/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.quickcheck.controller;

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
import com.bluebirdme.mes.linglong.quickcheck.service.PlmQucikCheckParaServiceImpl;


/**
 * PLM快检标准参数从表
 * @author 肖吉朔
 * @Date 2020-08-18 13:50:49
 */
@Log(code="11",value="PLM快检标准参数从表")
@RestController
@RequestMapping("quickcheck/para")
public class PlmQucikCheckParaController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmQucikCheckParaServiceImpl plmqucikcheckparaSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmqucikcheckparaSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmqucikcheckparaSrv;
	}
    
    @Log(code="11_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plmqucikcheckparaSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
