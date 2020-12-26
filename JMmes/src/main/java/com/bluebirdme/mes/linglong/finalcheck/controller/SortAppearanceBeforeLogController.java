/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortAppearanceBeforeLog;
import com.bluebirdme.mes.linglong.finalcheck.service.SortAppearanceBeforeLogServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检外观前分拣履历表
 * 
 * @author 时永良
 * @Date 2019-01-07 11:38:44
 */
@Log(code = "AT_D_QM_SORTAPPEARANCELOG", value = "蓝英质检外观前分拣履历")
@RestController
@RequestMapping("finalcheck/qualitylnspectionRecord/sortAppearanceBeforeLog")
public class SortAppearanceBeforeLogController extends RockWellFunctionalUDAController<Object> {

	@Resource
	SortAppearanceBeforeLogServiceImpl sortappearancelogSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return sortappearancelogSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return sortappearancelogSrv;
	}
	
	@RequestMapping("getSortAppearanceBeforeLog")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}

	
}
