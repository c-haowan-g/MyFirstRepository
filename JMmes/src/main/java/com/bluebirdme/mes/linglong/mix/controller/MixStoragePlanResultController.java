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
import com.bluebirdme.mes.linglong.mix.service.MixStoragePlanResultServiceImpl;


/**
 * 盘库结果管理
 * @author 陈国强
 * @Date 2020-08-20 08:13:07
 */
@Log(code="AT_CM_WH_ITEM_INV_RESULT",value="盘库结果管理")
@RestController
@RequestMapping("mix/storageManagement/mixStoragePlanResult")
public class MixStoragePlanResultController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixStoragePlanResultServiceImpl mixstorageplanresultSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixstorageplanresultSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixstorageplanresultSrv;
	}
    
    @Log(code="AT_CM_WH_ITEM_INV_RESULT_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixstorageplanresultSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    /*@RequestMapping({"lock"})
    public Response lock(Long[] ids) throws Exception {
      return Response.suc(this.materialstockplanresultSrv.lock(ids));
    }
    
    @RequestMapping({"onsave"})
    public Response onsave(Long[] ids) throws Exception {
      return Response.suc(this.materialstockplanresultSrv.onsave(ids));
    }
  }*/
}
