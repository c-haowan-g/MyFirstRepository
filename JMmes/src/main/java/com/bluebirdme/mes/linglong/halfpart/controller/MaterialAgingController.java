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
import com.bluebirdme.mes.linglong.halfpart.service.MaterialAgingServiceImpl;


/**
 * 半部件物料时效维护
 * @author 王超
 * @Date 2020-03-06 11:24:18
 */
@Log(code="半部件物料时效维护",value="半部件物料时效维护")
@RestController
@RequestMapping("halfpart/baseData/materialAging")
public class MaterialAgingController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaterialAgingServiceImpl materialsplusSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialsplusSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialsplusSrv;
	}
    
    @Override
    @Log(code = "半部件物料时效维护", value = "物料组查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = materialsplusSrv.datagridUDA(filter, page);
		return toJson(map);
	}
    
    @Override
    @Log(code = "半部件物料时效维护", value = "单物料查询")
	@ResponseBody
	@RequestMapping("datagridGroup")
	public String datagridUDA(Filter filter, Page page) throws Exception {
    	Map map = materialsplusSrv.datagridUDA1(filter, page);
		return toJson(map);
	}
    
    @Log(code="半部件物料时效维护_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO materialsplus ) throws Exception {
    	if (materialsplusSrv.saveChanges(materialsplus) == -1) {
        	return Response.error(Response.SYS_EXCEPTION, "代码重复",materialsplus);
		}
        return Response.suc("OK");
    }
    
    /**
	 * 查出物料规格显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialSpec", value = "查出物料规格显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialSpec")
	public String searchMaterialSpec() throws Exception {
		List<Map<String, Object>> list = materialsplusSrv.searchMaterialSpec();
		return toJson(list);
	}
	
	/**
	 * 查出物料编码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialCode", value = "查出物料编码显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialCode")
	public String searchMaterialCode() throws Exception {
		List<Map<String, Object>> list = materialsplusSrv.searchMaterialCode();
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
		List<Map<String, Object>> list = materialsplusSrv.searchMaterialGroup();
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
		List<Map<String, Object>> list = materialsplusSrv.toUserName(usercode);
		return toJson(list);
	}
	
	/**
	 * 根据物料编号查询规格
	 * 
	 * @return
	 */
	@Log(code = "getMaterialSpecByCode", value = "根据物料编号查询规格")
	@RequestMapping("getMaterialSpecByCode")
	public String getMaterialSpecByCode(String materialcode) throws Exception {
		List<Map<String, Object>> list = materialsplusSrv.getMaterialSpecByCode(materialcode);
		return toJson(list);
	}
	
	/**
	 * 根据物料编号查询物料信息
	 * 
	 * @return
	 */
	@Log(code = "getInfoByCode", value = "根据物料编号查询物料信息")
	@RequestMapping("getInfoByCode")
	public String getInfoByCode(String materialcode) throws Exception {
		List<Map<String, Object>> list = materialsplusSrv.getInfoByCode(materialcode);
		return toJson(list);
	}
	
	/**
	 * 根据物料编号查询规格
	 * 
	 * @return
	 */
	@Log(code = "setSameAgingByCode", value = "同种物料设置相同时效")
	@RequestMapping("setSameAgingByCode")
	public int setSameAgingByCode(String materialgroup, String smalltime, String overtime, String spare1_s, String spare2_s) throws Exception {
		List<Map<String, Object>> list = materialsplusSrv.searchSameGroupByCode(materialgroup);
		RockWellEntityDTO materialsplus = new RockWellEntityDTO();
		materialsplus.setUpdated(list);
		materialsplusSrv.saveChanges1(materialsplus, smalltime, overtime, spare1_s, spare2_s);
		materialsplusSrv.savepartclass(materialgroup, smalltime, overtime, spare1_s, spare2_s);
		int count = list.size();
		return count;
	}

	
}
