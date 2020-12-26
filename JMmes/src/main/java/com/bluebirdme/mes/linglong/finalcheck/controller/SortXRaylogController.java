/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortXRaylog;
import com.bluebirdme.mes.linglong.finalcheck.service.SortXRaylogServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检X关分拣履历表
 * 
 * @author lnk
 * @Date 2019-01-04 16:06:03
 */
@Log(code = "AT_D_QM_SORTXRAYLOG", value = "蓝英质检X光分拣履历表")
@RestController
@RequestMapping("finalcheck/qualitylnspectionRecord/sortXrayLog")
public class SortXRaylogController extends RockWellFunctionalUDAController<Object> {

	@Resource
	SortXRaylogServiceImpl sortxraylogSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return sortxraylogSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return sortxraylogSrv;
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
		Map list = getUDAService().datagridUDA(filter, page);
		return toJson(list);
	}
}
