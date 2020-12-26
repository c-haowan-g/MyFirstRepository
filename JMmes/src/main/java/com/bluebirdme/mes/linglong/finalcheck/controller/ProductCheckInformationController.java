/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.ProductCheckInformation;
import com.bluebirdme.mes.linglong.finalcheck.service.ProductCheckInformationServiceImpl;

/**
 * 成品质检信息
 * @author 司乔靖
 * @Date 2019-02-10 13:37:36
 */
@Log(code="成品质检信息",value="成品质检信息")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/productCheck")
public class ProductCheckInformationController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ProductCheckInformationServiceImpl productcheckinformationSrv;


    @Override
   	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@ResponseBody
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
   		filter.set("s_factory_s", LLWebUtils.factory());
    	return toJson(productcheckinformationSrv.datagridUDA(filter, page));
   	}


	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return productcheckinformationSrv;
	}


	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return productcheckinformationSrv;
	}
    
}
