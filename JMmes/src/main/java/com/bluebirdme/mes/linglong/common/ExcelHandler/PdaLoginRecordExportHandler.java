/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.ExcelHandler;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.PdaLoginRecordServiceImpl;

import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class PdaLoginRecordExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	PdaLoginRecordServiceImpl service = (PdaLoginRecordServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"PdaLoginRecordServiceImpl"首字母改为小写
   				.firstCharToLowerCase("PdaLoginRecordServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if(entityList.get(i).get("class_id_s")!=null){
   					if (entityList.get(i).get("class_id_s").toString().equals("302001")) {
   						entityList.get(i).put("class_id_s", "早班");
					}else if (entityList.get(i).get("class_id_s").toString().equals("302002")) {
						entityList.get(i).put("class_id_s", "中班");
					}else {
						entityList.get(i).put("class_id_s", "晚班");
					}
   				}
   				if(entityList.get(i).get("group_id_s")!=null){
   					if (entityList.get(i).get("group_id_s").toString().equals("301001")) {
   						entityList.get(i).put("group_id_s", "甲班");
					}else if (entityList.get(i).get("group_id_s").toString().equals("301002")) {
						entityList.get(i).put("group_id_s", "乙班");
					}else {
						entityList.get(i).put("group_id_s", "丙班");
					}
   				}
   				if(entityList.get(i).get("s_factory_s")!=null){
   					if (entityList.get(i).get("s_factory_s").toString().equals("1")) {
   						entityList.get(i).put("s_factory_s", "全钢");
					}else {
						entityList.get(i).put("s_factory_s", "半钢");
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
