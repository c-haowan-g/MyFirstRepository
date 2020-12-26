package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.util.ArrayList;
import java.util.List;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.DetialAll;
import com.bluebirdme.mes.linglong.finalcheck.service.DetialServiceImpl;

public class Detial2ExportHandler extends DefaultExcelExportHandler {
	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("agenc_no_s", FactoryConstant.JING_MEN_CODE);
		if(filter.getFilter().containsKey("barcode_s")){
			filter.set("start_opertime_t","");
			filter.set("end_opertime_t","");
		}
		DetialServiceImpl service = (DetialServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("detialServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		List<DetialAll> entityList = service.datagridRows2(filter, page,
				DetialAll.class);
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