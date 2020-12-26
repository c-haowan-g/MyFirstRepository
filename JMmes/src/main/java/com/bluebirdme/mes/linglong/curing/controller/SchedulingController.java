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
import com.bluebirdme.mes.linglong.curing.entity.Scheduling;
import com.bluebirdme.mes.linglong.curing.service.SchedulingServiceImpl;

/**
 * 人员排班查询
 * 
 * @author 时永良
 * @Date 2018-08-20 14:39:09
 */
@Log(code = "LH_SCGL_PBCX", value = "人员排班查询日志")
@RestController
@RequestMapping("curing/productionManagement/shiftQuery")
public class SchedulingController extends RockWellFunctionalUDAController<Object> {

	@Resource
	SchedulingServiceImpl schedulingSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return schedulingSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return schedulingSrv;
	}
	
	/**
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getScheduling")
	public String getScheduling(Filter filter, Page page, Class clazz)
			throws Exception {
		if (filter.toString().contains("equip_code_s")) {
			String str = "%" + filter.get("equip_code_s") + "%";
			filter.set("equip_code_s", str);
		}
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}

	/**
	 * 
	 * @Title: getEqu
	 * @Description: TODO(未领用机台查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getEqu")
	public String getEqu() {
		List<Map<String, Object>> list = schedulingSrv.getEqu();
		return toJson(list);
	}
}
