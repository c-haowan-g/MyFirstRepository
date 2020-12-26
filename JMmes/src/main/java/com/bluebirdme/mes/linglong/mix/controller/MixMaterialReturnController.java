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
import com.bluebirdme.mes.linglong.mix.service.MixMaterialReturnServiceImpl;


/**
 * 密炼退料登记表
 * @author 栾和源
 * @Date 2020-08-07 16:31:49
 */
@Log(code="密炼退料登记",value="密炼退料登记")
@RestController
@RequestMapping("mix/productionManagement/mixmaterialreturn")
public class MixMaterialReturnController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixMaterialReturnServiceImpl mixmaterialreturnSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixmaterialreturnSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixmaterialreturnSrv;
	}
    
    @Log(code="密炼退料登记_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixmaterialreturnSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
