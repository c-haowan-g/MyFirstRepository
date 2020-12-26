 package com.bluebirdme.mes.linglong.common.controller;
 
 import com.bluebirdme.core.system.annotations.Log;
 import com.bluebirdme.core.system.annotations.NoLogin;
 import com.bluebirdme.core.system.spring.SpringContext;
 import com.bluebirdme.core.system.web.Filter;
 import com.bluebirdme.core.system.web.Page;
 import com.bluebirdme.mes.linglong.common.entity.QuickCheck;
 import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
 import com.bluebirdme.mes.linglong.common.service.QuickCheckServiceImpl;
 import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
 import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
 import java.util.List;
 import java.util.Map;
 import javax.annotation.Resource;
 import javax.servlet.ServletOutputStream;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.bind.annotation.RestController;
 import org.xdemo.app.xutils.j2se.StringUtils;

 @NoLogin
 @RestController
 @RequestMapping({"/common/quickcheck"})
 public class QuickCheckController
   extends RockWellFunctionalController<QuickCheck>
 {
   @Resource
   QuickCheckServiceImpl quickCheckServiceImpl;
   
   protected RockWellBaseServiceImpl<QuickCheck> getService() {
     return (RockWellBaseServiceImpl<QuickCheck>)this.quickCheckServiceImpl;
   }
   public ExportServiceImpl exportServiceImpl = (ExportServiceImpl)SpringContext.getBean(
       StringUtils.firstCharToLowerCase("exportServiceImpl"));
 
   
   @ResponseBody
   @RequestMapping({"filter"})
   public String filter(Filter filter, Page page, Class clazz) throws Exception {
     Map<String, Object> result = this.quickCheckServiceImpl.filter(filter, page, QuickCheck.class);
     return toJson(result);
   }
 
 
 
 
 
   
   @RequestMapping({"kjqx"})
   public String kjqx(@RequestBody Map<String, Object> list_map) {
     List<Map<String, Object>> listDate = this.quickCheckServiceImpl.kjqx(list_map);
     return toJson(listDate);
   }
 
   
   @NoLogin
   @Log(value = "导出CSV", code = "COMMON_QUICKCHECK_EXPORT_CSV")
   @RequestMapping({"exportCSV"})
   public void exportCSV(String s_factory_s, String start_time_t, String end_time_t, String material_code_s, String material_name_s, String quickcheck_recipe_code_s) throws Exception {
     int batchQueryCount = 1000;
     Filter filter = new Filter();
     filter.setSort("t.atr_key");
     filter.setOrder("asc");
     filter.set("s_factory_s", s_factory_s)
       .set("material_code_s", material_code_s)
       .set("material_name_s", material_name_s)
       .set("quickcheck_recipe_code_s", quickcheck_recipe_code_s)
       .set("start_time_t", start_time_t)
       .set("end_time_t", end_time_t);
     System.out.println(filter);
     
     Page page = new Page();
     page.setRows(batchQueryCount);
     page.setAll(0);
     
     int pageNum = 1;
     
     this.response.reset();
     this.response.setHeader("content-disposition", "attachment;filename=" + new String("快检信息履历.csv"
           .getBytes("GBK"), "ISO-8859-1"));
     
     String title = "胶料,胶料编号,胶料车次,实验日期,炼胶班次,ML,MH,Ts1,T30,T60,T25,粘度,焦烧,比重,数显硬度,T25S,试验结果,炼胶人,炼胶时间,检验人姓名,处理方式,备注";
     ServletOutputStream servletOutputStream = this.response.getOutputStream();
     servletOutputStream.write((title + System.getProperty("line.separator")).getBytes("GBK"));
     
     servletOutputStream.flush();
     try {
       List<Map<String, Object>> list;
       do {
         page.setPage(1);
         list = this.quickCheckServiceImpl.rows(filter, page, QuickCheck.class);
         for (int i = 0; i < list.size(); i++) {
           StringBuffer sb = new StringBuffer();
           sb.append(((Map)list.get(i)).get("MATERIAL_NAME_S")).append(",")
             .append(((Map)list.get(i)).get("SAMPLENO_S")).append(",")
             .append(((Map)list.get(i)).get("TRAIN_NUM_S")).append(",")
             .append(((Map)list.get(i)).get("CREATED_TIME_T")).append(",")
             .append(((Map)list.get(i)).get("SHIIFT_CHECK_S")).append(",")
             .append(((Map)list.get(i)).get("ML")).append(",")
             .append(((Map)list.get(i)).get("MH")).append(",")
             .append(((Map)list.get(i)).get("SPARE1_S")).append(",")
             .append(((Map)list.get(i)).get("T30")).append(",")
             .append(((Map)list.get(i)).get("T60")).append(",")
             .append(((Map)list.get(i)).get("T25")).append(",")
             .append(((Map)list.get(i)).get("ND")).append(",")
             .append(((Map)list.get(i)).get("JS")).append(",")
             .append(((Map)list.get(i)).get("BZ")).append(",")
             .append(((Map)list.get(i)).get("YD")).append(",")
             .append(((Map)list.get(i)).get("SPARE3_S")).append(",")
             .append(((Map)list.get(i)).get("STATE_CODE_S")).append(",")
             .append(((Map)list.get(i)).get("LJNAME")).append(",")
             .append(((Map)list.get(i)).get("BEGINTIME")).append(",")
             .append(((Map)list.get(i)).get("CREATED_NAME_S"));
           System.out.println(sb.toString());
           servletOutputStream.write((sb.toString().replace("\n", " ").replace("\r", " ").replace("null", "") + System.getProperty("line.separator")).getBytes("GBK"));
           servletOutputStream.flush();
         } 
       } while (list.size() >= batchQueryCount);
 
     
     }
     catch (Exception e) {
       e.printStackTrace();
     } finally {
       servletOutputStream.flush();
       servletOutputStream.close();
     } 
   }
   
   @RequestMapping({"export"})
   public String export(Filter filter, Page page, HttpServletRequest request, HttpServletResponse response) throws Exception {
     return this.quickCheckServiceImpl.export(filter, page, request, response);
   }
 }


