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
import com.bluebirdme.mes.linglong.halfpart.service.EquipmentCapaCityServiceImpl;
//import com.bluebirdme.mes.linglong.semicomponen.service.WorkerLoginRecordServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.Reas;
import com.bluebirdme.mes.linglong.finalcheck.service.ReasServiceImpl;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class EquipmentcapacityExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	EquipmentCapaCityServiceImpl service=(EquipmentCapaCityServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("EquipmentCapaCityServiceImpl"));
		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> list = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		List<Map<String, Object>> listresult = service.searchDescription();
		for (int i = 0; i < list.size(); i++) {
			filter.set("s_factory_s", LLWebUtils.factory());
	    	String date=filter.get("equipmentcode_s");
	    	for(int j = 0; j<listresult.size();j++){
	    		if(listresult.get(j).get("P_LINE_NAME").equals(list.get(i).get("equipmentcode_s"))){
	    			list.get(i).put("equipmentcode_s",listresult.get(j).get("DESCRIPTION").toString());
	    		}
	    	}
			list.get(i).put("materialgroup_s",
					exportCombox.getDictName(list.get(i).get("materialgroup_s").toString()));
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