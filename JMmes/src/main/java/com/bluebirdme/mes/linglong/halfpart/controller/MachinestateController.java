/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import javax.annotation.Resource;


import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;

import com.bluebirdme.mes.linglong.halfpart.service.MachinestateServiceImpl;


/**
 * 机台信息状态表 
 * @author 李新宇
 * @Date 2020-03-04 08:36:33
 */
@Log(code="机台信息状态表 ",value="机台信息状态表 ")
@RestController
@RequestMapping("halfpart/productionManagement/MachineState/machinestate")
public class MachinestateController extends RockWellFunctionalUDAController<Object> {
    
    @Resource
    MachinestateServiceImpl machomestatisSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return machomestatisSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return machomestatisSrv;
	}
    
    @Log(code="机台信息状态表 _SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        machomestatisSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }


    /**
     * 获取子表设备信息
     * @author 李新宇
     * @Date 2020-3-4 13:21
     */
    @RequestMapping("getChildrenGrid")
    @Log(code="获取子表设备信息 getChildrenGrid",value="获取子表设备信息",target=LogType.DB)
    public Object getChildrenGrid(Filter filter, Page page,String machinebarcode_s) throws Exception {
        filter.getFilter().put("machinebarcode_s",machinebarcode_s);
        return  toJson(machomestatisSrv.childrenGrid(filter,page));
    }

    /**
     *获取全部机台条码号
     */
    @RequestMapping("getLineNameList")
    @Log(code="获取全部机台条码号 getLineNameList",value="获取全部机台条码号",target=LogType.DB)
    public Object getLineNameList(){
        return toJson(machomestatisSrv.getLineName());
    }

}
