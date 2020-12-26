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
import com.bluebirdme.mes.linglong.finalcheck.entity.SortAppearanceBeforeLog;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.SortAppearanceBeforeLogServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class SortAppearanceBeforeLogExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
   	@Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
    	SortAppearanceBeforeLogServiceImpl service = (SortAppearanceBeforeLogServiceImpl) SpringContext
   				.getBean(StringUtils
   						.firstCharToLowerCase("sortAppearanceBeforeLogServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		    // 转换下拉框
   			if (entityList != null) {
   				for (int i = 0; i < entityList.size(); i++) {
   					//判断map中是否包含指定的key
   					if (entityList.get(i).containsKey("sorttype_i")){
   						//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   						entityList.get(i).put("sorttype_i", exportCombox.getDictname(entityList.get(i).get("sorttype_i").toString()));
   					}
   					if (entityList.get(i).containsKey("gradecd_i")){
   						//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   						entityList.get(i).put("gradecd_i", exportCombox.getDictname(entityList.get(i).get("gradecd_i").toString()));
   					}
   					if (entityList.get(i).containsKey("proess_i")){
   						//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   						entityList.get(i).put("proess_i", exportCombox.getDictname(entityList.get(i).get("proess_i").toString()));
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
    
        
    }

}
