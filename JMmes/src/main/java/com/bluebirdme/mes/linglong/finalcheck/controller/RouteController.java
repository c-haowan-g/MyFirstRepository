/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.RouteServiceImpl;
/**
 * Route-Arc
 * @author 时永良
 * @Date 2019-08-08 16:01:32
 */
@Log(code="11",value="11")
@RestController
@RequestMapping("route")
public class RouteController extends RockWellFunctionalUDAController<Object> {
    
    @Resource RouteServiceImpl routeSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return routeSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return routeSrv;
	}
    
	@RequestMapping("datagridUDA1")
	public String datagridUDA1(String routeName) throws Exception {
		return GsonTools.toJson(routeSrv.datagridUDA1(routeName));
	}
	@RequestMapping("getRouteName")
   	public String getRouteName() throws Exception{
    	List<Map<String,Object>> list=routeSrv.getRouteName();
   		return toJson(list);
   	}

}
