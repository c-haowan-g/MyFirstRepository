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

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.CapsuleStandardServiceImpl;

/**
 * 胶囊工艺标准
 * 
 * @author 李迺锟
 * @Date 2018-08-03 14:53:59
 */
@Log(code = "CapsuleStandard", value = "CapsuleStandard")
@RestController
@RequestMapping("curing/moldmanagement/CapsuleStandard")
public class CapsuleStandardController extends RockWellFunctionalUDAController<Object> {

	@Resource
	CapsuleStandardServiceImpl capsulestandardSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return capsulestandardSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return capsulestandardSrv;
	}

	@Log(code = "CapsuleStandard_SAVE_CHANGES", value = "保存数据的增删改")
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		if (capsulestandardSrv.saveChanges(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复", rockWellEntityDTO);
		}
		return Response.suc();
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
	public String searchByEntName(Filter filter, Page page) throws Exception {
		Map list = capsulestandardSrv.datagridUDA(filter, page);
		return toJson(list);
	}

	/**
	 * 物料数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByMaterial")
	public String searchByModal() {
		List<Map<String, Object>> list = capsulestandardSrv.searchByMaterial();
		return toJson(list);
	}

	/**
	 * 胶囊规格的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchBycapsule")
	public String searchBycapsule(@RequestBody String value) {
		System.out.println(value.replace("\"", ""));
		String capsule = capsulestandardSrv.searchBycapsule(value.replace("\"", ""));
		return toJson(capsule);
	}

	/**
	 * 胶囊规格的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchCodeByMaterial")
	public String searchCodeByMaterial(@RequestBody String value) {
		System.out.println(value.replace("\"", ""));
		String capsule = capsulestandardSrv.searchCodeByMaterial(value.replace("\"", ""));
		return toJson(capsule);
	}

	/**
	 * 供应商的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByVendor")
	public String searchByVendor() {
		List<Map<String, Object>> capsule = capsulestandardSrv.searchByVendor();
		return toJson(capsule);
	}
}
