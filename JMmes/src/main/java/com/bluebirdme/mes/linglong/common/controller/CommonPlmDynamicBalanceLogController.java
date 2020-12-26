/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.CommonPlmDynamicBalanceLogServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * PLM动平衡标准集成日志表
 * 
 * @author 刘程明
 * @Date 2019-07-02 17:26:05
 */
@Log(code = "AT_INT_PLM_DYNAMICBALANCE_LOG_LOG", value = "PLM动平衡标准集成日志表操作日志")
@RestController
@RequestMapping("common/plm/commonplmdynamicbalancelog")
public class CommonPlmDynamicBalanceLogController extends RockWellFunctionalUDAController<Object> {

	@Resource
	CommonPlmDynamicBalanceLogServiceImpl commonplmdynamicbalancelogSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return commonplmdynamicbalancelogSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return commonplmdynamicbalancelogSrv;
	}

	@Log(value = "数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridAll")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(commonplmdynamicbalancelogSrv.datagridUDA(filter, page));
	}
}
