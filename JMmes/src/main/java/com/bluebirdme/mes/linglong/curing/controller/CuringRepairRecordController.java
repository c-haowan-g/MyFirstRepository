/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.Map;

import javax.annotation.Resource;




import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.CuringRepairRecordServiceImpl;


/**
 * 硫化返修记录
 * @author 王超
 * @Date 2020-04-09 12:00:47
 */
@Log(code="123",value="123")
@RestController
@RequestMapping("curing/ReportQuery/CuringRepairRecord")
public class CuringRepairRecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CuringRepairRecordServiceImpl curingrepairrecordSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return curingrepairrecordSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return curingrepairrecordSrv;
	}
    
    /**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 *             王超
	 */
	@Log(code = "curingrepairrecord", value = "查询全部页面初始化使用")
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		Map map = curingrepairrecordSrv.datagridUDA(filter, page);
		return toJson(map);
	}

}
