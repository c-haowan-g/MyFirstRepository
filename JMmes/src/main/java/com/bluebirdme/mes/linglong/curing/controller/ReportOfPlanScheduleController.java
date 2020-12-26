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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.ReportOfPlanSchedule;
import com.bluebirdme.mes.linglong.curing.service.ReportOfPlanScheduleServiceImpl;

/**
 * 日计划进度查询
 * @author 时永良
 * @Date 2018-10-08 15:46:14
 */
@Log(code="LH_BB_JHJDBB",value="日计划进度查询")
@RestController
@RequestMapping("curing/reportQuery/scheduleReport/reportOfPlanSchedule")
public class ReportOfPlanScheduleController extends RockWellFunctionalUDAController<Object> {
    
    @Resource ReportOfPlanScheduleServiceImpl ReportOfPlanScheduleSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return ReportOfPlanScheduleSrv;
    }
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return ReportOfPlanScheduleSrv;
	}
    @Override
  	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
  	@ResponseBody
  	@RequestMapping("datagrid")
  	public String datagrid(Filter filter, Page page) throws Exception {
  		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
  	}

    /**
	 * 产线编码的查询（AT_C_MM_MACHINECONTROL中的Product_Line_s）
	 * 时永良-2019/7/17
	 * @return
	 */
	@RequestMapping("searchByProductLine")
	public String searchByProductLine() {
		List<Map<String, Object>> list = ReportOfPlanScheduleSrv.searchByProductLine();
		return toJson(list);
	}
}
