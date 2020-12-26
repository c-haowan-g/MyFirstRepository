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
import com.bluebirdme.mes.linglong.material.service.TestTaskDenialServiceImpl;


/**
 * TDM检测任务拒绝表[TDM发MES]
 * @author 李昂
 * @Date 2020-08-12 08:39:19
 */
@Log(code="拒绝表",value="拒绝表")
@RestController
@RequestMapping("material/testtaskdenial")
public class TestTaskDenialController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TestTaskDenialServiceImpl testtaskdenialSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return testtaskdenialSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return testtaskdenialSrv;
	}
    
    @Log(code="拒绝表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        testtaskdenialSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
