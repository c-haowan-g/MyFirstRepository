/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;





import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.SortingrateServiceImpl;


/**
 * 分拣扫描率报表
 * @author 徐秉正
 * @Date 2020-11-16 16:33:06
 */
@Log(code="finalcheck/reportCenter/sortingrate",value="分拣扫描率报表")
@RestController
@RequestMapping("finalcheck/reportCenter/sortingrate")
public class SortingrateController extends RockWellFunctionalUDAController<Object> {
    
    @Resource SortingrateServiceImpl sortingrateSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return sortingrateSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return sortingrateSrv;
	}
	 @Log(code = "finalcheck/reportCenter/sortingrate_SAVE_CHANGES", value = "转换")
	   	@RequestMapping("searchcode")
	   	public String searchcode() throws Exception {
	   		List<Map<String, Object>> list = sortingrateSrv.searchcode();
	   		return toJson(list);
	   	} 
	 @Log(code = "finalcheck/reportCenter/sortingrate_SAVE_CHANGES", value = "转换")
	   	@RequestMapping("searchcodewg")
	   	public String searchcodewg() throws Exception {
	   		List<Map<String, Object>> list = sortingrateSrv.searchcodewg();
	   		return toJson(list);
	   	} 
	 @Log(code = "finalcheck/reportCenter/sortingrate_SAVE_CHANGES", value = "转换")
	   	@RequestMapping("searchcodegm")
	   	public String searchcodegm() throws Exception {
	   		List<Map<String, Object>> list = sortingrateSrv.searchcodegm();
	   		return toJson(list);
	   	} 
	 @Log(code = "finalcheck/reportCenter/sortingrate_SAVE_CHANGES", value = "转换")
	   	@RequestMapping("searchcodexg")
	   	public String searchcodexg() throws Exception {
	   		List<Map<String, Object>> list = sortingrateSrv.searchcodexg();
	   		return toJson(list);
	   	} 
    @Log(code="finalcheck/reportCenter/sortingrate_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        sortingrateSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

	 @Log(code="getAll",value="动平衡扫描率查询")
	 @RequestMapping("getAll") 
	 public String getAll(Filter filter)throws Exception{
		 if(filter.get("entname_s")!=null){
			List<Map<String, Object>> list = sortingrateSrv.getAll(filter);
			 return toJson(list);
		 }
		 if(filter.get("wgentname_s")!=null){
				List<Map<String, Object>> list1 = sortingrateSrv.getAlla(filter);
				 return toJson(list1);
		 }
		 if(filter.get("xgentname_s")!=null){
				List<Map<String, Object>> list2 = sortingrateSrv.getAllx(filter);
				 return toJson(list2);
		 }
		 if(filter.get("gmentname_s")!=null){
				List<Map<String, Object>> list3 = sortingrateSrv.getAllgm(filter);
				 return toJson(list3);
		 }
		 
		 List<Map<String, Object>> list = sortingrateSrv.getAll(filter);
		 List<Map<String, Object>> list1 = sortingrateSrv.getAlla(filter);
		 List<Map<String, Object>> list2 = sortingrateSrv.getAllx(filter);
		 List<Map<String, Object>> list3 = sortingrateSrv.getAllgm(filter);
		 list.addAll(list1);
		 list.addAll(list2);
		 list.addAll(list3);
		 return toJson(list);
	 }
	 
}
