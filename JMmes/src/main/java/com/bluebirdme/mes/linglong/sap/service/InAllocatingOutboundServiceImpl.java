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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.entity.Reservation;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualDNItemATO;
import com.bluebirdme.mes.linglong.sap.entity.dto.InAllocatingOutboundATO;
import com.bluebirdme.mes.linglong.sap.entity.dto.InAllocatingOutboundDTO;
import com.bluebirdme.mes.linglong.sap.entity.dto.PlandnHeaderATO;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 发布预留到 MES 系统（SAP->MES）
 * @author 时永良
 * @Date 2019-01-04 09:31:30
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class InAllocatingOutboundServiceImpl extends RockWellBaseServiceImpl<Reservation> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Reservation.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    public String exportService(String snno_s,HttpServletRequest request,HttpServletResponse response,List<?> listUp,List<?> listDown,List<?> listOff) throws UnsupportedEncodingException {
   	 HSSFWorkbook wb = new HSSFWorkbook();  
	        HSSFSheet sheet = wb.createSheet("调拨出库单信息");//创建一个sheet-test1  
	        HSSFSheet sheet1 = wb.createSheet("调拨出库信息");//创建一个sheet-test1  
	        HSSFSheet sheet2 = wb.createSheet("生产明细");//创建一个sheet-test1  
	  	  
	        request.setCharacterEncoding("UTF-8");
 			response.setCharacterEncoding("UTF-8");
 			response.setContentType("application/x-download");
 			
	  		// 设置下载文件的文件名称
		        String fileName = "调拨出库查询" + new SimpleDateFormat("YYYY-MM-dd").format(new Date()) + ".xls";
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
		        
		        String[]arr = {"预留单号","订单号","需求时间","需求部门","状态","发出库存地点","收货库存地点","发出工厂","接收工厂","预计调拨数量","实际调拨数量","调拨差异数量"};
 		        String[]arr1 = {"预留单型号","物料号","物料规格","预计调拨数量","实际调拨数量","调拨差异数量"};
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
                InAllocatingOutboundATO ato= (InAllocatingOutboundATO) listUp.get(j)	;
               	row = sheet.createRow(j+1);
               	List<Map<String,Object>> listRealityQty=RealityQty(ato.getReserno_s());
   		        for(int i =0;i<arr.length;i++){
   		        	cellStyleContent.setFont(hssfFontContent);//设置字体
   		            cell = row.createCell((short)i);  
   		            cell.setCellStyle(cellStyleContent);  
   		        
   		            switch(i){
   		            	case 0:
   		            		cell.setCellValue(ato.getReserno_s());  //预留单号
   		            		break;
   		            	case 1:
   		            		cell.setCellValue(ato.getOrder_s());  //订单号
   		            		break;
   		            	case 2:
   		            		cell.setCellValue(ato.getDemondsdate_s()); //需求时间 
   		            		break;
   		            	case 3:
   		            		cell.setCellValue(ato.getDepartment_s()); //需求部门
   		            		break;
   		            	case 4:
   		            		if(ato.getIsdeliver_s().equals("0")){//状态
   		            			cell.setCellValue("未发货"); 
   		            		}else if(ato.getIsdeliver_s().equals("1")){
   		            			cell.setCellValue("已发货"); 
   		            		}
   		            		break;
   		            	case 5:
   		            		cell.setCellValue(ato.getStorlocfrom_s());  //发出库存地点
   		            		break;
   		            	case 6:
   		            		cell.setCellValue(ato.getStorlocto_s()); //收货库存地点 
   		            		break;
   		            	case 7:
   		            		cell.setCellValue(ato.getPlantfrom_s()); //发出工厂 
   		            		break;
   		            	case 8:
   		            		cell.setCellValue(ato.getPlantto_s());  //接收工厂
   		            		break;
   		            	case 9:
   		            		cell.setCellValue(ato.getQty_s());  //预计调拨数量
   		            		break;
   		            	case 10:
   		            		cell.setCellValue(listRealityQty.get(0).get("REALITYQTY").toString());  //实际调拨数量
   		            		break;
   		            	case 11:
   		            		cell.setCellValue(Integer.parseInt(ato.getQty_s())-Integer.parseInt(listRealityQty.get(0).get("REALITYQTY").toString()));//调拨差异数量  
   		            		break;
   		            }
   		            sheet.autoSizeColumn(i);//自动设宽  
   		        }
               }
		       
               for(int j=0;j<listDown.size();j++){
            	   InAllocatingOutboundDTO ato= (InAllocatingOutboundDTO) listDown.get(j)	;
                  	row = sheet1.createRow(j+1);
                  	List<Map<String,Object>> listRealityQty=RealityQty2(ato.getReserno_s(),ato.getMatcode_s());
      		        for(int i =0;i<arr1.length;i++){
      		        	cellStyleContent.setFont(hssfFontContent);//设置字体
      		            cell = row.createCell((short)i);  
      		            cell.setCellStyle(cellStyleContent);  
      		            switch(i){
      		            	case 0:
      		            		cell.setCellValue(ato.getReseritem_s());  
      		            		break;
      		            	case 1:
      		            		cell.setCellValue(ato.getMatcode_s());  
      		            		break;
      		            	case 2:
      		            		cell.setCellValue(ato.getMaterialdesc_s());  
      		            		break;
      		            	case 3:
      		            		cell.setCellValue(ato.getQty_s());  
      		            		break;
      		            	case 4:
      		            		cell.setCellValue(listRealityQty.get(0).get("REALITYQTY").toString());  
      		            		break;
      		            	case 5:
      		            		cell.setCellValue(Integer.parseInt(ato.getQty_s())-Integer.parseInt(listRealityQty.get(0).get("REALITYQTY").toString()));  
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
    
    
    public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz) throws Exception {

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
    
    //查询出实际调拨数量
    public List<Map<String, Object>> RealityQty(String snno_s){
    	SQLQuery query = createSQLQuery(getSQL("realityqty"));
    	query.setParameter("snno_s", snno_s);
		return query.list();
    }
    
    //查询出实际调拨数量(单个)
    public List<Map<String, Object>> RealityQty2(String snno_s,String materialcode_s){
    	SQLQuery query = createSQLQuery(getSQL("realityqty2"));
    	query.setParameter("snno_s", snno_s);
    	query.setParameter("materialcode_s",materialcode_s);
		return query.list();
    }
    

    //添加查询轮胎条件（调拨出库）
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
}
