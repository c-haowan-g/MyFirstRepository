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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.MesSapProduction;
import com.bluebirdme.mes.linglong.curing.service.MesSapProductionServiceImpl;

/**
 * 产量固化与SAP抛帐
 * 
 * @author 时永良
 * @Date 2018-12-20 10:43:44
 */
@Log(code = "AT_INT_SAP_MESSAPPRODUCTION_LOG", value = "产量固化与SAP抛帐日志")
@RestController
@RequestMapping("curing/mesapproduction")
public class MesSapProductionController extends RockWellFunctionalUDAController<Object> {

	@Resource
	MesSapProductionServiceImpl messapproductionSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return messapproductionSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return messapproductionSrv;
	}
	
	/**
	 * 对应硫化与SAP集成报产第七个按钮，版本变更，查询
	 * @Title: 页面初始化
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page)
			throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
	/**
	 * 对应硫化与SAP集成报产第七个按钮，版本变更，保存
	 * @param list
	 * @return
	 * @throws Exception
	 */
	@Log(code = "AT_INT_SAP_MESSAPPRODUCTION_LOG_CHANGE_VERSION", value = "保存版本变更", target = LogType.DB)
	@RequestMapping("saveVersion")
	public Response saveVersion(@RequestBody List<MesSapProduction> list) throws Exception {
		String message=messapproductionSrv.saveVersion(list);
		return Response.error(Response.SYS_EXCEPTION,message,null);
	}
	/**
	 * 带条件查询全部
	 * 孙尊龙-2020/5/20
	 * @return
	 */
	@RequestMapping("searchBy")
	public String searchBy(String post_date_s,String batch_id_s,String material_code_s,String class_id_s,String operate_usernane_s,String serid_s,String product_type_s,String process_s) throws Exception{
		Filter filter = new Filter();
		filter.set("post_date_s", post_date_s).set("batch_id_s", batch_id_s).set("material_code_s", material_code_s)
				.set("class_id_s", class_id_s).set("operate_usernane_s", operate_usernane_s)
				.set("serid_s", serid_s).set("product_type_s", product_type_s).set("process_s",process_s);
		List<Map<String, Object>> list = messapproductionSrv.searchBy(filter);

		return toJson(list);
	}

}
