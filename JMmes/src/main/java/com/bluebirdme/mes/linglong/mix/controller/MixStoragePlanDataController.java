/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.List;
import java.util.Map;
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
import com.bluebirdme.mes.linglong.mix.service.MixStoragePlanDataServiceImpl;


/**
 * 盘库数据管理表
 * @author 陈国强
 * @Date 2020-08-18 16:19:22
 */
@Log(code="AT_CM_WH_ITEM_INV_EXEC",value="盘库数据管理表")
@RestController
@RequestMapping("mix/storageManagement/mixStoragePlanData")
public class MixStoragePlanDataController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixStoragePlanDataServiceImpl mixstorageplandataSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixstorageplandataSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixstorageplandataSrv;
	}
    
    @Log(code="AT_CM_WH_ITEM_INV_EXEC_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixstorageplandataSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @RequestMapping({"getJobName"})
    public String getJobName(String date) throws Exception {
      List<Map<String, Object>> getJobName = this.mixstorageplandataSrv.getJobName(date);
      return toJson(getJobName);
    }
    /*@RequestMapping({"lock"})
    public Response lock(Long[] ids) throws Exception {
      return Response.suc(this.mixstorageplandataSrv.lock(ids));
    }
    
    @RequestMapping({"unlock"})
    public Response unlock(Long[] ids) throws Exception {
      return Response.suc(this.mixstorageplandataSrv.unlock(ids));
    }
    
    @RequestMapping({"scanning"})
    public Response scanning(Long[] ids) throws Exception {
      return Response.suc(this.mixstorageplandataSrv.scanning(ids));
    }
    
    @RequestMapping({"deletes"})
    public Response deletes(Long[] ids) throws Exception {
      return Response.suc(this.mixstorageplandataSrv.deletes(ids));
    }*/
}
