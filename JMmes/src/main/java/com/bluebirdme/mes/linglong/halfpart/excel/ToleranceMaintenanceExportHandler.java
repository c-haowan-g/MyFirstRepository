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
import com.bluebirdme.mes.linglong.halfpart.service.ToleranceMaintenanceServiceImpl;
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
public class ToleranceMaintenanceExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	ToleranceMaintenanceServiceImpl service = (ToleranceMaintenanceServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"ToleranceMaintenanceServiceImpl"首字母改为小写
   				.firstCharToLowerCase("toleranceMaintenanceServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   			    // <!-- 机台 -->
   				if(entityList.get(i).get("productionline_s")!=null&&entityList.get(i).get("productionline_s")!=null){
   					entityList.get(i).put("productionline_s", service.getHalfPartProductionLine(entityList.get(i).get("productionline_s").toString()));
   				}
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
        
    }

}
