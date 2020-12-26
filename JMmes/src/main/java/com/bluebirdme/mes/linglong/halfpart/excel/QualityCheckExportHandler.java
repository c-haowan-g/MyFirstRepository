/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.halfpart.service.QualityCheckServiceImpl;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class QualityCheckExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	QualityCheckServiceImpl service = (QualityCheckServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"QualityCheckServiceImpl"首字母改为小写
   				.firstCharToLowerCase("QualityCheckServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				Map<String, Object> map = entityList.get(i);
   				String spare7_s = (String) map.get("spare7_s");
   				map.put("spare7_s", spare7_s.replace("<br/>", ";"));
   				String tyre_status_code_s = (String) map.get("tyre_status_code_s");
   				if(tyre_status_code_s != null && !"".equals(tyre_status_code_s)){
   					if(tyre_status_code_s.equals("0")){
   						map.put("tyre_status_code_s", "不合格");
   					}else if(tyre_status_code_s.equals("1")){
   						map.put("tyre_status_code_s", "合格");
   					}
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
