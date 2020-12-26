package com.bluebirdme.mes.linglong.finalcheck.controller;

/**

 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortStorageLogs;
import com.bluebirdme.mes.linglong.finalcheck.service.SortstoragelogsServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检入库分拣履历表
 * 
 * @author 时永良
 * @Date 2019-01-07 14:24:38
 */
@Log(code = "质检入库分拣履历表", value = "质检入库分拣履历表")
@RestController
@RequestMapping("finalcheck/qualitylnspectionRecord/sortStorageLog")
public class SortstoragelogsController extends RockWellFunctionalUDAController<Object> {

	@Resource
	SortstoragelogsServiceImpl sortstoragelogsSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return sortstoragelogsSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return sortstoragelogsSrv;
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
