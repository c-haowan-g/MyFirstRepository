/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.WorkOrderResultPrintServiceImpl;
import com.ibm.icu.text.DecimalFormat;

/**
 * 2019-03-06
 * @author qingyu_zhou
 *硫化产量报表
 */
public class WorkOrderResultPrintExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void regFormatter() {
    	
    	regFormatter("class_id_s", new IExcelValueFormatter() {
			@Override
			public String format(Object value) {
				String a = null;
				if(value!=null){
					if (value.equals("302001")) {
						a = "早班";
					} else if(value.equals("302002")){
						a = "中班";
					}else if(value.equals("302003")){
						a = "晚班";
					}
				}
				
				return a;
			}
		});
    }

    
    @Override
	public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
    	List<Object> listObj = new ArrayList<Object>();
    	WorkOrderResultPrintServiceImpl service = (WorkOrderResultPrintServiceImpl) SpringContext.getBean("workOrderResultPrintServiceImpl");
		List<Map<String,Object>> list = service.datagridRowsUDA(filter, page);
		for(Map<String,Object> sje:list){
			if(sje.get("spare1_s")==""||sje.get("spare1_s")==null){
				sje.put("curing_openmoulddate", "");
//				System.out.println("----------------------我是分割线---------------------");
			}else{
//				System.out.println(sje.getSpare1_s().toString());
		        double hours =formatDouble(Double.valueOf(sje.get("spare1_s").toString())/60);
		        //单台设备定额
		    	double de= 450/(new Double(hours))*2;
		    	double dthours= 8/(de*10);
		    	//按照格式保留小数位
		    	DecimalFormat decimalFormat = new DecimalFormat("#0.0000");
		    	Double totalquantity=null;
		    	if(sje.get("totalquantity")!=null&&sje.get("totalquantity")!=""){
		    		 totalquantity=(Double)sje.get("totalquantity");
		    	}
		    	String curing_openmoulddate=String.valueOf(decimalFormat.format( dthours*totalquantity));
		    	//完成工时
		    	sje.put("curing_openmoulddate", curing_openmoulddate);
		    	//足额完成率
		    	double curing_closemoulddate=Math.floor((dthours/8)*100*1000)/1000;
		    	sje.put("curing_closemoulddate", String.valueOf(curing_closemoulddate)+"%");
		    	//质量达成率
		    	Double qualitycompletionrate=null;
		    	if(sje.get("gradea")!=null&&sje.get("gradea")!=""){
		    		qualitycompletionrate =Math.floor(((new Double(sje.get("gradea").toString()))/(new Double(totalquantity))/0.996*100)*1000)/1000;
		    	}
		    	sje.put("qualitycompletionrate", String.valueOf(qualitycompletionrate)+"%");
			}
	    	
			listObj.add(sje);
		}
		return listObj;
	}

    //四舍五入并保留两位小数
    public static double formatDouble(double d) {
        return (double)Math.round(d*100)/100;
    }
}
