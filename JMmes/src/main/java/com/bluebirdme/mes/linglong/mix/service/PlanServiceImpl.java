/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.Plan;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSImplementService;
import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSInterface;

/**
 * 密炼日计划表
 * 
 * @author 王超
 * @Date 2020-08-04 16:31:44
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PlanServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	/**
	 * ServiceImpl可以继承RockWellBaseServiceImpl,
	 * RockWellUDABaseServiceImpl两个类的区别区分在一下几点上需要注意
	 * 1.RockWellUDABaseServiceImpl类继承了RockWellBaseServiceImpl
	 * 2.RockWellUDABaseServiceImpl使用datagridUDA查询全部的时候
	 * ，返回值为List<Map<String,Object>>类型。
	 * RockWellBaseServiceImpl使用datagrid查询返回的是List
	 * <T>类型，这个类型是根据Controller里面，调用datagrid
	 * 方法时传参的类型而决定，在sql中必须要写*查询全部，查询的全部要与实体类所对应。
	 * 3.本框架在使用增删改时，是操作实体类进行增删改的（这里说的是AT表的情况），因此使用RockWellEntityDTO接收参数之后需要将
	 * List<Map<String,Object>>中的Map通过 MapTrunPojo.mapToEntity方法转换为实体类再进行操作。
	 * 4.如果是使用工厂模型的情况，那么我们的操作方式是直接操作RockWell中api里面的对象
	 * 5.在操作工厂模型UDA表时，setUDA这个方法的参数为setUDA(value,key)，key值为UDA的字段名称，
	 * 在代码生成的时候有一个实体类的UDA类，在这个实体类中存放了这个工厂模型对象所有的UDA属性，上面的key值可以直接引用。
	 * 
	 */
	@Resource
	LingLongDataSource llds;
	// @Resource SerialServiceImpl serialSrv;
	@Resource
	WorkOrderEditServiceImpl mixWorkOrderEditImpl;
	@Resource
	WorkOrderExecServiceImpl mixWorkOrderExecServiceImpl;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Plan.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public Map<String, Object> datagridUDAjl(Filter filter, Page page)
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
		ret.put("rows", datagridRowsUDAjl(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDAjl(filter, page));
		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDAjl(Filter filter, Page page)
			throws Exception {
		if (getSQL("datagridUDA_rowsjl") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDA_rowsjl的SQL语句定义");
		String dataSql = getSQL("datagridUDA_rowsjl", filter.getFilter());
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

	public Long datagridTotalUDAjl(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_totaljl") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDA_totaljl的SQL语句定义");
		String totalSql = getSQL("datagridUDA_totaljl", filter.getFilter());
		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	public Map<String, Object> datagridUDAxl(Filter filter, Page page)
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
		ret.put("rows", datagridRowsUDAxl(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDAxl(filter, page));
		return ret;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDAxl(Filter filter, Page page)
			throws Exception {
		if (getSQL("datagridUDA_rowsxl") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDA_rowsxl的SQL语句定义");
		String dataSql = getSQL("datagridUDA_rowsxl", filter.getFilter());
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

	public Long datagridTotalUDAxl(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_totalxl") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDA_totalxl的SQL语句定义");
		String totalSql = getSQL("datagridUDA_totalxl", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	public String downwardbysos(String[] ids) throws Exception {
		try {
			StringBuffer sb = new StringBuffer();
			String recipecode = "";
			int sucCount = 0;
			StringBuffer falseinfo = new StringBuffer();
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			String result = "False";
			for (int i = 0; i < ids.length; i++) {
				recipecode = ids[i];
				result = portType.reciveWoCreateByMES((String) null,
						(String) null, recipecode,
						(LLWebUtils.getUser()).userCode,
						(LLWebUtils.getUser()).userName);
				if (result.equals("OK")) {
					sucCount++;
				} else {
					falseinfo.append(recipecode + "操作失败，返回结果：" + result
							+ "<br>");
				}
			}
			sb.append("合计：" + ids.length + "条，" + "成功：" + sucCount + "条；"
					+ "失败：" + (ids.length - sucCount) + "条");
			sb.append("<br>");
			sb.append(falseinfo.toString());
			return sb.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	@RockWellTransactional
	public int saveChanges(RockWellEntityDTO rockWellEntityDTO)
			throws Exception {
		int mun = 0;
		boolean ist = false;
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO
					.getDeleted();
			for (Map<String, Object> newitem : equipmentmateriallist) {
				Plan item = (Plan) MapTrunPojo
						.mapToEntity(newitem, getEntity());
				// 修改存在状态
				item.setRecord_flag_s("D");
				item.setChanged_by_s(WebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				update(item);
			}
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO
					.getInserted();
			for (Map<String, Object> newitem : equipmentmateriallist) {
				Plan item = (Plan) MapTrunPojo
						.mapToEntity(newitem, getEntity());
				// 默认参数
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setRecord_flag_s("A");
				item.setCreated_by_s(WebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setEquip_name_s(searchMixEquipName(item.getEquip_code_s()).get(0).get("DESCRIPTION").toString());
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("record_flag_s", "A");
				where.andEqual("plan_no_s", item.getPlan_no_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);
				if (list.size() != 0) {
					ist = true;
				}
				insertedList.add(item);
			}
			if (ist != false) {
				mun = -1;
			} else {
				save(insertedList);
			}
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO
					.getUpdated();
			for (Map<String, Object> newitem : equipmentmateriallist) {
				Plan item = (Plan) MapTrunPojo
						.mapToEntity(newitem, getEntity());
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(WebUtils.getUser().userCode);
				item.setChanged_name_s(WebUtils.getUser().userName);
				// 修改
				if (item.getPlan_status_s().toString().equals("052001")) {
					item.setCheck_by_s("");
					item.setCheck_time_t(null);
					item.setCheck_name_s("");
					item.setCheck_state_s("0");
					item.setStatus_mor_s("052001");
					item.setStatus_mid_s("052001");
					item.setStatus_nig_s("052001");
					item.setStatus_check_mor_s("053001");
					item.setStatus_check_mid_s("053001");
					item.setStatus_check_nig_s("053001");
				}
				// 审核
				if (item.getPlan_status_s().toString().equals("052002")) {
					item.setCheck_by_s(WebUtils.getUser().userCode);
					item.setCheck_time_t(new Date());
					item.setCheck_name_s(LLWebUtils.getUser().userName);
					item.setCheck_state_s("1");
					item.setStatus_mor_s("052002");
					item.setStatus_mid_s("052002");
					item.setStatus_nig_s("052002");
					item.setStatus_check_mor_s("053002");
					item.setStatus_check_mid_s("053002");
					item.setStatus_check_nig_s("053002");
				}
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("record_flag_s", "A");
				where.andEqual("plan_no_s", item.getPlan_no_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);
				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						if (!list.get(i).get("ATR_KEY").toString()
								.equals(item.getAtr_key().toString())) {
							ist = true;
						}
					}
				}
				insertedList.add(item);
			}
			if (ist != false) {
				mun = -1;
			} else {
				update(insertedList);
			}
		}
		return mun;

	}

	// 上移
	public String upward(String[] ids) throws Exception {
		try {
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			StringBuffer errorBuffer = new StringBuffer();
			StringBuffer resultBuffer = new StringBuffer();
			String moveFlag = "Up";
			for (String item : ids) {
				String result = "False";
				result = portType.recivePlanMoveByMES((String) null,
						(String) null, item, moveFlag,
						(LLWebUtils.getUser()).userCode,
						(LLWebUtils.getUser()).userName);
				if (result.equals("OK")) {
					resultBuffer.append(buildcommonMsg(Integer.valueOf(1), item
							+ "操作成功"));
					continue;
				}
				errorBuffer.append(buildcommonMsg(Integer.valueOf(0), item
						+ "操作失败，返回结果" + result));
			}
			return resultBuffer.toString() + "<br>" + errorBuffer.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	// 下移
	public String down(String[] ids) throws Exception {
		try {
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			StringBuffer errorBuffer = new StringBuffer();
			StringBuffer resultBuffer = new StringBuffer();
			String moveFlag = "Down";
			for (String item : ids) {
				String result = "False";
				result = portType.recivePlanMoveByMES((String) null,
						(String) null, item, moveFlag,
						(LLWebUtils.getUser()).userCode,
						(LLWebUtils.getUser()).userName);
				if (result.equals("OK")) {
					resultBuffer.append(buildcommonMsg(Integer.valueOf(1), item
							+ "操作成功"));
					continue;
				}
				errorBuffer.append(buildcommonMsg(Integer.valueOf(0), item
						+ "操作失败，返回结果" + result));
			}
			return resultBuffer.toString() + "<br>" + errorBuffer.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * 密炼机台列表查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMixEquip() {
		SQLQuery query = createSQLQuery(getSQL("searchMixEquip"));
		if (LLWebUtils.factory().equals("1")) {
			query.setParameter("factory", "80231MX");
		} else {
			query.setParameter("factory", "80232MX");
		}
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toUserName(String usercode) {
		SQLQuery query = createSQLQuery(getSQL("toUserName"));
		query.setParameter("usercode", usercode);
		System.out.println(getSQL("toUserName").toString());
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

	/**
	 * 根据机台查询胶料密炼配方
	 * 
	 * @return
	 */
	public List<Map<String, Object>> mixJLMaterialList(String equipcode) {
		SQLQuery query = createSQLQuery(getSQL("mixJLMaterialList"));
		query.setParameter("equipcode", equipcode);
		System.out.println(getSQL("mixJLMaterialList").toString());
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

	/**
	 * 根据机台查询小料密炼配方
	 * 
	 * @return
	 */
	public List<Map<String, Object>> mixXLMaterialList(String equipcode,
			String mater_type_s) {
		if (!mater_type_s.equals("ALL")) {
			SQLQuery query = getSession().createSQLQuery(
					getSQL("mixXLMaterialList"));
			query.setParameter("equipcode", equipcode);
			query.setParameter("mater_type_s", mater_type_s);
			query.setResultTransformer((ResultTransformer) Transformers.ALIAS_TO_ENTITY_MAP);
			return query.list();
		}
		SQLQuery query1 = getSession().createSQLQuery(
				getSQL("mixXLMaterialListAll"));
		query1.setParameter("equipcode", equipcode);
		query1.setResultTransformer((ResultTransformer) Transformers.ALIAS_TO_ENTITY_MAP);
		return query1.list();
	}

	/**
	 * 根据物料编码查询名称
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getMaterialNameByCode(String materialcode) {
		SQLQuery query = createSQLQuery(getSQL("getMaterialNameByCode"));
		query.setParameter("materialcode", materialcode);
		System.out.println(getSQL("getMaterialNameByCode").toString());
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

	/**
	 * 查询计划表最大顺序号
	 * 
	 * @return
	 */
	public int getMixDayPlanMaxSeq(String plandate, String equipcode) {
		int maxseq = ((BigDecimal) getSession()
				.createSQLQuery(getSQL("getMixDayPlanMaxSeq"))
				.setParameter("factory", LLWebUtils.factory())
				.setParameter("plandate", plandate)
				.setParameter("equipcode", equipcode).uniqueResult())
				.intValue();
		return maxseq;
	}

	// 获取新增信息-配方-快检信息
	@SuppressWarnings("unchecked")
	public Object[] getAddInfoList(String equipcode, String materialcode,
			String palntype) throws Exception {
		StringBuffer errorInfo = new StringBuffer();
		// 配方粗筛
		SQLQuery query = createSQLQuery(getSQL("getRecipeListByMaterialcode"));
		query.setParameter("materialcode", materialcode);
		query.setParameter("equipcode", equipcode);
		List<Map<String, Object>> res = query.list();
		if (res == null || res.size() == 0) {
			errorInfo.append(buildcommonMsg(0, materialcode
					+ "物料编码没有同步的密炼配方，请联系PLM人员集成"));
		}
		if (errorInfo.length() > 0) {
			throw new Exception(errorInfo.toString());
		}
		List<Map<String, Object>> recipeInfo = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < res.size(); i++) {
			recipeInfo.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		List<Map<String, Object>> quickCheckInfo = new ArrayList<Map<String, Object>>();
		String sip = "";
		if (palntype.equals("051003")) {
			// 校验密炼快检检验百分比有没有维护
			sip = getSip(materialcode).toString();
			// 快检粗筛
			SQLQuery queryc = createSQLQuery(getSQL("getQuickCheckListByMaterialcode"));
			queryc.setParameter("materialcode", materialcode);
			List<Map<String, Object>> res2 = queryc.list();
			/*if (res2 == null || res2.size() == 0) {
				errorInfo.append(buildcommonMsg(0, materialcode
						+ "物料编码没有同步的快检标准，请联系PLM人员集成"));
			}
			if (errorInfo.length() > 0) {
				throw new Exception(errorInfo.toString());
			}*/
			if (res2 != null && res2.size() > 0) {
				for (int i = 0; i < res2.size(); i++) {
					quickCheckInfo.add(TransformUpperCase.transformUpperCase(res2
							.get(i)));
				}
			}
		}
		Object[] result = new Object[] { recipeInfo, quickCheckInfo, sip };
		return result;
	}

	public Float getSip(String materialcode) throws Exception {
		Object sip = getSession()
				.createSQLQuery(getSQL("getSipByMaterialCode"))
				.setParameter("materialcode", materialcode).uniqueResult();
		if (sip == null) {
			return 0f;
		}
		return Float.parseFloat(sip.toString());
	}

	// 通过配方号获取新增信息-计划号-配方-快检信息
	@SuppressWarnings("unchecked")
	public Response getAddInfoListByRecipecode(String recipecode,
			String productdate) throws Exception {
		StringBuffer errorInfo = new StringBuffer();
		// 获取配方信息
		SQLQuery queryrecipeedit = createSQLQuery(getSQL("getRecipeEditListByRecipecode"));
		queryrecipeedit.setParameter("recipecode", recipecode);
		List<Map<String, Object>> recipeeditList = queryrecipeedit.list();
		if (recipeeditList == null || recipeeditList.size() == 0) {
			errorInfo.append(buildcommonMsg(0, recipecode
					+ "此配方没有已审核的数据，请打开基础数据查询密炼配方集成页面，点击审核"));
		}
		if (recipeeditList.size() > 1) {
			errorInfo
					.append(buildcommonMsg(0, recipecode + "此配方在配方管理表中的数据不止一条"));
		}
		if (errorInfo.length() > 0) {
			return Response.error("1", errorInfo.toString(), null);
		}
		String matertype = recipeeditList.get(0).get("MATER_TYPE_S").toString();// 父物料类型-330
		String equipcode = "";
		if (recipeeditList.get(0).get("MES_EQUIP_CODE_S") != null) {
			equipcode = recipeeditList.get(0).get("MES_EQUIP_CODE_S")
					.toString();// 机台条码
		}
		String matersap_s = recipeeditList.get(0).get("MATER_CODE_S")
				.toString();
		// String matername_s =
		// recipeeditList.get(0).get("MATER_NAME_S").toString();
		// String materrevision_s =
		// recipeeditList.get(0).get("B_VERSION_S").toString();
		String prescriptionstage_s = recipeeditList.get(0)
				.get("PRESCRIPTIONSTAGE_S").toString();
		List<Map<String, Object>> quickCheckInfo = new ArrayList<Map<String, Object>>();
		// 只对胶料计划校验快检标准
		if (matertype.equals("LLMasterBatch")
				|| matertype.equals("LLFinalBatchMPart")) {
			// 获取快检信息
			SQLQuery query = createSQLQuery(getSQL("getQuickCheckListByRecipecode"));
			query.setParameter("matersap_s", matersap_s);
			// query.setParameter("materrevision_s", materrevision_s); //and
			// p.materrevision_s=:materrevision_s
			query.setParameter("prescriptionstage_s", prescriptionstage_s);
			List<Map<String, Object>> res = query.list();
//			if (res == null || res.size() == 0) {
//				errorInfo.append(buildcommonMsg(0, recipecode
//						+ "配方没有同步的快检标准，请联系PLM人员集成"));
//			}
//			if (errorInfo.length() > 0) {
//				return Response.error("1", errorInfo.toString(), null);
//			}
			if (res != null && res.size() > 0) {
				for (int i = 0; i < res.size(); i++) {
					quickCheckInfo.add(TransformUpperCase.transformUpperCase(res.get(i)));
				}
			}
		}
		// 返回结果
		Object[] result = new Object[] { quickCheckInfo, equipcode, matersap_s };
		return Response.suc(result);
	}

	// 通过配方号获取物料类型
	// private String getMatTypeByRecipeCode(String recipecode) throws Exception
	// {
	// StringBuffer errorInfo = new StringBuffer();
	// // 获取配方信息
	// SQLQuery queryrecipeedit =
	// createSQLQuery(getSQL("getRecipeEditListByRecipecode"));
	// queryrecipeedit.setParameter("recipecode", recipecode);
	// List<Map<String, Object>> recipeeditList = queryrecipeedit.list();
	// if (recipeeditList == null || recipeeditList.size() == 0) {
	// errorInfo.append(buildcommonMsg(0, recipecode
	// + "此配方没有已审核的数据，请打开-基础数据查询->密炼配方集成页面，点击审核"));
	// }
	// if (recipeeditList.size() > 1) {
	// errorInfo
	// .append(buildcommonMsg(0, recipecode + "此配方在配方管理表中的数据不止一条"));
	// }
	// if (errorInfo.length() > 0) {
	// throw new Exception(errorInfo.toString());
	// }
	// String matertype =
	// recipeeditList.get(0).get("MATER_TYPE_S").toString();// 父物料类型-330
	// return matertype;
	// }

	// 获取等同物料编码列表
	public List<Map<String, Object>> getEqualMaterialcode(String recipecode,
			String equipcode) {
		SQLQuery query = createSQLQuery(getSQL("getEqualMaterialcode"));
		query.setParameter("equipcode", equipcode);
		query.setParameter("recipecode", recipecode);
		return query.list();
	}

	// 获取等同物料等级
	public List<Map<String, Object>> getEqualMaterialLevel(String materialcode) {
		SQLQuery query = createSQLQuery(getSQL("getEqualMaterialLevel"));
		query.setParameter("materialcode", materialcode);
		return query.list();
	}
	
	// 根据机台条码获取机台名称
	public List<Map<String, Object>> searchMixEquipName(String equipcode) {
		SQLQuery query = createSQLQuery(getSQL("searchMixEquipName"));
		if (LLWebUtils.factory().equals("1")) {
			query.setParameter("factory", "80231MX");
		} else {
			query.setParameter("factory", "80232MX");
		}
		query.setParameter("equipcode", equipcode);
		return query.list();
	}

	// 验证物料编码是否已经存在
	public Boolean validEquipcodeExitInPlan(String plandate, String equipment,
			String materialcode, String recipecode) {
		int count = ((BigDecimal) getSession()
				.createSQLQuery(getSQL("validEquipcodeExitInPlan"))
				.setParameter("plandate", plandate)
				.setParameter("equipment", equipment)
				.setParameter("factory", LLWebUtils.factory())
				.setParameter("materialcode", materialcode)
				.setParameter("recipecode", recipecode).uniqueResult())
				.intValue();
		if (count > 0) {
			return false;
		}
		return true;
	}

	private String buildcommonMsg(Integer type, String msg) {
		String color = "";
		if (type.equals(0)) {
			color = "<font color=ff0000>";// 错误
		} else if (type.equals(1)) {
			color = "<font color=000000>";// 正确
		} else if (type.equals(2)) {
			color = "<font color=f7df09>";// 警告
		}
		return color + msg + "<br>";
	}

	// 日计划复制
	public List<Plan> copy(Filter filter, String todate, Page page)
			throws Exception {
		Where w = new Where();
		w.andEqual("s_factory_s", LLWebUtils.factory());
		w.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
		w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		w.andEqual("plan_date_s", todate);
		w.andEqual("plan_type_s", filter.get("plan_type_s"));
		if (super.findByWhere(w).size() > 0) {
			throw new Exception(todate + "已经存在日计划");
		}
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("plan_status_s", "052004");
		List<Plan> listMixPlan = datagridRows(filter, page, Plan.class);
		List<Plan> mixPlanResult = new ArrayList<>();
		Map<String, Plan> saveMixPlanListMap = new HashMap<String, Plan>();// 用来存要保存的计划信息
		StringBuffer errorInfo = new StringBuffer();
		for (Plan mixPlan : listMixPlan) {
			String mapKey = mixPlan.getMaterial_code_s() + "|"
					+ mixPlan.getEquip_code_s() + "|"
					+ mixPlan.getMixrecipe_recipe_code_s();
			if (!saveMixPlanListMap.containsKey(mapKey)) {
				saveMixPlanListMap.put(mapKey, mixPlan);
				mixPlanResult.add(getNewMixDayPlan(mixPlan, filter, todate));
				continue;
			}
			Plan exitMixDayPlan = saveMixPlanListMap.get(mapKey);

			Integer qty_plan_i = exitMixDayPlan.getQty_plan_i() == null ? 0
					: exitMixDayPlan.getQty_plan_i();// 计划总数
			Integer qty_plan_i2 = mixPlan.getQty_plan_i() == null ? 0 : mixPlan
					.getQty_plan_i();

			Integer qty_mor_i = exitMixDayPlan.getQty_mor_i() == null ? 0
					: exitMixDayPlan.getQty_mor_i();
			Integer qty_mor_i2 = mixPlan.getQty_mor_i() == null ? 0 : mixPlan
					.getQty_mor_i();
			Integer qty_mid_i = exitMixDayPlan.getQty_mid_i() == null ? 0
					: exitMixDayPlan.getQty_mid_i();
			Integer qty_mid_i2 = mixPlan.getQty_mid_i() == null ? 0 : mixPlan
					.getQty_mid_i();
			Integer qty_nig_i = exitMixDayPlan.getQty_nig_i() == null ? 0
					: exitMixDayPlan.getQty_nig_i();
			Integer qty_nig_i2 = mixPlan.getQty_nig_i() == null ? 0 : mixPlan
					.getQty_nig_i();

			exitMixDayPlan.setQty_plan_i(qty_plan_i + qty_plan_i2);// 计划总数
			exitMixDayPlan.setQty_mor_i(qty_mor_i + qty_mor_i2);// 早班数量
			exitMixDayPlan.setQty_mid_i(qty_mid_i + qty_mid_i2);// 中班数量
			exitMixDayPlan.setQty_nig_i(qty_nig_i + qty_nig_i2);// 晚班数量

			float qty_check_plan_f = (Float) (exitMixDayPlan
					.getQty_check_plan_f() == null ? 0 : exitMixDayPlan
					.getQty_check_plan_f());
			float qty_check_plan_f2 = (Float) (mixPlan.getQty_check_plan_f() == null ? 0
					: mixPlan.getQty_check_plan_f());
			exitMixDayPlan.setQty_check_plan_f(qty_check_plan_f
					+ qty_check_plan_f2 + "");// 检查总量

			float qty_check_mor_f = (Float) (exitMixDayPlan
					.getQty_check_mor_f() == null ? 0 : exitMixDayPlan
					.getQty_check_mor_f());
			float qty_check_mor_f2 = (Float) (mixPlan.getQty_check_mor_f() == null ? 0
					: mixPlan.getQty_check_mor_f());
			exitMixDayPlan.setQty_check_mor_f(qty_check_mor_f
					+ qty_check_mor_f2 + "");// 早班检查量

			float qty_check_mid_f = (Float) (exitMixDayPlan
					.getQty_check_mid_f() == null ? 0 : exitMixDayPlan
					.getQty_check_mid_f());
			float qty_check_mid_f2 = (Float) (mixPlan.getQty_check_mid_f() == null ? 0
					: mixPlan.getQty_check_mid_f());
			exitMixDayPlan.setQty_check_mid_f(qty_check_mid_f
					+ qty_check_mid_f2 + "");// 中班检查量

			float qty_check_nig_f = (Float) (exitMixDayPlan
					.getQty_check_nig_f() == null ? 0 : exitMixDayPlan
					.getQty_check_nig_f());
			float qty_check_nig_f2 = (Float) (mixPlan.getQty_check_nig_f() == null ? 0
					: mixPlan.getQty_check_nig_f());
			exitMixDayPlan.setQty_check_nig_f(qty_check_nig_f
					+ qty_check_nig_f2 + "");// 晚班检查量

			saveMixPlanListMap.replace(mapKey, exitMixDayPlan);// 更新键值对
			mixPlanResult.add(getNewMixDayPlan(exitMixDayPlan, filter, todate));
		}
		if (errorInfo.length() > 0) {
			throw new Exception(errorInfo.toString());
		}
		for (int i = 0; i < mixPlanResult.size(); i++) {
			mixPlanResult.get(i).setPlan_no_s(this.getPlanno(todate, i));
			mixPlanResult.get(i).setSpare8_s(i + 1 + "");
		}
		return mixPlanResult;
	}

	// 获取新的计划
	private Plan getNewMixDayPlan(Plan mixPlan, Filter filter, String todate)
			throws Exception {
		// String recipecode=mixPlan.getMixrecipe_recipe_code_s();//配方号
		// String matertype= getMatTypeByRecipeCode(recipecode);
		// mixPlan.setPlan_no_s(this.getPlanno(todate));
		mixPlan.setPlan_date_s(todate);
		mixPlan.setChanged_by_s(null);
		mixPlan.setChanged_name_s(null);
		mixPlan.setChanged_time_t(null);
		mixPlan.setCreated_by_s(LLWebUtils.getUser().userCode);
		mixPlan.setCreated_name_s(LLWebUtils.getUser().userName);
		mixPlan.setCreated_time_t(new Date());
		mixPlan.setCheck_by_s(null);
		mixPlan.setCheck_name_s(null);
		mixPlan.setCheck_state_s("0");
		mixPlan.setCheck_time_t(null);
		mixPlan.setDatasource_s(null);
		mixPlan.setId_s(null);
		mixPlan.setIs_silo_clean_s(null);
		mixPlan.setMemo_s(null);
		mixPlan.setMi_equip_code_s(null);
		mixPlan.setMi_equip_name_s(null);
		mixPlan.setPlan_finish_time_t(null);
		mixPlan.setPlan_start_time_t(null);
		mixPlan.setPlan_status_s("052001");
		mixPlan.setProduction_ver_s(null);
		mixPlan.setQty_check_bad_mor_i(null);
		mixPlan.setQty_check_bad_mid_i(null);
		mixPlan.setQty_check_bad_nig_i(null);
		mixPlan.setQty_check_good_mor_i(null);
		mixPlan.setQty_check_good_mid_i(null);
		mixPlan.setQty_check_good_nig_i(null);
		mixPlan.setQty_complete_mor_i(null);
		mixPlan.setQty_complete_mid_i(null);
		mixPlan.setQty_complete_nig_i(null);
		mixPlan.setSa_equip_code_s(null);
		mixPlan.setSa_equip_name_s(null);
		mixPlan.setSend_by_s(null);
		mixPlan.setSend_name_s(null);
		mixPlan.setSend_state_s("0");
		mixPlan.setSend_time_t(null);
		if (filter.get("plan_type_s").equals("051003")) {
			mixPlan.setSip_s(getSip(mixPlan.getMaterial_code_s()).toString());
		}
		mixPlan.setMixrecipe_recipe_code_s(mixPlan.getMixrecipe_recipe_code_s());
		mixPlan.setStatus_mor_s("052001");
		mixPlan.setStatus_mid_s("052001");
		mixPlan.setStatus_nig_s("052001");
		mixPlan.setStatus_check_mor_s("053001");
		mixPlan.setStatus_check_mid_s("053001");
		mixPlan.setStatus_check_nig_s("053001");
		mixPlan.setS_factory_s(LLWebUtils.factory());
		mixPlan.setAtr_key(null);
		mixPlan.setSite_num(null);
		mixPlan.setAtr_name(null);
		mixPlan.setPurge_status(null);
		mixPlan.setCreation_time(null);
		mixPlan.setCreation_time_u(null);
		mixPlan.setCreation_time_z(null);
		mixPlan.setLast_modified_time(null);
		mixPlan.setLast_modified_time_u(null);
		mixPlan.setLast_modified_time_z(null);
		mixPlan.setXfr_insert_pid(null);
		mixPlan.setXfr_update_pid(null);
		mixPlan.setTrx_id(null);
		mixPlan.setParent_key(null);
		mixPlan.setSpare6_s("0");
		return mixPlan;
	}

	// 根据物料编码+时间获取计划流水号
	private String getPlanno(String productdate, int i) throws Exception {
		String planno = "";
		int num = ((BigDecimal) getSession()
				.createSQLQuery(getSQL("getMixPlanMaxSeq"))
				.setParameter("factory", LLWebUtils.factory())
				.setParameter("plandate", productdate).uniqueResult())
				.intValue() + i;
		if (num < 10) {
			planno = "MP" + productdate + "00" + num;
		} else if (num >= 10 && num < 100) {
			planno = "MP" + productdate + "0" + num;
		} else {
			planno = "MP" + productdate + num;
		}
		return planno;
	}

	// 调用接口生成领料计划
	public String producerecivelist(String[] ids) throws Exception {
		try {
			StringBuffer sb = new StringBuffer();
			String upEditOrderSql = "";
			String upExecOrderSql = "";
			String upMixdayPlanSql = "";
			String recipecode = "";
			int sucCount = 0;
			StringBuffer falseinfo = new StringBuffer();
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			String result = "False";
			for (int i = 0; i < ids.length; i++) {
				recipecode = ids[i];
				result = portType.reciveMaterialApplyByMES((String) null,
						(String) null, recipecode,
						(LLWebUtils.getUser()).userCode,
						(LLWebUtils.getUser()).userName);
				if (result.equals("OK")) {
					sucCount++;
					upMixdayPlanSql = "update AT_MX_PP_PLAN t set t.spare6_s='1' where t.plan_no_s='"
							+ recipecode + "'";
					upEditOrderSql = "update AT_MX_PP_WO_EDIT t set t.spare6_s='1' where t.plan_no_s='"
							+ recipecode + "'";
					upExecOrderSql = "update AT_MX_PP_WO_EXEC t set t.spare6_s='1' where t.plan_no_s='"
							+ recipecode + "'";
					RockWellUtils.execSQL(new String[] { upMixdayPlanSql });
					RockWellUtils.execSQL(new String[] { upEditOrderSql });
					RockWellUtils.execSQL(new String[] { upExecOrderSql });
				} else {
					falseinfo.append(recipecode + "操作失败，返回结果：" + result
							+ "<br>");
				}
			}
			sb.append("合计：" + ids.length + "条，" + "成功：" + sucCount + "条；"
					+ "失败：" + (ids.length - sucCount) + "条");
			sb.append("<br>");
			sb.append(falseinfo.toString());
			return sb.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	/**
	 * 获取密炼物料信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getMixMatInfo() {
		SQLQuery query = createSQLQuery(getSQL("getMixMatInfo"));
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

	/**
	 * 获取胶料机台信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getJlEquipList(String plantype)
			throws Exception {
		try {
			String areaname = "";
			String[] matchlist = null;
			if (LLWebUtils.factory().equals("1")) {
				areaname = "80231MX";
				if (plantype.equals("051003"))
					matchlist = new String[] { "F1001", "F1002", "F1003",
							"F1004", "F1005", "F1006", "F1007", "F1008", "F1009", "F1010" };
				if (plantype.equals("051002"))
					matchlist = new String[] { "E0201", "E0202", "E0203" };
				if (plantype.equals("051001"))
					matchlist = new String[] { "F1011", "F1012", "F1013", "F1014" };
				if (plantype.equals("051003051001"))
					matchlist = new String[] { "E01", "E02" };
				if (plantype.equals("051004"))
					matchlist = new String[] { "F10" };
			} else {
				areaname = "80232MX";
				if (plantype.equals("051003"))
					matchlist = new String[] { "H1001", "H1002", "H1003",
							"H1004", "H1005", "H1006", "H1007", "H1008", "H1009", "H1010" };
				if (plantype.equals("051002"))
					matchlist = new String[] { "E0201", "E0202", "E0203" };
				if (plantype.equals("051001"))
					matchlist = new String[] { "H1011", "H1012", "H1013", "H1014" };
				if (plantype.equals("051003051001"))
					matchlist = new String[] { "E01", "E02" };
				if (plantype.equals("051004"))
					matchlist = new String[] { "H10" };
			}
			return getProductionInfoByAreaNameAndMatchlist(areaname, matchlist);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取小料机台信息
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getXlEquipList() throws Exception {
		try {
			String areaname = "";
			String[] matchlist = null;
			if (LLWebUtils.factory().equals("1")) {
				areaname = "80231MX";
				matchlist = new String[] { "F1011", "F1012", "F1013", "F1014" };
			} else {
				areaname = "80232MX";
				matchlist = new String[] { "H1011", "H1012", "H1013", "H1014" };
			}
			return getProductionInfoByAreaNameAndMatchlist(areaname, matchlist);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Map<String, Object>> getplmByPlinenameall() throws Exception {
		try {
			String areaname = "";
			String[] matchlist = null;
			if (LLWebUtils.factory().equals("1")) {
				areaname = "80231MX";
				matchlist = new String[] { "F1001", "F1002", "F1003",
						"F1004", "F1005", "F1006", "F1007", "F1008", "F1009", "F1010",
						"F1011", "F1012", "F1013", "F1014" };
			} else {
				areaname = "80232MX";
				matchlist = new String[] { "H1001", "H1002", "H1003",
						"H1004", "H1005", "H1006", "H1007", "H1008", "H1009", "H1010",
						"H1011", "H1012", "H1013", "H1014" };
			}
			return getProductionInfoByAreaNameAndMatchlist(areaname, matchlist);
		} catch (Exception e) {
			return null;
		}
	}

	public List<Map<String, Object>> getProductionInfoByAreaNameAndMatchlist(
			String areaname, String[] matchlist) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append("select a.area_name,a.description areadescription,p.p_line_name,p.description,up.*");
		sql.append(" from area a, area_production_line l2, production_line p,uda_productionline up");
		sql.append(" where l2.parent_key = a.area_key");
		sql.append(" and l2.child_key = p.p_line_key");
		sql.append(" and p.p_line_key=up.object_key(+)");
		if (matchlist != null && matchlist.length > 0) {
			String matchString = "";
			sql.append(" and REGEXP_LIKE(p.p_line_name, '(");
			for (int j = 0; j < matchlist.length; j++)
				matchString = matchString + matchlist[j].toString() + "|";
			sql.append(matchString.substring(0, matchString.length() - 1)
					.trim());
			sql.append(")') ");
		}
		if (!areaname.equals("")) {
			sql.append(" and a.area_name='");
			sql.append(areaname + "'");
		}
		sql.append(" order by p.p_line_name");
		SQLQuery query = createSQLQuery(sql.toString());
		List<Map<String, Object>> res = query.list();
		List<Map<String, Object>> list_new = new ArrayList<>();
		for (int i = 0; i < res.size(); i++)
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		return list_new;
	}

}
