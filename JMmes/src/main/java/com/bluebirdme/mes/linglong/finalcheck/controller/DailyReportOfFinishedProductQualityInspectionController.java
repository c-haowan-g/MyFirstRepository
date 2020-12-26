/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.DailyReportOfFinishedProductQualityInspection;
import com.bluebirdme.mes.linglong.finalcheck.service.DailyReportOfFinishedProductQualityInspectionServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.ReasServiceImpl;

/**
 * 成品质量检查日报表
 * 
 * @author wanghailin
 * @Date 2018-12-7 08:35:38
 */
@Log(code = "AT_C_MM_VISUALMCHECKSUMPRINT_LOG", value = "成品质量检查日报表日志")
@RestController
@RequestMapping("finalcheck/reportCenter/dailyReportOfQuality")
public class DailyReportOfFinishedProductQualityInspectionController extends
RockWellFunctionalUDAController<Object> {

	@Resource
	DailyReportOfFinishedProductQualityInspectionServiceImpl dailyReportOfFinishedProductQualityInspectionSrv;
	@Resource
	ReasServiceImpl reasServiceImpl;

	

	@Log(code = "datagrid2", value = "成品质量检查日报表")
	@RequestMapping("datagrid2")
	public String datagrid2(Filter filter, Page page) throws Exception {
		String factoryString = LLWebUtils.factory();
		String factoryCodeString = FactoryConstant.JING_MEN_CODE;
		filter.set("s_factory_s", factoryString);
		filter.set("agenc_no_s", factoryCodeString);
		Map<String, Object> listMap=dailyReportOfFinishedProductQualityInspectionSrv.datagridUDA(filter, page);
		return toJson(listMap);
	}



	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return dailyReportOfFinishedProductQualityInspectionSrv;
	}



	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return dailyReportOfFinishedProductQualityInspectionSrv;
	}
}
