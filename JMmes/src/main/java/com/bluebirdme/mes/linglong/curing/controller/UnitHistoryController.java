/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.UnitHistoryServiceImpl;

/**
 * unit生产履历
 * 
 * @author penga_liu
 * 
 * @Date 2019年6月23日 下午1:35:41
 */
@RestController
@RequestMapping("unithistory")
public class UnitHistoryController extends RockWellFunctionalUDAController<Object> {

	@Resource
	UnitHistoryServiceImpl UnitHistorySrv;

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return UnitHistorySrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return UnitHistorySrv;
	}

	// 查询全部
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		return GsonTools.toJson(UnitHistorySrv.datagridUDA(filter, page));
	}
}
