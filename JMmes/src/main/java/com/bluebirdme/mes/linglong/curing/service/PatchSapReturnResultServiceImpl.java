/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MesSapProduction;
import com.bluebirdme.mes.linglong.curing.entity.ProductionDdetail;
import com.bluebirdme.mes.linglong.curing.entity.SapReturnResult;
import com.bluebirdme.mes.linglong.curing.entity.SapReturnResultSimple;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Part;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 硫化冲产表
 * 
 * @author 时永良
 * @Date 2019-03-26 13:31:11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PatchSapReturnResultServiceImpl extends
		RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Resource
	SerialServiceImpl serialSrv;

	@Resource
	MesSapProductionServiceImpl mspSrv;

	// 硫化报产冲产明细表
	@Resource
	ProductionDdetailServiceImpl productionDdetailServiceImpl;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return SapReturnResult.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	/**
	 * 查询冲产信息数据
	 */
	public Map<String, Object> searchReplenishData(Filter filter, Page page)
			throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception(
						"当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridUDARowsThree(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridUDATotalThree(filter, page));

		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridUDARowsThree(Filter filter,
			Page page) throws Exception {

		if (getSQL("datagridUDARowsThree") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDARowsThree的SQL语句定义");

		String dataSql = getSQL("datagridUDARowsThree", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

	public Long datagridUDATotalThree(Filter filter, Page page)
			throws Exception {

		if (getSQL("datagridUDATotalThree") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDATotalThree的SQL语句定义");

		String totalSql = getSQL("datagridUDATotalThree", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 冲产固化
	 * 
	 * @param rockWellEntityDTO
	 * @throws Exception
	 */
	public String guhua(Map<String, Object> rockWellEntityDTO) throws Exception {
		List<Map<String, Object>> insertedList = (List<Map<String, Object>>) rockWellEntityDTO
				.get("selectedrows");
		boolean flag = false;
		if (!ListUtils.isEmpty(insertedList)) {
			// 获取固化的数据

			String beginTime = rockWellEntityDTO.get("begintime").toString();
			String endTime = rockWellEntityDTO.get("endtime").toString();
			String materialCode = null;
			String classId = null;
			String productionver = null;
			String materialName = null;
			String spare6_s = null;
			String total = null;
			String serialno = null;
			String workorderno = null;
			for (Map<String, Object> r : insertedList) {
				// 一个固化产生一个报产流水号
				if (LLWebUtils.factory().equals("1")) {// 全钢
					serialno = getBatch_id();
				}
				if (LLWebUtils.factory().equals("2")) {// 半钢
					serialno = getBGBatch_id();
				}
				if (r.get("productionver_s") == null) {
					throw new Exception("生产版本为空，不允许报产");
				}
				if (r.get("material_code_s") != null
						&& r.get("material_code_s") != "") {
					materialCode = r.get("material_code_s").toString();
				}
				if (r.get("class_id_s") != null && r.get("class_id_s") != "") {
					classId = r.get("class_id_s").toString();
				}
				if (r.get("productionver_s") != null
						&& r.get("productionver_s") != "") {
					productionver = r.get("productionver_s").toString();
				}
				if (r.get("material_name_s") != null
						&& r.get("material_name_s") != "") {
					materialName = r.get("material_name_s").toString();
				}
				if (r.get("spare6_s") != null && r.get("spare6_s") != "") {
					spare6_s = r.get("spare6_s").toString();// 用于区分外胎是否为试验胎，0不是，1是
				} else {
					spare6_s = "0";
				}
				if (r.get("total") != null && r.get("total") != "") {
					total = r.get("total").toString();
				}
				List<Map<String, Object>> list = productionDetailByCuring(r,
						beginTime, endTime);
				for (int i = 0; i < list.size(); i++) {
					ProductionDdetail productionDdetail = new ProductionDdetail();
					productionDdetail.setAgenc_no_s(LLConstant.JING_MEN_CODE);
					productionDdetail.setS_factory_s(LLWebUtils.factory());
					productionDdetail
							.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
					productionDdetail.setTyre_barcode_s(list.get(i)
							.get("tyre_barcode_s").toString());
					productionDdetail.setEquip_code_s(list.get(i)
							.get("equip_code_s").toString());
					productionDdetail.setCuring_grade_s(list.get(i)
							.get("spare5_s").toString());
					productionDdetail.setMaterial_code_s(list.get(i)
							.get("material_code_s").toString());
					productionDdetail.setMaterial_name_s(list.get(i)
							.get("material_name_s").toString());
					productionDdetail.setProduct_date_s(list.get(i)
							.get("product_date_s").toString());
					productionDdetail.setSerial_number_s(serialno);
					productionDdetail.setSpare1_s("252006");// 备用字段1
															// 被用于存放工序数据：252006硫化/成型252005
					productionDdetail.setSpare2_s("02");// 备用字段2
														// 被用于存放区分报产，冲产数据:01:报产，02：冲产
					productionDdetailServiceImpl.save(productionDdetail);
				}
				String updatesapreturnresultSql = String
						.format("update AT_C_MM_SAPRETURNRESULT t set t.solidif_yflag_s = '1', t.spare1_s = '%s'"
								+ " where t.record_flag_s = '%s' "
								+ " and t.s_factory_s='%s' "
								+ " and t.agenc_no_s='%s'  "
								+ " and t.material_code_s='%s' "
								+ " and t.CLASS_ID_S='%s' "
								+ " and t.productionver_s='%s' "
								+ " and nvl(t.solidif_yflag_s,0)='0' "
								+ " and t.curing_openmoulddate_t between to_date('%s','YYYY-mm-dd HH24:MI:SS')  "
								+ " and to_date('%s','YYYY-mm-dd HH24:MI:SS') "
								+ " and t.patch_curingflag_s='1' "
								+ " and t.material_name_s='%s' ", serialno,
								LLConstant.Record_Flag.AVAILIABLE,
								LLWebUtils.factory(), LLConstant.JING_MEN_CODE,
								materialCode, classId, productionver,
								beginTime, endTime, materialName);
				System.out.println(updatesapreturnresultSql);
				// 更新硫化产出表。更新（1）固化标识为已固化（2）固化流水号
				RockWellUtils.execSQL(updatesapreturnresultSql);

				// 一个规格产生一个报产工单号
				if (LLWebUtils.factory().equals("1")) {// 全钢
					workorderno = getSerid();
				}
				if (LLWebUtils.factory().equals("2")) {// 半钢
					workorderno = getBGSerid();
				}
				// 向AT_INT_SAP_MESSAPPRODUCTION表写入数据
				MesSapProduction mesSapProduction = new MesSapProduction();
				mesSapProduction.setAgenc_no_s(LLConstant.JING_MEN_CODE);
				mesSapProduction.setS_factory_s(LLWebUtils.factory());
				mesSapProduction
						.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
				mesSapProduction.setSerid_s(workorderno);// 每一种规格带一个工单号
				mesSapProduction.setProduct_type_s("02");// 01:报产，02：冲产
				mesSapProduction.setPlant_s(LLConstant.JING_MEN_CODE);// 工厂号
				// SAP品号（18位的物料编码，生产实绩表里的物料编码不可以直接用，因sap报产的时候不会识别这个，需要根据物料编码从sap物料信息表查对应的列MATERIALSHORT_S）
				mesSapProduction
						.setMaterial_code_s(getMaterialShort(materialCode));// 物料编码（18位）
				mesSapProduction.setMaterial_name_s(materialName);// 物料名称
				mesSapProduction.setPro_version_s(productionver);// 生产版本
				mesSapProduction.setQuantity_f(total);// 实际数量
				mesSapProduction.setActual_quantity_f(total);// 实际固化数量
				if (judgeDateIsLastMonth()) {
					mesSapProduction.setPost_date_s(getDateAddOne());// 过账日期
				} else {
					mesSapProduction.setPost_date_s(getDate());// 过账日期
				}
				mesSapProduction.setDoc_date_s(getDate());// 凭证日期（默认当前日期
				// YYYYmmdd）
				if (LLWebUtils.factory().equals("1")) {
					if (spare6_s.equals("0")) {
						mesSapProduction.setStorage_loc_s("H290");// 线边库-下线库位：全钢外胎H290;
					} else {
						mesSapProduction.setStorage_loc_s("H291");// 线边库-下线库位：全钢外胎,并且是试验胎H291;
					}
				} else if (LLWebUtils.factory().equals("2")) {
					if (spare6_s.equals("0")) {
						mesSapProduction.setStorage_loc_s("H190");// 线边库-下线库位：半钢外胎H190;
					} else {
						mesSapProduction.setStorage_loc_s("H191");// 线边库-下线库位：半钢外胎,并且是试验胎H191;
					}
				}
				mesSapProduction.setBatch_s("1111");// 产品下线批次,湖北为1111
				mesSapProduction.setHeadtxt_s(classId + getDateTime()
						+ WebUtils.getUser().userCode);// 班次+时间+操作人（系统）
				mesSapProduction.setRecord_sap_flag_s("0");// 记录标示（0:SAP未读取;1:：已读取；2：正常；3:错误)
				/*
				 * mesSapProduction.setOperate_userid_s(WebUtils.getUser().userCode
				 * );// 操作工编号
				 * mesSapProduction.setOperate_usernane_s(WebUtils.getUser
				 * ().userName);// 操作工姓名
				 * mesSapProduction.setOperate_time_s(getDateTime());// 操作时间
				 */mesSapProduction.setBatch_id_s(serialno);// 设置流水号
				mesSapProduction.setProcess_s("252006");// 报工工序:252006硫化/成型252005
				mesSapProduction.setReverser_flag_s("0");// 冲销标识:默认 0 0否1是
				mesSapProduction.setSolid_flag_s("0");// 固化标识（0 未固化 1已固化）
				mesSapProduction.setClass_id_s(classId);// 生产班次
				mesSapProduction.setRush_serid_s(materialCode);// 物料编码
				mesSapProduction.setDummy1_s(beginTime);
				mesSapProduction.setDummy2_s(endTime);
				mesSapProduction.setSpare4_s("1");// 区分是否补硫化1：是0：否
				// 保存到ERP抛帐表
				mspSrv.save(mesSapProduction);
				flag = true;
			}
		}
		if (flag = false) {
			return "操作失败，可能原因：硫化班次为空！";
		} else {
			return "操作成功";
		}
	}

	/**
	 * 明细窗口
	 * 
	 * @param workOrderResultReportDTO
	 *            要进行固化的物料编码数组
	 * @throws Exception
	 */
	@RockWellTransactional
	public List<Map<String, Object>> productionDetail(
			Map<String, Object> workOrderResultReportDTO) throws Exception {
		String beginTime = workOrderResultReportDTO.get("begintime").toString();
		String endTime = workOrderResultReportDTO.get("endtime").toString();
		List<Map<String, Object>> selectRows = (List<Map<String, Object>>) workOrderResultReportDTO
				.get("selectedrows");
		if (beginTime.isEmpty() || endTime.isEmpty() || selectRows.size() == 0) {
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}
		String classId = selectRows.get(0).get("class_id_s").toString();
		String productionver = selectRows.get(0).get("productionver_s")
				.toString();
		String materialCode = selectRows.get(0).get("material_code_s")
				.toString();
		String materialName = selectRows.get(0).get("material_name_s")
				.toString();

		SQLQuery query = createSQLQuery(getSQL("searchProductionDetai"));
		query.setParameter("beginTime", beginTime);
		query.setParameter("endTime", endTime);
		query.setParameter("classId", classId);
		query.setParameter("productionver", productionver);
		query.setParameter("materialCode", materialCode);
		query.setParameter("materialName", materialName);
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

	/**
	 * 冲产固化时查询明细
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param workOrderResultReportDTO
	 *            要进行固化的物料编码数组
	 * @throws Exception
	 */
	@RockWellTransactional
	public List<Map<String, Object>> productionDetailByCuring(
			Map<String, Object> workOrderResultReportDTO, String beginTime,
			String endTime) throws Exception {
		List<Map<String, Object>> selectRows = (List<Map<String, Object>>) workOrderResultReportDTO
				.get("selectedrows");
		if (beginTime.isEmpty() || endTime.isEmpty()) {
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}
		String materialCode = workOrderResultReportDTO.get("material_code_s")
				.toString();
		String classId = workOrderResultReportDTO.get("class_id_s").toString();
		String productionver = workOrderResultReportDTO.get("productionver_s")
				.toString();
		String materialName = workOrderResultReportDTO.get("material_name_s")
				.toString();
		SQLQuery query = createSQLQuery(getSQL("searchProductionDetai"));
		query.setParameter("beginTime", beginTime);
		query.setParameter("endTime", endTime);
		query.setParameter("classId", classId);
		query.setParameter("productionver", productionver);
		query.setParameter("materialCode", materialCode);
		query.setParameter("materialName", materialName);
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

	public List<Object> getWorkOrderCode(String code, String type) {
		String sql;
		// String
		// sql="select SERID_S from AT_INT_SAP_MesSapProduction where 1=1 ";
		/*
		 * if(!StringUtils.isBlank(type)){ sql
		 * +=" and PRODUCT_TYPE_S like '%"+type+"'"; }
		 * if(!StringUtils.isBlank(code)){ sql
		 * +=" and SERID_S like '%"+type+"%'"; }
		 */
		code = new SimpleDateFormat("YYYYMMdd").format(new Date());
		if (StringUtils.isBlank(type)) {
			sql = "select SERID_S from AT_INT_SAP_MesSapProduction where SERID_S like '%"
					+ code + "%'";
		} else {
			sql = "select SERID_S from AT_INT_SAP_MesSapProduction where PRODUCT_TYPE_S='"
					+ type + "' and SERID_S like '%" + code + "%'";
		}
		System.out.println(sql);
		return getSession().createSQLQuery(sql).list();

	}

	/**
	 * 时间转换成java.sql.Date
	 * 
	 * @param strDate
	 *            时间字符
	 * @return
	 * @throws ParseException
	 */
	public java.util.Date strToDate(String strDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = sdf.parse(strDate);
		return date;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	/**
	 * 获取当前年
	 * 
	 * @return
	 */
	public String getDateYear() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		return format.format(new Date());
	}

	/**
	 * 获取当前年月日
	 * 
	 * @return
	 */
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(new Date());
	}

	/**
	 * 获取当前年月日加一天
	 * 
	 * @return
	 */
	public String getDateAddOne() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, 1);
		return format.format(c.getTime());
	}

	/**
	 * 根据物料编码返回18位物料编码
	 * 
	 * @param materialcode
	 * @return
	 * @throws Exception
	 */
	public String getMaterialShort(String materialcode) throws Exception {
		Part part = getFunction().getPart(materialcode);
		if (part == null) {
			throw new Exception(materialcode + "的物料编码不存在");
		}
		return (String) part.getUDA("MaterialShort");
	}

	/**
	 * 判断今天是否是每月最后一天的下午4点后、24点前
	 * 
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	public Boolean judgeDateIsLastMonth() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 24hh");
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		String lastmonthday = format.format(calendar.getTime());

		DateFormat df = new SimpleDateFormat("yyyy-MM-DD 24hh");
		Date monthlasttimestart = df.parse(lastmonthday + " 16:00:00");
		Date monthlasttimeend = df.parse(lastmonthday + " 23:59:59");

		Date nowDate = df.parse(df.format(new Date()));
		if (nowDate.getTime() > monthlasttimestart.getTime()
				&& nowDate.getTime() < monthlasttimeend.getTime()) {
			return true;
		}

		return false;
	}

	/**
	 * 查询固化数据
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	public List<SapReturnResultSimple> guhuaData(String beginTime,
			String endTime, String material_code_s) throws Exception {

		String sql = "SELECT " + "0 atr_key,'' serid_s,MATERIAL_CODE_S, "
				+ "	PRODUCTIONVER_S, " + "	MATERIAL_NAME_S, "
				+ "	CLASS_ID_S CLASS_ID_S, " + "	COUNT (1) TOTAL " + "FROM "
				+ "	AT_C_MM_SAPRETURNRESULT " + "WHERE "
				+ "	CURING_CLOSEMOULDDATE_T BETWEEN to_date('" + beginTime
				+ "','yyyy-MM-dd HH24:mi:ss') " + "AND to_date('" + endTime
				+ "','yyyy-MM-dd HH24:mi:ss') " + "AND ( "
				+ "	SOLIDIF_YFLAG_S = '0'  ) "
				+ " AND (SPARE6_S = '1' OR SPARE3_S='1') and S_FACTORY_S='"
				+ LLWebUtils.factory() + "' and MATERIAL_CODE_S like '%"
				+ material_code_s + "%'" + "GROUP BY " + "	MATERIAL_CODE_S, "
				+ "	MATERIAL_NAME_S, " + "	PRODUCTIONVER_S, " + "	CLASS_ID_S"
				+ " order by CLASS_ID_S,MATERIAL_CODE_S,PRODUCTIONVER_S";

		System.out.println(sql);
		return createSQLQuery(sql, SapReturnResultSimple.class).list();
	}

	public String subStr(String str, int start) {
		if (str == null || str.equals("") || str.length() == 0) {
			return "";
		}
		if (start < str.length()) {
			return str.substring(start);
		} else {
			return "";
		}
	}

	/**
	 * 自动生成全钢报产流水号
	 * 
	 * @return
	 */
	public String getSerid() throws Exception {
		String max_code = "";
		String comment_code = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 组合流水号前一部分，时间字符串，如：20190219
			String uid_pfix = format.format(new Date());
			SQLQuery query = createSQLQuery(getSQL("getSerid"));
			List<Map<String, Object>> listMap = query.list();
			if (listMap.get(0).get("SERID") != null) {
				max_code = listMap.get(0).get("SERID").toString();
				if (max_code != null && max_code.contains(uid_pfix)) {
					String uid_end = max_code.substring(8, 12);
					int endNum = Integer.parseInt(uid_end);
					int tmpNum = 10000 + endNum + 1;
					comment_code = "JMMES" + uid_pfix + subStr("" + tmpNum, 1);
				} else {
					comment_code = "JMMES" + uid_pfix + "0001";
				}
			} else {
				comment_code = "JMMES" + uid_pfix + "0001";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment_code;
	}

	/**
	 * 自动生成全钢上传批次号
	 * 
	 * @return
	 */
	public String getBatch_id() throws Exception {
		String max_code = "";
		String comment_code = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 组合流水号前一部分，时间字符串，如：20190219
			String uid_pfix = format.format(new Date());
			SQLQuery query = createSQLQuery(getSQL("getBatch_id"));
			List<Map<String, Object>> listMap = query.list();
			if (listMap.get(0).get("BATCHID") != null) {
				max_code = listMap.get(0).get("BATCHID").toString();
				if (max_code != null && max_code.contains(uid_pfix)) {
					String uid_end = max_code.substring(8, 13);
					int endNum = Integer.parseInt(uid_end);
					int tmpNum = 100000 + endNum + 1;
					comment_code = uid_pfix + subStr("" + tmpNum, 1);
				} else {
					comment_code = uid_pfix + "00001";
				}
			} else {
				comment_code = uid_pfix + "00001";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment_code;
	}

	/**
	 * 自动生成半钢报产流水号
	 * 
	 * @return
	 */
	public String getBGSerid() throws Exception {
		String max_code = "";
		String comment_code = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 组合流水号前一部分，时间字符串，如：20190219
			String uid_pfix = format.format(new Date());
			SQLQuery query = createSQLQuery(getSQL("getBGSerid"));
			List<Map<String, Object>> listMap = query.list();
			if (listMap.get(0).get("SERID") != null) {
				max_code = listMap.get(0).get("SERID").toString();
				if (max_code != null && max_code.contains(uid_pfix)) {
					String uid_end = max_code.substring(8, 12);
					int endNum = Integer.parseInt(uid_end);
					int tmpNum = 10000 + endNum + 1;
					comment_code = "JMBGM" + uid_pfix + subStr("" + tmpNum, 1);
				} else {
					comment_code = "JMBGM" + uid_pfix + "0001";
				}
			} else {
				comment_code = "JMBGM" + uid_pfix + "0001";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment_code;
	}

	/**
	 * 自动生成半钢上传批次号
	 * 
	 * @return
	 */
	public String getBGBatch_id() throws Exception {
		String max_code = "";
		String comment_code = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			// 组合流水号前一部分，时间字符串，如：20190219
			String uid_pfix = format.format(new Date());
			SQLQuery query = createSQLQuery(getSQL("getBGBatch_id"));
			List<Map<String, Object>> listMap = query.list();
			if (listMap.get(0).get("BATCHID") != null) {
				max_code = listMap.get(0).get("BATCHID").toString();
				if (max_code != null && max_code.contains(uid_pfix)) {
					String uid_end = max_code.substring(8, 13);
					int endNum = Integer.parseInt(uid_end);
					int tmpNum = 100000 + endNum + 1;
					comment_code = "BG" + uid_pfix + subStr("" + tmpNum, 1);
				} else {
					comment_code = "BG" + uid_pfix + "00001";
				}
			} else {
				comment_code = "BG" + uid_pfix + "00001";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment_code;
	}
}
