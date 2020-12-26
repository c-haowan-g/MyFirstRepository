/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.service.CxProductionDayPlanServiceImpl;
import com.bluebirdme.mes.linglong.common.service.CoreDictionaryServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringProductionMonthPlan;
import com.bluebirdme.mes.linglong.curing.entity.ProductionDayPlan;
import com.bluebirdme.mes.linglong.curing.entity.SapProductionPlan;
import com.bluebirdme.mes.linglong.curing.entity.dto.CuringProductionMonthPlanDTO;
import com.bluebirdme.mes.linglong.sap.service.PartsServiceImpl;
import com.datasweep.compatibility.client.Lot;
import com.datasweep.compatibility.client.Order;
import com.datasweep.compatibility.client.OrderItem;
import com.datasweep.compatibility.client.Part;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import freemarker.template.TemplateException;

/**
 * 硫化月计划编制(加工单)
 * 
 * @author penga_liu
 * 
 * @Date 2019年7月26日 上午11:33:27
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CuringProductionMonthPlanServiceImpl extends RockWellBaseServiceImpl<CuringProductionMonthPlan> {

	@Resource
	LingLongDataSource llds;
	@Resource
	CoreDictionaryServiceImpl cds;
	@Resource
	PartsServiceImpl impl;
	@Resource
	SerialServiceImpl ssi;
	@Resource
	ProductionDayPlanServiceImpl pdpSrv;
	@Resource
	SerialServiceImpl serialSrv;
	@Resource
	CxProductionDayPlanServiceImpl cxproductiondayplanSrv;

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return CuringProductionMonthPlan.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public void validRepeatMonthlyPlan(CuringProductionMonthPlan spp) throws Exception {

		String sql = getSQL("validMonthlyPlan");
		if (spp.getAtr_key() != null) {
			sql += " and atr_key<>" + spp.getAtr_key();
		}
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("code", spp.getMaterial_code_s()).setParameter("start", spp.getPlan_starttime_t())
				.setParameter("end", spp.getPlan_endtime_t()).setParameter("factory", LLWebUtils.factory())
				.setParameter("month", spp.getMonth_i());

		List<Object> plannoList = q.list();
		if (!ListUtils.isEmpty(plannoList)) {
			throw new Exception(LanguageProvider.getMessage("tip.conflict") + ":" + spp.getPlanno_month_s() + "<-->"
					+ GsonTools.toJson(plannoList));
		}

	}

	@RockWellTransactional
	public void saveChanges(CuringProductionMonthPlanDTO monthplan) throws Exception {
		// 删除记录
		if (!ListUtils.isEmpty(monthplan.getDeleted())) {
			for (CuringProductionMonthPlan plan : monthplan.getDeleted()) {
				if (plan.getPlan_status_s().equals("217003") || plan.getPlan_status_s().equals("217004")) {
					throw new Exception("月计划状态已下发或已关闭，不能删除！");
				} else {
					plan.setChanged_by_s(WebUtils.getUserName());
					plan.setChanged_time_t(new Date());
					plan.setRecord_flag_s("D");
					delWorkOrder(plan);// 删除工单
				}
			}
			update(monthplan.getDeleted());
		}

		// 新增记录
		if (!ListUtils.isEmpty(monthplan.getInserted())) {
			for (CuringProductionMonthPlan plan : monthplan.getInserted()) {
				plan.setS_factory_s(LLWebUtils.factory());
				plan.setCreated_by_s(WebUtils.getUserName());
				plan.setCreated_time_t(new Date());
				plan.setRecord_flag_s("A");
				plan.setPlan_status_s("217002");// 已保存
				validMaterial(plan.getMaterial_code_s());
				validRepeatMonthlyPlan(plan);
				BuildOrder(plan);// 创建工单
			}
			save(monthplan.getInserted());
		}

		// 更新记录
		if (!ListUtils.isEmpty(monthplan.getUpdated())) {
			for (CuringProductionMonthPlan plan : monthplan.getUpdated()) {
				// if (plan.getPlan_status_s().equals("217003") ||
				// plan.getPlan_status_s().equals("217004")) {
				// throw new Exception("月计划状态已下发或已关闭，不能修改！");
				// } else {
				plan.setChanged_by_s(WebUtils.getUserName());
				plan.setChanged_time_t(new Date());
				// plan.setPlan_status_s("217002");// 已保存
				validMaterial(plan.getMaterial_code_s());
				validRepeatMonthlyPlan(plan);
				updateWorkOrder(plan);// 修改工单数量
				// }

			}
			update(monthplan.getUpdated());
		}
	}

	/**
	 * 创建工单
	 * 
	 * @Title: BuildOrder
	 * @Description: TODO(描述)
	 * @return: void 返回类型
	 * 
	 */
	public void BuildOrder(CuringProductionMonthPlan plan) {

		Part part = null;
		// 生成工单
		Order order = null;
		order = getFunction().getWorkOrder(plan.getPlanno_month_s());
		if (order == null) {
			order = getFunction().createWorkOrder(plan.getPlanno_month_s());
		}
		List<OrderItem> itemList = new ArrayList<OrderItem>();
		OrderItem orderitem = null;
		// Map<String, Object> leftBOM = getBom(dayplan, "L");
		// Map<String, Object> rightBOM = getBom(dayplan, "R");
		// 计划数量
		if (plan.getQuantity_plan_f().intValue() > 0) {

			orderitem = getFunction().createOrderItem();

			orderitem.setOrderItem(serialSrv.serial("W" + plan.getPlanno_month_s(), 2, 1).get(0).toString());
			// orderitem.setPlannedProductionLine(dayplan.getProduction_line_s());
			// orderitem.setUDA("B", 1);// 工单类型
			orderitem.setUDA(plan.getS_factory_s(), 2);// 工厂(1全钢，2半钢)
			orderitem.setUDA(plan.getAgenc_no_s(), 3);// 机构代码
			if (plan.getS_factory_s().equals("2")) {
				orderitem.setPlannedRoute(".半钢工艺路线");
			} else {
				orderitem.setPlannedRoute(".全钢工艺路线");
			}

			part = getFunction().getPart(plan.getMaterial_code_s());
			orderitem.setQuantityOrdered(plan.getQuantity_plan_f());
			orderitem.setPartNumber(plan.getMaterial_code_s());
			orderitem.setPartRevision(part.getRevision());
			// orderitem.setBomName(leftBOM.get("BOM_NAME").toString());
			// orderitem.setBomRevision(leftBOM.get("BOM_REVISION").toString());

			orderitem.setPlannedStartTime(formatterTime(plan.getPlan_starttime_t()));
			orderitem.setPlannedFinishTime(formatterTime(plan.getPlan_endtime_t()));
			itemList.add(orderitem);
		}

		for (int i = 0; i < itemList.size(); i++) {
			order.addOrderItem(itemList.get(i));
			order.save();
			// 创建Lot=>unit
			Lot lot = getFunction().createLot("Lot_" + itemList.get(i).getOrderItem(), order);
			lot.setOrderItem(itemList.get(i).getOrderItem());
			// 生成unit改成扫描条码时逐条生成，不在此批量生成
			// lot.setQuantity(itemList.get(i).getQuantityOrdered());
			lot.setRouteName(itemList.get(i).getPlannedRoute());
			lot.save();

		}

	}

	// 删除工单及工单项
	public void delWorkOrder(CuringProductionMonthPlan plan) throws Exception {

		Order order = null;
		order = getFunction().getWorkOrder(plan.getPlanno_month_s());
		if (order != null) {
			Time orderTime = getFunction().createTime();

			order.remove(orderTime, "删除月计划，同时删除相应的工单");

			pdpSrv.updateDayPLan(plan);// 删除硫化日计划
			cxproductiondayplanSrv.updateDayPLan(plan);// 删除成型日计划

		}
	}

	// 修改工单数量
	public void updateWorkOrder(CuringProductionMonthPlan plan) throws Exception {
		Order order = null;
		order = getFunction().getWorkOrder(plan.getPlanno_month_s());

		if (order != null) {
			OrderItem orderitem = (OrderItem) order.getOrderItems().get(0);
			String oldPart = orderitem.getPartNumber();
			String newPart = plan.getMaterial_code_s();
			if (!oldPart.equals(newPart)) {// 修改了轮胎规格需要删除重新添加
				if (plan.getPlan_status_s().equals("217003") || plan.getPlan_status_s().equals("217004")) {
					throw new Exception("月计划状态已下发或已关闭，物料规格不能修改！");
				}
				delWorkOrder(plan);// 删除
				BuildOrder(plan);// 新增
				pdpSrv.updateDayPLan(plan);// 删除硫化日计划
				cxproductiondayplanSrv.updateDayPLan(plan);// 删除成型日计划
			} else {// 不修改轮胎规格只增加数量
				// 生成unit改成扫描条码时逐条生成，不在此批量生成
				// Lot lot = (Lot) order.getLots().get(0);
				// int Quantity_plan = plan.getQuantity_plan_f().intValue();
				// int before_quantity = lot.getQuantity();
				// int add_quantity = 0;
				// if (Quantity_plan > before_quantity) {
				// add_quantity = Quantity_plan - before_quantity;
				// lot.addUnits(add_quantity);
				// }
				// 修改现有工单计划数量或者计划时间段
				orderitem = (OrderItem) order.getOrderItems().get(0);
				orderitem.setQuantityOrdered(plan.getQuantity_plan_f());
				orderitem.setPlannedStartTime(formatterTime(plan.getPlan_starttime_t()));
				orderitem.setPlannedFinishTime(formatterTime(plan.getPlan_endtime_t()));
				order.addOrderItem(orderitem);
				order.save();
			}

		}

	}

	// 格式化时间，date装换time
	public Time formatterTime(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hours = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.HOUR_OF_DAY);
		int sec = c.get(Calendar.SECOND);
		Calendar calendar = new GregorianCalendar(year, month, day, hours, min, sec);
		Time time = new Time(calendar);
		return time;
	}

	/**
	 * 验证物料
	 * 
	 * @param code
	 * @throws Exception
	 */
	public void validMaterial(String code) throws Exception {
		// FIXME 成本收集器暂时不用，后期有数据再取消注释
		/*
		 * if(pdpSrv.costCollector(code)==null){ //无成本收集器 throw new
		 * Exception(msg("tip.noCostCollector")); }
		 */

		List<Map<String, Object>> greenTireInfo = pdpSrv.loadGreenTire(code);

		if (ListUtils.isEmpty(greenTireInfo)) {
			// 找不到胎胚信息
			throw new Exception(msg("tip.greenTireCodeNotFound"));
		}

		for (Map<String, Object> map : greenTireInfo) {
			if (map.get("processbom_index_build_s") == null) {
				throw new Exception(msg("成型工艺路线不存在！"));
			}
		}
		// 验证投产试制版本信息
		/*
		 * if (!validProductionVer(code)) { throw new Exception(code +
		 * "外胎无可使用的生产版本"); }
		 */

		for (Map<String, Object> map : greenTireInfo) {
			// 验证工艺

			if (pdpSrv.CuringProcIdByMonth(map.get("specification_left_s").toString().substring(0, 9)) == null) {
				throw new Exception(msg("tip.noCuringProcess"));
			}
			// 验证工艺
			if (ListUtils.isEmpty(pdpSrv.validCxProcId(map.get("specification_left_s").toString().substring(0, 9)))) {
				throw new Exception(msg("tip.noBuildingProcess"));
			}
			// 校验BOM
			if (!pdpSrv.validBom(code)) {
				throw new Exception(msg("tip.noAvailiableBom"));
			}
			// 校验物料是否失效
			if (pdpSrv.validDiscardMaterialCode(code)) {
				throw new Exception(code + ":" + msg("tip.codeoutdate"));
			}

		}
	}

	public String validMaterial2(String code) {
		List<String> messages = new ArrayList<String>();

		// FIXME 成本收集器暂时不用，后期有数据再取消注释
		/*
		 * if(pdpSrv.costCollector(code)==null){ //无成本收集器
		 * messages.add(msg("tip.noCostCollector")); }
		 */

		List<Map<String, Object>> greenTireInfo = pdpSrv.loadGreenTire(code);

		if (ListUtils.isEmpty(greenTireInfo)) {
			// 找不到胎胚信息
			messages.add(msg("tip.greenTireCodeNotFound"));
		}

		for (Map<String, Object> map : greenTireInfo) {
			// 验证工艺
			if (pdpSrv.CuringProcIdByMonth(map.get("specification_left_s").toString().substring(0, 9)) == null) {
				messages.add(msg("tip.noCuringProcess"));
			}
			// 验证工艺
			if (ListUtils.isEmpty(pdpSrv.validCxProcId(map.get("specification_left_s").toString().substring(0, 9)))) {
				messages.add(msg("tip.noBuildingProcess"));
			}
			// 校验BOM
			if (!pdpSrv.validBom(code)) {
				messages.add(code + ":" + msg("tip.noAvailiableBom"));
			}
			// 校验物料是否失效
			if (pdpSrv.validDiscardMaterialCode(code)) {
				messages.add(code + ":" + msg("tip.codeoutdate"));
			}

		}

		// 验证投产试制版本信息
		if (!validProductionVer(code)) {
			messages.add(code + "外胎无可使用的生产版本");
		}

		StringBuffer sb = new StringBuffer();
		for (String msg : messages) {
			sb.append(msg + " / ");
		}
		return sb.toString();
	}

	/**
	 * 当一个物料有多个生产版本号时，投产：03，试产：02，试制：01 a、
	 * 如果既有试制又有投产，则只需校验投产的生产版本号，并且只要有一个生产版本号即可通过校验， b、
	 * 如果只有投产，则只需校验投产的任意一个生产版本号，即可通过校验 c、 如果只有试制，则只需校验试制的任意一个生产版本号，即可通过校验
	 * 
	 * @param materialCode
	 *            物料编码
	 * @return true为存在，false为不存在
	 */
	public Boolean validProductionVer(String materialCode) {
		List<Map<String, Object>> costPLM = createSQLQuery(getSQL("costPLM")).setParameter("code", materialCode).list();
		if (costPLM.size() == 0) {
			return false;
		}
		List<String> prophaselist = new ArrayList<>();
		for (Map<String, Object> map : costPLM) {
			prophaselist.add((String) map.get("PROPHASE_S"));
		}

		for (Map<String, Object> map : costPLM) {
			prophaselist.add((String) map.get("PROPHASE_S"));
			String prophase = (String) map.get("PROPHASE_S");
			String productionver = (String) map.get("PRODUCTION_VER_S");
			// 无生产版本数据，有数据后删除return true并取消注释
			return true;
			/*
			 * if (validcost(materialCode, productionver)) { return true; } else
			 * { continue; }
			 */
		}

		return false;
	}

	/**
	 * 验证版本
	 * 
	 * @param materialCode
	 * @param productionver
	 * @return
	 */
	private Boolean validcost(String materialCode, String productionver) {
		int count = ((BigDecimal) getSession().createSQLQuery(getSQL("costSAP")).setParameter("code", materialCode)
				.setParameter("production_ver_s", productionver).uniqueResult()).intValue();
		return count > 0 ? true : false;
	}

	/**
	 * 根据品号获得规格
	 * 
	 * @param code
	 *            物料代码
	 * @return 物料规格
	 */
	public String getMaterielSpec(String code) {
		Part part = impl.getPartByCode(code);
		if (part != null) {
			return part.getDescription();
		}
		return "";
	}

	/**
	 * 根据代码获得数据字典
	 * 
	 * @param code
	 *            数据字典代码
	 * @return 字典描述
	 */
	public String getDictData(String code) {
		Map<String, Object> mp = cds.keyValuePair(code);
		return mp.get(code).toString();

	}

	/**
	 * 获取生产月计划编号
	 * 
	 * @return 最新的月计划编码
	 * @throws Exception
	 */
	public String getSAPProductionPlanNo() throws Exception {
		return ssi.serial("LHYJH");
	}

	/**
	 * BOM是否存在判断
	 * 
	 * @param materialCode
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@SuppressWarnings("unchecked")
	public boolean checkBOMisExist(String materialCode) throws TemplateException, IOException {
		boolean isExist = false;
		Filter filter = new Filter();
		filter.set("mastersap_s", materialCode);
		SQLQuery sql = createSQLQuery(getSQL("checkBOMisExistByCode", filter.getFilter()));
		sql.setParameter("mastersap_s", filter.get("mastersap_s"));
		List<Map<String, Object>> list = sql.list();
		if (list.size() > 0) {
			isExist = true;
		}
		return isExist;
	}

	/**
	 * 检查物料的工艺配方是否存在
	 * 
	 * @param materialCode
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public boolean checkCuringProcess(String materialCode) throws TemplateException, IOException {
		boolean isExist = false;
		Filter filter = new Filter();
		filter.set("mastersap_s", materialCode);
		SQLQuery sql = createSQLQuery(getSQL("checkCuringProcess", filter.getFilter()));
		sql.setParameter("mastersap_s", filter.get("mastersap_s"));
		List<Map<String, Object>> list = sql.list();
		if (list.size() > 0) {
			isExist = true;
		}
		return isExist;
	}

	/**
	 * 获得物料版本信息
	 * 
	 * @param materialCode
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getProductionVersion(String materialCode) throws TemplateException, IOException {
		Filter filter = new Filter();
		filter.set("material_code_s", materialCode);
		SQLQuery sql = createSQLQuery(getSQL("getProductionVersion", filter.getFilter()));
		sql.setParameter("material_code_s", filter.get("material_code_s"));
		List<Map<String, Object>> list = sql.list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	/**
	 * 检查计划结束日期是否在计划开始日期之后
	 * 
	 * @param planStart
	 * @param planEnd
	 * @return
	 */
	public boolean checkPlanDate(Date planStart, Date planEnd) {
		return (planEnd.getTime() > planStart.getTime());
	}

	/***
	 * 检查计划时间不要超过当月
	 * 
	 * @param planEnd
	 * @return
	 * @throws ParseException
	 */
	public boolean checkPlanDateInMonth(Date planEnd) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(planEnd);
		calendar.add(Calendar.MONTH, 1);
		Date date = sdf1.parse(sdf.format(calendar.getTime()) + "-01");
		return date.getTime() > planEnd.getTime();
	}

	/**
	 * 根据指定日期查询可用的物料编码
	 * 
	 * @param date
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getMaterialsByDate(String date, String materialCode) throws TemplateException,
			IOException {

		Filter filter = new Filter();
		filter.set("date", date);

		if (!StringUtils.isBlank(materialCode)) {
			filter.set("materialCode", materialCode);
		}

		String sql = getSQL("getMaterialsByDate", filter);

		SQLQuery query = createSQLQuery(sql);
		query.setParameter("date", date);
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("agenc_no_s", LLConstant.JING_MEN_CODE);

		if (!StringUtils.isBlank(materialCode)) {
			query.setParameter("materialCode", "%" + materialCode + "%");
		}

		return query.list();
	}

	/**
	 * 
	 * @Title: getByDayPlan
	 * @Description: 根据日计划获取该日计划对应的月计划
	 * @param: @param dayplan 日计划
	 * @param: @return 月季花
	 * @return: List<SapProductionPlan>
	 * @throws
	 */
	public List<SapProductionPlan> getByDayPlan(ProductionDayPlan dayplan) throws Exception {
		List<SapProductionPlan> resultList = new ArrayList<SapProductionPlan>();
		String sqlString = getSQL("getsapproductplanByDayPLan");
		SQLQuery query = createSQLQuery(sqlString, SapProductionPlan.class);
		query.setParameter("production_date", dayplan.getProduction_date_s());

		if (StringUtils.isNotEmpty(dayplan.getMaterial_desc_left_s())) {
			query.setParameter("material_desc", dayplan.getMaterial_desc_left_s());
		} else if (StringUtils.isNotEmpty(dayplan.getMaterial_desc_right_s())) {
			query.setParameter("material_desc", dayplan.getMaterial_desc_right_s());
		} else {
			query.setParameter("material_desc", "");
		}
		if (StringUtils.isNotEmpty(dayplan.getMaterial_code_left_s())) {
			query.setParameter("material_code", dayplan.getMaterial_code_left_s());
		} else if (StringUtils.isNotEmpty(dayplan.getMaterial_code_right_s())) {
			query.setParameter("material_code", dayplan.getMaterial_desc_right_s());
		} else {
			query.setParameter("material_code", "");
		}
		resultList = query.list();
		return resultList;
	}

	/**
	 * 根据日计划的物料编码，描述，时间，获取对应月计划实体，由于左右物料可能不一样，所以上面的方法是写的有问题的，后续人再改吧
	 * 
	 * @param dayplan
	 *            日计划实体
	 * @return 月计划集合
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SapProductionPlan> getSapPlanByDayPlan(ProductionDayPlan dayplan) throws Exception {
		List<SapProductionPlan> resultList = new ArrayList<SapProductionPlan>();
		String sqlString = getSQL("getsapproductplanByDayPLan2");
		SQLQuery queryLeft = createSQLQuery(sqlString, SapProductionPlan.class);
		queryLeft.setParameter("production_date", dayplan.getProduction_date_s());

		if (StringUtils.isNotEmpty(dayplan.getMaterial_code_left_s())) {
			queryLeft.setParameter("material_code", dayplan.getMaterial_code_left_s());
		} else {
			queryLeft.setParameter("material_code", "");
		}
		SQLQuery queryRight = createSQLQuery(sqlString, SapProductionPlan.class);
		queryRight.setParameter("production_date", dayplan.getProduction_date_s());

		if (StringUtils.isNotEmpty(dayplan.getMaterial_code_right_s())) {
			queryRight.setParameter("material_code", dayplan.getMaterial_code_right_s());
		} else {
			queryRight.setParameter("material_code", "");
		}
		resultList = queryLeft.list();
		resultList.addAll(queryRight.list());
		return resultList;
	}

	/**
	 * 通过月计划表的月份、物料到日计划表查询计划状态，决定月计划数量的修改状态
	 * 
	 * @Title: CheckDayPlan
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("unchecked")
	public int CheckDayPlan(String month_i, String material_code_s) throws Exception {
		BigDecimal rs = null;
		int mun = 0;
		rs = (BigDecimal) getSession().createSQLQuery(getSQL("CheckDayPlan")).setParameter("month_i", month_i)
				.setParameter("material_code_s", material_code_s).uniqueResult();
		if (rs.intValue() > 0) {
			mun = -1;
		} else {
			mun = 0;
		}
		return mun;
	}
	/**
	 * 获取当前工厂
	 */
}
