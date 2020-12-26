/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.MainTypeLogServiceImpl;

/**
 * 轮胎主表(终检蓝英接口同步履历)
 * 
 * @author 时永良
 * @Date 2018-11-28 09:59:40
 */
@Log(code = "AT_C_MM_MAINTYRE_LOG", value = "蓝英轮胎主表日志")
@RestController
@RequestMapping("finalcheck/finishedProductManagement/mainTypeLog")
public class MainTypeLogController extends RockWellFunctionalUDAController<Object> {

	@Resource
	MainTypeLogServiceImpl maintypelogSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return maintypelogSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return maintypelogSrv;
	}

	@Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		if (filter.getFilter().containsKey("barcode_s")) {
			filter.set("begin_created_time", "");
			filter.set("end_created_time", "");
		}
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
}
