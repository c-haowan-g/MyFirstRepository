/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;






import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
import com.bluebirdme.mes.linglong.mix.service.MaterialApplyServiceImpl;


/**
 * 密炼领料管理
 * @author 王超
 * @Date 2020-08-07 09:12:17
 */
@Log(code="密炼领料管理",value="密炼领料管理")
@RestController
@RequestMapping("mix/planManagement/materialApply")
public class MaterialApplyController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaterialApplyServiceImpl materialapplySrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialapplySrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialapplySrv;
	}
    
    @Log(code="密炼领料管理_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
    	if (materialapplySrv.saveChanges(rockWellEntityDTO) == -1) {
        	return Response.error(Response.SYS_EXCEPTION, "代码重复",rockWellEntityDTO);
		}
        return Response.suc("OK");
    }
    
    @Log(code = "密炼领料管理", value = "信息列表查询")
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {    	
    	Map map = materialapplySrv.datagridUDA(filter, page);
		return toJson(map);
	}
    
    @Log(code = "密炼领料管理", value = "信息列表查询2")
	@RequestMapping("datagrid2")
	public String datagrid2(Filter filter, Page page) throws Exception {    	
    	Map map = materialapplySrv.datagridUDA2(filter, page);
		return toJson(map);
	}
    
    /**
	 * 根据机台条码查询名称
	 * 
	 * @return
	 */
	@Log(code = "searchMixEquipName", value = "根据机台条码查询名称")
	@RequestMapping("searchMixEquipName")
	public String searchMixEquipName(String equipcode) throws Exception {
		List<Map<String, Object>> list = materialapplySrv.searchMixEquipName(equipcode);
		return toJson(list);
	}

}
