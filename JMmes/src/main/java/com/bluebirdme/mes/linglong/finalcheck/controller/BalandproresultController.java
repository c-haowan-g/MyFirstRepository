/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.BalandproresultServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.EntModelServiceImpl;

/**
 * 质检动平衡检测结果表(国际计测)
 * 
 * @author 刘朋
 * @Date 2019-01-18 15:32:07
 */
@Log(code = "质检动平衡检测结果表(国际计测)", value = "质检动平衡检测结果表(国际计测)")
@RestController
@RequestMapping("finalcheck/dynabalancecheresult/balandproresult")
public class BalandproresultController extends RockWellFunctionalUDAController<Object> {

	@Resource
	BalandproresultServiceImpl balandproresultSrv;
	@Resource
	EntModelServiceImpl entSrv;
	public ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils
			.firstCharToLowerCase("exportServiceImpl"));

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return balandproresultSrv;
	}

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return balandproresultSrv;
	}

	@Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		/*if (filter.getFilter().containsKey("barcode_s")) {
			filter.set("begin_created_time", "");
			filter.set("end_created_time", "");
		}*/
		Map<String, Object> map = balandproresultSrv.datagridUDA(filter, page);
		List<Map<String, Object>> list = (List<Map<String, Object>>) map.get("rows");
		for (Map<String, Object> str : list) {
			str.put("upper_unbalance_g_s", Float.valueOf(str.get("upper_unbalance_g_s").toString()) / 10);
			str.put("lower_unbalance_g_s", Float.valueOf(str.get("lower_unbalance_g_s").toString()) / 10);
			str.put("up_low_unbalance_g_s", Float.valueOf(str.get("up_low_unbalance_g_s").toString()) / 10);
			str.put("static_unbalance_g_s", Float.valueOf(str.get("static_unbalance_g_s").toString()) / 10);
			str.put("couple_unbalance_g_s", Float.valueOf(str.get("couple_unbalance_g_s").toString()) / 10);
			str.put("lt_oa_mm_s", Float.valueOf(str.get("lt_oa_mm_s").toString()) / 100);
			str.put("lt_oa2_mm_s", Float.valueOf(str.get("lt_oa2_mm_s").toString()) / 100);
			str.put("lt_oa3_mm_s", Float.valueOf(str.get("lt_oa3_mm_s").toString()) / 100);
			str.put("lb_oa_mm_s", Float.valueOf(str.get("lb_oa_mm_s").toString()) / 100);
			str.put("lb_oa2_mm_s", Float.valueOf(str.get("lb_oa2_mm_s").toString()) / 100);
			str.put("lb_oa3_mm_s", Float.valueOf(str.get("lb_oa3_mm_s").toString()) / 100);
			str.put("rt_oa_mm_s", Float.valueOf(str.get("rt_oa_mm_s").toString()) / 100);
			str.put("rc_oa_mm_s", Float.valueOf(str.get("rc_oa_mm_s").toString()) / 100);
			str.put("rb_oa_mm_s", Float.valueOf(str.get("rb_oa_mm_s").toString()) / 100);
			str.put("lt_oa_1h_mm_s", Float.valueOf(str.get("lt_oa_1h_mm_s").toString()) / 100);
			str.put("lt_oa2_1h_mm_s", Float.valueOf(str.get("lt_oa2_1h_mm_s").toString()) / 100);
			str.put("lt_oa3_1h_mm_s", Float.valueOf(str.get("lt_oa3_1h_mm_s").toString()) / 100);
			str.put("lb_oa_1h_mm_s", Float.valueOf(str.get("lb_oa_1h_mm_s").toString()) / 100);
			str.put("lb_oa2_1h_mm_s", Float.valueOf(str.get("lb_oa2_1h_mm_s").toString()) / 100);
			str.put("lb_oa3_1h_mm_s", Float.valueOf(str.get("lb_oa3_1h_mm_s").toString()) / 100);
			str.put("rt_oa_1h_mm_s", Float.valueOf(str.get("rt_oa_1h_mm_s").toString()) / 100);
			str.put("rc_oa_1h_mm_s", Float.valueOf(str.get("rc_oa_1h_mm_s").toString()) / 100);
			str.put("rb_oa_1h_mm_s", Float.valueOf(str.get("rb_oa_1h_mm_s").toString()) / 100);
			str.put("lro_t1_nth_mm_s", Float.valueOf(str.get("lro_t1_nth_mm_s").toString()) / 100);
			str.put("lro_t2_nth_mm_s", Float.valueOf(str.get("lro_t2_nth_mm_s").toString()) / 100);
			str.put("lro_t3_nth_mm_s", Float.valueOf(str.get("lro_t3_nth_mm_s").toString()) / 100);
			str.put("lro_b1_nth_mm_s", Float.valueOf(str.get("lro_b1_nth_mm_s").toString()) / 100);
			str.put("lro_b2_nth_mm_s", Float.valueOf(str.get("lro_b2_nth_mm_s").toString()) / 100);
			str.put("lro_b3_nth_mm_s", Float.valueOf(str.get("lro_b3_nth_mm_s").toString()) / 100);
			str.put("rro_t_nth_mm_s", Float.valueOf(str.get("rro_t_nth_mm_s").toString()) / 100);
			str.put("rro_c_nth_mm_s", Float.valueOf(str.get("rro_c_nth_mm_s").toString()) / 100);
			str.put("rro_b_nth_mm_s", Float.valueOf(str.get("rro_b_nth_mm_s").toString()) / 100);
			str.put("lt_bulging_mm_s", Float.valueOf(str.get("lt_bulging_mm_s").toString()) / 100);
			str.put("lt_bulging2_mm_s", Float.valueOf(str.get("lt_bulging2_mm_s").toString()) / 100);
			str.put("lt_bulging3_mm_s", Float.valueOf(str.get("lt_bulging3_mm_s").toString()) / 100);
			str.put("lb_bulging_mm_s", Float.valueOf(str.get("lb_bulging_mm_s").toString()) / 100);
			str.put("lb_bulging2_mm_s", Float.valueOf(str.get("lb_bulging2_mm_s").toString()) / 100);
			str.put("lb_bulging3_mm_s", Float.valueOf(str.get("lb_bulging3_mm_s").toString()) / 100);
			str.put("lt_dent_mm_s", Float.valueOf(str.get("lt_dent_mm_s").toString()) / 100);
			str.put("lt_dent2_mm_s", Float.valueOf(str.get("lt_dent2_mm_s").toString()) / 100);
			str.put("lt_dent3_mm_s", Float.valueOf(str.get("lt_dent3_mm_s").toString()) / 100);
			str.put("lb_dent_mm_s", Float.valueOf(str.get("lb_dent_mm_s").toString()) / 100);
			str.put("lb_dent2_mm_s", Float.valueOf(str.get("lb_dent2_mm_s").toString()) / 100);
			str.put("lb_dent3_mm_s", Float.valueOf(str.get("lb_dent3_mm_s").toString()) / 100);
		}
		String string = GsonTools.toJson(map);

		return string;
	}

	@Log(code = "ZJ_BZGL_RKFJ_SAVE_ENTNAME", value = "获取动平衡光机")
	@RequestMapping("combox_entcode")
	public String combox_entcode() throws Exception {
		List<Map<String, Object>> list = balandproresultSrv.getEntCodeName();
		return toJson(list);
	}

	@Log(value = "导出EXCEL", code = "ZJ_JCGL_DPHJCLL_EXPORT")
	@RequestMapping("export")
	public void export(String s_factory_s, String machinebar_s, String sap_item_s, String barcode_s,
			String begin_created_time, String end_created_time,String grade_code_s) throws Exception {
//		String report_name="动平衡检测履历（全钢）.csv";// 报表名词
		Filter filter = new Filter();
		filter.set("machinebar_s", machinebar_s).set("sap_item_s", sap_item_s).set("barcode_s", barcode_s)
				.set("s_factory_s", s_factory_s).set("begin_created_time", begin_created_time)
				.set("end_created_time", end_created_time).set("grade_code_s", grade_code_s);

		// 每次查询2000条导入
		int batchQueryCount = 1000;

		Page page = new Page();
		page.setRows(batchQueryCount);
		page.setAll(0);

		int pageNum = 1;

		/*
		 * Workbook wb = new XSSFWorkbook(); // 获取一个工作表 Sheet sheet =
		 * wb.createSheet();
		 * 
		 * Row row=null;
		 */
		response.reset();
		response.setHeader("content-disposition", "attachment;filename="
				+ new String("动平衡检测履历.csv"  .getBytes("GBK"), "ISO-8859-1"));
		String title = "动平衡机台,轮胎条码,物料编码,物料描述,检测时间,成型机台,成型时间,硫化机台,硫化时间,轮胎总等级,动平衡总等级,跳动度总等级,动平衡上量,动平衡上量角度,动平衡上量等级,动平衡下量,动平衡下量角度,动平衡下量等级,动平衡上量+下量,动平衡上量+下量等级,静平衡量,静平衡量角度,静平衡量等级,力偶,力偶角度,力偶等级,上侧侧向跳动值1,上侧侧向跳动角度1,上侧侧向跳动等级1,上侧侧向跳动值2,上侧侧向跳动角度2,上侧侧向跳动等级2,上侧侧向跳动值3,上侧侧向跳动角度3,上侧侧向跳动等级3,下侧侧向跳动值1,下侧侧向跳动角度1,下侧侧向跳动等级1,下侧侧向跳动值2,下侧侧向跳动角度2,下侧侧向跳动等级2,下侧侧向跳动值3,下侧侧向跳动角度3,下侧侧向跳动等级3,上侧径向跳动值,上侧径向跳动角度,上侧径向跳动等级,径向跳动值,径向跳动角度,径向跳动等级,下侧径向跳动值,下侧径向跳动角度,下侧径向跳动等级,上侧侧向跳动一次谐波值1,上侧侧向跳动一次谐波角度1,上侧侧向跳动一次谐波等级1,上侧侧向跳动一次谐波值2,上侧侧向跳动一次谐波角度2,上侧侧向跳动一次谐波等级2,上侧侧向跳动一次谐波值3,上侧侧向跳动一次谐波角度3,上侧侧向跳动一次谐波等级3,下侧侧向跳动一次谐波值1,下侧侧向跳动一次谐波角度1,下侧侧向跳动一次谐波等级1,下侧侧向跳动一次谐波值2,下侧侧向跳动一次谐波角度2,下侧侧向跳动一次谐波等级2,下侧侧向跳动一次谐波值3,下侧侧向跳动一次谐波角度3,下侧侧向跳动一次谐波等级3,上侧径向跳动一次谐波值,上侧径向跳动一次谐波角度,上侧径向跳动一次谐波等级,径向跳动一次谐波值,径向跳动一次谐波角度,径向跳动一次谐波等级,下侧径向跳动一次谐波值,下侧径向跳动一次谐波角度,下侧径向跳动一次谐波等级,上侧侧向跳动N次谐波值1,上侧侧向跳动N次谐波角度1,上侧侧向跳动N次谐波等级1,上侧侧向跳动N次谐波值2,上侧侧向跳动N次谐波角度2,上侧侧向跳动N次谐波等级2,上侧侧向跳动N次谐波值3,上侧侧向跳动N次谐波角度3,上侧侧向跳动N次谐波等级3,下侧侧向跳动N次谐波值1,下侧侧向跳动N次谐波角度1,下侧侧向跳动N次谐波等级1,下侧侧向跳动N次谐波值2,下侧侧向跳动N次谐波角度2,下侧侧向跳动N次谐波等级2,下侧侧向跳动N次谐波值3,下侧侧向跳动N次谐波角度3,下侧侧向跳动N次谐波等级3,上侧径向跳动N次谐波值,上侧径向跳动N次谐波角度,上侧径向跳动N次谐波等级,径向跳动N次谐波值,径向跳动N次谐波角度,径向跳动N次谐波等级,下侧径向跳动N次谐波值,下侧径向跳动N次谐波角度,下侧径向跳动N次谐波等级,上侧侧向凸值1,上侧侧向凸角度1,上侧侧向凸等级1,上侧侧向凸值2,上侧侧向凸角度2,上侧侧向凸等级2,上侧侧向凸值3,上侧侧向凸角度3,上侧侧向凸等级3,下侧侧向凸值1,下侧侧向凸角度1,下侧侧向凸等级1,下侧侧向凸值2,下侧侧向凸角度2,下侧侧向凸等级2,下侧侧向凸值3,下侧侧向凸角度3,下侧侧向凸等级3,上侧侧向凹值1,上侧侧向凹角度1,上侧侧向凹等级1,上侧侧向凹值2,上侧侧向凹角度2,上侧侧向凹等级2,上侧侧向凹值3,上侧侧向凹角度3,上侧侧向凹等级3,下侧侧向凹值1,下侧侧向凹角度1,下侧侧向凹等级1,下侧侧向凹值2,下侧侧向凹角度2,下侧侧向凹等级2,下侧侧向凹值3,下侧侧向凹角度3,下侧侧向凹等级3,创建人";

		StringBuffer sb = new StringBuffer();
		OutputStream writer = response.getOutputStream();
		writer.write((title + System.getProperty("line.separator")).getBytes("GBK"));
		// 缓冲输出到客户端，浏览器将立即开始下载，提高用户体验
		writer.flush();
		ConcurrentHashMap<String, String> grade = new ConcurrentHashMap<String, String>();
		try
		{
//		System.out.println("数据总行数:" +balandproresultSrv.datagridTotalUDA1(filter, page));

		while (true) {
			// 分页查询数据
			long t1 = System.currentTimeMillis();
			System.out.println("正在查询第" + (pageNum++) + "页数据");
			
			List<Map<String, Object>> list = balandproresultSrv.datagridRowsUDA1(filter, page);
			long t2 = System.currentTimeMillis();
			System.out.println("数据查询完成，耗时:" + (t2 - t1) + "ms");
			// filter.set("atr_key", list.get(list.size()-1).getAtr_key());
			page.setPage(page.getPage() + 1);
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Map<String, Object> rs : list) {

				/* if (rs.get("grade_code_s") != null &&grade.get(rs.get("grade_code_s")) == null) {
				     grade.put("grade_code_s",exportServiceImpl.getDictName(rs.get("grade_code_s").toString()));
				 }*/
				 if(rs.get("grade_code_s")!=null){
					 rs.put("grade_code_s", exportServiceImpl.getDictName(rs.get("grade_code_s").toString())); 
				 }
				 if (rs.get("s_factory_s").toString().equals("2")) {
					 rs.put("s_factory_s", "半钢");
				 } else {
					 rs.put("s_factory_s", "全钢");
				 }
				 sb = new StringBuffer();
				 if(rs.containsKey("machinebar_s")){
						if(rs.get("machinebar_s")!=null){
							sb.append(combox_entName(rs.get("machinebar_s").toString())).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("barcode_s")){
						if(rs.get("barcode_s")!=null){
							sb.append(rs.get("barcode_s").toString()).append(",");					
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
							sb.append(rs.get("description").toString()).append(",\t");					
						}else{
							sb.append("").append(",\t");		
						}
					}
					if(rs.containsKey("created_time_t")){
						if(rs.get("created_time_t")!=null){
							sb.append(rs.get("created_time_t").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("buildinmachinecode_s")){
						if(rs.get("buildinmachinecode_s")!=null){
							sb.append(rs.get("buildinmachinecode_s").toString()).append(",\t");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("buildintime_t")){
						if(rs.get("buildintime_t")!=null){
							sb.append(rs.get("buildintime_t").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("curingmachinecode_s")){
						if(rs.get("curingmachinecode_s")!=null){
							sb.append(rs.get("curingmachinecode_s").toString()).append(",\t");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("curingtime_t")){
						if(rs.get("curingtime_t")!=null){
							sb.append(rs.get("curingtime_t").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("grade_code_s")){
						if(rs.get("grade_code_s")!=null){
							sb.append(rs.get("grade_code_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("balance_total_rank_s")){
						if(rs.get("balance_total_rank_s")!=null){
							sb.append(rs.get("balance_total_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ro_total_rank_s")){
						if(rs.get("ro_total_rank_s")!=null){
							sb.append(rs.get("ro_total_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("upper_unbalance_g_s")){
						if(rs.get("upper_unbalance_g_s")!=null){
							sb.append(Float.valueOf(rs.get("upper_unbalance_g_s").toString()) / 10).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("upper_unbalance_deg_s")){
						if(rs.get("upper_unbalance_deg_s")!=null){
							sb.append(rs.get("upper_unbalance_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("upper_unbalance_rank_s")){
						if(rs.get("upper_unbalance_rank_s")!=null){
							sb.append(rs.get("upper_unbalance_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lower_unbalance_g_s")){
						if(rs.get("lower_unbalance_g_s")!=null){
							sb.append(Float.valueOf(rs.get("lower_unbalance_g_s").toString()) / 10).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lower_unbalance_deg_s")){
						if(rs.get("lower_unbalance_deg_s")!=null){
							sb.append(rs.get("lower_unbalance_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lower_unbalance_rank_s")){
						if(rs.get("lower_unbalance_rank_s")!=null){
							sb.append(rs.get("lower_unbalance_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("up_low_unbalance_g_s")){
						if(rs.get("up_low_unbalance_g_s")!=null){
							sb.append(Float.valueOf(rs.get("up_low_unbalance_g_s").toString()) / 10).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("up_low_unbalance_rank_s")){
						if(rs.get("up_low_unbalance_rank_s")!=null){
							sb.append(rs.get("up_low_unbalance_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("static_unbalance_g_s")){
						if(rs.get("static_unbalance_g_s")!=null){
							sb.append(Float.valueOf(rs.get("static_unbalance_g_s").toString()) / 10).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("static_unbalance_deg_s")){
						if(rs.get("static_unbalance_deg_s")!=null){
							sb.append(rs.get("static_unbalance_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("static_unbalance_rank_s")){
						if(rs.get("static_unbalance_rank_s")!=null){
							sb.append(rs.get("static_unbalance_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("couple_unbalance_g_s")){
						if(rs.get("couple_unbalance_g_s")!=null){
							sb.append(Float.valueOf(rs.get("couple_unbalance_g_s").toString()) / 10).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("couple_unbalance_deg_s")){
						if(rs.get("couple_unbalance_deg_s")!=null){
							sb.append(rs.get("couple_unbalance_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("couple_unbalance_rank_s")){
						if(rs.get("couple_unbalance_rank_s")!=null){
							sb.append(rs.get("couple_unbalance_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa_mm_s")){
						if(rs.get("lt_oa_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_oa_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa_deg_s")){
						if(rs.get("lt_oa_deg_s")!=null){
							sb.append(rs.get("lt_oa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa_rank_s")){
						if(rs.get("lt_oa_rank_s")!=null){
							sb.append(rs.get("lt_oa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa2_mm_s")){
						if(rs.get("lt_oa2_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_oa2_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa2_deg_s")){
						if(rs.get("lt_oa2_deg_s")!=null){
							sb.append(rs.get("lt_oa2_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa2_rank_s")){
						if(rs.get("lt_oa2_rank_s")!=null){
							sb.append(rs.get("lt_oa2_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa3_mm_s")){
						if(rs.get("lt_oa3_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_oa3_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa3_deg_s")){
						if(rs.get("lt_oa3_deg_s")!=null){
							sb.append(rs.get("lt_oa3_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa3_rank_s")){
						if(rs.get("lt_oa3_rank_s")!=null){
							sb.append(rs.get("lt_oa3_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lb_oa_mm_s")){
						if(rs.get("lb_oa_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_oa_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa_deg_s")){
						if(rs.get("lb_oa_deg_s")!=null){
							sb.append(rs.get("lb_oa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa_rank_s")){
						if(rs.get("lb_oa_rank_s")!=null){
							sb.append(rs.get("lb_oa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa2_mm_s")){
						if(rs.get("lb_oa2_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_oa2_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa2_deg_s")){
						if(rs.get("lb_oa2_deg_s")!=null){
							sb.append(rs.get("lb_oa2_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa2_rank_s")){
						if(rs.get("lb_oa2_rank_s")!=null){
							sb.append(rs.get("lb_oa2_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa3_mm_s")){
						if(rs.get("lb_oa3_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_oa3_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa3_deg_s")){
						if(rs.get("lt_oa3_deg_s")!=null){
							sb.append(rs.get("lt_oa3_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa3_rank_s")){
						if(rs.get("lt_oa3_rank_s")!=null){
							sb.append(rs.get("lt_oa3_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("rt_oa_mm_s")){
						if(rs.get("rt_oa_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rt_oa_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rt_oa_deg_s")){
						if(rs.get("rt_oa_deg_s")!=null){
							sb.append(rs.get("rt_oa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rt_oa_rank_s")){
						if(rs.get("rt_oa_rank_s")!=null){
							sb.append(rs.get("rt_oa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rc_oa_mm_s")){
						if(rs.get("rc_oa_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rc_oa_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rc_oa_deg_s")){
						if(rs.get("rc_oa_deg_s")!=null){
							sb.append(rs.get("rc_oa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rc_oa_rank_s")){
						if(rs.get("rc_oa_rank_s")!=null){
							sb.append(rs.get("rc_oa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rb_oa_mm_s")){
						if(rs.get("rb_oa_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rb_oa_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rb_oa_deg_s")){
						if(rs.get("rb_oa_deg_s")!=null){
							sb.append(rs.get("rb_oa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rb_oa_rank_s")){
						if(rs.get("rb_oa_rank_s")!=null){
							sb.append(rs.get("rb_oa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lt_oa_1h_mm_s")){
						if(rs.get("lt_oa_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_oa_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa_1h_deg_s")){
						if(rs.get("lt_oa_1h_deg_s")!=null){
							sb.append(rs.get("lt_oa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa_1h_rank_s")){
						if(rs.get("lt_oa_1h_rank_s")!=null){
							sb.append(rs.get("lt_oa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa2_1h_mm_s")){
						if(rs.get("lt_oa2_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_oa2_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa2_1h_deg_s")){
						if(rs.get("lt_oa2_1h_deg_s")!=null){
							sb.append(rs.get("lt_oa2_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa2_1h_rank_s")){
						if(rs.get("lt_oa2_1h_rank_s")!=null){
							sb.append(rs.get("lt_oa2_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa3_1h_mm_s")){
						if(rs.get("lt_oa3_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_oa3_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa3_1h_deg_s")){
						if(rs.get("lt_oa3_1h_deg_s")!=null){
							sb.append(rs.get("lt_oa3_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_oa3_1h_rank_s")){
						if(rs.get("lt_oa3_1h_rank_s")!=null){
							sb.append(rs.get("lt_oa3_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lb_oa_1h_mm_s")){
						if(rs.get("lb_oa_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_oa_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa_1h_deg_s")){
						if(rs.get("lb_oa_1h_deg_s")!=null){
							sb.append(rs.get("lb_oa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa_1h_rank_s")){
						if(rs.get("lb_oa_1h_rank_s")!=null){
							sb.append(rs.get("lb_oa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa2_1h_mm_s")){
						if(rs.get("lb_oa2_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_oa2_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa2_1h_deg_s")){
						if(rs.get("lb_oa2_1h_deg_s")!=null){
							sb.append(rs.get("lb_oa2_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa2_1h_rank_s")){
						if(rs.get("lb_oa2_1h_rank_s")!=null){
							sb.append(rs.get("lb_oa2_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa3_1h_mm_s")){
						if(rs.get("lb_oa3_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_oa3_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa3_1h_deg_s")){
						if(rs.get("lb_oa3_1h_deg_s")!=null){
							sb.append(rs.get("lb_oa3_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_oa3_1h_rank_s")){
						if(rs.get("lb_oa3_1h_rank_s")!=null){
							sb.append(rs.get("lb_oa3_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("rt_oa_1h_mm_s")){
						if(rs.get("rt_oa_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rt_oa_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rt_oa_1h_deg_s")){
						if(rs.get("rt_oa_1h_deg_s")!=null){
							sb.append(rs.get("rt_oa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rt_oa_1h_rank_s")){
						if(rs.get("rt_oa_1h_rank_s")!=null){
							sb.append(rs.get("rt_oa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rc_oa_1h_mm_s")){
						if(rs.get("rc_oa_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rc_oa_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rc_oa_1h_deg_s")){
						if(rs.get("rc_oa_1h_deg_s")!=null){
							sb.append(rs.get("rc_oa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rc_oa_1h_rank_s")){
						if(rs.get("rc_oa_1h_rank_s")!=null){
							sb.append(rs.get("rc_oa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rb_oa_1h_mm_s")){
						if(rs.get("rb_oa_1h_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rb_oa_1h_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rb_oa_1h_deg_s")){
						if(rs.get("rb_oa_1h_deg_s")!=null){
							sb.append(rs.get("rb_oa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rb_oa_1h_rank_s")){
						if(rs.get("rb_oa_1h_rank_s")!=null){
							sb.append(rs.get("rb_oa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lro_t1_nth_mm_s")){
						if(rs.get("lro_t1_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lro_t1_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_t1_nth_deg_s")){
						if(rs.get("lro_t1_nth_deg_s")!=null){
							sb.append(rs.get("lro_t1_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_t1_nth_rank_s")){
						if(rs.get("lro_t1_nth_rank_s")!=null){
							sb.append(rs.get("lro_t1_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_t2_nth_mm_s")){
						if(rs.get("lro_t2_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lro_t2_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_t2_nth_deg_s")){
						if(rs.get("lro_t2_nth_deg_s")!=null){
							sb.append(rs.get("lro_t2_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_t2_nth_rank_s")){
						if(rs.get("lro_t2_nth_rank_s")!=null){
							sb.append(rs.get("lro_t2_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_t3_nth_mm_s")){
						if(rs.get("lro_t3_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lro_t3_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_t3_nth_deg_s")){
						if(rs.get("lro_t3_nth_deg_s")!=null){
							sb.append(rs.get("lro_t3_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_t3_nth_rank_s")){
						if(rs.get("lro_t3_nth_rank_s")!=null){
							sb.append(rs.get("lro_t3_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lro_b1_nth_mm_s")){
						if(rs.get("lro_b1_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lro_b1_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_b1_nth_deg_s")){
						if(rs.get("lro_b1_nth_deg_s")!=null){
							sb.append(rs.get("lro_b1_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_b1_nth_rank_s")){
						if(rs.get("lro_b1_nth_rank_s")!=null){
							sb.append(rs.get("lro_b1_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_b2_nth_mm_s")){
						if(rs.get("lro_b2_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lro_b2_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_b2_nth_deg_s")){
						if(rs.get("lro_b2_nth_deg_s")!=null){
							sb.append(rs.get("lro_b2_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_b2_nth_rank_s")){
						if(rs.get("lro_b2_nth_rank_s")!=null){
							sb.append(rs.get("lro_b2_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_b3_nth_mm_s")){
						if(rs.get("lro_b3_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lro_b3_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_b3_nth_deg_s")){
						if(rs.get("lro_b3_nth_deg_s")!=null){
							sb.append(rs.get("lro_b3_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lro_b3_nth_rank_s")){
						if(rs.get("lro_b3_nth_rank_s")!=null){
							sb.append(rs.get("lro_b3_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("rro_t_nth_mm_s")){
						if(rs.get("rro_t_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rro_t_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rro_t_nth_deg_s")){
						if(rs.get("rro_t_nth_deg_s")!=null){
							sb.append(rs.get("rro_t_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rro_t_nth_rank_s")){
						if(rs.get("rro_t_nth_rank_s")!=null){
							sb.append(rs.get("rro_t_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rro_c_nth_mm_s")){
						if(rs.get("rro_c_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rro_c_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rro_c_nth_deg_s")){
						if(rs.get("rro_c_nth_deg_s")!=null){
							sb.append(rs.get("rro_c_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rro_c_nth_rank_s")){
						if(rs.get("rro_c_nth_rank_s")!=null){
							sb.append(rs.get("rro_c_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rro_b_nth_mm_s")){
						if(rs.get("rro_b_nth_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("rro_b_nth_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rro_b_nth_deg_s")){
						if(rs.get("rro_b_nth_deg_s")!=null){
							sb.append(rs.get("rro_b_nth_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rro_b_nth_rank_s")){
						if(rs.get("rro_b_nth_rank_s")!=null){
							sb.append(rs.get("rro_b_nth_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lt_bulging_mm_s")){
						if(rs.get("lt_bulging_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_bulging_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging_deg_s")){
						if(rs.get("lt_bulging_deg_s")!=null){
							sb.append(rs.get("lt_bulging_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging_rank_s")){
						if(rs.get("lt_bulging_rank_s")!=null){
							sb.append(rs.get("lt_bulging_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging2_mm_s")){
						if(rs.get("lt_bulging2_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_bulging2_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging2_deg_s")){
						if(rs.get("lt_bulging2_deg_s")!=null){
							sb.append(rs.get("lt_bulging2_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging2_rank_s")){
						if(rs.get("lt_bulging2_rank_s")!=null){
							sb.append(rs.get("lt_bulging2_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging3_mm_s")){
						if(rs.get("lt_bulging3_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_bulging3_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging3_deg_s")){
						if(rs.get("lt_bulging3_deg_s")!=null){
							sb.append(rs.get("lt_bulging3_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging3_rank_s")){
						if(rs.get("lt_bulging3_rank_s")!=null){
							sb.append(rs.get("lt_bulging3_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lb_bulging_mm_s")){
						if(rs.get("lb_bulging_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_bulging_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_bulging_deg_s")){
						if(rs.get("lb_bulging_deg_s")!=null){
							sb.append(rs.get("lb_bulging_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_bulging_rank_s")){
						if(rs.get("lb_bulging_rank_s")!=null){
							sb.append(rs.get("lb_bulging_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_bulging2_mm_s")){
						if(rs.get("lb_bulging2_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_bulging2_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_bulging2_deg_s")){
						if(rs.get("lb_bulging2_deg_s")!=null){
							sb.append(rs.get("lb_bulging2_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_bulging2_rank_s")){
						if(rs.get("lb_bulging2_rank_s")!=null){
							sb.append(rs.get("lb_bulging2_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_bulging3_mm_s")){
						if(rs.get("lb_bulging3_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_bulging3_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_bulging3_deg_s")){
						if(rs.get("lb_bulging3_deg_s")!=null){
							sb.append(rs.get("lb_bulging3_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_bulging3_rank_s")){
						if(rs.get("lb_bulging3_rank_s")!=null){
							sb.append(rs.get("lb_bulging3_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lt_dent_mm_s")){
						if(rs.get("lt_dent_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_dent_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_dent_deg_s")){
						if(rs.get("lt_dent_deg_s")!=null){
							sb.append(rs.get("lt_dent_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_dent_rank_s")){
						if(rs.get("lt_dent_rank_s")!=null){
							sb.append(rs.get("lt_dent_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_dent2_mm_s")){
						if(rs.get("lt_dent2_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_dent2_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_dent2_deg_s")){
						if(rs.get("lt_dent2_deg_s")!=null){
							sb.append(rs.get("lt_dent2_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_dent2_rank_s")){
						if(rs.get("lt_dent2_rank_s")!=null){
							sb.append(rs.get("lt_dent2_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_dent3_mm_s")){
						if(rs.get("lt_dent3_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lt_dent3_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_dent3_deg_s")){
						if(rs.get("lt_dent3_deg_s")!=null){
							sb.append(rs.get("lt_dent3_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_dent3_rank_s")){
						if(rs.get("lt_dent3_rank_s")!=null){
							sb.append(rs.get("lt_dent3_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("lb_dent_mm_s")){
						if(rs.get("lb_dent_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_dent_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_dent_deg_s")){
						if(rs.get("lb_dent_deg_s")!=null){
							sb.append(rs.get("lb_dent_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_dent_rank_s")){
						if(rs.get("lb_dent_rank_s")!=null){
							sb.append(rs.get("lb_dent_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_dent2_mm_s")){
						if(rs.get("lb_dent2_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_dent2_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_dent2_deg_s")){
						if(rs.get("lb_dent2_deg_s")!=null){
							sb.append(rs.get("lb_dent2_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_dent2_rank_s")){
						if(rs.get("lb_dent2_rank_s")!=null){
							sb.append(rs.get("lb_dent2_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_dent3_mm_s")){
						if(rs.get("lb_dent3_mm_s")!=null){
							sb.append(Float.valueOf(rs.get("lb_dent3_mm_s").toString()) / 100).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_dent3_deg_s")){
						if(rs.get("lb_dent3_deg_s")!=null){
							sb.append(rs.get("lb_dent3_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lb_dent3_rank_s")){
						if(rs.get("lb_dent3_rank_s")!=null){
							sb.append(rs.get("lb_dent3_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					
					if(rs.containsKey("created_by")){
						if(rs.get("created_by")!=null){
							sb.append(rs.get("created_by").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
				writer.write((sb.toString().replace("\n", " ").replace("\r", " ").replace("null", "") + System
						.getProperty("line.separator")).getBytes("GBK"));
				writer.flush();
			}
//			if (list.size() < batchQueryCount) {
//				break;
//			}
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

//	void writeRow(Row row, Object... values) {
//		int i = 0;
//		for (Object v : values) {
//			if (v == null) {
//				v = "";
//			}
//			row.createCell(i++).setCellValue(v + "");
//		}
//	}
//   
	
	@Log(code = "ZJ_BZGL_RKFJ_SAVE_ENTNAME", value = "获取动平衡机")
	@RequestMapping("combox_entName")
	public String combox_entName(String entCode) throws Exception {
		String result = balandproresultSrv.getEndNameByEntCode(entCode);
		return result;
	}
}
