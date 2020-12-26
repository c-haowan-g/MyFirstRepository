/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.common.service.BillOfMaterialServiceImpl;
import com.bluebirdme.mes.linglong.common.entity.dto.BillOfMaterialUDAUdaDTO;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * bom_uda
 * @author 王海霖
 * @Date 2019-06-24 15:06:48
 */
@Log(code="common/billofmaterials",value="PLM_BOM查询日志")
@RestController
@RequestMapping("common/billofmaterials")
public class BillOfMaterialController extends RockWellFunctionalUDAController<Object> {
    
    @Resource BillOfMaterialServiceImpl billofmaterialSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return billofmaterialSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return billofmaterialSrv;
	}
    
    @Log(code="common/billofmaterials_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody BillOfMaterialUDAUdaDTO udaDto ) throws Exception {
        billofmaterialSrv.saveChanges(udaDto);
        return Response.suc();
    }
    @Log(code="common/billofmaterials_datagridBOMCount",value="查询bom子数据",target=LogType.DB)
    @RequestMapping("datagridBOMCount")
    public String datagridBOMCount(String bomkey ) throws Exception {
    	
		List<Map<String,Object>> maps=billofmaterialSrv.datagridBOMCount(bomkey);
		for (int i = 0; i < maps.size(); i++) {
			Map<String,Object> map=maps.get(i);
			if(StringHelper.isNullOrEmpty((String)map.get("bom_name"))){
				map.remove("state");
			}
		}
        return toJson(billofmaterialSrv.datagridBOMCount(bomkey));
    }
  
	@Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		String flag = filter.getFilter().get("bomflag_i");
		if(("2").equals(flag)){
			filter.getFilter().put("bom2flag", "1");
		}else if(("3").equals(flag)){
			filter.getFilter().put("bom3flag", "1");
		}
		filter.getFilter().remove("bomflag_i");
		filter.getFilter().remove("s_factory_s");
		Map<String, Object> lists = datagridUDA1(filter, page);
		Object object = lists.get("rows");
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> maps=(List<Map<String, Object>>) object;
		for (int i = 0; i < maps.size(); i++) {
			Map<String,Object> map=maps.get(i);
			map.put("id", i);
		}
		return GsonTools.toJson(lists);
	}
	
	public Map<String, Object> datagridUDA1(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", getUDAService().datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", getUDAService().datagridTotalUDA(filter, page));
		return ret;

	}
    
	
    
	@Log(value = "查询树形结构条件查询--成型日计划使用", code = "treelistQuery", target = LogType.CONSOLE)
	@RequestMapping("treelistQuery")
	public String treelistQuery(@RequestBody List<Map<String, Object>> list_map) throws Exception {
		List<Map<String, Object>> list=billofmaterialSrv.treelistQuery(list_map);
		return toJson(list);
	}
}
