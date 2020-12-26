/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.Qualitycheck;
import com.bluebirdme.mes.linglong.building.service.QualitycheckServiceImpl;

/**
 * 胎胚病象查询
 * @author 司乔靖
 * @Date 2019-02-18 16:06:00
 */
@Log(code="胎胚病象查询",value="胎胚病象查询")
@RestController
@RequestMapping("building/productionManagement/qualitycheck")
public class QualitycheckController extends RockWellFunctionalUDAController<Object> {
    
    @Resource QualitycheckServiceImpl qualitycheckSrv;

    
    
    @Override
    @Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(qualitycheckSrv.datagridUDA(filter, page));
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return qualitycheckSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return qualitycheckSrv;
	}

}
