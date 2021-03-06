package com.bluebirdme.mes.linglong.building.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.service.EquipmentRealTimeServiceImpl;

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
public class EquipmentRealTimeExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	EquipmentRealTimeServiceImpl service = (EquipmentRealTimeServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"EquipmentRealTimeServiceImpl"首字母改为小写
   				.firstCharToLowerCase("EquipmentRealTimeServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		filter.getFilter().put("s_factory_s","1");
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
		regFormatter("s_factory_s", new IExcelValueFormatter() {
			@Override
			public String format(Object value) {
				//return sdf.format(new Date((Long)value));
				//s_factory_s
				return null;
			}
		});
    }

}
