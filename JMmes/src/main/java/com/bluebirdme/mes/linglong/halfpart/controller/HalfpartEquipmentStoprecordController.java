/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import javax.annotation.Resource;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.HalfpartEquipmentStoprecordServiceImpl;


/**
 * 设备报警停机履历表
 * @author 肖吉朔
 * @Date 2020-08-20 09:13:06
 */
@Log(code="111",value="设备报警停机履历表")
@RestController
@RequestMapping("halfpart/equipmentStoprecord")
public class HalfpartEquipmentStoprecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource HalfpartEquipmentStoprecordServiceImpl halfpartequipmentstoprecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return halfpartequipmentstoprecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return halfpartequipmentstoprecordSrv;
	}
    
    @Log(code="111_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        halfpartequipmentstoprecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
