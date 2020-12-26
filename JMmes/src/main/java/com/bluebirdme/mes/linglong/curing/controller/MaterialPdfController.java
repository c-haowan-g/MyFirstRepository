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
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.MaterialPdf;
import com.bluebirdme.mes.linglong.curing.service.MaterialPdfServiceImpl;

/**
 * 模具标识图维护
 * 
 * @author 时永良
 * @Date 2018-08-20 13:57:26
 */
@Log(code = "MaterialPDF", value = "MaterialPDF")
@RestController
@RequestMapping("curing/moldmanagement/moldmarkingdrawing/materialpdf")
public class MaterialPdfController extends RockWellFunctionalUDAController<Object> {

	@Resource
	MaterialPdfServiceImpl MaterialPdfSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return MaterialPdfSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return MaterialPdfSrv;
	}
	
	@Log(code = "MaterialPdf_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		if (MaterialPdfSrv.saveChanges(rockWellEntityDTO) == -1) {
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
	public String searchByEntName(Filter filter, Page page)
			throws Exception {
		Map list = getUDAService().datagridUDA(filter, page);
		return toJson(list);
	}

	/**
	 * 查询模具标示图对应的物料编码（part表中的part_number）
	 * 时永良-2019/7/17
	 * @return
	 */
	@RequestMapping("searchByMaterial")
	public String searchByMaterial() {
		List<Map<String, Object>> list = MaterialPdfSrv.searchByMaterial();
		return toJson(list);
	}
}
