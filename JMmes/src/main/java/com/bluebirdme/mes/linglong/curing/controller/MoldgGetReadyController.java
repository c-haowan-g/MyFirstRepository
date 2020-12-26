/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.MoldgGetReadyServiceImpl;

/**
 * 模具备模
 * 
 * @author 时永良
 * @Date 2018-08-24 15:07:23
 */
@Log(code = "MoldgGetReady", value = "MoldgGetReady")
@RestController
@RequestMapping("curing/moldManagement/moldgGetReady")
public class MoldgGetReadyController extends RockWellFunctionalUDAController<Object> {

	@Resource
	MoldgGetReadyServiceImpl moldggetreadySrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return moldggetreadySrv;
	}
	
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return moldggetreadySrv;
	}
	
	@Log(value = "查询换模计划信息（初始化）", code = "FUNC_007", target = LogType.CONSOLE)
	@Override
	@RequestMapping("searchBy")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
	
	/**
	 * 查询备模履历（初始化）
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchByRecord")
	public String searchByRecord(Filter filter, Page page)throws Exception {
		Map list = moldggetreadySrv.moldRecordDatagrid(filter, page);
		return toJson(list);
	}
	
	/**
	 * 根据换模计划号,拿到日计划中计划数量左和计划数量右
	 * @param 
	 * @return
	 */
	@RequestMapping("getPlanNum")
	public String getPlanNum(String moldchangePlanno) throws Exception{
		List<Map<String, Object>> listData = moldggetreadySrv.getPlanNum(moldchangePlanno);
		return toJson(listData);
	}
	
	/**
	 * 返回左模的规格信息（弹出的模具选择弹窗的查询）
	 * @param map
	 * @return
	 */
	@RequestMapping("left")
	public String left(@RequestBody Map<String,Object> list_map){
		List<Map<String, Object>> listDate = moldggetreadySrv.left(list_map);
		return toJson(listDate);
	}
	/**
	 *  返回右模的规格信息（弹出的模具选择弹窗的查询）
	 * @param map
	 * @return
	 */
	@RequestMapping("right")
	public String right(@RequestBody Map<String, Object> list_map){
		List<Map<String,Object>> listDate = moldggetreadySrv.right(list_map);
		return toJson(listDate);
	}
	
	@Log(code = "moldggetready_SAVE_CHANGES", value = "备模的保存方法")
	@RequestMapping("moldSave")
	public Response moldSave(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		if (moldggetreadySrv.moldSave(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "已完成",rockWellEntityDTO);
		}
		return Response.suc();
	}

	/**
	 * 剔除
	 * @param planno_s
	 * @return
	 */
	@RequestMapping("validMoldChangePlan")
	public Response validMoldChangePlan(String planno_s) {
		return Response.suc(moldggetreadySrv.validMoldChangePlan(planno_s));
	}
}
