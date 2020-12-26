/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.Machine_Formula;
import com.bluebirdme.mes.linglong.building.service.Machine_FormulaServiceImpl;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class Machine_FormulaExportHandler extends DefaultExcelExportHandler {
    
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Machine_FormulaServiceImpl machine_formulaSrv;
    
    public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
		List<Object> listATO = new ArrayList<>();
		List<Machine_Formula> list = machine_formulaSrv.datagridAllRows(filter, Machine_Formula.class);
		for(int i =0;i<list.size();i++){
			listATO.add(list.get(i));
		}
		return listATO;
	}
	
    @Override
    public void regFormatter() {}

    public String exportService(HttpServletRequest request,HttpServletResponse response,List<Machine_Formula> listUp) throws UnsupportedEncodingException {
		HSSFWorkbook wb = new HSSFWorkbook();  
		String nameStr = "成型工艺配方";
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
        
        String[] arr = {"机台条码","胎胚物料编码","产品阶段","胎胚版本号","参数索引","参数描述",
        		"参数名","参数值","参数标准值","标准上限","标准下限","修改时间","修改来源"};
        
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
        	Machine_Formula machine_Formula= listUp.get(j);
	       	row = sheet.createRow(j+1);
	        for(int i = 0; i < arr.length; i++){
	        	cellStyleContent.setFont(hssfFontContent);//设置字体
	            cell = row.createCell((short)i);  
	            cell.setCellStyle(cellStyleContent);  
	            switch(i){
	            	case 0:
	            		cell.setCellValue(machine_Formula.getEquip_code_s());  
	            		break;
	            	case 1:
	            		cell.setCellValue(machine_Formula.getMaterial_code_s());  
	            		break;
	            	case 2:
	            		cell.setCellValue(machine_Formula.getProduction_step_s());
	            		break;
	            	case 3:
	            		cell.setCellValue(machine_Formula.getVersion_s());
	            		break;	
	            	case 4:
	            		cell.setCellValue(machine_Formula.getParameter_id_s()); 
	            		break;
	            	case 5:
	            		cell.setCellValue(machine_Formula.getParmtype_name_s()); 
	            		break;
	            	case 6:
	            		cell.setCellValue(machine_Formula.getParameter_name_s()); 
	            		break;
	            	case 7:
	            		cell.setCellValue(machine_Formula.getParameter_plcvalue_s()); 
	            		break;
	            	case 8:
	            		cell.setCellValue(machine_Formula.getParameter_standardvalue_s()); 
	            		break;
	            	case 9:
	            		cell.setCellValue(machine_Formula.getParameter_uppervalue_s()); 
	            		break;
	            	case 10:
	            		cell.setCellValue(machine_Formula.getParameter_lowervalue_s()); 
	            		break;
	            	case 11:
	            		if(!((machine_Formula.getChanged_time_t())==null)){
	            			System.out.println((machine_Formula.getChanged_time_t()).equals(null));
	            			cell.setCellValue(machine_Formula.getChanged_time_t()); 
	            		}
	            		cell.setCellValue(""); 
	            		break;
	            	case 12:
	            		cell.setCellValue(machine_Formula.getAlter_source_s()); 
	            		break;
	            }
	            sheet.autoSizeColumn(i);//自动设宽  
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
