/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.PlanCuringParameter;
import com.bluebirdme.mes.linglong.curing.service.PlanCuringParameterServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.PlanDayParameterServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 页面名称:工艺参数查询
 * 
 * @author whl
 * @Date 2018-09-04 18:37:22
 */
@Log(code = "PlanCuringParameter", value = "工艺参数查询")
@RestController
@RequestMapping("curing/productionManagement/planCuringParameter/")
public class PlanCuringParameterController extends
		RockWellFunctionalUDAController<Object> {
	// 参数表
	@Resource
	PlanCuringParameterServiceImpl plancuringparameterSrv;
	// 日计划表
	@Resource
	PlanDayParameterServiceImpl plandayparameterSrv;

	

	/**
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询参数)
	 * @return: String 返回类型
	 * 右
	 */
	@RequestMapping("getParameter")
	public String datagrid(Filter filter, Page page, Class clazz)
			throws Exception {
		Map<String, Object> list = plancuringparameterSrv.datagrid(filter,
				page, clazz);
		System.out.println(filter);
		return GsonTools.toJson(list);
	}

	/**
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询参数)
	 * @return: String 返回类型
	 * 左
	 */
	@RequestMapping("getParameterl")
	public String datagridleft(Filter filter, Page page, Class clazz)
			throws Exception {
		Map<String, Object> list = plancuringparameterSrv.datagridUDA(filter,
				page);
		System.out.println(filter);
		return GsonTools.toJson(list);
	}

	/**
	 * 
	 * @Title: getPlan
	 * @Description: TODO(查询日计划)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getPlan")
	public String getPlan(Filter filter, Page page, Class clazz)
			throws Exception {
		Map<String, Object> list = plandayparameterSrv.datagridUDA(filter, page);
		return GsonTools.toJson(list);
	}

	/**
	 * 根据品号查询工艺参数
	 * 
	 * @Title: getParameterBySapmat_s
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@SuppressWarnings("null")
	@RequestMapping("getParameterBySapmat_s")
	public String getParameterBySapmat_s(Filter filter, Page page, Class clazz)
			throws Exception {
		System.out.println(filter);
		Map<String, Object> list = plandayparameterSrv.datagridUDA(filter, page);
		return GsonTools.toJson(list);
	}
	
	@Log(code="colorMarkingLine",value="查询ERP代码和色标线功能")
    @RequestMapping("colorMarkingLine")
   	public String colorMarkingLine() throws Exception{
    	List<Map<String,Object>> list=plancuringparameterSrv.getColorMarkingLine();
   		return toJson(list);
   	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return plancuringparameterSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return plancuringparameterSrv;
	}
}
