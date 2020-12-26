/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
import com.bluebirdme.mes.linglong.finalcheck.entity.DynaBalanceCheResultPrint;
import com.bluebirdme.mes.linglong.finalcheck.service.BalanceTestReportBGServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.DynaBalanceTestReportServiceImpl;

/**
 * 动平衡检测报表
 * 
 * @author 时永良
 * @Date 2019-08-08 11:05:10
 */
@Log(code = "DynaBalanceTestReportController", value = "动平衡检测报表")
@RestController
@RequestMapping("finalcheck/reportCenter/BalanceTestReportBG")
public class BalanceTestReportBGController extends RockWellFunctionalUDAController<Object> {

	@Resource
	BalanceTestReportBGServiceImpl balanceTestReportBGServiceImpl;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return balanceTestReportBGServiceImpl;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return balanceTestReportBGServiceImpl;
	}
	
	@RequestMapping("filter")
	public String filter(Filter filter, Page page)
			throws Exception {
        Map<String,Object> map = balanceTestReportBGServiceImpl.filter(filter, page);
		return toJson(map);
	}
	
	/**
	 * 带条件查询全部
	 * 
	 * @return
	 */
	@RequestMapping("searchBy")
	public String searchBy(String begin_created_time,String end_created_time,String curingspeccode_s) throws Exception{
		Filter filter = new Filter();
		filter.set("begin_created_time", begin_created_time).set("end_created_time", end_created_time)
				.set("curingspeccode_s", curingspeccode_s);
		List<Map<String, Object>> list = balanceTestReportBGServiceImpl.datagridRowsUDA(filter);
		return toJson(list);
	}
	
	
}
