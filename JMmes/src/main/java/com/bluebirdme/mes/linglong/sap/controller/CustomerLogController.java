/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.CustomerLogServiceImpl;


/**
 * 客户住数据信息日志
 * @author 周清玉
 * @Date 2018-10-17 15:29:18
 */
@Log(code="客户住数据信息日志",value="客户住数据信息日志")
@RestController
@RequestMapping("sap/CustomerLog")
public class CustomerLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CustomerLogServiceImpl customerlogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return customerlogSrv;
    }

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return customerlogSrv;
	}
    
    
	@Log(value = "查询全部数据", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridOn")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(customerlogSrv.datagridUDA(filter, page));
	}

}
