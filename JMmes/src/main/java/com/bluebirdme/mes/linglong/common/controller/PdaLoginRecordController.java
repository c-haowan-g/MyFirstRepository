/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.common.service.PdaLoginRecordServiceImpl;

/**
 * 手持登录履历表
 * @author 王超
 * @Date 2020-06-04 09:14:13
 */
@Log(code="手持登录履历表",value="手持登录履历表")
@RestController
@RequestMapping("common/pdaloginrecord")
public class PdaLoginRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PdaLoginRecordServiceImpl pdalogin_recordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return pdalogin_recordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return pdalogin_recordSrv;
	}
    
    @Override
    @Log(value = "查询列表", code = "ALL")
    @ResponseBody
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = pdalogin_recordSrv.datagridUDA(filter, page);
		return toJson(map);
    }
    
}
