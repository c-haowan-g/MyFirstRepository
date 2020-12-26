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
import com.bluebirdme.mes.linglong.finalcheck.entity.SortAppearanceBackLog;
import com.bluebirdme.mes.linglong.finalcheck.service.SortAppearanceBackLogServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检外观后分拣履历表
 * 
 * @author 时永良
 * @Date 2019-01-07 14:09:34
 */
@Log(code = "AT_D_QM_SORTAPPEARANCEALOG", value = "蓝英质检外观后分拣履历")
@RestController
@RequestMapping("finalcheck/qualitylnspectionRecord/sortAppearanceBackLog")
public class SortAppearanceBackLogController extends RockWellFunctionalUDAController<Object> {

	@Resource
	SortAppearanceBackLogServiceImpl sortappearancebacklogSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return sortappearancebacklogSrv;
	}
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return sortappearancebacklogSrv;
	}
	
	@RequestMapping("getSortAppearanceBackLog")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
}
