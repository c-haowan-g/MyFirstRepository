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

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.service.EntModelServiceImpl;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class EntModelExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private EntModelServiceImpl service = (EntModelServiceImpl) SpringContext.getBean(StringUtils
			.firstCharToLowerCase("EntModelServiceImpl"));
	private ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils
			.firstCharToLowerCase("exportServiceImpl"));

	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));
		// 转换下拉框
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).put("uda_0", exportServiceImpl.getDictName(entityList.get(i).get("uda_0").toString()));
			entityList.get(i).put("equip_type_s",
					exportServiceImpl.getDictName(entityList.get(i).get("equip_type_s").toString()));
			entityList.get(i).put("status_s",
					exportServiceImpl.getDictName(entityList.get(i).get("status_s").toString()));
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

		// 是强制执行，1是，0，否
		regFormatter("device_valid_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if (value != null) {
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				} else {
					return null;
				}
			}
		});
	}
}
