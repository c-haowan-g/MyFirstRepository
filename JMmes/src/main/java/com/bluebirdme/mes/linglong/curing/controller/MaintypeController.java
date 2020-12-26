/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.curing.service.MaintypeServiceImpl;

/**
 * 
 * @author qingyu_zhou
 * 返修胎合格率统计
 *
 */
@Log(code="MaintypeLog",value="轮胎返修合格率")
@RestController
@RequestMapping("curing/reworkprocess/Maintype")
public class MaintypeController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaintypeServiceImpl maintypeSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return maintypeSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return maintypeSrv;
	}
    

    @Override
   	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@ResponseBody
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
   		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
   	}


	
    
}
