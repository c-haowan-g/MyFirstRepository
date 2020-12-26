/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.sap.entity.ProductVersion;
import com.bluebirdme.mes.linglong.sap.entity.dto.ProductVersionDTO;
import com.bluebirdme.mes.linglong.sap.service.ProductVersionServiceImpl;

/**
 * SAP下发生产版本
 * 
 * @author 刘朋
 * @Date 2018-09-22 16:49:09
 */
@Log(code = "AT_INT_SAP_PRODUCTVERSION", value = "生产版本维护")
@RestController
@RequestMapping("sap/common/productversion")
public class ProductVersionController extends
		RockWellFunctionalUDAController<Object> {

	@Resource
	ProductVersionServiceImpl productversionSrv;

	



	/**
	 * search ProductionVer from table AT_INT_SAP_PRODUCTVERSION in Sap
	 * 从sap下发生产版本表中获取生产版本号
	 * 2019/04/24
	 * Yinghui.Lan
	 */
    @RequestMapping("searchProductionVersion")
    public String searchProductionVersion(){
    	List<String> productionVersionList=productversionSrv.searchProductionVersion();
    	return toJson(productionVersionList);
    }

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return productversionSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return productversionSrv;
	}
	
}
