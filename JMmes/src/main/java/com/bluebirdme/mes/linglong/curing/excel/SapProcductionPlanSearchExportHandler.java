/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.entity.SapProcductionPlanSearch;
import com.bluebirdme.mes.linglong.curing.service.SapProcductionPlanSearchServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class SapProcductionPlanSearchExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
    	List<Object> listATO = new ArrayList<>();
		
    	SapProcductionPlanSearchServiceImpl service = (SapProcductionPlanSearchServiceImpl) SpringContext.getBean("sapProcductionPlanSearchServiceImpl");
		List<SapProcductionPlanSearch> list = service.datagridRows(filter, page, SapProcductionPlanSearch.class);
		
		for(int i =0;i<list.size();i++){
			listATO.add(list.get(i));
		}
		return listATO;
	}
    
    @Override
    public void regFormatter() {}

}
