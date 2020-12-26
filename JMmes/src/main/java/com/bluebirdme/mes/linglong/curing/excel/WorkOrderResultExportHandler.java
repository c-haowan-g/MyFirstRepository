package com.bluebirdme.mes.linglong.curing.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.CoreDictionaryServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.WorkOrderResultServiceImpl;

/**
 * 
 * @author 时永良
 * 生产明细查询导出
 *
 */
public class WorkOrderResultExportHandler extends DefaultExcelExportHandler{

	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
		WorkOrderResultServiceImpl shu = (WorkOrderResultServiceImpl) SpringContext.getBean("workOrderResultServiceImpl"); 

		List<Object> listATO = new ArrayList<>();
		if(filter.getFilter().containsKey("tyre_barcode_s")){
			filter.set("start_time","");
			filter.set("end_time","");
		}
		List<Map<String, Object>> listshu= shu.datagridRowsTwo(filter, page);
	    CoreDictionaryServiceImpl coredictionary = (CoreDictionaryServiceImpl) SpringContext.getBean("coreDictionaryServiceImpl");

 		Map<String,Object> map =coredictionary.keyValuePair("301","302","305","253");
		// 转换下拉框
		for (int i = 0; i < listshu.size(); i++) {
			//硫化班次
			if(listshu.get(i).get("class_id_s")==null){
				listshu.get(i).put("class_id_s", "");
			}else{
				listshu.get(i).put("class_id_s", map.get(listshu.get(i).get("class_id_s")).toString());
			}
			
			//硫化班组
			if(listshu.get(i).get("shift_id_s")==null){
				listshu.get(i).put("shift_id_s", "");
			}else{
				if (listshu.get(i).get("shift_id_s").toString().equals("301001")) {
					listshu.get(i).put("shift_id_s", "甲班");
				} else if (listshu.get(i).get("shift_id_s").toString().equals("301002")){
					listshu.get(i).put("shift_id_s", "乙班");
				} else if (listshu.get(i).get("shift_id_s").toString().equals("301002")){
					listshu.get(i).put("shift_id_s", "丙班");
				}
			}
			
			//单位
			if(listshu.get(i).get("unit_s")==null){
				listshu.get(i).put("unit_s", "");
			}else{
				listshu.get(i).put("unit_s", map.get(listshu.get(i).get("unit_s")).toString());
			}
			//质量等级
			if(listshu.get(i).get("spare5_s")==null){
				listshu.get(i).put("spare5_s", "");
			}else{
				listshu.get(i).put("spare5_s", map.get(listshu.get(i).get("spare5_s")).toString());
				
			}
			
			if(listshu.get(i).get("spare6_s")==null){
				listshu.get(i).put("spare6_s", "");
			}else{
				if (listshu.get(i).get("spare6_s").equals("1")) {
					listshu.get(i).put("spare6_s", "是");
				} else {
					listshu.get(i).put("spare6_s", "否");
				}
			}
			
			
		}
		
		for(int i =0;i<listshu.size();i++){
			listATO.add(listshu.get(i));
		}
		
		return listATO;
	}
	@Override
	public void regFormatter() {}

}
