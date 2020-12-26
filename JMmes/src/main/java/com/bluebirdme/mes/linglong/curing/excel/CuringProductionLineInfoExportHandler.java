/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class CuringProductionLineInfoExportHandler extends DefaultExcelExportHandler {
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
    	RockWellUDABaseServiceImpl<Object> service = (RockWellUDABaseServiceImpl) SpringContext.getBean("curingProductionLineInfoServiceImpl");
		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> list = service.datagridRowsUDA(filter, page);
		
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		// 转换下拉框
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				// <!-- 机台组 基础数据211 -->
				list.get(i).put("Machinegroup_s",exportCombox.getDictname((String)list.get(i).get("Machinegroup_s")));
			}
		} 
		// 转换下拉框
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				// <!-- 硫化机状态 基础数据214 -->
				list.get(i).put("Status_s",exportCombox.getDictname((String)list.get(i).get("Status_s")));
			}
		} 
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				listATO.add(list.get(i));
			}
		}
		return listATO;
	}

	@Override
	public void regFormatter() {
		// TODO Auto-generated method stub
        
    }

}
