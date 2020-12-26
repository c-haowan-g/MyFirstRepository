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
import com.bluebirdme.mes.linglong.mix.service.ReturnPolyRecordServiceImpl;


/**
 * 密炼退料登记表
 * @author 边朝会
 * @Date 2020-08-07 10:19:11
 */
@Log(code="ReturnPolyRecord",value="ReturnPolyRecord")
@RestController
@RequestMapping("view/mix/productionManagement")
public class ReturnPolyRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ReturnPolyRecordServiceImpl returnpolyrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return returnpolyrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return returnpolyrecordSrv;
	}
    
    @Log(code="ReturnPolyRecord_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        returnpolyrecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
