/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;


import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;

import com.bluebirdme.mes.linglong.finalcheck.service.CheckxrayResultlogServiceImpl;


/**
 * X光质检信息日志查询
 * @author 李新宇
 * @Date 2020-04-15 10:51:34
 */
@Log(code="X光质检信息日志查询",value="X光质检信息日志查询")
@RestController
@RequestMapping("/finalcheck/qualityInspectionRecord/checkxrayResultLog/checkxrayresultlog")
public class CheckxrayResultlogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CheckxrayResultlogServiceImpl checkxrayresultlogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return checkxrayresultlogSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return checkxrayresultlogSrv;
	}
    
    @Log(code="X光质检信息日志查询_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        checkxrayresultlogSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
