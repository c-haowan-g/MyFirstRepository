/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.bluebirdme.mes.linglong.halfpart.service.PlmHalfpartRecipeParaServiceImpl;


/**
 * PLM半部件配方下发基础参数表
 * @author 李德晓
 * @Date 2020-03-16 15:31:45
 */
@Log(code="PLM半部件配方下发基础参数表",value="PLM半部件配方下发基础参数表")
@RestController
@RequestMapping("halfpart/baseData/plmHalfpartRecipePara")
public class PlmHalfpartRecipeParaController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlmHalfpartRecipeParaServiceImpl plmhalfpartrecipeparaSrv;
    @Override
    @Log(code = "半部件全钢操作工登录履历", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plmhalfpartrecipeparaSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plmhalfpartrecipeparaSrv;
	}
    
    @Log(code="PLM半部件配方下发基础参数表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plmhalfpartrecipeparaSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(code = "searchEquipmenttypecode_s", value = "查出设备类型名称显示在JSP页面下拉列表处")
   	@RequestMapping("searchEquipmenttypecode_s")
   	public String searchEquipmenttypecode_s() throws Exception {
   		List<Map<String, Object>> list = plmhalfpartrecipeparaSrv.searchEquipmenttypecode_s();
   		return toJson(list);
   	} 
    @Log(code = "searchBasetype_s", value = "查出参数类型")
   	@RequestMapping("searchBasetype_s")
   	public String searchBasetype_s() throws Exception {
   		List<Map<String, Object>> list = plmhalfpartrecipeparaSrv.searchBasetype_s();
   		return toJson(list);
   	} 


}
