/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.quickcheck.controller;

import javax.annotation.Resource;


import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;



import org.apache.http.HttpRequest;
import org.jboss.logging.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.quickcheck.service.PlmQucikCheckParaHisServiceImpl;


/**
 * PLM快检标准参数从表
 * @author 肖吉朔
 * @Date 2020-08-09 10:15:22
 */
@Log(code="11",value="PLM快检标准参数从表")
@RestController
@RequestMapping("/quickcheck/parahis")
public class PlmQucikCheckParaHisController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmQucikCheckParaHisServiceImpl parahisSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return parahisSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return parahisSrv;
	}
    
    @Log(code="11_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        parahisSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
  
    
   
}
