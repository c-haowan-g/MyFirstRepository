/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.excel.ExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 默认的Excel导出处理器
 * @author Goofy
 * @Date 2018年7月12日 下午2:07:28
 */
public abstract class DefaultExcelExportHandler implements ExcelExportHandler{
	
	public Map<String, IExcelValueFormatter> formatters=new HashMap<String, IExcelValueFormatter>();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
		RockWellBaseServiceImpl<Object> service = (RockWellBaseServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase(serviceName));
		List<Object> list = service.datagridRows(filter, page, null);
		return list;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Object> getRows(Long ids[],String serviceName) {
		RockWellBaseServiceImpl<Object> service = (RockWellBaseServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase(serviceName));
		List<Object> list = service.findByIds(ids);
		return list;
	}
	

	@Override
	public IExcelValueFormatter getFormatter(String field) {
		return this.formatters.get(field);
	}

	public void regFormatter(String field,IExcelValueFormatter formatter){
		this.formatters.put(field, formatter);
	}

}
