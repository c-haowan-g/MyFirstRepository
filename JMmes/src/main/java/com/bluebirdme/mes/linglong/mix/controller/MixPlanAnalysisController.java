/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;
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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.mix.entity.MixPlanAnalysis;
import com.bluebirdme.mes.linglong.mix.service.MixPlanAnalysisServiceImpl;
//import com.bluebirdme.mes.linglong.mix.entity.dto.MixPlanAnalysisDTO;

/**
 * 计划库存分析报表_密炼日计划表
 * @author mengh
 * @Date 2020-02-17 11:10:21
 */
@Log(code="MixPlanAnalysis_Log",value="计划库存分析报表_密炼日计划表_日志")
@RestController
@RequestMapping("mix/report/mixplananalysis")
public class MixPlanAnalysisController extends RockWellFunctionalController<MixPlanAnalysis> {
    
    @Resource MixPlanAnalysisServiceImpl mixplananalysisSrv;

    @Override
    protected RockWellBaseServiceImpl<MixPlanAnalysis> getService() {
        return mixplananalysisSrv;
    }
    
    
   /* @Log(code="MixPlanAnalysis_Log_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody MixPlanAnalysisDTO mixplananalysis ) throws Exception {
        mixplananalysisSrv.saveChanges(mixplananalysis);
        return Response.suc();
    }
    */
    @NoLogin
    @Log(value = "导出CSV", code = "ZJ_JCGL_DPHJCLL_EXPORT_CSV")
    @RequestMapping("exportCSV")
    public void exportCSV(String s_factory_s,String plan_date_s,String equip_code_s,String material_code_s,String material_name_s) throws Exception{
        Filter filter=new Filter();
        filter.setSort("t.atr_key");
        filter.setOrder("asc");
            filter.set("s_factory_s", s_factory_s)
                    .set("plan_date_s", plan_date_s)
                    .set("equip_code_s",equip_code_s)
                    .set("material_code_s",material_code_s)
                    .set("material_name_s",material_name_s);
                    
        System.out.println(filter);
        // 每次查询2000条导入
        int batchQueryCount = 1000;
        Page page = new Page();
        page.setRows(batchQueryCount);
        page.setAll(0);

        int pageNum = 1;

        response.reset();

        response.setHeader("content-disposition", "attachment;filename="
                + new String("计划执行情况分析报表.csv".getBytes("GBK"), "ISO-8859-1"));
        String title0=",,,,,,早班,早班,早班,中班,中班,中班,晚班,晚班,晚班";

        String title="机台条码,物料编码,物料名称,日计划量,日完成量,日完成率/%,计划量,完成量,完成率/%,计划量,完成量,完成率/%,计划量,完成量,完成率/%";
        StringBuffer sb=new StringBuffer();
        OutputStream writer = response.getOutputStream();
        writer.write((title0+System.getProperty("line.separator")+title+System.getProperty("line.separator")).getBytes("GBK"));//
        //缓冲输出到客户端，浏览器将立即开始下载，提高用户体验
        writer.flush();

        ConcurrentHashMap<String, String> machine=new ConcurrentHashMap<String,String>();
        try {
            while (true) {
                // 分页查询数据
                long t1=System.currentTimeMillis();
                System.out.println("正在查询第" + (pageNum++) + "页数据");
                page.setPage(1);
//                List<MixMonthlyReport> list = getService().datagridRows(filter, page, MixMonthlyReport.class);
                List <MixPlanAnalysis> list = getService().datagridRows(filter, page, MixPlanAnalysis.class);		
//                filter.set("atr_key", list.get(list.size()-1).getAtr_key());
                long t2=System.currentTimeMillis();
                System.out.println("数据查询完成，耗时:"+(t2-t1)+"ms");

                for(MixPlanAnalysis rs : list){
                    sb=new StringBuffer();                 
                    sb.append(rs.getEquip_name_s()).append(",")
                    .append(rs.getMaterial_code_s()).append(",")
                    .append(rs.getMaterial_name_s()).append(",")
                    .append(rs.getQty_plan_i()).append(",")
                    .append(rs.getPlay_complete()).append(",")
                    .append(rs.getPlay_completion()).append(",")
                    .append(rs.getQty_mor_i()).append(",")
                    .append(rs.getQty_complete_mor_i()).append(",")
                    .append(rs.getQty_completion_mor_i()).append(",")
                    .append(rs.getQty_mid_i()).append(",")
                    .append(rs.getQty_complete_mid_i()).append(",")
                    .append(rs.getQty_completion_mid_i()).append(",")
                    .append(rs.getQty_nig_i()).append(",")
                    .append(rs.getQty_complete_nig_i()).append(",")
                    .append(rs.getQty_completion_nig_i()).append(",");
                    writer.write((sb.toString().replace("\n", " ").replace("\r", " ").replace("null", "") +System.getProperty("line.separator")).getBytes("GBK"));
                    writer.flush();
                }


              /*  for (MixMonthlyReport rs : list) {
                    sb=new StringBuffer();
                    sb.append(rs.getEQUIP_NAME_S()).append(",").append( rs.getMASTER_NAME_S()).append(",").append( rs.getCuringspeccode_s()).append(",").append(rs.getMaterialdesc_s()).append(",\t").append(rs.getOutputtime_t()).append(",").append(rs.getBuildinmachinecode_s()).append(",").append(rs.getCuringmachinecode_s()).append(",").append( rs.getTire_total_ratings_s()).append(",").append(rs.getBalancetotal_rank_s()).append(",").append( rs.getRototal_rank_s()).append(",").append( rs.getUfm_totalrank_s()).append(",").append(rs.getCw_rfvoa_kgf_s()).append(",").append( rs.getCw_rfvoa_deg_s()).append(",").append( rs.getCw_rfvoa_rank_s()).append(",").append(rs.getCw_rfvoa_1h_kgf_s()).append(",").append( rs.getCw_rfvoa_1h_deg_s()).append(",").append( rs.getCw_rfvoa_1h_rank_s()).append(",").append(rs.getCw_rfvoa_2h_kgf_s()).append(",").append( rs.getCw_rfvoa_2h_deg_s()).append(",").append( rs.getCw_rfvoa_2h_rank_s()).append(",").append(rs.getCw_rfvoa_3h_kgf_s()).append(",").append( rs.getCw_rfvoa_3h_deg_s()).append(",").append( rs.getCw_rfvoa_3h_rank_s()).append(",").append(rs.getCw_rfvoa_4h_kgf_s()).append(",").append( rs.getCw_rfvoa_4h_deg_s()).append(",").append( rs.getCw_rfvoa_4h_rank_s()).append(",").append(rs.getCw_rfvoa_5h_kgf_s()).append(",").append( rs.getCw_rfvoa_5h_deg_s()).append(",").append( rs.getCw_rfvoa_5h_rank_s()).append(",").append(rs.getCw_rfvoa_6h_kgf_s()).append(",").append( rs.getCw_rfvoa_6h_deg_s()).append(",").append( rs.getCw_rfvoa_6h_rank_s()).append(",").append(rs.getCw_rfvoa_7h_kgf_s()).append(",").append( rs.getCw_rfvoa_7h_deg_s()).append(",").append( rs.getCw_rfvoa_7h_rank_s()).append(",").append(rs.getCw_rfvoa_8h_kgf_s()).append(",").append( rs.getCw_rfvoa_8h_deg_s()).append(",").append( rs.getCw_rfvoa_8h_rank_s()).append(",").append(rs.getCw_rfvoa_9h_kgf_s()).append(",").append( rs.getCw_rfvoa_9h_deg_s()).append(",").append( rs.getCw_rfvoa_9h_rank_s()).append(",").append(rs.getCw_rfvoa_10h_kgf_s()).append(",").append( rs.getCw_rfvoa_10h_deg_s()).append(",").append( rs.getCw_rfvoa_10h_rank_s()).append(",").append(rs.getCw_lfvoa_kgf_s()).append(",").append( rs.getCw_lfvoa_deg_s()).append(",").append( rs.getCw_lfvoa_rank_s()).append(",").append(rs.getCw_lfvoa_1h_kgf_s()).append(",").append( rs.getCw_lfvoa_1h_deg_s()).append(",").append( rs.getCw_lfvoa_1h_rank_s()).append(",").append(rs.getCw_lfvoa_2h_kgf_s()).append(",").append( rs.getCw_lfvoa_2h_deg_s()).append(",").append( rs.getCw_lfvoa_2h_rank_s()).append(",").append(rs.getCw_lfvoa_3h_kgf_s()).append(",").append( rs.getCw_lfvoa_3h_deg_s()).append(",").append( rs.getCw_lfvoa_3h_rank_s()).append(",").append(rs.getCw_lfvoa_4h_kgf_s()).append(",").append( rs.getCw_lfvoa_4h_deg_s()).append(",").append( rs.getCw_lfvoa_4h_rank_s()).append(",").append(rs.getCw_lfvoa_5h_kgf_s()).append(",").append( rs.getCw_lfvoa_5h_deg_s()).append(",").append( rs.getCw_lfvoa_5h_rank_s()).append(",").append(rs.getCw_lfvoa_6h_kgf_s()).append(",").append( rs.getCw_lfvoa_6h_deg_s()).append(",").append( rs.getCw_lfvoa_6h_rank_s()).append(",").append(rs.getCw_lfvoa_7h_kgf_s()).append(",").append( rs.getCw_lfvoa_7h_deg_s()).append(",").append( rs.getCw_lfvoa_7h_rank_s()).append(",").append(rs.getCw_lfvoa_8h_kgf_s()).append(",").append( rs.getCw_lfvoa_8h_deg_s()).append(",").append( rs.getCw_lfvoa_8h_rank_s()).append(",").append(rs.getCw_lfvoa_9h_kgf_s()).append(",").append( rs.getCw_lfvoa_9h_deg_s()).append(",").append( rs.getCw_lfvoa_9h_rank_s()).append(",").append(rs.getCw_lfvoa_10h_kgf_s()).append(",").append( rs.getCw_lfvoa_10h_deg_s()).append(",").append( rs.getCw_lfvoa_10h_rank_s()).append(",").append(rs.getCw_lfd_kgf_s()).append(",").append( rs.getCw_lfd_rank_s()).append(",").append( rs.getCcw_rfvoa_kgf_s()).append(",").append(rs.getCcw_rfvoa_deg_s()).append(",").append( rs.getCcw_rfvoa_rank_s()).append(",").append( rs.getCcw_rfvoa_1h_kgf_s()).append(",").append(rs.getCcw_rfvoa_1h_deg_s()).append(",").append( rs.getCcw_rfvoa_1h_rank_s()).append(",").append( rs.getCcw_rfvoa_2h_kgf_s()).append(",").append(rs.getCcw_rfvoa_2h_deg_s()).append(",").append( rs.getCcw_rfvoa_2h_rank_s()).append(",").append( rs.getCcw_rfvoa_3h_kgf_s()).append(",").append(rs.getCcw_rfvoa_3h_deg_s()).append(",").append( rs.getCcw_rfvoa_3h_rank_s()).append(",").append( rs.getCcw_rfvoa_4h_kgf_s()).append(",").append(rs.getCcw_rfvoa_4h_deg_s()).append(",").append( rs.getCcw_rfvoa_4h_rank_s()).append(",").append( rs.getCcw_rfvoa_5h_kgf_s()).append(",").append(rs.getCcw_rfvoa_5h_deg_s()).append(",").append( rs.getCcw_rfvoa_5h_rank_s()).append(",").append( rs.getCcw_rfvoa_6h_kgf_s()).append(",").append(rs.getCcw_rfvoa_6h_deg_s()).append(",").append( rs.getCcw_rfvoa_6h_rank_s()).append(",").append( rs.getCcw_rfvoa_7h_kgf_s()).append(",").append(rs.getCcw_rfvoa_7h_deg_s()).append(",").append( rs.getCcw_rfvoa_7h_rank_s()).append(",").append( rs.getCcw_rfvoa_8h_kgf_s()).append(",").append(rs.getCcw_rfvoa_8h_deg_s()).append(",").append( rs.getCcw_rfvoa_8h_rank_s()).append(",").append( rs.getCcw_rfvoa_9h_kgf_s()).append(",").append(rs.getCcw_rfvoa_9h_deg_s()).append(",").append( rs.getCcw_rfvoa_9h_rank_s()).append(",").append( rs.getCcw_rfvoa_10h_kgf_s()).append(",").append(rs.getCcw_rfvoa_10h_deg_s()).append(",").append( rs.getCcw_rfvoa_10h_rank_s()).append(",").append( rs.getCcw_lfvoa_kgf_s()).append(",").append(rs.getCcw_lfvoa_deg_s()).append(",").append( rs.getCcw_lfvoa_rank_s()).append(",").append( rs.getCcw_lfvoa_1h_kgf_s()).append(",").append(rs.getCcw_lfvoa_1h_deg_s()).append(",").append( rs.getCcw_lfvoa_1h_rank_s()).append(",").append( rs.getCcw_lfvoa_2h_kgf_s()).append(",").append(rs.getCcw_lfvoa_2h_deg_s()).append(",").append( rs.getCcw_lfvoa_2h_rank_s()).append(",").append( rs.getCcw_lfvoa_3h_kgf_s()).append(",").append(rs.getCcw_lfvoa_3h_deg_s()).append(",").append( rs.getCcw_lfvoa_3h_rank_s()).append(",").append( rs.getCcw_lfvoa_4h_kgf_s()).append(",").append(rs.getCcw_lfvoa_4h_deg_s()).append(",").append( rs.getCcw_lfvoa_4h_rank_s()).append(",").append( rs.getCcw_lfvoa_5h_kgf_s()).append(",").append(rs.getCcw_lfvoa_5h_deg_s()).append(",").append( rs.getCcw_lfvoa_5h_rank_s()).append(",").append( rs.getCcw_lfvoa_6h_kgf_s()).append(",").append(rs.getCcw_lfvoa_6h_deg_s()).append(",").append( rs.getCcw_lfvoa_6h_rank_s()).append(",").append( rs.getCcw_lfvoa_7h_kgf_s()).append(",").append(rs.getCcw_lfvoa_7h_deg_s()).append(",").append( rs.getCcw_lfvoa_7h_rank_s()).append(",").append( rs.getCcw_lfvoa_8h_kgf_s()).append(",").append(rs.getCcw_lfvoa_8h_deg_s()).append(",").append( rs.getCcw_lfvoa_8h_rank_s()).append(",").append( rs.getCcw_lfvoa_9h_kgf_s()).append(",").append(rs.getCcw_lfvoa_9h_deg_s()).append(",").append( rs.getCcw_lfvoa_9h_rank_s()).append(",").append( rs.getCcw_lfvoa_10h_kgf_s()).append(",").append(rs.getCcw_lfvoa_10h_deg_s()).append(",").append( rs.getCcw_lfvoa_10h_rank_s()).append(",").append( rs.getCcw_lfd_kgf_s()).append(",").append(rs.getCcw_lfd_rank_s()).append(",").append( rs.getCon_kgf_s()).append(",").append( rs.getCon_rank_s()).append(",").append( rs.getPly_kgf_s()).append(",").append(rs.getPly_rank_s()).append(",").append( rs.getLtoa_mm_s()).append(",").append( rs.getLtoa_deg_s()).append(",").append( rs.getLtoa_rank_s()).append(",").append(rs.getLtoa_1h_mm_s()).append(",").append( rs.getLtoa_1h_deg_s()).append(",").append( rs.getLtoa_1h_rank_s()).append(",").append( rs.getLboa_mm_s()).append(",").append(rs.getLboa_deg_s()).append(",").append( rs.getLboa_rank_s()).append(",").append( rs.getLboa_1h_mm_s()).append(",").append( rs.getLboa_1h_deg_s()).append(",").append(rs.getLboa_1h_rank_s()).append(",").append( rs.getRtoa_mm_s()).append(",").append( rs.getRtoa_deg_s()).append(",").append( rs.getRtoa_rank_s()).append(",").append(rs.getRtoa_1h_mm_s()).append(",").append( rs.getRtoa_1h_deg_s()).append(",").append( rs.getRtoa_1h_rank_s()).append(",").append( rs.getRcoa_mm_s()).append(",").append(rs.getRcoa_deg_s()).append(",").append( rs.getRcoa_rank_s()).append(",").append( rs.getRcoa_1h_mm_s()).append(",").append( rs.getRcoa_1h_deg_s()).append(",").append(rs.getRcoa_1h_rank_s()).append(",").append( rs.getRboa_mm_s()).append(",").append( rs.getRboa_deg_s()).append(",").append( rs.getRboa_rank_s()).append(",").append(rs.getRboa_1h_mm_s()).append(",").append( rs.getRboa_1h_deg_s()).append(",").append( rs.getRboa_1h_rank_s()).append(",").append(rs.getLt_bulging_mm_s()).append(",").append( rs.getLt_bulging_deg_s()).append(",").append( rs.getLt_bulging_rank_s()).append(",").append(rs.getLt_dent_mm_s()).append(",").append( rs.getLt_dent_deg_s()).append(",").append( rs.getLt_dent_rank_s()).append(",").append(rs.getLb_bulging_mm_s()).append(",").append( rs.getLb_bulging_deg_s()).append(",").append( rs.getLb_bulging_rank_s()).append(",").append(rs.getLb_dent_mm_s()).append(",").append( rs.getLb_dent_deg_s()).append(",").append( rs.getLb_dent_rank_s()).append(",").append(rs.getOutsidediameter_mm_s()).append(",").append( rs.getOutsidediameter_rank_s()).append(",").append(rs.getUpper_unbalance_g_s()).append(",").append( rs.getUpper_unbalance_deg_s()).append(",").append(rs.getUpper_unbalance_rank_s()).append(",").append( rs.getLower_unbalance_g_s()).append(",").append(rs.getLower_unbalance_deg_s()).append(",").append( rs.getLower_unbalance_rank_s()).append(",").append(rs.getStatic_unbalance_g_s()).append(",").append( rs.getStatic_unbalance_deg_s()).append(",").append(rs.getStatic_unbalance_rank_s()).append(",").append( rs.getCouple_unbalance_g_s()).append(",").append(rs.getCouple_unbalance_deg_s()).append(",").append(rs.getCouple_unbalance_rank_s()).append(",").append(rs.getUplow_unbalance_g_s()).append(",").append(rs.getUplow_unbalance_rank_s()).append(",").append( rs.getWeight_s()).append(",").append( rs.getWeight_rank_s()).append(",").append(rs.getLoad_s()).append(",").append( rs.getModelno_s()).append(",").append( rs.getTestmode_s()).append(",").append( rs.getChanged_by_s()).append(",\t").append(rs.getChanged_time_t()).append(",").append( rs.getCreated_by_s()).append(",\t").append( rs.getCreated_time_t());
                    writer.write((sb.toString().replace("\n", " ").replace("\r", " ").replace("null", "") +System.getProperty("line.separator")).getBytes("GBK"));
                    writer.flush();
                }*/
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

    

}
