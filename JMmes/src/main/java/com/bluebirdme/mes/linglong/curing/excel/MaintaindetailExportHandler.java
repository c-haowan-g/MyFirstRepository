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

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.MaintaindetailServiceImpl;

/**
 * 导出处理器
 * @author 周清玉 设备呼叫信息查询
 * @Date 2019年9月4日 下午2:30:34
 */
public class MaintaindetailExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
   	@Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MaintaindetailServiceImpl service = (MaintaindetailServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("maintaindetailServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if(entityList.get(i).get("equip_type_s")!=null){
   					entityList.get(i).put("equip_type_s", exportCombox.getDictName(entityList.get(i).get("equip_type_s").toString()));
   				}
   				if (entityList.get(i).get("repaircalltype_s")!=null) {
   					entityList.get(i).put("repaircalltype_s", exportCombox.getDictName(entityList.get(i).get("repaircalltype_s").toString()));
				}
   				
   				
   				//结果
   				if(entityList.get(i).get("repick_result_s")!=null){
	   				if(entityList.get(i).get("repick_result_s").equals("0")){
	   					entityList.get(i).put("repick_result_s", "未完成");
	   				}else if(entityList.get(i).get("repick_result_s").equals("1")){
	   					entityList.get(i).put("repick_result_s","已完成");
	   				}else if(entityList.get(i).get("repick_result_s").equals("2")){
	   					entityList.get(i).put("repick_result_s","已确认");
	   				}
   				}
   				//状态
   				if(entityList.get(i).get("repick_status_s").equals("0")){
   					entityList.get(i).put("repick_result_s","呼叫中");
   				}else if(entityList.get(i).get("repick_status_s").equals("1")){
   					entityList.get(i).put("repick_result_s","维修中");
   				}else if(entityList.get(i).get("repick_status_s").equals("2")){
   					entityList.get(i).put("repick_result_s","维修完成");
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
