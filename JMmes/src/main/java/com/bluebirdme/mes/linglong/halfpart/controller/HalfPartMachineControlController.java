package com.bluebirdme.mes.linglong.halfpart.controller;

import javax.annotation.Resource;


import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.HalfPartMachineControlServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;

import org.xdemo.app.xutils.ext.GsonTools;


/**
 * 机台控制管理
 * @author 李新宇
 * @Date 2020-03-05 11:15:54
 */
@Log(code="半部件机台控制管理",value="半部件机台控制管理")
@RestController
@RequestMapping("halfpart/productionManagement/HalfPartMachineControl/halfpartmachinecontrol")
public class HalfPartMachineControlController extends RockWellFunctionalUDAController<Object> {
    
    @Resource
    private HalfPartMachineControlServiceImpl machineControlService;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return machineControlService;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return machineControlService;
	}


    @Override
    @Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
    @ResponseBody
    @RequestMapping("datagridUDA")
    public String datagridUDA(Filter filter, Page page) throws Exception {
        return GsonTools.toJson(machineControlService.datagridRowsUDA(filter,page));
    }

    @Log(value = "查询数据字典119", code = "查询数据字典119", target = LogType.CONSOLE)
    @RequestMapping("searchBy119")
    public String searchBy119(Filter filter, Page page) throws Exception {
        return GsonTools.toJson(machineControlService.searchBy119());
    }

    /**
     * 获取机台日志数据
     * 李新宇
     * @throws Exception
     */
    @Log(value = "机台控制日志查询", code = "机台控制日志查询", target = LogType.CONSOLE)
    @RequestMapping("datagridLog")
    public String datagridLog(Filter filter,Page page) throws Exception {
        return GsonTools.toJson(machineControlService.datagridLog(filter,page));
    }

    /**
     * 更改状态
     * 李新宇
     * @param oper
     * @param code
     */
    @Log(value = "机台控制改变状态", code = "机台控制改变状态", target = LogType.CONSOLE)
    @RequestMapping("changeState")
    public String changeState(String oper,String code,String[] barCodes) throws Exception {
        Filter filter = new Filter();
        filter.getFilter().put("code",code);
        filter.getFilter().put("oper",oper);
        return (String) machineControlService.changeState(filter,barCodes);
    }
}
