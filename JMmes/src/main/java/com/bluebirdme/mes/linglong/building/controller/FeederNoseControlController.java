package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.service.FeederNoseControlServiceImpl;

/**
 * 成型机台投料口控制管理
 * @author 时永良
 * @Date 2019-01-28 11:28:38
 */
@Log(code="成型机台投料口控制管理",value="成型机台投料口控制管理")
@RestController
@RequestMapping("building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol")
public class FeederNoseControlController extends RockWellFunctionalUDAController<Object> {
	@Resource FeederNoseControlServiceImpl FeederNoseControlServiceImpl;
	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return FeederNoseControlServiceImpl;
	}
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return FeederNoseControlServiceImpl;
	}
	/**
	 * 查询全部 页面初始化使用
	 * @param machinename_s
	 *        机台名称
	 * @param machinegroup_s
	 *        机台组
	 * @return
	 * @throws Exception
	 */
	@Log(code = "searchInit", value = "查询全部 页面初始化使用")
	@RequestMapping("searchInit")
	public String searchByDataDictionary(String machinename_s,String machinegroup_s) throws Exception {
		List<Map<String, Object>> list = FeederNoseControlServiceImpl.searchInit(machinename_s,machinegroup_s);
		return toJson(list);
	}
	
	/**
	  * 根据数据字典查出所需控制项（198为数据字典中代码号）
	  * @return
	 */
	@Log(code = "searchBy198", value = "根据数据字典查出所需控制项")
	@RequestMapping("searchBy198")
	public String searchBy198() throws Exception {
		List<Map<String, Object>> list = FeederNoseControlServiceImpl.searchBy198();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		return toJson(list);
	}
	/**
	  * 根据数据字典查出所需控制项（199为数据字典中代码号）
	  * @return
	 */
	@Log(code = "searchBy199", value = "根据数据字典查出所需控制项")
	@RequestMapping("searchBy199")
	public String searchBy199() throws Exception {
		List<Map<String, Object>> list = FeederNoseControlServiceImpl.searchBy199();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		return toJson(list);
	}
	
	/**
	  * 根据数据字典查出所需控制项
	  * @return
	 */
	@Log(code = "searchByDictionary", value = "根据数据字典查出所需控制项")
	@RequestMapping("searchByDictionary")
	public String searchByDictionary() throws Exception {
		List<Map<String, Object>> list = FeederNoseControlServiceImpl.searchByDictionary();
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		return toJson(list);
	}
	    /**
		 * 控制开关
		 * 
		 * @param dataOnOff
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("onOff")
		public Response onOff(@RequestBody Map<String, Object> updated)throws Exception {
			/*if (FeederNoseControlServiceImpl.onOff(updated) =="") {
				return Response.suc("ok");
			}else if(FeederNoseControlServiceImpl.onOff(updated) ==0){
				return Response.error(Response.SYS_EXCEPTION, "已经是当前状态",null);
			}else if(FeederNoseControlServiceImpl.onOff(updated) ==2){
				return Response.error(Response.SYS_EXCEPTION, "已经是当前状态",null);
			}else if(FeederNoseControlServiceImpl.onOff(updated) ==3){
				
			}*/
			String message=FeederNoseControlServiceImpl.onOff(updated);
			return Response.error(Response.SYS_EXCEPTION,message,null);
		}
		/**
		  * 根据数据字典查出数据
		  * @return
		 */
		@Log(code = "searchFromCoreMenu", value = "根据菜单管理查出数据")
		@RequestMapping("searchFromCoreMenu")
		public String searchFromCoreMenu() throws Exception {
			List<Map<String, Object>> list = FeederNoseControlServiceImpl.searchFromCoreMenu();
			return toJson(list);
		}
		
		 /**
		 * 模态框的内容查询
		 * @return
		 */
		@RequestMapping("searchByModal")
		public String searchByModal() {
			List<Map<String, Object>> list = FeederNoseControlServiceImpl.searchByModal();
			return toJson(list);
		}
	
	
	/**
	  * 查出机台名称显示在JSP页面下拉列表处
	  * @return
	 */
	@Log(code = "searchDescription", value = "查出机台名称显示在JSP页面下拉列表处")
	@RequestMapping("searchDescription")
	public String searchDescription() throws Exception {
		List<Map<String, Object>> list = FeederNoseControlServiceImpl.searchDescription();
		return toJson(list);
	}
}
