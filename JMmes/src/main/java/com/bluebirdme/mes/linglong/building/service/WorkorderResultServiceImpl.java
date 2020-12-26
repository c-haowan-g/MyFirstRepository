/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

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

import client.LZMESFLUSHPRODUCT;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.entity.DoubleProduction;
import com.bluebirdme.mes.linglong.building.entity.UpdateWorkOrderResultReport;
import com.bluebirdme.mes.linglong.building.entity.WorkOrderResultReport;
import com.bluebirdme.mes.linglong.building.entity.WorkorderResult;
import com.bluebirdme.mes.linglong.building.entity.dto.UpdateWorkOrderResultReportDTO;
import com.bluebirdme.mes.linglong.building.entity.dto.WorkOrderResultReportDTO;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MesSapProduction;
import com.bluebirdme.mes.linglong.curing.service.MesSapProductionServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Part;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 成型生成实绩查询
 * 
 * @author 时永良
 * @Date 2019-01-16 08:11:24
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkorderResultServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	// 系统参数获取
	@Resource
	SerialServiceImpl serialSrv;

	@Resource
	LingLongDataSource llds;
	// ERP抛帐表
	@Resource
	MesSapProductionServiceImpl mesSapProductionServiceImpl;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return WorkorderResult.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	/**
	 * 查出胎胚质量状态显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchDescription() {
		SQLQuery query = createSQLQuery(getSQL("searchDescription"));
		System.out.println(getSQL("searchDescription").toString());
		return query.list();
	}
	/**
	 * 通过工艺配方查出胎胚重量公差参数
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getWeightData() {
		
		SQLQuery query = createSQLQuery(getSQL("getWeightData"));
		System.out.println(getSQL("getWeightData").toString());
		return query.list();
	}
	/**
	 * 通过工艺配方查出半钢胎胚重量公差参数
	 * @author dexiao_li
	 * @Date 2020-08-14 15:20:24
	 * @return
	 */
	public List<Map<String, Object>> getHalfWeightData() {
		SQLQuery query = createSQLQuery(getSQL("getHalfWeightData"));
		System.out.println(getSQL("getHalfWeightData").toString());
		return query.list();
	}
	
