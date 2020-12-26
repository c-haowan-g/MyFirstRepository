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
import com.bluebirdme.mes.linglong.mix.service.PlmMixWeightEditServiceImpl;


/**
 * PLM密炼称量维护表
 * @author 栾和源
 * @Date 2020-08-12 09:40:32
 */
@Log(code="PLM密炼称量维护",value="PLM密炼称量维护")
@RestController
@RequestMapping("mix/qualityManagement/plmmixweightedit")
public class PlmMixWeightEditController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmMixWeightEditServiceImpl plmmixweighteditSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmmixweighteditSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmmixweighteditSrv;
	}
    
    @Log(code="PLM密炼称量维护_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plmmixweighteditSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
