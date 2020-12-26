/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MoldChangePlan;
import com.bluebirdme.mes.linglong.curing.entity.dto.MoldChangePlanDTO;

import freemarker.template.TemplateException;

/**
 * 硫化换模计划表
 * 
 * @author 司乔靖
 * @Date 2019-07-18 10:58:42
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MoldChangePlanServiceImpl extends RockWellBaseServiceImpl<MoldChangePlan> {

	@Resource
	LingLongDataSource llds;
	@Resource
	SerialServiceImpl ssi;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return MoldChangePlan.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	// 新增、修改、删除
	@RockWellTransactional
	public void saveChanges(MoldChangePlanDTO moldchangeplan) throws Exception {

		// 删除
		if (!ListUtils.isEmpty(moldchangeplan.getDeleted())) {
			for (MoldChangePlan plan : moldchangeplan.getDeleted()) {
				plan.setChanged_by_s(LLWebUtils.getUser().userCode);
				plan.setChanged_time_t(new Date());
				plan.setRecord_flag_s("D");
			}
			update(moldchangeplan.getDeleted());
		}

		// 新增
		if (!ListUtils.isEmpty(moldchangeplan.getInserted())) {
			List<MoldChangePlan> planList = moldchangeplan.getInserted();

			for (MoldChangePlan mPlan : planList) {
				List<Map<String, Object>> specMap = getThSpecByPlanNo(mPlan.getPlan_no_s());

				String specL = (String) specMap.get(0).get("SPECCODE_LEFT_S");// 左规格
				String specR = (String) specMap.get(0).get("SPECCODE_RIGHT_S");// 右规格
				String materCodeL = (String) specMap.get(0).get("MATERIAL_CODE_LEFT_S"); // 左物料编码
				String materCodeR = (String) specMap.get(0).get("MATERIAL_CODE_RIGHT_S"); // 右物料编码

				String flowerL = (String) specMap.get(0).get("PATTERNL");
				String flowerR = (String) specMap.get(0).get("PATTERNR");

				mPlan.setSpeccode_left_s(specL);// 左规格
				mPlan.setSpeccode_right_s(specR);// 右规格
				mPlan.setMaterial_code_left_s(materCodeL);// 设置左物料编码
				mPlan.setMaterial_code_right_s(materCodeR);// 设置右物料编码
				mPlan.setFlowercode_left_s(flowerL);// 设置左花纹
				mPlan.setFlowercode_right_s(flowerR);// 设置右花纹

				mPlan.setPlanno_changemold_s(getSAPProductionPlanNo());
				mPlan.setS_factory_s(LLWebUtils.factory());
				mPlan.setCreated_by_s(LLWebUtils.getUser().userCode);
				mPlan.setCreated_time_t(new Date());
				mPlan.setRecord_flag_s("A");// 计划删除标记-未删除
				mPlan.setStatus_s("0");// 备模状态-未备模
			}
			save(planList);
		}
		// 更新
		if (!ListUtils.isEmpty(moldchangeplan.getUpdated())) {

			for (MoldChangePlan mPlan : moldchangeplan.getUpdated()) {

				List<Map<String, Object>> specMap = getThSpecByPlanNo(mPlan.getPlan_no_s());
				String specL = (String) specMap.get(0).get("SPECCODE_LEFT_S");// 左规格
				String specR = (String) specMap.get(0).get("SPECCODE_RIGHT_S");// 右规格
				String materCodeL = (String) specMap.get(0).get("MATERIAL_CODE_LEFT_S"); // 左物料编码
				String materCodeR = (String) specMap.get(0).get("MATERIAL_CODE_RIGHT_S"); // 右物料编码
				String flowerL = (String) specMap.get(0).get("PATTERNL");
				String flowerR = (String) specMap.get(0).get("PATTERNR");

				mPlan.setSpeccode_left_s(specL);// 左规格
				mPlan.setSpeccode_right_s(specR);// 右规格
				mPlan.setMaterial_code_left_s(materCodeL);// 设置左物料编码
				mPlan.setMaterial_code_right_s(materCodeR);// 设置右物料编码
				mPlan.setFlowercode_left_s(flowerL);// 设置左花纹
				mPlan.setFlowercode_right_s(flowerR);// 设置右花纹
				mPlan.setChanged_by_s((LLWebUtils.getUser().userCode));
				mPlan.setChanged_time_t(new Date());

			}
			update(moldchangeplan.getUpdated());
		}

	}

	/**
	 * 获取换模计划编号
	 * 
	 * @return 最新的月计划编码
	 * @throws Exception
	 */
	public String getSAPProductionPlanNo() throws Exception {
		return ssi.serial("HMJH");
	}

	// 获取符合条件的日计划号
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getDayPlanNoForMold(String mold_changetime_s, String equip_code_s)
			throws TemplateException, IOException {
		Filter filter = new Filter();
		filter.set("production_date_s", mold_changetime_s);
		filter.set("production_line_s", equip_code_s);
		SQLQuery sql = createSQLQuery(getSQL("getDayPlanNoForMold", filter.getFilter()));
		sql.setParameter("production_date_s", filter.get("production_date_s"));
		sql.setParameter("production_line_s", filter.get("production_line_s"));
		List<Map<String, Object>> list = sql.list();
		return list;
	}

	// 根据计划号获取规格信息
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getThSpecByPlanNo(String planNo) {
		SQLQuery query = createSQLQuery(getSQL("getThSpecByPlanNo"));
		query.setParameter("PLAN_NO_S", planNo);
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 审核计划、取消审核、关闭订单
	 * 
	 * @param iD
	 * @param status
	 * @return
	 */
	public boolean dealAudit(long iD, String status) {
		try {
			update(iD, "plan_status_s", status);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 获取胶囊
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCapsule(String planNo) {
		SQLQuery query = createSQLQuery(getSQL("getCupsule"));
		query.setParameter("PLANNO", planNo);
		List<Map<String, Object>> list = query.list();
		return list;
	}

	/**
	 * 获取色标线
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getLineColor(String planNo) {
		SQLQuery query = createSQLQuery(getSQL("getLineColor"));
		query.setParameter("PLANNO", planNo);
		List<Map<String, Object>> list = query.list();
		return list;
	}

}
