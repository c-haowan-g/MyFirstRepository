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
import com.bluebirdme.mes.linglong.material.service.TestTaskDetialServiceImpl;


/**
 * TDM检测结果明细表[TDM发MES]
 * @author 李昂
 * @Date 2020-08-12 08:40:37
 */
@Log(code="AT_INT_TDM_TESTTASKDETIAL",value="明细表")
@RestController
@RequestMapping("material/testtaskdetial")
public class TestTaskDetialController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TestTaskDetialServiceImpl testtaskdetialSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return testtaskdetialSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return testtaskdetialSrv;
	}
    
    @Log(code="AT_INT_TDM_TESTTASKDETIAL_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        testtaskdetialSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
