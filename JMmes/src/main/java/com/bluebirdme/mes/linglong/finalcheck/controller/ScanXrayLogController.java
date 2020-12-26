/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanXrayLog;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanXrayLogServiceImpl;

/**
 * X光扫描履历表
 * @author 时永良
 * @Date 2018-08-05 09:07:46
 */
@Log(code="ZJ_JZGL_XGSLL",value="X光扫描履历日志")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/scanXrayLog")
public class ScanXrayLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ScanXrayLogServiceImpl scanxraylogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return scanxraylogSrv;
    }
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
    	return scanxraylogSrv;
	}
    
    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	if(filter.getFilter().containsKey("barcode_s")){
			filter.set("begin_created_time","");
			filter.set("end_created_time","");
		}
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
}
