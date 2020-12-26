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
import com.bluebirdme.mes.linglong.finalcheck.service.MaintyreCurServiceImpl;

/**
 * 轮胎主表(终检蓝英接口同步实时履历)
 * 
 * @author 时永良
 * @Date 2019-05-13 11:23:26
 */
@Log(code = "MaintyreCur_Log", value = "轮胎主表_log")
@RestController
@RequestMapping("finalcheck/finishedProductManagement/mainTypecurLog")
public class MaintyreCurController extends RockWellFunctionalUDAController<Object> {

	@Resource
	MaintyreCurServiceImpl maintyrecurSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return maintyrecurSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return maintyrecurSrv;
	}

	@Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		if (filter.getFilter().containsKey("barcode_s_history")) {
			filter.set("begin_created_time_history", "");
			filter.set("end_created_time_history", "");
		}
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
}
