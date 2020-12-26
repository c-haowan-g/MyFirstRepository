/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.HalfpartControlServiceImpl;

/**
 * 机台控制开关表
 * @author 时永良
 * @Date 2020年8月18日08:15:13
 */
@Log(code="halfpart/productionManagement/halfpartControl",value="半部件机台控制管理")
@RestController
@RequestMapping("halfpart/productionManagement/halfpartControl")
public class HalfpartControlController extends RockWellFunctionalUDAController<Object> {
    
    @Resource HalfpartControlServiceImpl halfpartcontrolSrv;

    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return halfpartcontrolSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return halfpartcontrolSrv;
	}
    
    /**
	 * 查询全部 页面初始化使用
	 * @param machinecode_s
	 *        机台条码
	 * @param machinetype_s
	 *        机台类型
	 * @param machinestatus_s
	 *        机台状态
	 * @return
	 * @throws Exception
	 */
	@Log(code = "searchInit", value = "查询全部 页面初始化使用")
	@RequestMapping("searchInit")
	public String searchByDataDictionary(String machinecode_s,String machinetype_s,String machinestatus_s) throws Exception {
		List<Map<String, Object>> list = halfpartcontrolSrv.searchInit(machinecode_s,machinetype_s,machinestatus_s);
		return toJson(list);
	}
    
	 /**
	  * 根据数据字典查出所需控制项（119为数据字典中代码号）
	  * @return
	  */
	@Log(code = "searchBy119", value = "根据数据字典查出所需控制项")
	@RequestMapping("searchBy119")
	public String searchBy119() throws Exception {
		List<Map<String, Object>> list = halfpartcontrolSrv.searchBy119();
		return toJson(list);
	}
	
	/**
	  * 根据菜单管理查出数据
	  * @return
	 */
	@Log(code = "searchFromCoreMenu", value = "根据菜单管理查出数据")
	@RequestMapping("searchFromCoreMenu")
	public String searchFromCoreMenu() throws Exception {
		List<Map<String, Object>> list = halfpartcontrolSrv.searchFromCoreMenu();
		return toJson(list);
	}
	
   /**
	* 模态框的内容查询
	* @return
	*/
	@RequestMapping("searchByModal")
	public String searchByModal() {
	  List<Map<String, Object>> list = halfpartcontrolSrv.searchByModal();
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
		String message=halfpartcontrolSrv.onOff(updated);
		return Response.error(Response.SYS_EXCEPTION,message,null);
	}
	
	/**
	  * 查出机台条码显示在JSP页面下拉列表处
	  * @return
	 */
	@Log(code = "searchDescription", value = "查出机台条码显示在JSP页面下拉列表处")
	@RequestMapping("searchDescription")
	public String searchDescription() throws Exception {
		List<Map<String, Object>> list = halfpartcontrolSrv.searchDescription();
		return toJson(list);
	}

	
}
