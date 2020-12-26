/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.MoldoutstoreServiceImpl;

/**
 * 模具出库记录
 * @author whl
 * @Date 2018-10-03 15:16:26
 */
@Log(code="LH_MJGL_MJCKJL",value="模具出库记录日志")
@RestController
@RequestMapping("curing/MoldManagement/moldoutstore")
public class MoldoutstoreController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MoldoutstoreServiceImpl moldoutstoreSrv;

  

    @Override
  	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
  	@ResponseBody
  	@RequestMapping("datagrid")
  	public String datagrid(Filter filter, Page page) throws Exception {
  		return GsonTools.toJson(moldoutstoreSrv.datagridUDA(filter, page));
  	}


	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return moldoutstoreSrv;
	}


	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return moldoutstoreSrv;
	}
    
    
}
