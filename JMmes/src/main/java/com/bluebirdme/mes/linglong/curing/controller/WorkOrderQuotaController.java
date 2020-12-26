/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.Map;

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
import com.bluebirdme.mes.linglong.curing.entity.WorkOrderQuota;
import com.bluebirdme.mes.linglong.curing.service.WorkOrderQuotaServiceImpl;

/**
 * 硫化工单生产实绩表
 * @author 周志祥
 * @Date 2018-11-10 11:17:18
 */
@Log(code="AT_C_MM_WORKORDERRESULTPRINT_Log",value="硫化产量报表查询")
@RestController
@RequestMapping("curing/CuringOutputCollect/WorkOrderQuota")
public class WorkOrderQuotaController extends RockWellFunctionalController<WorkOrderQuota> {
    
    @Resource WorkOrderQuotaServiceImpl workordquotaSrv;

    @Override
    protected RockWellBaseServiceImpl<WorkOrderQuota> getService() {
        return workordquotaSrv;
    }
    
    
    
    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getService().datagrid(filter, page, WorkOrderQuota.class));
	}

    
    @RequestMapping("selectWorkOrderData")
    public Response selectWorkOrderData(@RequestBody Map<String, Object> list_map) throws Exception{
    	return Response.suc(workordquotaSrv.selectWorkOrderData(list_map));
    }

}
