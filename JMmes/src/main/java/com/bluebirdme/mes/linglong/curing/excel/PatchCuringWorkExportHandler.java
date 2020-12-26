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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.PatchCuringWorkServiceImpl;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class PatchCuringWorkExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		PatchCuringWorkServiceImpl service = (PatchCuringWorkServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("patchCuringWorkServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		if (filter.getFilter().containsKey("tyre_barcode_s")) {
			filter.set("begin_created_time", "");
			filter.set("end_created_time", "");
		}
		filter.set("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));
		// 转换下拉框文本
		for (int i = 0; i < entityList.size(); i++) {
			
			entityList.get(i).put("spare10_s",
					exportCombox.getDictName((entityList.get(i).get("spare10_s").toString())));//补录类型
			if (entityList.get(i).get("spare7_s") != null) {
				entityList.get(i).put("spare7_s",
						exportCombox.getDictName((entityList.get(i).get("spare7_s").toString())));//补录原因
			}
			entityList.get(i).put("shift_id_s",
					exportCombox.getDictName((entityList.get(i).get("shift_id_s").toString())));// 班组
			entityList.get(i).put("class_id_s",
					exportCombox.getDictName((entityList.get(i).get("class_id_s").toString())));// 班次
			entityList.get(i).put("quality_status_s",
					exportCombox.getDictName((entityList.get(i).get("quality_status_s").toString())));// 质检状态
			entityList.get(i).put("unit_s", exportCombox.getDictName((entityList.get(i).get("unit_s").toString())));// 单位
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
