 package com.bluebirdme.mes.linglong.common.service;
 
 import com.bluebirdme.core.system.web.Filter;
 import com.bluebirdme.core.system.web.Page;
 import com.bluebirdme.mes.linglong.common.entity.CommonDynamicBalanceEdit;
 import com.bluebirdme.mes.linglong.common.entity.QuickCheck;
 import com.bluebirdme.mes.linglong.core.LingLongDataSource;
 import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
 import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
 import java.io.OutputStream;
 import java.io.UnsupportedEncodingException;
 import java.math.BigDecimal;
 import java.net.URLEncoder;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.LinkedHashMap;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
 import javax.annotation.Resource;
 import javax.servlet.ServletOutputStream;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import org.apache.poi.hssf.usermodel.HSSFCellStyle;
 import org.apache.poi.hssf.usermodel.HSSFFont;
 import org.apache.poi.hssf.usermodel.HSSFSheet;
 import org.apache.poi.hssf.usermodel.HSSFWorkbook;
 import org.apache.poi.hssf.util.HSSFColor;
 import org.apache.poi.ss.usermodel.BorderStyle;
 import org.apache.poi.ss.usermodel.Cell;
 import org.apache.poi.ss.usermodel.CellStyle;
 import org.apache.poi.ss.usermodel.Font;
 import org.apache.poi.ss.usermodel.HorizontalAlignment;
 import org.apache.poi.ss.usermodel.IndexedColors;
 import org.apache.poi.ss.usermodel.Row;
 import org.apache.poi.ss.usermodel.VerticalAlignment;
 import org.apache.poi.ss.util.CellRangeAddress;
 import org.hibernate.SQLQuery;
 import org.hibernate.Session;
 import org.hibernate.transform.ResultTransformer;
 import org.hibernate.transform.Transformers;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
 

 @Service
 @Transactional(rollbackFor = {Exception.class})
 public class QuickCheckServiceImpl
   extends RockWellBaseServiceImpl<QuickCheck>
 {
   @Resource
   LingLongDataSource llds;
   
   protected Session getSession() {
     return this.llds.getSession();
   }
 
   
   protected Class getEntity() {
     return CommonDynamicBalanceEdit.class;
   }
 
   
   protected boolean useCache() {
     return false;
   }
 
 
   
   public Map<String, Object> filter(Filter filter, Page page, Class clazz) throws Exception {
     filter.set("s_factory_s", LLWebUtils.factory());
     Map<String, Object> result = new HashMap<>();
     result.put("rows", rows(filter, page, clazz));
     result.put("total", total(filter, page));
     return result;
   }
   
   public List<Map<String, Object>> searchById(String materialname, String type, String starttime, String endtime) {
     SQLQuery query = getSession().createSQLQuery(getSQL("byId"));
     query.setParameter("materialname", materialname);
     query.setParameter("testmethod", type);
     query.setParameter("starttime", starttime);
     query.setParameter("endtime", endtime);
     query.setResultTransformer((ResultTransformer)Transformers.ALIAS_TO_ENTITY_MAP);
     return query.list();
   }
 

   public List<Map<String, Object>> kjqx(Map<String, Object> map) {
     String smwd = null;
     String xmwd = null;
     String ndz = null;
     List<Map<String, Object>> newlist = new ArrayList<>();
     String materialname = map.get("materialname").toString();
     String type = map.get("typename").toString();
     String starttime = map.get("starttime").toString();
     String endtime = map.get("endtime").toString();
     if (materialname != null) {
       List<Map<String, Object>> qxlist = searchById(materialname, type, starttime, endtime);
       
       for (Map<String, Object> m : qxlist) {
         
         Map<String, Object> resultMap = new LinkedHashMap<>();
         
         Set<String> keySet = m.keySet();
         
         for (String key : keySet) {
           String newKey = key.toLowerCase();
           newKey = newKey.replace("_", "");
           resultMap.put(newKey, m.get(key));
         } 
         Map<String, Object> newresultMap = new HashMap<>();
         newresultMap = resultMap;
         newlist.add(newresultMap);
       } 
     } 
     return newlist;
   }
 
 
 
   
   public List<Map<String, Object>> rows(Filter filter, Page page, Class clazz) throws Exception {
     String material_code_s = "";
     String material_name_s = "";
     String lot_no_s = "";
     String start_time_t = "";
     String end_time_t = "";
     SQLQuery query = createSQLQuery(getSQL("datagrid_rows", filter));
     query.setParameter("s_factory_s", ((String)filter.getFilter().get("s_factory_s"))
         .toString());
     query.setParameter("start_time_t", ((String)filter
         .getFilter().get("start_time_t")).toString());
     query.setParameter("end_time_t", ((String)filter.getFilter().get("end_time_t"))
         .toString());
     if (filter.getFilter().containsKey("material_code_s")) {
       
       material_code_s = ((String)filter.getFilter().get("material_code_s")).toString();
       query.setParameter("material_code_s", material_code_s);
     } 
     if (filter.getFilter().containsKey("material_name_s")) {
       
       material_name_s = ((String)filter.getFilter().get("material_name_s")).toString();
       query.setParameter("material_name_s", material_name_s);
     } 
     if (filter.getFilter().containsKey("quickcheck_recipe_code_s")) {
       
       lot_no_s = ((String)filter.getFilter().get("quickcheck_recipe_code_s")).toString();
       query.setParameter("quickcheck_recipe_code_s", lot_no_s);
     } 
     if (page.getAll() == 0) {
       query.setMaxResults(page.getRows());
       query.setFirstResult((page.getPage() - 1) * page.getRows());
     } 
     List<Map<String, Object>> result = query.list();
     return result;
   }
   
   public Long total(Filter filter, Page page) throws Exception {
     if (page.getTotalRows() == 0L) {
       String material_code_s = "";
       String material_name_s = "";
       String lot_no_s = "";
       String result_s = "";
       String start_time_t = "";
       String end_time_t = "";
       SQLQuery query = getSession().createSQLQuery(
           getSQL("datagrid_total", filter));
       query.setParameter("s_factory_s", ((String)filter
           .getFilter().get("s_factory_s")).toString());
       if (filter.getFilter().containsKey("material_code_s")) {
         
         material_code_s = ((String)filter.getFilter().get("material_code_s")).toString();
         query.setParameter("material_code_s", material_code_s);
       } 
       if (filter.getFilter().containsKey("material_name_s")) {
         
         material_name_s = ((String)filter.getFilter().get("material_name_s")).toString();
         query.setParameter("material_name_s", material_name_s);
       } 
       if (filter.getFilter().containsKey("lot_no_s")) {
         lot_no_s = ((String)filter.getFilter().get("lot_no_s")).toString();
         query.setParameter("lot_no_s", lot_no_s);
       } 
       if (filter.getFilter().containsKey("result_s")) {
         result_s = ((String)filter.getFilter().get("result_s")).toString();
         query.setParameter("result_s", result_s);
       } 
       if (filter.getFilter().containsKey("start_time_t")) {
         
         start_time_t = ((String)filter.getFilter().get("start_time_t")).toString();
         query.setParameter("start_time_t", start_time_t);
       } 
       if (filter.getFilter().containsKey("end_time_t")) {
         end_time_t = ((String)filter.getFilter().get("end_time_t")).toString();
         query.setParameter("end_time_t", end_time_t);
       } 
       return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
     } 
     return Long.valueOf(page.getTotalRows());
   }
 
 
 
   
   public String export(Filter filter, Page page, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
     HSSFWorkbook wb = new HSSFWorkbook();
     request.setCharacterEncoding("UTF-8");
     response.setCharacterEncoding("UTF-8");
     response.setContentType("application/x-download");
 
 
     
     String fileName = "随车单" + (new SimpleDateFormat("YYYY-MM-dd")).format(new Date()) + ".xls";
     
     try {
       fileName = URLEncoder.encode(fileName, "UTF-8");
     } catch (UnsupportedEncodingException e) {
       e.printStackTrace();
     } 
 
     
     HSSFSheet hSSFSheet = wb.createSheet("sheet1");
 
 
     
     HSSFFont hSSFFont1 = wb.createFont();
     hSSFFont1.setFontHeightInPoints((short)18);
     hSSFFont1.setColor(HSSFColor.BLACK.index);
     hSSFFont1.setFontName("宋体");
 
     
     HSSFCellStyle hSSFCellStyle1 = wb.createCellStyle();
     hSSFCellStyle1.setFont((Font)hSSFFont1);
     hSSFCellStyle1.setFillForegroundColor(IndexedColors.LIME.getIndex());
     hSSFCellStyle1.setAlignment(HorizontalAlignment.CENTER);
     hSSFCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
     hSSFCellStyle1.setWrapText(true);
 
     
     hSSFCellStyle1.setBorderBottom(BorderStyle.THIN);
     hSSFCellStyle1.setBorderLeft(BorderStyle.DASH_DOT_DOT);
     hSSFCellStyle1.setBorderTop(BorderStyle.THIN);
     hSSFCellStyle1.setBorderRight(BorderStyle.THIN);
     hSSFCellStyle1.setBottomBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle1.setLeftBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle1.setTopBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle1.setRightBorderColor(IndexedColors.BLACK.getIndex());
 
     
     CellRangeAddress region = new CellRangeAddress(0, 0, 0, 2);
 
 
     
     hSSFSheet.addMergedRegion(region);
 
     
     Row rowTitle = hSSFSheet.createRow(0);
     rowTitle.setHeight((short)400);
     Cell cellTitle1_1 = rowTitle.createCell(0);
     Cell cellTitle1_2 = rowTitle.createCell(1);
     Cell cellTitle1_3 = rowTitle.createCell(2);
     cellTitle1_1.setCellStyle((CellStyle)hSSFCellStyle1);
     cellTitle1_2.setCellStyle((CellStyle)hSSFCellStyle1);
     cellTitle1_3.setCellStyle((CellStyle)hSSFCellStyle1);
     cellTitle1_1.setCellValue("山东玲珑轮胎股份有限公司客户随车单");
     
     Row rowTitle1 = hSSFSheet.createRow(1);
     rowTitle1.setHeight((short)400);
     Cell cell = rowTitle1.createCell(1);
     cell.setCellValue("订单单别:______8003______出库日期:________________车辆:_________________");
     
     Row rowTitle2 = hSSFSheet.createRow(2);
     rowTitle2.setHeight((short)400);
     cell = rowTitle2.createCell(1);
     cell.setCellValue("订单单号:____哈哈哈____制单日期:" + (new SimpleDateFormat("YYYY-MM-dd"))
         .format(new Date()) + "___客户:哈哈哈");
 
 
     
     HSSFFont hSSFFont2 = wb.createFont();
     hSSFFont2.setFontHeightInPoints((short)14);
     hSSFFont2.setColor(Font.COLOR_NORMAL);
     hSSFFont2.setFontName("Microsoft Sans Serif");
 
     
     HSSFCellStyle hSSFCellStyle2 = wb.createCellStyle();
     hSSFCellStyle2.setFont((Font)hSSFFont2);
     hSSFCellStyle2.setFillForegroundColor(IndexedColors.LIME.getIndex());
     hSSFCellStyle2.setAlignment(HorizontalAlignment.CENTER);
     hSSFCellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
     hSSFCellStyle2.setWrapText(true);
 
     
     hSSFCellStyle2.setBorderBottom(BorderStyle.THIN);
     hSSFCellStyle2.setBorderLeft(BorderStyle.DASH_DOT_DOT);
     hSSFCellStyle2.setBorderTop(BorderStyle.THIN);
     hSSFCellStyle2.setBorderRight(BorderStyle.THIN);
     hSSFCellStyle2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle2.setTopBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle2.setRightBorderColor(IndexedColors.BLACK.getIndex());
 
     
     Row rowHea = hSSFSheet.createRow(3);
     String[] cellHead = { "序号", "规格", "合计" };
     
     double[] titleWidth = { 24.0D, 100.0D, 24.0D };
     for (int i = 0; i < cellHead.length; i++) {
       Cell createCell = rowHea.createCell(i);
       createCell.setCellValue(cellHead[i]);
       createCell.setCellStyle((CellStyle)hSSFCellStyle2);
     } 
 
     
     HSSFFont hSSFFont3 = wb.createFont();
     hSSFFont3.setFontHeightInPoints((short)14);
     hSSFFont3.setColor(Font.COLOR_NORMAL);
     hSSFFont3.setFontName("Microsoft Sans Serif");
 
     
     HSSFCellStyle hSSFCellStyle3 = wb.createCellStyle();
     hSSFCellStyle3.setFont((Font)hSSFFont3);
     hSSFCellStyle3.setAlignment(HorizontalAlignment.CENTER);
     hSSFCellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
     hSSFCellStyle3.setWrapText(true);
 
     
     hSSFCellStyle3.setBorderBottom(BorderStyle.THIN);
     hSSFCellStyle3.setBorderLeft(BorderStyle.DASH_DOT_DOT);
     hSSFCellStyle3.setBorderTop(BorderStyle.THIN);
     hSSFCellStyle3.setBorderRight(BorderStyle.THIN);
     hSSFCellStyle3.setBottomBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle3.setLeftBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle3.setTopBorderColor(IndexedColors.BLACK.getIndex());
     hSSFCellStyle3.setRightBorderColor(IndexedColors.BLACK.getIndex());
 
 
     
     HSSFFont hSSFFont4 = wb.createFont();
     hSSFFont3.setFontHeightInPoints((short)12);
     hSSFFont3.setColor(Font.COLOR_NORMAL);
     hSSFFont3.setFontName("Microsoft Sans Serif");
     
     SQLQuery query = createSQLQuery(getSQL("searchSpecBySnno"));
     query.setParameter("snno_s", "哈哈哈");
     List<Map<String, Object>> list = query.list();
     List<StringBuffer> listSon = new ArrayList<>();
     
     int number = 4;
     int gross = 0;
     Row row = hSSFSheet.createRow(number); int j;
     for (j = 1; j <= list.size(); j++) {
       String materialdesc_s = (String)((Map)list.get(j - 1)).get("MATERIALDESC_S");
       
       SQLQuery searchBarcodeBySnnoAndSpec = createSQLQuery(getSQL("searchBarcodeBySnnoAndSpec"));
       searchBarcodeBySnnoAndSpec.setParameter("snno_s", "哈哈哈");
       searchBarcodeBySnnoAndSpec.setParameter("materialdesc_s", materialdesc_s);
 
 
       
       List<Map<String, Object>> listBarcode = searchBarcodeBySnnoAndSpec.list();
       gross += listBarcode.size();
       for (int h = 0; h < cellHead.length; h++) {
         hSSFCellStyle3.setFont((Font)hSSFFont4);
         cell = row.createCell((short)h);
         cell.setCellStyle((CellStyle)hSSFCellStyle3);
         switch (h) {
           case 0:
             cell.setCellValue(j);
             break;
           
           case 1:
             cell.setCellValue(materialdesc_s);
             break;
           case 2:
             cell.setCellValue(listBarcode.size());
             break;
         } 
         hSSFSheet.autoSizeColumn(h);
       } 
       
       StringBuffer buffer = new StringBuffer();
       int kis = 0;
       for (int k = 0; k < listBarcode.size(); k++) {
         kis++;
         buffer.append((new StringBuilder()).append(((Map)listBarcode.get(k)).get("BARCODE_S")).append(",").toString());
         if (kis % 6 == 0 || kis == listBarcode.size()) {
           listSon.add(buffer);
           buffer.deleteCharAt(buffer.length() - 1);
           buffer = new StringBuffer();
         } 
       } 
       
       for (int y = 0; y < listSon.size(); y++) {
         number++;
         row = hSSFSheet.createRow(number);
         for (int m = 0; m < cellHead.length; m++) {
           hSSFCellStyle3.setFont((Font)hSSFFont4);
           cell = row.createCell((short)m);
           cell.setCellStyle((CellStyle)hSSFCellStyle3);
           switch (m) {
             case 1:
               cell.setCellValue(((StringBuffer)listSon.get(y)).toString());
               break;
           } 
           hSSFSheet.autoSizeColumn(m);
         } 
       } 
       
       number++;
       row = hSSFSheet.createRow(number);
       listSon = new ArrayList<>();
     } 
     
     row = hSSFSheet.createRow(number);
     hSSFCellStyle3.setFont((Font)hSSFFont4);
     cell = row.createCell(0);
     cell.setCellValue("总合计");
     cell.setCellStyle((CellStyle)hSSFCellStyle3);
     cell = row.createCell(1);
     cell.setCellValue("");
     cell.setCellStyle((CellStyle)hSSFCellStyle3);
     cell = row.createCell(2);
     cell.setCellValue(gross);
     cell.setCellStyle((CellStyle)hSSFCellStyle3);
 
     
     for (j = 0; j < titleWidth.length; j++) {
       hSSFSheet.setColumnWidth((short)j, (short)(int)titleWidth[j] * 256);
     }
 
     
     hSSFSheet.createFreezePane(0, 4, 1, 4);
     response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
     
     try {
       ServletOutputStream servletOutputStream = response.getOutputStream();
       wb.write((OutputStream)servletOutputStream);
       servletOutputStream.close();
       System.out.println("输出完成");
       return "输出完成";
     } catch (Exception e) {
       System.out.println("文件输出失败!");
       e.printStackTrace();
       return "文件输出失败!";
     } 
   }
 }


