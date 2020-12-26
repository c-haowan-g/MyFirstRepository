/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.service.BuildQuotaServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class BuildQuotaExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	BuildQuotaServiceImpl service = (BuildQuotaServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"BuildQuotaServiceImpl"首字母改为小写
   				.firstCharToLowerCase("BuildQuotaServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRows4(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			
   			
   			for (int i = 0; i < entityList.size(); i++) {
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   				
   				
		        
   				if(entityList.get(i).get("yieldcount")==null||entityList.get(i).get("yieldcount").equals(0)){
   					entityList.get(i).put("arate","");
   					}else{
   						Float yieldcount = Float.valueOf(entityList.get(i).get("yieldcount").toString());
   						Float waste = Float.valueOf(entityList.get(i).get("waste").toString());
   						Float secondlevel =Float.valueOf(entityList.get(i).get("secondlevel").toString());
   						
   		   			   /* String y=yieldcount.setScale(3,BigDecimal.ROUND_HALF_UP).toString();
   		   			    String w=waste.setScale(3,BigDecimal.ROUND_HALF_UP).toString();
   		   			    String s=secondlevel.setScale(3,BigDecimal.ROUND_HALF_UP).toString();*/
   		   			    DecimalFormat df = new DecimalFormat("0.00%");
   		   				String rat=(yieldcount-waste-secondlevel)/yieldcount*100+"%";
   					    entityList.get(i).put("arate",rat);
   					}
   				
   				if(entityList.get(i).get("quotacount")==null||entityList.get(i).get("quotacount")==""){
   					entityList.get(i).put("gongshi",0);
   					}else{
   						Float quotacount = Float.valueOf(entityList.get(i).get("quotacount").toString());
   						Float yieldcount = Float.valueOf(entityList.get(i).get("yieldcount").toString());
   						Float gongshi=8/quotacount*yieldcount;
   						DecimalFormat df = new DecimalFormat("0.00");
   						entityList.get(i).put("gongshi",gongshi);
   		    	}
   				
   				if(entityList.get(i).get("quotacount")==null){
   					entityList.get(i).put("dingerate",0);
   					}else{
   						Float quotacount = Float.valueOf(entityList.get(i).get("quotacount").toString());
   						Float yieldcount = Float.valueOf(entityList.get(i).get("yieldcount").toString());
   						String dingerate=8/quotacount*yieldcount+"%";
   						DecimalFormat df = new DecimalFormat("0.00%");
   						entityList.get(i).put("dingerate",dingerate);}
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
      
        
    }

}
