/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

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
import com.bluebirdme.mes.linglong.building.service.StorageAreaHisServiceImpl;


/**
 * 成型线边库历史表
 * @author 李昂
 * @Date 2020-11-25 08:03:01
 */
@Log(code="AT_B_MM_STORAGEAREA_HIS",value="成型线边库历史表")
@RestController
@RequestMapping("building/report/storageareahis")
public class StorageAreaHisController extends RockWellFunctionalUDAController<Object> {
    
    @Resource StorageAreaHisServiceImpl storageareahisSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return storageareahisSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return storageareahisSrv;
	}
    
    @Log(code="AT_B_MM_STORAGEAREA_HIS_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        storageareahisSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
