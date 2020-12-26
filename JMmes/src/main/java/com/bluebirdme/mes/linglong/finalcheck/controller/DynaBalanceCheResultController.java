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

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynaBalanceCheResult;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.DynaBalanceCheResultDTO;
import com.bluebirdme.mes.linglong.finalcheck.service.DynaBalanceCheResultServiceImpl;

/**
 * 动平衡检查履历表
 * 
 * @author 时永良
 * @Date 2018-08-10 07:25:02
 */
@Log(code = "ZJ_ZJGL_DPHJCLL", value = "动平衡检查履历日志")
@RestController
@RequestMapping("finalcheck/qualitylnspectionRecord/dynaBalanceCheResult")
public class DynaBalanceCheResultController extends RockWellFunctionalUDAController<Object> {

	@Resource
	DynaBalanceCheResultServiceImpl dynabalancecheresultSrv;
	public ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils
			.firstCharToLowerCase("exportServiceImpl"));

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return dynabalancecheresultSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return dynabalancecheresultSrv;
	}
	
	@Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		if(filter.getFilter().containsKey("barcode_s")){
			filter.set("begin_created_time","");
			filter.set("end_created_time","");
		}
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}

	@Log(code = "ZJ_BZGL_RKFJ_SAVE_ENTNAME", value = "获取动平衡光机")
	@RequestMapping("combox_entcode")
	public String combox_entcode() throws Exception {
		List<Map<String, Object>> list = dynabalancecheresultSrv.getEntCodeName();
		return toJson(list);
	}
	

	/*@Log(value = "导出EXCEL", code = "ZJ_JCGL_DPHJCLL_EXPORT")
	@RequestMapping("export")
	public void export(String s_factory_s,String machinebar_s,String curingspeccode_s,String barcode_s,String begin_created_time,String end_created_time) throws Exception{
		Filter filter=new Filter();
    	filter.setSort("t.atr_key");
    	filter.setOrder("asc");
    	if(!StringUtils.isEmpty(barcode_s)){
    		filter.set("machinebar_s", machinebar_s)
	    	.set("curingspeccode_s", curingspeccode_s)
	    	.set("barcode_s", barcode_s)
	    	.set("s_factory_s", s_factory_s)
	    	.set("begin_created_time", "")
	    	.set("end_created_time", "");
    	}else{
	    	filter.set("machinebar_s", machinebar_s)
			    	.set("curingspeccode_s", curingspeccode_s)
			    	.set("barcode_s", barcode_s)
			    	.set("s_factory_s", s_factory_s)
			    	.set("begin_created_time", begin_created_time)
			    	.set("end_created_time", end_created_time);
    	}
    	System.out.println(filter);
		// 每次查询2000条导入
		int batchQueryCount = 100;

		Page page = new Page();
		page.setRows(batchQueryCount);
		page.setAll(0);

		int pageNum = 1;
		int rowNum = 0;

		SXSSFWorkbook wb = new SXSSFWorkbook();
		// 获取一个工作表
		SXSSFSheet sheet = wb.createSheet();

		SXSSFRow row = null;

		row = sheet.createRow(rowNum++);
		writeRow(row, new Object[] { "动平衡机台", "轮胎条码", "物料编码", "物料描述", "检测时间", "轮胎总等级", "动平衡总等级", "跳动度总等级", "均匀性总等级",
				"径向力波动值", "径向力波动角度", "径向力波动等级 ", "径向力波动一次谐波值", "径向力波动一次谐角度", "径向力波动一次谐波等级", "径向力波动二次谐波值",
				"径向力波动二次谐波角度", "径向力波动二次谐波等级", "径向力波动三次谐波值", "径向力波动三次谐波角度", "径向力波动三次谐波等级", "径向力波动四次谐波值", "径向力波动四次谐波角度",
				"径向力波动四次谐波等级", "径向力波动五次谐波值", "径向力波动五次谐波角度", "径向力波动五次谐波等级", "径向力波动六次谐波值", "径向力波动六次谐波角度", "径向力波动六次谐波等级",
				"径向力波动七次谐波值", "径向力波动七次谐波角度", "径向力波动七次谐波等级", "径向力波动八次谐波值", "径向力波动八次谐波角度", "径向力波动八次谐波等级", "径向力波动九次谐波值",
				"径向力波动九次谐波角度", "径向力波动九次谐波等级", "径向力波动十次谐波值", "径向力波动十次谐波角度", "径向力波动十次谐波等级", "侧向力波动值 ", "侧向力波动角度",
				"侧向力波动等级", "侧向力波动一次谐波值", "侧向力波动一次谐角度", "侧向力波动一次谐波等级", "侧向力波动二次谐波值", "侧向力波动二次谐波角度", "侧向力波动二次谐波角等级",
				"侧向力波动三次谐波值", "侧向力波动三次谐波角度", "侧向力波动三次谐波等级", "侧向力波动四次谐波值 ", "侧向力波动四次谐波角度", "侧向力波动四次谐波等级", "侧向力波动五次谐波值",
				"侧向力波动五次谐波角度", "侧向力波动五次谐波等级", "侧向力波动六次谐波值", "侧向力波动六次谐波角度", "侧向力波动六次谐波等级", "侧向力波动七次谐波值", "侧向力波动七次谐波角度",
				"侧向力波动七次谐波等级", "侧向力波动八次谐波值", "侧向力波动八次谐波角度", "侧向力波动八次谐波等级", "侧向力波动九次谐波值", "侧向力波动九次谐波角度", "侧向力波动九次谐波等级",
				"侧向力波动十次谐波值", "侧向力波动十次谐波角度 ", "侧向力波动十次谐波等级", "正转侧向力偏移值", "正转侧向力偏移等级", "反转径向力波动值", "反转径向力波动角度",
				"反转径向力波动角等级", "反转径向力波动一次谐波值", "反转径向力波动一次谐波角度", "反转径向力波动一次谐波等级", "反转径向力波动二次谐波值", "反转径向力波动二次谐波角度",
				"反转径向力波动二次谐波等级", "反转径向力波动三次谐波值 ", "反转径向力波动三次谐波角度 ", "反转径向力波动三次谐波等级", "反转径向力波动四次谐波值", "反转径向力波动四次谐波角度",
				"反转径向力波动四次谐波等级 ", "反转径向力波动五次谐波值", "反转径向力波动五次谐波角度", "反转径向力波动五次谐波等级 ", "反转径向力波动六次谐波值", "反转径向力波动六次谐波角度",
				"反转径向力波动六次谐波等级", "反转径向力波动七次谐波值", "反转径向力波动七次谐波角度", "反转径向力波动七次谐波等级 ", "反转径向力波动八次谐波值 ", "反转径向力波动八次谐波角度",
				"反转径向力波动八次谐波等级", "反转径向力波动九次谐波值", "反转径向力波动九次谐波角度 ", "反转径向力波动九次谐波等级 ", "反转径向力波动十次谐波值", "反转径向力波动十次谐波角度",
				"反转径向力波动十次谐波等级 ", "反转侧向力波动值", "反转侧向力波动角度", "反转侧向力波动等级 ", "反转侧向力波动一次谐波值", "反转侧向力波动一次谐波角度",
				"反转侧向力波动一次谐波等级", "反转侧向力波动二次谐波值 ", "反转侧向力波动二次谐波角度", "反转侧向力波动二次谐波等级", "反转侧向力波动三次谐波值", "反转侧向力波动三次谐波角度",
				"反转侧向力波动三次谐波等级", "反转侧向力波动四次谐波值", "反转侧向力波动四次谐波角度", "反转侧向力波动四次谐波等级", "反转侧向力波动五次谐波值", "反转侧向力波动五次谐波角度",
				"反转侧向力波动五次谐波等级", "反转侧向力波动六次谐波值 ", "反转侧向力波动六次谐波角度", "反转侧向力波动六次谐波等级", "反转侧向力波动七次谐波值", "反转侧向力波动七次谐波角度",
				"反转侧向力波动七次谐波等级 ", "反转侧向力波动八次谐波值", "反转侧向力波动八次谐波角度", "反转侧向力波动八次谐波等级", "反转侧向力波动九次谐波值", "反转侧向力波动九次谐波角度 ",
				"反转侧向力波动九次谐波等级 ", "反转侧向力波动十次谐波值", "反转侧向力波动十次谐波角度", "反转侧向力波动十次谐波等级", "反转侧向力偏移值", "反转侧向力偏移等级", " 锥度值 ",
				"锥度等级", "帘布效应", "帘布效应等级", "上部侧向跳动值", "上部侧向跳动角度", "上部侧向跳动等级", "上部侧向跳动一次谐波值", "上部侧向跳动一次谐波角度",
				"上部侧向跳动一次谐波等级", "下部侧向跳动值", "下部侧向跳动角度 ", "下部侧向跳动等级", "下部侧向跳动一次谐波值", "下部侧向跳动一次谐波角度", "下部侧向跳动一次谐波等级",
				"上部径向跳动值", "上部径向跳动角度", "上部径向跳动等级", "上部径向跳动一次谐波值", "上部径向跳动一次谐波角度", "上部径向跳动一次谐波等级", "中部径向跳动值",
				"中部径向跳动角度", "中部径向跳动等级", "中部径向跳动一次谐波值", "中部径向跳动一次谐波角度", "中部径向跳动一次谐波等级 ", "下部径向跳动值", "下部径向跳动角度",
				"下部径向跳动等级", "下部径向跳动一次谐波值", "下部径向跳动一次谐波角度", "下部径向跳动一次谐波等级", "上部侧向凸值 ", "上部侧向凸角度", "上部侧向凸等级", "上部侧向凹值",
				"上部侧向凹角度 ", "上部侧向凹等级", "下部侧向凸值", "下部侧向凸角度", "下部侧向凸等级 ", "下部侧向凹值", "下部侧向凹角度 ", "下部侧向凹等级", "轮胎外直径",
				"轮胎外直径等级", "上面不平衡量 ", "上面不平衡量角度", "上面不平衡量等级", "下面不平衡量 ", "下面不平衡量角度", "下面不平衡量等级", "静合成不平衡量",
				"静合成不平衡量角度 ", "静合成不平衡量等级 ", "偶不平衡量", "偶不平衡量角度", "偶不平衡量等级", "上面+下面不平衡量", "上面+下面不平衡量等级", "轮胎重量",
				"轮胎重量等级", "荷重", "MODELNO", "测试模式", "修改人", "修改时间", "创建人", "创建时间" });
		System.out.println(getService().datagridTotal(filter,page));
		while (true) {
			// 分页查询数据
			long t1=System.currentTimeMillis();
			System.out.println("正在查询第" + (pageNum++) + "页数据");
			page.setPage(1);
			List<DynaBalanceCheResultAll> list = getService().datagridRows(filter, page, DynaBalanceCheResultAll.class);
			filter.set("atr_key", list.get(list.size()-1).getAtr_key());
			long t2=System.currentTimeMillis();
			System.out.println("数据查询完成，耗时:"+(t2-t1)+"ms");
			for (DynaBalanceCheResultAll rs : list) {
				System.out.println("正在写入Excel：" + rowNum + "条数据");
				long tt1=System.currentTimeMillis();
				row = sheet.createRow(rowNum++);
				long tt2=System.currentTimeMillis();
				System.out.println("创建"+rowNum+"行:"+(tt2-tt1)+"ms");
				rs.setTire_total_ratings_s(exportServiceImpl.getDictName(rs.getTire_total_ratings_s()));
				if (rs.getS_factory_s().equals("2")) {
					rs.setS_factory_s("半钢");
				} else {
					rs.setS_factory_s("全钢");
				}
				writeRow(
						row,
						new Object[] { rs.getMachinebar_s(), rs.getBarcode_s(), rs.getCuringspeccode_s(),
								rs.getMaterialdesc_s(), rs.getOutputtime_t(), rs.getTire_total_ratings_s(),
								rs.getBalancetotal_rank_s(), rs.getRototal_rank_s(), rs.getUfm_totalrank_s(),
								rs.getCw_rfvoa_kgf_s(), rs.getCw_rfvoa_deg_s(), rs.getCw_rfvoa_rank_s(),
								rs.getCw_rfvoa_1h_kgf_s(), rs.getCw_rfvoa_1h_deg_s(), rs.getCw_rfvoa_1h_rank_s(),
								rs.getCw_rfvoa_2h_kgf_s(), rs.getCw_rfvoa_2h_deg_s(), rs.getCw_rfvoa_2h_rank_s(),
								rs.getCw_rfvoa_3h_kgf_s(), rs.getCw_rfvoa_3h_deg_s(), rs.getCw_rfvoa_3h_rank_s(),
								rs.getCw_rfvoa_4h_kgf_s(), rs.getCw_rfvoa_4h_deg_s(), rs.getCw_rfvoa_4h_rank_s(),
								rs.getCw_rfvoa_5h_kgf_s(), rs.getCw_rfvoa_5h_deg_s(), rs.getCw_rfvoa_5h_rank_s(),
								rs.getCw_rfvoa_6h_kgf_s(), rs.getCw_rfvoa_6h_deg_s(), rs.getCw_rfvoa_6h_rank_s(),
								rs.getCw_rfvoa_7h_kgf_s(), rs.getCw_rfvoa_7h_deg_s(), rs.getCw_rfvoa_7h_rank_s(),
								rs.getCw_rfvoa_8h_kgf_s(), rs.getCw_rfvoa_8h_deg_s(), rs.getCw_rfvoa_8h_rank_s(),
								rs.getCw_rfvoa_9h_kgf_s(), rs.getCw_rfvoa_9h_deg_s(), rs.getCw_rfvoa_9h_rank_s(),
								rs.getCw_rfvoa_10h_kgf_s(), rs.getCw_rfvoa_10h_deg_s(), rs.getCw_rfvoa_10h_rank_s(),
								rs.getCw_lfvoa_kgf_s(), rs.getCw_lfvoa_deg_s(), rs.getCw_lfvoa_rank_s(),
								rs.getCw_lfvoa_1h_kgf_s(), rs.getCw_lfvoa_1h_deg_s(), rs.getCw_lfvoa_1h_rank_s(),
								rs.getCw_lfvoa_2h_kgf_s(), rs.getCw_lfvoa_2h_deg_s(), rs.getCw_lfvoa_2h_rank_s(),
								rs.getCw_lfvoa_3h_kgf_s(), rs.getCw_lfvoa_3h_deg_s(), rs.getCw_lfvoa_3h_rank_s(),
								rs.getCw_lfvoa_4h_kgf_s(), rs.getCw_lfvoa_4h_deg_s(), rs.getCw_lfvoa_4h_rank_s(),
								rs.getCw_lfvoa_5h_kgf_s(), rs.getCw_lfvoa_5h_deg_s(), rs.getCw_lfvoa_5h_rank_s(),
								rs.getCw_lfvoa_6h_kgf_s(), rs.getCw_lfvoa_6h_deg_s(), rs.getCw_lfvoa_6h_rank_s(),
								rs.getCw_lfvoa_7h_kgf_s(), rs.getCw_lfvoa_7h_deg_s(), rs.getCw_lfvoa_7h_rank_s(),
								rs.getCw_lfvoa_8h_kgf_s(), rs.getCw_lfvoa_8h_deg_s(), rs.getCw_lfvoa_8h_rank_s(),
								rs.getCw_lfvoa_9h_kgf_s(), rs.getCw_lfvoa_9h_deg_s(), rs.getCw_lfvoa_9h_rank_s(),
								rs.getCw_lfvoa_10h_kgf_s(), rs.getCw_lfvoa_10h_deg_s(), rs.getCw_lfvoa_10h_rank_s(),
								rs.getCw_lfd_kgf_s(), rs.getCw_lfd_rank_s(), rs.getCcw_rfvoa_kgf_s(),
								rs.getCcw_rfvoa_deg_s(), rs.getCcw_rfvoa_rank_s(), rs.getCcw_rfvoa_1h_kgf_s(),
								rs.getCcw_rfvoa_1h_deg_s(), rs.getCcw_rfvoa_1h_rank_s(), rs.getCcw_rfvoa_2h_kgf_s(),
								rs.getCcw_rfvoa_2h_deg_s(), rs.getCcw_rfvoa_2h_rank_s(), rs.getCcw_rfvoa_3h_kgf_s(),
								rs.getCcw_rfvoa_3h_deg_s(), rs.getCcw_rfvoa_3h_rank_s(), rs.getCcw_rfvoa_4h_kgf_s(),
								rs.getCcw_rfvoa_4h_deg_s(), rs.getCcw_rfvoa_4h_rank_s(), rs.getCcw_rfvoa_5h_kgf_s(),
								rs.getCcw_rfvoa_5h_deg_s(), rs.getCcw_rfvoa_5h_rank_s(), rs.getCcw_rfvoa_6h_kgf_s(),
								rs.getCcw_rfvoa_6h_deg_s(), rs.getCcw_rfvoa_6h_rank_s(), rs.getCcw_rfvoa_7h_kgf_s(),
								rs.getCcw_rfvoa_7h_deg_s(), rs.getCcw_rfvoa_7h_rank_s(), rs.getCcw_rfvoa_8h_kgf_s(),
								rs.getCcw_rfvoa_8h_deg_s(), rs.getCcw_rfvoa_8h_rank_s(), rs.getCcw_rfvoa_9h_kgf_s(),
								rs.getCcw_rfvoa_9h_deg_s(), rs.getCcw_rfvoa_9h_rank_s(), rs.getCcw_rfvoa_10h_kgf_s(),
								rs.getCcw_rfvoa_10h_deg_s(), rs.getCcw_rfvoa_10h_rank_s(), rs.getCcw_lfvoa_kgf_s(),
								rs.getCcw_lfvoa_deg_s(), rs.getCcw_lfvoa_rank_s(), rs.getCcw_lfvoa_1h_kgf_s(),
								rs.getCcw_lfvoa_1h_deg_s(), rs.getCcw_lfvoa_1h_rank_s(), rs.getCcw_lfvoa_2h_kgf_s(),
								rs.getCcw_lfvoa_2h_deg_s(), rs.getCcw_lfvoa_2h_rank_s(), rs.getCcw_lfvoa_3h_kgf_s(),
								rs.getCcw_lfvoa_3h_deg_s(), rs.getCcw_lfvoa_3h_rank_s(), rs.getCcw_lfvoa_4h_kgf_s(),
								rs.getCcw_lfvoa_4h_deg_s(), rs.getCcw_lfvoa_4h_rank_s(), rs.getCcw_lfvoa_5h_kgf_s(),
								rs.getCcw_lfvoa_5h_deg_s(), rs.getCcw_lfvoa_5h_rank_s(), rs.getCcw_lfvoa_6h_kgf_s(),
								rs.getCcw_lfvoa_6h_deg_s(), rs.getCcw_lfvoa_6h_rank_s(), rs.getCcw_lfvoa_7h_kgf_s(),
								rs.getCcw_lfvoa_7h_deg_s(), rs.getCcw_lfvoa_7h_rank_s(), rs.getCcw_lfvoa_8h_kgf_s(),
								rs.getCcw_lfvoa_8h_deg_s(), rs.getCcw_lfvoa_8h_rank_s(), rs.getCcw_lfvoa_9h_kgf_s(),
								rs.getCcw_lfvoa_9h_deg_s(), rs.getCcw_lfvoa_9h_rank_s(), rs.getCcw_lfvoa_10h_kgf_s(),
								rs.getCcw_lfvoa_10h_deg_s(), rs.getCcw_lfvoa_10h_rank_s(), rs.getCcw_lfd_kgf_s(),
								rs.getCcw_lfd_rank_s(), rs.getCon_kgf_s(), rs.getCon_rank_s(), rs.getPly_kgf_s(),
								rs.getPly_rank_s(), rs.getLtoa_mm_s(), rs.getLtoa_deg_s(), rs.getLtoa_rank_s(),
								rs.getLtoa_1h_mm_s(), rs.getLtoa_1h_deg_s(), rs.getLtoa_1h_rank_s(), rs.getLboa_mm_s(),
								rs.getLboa_deg_s(), rs.getLboa_rank_s(), rs.getLboa_1h_mm_s(), rs.getLboa_1h_deg_s(),
								rs.getLboa_1h_rank_s(), rs.getRtoa_mm_s(), rs.getRtoa_deg_s(), rs.getRtoa_rank_s(),
								rs.getRtoa_1h_mm_s(), rs.getRtoa_1h_deg_s(), rs.getRtoa_1h_rank_s(), rs.getRcoa_mm_s(),
								rs.getRcoa_deg_s(), rs.getRcoa_rank_s(), rs.getRcoa_1h_mm_s(), rs.getRcoa_1h_deg_s(),
								rs.getRcoa_1h_rank_s(), rs.getRboa_mm_s(), rs.getRboa_deg_s(), rs.getRboa_rank_s(),
								rs.getRboa_1h_mm_s(), rs.getRboa_1h_deg_s(), rs.getRboa_1h_rank_s(),
								rs.getLt_bulging_mm_s(), rs.getLt_bulging_deg_s(), rs.getLt_bulging_rank_s(),
								rs.getLt_dent_mm_s(), rs.getLt_dent_deg_s(), rs.getLt_dent_rank_s(),
								rs.getLb_bulging_mm_s(), rs.getLb_bulging_deg_s(), rs.getLb_bulging_rank_s(),
								rs.getLb_dent_mm_s(), rs.getLb_dent_deg_s(), rs.getLb_dent_rank_s(),
								rs.getOutsidediameter_mm_s(), rs.getOutsidediameter_rank_s(),
								rs.getUpper_unbalance_g_s(), rs.getUpper_unbalance_deg_s(),
								rs.getUpper_unbalance_rank_s(), rs.getLower_unbalance_g_s(),
								rs.getLower_unbalance_deg_s(), rs.getLower_unbalance_rank_s(),
								rs.getStatic_unbalance_g_s(), rs.getStatic_unbalance_deg_s(),
								rs.getStatic_unbalance_rank_s(), rs.getCouple_unbalance_g_s(),
								rs.getCouple_unbalance_deg_s(),
								rs.getCouple_unbalance_rank_s(),
								rs.getUplow_unbalance_g_s(),
								// rs.getUplow_unbalance_deg_s(),
								rs.getUplow_unbalance_rank_s(), rs.getWeight_s(), rs.getWeight_rank_s(),
								rs.getLoad_s(), rs.getModelno_s(), rs.getTestmode_s(), rs.getChanged_by_s(),
								rs.getChanged_time_t(), rs.getCreated_by_s(), rs.getCreated_time_t() });
				long tt3=System.currentTimeMillis();
				System.out.println("写入"+rowNum+"行:"+(tt3-tt2)+"ms");
			}
			long t3=System.currentTimeMillis();
			System.out.println(list.size()+"条数据已写入,耗时："+(t3-t2)+"ms");
			if (list.size() < batchQueryCount) {
				break;
			}
		}
		response.reset();
		response.setHeader("content-disposition", "attachment;filename="
				+ new String("动平衡检测履历.xlsx".getBytes("GBK"), "ISO-8859-1"));
		OutputStream os = response.getOutputStream();
		wb.write(os);
		wb.close();
		wb.dispose();

		os.close();
	}*/
	
	/*@NoLogin
	@Log(value = "导出CSV", code = "ZJ_JCGL_DPHJCLL_EXPORT_CSV")
	@RequestMapping("exportCSV")
	public void exportCSV(String s_factory_s,String machinebar_s,String curingspeccode_s,String barcode_s,String begin_created_time,String end_created_time) throws Exception{
    	Filter filter=new Filter();
//    	filter.setSort("t.atr_key");
//    	filter.setOrder("asc");
    	if(!StringUtils.isEmpty(barcode_s)){
    		filter.set("machinebar_s", machinebar_s)
	    	.set("curingspeccode_s", curingspeccode_s)
	    	.set("barcode_s", barcode_s)
	    	.set("s_factory_s", s_factory_s)
	    	.set("begin_created_time", "")
	    	.set("end_created_time", "");
    	}else{
	    	filter.set("machinebar_s", machinebar_s)
			    	.set("curingspeccode_s", curingspeccode_s)
			    	.set("barcode_s", barcode_s)
			    	.set("s_factory_s", s_factory_s)
			    	.set("begin_created_time", begin_created_time)
			    	.set("end_created_time", end_created_time);
    	}
    	System.out.println(filter);
		// 每次查询2000条导入
		int batchQueryCount = 1000;

		Page page = new Page();
		page.setRows(batchQueryCount);
		page.setAll(0);

		int pageNum = 1;
		
		response.reset();
		
		response.setHeader("content-disposition", "attachment;filename="
				+ new String("动平衡检测履历.csv".getBytes("GBK"), "ISO-8859-1"));
		
		String title="动平衡机台,轮胎条码,物料编码,物料描述,检测时间,成型机台,成型时间,硫化机台,硫化时间,轮胎总等级,动平衡总等级,跳动度总等级,均匀性总等级,荷重,径向力波动值,径向力波动角度,径向力波动等级 ,径向力波动一次谐波值,径向力波动一次谐角度,径向力波动一次谐波等级,径向力波动二次谐波值,径向力波动二次谐波角度,径向力波动二次谐波等级,径向力波动三次谐波值,径向力波动三次谐波角度,径向力波动三次谐波等级,径向力波动四次谐波值,径向力波动四次谐波角度,径向力波动四次谐波等级,径向力波动五次谐波值,径向力波动五次谐波角度,径向力波动五次谐波等级,径向力波动六次谐波值,径向力波动六次谐波角度,径向力波动六次谐波等级,径向力波动七次谐波值,径向力波动七次谐波角度,径向力波动七次谐波等级,径向力波动八次谐波值,径向力波动八次谐波角度,径向力波动八次谐波等级,径向力波动九次谐波值,径向力波动九次谐波角度,径向力波动九次谐波等级,径向力波动十次谐波值,径向力波动十次谐波角度,径向力波动十次谐波等级,侧向力波动值,侧向力波动角度,侧向力波动等级,侧向力波动一次谐波值,侧向力波动一次谐角度,侧向力波动一次谐波等级,侧向力波动二次谐波值,侧向力波动二次谐波角度,侧向力波动二次谐波角等级,侧向力波动三次谐波值,侧向力波动三次谐波角度,侧向力波动三次谐波等级,侧向力波动四次谐波值,侧向力波动四次谐波角度,侧向力波动四次谐波等级,侧向力波动五次谐波值,侧向力波动五次谐波角度,侧向力波动五次谐波等级,侧向力波动六次谐波值,侧向力波动六次谐波角度,侧向力波动六次谐波等级,侧向力波动七次谐波值,侧向力波动七次谐波角度,侧向力波动七次谐波等级,侧向力波动八次谐波值,侧向力波动八次谐波角度,侧向力波动八次谐波等级,侧向力波动九次谐波值,侧向力波动九次谐波角度,侧向力波动九次谐波等级,侧向力波动十次谐波值,侧向力波动十次谐波角度,侧向力波动十次谐波等级,正转侧向力偏移值,正转侧向力偏移等级,反转径向力波动值,反转径向力波动角度,反转径向力波动角等级,反转径向力波动一次谐波值,反转径向力波动一次谐波角度,反转径向力波动一次谐波等级,反转径向力波动二次谐波值,反转径向力波动二次谐波角度,反转径向力波动二次谐波等级,反转径向力波动三次谐波值,反转径向力波动三次谐波角度,反转径向力波动三次谐波等级,反转径向力波动四次谐波值,反转径向力波动四次谐波角度,反转径向力波动四次谐波等级,反转径向力波动五次谐波值,反转径向力波动五次谐波角度,反转径向力波动五次谐波等级,反转径向力波动六次谐波值,反转径向力波动六次谐波角度,反转径向力波动六次谐波等级,反转径向力波动七次谐波值,反转径向力波动七次谐波角度,反转径向力波动七次谐波等级,反转径向力波动八次谐波值,反转径向力波动八次谐波角度,反转径向力波动八次谐波等级,反转径向力波动九次谐波值,反转径向力波动九次谐波角度,反转径向力波动九次谐波等级,反转径向力波动十次谐波值,反转径向力波动十次谐波角度,反转径向力波动十次谐波等级,反转侧向力波动值,反转侧向力波动角度,反转侧向力波动等级,反转侧向力波动一次谐波值,反转侧向力波动一次谐波角度,反转侧向力波动一次谐波等级,反转侧向力波动二次谐波值,反转侧向力波动二次谐波角度,反转侧向力波动二次谐波等级,反转侧向力波动三次谐波值,反转侧向力波动三次谐波角度,反转侧向力波动三次谐波等级,反转侧向力波动四次谐波值,反转侧向力波动四次谐波角度,反转侧向力波动四次谐波等级,反转侧向力波动五次谐波值,反转侧向力波动五次谐波角度,反转侧向力波动五次谐波等级,反转侧向力波动六次谐波值,反转侧向力波动六次谐波角度,反转侧向力波动六次谐波等级,反转侧向力波动七次谐波值,反转侧向力波动七次谐波角度,反转侧向力波动七次谐波等级,反转侧向力波动八次谐波值,反转侧向力波动八次谐波角度,反转侧向力波动八次谐波等级,反转侧向力波动九次谐波值,反转侧向力波动九次谐波角度,反转侧向力波动九次谐波等级,反转侧向力波动十次谐波值,反转侧向力波动十次谐波角度,反转侧向力波动十次谐波等级,反转侧向力偏移值,反转侧向力偏移等级,锥度值,锥度等级,帘布效应,帘布效应等级,上部侧向跳动值,上部侧向跳动角度,上部侧向跳动等级,上部侧向跳动一次谐波值,上部侧向跳动一次谐波角度,上部侧向跳动一次谐波等级,下部侧向跳动值,下部侧向跳动角度,下部侧向跳动等级,下部侧向跳动一次谐波值,下部侧向跳动一次谐波角度,下部侧向跳动一次谐波等级,上部径向跳动值,上部径向跳动角度,上部径向跳动等级,上部径向跳动一次谐波值,上部径向跳动一次谐波角度,上部径向跳动一次谐波等级,中部径向跳动值,中部径向跳动角度,中部径向跳动等级,中部径向跳动一次谐波值,中部径向跳动一次谐波角度,中部径向跳动一次谐波等级,下部径向跳动值,下部径向跳动角度,下部径向跳动等级,下部径向跳动一次谐波值,下部径向跳动一次谐波角度,下部径向跳动一次谐波等级,上部侧向凸值 ,上部侧向凸角度,上部侧向凸等级,上部侧向凹值,上部侧向凹角度 ,上部侧向凹等级,下部侧向凸值,下部侧向凸角度,下部侧向凸等级 ,下部侧向凹值,下部侧向凹角度 ,下部侧向凹等级,轮胎外直径,轮胎外直径等级,上面不平衡量 ,上面不平衡量角度,上面不平衡量等级,下面不平衡量 ,下面不平衡量角度,下面不平衡量等级,静合成不平衡量,静合成不平衡量角度 ,静合成不平衡量等级 ,偶不平衡量,偶不平衡量角度,偶不平衡量等级,上面+下面不平衡量,上面+下面不平衡量等级,轮胎重量,轮胎重量等级,MODELNO,测试模式,创建人,创建时间";
		
		StringBuffer sb=new StringBuffer();
		OutputStream writer = response.getOutputStream();
		writer.write((title+System.getProperty("line.separator")).getBytes("GBK"));//
		//缓冲输出到客户端，浏览器将立即开始下载，提高用户体验
		writer.flush();
		
		ConcurrentHashMap<String, String> machine=new ConcurrentHashMap<String,String>();
		try {
			while (true) {
				// 分页查询数据
				long t1=System.currentTimeMillis();
				System.out.println("正在查询第" + (pageNum++) + "页数据");
				page.setPage(1);
				List<Map<String, Object>> list = getUDAService().datagridRowsUDA(filter, page);
				//filter.set("atr_key", list.get(list.size()-1).get("atr_key").toString());
				long t2=System.currentTimeMillis();
				System.out.println("数据查询完成，耗时:"+(t2-t1)+"ms");
				
				for (Map<String, Object> rs : list) {
					if(rs.get("tire_total_ratings_s").toString()!=null&&machine.get(rs.get("tire_total_ratings_s").toString())==null){
						machine.put(rs.get("tire_total_ratings_s").toString(),exportServiceImpl.getDictName(rs.get("tire_total_ratings_s").toString()));
					}
					if(rs.get("tire_total_ratings_s").toString()!=null){
						rs.put("tire_total_ratings_s", exportServiceImpl.getDictName(rs.get("tire_total_ratings_s").toString())); 
					}
					
					if(rs.get("machinebar_s").toString()!=null&&machine.get(rs.get("machinebar_s").toString())==null){
						machine.put(rs.get("machinebar_s").toString(),combox_entName((rs.get("machinebar_s").toString())));
					}
					if(rs.get("machinebar_s").toString()!=null){
						rs.put("machinebar_s", combox_entName(rs.get("machinebar_s").toString())); 
					}
					
					if (rs.get("s_factory_s").toString().equals("2")) {
						rs.put("s_factory_s", "半钢");
					} else {
						rs.put("s_factory_s", "全钢");
					}
					sb=new StringBuffer();
					if(rs.containsKey("machinebar_s")){
						if(rs.get("machinebar_s")!=null){
							sb.append(rs.get("machinebar_s").toString()).append(",");					
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
					if(rs.containsKey("material_code_s")){
						if(rs.get("material_code_s")!=null){
							sb.append(rs.get("material_code_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("material_name_s")){
						if(rs.get("material_name_s")!=null){
							sb.append(rs.get("material_name_s").toString()).append(",\t");					
						}else{
							sb.append("").append(",\t");		
						}
					}
					if(rs.containsKey("outputtime_t")){
						if(rs.get("outputtime_t")!=null){
							sb.append(rs.get("outputtime_t").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("buildinmachinecode_s")){
						if(rs.get("buildinmachinecode_s")!=null){
							sb.append(rs.get("buildinmachinecode_s").toString()).append(",\t");					
						}else{
							sb.append("").append(",\t");		
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
							sb.append("").append(",\t");		
						}
					}
					if(rs.containsKey("curingtime_t")){
						if(rs.get("curingtime_t")!=null){
							sb.append(rs.get("curingtime_t").toString()).append(",");					
						}else{
							sb.append("").append(",\t");		
						}
					}
					if(rs.containsKey("tire_total_ratings_s")){
						if(rs.get("tire_total_ratings_s")!=null){
							sb.append(rs.get("tire_total_ratings_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("balancetotal_rank_s")){
						if(rs.get("balancetotal_rank_s")!=null){
							sb.append(rs.get("balancetotal_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rototal_rank_s")){
						if(rs.get("rototal_rank_s")!=null){
							sb.append(rs.get("rototal_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ufm_totalrank_s")){
						if(rs.get("ufm_totalrank_s")!=null){
							sb.append(rs.get("ufm_totalrank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("load_s")){
						if(rs.get("load_s")!=null){
							sb.append(rs.get("load_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_kgf_s")){
						if(rs.get("cw_rfvoa_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_deg_s")){
						if(rs.get("cw_rfvoa_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_rank_s")){
						if(rs.get("cw_rfvoa_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_1h_kgf_s")){
						if(rs.get("cw_rfvoa_1h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_1h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_1h_deg_s")){
						if(rs.get("cw_rfvoa_1h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_1h_rank_s")){
						if(rs.get("cw_rfvoa_1h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_2h_kgf_s")){
						if(rs.get("cw_rfvoa_2h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_2h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_2h_deg_s")){
						if(rs.get("cw_rfvoa_2h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_2h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_2h_rank_s")){
						if(rs.get("cw_rfvoa_2h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_2h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_3h_kgf_s")){
						if(rs.get("cw_rfvoa_3h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_3h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_3h_deg_s")){
						if(rs.get("cw_rfvoa_3h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_3h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_3h_rank_s")){
						if(rs.get("cw_rfvoa_3h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_3h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_4h_kgf_s")){
						if(rs.get("cw_rfvoa_4h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_4h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_4h_deg_s")){
						if(rs.get("cw_rfvoa_4h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_4h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_4h_rank_s")){
						if(rs.get("cw_rfvoa_4h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_4h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_5h_kgf_s")){
						if(rs.get("cw_rfvoa_5h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_5h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_5h_deg_s")){
						if(rs.get("cw_rfvoa_5h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_5h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_5h_rank_s")){
						if(rs.get("cw_rfvoa_5h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_5h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_6h_kgf_s")){
						if(rs.get("cw_rfvoa_6h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_6h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_6h_deg_s")){
						if(rs.get("cw_rfvoa_6h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_6h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_6h_rank_s")){
						if(rs.get("cw_rfvoa_6h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_6h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_7h_kgf_s")){
						if(rs.get("cw_rfvoa_7h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_7h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_7h_deg_s")){
						if(rs.get("cw_rfvoa_7h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_7h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_7h_rank_s")){
						if(rs.get("cw_rfvoa_7h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_7h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_8h_kgf_s")){
						if(rs.get("cw_rfvoa_8h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_8h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_8h_deg_s")){
						if(rs.get("cw_rfvoa_8h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_8h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_8h_rank_s")){
						if(rs.get("cw_rfvoa_8h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_8h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_9h_kgf_s")){
						if(rs.get("cw_rfvoa_9h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_9h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_9h_deg_s")){
						if(rs.get("cw_rfvoa_9h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_9h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_9h_rank_s")){
						if(rs.get("cw_rfvoa_9h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_9h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_10h_kgf_s")){
						if(rs.get("cw_rfvoa_10h_kgf_s")!=null){
							sb.append(rs.get("cw_rfvoa_10h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_10h_deg_s")){
						if(rs.get("cw_rfvoa_10h_deg_s")!=null){
							sb.append(rs.get("cw_rfvoa_10h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_rfvoa_10h_rank_s")){
						if(rs.get("cw_rfvoa_10h_rank_s")!=null){
							sb.append(rs.get("cw_rfvoa_10h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_kgf_s")){
						if(rs.get("cw_lfvoa_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_deg_s")){
						if(rs.get("cw_lfvoa_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_rank_s")){
						if(rs.get("cw_lfvoa_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_1h_kgf_s")){
						if(rs.get("cw_lfvoa_1h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_1h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_1h_deg_s")){
						if(rs.get("cw_lfvoa_1h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_1h_rank_s")){
						if(rs.get("cw_lfvoa_1h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_2h_kgf_s")){
						if(rs.get("cw_lfvoa_2h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_2h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_2h_deg_s")){
						if(rs.get("cw_lfvoa_2h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_2h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_2h_rank_s")){
						if(rs.get("cw_lfvoa_2h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_2h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_3h_kgf_s")){
						if(rs.get("cw_lfvoa_3h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_3h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_3h_deg_s")){
						if(rs.get("cw_lfvoa_3h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_3h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_3h_rank_s")){
						if(rs.get("cw_lfvoa_3h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_3h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_4h_kgf_s")){
						if(rs.get("cw_lfvoa_4h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_4h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_4h_deg_s")){
						if(rs.get("cw_lfvoa_4h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_4h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_4h_rank_s")){
						if(rs.get("cw_lfvoa_4h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_4h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_5h_kgf_s")){
						if(rs.get("cw_lfvoa_5h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_5h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_5h_deg_s")){
						if(rs.get("cw_lfvoa_5h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_5h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_5h_rank_s")){
						if(rs.get("cw_lfvoa_5h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_5h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_6h_kgf_s")){
						if(rs.get("cw_lfvoa_6h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_6h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_6h_deg_s")){
						if(rs.get("cw_lfvoa_6h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_6h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_6h_rank_s")){
						if(rs.get("cw_lfvoa_6h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_6h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_7h_kgf_s")){
						if(rs.get("cw_lfvoa_7h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_7h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_7h_deg_s")){
						if(rs.get("cw_lfvoa_7h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_7h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_7h_rank_s")){
						if(rs.get("cw_lfvoa_7h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_7h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_8h_kgf_s")){
						if(rs.get("cw_lfvoa_8h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_8h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_8h_deg_s")){
						if(rs.get("cw_lfvoa_8h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_8h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_8h_rank_s")){
						if(rs.get("cw_lfvoa_8h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_8h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_9h_kgf_s")){
						if(rs.get("cw_lfvoa_9h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_9h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_9h_deg_s")){
						if(rs.get("cw_lfvoa_9h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_9h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_9h_rank_s")){
						if(rs.get("cw_lfvoa_9h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_9h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_10h_kgf_s")){
						if(rs.get("cw_lfvoa_10h_kgf_s")!=null){
							sb.append(rs.get("cw_lfvoa_10h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_10h_deg_s")){
						if(rs.get("cw_lfvoa_10h_deg_s")!=null){
							sb.append(rs.get("cw_lfvoa_10h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfvoa_10h_rank_s")){
						if(rs.get("cw_lfvoa_10h_rank_s")!=null){
							sb.append(rs.get("cw_lfvoa_10h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfd_kgf_s")){
						if(rs.get("cw_lfd_kgf_s")!=null){
							sb.append(rs.get("cw_lfd_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("cw_lfd_rank_s")){
						if(rs.get("cw_lfd_rank_s")!=null){
							sb.append(rs.get("cw_lfd_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_kgf_s")){
						if(rs.get("ccw_rfvoa_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_deg_s")){
						if(rs.get("ccw_rfvoa_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_rank_s")){
						if(rs.get("ccw_rfvoa_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_1h_kgf_s")){
						if(rs.get("ccw_rfvoa_1h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_1h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_1h_deg_s")){
						if(rs.get("ccw_rfvoa_1h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_1h_rank_s")){
						if(rs.get("ccw_rfvoa_1h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_2h_kgf_s")){
						if(rs.get("ccw_rfvoa_2h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_2h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_2h_deg_s")){
						if(rs.get("ccw_rfvoa_2h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_2h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_2h_rank_s")){
						if(rs.get("ccw_rfvoa_2h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_2h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_3h_kgf_s")){
						if(rs.get("ccw_rfvoa_3h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_3h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_3h_deg_s")){
						if(rs.get("ccw_rfvoa_3h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_3h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_3h_rank_s")){
						if(rs.get("ccw_rfvoa_3h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_3h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_4h_kgf_s")){
						if(rs.get("ccw_rfvoa_4h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_4h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_4h_deg_s")){
						if(rs.get("ccw_rfvoa_4h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_4h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_4h_rank_s")){
						if(rs.get("ccw_rfvoa_4h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_4h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_5h_kgf_s")){
						if(rs.get("ccw_rfvoa_5h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_5h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_5h_deg_s")){
						if(rs.get("ccw_rfvoa_5h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_5h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_5h_rank_s")){
						if(rs.get("ccw_rfvoa_5h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_5h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_6h_kgf_s")){
						if(rs.get("ccw_rfvoa_6h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_6h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_6h_deg_s")){
						if(rs.get("ccw_rfvoa_6h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_6h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_6h_rank_s")){
						if(rs.get("ccw_rfvoa_6h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_6h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_7h_kgf_s")){
						if(rs.get("ccw_rfvoa_7h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_7h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_7h_deg_s")){
						if(rs.get("ccw_rfvoa_7h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_7h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_7h_rank_s")){
						if(rs.get("ccw_rfvoa_7h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_7h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_8h_kgf_s")){
						if(rs.get("ccw_rfvoa_8h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_8h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_8h_deg_s")){
						if(rs.get("ccw_rfvoa_8h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_8h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_8h_rank_s")){
						if(rs.get("ccw_rfvoa_8h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_8h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_9h_kgf_s")){
						if(rs.get("ccw_rfvoa_9h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_9h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_9h_deg_s")){
						if(rs.get("ccw_rfvoa_9h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_9h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_9h_rank_s")){
						if(rs.get("ccw_rfvoa_9h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_9h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_10h_kgf_s")){
						if(rs.get("ccw_rfvoa_10h_kgf_s")!=null){
							sb.append(rs.get("ccw_rfvoa_10h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_10h_deg_s")){
						if(rs.get("ccw_rfvoa_10h_deg_s")!=null){
							sb.append(rs.get("ccw_rfvoa_10h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_rfvoa_10h_rank_s")){
						if(rs.get("ccw_rfvoa_10h_rank_s")!=null){
							sb.append(rs.get("ccw_rfvoa_10h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_kgf_s")){
						if(rs.get("ccw_lfvoa_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_deg_s")){
						if(rs.get("ccw_lfvoa_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_rank_s")){
						if(rs.get("ccw_lfvoa_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_1h_kgf_s")){
						if(rs.get("ccw_lfvoa_1h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_1h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_1h_deg_s")){
						if(rs.get("ccw_lfvoa_1h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_1h_rank_s")){
						if(rs.get("ccw_lfvoa_1h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_2h_kgf_s")){
						if(rs.get("ccw_lfvoa_2h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_2h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_2h_deg_s")){
						if(rs.get("ccw_lfvoa_2h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_2h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_2h_rank_s")){
						if(rs.get("ccw_lfvoa_2h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_2h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_3h_kgf_s")){
						if(rs.get("ccw_lfvoa_3h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_3h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_3h_deg_s")){
						if(rs.get("ccw_lfvoa_3h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_3h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_3h_rank_s")){
						if(rs.get("ccw_lfvoa_3h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_3h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_4h_kgf_s")){
						if(rs.get("ccw_lfvoa_4h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_4h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_4h_deg_s")){
						if(rs.get("ccw_lfvoa_4h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_4h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_4h_rank_s")){
						if(rs.get("ccw_lfvoa_4h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_4h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_5h_kgf_s")){
						if(rs.get("ccw_lfvoa_5h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_5h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_5h_deg_s")){
						if(rs.get("ccw_lfvoa_5h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_5h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_5h_rank_s")){
						if(rs.get("ccw_lfvoa_5h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_5h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_6h_kgf_s")){
						if(rs.get("ccw_lfvoa_6h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_6h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_6h_deg_s")){
						if(rs.get("ccw_lfvoa_6h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_6h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_6h_rank_s")){
						if(rs.get("ccw_lfvoa_6h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_6h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_7h_kgf_s")){
						if(rs.get("ccw_lfvoa_7h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_7h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_7h_deg_s")){
						if(rs.get("ccw_lfvoa_7h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_7h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_7h_rank_s")){
						if(rs.get("ccw_lfvoa_7h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_7h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_8h_kgf_s")){
						if(rs.get("ccw_lfvoa_8h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_8h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_8h_deg_s")){
						if(rs.get("ccw_lfvoa_8h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_8h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_8h_rank_s")){
						if(rs.get("ccw_lfvoa_8h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_8h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_9h_kgf_s")){
						if(rs.get("ccw_lfvoa_9h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_9h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_9h_deg_s")){
						if(rs.get("ccw_lfvoa_9h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_9h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_9h_rank_s")){
						if(rs.get("ccw_lfvoa_9h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_9h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_10h_kgf_s")){
						if(rs.get("ccw_lfvoa_10h_kgf_s")!=null){
							sb.append(rs.get("ccw_lfvoa_10h_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_10h_deg_s")){
						if(rs.get("ccw_lfvoa_10h_deg_s")!=null){
							sb.append(rs.get("ccw_lfvoa_10h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfvoa_10h_rank_s")){
						if(rs.get("ccw_lfvoa_10h_rank_s")!=null){
							sb.append(rs.get("ccw_lfvoa_10h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfd_kgf_s")){
						if(rs.get("ccw_lfd_kgf_s")!=null){
							sb.append(rs.get("ccw_lfd_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ccw_lfd_rank_s")){
						if(rs.get("ccw_lfd_rank_s")!=null){
							sb.append(rs.get("ccw_lfd_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("con_kgf_s")){
						if(rs.get("con_kgf_s")!=null){
							sb.append(rs.get("con_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("con_rank_s")){
						if(rs.get("con_rank_s")!=null){
							sb.append(rs.get("con_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ply_kgf_s")){
						if(rs.get("ply_kgf_s")!=null){
							sb.append(rs.get("ply_kgf_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ply_rank_s")){
						if(rs.get("ply_rank_s")!=null){
							sb.append(rs.get("ply_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ltoa_mm_s")){
						if(rs.get("ltoa_mm_s")!=null){
							sb.append(rs.get("ltoa_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ltoa_deg_s")){
						if(rs.get("ltoa_deg_s")!=null){
							sb.append(rs.get("ltoa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ltoa_rank_s")){
						if(rs.get("ltoa_rank_s")!=null){
							sb.append(rs.get("ltoa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ltoa_1h_mm_s")){
						if(rs.get("ltoa_1h_mm_s")!=null){
							sb.append(rs.get("ltoa_1h_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ltoa_1h_deg_s")){
						if(rs.get("ltoa_1h_deg_s")!=null){
							sb.append(rs.get("ltoa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("ltoa_1h_rank_s")){
						if(rs.get("ltoa_1h_rank_s")!=null){
							sb.append(rs.get("ltoa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lboa_mm_s")){
						if(rs.get("lboa_mm_s")!=null){
							sb.append(rs.get("lboa_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lboa_deg_s")){
						if(rs.get("lboa_deg_s")!=null){
							sb.append(rs.get("lboa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lboa_rank_s")){
						if(rs.get("lboa_rank_s")!=null){
							sb.append(rs.get("lboa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lboa_1h_mm_s")){
						if(rs.get("lboa_1h_mm_s")!=null){
							sb.append(rs.get("lboa_1h_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lboa_1h_deg_s")){
						if(rs.get("lboa_1h_deg_s")!=null){
							sb.append(rs.get("lboa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lboa_1h_rank_s")){
						if(rs.get("lboa_1h_rank_s")!=null){
							sb.append(rs.get("lboa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rtoa_mm_s")){
						if(rs.get("rtoa_mm_s")!=null){
							sb.append(rs.get("rtoa_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rtoa_deg_s")){
						if(rs.get("rtoa_deg_s")!=null){
							sb.append(rs.get("rtoa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rtoa_rank_s")){
						if(rs.get("rtoa_rank_s")!=null){
							sb.append(rs.get("rtoa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rtoa_1h_mm_s")){
						if(rs.get("rtoa_1h_mm_s")!=null){
							sb.append(rs.get("rtoa_1h_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rtoa_1h_deg_s")){
						if(rs.get("rtoa_1h_deg_s")!=null){
							sb.append(rs.get("rtoa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rtoa_1h_rank_s")){
						if(rs.get("rtoa_1h_rank_s")!=null){
							sb.append(rs.get("rtoa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rcoa_mm_s")){
						if(rs.get("rcoa_mm_s")!=null){
							sb.append(rs.get("rcoa_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rcoa_deg_s")){
						if(rs.get("rcoa_deg_s")!=null){
							sb.append(rs.get("rcoa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rcoa_rank_s")){
						if(rs.get("rcoa_rank_s")!=null){
							sb.append(rs.get("rcoa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rcoa_1h_mm_s")){
						if(rs.get("rcoa_1h_mm_s")!=null){
							sb.append(rs.get("rcoa_1h_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rcoa_1h_deg_s")){
						if(rs.get("rcoa_1h_deg_s")!=null){
							sb.append(rs.get("rcoa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rcoa_1h_rank_s")){
						if(rs.get("rcoa_1h_rank_s")!=null){
							sb.append(rs.get("rcoa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rboa_mm_s")){
						if(rs.get("rboa_mm_s")!=null){
							sb.append(rs.get("rboa_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rboa_deg_s")){
						if(rs.get("rboa_deg_s")!=null){
							sb.append(rs.get("rboa_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rboa_rank_s")){
						if(rs.get("rboa_rank_s")!=null){
							sb.append(rs.get("rboa_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rboa_1h_mm_s")){
						if(rs.get("rboa_1h_mm_s")!=null){
							sb.append(rs.get("rboa_1h_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rboa_1h_deg_s")){
						if(rs.get("rboa_1h_deg_s")!=null){
							sb.append(rs.get("rboa_1h_deg_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("rboa_1h_rank_s")){
						if(rs.get("rboa_1h_rank_s")!=null){
							sb.append(rs.get("rboa_1h_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("lt_bulging_mm_s")){
						if(rs.get("lt_bulging_mm_s")!=null){
							sb.append(rs.get("lt_bulging_mm_s").toString()).append(",");					
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
					if(rs.containsKey("lt_dent_mm_s")){
						if(rs.get("lt_dent_mm_s")!=null){
							sb.append(rs.get("lt_dent_mm_s").toString()).append(",");					
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
					if(rs.containsKey("lb_bulging_mm_s")){
						if(rs.get("lb_bulging_mm_s")!=null){
							sb.append(rs.get("lb_bulging_mm_s").toString()).append(",");					
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
					if(rs.containsKey("lb_dent_mm_s")){
						if(rs.get("lb_dent_mm_s")!=null){
							sb.append(rs.get("lb_dent_mm_s").toString()).append(",");					
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
					if(rs.containsKey("outsidediameter_mm_s")){
						if(rs.get("outsidediameter_mm_s")!=null){
							sb.append(rs.get("outsidediameter_mm_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("outsidediameter_rank_s")){
						if(rs.get("outsidediameter_rank_s")!=null){
							sb.append(rs.get("outsidediameter_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("upper_unbalance_g_s")){
						if(rs.get("upper_unbalance_g_s")!=null){
							sb.append(rs.get("upper_unbalance_g_s").toString()).append(",");					
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
							sb.append(rs.get("lower_unbalance_g_s").toString()).append(",");					
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
					if(rs.containsKey("static_unbalance_g_s")){
						if(rs.get("static_unbalance_g_s")!=null){
							sb.append(rs.get("static_unbalance_g_s").toString()).append(",");					
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
							sb.append(rs.get("couple_unbalance_g_s").toString()).append(",");					
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
					if(rs.containsKey("uplow_unbalance_g_s")){
						if(rs.get("uplow_unbalance_g_s")!=null){
							sb.append(rs.get("uplow_unbalance_g_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("uplow_unbalance_rank_s")){
						if(rs.get("uplow_unbalance_rank_s")!=null){
							sb.append(rs.get("uplow_unbalance_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("weight_s")){
						if(rs.get("weight_s")!=null){
							sb.append(rs.get("weight_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("weight_rank_s")){
						if(rs.get("weight_rank_s")!=null){
							sb.append(rs.get("weight_rank_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
				
					if(rs.containsKey("modelno_s")){
						if(rs.get("modelno_s")!=null){
							sb.append(rs.get("modelno_s").toString()).append(",");					
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("testmode_s")){
						if(rs.get("testmode_s")!=null){
							if(rs.get("testmode_s").toString().equals("0")){
								sb.append("正常测试").append(",");					
							}else{
								sb.append("精度测试").append(",");
							}
						}else{
							sb.append("").append(",");		
						}
					}
					if(rs.containsKey("created_by_s")){
						if(rs.get("created_by_s")!=null){
							sb.append(rs.get("created_by_s").toString()).append(",\t");					
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
					writer.write((sb.toString().replace("\n", " ").replace("\r", " ").replace("null", "") +System.getProperty("line.separator")).getBytes("GBK"));
					writer.flush();
				}
				if (list.size() < batchQueryCount) {
					break;
				}
				long t3=System.currentTimeMillis();
				System.out.println("第"+(pageNum-1)+"页数据输出完成，耗时:"+(t3-t2)+"ms");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			writer.flush();
			writer.close();
		}
	}

	void writeRow(SXSSFRow row, Object... values) {
		int i = 0;
		for (Object v : values) {
			if (v == null) {
				v = "";
			}
			row.createCell(i++).setCellValue(v + "");
		}
	}*/
	
	
	@Log(code = "ZJ_BZGL_RKFJ_SAVE_ENTNAME", value = "获取动平衡机")
	@RequestMapping("combox_entName")
	public String combox_entName(String entCode) throws Exception {
		String result = dynabalancecheresultSrv.getEndNameByEntCode(entCode);
		return result;
	}
	
	@NoLogin
	@Log(value = "导出EXCEL", code = "ZJ_JCGL_DPHJCLL_EXPORT")
	@RequestMapping("export")
	  public void export(String s_factory_s,String tire_total_ratings_s, String machinebar_s, String curingspeccode_s, String barcode_s, String begin_created_time, String end_created_time) throws Exception
	  {
	    Filter filter = new Filter();
	   
	    if (!StringUtils.isEmpty(barcode_s))
	      filter.set("machinebar_s", machinebar_s)
	        .set("curingspeccode_s", curingspeccode_s)
	        .set("barcode_s", barcode_s)
	        .set("s_factory_s", s_factory_s)
	        .set("tire_total_ratings_s", tire_total_ratings_s)
	        .set("begin_created_time", "")
	        .set("end_created_time", "");
	    else {
	      filter.set("machinebar_s", machinebar_s)
	        .set("curingspeccode_s", curingspeccode_s)
	        .set("barcode_s", barcode_s)
	        .set("s_factory_s", s_factory_s)
	        .set("tire_total_ratings_s", tire_total_ratings_s)
	        .set("begin_created_time", begin_created_time)
	        .set("end_created_time", end_created_time);
	    }

	    System.out.println(filter);

	    int batchQueryCount = 1000;

	    Page page = new Page();
	    page.setRows(batchQueryCount);
	    page.setAll(0);

	    int pageNum = 1;
	     

	    this.response.reset();

	    this.response.setHeader("content-disposition", "attachment;filename=" 
	    + new String("动平衡检测履历.csv"  .getBytes("GBK"),  "ISO-8859-1"));

	    String title = "动平衡机台,轮胎条码,物料编码,物料描述,检测时间,成型机台,成型时间,硫化机台,硫化时间,轮胎总等级,动平衡总等级,跳动度总等级,均匀性总等级,荷重,径向力波动值,径向力波动角度,径向力波动等级 ,径向力波动一次谐波值,径向力波动一次谐角度,径向力波动一次谐波等级,径向力波动二次谐波值,径向力波动二次谐波角度,径向力波动二次谐波等级,径向力波动三次谐波值,径向力波动三次谐波角度,径向力波动三次谐波等级,径向力波动四次谐波值,径向力波动四次谐波角度,径向力波动四次谐波等级,径向力波动五次谐波值,径向力波动五次谐波角度,径向力波动五次谐波等级,径向力波动六次谐波值,径向力波动六次谐波角度,径向力波动六次谐波等级,径向力波动七次谐波值,径向力波动七次谐波角度,径向力波动七次谐波等级,径向力波动八次谐波值,径向力波动八次谐波角度,径向力波动八次谐波等级,径向力波动九次谐波值,径向力波动九次谐波角度,径向力波动九次谐波等级,径向力波动十次谐波值,径向力波动十次谐波角度,径向力波动十次谐波等级,侧向力波动值,侧向力波动角度,侧向力波动等级,侧向力波动一次谐波值,侧向力波动一次谐角度,侧向力波动一次谐波等级,侧向力波动二次谐波值,侧向力波动二次谐波角度,侧向力波动二次谐波角等级,侧向力波动三次谐波值,侧向力波动三次谐波角度,侧向力波动三次谐波等级,侧向力波动四次谐波值,侧向力波动四次谐波角度,侧向力波动四次谐波等级,侧向力波动五次谐波值,侧向力波动五次谐波角度,侧向力波动五次谐波等级,侧向力波动六次谐波值,侧向力波动六次谐波角度,侧向力波动六次谐波等级,侧向力波动七次谐波值,侧向力波动七次谐波角度,侧向力波动七次谐波等级,侧向力波动八次谐波值,侧向力波动八次谐波角度,侧向力波动八次谐波等级,侧向力波动九次谐波值,侧向力波动九次谐波角度,侧向力波动九次谐波等级,侧向力波动十次谐波值,侧向力波动十次谐波角度,侧向力波动十次谐波等级,正转侧向力偏移值,正转侧向力偏移等级,反转径向力波动值,反转径向力波动角度,反转径向力波动角等级,反转径向力波动一次谐波值,反转径向力波动一次谐波角度,反转径向力波动一次谐波等级,反转径向力波动二次谐波值,反转径向力波动二次谐波角度,反转径向力波动二次谐波等级,反转径向力波动三次谐波值,反转径向力波动三次谐波角度,反转径向力波动三次谐波等级,反转径向力波动四次谐波值,反转径向力波动四次谐波角度,反转径向力波动四次谐波等级,反转径向力波动五次谐波值,反转径向力波动五次谐波角度,反转径向力波动五次谐波等级,反转径向力波动六次谐波值,反转径向力波动六次谐波角度,反转径向力波动六次谐波等级,反转径向力波动七次谐波值,反转径向力波动七次谐波角度,反转径向力波动七次谐波等级,反转径向力波动八次谐波值,反转径向力波动八次谐波角度,反转径向力波动八次谐波等级,反转径向力波动九次谐波值,反转径向力波动九次谐波角度,反转径向力波动九次谐波等级,反转径向力波动十次谐波值,反转径向力波动十次谐波角度,反转径向力波动十次谐波等级,反转侧向力波动值,反转侧向力波动角度,反转侧向力波动等级,反转侧向力波动一次谐波值,反转侧向力波动一次谐波角度,反转侧向力波动一次谐波等级,反转侧向力波动二次谐波值,反转侧向力波动二次谐波角度,反转侧向力波动二次谐波等级,反转侧向力波动三次谐波值,反转侧向力波动三次谐波角度,反转侧向力波动三次谐波等级,反转侧向力波动四次谐波值,反转侧向力波动四次谐波角度,反转侧向力波动四次谐波等级,反转侧向力波动五次谐波值,反转侧向力波动五次谐波角度,反转侧向力波动五次谐波等级,反转侧向力波动六次谐波值,反转侧向力波动六次谐波角度,反转侧向力波动六次谐波等级,反转侧向力波动七次谐波值,反转侧向力波动七次谐波角度,反转侧向力波动七次谐波等级,反转侧向力波动八次谐波值,反转侧向力波动八次谐波角度,反转侧向力波动八次谐波等级,反转侧向力波动九次谐波值,反转侧向力波动九次谐波角度,反转侧向力波动九次谐波等级,反转侧向力波动十次谐波值,反转侧向力波动十次谐波角度,反转侧向力波动十次谐波等级,反转侧向力偏移值,反转侧向力偏移等级,锥度值,锥度等级,帘布效应,帘布效应等级,上部侧向跳动值,上部侧向跳动角度,上部侧向跳动等级,上部侧向跳动一次谐波值,上部侧向跳动一次谐波角度,上部侧向跳动一次谐波等级,下部侧向跳动值,下部侧向跳动角度,下部侧向跳动等级,下部侧向跳动一次谐波值,下部侧向跳动一次谐波角度,下部侧向跳动一次谐波等级,上部径向跳动值,上部径向跳动角度,上部径向跳动等级,上部径向跳动一次谐波值,上部径向跳动一次谐波角度,上部径向跳动一次谐波等级,中部径向跳动值,中部径向跳动角度,中部径向跳动等级,中部径向跳动一次谐波值,中部径向跳动一次谐波角度,中部径向跳动一次谐波等级,下部径向跳动值,下部径向跳动角度,下部径向跳动等级,下部径向跳动一次谐波值,下部径向跳动一次谐波角度,下部径向跳动一次谐波等级,上部侧向凸值 ,上部侧向凸角度,上部侧向凸等级,上部侧向凹值,上部侧向凹角度 ,上部侧向凹等级,下部侧向凸值,下部侧向凸角度,下部侧向凸等级 ,下部侧向凹值,下部侧向凹角度 ,下部侧向凹等级,轮胎外直径,轮胎外直径等级,上面不平衡量 ,上面不平衡量角度,上面不平衡量等级,下面不平衡量 ,下面不平衡量角度,下面不平衡量等级,静合成不平衡量,静合成不平衡量角度 ,静合成不平衡量等级 ,偶不平衡量,偶不平衡量角度,偶不平衡量等级,上面+下面不平衡量,上面+下面不平衡量等级,轮胎重量,轮胎重量等级,MODELNO,测试模式,创建人,创建时间";

	    StringBuffer sb = new StringBuffer();
	    OutputStream writer = this.response.getOutputStream();
	    writer.write((title + System.getProperty("line.separator")) .getBytes("GBK"));

	    writer.flush();

	    ConcurrentHashMap <String, String>machine = new ConcurrentHashMap<String, String>();
	    try
	    {
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
	          if(rs.containsKey("machinebar_s")){
					if(rs.get("machinebar_s")!=null){
						sb.append(rs.get("machinebar_s").toString()).append(",");					
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
				if(rs.containsKey("material_code_s")){
					if(rs.get("material_code_s")!=null){
						sb.append(rs.get("material_code_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("material_name_s")){
					if(rs.get("material_name_s")!=null){
						sb.append(rs.get("material_name_s").toString()).append(",\t");					
					}else{
						sb.append("").append(",\t");		
					}
				}
				if(rs.containsKey("outputtime_t")){
					if(rs.get("outputtime_t")!=null){
						sb.append(rs.get("outputtime_t").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("buildinmachinecode_s")){
					if(rs.get("buildinmachinecode_s")!=null){
						sb.append(rs.get("buildinmachinecode_s").toString()).append(",\t");					
					}else{
						sb.append("").append(",\t");		
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
						sb.append("").append(",\t");		
					}
				}
				if(rs.containsKey("curingtime_t")){
					if(rs.get("curingtime_t")!=null){
						sb.append(rs.get("curingtime_t").toString()).append(",");					
					}else{
						sb.append("").append(",\t");		
					}
				}
				if(rs.containsKey("tire_total_ratings_s")){
					if(rs.get("tire_total_ratings_s")!=null){
						if(rs.get("tire_total_ratings_s").toString().equals("253001")){
							sb.append("合格").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253002")){
							sb.append("复检合格").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253003")){
							sb.append("不合格").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253006")){
							sb.append("次品").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253007")){
							sb.append("合格品A").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253008")){
							sb.append("合格品B").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253009")){
							sb.append("A1").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253010")){
							sb.append("A2").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253011")){
							sb.append("A3").append(",");
						}
						else if(rs.get("tire_total_ratings_s").toString().equals("253012")){
							sb.append("废品").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253013")){
							sb.append("特废").append(",");
						}else if(rs.get("tire_total_ratings_s").toString().equals("253014")){
							sb.append("A4").append(",");
						}else
						{
							sb.append("").append(",");
						}
						
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("balancetotal_rank_s")){
					if(rs.get("balancetotal_rank_s")!=null){
						sb.append(rs.get("balancetotal_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rototal_rank_s")){
					if(rs.get("rototal_rank_s")!=null){
						sb.append(rs.get("rototal_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ufm_totalrank_s")){
					if(rs.get("ufm_totalrank_s")!=null){
						sb.append(rs.get("ufm_totalrank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("load_s")){
					if(rs.get("load_s")!=null){
						sb.append(rs.get("load_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_kgf_s")){
					if(rs.get("cw_rfvoa_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_deg_s")){
					if(rs.get("cw_rfvoa_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_rank_s")){
					if(rs.get("cw_rfvoa_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_1h_kgf_s")){
					if(rs.get("cw_rfvoa_1h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_1h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_1h_deg_s")){
					if(rs.get("cw_rfvoa_1h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_1h_rank_s")){
					if(rs.get("cw_rfvoa_1h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_2h_kgf_s")){
					if(rs.get("cw_rfvoa_2h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_2h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_2h_deg_s")){
					if(rs.get("cw_rfvoa_2h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_2h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_2h_rank_s")){
					if(rs.get("cw_rfvoa_2h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_2h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_3h_kgf_s")){
					if(rs.get("cw_rfvoa_3h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_3h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_3h_deg_s")){
					if(rs.get("cw_rfvoa_3h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_3h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_3h_rank_s")){
					if(rs.get("cw_rfvoa_3h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_3h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_4h_kgf_s")){
					if(rs.get("cw_rfvoa_4h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_4h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_4h_deg_s")){
					if(rs.get("cw_rfvoa_4h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_4h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_4h_rank_s")){
					if(rs.get("cw_rfvoa_4h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_4h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_5h_kgf_s")){
					if(rs.get("cw_rfvoa_5h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_5h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_5h_deg_s")){
					if(rs.get("cw_rfvoa_5h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_5h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_5h_rank_s")){
					if(rs.get("cw_rfvoa_5h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_5h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_6h_kgf_s")){
					if(rs.get("cw_rfvoa_6h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_6h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_6h_deg_s")){
					if(rs.get("cw_rfvoa_6h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_6h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_6h_rank_s")){
					if(rs.get("cw_rfvoa_6h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_6h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_7h_kgf_s")){
					if(rs.get("cw_rfvoa_7h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_7h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_7h_deg_s")){
					if(rs.get("cw_rfvoa_7h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_7h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_7h_rank_s")){
					if(rs.get("cw_rfvoa_7h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_7h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_8h_kgf_s")){
					if(rs.get("cw_rfvoa_8h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_8h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_8h_deg_s")){
					if(rs.get("cw_rfvoa_8h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_8h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_8h_rank_s")){
					if(rs.get("cw_rfvoa_8h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_8h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_9h_kgf_s")){
					if(rs.get("cw_rfvoa_9h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_9h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_9h_deg_s")){
					if(rs.get("cw_rfvoa_9h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_9h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_9h_rank_s")){
					if(rs.get("cw_rfvoa_9h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_9h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_10h_kgf_s")){
					if(rs.get("cw_rfvoa_10h_kgf_s")!=null){
						sb.append(rs.get("cw_rfvoa_10h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_10h_deg_s")){
					if(rs.get("cw_rfvoa_10h_deg_s")!=null){
						sb.append(rs.get("cw_rfvoa_10h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_rfvoa_10h_rank_s")){
					if(rs.get("cw_rfvoa_10h_rank_s")!=null){
						sb.append(rs.get("cw_rfvoa_10h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_kgf_s")){
					if(rs.get("cw_lfvoa_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_deg_s")){
					if(rs.get("cw_lfvoa_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_rank_s")){
					if(rs.get("cw_lfvoa_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_1h_kgf_s")){
					if(rs.get("cw_lfvoa_1h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_1h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_1h_deg_s")){
					if(rs.get("cw_lfvoa_1h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_1h_rank_s")){
					if(rs.get("cw_lfvoa_1h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_2h_kgf_s")){
					if(rs.get("cw_lfvoa_2h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_2h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_2h_deg_s")){
					if(rs.get("cw_lfvoa_2h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_2h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_2h_rank_s")){
					if(rs.get("cw_lfvoa_2h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_2h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_3h_kgf_s")){
					if(rs.get("cw_lfvoa_3h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_3h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_3h_deg_s")){
					if(rs.get("cw_lfvoa_3h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_3h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_3h_rank_s")){
					if(rs.get("cw_lfvoa_3h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_3h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_4h_kgf_s")){
					if(rs.get("cw_lfvoa_4h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_4h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_4h_deg_s")){
					if(rs.get("cw_lfvoa_4h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_4h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_4h_rank_s")){
					if(rs.get("cw_lfvoa_4h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_4h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_5h_kgf_s")){
					if(rs.get("cw_lfvoa_5h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_5h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_5h_deg_s")){
					if(rs.get("cw_lfvoa_5h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_5h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_5h_rank_s")){
					if(rs.get("cw_lfvoa_5h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_5h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_6h_kgf_s")){
					if(rs.get("cw_lfvoa_6h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_6h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_6h_deg_s")){
					if(rs.get("cw_lfvoa_6h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_6h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_6h_rank_s")){
					if(rs.get("cw_lfvoa_6h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_6h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_7h_kgf_s")){
					if(rs.get("cw_lfvoa_7h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_7h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_7h_deg_s")){
					if(rs.get("cw_lfvoa_7h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_7h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_7h_rank_s")){
					if(rs.get("cw_lfvoa_7h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_7h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_8h_kgf_s")){
					if(rs.get("cw_lfvoa_8h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_8h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_8h_deg_s")){
					if(rs.get("cw_lfvoa_8h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_8h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_8h_rank_s")){
					if(rs.get("cw_lfvoa_8h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_8h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_9h_kgf_s")){
					if(rs.get("cw_lfvoa_9h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_9h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_9h_deg_s")){
					if(rs.get("cw_lfvoa_9h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_9h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_9h_rank_s")){
					if(rs.get("cw_lfvoa_9h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_9h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_10h_kgf_s")){
					if(rs.get("cw_lfvoa_10h_kgf_s")!=null){
						sb.append(rs.get("cw_lfvoa_10h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_10h_deg_s")){
					if(rs.get("cw_lfvoa_10h_deg_s")!=null){
						sb.append(rs.get("cw_lfvoa_10h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfvoa_10h_rank_s")){
					if(rs.get("cw_lfvoa_10h_rank_s")!=null){
						sb.append(rs.get("cw_lfvoa_10h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfd_kgf_s")){
					if(rs.get("cw_lfd_kgf_s")!=null){
						sb.append(rs.get("cw_lfd_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("cw_lfd_rank_s")){
					if(rs.get("cw_lfd_rank_s")!=null){
						sb.append(rs.get("cw_lfd_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_kgf_s")){
					if(rs.get("ccw_rfvoa_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_deg_s")){
					if(rs.get("ccw_rfvoa_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_rank_s")){
					if(rs.get("ccw_rfvoa_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_1h_kgf_s")){
					if(rs.get("ccw_rfvoa_1h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_1h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_1h_deg_s")){
					if(rs.get("ccw_rfvoa_1h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_1h_rank_s")){
					if(rs.get("ccw_rfvoa_1h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_2h_kgf_s")){
					if(rs.get("ccw_rfvoa_2h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_2h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_2h_deg_s")){
					if(rs.get("ccw_rfvoa_2h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_2h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_2h_rank_s")){
					if(rs.get("ccw_rfvoa_2h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_2h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_3h_kgf_s")){
					if(rs.get("ccw_rfvoa_3h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_3h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_3h_deg_s")){
					if(rs.get("ccw_rfvoa_3h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_3h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_3h_rank_s")){
					if(rs.get("ccw_rfvoa_3h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_3h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_4h_kgf_s")){
					if(rs.get("ccw_rfvoa_4h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_4h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_4h_deg_s")){
					if(rs.get("ccw_rfvoa_4h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_4h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_4h_rank_s")){
					if(rs.get("ccw_rfvoa_4h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_4h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_5h_kgf_s")){
					if(rs.get("ccw_rfvoa_5h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_5h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_5h_deg_s")){
					if(rs.get("ccw_rfvoa_5h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_5h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_5h_rank_s")){
					if(rs.get("ccw_rfvoa_5h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_5h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_6h_kgf_s")){
					if(rs.get("ccw_rfvoa_6h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_6h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_6h_deg_s")){
					if(rs.get("ccw_rfvoa_6h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_6h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_6h_rank_s")){
					if(rs.get("ccw_rfvoa_6h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_6h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_7h_kgf_s")){
					if(rs.get("ccw_rfvoa_7h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_7h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_7h_deg_s")){
					if(rs.get("ccw_rfvoa_7h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_7h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_7h_rank_s")){
					if(rs.get("ccw_rfvoa_7h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_7h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_8h_kgf_s")){
					if(rs.get("ccw_rfvoa_8h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_8h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_8h_deg_s")){
					if(rs.get("ccw_rfvoa_8h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_8h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_8h_rank_s")){
					if(rs.get("ccw_rfvoa_8h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_8h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_9h_kgf_s")){
					if(rs.get("ccw_rfvoa_9h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_9h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_9h_deg_s")){
					if(rs.get("ccw_rfvoa_9h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_9h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_9h_rank_s")){
					if(rs.get("ccw_rfvoa_9h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_9h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_10h_kgf_s")){
					if(rs.get("ccw_rfvoa_10h_kgf_s")!=null){
						sb.append(rs.get("ccw_rfvoa_10h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_10h_deg_s")){
					if(rs.get("ccw_rfvoa_10h_deg_s")!=null){
						sb.append(rs.get("ccw_rfvoa_10h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_rfvoa_10h_rank_s")){
					if(rs.get("ccw_rfvoa_10h_rank_s")!=null){
						sb.append(rs.get("ccw_rfvoa_10h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_kgf_s")){
					if(rs.get("ccw_lfvoa_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_deg_s")){
					if(rs.get("ccw_lfvoa_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_rank_s")){
					if(rs.get("ccw_lfvoa_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_1h_kgf_s")){
					if(rs.get("ccw_lfvoa_1h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_1h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_1h_deg_s")){
					if(rs.get("ccw_lfvoa_1h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_1h_rank_s")){
					if(rs.get("ccw_lfvoa_1h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_2h_kgf_s")){
					if(rs.get("ccw_lfvoa_2h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_2h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_2h_deg_s")){
					if(rs.get("ccw_lfvoa_2h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_2h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_2h_rank_s")){
					if(rs.get("ccw_lfvoa_2h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_2h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_3h_kgf_s")){
					if(rs.get("ccw_lfvoa_3h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_3h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_3h_deg_s")){
					if(rs.get("ccw_lfvoa_3h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_3h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_3h_rank_s")){
					if(rs.get("ccw_lfvoa_3h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_3h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_4h_kgf_s")){
					if(rs.get("ccw_lfvoa_4h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_4h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_4h_deg_s")){
					if(rs.get("ccw_lfvoa_4h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_4h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_4h_rank_s")){
					if(rs.get("ccw_lfvoa_4h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_4h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_5h_kgf_s")){
					if(rs.get("ccw_lfvoa_5h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_5h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_5h_deg_s")){
					if(rs.get("ccw_lfvoa_5h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_5h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_5h_rank_s")){
					if(rs.get("ccw_lfvoa_5h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_5h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_6h_kgf_s")){
					if(rs.get("ccw_lfvoa_6h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_6h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_6h_deg_s")){
					if(rs.get("ccw_lfvoa_6h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_6h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_6h_rank_s")){
					if(rs.get("ccw_lfvoa_6h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_6h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_7h_kgf_s")){
					if(rs.get("ccw_lfvoa_7h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_7h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_7h_deg_s")){
					if(rs.get("ccw_lfvoa_7h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_7h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_7h_rank_s")){
					if(rs.get("ccw_lfvoa_7h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_7h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_8h_kgf_s")){
					if(rs.get("ccw_lfvoa_8h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_8h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_8h_deg_s")){
					if(rs.get("ccw_lfvoa_8h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_8h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_8h_rank_s")){
					if(rs.get("ccw_lfvoa_8h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_8h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_9h_kgf_s")){
					if(rs.get("ccw_lfvoa_9h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_9h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_9h_deg_s")){
					if(rs.get("ccw_lfvoa_9h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_9h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_9h_rank_s")){
					if(rs.get("ccw_lfvoa_9h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_9h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_10h_kgf_s")){
					if(rs.get("ccw_lfvoa_10h_kgf_s")!=null){
						sb.append(rs.get("ccw_lfvoa_10h_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_10h_deg_s")){
					if(rs.get("ccw_lfvoa_10h_deg_s")!=null){
						sb.append(rs.get("ccw_lfvoa_10h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfvoa_10h_rank_s")){
					if(rs.get("ccw_lfvoa_10h_rank_s")!=null){
						sb.append(rs.get("ccw_lfvoa_10h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfd_kgf_s")){
					if(rs.get("ccw_lfd_kgf_s")!=null){
						sb.append(rs.get("ccw_lfd_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ccw_lfd_rank_s")){
					if(rs.get("ccw_lfd_rank_s")!=null){
						sb.append(rs.get("ccw_lfd_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("con_kgf_s")){
					if(rs.get("con_kgf_s")!=null){
						sb.append(rs.get("con_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("con_rank_s")){
					if(rs.get("con_rank_s")!=null){
						sb.append(rs.get("con_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ply_kgf_s")){
					if(rs.get("ply_kgf_s")!=null){
						sb.append(rs.get("ply_kgf_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ply_rank_s")){
					if(rs.get("ply_rank_s")!=null){
						sb.append(rs.get("ply_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ltoa_mm_s")){
					if(rs.get("ltoa_mm_s")!=null){
						sb.append(rs.get("ltoa_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ltoa_deg_s")){
					if(rs.get("ltoa_deg_s")!=null){
						sb.append(rs.get("ltoa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ltoa_rank_s")){
					if(rs.get("ltoa_rank_s")!=null){
						sb.append(rs.get("ltoa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ltoa_1h_mm_s")){
					if(rs.get("ltoa_1h_mm_s")!=null){
						sb.append(rs.get("ltoa_1h_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ltoa_1h_deg_s")){
					if(rs.get("ltoa_1h_deg_s")!=null){
						sb.append(rs.get("ltoa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("ltoa_1h_rank_s")){
					if(rs.get("ltoa_1h_rank_s")!=null){
						sb.append(rs.get("ltoa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("lboa_mm_s")){
					if(rs.get("lboa_mm_s")!=null){
						sb.append(rs.get("lboa_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("lboa_deg_s")){
					if(rs.get("lboa_deg_s")!=null){
						sb.append(rs.get("lboa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("lboa_rank_s")){
					if(rs.get("lboa_rank_s")!=null){
						sb.append(rs.get("lboa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("lboa_1h_mm_s")){
					if(rs.get("lboa_1h_mm_s")!=null){
						sb.append(rs.get("lboa_1h_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("lboa_1h_deg_s")){
					if(rs.get("lboa_1h_deg_s")!=null){
						sb.append(rs.get("lboa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("lboa_1h_rank_s")){
					if(rs.get("lboa_1h_rank_s")!=null){
						sb.append(rs.get("lboa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rtoa_mm_s")){
					if(rs.get("rtoa_mm_s")!=null){
						sb.append(rs.get("rtoa_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rtoa_deg_s")){
					if(rs.get("rtoa_deg_s")!=null){
						sb.append(rs.get("rtoa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rtoa_rank_s")){
					if(rs.get("rtoa_rank_s")!=null){
						sb.append(rs.get("rtoa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rtoa_1h_mm_s")){
					if(rs.get("rtoa_1h_mm_s")!=null){
						sb.append(rs.get("rtoa_1h_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rtoa_1h_deg_s")){
					if(rs.get("rtoa_1h_deg_s")!=null){
						sb.append(rs.get("rtoa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rtoa_1h_rank_s")){
					if(rs.get("rtoa_1h_rank_s")!=null){
						sb.append(rs.get("rtoa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rcoa_mm_s")){
					if(rs.get("rcoa_mm_s")!=null){
						sb.append(rs.get("rcoa_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rcoa_deg_s")){
					if(rs.get("rcoa_deg_s")!=null){
						sb.append(rs.get("rcoa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rcoa_rank_s")){
					if(rs.get("rcoa_rank_s")!=null){
						sb.append(rs.get("rcoa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rcoa_1h_mm_s")){
					if(rs.get("rcoa_1h_mm_s")!=null){
						sb.append(rs.get("rcoa_1h_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rcoa_1h_deg_s")){
					if(rs.get("rcoa_1h_deg_s")!=null){
						sb.append(rs.get("rcoa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rcoa_1h_rank_s")){
					if(rs.get("rcoa_1h_rank_s")!=null){
						sb.append(rs.get("rcoa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rboa_mm_s")){
					if(rs.get("rboa_mm_s")!=null){
						sb.append(rs.get("rboa_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rboa_deg_s")){
					if(rs.get("rboa_deg_s")!=null){
						sb.append(rs.get("rboa_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rboa_rank_s")){
					if(rs.get("rboa_rank_s")!=null){
						sb.append(rs.get("rboa_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rboa_1h_mm_s")){
					if(rs.get("rboa_1h_mm_s")!=null){
						sb.append(rs.get("rboa_1h_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rboa_1h_deg_s")){
					if(rs.get("rboa_1h_deg_s")!=null){
						sb.append(rs.get("rboa_1h_deg_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("rboa_1h_rank_s")){
					if(rs.get("rboa_1h_rank_s")!=null){
						sb.append(rs.get("rboa_1h_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("lt_bulging_mm_s")){
					if(rs.get("lt_bulging_mm_s")!=null){
						sb.append(rs.get("lt_bulging_mm_s").toString()).append(",");					
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
				if(rs.containsKey("lt_dent_mm_s")){
					if(rs.get("lt_dent_mm_s")!=null){
						sb.append(rs.get("lt_dent_mm_s").toString()).append(",");					
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
				if(rs.containsKey("lb_bulging_mm_s")){
					if(rs.get("lb_bulging_mm_s")!=null){
						sb.append(rs.get("lb_bulging_mm_s").toString()).append(",");					
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
				if(rs.containsKey("lb_dent_mm_s")){
					if(rs.get("lb_dent_mm_s")!=null){
						sb.append(rs.get("lb_dent_mm_s").toString()).append(",");					
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
				if(rs.containsKey("outsidediameter_mm_s")){
					if(rs.get("outsidediameter_mm_s")!=null){
						sb.append(rs.get("outsidediameter_mm_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("outsidediameter_rank_s")){
					if(rs.get("outsidediameter_rank_s")!=null){
						sb.append(rs.get("outsidediameter_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("upper_unbalance_g_s")){
					if(rs.get("upper_unbalance_g_s")!=null){
						sb.append(rs.get("upper_unbalance_g_s").toString()).append(",");					
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
						sb.append(rs.get("lower_unbalance_g_s").toString()).append(",");					
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
				if(rs.containsKey("static_unbalance_g_s")){
					if(rs.get("static_unbalance_g_s")!=null){
						sb.append(rs.get("static_unbalance_g_s").toString()).append(",");					
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
						sb.append(rs.get("couple_unbalance_g_s").toString()).append(",");					
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
				if(rs.containsKey("uplow_unbalance_g_s")){
					if(rs.get("uplow_unbalance_g_s")!=null){
						sb.append(rs.get("uplow_unbalance_g_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("uplow_unbalance_rank_s")){
					if(rs.get("uplow_unbalance_rank_s")!=null){
						sb.append(rs.get("uplow_unbalance_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("weight_s")){
					if(rs.get("weight_s")!=null){
						sb.append(rs.get("weight_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("weight_rank_s")){
					if(rs.get("weight_rank_s")!=null){
						sb.append(rs.get("weight_rank_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
			
				if(rs.containsKey("modelno_s")){
					if(rs.get("modelno_s")!=null){
						sb.append(rs.get("modelno_s").toString()).append(",");					
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("testmode_s")){
					if(rs.get("testmode_s")!=null){
						if(rs.get("testmode_s").toString().equals("0")){
							sb.append("正常测试").append(",");					
						}else{
							sb.append("精度测试").append(",");
						}
					}else{
						sb.append("").append(",");		
					}
				}
				if(rs.containsKey("created_by_s")){
					if(rs.get("created_by_s")!=null){
						sb.append(rs.get("created_by_s").toString()).append(",\t");					
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
