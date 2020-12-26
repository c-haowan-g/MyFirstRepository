package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.entity.ChangeMould;
import com.bluebirdme.mes.linglong.building.entity.ClassPlan;
import com.bluebirdme.mes.linglong.building.entity.CxProductionDayPlan;
import com.bluebirdme.mes.linglong.building.entity.FormulaRecord;
import com.bluebirdme.mes.linglong.building.entity.Machine_Formula;
import com.bluebirdme.mes.linglong.building.service.FactoryProductLineServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringProductionMonthPlan;
import com.bluebirdme.mes.linglong.curing.entity.ProductionDayPlan;
import com.bluebirdme.mes.linglong.curing.service.SapProductionPlanServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.ui.Time;

/**
 * 成型日计划表
 * 
 * @author 时永良
 * @Date 2019-02-26 17:37:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CxProductionDayPlanServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;
	@Resource
	FactoryProductLineServiceImpl productlineds;
	@Resource
	ClassPlanServiceImpl workorderds;
	@Resource
	SerialServiceImpl serialSrv;// 系统参数获取
	@Resource
	MachineStatusServiceImpl machineStatusServiceSrv;// 获取机台状态
	@Resource
	ChangeMouldServiceImpl changeMouldServiceSrv;// 换模计划
	@Resource
	BuildingValidDataToolsServiceImpl validtools;
	@Resource
	Machine_FormulaServiceImpl machineformulaSrv;// 下发参数的表
	@Resource
	FormulaRecordServiceImpl formularecordSrv;// 下发参数履历表
	@Resource
	BuildRecipeParaServiceImpl buildRecipeParaServiceImpl;// 工艺参数表
	@Resource
	SapProductionPlanServiceImpl sapProductionPlanServiceImpl;// 硫化月计划

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return CxProductionDayPlan.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	
	public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {
	
		  String FACTORY = "s_factory_s";
		  
		  if (!filter.getFilter().containsKey(FACTORY)) { try {
		  filter.set("s_factory_s", LLWebUtils.factory()); } catch (Exception
		  e) { throw new
		  Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录"); } }
		 

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
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

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	/**
	 * 保存  
	 * 由于物料描述长度为80，暂时处理过长的字段保存0-75个字段   已修改字段 
	 * @param rockWellEntityDTO
	 * @return
	 * @throws Exception
	 */
	@RockWellTransactional
	public String saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		StringBuffer sbBuffer = new StringBuffer();// 存放异常信息
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			int con = rockWellEntityDTO.getDeleted().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CxProductionDayPlan cxProductionDayPlan=(CxProductionDayPlan) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), CxProductionDayPlan.class);
				cxProductionDayPlan.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
				cxProductionDayPlan.setChanged_by_s(LLWebUtils.getUser().userCode);
				cxProductionDayPlan.setChanged_time_t(new Date());
				list.add(cxProductionDayPlan);
			}
			update(list);
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			int con = rockWellEntityDTO.getInserted().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CxProductionDayPlan cxProductionDayPlan=(CxProductionDayPlan) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), CxProductionDayPlan.class);
				Where where = new Where();
				where.andEqual("plan_no_s", cxProductionDayPlan.getPlan_no_s());
				where.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
				if (findByWhere(where).size() > 0) {
					continue;// 应对复制页面问题
				}
				// 验证数据有效性
				String errString = validDataCorrect(cxProductionDayPlan);
				if (errString != null) {
					sbBuffer.append(errString);
					continue;
				}
				/*// 将硫化月计划号存入成型日计划表中
				List<Map<String,Object>> planno_month = monthlyPlanToCxProductionDayPlan(cxProductionDayPlan);
				if (planno_month.size()!=0) {
					for(int j=0;j<planno_month.size();j++){
						cxProductionDayPlan.setPlanno_month_s(planno_month.get(j).get("planno_month_s").toString());
					}
				}*/
				// 将work_order_items中的order_number存入成型日计划表中
				/*String order_number = orderNumberToCxProductionDayPlan(cxProductionDayPlan);
				if (order_number != null) {
					cxProductionDayPlan.setOrder_number_s(order_number);
				}*/
				cxProductionDayPlan.setCreated_by_s(LLWebUtils.getUser().userCode);
				cxProductionDayPlan.setCreated_time_t(new Date());
				cxProductionDayPlan.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
				cxProductionDayPlan.setS_factory_s(LLWebUtils.factory());
				Integer planQueueNo = cxProductionDayPlan.getPlan_queue_i();
				if (cxProductionDayPlan.getPlan_queue_i() == null || cxProductionDayPlan.getPlan_queue_i() == 0) {
					String euipcode = cxProductionDayPlan.getEquip_code_s();
					String productdate = cxProductionDayPlan.getProduction_date_s();
					Integer planQueue = Integer.parseInt(serialSrv.machineOrderNumber(euipcode, productdate, 10));
					planQueueNo = planQueue;
				}

				Object getEntType = getSession().createSQLQuery(getSQL("getEntTypeByCode"))
						.setParameter("equipcode", cxProductionDayPlan.getEquip_code_s()).uniqueResult();
				if (getEntType == null) {
					sbBuffer.append(cxProductionDayPlan.getEquip_code_s() + "设备类型未维护，请至基础数据->产线管理页面维护设备的产线类型");
					continue;
				}
				cxProductionDayPlan.setEquip_type_s(getEntType.toString());
				cxProductionDayPlan.setPlan_queue_i(planQueueNo);
				/*//由于物料描述长度为80，暂时处理过长的字段保存0-75个字段
				if(cxProductionDayPlan.getMaterial_desc_s().length()>= 80){
					cxProductionDayPlan.setMaterial_desc_s(cxProductionDayPlan.getMaterial_desc_s().substring(0, 75));
				}*/
				list.add(cxProductionDayPlan);
			}
			save(list);
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			int con = rockWellEntityDTO.getUpdated().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				CxProductionDayPlan cxProductionDayPlan=(CxProductionDayPlan) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), CxProductionDayPlan.class);
				// 验证数据有效性
				String errString = validDataCorrect(cxProductionDayPlan);
				if (errString != null) {
					sbBuffer.append(errString);
					continue;
				}
				cxProductionDayPlan.setChanged_by_s(LLWebUtils.getUser().userCode);
				cxProductionDayPlan.setChanged_time_t(new Date());

				Object getEntType = getSession().createSQLQuery(getSQL("getEntTypeByCode"))
						.setParameter("equipcode", cxProductionDayPlan.getEquip_code_s()).uniqueResult();
				if (getEntType == null) {
					sbBuffer.append(cxProductionDayPlan.getEquip_code_s() + "设备类型未维护，请至基础数据->产线管理页面维护设备的产线类型");
					continue;
				}
				cxProductionDayPlan.setEquip_type_s(getEntType.toString());

				if (cxProductionDayPlan.getAtr_key() == null) {
					save(cxProductionDayPlan);
				}
				update(cxProductionDayPlan);
			}

		}
		if (sbBuffer.length() > 0) {
			return sbBuffer.toString();
		} else {
			return "操作成功";
		}
	}

	@SuppressWarnings("unused")
	private Map<String, CxProductionDayPlan> getExitWorkStatusPlan(List<CxProductionDayPlan> listCxPlan) {
		Map<String, CxProductionDayPlan> plansGroupByMachine = new HashMap<>();

		for (CxProductionDayPlan item : listCxPlan) {
			if (item.getStatus_s().equals("152003") && !plansGroupByMachine.containsKey(item.getEquip_code_s())) {
				plansGroupByMachine.put(item.getEquip_code_s(), item);
			}
		}
		if (plansGroupByMachine.size() == 0) {
			return null;
		}
		return plansGroupByMachine;
	}

	/**
	 * 日计划复制 刘程明 2019年3月18日
	 * 
	 * @param filter
	 * @param todate
	 *            要复制去的时间
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<CxProductionDayPlan> copy(Filter filter, String todate, Page page) throws Exception {

		Where w = new Where();
		w.andEqual("s_factory_s", LLWebUtils.factory());
		w.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
		w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		w.andEqual("production_date_s", todate);
		if (super.findByWhere(w).size() > 0) {
			throw new Exception(todate + "已经存在日计划");
		}

		List<CxProductionDayPlan> listCxPlan = super.datagridRows(filter, page, CxProductionDayPlan.class);

		List<CxProductionDayPlan> listCxPlanResult = new ArrayList<>();

		Map<String, CxProductionDayPlan> exitWorkStatusPlan = getExitWorkStatusPlan(listCxPlan);

		Integer planQueue = -1;
		for (CxProductionDayPlan cxPlan : listCxPlan) {

			cxPlan.setProduction_date_s(todate);
			cxPlan.setPlan_no_s(serialSrv.serial("CXRJH", todate));
			String euipCode = cxPlan.getEquip_code_s();
			String planStatus = cxPlan.getStatus_s();
			// 如果前一日期的计划处于执行中，则将新的计划的序号设置为10
			if (planStatus.equals("152003") && exitWorkStatusPlan != null && exitWorkStatusPlan.size() > 0
					&& exitWorkStatusPlan.containsKey(euipCode)) {
				planQueue = 10;
			} else if (!planStatus.equals("152003") && exitWorkStatusPlan != null && exitWorkStatusPlan.size() > 0
					&& exitWorkStatusPlan.containsKey(euipCode)) {
				planQueue = Integer.parseInt(serialSrv.machineOrderNumber(euipCode, todate, 10)) + 10;
			} else {
				planQueue = Integer.parseInt(serialSrv.machineOrderNumber(euipCode, todate, 10));
			}
			cxPlan.setStatus_s("152001");
			cxPlan.setPlan_queue_i(planQueue);
			cxPlan.setCreated_by_s(LLWebUtils.getUser().userCode);
			cxPlan.setCreated_time_t(new Date());
			// 清空修改人，审核人信息
			cxPlan.setChanged_by_s(null);
			cxPlan.setChanged_time_t(null);
			cxPlan.setAudit_by_s(null);
			cxPlan.setAudit_time_t(null);
			// 清空rockwell的表
			cxPlan.setAtr_key(null);
			cxPlan.setSite_num(null);
			cxPlan.setAtr_name(null);
			cxPlan.setPurge_status(null);
			cxPlan.setCreation_time(null);
			cxPlan.setCreation_time_u(null);
			cxPlan.setCreation_time_z(null);
			cxPlan.setLast_modified_time(null);
			cxPlan.setLast_modified_time_u(null);
			cxPlan.setLast_modified_time_z(null);
			cxPlan.setXfr_insert_pid(null);
			cxPlan.setXfr_update_pid(null);
			cxPlan.setTrx_id(null);
			cxPlan.setParent_key(null);

			/*
			 * //清空计划数量信息 cxPlan.setPlanamount_mor_i(null);
			 * cxPlan.setPlanamount_mid_i(null);
			 * cxPlan.setPlanamount_nig_i(null);
			 * cxPlan.setQuantity_dayplan_i(null);
			 */// lcm修改

			// 清空实绩产出量信息
			cxPlan.setOutput_morclass_i(null);
			cxPlan.setOutput_midclass_i(null);
			cxPlan.setOutput_nigclass_i(null);
			//cxPlan.setPlanno_month_s(null);
			cxPlan.setQuantity_dayproduct_i(null);

			// 按照产线条码号，将计划实体信息，存到一个集合里面
			listCxPlanResult.add(cxPlan);

		}
		return listCxPlanResult;
	}

	/**
	 * 验证计划的有效性 刘程明 2019年3月14日
	 * 
	 * @param cxPlan
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private String validDataCorrect(CxProductionDayPlan cxPlan) throws Exception {
		StringBuffer errorMSG = new StringBuffer();
		String planno = cxPlan.getPlan_no_s();
		String materialCode = cxPlan.getMaterial_code_s();
		String equipcode = cxPlan.getEquip_code_s();// 设备条码
		String productionver = cxPlan.getProductionver_s();// 成本收集器版本 H103
		String materialVer = cxPlan.getVersion_s();// 物料版本
		String productionStep = cxPlan.getProduction_step_s();// 产品阶段
		String customer = cxPlan.getCustomer_flag_s();// 用户特殊要求标识
		String productDate = cxPlan.getProduction_date_s();// 计划生产日期
		String msg = "机台：" + equipcode + "计划号：" + planno + "物料编码：" + materialCode + "<br/>";
		if (!validtools.validCurringMonthPlanMaterialCodeAndProductDate(materialCode, productDate)) {
			errorMSG.append(msg + "<font color=ff0000>" + "硫化月计划外胎规格对应的胎胚物料编码不存在或该硫化月计划编制日期已过期，请重新选择胎胚物料编码" + "</font> <br/>");
		}
		if (!validtools.validMaterialPlusDate(materialCode)) {
			errorMSG.append(msg + "<font color=ff0000>" + "物料时效性未维护，请至系统管理->基础数据查询->物料有效期维护页面维护物料有效期" + "</font> <br/>");
		}
		if (!validtools.validBomExit(materialCode, materialVer, productionStep)) {
			errorMSG.append(msg + "<font color=ff0000>" + "物料BOM不存在或半部件BOM信息不完整" + "</font> <br/>");
		}
		if (!validtools.validMaterialOutDate(materialCode)) {
			errorMSG.append(msg + "<font color=ff0000>" + "物料已失效" + "</font> <br/>");
		}
		if (!validtools.validProductionVerFromBomAndSAP(materialCode, productionver)) {
			errorMSG.append(msg + "<font color=ff0000>" + "生产版本信息不正确" + "</font> <br/>");
		}
		if (!validtools.validCustomerDemand(equipcode, customer)) {
			errorMSG.append(msg + "<font color=ff0000>" + "客户标识字段校验产线不正确" + "</font> <br/>");
		}
		/*
		 * if(!validtools.validCurringBuildingProcessIsExit(materialCode,
		 * materialVer, productionver)){
		 * errorMSG.append(msg+"<font color=ff0000>"+"成型工艺参数校验失败，请联系PLM人员维护"+"</font> <br/>");
		 */
		if (errorMSG.length() > 0) {
			return errorMSG.toString();
		}
		return null;
	}

	/**
	 * 从硫化月计划中查出月计划号，将之存入成型日计划表中 时永良 2019年8月1日08:01:26
	 * 
	 * @param cxPlan
	 * @return
	 * @throws Exception
	 */
	private List<Map<String,Object>> monthlyPlanToCxProductionDayPlan(CxProductionDayPlan cxPlan) throws Exception {
		String materialCode = cxPlan.getMaterial_code_s();
		String productDate = cxPlan.getProduction_date_s();// 计划生产日期
		List<Map<String,Object>> monthPlan = validtools.monthlyPlanToCxProductionDayPlan(materialCode, productDate);
		return monthPlan;
	}

	/**
	 * 从工单子项中（work_order_items）查出订单子项编号（order_item），将之存入成型日计划表中 时永良
	 * 2019年8月1日08:01:26
	 * 
	 * @param cxPlan
	 * @return
	 * @throws Exception
	 */
	private String orderNumberToCxProductionDayPlan(CxProductionDayPlan cxPlan) throws Exception {
		String materialCode = cxPlan.getMaterial_code_s();
		String productDate = cxPlan.getProduction_date_s();// 计划生产日期
		String data = validtools.orderNumberToCxProductionDayPlan(materialCode, productDate);
		return data;
	}

	/**
	 * 审核计划 刘程明 2019年3月12日
	 * 
	 * @param ids
	 * @throws Exception
	 */
	@RockWellTransactional
	public void audit(Long[] ids) throws Exception {
		List<Map<String, Object>> monthlist = new ArrayList<>();
		List<Object> listCxProductionDayPlan=findByIds(ids);// 查出要审核的计划
		Object ob = (Object) listCxProductionDayPlan;
		List<CxProductionDayPlan> list = (List<CxProductionDayPlan>)ob ;
		Map<String, List<CxProductionDayPlan>> plansGroupByMachine = new HashMap<>();// 将产线按照计划分组
		String idlist[] = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			idlist[i] = ids[i].toString();
		}
		// -----------循环更新计划状态信息，并写信息到工单表-------------------//
		for (CxProductionDayPlan cxdayplan : list) {
			if (!cxdayplan.getStatus_s().equals("152001")) {
				throw new Exception("计划状态为已审核");
			}
			cxdayplan.setStatus_s("152002");
			cxdayplan.setAudit_by_s(LLWebUtils.getUser().userCode);
			cxdayplan.setAudit_time_t(new Date());
			updateOtherTable(cxdayplan);// 日计划信息按照早中晚数量情况写入班次计划表

			if (!plansGroupByMachine.containsKey(cxdayplan.getEquip_code_s())) {
				Where where = new Where();
				where.andEqual("equip_code_s", cxdayplan.getEquip_code_s());
				where.andIn("atr_key", idlist);
				List<Object> list1=findByWhere(where);
				Object ob1 = (Object) list1;
				List<CxProductionDayPlan> cxList = (List<CxProductionDayPlan>)ob1 ;
				plansGroupByMachine.put(cxdayplan.getEquip_code_s(), cxList);
			}
			// 通过胎胚物料编码和计划生产日期查出对应月计划，改变月计划状态为已下发（217003）。
			monthlist = searchSapProductionPlan(cxdayplan.getMaterial_code_s(), cxdayplan.getProduction_date_s());
			if (!monthlist.get(0).get("PLAN_STATUS_S").equals("217002")) {
				// throw new Exception("计划状态为已下发");
			} else {
				Map<String, Object> map1 = new HashMap<>();
				Map<String, Object> map2 = new HashMap<>();
				map1.put("planno_month_s", monthlist.get(0).get("PLANNO_MONTH_S"));
				map2.put("plan_status_s", "217003");
				sapProductionPlanServiceImpl.update(map1, map2);
			}
			// -----------保存审核状态至日计划---------//
			update(cxdayplan);
		}
		// 根据情况构建换工装计划
		buildMouldChangePlan(plansGroupByMachine);
		
	}

	/**
	 * 根据条件，构建换工装计划 刘程明 2019年3月22日
	 * 
	 * @param plansGroupByMachine
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "null" })
	@RockWellTransactional
	private void buildMouldChangePlan(Map<String, List<CxProductionDayPlan>> plansGroupByMachine) throws Exception {
		// 换工装计划列表
		List<Object> changemouldplanlist = new ArrayList<Object>();
		// 换工装计划
		ChangeMould changemouldplan;
		// ----- 校验同一个产线的计划顺序号是否有跳号的行为-----//
		for (String line : plansGroupByMachine.keySet()) {
			// 页面选择点击需要审核的日计划集合
			List<CxProductionDayPlan> cxlist = plansGroupByMachine.get(line);
			Collections.sort(cxlist, new Comparator<CxProductionDayPlan>() {
				@Override
				public int compare(CxProductionDayPlan o1, CxProductionDayPlan o2) {
					// 升序
					return o1.getPlan_queue_i().compareTo(o2.getPlan_queue_i());
				}
			});
			int planqueueList[] = new int[cxlist.size()];

			for (int i = 0; i < cxlist.size(); i++) {
				String equipcode = cxlist.get(i).getEquip_code_s();
				String productdate = cxlist.get(i).getProduction_date_s();
				Integer planqueue = cxlist.get(i).getPlan_queue_i();
				planqueueList[i] = planqueue;
				String materialCode = cxlist.get(i).getMaterial_code_s();
				String beforeMaterialCodeString = getBeforePlanMaterialCode(equipcode, productdate,
						planqueue.toString());
				if (beforeMaterialCodeString == null) {
					continue;
				}
				// 只和上一条计划的代码作比较，不一致就生成换工装计划（当天比较）
				if (!beforeMaterialCodeString.equals(materialCode)) {
					changemouldplan = buildMoldChangePlan(cxlist.get(i));
					if (changemouldplan != null && !changemouldplanlist.contains(changemouldplan)) {
						changemouldplanlist.add(changemouldplan);
					}
				}

			}

			Arrays.sort(planqueueList);

			Integer minAuditPlanqueue = planqueueList[0];// 当前审核列表最小的顺序号

			Integer minTodayPlanqueue = getMinPlanqueueNo(line, cxlist.get(0).getProduction_date_s());// /当日最小序列号

			// 如果计划里面含有当日第一个物料编码，则和上一次生产的最后一个物料编码比较，如果不一致则生成换工装计划（跨天比较，和上一次生产比较）
			if (minTodayPlanqueue != null && minTodayPlanqueue.equals(minAuditPlanqueue)) {

				Object beforedayMaterialCode = getSession().createSQLQuery(getSQL("getBeforeDayPlanMaterialCode"))
						.setParameter("equip_code", line)
						.setParameter("productdate", cxlist.get(0).getProduction_date_s())//选择要审核的日期
						.setParameter("factory", LLWebUtils.factory()).uniqueResult();
				//如果之前日期最后一个日计划的物料编码为空，则证明这台机器是第一次生产，它生产的第一个产品需要第一次换工装
				if (beforedayMaterialCode == null) {
					changemouldplan = buildMoldChangePlan(cxlist.get(0));
					if (changemouldplan == null) {
						continue;
					} else if (!changemouldplanlist.contains(changemouldplan)) {
						changemouldplanlist.add(changemouldplan);
					}
				} else {
					System.out.println("上一次生产的最后一个计划的物料号是" + beforedayMaterialCode);
					Object minPlanqueueMaterialCode = createSQLQuery(getSQL("getMinPlanqueueNoMaterialCode"))
							.setParameter("equip_code", line)
							.setParameter("productdate", cxlist.get(0).getProduction_date_s())
							.setParameter("factory", LLWebUtils.factory()).uniqueResult();
					//如果日计划的最小生产序号物料编码不为空并且日计划的最小生产序号的物料编码与上一次生产的最后一个计划的物料编码不同，需要换工装
					if (minPlanqueueMaterialCode != null
							&& minPlanqueueMaterialCode.toString().indexOf(beforedayMaterialCode.toString()) == -1) {
						changemouldplan = buildMoldChangePlan(cxlist.get(0));
						if (changemouldplan == null) {
							continue;
						} else if (!changemouldplanlist.contains(changemouldplan)) {
							changemouldplanlist.add(changemouldplan);
						}
					}
				}
			}
		}
		if (changemouldplanlist == null || changemouldplanlist.size() == 0) {
			return;
		}
		// -----------保存换模计划----------------//
		changeMouldServiceSrv.save(changemouldplanlist);
	}

	/**
	 * 获取某产线的当前最小的序号 刘程明 2019年3月26日
	 * 
	 * @param equipcode
	 * @param productdate
	 * @return
	 */
	public Integer getMinPlanqueueNo(String equipcode, String productdate) {
		Object minPlanquere = getSession().createSQLQuery(getSQL("getMinPlanqueueNo"))
				.setParameter("equip_code", equipcode).setParameter("productdate", productdate)
				.setParameter("factory", LLWebUtils.factory()).uniqueResult();
		if (minPlanquere == null) {
			return null;
		}
		return Integer.parseInt(minPlanquere.toString());
	}

	/**
	 * 获取某机台输入顺序号号前一条序号的物料编码 刘程明 2019年3月26日
	 * 
	 * @param equipcode
	 * @param productdate
	 * @param currentplanqueue
	 * @return
	 */
	public String getBeforePlanMaterialCode(String equipcode, String productdate, String currentplanqueue) {
		Object beforeMaterialCode = getSession().createSQLQuery(getSQL("getBeforePlanMaterialCode"))
				.setParameter("equip_code", equipcode).setParameter("productdate", productdate)
				.setParameter("factory", LLWebUtils.factory()).setParameter("currentplanqueue_i", currentplanqueue)
				.uniqueResult();
		System.out.println(getSession().createSQLQuery(getSQL("getBeforePlanMaterialCode"))
		.setParameter("equip_code", equipcode).setParameter("productdate", productdate)
		.setParameter("factory", LLWebUtils.factory()).setParameter("currentplanqueue_i", currentplanqueue)
		.getQueryString().toString());
		if (beforeMaterialCode == null) {
			return null;
		}
		return beforeMaterialCode.toString();
	}

	/**
	 * 撤销日计划审核 刘程明 2019年3月12日
	 * 
	 * @param ids
	 * @throws Exception
	 */
	@RockWellTransactional
	public void cancelAudit(Long[] ids) throws Exception {
		List<Object> listCxProductionDayPlan=findByIds(ids);// 查出要撤销审核的计划
		Object ob = (Object) listCxProductionDayPlan;
		List<CxProductionDayPlan> list = (List<CxProductionDayPlan>)ob ;
		List<Map<String, Object>> monthlist = new ArrayList<>();
		for (CxProductionDayPlan cxdayplan : list) {
			if (!cxdayplan.getStatus_s().equals("152002")) {
				throw new Exception("计划状态不是未审核");
			}
			cxdayplan.setStatus_s("152001");
			cxdayplan.setAudit_by_s(null);
			cxdayplan.setAudit_time_t(null);
			cxdayplan.setChanged_by_s(LLWebUtils.getUser().userCode);
			cxdayplan.setChanged_time_t(new Date());

			// 通过胎胚物料编码和计划生产日期查出对应月计划，改变月计划状态为已保存（217002）。
			monthlist = searchSapProductionPlan(cxdayplan.getMaterial_code_s(), cxdayplan.getProduction_date_s());
			Integer count1 = getCuringDayPlanByPlannoMonth(monthlist.get(0).get("PLANNO_MONTH_S").toString());
			Integer count2 = getBuildingDayPlanByPlannoMonth(monthlist.get(0).get("PLANNO_MONTH_S").toString());
			if (count2 <= 1 && count1 == 0) {
				Map<String, Object> map1 = new HashMap<>();
				Map<String, Object> map2 = new HashMap<>();
				map1.put("planno_month_s", monthlist.get(0).get("PLANNO_MONTH_S"));
				map2.put("plan_status_s", "217002");
				sapProductionPlanServiceImpl.update(map1, map2);
			}
			// ------删除换工装计划--//
			delMouldChangePlanByCxPlan(cxdayplan);
			// ---------删除工单信息--------//
			delWorkOrderByCxPlan(cxdayplan);
			// ------撤销审核操作------//
			update(cxdayplan);
		}
	}

	/**
	 * 
	 * @Title: getDayPlanBySapPlan
	 * @Description: 获取月计划下对应的所有的日计划的数量(硫化)
	 * @param: @param sapplan 月计划
	 * @param: @return 日计划数量
	 * @return: 日计划数量
	 * @throws
	 */
	public Integer getCuringDayPlanByPlannoMonth(String plannoMonth) throws Exception {
		List<ProductionDayPlan> dayPlans = new ArrayList<ProductionDayPlan>();
		String sqlString = getSQL("getCuringDayPlanByPlannoMonth");
		SQLQuery query = createSQLQuery(sqlString);
		query.setParameter("plannoMonth", plannoMonth);
		dayPlans = query.list();
		return dayPlans.size();
	}

	/**
	 * 
	 * @Title: getDayPlanBySapPlan
	 * @Description: 获取月计划下对应的所有的日计划的数量(成型)
	 * @param: @param sapplan 月计划
	 * @param: @return 日计划数量
	 * @return: 日计划数量
	 * @throws
	 */
	public Integer getBuildingDayPlanByPlannoMonth(String plannoMonth) throws Exception {
		List<ProductionDayPlan> dayPlans = new ArrayList<ProductionDayPlan>();
		String sqlString = getSQL("getBuildingDayPlanByPlannoMonth");
		SQLQuery query = createSQLQuery(sqlString);
		query.setParameter("plannoMonth", plannoMonth);
		dayPlans = query.list();
		return dayPlans.size();
	}

	/**
	 * 删除换工装计划 刘程明 2019年3月14日
	 * 
	 * @param cxplan
	 */
	@RockWellTransactional
	public void delMouldChangePlanByCxPlan(CxProductionDayPlan cxdayplan) throws Exception {

		List<Object> deletechangemolgList = new ArrayList<Object>();
		Where where = new Where();
		where.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
		where.andEqual("s_factory_s", LLWebUtils.factory());
		where.andEqual("production_plan_no_s", cxdayplan.getPlan_no_s());
		deletechangemolgList = changeMouldServiceSrv.findByWhere(where);
		for (Object changemould : deletechangemolgList) {
			if(changemould instanceof ChangeMould){
				ChangeMould changeMould1=(ChangeMould)changemould;
				changeMould1.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
				changeMould1.setChanged_by_s(LLWebUtils.getUser().userCode);
				changeMould1.setChanged_time_t(new Date());
				if (changeMould1.getPlan_status_s().equals("170003")) {
					throw new Exception(changeMould1.getEquip_code_s() + ":" + changeMould1.getProduction_plan_no_s()
							+ "该计划下换工装计划:" + changeMould1.getPlan_no_s() + "状态不是未审核，不允许取消");
				}
			}
			
		}
		changeMouldServiceSrv.update(deletechangemolgList);
	}

	/**
	 * 删除工单信息 刘程明 2019年3月14日
	 */
	@RockWellTransactional
	public void delWorkOrderByCxPlan(CxProductionDayPlan cxdayplan) throws Exception {
		Where workorderWhere = new Where();
		workorderWhere.andEqual("PLAN_NO_S", cxdayplan.getPlan_no_s());
		workorderWhere.andEqual("RECORD_FLAG_S", "A");
		workorderWhere.andEqual("AGENC_NO_S", FactoryConstant.JING_MEN_CODE);
		List<Object> workderlist = workorderds.findByWhere(workorderWhere);
		for (Object workorderItem : workderlist) {
            if(workorderItem instanceof ClassPlan){
            	ClassPlan workorder=(ClassPlan) workorderItem;
            	if (workorder.getStatus_s().equals("169002")) {
    				throw new Exception("计划号：" + cxdayplan.getPlan_no_s() + "的:" + workorder.getOrder_code_s()
    						+ "工单已经执行，不允许取消审核");
    			}
    			workorder.setRecord_flag_s("D");
    			workorder.setChanged_by_s(LLWebUtils.getUser().userCode);
    			workorder.setChanged_time_t(new Date());
    			workorder.setClose_reason_s("因日计划:" + cxdayplan.getPlan_no_s() + "取消审核而关闭");
    			workorderds.update(workorder);
            }
           
		}
		
	}

	/**
	 * 向班次计划表插入数据 
	 * 时永良
     * 2019年3月11日
	 * 
	 * @param item
	 * @throws Exception
	 */
	@RockWellTransactional
	private void updateOtherTable(CxProductionDayPlan item) throws Exception {
		List<Object> addWorkOrderList = new ArrayList<>();
		// 更新班次计划表
		if (item.getPlanamount_mor_i() != null && item.getPlanamount_mor_i() > 0) {
			addWorkOrderList.add(insetDataToWorkOrder(item, "193001"));
		}
		if (item.getPlanamount_mid_i() != null && item.getPlanamount_mid_i() > 0) {
			addWorkOrderList.add(insetDataToWorkOrder(item, "193002"));
		}
		if (item.getPlanamount_nig_i() != null && item.getPlanamount_nig_i() > 0) {
			addWorkOrderList.add(insetDataToWorkOrder(item, "193003"));
		}
		// 工艺参数下发
		insertDataToMachineFormula(item);

		workorderds.save(addWorkOrderList);
	}

	/**
	 * 下发工艺参数至AT_B_QM_MACHINE_FORMULA表
	 * 
	 * @param item
	 *            日计划
	 * @throws Exception
	 * @author 时永良
	 * @date 2019年4月16日
	 */
	@RockWellTransactional
	private void insertDataToMachineFormula(CxProductionDayPlan item) throws Exception {

		List<Map<String,Object>> buildRecipeParaList = buildRecipeParaServiceImpl.getBuildingParaByProcessid(item);
		if (buildRecipeParaList == null) {
			throw new Exception("设备：" + item.getEquip_code_s() + "获取PLM设备类型代码失败，" + "请联系MES管理人员解决");
		}
		if (buildRecipeParaList.size() == 0) {
			throw new Exception("设备：" + item.getEquip_code_s() + "计划：" + item.getPlan_no_s() + "工艺参数未获取，请联系PLM人员解决");
		}
		List<Map<String,Object>> recipePara = new ArrayList<>();
		recipePara.addAll(buildRecipeParaList);
		List<Object> exitMachineFormulas = this.getMachineFormulaByCxplan(item);// 当前存在的参数表
		// 如果不存在，则保存；
		if (exitMachineFormulas == null) {
			System.out.println("进行保存操作，开始时间" + new Time());
			Machine_Formula machineformula = new Machine_Formula();
			for (Map<String,Object> para : buildRecipeParaList) {
				machineformula.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
				machineformula.setS_factory_s(LLWebUtils.factory());
				machineformula.setAgenc_no_s(LLConstant.JING_MEN_CODE);
				machineformula.setCreated_by_s(LLWebUtils.getUser().userCode);
				machineformula.setCreated_time_t(new Date());
				machineformula.setAlter_source_s("1");// 配方修改来源
				machineformula.setEquip_code_s(item.getEquip_code_s());
				machineformula.setEquip_type_s(item.getEquip_type_s());
				machineformula.setMaterial_code_s(item.getMaterial_code_s());
				machineformula.setMaterial_desc_s(item.getMaterial_desc_s());
				machineformula.setNew_flag_s("187001");
				if(para.get("PARMCODE_S")!=null){
					machineformula.setParameter_id_s(para.get("PARMCODE_S").toString());
				}
				if(para.get("VALUEMIN_S")!=null){
					machineformula.setParameter_lowervalue_s(para.get("VALUEMIN_S").toString());
				}
				if(para.get("PARMNAME_S")!=null){
					machineformula.setParameter_name_s(para.get("PARMNAME_S").toString());
				}
				if(para.get("LOGICALADDRESS_S")!=null){
					machineformula.setParameter_plcaddress_s(para.get("LOGICALADDRESS_S").toString());// 工艺参数PLC地址
				}
				// machineformula.setParameter_plcvalue_s(parameter_plcvalue_s);//工艺参数PLC值
				if(para.get("VALUEDATA")!=null){
					machineformula.setParameter_standardvalue_s(para.get("VALUEDATA").toString());
				}
				if(para.get("VALUEMAX_S")!=null){
					machineformula.setParameter_uppervalue_s(para.get("VALUEMAX_S").toString());
				}
				if(para.get("PARMTYPECODE_S")!=null){
					machineformula.setParmtype_code_s(para.get("PARMTYPECODE_S").toString());
				}
				if(para.get("PARMTYPENAME_S")!=null){
					machineformula.setParmtype_name_s(para.get("PARMTYPENAME_S").toString());
				}
				machineformula.setProcessbom_index_s(item.getProcessbom_index_s());
				machineformula.setProduction_step_s(item.getProduction_step_s());
				machineformula.setVersion_s(item.getVersion_s());
				machineformulaSrv.save(machineformula);
			}
			System.out.println("进行保存操作，结束时间" + new Time());
		} else {
			// 如果参数存在的话，再各自循环，判断参数id，更新
			List<Object> updateMachineFormulaList = new ArrayList<Object>();
			System.out.println("进行修改操作，开始时间" + new Time());
			for (Object exitFormula : exitMachineFormulas) {
				Machine_Formula formula=(Machine_Formula) exitFormula;
				for (Map<String,Object> para : buildRecipeParaList) {
					if(formula.getParameter_id_s()!=null){
						if (formula.getParameter_id_s().equals(para.get("PARMCODE_S"))) {

							if (formula.getParameter_standardvalue_s() != null && para.get("VALUEDATA") == null) {
								formula.setParameter_standardvalue_s(null);
								formula.setNew_flag_s("187002");
								updateMachineFormulaList.add(formula);
							}
							if (formula.getParameter_standardvalue_s() == null && para.get("VALUEDATA") != null) {
								formula.setParameter_standardvalue_s(para.get("VALUEDATA").toString());
								formula.setNew_flag_s("187002");
								updateMachineFormulaList.add(formula);
							}
							if (formula.getParameter_standardvalue_s() != null && para.get("VALUEDATA") != null) {
								if (!formula.getParameter_standardvalue_s().equals(para.get("VALUEDATA"))) {
									formula.setParameter_standardvalue_s(para.get("VALUEDATA").toString());
									formula.setNew_flag_s("187002");
									updateMachineFormulaList.add(formula);
								}
							}
							buildRecipeParaList.remove(para);
							break;
						}
					}
				}
			}
			if (updateMachineFormulaList.size() > 0) {
				machineformulaSrv.update(updateMachineFormulaList);;
			}
			System.out.println("进行修改操作，结束时间" + new Time());
		}
		// 插入履历表
		this.updateMachineFormulaRecord(recipePara, item);
	}

	/**
	 * 工艺参数保存到参数履历表
	 * 
	 * @param formulaList
	 * @throws Exception
	 * @author 刘程明
	 * @date 2019年4月16日
	 */
	private void updateMachineFormulaRecord(List<Map<String,Object>> buildRecipeParaList, CxProductionDayPlan item)
			throws Exception {
		FormulaRecord formulaRecord = new FormulaRecord();
		for (Map<String,Object> para : buildRecipeParaList) {
			formulaRecord.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
			formulaRecord.setAgenc_no_s(LLConstant.JING_MEN_CODE);
			formulaRecord.setS_factory_s(LLWebUtils.factory());
			formulaRecord.setCreated_by_s(LLWebUtils.getUser().userCode);
			formulaRecord.setCreated_time_t(new Date());
			formulaRecord.setAlter_source_s("1");// 设置配方修改来源
			formulaRecord.setEquip_code_s(item.getEquip_code_s());
			formulaRecord.setFormula_index_s(item.getProcessbom_index_s());// 工艺配方索引号
			// formulaRecord.setFormula_modify_index_s(formula_modify_index_s);//工艺修改记录索引
			formulaRecord.setMaterialcode_s(item.getMaterial_code_s());
			if(para.get("PARMCODE_S")!=null){
				formulaRecord.setParameter_id_s(para.get("PARMCODE_S").toString());
			}
			if(para.get("PARMNAME_S")!=null){
				formulaRecord.setParameter_name_s(para.get("PARMNAME_S").toString());
			}
			if(para.get("LOGICALADDRESS_S")!=null){
				formulaRecord.setParameter_plcaddress_s(para.get("LOGICALADDRESS_S").toString());// 下发参数PLC地址
			}
			// formulaRecord.setParameter_plcvalue_s(parameter_plcvalue_s);
			formulaRecord.setPlan_no_s(item.getPlan_no_s());
			formulaRecord.setProductlinecode_s(item.getEquip_code_s());
			formularecordSrv.save(formulaRecord);
		}
	};

	/**
	 * 根据成型计划得到该计划对应的工艺参数 刘程明 2019年3月31日
	 */
	@SuppressWarnings("unused")
	private List<Object> getMachineFormulaByCxplan(CxProductionDayPlan item) {
		Where where = new Where();
		where.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		where.andEqual("s_factory_s", LLWebUtils.factory());
		where.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
		where.andEqual("equip_code_s", item.getEquip_code_s());
		where.andEqual("equip_type_s", item.getEquip_type_s());
		where.andEqual("material_code_s", item.getMaterial_code_s());
		where.andEqual("production_step_s", item.getProduction_step_s());
		where.andEqual("version_s", item.getVersion_s());
		List<Object> exitMachineFormulas = machineformulaSrv.findByWhere(where);
		if (exitMachineFormulas.size() > 0 && exitMachineFormulas != null) {
			return exitMachineFormulas;
		}
		return null;
	}

	/**
	 * 向班次计划表中插入数据 
	 * 刘程明 
	 * 2019年3月11日
	 * @param item
	 * @param classid
	 * @throws Exception
	 */
	@RockWellTransactional
	private ClassPlan insetDataToWorkOrder(CxProductionDayPlan item, String classid) throws Exception {
		ClassPlan classplan = new ClassPlan();
		classplan.setAgenc_no_s(LLConstant.JING_MEN_CODE);
		classplan.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
		classplan.setCreated_by_s(LLWebUtils.getUser().userCode);
		classplan.setCreated_time_t(new Date());
		classplan.setS_factory_s(LLWebUtils.factory());

		// workorder.setClose_reason_s("");//关闭原因
		// workorder.setEnd_time_t();//结束时间
		classplan.setClass_id_s(classid);// 生产班次
		// workorder.setEquip_code_s(item.getProduction_line_s());//机台条码
		// Map<String, Object>
		// plineInfo=productlineds.getProductLineInfoByName(item.getProduction_line_s());
		// if(plineInfo==null){
		// throw new Exception("未查询到产线信息");
		// }
		// workorder.setEquip_type_s(plineInfo.get("MACHINETYPE").toString());//机台类型

		// workorder.setGroup_s("");//班组
		classplan.setMaterial_code_s(item.getMaterial_code_s());
		classplan.setMaterial_desc_s(item.getMaterial_desc_s());
		String classplanno = serialSrv.serial("BW" + item.getPlan_no_s(), 2, 1).get(0).toString();
		classplan.setOrder_code_s(classplanno);// 班次计划号
		/*
		 * String order=serialSrv.serial("0", 1, 1).get(0).toString(); int
		 * no=Integer.parseInt(order); workorder.setOrder_queue_i(no)
		 */;// 工单序号
		String planqueue = item.getPlan_queue_i().toString();// 日计划的顺序号
		String workorderqueue = classid.substring(classid.length() - 1, classid.length());
		classplan.setOrder_queue_i(Integer.parseInt(planqueue + workorderqueue));
		classplan.setPlan_no_s(item.getPlan_no_s());// 日计划号
		classplan.setProcessbom_index_s(item.getProcessbom_index_s());// 工艺配方索引
		// workorder.setProduction_date_s(item.getProduction_date_t().toString());//执行日期
		classplan.setEquip_code_s(item.getEquip_code_s()); // 机台条码
		// workorder.setEquip_type_s(item.getEquip_type_s());
		classplan.setProduction_date_s(item.getProduction_date_s());
		classplan.setProduction_step_s(item.getProduction_step_s());// 产品阶段
		if (classid.equals("193001")) {
			classplan.setQuantity_order_i(item.getPlanamount_mor_i());// 早班日计划量
		}
		if (classid.equals("193002")) {
			classplan.setQuantity_order_i(item.getPlanamount_mid_i());// 中班日计划量
		}
		if (classid.equals("193003")) {
			classplan.setQuantity_order_i(item.getPlanamount_nig_i());// 晚班日计划量
		}
		classplan.setQuantity_real_i(0);// 日完成量
		classplan.setSpecification_s(item.getSpecification_s());// 规格
		classplan.setStatus_s("169001");// 状态
		classplan.setVersion_s(item.getVersion_s());// 胎胚版本号
		return classplan;
	}

	/**
	 * 构造换工装信息表 刘程明 2019年3月13日
	 * 
	 * @param dailyPlan
	 *            日计划
	 * @return
	 * @throws Exception
	 */
	public ChangeMould buildMoldChangePlan(CxProductionDayPlan cxplan) throws Exception {

		Where where = new Where();
		where.andEqual("record_flag_s", "A");
		where.andEqual("s_factory_s", LLWebUtils.factory());
		where.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
		where.andEqual("plan_no_s", "BG" + cxplan.getPlan_no_s());
		if (changeMouldServiceSrv.findByWhere(where).size() > 0) {
			return null;
		}

		ChangeMould changemouldplan = new ChangeMould();
		changemouldplan.setCreated_by_s(LLWebUtils.getUser().userCode + "|" + cxplan.getPlan_no_s());
		changemouldplan.setCreated_time_t(new Date());
		changemouldplan.setS_factory_s(LLWebUtils.factory());
		changemouldplan.setAgenc_no_s(LLConstant.JING_MEN_CODE);
		changemouldplan.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
		changemouldplan.setProduction_plan_no_s(cxplan.getPlan_no_s());
		changemouldplan.setPlan_status_s("170001");// 默认换工装计划状态
		changemouldplan.setPlan_no_s("BG" + cxplan.getPlan_no_s());
		changemouldplan.setMaterial_spec_s(cxplan.getSpecification_s());// 规格
		changemouldplan.setMaterial_name_s(cxplan.getMaterial_desc_s());// 物料描述
		changemouldplan.setMaterial_code_s(cxplan.getMaterial_code_s());
		changemouldplan.setEquip_code_s(cxplan.getEquip_code_s());
		changemouldplan.setChangetime_s(cxplan.getProduction_date_s());// 换模日期
		changemouldplan.setPlan_queue_s(cxplan.getPlan_queue_i().toString());
		return changemouldplan;
	}

	/**
	 * 获取物料编码版本 刘程明 2019年3月15日
	 * 
	 * @param materialcode
	 *            物料编码
	 * @param productionstep
	 *            产品阶段 例:03
	 * @return
	 */
	public List<String> getMaterialVersionByCodeAndStep(String materialcode, String productionstep) {
		SQLQuery query = createSQLQuery(getSQL("getMaterialVersionByCodeAndStep"));
		query.setParameter("materialcode", materialcode);
		query.setParameter("productionstep", productionstep);
		return query.list();
	}

	/**
	 * 根据产线条码和日期查询当前日期下得日计划号 刘程明 2019年3月15日
	 * 
	 * @param equipCode
	 *            设备条码
	 * @param productDate
	 *            计划日期
	 * @return
	 */
	public List<String> searchDayplannoByEquipCodeAndPlanDate(String equipCode, String productDate) {
		SQLQuery query = createSQLQuery(getSQL("searchDayplannoByProductlineAndPlanDate"));
		query.setParameter("equipcode", equipCode);
		query.setParameter("productiondate", productDate);
		return query.list();
	}

	/**
	 * 获取成型工艺配方ID 刘程明 2019年3月15日
	 * 
	 * @param materialcode
	 * @param productionstep
	 * @param version
	 * @return
	 */
	public List<String> getPlmBuildingProcessID(String materialcode, String productionstep, String version) {
		SQLQuery query = createSQLQuery(getSQL("getPlmBuildingProcessID"));
		query.setParameter("materialcode", materialcode);
		//query.setParameter("productionstep", productionstep);
		query.setParameter("version", version);
		List<String> list = query.list();
		return query.list();
	}

	/**
	 * 获取成本收集器 刘程明 2019年3月15日
	 * 
	 * @param materialcode
	 *            物料编码
	 * @return
	 */
	public List<String> getCostcollector(String materialcode) {
		SQLQuery query = createSQLQuery(getSQL("getCostcollector"));
		query.setParameter("materialcode", materialcode);
		return query.list();
	}

	/**
	 * 选择物料编码后，根据产品阶段，带出成本收集器 刘程明 2019年3月15日
	 * 
	 * @param materialcode
	 *            物料编码
	 * @param productStep
	 *            产品阶段 03投产 02 试产 01 试制
	 * @return
	 */
	public List<String> getCostcollectorByMaterialAndStep(String materialcode, String productStep) {

		if (productStep.equals("01")) {
			productStep = "Z";// 试制
		} else if (productStep.equals("02")) {
			productStep = "C";// 试产
		} else {
			SQLQuery query = createSQLQuery(getSQL("getCostcollectorByMaterialAndStep2"));
			query.setParameter("materialcode", materialcode);
			return query.list();
		}
		SQLQuery query = createSQLQuery(getSQL("getCostcollectorByMaterialAndStep"));
		query.setParameter("materialcode", materialcode);
		query.setParameter("productStep", productStep);
		return query.list();
	}

	/**
	 * 从硫化月计划中查出月计划号，将之存入成型日计划表中 时永良 2019年8月1日08:01:26
	 * 
	 * @param cxPlan
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> monthlyPlanToCxProductionDayPlan(String materialCode, String productDate) {
		String month_i = productDate.substring(0, 6);// 月份，例201904
		SQLQuery query = createSQLQuery(getSQL("monthlyPlanToCxProductionDayPlan"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("month_i", month_i);
		query.setParameter("subitemsap_s", materialCode);
		query.setParameter("productDate", productDate);
		return query.list();
	}

	/**
	 * 从硫化月计划中查出月计划号，将之存入成型日计划表中 时永良 2019年8月1日08:01:26
	 * 
	 * @param cxPlan
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> searchSapProductionPlan(String materialCode, String productDate) {
		String month_i = productDate.substring(0, 6);// 月份，例201904
		SQLQuery query = createSQLQuery(getSQL("searchSapProductionPlan"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("month_i", month_i);
		query.setParameter("subitemsap_s", materialCode);
		query.setParameter("productDate", productDate);
		return query.list();
	}

	/**
	 * 从工单子项中（work_order_items）查出订单子项编号（order_item），将之存入成型日计划表中 时永良
	 * 2019年8月1日08:01:26
	 * 
	 * @param cxPlan
	 * @return
	 * @throws Exception
	 */
	public List<String> orderNumberToCxProductionDayPlan(String materialCode, String productDate) {
		SQLQuery query = createSQLQuery(getSQL("orderNumberToCxProductionDayPlan"));
		query.setParameter("subitemsap_s", materialCode);
		query.setParameter("productDate", productDate);
		List<String> list = query.list();
		return query.list();
	}

	// 获取-307基础数据
	public List<String> getProductionStepBaseData() {
		SQLQuery query = createSQLQuery(getSQL("getProductionStepBaseData"));
		return query.list();
	}

	// 获取328基础数据
	public List<String> getCustomerBaseData() {
		SQLQuery query = createSQLQuery(getSQL("getCustomerBaseData"));
		return query.list();
	}

	/**
	 * 获取无生产版本信息的物料编码列表 刘程明 2019年3月18日
	 * 
	 * @param cxPlanList
	 *            要验证的成型日计划列表
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> costNoProductionVerList(List<CxProductionDayPlan> cxPlanList) throws Exception {
		ArrayList<String> resultArrayList = new ArrayList<String>();
		for (CxProductionDayPlan item : cxPlanList) {
			if (!validtools.validMaterialOutDate(item.getMaterial_code_s())) {
				resultArrayList.add(item.getMaterial_code_s());
			}
		}

		return resultArrayList;

	}

	/**
	 * 获取失效物料的列表 刘程明 2019年3月18日
	 * 
	 * @param cxPlanList
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> costOutDateMaterialList(List<CxProductionDayPlan> cxPlanList) throws Exception {
		ArrayList<String> resultArrayList = new ArrayList<String>();
		for (CxProductionDayPlan item : cxPlanList) {
			if (!validtools.validProductionVerFromBomAndSAP(item.getMaterial_code_s(), item.getProductionver_s())) {
				resultArrayList.add(item.getMaterial_code_s());
			}
		}
		return resultArrayList;
	}

	/**
	 * 获取某机台某日期前一计划的顺序号 刘程明 2019年3月27日
	 * 
	 * @param currentplanqueue
	 * @param equipCode
	 * @param productDate
	 * @return
	 */
	public String getPlanqueueByAfterPlanqueue(String currentplanqueue, String equipCode, String productDate) {
		Object beforePlanqueue = getSession().createSQLQuery(getSQL("getPlanqueueByAfterPlanqueue"))
				.setParameter("productDate", productDate).setParameter("equipCode", equipCode)
				.setParameter("currentplanque", currentplanqueue).setParameter("factory", LLWebUtils.factory())
				.uniqueResult();
		if (beforePlanqueue == null) {
			return "0";
		}
		return beforePlanqueue.toString();
	}

	/**
	 * 获取日计划顺序号 刘程明 2019年3月31日
	 * 
	 * @param euipcode
	 * @param productdate
	 * @return
	 */
	public String getPlanqueue(String equipcode, String productdate) {
		Integer changeLength = 10;
		return serialSrv.machineOrderNumber(equipcode, productdate, changeLength);
	}

	/**
	 * 月计划更新或删除调用删除未开始的硫化日计划
	 * 
	 * @Title: updateDayPLan
	 * @Description: TODO(描述)
	 * @return: void 返回类型
	 * 
	 */
	public void updateDayPLan(CuringProductionMonthPlan plan) throws Exception {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("planno_month_s", plan.getPlanno_month_s());
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("record_flag_s", "D");
		update(map1, map2);
	}

	public List<Map<String, Object>> treelistQuery(String subitemsap_s,String productionStep) throws Exception {
		Filter filter = new Filter();
		filter.set("subitemsap_s", subitemsap_s);
		filter.set("productionStep", productionStep);
		String dataSql = getSQL("treelistQuery", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 成型日计划查询树状bom结构使用
	 * 
	 * @param list_map
	 *            查询条件集合
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> treelistQuery2(List<Map<String, Object>> list_map) throws Exception {
		Filter filter = new Filter();
		filter.set("subitemsap_s", list_map.get(0).get("subitemsap_s"));
		filter.set("bom_revision", list_map.get(1).get("bom_revision"));
		filter.set("part_number", list_map.get(2).get("part_number"));
		filter.set("part_revision", list_map.get(3).get("part_revision"));
		SQLQuery querys = createSQLQuery(getSQL("treelistQuery2", filter.getFilter()));
		if (!list_map.get(0).get("subitemsap_s").equals("")) {
			querys.setParameter("subitemsap_s", list_map.get(0).get("subitemsap_s").toString());
		}
		if (!list_map.get(1).get("bom_revision").equals("")) {
			querys.setParameter("bom_revision", list_map.get(1).get("bom_revision").toString());
		}
		if (!list_map.get(2).get("part_number").equals("")) {
			querys.setParameter("part_number", list_map.get(2).get("part_number").toString());
		}
		if (!list_map.get(3).get("part_revision").equals("")) {
			querys.setParameter("part_revision", list_map.get(3).get("part_revision").toString());
		}

		return querys.list();
	}
	
	
	/**
	 * 根据计划日期（月份）来查询出全部硫化月计划号
	 *  时永良 
	 *  2019年8月1日08:01:26
	 * @param cxPlan
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> searchPlanNoMonthByMonthPlan() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String month_i = sdf.format(date).substring(0, 6);// 月份，例201904
		SQLQuery query = createSQLQuery(getSQL("searchPlanNoMonthByMonthPlan"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("month_i", month_i);
		List<Map<String, Object>> res=query.list();
		return res;
	}
	
	/**
	 *  根据月计划号查出对应的工单子项（工单表的工单号等于月计划号）
	 *  时永良 
	 *  2019年8月1日08:01:26
	 * @param monthPlanNo 月计划号
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getOrderItenByMonthPlanNo(String monthPlanNo) {
		SQLQuery query = createSQLQuery(getSQL("getOrderItenByMonthPlanNo"));
		query.setParameter("monthPlanNo", monthPlanNo);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> res=query.list();
		return res;
	}
	
	/**
	 *  根据月计划号查出对应的物料编码
	 *  时永良 
	 *  2019年8月1日08:01:26
	 * @param monthPlanNo 月计划号
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getPartNumberByMonthPlanNo(String monthPlanNo) {
		SQLQuery query = createSQLQuery(getSQL("getPartNumberByMonthPlanNo"));
		query.setParameter("monthPlanNo", monthPlanNo);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> res=query.list();
		return res;
	}
	
	
	/**
	 *  主页面使用(根据胎胚物料编码带出唯一产品阶段、成本收集器、胎胚版本号，若有多个不带出)
	 *  时永良 
	 *  2019年8月1日08:01:26
	 * @param materialcode 胎胚物料编码
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> getProductionStepByMaterialcode(String materialcode) {
		SQLQuery query = createSQLQuery(getSQL("getProductionStepByMaterialcode"));
		query.setParameter("materialcode", materialcode);
		List<Map<String, Object>> res=query.list();
	    if(res.size()==1){
			for(Map<String, Object> str:res){
				str.put("judge","1");
			}
			return res;
		}
		else if(res.size()>1){
			for(Map<String, Object> str:res){
				str.put("judge","2");
			}
			return res;
		}
		return null;
	}
	
	
	/**
	 *  主页面使用(根据胎胚物料编码分别查询BOM和成本收集器，若无BOM则提示联系技术人员，若无成本收集器则提示联系财务人员)
	 *  时永良 
	 *  2019年8月1日08:01:26
	 * @param materialcode 胎胚物料编码
	 * @return
	 * @throws Exception
	 */
	public String getBOMorProductionverByMaterialcode(String materialcode) {
		SQLQuery query = createSQLQuery(getSQL("getBOMByMaterialcode"));
		query.setParameter("materialcode", materialcode);
		List<Map<String, Object>> res=query.list();
		SQLQuery query1 = createSQLQuery(getSQL("getProductionStepByMaterialcode"));
		query1.setParameter("materialcode", materialcode);
		List<Map<String, Object>> res1=query1.list();
		
        if(res.size()==0){
        	return "BOM为空";
        } 
        if(res1.size()==0){
        	return "成本收集器为空";
        }
		return null;
	}
}
