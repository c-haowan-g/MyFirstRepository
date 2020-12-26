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
import com.bluebirdme.mes.linglong.mix.service.MixRecipeWeightProdServiceImpl;


/**
 * 密炼小料包产出称量实绩表
 * @author 栾和源
 * @Date 2020-08-07 15:29:59
 */
@Log(code="密炼小料包产出称量实绩表",value="密炼小料包产出称量实绩表")
@RestController
@RequestMapping("mix/productionManagement/mixrecipeweightprod")
public class MixRecipeWeightProdController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixRecipeWeightProdServiceImpl mixrecipeweightprodSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixrecipeweightprodSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixrecipeweightprodSrv;
	}
    
    @Log(code="密炼小料包产出称量实绩表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixrecipeweightprodSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
