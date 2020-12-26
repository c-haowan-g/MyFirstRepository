/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.service.TireCarRealServiceImpl;

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
public class TireCarRealExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	TireCarRealServiceImpl service = (TireCarRealServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"TireCarRealServiceImpl"首字母改为小写
   				.firstCharToLowerCase("TireCarRealServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if(entityList.get(i).get("tire_shelf_code_s")!=null){
   					entityList.get(i).put("tire_shelf_code_s", entityList.get(i).get("tire_shelf_code_s").toString());
   				}
   				if(entityList.get(i).get("tire_shelf_description_s")!=null){
   					entityList.get(i).put("tire_shelf_description_s", entityList.get(i).get("tire_shelf_description_s").toString());
   				}
   				if(entityList.get(i).get("tire_shelf_name_s")!=null){
   					entityList.get(i).put("tire_shelf_name_s", entityList.get(i).get("tire_shelf_name_s").toString());
   				}
   				if(entityList.get(i).get("barcode_s")!=null){
   					entityList.get(i).put("barcode_s", entityList.get(i).get("barcode_s").toString());
   				}
   				if(entityList.get(i).get("greentire_beyondtime_f")!=null){
   					entityList.get(i).put("greentire_beyondtime_f", entityList.get(i).get("greentire_beyondtime_f").toString());
   				}
   				if(entityList.get(i).get("greentire_parktime_f")!=null){
   					entityList.get(i).put("greentire_parktime_f", entityList.get(i).get("greentire_parktime_f").toString());
   				}
   				if(entityList.get(i).get("instoretime_t")!=null){
   					entityList.get(i).put("instoretime_t", entityList.get(i).get("instoretime_t").toString());
   				}
   				if(entityList.get(i).get("material_code_s")!=null){
   					entityList.get(i).put("material_code_s", entityList.get(i).get("material_code_s").toString());
   				}
   				if(entityList.get(i).get("material_spec_s")!=null){
   					entityList.get(i).put("material_spec_s", entityList.get(i).get("material_spec_s").toString());
   				}
   				if(entityList.get(i).get("placebar_s")!=null){
   					entityList.get(i).put("placebar_s", entityList.get(i).get("placebar_s").toString());
   				}
   				if(entityList.get(i).get("placestatus_s")!=null){
   					entityList.get(i).put("placestatus_s", exportCombox.getDictname(entityList.get(i).get("placestatus_s").toString()));
   				}
   				if(entityList.get(i).get("storetype_s")!=null){
   					entityList.get(i).put("storetype_s", entityList.get(i).get("storetype_s").toString());
   				}
   				if(entityList.get(i).get("changed_by_s")!=null){
   					entityList.get(i).put("changed_by_s", exportCombox.getUserName(entityList.get(i).get("changed_by_s").toString()));
   				}
   				if(entityList.get(i).get("changed_time_t")!=null){
   					entityList.get(i).put("changed_time_t", entityList.get(i).get("changed_time_t"));
   				}
   				if(entityList.get(i).get("created_by_s")!=null){
   					entityList.get(i).put("created_by_s", exportCombox.getUserName(entityList.get(i).get("created_by_s").toString()));
   				}
   				if(entityList.get(i).get("created_time_t")!=null){
   					entityList.get(i).put("created_time_t", entityList.get(i).get("created_time_t"));
   				}
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
    }

}
