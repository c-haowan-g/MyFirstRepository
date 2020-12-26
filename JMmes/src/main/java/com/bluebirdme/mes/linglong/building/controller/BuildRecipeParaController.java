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
import com.bluebirdme.mes.linglong.building.service.BuildRecipeParaServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * PLM配方下发基础参数表
 * @author 周清玉
 * @Date 2019-03-30 14:29:57
 */
@Log(code="AT_INT_PLM_BUILDRECIPEPARA_LOG",value="PLM配方下发基础参数表操作日志")
@RestController
@RequestMapping("building/basedata/buildrecipepara")
public class BuildRecipeParaController extends RockWellFunctionalUDAController<Object> {
    
    @Resource BuildRecipeParaServiceImpl buildrecipeparaSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return buildrecipeparaSrv;
    }

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return buildrecipeparaSrv;
	}
    
    @Log(code="AT_INT_PLM_BUILDRECIPEPARA_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
        buildrecipeparaSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(code="comboxparamtype",value="查询参数类型下拉框内容")
    @RequestMapping("comboxparamtype")
   	public String comboxparamtype() throws Exception{
    	List<Map<String,Object>> list=buildrecipeparaSrv.getComboxparamtype();
   		return toJson(list);
   	}

    @Log(code="comboxequiptype",value="获取设备类型下拉框")
    @RequestMapping("comboxequiptype")
   	public String comboxequiptype() throws Exception{
    	List<Map<String,Object>> list=buildrecipeparaSrv.getComboxequiptype();
   		return toJson(list);
   	}
    
	@Override
	@Log(value = "查询", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		return GsonTools.toJson(buildrecipeparaSrv.datagridUDA(filter, page));
	}


}
