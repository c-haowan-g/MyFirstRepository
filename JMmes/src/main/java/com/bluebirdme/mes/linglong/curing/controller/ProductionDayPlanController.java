/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.ProductionDayPlan;
import com.bluebirdme.mes.linglong.curing.entity.dto.ProductionDayPlanDTO;
import com.bluebirdme.mes.linglong.curing.entity.dto.ProductionDayPlanEXT;
import com.bluebirdme.mes.linglong.curing.service.MachineControlServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.ProductionDayPlanServiceImpl;

/**
 * 硫化生产日计划
 * 
 * @author 周清玉
 * @Date 2019-07-06 14:34:18
 */
@Log(code = "LH_RJG", value = "硫化日计划")
@RestController
@RequestMapping("curing/productionPlan/dailyPlan")
public class ProductionDayPlanController extends RockWellFunctionalController<ProductionDayPlan> {

	@Resource
	ProductionDayPlanServiceImpl pdpSrv;

	@Resource
	MachineControlServiceImpl mcSrv;

	@Override
	protected RockWellBaseServiceImpl<ProductionDayPlan> getService() {
		return pdpSrv;
	}

	@Log(value = "删除信息", code = "FUNC_003", target = LogType.DB)
	@ResponseBody
	@RequestMapping("delete2")
	public Response delete2(String ids) throws Exception {
		ProductionDayPlan pdp = pdpSrv.findById(Long.parseLong(ids));

		if (!pdp.getStatus_s().equals("218001")) {
			return Response.error(Response.SYS_EXCEPTION, getMessage("tip.canNotBeDeletedOrEdit"), null);
		}

		pdpSrv.update(ids, "record_flag_s", LLConstant.Record_Flag.DELETED);

		return Response.suc();
	}

	@Log(value = "删除信息", code = "FUNC_003", target = LogType.DB)
	@ResponseBody
	@RequestMapping("delete3")
	public Response delete3(Long[] ids) throws Exception {
		/*
		 * ProductionDayPlan pdp = pdpSrv.findById(Long.parseLong(ids));
		 * 
		 * if (!pdp.getStatus_s().equals("218001")) { return
		 * Response.error(Response.SYS_EXCEPTION,
		 * getMessage("tip.canNotBeDeletedOrEdit"), null); }
		 * 
		 * pdpSrv.update(ids, "record_flag_s", LLConstant.Record_Flag.DELETED);
		 */

		pdpSrv.forced(ids);

		return Response.suc();
	}

	@Log(code = "LH_RJG_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody ProductionDayPlanDTO productiondayplan) throws Exception {
		return Response.suc(pdpSrv.saveChanges(productiondayplan));
	}

	@RequestMapping("daily/{date}/{lineCode}")
	public Response daily(@PathVariable("date") String date, @PathVariable("lineCode") String lineCode) {
		Where w = new Where();
		w.andEndWith("production_date_s", date);
		w.andEqual("production_line_s", lineCode);
		w.andEqual("record_flag_s", LLConstant.Record_Flag.AVAILIABLE);
		w.andEqual("s_factory_s", LLWebUtils.factory());
		w.andEqual("agenc_no_s", LLConstant.JING_MEN_CODE);

		List<ProductionDayPlan> list = pdpSrv.findByWhere(w);

		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("index", list.size() + 1);

		// 对计划顺序号降序排序
		Collections.sort(list, new Comparator<ProductionDayPlan>() {

			@Override
			public int compare(ProductionDayPlan o1, ProductionDayPlan o2) {
				int no1 = Integer.parseInt(o1.getPlan_queue_s());
				int no2 = Integer.parseInt(o2.getPlan_queue_s());
				if (no1 < no2) {
					return 1;
				}
				if (no2 == no1) {
					return 0;
				}
				return -1;
			}
		});
		ret.put("lastPlan", list.size() == 0 ? null : list.get(0));

		return Response.suc(ret);
	}

