/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;


import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;

import com.bluebirdme.mes.linglong.curing.service.CuringCancelWorkServiceImpl;
import org.xdemo.app.xutils.ext.GsonTools;

import java.util.List;
import java.util.Map;


/**
 * 取消硫化作业履历表
 * @author 孙尊龙
 * @Date 2020-05-04 11:48:45
 */
@Log(code="LH_QXZY",value="取消硫化作业履历")
@RestController
@RequestMapping("curing/reportQuery/cancelWork")
public class CuringCancelWorkController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CuringCancelWorkServiceImpl curingcancelworkSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return curingcancelworkSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return curingcancelworkSrv;
	}

    @Override
    @Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
    @ResponseBody
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
        //Map<String,Object> map=getUDAService().datagridUDA(filter, page);
        return GsonTools.toJson(curingcancelworkSrv.datagridRowsUDA(filter, page));
    }

   

}
