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
import com.bluebirdme.mes.linglong.halfpart.service.EquipmentCapaCityServiceImpl;


/**
 * 半部件全钢机台产能维护
 * @author 李德晓
 * @Date 2020-01-22 08:38:14
 */
@Log(code="半部件全钢机台产能维护",value="半部件全钢机台产能维护")
@RestController
@RequestMapping("halfpart/baseData/halfPartMachineCapacity")
public class EquipmentcapacityController extends RockWellFunctionalUDAController<Object> {
    
    @Resource EquipmentCapaCityServiceImpl equipmentcapacitySrv;
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
        return equipmentcapacitySrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return equipmentcapacitySrv;
	}
   
    @Log(code="半部件全钢机台产能维护_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
        if (equipmentcapacitySrv.saveChanges(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复",rockWellEntityDTO);
		}
		return Response.suc();
    }
    @Log(code = "searchMaterialGroup", value = "查出物料组显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialGroup")
	public String searchMaterialGroup() throws Exception {
		List<Map<String, Object>> list = equipmentcapacitySrv.searchMaterialGroup();
		System.out.println(list.size());
		return toJson(list);
	}
    @Log(code = "searchDescription", value = "查出机台名称显示在JSP页面下拉列表处")
	@RequestMapping("searchDescription")
	public String searchDescription() throws Exception {
		List<Map<String, Object>> list = equipmentcapacitySrv.searchDescription();
		return toJson(list);
	} 
}
