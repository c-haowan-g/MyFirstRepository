/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.mix.service.MixMonthlyReportServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.UnitStatusServiceImpl;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author guoqiag_chen
 * @Date 2019年8月29日 下午2:30:34
 */
public class UnitStatusExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	UnitStatusServiceImpl service = (UnitStatusServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MixMonthlyReportServiceImpl"首字母改为小写
   				.firstCharToLowerCase("UnitStatusServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
    	regFormatter("status", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
            	
            	if(value.equals("Created")){
            		return "创建";
            	}else if(value.equals("Started")){
            		return "已执行";
            	}else if(value.equals("Completed")){
            		return "已完成";
            	}else if(value.equals("Finished")){
            		return "生产结束";
            	}else if(value.equals("Shipped")){
            		return "发货";
            	}else if(value.equals("Closed")){
            		return "订单关闭";
            	}else if(value.equals("Received")){
            		return "生产恢复";
            	}else{
            		return"";
            	}
            	
            }
        });
    	regFormatter("op_name", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
            	
            	if(value.equals("252004")){
            		return "半部件";
            	}else if(value.equals("252005")){
            		return "成型";
            	}else if(value.equals("252006")){
            		return "硫化";
            	}else if(value.equals("252007")){
            		return "割毛";
            	}else if(value.equals("252008")){
            		return "外观";
            	}else if(value.equals("252009")){
            		return "X光";
            	}else if(value.equals("252010")){
            		return "动平衡";
            	}else if(value.equals("252011")){
            		return"均匀性";
            	}else if(value.equals("252013")){
            		return "入库";
            	}else if(value.equals("252014")){
            		return "发货";
            	}else if(value.equals("252015")){
            		return"退车间";
            	}else if(value.equals("252100")){
            		return "成型返修";
            	}else if(value.equals("252101")){
            		return"外观返修";
            	}else{
            		return"";
            	}
            	
            }
        });
    	regFormatter("quality_grade_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
            	
            	if(value.equals("253001")){
            		return "合格";
            	}else if(value.equals("253002")){
            		return "复检合格";
            	}else if(value.equals("253003")){
            		return "不合格";
            	}else if(value.equals("253006")){
            		return "次品";
            	}else if(value.equals("253007")){
            		return "合格品A";
            	}else if(value.equals("253008")){
            		return "合格品B";
            	}else if(value.equals("253009")){
            		return "A1";
            	}else if(value.equals("253010")){
            		return"A2";
            	}else if(value.equals("253011")){
            		return "A3";
            	}else if(value.equals("253012")){
            		return "废品";
            	}else if(value.equals("253013")){
            		return"特废";
            	}else if(value.equals("253014")){
            		return "A4";
            	}else{
            		return"";
            	}
            	
            }
        });
    	regFormatter("atpresentgradecode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
            	
            	if(value.equals("253001")){
            		return "合格";
            	}else if(value.equals("253002")){
            		return "复检合格";
            	}else if(value.equals("253003")){
            		return "不合格";
            	}else if(value.equals("253006")){
            		return "次品";
            	}else if(value.equals("253007")){
            		return "合格品A";
            	}else if(value.equals("253008")){
            		return "合格品B";
            	}else if(value.equals("253009")){
            		return "A1";
            	}else if(value.equals("253010")){
            		return"A2";
            	}else if(value.equals("253011")){
            		return "A3";
            	}else if(value.equals("253012")){
            		return "废品";
            	}else if(value.equals("253013")){
            		return"特废";
            	}else if(value.equals("253014")){
            		return "A4";
            	}else{
            		return"";
            	}
            	
            }
        });
    	regFormatter("previous_status", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
            	
            	if(value.equals("Created")){
            		return "创建";
            	}else if(value.equals("Started")){
            		return "已执行";
            	}else if(value.equals("Completed")){
            		return "已完成";
            	}else if(value.equals("Finished")){
            		return "生产结束";
            	}else if(value.equals("Shipped")){
            		return "发货";
            	}else if(value.equals("Closed")){
            		return "订单关闭";
            	}else if(value.equals("Received")){
            		return "生产恢复";
            	}else{
            		return"";
            	}
            	
            }
        });
    }

}
