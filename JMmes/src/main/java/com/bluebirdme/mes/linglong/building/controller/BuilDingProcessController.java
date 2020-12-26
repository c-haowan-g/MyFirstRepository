/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;
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
import com.bluebirdme.mes.linglong.building.service.BuilDingProcessServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 成型工艺参数配方查询
 * @author 周清玉
 * @Date 2019-08-15 08:40:14
 */
@Log(code="CX_ZLGL_CXGYCS",value="成型工艺参数配方查询日志")
@RestController
@RequestMapping("/building/quailtyManageMent/buildingProcess")
public class BuilDingProcessController extends RockWellFunctionalUDAController<Object> {
    
    @Resource BuilDingProcessServiceImpl buildingprocessSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return buildingprocessSrv;
    }
    

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return buildingprocessSrv;
	}

	 @Override
	 @Log(value = "成型工艺参数查询列表", code = "ALL", target = LogType.CONSOLE)
	 @ResponseBody
	 @RequestMapping("datagrid")
	 public String datagrid(Filter filter, Page page) throws Exception {
	   		return GsonTools.toJson(buildingprocessSrv.datagridUDA_Ping(filter, page));
	 }
    
    @Log(value = "工艺参数列表查询", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("datagrid2")
   	public String datagrid2(String key) {
   		List<Map<String, Object>> list = buildingprocessSrv.searchByMaterial(key);
   		return toJson(list);
   	}
    
    @Log(code="colorMarkingLine",value="查询ERP代码和色标线功能")
    @RequestMapping("colorMarkingLine")
   	public String colorMarkingLine() throws Exception{
    	List<Map<String,Object>> list=buildingprocessSrv.getColorMarkingLine();
   		return toJson(list);
   	}


}
