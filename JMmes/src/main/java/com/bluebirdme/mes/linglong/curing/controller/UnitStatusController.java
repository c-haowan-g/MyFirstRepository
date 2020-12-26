/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.UnitStatusServiceImpl;

/**
 * 硫化工单测试
 * 
 * @author penga_liu
 * 
 * @Date 2019年6月23日 下午1:35:41
 */
@RestController
@RequestMapping("unitstatus")
public class UnitStatusController extends RockWellFunctionalUDAController<Object> {

	@Resource
	UnitStatusServiceImpl unitstatusSrv;

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return unitstatusSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return unitstatusSrv;
	}

	@RequestMapping("updateSerialStatus")
	public Response updateSerialStatus(String serial_number, String orderitem, String step, String reason, String flag)
			throws Exception {
		unitstatusSrv.updateSerialStatus(serial_number, orderitem, step, reason, flag);
		return Response.suc();
	}

	// 查询全部
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		return GsonTools.toJson(unitstatusSrv.datagridUDA(filter, page));
	}
}
