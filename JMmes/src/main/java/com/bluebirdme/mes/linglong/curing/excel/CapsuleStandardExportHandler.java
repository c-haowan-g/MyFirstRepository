package com.bluebirdme.mes.linglong.curing.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.CapsuleStandardServiceImpl;

/**
 * 
 * @author 周清玉 胶囊工艺标准导出
 */
public class CapsuleStandardExportHandler extends DefaultExcelExportHandler {

	
	
	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
		CapsuleStandardServiceImpl shu = (CapsuleStandardServiceImpl) SpringContext.getBean("capsuleStandardServiceImpl"); 
		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu= shu.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		// 转换下拉框
		for (int i = 0; i < listshu.size(); i++) {
			//厂商
			//判断map中是否包含指定的key
			if (listshu.get(i).containsKey("capsule_factory_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
				listshu.get(i).put("capsule_factory_s", exportCombox.getDictname(listshu.get(i).get("capsule_factory_s").toString()));
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
