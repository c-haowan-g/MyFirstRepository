/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;














import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.entity.MixReportByDismantling;
import com.bluebirdme.mes.linglong.mix.service.MixReportByDismantlingServiceImpl;


/**
 * 密炼拆胶产量统计报表
 * @author 陈国强
 * @Date 2020-08-25 16:38:18
 */
@Log(code="密炼库存操作履历表",value="密炼库存操作履历表")
@RestController
@RequestMapping("mix/report/mixreportbydismantling")
public class MixReportByDismantlingController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixReportByDismantlingServiceImpl mixreportbydismantlingSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixreportbydismantlingSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixreportbydismantlingSrv;
	}
    
    @Log(code="密炼库存操作履历表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixreportbydismantlingSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value="查询列表", code="ALL", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagrid"})
    public String datagrid(Filter filter, Page page) throws Exception { 
    	filter.set("s_factory_s", LLWebUtils.factory());
      return GsonTools.toJson(getUDAService().datagridUDA(filter, page)); 
      }

    @NoLogin
    @Log(value="导出CSV", code="ZJ_JCGL_DPHJCLL_EXPORT_CSV")
    @RequestMapping({"exportCSV"})
    public String exportCSV(String s_factory_s, String start_time, String end_time, String prod_shift_code_s) throws Exception {
      Filter filter = new Filter();
      filter.setSort("t.atr_key");
      filter.setOrder("asc");
      filter.set("s_factory_s", s_factory_s).set("start_time", start_time).set("end_time", end_time)
        .set("prod_shift_code_s", prod_shift_code_s);

      System.out.println(filter);

      int batchQueryCount = 1000;
      Page page = new Page();
      page.setRows(batchQueryCount);
      page.setAll(0);
      List<Map<String, Object>> list = mixreportbydismantlingSrv.datagridRowsUDA(filter,page);
	  return toJson(list);
      /*int pageNum = 1;

      this.response.reset();

      this.response.setHeader("content-disposition", "attachment;filename=" + new String("计划执行情况分析报表.csv"
        .getBytes("GBK"), 
        "ISO-8859-1"));
      String title0 = "";

      String title = "生产班次,物料编码,物料名称,拆批人,总框数,总重量";
      StringBuffer sb = new StringBuffer();
      OutputStream writer = this.response.getOutputStream();
      writer.write(
        (System.getProperty("line.separator") + 
        title + System.getProperty("line.separator")).getBytes("GBK"));

      writer.flush();

      ConcurrentHashMap machine = new ConcurrentHashMap();
      try
      {
        while (true) {
          long t1 = System.currentTimeMillis();
          System.out.println("正在查询第" + pageNum++ + "页数据");
          page.setPage(1);

          List list = getService().datagridRows(filter, page, MixReportByDismantling.class);

          long t2 = System.currentTimeMillis();
          System.out.println("数据查询完成，耗时:" + (t2 - t1) + "ms");

          for (MixReportByDismantling rs : getService().datagridRows(filter, page, MixReportByDismantling.class)) {
            String prodshiftcode = null;
            if (rs.getProd_shift_code_s() != null) {
              if (rs.getProd_shift_code_s().toString().equals("302001"))
                prodshiftcode = "早班";
              else if (rs.getProd_shift_code_s().toString().equals("302002"))
                prodshiftcode = "中班";
              else if (rs.getProd_shift_code_s().toString().equals("302003")) {
                prodshiftcode = "晚班";
              }
            }

            sb = new StringBuffer();
            sb.append(prodshiftcode).append(",").append(rs.getMaterial_code_s()).append(",")
              .append(rs
              .getMaterial_name_s()).append(",").append(rs.getSpare6_s()).append(",")
              .append(rs
              .getFramenumber()).append(",").append(rs.getQtyleft()).append(",");
            writer.write(
              (sb.toString().replace("\n", " ").replace("\r", " ").replace("null", "") + 
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
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        writer.flush();
        writer.close();
      }*/
    }
}
