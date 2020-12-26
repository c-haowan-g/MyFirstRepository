/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.WorkOrderResultServiceImpl;

/**
 * 生产明细查询
 * 
 * @author 时永良
 * @Date 2018-09-10 11:45:20
 */
@Log(code = "WorkOrderResult", value = "WorkOrderResult")
@RestController
@RequestMapping("curing/report/productionSubsidiaryQuery")
public class WorkOrderResultController extends RockWellFunctionalUDAController<Object> {

	@Resource
	WorkOrderResultServiceImpl workorderresultSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return workorderresultSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return workorderresultSrv;
	}

	/*---------------------------------  硫化生产分析页面初始化--------------------------------------------- */
	@Override
	@Log(value = "硫化生产分析页面初始化", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}

	/*---------------------------------  硫化生产分析页面初始化--------------------------------------------- */

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
	public String searchBy(Filter filter, Page page) throws Exception {
		if (filter.get("tyre_barcode_s") == null) {
			Map map = workorderresultSrv.datagridTwo(filter, page);
			return toJson(map);
		} else {
			filter.set("end_time", "");
			filter.set("start_time", "");
			Map map = workorderresultSrv.datagridTwo(filter, page);
			return toJson(map);
		}

	}

	/**
	 * 产线编码的查询（Equipment表中的equip_code_s） 时永良-2019/7/17
	 * 
	 * @return
	 */
	@RequestMapping("searchByEquipCode")
	public String searchByModal() {
		List<Map<String, Object>> list = workorderresultSrv.searchByEquipCode();
		return toJson(list);
	}

	/**
	 * 查询物料编码（part表中的part_number） 时永良-2019/7/17
	 * 
	 * @return
	 */
	@RequestMapping("searchByMaterial")
	public String searchByMaterial() {
		List<Map<String, Object>> list = workorderresultSrv.searchByMaterial();
		return toJson(list);
	}

	/**
	 * 获取硫化曲线数据
	 * 
	 * @param list_map
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("lhqx")
	public String lhqx(@RequestBody Map<String, Object> list_map) throws ParseException {
		List<Map<String, Object>> listDate = workorderresultSrv.lhqx(list_map);
		return toJson(listDate);
	}

	/**
	 * 获取压力曲线数据
	 * 
	 * @param list_map
	 * @return
	 */
	@RequestMapping("dxyl")
	public String dxyl(@RequestBody Map<String, Object> list_map) {
		List<Map<String, Object>> listDate = workorderresultSrv.dxyl(list_map);
		return toJson(listDate);
	}

	/**
	 * 对应硫化与SAP集成报产第一个按钮，报产固化，查询
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Except
	 *             ion
	 */
	@RequestMapping("searchReportData")
	public String searchReportData(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		Map list = workorderresultSrv.datagridUDAThree(filter, page);
		return toJson(list);
	}

	/**
	 * 对应硫化与SAP集成报产第一个按钮，报产固化，固化
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param lineCode
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkOrderResult_curing", value = "硫化数量固化", target = LogType.DB)
	@RequestMapping("curing")
	public Response curing(@RequestBody Map<String, Object> workOrderResultReportDTO) throws Exception {
		String message = workorderresultSrv.curing(workOrderResultReportDTO);
		return Response.error(Response.SYS_EXCEPTION, message, null);
	}

	/**
	 * 对应硫化与SAP集成报产第一个按钮，报产固化，明细
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param lineCode
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkOrderResult_productionDetail", value = "硫化报产明细查询", target = LogType.DB)
	@RequestMapping("productionDetail")
	public String productionDetail(@RequestBody Map<String, Object> workOrderResultReportDTO) throws Exception {
		List<Map<String, Object>> list = workorderresultSrv.productionDetail(workOrderResultReportDTO);
		return toJson(list);
	}

	/**
	 * 对应硫化与SAP集成报产第二个按钮，报产上报
	 * 
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkOrderResult_report", value = "硫化数量报产", target = LogType.CONSOLE)
	@RequestMapping("reporttosapBySelectRow")
	public Response reporttosapBySelectRow(String[] batchidlist) throws Exception {
		workorderresultSrv.reporttosapBySelectRow(batchidlist);
		return Response.suc();
	}

	/**
	 * 对应硫化与SAP集成报产第四个按钮，冲产上报
	 * 
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkOrderResult_report", value = "硫化数量冲产", target = LogType.CONSOLE)
	@RequestMapping("reflushtosapBySelectRow")
	public Response reflushtosapBySelectRow(String[] batchidlist) throws Exception {
		workorderresultSrv.reflushtosapBySelectRow(batchidlist);
		return Response.suc();
	}
    /**
     * 对应硫化与SAP集成报产第七个按钮，冲产上报之后将返回成功的数据从生产实绩表变成未固化
     * @return
     * @throws Exception
     */
    @Log(code="WorkOrderResult_report",value="硫化数量冲产",target=LogType.CONSOLE)
    @RequestMapping("repeattosapBySelectRow")
    public Response repeattosapBySelectRow(String[] batchidlist) throws Exception{
        workorderresultSrv.repeattosapBySelectRow(batchidlist);
        return Response.suc();
    }
	/**
	 * 对应硫化与SAP集成报产第五个按钮，明细
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkOrderResult_productionDetail2", value = "硫化与sap集成报产明细查询", target = LogType.DB)
	@RequestMapping("productionDetail2")
	public String productionDetail2(@RequestBody Map<String, Object> workOrderResultReportDTO) throws Exception {
		List<Map<String, Object>> list = workorderresultSrv.productionDetail2(workOrderResultReportDTO);
		return toJson(list);
	}
	/**
	 * 查出模具条码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMoldCode", value = "查出模具条码显示在JSP页面下拉列表处")
	@RequestMapping("searchMoldCode")
	public String searchMoldCode() throws Exception {
		List<Map<String, Object>> list = workorderresultSrv.searchMoldCode();
		return toJson(list);
	}
}
