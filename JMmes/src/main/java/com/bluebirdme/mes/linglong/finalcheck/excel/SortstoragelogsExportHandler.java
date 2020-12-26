package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.excel.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.SortstoragelogsServiceImpl;
import com.ibm.icu.text.SimpleDateFormat;

public class SortstoragelogsExportHandler extends DefaultExcelExportHandler{
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
   	@Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
    	SortstoragelogsServiceImpl service = (SortstoragelogsServiceImpl) SpringContext
   				.getBean(StringUtils
   						.firstCharToLowerCase("sortstoragelogsServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   		List<Map<String, Object>> entityList= service.datagridRowsUDA(filter, page);
   		// 转换下拉框
   		for (int i = 0; i < entityList.size(); i++) {
//   			entityList.get(i).getp
//   			//entityList.get(i).setSorttype_i((exportCombox.getDictName(entityList.get(i).getSorttype_i())));
 			//entityList.get(i).setGradecd_i((exportCombox.getDictName(entityList.get(i).getGradecd_i())));
//   			entityList.get(i).setProess_i((exportCombox.getDictName(entityList.get(i).getProess_i())));
//   			entityList.get(i).setStation_i((exportCombox.getDictName(entityList.get(i).getStation_i())));
   			/*entityList.get(i).setEtype_i((exportCombox.getDictName(entityList.get(i).getEtype_i())));*/
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
