/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.entity.ScanAppearanceLog;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanAppearanceLogServiceImpl;
/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class ScanAppearanceLogExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void regFormatter() {
    }
    public ScanAppearanceLogServiceImpl service = (ScanAppearanceLogServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("ScanAppearanceLogServiceImpl"));
    public ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
   		List<Object> list = new ArrayList<Object>();
   		if(filter.getFilter().containsKey("barcode_s")){
			filter.set("begin_created_time","");
			filter.set("end_created_time","");
		}
   		@SuppressWarnings("unchecked")
		List<Object> entityList = (List<Object>) service.datagridUDA(filter, page);
   		// 转换下拉框
   		for (int i = 0; i < entityList.size(); i++) {
   			
   			if(((ScanAppearanceLog) entityList.get(i)).getIsok_i()==null){
   				break;
   			}
   			
   			
   			if( ((ScanAppearanceLog) entityList.get(i)).getIsok_i().equals("0")){
 				((ScanAppearanceLog) entityList.get(i)).setIsok_i("失败");
 			}
 			else if(((ScanAppearanceLog) entityList.get(i)).getIsok_i().equals("1")){
 				((ScanAppearanceLog) entityList.get(i)).setIsok_i("成功");
 			}
 			if(((ScanAppearanceLog) entityList.get(i)).getWritein_i()!=null){
 				if( ((ScanAppearanceLog) entityList.get(i)).getWritein_i().equals("0")){
 	 				((ScanAppearanceLog) entityList.get(i)).setWritein_i("失败");
 	 			}
 	 			else if(((ScanAppearanceLog) entityList.get(i)).getWritein_i().equals("1")){
 	 				((ScanAppearanceLog) entityList.get(i)).setWritein_i("成功");
 	 			}
 			}else{
 				((ScanAppearanceLog) entityList.get(i)).setWritein_i("");
 			}
 			
   		}
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
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
		// 转换下拉框
   		for (int i = 0; i < entityList.size(); i++) {
   			if(((ScanAppearanceLog) entityList.get(i)).getIsok_i()==null){
   				break;
   			}
   			
   			if( ((ScanAppearanceLog) entityList.get(i)).getIsok_i().equals("0")){
 				((ScanAppearanceLog) entityList.get(i)).setIsok_i("失败");
 			}
 			else if(((ScanAppearanceLog) entityList.get(i)).getIsok_i().equals("1")){
 				((ScanAppearanceLog) entityList.get(i)).setIsok_i("成功");
 			}
 			
 			if( ((ScanAppearanceLog) entityList.get(i)).getWritein_i().equals("0")){
 				((ScanAppearanceLog) entityList.get(i)).setWritein_i("失败");
 			}
 			else if(((ScanAppearanceLog) entityList.get(i)).getWritein_i().equals("1")){
 				((ScanAppearanceLog) entityList.get(i)).setWritein_i("成功");
 			}
   		}
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				list.add(entityList.get(i));
   			}
   		}
		return list;
	}

}
