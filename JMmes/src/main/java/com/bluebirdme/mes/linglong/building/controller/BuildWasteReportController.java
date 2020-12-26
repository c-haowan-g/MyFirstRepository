/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.entity.BuildWasteReport;
import com.bluebirdme.mes.linglong.building.service.BuildWasteReportServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 产出实绩表
 * 
 * @author 刘朋
 * @Date 2019-08-22
 */
@Log(code = "BuildWasteReport_log", value = "成型废次品_log")
@RestController
@RequestMapping("building/report/buildwaste/buildwastereport")
public class BuildWasteReportController extends RockWellFunctionalUDAController<Object> {

	@Resource
	BuildWasteReportServiceImpl buildwastereportSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return buildwastereportSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return buildwastereportSrv;
	}

	@Override
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getService().datagrid(filter, page, BuildWasteReport.class));
	}

}
