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

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.CapsuleServiceImpl;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class CapsuleExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		CapsuleServiceImpl service = (CapsuleServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("capsuleServiceImpl"));
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		filter.set("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> entityList= service.datagridRowsUDA(filter, page);
		// 转换下拉框
		for (int i = 0; i < entityList.size(); i++) {
			//判断map中是否包含指定的key
			if (entityList.get(i).get("statues_s") != null){
				entityList.get(i).put("statues_s", exportCombox.getDictname(entityList.get(i).get("statues_s").toString()));
			}
			if (entityList.get(i).get("change_reason_s") != null){
				entityList.get(i).put("change_reason_s", exportCombox.getDictname(entityList.get(i).get("change_reason_s").toString()));
			}
			if (entityList.get(i).get("scrap_reason_s") != null){
				entityList.get(i).put("scrap_reason_s", exportCombox.getDictname(entityList.get(i).get("scrap_reason_s").toString()));
			}
			if (entityList.get(i).get("operate_type_s") != null){
				entityList.get(i).put("operate_type_s", exportCombox.getDictname(entityList.get(i).get("operate_type_s").toString()));
			}
			if (entityList.get(i).get("spare2_s") != null){
				entityList.get(i).put("spare2_s", exportCombox.getUserName(entityList.get(i).get("spare2_s").toString()));
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
