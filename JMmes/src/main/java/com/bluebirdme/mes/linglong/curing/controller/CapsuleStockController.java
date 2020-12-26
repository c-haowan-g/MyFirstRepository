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
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.CapsuleStockServiceImpl;

/**
 * 胶囊库存管理
 * 
 * @author 李迺锟
 * @Date 2019-07-30
 */
@Log(code = "C_WH_CAPSULESTOCK", value = "胶囊库存管理")
@RestController
@RequestMapping("lh/kcgl/jnkc")
public class CapsuleStockController extends RockWellFunctionalUDAController<Object> {

	@Resource
	CapsuleStockServiceImpl capsulestockSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return capsulestockSrv;
	}
	
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return capsulestockSrv;
	}
	/**
	 * 
	 * @Title: datagrid
	 * @Description: TODO(查询)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getCapsuleStock")
	public String datagrid(Filter filter, Page page, Class clazz)
			throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}

	/**
	 * 
	 * @Title: saveChanges
	 * @Description: TODO(增删改)
	 * @return: Response 返回类型
	 * @throws Exception
	 * 
	 */
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO)
			throws Exception {
		capsulestockSrv.save2(rockWellEntityDTO);
		return Response.suc();
	}

	/**
	 * 
	 * @Title: comboxMaterialCode
	 * @Description: TODO(胶囊规格下拉框)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("comboxCapsule_spec")
	public String comboxCapsule_spec() throws Exception {
		List<Map<String, Object>> list = capsulestockSrv
				.getComboxCapsule_spec();
		return toJson(list);
	}

	/**
	 * 
	 * @Title: getDataByspec
	 * @Description: TODO(通过胶囊规格查询物料条码，校验码)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getDataByspec")
	public String getDataByspec(@RequestBody String spec) throws Exception {

		Map<String, Object> data = capsulestockSrv.getDataByspec(spec.replace(
				"\"", ""));

		return toJson(data);
	}

	/**
	 * 
	 * @Title: getSpecByFactory
	 * @Description: TODO(根据厂商查取规格)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getSpecByFactory")
	public String getSpecByFactory(@RequestBody String capsule_factory)
			throws Exception {
		String data = capsulestockSrv.getSpecByFactory(capsule_factory.replace(
				"\"", ""));
		return data;
	}

	/**
	 * 
	 * @Title: countStock
	 * @Description: TODO(统计胶囊即时库存)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("countStock")
	public String countStock() {
		List<Map<String, Object>> list = capsulestockSrv.countStock();
		return toJson(list);
	}

	/**
	 * 胶囊库存下拉框
	 * 
	 * @Title: CapsuleLocation
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("CapsuleLocation")
	public String CapsuleLocation() throws Exception {
		List<Map<String, Object>> list = capsulestockSrv.CapsuleLocation();
		return toJson(list);
	}

}
