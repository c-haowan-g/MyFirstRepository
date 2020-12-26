/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import javax.annotation.Resource;



import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.MixProductReportServiceImpl;

import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

import org.xdemo.app.xutils.j2se.StringUtils;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.ConcurrentHashMap;

import com.bluebirdme.mes.linglong.mix.entity.MixProductReport;

import org.apache.poi.xssf.streaming.SXSSFRow;

/**
 * 密炼小料包产出实绩表
 * @author 陈国强
 * @Date 2020-08-22 15:45:47
 */
@Log(code="AT_MX_MM_RECIPEBAG_PROD",value="密炼小料包产出实绩表")
@RestController
@RequestMapping("mix/report/mixproductreport/mixproductreport")
public class MixProductReportController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixProductReportServiceImpl mixproductreportSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixproductreportSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixproductreportSrv;
	}
    
    @Log(code="AT_MX_MM_RECIPEBAG_PROD_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixproductreportSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(value="查询列表", code="ALL", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagrid"})
    public String datagrid(Filter filter, Page page) throws Exception {
    	filter.set("s_factory_s", LLWebUtils.factory());
      return GsonTools.toJson(getUDAService().datagridUDA(filter, page)); } 
    
    @Log(value="查询列表", code="ALL", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagrid2"})
    public String datagrid2(Filter filter, Page page) throws Exception {
    	filter.set("s_factory_s", LLWebUtils.factory());
      return GsonTools.toJson(mixproductreportSrv.datagridUDA3(filter, page)); } 
    
    @Log(value="查询列表", code="ALL", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagrid3"})
    public String datagrid3(Filter filter, Page page) throws Exception {
      filter.set("s_factory_s", LLWebUtils.factory());
      return GsonTools.toJson(mixproductreportSrv.datagridUDAhis(filter, page));
    }
    @NoLogin
    @Log(value="导出CSV", code="OUTPUT_EXPORT_CSV")
    @RequestMapping({"exportCSV"})
    public String exportCSV(String s_factory_s, String start_time, String end_time, String shift_code_s, String equip_code_s) throws Exception { Filter filter = new Filter();
      filter.setSort("t.atr_key");
      filter.setOrder("asc");
      if ((!StringUtils.isEmpty(shift_code_s)) && (!StringUtils.isEmpty(equip_code_s))) {
        filter.set("shift_code_s", shift_code_s)
          .set("equip_code_s", equip_code_s)
          .set("start_time", start_time)
          .set("end_time", end_time);
      }
      else if ((!StringUtils.isEmpty(shift_code_s)) && (StringUtils.isEmpty(equip_code_s))) {
        filter.set("shift_code_s", shift_code_s)
          .set("equip_code_s", "")
          .set("start_time", start_time)
          .set("end_time", end_time);
      }
      else if ((StringUtils.isEmpty(shift_code_s)) && (!StringUtils.isEmpty(equip_code_s))) {
        filter.set("shift_code_s", "")
          .set("equip_code_s", equip_code_s)
          .set("start_time", start_time)
          .set("end_time", end_time);
      }
      else if ((StringUtils.isEmpty(shift_code_s)) && (StringUtils.isEmpty(equip_code_s))) {
        filter.set("shift_code_s", "")
          .set("equip_code_s", "")
          .set("start_time", start_time)
          .set("end_time", end_time);
      }

      System.out.println(filter);

      int batchQueryCount = 1000;

      Page page = new Page();
      page.setRows(batchQueryCount);
      page.setAll(0);
      List<Map<String, Object>> list = mixproductreportSrv.datagridRowsUDAhis(filter,page);
	  return toJson(list);

      /*int pageNum = 1;

      this.response.reset();

      this.response.setHeader("content-disposition", "attachment;filename=" + new String("密炼产量报表.csv"
        .getBytes("GBK"), 
        "ISO-8859-1"));

      String title = "生产时间,班次,班组,机台名称,物料名称,主机手,总车数,总重量,配方类型";

      StringBuffer sb = new StringBuffer();
      OutputStream writer = this.response.getOutputStream();
      writer.write((title + System.getProperty("line.separator")).getBytes("GBK"));

      writer.flush();

      ConcurrentHashMap machine = new ConcurrentHashMap();
      try
      {
        while (true) {
          long t1 = System.currentTimeMillis();
          System.out.println("正在查询第" + pageNum++ + "页数据");
          page.setPage(1);
          List list = getService().datagridRows(filter, page, MixProductReport.class);
          long t2 = System.currentTimeMillis();
          System.out.println("数据查询完成，耗时:" + (t2 - t1) + "ms");

          for (MixProductReport rs : getService().datagridRows(filter, page, MixProductReport.class))
          {
            sb = new StringBuffer();
            sb.append(rs.getProduct_time_t()).append(",").append(shiftCode(rs.getShift_code_s())).append(",").append(GroupCode(rs.getGroup_code_s())).append(",").append(rs.getEquip_name_s()).append(",").append(rs.getMaterial_name_s()).append(",").append(rs.getCreated_name_s()).append(",").append(rs.getTrainCount()).append(",").append(rs.getTotalWeight()).append(",\t").append(rs.getRecipe_code_name_s());
            writer.write((sb.toString().replace("\n", " ").replace("\r", " ").replace("null", "") + System.getProperty("line.separator")).getBytes("GBK"));
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
      }
    }

    public String shiftCode(String shift_code_s)
    {
      if ("302001".equals(shift_code_s))
        shift_code_s = "早班";
      else if ("302002".equals(shift_code_s))
        shift_code_s = "中班";
      else if ("302003".equals(shift_code_s)) {
        shift_code_s = "晚班";
      }
      return shift_code_s;
    }

    public String GroupCode(String group_code_s)
    {
      if ("301001".equals(group_code_s))
        group_code_s = "甲班";
      else if ("301002".equals(group_code_s))
        group_code_s = "乙班";
      else if ("301003".equals(group_code_s)) {
        group_code_s = "丙班";
      }
      return group_code_s;
    }

    void writeRow(SXSSFRow row, Object[] values)
    {
      int i = 0;
      for (Object v : values) {
        if (v == null) {
          v = "";
        }
        row.createCell(i++).setCellValue(v + "");
      }*/
    }
}
