/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import javax.annotation.Resource;

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
import com.bluebirdme.mes.linglong.sap.service.VendorLogServiceImpl;

/**
 * 供应商信息表历史
 * @author 周清玉
 * @Date 2018-10-17 14:17:21
 */
@Log(code="供应商信息表日志",value="供应商信息表日志")
@RestController
@RequestMapping("sap/VendorLog/VendorLog")
public class VendorLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource VendorLogServiceImpl vendorlogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return vendorlogSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return vendorlogSrv;
	}
    
    @Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridOn")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(vendorlogSrv.datagridUDA(filter, page));
	}

	

}
