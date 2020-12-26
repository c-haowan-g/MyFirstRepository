package com.bluebirdme.mes.linglong.curing.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.FirstMoldDetectionServiceImpl;

public class FirstMoldDetectionHandler extends DefaultExcelExportHandler {
	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		FirstMoldDetectionServiceImpl service = (FirstMoldDetectionServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("firstMoldDetectionServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				if(entityList.get(i).containsKey("shiftcd_s")){
					if(entityList.get(i).get("shiftcd_s")!=null){
						entityList.get(i).put("shiftcd_s", exportCombox.getDictName(entityList.get(i).get("shiftcd_s").toString()));
					}
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