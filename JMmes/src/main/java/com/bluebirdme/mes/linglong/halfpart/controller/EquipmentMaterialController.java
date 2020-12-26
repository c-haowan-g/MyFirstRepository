/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.EquipmentMaterialServiceImpl;


/**
 * 半部件机台物料维护
 * @author 王超
 * @Date 2020-03-03 16:10:49
 */
@Log(code="半部件机台物料维护",value="半部件机台物料维护")
@RestController
@RequestMapping("halfpart/basedata/equipmentMaterial")
public class EquipmentMaterialController extends RockWellFunctionalUDAController<Object> {
    
    @Resource EquipmentMaterialServiceImpl equipmentmaterialSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return equipmentmaterialSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return equipmentmaterialSrv;
	}
    
    @Log(code="半部件机台物料维护_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO equipmentmaterial ) throws Exception {
    	if (equipmentmaterialSrv.saveChanges(equipmentmaterial) == -1) {
        	return Response.error(Response.SYS_EXCEPTION, "代码重复",equipmentmaterial);
		}
        return Response.suc("OK");
    }
    
    @Override
    @Log(code = "半部件机台物料维护", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
    /**
	 * 查出机台条码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchEquipmentCode", value = "查出机台条码显示在JSP页面下拉列表处")
	@RequestMapping("searchEquipmentCode")
	public String searchEquipmentCode(final String[] list_map) throws Exception {
		Map<String,String> map=new HashMap<>();
		if(list_map!=null){
			String string=Arrays.asList(list_map).toString();
			List<Map<String,String>> list=(List<Map<String,String>>)JSONArray.parse(string);
			map=list.get(0);
		}
		return toJson(equipmentmaterialSrv.searchEquipmentCode(map));
	}
	
	/**
	 * 查出物料编码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialCode", value = "查出物料编码显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialCode")
	public String searchMaterialCode() throws Exception {
		List<Map<String, Object>> list = equipmentmaterialSrv.searchMaterialCode();
		return toJson(list);
	}
	
	/**
	 * 根据机台条码查询物料
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialByEquipCode", value = "根据机台条码查询物料")
	@RequestMapping("searchMaterialByEquipCode")
	public String searchMaterialByEquipCode(String equipmentcode) throws Exception {
		List<Map<String, Object>> list = equipmentmaterialSrv.searchMaterialByEquipCode(equipmentcode);
		return toJson(list);
	}
	
	/**
	 * 查出物料组显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialGroup", value = "查出物料组显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialGroup")
	public String searchMaterialGroup() throws Exception {
		List<Map<String, Object>> list = equipmentmaterialSrv.searchMaterialGroup();
		return toJson(list);
	}
		
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	@Log(code = "toUserName", value = "根据用户号码查询姓名")
	@RequestMapping("toUserName")
	public String toUserName(String usercode) throws Exception {
		List<Map<String, Object>> list = equipmentmaterialSrv.toUserName(usercode);
		return toJson(list);
	}
	
	/**
	 * 根据物料编号查询物料名称
	 * 
	 * @return
	 */
	@Log(code = "getMaterialNameByCode", value = "根据物料编号查询物料名称")
	@RequestMapping("getMaterialNameByCode")
	public String getMaterialNameByCode(String materialcode) throws Exception {
		List<Map<String, Object>> list = equipmentmaterialSrv.getMaterialNameByCode(materialcode);
		return toJson(list);
	}
	
	/**
	 * 根据机台编码查询机台名称
	 * 
	 * @return
	 */
	@Log(code = "toEquipName", value = "根据机台编码查询机台名称")
	@RequestMapping("toEquipName")
	public String toEquipName(String equipcode) throws Exception {
		List<Map<String, Object>> list = equipmentmaterialSrv.toEquipName(equipcode);
		return toJson(list);
	}
	
	/**
	 * 根据机台名称过滤物料组
	 * 
	 * @return
	 */
	@Log(code = "filteByEquipName", value = "根据机台名称过滤物料组")
	@RequestMapping("filteByEquipName")
	public String filteByEquipName(String eqname) throws Exception {
		List<Map<String, Object>> list = equipmentmaterialSrv.filteByEquipName(eqname);
		return toJson(list);
	}
	
	/**
	 * 根据物料组编号查询物料组名称
	 * 
	 * @return
	 */
	@Log(code = "getNameByGroupCode", value = "根据物料组编号查询物料组名称")
	@RequestMapping("getNameByGroupCode")
	public String getNameByGroupCode(String materialgroup_s) throws Exception {
		List<Map<String, Object>> list = equipmentmaterialSrv.getNameByGroupCode(materialgroup_s);
		return toJson(list);
	}

}
