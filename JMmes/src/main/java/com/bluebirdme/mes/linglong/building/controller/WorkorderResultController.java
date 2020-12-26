/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.building.entity.dto.UpdateWorkOrderResultReportDTO;
import com.bluebirdme.mes.linglong.building.entity.dto.WorkOrderResultReportDTO;
import com.bluebirdme.mes.linglong.building.service.WorkorderResultServiceImpl;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * 成型生成实绩查询
 * 
 * @author 时永良
 * @Date 2019-01-16 08:11:24
 */
@Log(code = "成型生成实绩查询", value = "成型生成实绩查询")
@RestController
@RequestMapping("building/productionManagement/workOrderResult")
public class WorkorderResultController extends RockWellFunctionalUDAController<Object> {

	@Resource
	WorkorderResultServiceImpl workorderresultSrv;

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return workorderresultSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return workorderresultSrv;
	}

	/**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 *             时永良
	 */
	@Log(code = "WorkorderResult_searchInit", value = "查询全部 页面初始化使用")
	@RequestMapping("searchInit")
	public String searchInit(Filter filter, Page page) throws Exception {
		Map map = getUDAService().datagridUDA(filter, page);
		return toJson(map);
	}

	/**
	 * 查出胎胚质量状态显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchDescription", value = "查出胎胚质量状态显示在JSP页面下拉列表处")
	@RequestMapping("searchDescription")
	public String searchDescription() throws Exception {
		List<Map<String, Object>> list = workorderresultSrv.searchDescription();
		return toJson(list);
	}
	
	/**
	 * 查出胎胚质量状态显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "getWeightData", value = "通过工艺配方查出胎胚重量公差参数")
	@RequestMapping("getWeightData")
	public String getWeightData() throws Exception {
		List<Map<String, Object>> list = workorderresultSrv.getWeightData();
		return toJson(list);
	}
	/**
	 * 通过工艺配方查出半钢胎胚重量公差参数
	 * @author dexiao_li
	 * @Date 2020-08-14 15:20:24
	 * @return
	 */
	@Log(code = "getHalfWeightData", value = "通过工艺配方查出半钢胎胚重量公差参数")
	@RequestMapping("getHalfWeightData")
	public String getHalfWeightData() throws Exception {
		List<Map<String, Object>> list = workorderresultSrv.getHalfWeightData();
		return toJson(list);
	}


	/**
	 * 查询成型报产信息用-刘朋
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchReportData")
	public String searchReportData(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("agenc_no_s", LLConstant.JING_MEN_CODE);
		Map list = workorderresultSrv.searchReportData(filter, page);
		return toJson(list);
	}

	/**
	 * 报产固化操作
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param lineCode
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkOrderResult_curing", value = "成型报产数量固化", target = LogType.DB)
	@RequestMapping("Solidification")
	public Response Solidification(@RequestBody WorkOrderResultReportDTO workOrderResultReportDTO) throws Exception {
		workorderresultSrv.Solidification(workOrderResultReportDTO);
		return Response.suc();

	}

	/**
	 * 查询成型冲产信息用
	 * 
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchUpdateData")
	public String searchUpdateData(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("agenc_no_s", LLConstant.JING_MEN_CODE);
		Map list = workorderresultSrv.RushProduct(filter, page);
		return toJson(list);
	}

	/**
	 * 冲产固化操作
	 * 
	 * @param beginTime
	 * @param endTime
	 * @param lineCode
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkOrderResult_updatesolid", value = "成型冲产数量固化", target = LogType.DB)
	@RequestMapping("updatesolid")
	public Response updatesolid(@RequestBody UpdateWorkOrderResultReportDTO workOrderResultReportDTO) throws Exception {
		workorderresultSrv.updatesolid(workOrderResultReportDTO);
		return Response.suc();
	}

	/**
	 * 报产上报
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
	 * 冲产上报
	 * 
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkOrderResult_reflush", value = "硫化数量冲产", target = LogType.CONSOLE)
	@RequestMapping("reflushtosapBySelectRow")
	public Response reflushtosapBySelectRow(String[] batchidlist) throws Exception {
		workorderresultSrv.reflushtosapBySelectRow(batchidlist);
		return Response.suc();
	}
	
	/**
	 * 对应成型与SAP集成报产第五个按钮，明细
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws Exception 
	 */
	@Log(code="WorkOrderResult_productionDetail2",value="成型与sap集成报产明细查询",target=LogType.DB)
	@RequestMapping("productionDetail2")
	public String productionDetail2(@RequestBody Map<String,Object> workOrderResultReportDTO) throws Exception {
		List<Map<String,Object>> list=workorderresultSrv.productionDetail2(workOrderResultReportDTO);
		return toJson(list);
	}
	
	
	/**
	 * 查询成型产出但未硫化的成型生产实绩
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	@Log(code = "WorkorderResult_searchWorkOrderResultByNotCuring", value = "查询成型产出但未硫化的成型生产实绩")
	@RequestMapping("searchWorkOrderResultByNotCuring")
	public String searchWorkOrderResultByNotCuring(Filter filter, Page page) throws Exception {
		Map map = workorderresultSrv.datagridUDA4(filter, page);
		return toJson(map);
	}
	//全部查询
	@Log(code = "s", value = "s")
	@RequestMapping("search")
	public String search() throws Exception {
		List<Map<String, Object>> list = workorderresultSrv.search();
		return toJson(list);
	}
	
	@NoLogin
	@Log(value = "导出EXCEL", code = "ZJ_JCGL_WORK_EXPORT")
	@RequestMapping("export")
	  public void export(String s_factory_s, String tyre_barcode_s, String equip_code_s, String material_code_s, String workerMain_id_s,String workerAssistant_id1_s,String workerAssistant_id2_s,
			  String quality_status_s,String created_by_s,String add_flag_s,String tire_car_code_s,String building_shift_s,String begintime, String endtime,String spare1_s) throws Exception
	  {
		 Filter filter = new Filter();
		 filter.set("tyre_barcode_s", tyre_barcode_s)
	        .set("equip_code_s", equip_code_s)
	        .set("material_code_s", material_code_s)
	        .set("s_factory_s", s_factory_s)
	        .set("workerMain_id_s", workerMain_id_s)
	        .set("workerAssistant_id1_s", workerAssistant_id1_s)
	        .set("workerAssistant_id2_s", workerAssistant_id2_s)
	        .set("quality_status_s", quality_status_s)
	        .set("created_by_s", created_by_s)
	        .set("add_flag_s", add_flag_s)
	        .set("tire_car_code_s", tire_car_code_s)
	        .set("building_shift_s", building_shift_s)
	        .set("begintime", begintime)
	        .set("endtime", endtime)
	        .set("spare1_s", spare1_s);
		 System.out.println(filter);
		  int batchQueryCount = 1000;

		    Page page = new Page();
		    page.setRows(batchQueryCount);
		    page.setAll(0);

		    int pageNum = 1;
		     

		    this.response.reset();

		    this.response.setHeader("content-disposition", "attachment;filename=" 
		    + new String("成型生产实绩.csv"  .getBytes("GBK"),  "ISO-8859-1"));

		    String title = "胎胚条码,日计划号,班次计划号,产线编码,成型补产出类型,是否补成型,补录原因,胎胚车编号,物料编码,物料名称,产出时间,标准重量,成型重量,胎胚上限重量,胎胚下限重量,质量等级,重量是否合格 ,是否首条,一段操作,二段操作,操作辅机,是否固化,固化时间,班次,成型时间";
		    StringBuffer sb = new StringBuffer();
		    OutputStream writer = this.response.getOutputStream();
		    writer.write((title + System.getProperty("line.separator")) .getBytes("GBK"));

		    writer.flush();
		    ConcurrentHashMap <String, String>machine = new ConcurrentHashMap<String, String>();
		    try{
		    	while (true) {
			        long t1 = System.currentTimeMillis();
			        System.out.println("正在查询第" + pageNum++ + "页数据");
			        
			       
			        List<Map<String, Object>> list = getUDAService().datagridRowsUDA(filter, page);
			        long t2 = System.currentTimeMillis();
			        System.out.println("数据查询完成，耗时:" + (t2 - t1) + "ms");
			        page.setPage(page.getPage() + 1);
			      
			        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			        for (Map<String, Object> rs : list)
			        {
			        	
						 if (rs.get("s_factory_s").toString().equals("2")) {
							 rs.put("s_factory_s", "半钢");
						 } else {
							 rs.put("s_factory_s", "全钢");
						 }
			          sb = new StringBuffer();
			          if(rs.containsKey("tyre_barcode_s")){
							if(rs.get("tyre_barcode_s")!=null){
								sb.append(rs.get("tyre_barcode_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
			          if(rs.containsKey("plan_no_s")){
							if(rs.get("plan_no_s")!=null){
								sb.append(rs.get("plan_no_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("work_order_id_s")){
							if(rs.get("work_order_id_s")!=null){
								sb.append(rs.get("work_order_id_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("equip_code_s")){
							if(rs.get("equip_code_s")!=null){
								sb.append(rs.get("equip_code_s").toString()).append(",\t");					
							}else{
								sb.append("").append(",\t");		
							}
						}
						if(rs.containsKey("created_by_s")){
							if(rs.get("created_by_s")!=null){
								if(rs.get("created_by_s").toString().equals("360001"))
								{
									sb.append("新增").append(",\t");					
								}
								else if(rs.get("created_by_s").toString().equals("360001"))
								{
									sb.append("条码替换").append(",\t");
								}
								else if(rs.get("created_by_s").toString().equals("360001"))
								{
									sb.append("规格更改").append(",\t");
								}else
								{
									sb.append("").append(",");
								}
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("add_flag_s")){
							if(rs.get("add_flag_s")!=null){
								if(rs.get("add_flag_s").toString().equals("105001"))
								{
									sb.append("正常产出").append(",\t");					
								}
								else if(rs.get("add_flag_s").toString().equals("105002"))
								{
									sb.append("补产出").append(",\t");
								}
								else if(rs.get("add_flag_s").toString().equals("105003"))
								{
									sb.append("取消产出").append(",\t");
								}
												
							}else{
								sb.append("").append(",\t");		
							}
						}
						if(rs.containsKey("spare1_s")){
							if(rs.get("spare1_s")!=null){
								if(rs.get("spare1_s").toString().equals("361001"))
								{
									sb.append("计划有误").append(",\t");					
								}
								else if(rs.get("spare1_s").toString().equals("361002"))
								{
									sb.append("操作问题").append(",\t");
								}
								else if(rs.get("spare1_s").toString().equals("361003"))
								{
									sb.append("设备故障").append(",\t");
								}else if(rs.get("spare1_s").toString().equals("361004"))
								{
									sb.append("厂家调试").append(",\t");
								}
								else if(rs.get("spare1_s").toString().equals("361005"))
								{
									sb.append("系统异常").append(",\t");
								}
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("tire_car_code_s")){
							if(rs.get("tire_car_code_s")!=null){
								sb.append(rs.get("tire_car_code_s").toString()).append(",\t");					
							}else{
								sb.append("").append(",\t");		
							}
						}
						if(rs.containsKey("material_code_s")){
							if(rs.get("material_code_s")!=null){
								sb.append(rs.get("material_code_s").toString()).append(",");					
							}else{
								sb.append("").append(",\t");		
							}
						}
						if(rs.containsKey("material_name_s")){
							if(rs.get("material_name_s")!=null){
								sb.append(rs.get("material_name_s").toString().replace(",","，")).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("building_date_t")){
							if(rs.get("building_date_t")!=null){
								sb.append(rs.get("building_date_t").toString().substring(0, 18)).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("standard_weight_s")){
							if(rs.get("standard_weight_s")!=null){
								sb.append(rs.get("standard_weight_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("building_weight_s")){
							if(rs.get("building_weight_s")!=null){
								sb.append(rs.get("building_weight_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("spare4_s")){
							if(rs.get("spare4_s")!=null){
								sb.append(rs.get("spare4_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("spare3_s")){
							if(rs.get("spare3_s")!=null){
								sb.append(rs.get("spare3_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("quality_status_s")){
							if(rs.get("quality_status_s")!=null){
								
								if(rs.get("quality_status_s").toString().equals("253001"))
								{
									sb.append("合格").append(",\t");					
								}
								else if(rs.get("quality_status_s").toString().equals("253002"))
								{
									sb.append("复检合格").append(",\t");
								}
								else if(rs.get("quality_status_s").toString().equals("253003"))
								{
									sb.append("不合格").append(",\t");
								}
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("quality_weight_status_s")){
							if(rs.get("quality_weight_status_s")!=null){
									
								if(rs.get("quality_weight_status_s").toString().equals("1"))
								{
									sb.append("合格").append(",\t");					
								}
								else if(rs.get("quality_weight_status_s").toString().equals("0"))
								{
									sb.append("超轻").append(",\t");
								}
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("first_s")){
							if(rs.get("first_s")!=null){
								
								if(rs.get("first_s").toString().equals("1"))
								{
									sb.append("否").append(",\t");					
								}
								else if(rs.get("first_s").toString().equals("0"))
								{
									sb.append("是").append(",\t");
								}
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("workermain_id_s")){
							if(rs.get("workermain_id_s")!=null){
								sb.append(rs.get("workermain_id_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("workerassistant_id1_s")){
							if(rs.get("workerassistant_id1_s")!=null){
								sb.append(rs.get("workerassistant_id1_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("workerassistant_id2_s")){
							if(rs.get("workerassistant_id2_s")!=null){
								sb.append(rs.get("workerassistant_id2_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("solid_yflag_s")){
							if(rs.get("solid_yflag_s")!=null){
								if(rs.get("solid_yflag_s").toString().equals("177001"))
								{
									sb.append("已固化").append(",\t");					
								}
								else if(rs.get("solid_yflag_s").toString().equals("177002"))
								{
									sb.append("未固化").append(",\t");
								}
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("solid_time_t")){
							if(rs.get("solid_time_t")!=null){
								sb.append(rs.get("solid_time_t").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("building_shift_s")){
							if(rs.get("building_shift_s")!=null){
								
								if(rs.get("building_shift_s").toString().equals("193001"))
								{
									sb.append("早班").append(",\t");					
								}
								else if(rs.get("building_shift_s").toString().equals("193002"))
								{
									sb.append("中班").append(",\t");
								}
								else if(rs.get("building_shift_s").toString().equals("193003"))
								{
									sb.append("晚班").append(",\t");
								}
							}else{
								sb.append("").append(",");		
							}
						}
						if(rs.containsKey("spare2_s")){
							if(rs.get("spare2_s")!=null){
								sb.append(rs.get("spare2_s").toString()).append(",");					
							}else{
								sb.append("").append(",");		
							}
						}
						 writer.write(
						            (sb.toString().replace("\n", " ")
						            .replace("\r", " ")
						            .replace("null", "") + 
						            System.getProperty("line.separator"))
						            .getBytes("GBK"));
						          writer.flush();
			          }
			        if (list.size() < batchQueryCount) {
				          break;
				        }
				        long t3 = System.currentTimeMillis();
				        System.out.println("第" + (pageNum - 1) + "页数据输出完成，耗时:" + (t3 - t2) + "ms");
		    	}
		    }
		    catch (Exception e) {
			      e.printStackTrace();
			    } finally {
			     
			      writer.close();
			    }
	  }
	
}
