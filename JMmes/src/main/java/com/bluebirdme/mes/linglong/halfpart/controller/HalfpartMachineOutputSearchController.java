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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.service.HalfpartMachineOutputSearchServiceImpl;


/**
 * 半部件产出实绩
 * @author 李德晓
 * @Date 2020-03-17 16:05:04
 */
@Log(code="半部件产出实绩",value="半部件产出实绩")        
@RestController
@RequestMapping("halfpart/baseData/halfpartMachineOutput")
public class HalfpartMachineOutputSearchController extends RockWellFunctionalUDAController<Object> {
    
    @Resource HalfpartMachineOutputSearchServiceImpl halfpartmachineoutputsearchSrv;
    @Override
    @Log(code = "半部件产出实际", value = "信息列表查询")
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return halfpartmachineoutputsearchSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return halfpartmachineoutputsearchSrv;
	}
    
   /* @Log(code="半部件产出实绩_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        halfpartmachineoutputsearchSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }*/
    @Log(code = "searchDescription", value = "查出机台条码显示在JSP页面下拉列表处")
   	@RequestMapping("searchDescription")
   	public String searchDescription() throws Exception {
   		List<Map<String, Object>> list = halfpartmachineoutputsearchSrv.searchDescription();
   		return toJson(list);
   	} 
    /*@Log(code = "searchMaterialcode_s", value = "查出物料编码显示在JSP页面下拉列表处")
   	@RequestMapping("searchMaterialcode_s")
   	public String searchMaterialcode_s() throws Exception {
   		List<Map<String, Object>> list = halfpartmachineoutputsearchSrv.searchMaterialcode_s();
   		return toJson(list);
   	} */
 // 查出物料编码显示在JSP页面下拉列表处
	 
 	@Log(code = "searchMaterielcode", value = "查出物料编码显示在JSP页面下拉列表处")
 	@RequestMapping("searchMaterielcode")
 	public String searchMaterielcode() throws Exception {
 		if(LLWebUtils.factory().equals("1")){
 			return toJson(halfpartmachineoutputsearchSrv.searchMaterialcode_s());	
 		}
 		if(LLWebUtils.factory().equals("2")){
 			return toJson(halfpartmachineoutputsearchSrv.searchMaterialcode_sb());	
 		}
 		return "";
 	}
   /* @Log(code = "searchMaterspec_s", value = "查出规格显示在JSP页面下拉列表处")
   	@RequestMapping("searchMaterspec_s")
   	public String searchMaterspec_s() throws Exception {
   		List<Map<String, Object>> list = halfpartmachineoutputsearchSrv.searchMaterspec_s();
   		return toJson(list);
   	} */
 	@Log(code = "searchMaterspec_s", value = "查出物料编码显示在JSP页面下拉列表处")
 	@RequestMapping("searchMaterspec_s")
 	public String searchMaterspec_s() throws Exception {
 		if(LLWebUtils.factory().equals("1")){
 			return toJson(halfpartmachineoutputsearchSrv.searchMaterspec_s());	
 		}
 		if(LLWebUtils.factory().equals("2")){
 			return toJson(halfpartmachineoutputsearchSrv.searchMaterspec_sb());	
 		}
 		return "";
 	}
    @Log(code = "searchUsercode", value = "查出查出usercode，username并转换")
   	@RequestMapping("searchUsercode")
   	public String searchUsercode() throws Exception {
   		List<Map<String, Object>> list = halfpartmachineoutputsearchSrv.searchUsercode();
   		return toJson(list);
   	}
    
    @Log(code="saveChanges",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        halfpartmachineoutputsearchSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

}
