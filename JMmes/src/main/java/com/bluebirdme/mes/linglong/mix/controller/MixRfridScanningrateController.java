/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import javax.annotation.Resource;

import org.xdemo.app.xutils.ext.GsonTools;
import com.bluebirdme.core.system.web.Filter;
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
import com.bluebirdme.mes.linglong.mix.service.MixRfridScanningrateServiceImpl;


/**
 * PLM密炼物料表
 * @author 陈国强
 * @Date 2020-08-25 08:21:09
 */
@Log(code="AT_INT_PLM_MIXMATERIAL",value="PLM密炼物料表")
@RestController
@RequestMapping("mix/report/mixrfridscanningrate")
public class MixRfridScanningrateController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixRfridScanningrateServiceImpl mixrfridscanningrateSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixrfridscanningrateSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixrfridscanningrateSrv;
	}
    
    @Log(code="AT_INT_PLM_MIXMATERIAL_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixrfridscanningrateSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(code="getAll", value="RFID扫描率查询")
    @RequestMapping({"getAll"})
    public String getAll(Filter filter) throws Exception { 
    	return GsonTools.toJson(this.mixrfridscanningrateSrv.getAll(filter)); 
    	
    }


}
