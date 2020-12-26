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
import com.bluebirdme.mes.linglong.mix.service.DrprodImplementgyServiceImpl;


/**
 * 密炼胶料产出工艺实绩表
 * @author 陈国强
 * @Date 2020-09-16 09:51:21
 */
@Log(code="DrprodImplementgy_log",value="密炼胶料产出工艺实绩日志")
@RestController
@RequestMapping("mix/productionManagement/drprodimplementgy")
public class DrprodImplementgyController extends RockWellFunctionalUDAController<Object> {
    
    @Resource DrprodImplementgyServiceImpl drprodimplementgySrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return drprodimplementgySrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return drprodimplementgySrv;
	}
    
    @Log(code="DrprodImplementgy_log_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        drprodimplementgySrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
