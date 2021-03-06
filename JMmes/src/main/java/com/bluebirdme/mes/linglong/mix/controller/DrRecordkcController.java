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
import com.bluebirdme.mes.linglong.mix.service.DrRecordkcServiceImpl;


/**
 * 密炼库存操作履历表
 * @author 陈国强
 * @Date 2020-08-16 09:58:50
 */
@Log(code="AT_MX_WH_ITEM_INV_RECORD",value="密炼库存操作履历表")
@RestController
@RequestMapping("mix/storageManagement/drRecordkc")
public class DrRecordkcController extends RockWellFunctionalUDAController<Object> {
    
    @Resource DrRecordkcServiceImpl drrecordkcSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return drrecordkcSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return drrecordkcSrv;
	}
    
    @Log(code="AT_MX_WH_ITEM_INV_RECORD_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        drrecordkcSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
