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
import com.bluebirdme.mes.linglong.halfpart.service.LedgerServiceImpl;
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
public class LedgerExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	LedgerServiceImpl shu = (LedgerServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"LedgerServiceImpl"首字母改为小写
   				.firstCharToLowerCase("LedgerServiceImpl"));
    	filter.set("s_factory_s", LLWebUtils.factory());
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String, Object>> entityList = shu.datagridRowsUDA(filter, page);
   		int code=0;
   		int type=0;
   		
   		if(filter.getFilter().containsKey("materielcode_s")){
   			code = 1;
   		}
   		if(filter.getFilter().containsKey("stocktype_s")){
   			type = 1;
   		}
   		
   		if(code == 1 && type == 1){
   			entityList = shu.allRowsUDA(filter, page);
   		}else if(code == 1 && type == 0){
   			entityList = shu.codeRowsUDA(filter, page);
   		}else if(code == 0 && type == 1){
   			entityList = shu.typeRowsUDA(filter, page);
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
