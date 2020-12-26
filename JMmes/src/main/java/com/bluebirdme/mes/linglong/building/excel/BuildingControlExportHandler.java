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

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.service.BuildRecipeParaServiceImpl;
import com.bluebirdme.mes.linglong.building.service.BuildingControlServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;

/**
 * 导出处理器
 * 
 * @author Goofy 
 * @Date 2018年7月13日 下午2:30:34
 */
public class BuildingControlExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		BuildingControlServiceImpl service = (BuildingControlServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("buildingControlServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		String machinename_s=filter.getFilter().get("machinename_s");
		String machinegroup_s=filter.getFilter().get("machinegroup_s");
		String machinestatus_s=filter.getFilter().get("machinestatus_s");
		List<Map<String, Object>> entityList = service.searchInit(machinename_s, machinegroup_s, machinestatus_s);
		ExportServiceImpl exportCombox = (ExportServiceImpl)SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		List<Map<String, Object>> data = service.searchBy196();
		 if (entityList != null) {
	            for (int i = 0; i < entityList.size(); i++) {
	                for (int j = 0; j < data.size(); j++) {
	                    if (entityList.get(i).get("A" + data.get(j).get("DICTCODE_S")) != null) {
	                        System.out.println(entityList.get(i).get("A" + data.get(j).get("DICTCODE_S")));
	                        if (Integer.parseInt(entityList.get(i).get("A" + data.get(j).get("DICTCODE_S")).toString()) == 1) {
	                            entityList.get(i).put("A" + data.get(j).get("DICTCODE_S"), "开启");
	                        } else {
	                            entityList.get(i).put("A" + data.get(j).get("DICTCODE_S"), "关闭");
	                        }
	                    }
	                }
	                if (entityList.get(i).get("MACHINESTATUS_S") != null) {
	                    entityList.get(i).put("MACHINESTATUS_S", exportCombox.getDictName((String) entityList.get(i).get("MACHINESTATUS_S")));
	                }
	                if (entityList.get(i).get("MACHINEGROUP_S") != null) {
	                    entityList.get(i).put("MACHINEGROUP_S", exportCombox.getDictName((String) entityList.get(i).get("MACHINEGROUP_S")));
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
