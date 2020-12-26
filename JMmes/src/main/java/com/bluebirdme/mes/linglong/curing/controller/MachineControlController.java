/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MachineControl;
import com.bluebirdme.mes.linglong.curing.service.MachineControlServiceImpl;

/**
 * 硫化机台控制管理
 * 
 * @author 时永良
 * @Date 2018-08-10 13:31:38
 */
@Log(code = "MachineControl", value = "MachineControl")
@RestController
@RequestMapping("curing/baseData/curingControl/machinecontrol")
public class MachineControlController extends RockWellFunctionalUDAController<Object> {

	@Resource
	MachineControlServiceImpl machinecontrolSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return machinecontrolSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return machinecontrolSrv;
	}

	/**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchBy")
	public String searchByEntName(Filter filter, Page page, Class clazz)
			throws Exception {
		Map list = machinecontrolSrv.datagridUDA2(filter, page);
		return toJson(list);
	}
    
	/**
	 * 
	 * @return
	 */
	/*@RequestMapping("searchByModal")
	public String searchByModal() {
		List<Map<String, Object>> list = machinecontrolSrv.searchByModal();
		return toJson(list);
	}*/
	
	/**
	 * 根据产线条码查询机台日志
	 * 2020/07/06 栾和源
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("searchByLine")
	public String searchByLine(Filter filter, Page page) throws Exception{
		Map list =  machinecontrolSrv.searchByLine(filter,page);
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
		List<String> list =machinecontrolSrv.onOff(updated);
		if (list.size()!=0) {
			return Response.error(Response.SYS_EXCEPTION, list+"已经是当前状态","error");
		}
		return Response.suc();
	}
	
	/**
	  * 查出产线编码显示在JSP页面下拉列表处
	  * @return
	 */
	@Log(code = "searchProductionLine", value = "查出产线编码显示在JSP页面下拉列表处")
	@RequestMapping("searchProductionLine")
	public String searchProductionLine() throws Exception {
		List<Map<String, Object>> list = machinecontrolSrv.searchProductionLine();
		return toJson(list);
	}
}
