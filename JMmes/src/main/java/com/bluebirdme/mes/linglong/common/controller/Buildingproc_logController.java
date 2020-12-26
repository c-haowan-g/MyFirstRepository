/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.util.List;
import java.util.Map;

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
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.common.service.Buildingproc_logServiceImpl;

/**
 * PLM成型工艺表日志
 * @author 时永良
 * @Date 2018-10-18 08:58:27
 */
@Log(code="CX_ZLGL_CXGYCSLOG",value="PLM成型日志")
@RestController
@RequestMapping("common/BuildingprocessLog/buildingprocesslog")
public class Buildingproc_logController extends RockWellFunctionalUDAController<Object> {
    
    @Resource Buildingproc_logServiceImpl buildingproc_logSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return buildingproc_logSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return buildingproc_logSrv;
	}
    
    @Log(value = "成型工艺参数日志列表查询", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("datagrid2")
   	public String datagrid2(String ids) {
   		List<Map<String, Object>> list = buildingproc_logSrv.searchByMaterial(ids);
   		return toJson(list);
   	}
    
    @Override
   	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@ResponseBody
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
   		return GsonTools.toJson(buildingproc_logSrv.datagridUDA(filter, page));
   	}

}
