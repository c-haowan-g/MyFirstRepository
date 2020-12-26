/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.quickcheck.controller;

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
import com.bluebirdme.mes.linglong.quickcheck.service.ReasWarnServiceImpl;


/**
 * 病象预警等级表
 * @author 肖吉朔
 * @Date 2020-08-07 13:21:10
 */
@Log(code="11",value="病象预警等级表")
@RestController
@RequestMapping("/quickcheck/statistatement/reaswarn")
public class ReasWarnController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ReasWarnServiceImpl reaswarnSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return reaswarnSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return reaswarnSrv;
	}
    
    @Log(code="11_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        reaswarnSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
