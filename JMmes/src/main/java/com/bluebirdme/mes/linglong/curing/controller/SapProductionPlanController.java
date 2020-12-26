/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.ProductionDayPlan;
import com.bluebirdme.mes.linglong.curing.service.ProductionDayPlanServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.SapProductionPlanServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.PartsServiceImpl;

import freemarker.template.TemplateException;

/**
 * 硫化月计划编制
 * 
 * @author whl
 * @Date 2018-08-07 13:15:32
 */
@Log(code = "LH_SCJH_YJH", value = "硫化月计划编制日志")
@RestController
@RequestMapping("curing/productionPlan/monthlyPlan")
public class SapProductionPlanController extends RockWellFunctionalUDAController<Object> {

	@Resource
	SapProductionPlanServiceImpl sapMonthlyPlan;
	@Resource
	ProductionDayPlanServiceImpl pdpSrv;

	@Resource
	PartsServiceImpl partsServiceImpl;

	@Log(code = "LH_SCJH_YJH_SAVE_CHANGES", value = "保存数据的增删改")
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		sapMonthlyPlan.saveChanges(rockWellEntityDTO);
		return Response.suc();
	}

	@RequestMapping("materials")
	public String materials(String date, String q) throws TemplateException, IOException {
		List<Map<String, Object>> list = sapMonthlyPlan.getMaterialsByDate(date, q);
		return toJson(list);
	}

	@RequestMapping("checkDailyPlan")
	public Response checkDailyPlan(String month, String materialCode) {

		Where w = new Where();
		w.andStartWith("production_date_s", month);
		w.andEqual("material_code_right_s", materialCode);
		w.orEqual("material_code_left_s", materialCode);

		List<ProductionDayPlan> list = pdpSrv.findByWhere(w);

		if (!ListUtils.isEmpty(list)) {
			return Response.suc(true);
		}

		return Response.suc(false);

	}

	/**
	 * 通过月计划表的月份、物料到日计划表查询计划状态，决定月计划数量的修改状态
	 * 
	 * @Title: CheckDayPlan
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("checkdayplan")
	public String CheckDayPlan(String month_i, String material_code_s) throws Exception {
		int data = sapMonthlyPlan.CheckDayPlan(month_i, material_code_s);
		return toJson(data);
	}

	// 获取物料代码，动态搜索物料编码
	@RequestMapping("list")
	public String GetPartlByPartNumber(String code, String q) throws Exception {
		if (!StringUtils.isBlank(q)) {
			code = q;
		}

		Filter filter = new Filter();
		if (!StringUtils.isBlank(code)) {
			filter.set("materialcode_s", "contains:" + code);
		}
		filter.set("matgrp_s", "FERT");
		if (LLWebUtils.factory().equals(LLConstant.QUAN_GANG)) {
			filter.set("matgrp_s", "beginWith:21");
		} else {
			filter.set("matgrp_s", "beginWith:22");
		}
		Page page = new Page();
		return toJson(partsServiceImpl.datagridUDA(filter, page).get("rows"));
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return sapMonthlyPlan;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return sapMonthlyPlan;
	}

}
