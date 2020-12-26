/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.common.service.RouteLogServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;

/**
 * Route
 * @author 葛迎祥
 * @Date 2020-05-07 13:47:54
 */
@Log(code="Route",value="Route")
@RestController
@RequestMapping("common/routeLog/routelog")
public class RouteLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource RouteLogServiceImpl routeSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return routeSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return routeSrv;
	}
    
	@Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(routeSrv.datagridUDA(filter, page));
	}
	
    @Log(code="Route_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        routeSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

    
    

}
