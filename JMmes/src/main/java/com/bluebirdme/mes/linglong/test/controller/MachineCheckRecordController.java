/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.test.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.test.service.MachineCheckRecordServiceImpl;

/**
 * 开班检查表
 * @author 周清玉
 * @Date 2019-08-09 08:42:13
 */
@Log(code="框架测试",value="框架测试")
@RestController
@RequestMapping("test/MachineCheckRecord")
public class MachineCheckRecordController extends RockWellFunctionalUDAController<Object> {
    
	 @Resource MachineCheckRecordServiceImpl machinecheckrecordSrv;
	    

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return machinecheckrecordSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return machinecheckrecordSrv;
	}

	@Log(code="框架测试_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
	        machinecheckrecordSrv.saveChanges(rockWellEntityDTO);
	        return Response.suc();
	    }

}
