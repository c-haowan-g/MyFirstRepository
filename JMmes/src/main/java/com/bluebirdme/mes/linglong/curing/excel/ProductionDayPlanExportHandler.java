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

import com.bluebirdme.mes.linglong.curing.entity.ProductionDayPlan;
import com.bluebirdme.mes.linglong.curing.service.ProductionDayPlanServiceImpl;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class ProductionDayPlanExportHandler extends DefaultExcelExportHandler {
    
	@Override
	public void regFormatter() {

	}
	private ProductionDayPlanServiceImpl service=(ProductionDayPlanServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("ProductionDayPlanServiceImpl"));
    private ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext
			.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));   
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
	   			throws Exception {
   		List<Object> list = new ArrayList<Object>();
   		List<ProductionDayPlan> entityList = service.datagridRows(filter, page,ProductionDayPlan.class);
   		ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   		// 转换下拉框
   		for (int i = 0; i < entityList.size(); i++) {//spare1_s
   			entityList.get(i).setStatus_s(exportServiceImpl.getDictName(entityList.get(i).getStatus_s()));
   			entityList.get(i).setProduction_step_left_s(exportServiceImpl.getDictName(entityList.get(i).getProduction_step_left_s()));
   			entityList.get(i).setProduction_step_right_s(exportServiceImpl.getDictName(entityList.get(i).getProduction_step_right_s()));
   		   }
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}

}
