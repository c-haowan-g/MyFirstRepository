/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.HalfpartMachineFormulaSearchServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

public class HalfpartMachineFormulaSearchExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	HalfpartMachineFormulaSearchServiceImpl service = (HalfpartMachineFormulaSearchServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("halfpartMachineFormulaSearchServiceImpl"));
    	List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> list = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		List<Map<String, Object>> listresult = service.searchEquip_code_s();
   		// 转换数据，数据赋值
   			for (int i = 0; i < list.size(); i++) {
   				filter.set("s_factory_s", LLWebUtils.factory());
   		    	String date=filter.get("equip_code_s");
   		    	for(int j = 0; j<listresult.size();j++){
   		    		if(listresult.get(j).get("P_LINE_NAME").equals(list.get(i).get("equip_code_s"))){
   		    			list.get(i).put("equip_code_s",listresult.get(j).get("DESCRIPTION").toString());
   		    		}
   		    	}
    		   //如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
       	       list.get(i).put("production_step_s", exportCombox.getDictname(list.get(i).get("production_step_s").toString()));
    			
   		    	
   			}
   			for(Map<String,Object> sje:list){
   				listATO.add(sje);
   			}
   		return listATO;
   	}
    
    @Override
    public void regFormatter() {
        
    }

}
