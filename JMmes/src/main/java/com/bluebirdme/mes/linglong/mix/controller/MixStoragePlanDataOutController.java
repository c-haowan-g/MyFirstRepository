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
import com.bluebirdme.mes.linglong.mix.service.MixStoragePlanDataOutServiceImpl;


/**
 * 盘库数据管理出库表
 * @author 陈国强
 * @Date 2020-08-18 16:29:32
 */
@Log(code="AT_CM_WH_ITEM_INV_EXEC_OUT",value="盘库数据管理出库表")
@RestController
@RequestMapping("mix/storageManagement/mixStoragePlanDataOut")
public class MixStoragePlanDataOutController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixStoragePlanDataOutServiceImpl mixstorageplandataoutSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixstorageplandataoutSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixstorageplandataoutSrv;
	}
    
    @Log(code="AT_CM_WH_ITEM_INV_EXEC_OUT_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixstorageplandataoutSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
