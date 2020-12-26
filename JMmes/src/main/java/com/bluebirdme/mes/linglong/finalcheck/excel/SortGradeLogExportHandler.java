/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortGradeLog;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.SortGradeLogServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class SortGradeLogExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
   	@Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
    	SortGradeLogServiceImpl service = (SortGradeLogServiceImpl) SpringContext
   				.getBean(StringUtils
   						.firstCharToLowerCase("sortGradeLogServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   		List<SortGradeLog> entityList = service.datagridRows(filter, page,
   				SortGradeLog.class);
   		// 转换下拉框
   		for (int i = 0; i < entityList.size(); i++) {
   			//entityList.get(i).setSorttype_i((exportCombox.getDictName(entityList.get(i).getSorttype_i())));
   			entityList.get(i).setGradecd_i((exportCombox.getDictName(entityList.get(i).getGradecd_i())));
   			entityList.get(i).setProess_i((exportCombox.getDictName(entityList.get(i).getProess_i())));
   			entityList.get(i).setStation_i((exportCombox.getDictName(entityList.get(i).getStation_i())));
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
