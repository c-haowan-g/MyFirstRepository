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
import com.bluebirdme.mes.linglong.common.service.CommonPLMDynamicBalanceExecServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * PLM动平衡标准执行表 Title: CommonPLMDynamicBalanceExecController
 * 
 * @author penga_liu
 * @Date 2019年9月16日 下午3:18:06
 */
@Log(code = "AT_INT_PLM_DYNAMICBALANCEEXEC_LOG", value = "PLM动平衡标准执行表日志")
@RestController
@RequestMapping("common/plm/commonplmdynamicbalanceexec")
public class CommonPLMDynamicBalanceExecController extends RockWellFunctionalUDAController<Object> {

	@Resource
	CommonPLMDynamicBalanceExecServiceImpl commonplmdynamicbalanceexecSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return commonplmdynamicbalanceexecSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return commonplmdynamicbalanceexecSrv;
	}

	@Log(value = "数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridAll")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(commonplmdynamicbalanceexecSrv.datagridUDA(filter, page));
	}
}
