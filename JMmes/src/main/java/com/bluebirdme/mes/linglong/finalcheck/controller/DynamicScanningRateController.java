package com.bluebirdme.mes.linglong.finalcheck.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.web.Filter;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynamicScanningRate;
import com.bluebirdme.mes.linglong.finalcheck.service.DynamicScanningRateServiceImpl;

/**
 * 动平衡扫描率
 * 
 * @author 王海霖
 */
@Log(code = "动平衡扫描率", value = "DynamicScanningRateController")
@RestController
@RequestMapping("finalcheck/reportCenter/dynamicScanningRate")
public class DynamicScanningRateController extends RockWellFunctionalController<DynamicScanningRate>{
	 
	@Resource
	DynamicScanningRateServiceImpl dynamicScanningRateServiceImpl;
	@Override
	protected RockWellBaseServiceImpl<DynamicScanningRate> getService() {
		return dynamicScanningRateServiceImpl;
	}
	
	 @Log(code="getAll",value="动平衡扫描率查询")
	 @RequestMapping("getAll") 
	 public String getAll(Filter filter)throws Exception{
	    return toJson(dynamicScanningRateServiceImpl.getAll(filter));
	 }

	


}
