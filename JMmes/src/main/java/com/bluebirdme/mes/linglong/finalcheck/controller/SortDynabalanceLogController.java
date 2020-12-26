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
import com.bluebirdme.mes.linglong.finalcheck.entity.SortDynabalanceLog;
import com.bluebirdme.mes.linglong.finalcheck.service.SortDynabalanceLogServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 质检动平衡分拣履历表
 * 
 * @author 时永良
 * @Date 2019-01-04 16:17:10
 */
@Log(code = "AT_D_QM_SORTDYNABALANCELOG", value = "蓝英质检动平衡分拣履历表")
@RestController
@RequestMapping("finalcheck/qualitylnspectionRecord/sortDynaBalanceLog")
public class SortDynabalanceLogController extends RockWellFunctionalUDAController<Object> {

	@Resource
	SortDynabalanceLogServiceImpl sortdynabalancelogSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return sortdynabalancelogSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return sortdynabalancelogSrv;
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
