/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.curing.service.CuringMoldServiceImpl;
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
public class CuringMoldExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	CuringMoldServiceImpl service = (CuringMoldServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"CuringMoldServiceImpl"首字母改为小写
   				.firstCharToLowerCase("CuringMoldServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		filter.set("s_factory_s", LLWebUtils.factory());
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if(entityList.get(i).get("mold_type_s") != null){
   					if (entityList.get(i).get("mold_type_s").toString().equals("205001")) {
   						entityList.get(i).put("mold_type_s", "整套");
					}else if (entityList.get(i).get("mold_type_s").toString().equals("205002")){
						entityList.get(i).put("mold_type_s", "侧板");		
					}else {
						entityList.get(i).put("mold_type_s", "花纹块");		
					}
   				}
   				if(entityList.get(i).get("mold_desc_s") != null){
   					if (entityList.get(i).get("mold_desc_s").toString().equals("239001")) {
   						entityList.get(i).put("mold_desc_s", "活络模");
					}else if (entityList.get(i).get("mold_desc_s").toString().equals("239002")){
						entityList.get(i).put("mold_desc_s", "两半模");		
					}else {
						entityList.get(i).put("mold_desc_s", "抽真空");		
					}
   				}
   				if(entityList.get(i).get("repair_state_s") != null){
   					if (entityList.get(i).get("repair_state_s").toString().equals("1")) {
   						entityList.get(i).put("repair_state_s", "可以");
					}else {
						entityList.get(i).put("repair_state_s", "不可以");		
					}
   				}
   				if(entityList.get(i).get("statues_id_s") != null){
   					if (entityList.get(i).get("statues_id_s").toString().equals("1")) {
   						entityList.get(i).put("statues_id_s", "已出库");
					}else if(entityList.get(i).get("statues_id_s").toString().equals("2")) {
						entityList.get(i).put("statues_id_s", "已入库");		
					}else if(entityList.get(i).get("statues_id_s").toString().equals("3")) {
						entityList.get(i).put("statues_id_s", "已报备");		
					}else if(entityList.get(i).get("statues_id_s").toString().equals("4")) {
						entityList.get(i).put("statues_id_s", "使用中");		
					}else if(entityList.get(i).get("statues_id_s").toString().equals("5")) {
						entityList.get(i).put("statues_id_s", "已报废");		
					}else {
						entityList.get(i).put("statues_id_s", "未入库");		
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
