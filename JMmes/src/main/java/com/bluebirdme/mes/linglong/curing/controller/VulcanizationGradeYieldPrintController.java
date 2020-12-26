/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.VulcanizationGradeYieldPrint;
import com.bluebirdme.mes.linglong.curing.service.VulcanizationGradeYieldPrintServiceImpl;

/**
 * 硫化等级产量报表
 * @author 王海霖
 * @Date 2018-12-13 11:17:18
 */
@Log(code="AT_C_MM_WORKORDERRESULT",value="硫化等级产量报表查询")
@RestController
@RequestMapping("lh/bb/lhdjclbb")
public class VulcanizationGradeYieldPrintController extends RockWellFunctionalController<VulcanizationGradeYieldPrint> {
    
    @Resource RockWellBaseServiceImpl<VulcanizationGradeYieldPrint> vgypImpl;
    
    @Resource
    VulcanizationGradeYieldPrintServiceImpl serviceImpl;
    /**
     * 
     * @Description: 查询数据列表
     * @author 王海霖
     * @date 2018-12-14
     */
    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	filter.set("s_factory_s", LLWebUtils.factory());
//    	System.out.println(GsonTools.toJson(getService().datagrid(filter, page, VulcanizationGradeYieldPrint.class)));
		return GsonTools.toJson(getService().datagrid(filter, page, VulcanizationGradeYieldPrint.class));
	}
    /**
     * 详情查询
     * @author hailin_wang
     * @param filter page
     * @return string
     */
	@Log(value = "查询详情", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid_detail")
    public String datagridDetail(Filter filter, Page page)throws Exception{
    	return GsonTools.toJson(serviceImpl.getProductionDayPlanByParamter(filter, page));
    }
    
	@Override
	protected RockWellBaseServiceImpl<VulcanizationGradeYieldPrint> getService() {
		return vgypImpl;
	}


}
