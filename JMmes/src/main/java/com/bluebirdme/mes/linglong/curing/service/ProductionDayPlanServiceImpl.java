/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.service.CxProductionDayPlanServiceImpl;
import com.bluebirdme.mes.linglong.common.service.CommonTools;
import com.bluebirdme.mes.linglong.common.service.CoreDictionaryServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringProductionMonthPlan;
import com.bluebirdme.mes.linglong.curing.entity.MoldChangePlan;
import com.bluebirdme.mes.linglong.curing.entity.PlanDayParameter;
import com.bluebirdme.mes.linglong.curing.entity.ProductionDayPlan;
import com.bluebirdme.mes.linglong.curing.entity.SapProductionPlan;
import com.bluebirdme.mes.linglong.curing.entity.dto.ProductionDayPlanDTO;
import com.bluebirdme.mes.linglong.sap.service.MaterialsPlusServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Lot;
import com.datasweep.compatibility.client.Operation;
import com.datasweep.compatibility.client.Order;
import com.datasweep.compatibility.client.OrderItem;
import com.datasweep.compatibility.client.Part;
import com.datasweep.compatibility.client.ProductionLine;
import com.datasweep.compatibility.client.Route;
import com.datasweep.compatibility.ui.Time;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 硫化生产日计划
 * 
 * @author 周清玉 刘朋
 * @Date 2019-07-16 14:34:18
 */
@Service
public class ProductionDayPlanServiceImpl extends RockWellBaseServiceImpl<ProductionDayPlan> {

	@Resource
	LingLongDataSource llds;

	@Resource
	CoreDictionaryServiceImpl dictSrv;

	@Resource
	PlmCuringProcessParameterServiceImpl cppSrv;

	@Resource
	PlanDayParameterServiceImpl pdpSrv;

	@Resource
	MoldChangePlanServiceImpl mcpSrv;

	@Resource
	SerialServiceImpl serialSrv;

	@Resource
	SapProductionPlanServiceImpl sapplanSrv;

	@Resource
	CuringProductionMonthPlanServiceImpl CuringProductionMonthPlan;
	@Resource
	CxProductionDayPlanServiceImpl CxProductionDayPlanServiceImpl;

	@Resource
	MachineControlServiceImpl machineControlServiceImpl;

	@Resource
	MaterialsPlusServiceImpl materialsPlusServiceImpl;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return ProductionDayPlan.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@Override
	@RockWellTransactional
	public void save(ProductionDayPlan plan) throws Exception {
		// 检测冲突

		Where w = new Where();

		List<ProductionDayPlan> list = null;
		// 2020 5/19 孙尊龙修改
		Filter f = new Filter();
		f.set("area_name", FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "C");
		f.set("p_line_name", plan.getProduction_line_s());
		List<Map<String, Object>> l = datagridRowsUDA(f);
		if (l.size() == 0) {
			throw new Exception(LanguageProvider.getMessage(plan.getProduction_line_s()
					+ "产线未维护设备机型(左右机台)，请到硫化产线设备信息维护页面维护！"));
		} else {
			if (l.get(0).get("isused_s") == null || l.get(1).get("isused_s") == null) {
				throw new Exception(LanguageProvider.getMessage(plan.getProduction_line_s()
						+ "产线未维护机台管控状态，请到硫化机台控制管理页面维护！"));
			}
		}

		// 先校验硫化参数是否相同
		String Specification_left_s = plan.getSpecification_left_s().substring(0, 9);// 胎胚编码左
		String Specification_right_s = plan.getSpecification_right_s().substring(0, 9);// 胎胚编码右
		// 硫化工艺路线
		String bomId1 = null;
		String bomId2 = null;

		if (LLWebUtils.factory().equals("2")) {
			// 如果是半钢的，那么半钢查询工艺路线的方式为 品号+阶段 取最新版
			bomId1 = CuringProcId2(Specification_left_s, plan.getProduction_step_left_s());
			bomId2 = CuringProcId2(Specification_right_s, plan.getProduction_step_right_s());
		} else {
			// 如果是全钢的，胎胚施工代码前七位+阶段 取最新版
			bomId1 = CuringProcId1(Specification_left_s, plan.getProduction_step_left_s());
			bomId2 = CuringProcId1(Specification_right_s, plan.getProduction_step_right_s());
		}
/*     
		if (!valid(bomId1, bomId2)) {
			throw new Exception(errorInfo(plan, "curingprocess.notuniform"));
		}
*/
		plan.setProcessbom_index_curing_s(bomId1);
		plan.setSpare10_s(bomId2);
		plan.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
		// 更新操作
		if (plan.getAtr_key() != null) {

			ProductionDayPlan db = findById(plan.getAtr_key());

			if (db == null) {
				throw new Exception(LanguageProvider.getMessage("tip.canNotUpdateNoneExistRecord"));
			}

			if (db.getRecord_flag_s().equals("D")) {
				throw new Exception(LanguageProvider.getMessage("tip.canNotUpdateDeletedData"));
			}

			/*
			 * w.andEqual("s_factory_s", LLWebUtils.factory());
			 * w.andEqual("agenc_no_s", LLConstant.LIU_ZHOU_CODE);
			 * w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
			 * w.andEqual("production_date_s", plan.getProduction_date_s());
			 * w.andEqual("production_line_s", plan.getProduction_line_s());
			 * w.andEqual("material_code_left_s",
			 * plan.getMaterial_code_left_s()); w.andNotEqual("atr_key",
			 * plan.getAtr_key());
			 * 
			 * list = findByWhere(w);
			 * 
			 * if (list.size() > 0) { throw new
			 * Exception(LanguageProvider.getMessage("tip.materialRepeat") + ":"
			 * + plan.getMaterial_code_left_s()); }
			 * 
			 * w.reset();
			 * 
			 * w.andEqual("s_factory_s", LLWebUtils.factory());
			 * w.andEqual("agenc_no_s", LLConstant.LIU_ZHOU_CODE);
			 * w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
			 * w.andEqual("production_date_s", plan.getProduction_date_s());
			 * w.andEqual("production_line_s", plan.getProduction_line_s());
			 * w.andEqual("material_code_right_s",
			 * plan.getMaterial_code_right_s()); w.andNotEqual("atr_key",
			 * plan.getAtr_key());
			 * 
			 * list = findByWhere(w); if (list.size() > 1) { throw new
			 * Exception(LanguageProvider.getMessage("tip.materialRepeat") + ":"
			 * + plan.getMaterial_code_right_s()); }
			 */

			Map<String, Object> left = getPlanCountNotMyself(plan.getAtr_key(), plan.getProduction_date_s(),
					plan.getMaterial_code_left_s());// 左物料月计划数量
			Map<String, Object> right = getPlanCountNotMyself(plan.getAtr_key(), plan.getProduction_date_s(),
					plan.getMaterial_code_right_s());// 右物料月计划数量
			if (left == null) {
				throw new Exception(msg("tip.notExistInMonthlyPlan") + plan.getMaterial_code_left_s());
			}

			if (right == null) {
				throw new Exception(msg("tip.notExistInMonthlyPlan") + plan.getMaterial_code_right_s());
			}

			if (plan.getMaterial_code_left_s().equals(plan.getMaterial_code_right_s())) {

				Integer allocate = plan.getQuantity_dayplan_left_i() + plan.getQuantity_dayplan_right_i();// 编制的计划中的左物料数量+右物料数量
				int max = ((BigDecimal) left.get("MAX")).intValue();// 月计划某物料总共的数量
				int allocated = ((BigDecimal) left.get("ALLOCATED")).intValue();// 日计划已经使用的数量

				if ((max - allocated) < allocate) {
					throw new Exception("机台：" + plan.getEquip_code_left_s()
							+ LanguageProvider.getMessage("tip.overstepMax") + ":" + (allocate - (max - allocated))
							+ "条");
				}

			} else {

				Integer allocate = plan.getQuantity_dayplan_left_i();// 左计划数量

				int max = ((BigDecimal) left.get("MAX")).intValue();
				int allocated = ((BigDecimal) left.get("ALLOCATED")).intValue();

				if ((max - allocated) < allocate) {
					throw new Exception("机台：" + plan.getEquip_code_left_s()
							+ LanguageProvider.getMessage("tip.overstepMax") + ":" + (allocate - (max - allocated))
							+ "条");
				}

				allocate = plan.getQuantity_dayplan_right_i();// 右计划数量

				max = ((BigDecimal) right.get("MAX")).intValue();
				allocated = ((BigDecimal) right.get("ALLOCATED")).intValue();

				if ((max - allocated) < allocate) {
					throw new Exception("机台：" + plan.getEquip_code_left_s()
							+ LanguageProvider.getMessage("tip.overstepMax") + ":" + (allocate - (max - allocated)));
				}
			}

			plan.setChanged_by_s(WebUtils.getUserName());
			plan.setChanged_time_t(new Date());
			plan.setSpecification_left_s(Specification_left_s);
			plan.setSpecification_right_s(Specification_right_s);
			// 保存硫化总时间到备用字段1
			plan.setSpare1_s(cppSrv.getCurringFullTimeParams(plan.getProcessbom_index_curing_s()));
			if (LLWebUtils.factory().equals("1")) {

				// 保存内径外径断面宽子口宽至备用
				List<Map<String, Object>> parasList = materialsPlusServiceImpl.getMaterialPlusParams(plan
						.getMaterial_code_left_s());
				if (parasList == null || parasList.size() == 0) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ msg("tip.materialExt"));
				}
				String innerdia = "";// 内径
				String outdia = "";// 外径
				String typewidth = "";// 断面宽
				String beadwidth = "";// 子口宽

				for (Map<String, Object> map : parasList) {
					innerdia = map.get("INNERDIA_D").toString();
					outdia = map.get("OUTERDIA_D").toString();
					typewidth = map.get("TYREWIDTH_D").toString();
					beadwidth = map.get("BEADWIDTH_D").toString();
				}

				if (innerdia.equals("0")) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ "内径不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护内径");
				}
				if (outdia.equals("0")) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ "外径不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护外径");
				}
				if (typewidth.equals("0")) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ "断面宽不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护断面宽");
				}
				if (beadwidth.equals("0")) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ "子口宽不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护子口宽");
				}

				plan.setSpare2_s(innerdia);// 设置内径
				plan.setSpare3_s(outdia);// 设置外径
				plan.setSpare4_s(typewidth);// 设置断面宽
				plan.setSpare5_s(beadwidth);// 子口宽
			}
			// 验证zuo生产版本在SAP中是否正常 如果不符合条件，则不允许保存
			if (!costCollector(plan.getMaterial_code_left_s(), plan.getChildbom_ver_left_s(),
					plan.getSpecification_left_s())) {
				throw new Exception("机台：" + plan.getEquip_code_left_s() + "物料编码：" + plan.getMaterial_code_left_s()
						+ "胎胚编码：" + plan.getChildbom_ver_left_s() + LanguageProvider.getMessage("tip.validmaterialcb"));
			}
			// 成本收集器版本(左)
			String leftproduction_ver_s = getSession().createSQLQuery(getSQL("costproductionver"))
					.setParameter("code", plan.getMaterial_code_left_s())
					.setParameter("subitemrevision_s", plan.getChildbom_ver_left_s())
					.setParameter("subitemsap_s", plan.getSpecification_left_s()).uniqueResult().toString();
			// 验证生产版本在SAP中是否正常 如果不符合条件，则不允许保存
			if (!costCollector(plan.getMaterial_code_right_s(), plan.getChildbom_ver_right_s(),
					plan.getSpecification_right_s())) {
				throw new Exception("机台：" + plan.getEquip_code_right_s() + "物料编码：" + plan.getMaterial_code_right_s()
						+ "胎胚编码：" + plan.getChildbom_ver_right_s() + LanguageProvider.getMessage("tip.validmaterialcb"));
			}
			// 成本收集器版本右
			String rightproduction_ver_s = getSession().createSQLQuery(getSQL("costproductionver"))
					.setParameter("code", plan.getMaterial_code_right_s())
					.setParameter("subitemrevision_s", plan.getChildbom_ver_right_s())
					.setParameter("subitemsap_s", plan.getSpecification_right_s()).uniqueResult().toString();
			plan.setProductionver_left_s(leftproduction_ver_s);
			plan.setProductionver_right_s(rightproduction_ver_s);

			// 验证左物料编码是否失效
			if (validDiscardMaterialCode(plan.getMaterial_code_left_s())) {
				throw new Exception("机台：" + plan.getEquip_code_left_s() + "   " + plan.getMaterial_code_left_s()
						+ msg("tip.codeoutdate"));
			}
			// 验证右物料编码是否失效
			if (validDiscardMaterialCode(plan.getMaterial_code_right_s())) {
				throw new Exception("机台：" + plan.getEquip_code_right_s() + "   " + plan.getMaterial_code_right_s()
						+ msg("tip.codeoutdate"));
			}
			// 将左物料月计划号和右物料月计划号分别保存到日计划表的planno_month和备用字段6
			List<SapProductionPlan> sapProductionPlans = new ArrayList<SapProductionPlan>();
			sapProductionPlans = sapplanSrv.getSapPlanByDayPlan(plan);
			if (sapProductionPlans.size() < 2) {
				throw new Exception(plan.getEquip_code_left_s() + "、" + plan.getEquip_code_right_s()
						+ "机台日计划绑定月计划号失败，请检查日计划品号与月计划品号是否对应");
			}
			plan.setPlanno_month_s(sapProductionPlans.get(0).getPlanno_month_s());
			plan.setSpare6_s(sapProductionPlans.get(1).getPlanno_month_s());

			// 校验bom
			if (!validBomDayplan(Specification_left_s, plan.getProduction_step_left_s(), plan.getMaterial_code_left_s())) {
				throw new Exception("机台：" + plan.getEquip_code_left_s() + "的" + plan.getMaterial_code_left_s() + ":"
						+ msg("tip.bomoutdate"));
			}
			if (!validBomDayplan(Specification_right_s, plan.getProduction_step_right_s(),
					plan.getMaterial_code_right_s())) {
				throw new Exception("机台：" + plan.getEquip_code_right_s() + "的" + plan.getMaterial_code_right_s() + ":"
						+ msg("tip.bomoutdate"));
			}
