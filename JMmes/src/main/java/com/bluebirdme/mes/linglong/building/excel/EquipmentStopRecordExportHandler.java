/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.building.entity.EquipmentStopRecord;
import com.bluebirdme.mes.linglong.building.service.EquipmentStopRecordServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class EquipmentStopRecordExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void regFormatter() {
    }

	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		List<Object> listExp = new ArrayList<>();
		EquipmentStopRecordServiceImpl service = (EquipmentStopRecordServiceImpl)SpringContext.getBean("equipmentStopRecordServiceImpl");
		List<Map<String, Object>> list = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		for(int i =0;i<list.size();i++){
			list.get(i).put("alarm_level_s", exportServiceImpl.getDictName(list.get(i).get("alarm_level_s").toString()));
			list.get(i).put("downtime_code_s", exportServiceImpl.getDictName(list.get(i).get("downtime_code_s").toString()));
			list.get(i).put("downtime_source_s", exportServiceImpl.getDictName(list.get(i).get("downtime_source_s").toString()));
			list.get(i).put("downtime_status_s", exportServiceImpl.getDictName(list.get(i).get("downtime_status_s").toString()));
			list.get(i).put("downtime_type_s", exportServiceImpl.getDictName(String.valueOf(list.get(i).get("downtime_type_s"))));
			list.get(i).put("quality_confirmor_s", exportServiceImpl.getUserName(String.valueOf(list.get(i).get("quality_confirmor_s"))));
			list.get(i).put("changed_by_s", exportServiceImpl.getUserName(String.valueOf(list.get(i).get("changed_by_s"))));
			/*list.get(i).setAlarm_level_s(exportServiceImpl.getDictName(list.get(i).getAlarm_level_s()));
			list.get(i).setDowntime_code_s(exportServiceImpl.getDictName(list.get(i).getDowntime_code_s()));
			list.get(i).setDowntime_source_s(exportServiceImpl.getDictName(list.get(i).getDowntime_source_s()));
			list.get(i).setDowntime_status_s(exportServiceImpl.getDictName(list.get(i).getDowntime_status_s()));
			list.get(i).setDowntime_type_s(exportServiceImpl.getDictName(list.get(i).getDowntime_type_s()));
			list.get(i).setQuality_confirmor_s(exportServiceImpl.getUserName(list.get(i).getQuality_confirmor_s()));
			list.get(i).setChanged_by_s(exportServiceImpl.getUserName(list.get(i).getChanged_by_s()));*/
		}
		if (list != null) {
   			for (int i = 0; i < list.size(); i++) {
   				listExp.add(list.get(i));
   			}
   		}
   		return listExp;
	}
    
}
