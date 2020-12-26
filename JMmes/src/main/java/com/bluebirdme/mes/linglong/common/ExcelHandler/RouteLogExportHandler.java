/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.ExcelHandler;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.RouteLogServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * 硫化机台报警查询(设备报警信息表)
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class RouteLogExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	RouteLogServiceImpl service = (RouteLogServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase(serviceName));
    	
    	List<Object> list = new ArrayList<Object>();
    	List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
    	
    	if(null != entityList){
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
