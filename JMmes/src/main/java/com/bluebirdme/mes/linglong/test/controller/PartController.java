/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.test.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.core.system.base.BaseController;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.test.service.PartServiceImpl;
import com.bluebirdme.mes.linglong.test.entity.dto.UdaDto;

/**
 * 测试新封装
 * @author 周清玉
 * @Date 2019-06-19 14:43:16
 */
@Log(code="demoTestLog",value="测试新封装日志")
@RestController
@RequestMapping("demoTest")
public class PartController extends RockWellFunctionalUDAController<Object> {
	
	@Resource PartServiceImpl partSrv;
	    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return partSrv;
	}
	
	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return partSrv;
	}
	
    @Log(code="demoTestLog_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody UdaDto udaDto ) throws Exception {
        partSrv.saveChanges(udaDto);
        return Response.suc();
    }


    
}
