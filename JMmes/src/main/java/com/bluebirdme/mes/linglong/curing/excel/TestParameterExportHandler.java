/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.entity.TestParameter;
import com.bluebirdme.mes.linglong.curing.service.TestParameterServiceImpl;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class TestParameterExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		TestParameterServiceImpl service = (TestParameterServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("testParameterServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		filter.set("equip_code_s", "");
		List<TestParameter> entityList = service.datagridRows(filter, page, TestParameter.class);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));

		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				if (entityList.get(i).getChanged_by_s() != null) {
					entityList.get(i).setChanged_by_s(exportCombox.getUserName(entityList.get(i).getChanged_by_s().toString()));
				}
				list.add(entityList.get(i));
			}
		}
		return list;
	}

	@Override
	public void regFormatter() {
		regFormatter("test_flag_s", new IExcelValueFormatter() {

			public String format(Object value) {
				// TODO Auto-generated method stub
				if (value == null) {
					return "";
				} else if (value.equals("0")) {
					return "否";
				} else {
					return "是";
				}
			}
		});
	}

}
