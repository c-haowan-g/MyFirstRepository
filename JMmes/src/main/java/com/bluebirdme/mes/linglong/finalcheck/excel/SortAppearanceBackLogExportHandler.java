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
import com.bluebirdme.mes.linglong.finalcheck.entity.SortAppearanceBackLog;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.SortAppearanceBackLogServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class SortAppearanceBackLogExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
   	@Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
    	SortAppearanceBackLogServiceImpl service = (SortAppearanceBackLogServiceImpl) SpringContext
   				.getBean(StringUtils
   						.firstCharToLowerCase("sortAppearanceBackLogServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   		List<Map<String, Object>> entityList= service.datagridRowsUDA(filter, page);
   		// 转换下拉框
   		/*	for (int i = 0; i < entityList.size(); i++) {
   				System.out.println(entityList.get(i).getEnttype_i());
   				entityList.get(i).setEnttype_i(exportCombox.getDictName(entityList.get(i).getEnttype_i()));
   				entityList.get(i).setIswork_i(exportCombox.getDictName(entityList.get(i).getIswork_i()));
   				entityList.get(i).setSpare1_s(exportCombox.getDictName(entityList.get(i).getSpare1_s()));
   			}*/
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
