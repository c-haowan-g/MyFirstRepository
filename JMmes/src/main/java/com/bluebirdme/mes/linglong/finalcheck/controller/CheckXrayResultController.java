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

import com.bluebirdme.mes.linglong.finalcheck.service.CheckXrayResultServiceImpl;


/**
 * X光质检信息表
 * @author 李新宇
 * @Date 2020-02-24 08:38:10
 */
@Log(code="X光质检信息表",value="X光质检信息表")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/CheckXrayResult")
public class CheckXrayResultController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CheckXrayResultServiceImpl checkxrayresultSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return checkxrayresultSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return checkxrayresultSrv;
	}
    
    @Log(code="X光质检信息表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        checkxrayresultSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