//左轮胎
			cppSrv.deleteParams(plan.getPlan_no_s());
			if (plan.getReason_midclass_left_s().equals("0")) {
				cppSrv.saveParams(plan.getS_factory_s(), plan.getPlan_no_s(), plan.getProcessbom_index_curing_s(),
						plan.getProcessbom_index_build_s(),plan.getMaterial_code_left_s(),0);
			} else if (plan.getReason_midclass_left_s().equals("1")) {
				cppSrv.saveTestParams(plan.getS_factory_s(), plan.getPlan_no_s(), plan.getProduction_date_s(),
						plan.getProduction_line_s(), plan.getMaterial_code_left_s(),0);
			}
//右轮胎
			
			if (plan.getReason_midclass_left_s().equals("0")) {
				cppSrv.saveParams(plan.getS_factory_s(), plan.getPlan_no_s(), plan.getSpare10_s(),
						plan.getSpare8_s(),plan.getMaterial_code_right_s(),1);
			} else if (plan.getReason_midclass_left_s().equals("1")) {
				cppSrv.saveTestParams(plan.getS_factory_s(), plan.getPlan_no_s(), plan.getProduction_date_s(),
						plan.getProduction_line_s(), plan.getMaterial_code_right_s(),1);
			}
			plan.setReason_midclass_left_s(null);
			update(plan);
		} else {
			// 保存操作
			plan.setCreated_by_s(WebUtils.getUserName());
			plan.setCreated_time_t(new Date());
			plan.setS_factory_s(LLWebUtils.factory());
			plan.setAgenc_no_s(LLConstant.JING_MEN_CODE);
			plan.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
			plan.setSpecification_left_s(Specification_left_s);
			plan.setSpecification_right_s(Specification_right_s);
			plan.setStatus_s("218001");

			/*
			 * w.andEqual("s_factory_s", LLWebUtils.factory());
			 * w.andEqual("agenc_no_s", LLConstant.LIU_ZHOU_CODE);
			 * w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
			 * w.andEqual("production_date_s", plan.getProduction_date_s());
			 * w.andEqual("production_line_s", plan.getProduction_line_s());
			 * w.andEqual("material_code_left_s",
			 * plan.getMaterial_code_left_s());
			 * 
			 * list = findByWhere(w);
			 * 
			 * if (list.size() > 0) { throw new
			 * Exception(LanguageProvider.getMessage("tip.materialRepeat") + ":"
			 * + plan.getMaterial_code_left_s()); }
			 * 
			 * w.reset(); w.andEqual("s_factory_s", LLWebUtils.factory());
			 * w.andEqual("agenc_no_s", LLConstant.LIU_ZHOU_CODE);
			 * w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
			 * w.andEqual("production_date_s", plan.getProduction_date_s());
			 * w.andEqual("production_line_s", plan.getProduction_line_s());
			 * w.andEqual("material_code_right_s",
			 * plan.getMaterial_code_right_s());
			 * 
			 * list = findByWhere(w); if (list.size() > 1) { throw new
			 * Exception(LanguageProvider.getMessage("tip.materialRepeat") + ":"
			 * + plan.getMaterial_code_right_s()); }
			 */

			Map<String, Object> left = getPlanCount(plan.getProduction_date_s(), plan.getMaterial_code_left_s());
			Map<String, Object> right = getPlanCount(plan.getProduction_date_s(), plan.getMaterial_code_right_s());

			if (left == null) {
				throw new Exception(msg("tip.notExistInMonthlyPlan") + plan.getMaterial_code_left_s());
			}

			if (right == null) {
				throw new Exception(msg("tip.notExistInMonthlyPlan") + plan.getMaterial_code_right_s());
			}

			if (plan.getMaterial_code_left_s().equals(plan.getMaterial_code_right_s())) {

				Integer allocate = plan.getQuantity_dayplan_left_i() + plan.getQuantity_dayplan_right_i();

				int max = ((BigDecimal) left.get("MAX")).intValue();
				int allocated = ((BigDecimal) left.get("ALLOCATED")).intValue();

				if ((max - allocated) < allocate) {
					throw new Exception("机台：" + plan.getEquip_code_left_s()
							+ LanguageProvider.getMessage("tip.overstepMax") + ":" + (allocate - (max - allocated))
							+ "条");
				}
			} else {

				Integer allocate = plan.getQuantity_dayplan_left_i();

				int max = ((BigDecimal) left.get("MAX")).intValue();
				int allocated = ((BigDecimal) left.get("ALLOCATED")).intValue();

				if ((max - allocated) < allocate) {
					throw new Exception("机台：" + plan.getEquip_code_left_s()
							+ LanguageProvider.getMessage("tip.overstepMax") + ":" + (allocate - (max - allocated))
							+ "条");
				}

				allocate = plan.getQuantity_dayplan_right_i();

				max = ((BigDecimal) right.get("MAX")).intValue();
				allocated = ((BigDecimal) right.get("ALLOCATED")).intValue();

				if ((max - allocated) < allocate) {
					throw new Exception("机台：" + plan.getEquip_code_left_s()
							+ LanguageProvider.getMessage("tip.overstepMax") + ":" + (allocate - (max - allocated))
							+ "条");
				}
			}

			plan.setCreated_by_s(WebUtils.getUserName());
			plan.setCreated_time_t(new Date());
			// 保存硫化总时间到备用字段1
			plan.setSpare1_s(cppSrv.getCurringFullTimeParams(plan.getProcessbom_index_curing_s()));
			if (LLWebUtils.factory().equals("1")) {
				// 保存内径外径断面宽子口宽至备用
				List<Map<String, Object>> parasList = materialsPlusServiceImpl.getMaterialPlusParams(plan
						.getMaterial_code_left_s());
				if (parasList == null || parasList.size() == 0) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ msg("tip.materialExt"));
				}
				String innerdia = "";// 内径
				String outdia = "";// 外径
				String typewidth = "";// 断面宽
				String beadwidth = "";// 子口宽

				for (Map<String, Object> map : parasList) {
					innerdia = map.get("INNERDIA_D").toString();
					outdia = map.get("OUTERDIA_D").toString();
					typewidth = map.get("TYREWIDTH_D").toString();
					beadwidth = map.get("BEADWIDTH_D").toString();
				}

				if (innerdia.equals("0")) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ "内径不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护内径");
				}
				if (outdia.equals("0")) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ "外径不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护外径");
				}
				if (typewidth.equals("0")) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ "断面宽不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护断面宽");
				}
				if (beadwidth.equals("0")) {
					throw new Exception("机台：" + plan.getProduction_line_s() + "物料：" + plan.getMaterial_code_left_s()
							+ "子口宽不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护子口宽");
				}

				plan.setSpare2_s(innerdia);// 设置内径
				plan.setSpare3_s(outdia);// 设置外径
				plan.setSpare4_s(typewidth);// 设置断面宽
				plan.setSpare5_s(beadwidth);// 子口宽
			}

			// 验证生产版本在SAP中是否正常 如果不符合条件，则不允许保存
			if (!costCollector(plan.getMaterial_code_left_s(), plan.getChildbom_ver_left_s(),
					plan.getSpecification_left_s())) {
				throw new Exception("机台：" + plan.getEquip_code_left_s() + "物料编码：" + plan.getMaterial_code_left_s()
						+ "胎胚编码：" + plan.getChildbom_ver_left_s() + LanguageProvider.getMessage("tip.validmaterialcb"));
			}
			// 成本收集器版本(左)
			String leftproduction_ver_s = getSession().createSQLQuery(getSQL("costproductionver"))
					.setParameter("code", plan.getMaterial_code_left_s())
					.setParameter("subitemrevision_s", plan.getChildbom_ver_left_s())
					.setParameter("subitemsap_s", plan.getSpecification_left_s()).uniqueResult().toString();
			// 验证生产版本在SAP中是否正常 如果不符合条件，则不允许保存
			if (!costCollector(plan.getMaterial_code_right_s(), plan.getChildbom_ver_right_s(),
					plan.getSpecification_right_s())) {
				throw new Exception("机台：" + plan.getEquip_code_right_s() + "物料编码：" + plan.getMaterial_code_right_s()
						+ "胎胚编码：" + plan.getChildbom_ver_right_s() + LanguageProvider.getMessage("tip.validmaterialcb"));
			}
			// 成本收集器版本右
			String rightproduction_ver_s = getSession().createSQLQuery(getSQL("costproductionver"))
					.setParameter("code", plan.getMaterial_code_right_s())
					.setParameter("subitemrevision_s", plan.getChildbom_ver_right_s())
					.setParameter("subitemsap_s", plan.getSpecification_right_s()).uniqueResult().toString();
			plan.setProductionver_left_s(leftproduction_ver_s);
			plan.setProductionver_right_s(rightproduction_ver_s);
			// 验证左物料编码是否失效
			if (validDiscardMaterialCode(plan.getMaterial_code_left_s())) {
				throw new Exception("机台：" + plan.getEquip_code_left_s() + "  " + plan.getMaterial_code_left_s()
						+ msg("tip.codeoutdate"));
			}
			// 验证右物料编码是否失效
			if (validDiscardMaterialCode(plan.getMaterial_code_right_s())) {
				throw new Exception("机台：" + plan.getEquip_code_right_s() + "  " + plan.getMaterial_code_right_s()
						+ msg("tip.codeoutdate"));
			}

			// 将左物料月计划号和右物料月计划号分别保存到日计划表的planno_month和备用字段6
			List<SapProductionPlan> sapProductionPlans = new ArrayList<SapProductionPlan>();
			sapProductionPlans = sapplanSrv.getSapPlanByDayPlan(plan);
			if (sapProductionPlans.size() < 2) {
				throw new Exception(plan.getEquip_code_left_s() + "、" + plan.getEquip_code_right_s()
						+ "机台日计划绑定月计划号失败，请检查日计划品号与月计划品号是否对应");

			}
			plan.setPlanno_month_s(sapProductionPlans.get(0).getPlanno_month_s());
			plan.setSpare6_s(sapProductionPlans.get(1).getPlanno_month_s());

			// 将左物料月工单号和右物料工单号分别保存到日计划表的left_order_number和right_order_number
			List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
			listmap = getWorkOrderByDayPlan(plan);
			if (listmap.size() < 2) {
				throw new Exception(plan.getEquip_code_left_s() + "、" + plan.getEquip_code_right_s()
						+ "机台日计划绑定工单号失败，请检查日计划品号与月工单品号是否对应");
			}
			plan.setLeft_order_number_s(listmap.get(0).get("ORDER_ITEM").toString());
			plan.setRight_order_number_s(listmap.get(1).get("ORDER_ITEM").toString());

			// 校验bom
			if (!validBomDayplan(Specification_left_s, plan.getProduction_step_left_s(), plan.getMaterial_code_left_s())) {
				throw new Exception("机台：" + plan.getEquip_code_left_s() + "的" + plan.getMaterial_code_left_s() + ":"
						+ msg("tip.bomoutdate"));
			}
			if (!validBomDayplan(Specification_right_s, plan.getProduction_step_right_s(),
					plan.getMaterial_code_right_s())) {
				throw new Exception("机台：" + plan.getEquip_code_right_s() + "的" + plan.getMaterial_code_right_s() + ":"
						+ msg("tip.bomoutdate"));
			}

			cppSrv.deleteParams(plan.getPlan_no_s());
			if (plan.getReason_midclass_left_s().equals("0")) {
				System.out.println("左");
				cppSrv.saveParams(plan.getS_factory_s(), plan.getPlan_no_s(), plan.getProcessbom_index_curing_s(),
						plan.getProcessbom_index_build_s(),plan.getMaterial_code_left_s(),0);
			} else if (plan.getReason_midclass_left_s().equals("1")) {
				cppSrv.saveTestParams(plan.getS_factory_s(), plan.getPlan_no_s(), plan.getProduction_date_s(),
						plan.getProduction_line_s(), plan.getMaterial_code_left_s(),0);
			}
