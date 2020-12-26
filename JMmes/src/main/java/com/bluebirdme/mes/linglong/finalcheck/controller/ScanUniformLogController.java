/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanUniformLogServiceImpl;

/**
 * 质检均匀性扫描履历表-全钢
 * 
 * @author 刘朋
 * @Date 2019-09-12 09:49:19
 */
@Log(code = "AT_D_QM_SCANUNIFORMLOG", value = "均匀性扫描履历")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/scanUniformLog")
public class ScanUniformLogController extends RockWellFunctionalUDAController<Object> {

	@Resource
	ScanUniformLogServiceImpl scanuniformlogSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return scanuniformlogSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return scanuniformlogSrv;
	}

	@Log(code = "AT_D_QM_SCANUNIFORMLOG_SAVE_CHANGES", value = "保存数据的增删改", target = LogType.DB)
	@RequestMapping("saveChanges")
	public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		scanuniformlogSrv.saveChanges(rockWellEntityDTO);
		return Response.suc();
	}
	
	@Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
	/*	if(filter.getFilter().containsKey("barcode_s")){
			filter.set("begin_created_time","");
			filter.set("end_created_time","");
		}*/
		return GsonTools.toJson(scanuniformlogSrv.datagridUDA(filter, page));
	}
}
