package com.bluebirdme.mes.linglong.building.controller;

import javax.annotation.Resource;


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

import com.bluebirdme.mes.linglong.building.service.EquipmentRealTimeServiceImpl;


/**
 * 设备报警停机实时表
 * @author 李新宇
 * @Date 2020-01-20 09:33:58
 */
@Log(code="设备报警停机实时查询",value="设备报警停机实时查询")
@RestController
@RequestMapping("building/productionManagement/equipmentAlarm/equipmentalarm")
public class EquipmentRealTimeController extends RockWellFunctionalUDAController<Object> {
    
    @Resource EquipmentRealTimeServiceImpl equipmentrealtimeSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return equipmentrealtimeSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return equipmentrealtimeSrv;
	}


    /**
     * 获取全部机台条码
     * @return
     * @throws Exception
     */
    @RequestMapping("equipCodeList")
    public Object getEquipCodeList() throws Exception{
    	return toJson(equipmentrealtimeSrv.getEquipCodeList());
    }
    
    /*@Log(code="设备报警停机实时查询_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        equipmentrealtimeSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }*/

}
