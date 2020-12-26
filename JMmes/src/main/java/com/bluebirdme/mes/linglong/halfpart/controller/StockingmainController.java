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
import com.bluebirdme.mes.linglong.halfpart.service.StockingmainServiceImpl;


/**
 * (半部件)盘库记录主表
 * @author 肖吉朔
 * @Date 2020-09-01 14:09:12
 */
@Log(code="111",value="(半部件)盘库记录主表")
@RestController
@RequestMapping("halfpart/stockingRecord/stockingmain")
public class StockingmainController extends RockWellFunctionalUDAController<Object> {
    
    @Resource StockingmainServiceImpl stockingmainSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return stockingmainSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return stockingmainSrv;
	}
    
    @Log(code="111_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        stockingmainSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
