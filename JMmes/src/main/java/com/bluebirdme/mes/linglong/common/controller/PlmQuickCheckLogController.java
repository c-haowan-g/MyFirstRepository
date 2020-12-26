/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

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
import com.bluebirdme.mes.linglong.common.service.PlmQuickCheckLogServiceImpl;


/**
 * PLM快检标准参数日志主表
 * @author 肖吉朔
 * @Date 2020-08-26 10:00:10
 */
@Log(code="111",value="PLM快检标准参数日志主表")
@RestController
@RequestMapping("common/PlmQuickCheckLog")
public class PlmQuickCheckLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmQuickCheckLogServiceImpl plmquickchecklogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmquickchecklogSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmquickchecklogSrv;
	}
    
    @Log(code="111_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plmquickchecklogSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
