/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.building.service.WorkorderResultServiceImpl;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class WorkorderResultNotCuringExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	WorkorderResultServiceImpl shu = (WorkorderResultServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("workorderResultServiceImpl"));

		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu = shu.datagridRowsUDA4(filter, page);
		if (listshu != null) {
			for (int i = 0; i < listshu.size(); i++) {
				listATO.add(listshu.get(i));
			}
		}
		return listATO;
	}
    
    
    @Override
    public void regFormatter() {
    }
}
