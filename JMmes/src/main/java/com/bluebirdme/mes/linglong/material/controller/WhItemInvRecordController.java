/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.controller;

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
import com.bluebirdme.mes.linglong.material.service.WhItemInvRecordServiceImpl;


/**
 * 原材料库存操作履历表
 * @author 李昂
 * @Date 2020-08-07 08:55:29
 */
@Log(code="原材料库存操作履历表",value="原材料库存操作履历表")
@RestController
@RequestMapping("material/reportsCenter/whiteminvrecord")
public class WhItemInvRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource WhItemInvRecordServiceImpl whiteminvrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return whiteminvrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return whiteminvrecordSrv;
	}
    
    @Log(code="原材料库存操作履历表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        whiteminvrecordSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
