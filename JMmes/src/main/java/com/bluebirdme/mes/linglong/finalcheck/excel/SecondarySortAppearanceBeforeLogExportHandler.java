/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.service.SecondarySortAppearanceBeforeLogServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class SecondarySortAppearanceBeforeLogExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
    	SecondarySortAppearanceBeforeLogServiceImpl service = (SecondarySortAppearanceBeforeLogServiceImpl) SpringContext
   				.getBean(StringUtils
   						.firstCharToLowerCase("secondarySortAppearanceBeforeLogServiceImpl"));
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
