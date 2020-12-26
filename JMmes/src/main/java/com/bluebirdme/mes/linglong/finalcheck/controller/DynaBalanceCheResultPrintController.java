/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynaBalanceCheResultPrint;
import com.bluebirdme.mes.linglong.finalcheck.service.DynaBalanceCheResultPrintServiceImpl;

/**
 * 轮胎主表
 * 
 * @author wanghailin
 * @Date 2018-09-12 17:58:15
 */
@Log(code = "AT_C_MM_MainTyre_Log", value = "轮胎主表日志")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/dynaBalanceCheResultPrint")
public class DynaBalanceCheResultPrintController extends RockWellFunctionalUDAController<Object> {

	@Resource
	DynaBalanceCheResultPrintServiceImpl dynaBalanceCheResultPrintService;

	

	

	@Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getService().datagrid(filter, page, DynaBalanceCheResultPrint.class));
	}

	@Log(code = "getGradeNum", value = "获取等级")
	@RequestMapping("getGradeNum")
	public String getGradeNum(String beginTime, String endTime, String curingspeccode_s, String entbarcode_s)
			throws Exception {
		List<Map<String, Object>> list = dynaBalanceCheResultPrintService.getGradeNum(beginTime, endTime,
				curingspeccode_s, entbarcode_s);
		return toJson(list);
	}

	/**
	 * 新封装的datagrid数据：（datagrid+getGradeNum）
	 * 
	 * @Title: getdata
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("getdata")
	public String getdata(String beginTime, String endTime, String curingspeccode_s, String entbarcode_s)
			throws Exception {
		List<Map<String, Object>> list = dynaBalanceCheResultPrintService.getdata(beginTime, endTime, curingspeccode_s,
				entbarcode_s);
		return toJson(list);
	}
    
	
	/**
     * BY 时永良（用于动平衡检测结果汇总机台下拉列表）
     * @param equip_type
     * @return
     * @throws Exception
     */
	@Log(code = "SearchEnt", value = "机台下拉框", target = LogType.CONSOLE)
	@RequestMapping("SearchEnt")
	public String SearchEnt() throws Exception {
		List<Map<String, Object>> list = dynaBalanceCheResultPrintService.SearchEnt();
		return toJson(list);
	}
	
	/**
     * BY 时永良（根据机台查询其中文名称）
     * @param equip_type
     * @return
     * @throws Exception
     */
	@Log(code = "SearchDescription", value = "机台中文", target = LogType.CONSOLE)
	@RequestMapping("SearchDescription")
	public String SearchDescription(String barcode) throws Exception {
		List<Map<String, Object>> list = dynaBalanceCheResultPrintService.SearchDescription(barcode);
		return toJson(list);
	}
	
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return dynaBalanceCheResultPrintService;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return dynaBalanceCheResultPrintService;
	}
	
	@RequestMapping("filter")
	public String filter(Filter filter, Page page, String[] sumFlag)
			throws Exception {
		String[] newSumFlag = sumFlag[0].split(",");
        List<String> queryList = Arrays.asList(newSumFlag); //先将数组转化成集合
        Map<String,Object> map = dynaBalanceCheResultPrintService.filter(filter, page, queryList);
		return toJson(map);
	}
	
	
	//数据导出
  	@RequestMapping("export")
  	public void exprot(@RequestParam("sumFlag")String[] sumFlag,@RequestParam("starttime")String starttime,@RequestParam("endtime")String endtime,@RequestParam("curingspeccode")String curingspeccode) throws Exception{
  		Filter filter = new Filter();
  		List<String> queryList=null;
  		if(sumFlag.length==1){
  			String[] newSumFlag = sumFlag[0].split(",");
  	        queryList = Arrays.asList(newSumFlag); //先将数组转化成集合
  		}else{
  		    queryList = Arrays.asList(sumFlag); //先将数组转化成集合
  		}
  		
		filter.set("begin_created_time", starttime);
		filter.set("end_created_time", endtime);
		filter.set("curingspeccode_s", curingspeccode);
		
		// 每次查询2000条导入
		int batchQueryCount = 100;

		Page page = new Page();
		page.setRows(batchQueryCount);
		page.setAll(0);

		int pageNum = 1;
		response.reset();
		response.setHeader("content-disposition", "attachment;filename="
				+ new String("动平衡检测结果汇总（全钢）.csv".getBytes("GBK"), "ISO-8859-1"));
		
		String title =null;
		if(queryList.contains("curingmachinecode_s")&&sumFlag.length==1){
			title="硫化机台,物料编码,物料描述,受检总数,动平衡A+1,动平衡A+1品率,跳动度A+1,跳动度A+1品率,A+1,A+1品率,动平衡A,动平衡A品率,跳动度A,跳动度A品率,A,A品率,动平衡A0,动平衡A0品率,跳动度A0,跳动度A0品率,A0,A0品率,动平衡D,动平衡D品率,跳动度D,跳动度D品率,二级,二级品率";
		}
		if(queryList.contains("buildinmachinecode_s")&&sumFlag.length==1){
			title="成型机台,物料编码,物料描述,受检总数,动平衡A+1,动平衡A+1品率,跳动度A+1,跳动度A+1品率,A+1,A+1品率,动平衡A,动平衡A品率,跳动度A,跳动度A品率,A,A品率,动平衡A0,动平衡A0品率,跳动度A0,跳动度A0品率,A0,A0品率,动平衡D,动平衡D品率,跳动度D,跳动度D品率,二级,二级品率";
		}
		if(queryList.contains("dynaBalancemachinecode_s")&&sumFlag.length==1){
			title="动平衡机台,物料编码,物料描述,受检总数,动平衡A+1,动平衡A+1品率,跳动度A+1,跳动度A+1品率,A+1,A+1品率,动平衡A,动平衡A品率,跳动度A,跳动度A品率,A,A品率,动平衡A0,动平衡A0品率,跳动度A0,跳动度A0品率,A0,A0品率,动平衡D,动平衡D品率,跳动度D,跳动度D品率,二级,二级品率";
		}
		if(queryList.contains("buildinmachinecode_s")&&queryList.contains("curingmachinecode_s")&&sumFlag.length==2){
			title="成型机台,硫化机台,物料编码,物料描述,受检总数,动平衡A+1,动平衡A+1品率,跳动度A+1,跳动度A+1品率,A+1,A+1品率,动平衡A,动平衡A品率,跳动度A,跳动度A品率,A,A品率,动平衡A0,动平衡A0品率,跳动度A0,跳动度A0品率,A0,A0品率,动平衡D,动平衡D品率,跳动度D,跳动度D品率,二级,二级品率";
		}
		if(queryList.contains("buildinmachinecode_s")&&queryList.contains("dynaBalancemachinecode_s")&&sumFlag.length==2){
			title="成型机台,动平衡机台,物料编码,物料描述,受检总数,动平衡A+1,动平衡A+1品率,跳动度A+1,跳动度A+1品率,A+1,A+1品率,动平衡A,动平衡A品率,跳动度A,跳动度A品率,A,A品率,动平衡A0,动平衡A0品率,跳动度A0,跳动度A0品率,A0,A0品率,动平衡D,动平衡D品率,跳动度D,跳动度D品率,二级,二级品率";
		}
		if(queryList.contains("curingmachinecode_s")&&queryList.contains("dynaBalancemachinecode_s")&&sumFlag.length==2){
			title="硫化机台,动平衡机台,物料编码,物料描述,受检总数,动平衡A+1,动平衡A+1品率,跳动度A+1,跳动度A+1品率,A+1,A+1品率,动平衡A,动平衡A品率,跳动度A,跳动度A品率,A,A品率,动平衡A0,动平衡A0品率,跳动度A0,跳动度A0品率,A0,A0品率,动平衡D,动平衡D品率,跳动度D,跳动度D品率,二级,二级品率";
		}
		if(sumFlag.length==3){
			title="成型机台,硫化机台,动平衡机台,物料编码,物料描述,受检总数,动平衡A+1,动平衡A+1品率,跳动度A+1,跳动度A+1品率,A+1,A+1品率,动平衡A,动平衡A品率,跳动度A,跳动度A品率,A,A品率,动平衡A0,动平衡A0品率,跳动度A0,跳动度A0品率,A0,A0品率,动平衡D,动平衡D品率,跳动度D,跳动度D品率,二级,二级品率";
		}
		StringBuffer sb = new StringBuffer();
		OutputStream writer = response.getOutputStream();
		writer.write((title + System.getProperty("line.separator")).getBytes("GBK"));
		// 缓冲输出到客户端，浏览器将立即开始下载，提高用户体验
		writer.flush();

		ConcurrentHashMap<String, String> grade = new ConcurrentHashMap<String, String>();
		System.out.println("数据总行数:" + dynaBalanceCheResultPrintService.getTotal(filter, page, queryList));
		while (true) {
			// 分页查询数据
			long t1 = System.currentTimeMillis();
			System.out.println("正在查询第" + (pageNum++) + "页数据");
			List<Map<String, Object>> list = dynaBalanceCheResultPrintService.getRows(filter, page, queryList);
			long t2 = System.currentTimeMillis();
			System.out.println("数据查询完成，耗时:" + (t2 - t1) + "ms");
			// filter.set("atr_key", list.get(list.size()-1).getAtr_key());
			page.setPage(page.getPage() + 1);
			for (Map<String, Object> rs : list) {
				sb = new StringBuffer();
				if(rs.containsKey("buildinmachinecode_s")){
					if(rs.get("buildinmachinecode_s")!=null){
						sb.append(rs.get("buildinmachinecode_s").toString()).append(",");					
					}else{
						sb.append("补录").append(",");		
					}
				}
				if(rs.containsKey("curingmachinecode_s")){
					if(rs.get("curingmachinecode_s")!=null){
						sb.append(rs.get("curingmachinecode_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("dynabalancemachinecode_s")){
					if(rs.get("dynabalancemachinecode_s")!=null){
						sb.append(rs.get("dynabalancemachinecode_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("curingspeccode_s")){
					if(rs.get("curingspeccode_s")!=null){
						sb.append(rs.get("curingspeccode_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("description")){
					if(rs.get("description")!=null){
						sb.append(rs.get("description").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("speccount")){
					if(rs.get("speccount")!=null){
						sb.append(rs.get("speccount").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("dpha1")){
					if(rs.get("dpha1")!=null){
						sb.append(rs.get("dpha1").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("dpha1pinlv")){
					if(rs.get("dpha1pinlv")!=null){
						sb.append(rs.get("dpha1pinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("tdda1")){
					if(rs.get("tdda1")!=null){
						sb.append(rs.get("tdda1").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("tdda1pinlv")){
					if(rs.get("tdda1pinlv")!=null){
						sb.append(rs.get("tdda1pinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("a1")){
					if(rs.get("a1")!=null){
						sb.append(rs.get("a1").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("a1pinlv")){
					if(rs.get("a1pinlv")!=null){
						sb.append(rs.get("a1pinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				
				
				if(rs.containsKey("dpha")){
					if(rs.get("dpha")!=null){
						sb.append(rs.get("dpha").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("dphapinlv")){
					if(rs.get("dphapinlv")!=null){
						sb.append(rs.get("dphapinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("tdda")){
					if(rs.get("tdda")!=null){
						sb.append(rs.get("tdda").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("tddapinlv")){
					if(rs.get("tddapinlv")!=null){
						sb.append(rs.get("tddapinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("a")){
					if(rs.get("a")!=null){
						sb.append(rs.get("a").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("apinlv")){
					if(rs.get("apinlv")!=null){
						sb.append(rs.get("apinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				
				if(rs.containsKey("dpha0")){
					if(rs.get("dpha0")!=null){
						sb.append(rs.get("dpha0").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("dpha0pinlv")){
					if(rs.get("dpha0pinlv")!=null){
						sb.append(rs.get("dpha0pinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("tdda0")){
					if(rs.get("tdda0")!=null){
						sb.append(rs.get("tdda0").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("tdda0pinlv")){
					if(rs.get("tdda0pinlv")!=null){
						sb.append(rs.get("tdda0pinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("a0")){
					if(rs.get("a0")!=null){
						sb.append(rs.get("a0").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("a0pinlv")){
					if(rs.get("a0pinlv")!=null){
						sb.append(rs.get("a0pinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				
				
				if(rs.containsKey("dphd")){
					if(rs.get("dphd")!=null){
						sb.append(rs.get("dphd").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("dphdpinlv")){
					if(rs.get("dphdpinlv")!=null){
						sb.append(rs.get("dphdpinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("tddd")){
					if(rs.get("tddd")!=null){
						sb.append(rs.get("tddd").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("tdddpinlv")){
					if(rs.get("tdddpinlv")!=null){
						sb.append(rs.get("tdddpinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("erji")){
					if(rs.get("erji")!=null){
						sb.append(rs.get("erji").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("erjipinlv")){
					if(rs.get("erjipinlv")!=null){
						sb.append(rs.get("erjipinlv").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				writer.write((sb.toString().replace("\n", " ").replace("\r", " ").replace("null", "") + System
						.getProperty("line.separator")).getBytes("GBK"));
				writer.flush();
			}
			if (list.size() < batchQueryCount) {
				break;
			}
			if (list.size() < batchQueryCount) {
				break;
			}
			long t3 = System.currentTimeMillis();
			System.out.println("第" + (pageNum - 1) + "页数据输出完成，耗时:" + (t3 - t2) + "ms");
		}
		writer.close();
  	}
}
