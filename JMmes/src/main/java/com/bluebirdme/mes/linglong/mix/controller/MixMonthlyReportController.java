/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.annotations.NoLogin;

import java.io.OutputStream;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

import com.bluebirdme.mes.linglong.mix.entity.MixMonthlyReport;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.MixMonthlyReportServiceImpl;

import org.xdemo.app.xutils.ext.GsonTools;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 密炼月产量表
 * @author 陈国强
 * @Date 2020-08-21 08:25:16
 */
@Log(code="AT_MX_RP_MONTHPROD",value="密炼月产量表")
@RestController
@RequestMapping("mix/report/mixmonthlyreport/mixmonthlyreport")
public class MixMonthlyReportController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixMonthlyReportServiceImpl mixmonthlyreportSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixmonthlyreportSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixmonthlyreportSrv;
	}
    
    @Log(code="AT_MX_RP_MONTHPROD_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        mixmonthlyreportSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(code="getAll", value="Mix月报表查询")
    @RequestMapping({"getAll"})
    public String getAll(Filter filter) throws Exception {
      return GsonTools.toJson(this.mixmonthlyreportSrv.getAll(filter));
    }
    @Log(value="查询列表", code="ALL", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagrid"})
    public String datagrid(Filter filter, Page page) throws Exception { 
    	filter.set("s_factory_s", LLWebUtils.factory());
      return GsonTools.toJson(getUDAService().datagridUDA(filter, page)); }

    @RequestMapping({"getmasternamelist"})
    public String getmasternamelist(String begindate)
      throws Exception
    {
      List getmasternamelist = this.mixmonthlyreportSrv.getmasternamelist(begindate);
      return toJson(getmasternamelist);
    }
    @RequestMapping({"getmaterialspeclist"})
    public String getmaterialspeclist(String begindate)
      throws Exception
    {
      List getmaterialspeclist = this.mixmonthlyreportSrv.getmaterialspeclist(begindate);
      return toJson(getmaterialspeclist);
    }
    @RequestMapping({"getMixProductionInfo"})
    public String getMixProductionInfo(String plantype) throws Exception
    {
      List list = this.mixmonthlyreportSrv.getMixProductionInfo(plantype);
      return toJson(list);
    }
    @RequestMapping({"getRfidByPlinename"})
    public String getRfidByPlinename() throws Exception
    {
      List list = this.mixmonthlyreportSrv.getRfidByPlinename();
      return toJson(list);
    }
    @RequestMapping({"getMixXLProductionInfo"})
    public String getMixXLProductionInfo() throws Exception
    {
      List list = this.mixmonthlyreportSrv.getMixXLProductionInfo();
      return toJson(list);
    }
    @NoLogin
    @Log(value="导出CSV", code="ZJ_JCGL_DPHJCLL_EXPORT_CSV")
    @RequestMapping({"exportCSV"})
    public String exportCSV(String s_factory_s, String month_s, String equip_code_s, String master_name_s, String materialspec_s, String materialcode_s) throws Exception {
      Filter filter = new Filter();
      filter.setSort("t.atr_key");
      filter.setOrder("asc");
      filter.set("s_factory_s", s_factory_s).set("month_s", month_s).set("equip_code_s", equip_code_s).set("master_name_s", master_name_s).set("materialspec_s", materialspec_s).set("materialcode_s", materialcode_s);
      String month = filter.get("month_s").toString();
      String monthReal = month.replace("-", "");
      filter.set("month_s", monthReal);

      System.out.println(filter);
      
      int batchQueryCount = 1000;
      Page page = new Page();
      page.setRows(batchQueryCount);
      page.setAll(0);
      List<Map<String, Object>> list = mixmonthlyreportSrv.datagridRowsUDA(filter,page);
	  return toJson(list);
      /*int pageNum = 1;

      this.response.reset();

      this.response.setHeader("content-disposition", "attachment;filename=" + new String("月报表.csv"
        .getBytes("GBK"), 
        "ISO-8859-1"));
      String title0 = "基本信息,基本信息,基本信息,基本信息,1号,1号,2号,2号,3号,3号,4号,4号,5号,5号,6号,6号,7号,7号,8号,8号,9号,9号,10号,10号,11号,11号,12号,12号,13号,13号,14号,14号,15号,15号,16号,16号,17号,17号,18号,18号,19号,19号,20号,20号,21号,21号,22号,22号,23号,23号,24号,24号,25号,25号,26号,26号,27号,27号,28号,28号,29号,29号,30号,30号,31号,31号,合计,合计";

      String title = "机台条码,主机手,物料名称,物料编码,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,车数,重量,总车数,总重量";
      StringBuffer sb = new StringBuffer();
      OutputStream writer = this.response.getOutputStream();
      writer.write((title0 + System.getProperty("line.separator") + title + System.getProperty("line.separator"))
        .getBytes("GBK"));

      writer.flush();
      ConcurrentHashMap machine = new ConcurrentHashMap();
      int num = 1;
      try
      {
        while (true) {
          long t1 = System.currentTimeMillis();
          System.out.println("正在查询第" + pageNum++ + "页数据");
          page.setPage(num);
          List<Object> list = new ArrayList<Object>();
          List<Object> mapl = new ArrayList<Object>();
          List<Map<String, Object>>map = getUDAService().datagridRowsUDA(filter, page);
          for (Map<String, Object> m : map)
          {
            for (String k : m.keySet())
            {
               mapl.add(m.get(k));
               
            }
          }
          list.add(mapl);
          List <MixMonthlyReport> list = getService().datagridRows(filter, page, MixMonthlyReport.class);
          num++;
          long t2 = System.currentTimeMillis();
          System.out.println("数据查询完成，耗时:" + (t2 - t1) + "ms");

          for (int i = 0; i < list.size(); i++) {
        	  System.out.println(list.size());
            sb = new StringBuffer();
            MixMonthlyReport hash = (MixMonthlyReport)list.get(i);
            sb.append(hash.getEquip_name_s()).append(",").append(hash.getMaster_name_s()).append(",")
              .append(hash
              .getMaterialspec_s()).append(",").append(hash.getMaterialcode_s()).append(",")
              .append(hash
              .getOneday_train_i()).append(",").append(hash.getOneday_weight_d()).append(",")
              .append(hash
              .getTwoday_train_i()).append(",").append(hash.getTwoday_weight_d())
              .append(",")
              .append(hash
              .getThreeday_train_i()).append(",").append(hash.getThreeday_weight_d())
              .append(",")
              .append(hash.getFourday_train_i()).append(",")
              .append(hash
              .getFourday_weight_d()).append(",").append(hash.getFiveday_train_i())
              .append(",")
              .append(hash.getFiveday_weight_d()).append(",")
              .append(hash
              .getSixday_train_i()).append(",").append(hash.getSixday_weight_d())
              .append(",")
              .append(hash.getSevenday_train_i()).append(",")
              .append(hash
              .getSevenday_weight_d()).append(",").append(hash.getEightday_train_i())
              .append(",")
              .append(hash.getEightday_weight_d()).append(",")
              .append(hash
              .getNineday_train_i()).append(",").append(hash.getNineday_weight_d())
              .append(",")
              .append(hash.getTenday_train_i()).append(",")
              .append(hash
              .getTenday_weight_d()).append(",").append(hash.getElevenday_train_i())
              .append(",")
              .append(hash.getElevenday_weight_d()).append(",")
              .append(hash
              .getTwelvenday_train_i()).append(",").append(hash.getTwelvenday_weight_d())
              .append(",")
              .append(hash.getThirteenday_train_i()).append(",")
              .append(hash
              .getThirteenday_weight_d()).append(",")
              .append(hash
              .getFourteenday_train_i()).append(",")
              .append(hash
              .getFourteenday_weight_d()).append(",").append(hash.getFifteenday_train_i())
              .append(",")
              .append(hash.getFifteenday_weight_d()).append(",")
              .append(hash
              .getSixteenday_train_i()).append(",").append(hash.getSixteenday_weight_d())
              .append(",")
              .append(hash.getSeventeenday_train_i()).append(",")
              .append(hash
              .getSeventeenday_weight_d()).append(",")
              .append(hash
              .getEighteenday_train_i()).append(",")
              .append(hash
              .getEighteenday_weight_d()).append(",").append(hash.getNinteenday_train_i())
              .append(",")
              .append(hash.getNinteenday_weight_d()).append(",")
              .append(hash
              .getTwentyday_train_i()).append(",").append(hash.getTwentyday_weight_d())
              .append(",")
              .append(hash.getTwentyoneday_train_i()).append(",")
              .append(hash
              .getTwentyoneday_weight_d()).append(",")
              .append(hash
              .getTwentytwoday_train_i()).append(",")
              .append(hash
              .getTwentytwoday_weight_d()).append(",")
              .append(hash
              .getTwentythreeday_train_i()).append(",")
              .append(hash
              .getTwentythreeday_weight_d()).append(",")
              .append(hash
              .getTwentyfourday_train_i()).append(",")
              .append(hash
              .getTwentyfourday_weight_d()).append(",")
              .append(hash
              .getTwentyfiveday_train_i()).append(",")
              .append(hash
              .getTwentyfiveday_weight_d()).append(",")
              .append(hash
              .getTwentysixday_train_i()).append(",")
              .append(hash
              .getTwentysixday_weight_d()).append(",")
              .append(hash
              .getTwentysevenday_train_i()).append(",")
              .append(hash
              .getTwentysevenday_weight_d()).append(",")
              .append(hash
              .getTwentyeightday_train_i()).append(",")
              .append(hash
              .getTwentyeightday_weight_d()).append(",")
              .append(hash
              .getTwentynineday_train_i()).append(",")
              .append(hash
              .getTwentynineday_weight_d()).append(",")
              .append(hash
              .getThirtyday_train_i()).append(",").append(hash.getThirtyday_weight_d())
              .append(",")
              .append(hash.getThirtyoneday_train_i()).append(",")
              .append(hash
              .getThirtyoneday_weight_d()).append(",").append(hash.getTotal_train_i())
              .append(",")
              .append(hash.getTotal_weight_d()).append(",");
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
