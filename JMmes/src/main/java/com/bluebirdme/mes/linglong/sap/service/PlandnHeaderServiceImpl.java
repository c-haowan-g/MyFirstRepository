/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.entity.PlandnHeader;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualDNItemATO;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualamountItemATO;
import com.bluebirdme.mes.linglong.sap.entity.dto.PlandnHeaderATO;
import com.bluebirdme.mes.linglong.util.DateUtil;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 发货单及发货实绩查询 
 * @author 周清玉
 * @Date 2018-12-12 11:55:10
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PlandnHeaderServiceImpl extends RockWellBaseServiceImpl<PlandnHeader> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return PlandnHeader.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    
    public String exportService(String snno_s,HttpServletRequest request,HttpServletResponse response,List<?> listUp,List<?> listDown,List<?> listOff) throws UnsupportedEncodingException {
    	 HSSFWorkbook wb = new HSSFWorkbook();  
	        HSSFSheet sheet = wb.createSheet("销售出库单信息");//创建一个sheet-test1  
	        HSSFSheet sheet1 = wb.createSheet("销售出库信息");//创建一个sheet-test1  
	        HSSFSheet sheet2 = wb.createSheet("发货明细");//创建一个sheet-test1  
	  	  
	        request.setCharacterEncoding("UTF-8");
  			response.setCharacterEncoding("UTF-8");
  			response.setContentType("application/x-download");
  			
	  		// 设置下载文件的文件名称
		        String fileName = "销售出库查询" + new SimpleDateFormat("YYYY-MM-dd").format(new Date()) + ".xls";
		        try {
		            fileName = URLEncoder.encode(fileName, "UTF-8");
		        } catch (UnsupportedEncodingException e) {
		            e.printStackTrace();
		        }
		        HSSFCellStyle cellStyle = wb.createCellStyle();
		        HSSFCellStyle cellStyleContent = wb.createCellStyle();

		        //设置居中
		        cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
		        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
		        //设置边框
		        cellStyle.setBorderBottom(BorderStyle.THIN); //下边框
		        cellStyle.setBorderLeft(BorderStyle.DASH_DOT_DOT);//左边框
		        cellStyle.setBorderTop(BorderStyle.THIN);//上边框
		        cellStyle.setBorderRight(BorderStyle.THIN);//右边框
		        
		        //设置居中
		        cellStyleContent.setAlignment(HorizontalAlignment.CENTER);//水平居中
		        cellStyleContent.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
		        //设置边框
		        cellStyleContent.setBorderBottom(BorderStyle.THIN); //下边框
		        cellStyleContent.setBorderLeft(BorderStyle.DASH_DOT_DOT);//左边框
		        cellStyleContent.setBorderTop(BorderStyle.THIN);//上边框
		        cellStyleContent.setBorderRight(BorderStyle.THIN);//右边框
		        
		        //改变字体样式，步骤
		        HSSFFont hssfFont = wb.createFont();
//		        //设置字体,红色
//		        hssfFont.setColor(HSSFFont.COLOR_RED);
		        //字体粗体显示
		        hssfFont.setBold(true);
		        hssfFont.setFontName("宋体");
		        // 字体大小
		        hssfFont.setFontHeightInPoints((short) 13);
		        
		        //改变字体样式，步骤
		        HSSFFont hssfFontContent  = wb.createFont();
		        hssfFont.setFontName("宋体");
		        // 字体大小
		        hssfFontContent.setFontHeightInPoints((short) 9);
		        
		        String[]arr = {"发货单号","凭证日期","客户编码","客户全称","发货单状态","预计发货数量","实际发货数量","发货差异数量"};
		        String[]arr1 = {"物料号","物料规格","预计发货数量","实际发货数量","发货差异数量","质量等级"};
	        	String[]arr2 = {"发货单号","轮胎条码","物料号","规格/花纹","外胎质量等级","生产日期","发货人","发货日期"};
	        	//创建第一行
	            HSSFRow row = sheet.createRow(0);
	            HSSFCell cell ;
	            //创建第一行
	            HSSFRow row1 = sheet1.createRow(0);
	            HSSFCell cell1 ;
	            //创建第一行
	            HSSFRow row2 = sheet2.createRow(0);
	            HSSFCell cell2 ;
		        for (int j = 0; j < arr.length; j++) {  
		        	cellStyle.setFont(hssfFont);//设置字体
		            cell = row.createCell((short)j);  
		            cell.setCellStyle(cellStyle);  
		            cell.setCellValue(arr[j]);  
		            sheet.autoSizeColumn(j);//自动设宽  
		        } 
		        for (int j = 0; j < arr1.length; j++) {  
		        	// 字体大小
		        	cellStyle.setFont(hssfFont);//设置字体
		        	cell1 = row1.createCell((short)j);  
		        	cell1.setCellStyle(cellStyle);  
		        	cell1.setCellValue(arr1[j]);  
		        	sheet1.autoSizeColumn(j);//自动设宽  
		        } 
		        for (int j = 0; j < arr2.length; j++) {  
		        	// 字体大小
		        	cellStyle.setFont(hssfFont);//设置字体
		        	cell2 = row2.createCell((short)j);  
		        	cell2.setCellStyle(cellStyle);  
		        	cell2.setCellValue(arr2[j]);  
		        	sheet2.autoSizeColumn(j);//自动设宽  
		        } 
		       
		        //设置并添加内容
                for(int j=0;j<listUp.size();j++){
                 PlandnHeader ato= (PlandnHeader) listUp.get(j);
                 List<Map<String,Object>> a= a(ato.getSnno_s());
                 List<Map<String,Object>> listSumQty=SumQty(a.get(0).get("ATR_KEY").toString());
 		         List<Map<String,Object>> listRealityQty=RealityQty(ato.getSnno_s());
                	row = sheet.createRow(j+1);
    		        for(int i =0;i<arr.length;i++){
    		        	cellStyleContent.setFont(hssfFontContent);//设置字体
    		            cell = row.createCell((short)i);  
    		            cell.setCellStyle(cellStyleContent);  
    		            switch(i){
    		            	case 0:
    		            		cell.setCellValue(ato.getSnno_s());  
    		            		break;
    		            	case 1:
    		            		cell.setCellValue(ato.getDocdate_s());  
    		            		break;
    		            	case 2:
    		            		cell.setCellValue(ato.getCustomerid_s());  
    		            		break;
    		            	case 3:
    		            		List<Map<String,Object>> listQueryCustomename=queryCustomename(ato.getCustomerid_s());
    		            		cell.setCellValue(listQueryCustomename.get(0).get("CUSTOMENAME_S").toString());  
    		            		break;
    		            	case 4:
    		            		String	dummy1= ato.getDummy3_s();
    		            		if(dummy1==null){
    		          			  dummy1="1";
    		          			}
    		          			switch(dummy1){
    		          				case "1": 
    		          					cell.setCellValue("接受"); 
    		          					break;
    		          				case "2": 
    		          					cell.setCellValue("执行");
    		          					break;
    		          				case "3": 
    		          					cell.setCellValue("关闭");
    		          					break;
    		          			}
    		            		break;
    		            	case 5:
    		            		cell.setCellValue(listSumQty.get(0).get("QTY_S").toString());  
    		            		break;
    		            	case 6:
    		            		cell.setCellValue(listRealityQty.get(0).get("REALITYQTY").toString());
    		            		break;
    		            	case 7:
    		            		cell.setCellValue(Integer.parseInt(listSumQty.get(0).get("QTY_S").toString())-Integer.parseInt(listRealityQty.get(0).get("REALITYQTY").toString()));
    		            		break;	
    		            }
    		            sheet.autoSizeColumn(i);//自动设宽  
    		        }
                }
		        
                for(int j=0;j<listDown.size();j++){
                	PlandnHeaderATO ato= (PlandnHeaderATO) listDown.get(j);
                	List<Map<String,Object>> listRealityQty=RealityQty2(ato.getSnno_s(),ato.getMaterialcode_s());
                   	row = sheet1.createRow(j+1);
       		        for(int i =0;i<arr1.length;i++){
       		        	cellStyleContent.setFont(hssfFontContent);//设置字体
       		            cell = row.createCell((short)i);  
       		            cell.setCellStyle(cellStyleContent);  
       		            switch(i){
       		            	case 0:
       		            		cell.setCellValue(ato.getMaterialcode_s());  
       		            		break;
       		            	case 1:
       		            		cell.setCellValue(ato.getMaterialdesc_s());  
       		            		break;
       		            	case 2:
       		            		cell.setCellValue(ato.getQty_s());  
       		            		break;
       		            	case 3:
    		            		cell.setCellValue(listRealityQty.get(0).get("REALITYQTY").toString());
       		            		break;
       		            	case 4:
    		            		cell.setCellValue(Integer.parseInt(ato.getQty_s())-Integer.parseInt(listRealityQty.get(0).get("REALITYQTY").toString()));
       		            		break;	
       		            	case 5:
       		            		cell.setCellValue(ato.getBatch_s()); 
       		            		break;
       		            }
       		            sheet1.autoSizeColumn(i);//自动设宽  
       		        }
                   }
                
                for(int j=0;j<listOff.size();j++){
                	ActualDNItemATO ato= (ActualDNItemATO) listOff.get(j);
                   	row = sheet2.createRow(j+1);
       		        for(int i =0;i<arr2.length;i++){
       		        	cellStyleContent.setFont(hssfFontContent);//设置字体
       		            cell = row.createCell((short)i);  
       		            cell.setCellStyle(cellStyleContent);  
       		            switch(i){
       		            	case 0:
       		            		cell.setCellValue(ato.getSnno_s());  
       		            		break;
       		            	case 1:
       		            		cell.setCellValue(ato.getBarcode_s());  
       		            		break;
       		            	case 2:
       		            		cell.setCellValue(ato.getMaterialcode_s());  
       		            		break;
       		            	case 3:
       		            		cell.setCellValue(ato.getMaterialdesc_s());  
       		            		break;
       		            	case 4:
       		            		cell.setCellValue(ato.getGradecode_s()); 
       		            		break;
       		            	case 5:
       		            		cell.setCellValue(ato.getDynamicbalancepasstime_t()); 
       		            		break;
       		            	case 6:
       		            		cell.setCellValue(ato.getCreatedby_s()); 
       		            		break;
       		            	case 7:
       		            		cell.setCellValue(ato.getCreation_time_date()); 
       		            		break;
       		            }
       		            sheet2.autoSizeColumn(i);//自动设宽  
       		        }
                   }
                
		        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
		        try {
		        	OutputStream out = response.getOutputStream();
					wb.write(out);
					out.close(); 
		            System.out.println("输出完成");  
		            return "输出完成";
		        } catch (Exception e) {  
		            System.out.println("文件输出失败!"); 
		            e.printStackTrace(); 
		            return "文件输出失败!";
		        }  
    }
    
    
    //查看是否上传
    
    public List<Map<String, Object>> count(String sonn,String materialcode_s){
    	SQLQuery query = createSQLQuery(getSQL("countQuery"));
		query.setParameter("snno_s", sonn);
//		query.setParameter("materialcode_s",materialcode_s);
		return query.list();
    }
    //根据ID号查询客户名称等
    public List<Map<String, Object>> queryCustomename(String customerid_s){
    	SQLQuery query = createSQLQuery(getSQL("queryCustomename"));
		query.setParameter("customerid_s", customerid_s);
		return query.list();
    }
    
    //查询出预计发货数量
    public List<Map<String, Object>> SumQty(String atr_key){
    	SQLQuery query = createSQLQuery(getSQL("sumcount"));
    	query.setParameter("ATR_KEY", atr_key);
		return query.list();
    }
    
    public List<Map<String, Object>> a(String snno_s){
    	SQLQuery query = createSQLQuery(getSQL("a"));
    	query.setParameter("snno_s", snno_s);
		return query.list();
    }
    
    //查询出实际发货数量
    public List<Map<String, Object>> RealityQty(String snno_s){
    	SQLQuery query = createSQLQuery(getSQL("realityqty"));
    	query.setParameter("snno_s", snno_s);
		return query.list();
    }
    
    //查询出实际发货数量(单个)
    public List<Map<String, Object>> RealityQty2(String snno_s,String materialcode_s){
    	SQLQuery query = createSQLQuery(getSQL("realityqty2"));
    	query.setParameter("snno_s", snno_s);
    	query.setParameter("materialcode_s",materialcode_s);
		return query.list();
    }
    
    public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz) throws Exception {

		String FACTORY = "s_factory_s";

		if (clazz == null) {
			clazz = getEntity();
		}

		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
					System.out.println(LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
	}
    
    @SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz) throws Exception {

		String FACTORY = "s_factory_s";
		
		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows2的SQL语句定义");

		String dataSql = getSQL("datagrid_rows2", filter.getFilter());

		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

		setParameter(query, filter);

		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}

		return query.list();
	}
    
    public Long datagridTotal2(Filter filter, Page page) throws Exception {

		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total2的SQL语句定义");

		String totalSql = getSQL("datagrid_total2", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
    
    
    
    //添加查询轮胎条件
    public Map<String, Object> datagridBar(Filter filter, Page page, Class clazz) throws Exception {
		String FACTORY = "s_factory_s";
		if (clazz == null) {
			clazz = getEntity();
		}
		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsBar(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalBar(filter, page));
		return ret;
	}
    
	@SuppressWarnings({ "unchecked" })
	public <K> List<K> datagridRowsBar(Filter filter, Page page, Class<K> clazz) throws Exception {
		String FACTORY = "s_factory_s";
		if (!filter.getFilter().containsKey(FACTORY)) {
			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		if (getSQL("datagridBar") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");
		String dataSql = getSQL("datagridBar", filter.getFilter());
		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		return query.list();
	}
	public Long datagridTotalBar(Filter filter, Page page) throws Exception {
		if (getSQL("datagridTotalBar") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");
		String totalSql = getSQL("datagridTotalBar", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	
	
	public Map<String,Object> searchTheAccessoryBySonn(String snno_s){
		SQLQuery query =createSQLQuery(getSQL("searchSpecBySnno"));
		query.setParameter("snno_s", snno_s);
		List<Map<String,Object>> list=query.list();
		List<Map<String,Object>> listMap=new ArrayList<Map<String,Object>>();
		Map<String,Object> map = null;
		Map<String,Object> mapSon =new HashMap<String, Object>();;
		Map<String,Object> mapKey = new HashMap<>();
		
		//追加合计的ID
		int poo=1;
		//追加合计数量
		int gross=0;
		for(int i=1;i<=list.size();i++){
			poo++;
			map = new HashMap<>();
			String materialdesc_s =(String) list.get(i-1).get("MATERIALDESC_S");
			SQLQuery searchBarcodeBySnnoAndSpec =createSQLQuery(getSQL("searchBarcodeBySnnoAndSpec"));
			searchBarcodeBySnnoAndSpec.setParameter("snno_s", snno_s);
			searchBarcodeBySnnoAndSpec.setParameter("materialdesc_s", materialdesc_s);
			@SuppressWarnings("unchecked")
			List<Map<String,Object>> listBarcode=searchBarcodeBySnnoAndSpec.list();
			gross+=listBarcode.size();
			StringBuffer buffer = new StringBuffer();
			
			int kis=0;

			for(int j=0;j<listBarcode.size();j++){
				poo++;//追加合计的ID
				kis++;
				buffer.append(listBarcode.get(j).get("BARCODE_S")+",");
				if(kis%6==0 || kis==listBarcode.size()){
					mapSon.put("materialdesc_s", buffer);//规格//子节点下面的规格其实是轮胎条码
					mapSon.put("_parentId", i);//父id
					buffer.deleteCharAt(buffer.length()-1);
					listMap.add(mapSon);
					mapSon= new HashMap<String, Object>();
					buffer = new StringBuffer();
				}
			}
			map.put("id", i);//序号
			map.put("materialdesc_s", materialdesc_s);//规格
			map.put("barcodeSize", listBarcode.size());//合计
			map.put("_parentId", null);//父ID
			listMap.add(map);
		}
		
		Map<String,Object> mapHj = new HashMap<String,Object>();
		mapHj.put("_parentId", null);//父ID
		mapHj.put("materialdesc_s", "合计");//规格
		mapHj.put("id", poo);//序号
		mapHj.put("barcodeSize", gross);//合计数据
		listMap.add(mapHj);
		mapKey.put("rows", listMap);
		return mapKey;
	}
	
	
	
	 public String theAccessoryExportExcel(String snno_s,String customename_s,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		 
		 HSSFWorkbook wb = new HSSFWorkbook();  
	        request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/x-download");
			
	  		// 设置下载文件的文件名称
		        String fileName = "随车单" + new SimpleDateFormat("YYYY-MM-dd").format(new Date()) + ".xls";
		        try {
		            fileName = URLEncoder.encode(fileName, "UTF-8");
		        } catch (UnsupportedEncodingException e) {
		            e.printStackTrace();
		        }
		        
	        //创建sheet
	        Sheet createSheet = wb.createSheet("sheet1");
	        Cell cell ;
	        
	        //设置标题字体
	        Font fontTitle = wb.createFont();
	        fontTitle.setFontHeightInPoints((short) 18); //字体大小
	        fontTitle.setColor(HSSFColor.BLACK.index); //字体颜色
	        fontTitle.setFontName("宋体"); //字体

	        //设置标题单元格类型
	        CellStyle cellStyleTitle = wb.createCellStyle();
	        cellStyleTitle.setFont(fontTitle);
	        cellStyleTitle.setFillForegroundColor(IndexedColors.LIME.getIndex());
	        cellStyleTitle.setAlignment(HorizontalAlignment.CENTER);//水平居中
	        cellStyleTitle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
	        cellStyleTitle.setWrapText(true);//设置自动换行
	        
	      //设置边框
	        cellStyleTitle.setBorderBottom(BorderStyle.THIN); //下边框
	        cellStyleTitle.setBorderLeft(BorderStyle.DASH_DOT_DOT);//左边框
	        cellStyleTitle.setBorderTop(BorderStyle.THIN);//上边框
	        cellStyleTitle.setBorderRight(BorderStyle.THIN);//右边框   
	        cellStyleTitle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleTitle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleTitle.setTopBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleTitle.setRightBorderColor(IndexedColors.BLACK.getIndex());

	        
	        //创建合并单元格  ---begin
	        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 2);// 下标从0开始 起始行号，终止行号， 起始列号，终止列号
	        //在sheet里增加合并单元格  
	        createSheet.addMergedRegion(region);
	        
	        // -----------填充第一行数据-------------
	        Row rowTitle = createSheet.createRow(0);
	        rowTitle.setHeight((short)400);
	        Cell cellTitle1_1 = rowTitle.createCell(0);
	        Cell cellTitle1_2 = rowTitle.createCell(1);
	        Cell cellTitle1_3 = rowTitle.createCell(2);
	        cellTitle1_1.setCellStyle(cellStyleTitle);
	        cellTitle1_2.setCellStyle(cellStyleTitle);
	        cellTitle1_3.setCellStyle(cellStyleTitle);
	        cellTitle1_1.setCellValue("山东玲珑轮胎股份有限公司客户随车单");// 设置标题内容
	        // -----------填充第二行数据-------------
	        Row rowTitle1 = createSheet.createRow(1);
	        rowTitle1.setHeight((short)400);
	        cell = rowTitle1.createCell((short)1);  
	        cell.setCellValue("订单单别:______8003______"+"出库日期:________________"+"车辆:_________________");
	        Row rowTitle2 = createSheet.createRow(2);
	        rowTitle2.setHeight((short)400);
	        cell = rowTitle2.createCell((short)1); 
	        cell.setCellValue("订单单号:____"+snno_s+"____制单日期:"+new SimpleDateFormat("YYYY-MM-dd").format(new Date()) +"___客户:"+customename_s);
	        
	        //设置表头字体
	        Font fontHead = wb.createFont();
	        fontHead.setFontHeightInPoints((short) 14); //字体大小
	        fontHead.setColor(Font.COLOR_NORMAL); //字体颜色
	        fontHead.setFontName("Microsoft Sans Serif"); //字体

	        //设置表头单元格类型
	        CellStyle cellStyleHead = wb.createCellStyle();
	        cellStyleHead.setFont(fontHead);
	        cellStyleHead.setFillForegroundColor(IndexedColors.LIME.getIndex());
	        cellStyleHead.setAlignment(HorizontalAlignment.CENTER);//水平居中
	        cellStyleHead.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
	        cellStyleHead.setWrapText(true);//设置自动换行

	        //设置边框
	        cellStyleHead.setBorderBottom(BorderStyle.THIN); //下边框
	        cellStyleHead.setBorderLeft(BorderStyle.DASH_DOT_DOT);//左边框
	        cellStyleHead.setBorderTop(BorderStyle.THIN);//上边框
	        cellStyleHead.setBorderRight(BorderStyle.THIN);//右边框
	        cellStyleHead.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleHead.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleHead.setTopBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleHead.setRightBorderColor(IndexedColors.BLACK.getIndex());
	        //内容=========================================================================
	        //创建第一行，标题
	        Row rowHea = createSheet.createRow(3);
	        String[] cellHead = {"序号","规格","合计"};
	        // 设置列宽
	        double[] titleWidth = {24, 100, 24};
	        for (int i = 0; i < cellHead.length; i++) {
	            Cell createCell = rowHea.createCell(i);
	            createCell.setCellValue(cellHead[i]);
	            createCell.setCellStyle(cellStyleHead);
	        }
	        

	        //设置内容字体
	        Font fontData = wb.createFont();
	        fontData.setFontHeightInPoints((short) 14); //字体大小
	        fontData.setColor(Font.COLOR_NORMAL); //字体颜色
	        fontData.setFontName("Microsoft Sans Serif"); //字体

	        //设置内容单元格类型
	        CellStyle cellStyleDataOdd = wb.createCellStyle();
	        cellStyleDataOdd.setFont(fontData);
	        cellStyleDataOdd.setAlignment(HorizontalAlignment.CENTER);//水平居中
	        cellStyleDataOdd.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
	        cellStyleDataOdd.setWrapText(true);

	        //设置边框
	        cellStyleDataOdd.setBorderBottom(BorderStyle.THIN); //下边框
	        cellStyleDataOdd.setBorderLeft(BorderStyle.DASH_DOT_DOT);//左边框
	        cellStyleDataOdd.setBorderTop(BorderStyle.THIN);//上边框
	        cellStyleDataOdd.setBorderRight(BorderStyle.THIN);//右边框
	        cellStyleDataOdd.setBottomBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleDataOdd.setLeftBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleDataOdd.setTopBorderColor(IndexedColors.BLACK.getIndex());
	        cellStyleDataOdd.setRightBorderColor(IndexedColors.BLACK.getIndex());

	      //内容字体============================================================================
	        //设置内容字体
	        Font hssfFontContent = wb.createFont();
	        fontData.setFontHeightInPoints((short) 12); //字体大小
	        fontData.setColor(Font.COLOR_NORMAL); //字体颜色
	        fontData.setFontName("Microsoft Sans Serif"); //字体
	      //内容数据---------------------------------------------------------------------------------
            SQLQuery query =createSQLQuery(getSQL("searchSpecBySnno"));
			query.setParameter("snno_s", snno_s);
			List<Map<String,Object>> list=query.list();
			List<StringBuffer> listSon =new ArrayList<StringBuffer>();
			
			int number=4;//创建行数
			int gross = 0;//合计总数量
			Row row = createSheet.createRow(number);
			for(int i=1;i<=list.size();i++){
				String materialdesc_s =(String) list.get(i-1).get("MATERIALDESC_S");
				SQLQuery searchBarcodeBySnnoAndSpec =createSQLQuery(getSQL("searchBarcodeBySnnoAndSpec"));
				searchBarcodeBySnnoAndSpec.setParameter("snno_s", snno_s);
				searchBarcodeBySnnoAndSpec.setParameter("materialdesc_s", materialdesc_s);
				@SuppressWarnings("unchecked")
				List<Map<String,Object>> listBarcode=searchBarcodeBySnnoAndSpec.list();
				gross+=listBarcode.size();
				for(int h=0;h<cellHead.length;h++){
					cellStyleDataOdd.setFont(hssfFontContent);//设置字体
		            cell = row.createCell((short)h);  
		            cell.setCellStyle(cellStyleDataOdd);  
		            switch(h){
		            	case 0:
		            		cell.setCellValue(i);  
		            		break;
		            	case 1:
		            		
		            		cell.setCellValue(materialdesc_s);  
		            		break;
		            	case 2:
		            		cell.setCellValue(listBarcode.size());  
		            		break;
		            }
		            createSheet.autoSizeColumn(h);//自动设宽  
				}
				
				
		 	 StringBuffer buffer = new StringBuffer();
			 int kis=0;
			 for(int j=0;j<listBarcode.size();j++){
					kis++;
					buffer.append(listBarcode.get(j).get("BARCODE_S")+",");
					if(kis%6==0 || kis==listBarcode.size()){
						listSon.add(buffer);//规格//子节点下面的规格其实是轮胎条码
						buffer.deleteCharAt(buffer.length()-1);
						buffer = new StringBuffer();
					}
				}
				
				for(int y =0;y<listSon.size();y++){
					number++;
					row = createSheet.createRow(number);
					for(int h=0;h<cellHead.length;h++){
    		        	cellStyleDataOdd.setFont(hssfFontContent);//设置字体
    		            cell = row.createCell((short)h);  
    		            cell.setCellStyle(cellStyleDataOdd);  
    		            switch(h){
    		            	case 1:
    		            		cell.setCellValue(listSon.get(y).toString());  
    		            		break;
    		            }
    		            createSheet.autoSizeColumn(h);//自动设宽  
					}
					
				}
				number++;
				row = createSheet.createRow(number);
				listSon = new ArrayList<StringBuffer>();
			}
			
			row = createSheet.createRow(number);
			cellStyleDataOdd.setFont(hssfFontContent);//设置字体
            cell = row.createCell((short)0); 
            cell.setCellValue("总合计");  
            cell.setCellStyle(cellStyleDataOdd);  
            cell = row.createCell((short)1);
            cell.setCellValue(""); 
            cell.setCellStyle(cellStyleDataOdd);  
            cell = row.createCell((short)2);
            cell.setCellValue(gross); 
            cell.setCellStyle(cellStyleDataOdd);  
            
           
            
            
	        // 设置列宽
	        for (int i = 0; i < titleWidth.length; i++) {
	             createSheet.setColumnWidth((short) i, (short) titleWidth[i] * 256);
	        }
	        
	        // 设置上面四行冻结
	        createSheet.createFreezePane( 0, 4, 1, 4); // 前两个参数是你要用来拆分的列数和行数。后两个参数是下面窗口的可见象限，其中第三个参数是右边区域可见的左边列数，第四个参数是下面区域可见的首行
	        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
	        try {
	        	OutputStream out = response.getOutputStream();
				wb.write(out);
				out.close(); 
	            System.out.println("输出完成");  
	            return "输出完成";
	        } catch (Exception e) {  
	            System.out.println("文件输出失败!"); 
	            e.printStackTrace(); 
	            return "文件输出失败!";
	        }  
	 }
	 
	 /**
	  * 销售发货数量
	  * @return
	  */
	 public List<Map<String,Object>> plandnitemColumnQty(Filter filter){
		 SQLQuery query = createSQLQuery(getSQL("plandnitemColumnQty"));
		 query.setParameter("start_time", filter.get("start_time")+" 00:00:00");
	     query.setParameter("end_time", filter.get("end_time")+" 23:59:59");
	     query.setParameter("plant_s",filter.get("plant_s"));
		 return query.list();
	 }
	 /**
	  * 调拨发货数量
	  * @return
	  */
	 public List<Map<String,Object>> inAllocatingColumnQty(Filter filter){
		 SQLQuery query = createSQLQuery(getSQL("inAllocatingColumnQty"));
		 query.setParameter("start_time", filter.get("start_time")+" 00:00:00");
	     query.setParameter("end_time", filter.get("end_time")+" 23:59:59");
	     query.setParameter("plant_s",filter.get("plant_s"));
		 return query.list();
	 }
}
