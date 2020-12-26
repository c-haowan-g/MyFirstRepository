/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.curing.service.AlertinformationServiceImpl;

/**
 * 硫化机台报警查询(设备报警信息表)
 * 
 * @author 时永良
 * @Date 2018-12-21 09:12:17
 */
@Log(code = "Alertinformation", value = "硫化机台报警查询")
@RestController
@RequestMapping("curing/ReportQuery/curingAlarmEnquiries")
public class AlertinformationController extends RockWellFunctionalUDAController<Object> {

	@Resource
	AlertinformationServiceImpl alertinformationSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return alertinformationSrv;
	}
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return alertinformationSrv;
	}
	/**
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getAlertinformation")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
	
	/**
	 * 根据病象编号查询病象名称
	 * 
	 * @return
	 */
	@RequestMapping("getReasNameByCode")
	public String getReasNameByCode(String reas_code) throws Exception {
		List<Map<String, Object>> list = alertinformationSrv.getReasNameByCode(reas_code);
		return toJson(list);
	}
}
