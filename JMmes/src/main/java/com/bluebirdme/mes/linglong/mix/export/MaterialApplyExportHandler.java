/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.export;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.mix.service.MaterialApplyServiceImpl;
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
public class MaterialApplyExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MaterialApplyServiceImpl service = (MaterialApplyServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MaterialApplyServiceImpl"首字母改为小写
   				.firstCharToLowerCase("MaterialApplyServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		filter.set("s_factory_s", LLWebUtils.factory());
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if(entityList.get(i).get("prod_shift_s") != null){
   					entityList.get(i).put("prod_shift_s", exportCombox.getDictname(entityList.get(i).get("prod_shift_s").toString()));
   				}
   				if(entityList.get(i).get("prod_type_s") != null){
   					entityList.get(i).put("prod_type_s", exportCombox.getDictname(entityList.get(i).get("prod_type_s").toString()));
   				}
   				if(entityList.get(i).get("status_check_s") != null){
   					entityList.get(i).put("status_check_s", exportCombox.getDictname(entityList.get(i).get("status_check_s").toString()));
   				}
   				if(entityList.get(i).get("check_by_s") != null){
   					entityList.get(i).put("check_by_s", exportCombox.getUserName(entityList.get(i).get("check_by_s").toString()));
   				}
   				if(entityList.get(i).get("close_by_s") != null){
   					entityList.get(i).put("close_by_s", exportCombox.getUserName(entityList.get(i).get("close_by_s").toString()));
   				}
   				if(entityList.get(i).get("changed_by_s") != null){
   					entityList.get(i).put("changed_by_s", exportCombox.getUserName(entityList.get(i).get("changed_by_s").toString()));
   				}
   				if(entityList.get(i).get("created_by_s") != null){
   					entityList.get(i).put("created_by_s", exportCombox.getUserName(entityList.get(i).get("created_by_s").toString()));
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
