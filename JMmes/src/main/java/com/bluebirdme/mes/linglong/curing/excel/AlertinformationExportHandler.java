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
import com.bluebirdme.mes.linglong.curing.service.AlertinformationServiceImpl;

/**
 * 硫化机台报警查询(设备报警信息表)
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class AlertinformationExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		AlertinformationServiceImpl service = (AlertinformationServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("alertinformationServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		filter.set("s_factory_s", LLWebUtils.factory());
		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));
		// 转换下拉框文本
		for (int i = 0; i < entityList.size(); i++) {
			//判断map中是否包含指定的key
			if (entityList.get(i).containsKey("alarm_from_s")){
				if(entityList.get(i).get("alarm_from_s")!=null&&entityList.get(i).get("alarm_from_s")!=""){
					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
					entityList.get(i).put("alarm_from_s", exportCombox.getDictname(entityList.get(i).get("alarm_from_s").toString()));
				}
			}
			//判断map中是否包含指定的key
			if (entityList.get(i).containsKey("alert_level_s")){
				if(entityList.get(i).get("alert_level_s")!=null&&entityList.get(i).get("alert_level_s")!=""){
					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
					entityList.get(i).put("alert_level_s", exportCombox.getDictname(entityList.get(i).get("alert_level_s").toString()));
				}
			}
			//判断map中是否包含指定的key
			if (entityList.get(i).containsKey("alert_status_s")){
				if(entityList.get(i).get("alert_status_s")!=null&&entityList.get(i).get("alert_status_s")!=""){
					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
					entityList.get(i).put("alert_status_s", exportCombox.getDictname(entityList.get(i).get("alert_status_s").toString()));
				}
			}
			if (entityList.get(i).containsKey("alert_code_s")){
				if(entityList.get(i).get("alert_code_s")!=null&&entityList.get(i).get("alert_code_s")!=""){
					if (!entityList.get(i).get("alert_code_s").toString().equals("235007")) {
						if(entityList.get(i).get("spare1_s")!=null&&entityList.get(i).get("spare1_s")!=""){
							if (entityList.get(i).get("spare1_s").toString().equals("1")) {
								entityList.get(i).put("spare1_s", "质检员通过");
							} else if(entityList.get(i).get("spare1_s").toString().equals("0")){
								entityList.get(i).put("spare1_s", "质检员不通过");
							} else if(entityList.get(i).get("spare1_s").toString().equals("2")){
								entityList.get(i).put("spare1_s", "操作工放行");
							} else if(entityList.get(i).get("spare1_s").toString().equals("3")){
								entityList.get(i).put("spare1_s", "操作工不通过");
							} else {
								entityList.get(i).put("spare1_s", "");
							}
						}
					} else {
						if(entityList.get(i).get("spare1_s")!=null&&entityList.get(i).get("spare1_s")!=""){
						    entityList.get(i).put("spare1_s", service.getReasNameByCode(entityList.get(i).get("spare1_s").toString()).get(0).get("reas_cn_s"));
						}
					}
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
