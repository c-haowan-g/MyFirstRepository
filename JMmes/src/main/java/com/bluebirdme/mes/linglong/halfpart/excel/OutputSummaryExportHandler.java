package com.bluebirdme.mes.linglong.halfpart.excel;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.wsdl.Output;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.excel.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_1ATO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_2ATO;
import com.bluebirdme.mes.linglong.halfpart.entity.OutputSummary_3ATO;


	 public class OutputSummaryExportHandler extends DefaultExcelExportHandler {
	     
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    
		    @Override
		    public void regFormatter() {
		    
		    }
		    
		    public String exportService(HttpServletRequest request,HttpServletResponse response,List listUp,String sumFlag) throws UnsupportedEncodingException {
				HSSFWorkbook wb = new HSSFWorkbook();  
				String nameStr = "半部件产量汇总查询";
		        HSSFSheet sheet = wb.createSheet(nameStr);//创建一个sheet-test1  

		        request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/x-download");
					
		  		// 设置下载文件的文件名称
		        String fileName = nameStr + ".xls";
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
		        
		        String[] arr = {"机台条码","机台名称","物料编码","物料名称","班次","汇总量"};
		        
		    	//创建第一行
		        HSSFRow row = sheet.createRow(0);
		        HSSFCell cell ;
		        
		    	int k = 0;
		        for (int j = 0; j < arr.length; j++) {  
		        	cellStyle.setFont(hssfFont);//设置字体
		        	cell = row.createCell((short)j);  
		        	cell.setCellStyle(cellStyle);  
		        	cell.setCellValue(arr[j]);  
		        	sheet.autoSizeColumn(j);//自动设宽  
		        } 
		        
		        //设置并添加内容
		        for(int j = 0; j < listUp.size(); j++){
		        	if("machinecode_s".equals(sumFlag)){
		        		OutputSummary_1ATO outputSummary= (OutputSummary_1ATO) listUp.get(j);
		    	       	row = sheet.createRow(j+1);
		    	        for(int i = 0; i < arr.length; i++){
		    	        	cellStyleContent.setFont(hssfFontContent);//设置字体
		    	            cell = row.createCell((short)i);  
		    	            cell.setCellStyle(cellStyleContent);  
		    	            switch(i){
		    	            	case 0:
		    	            		cell.setCellValue(outputSummary.getMachinecode_s());  
		    	            		break;
		    	            	case 1:
		    	            		cell.setCellValue(outputSummary.getMachinename_s());  
		    	            		break;
		    	            	case 2:
		    	            		cell.setCellValue("");
		    	            		break;
		    	            	case 3:
		    	            		cell.setCellValue("");
		    	            		break;	
		    	            	case 4:
		    	            		cell.setCellValue(""); 
		    	            		break;
		    	            	case 5:
		    	            		cell.setCellValue(outputSummary.getAmount_i()); 
		    	            		break;
		    	            }
		    	            sheet.autoSizeColumn(i);//自动设宽  
		    	        }
		    		}
		    		else if("materialcode_s".equals(sumFlag)){
		    			OutputSummary_2ATO outputSummary= (OutputSummary_2ATO) listUp.get(j);
		    	       	row = sheet.createRow(j+1);
		    	        for(int i = 0; i < arr.length; i++){
		    	        	cellStyleContent.setFont(hssfFontContent);//设置字体
		    	            cell = row.createCell((short)i);  
		    	            cell.setCellStyle(cellStyleContent);  
		    	            switch(i){
		    	            	case 0:
		    	            		cell.setCellValue("");  
		    	            		break;
		    	            	case 1:
		    	            		cell.setCellValue("");  
		    	            		break;
		    	            	case 2:
		    	            		cell.setCellValue(outputSummary.getMaterialcode_s());
		    	            		break;
		    	            	case 3:
		    	            		cell.setCellValue(outputSummary.getMaterialname_s());
		    	            		break;	
		    	            	case 4:
		    	            		cell.setCellValue(""); 
		    	            		break;
		    	            	case 5:
		    	            		cell.setCellValue(outputSummary.getAmount_i()); 
		    	            		break;
		    	            }
		    	            sheet.autoSizeColumn(i);//自动设宽  
		    	        }
		    		}
		    		else{
		    			OutputSummary_3ATO outputSummary= (OutputSummary_3ATO) listUp.get(j);
		    	       	row = sheet.createRow(j+1);
		    	        for(int i = 0; i < arr.length; i++){
		    	        	cellStyleContent.setFont(hssfFontContent);//设置字体
		    	            cell = row.createCell((short)i);  
		    	            cell.setCellStyle(cellStyleContent);  
		    	            switch(i){
		    	            	case 0:
		    	            		cell.setCellValue("");  
		    	            		break;
		    	            	case 1:
		    	            		cell.setCellValue("");  
		    	            		break;
		    	            	case 2:
		    	            		cell.setCellValue("");
		    	            		break;
		    	            	case 3:
		    	            		cell.setCellValue("");
		    	            		break;	
		    	            	case 4:
		    	            		cell.setCellValue(outputSummary.getOutclass_s()); 
		    	            		break;
		    	            	case 5:
		    	            		cell.setCellValue(outputSummary.getAmount_i()); 
		    	            		break;
		    	            }
		    	            sheet.autoSizeColumn(i);//自动设宽  
		    	        }
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

	 }


