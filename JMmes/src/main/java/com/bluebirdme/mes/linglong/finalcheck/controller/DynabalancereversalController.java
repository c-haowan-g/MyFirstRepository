/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import javax.annotation.Resource;

import com.bluebirdme.mes.linglong.core.*;

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

import com.bluebirdme.mes.linglong.finalcheck.service.DynabalancereversalServiceImpl;

/**
 * 质检动平衡翻转维护
 * @author 马建斌
 * @Date 2018-10-12 10:21:29
 */
@Log(code="ZJ_JCGL_DPHFZWH_DY",value="质检动平衡翻转维护日志")
@RestController
@RequestMapping("finalcheck/standardmagement/dynabalancereversal")
public class DynabalancereversalController extends RockWellFunctionalUDAController<Object> {
    
    @Resource DynabalancereversalServiceImpl dynabalancereversalSrv;

    /**
     * 修改人 : 李新宇
     * @param rockWellEntityDTO
     * @return
     * @throws Exception
     */
    @Log(code="机台信息状态表 _SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        dynabalancereversalSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return dynabalancereversalSrv;
    }

    /**
     * 修改人 : 李新宇
     * @param filter
     * @param page
     * @return
     * @throws Exception
     */
    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	//System.out.println(page.getPage()+"\t"+page.getRows());
		return GsonTools.toJson(dynabalancereversalSrv.datagridUDA(filter,page));
	}

	@RequestMapping("checkCode")
    @ResponseBody
	public Object checkCode(String code){
        return dynabalancereversalSrv.checkCode(code);
    }

    @Override
    protected RockWellUDABaseServiceImpl<Object> getUDAService() {
        return dynabalancereversalSrv;
    }
}
