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
import com.bluebirdme.mes.linglong.mix.service.EqualMaterialServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class EqualMaterialExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	EqualMaterialServiceImpl service = (EqualMaterialServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("EqualMaterialServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if (entityList.get(i).get("send_state_s") != null) {
   					if (entityList.get(i).get("send_state_s").toString().equals("0")) {
   						entityList.get(i).put("send_state_s", "未下发");
					}else if (entityList.get(i).get("send_state_s").toString().equals("1")) {
						entityList.get(i).put("send_state_s", "已使用");
					}else {
						entityList.get(i).put("send_state_s", "下发失败");
					}
   					if(entityList.get(i).get("created_by_s") != null){
   	   					entityList.get(i).put("created_by_s", exportCombox.getUserName(entityList.get(i).get("created_by_s").toString()));
   	   				}
   	   				if(entityList.get(i).get("send_by_s") != null){
   	   					entityList.get(i).put("send_by_s", exportCombox.getUserName(entityList.get(i).get("send_by_s").toString()));
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
