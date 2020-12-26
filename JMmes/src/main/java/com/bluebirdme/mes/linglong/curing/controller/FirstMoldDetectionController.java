/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.FirstMoldDetectionServiceImpl;

/**
 * 首模检测查询
 * 
 * @author 时永良
 * @Date 2018-08-07 17:18:05
 */
@Log(code = "AT_D_EM_Detial", value = "首模检测查询")
@RestController
@RequestMapping("curing/ReportQuery/firstMoldDetectionQuery")
public class FirstMoldDetectionController extends RockWellFunctionalUDAController<Object> {

	@Resource
	FirstMoldDetectionServiceImpl detialSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return detialSrv;
	}
	
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return detialSrv;
	}
	/**
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getDetial")
	public String datagrid(Filter filter, Page page)
			throws Exception {
		if(filter.getFilter().containsKey("barcode_s")){
			filter.set("start_opertime_t","");
			filter.set("end_opertime_t","");
		}
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
}
