/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.test.entity.ExcelDemo;
import com.bluebirdme.mes.linglong.test.service.ExcelDemoServiceImpl;

/**
 * DemoController
 * @author Goofy
 * @Date 2018年8月7日 下午4:22:53
 */
@RestController
@RequestMapping("/demo/excel")
public class ExcelDemoController extends RockWellFunctionalController<ExcelDemo> {
	
	@Resource ExcelDemoServiceImpl demoSrv;

	@Override
	protected RockWellBaseServiceImpl<ExcelDemo> getService() {
		return demoSrv;
	}
	
	@Override
	@Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getService().datagrid(filter, page, null));
	}
	
}
