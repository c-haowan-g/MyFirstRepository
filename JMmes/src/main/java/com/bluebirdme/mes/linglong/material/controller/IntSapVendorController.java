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
import com.bluebirdme.mes.linglong.material.service.IntSapVendorServiceImpl;


/**
 * 供应商信息表
 * @author 李昂
 * @Date 2020-08-05 08:17:20
 */
@Log(code="sap供应商查询",value="sap供应商查询")
@RestController
@RequestMapping("material/intsapvendor")
public class IntSapVendorController extends RockWellFunctionalUDAController<Object> {
    
    @Resource IntSapVendorServiceImpl intsapvendorSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return intsapvendorSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return intsapvendorSrv;
	}
    
    @Log(code="sap供应商查询_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        intsapvendorSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