//右轮胎
			
			if (plan.getReason_midclass_left_s().equals("0")) {
				System.out.println("右");
				cppSrv.saveParams(plan.getS_factory_s(), plan.getPlan_no_s(), plan.getSpare10_s(),
						plan.getSpare8_s(),plan.getMaterial_code_right_s(),1);
			} else if (plan.getReason_midclass_left_s().equals("1")) {
				cppSrv.saveTestParams(plan.getS_factory_s(), plan.getPlan_no_s(), plan.getProduction_date_s(),
						plan.getProduction_line_s(), plan.getMaterial_code_right_s(),1);
			}
			plan.setReason_midclass_left_s(null);
			super.save(plan);
		}
	}

	/**
	 * 根据产线，查询机台状态
	 */

	public List<Map<String, Object>> datagridRowsUDA(Filter filter) throws Exception {
		filter.set("area_name", FactoryConstant.JING_MEN_CODE + LLWebUtils.factory() + "C");
		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows2的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());

		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);

		setParameter(query, filter);

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
	 * 根据日计划的物料编码，时间，获取对应月工单，由于左右物料可能不一样，所以可能查询到左右两个工单
	 * 
	 * @Title: getWorkOrderByDayPlan
	 * @Description: TODO(描述)
	 * @return: List<SapProductionPlan> 返回类型
	 * 
	 */
	public List<Map<String, Object>> getWorkOrderByDayPlan(ProductionDayPlan dayplan) throws Exception {
		List<Map<String, Object>> Listmap = new ArrayList<Map<String, Object>>();

		String sqlString = getSQL("getWorkOrderByDayPlan");
		SQLQuery queryLeft = createSQLQuery(sqlString);
		queryLeft.setParameter("production_date", dayplan.getProduction_date_s());

		if (StringUtils.isNotEmpty(dayplan.getMaterial_code_left_s())) {
			queryLeft.setParameter("material_code", dayplan.getMaterial_code_left_s());
		} else {
			queryLeft.setParameter("material_code", "");
		}
		SQLQuery queryRight = createSQLQuery(sqlString);
		queryRight.setParameter("production_date", dayplan.getProduction_date_s());

		if (StringUtils.isNotEmpty(dayplan.getMaterial_code_right_s())) {
			queryRight.setParameter("material_code", dayplan.getMaterial_code_right_s());
		} else {
			queryRight.setParameter("material_code", "");
		}
		Listmap = queryLeft.list();
		Listmap.addAll(queryRight.list());
		return Listmap;
	}

	@RockWellTransactional
	public String saveChanges(ProductionDayPlanDTO dto) throws Exception {
		List<String> testParameterPlanList = dto.getTestParameterList();
		String fromDate = dto.getFromdate();
		String fromTomorrowDate = CommonTools.dayCalculation(fromDate, 1);
		Where w = new Where();
		w.andEqual("s_factory_s", LLWebUtils.factory());
		w.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
		w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		w.andEqual("production_date_s", dto.getInserted().get(0).getProduction_date_s());

		// if (super.findByWhere(w).size() > 0) {
		// throw new Exception(dto.getInserted().get(0).getProduction_date_s() +
		// msg("tip.hasCuringPlans"));
		// }

		// 这里只有新增，因为这里保存的是复制的内容
		// 1. 日计划量是否超出
		// 其他校验已在前端完成

		List<ProductionDayPlan> list = dto.getInserted();

		Map<String, Integer> codeAndCount = new HashMap<String, Integer>();
		Map<String, Integer> codeAndMaxCount = new HashMap<String, Integer>();

		Map<String, Object> planMaxCount = null;

		String bomId1 = null;
		String bomId2 = null;
		StringBuffer errorMsg = new StringBuffer();
		// 获取物料编码对应的计划量以及最大的可分配量
		for (ProductionDayPlan pdp : list) {

			// 获取bomid 工艺路线
			String Specification_left_s = pdp.getSpecification_left_s().substring(0, 9);
			String Specification_right_s = pdp.getSpecification_right_s().substring(0, 9);

			if (LLWebUtils.factory().equals("2")) {
				// 如果是半钢的，那么半钢查询工艺路线的方式为 品号+阶段 取最新版
				bomId1 = CuringProcId2(Specification_left_s, pdp.getProduction_step_left_s());
				bomId2 = CuringProcId2(Specification_right_s, pdp.getProduction_step_right_s());
			} else {
				// 如果是全钢的，胎胚施工代码前七位+阶段 取最新版
				bomId1 = CuringProcId1(Specification_left_s, pdp.getProduction_step_left_s());
				bomId2 = CuringProcId1(Specification_right_s, pdp.getProduction_step_right_s());
			}

			// 验证bom参数值和参数代码是否一致
			/*if (!valid(bomId1, bomId2)) {
				// throw new Exception(errorInfo(pdp,
				// "curingprocess.notuniform"));
				errorMsg.append("\r\n" + errorInfo(pdp, "curingprocess.notuniform"));
				continue;
			}
*/
			pdp.setProcessbom_index_curing_s(bomId1);
			pdp.setSpare10_s(bomId2);

			// left
			if (codeAndCount.get(pdp.getMaterial_code_left_s()) == null) {
				codeAndCount.put(pdp.getMaterial_code_left_s(), 0);
			}
			// right
			if (codeAndCount.get(pdp.getMaterial_code_right_s()) == null) {
				codeAndCount.put(pdp.getMaterial_code_right_s(), 0);
			}
			// 把物料编码和页面上的计划数量，放进codeAndCount map里面
			codeAndCount.put(pdp.getMaterial_code_left_s(),
					codeAndCount.get(pdp.getMaterial_code_left_s()) + pdp.getQuantity_dayplan_left_i());
			codeAndCount.put(pdp.getMaterial_code_right_s(),
					codeAndCount.get(pdp.getMaterial_code_right_s()) + pdp.getQuantity_dayplan_right_i());

			// 获取左物料编码本月的计划生产数量
			planMaxCount = getPlanCount(pdp.getProduction_date_s(), pdp.getMaterial_code_left_s());
			if (planMaxCount == null) {
				errorMsg.append("\r\n" + msg("tip.notExistInMonthlyPlan") + pdp.getMaterial_code_left_s());
				continue;
			}
			if (codeAndMaxCount.get(pdp.getMaterial_code_left_s()) == null) {
				codeAndMaxCount.put(pdp.getMaterial_code_left_s(), 0);
			}
			codeAndMaxCount.put(pdp.getMaterial_code_left_s(), ((BigDecimal) planMaxCount.get("LEFT")).intValue());

			// 获取右物料编码本月的计划生产数量
			planMaxCount = getPlanCount(pdp.getProduction_date_s(), pdp.getMaterial_code_right_s());
			if (planMaxCount == null) {
				errorMsg.append("\r\n" + msg("tip.notExistInMonthlyPlan") + pdp.getMaterial_code_right_s());
				continue;

			}
			if (codeAndMaxCount.get(pdp.getMaterial_code_right_s()) == null) {
				codeAndMaxCount.put(pdp.getMaterial_code_right_s(), 0);
			}
			codeAndMaxCount.put(pdp.getMaterial_code_right_s(), ((BigDecimal) planMaxCount.get("LEFT")).intValue());

			pdp.setCreated_by_s(WebUtils.getUserName());
			pdp.setCreated_time_t(new Date());
			pdp.setS_factory_s(LLWebUtils.factory());
			pdp.setAgenc_no_s(LLConstant.JING_MEN_CODE);
			pdp.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
			pdp.setStatus_s("218001");
			// 保存硫化总时间到备用字段1
			pdp.setSpare1_s(cppSrv.getCurringFullTimeParams(pdp.getProcessbom_index_curing_s()));
			if (LLWebUtils.factory().equals("1")) {
				// 保存内径外径断面宽子口宽至备用
				List<Map<String, Object>> parasList = materialsPlusServiceImpl.getMaterialPlusParams(pdp
						.getMaterial_code_left_s());
				if (parasList == null || parasList.size() == 0) {
					throw new Exception("机台：" + pdp.getProduction_line_s() + "物料：" + pdp.getMaterial_code_left_s()
							+ msg("tip.materialExt"));
				}
				String innerdia = "";// 内径
				String outdia = "";// 外径
				String typewidth = "";// 断面宽
				String beadwidth = "";// 子口宽

				for (Map<String, Object> map : parasList) {
					innerdia = map.get("INNERDIA_D").toString();
					outdia = map.get("OUTERDIA_D").toString();
					typewidth = map.get("TYREWIDTH_D").toString();
					beadwidth = map.get("BEADWIDTH_D").toString();
				}

				if (innerdia.equals("0")) {
					throw new Exception("机台：" + pdp.getProduction_line_s() + "物料：" + pdp.getMaterial_code_left_s()
							+ "内径不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护内径");
				}
				if (outdia.equals("0")) {
					throw new Exception("机台：" + pdp.getProduction_line_s() + "物料：" + pdp.getMaterial_code_left_s()
							+ "外径不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护外径");
				}
				if (typewidth.equals("0")) {
					throw new Exception("机台：" + pdp.getProduction_line_s() + "物料：" + pdp.getMaterial_code_left_s()
							+ "断面宽不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护断面宽");
				}
				if (beadwidth.equals("0")) {
					throw new Exception("机台：" + pdp.getProduction_line_s() + "物料：" + pdp.getMaterial_code_left_s()
							+ "子口宽不能为0，请到系统管理->基础数据查询->物料信息扩展页面维护子口宽");
				}

				pdp.setSpare2_s(innerdia);// 设置内径
				pdp.setSpare3_s(outdia);// 设置外径
				pdp.setSpare4_s(typewidth);// 设置断面宽
				pdp.setSpare5_s(beadwidth);// 子口宽
			}
			// 验证左物料生产版本在SAP中是否正常 如果不符合条件，则不允许保存
			if (!costCollector(pdp.getMaterial_code_left_s(), pdp.getChildbom_ver_left_s(), pdp
					.getSpecification_left_s().substring(0, 9))) {
				errorMsg.append("\r\n" + "机台：" + pdp.getEquip_code_left_s() + "物料编码：" + pdp.getMaterial_code_left_s()
						+ "胎胚编码：" + pdp.getChildbom_ver_left_s() + LanguageProvider.getMessage("tip.validmaterialcb"));
				continue;

			}
			// 成本收集器版本(左)
			String leftproduction_ver_s = getSession().createSQLQuery(getSQL("costproductionver"))
					.setParameter("code", pdp.getMaterial_code_left_s())
					.setParameter("subitemrevision_s", pdp.getChildbom_ver_left_s())
					.setParameter("subitemsap_s", pdp.getSpecification_left_s().substring(0, 9)).uniqueResult()
					.toString();
			// 验证右物料生产版本在SAP中是否正常 如果不符合条件，则不允许保存
			if (!costCollector(pdp.getMaterial_code_right_s(), pdp.getChildbom_ver_right_s(), pdp
					.getSpecification_right_s().substring(0, 9))) {
				errorMsg.append("\r\n" + "机台：" + pdp.getEquip_code_right_s() + "物料编码：" + pdp.getMaterial_code_right_s()
						+ "胎胚编码：" + pdp.getChildbom_ver_right_s() + LanguageProvider.getMessage("tip.validmaterialcb"));
				continue;

			}
			// 成本收集器版本右
			String rightproduction_ver_s = getSession().createSQLQuery(getSQL("costproductionver"))
					.setParameter("code", pdp.getMaterial_code_right_s())
					.setParameter("subitemrevision_s", pdp.getChildbom_ver_right_s())
					.setParameter("subitemsap_s", pdp.getSpecification_right_s().substring(0, 9)).uniqueResult()
					.toString();
			pdp.setProductionver_left_s(leftproduction_ver_s);
			pdp.setProductionver_right_s(rightproduction_ver_s);

			// 验证左物料编码是否失效
			if (validDiscardMaterialCode(pdp.getMaterial_code_left_s())) {
				errorMsg.append("\r\n" + "机台：" + pdp.getEquip_code_left_s() + "   " + pdp.getMaterial_code_left_s()
						+ msg("tip.codeoutdate"));
				continue;
			}
			// 验证右物料编码是否失效
			if (validDiscardMaterialCode(pdp.getMaterial_code_right_s())) {
				errorMsg.append("\r\n" + "机台：" + pdp.getEquip_code_right_s() + "   " + pdp.getMaterial_code_right_s()
						+ msg("tip.codeoutdate"));
				continue;
			}

			// 将左物料月计划号和右物料月计划号分别保存到日计划表的planno_month和备用字段6
			List<SapProductionPlan> sapProductionPlans = new ArrayList<SapProductionPlan>();
			sapProductionPlans = sapplanSrv.getSapPlanByDayPlan(pdp);
			if (sapProductionPlans.size() < 2) {
				errorMsg.append("\r\n" + pdp.getMaterial_code_left_s() + " " + pdp.getMaterial_desc_left_s()
						+ "该物料在月计划中查询不到，请检查月计划中物料描述是否发生变化");
				continue;
			}
			pdp.setPlanno_month_s(sapProductionPlans.get(0).getPlanno_month_s());
			pdp.setSpare6_s(sapProductionPlans.get(1).getPlanno_month_s());

			// 将左物料月工单号和右物料工单号分别保存到日计划表的left_order_number和right_order_number
			List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
			listmap = getWorkOrderByDayPlan(pdp);
			if (listmap.size() < 2) {
				throw new Exception(pdp.getEquip_code_left_s() + "、" + pdp.getEquip_code_right_s()
						+ "机台日计划绑定工单号失败，请检查日计划品号与月工单品号是否对应");

			}
			pdp.setLeft_order_number_s(listmap.get(0).get("ORDER_ITEM").toString());
			pdp.setRight_order_number_s(listmap.get(1).get("ORDER_ITEM").toString());
			pdp.setSpecification_left_s(pdp.getSpecification_left_s().substring(0, 9));
			pdp.setSpecification_right_s(pdp.getSpecification_right_s().substring(0, 9));
			pdp.setSpare9_s(null);// 清除执行时间
			// 校验bom
			if (!validBomDayplan(Specification_left_s, pdp.getProduction_step_left_s(), pdp.getMaterial_code_left_s())) {
				errorMsg.append("机台：" + pdp.getEquip_code_left_s() + "的" + pdp.getMaterial_code_left_s() + ":"
						+ msg("tip.bomoutdate"));
				continue;
			}
			if (!validBomDayplan(Specification_right_s, pdp.getProduction_step_right_s(),
					pdp.getMaterial_code_right_s())) {
				errorMsg.append("机台：" + pdp.getEquip_code_right_s() + "的" + pdp.getMaterial_code_right_s() + ":"
						+ msg("tip.bomoutdate"));
				continue;
			}
			cppSrv.deleteParams(pdp.getPlan_no_s());
//左编码
			if (testParameterPlanList.size() > 0 && testParameterPlanList.contains(pdp.getPlan_no_s())) {
				cppSrv.saveTestParams(pdp.getS_factory_s(), pdp.getPlan_no_s(), fromTomorrowDate,
						pdp.getProduction_line_s(), pdp.getMaterial_code_left_s(),0);

			} else {
				cppSrv.saveParams(pdp.getS_factory_s(), pdp.getPlan_no_s(), pdp.getProcessbom_index_curing_s(),
						pdp.getProcessbom_index_build_s(),pdp.getMaterial_code_left_s(),0);
			}
			//右编码
			if (testParameterPlanList.size() > 0 && testParameterPlanList.contains(pdp.getPlan_no_s())) {
				cppSrv.saveTestParams(pdp.getS_factory_s(), pdp.getPlan_no_s(), fromTomorrowDate,
						pdp.getProduction_line_s(), pdp.getMaterial_code_right_s(),1);

			} else {
				cppSrv.saveParams(pdp.getS_factory_s(), pdp.getPlan_no_s(), pdp.getSpare10_s(),
						pdp.getSpare8_s(),pdp.getMaterial_code_right_s(),1);
			}
		}

		for (String code : codeAndCount.keySet()) {
			// 如果超出可分配量，报错
			if (codeAndCount.get(code) > codeAndMaxCount.get(code)) {
				errorMsg.append("\r\n" + code + msg("tip.overstepMax"));
			}
		}

		if (errorMsg.length() > 0) {
			return errorMsg.toString();
		} else {
			RockWellUtils.save(list);
		}
		return "操作成功";
	}

	/**
	 * 查询成本收集器
	 * 
	 * @param code
	 *            成品胎物料编码
	 * @return true是有，false是没有
	 */
	public Boolean costCollector(String code, String masterrevision, String childcode) {
		try {
			String production_ver_s = null;
			String production_ver_s2 = null;
			if (LLWebUtils.factory().equals("1")) {
				// 增加校验bom带出成本收集器
				production_ver_s = getSession().createSQLQuery(getSQL("costproductionver")).setParameter("code", code)
						.setParameter("subitemrevision_s", masterrevision).setParameter("subitemsap_s", childcode)
						.uniqueResult().toString();
				production_ver_s2 = getSession().createSQLQuery(getSQL("cost")).setParameter("code", code)
						.setParameter("production_ver_s", production_ver_s).uniqueResult().toString();
			} else if (LLWebUtils.factory().equals("2")) {
				// 增加校验bom带出成本收集器
				production_ver_s = getSession().createSQLQuery(getSQL("costproductionver1")).setParameter("code", code)
						.setParameter("subitemrevision_s", masterrevision).setParameter("subitemsap_s", childcode)
						.uniqueResult().toString();
				production_ver_s2 = getSession().createSQLQuery(getSQL("cost1")).setParameter("code", code)
						.setParameter("production_ver_s", production_ver_s).uniqueResult().toString();

			}
			if (production_ver_s.isEmpty() || production_ver_s2.isEmpty()) {
				return false;
			}
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}

	}

	/**
	 * 根据成品胎编码查询胎胚信息
	 * 
	 * @param code
	 *            成品胎编码
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> loadGreenTire(String code) {

		List<Map<String, Object>> stages = greenTireStages(code);// 所属阶段、版本

		Map<String, Object> dict = dictSrv.keyValuePair("-307");
		for (Map<String, Object> map : stages) {
			String greenTireCode = (String) map.get("PART_NUMBER") + "(" + (String) map.get("PART_REVISION") + ")";
			String childgreenTireCode = (String) map.get("PART_NUMBER");// 子物料编码
			String version = (String) map.get("PART_REVISION");
			String stage = (String) map.get("PROPHASE_S");// 产品阶段
			String greenTireCodes = (String) map.get("PART_NUMBER");

			Object CuringProcId = null;
			if (LLWebUtils.factory().equals("2")) {
				// 如果是半钢的，那么半钢查询工艺路线的方式为 品号+阶段 取最新版
				CuringProcId = CuringProcId2(greenTireCodes, stage);
			} else {
				// 如果是全钢的，胎胚施工代码前七位+阶段 取最新版
				CuringProcId = CuringProcId1(greenTireCodes, stage);
			}
			Object cxProcId = validCxProcIdUnique(greenTireCodes, version, stage);

			map.clear();

			// map.put("productionver_left_s", costCollector(code));
			// map.put("productionver_right_s", costCollector(code));

			map.put("processbom_index_build_s", cxProcId);
			map.put("processbom_index_curing_s", CuringProcId);

			map.put("specification_left_s", greenTireCode);
			map.put("childspecification_left_s", childgreenTireCode);

			map.put("childbom_ver_left_s", version);
			map.put("production_step_left_s", stage);
			map.put("production_step_left_s_text", dict.get(stage));

			map.put("specification_right_s", greenTireCode);
			map.put("childspecification_right_s", childgreenTireCode);

			map.put("childbom_ver_right_s", version);
			map.put("production_step_right_s", stage);
			map.put("production_step_right_s_text", dict.get(stage));
		}

		return stages;
	}

	/**
	 * 查询胎胚编码和版本、阶段
	 * 
	 * @param code
	 *            成品胎编码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> greenTireStages(String code) {
		return createSQLQuery(getSQL("greenTire")).setParameter("code", code).list();
	}

	/**
	 * 半钢硫化工艺ID
	 * 
	 * @param greenTireCode
	 *            胎胚编码 stage 产品阶段
	 * @return
	 */
	public String CuringProcId2(String greenTireCode, String stage) {
		System.out.println("---greenTireCode" + greenTireCode + "---stage" + stage);
		return (String) getSession().createSQLQuery(getSQL("CuringProcId2")).setParameter("code", greenTireCode)
				.uniqueResult();
	}

	/**
	 * 全钢硫化工艺ID
	 * 
	 * @param greenTireCode
	 *            胎胚编码 stage 产品阶段
	 * 
	 * @return
	 */
	public String CuringProcId1(String greenTireCode, String stage) {

		// 根据外胎编码查询胎胚施工代码
		String pdmmat = (String) getSession().createSQLQuery(getSQL("findByCoverTyre"))
				.setParameter("greenTireCode", greenTireCode).uniqueResult();

		String CuringProcId = null;

		if (pdmmat != null) {
			System.out.println("---greenTireCode" + greenTireCode + "pdmmat" + pdmmat + "---stage" + stage);
			CuringProcId = (String) getSession().createSQLQuery(getSQL("CuringProcId1")).setParameter("pdmmat", pdmmat)
					.uniqueResult();
			/*
			 * 刘朋2020/1/16 去除产品阶段，PLM告知不同产品阶段的工艺实际是一样的，使用时，以最新的产品阶段为主
			 * .setParameter("stage", stage)
			 */
		}
		return CuringProcId;
	}

	/**
	 * 硫化工艺ID(月计划)
	 * 
	 * @param greenTireCode
	 *            胎胚编码
	 * @return
	 */
	public String CuringProcIdByMonth(String greenTireCode) {
		List list = getSession().createSQLQuery(getSQL("CuringProcIdByMonth")).setParameter("code", greenTireCode)
				.list();
		if (list != null && list.size() != 0) {
			return (String) list.get(0);
		}
		return null;
	}

	/**
	 * 校验bom
	 * 
	 * @param code
	 *            物料编码
	 * @return
	 */
	public boolean validBom(String code) {
		/*
		 * String factory[];
		 * if(LLWebUtils.factory().equals(LLConstant.BAN_GANG)){ factory=new
		 * String[]{"G1","G3"}; }else{ factory=new String[]{"G2"}; }
		 */
		// .setParameterList("factory", factory)
		int count = ((BigDecimal) getSession().createSQLQuery(getSQL("validBom")).setParameter("code", code)
				.uniqueResult()).intValue();
		return count > 0 ? true : false;
	}

	/**
	 * 校验bom是否失效
	 * 
	 * @param masterrevision
	 * @param subitemsap
	 * @param prophase
	 * @param replacebom
	 * @param werk
	 * @param factory
	 * @param code
	 * @return true：没失效，false：失效
	 */
	public boolean validBomDayplan(String subitemsap, String prophase, String code) {
		String factory = "";
		int count = 0;
		if (LLWebUtils.factory().equals("1")) {
			factory = "H2";
			count = ((BigDecimal) getSession().createSQLQuery(getSQL("validBomDayplan"))
					.setParameter("subitemsap", subitemsap).setParameter("prophase", prophase)
					.setParameter("werk", FactoryConstant.JING_MEN_CODE).setParameter("factory", factory)
					.setParameter("code", code).uniqueResult()).intValue();
		} else if (LLWebUtils.factory().equals("2")) {
			// 半钢王婧琳确认外胎BOM不区分一次法二次发版本 20200428
			// factory = "H1";
			count = ((BigDecimal) getSession().createSQLQuery(getSQL("validBomDayplan_bg"))
					.setParameter("subitemsap", subitemsap).setParameter("prophase", prophase)
					.setParameter("werk", FactoryConstant.JING_MEN_CODE).setParameter("code", code).uniqueResult())
					.intValue();
		}

		/*
		 * 备用 select count(1) from at_int_plm_bom t where t.record_flag_s = 'A'
		 * and (t.expireddate_s is null or t.expireddate_s > to_char(sysdate,
		 * 'yyyyMMddHH24miss')) and t.masterrevision_s='A' and
		 * t.subitemsap_s='302082043' and t.prophase_s='03' and
		 * t.replacebom_s='04' and t.werks_s='8003' and t.factory_s='G1' and
		 * t.mastersap_s = '221008789'
		 */

		return count > 0 ? true : false;
	}

	/**
	 * 校验物料是否被废止
	 * 
	 * @param materialcode
	 * @return true是被废止，false是没有被废止
	 */
	public boolean validDiscardMaterialCode(String materialcode) {
		int count = ((BigDecimal) getSession().createSQLQuery(getSQL("validDiscardMaterialCode"))
				.setParameter("materialcode", materialcode).uniqueResult()).intValue();
		return count > 0 ? true : false;
	}

	/**
	 * 成型工艺ID
	 * 
	 * @param greenTireCode
	 *            胎胚编码
	 * @param version
	 *            版本
	 * @param stage
	 *            阶段
	 * @return
	 */
	public Object cxProcId(String greenTireCode, String version, String stage) {
		return getSession().createSQLQuery(getSQL("cxProcId")).setParameter("code", greenTireCode)
				.setParameter("stage", stage).setParameter("version", version).uniqueResult();
	}

	public List validCxProcId(String greenTireCode) {
		return getSession().createSQLQuery(getSQL("validCxProcId")).setParameter("greenTireCode", greenTireCode).list();
	}

	/**
	 * 获取唯一成型数据
	 * 
	 * @param greenTireCode
	 * @return
	 */
	public Object validCxProcIdUnique(String greenTireCode, String version, String stage) {
		List list = getSession().createSQLQuery(getSQL("validCxProcIdUnique"))
				.setParameter("greenTireCode", greenTireCode).list();
		if (list == null || list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 校验工艺参数是否一致
	 * 
	 * @param bomId1
	 * @param bomId2
	 * @return
	 */
	public Boolean valid(String bomId1, String bomId2) {
		if (bomId1 == null || bomId2 == null) {
			return false;
		}
		List<Map<String, Object>> codes = createSQLQuery(getSQL("validBomParamCode")).setParameter("id1", bomId1)
				.setParameter("id2", bomId2).list();
		List<Map<String, Object>> value = createSQLQuery(getSQL("validBomParamValue")).setParameter("id1", bomId1)
				.setParameter("id2", bomId2).list();
		return codes.size() == 1 && value.size() == 1;
	}

	/**
	 * 获取计划数量
	 * 
	 * @param date
	 * @param code
	 * @return
	 */
	public Map<String, Object> getPlanCount(String date, String code) {
		return (Map<String, Object>) createSQLQuery(getSQL("getPlanCount")).setParameter("date", date)
				.setParameter("code", code).setParameter("s_factory_s", LLWebUtils.factory()).uniqueResult();
	}

	/**
	 * 获取计划数量,排除自己，更新的时候用
	 * 
	 * @param date
	 * @param code
	 * @return
	 */
	public Map<String, Object> getPlanCountNotMyself(Long atr_key, String date, String code) {
		return (Map<String, Object>) createSQLQuery(getSQL("getPlanCountNotMyself")).setParameter("atr_key", atr_key)
				.setParameter("date", date).setParameter("code", code)
				.setParameter("s_factory_s", LLWebUtils.factory()).uniqueResult();
	}

	/**
	 * 根据产线查询昨日最后生产的计划信息
	 * 
	 * @param date
	 * @param lineCode
	 * @return
	 * @throws Exception
	 */
	public ProductionDayPlan getYesterdayFinalPlanByLine(String date, String lineCode) throws Exception {
		ProductionDayPlan pdp = (ProductionDayPlan) createSQLQuery(getSQL("getYesterdayFinalPlanByLine"),
				ProductionDayPlan.class).setParameter("date", date).setParameter("lineCode", lineCode).uniqueResult();
		return pdp;
	}

	/**
	 * 撤销日计划的审核,同时删除对应的换模计划
	 * 
	 * @param ids
	 * @throws Exception
	 */
	public void cancelAudit(Long[] ids) throws Exception {

		List<ProductionDayPlan> list = findByIds(ids);

		List<MoldChangePlan> mcpList = new ArrayList<MoldChangePlan>();

		for (ProductionDayPlan p : list) {
			if (!p.getStatus_s().equals("218002")) {
				throw new Exception(errorInfo(p, "tip.canNotCancelAudit"));
			}
			p.setApproval_time_s(null);
			p.setApprover_s(null);
			p.setStatus_s("218001");

			mcpList.addAll(mcpSrv.findByField("plan_no_s", p.getPlan_no_s()));

			/* Change BY zhoujie 添加取消日假话审核后，相应月计划的状态随之改变的逻辑 */
			List<SapProductionPlan> listsapPlans = sapplanSrv.getByDayPlan(p);
			if (listsapPlans != null && listsapPlans.size() > 0) {
				SapProductionPlan sapPlan = (SapProductionPlan) listsapPlans.get(0);
				Integer count1 = getDayPlanBySapPlan(sapPlan);// 获取月计划下对应的所有的硫化日计划的数量
				Integer count2 = CxProductionDayPlanServiceImpl.getBuildingDayPlanByPlannoMonth(sapPlan
						.getPlanno_month_s());// 获取月计划下对应的所有的成型日计划的数量
				if (count1 <= 1 && count2 == 0) {
					sapplanSrv.update(sapPlan.getAtr_key(), "plan_status_s", "217002");
				}
			}

			// 取消审核删除工单
			// delWorkOrder(p);

		}

		for (MoldChangePlan mcp : mcpList) {
			mcp.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
			if (!mcp.getPlan_status_s().equals("219001")) {
				throw new Exception(mcp.getPlan_no_s() + msg("tip.canNotCancelAudit"));
			}
		}

		update(list);

		mcpSrv.update(mcpList);

	}

	// 删除工单及工单项
	public void delWorkOrder(ProductionDayPlan plan) {
		Order order = null;
		order = getFunction().getWorkOrder(plan.getPlan_no_s());
		if (order != null) {
			Time orderTime = getFunction().createTime();
			order.remove(orderTime, "撤销审核删除工单！");
		}

	}

	/**
	 * 
	 * @Title: getDayPlanBySapPlan
	 * @Description: 获取月计划下对应的所有的日计划的数量
	 * @param: @param sapplan 月计划
	 * @param: @return 日计划数量
	 * @return: 日计划数量
	 * @throws
	 */
	private Integer getDayPlanBySapPlan(SapProductionPlan sapplan) throws Exception {
		List<ProductionDayPlan> dayPlans = new ArrayList<ProductionDayPlan>();
		String sqlString = getSQL("getDayPlanBySapProductionPlan");
		SQLQuery query = createSQLQuery(sqlString, ProductionDayPlan.class);
		query.setParameter("material_code", sapplan.getMaterial_code_s());
		query.setParameter("material_name", sapplan.getMaterial_name_s());
		DateFormat fomateDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		query.setParameter("starttime", fomateDateFormat.format(sapplan.getPlan_starttime_t()));
		query.setParameter("endtime", fomateDateFormat.format(sapplan.getPlan_endtime_t()));
		dayPlans = query.list();
		return dayPlans.size();
	}

	/**
	 * 计划审核，审核完成后，根据条件生成换模计划
	 * 
	 * @param ids
	 *            日计划ID数组
	 * @throws Exception
	 */
	@RockWellTransactional
	public void audit(Long[] ids) throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 根据前端审核的ID，查询出所有的日计划
		List<ProductionDayPlan> list = findByIds(ids);
		// 将计划按产线分组
		Map<String, List<ProductionDayPlan>> plansGroupByMachine = new HashMap<String, List<ProductionDayPlan>>();
		for (ProductionDayPlan plan : list) {
			if (!plan.getStatus_s().equals("218001")) {
				throw new Exception(errorInfo(plan, "tip.audited"));
			}
			plan.setStatus_s("218002");
			plan.setApproval_time_s(format2.format(new Date()));
			plan.setApprover_s(LLWebUtils.getUserName());
			if (!plansGroupByMachine.containsKey(plan.getProduction_line_s())) {
				plansGroupByMachine.put(plan.getProduction_line_s(), new ArrayList<ProductionDayPlan>());
			}
			plansGroupByMachine.get(plan.getProduction_line_s()).add(plan);

			/* Change by zhoujie 日计划状态为已审核后，月计划 的状态随从 217002 已保存 变为 217003 已下发 * */
			List<SapProductionPlan> sapProductionPlans = new ArrayList<SapProductionPlan>();
			sapProductionPlans = sapplanSrv.getByDayPlan(plan);
			if (null != sapProductionPlans && sapProductionPlans.size() > 0) {
				SapProductionPlan sapPlan = (SapProductionPlan) sapProductionPlans.get(0);
				if (sapPlan.getPlan_status_s().equals("217002")) {
					sapplanSrv.update(sapPlan.getAtr_key(), "plan_status_s", "217003");
				}
			}

			// // 日计划量大于0，根据日计划生成工单
			// if (plan.getQuantity_dayplan_left_i() > 0 ||
			// plan.getQuantity_dayplan_right_i() > 0) {
			// BuildOrder(plan);
			// }

		}

		// 校验同一个产线的计划顺序号是否有跳号的行为
		for (String line : plansGroupByMachine.keySet()) {
			int order = 0;
			for (ProductionDayPlan plan : plansGroupByMachine.get(line)) {
				if (order == 0) {
					order = Integer.parseInt(plan.getPlan_queue_s());
				} else {
					// 不连续的顺序号
					if (order + 1 != Integer.parseInt(plan.getPlan_queue_s())) {
						throw new Exception("[顺序号不连续] 产线:" + plan.getProduction_line_s() + ",顺序号:[" + order + ","
								+ Integer.parseInt(plan.getPlan_queue_s()) + "]");
					} else {
						order++;
					}
				}
			}
		}
		Calendar cal = Calendar.getInstance();

		// 上一个产线计划
		PlanDayParameter pdp = null;

		// 换模计划列表
		List<MoldChangePlan> mcpList = new ArrayList<MoldChangePlan>();

		// 换模计划
		MoldChangePlan mcp;

		// 分组的日计划
		List<ProductionDayPlan> groupPlans;

		// 按照产线生成换模计划
		for (String line : plansGroupByMachine.keySet()) {

			groupPlans = plansGroupByMachine.get(line);

			for (int i = 0; i < groupPlans.size(); i++) {

				// 构造一个换模计划
				mcp = buildMoldChangePlan(groupPlans.get(i));
				/*
				 * if (i == 0) { //如果顺序号是1，查询昨日产线的最后一条日计划 if
				 * (groupPlans.get(i).getPlan_queue_s().equals("1")) {
				 * 
				 * cal.set(Integer.parseInt(groupPlans.get(i).getProduction_date_s
				 * ().substring(0, 4)),
				 * Integer.parseInt(groupPlans.get(i).getProduction_date_s
				 * ().substring(4, 6))-1,
				 * Integer.parseInt(groupPlans.get(i).getProduction_date_s
				 * ().substring(6, 8))); cal.add(Calendar.DAY_OF_MONTH, -1); //
				 * 获取昨日产线的最后一条计划 previousLineFinalPlan =
				 * getYesterdayFinalPlanByLine(format.format(cal.getTime()),
				 * groupPlans.get(i).getProduction_line_s()); } else { Where w =
				 * new Where(); w.andEqual("production_date_s",
				 * groupPlans.get(i).getProduction_date_s());
				 * w.andEqual("production_line_s", line);
				 * w.andEqual("plan_queue_s",
				 * (Integer.parseInt(groupPlans.get(i).getPlan_queue_s()) - 1) +
				 * ""); w.andEqual("record_flag_s",
				 * LLConstant.Record_Flag.AVAILIABLE); previousLineFinalPlan =
				 * unique(w); } } else { previousLineFinalPlan =
				 * groupPlans.get(i - 1); }
				 */

				// 查询机台最近的日计划
				Where w = new Where();
				w.andEqual("production_line_s", line);
				String plno = machineControlServiceImpl.searchplannoByProductLine(line);
				// 查machinecontrol获取日计划信息获取日计划号
				if (!StringHelper.isNullOrEmpty(plno)) {
					// w.andEqual("status_s", "218003");
					w.andEqual("plan_no_s", plno);
					w.andEqual("record_flag_s", "A");
					pdp = (PlanDayParameter) pdpSrv.unique(w);
				} else {
					// 如果machinecontrol无日计划信息，直接查日计划表
					List<Map<String, Object>> dayplanlist = querylastdayplan(line);
					if (dayplanlist.size() != 0) {
						w.andEqual("record_flag_s", "A");
						w.andEqual("plan_no_s", dayplanlist.get(0).get("plan_no_s").toString());
						pdp = (PlanDayParameter) pdpSrv.unique(w);
					} else {
						pdp = null;
					}
				}

				// 当前正在执行的计划
				if (pdp == null) {
					mcpList.add(mcp);
				} else {
					/*
					 * if (pcp.getStatus_s().equals("218001")) { throw new
					 * Exception("前一个日计划未审核通过"); }
					 */
					// 左模和当前执行的计划左右模同物料规格，则不需要换左模
					if (groupPlans.get(i).getMaterial_code_left_s().equals(pdp.getMaterial_code_left_s())
							|| groupPlans.get(i).getMaterial_code_left_s().equals(pdp.getMaterial_code_right_s())) {
						mcp.setFlowercode_left_s(null);
						mcp.setMaterial_code_left_s(null);
						mcp.setMaterial_name_left_s(null);
						mcp.setSpeccode_left_s(null);
					}

					// 右模和当前执行的计划左右模同物料规格，则不需要换右模
					if (groupPlans.get(i).getMaterial_code_right_s().equals(pdp.getMaterial_code_left_s())
							|| groupPlans.get(i).getMaterial_code_right_s().equals(pdp.getMaterial_code_right_s())) {
						mcp.setFlowercode_right_s(null);
						mcp.setMaterial_code_right_s(null);
						mcp.setMaterial_name_right_s(null);
						mcp.setSpeccode_right_s(null);
					}
					if (mcp.getMaterial_code_left_s() == null && mcp.getMaterial_code_right_s() == null) {
						continue;
					}
					mcpList.add(mcp);
				}
			}
		}
		update(list);

		mcpSrv.save(mcpList);

	}

	public IFunctionsEx getFunction() {
		return PCContext.getFunctions();
	}

	/**
	 * 创建工单
	 * 
	 * @Title: BuildOrder
	 * @Description: TODO(描述)
	 * @return: void 返回类型
	 * 
	 */
	public void BuildOrder(ProductionDayPlan dayplan) {
		// 给route添加step（因为PLM拉取的route数据不包含step）
		Operation operation = null;
		Route route = getFunction().getRoute(dayplan.getProcessbom_index_curing_s());
		operation = getFunction().getOperation("252006");
		if (operation == null) {
			operation = getFunction().createOperation("252006");
			operation.save();
		}
		ProductionLine productionline = getFunction().getProductionLineByName(dayplan.getProduction_line_s() + "L");
		ProductionLine productionline2 = getFunction().getProductionLineByName(dayplan.getProduction_line_s() + "R");
		route.addStep(operation);// 添加step
		route.addProductionLine(productionline);
		route.addProductionLine(productionline2);

		route.save();
		Part part = null;
		// 生成工单
		Order order = null;
		order = getFunction().getWorkOrder(dayplan.getPlan_no_s());
		if (order == null) {
			order = getFunction().createWorkOrder(dayplan.getPlan_no_s());
		}
		List<OrderItem> itemList = new ArrayList<OrderItem>();
		OrderItem orderitem = null;
		Map<String, Object> leftBOM = getBom(dayplan, "L");
		Map<String, Object> rightBOM = getBom(dayplan, "R");
		// 早班左
		if (dayplan.getPlanamount_mor_left_i() > 0) {

			orderitem = getFunction().createOrderItem();

			orderitem.setOrderItem(serialSrv.serial("CW" + dayplan.getPlan_no_s(), 2, 1).get(0).toString());
			orderitem.setPlannedProductionLine(dayplan.getProduction_line_s());
			orderitem.setUDA("C", 1);// 工单类型
			orderitem.setUDA(dayplan.getS_factory_s(), 2);// 工厂(1全钢，2半钢)
			orderitem.setUDA(dayplan.getAgenc_no_s(), 3);// 机构代码
			orderitem.setPlannedRoute(dayplan.getProcessbom_index_curing_s());

			part = getFunction().getPart(dayplan.getMaterial_code_left_s());
			orderitem.setQuantityOrdered(dayplan.getPlanamount_mor_left_i());
			orderitem.setPartNumber(dayplan.getMaterial_code_left_s());
			orderitem.setPartRevision(part.getRevision());
			orderitem.setBomName(leftBOM.get("BOM_NAME").toString());
			orderitem.setBomRevision(leftBOM.get("BOM_REVISION").toString());
			orderitem.setUDA("早班左", 0);
			orderitem.setPlannedStartTime(returnTime(8));
			orderitem.setPlannedFinishTime(returnTime(16));
			itemList.add(orderitem);
		}
		// 早班右
		if (dayplan.getPlanamount_mor_right_i() > 0) {
			orderitem = getFunction().createOrderItem();
			orderitem.setOrderItem(serialSrv.serial("CW" + dayplan.getPlan_no_s(), 2, 1).get(0).toString());
			orderitem.setPlannedProductionLine(dayplan.getProduction_line_s());
			orderitem.setUDA("C", 1);// 工单类型
			orderitem.setUDA(dayplan.getS_factory_s(), 2);// 工厂(1全钢，2半钢)
			orderitem.setUDA(dayplan.getAgenc_no_s(), 3);// 机构代码
			orderitem.setPlannedRoute(dayplan.getProcessbom_index_curing_s());

			part = getFunction().getPart(dayplan.getMaterial_code_right_s());
			orderitem.setQuantityOrdered(dayplan.getPlanamount_mor_right_i());
			orderitem.setPartNumber(dayplan.getMaterial_code_right_s());
			orderitem.setPartRevision(part.getRevision());
			orderitem.setBomName(rightBOM.get("BOM_NAME").toString());
			orderitem.setBomRevision(rightBOM.get("BOM_REVISION").toString());
			orderitem.setUDA("早班右", 0);
			orderitem.setPlannedStartTime(returnTime(8));
			orderitem.setPlannedFinishTime(returnTime(16));
			itemList.add(orderitem);
		}
		// 中班左
		if (dayplan.getPlanamount_mid_left_i() > 0) {
			orderitem = getFunction().createOrderItem();
			orderitem.setOrderItem(serialSrv.serial("CW" + dayplan.getPlan_no_s(), 2, 1).get(0).toString());
			orderitem.setPlannedProductionLine(dayplan.getProduction_line_s());
			orderitem.setUDA("C", 1);// 工单类型
			orderitem.setUDA(dayplan.getS_factory_s(), 2);// 工厂(1全钢，2半钢)
			orderitem.setUDA(dayplan.getAgenc_no_s(), 3);// 机构代码
			orderitem.setPlannedRoute(dayplan.getProcessbom_index_curing_s());

			part = getFunction().getPart(dayplan.getMaterial_code_left_s());
			orderitem.setQuantityOrdered(dayplan.getPlanamount_mid_left_i());
			orderitem.setPartNumber(dayplan.getMaterial_code_left_s());
			orderitem.setPartRevision(part.getRevision());
			orderitem.setBomName(leftBOM.get("BOM_NAME").toString());
			orderitem.setBomRevision(leftBOM.get("BOM_REVISION").toString());
			orderitem.setUDA("中班左", 0);
			orderitem.setPlannedStartTime(returnTime(16));
			orderitem.setPlannedFinishTime(returnTime(24));
			itemList.add(orderitem);
		}
		// 中班右
		if (dayplan.getPlanamount_mid_right_i() > 0) {
			orderitem = getFunction().createOrderItem();
			orderitem.setOrderItem(serialSrv.serial("CW" + dayplan.getPlan_no_s(), 2, 1).get(0).toString());
			orderitem.setPlannedProductionLine(dayplan.getProduction_line_s());
			orderitem.setUDA("C", 1);// 工单类型
			orderitem.setUDA(dayplan.getS_factory_s(), 2);// 工厂(1全钢，2半钢)
			orderitem.setUDA(dayplan.getAgenc_no_s(), 3);// 机构代码
			orderitem.setPlannedRoute(dayplan.getProcessbom_index_curing_s());

			part = getFunction().getPart(dayplan.getMaterial_code_right_s());
			orderitem.setQuantityOrdered(dayplan.getPlanamount_mid_right_i());
			orderitem.setPartNumber(dayplan.getMaterial_code_right_s());
			orderitem.setPartRevision(part.getRevision());
			orderitem.setBomName(rightBOM.get("BOM_NAME").toString());
			orderitem.setBomRevision(rightBOM.get("BOM_REVISION").toString());
			orderitem.setUDA("中班右", 0);
			orderitem.setPlannedStartTime(returnTime(16));
			orderitem.setPlannedFinishTime(returnTime(24));
			itemList.add(orderitem);
		}
		// 晚班左
		if (dayplan.getPlanamount_nig_left_i() > 0) {
			orderitem = getFunction().createOrderItem();
			orderitem.setOrderItem(serialSrv.serial("CW" + dayplan.getPlan_no_s(), 2, 1).get(0).toString());
			orderitem.setPlannedProductionLine(dayplan.getProduction_line_s());
			orderitem.setUDA("C", 1);// 工单类型
			orderitem.setUDA(dayplan.getS_factory_s(), 2);// 工厂(1全钢，2半钢)
			orderitem.setUDA(dayplan.getAgenc_no_s(), 3);// 机构代码
			orderitem.setPlannedRoute(dayplan.getProcessbom_index_curing_s());

			part = getFunction().getPart(dayplan.getMaterial_code_left_s());
			orderitem.setQuantityOrdered(dayplan.getPlanamount_nig_left_i());
			orderitem.setPartNumber(dayplan.getMaterial_code_left_s());
			orderitem.setPartRevision(part.getRevision());
			orderitem.setBomName(leftBOM.get("BOM_NAME").toString());
			orderitem.setBomRevision(leftBOM.get("BOM_REVISION").toString());
			orderitem.setUDA("晚班左", 0);
			orderitem.setPlannedStartTime(returnTime(0));
			orderitem.setPlannedFinishTime(returnTime(8));
			itemList.add(orderitem);
		}
		// 晚班右
		if (dayplan.getPlanamount_nig_right_i() > 0) {
			orderitem = getFunction().createOrderItem();
			orderitem.setOrderItem(serialSrv.serial("CW" + dayplan.getPlan_no_s(), 2, 1).get(0).toString());
			orderitem.setPlannedProductionLine(dayplan.getProduction_line_s());
			orderitem.setUDA("C", 1);// 工单类型
			orderitem.setUDA(dayplan.getS_factory_s(), 2);// 工厂(1全钢，2半钢)
			orderitem.setUDA(dayplan.getAgenc_no_s(), 3);// 机构代码
			orderitem.setPlannedRoute(dayplan.getProcessbom_index_curing_s());

			part = getFunction().getPart(dayplan.getMaterial_code_right_s());
			orderitem.setQuantityOrdered(dayplan.getPlanamount_nig_right_i());
			orderitem.setPartNumber(dayplan.getMaterial_code_right_s());
			orderitem.setPartRevision(part.getRevision());
			orderitem.setBomName(rightBOM.get("BOM_NAME").toString());
			orderitem.setBomRevision(rightBOM.get("BOM_REVISION").toString());
			orderitem.setUDA("晚班右", 0);
			orderitem.setPlannedStartTime(returnTime(0));
			orderitem.setPlannedFinishTime(returnTime(8));
			itemList.add(orderitem);
		}
		for (int i = 0; i < itemList.size(); i++) {
			order.addOrderItem(itemList.get(i));
			order.save();
			// 创建Lot=>unit
			Lot lot = getFunction().createLot("Lot_" + itemList.get(i).getOrderItem(), order);
			lot.setOrderItem(itemList.get(i).getOrderItem());
			lot.setQuantity(itemList.get(i).getQuantityOrdered());
			lot.setRouteName(itemList.get(i).getPlannedRoute());

			lot.save();

		}

	}

	// 获取班次指定时间
	public Time returnTime(int settime) {
		Calendar cale = Calendar.getInstance();
		Calendar calendar = new GregorianCalendar(cale.get(Calendar.YEAR), cale.get(Calendar.MONTH),
				cale.get(Calendar.DAY_OF_MONTH), settime, 0, 0);
		Time time = new Time(calendar);
		return time;
	}

	// 通过参数查询唯一的BOM
	public Map<String, Object> getBom(ProductionDayPlan dayplan, String flag) {
		SQLQuery LeftBom = createSQLQuery(getSQL("getBom"));
		if (flag.equals("L")) {// 左
			LeftBom.setParameter("mastersap_s", dayplan.getMaterial_code_left_s());
			LeftBom.setParameter("part_number", dayplan.getSpecification_left_s());
			LeftBom.setParameter("part_revision", dayplan.getChildbom_ver_left_s());
			LeftBom.setParameter("prophase_s", dayplan.getProduction_step_left_s());
			LeftBom.setParameter("bom_revision", dayplan.getChildbom_ver_left_s());

		} else if (flag.equals("R")) {// 右
			LeftBom.setParameter("mastersap_s", dayplan.getMaterial_code_right_s());
			LeftBom.setParameter("part_number", dayplan.getSpecification_right_s());
			LeftBom.setParameter("part_revision", dayplan.getChildbom_ver_right_s());
			LeftBom.setParameter("prophase_s", dayplan.getProduction_step_right_s());
			LeftBom.setParameter("bom_revision", dayplan.getChildbom_ver_right_s());

		}
		Map bom = null;
		if (LeftBom.list().size() > 0) {
			bom = (HashMap<String, Object>) LeftBom.list().get(0);
		}
		return bom;
	}

	// 返回错误信息
	public String errorInfo(ProductionDayPlan dailyPlan, String msgCode) {
		return msg("productiondayplan.column.production_date_s") + "[" + dailyPlan.getProduction_date_s() + "],"
				+ msg("productiondayplan.column.production_line_s") + "[" + dailyPlan.getProduction_line_s() + "],"
				+ msg("productiondayplan.column.plan_queue_s") + "[" + dailyPlan.getPlan_queue_s() + "]，"
				+ msg(msgCode);
	}

	/**
	 * 构造换模计划
	 * 
	 * @param dailyPlan
	 * @return
	 * @throws Exception
	 */
	public MoldChangePlan buildMoldChangePlan(ProductionDayPlan dailyPlan) throws Exception {
		Part part_left = getFunction().getPart(dailyPlan.getMaterial_code_left_s());
		Part part_right = getFunction().getPart(dailyPlan.getMaterial_code_right_s());

		MoldChangePlan mcp = new MoldChangePlan(LLWebUtils.factory(), LLWebUtils.getUserName(), new Date());

		mcp.setMold_changetime_s(dailyPlan.getProduction_date_s());
		mcp.setPlan_no_s(dailyPlan.getPlan_no_s());
		mcp.setEquip_code_s(dailyPlan.getProduction_line_s());
		mcp.setPlanno_changemold_s(serialSrv.serial("HMJH", dailyPlan.getProduction_date_s()));
		mcp.setPlan_status_s("219001");
		mcp.setStatus_s("0");
		mcp.setMaterial_code_left_s(dailyPlan.getMaterial_code_left_s());
		mcp.setMaterial_code_right_s(dailyPlan.getMaterial_code_right_s());
		mcp.setMaterial_name_left_s(dailyPlan.getMaterial_desc_left_s());
		mcp.setMaterial_name_right_s(dailyPlan.getMaterial_desc_right_s());
		if (part_left.getUDA("THSpec") != null) {
			mcp.setSpeccode_left_s(part_left.getUDA("THSpec").toString());
		}
		if (part_right.getUDA("THSpec") != null) {
			mcp.setSpeccode_right_s(part_right.getUDA("THSpec").toString());
		}
		if (part_left.getUDA("Pattern") != null) {
			mcp.setFlowercode_left_s(part_left.getUDA("Pattern").toString());
		}
		if (part_right.getUDA("Pattern") != null) {
			mcp.setFlowercode_right_s(part_right.getUDA("Pattern").toString());
		}

		// 左模计划量为0，则不换模
		if (dailyPlan.getQuantity_dayplan_left_i() == 0) {
			mcp.setFlowercode_left_s(null);
			mcp.setMaterial_code_left_s(null);
			mcp.setMaterial_name_left_s(null);
		}
		// 右模计划量为0，则不换模
		if (dailyPlan.getQuantity_dayplan_right_i() == 0) {
			mcp.setFlowercode_right_s(null);
			mcp.setMaterial_code_right_s(null);
			mcp.setMaterial_name_right_s(null);
		}

		return mcp;

	}

	public String msg(String code) {
		return LanguageProvider.getMessage(code);
	}

	public Map<String, List<ProductionDayPlan>> copy(Filter filter, Page page, String to) throws Exception {

		Where w = new Where();
		w.andEqual("s_factory_s", LLWebUtils.factory());
		w.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);
		w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		w.andEqual("production_date_s", to);
		// 已有计划
		List<ProductionDayPlan> havePlanList = super.findByWhere(w);
		System.out.println(havePlanList);
		// if (super.findByWhere(w).size() > 0) {
		// throw new Exception(to + msg("tip.hasCuringPlans"));
		// }

		// 需要复制的计划,去掉已有的计划
		List<ProductionDayPlan> copyPlanList = super.datagridRows(filter, page, ProductionDayPlan.class);
		for (int i = 0; i < havePlanList.size(); i++) {
			for (int j = 0; j < copyPlanList.size(); j++) {
				String haveequip = havePlanList.get(i).getEquip_code_left_s();
				String havematerial = havePlanList.get(i).getMaterial_code_left_s();
				String copyequip = copyPlanList.get(j).getEquip_code_left_s();
				String copymaterial = copyPlanList.get(j).getMaterial_code_left_s();
				if (copyequip.equals(haveequip) && copymaterial.equals(havematerial)) {
					copyPlanList.remove(j);
				}
			}
		}
		Map<String, ProductionDayPlan> map = new HashMap<String, ProductionDayPlan>();

		for (ProductionDayPlan plan : copyPlanList) {

			plan.setProduction_date_s(to);
			plan.setPlan_no_s(serialSrv.serial("LHRJH", to));
			plan.setStatus_s("218001");

			plan.setApproval_time_s(null);
			plan.setApprover_s(null);
			plan.setCreated_by_s(null);
			plan.setCreated_time_t(null);
			plan.setChanged_by_s(null);
			plan.setChanged_time_t(null);

			plan.setAtr_key(null);
			plan.setSite_num(null);
			plan.setAtr_name(null);
			plan.setPurge_status(null);
			plan.setCreation_time(null);
			plan.setCreation_time_u(null);
			plan.setCreation_time_z(null);
			plan.setLast_modified_time(null);
			plan.setLast_modified_time_u(null);
			plan.setLast_modified_time_z(null);
			plan.setXfr_insert_pid(null);
			plan.setXfr_update_pid(null);
			plan.setTrx_id(null);
			plan.setParent_key(null);

			// 清空实绩产出量信息
			plan.setOutput_morclass_left_i(null);
			plan.setOutput_morclass_right_i(null);
			plan.setOutput_midclass_left_i(null);
			plan.setOutput_midclass_right_i(null);
			plan.setOutput_nigclass_left_i(null);
			plan.setOutput_nigclass_right_i(null);
			plan.setQty_dayproduct_left_i(null);
			plan.setQty_dayproduct_right_i(null);
			if(plan.getSpare10_s()==null){
	            	plan.setSpare10_s(plan.getProcessbom_index_curing_s());
	        }
	        if(plan.getSpare8_s()==null){
	            plan.setSpare8_s(plan.getProcessbom_index_build_s());
	        }
			if (map.get(plan.getProduction_line_s()) == null) {
				map.put(plan.getProduction_line_s(), plan);
			}

			if (Integer.parseInt(map.get(plan.getProduction_line_s()).getPlan_queue_s()) < Integer.parseInt(plan
					.getPlan_queue_s())) {
				map.put(plan.getProduction_line_s(), plan);
			}

		}

		copyPlanList.clear();
		copyPlanList.addAll((Collection<ProductionDayPlan>) map.values());

		List<ProductionDayPlan> db = new ArrayList<ProductionDayPlan>();

		List<ProductionDayPlan> paraMeterIsTestPlanList = new ArrayList<ProductionDayPlan>();

		for (ProductionDayPlan plan : copyPlanList) {
			// 月计划没有的物料，不做计划
			Map<String, Object> left = getPlanCount(plan.getProduction_date_s(), plan.getMaterial_code_left_s());
			Map<String, Object> right = getPlanCount(plan.getProduction_date_s(), plan.getMaterial_code_right_s());

			if (left == null) {
				continue;
			}

			if (right == null) {
				continue;
			}
			plan.setPlan_queue_s("1");

			// 判断试验胎参数--开始
			String fromDate = filter.get("production_date_s");
			String fromTomorrow = CommonTools.dayCalculation(fromDate, 1);
			String isTestFlag = this.validparameteristest(fromTomorrow, plan.getProduction_line_s(),
					plan.getMaterial_code_left_s());
			if (isTestFlag.equals("1")) {
				paraMeterIsTestPlanList.add(plan);
			}
			// 判断试验胎参数--结束
			// 初始化胎胚品号，格式如301094809(SZ_a_A) 刘朋2020/1/20
			plan.setSpecification_left_s(plan.getSpecification_left_s() + "(" + plan.getChildbom_ver_left_s() + ")");
			plan.setSpecification_right_s(plan.getSpecification_right_s() + "(" + plan.getChildbom_ver_right_s() + ")");
			db.add(plan);
		}
		Map<String, List<ProductionDayPlan>> resultMap = new HashMap<>();
		resultMap.put("copyData", db);
		resultMap.put("testFlag", paraMeterIsTestPlanList);
		return resultMap;
	}

	/**
	 * 根据日计划集合验证生产版本
	 * 
	 * @param list
	 *            待验证日计划集合
	 * @return 无生产版本的物料编码列表信息
	 */
	public List<ProductionDayPlan> costList(List<ProductionDayPlan> list) {
		List<Integer> intlist = new ArrayList<Integer>();
		// 获取无生产版本的物料编码列表
		for (int i = 0; i < list.size(); i++) {
			if (!costCollector(list.get(i).getMaterial_code_left_s(), list.get(i).getProductionver_left_s(), list
					.get(i).getSpecification_left_s())
					|| !costCollector(list.get(i).getMaterial_code_right_s(), list.get(i).getProductionver_right_s(),
							list.get(i).getSpecification_right_s())) {
				if (!intlist.contains(i)) {
					intlist.add(i);
				}
			}
		}
		Collections.reverse(intlist);
		for (Integer i : intlist) {
			int a = i;
			list.remove(a);
		}
		return list;
	}

	/**
	 * 根据日计划集合验证物料编码有效性
	 * 
	 * @param list
	 *            待验证日计划集合
	 * @return 失效物料编码
	 */
	public List<ProductionDayPlan> costMaterialList(List<ProductionDayPlan> list) {
		List<Integer> intlist = new ArrayList<Integer>();
		// 获取失效物料编码列表
		for (int i = 0; i < list.size(); i++) {
			if (!validDiscardMaterialCode(list.get(i).getMaterial_code_left_s())) {
				if (!intlist.contains(i)) {
					intlist.add(i);
				}
				continue;
			} else if (!validDiscardMaterialCode(list.get(i).getMaterial_code_right_s())) {
				if (!intlist.contains(i)) {
					intlist.add(i);
				}
				continue;
			}
		}
		Collections.reverse(intlist);
		for (Integer i : intlist) {
			int a = i;
			list.remove(a);
		}

		return list;
	}

	public void sort(String ids) throws NumberFormatException, Exception {
		String idArray[] = ids.split(",");
		for (int i = 0; i < idArray.length; i++) {
			update(Long.parseLong(idArray[i]), "plan_queue_s", (i + 1) + "");
		}
	}

	public void forced(Long[] ids) throws Exception {
		List<ProductionDayPlan> listEnt = findByIds(ids);
		for (ProductionDayPlan item : listEnt) {
			item.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
			update(item);
		}
	}

	/**
	 * 获取前一日计划的下发参数是否为试验胎参数
	 * 
	 * @param productdate
	 * @param equipcode
	 * @return 0代表正常，1代表试验胎参数
	 * @author 刘程明
	 * @date 2019年5月30日
	 */
	public String validparameteristest(String productdate, String equipcode, String materialcode) {
		try {
			Object testflag = getSession().createSQLQuery(getSQL("validparameteristest"))
					.setParameter("factory", LLWebUtils.factory()).setParameter("ageno", LLConstant.JING_MEN_CODE)
					.setParameter("recordflag", LLConstant.Record_Flag.AVAILIABLE)
					.setParameter("productdate", productdate).setParameter("equipcode", equipcode)
					.setParameter("materialcode", materialcode).uniqueResult();
			if (testflag == null) {
				return "0";
			} else {
				return testflag.toString();
			}
		} catch (Exception e) {
			System.out.println("请注意：" + productdate + "|||" + equipcode + "|||" + materialcode);
		}
		return "0";
	}

	// 月计划更新或删除调用删除未开始的硫化日计划
	public void updateDayPLan(CuringProductionMonthPlan plan) throws Exception {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("planno_month_s", plan.getPlanno_month_s());
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("record_flag_s", "D");
		update(map1, map2);
	}

	/**
	 * 查询产线上一日计划
	 * 
	 * @param line
	 * @return PlanDayParameter
	 */
	public List<Map<String, Object>> querylastdayplan(String line) {
		SQLQuery query = createSQLQuery(getSQL("querylastdayplan"));
		query.setParameter("line", line);
		TransformUpperCase transformUpperCase = new TransformUpperCase();
		List<Map<String, Object>> result = query.list();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result.size(); i++) {
			list.add(TransformUpperCase.transformUpperCase(result.get(i)));
		}
		return list;
	}
}
