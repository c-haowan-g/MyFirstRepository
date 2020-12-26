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
import com.bluebirdme.mes.linglong.mix.service.PlmMixWeightExecHisServiceImpl;


/**
 * PLM密炼称量执行历史表
 * @author 栾和源
 * @Date 2020-08-13 13:44:22
 */
@Log(code="PLM密炼称量执行历史",value="PLM密炼称量执行历史")
@RestController
@RequestMapping("mix/qualityManagement/plmmixweightexechis")
public class PlmMixWeightExecHisController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmMixWeightExecHisServiceImpl plmmixweightexechisSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmmixweightexechisSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmmixweightexechisSrv;
	}
    
    @Log(code="PLM密炼称量执行历史_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plmmixweightexechisSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
