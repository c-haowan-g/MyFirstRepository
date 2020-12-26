/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.building.entity.Machine_Formula;
import com.bluebirdme.mes.linglong.building.service.Machine_FormulaServiceImpl;
import com.bluebirdme.mes.linglong.building.excel.Machine_FormulaExportHandler;

/**
 * 成型工艺配方查询
 * @author whl
 * @Date 2019-02-18 13:47:29
 */
@Log(code="成型工艺配方查询",value="成型工艺配方查询")
@RestController
@RequestMapping("building/productionManagement/machine_Formula")
public class Machine_FormulaController extends RockWellFunctionalUDAController<Object> {
    
    @Resource Machine_FormulaServiceImpl machine_formulaSrv;
    Machine_FormulaExportHandler machine_FormulaExportHandler = new Machine_FormulaExportHandler();

    
   
    
    @Override
   	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@ResponseBody
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
        if(filter.get("status_s")!=null&&filter.get("status_s").equals("on")){
        	filter.set("status_s", "152003");//页面初始化只查询正执行参数
		}else{
			filter.set("status_s", "152002,152004");//页面初始化只查询正执行参数
		}
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("agenc_no_s", FactoryConstant.JING_MEN_CODE);
   		return GsonTools.toJson(machine_formulaSrv.datagridUDA(filter, page));
   	}
    
    /**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByEquipCode")
	public String searchByEquipCode() {
		List<Map<String, Object>> list = machine_formulaSrv.searchByEquipCode();
		return toJson(list);
	}
	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByMaterialCode")
	public String searchByMaterialCode() {
		List<Map<String, Object>> list = machine_formulaSrv.searchByMaterialCode();
		return toJson(list);
	}
	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByProductionStep")
	public String searchByProductionStep() {
		List<Map<String, Object>> list = machine_formulaSrv.searchByProductionStep();
		return toJson(list);
	}
	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByVersion")
	public String searchByVersion() {
		List<Map<String, Object>> list = machine_formulaSrv.searchByVersion();
		return toJson(list);
	}
	
	/**
	 * 根据左侧信息查询工艺参数ID等右侧数据
	 * @return
	 */
	@Log(value = "配方参数列表查询", code = "FUNC_007", target = LogType.CONSOLE)
	@RequestMapping("datagrid2")
	public String datagrid2(String equipcode_s,String materialcode_s,String productionstep_s,String versions) {
		List<Map<String, Object>> list = machine_formulaSrv.searchByMaterialCode_s(equipcode_s,materialcode_s,productionstep_s,versions);
		return toJson(list);
	}

	//数据导出
  	@RequestMapping("export")
  	public String exprot(@RequestParam("s_factory_s")String s_factory_s,HttpServletRequest request,
  			HttpServletResponse response,Filter filter,Page page) throws Exception{
  		filter.set("s_factory_s", s_factory_s);
  		
  		@SuppressWarnings("unchecked")
		List<Machine_Formula> listUp = machine_formulaSrv.datagridAllRows(filter,Machine_Formula.class);
  		
		machine_FormulaExportHandler.exportService(request, response,listUp);
  		return null;
  	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return machine_formulaSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return machine_formulaSrv;
	}
	
}
