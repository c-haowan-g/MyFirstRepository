/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MoldChangePlan;
import com.bluebirdme.mes.linglong.curing.entity.MoldChangePlanAll;
import com.bluebirdme.mes.linglong.curing.entity.dto.MoldChangePlanDTO;
import com.bluebirdme.mes.linglong.curing.service.MoldChangePlanServiceImpl;

/**
 * 硫化换模计划表
 * 
 * @author 司乔靖
 * @Date 2019-07-18 10:58:42
 */
@Log(code = "LH_SCJH_HMJH", value = "硫化换模计划表")
@RestController
@RequestMapping("curing/baseData/moldChangePlan")
public class MoldChangePlanController extends RockWellFunctionalController<MoldChangePlan> {

	@Resource
	MoldChangePlanServiceImpl moldchangeplanSrv;

	@Override
	protected RockWellBaseServiceImpl<MoldChangePlan> getService() {
		return moldchangeplanSrv;
	}

	@Log(code = "LH_SCJH_HMJH_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	@RockWellTransactional
	public Response saveChanges(@RequestBody MoldChangePlanDTO moldchangeplan) throws Exception {
		moldchangeplanSrv.saveChanges(moldchangeplan);
		return Response.suc();
	}

	@Log(code = "LH_SCJH_HMJH_PLAN_NO_MAX", value = "取换模计划最大计划号")
	@RequestMapping("planno/{plandate}")
	public Response getPlanNoMax(@PathVariable("plandate") String plandate) throws Exception {
		return Response.suc(moldchangeplanSrv.getSAPProductionPlanNo());
	}

	/**
	 * 获取符合条件的日计划号
	 * 
	 * @param d日期
	 * @param m产线
	 * @return
	 * @throws Exception
	 */
	@Log(code = "LH_SCJH_HMJH_DAY_PLAN_NO", value = "获取符合条件的日计划号")
	@RequestMapping("dayplanno")
	public String getDayPlanNoForMold(String d, String m) throws Exception {
		List<Map<String, Object>> map = moldchangeplanSrv.getDayPlanNoForMold(d, m);
		return toJson(map);
	}

	/**
	 * 根据计划号，获取左模具右模具的物料规格信息
	 * 
	 * @param planNo
	 * @return
	 * @throws Exception
	 */
	@Log(code = "LH_SCJH_HMJH_DAY_THSPEC", value = "根据计划号获取左模具右模具的物料规格信息")
	@RequestMapping("getThSpecByPlanNo")
	public String getThSpecByPlanNo(String planNo) throws Exception {
		List<Map<String, Object>> m = moldchangeplanSrv.getThSpecByPlanNo(planNo);
		return toJson(m);
	}

	// 计划审核、取消审核
	@Log(code = "LH_SCJH_HMJH_DAY_PLAN_NO", value = "计划审核、取消审核")
	@RequestMapping("auditplan")
	public Response auditPlan(Long ids[], String isAudit) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// TODO 由于前期上线不管控模具，所以审核模具计划默认备模，模具条码默认为000000
		/*if (LLWebUtils.factory().equals("2")) {// 半钢钢模具暂时不管控，取消备模步骤
			if (isAudit.equals("219003")) {
				map.put("mold_barcode_left_s", "M_01");
				map.put("moldbarcode_right_s", "M_02");
				map.put("status_s", "1");
				map.put("executive_s", "0");
			}
		}*/
		map.put("plan_status_s", isAudit);
		for (Long id : ids) {
			moldchangeplanSrv.update(id, map);
		}

		return Response.suc();
	}

	// 关闭计划
	@Log(code = "LH_SCJH_HMJH_DAY_PLAN_NO", value = "关闭计划")
	@RequestMapping("closeplan")
	public Response closePlan(long iD) {
		return Response.suc(moldchangeplanSrv.dealAudit(iD, "219007"));
	}

	@Log(value = "换模计划列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@Override
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		
		return GsonTools.toJson(getService().datagrid(filter, page, MoldChangePlanAll.class));
	}

}
