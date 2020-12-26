package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.DetialServiceImpl;

public class DetialExportHandler extends DefaultExcelExportHandler {
	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		DetialServiceImpl service = (DetialServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("detialServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("exportServiceImpl"));
		if(filter.getFilter().containsKey("barcode_s")){
			filter.set("start_opertime_t","");
			filter.set("end_opertime_t","");
		}
		filter.set("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
		for (int i = 0; i < entityList.size(); i++) {
			// 判断map中是否包含指定的key
			if (entityList.get(i).containsKey("groupcd_s")) {
				// 如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
				entityList.get(i).put("groupcd_s", exportCombox.getDictName(entityList.get(i).get("groupcd_s").toString()));
			}
			// 判断map中是否包含指定的key
			if (entityList.get(i).containsKey("shiftcd_s")) {
				// 如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
				entityList.get(i).put("shiftcd_s", exportCombox.getDictName(entityList.get(i).get("shiftcd_s").toString()));
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
	public void regFormatter() {

	}
}