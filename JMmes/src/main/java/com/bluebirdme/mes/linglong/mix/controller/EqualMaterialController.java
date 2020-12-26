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
import com.bluebirdme.mes.linglong.mix.service.EqualMaterialServiceImpl;

/**
 * PLM等同物料维护
 * @author 王超
 * @Date 2020-09-08 11:54:53
 */
@Log(code="EqualMaterial",value="PLM等同物料维护")
@RestController
@RequestMapping("mix/baseData/equalMaterial")
public class EqualMaterialController extends RockWellFunctionalUDAController<Object> {
    
    @Resource EqualMaterialServiceImpl equalmaterialSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return equalmaterialSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return equalmaterialSrv;
	}
    
    @Log(code="EqualMaterial_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
    	if (equalmaterialSrv.saveChanges(rockWellEntityDTO) == -1) {
        	return Response.error(Response.SYS_EXCEPTION, "代码重复",rockWellEntityDTO);
		}
        return Response.suc("OK");
    }
    
    /**
	 * 控制开关
	 * @param openOrclose
	 * @return
	 * @throws Exception
	 */
    @Log(code = "等级管控开关控制", value = "等级管控开关控制")
	@RequestMapping("openOrclose")
	public Response openOrclose(@RequestBody Map<String, Object> updated)throws Exception {
		List<String> list = equalmaterialSrv.openOrclose(updated);
		if (list.size() != 0) {
			return Response.error(Response.SYS_EXCEPTION, list+"已经是当前状态","error");
		}
		return Response.suc();
	}
    
    @Override
    @Log(code = "等同物料维护", value = "等同物料维护")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = equalmaterialSrv.datagridUDA(filter, page);
		return toJson(map);
	}
    
    /**
	 * 获取机台列表
	 * @return
	 */
	@Log(code = "getGroupnamesList", value = "获取机台列表")
	@RequestMapping("getGroupnamesList")
	public String getGroupnamesList() throws Exception {
		List<Map<String, Object>> list = equalmaterialSrv.getGroupnamesList();
		return toJson(list);
	}
	
	/**
	 * 获取等同物料列表
	 * @return
	 */
	@Log(code = "getEqualMatInfo", value = "获取等同物料列表")
	@RequestMapping("getEqualMatInfo")
	public String getMatInfo() throws Exception {
		List<Map<String, Object>> list = equalmaterialSrv.getEqualMatInfo();
		return toJson(list);
	}
	
	/**
	 * 获取密炼物料列表
	 * @return
	 */
	@Log(code = "getMixMatInfo", value = "获取密炼物料列表")
	@RequestMapping("getMixMatInfo")
	public String getMixMatInfo() throws Exception {
		List<Map<String, Object>> list = equalmaterialSrv.getMixMatInfo();
		return toJson(list);
	}

}