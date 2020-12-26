/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.service.ResumeServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class ResumeExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	ResumeServiceImpl service = (ResumeServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"ResumeServiceImpl"首字母改为小写
   				.firstCharToLowerCase("ResumeServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		filter.set("s_factory_s", LLWebUtils.factory());
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				filter.set("s_factory_s", LLWebUtils.factory());
   				if (entityList.get(i).get("spare1_s").toString().equals("252008")) {
   					entityList.get(i).put("spare1_s", "外观");
				}else if(entityList.get(i).get("spare1_s").toString().equals("252009")){
					entityList.get(i).put("spare1_s", "x光");
				}else{
					entityList.get(i).put("spare1_s", "硫化");
				}
   				if(entityList.get(i).get("curinggradecode_s")!=null&&entityList.get(i).get("curinggradecode_s")!=null){
   					entityList.get(i).put("curinggradecode_s", exportCombox.getDictname(entityList.get(i).get("curinggradecode_s").toString()));
   				}
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   				list.add(entityList.get(i));
   			}
   		}
//   		if (entityList != null) {
//   			for (int i = 0; i < entityList.size(); i++) {
//   				list.add(entityList.get(i));
//   			}
//   		}
   		return list;
   	}
    @Override
    public void regFormatter() {
    
       
        
    }

}
