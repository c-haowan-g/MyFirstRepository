/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.dto.UdaDto;
import com.bluebirdme.mes.linglong.curing.service.CuringWorkOrderServiceImpl;

/**
 * 硫化工单查询
 * 
 * @author penga_liu
 * 
 * @Date 2019年7月18日 下午4:10:27
 */
@RestController
@RequestMapping("workorder")
public class CuringWorkOrderController extends RockWellFunctionalUDAController<Object> {

	@Resource
	CuringWorkOrderServiceImpl workorderSrv;

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return workorderSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return workorderSrv;
	}

	@Log(code = "WORKORDER_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody UdaDto udaDto) throws Exception {
		workorderSrv.saveChanges(udaDto);
		return Response.suc();
	}

	@RequestMapping("particulars")
	public String particularsByMonthPlan(String monthPlan) {
		List<Map<String, Object>> list = workorderSrv.particularsByMonthPlan(monthPlan);
		return GsonTools.toJson(list);
	}

	// 查询全部
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		return GsonTools.toJson(workorderSrv.datagridUDA(filter, page));
	}
}
