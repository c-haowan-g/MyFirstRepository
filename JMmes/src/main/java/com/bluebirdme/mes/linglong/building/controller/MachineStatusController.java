/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

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
import com.bluebirdme.mes.linglong.building.service.MachineStatusServiceImpl;

/**
 * 机台信息状态表
 * @author 时永良
 * @Date 2019-03-06 18:31:24
 */
@Log(code="AT_CM_EM_MACHINESTATUS_LOG",value="机台信息状态表操作日志")
@RestController
@RequestMapping("building/productionManagement/machineStatus")
public class MachineStatusController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MachineStatusServiceImpl machinestatusSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return machinestatusSrv;
    }
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
    	return machinestatusSrv;
	}


	@Override
	@Log(value = "信息列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter,Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
	
	
	@Log(code="comboxMaterial",value="查询机器ID")
    @RequestMapping("comboxMaterial")
   	public String comboxMaterial() throws Exception{
    	List<Map<String,Object>> list=machinestatusSrv.comboxMaterial();
   		return toJson(list);
   	}
    
	@Log(code="getcxEquipcodetype",value="查询机台类型")
    @RequestMapping("getcxEquipcodetype")
   	public String getcxEquipcodetype() throws Exception{
    	List<Map<String,Object>> list=machinestatusSrv.getcxEquipcodetype();
   		return toJson(list);
   	}
}
