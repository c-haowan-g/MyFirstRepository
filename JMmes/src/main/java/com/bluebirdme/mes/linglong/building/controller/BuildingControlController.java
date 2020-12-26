/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.BuildWasteReport;
import com.bluebirdme.mes.linglong.building.entity.BuildingControl;
import com.bluebirdme.mes.linglong.building.service.BuildingControlServiceImpl;

/**
 * 成型机台开关控制管理
 * @author 时永良
 * @Date 2019-01-12 11:28:38
 */
@Log(code="成型机台开关控制管理",value="成型机台开关控制管理")
@RestController
@RequestMapping("building/productionManagement/buildingControl")
public class BuildingControlController extends RockWellFunctionalUDAController<Object> {
    
    @Resource BuildingControlServiceImpl buildingcontrolSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return buildingcontrolSrv;
    }
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return buildingcontrolSrv;
	}
	/**
	 * 机台日志界面查询
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("searchByModal")
	public String searchByModal(Filter filter, Page page) throws Exception {
		if(!filter.getFilter().containsKey("machinebarcode_s")){
			filter.getFilter().remove("begin_created_time");
			filter.getFilter().remove("end_created_time");
		}
		return GsonTools.toJson(buildingcontrolSrv.datagridUDA(filter, page));
	}
	
	/**
	 * 查询全部 页面初始化使用
	 * @param machinename_s
	 *        机台名称
	 * @param machinegroup_s
	 *        机台组
	 * @param machinestatus_s
	 *        机台状态
	 * @return
	 * @throws Exception
	 */
	@Log(code = "searchInit", value = "查询全部 页面初始化使用")
	@RequestMapping("searchInit")
	public String searchByDataDictionary(String machinename_s,String machinegroup_s,String machinestatus_s) throws Exception {
		List<Map<String, Object>> list = buildingcontrolSrv.searchInit(machinename_s,machinegroup_s,machinestatus_s);
		return toJson(list);
	}
	
	/**
	  * 根据数据字典查出所需控制项（196为数据字典中代码号）
	  * @return
	 */
	@Log(code = "searchBy196", value = "根据数据字典查出所需控制项")
	@RequestMapping("searchBy196")
	public String searchBy196() throws Exception {
		List<Map<String, Object>> list = buildingcontrolSrv.searchBy196();
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
			String message=buildingcontrolSrv.onOff(updated);
			return Response.error(Response.SYS_EXCEPTION,message,null);
		}
     

		/**
		  * 根据数据字典查出数据
		  * @return
		 */
		@Log(code = "searchFromCoreMenu", value = "根据菜单管理查出数据")
		@RequestMapping("searchFromCoreMenu")
		public String searchFromCoreMenu() throws Exception {
			List<Map<String, Object>> list = buildingcontrolSrv.searchFromCoreMenu();
			return toJson(list);
		}
		
		/**
		  * 查出机台名称显示在JSP页面下拉列表处
		  * @return
		 */
		@Log(code = "searchDescription", value = "查出机台名称显示在JSP页面下拉列表处")
		@RequestMapping("searchDescription")
		public String searchDescription() throws Exception {
			List<Map<String, Object>> list = buildingcontrolSrv.searchDescription();
			return toJson(list);
		}
}
