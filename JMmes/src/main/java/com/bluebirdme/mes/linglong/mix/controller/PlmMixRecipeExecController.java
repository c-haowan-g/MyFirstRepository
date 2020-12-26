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
import com.bluebirdme.mes.linglong.mix.service.PlmMixRecipeExecServiceImpl;


/**
 * PLM密炼配方执行表
 * @author 栾和源
 * @Date 2020-08-12 16:42:35
 */
@Log(code="PLM密炼配方执行",value="PLM密炼配方执行")
@RestController
@RequestMapping("mix/qualityManagement/plmmixrecipeexec")
public class PlmMixRecipeExecController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmMixRecipeExecServiceImpl plmmixrecipeexecSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmmixrecipeexecSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmmixrecipeexecSrv;
	}
    
    @Log(code="PLM密炼配方执行_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plmmixrecipeexecSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
