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
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.VisualmCheckSumPrintServiceImpl;

/**
 * 成品质量检查日报表+成品质量检查记录表
 * 
 * @author 周清玉
 * @Date 2019-08-13 15:28:51
 */
@Log(code = "AT_C_MM_VISUALMCHECKSUMPRINT_LOG", value = "成品质量检查日报表日志")
@RestController
@RequestMapping("finalcheck/reportCenter/VisualmCheckSumPrint")
public class VisualmCheckSumPrintController extends RockWellFunctionalUDAController<Object> {

	@Resource
	VisualmCheckSumPrintServiceImpl visualmchecksumprintSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return visualmchecksumprintSrv;
	}
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return visualmchecksumprintSrv;
	}

	@Log(value = "成品质量检查原始记录查询", code = "FUNC_0072", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid2")
	public String datagrid2(Filter filter, Page page) throws Exception {
		String factoryString = LLWebUtils.factory();
		String factoryCodeString = FactoryConstant.JING_MEN_CODE;
		filter.set("s_factory_s", factoryString);
		filter.set("agenc_no_s", factoryCodeString);
		if(filter.getFilter().containsKey("barcode_s")){
			filter.set("begin_created_time","");
			filter.set("end_created_time","");
		}
		return GsonTools.toJson(visualmchecksumprintSrv.datagrid2(filter, page));
	}

	/**
	 * 新封装的datagrid数据：（datagrid+getGradeNum）
	 * 
	 * @Title: getdata
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getdata")
	public String getdata(String beginTime, String endTime, String curingspeccode_s, String entbarcode_s)
			throws Exception {
		List<Map<String, Object>> list = visualmchecksumprintSrv.getdata(beginTime, endTime, curingspeccode_s,
				entbarcode_s);
		return toJson(list);
	}

	

}
