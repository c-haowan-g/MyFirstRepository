/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.building.entity.CxProductionDayPlan;
import com.bluebirdme.mes.linglong.building.service.CxProductionDayPlanServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class ProductionDayPlanExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void regFormatter() {}
        @Override
    public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
        List<Object> listExp = new ArrayList<>();
        CxProductionDayPlanServiceImpl service = (CxProductionDayPlanServiceImpl) SpringContext.getBean("cxProductionDayPlanServiceImpl");
    	List<Map<String, Object>> list= service.datagridRowsUDA(filter, page);
    	ExportServiceImpl exportChangeDict = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
        if(list!=null){
        	for(int i =0;i<list.size();i++){
        		if (list.get(i).containsKey("status_s")){
    				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
       				list.get(i).put("status_s", exportChangeDict.getDictname(list.get(i).get("status_s").toString()));
    			}
        		if (list.get(i).containsKey("production_step_s")){
    				if(list.get(i).get("production_step_s").equals("01")){
    					list.get(i).put("production_step_s", "试制");
    				}
    				if(list.get(i).get("production_step_s").equals("02")){
    					list.get(i).put("production_step_s", "试产");
    				}
    				if(list.get(i).get("production_step_s").equals("03")){
    					list.get(i).put("production_step_s", "投产");
    				}
    			}
        		if (list.get(i).containsKey("customer_flag_s")){
    				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
       				list.get(i).put("customer_flag_s", exportChangeDict.getDictname(list.get(i).get("customer_flag_s").toString()));
    			}
        		listExp.add(list.get(i));
        	}
        }
    	
    	return listExp;
    }

}
