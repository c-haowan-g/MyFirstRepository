/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.service.CheckXrayLogServiceImpl;

/**
 * 导出处理器
 * @author majb
 * @Date 2018年7月13日 下午2:30:34
 */
public class CheckXrayLogExportHandler extends DefaultExcelExportHandler {
    
	
	
	
	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
		CheckXrayLogServiceImpl shu = (CheckXrayLogServiceImpl) SpringContext.getBean("checkXrayLogServiceImpl"); 

		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu= shu.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		// 转换下拉框
		if (listshu != null) {
			for (int i = 0; i < listshu.size(); i++) {
				//当前工序
				//判断map中是否包含指定的key
				if (listshu.get(i).containsKey("proess_s")){
					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
					listshu.get(i).put("proess_s", exportCombox.getDictname(listshu.get(i).get("proess_s").toString()));
				}
			}
		}
		for(int i =0;i<listshu.size();i++){
			listATO.add(listshu.get(i));
		}
		
		return listATO;
	}
	
	
	@Override
	public void regFormatter() {
		
		
		
	}
	
	

}
