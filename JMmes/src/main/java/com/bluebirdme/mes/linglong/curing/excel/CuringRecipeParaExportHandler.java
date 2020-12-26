package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.excel.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.CuringRecipePara;
import com.bluebirdme.mes.linglong.curing.service.CuringRecipeParaServiceImpl;

public class CuringRecipeParaExportHandler extends DefaultExcelExportHandler {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		CuringRecipeParaServiceImpl service = (CuringRecipeParaServiceImpl) SpringContext
				.getBean(StringUtils
						.firstCharToLowerCase("curingRecipeParaServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		// 转换人员
		for (int i = 0; i < entityList.size(); i++) {
			if(entityList.get(i).containsKey("changed_by_s")){
				if(entityList.get(i).get("changed_by_s")!=null){
					entityList.get(i).put("changed_by_s", exportCombox.getUserName(entityList.get(i).get("changed_by_s").toString()));	
				}
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
		regFormatter("basetype_s", new IExcelValueFormatter() {

			public String format(Object value) {
				// TODO Auto-generated method stub
				if (value.equals("1")) {
					return "成型";
				} else if (value.equals("2")) {
					return "硫化";
				} else {
					return (String) value;
				}

			}

		});
		regFormatter("record_flag_s", new IExcelValueFormatter() {

			public String format(Object value) {
				// TODO Auto-generated method stub
				if (value.equals("A")) {
					return "启用";
				} else if (value.equals("D")) {
					return "停用";
				} else {
					return (String) value;
				}

			}

		});
	}

}
