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
import com.bluebirdme.mes.linglong.mix.service.SiloMaterialServiceImpl;

/**
 * 密炼料仓物料维护表
 * @author 王超
 * @Date 2020-08-03 15:29:17
 */
@Log(code="密炼料仓物料维护表",value="密炼料仓物料维护表")
@RestController
@RequestMapping("mix/baseData/siloMaterial")
public class SiloMaterialController extends RockWellFunctionalUDAController<Object> {
    
    @Resource SiloMaterialServiceImpl silomaterialSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return silomaterialSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return silomaterialSrv;
	}
    
    @Override
    @Log(code = "密炼料仓物料维护", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    
    @Log(code="密炼料仓物料维护表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
    	if (silomaterialSrv.saveChanges(rockWellEntityDTO) == -1) {
        	return Response.error(Response.SYS_EXCEPTION, "代码重复",rockWellEntityDTO);
		}
        return Response.suc("OK");
    }
    
    /**
	 * 查出物料编码显示在JSP页面下拉列表处
	 * @return
	 */
	@Log(code = "getMixMaterials", value = "查出物料编码显示在JSP页面下拉列表处")
	@RequestMapping("getMixMaterials")
	public String getMixMaterials() throws Exception {
		List<Map<String, Object>> list = silomaterialSrv.getMixMaterials();
		return toJson(list);
	}
	
	/**
	 * 根据物料编码获取物料名称和物料类
	 * @return
	 */
	@Log(code = "getNameAndTypeByCode", value = "查出物料编码显示在JSP页面下拉列表处")
	@RequestMapping("getNameAndTypeByCode")
	public String getNameAndTypeByCode(String materialcode) throws Exception {
		List<Map<String, Object>> list = silomaterialSrv.getNameAndTypeByCode(materialcode);
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).get("materialtype_s").toString().equals("055001")) {
					list.get(i).put("materialtype_s", "炭黑");
				}
				if (list.get(i).get("materialtype_s").toString().equals("055002")) {
					list.get(i).put("materialtype_s", "小药");
				}
				if (list.get(i).get("materialtype_s").toString().equals("055003")) {
					list.get(i).put("materialtype_s", "粉料");
				}
				if (list.get(i).get("materialtype_s").toString().equals("055004")) {
					list.get(i).put("materialtype_s", "油料");
				}
				if (list.get(i).get("materialtype_s").toString().equals("055005")) {
					list.get(i).put("materialtype_s", "胶料");
				}
				if (list.get(i).get("materialtype_s").toString().equals("055006")) {
					list.get(i).put("materialtype_s", "其它");
				}
			}
		}
		return toJson(list);
	}
	
	/**
	 * 下发
	 * @param openOrclose
	 * @return
	 * @throws Exception
	 */
    @Log(code = "料仓配料重新下发", value = "料仓配料重新下发")
	@RequestMapping("downward")
    public Response downward(String recipecodelist[]) throws Exception {
        return Response.suc(silomaterialSrv.downward(recipecodelist));
    }
	
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	@Log(code = "toUserName", value = "根据用户号码查询姓名")
	@RequestMapping("toUserName")
	public String toUserName(String usercode) throws Exception {
		List<Map<String, Object>> list = silomaterialSrv.toUserName(usercode);
		return toJson(list);
	}

}
