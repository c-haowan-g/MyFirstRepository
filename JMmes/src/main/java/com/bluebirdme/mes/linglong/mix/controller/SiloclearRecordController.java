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
import com.bluebirdme.mes.linglong.mix.service.SiloclearRecordServiceImpl;


/**
 * 密炼料仓清理履历表
 * @author 栾和源
 * @Date 2020-08-05 08:57:48
 */
@Log(code="密炼料仓清理履历",value="密炼料仓清理履历")
@RestController
@RequestMapping("mix/productionManagement/siloclearrecord")
public class SiloclearRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource SiloclearRecordServiceImpl siloclearrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return siloclearrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return siloclearrecordSrv;
	}
    
   

}
