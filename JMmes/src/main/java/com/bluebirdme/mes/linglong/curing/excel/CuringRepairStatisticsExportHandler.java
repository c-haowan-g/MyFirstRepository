/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.CuringRepairStatisticsServiceImpl;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class CuringRepairStatisticsExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	CuringRepairStatisticsServiceImpl service = (CuringRepairStatisticsServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("curingRepairStatisticsServiceImpl"));
    	
    	filter.set("s_factory_s", LLWebUtils.factory());
    	List<Map<String,Object>> entityList = null;
   		List<Object> list = new ArrayList<Object>();
   		int work_id = 0;
   		int material_code = 0;
   		
   		if(filter.get("month_s")!=null){
			filter.set("month_s", filter.get("month_s").replace("-", ""));
		}
   		
   		if(filter.getFilter().containsKey("work_id")){
   			work_id = 1;
   		}
   		if(filter.getFilter().containsKey("material_code")){
   			material_code = 1;
   		}
   		
   		if(work_id == 1 && material_code == 1){
   			entityList = service.datagridRowsUDA(filter, page);
   			
   		}
   		if(work_id == 1 && material_code == 0){
   			entityList = service.datagridRowsUDA2(filter, page);
   		}
   		if(work_id == 0 && material_code == 1){
   			entityList = service.datagridRowsUDA3(filter, page);
   		}
   		
   		// 转换数据，数据赋值
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
