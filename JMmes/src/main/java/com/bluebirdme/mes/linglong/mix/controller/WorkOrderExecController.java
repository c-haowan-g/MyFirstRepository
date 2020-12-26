/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.Map;

import javax.annotation.Resource;




import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.WorkOrderExecServiceImpl;


/**
 * 密炼工单下发
 * @author 王超
 * @Date 2020-08-07 09:07:42
 */
@Log(code="密炼工单下发",value="密炼工单下发")
@RestController
@RequestMapping("mix/planManagement/workOrderExec")
public class WorkOrderExecController extends RockWellFunctionalUDAController<Object> {
    
    @Resource WorkOrderExecServiceImpl workorderexecSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return workorderexecSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return workorderexecSrv;
	}
    
    @Log(code="密炼工单下发_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        workorderexecSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(code = "胶料计划", value = "信息列表查询")
	@RequestMapping("datagridjl")
	public String datagridjl(Filter filter, Page page) throws Exception {    	
    	Map map = workorderexecSrv.datagridUDAjl(filter, page);
		return toJson(map);
	}
	
    @Log(code = "小料计划", value = "信息列表查询")
	@RequestMapping("datagridxl")
	public String datagridxl(Filter filter, Page page) throws Exception {
    	Map map = workorderexecSrv.datagridUDAxl(filter, page);
		return toJson(map);
	}

}
