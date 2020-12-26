/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.MouldWorkListServiceImpl;

/**
 * 模具使用履历
 * 
 * @author 时永良
 * @Date 2018-08-22 16:49:40
 */
@Log(code = "AT_C_MM_WORKLIST", value = "模具使用履历")
@RestController
@RequestMapping("curing/moldManagement/mouldWorkList")
public class MouldWorkListController extends RockWellFunctionalUDAController<Object> {

	@Resource
	MouldWorkListServiceImpl worklistSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return worklistSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return worklistSrv;
	}

	/**
	 * 模具使用履历
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getMouldWorkList")
	public String datagrid(Filter filter, Page page, Class clazz) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}

	/**
	 * 洗模履历
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getCleanMouldWorkList")
	public String datagrid2(Filter filter, Page page, Class clazz) throws Exception {
		return GsonTools.toJson(worklistSrv.datagridUDA2(filter, page));
	}
}
