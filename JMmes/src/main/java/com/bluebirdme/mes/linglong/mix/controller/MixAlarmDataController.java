/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

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
import com.bluebirdme.mes.linglong.mix.service.MixAlarmDataServiceImpl;


/**
 * 设备报警信息表
 * @author 边朝会
 * @Date 2020-08-08 11:20:06
 */
@Log(code="MixAlarmData",value="MixAlarmData")
@RestController
@RequestMapping("views/mix/productionManagement")
public class MixAlarmDataController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixAlarmDataServiceImpl mixalarmdataSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixalarmdataSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixalarmdataSrv;
	}
    
    @Log(code="MixAlarmData_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixalarmdataSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