//全部查询
	public List<Map<String, Object>> search() {
		SQLQuery query = createSQLQuery(getSQL("search"));
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
	 * 查询成型报产信息数据
	 */

	public Map<String, Object> searchReportData(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA2(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA2(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA2(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows2的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows2", filter.getFilter());
		System.out.println(dataSql);

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

	public Long datagridTotalUDA2(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total2的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total2", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 报产固化操作
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param materialCodelist
	 *            要进行固化的物料编码数组
	 * @throws Exception
	 */
	@RockWellTransactional
	public void Solidification(WorkOrderResultReportDTO workOrderResultReportDTO) throws Exception {
		String beginTime = workOrderResultReportDTO.getBegintime();
		String endTime = workOrderResultReportDTO.getEndtime();
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String solidTime=sf.format(date);
		List<WorkOrderResultReport> selectRows = workOrderResultReportDTO.getSelectedrows();
		if (beginTime.isEmpty() || endTime.isEmpty() || selectRows.size() == 0) {
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}
		// 一个固化产生一个报产流水号
		String serialno = serialSrv.serial("BUILDINGNUM"); // serial():产生报产流水号方法
		for (WorkOrderResultReport item : selectRows) {
			if (item.getProduction_ver_s() == null) {
				throw new Exception("生产版本为空，不允许报产");
			}
			String updateWorkorderresultSql = String.format(
					  "update at_B_mm_workorderresult WT set WT.solid_yflag_s = '177001', WT.solid_time_t=to_date('%s','YYYY-mm-dd HH24:MI:SS'),WT.spare1_s = '%s'"
					   + " where WT.record_flag_s = '%s' " 
					   + " and WT.s_factory_s='%s' "
					   + " and WT.agenc_no_s='%s'  " 
					   + " and WT.material_code_s='%s' " 
					   + " and WT.building_shift_s='%s' "
					   + " and WT.production_ver_s='%s' " 
					   + " and nvl(WT.solid_yflag_s,177002)='177002' "
					   + " and WT.building_date_t between to_date('%s','YYYY-mm-dd HH24:MI:SS')  "
					   + " and to_date('%s','YYYY-mm-dd HH24:MI:SS') ", solidTime,serialno,
						LLConstant.Record_Flag.AVAILIABLE, LLWebUtils.factory(), LLConstant.JING_MEN_CODE,
						item.getMaterial_code_s(), item.getBuilding_shift_s(), item.getProduction_ver_s(), beginTime, endTime);
					System.out.println("----------------------"+updateWorkorderresultSql);
			        // 更新成型实绩表。更新：(1)固化标识为已固化;(2)固化流水号
					RockWellUtils.execSQL(updateWorkorderresultSql);

			String workorderno = serialSrv.serial("BUILDING"); // 一个规格产生一个报产工单号

			/*
			 * 向AT_INT_SAP_MESSAPPRODUCTION表写入数据
			 */
			MesSapProduction mesSapProduction = new MesSapProduction(); // 声明实体类
			mesSapProduction.setAgenc_no_s(LLConstant.JING_MEN_CODE);
			mesSapProduction.setS_factory_s(LLWebUtils.factory());
			mesSapProduction.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
			mesSapProduction.setSerid_s(serialno); // 需要更改！！！！！！！！！serid:LZMES+YYYYmmdd+类型（01/02）+4
													// 位流水号
			mesSapProduction.setSpare1_s(serialno);// Spare1_s:LZMES+YYYYmmdd+4
													// 位流水号
			mesSapProduction.setProduct_type_s("01");// 01:报产，02：冲产
			mesSapProduction.setPlant_s(LLConstant.JING_MEN_CODE);// 工厂号

			// SAP品号（18位的物料编码，生产实绩表里的物料编码不可以直接用，因sap报产的时候不会识别这个
			// 需要根据物料编码从sap物料信息表查对应的列MATERIALSHORT_S）
			mesSapProduction.setMaterial_code_s(getMaterialShort(item.getMaterial_code_s()));// 物料编码（18位）
			mesSapProduction.setMaterial_name_s(item.getMaterial_name_s());// 物料名称
			mesSapProduction.setPro_version_s(item.getProduction_ver_s());// 生产版本
			mesSapProduction.setQuantity_f(item.getTotal());// 实际数量
			mesSapProduction.setActual_quantity_f(item.getTotal());// 实际固化数量
			if (judgeDateIsLastMonth()) {
				mesSapProduction.setPost_date_s(getDateAddOne());// 过账日期
			} else {
				mesSapProduction.setPost_date_s(getDate());// 过账日期
			}
			mesSapProduction.setDoc_date_s(getDate());// 凭证日期（默认当前日期 YYYYmmdd）

			if (LLWebUtils.factory().equals("1")) {
				mesSapProduction.setStorage_loc_s("H250"); // 线边库-下线库位：全钢胎胚H250;
			} else if (LLWebUtils.factory().equals("2")) {
				mesSapProduction.setStorage_loc_s("H150"); // 线边库-下线库位：半钢胎胚H150
			}

			mesSapProduction.setBatch_s(getDateYear());// 产品下线批次（当前年份，过账日期前4位）
			mesSapProduction.setHeadtxt_s(item.getBuilding_shift_s() + getDateTime() + WebUtils.getUser().userCode);// 班次+时间+操作人（系统）
			mesSapProduction.setRecord_sap_flag_s("0");// 记录标示: 0-SAP未读取; 1-已读取;
														// 2-正常; 3-错误
			mesSapProduction.setOperate_userid_s(WebUtils.getUser().userCode); // 操作工编号
			mesSapProduction.setOperate_usernane_s(WebUtils.getUser().userName);// 操作工姓名
			mesSapProduction.setOperate_time_s(getDateTime());// 操作时间

			mesSapProduction.setBatch_id_s(workorderno); // 写入工单号
			mesSapProduction.setProcess_s("252005"); // 报工工序:252006硫化/成型252005
			mesSapProduction.setReverser_flag_s("0");// 冲销标识:默认 0 0否1是
			mesSapProduction.setSolid_flag_s("0"); // 固化标识（0 未固化 1已固化）
			mesSapProduction.setClass_id_s(item.getBuilding_shift_s());// 生产班次
			mesSapProduction.setRush_serid_s(item.getMaterial_code_s());// 物料编码
			mesSapProduction.setDummy1_s(beginTime);
			mesSapProduction.setDummy2_s(endTime);
			mesSapProductionServiceImpl.save(mesSapProduction); // 保存到ERP抛帐表
		}
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
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		String lastmonthday = format.format(calendar.getTime());

		DateFormat df = new SimpleDateFormat("yyyy-MM-DD 24hh");
		Date monthlasttimestart = df.parse(lastmonthday + " 16:00:00");
		Date monthlasttimeend = df.parse(lastmonthday + " 23:59:59");
		Date nowDate = df.parse(df.format(new Date()));

		if (nowDate.getTime() > monthlasttimestart.getTime() && nowDate.getTime() < monthlasttimeend.getTime()) {
			return true;
		}
		return false;
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
	 * 获取当前年月日
	 * 
	 * @return
	 */
	public String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
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
	 * 获取当前时间
	 * 
	 * @return
	 */
	public String getDateTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(new Date());
	}

	/**
	 * 根据条件查询ID，用于修改成型产出实绩 固化 标记状态 at_B_mm_workorderresult表
	 * 
	 * @Title: serchId
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	public String serchId(WorkOrderResultReport item, String beginTime, String endTime) {
		SQLQuery query = createSQLQuery(getSQL("searchID"));
		query.setParameter("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("agenc_no_s", LLConstant.JING_MEN_CODE);
		query.setParameter("material_code_s", item.getMaterial_code_s());
		query.setParameter("building_shift_s", item.getBuilding_shift_s());
		query.setParameter("production_ver_s", item.getProduction_ver_s());
		query.setParameter("beginTime", beginTime);
		query.setParameter("endTime", endTime);
		List<Map<String, Object>> list = query.list();
		return list.get(0).get("ATR_KEY").toString();

	}

	/**
	 * 根据条件查询ID，用于修改成型产出实绩 冲产 标记状态 AT_B_INT_DOUBLEPRODUCTION表
	 * 
	 * @Title: serchId
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	public String serchId2(UpdateWorkOrderResultReport item, String beginTime, String endTime) {
		SQLQuery query = createSQLQuery(getSQL("searchID2"));
		query.setParameter("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("agenc_no_s", LLConstant.JING_MEN_CODE);
		query.setParameter("material_code_s", item.getMaterial_code_s());
		query.setParameter("buildingshift_s", item.getBuildingshift_s());
		query.setParameter("productionver_s", item.getProductionver_s());
		query.setParameter("beginTime", beginTime);
		query.setParameter("endTime", endTime);
		List<Map<String, Object>> list = query.list();
		return list.get(0).get("ATR_KEY").toString();

	}

	/**
	 * 查询冲产信息数据
	 */
	public Map<String, Object> RushProduct(Filter filter, Page page) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA3(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA3(filter, page));

		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA3(Filter filter, Page page) throws Exception {

		if (getSQL("datagridRowsUDA3") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridRowsUDA3的SQL语句定义");
		String dataSql = getSQL("datagridRowsUDA3", filter.getFilter());
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

	public Long datagridTotalUDA3(Filter filter, Page page) throws Exception {
		if (getSQL("datagridTotalUDA3") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridTotalUDA3的SQL语句定义");
		String totalSql = getSQL("datagridTotalUDA3", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	/**
	 * 冲产固化操作
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param materialCodelist
	 *            要进行固化的物料编码数组
	 * @throws Exception
	 */
	@RockWellTransactional
	public void updatesolid(UpdateWorkOrderResultReportDTO workOrderResultReportDTO) throws Exception {
		String beginTime = workOrderResultReportDTO.getBegintime();
		String endTime = workOrderResultReportDTO.getEndtime();
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String solidTime=sf.format(date);
		List<UpdateWorkOrderResultReport> selectRows = workOrderResultReportDTO.getSelectedrows();
		if (beginTime.isEmpty() || endTime.isEmpty() || selectRows.size() == 0) {
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}
		// 一个冲产产生一个报产流水号
		String serialno = serialSrv.serial("BUILDINGNUM"); // serial():产生报产流水号函数
		for (UpdateWorkOrderResultReport item : selectRows) {
			if (item.getProductionver_s() == null) {
				throw new Exception("生产版本为空，不允许报产");
			}
			String updateDoubleProductionSql = String.format(
					  "update AT_B_INT_DOUBLEPRODUCTION WT set WT.Solid_Yflag_s = '177001', WT.solid_time_t=to_date('%s','YYYY-mm-dd HH24:MI:SS'), WT.Spare1_s = '%s'"
					   + " where WT.Record_Flag_s = '%s' " 
					   + " and WT.s_Factory_s='%s' "
					   + " and WT.Agenc_No_s='%s'  " 
					   + " and WT.Material_Code_s='%s' " 
					   + " and WT.Buildingshift_s='%s' "
					   + " and WT.Productionver_s='%s' " 
					   + " and nvl(WT.Solid_Yflag_s,177002)='177002' "
					   + " and WT.Buildingdate_t between to_date('%s','YYYY-mm-dd HH24:MI:SS')  "
					   + " and to_date('%s','YYYY-mm-dd HH24:MI:SS') ",solidTime,serialno,
						LLConstant.Record_Flag.AVAILIABLE, LLWebUtils.factory(), LLConstant.JING_MEN_CODE,
						item.getMaterial_code_s(), item.getBuildingshift_s(), item.getProductionver_s(), beginTime, endTime);
			// 更新成型冲产表。更新：(1)固化标识为已固化;(2)固化流水号
			RockWellUtils.execSQL(updateDoubleProductionSql);
			
			/*Long id = Long.parseLong(serchId2(item, beginTime, endTime));
			DoubleProduction doubleproduction = new DoubleProduction();
			doubleproduction.setAtr_key(id);
			doubleproduction.setSolid_yflag_s("177001");
			doubleproduction.setSpare1_s(serialno);
			update(doubleproduction);*/
			String workorderno = serialSrv.serial("BUILDING"); // 一个规格产生一个报产工单号
			/*
			 * 向AT_INT_SAP_MESSAPPRODUCTION表写入数据
			 */
			MesSapProduction mesSapProduction = new MesSapProduction(); // 声明实体类
			mesSapProduction.setAgenc_no_s(LLConstant.JING_MEN_CODE);
			mesSapProduction.setS_factory_s(LLWebUtils.factory());
			mesSapProduction.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
			mesSapProduction.setSerid_s(serialno);// serid:LZMES+YYYYmmdd+类型（01/02）+4
													// 位流水号
			mesSapProduction.setSpare1_s(serialno);// 流水号
			mesSapProduction.setProduct_type_s("02");// 01:报产，02：冲产
			mesSapProduction.setPlant_s(LLConstant.JING_MEN_CODE);// 工厂号

			// SAP品号（18位的物料编码，生产实绩表里的物料编码不可以直接用，因sap报产的时候不会识别这个
			// 需要根据物料编码从sap物料信息表查对应的列MATERIALSHORT_S）
			mesSapProduction.setMaterial_code_s(getMaterialShort(item.getMaterial_code_s()));// 物料编码（18位）
			mesSapProduction.setMaterial_name_s(item.getMaterial_name_s());// 物料名称
			mesSapProduction.setPro_version_s(item.getProductionver_s());// 生产版本
			mesSapProduction.setQuantity_f(item.getTotal());// 实际数量
			mesSapProduction.setActual_quantity_f(item.getTotal());// 实际固化数量
			if (judgeDateIsLastMonth()) {
				mesSapProduction.setPost_date_s(getDateAddOne());// 过账日期
			} else {
				mesSapProduction.setPost_date_s(getDate());// 过账日期
			}
			mesSapProduction.setDoc_date_s(getDate());// 凭证日期（默认当前日期 YYYYmmdd）

			if (LLWebUtils.factory().equals("1")) {
				mesSapProduction.setStorage_loc_s("H250"); // 线边库-下线库位：全钢胎胚H250;
			} else if (LLWebUtils.factory().equals("2")) {
				mesSapProduction.setStorage_loc_s("H150"); // 线边库-下线库位：半钢胎胚H150
			}

			mesSapProduction.setBatch_s(getDateYear());// 产品下线批次（当前年份，过账日期前4位）
			mesSapProduction.setHeadtxt_s(item.getBuildingshift_s() + getDateTime() + WebUtils.getUser().userCode);// 班次+时间+操作人（系统）
			mesSapProduction.setRecord_sap_flag_s("0");// 记录标示: 0-SAP未读取; 1-已读取;
														// 2-正常; 3-错误
			mesSapProduction.setOperate_userid_s(WebUtils.getUser().userCode); // 操作工编号
			mesSapProduction.setOperate_usernane_s(WebUtils.getUser().userName);// 操作工姓名
			mesSapProduction.setOperate_time_s(getDateTime());// 操作时间
			mesSapProduction.setBatch_id_s(workorderno);// 设置流水号

			mesSapProduction.setProcess_s("252005"); // 报工工序:252006硫化/成型252005
			mesSapProduction.setReverser_flag_s("0");// 冲销标识:默认 0 0否1是
			mesSapProduction.setSolid_flag_s("0"); // 固化标识（0 未固化 1已固化）
			mesSapProduction.setClass_id_s(item.getBuildingshift_s());// 生产班次
			mesSapProduction.setRush_serid_s(item.getMaterial_code_s());// 物料编码

			mesSapProductionServiceImpl.save(mesSapProduction); // 保存到ERP抛帐表
		}
	}

	/**
	 * 成型产量报产,根据选中行更新,调用报产jar包
	 * 
	 * @throws Exception
	 */
	public void reporttosapBySelectRow(String[] batchidlist) throws Exception {
		StringBuffer sbBuffer = new StringBuffer();
		sbBuffer.append("(");
		for (String item : batchidlist) {
			sbBuffer.append("'" + item + "',");
		}
		String insql = sbBuffer.toString().substring(0, sbBuffer.toString().length() - 1);
		insql = insql + ")";
		String sql = "update AT_INT_SAP_MESSAPPRODUCTION t set t.solid_flag_s='1' where t.BATCH_ID_S in" + insql
				+ " and t.record_flag_s='A'";
		System.out.println(sql);
		RockWellUtils.execSQL(sql);
		// TODO需要更改报产接口
		// LZMESPRODUCT curing = new LZMESPRODUCT();
		// curing.executeRequest();
	}
	
	
	/**
	 * 成型产量冲产,根据选中行更新,调用冲产jar包
	 * 
	 * @throws Exception
	 */
	public void reflushtosapBySelectRow(String[] batchidlist) throws Exception {
		StringBuffer sbBuffer=new StringBuffer();
		sbBuffer.append("(");
		for(String item:batchidlist){
			sbBuffer.append("'"+item+"',");
		}
		String insql=sbBuffer.toString().substring(0, sbBuffer.toString().length()-1);
		insql=insql+")";
		/*String sql="update AT_INT_SAP_MESSAPPRODUCTION t set t.solid_flag_s='1' where t.batch_id_s in"+insql
				+" and t.record_flag_s='A'";*/
		String sql="update AT_INT_SAP_MESSAPPRODUCTION t set t.solid_flag_s='1' where t.atr_key in"+insql
				+" and t.record_flag_s='A'";
		System.out.println(sql);
		RockWellUtils.execSQL(sql);
		//LZMESFLUSHPRODUCT curing = new LZMESFLUSHPRODUCT();
		//curing.executeRequest();
	}
	
	/**
	 * 明细窗口（主页面第五个按钮）
	 * 
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @throws Exception
	 */
	@RockWellTransactional
	public List<Map<String,Object>> productionDetail2(Map<String,Object> workOrderResultReportDTO) throws Exception {
		List<Map<String, Object>> selectRows = (List<Map<String, Object>>) workOrderResultReportDTO.get("selectedrows");
		if(selectRows.get(0).get("dummy1_s")==null||selectRows.get(0).get("dummy2_s")==null){
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}
		String beginTime =selectRows.get(0).get("dummy1_s").toString();
		String endTime = selectRows.get(0).get("dummy2_s").toString();
		if (beginTime.isEmpty() || endTime.isEmpty() || selectRows.size() == 0) {
			throw new Exception("未选择行数据或起始时间获取失败，请重试");
		}
		String classId=selectRows.get(0).get("class_id_s").toString();
		String productionver=selectRows.get(0).get("pro_version_s").toString();
		String materialCode=selectRows.get(0).get("rush_serid_s").toString();
		
		SQLQuery query = createSQLQuery(getSQL("searchProductionDetai"));
		query.setParameter("beginTime",beginTime);
		query.setParameter("endTime",endTime);
		query.setParameter("classId",classId);
		query.setParameter("productionver",productionver);
		query.setParameter("materialCode",materialCode);
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
	
	//------------------------------------------以下方法用于成型未硫化报表------------------------------------------------//
	
	/**
	 * 查询成型产出但未硫化的成型生产实绩
	 */

	public Map<String, Object> datagridUDA4(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA4(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA4(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA4(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows4") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows4的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows4", filter.getFilter());
		System.out.println(dataSql);

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

	public Long datagridTotalUDA4(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total4") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total4的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total4", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
}
