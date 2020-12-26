/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;
import java.util.Map;

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
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.building.service.BuildingOverDateSearchServiceImpl;


/**
 * 成型超期查询
 * @author 李德晓
 * @Date 2020-01-21 15:41:16
 */
@Log(code="成型超期查询",value="成型超期查询")
@RestController
@RequestMapping("building/buildingOverDateSearch/buildingoverdatesearch")
public class BuildingOverDateSearchController extends RockWellFunctionalUDAController<Object> {
    
    @Resource BuildingOverDateSearchServiceImpl buildingoverdatesearchSrv;
   
   
    @Override
    @Log(value = "信息列表查询", code = "成型超期查询", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return buildingoverdatesearchSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return buildingoverdatesearchSrv;
	}
}
