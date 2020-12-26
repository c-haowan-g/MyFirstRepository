/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.controller;

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
import com.bluebirdme.mes.linglong.material.service.IntSapDnServiceImpl;


/**
 * 发布内向交货单到 MES 系统（SAP->MES）行项目信息
 * @author 李昂
 * @Date 2020-08-05 08:23:47
 */
@Log(code="sap内向交货单",value="sap内向交货单")
@RestController
@RequestMapping("material/intsapdn")
public class IntSapDnController extends RockWellFunctionalUDAController<Object> {
    
    @Resource IntSapDnServiceImpl intsapdnSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return intsapdnSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return intsapdnSrv;
	}
    
    @Log(code="sap内向交货单_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        intsapdnSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
