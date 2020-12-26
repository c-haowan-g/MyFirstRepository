package com.bluebirdme.mes.linglong.curing.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.WorkOrderResultServiceImpl;

/**
 * 
 * @author 周清玉
 * 生产明细查询导出
 *
 */
public class WorkOrderResult2ExportHandler extends DefaultExcelExportHandler{

	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
		List<Object> listObj = new ArrayList<Object>();
		WorkOrderResultServiceImpl service = (WorkOrderResultServiceImpl) SpringContext.getBean("workOrderResultServiceImpl");
		filter.set("s_factory_s", LLWebUtils.factory());
		String date=filter.get("production_date_s").substring(filter.get("production_date_s").indexOf(":")+1);
		if(date.length()<=8)
			date=date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8);
		System.out.println(date);
		filter.set("production_date_s", date);
		List<Map<String,Object>> list = service.datagridRowsUDA(filter, page);
		for(Map<String,Object> sje:list){
			listObj.add(sje);
		}
		return listObj;
	}
	
	

	
	@Override
	public void regFormatter() {}

}
