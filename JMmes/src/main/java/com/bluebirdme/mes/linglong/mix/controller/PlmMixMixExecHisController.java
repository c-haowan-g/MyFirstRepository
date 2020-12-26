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
import com.bluebirdme.mes.linglong.mix.service.PlmMixMixExecHisServiceImpl;


/**
 * PLM密炼工艺执行历史表
 * @author 栾和源
 * @Date 2020-08-13 13:50:26
 */
@Log(code="PLM密炼工艺执行历史",value="PLM密炼工艺执行历史")
@RestController
@RequestMapping("mix/qualityManagement/plmmixmixexechis")
public class PlmMixMixExecHisController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmMixMixExecHisServiceImpl plmmixmixexechisSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmmixmixexechisSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmmixmixexechisSrv;
	}
    
    @Log(code="PLM密炼工艺执行历史_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plmmixmixexechisSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
