/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.EquipmentMaterialServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class EquipmentMaterialExportHandler extends DefaultExcelExportHandler {

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	EquipmentMaterialServiceImpl service = (EquipmentMaterialServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"EquipmentMaterialServiceImpl"首字母改为小写
   				.firstCharToLowerCase("EquipmentMaterialServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if (entityList.get(i).get("isprimary_s").toString().equals("0")) {
   					entityList.get(i).put("isprimary_s", "是");
				}else {
					entityList.get(i).put("isprimary_s", "否");
				}
   				if (entityList.get(i).get("description") != null) {
   					entityList.get(i).put("description", service.toEquipName(entityList.get(i).get("equipmentcode_s").toString()).get(0).get("equipname"));
				}
   				if (entityList.get(i).get("created_by_s") != null) {
   					entityList.get(i).put("created_by_s", service.toUserName(entityList.get(i).get("created_by_s").toString()).get(0).get("username"));
				}
   				if (entityList.get(i).get("changed_by_s") != null) {
   					entityList.get(i).put("changed_by_s", service.toUserName(entityList.get(i).get("changed_by_s").toString()).get(0).get("username"));
				}
   				if (entityList.get(i).get("materialgroup_s") != null) {
   					entityList.get(i).put("materialgroup_s", service.getNameByGroupCode(entityList.get(i).get("materialgroup_s").toString()).get(0).get("dictname_s"));
				}
   			}
   		}
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
