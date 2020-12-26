package com.bluebirdme.mes.linglong.curing.excel;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.entity.VulcanizationGradeYieldPrint;
import com.bluebirdme.mes.linglong.curing.service.MachineControlServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.VulcanizationGradeYieldPrintServiceImpl;

/**
 * 硫化等级产量报表
 * 
 * @author syl
 * @Date 2020年3月17日08:18:04
 */
public class VulcanizationGradeYieldPrintExportHandler extends DefaultExcelExportHandler {
	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	HttpSession session = request.getSession();

	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		VulcanizationGradeYieldPrintServiceImpl service = (VulcanizationGradeYieldPrintServiceImpl) SpringContext.getBean("vulcanizationGradeYieldPrintServiceImpl");

		List<Object> list = new ArrayList<Object>();
		List<VulcanizationGradeYieldPrint> entityList = service.datagridRows(filter, page, VulcanizationGradeYieldPrint.class);
		DecimalFormat df = new DecimalFormat(".00");
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				if(entityList.get(i).getActive_output().equals("0")){
					entityList.get(i).setFirst_grade("0.00%");		
				}else{
					entityList.get(i).setFirst_grade(df.format((Double.valueOf(entityList.get(i).getGradea())/Double.valueOf(entityList.get(i).getActive_output())*10000/100))+"%");	
				}
				if(entityList.get(i).getActive_output().equals("0")){
					entityList.get(i).setPercentofpass("0.00%");		
				}else{
					entityList.get(i).setPercentofpass(df.format((Double.valueOf(entityList.get(i).getGradea()+entityList.get(i).getSecondlevel())/Double.valueOf(entityList.get(i).getActive_output())*10000/100))+"%");	
				}
				if(entityList.get(i).getQuantity_plan().equals("0")){
					entityList.get(i).setQualitycompletionrate("0.00%");		
				}else{
					entityList.get(i).setQualitycompletionrate(df.format((Double.valueOf(entityList.get(i).getActive_output())/Double.valueOf(entityList.get(i).getQuantity_plan())*10000/100))+"%");	
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
