/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.curing.service.CapsuleServiceImpl;

/**
 * 胶囊信息表
 * @author 王超
 * @Date 2020-08-19 08:21:54
 */
@Log(code="胶囊使用履历",value="胶囊使用履历")
@RestController
@RequestMapping("curing/moldManagement/capsule")
public class CapsuleController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CapsuleServiceImpl capsuleSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return capsuleSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return capsuleSrv;
	}
    
    @Override
    @Log(code = "胶囊使用履历", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}

}
