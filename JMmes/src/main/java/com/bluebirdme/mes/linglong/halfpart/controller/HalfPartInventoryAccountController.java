package com.bluebirdme.mes.linglong.halfpart.controller;

import javax.annotation.Resource;


import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.HalfPartInventoryAccountServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;

import com.bluebirdme.mes.linglong.halfpart.service.LedgerServiceImpl;


/**
 * (半部件)库存台账
 * @author 李新宇
 * @Date 2020-03-12 08:17:06
 */
@Log(code="库存台账查询",value="库存台账查询")
@RestController
@RequestMapping("halfpart/stockmanagement/halfpartInventoryAccount/halfpartinventoryaccount")
public class HalfPartInventoryAccountController extends RockWellFunctionalUDAController<Object> {
    
    @Resource
    HalfPartInventoryAccountServiceImpl ledgerSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return ledgerSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return ledgerSrv;
	}
    
    @Log(code="库存台账查询_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        ledgerSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

    /**
     * 超期申请
     * @return
     * @throws Exception
     */
    @Log(code="库存台账超期申请",value="库存台账超期申请",target=LogType.DB)
    @RequestMapping("Apply")
    public Object apply(String[] atr_keys) throws Exception {
        return ledgerSrv.apply(atr_keys);
    }


    /**
     * 延期处理
     * 李新宇
     * 2020/3/14 8:53
     */
    @Log(code="库存台账延期处理",value="库存台账延期处理",target=LogType.DB)
    @RequestMapping("handle")
    public Object handle(String[] atr_keys) throws Exception {
        return ledgerSrv.handle(atr_keys);
    }
}
