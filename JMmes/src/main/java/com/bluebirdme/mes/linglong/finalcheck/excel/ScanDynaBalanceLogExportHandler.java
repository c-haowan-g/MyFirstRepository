/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanDynaBalanceLog;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortltemAll;
import com.bluebirdme.mes.linglong.finalcheck.service.CheckXrayLogServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanDynaBalanceLogServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanXrayLogServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.SortltemServiceImpl;

/**
 * 导出处理器
 * @author majb
 * @Date 2018年7月13日 下午2:30:34
 */
public class ScanDynaBalanceLogExportHandler extends DefaultExcelExportHandler {
	ScanDynaBalanceLogServiceImpl service = (ScanDynaBalanceLogServiceImpl) SpringContext.getBean("scanDynaBalanceLogServiceImpl"); 
	  
    @Override
    public void regFormatter() {
    }	
    
    @Override
 	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
    	

 		List<Object> list = new ArrayList<>();
 		/*if(filter.getFilter().containsKey("barcode_s")){
			filter.set("begin_created_time","");
			filter.set("end_created_time","");
		}*/
 		@SuppressWarnings("unchecked")
		List<Map<String, Object>> entityList= service.datagridRowsUDA(filter, page);
 		ExportServiceImpl exportChangeDict = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
 		for (int i = 0; i < entityList.size(); i++) {
 			if (entityList.get(i).containsKey("isok_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
 				if(entityList.get(i).get("isok_s").equals("0")){
 					entityList.get(i).put("isok_s", "失败");
 				}else if(entityList.get(i).get("isok_s").equals("1")){
 					entityList.get(i).put("isok_s", "成功");
 				}
			}
 			if (entityList.get(i).containsKey("writein_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
 				if(entityList.get(i).get("writein_s").equals("0")){
 					entityList.get(i).put("writein_s", "失败");
 				}else if(entityList.get(i).get("writein_s").equals("1")){
 					entityList.get(i).put("writein_s", "成功");
 				}
			}
 			if (entityList.get(i).containsKey("etype_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
 				if(entityList.get(i).get("etype_s").equals("0")){
 					entityList.get(i).put("etype_s", "无");
 				}else {
 					entityList.get(i).put("etype_s", exportChangeDict.getDictname(entityList.get(i).get("etype_s").toString()));
 				}
			}
 		}
 		for(int i =0;i<entityList.size();i++){
 			
 			list.add(entityList.get(i));
 		}
 		
 		return list;
 	}
    /*@Override
	public List<Object> getRows(Long ids[],String serviceName) {
		List<Object> list = new ArrayList<Object>();
		Filter filter=new Filter();
		String idsString = "";
		for(int i=0;i<ids.length;i++){
			if(ids[i].toString().equals("")){
				break;
			}
			idsString=idsString+","+ids[i].toString();
		}
		idsString=idsString.substring(1);
		filter.set("ids", "in:"+idsString);
		Page page=new Page();
		page.setAll(1);
		List<Object> entityList = null ;
		try {
			entityList = (List<Object>) service.datagridUDA(filter, page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		for (int i = 0; i < entityList.size(); i++) {
			if( ((ScanDynaBalanceLog)entityList.get(i)).getIsok_s().equals("0")){
				((ScanDynaBalanceLog)entityList.get(i)).setIsok_s("失败");
 			}
 			else if(((ScanDynaBalanceLog)entityList.get(i)).getIsok_s().equals("1")){
 				((ScanDynaBalanceLog)entityList.get(i)).setIsok_s("成功");
 			}
 			
 			if( ((ScanDynaBalanceLog)entityList.get(i)).getWritein_s().equals("0")){
 				((ScanDynaBalanceLog)entityList.get(i)).setWritein_s("失败");
 			}
 			else if(((ScanDynaBalanceLog)entityList.get(i)).getWritein_s().equals("1")){
 				((ScanDynaBalanceLog)entityList.get(i)).setWritein_s("成功");
 			}
		}
		for(int i =0;i<entityList.size();i++){
 			list.add(entityList.get(i));
 		}
 		return list;
    }*/
}
