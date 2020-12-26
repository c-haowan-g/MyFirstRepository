/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.HalfpartMachineFormulaSearchServiceImpl;


/**
 * 半部件机台工艺参数查询
 * @author 李德晓
 * @Date 2020-03-11 15:06:47
 */
@Log(code="半部件机台工艺参数查询",value="半部件机台工艺参数查询")
@RestController
@RequestMapping("halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch")
public class HalfpartMachineFormulaSearchController extends RockWellFunctionalUDAController<Object> {
    
    @Resource HalfpartMachineFormulaSearchServiceImpl halfpartmachineformulasearchSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return halfpartmachineformulasearchSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return halfpartmachineformulasearchSrv;
	}
    @RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    @Log(code = "searchEquip_code_s", value = "查出机台条码显示在JSP页面下拉列表处")
   	@RequestMapping("searchEquip_code_s")
   	public String searchEquip_code_s() throws Exception {
   		List<Map<String, Object>> list = halfpartmachineformulasearchSrv.searchEquip_code_s();
   		System.out.println(list);
   		return toJson(list);
   	}
    @Log(code = "searchMaterial_code_s", value = "查出物料编码显示在JSP页面下拉列表处")
   	@RequestMapping("searchMaterial_code_s")
   	public String searchMaterial_code_s() throws Exception {
   		List<Map<String, Object>> list = halfpartmachineformulasearchSrv.searchMaterial_code_s();
   		System.out.println(list);
   		return toJson(list);
   	}
    @Log(code = "searchProduction_step_s", value = "查出产品阶段显示在JSP页面下拉列表处")
   	@RequestMapping("searchProduction_step_s")
   	public String searchProduction_step_s() throws Exception {
   		List<Map<String, Object>> list = halfpartmachineformulasearchSrv.searchProduction_step_s();
   		System.out.println(list);
   		return toJson(list);
   	}
    @Log(code = "searchMaterial_desc_s", value = "查出版本号显示在JSP页面下拉列表处")
   	@RequestMapping("searchMaterial_desc_s")
   	public String searchMaterial_desc_s() throws Exception {
   		List<Map<String, Object>> list = halfpartmachineformulasearchSrv.searchMaterial_desc_s();
   		System.out.println(list);
   		return toJson(list);
   	}

}