	@RequestMapping("plandatagrid")
	public String datagrid(Filter filter, Page page, Class clazz) throws Exception {
		return GsonTools.toJson(pdpSrv.datagrid(filter, page, ProductionDayPlanEXT.class));
	}

	@Log(value = "复制信息", code = "LH_RJG_COPY", target = LogType.DB)
	@RequestMapping("copy")
	public Response copy(Filter filter, Page page, String to) throws Exception {

		Map<String, List<ProductionDayPlan>> copyRes = pdpSrv.copy(filter, page, to);

		List<ProductionDayPlan> data1 = copyRes.get("copyData");
		List<ProductionDayPlan> data4 = copyRes.get("testFlag");
		List<ProductionDayPlan> temp1 = new ArrayList<>();
		for (int i = 0; i < data1.size(); i++) {
			temp1.add(data1.get(i));
		}
		List<ProductionDayPlan> temp2 = new ArrayList<>();
		for (int i = 0; i < data1.size(); i++) {
			temp2.add(data1.get(i));
		}
		List<ProductionDayPlan> data2 = pdpSrv.costList(temp1);// 无生产版本信息的物料编码列表
		List<ProductionDayPlan> data3 = pdpSrv.costMaterialList(temp2);
		Object[] res = new Object[] { data1, data2, data3, data4 };

		return Response.suc(res);
	}

	@Override
	@Log(value = "保存或更新信息", code = "FUNC_001", target = LogType.DB)
	@ResponseBody
	@RequestMapping("save")
	public Response save(ProductionDayPlan plan) throws Exception {
		pdpSrv.save(plan);
		return Response.suc(plan);
	}

	@RequestMapping("machines/{lineCode}")
	public Response machines(@PathVariable("lineCode") String lineCode) {
		return Response.suc(mcSrv.machines(lineCode));
	}

	@RequestMapping("greenTire")
	public Response greeTire(String code) throws Exception {
		return Response.suc(pdpSrv.loadGreenTire(code));
	}

	/**
	 * 验证成本管理器
	 * 
	 * @param code
	 *            物料编码
	 * @param masterrevision
	 *            物料版本
	 * @return
	 */
	@RequestMapping("cost")
	public Response costCollector(String code, String masterrevision, String childcode) {
		if (pdpSrv.costCollector(code, masterrevision, childcode)) {
			return Response.suc();
		} else {
			return Response.error(Response.SYS_EXCEPTION, getMessage("tip.validmaterialcb"), null);
		}
	}

	@RequestMapping("validBom")
	public Response validBom(String bomId1, String bomId2) {
		return Response.suc(pdpSrv.valid(bomId1, bomId2));
	}

	@RequestMapping("getPlanCount")
	public Response getPlanCount(String date, String code) {
		return Response.suc(pdpSrv.getPlanCount(date, code));
	}

	@Log(code = "LH_RJH_SHENHE", value = "硫化日计划审核", target = LogType.DB)
	@RequestMapping("audit")
	public Response audit(Long[] ids) throws Exception {
		pdpSrv.audit(ids);
		return Response.suc();
	}

	@Log(code = "LH_RJH_CANCEL_SHENHE", value = "硫化日计划取消审核", target = LogType.DB)
	@RequestMapping("cancelAudit")
	public Response cancelAudit(Long[] ids) throws Exception {
		pdpSrv.cancelAudit(ids);
		return Response.suc();
	}

	@Log(code = "LH_RJH_SORT", value = "硫化日计划排序", target = LogType.DB)
	@RequestMapping("sort")
	public Response sort(String ids) throws NumberFormatException, Exception {
		pdpSrv.sort(ids);
		return Response.suc();
	}

	@Log(code = "LH_RJH_VALIDPARAMETER", value = "获取前一日计划的下发参数是否为试验胎参数", target = LogType.CONSOLE)
	@RequestMapping("validparameteristest")
	public Response validparameteristest(String productdate, String equipcode, String materialcode) throws Exception {
		String result = pdpSrv.validparameteristest(productdate, equipcode, materialcode);
		return Response.suc(result);
	}

}
