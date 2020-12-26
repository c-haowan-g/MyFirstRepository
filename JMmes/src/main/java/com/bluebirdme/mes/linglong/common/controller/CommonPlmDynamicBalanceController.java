/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.common.service.CommonPlmDynamicBalanceServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * PLM动平衡参数集成表
 * @author zqy
 * @Date 2019-06-27 14:24:00
 */
@Log(code="AT_INT_PLM_DYNAMICBALANCE_LOG",value="PLM动平衡参数集成表日志")
@RestController
@RequestMapping("common/plm/commonplmdynamicbalance")
public class CommonPlmDynamicBalanceController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CommonPlmDynamicBalanceServiceImpl commonplmdynamicbalanceSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return commonplmdynamicbalanceSrv;
    }
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return commonplmdynamicbalanceSrv;
	}
    
   
    /**
     * 下发
     * @param recipecodelist
     * @return
     * @throws Exception
     * @author 刘程明
     * @date 2019年7月1日
     */
    @RequestMapping("letdown")
    public Response letdown(String[] recipecodelist) throws Exception {
        return Response.suc(commonplmdynamicbalanceSrv.letdown(recipecodelist));
    }

    @Log(value = "数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridOn")
	public String datagridUDA(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(commonplmdynamicbalanceSrv.datagridUDA(filter, page));
	}
	
    
    
}
