/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.entity.SapProductionPlan;
import com.bluebirdme.mes.linglong.curing.service.SapProductionPlanServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class SapProductionPlanExportHandler extends DefaultExcelExportHandler {
	
	private SapProductionPlanServiceImpl service=(SapProductionPlanServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("SapProductionPlanServiceImpl"));
    private ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext
			.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));   
    
    /* (non-Javadoc)
	 * @see com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler#getRows(com.bluebirdme.core.system.web.Filter, com.bluebirdme.core.system.web.Page, java.lang.String)
	 */
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		if(filter.get("month_i")!=null){
			filter.set("month_i", filter.get("month_i").replace("-", ""));
		}
		
		List<Object> list = new ArrayList<Object>();
   		List<SapProductionPlan> entityList = service.datagridRows(filter, page,SapProductionPlan.class);
   		ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   		// 转换下拉框
   		for (int i = 0; i < entityList.size(); i++) {//spare1_s
   			entityList.get(i).setPlan_status_s(exportServiceImpl.getDictName(entityList.get(i).getPlan_status_s()));
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
