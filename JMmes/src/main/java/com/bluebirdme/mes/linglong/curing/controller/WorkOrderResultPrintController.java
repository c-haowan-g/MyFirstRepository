/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.List;
import java.util.Map;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.WorkOrderResultPrintServiceImpl;

/**
 * 硫化工单生产实绩表
 * @author 时永良
 * @Date 2018-11-10 11:17:18
 */
@Log(code="AT_C_MM_WORKORDERRESULTPRINT_Log",value="硫化产量报表查询")
@RestController
@RequestMapping("curing/ReportQuery/curingProductionReport")
public class WorkOrderResultPrintController extends RockWellFunctionalUDAController<Object> {
    
    @Resource WorkOrderResultPrintServiceImpl workorderresultprintSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return workorderresultprintSrv;
    }
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
    	return workorderresultprintSrv;
	}
    
    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map<String,Object> map=getUDAService().datagridUDA(filter, page);
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    
    /**
	 * 带条件查询全部
	 * 时永良-2019/7/17
	 * @return
	 */
	@RequestMapping("searchBy")
	public String searchBy(String begin_created_time,String end_created_time,String username,String equip_code_s,String class_id_s,String material_name_s,String material_code_s) throws Exception{
		Filter filter = new Filter();
		filter.set("begin_created_time", begin_created_time).set("end_created_time", end_created_time).set("username", username)
				.set("equip_code_s", equip_code_s).set("class_id_s", class_id_s)
				.set("material_name_s", material_name_s).set("material_code_s", material_code_s);
		List<Map<String, Object>> list = workorderresultprintSrv.datagridRowsUDA(filter);
		return toJson(list);
	}
}
