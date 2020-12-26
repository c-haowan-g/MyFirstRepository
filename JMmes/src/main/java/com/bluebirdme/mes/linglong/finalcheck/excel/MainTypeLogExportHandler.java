/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

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
import com.bluebirdme.mes.linglong.finalcheck.service.MainTypeLogServiceImpl;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class MainTypeLogExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		MainTypeLogServiceImpl service = (MainTypeLogServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("mainTypeLogServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));
		if (filter.getFilter().containsKey("barcode_s")) {
			filter.set("begin_created_time", "");
			filter.set("end_created_time", "");
		}
		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
		for (int i = 0; i < entityList.size(); i++) {
			// 判断map中是否包含指定的key
			if (entityList.get(i).containsKey("sync_flag_s")) {
				// 如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
				entityList.get(i).put("Sync_flag_s",
						entityList.get(i).get("sync_flag_s").toString() == "A" ? "增加" : "修改");
			}
		}
		/*
		 * // 转换下拉框 for (int i = 0; i < entityList.size(); i++) {
		 * entityList.get(
		 * i).setSorttype_i((exportCombox.getDictName(entityList.get
		 * (i).getSorttype_i())));
		 * entityList.get(i).setGradecd_i((exportCombox.getDictName
		 * (entityList.get(i).getGradecd_i())));
		 * entityList.get(i).setProess_i((exportCombox
		 * .getDictName(entityList.get(i).getProess_i())));
		 * entityList.get(i).setEtype_i
		 * ((exportCombox.getDictName(entityList.get(i).getEtype_i()))); }
		 */
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
