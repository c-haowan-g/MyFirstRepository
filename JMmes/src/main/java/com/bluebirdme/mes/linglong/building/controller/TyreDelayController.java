/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

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
import com.bluebirdme.mes.linglong.building.service.TyreDelayServiceImpl;


/**
 * 胎胚延期表
 * @author 王海霖
 * @Date 2020-02-26 15:36:01
 */
@Log(code="胎胚延期",value="胎胚延期")
@RestController
@RequestMapping("building/report/tyreDelay")
public class TyreDelayController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TyreDelayServiceImpl tyredelaySrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return tyredelaySrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return tyredelaySrv;
	}
    
    @Log(code="胎胚延期_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        tyredelaySrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
