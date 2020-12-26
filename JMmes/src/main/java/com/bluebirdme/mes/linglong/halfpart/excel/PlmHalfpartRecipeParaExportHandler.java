/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.PlmHalfpartRecipeParaServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class PlmHalfpartRecipeParaExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	PlmHalfpartRecipeParaServiceImpl service = (PlmHalfpartRecipeParaServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"PlmHalfpartRecipeParaServiceImpl"首字母改为小写
   				.firstCharToLowerCase("PlmHalfpartRecipeParaServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		List<Map<String, Object>> listresult = service.searchBasetype_s();
   		
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				
   				if(entityList.get(i).get("basetype_s")!=null){
   					for (Map<String, Object> map : listresult) {
						if(entityList.get(i).get("basetype_s").equals(map.get("ERPCODE_S"))){
							entityList.get(i).put("basetype_s", map.get("DICTNAME_S"));
						}
					}
   				}
   				if (entityList.get(i).get("is_max_min_s") != null) {
					if (entityList.get(i).get("is_max_min_s").equals("A")) {
						entityList.get(i).put("is_max_min_s", "启用");
					} else {
						entityList.get(i).put("is_max_min_s", "停用");
					}
				}

				if (entityList.get(i).get("record_flag_s").equals("A")) {
					entityList.get(i).put("record_flag_s", "启用");
				} else {
					entityList.get(i).put("record_flag_s", "停用");
				}
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
    }

}
