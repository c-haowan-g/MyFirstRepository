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
import com.bluebirdme.mes.linglong.mix.service.DrprodServiceImpl;


/**
 * 密炼胶料产出实绩表
 * @author 栾和源
 * @Date 2020-08-04 09:34:26
 */
@Log(code="密炼胶料产出实绩",value="密炼胶料产出实绩")
@RestController
@RequestMapping("mix/productionManagement/drprod")
public class DrprodController extends RockWellFunctionalUDAController<Object> {
    
    @Resource DrprodServiceImpl drprodSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return drprodSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return drprodSrv;
	}
 
  //重新下发
    @RequestMapping("downward")
	public Response downward(Long[] ids) throws Exception {
		 return Response.suc(drprodSrv.downward(ids));
	}

}
