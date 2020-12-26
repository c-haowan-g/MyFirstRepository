/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
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
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.ReportOfPlanScheduleServiceImpl;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class ReportOfPlanScheduleExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	ReportOfPlanScheduleServiceImpl service = (ReportOfPlanScheduleServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("reportOfPlanScheduleServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> entityList= service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).put("qty_dayproduct_left_bl", entityList.get(i).get("qty_dayproduct_left_bl")+"%");
			entityList.get(i).put("qty_dayproduct_right_bl", entityList.get(i).get("qty_dayproduct_right_bl")+"%");
			entityList.get(i).put("qty_dayproduct_left_zbwcbfb", entityList.get(i).get("qty_dayproduct_left_zbwcbfb")+"%");
			entityList.get(i).put("qty_dayproduct_left_zwbwcbfb", entityList.get(i).get("qty_dayproduct_left_zwbwcbfb")+"%");
			entityList.get(i).put("qty_dayproduct_left_wbwcbfb", entityList.get(i).get("qty_dayproduct_left_wbwcbfb")+"%");
			entityList.get(i).put("qty_dayproduct_right_wbwcbfb", entityList.get(i).get("qty_dayproduct_right_wbwcbfb")+"%");
			entityList.get(i).put("qty_dayproduct_right_zwcbfb", entityList.get(i).get("qty_dayproduct_right_zwcbfb")+"%");
			entityList.get(i).put("qty_dayproduct_right_wcbwcbfb", entityList.get(i).get("qty_dayproduct_right_wcbwcbfb")+"%");
		}
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				list.add(entityList.get(i));
			}
		}
		return list;
	}

    private String stringConvert(String str){
    	if(str.length()>=5){
    		str=str.substring(0,5);
    		return Double.parseDouble(str)*10+"%";
    	}
    	System.out.println(Double.parseDouble(str)*100+"%");
    	return Double.parseDouble(str)*10+"%";
    }
    
    @Override
    public void regFormatter() {
    
    }

}
