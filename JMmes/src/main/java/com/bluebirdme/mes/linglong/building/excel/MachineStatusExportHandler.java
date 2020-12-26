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

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.building.entity.MachineStatus;
import com.bluebirdme.mes.linglong.building.service.MachineStatusServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class MachineStatusExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void regFormatter() {
    
    }
    @Override
   	public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
       	List<Object> listExp = new ArrayList<>();
       	MachineStatusServiceImpl service = (MachineStatusServiceImpl) SpringContext.getBean("machineStatusServiceImpl");
   		List<Map<String,Object>> list = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportChangeDict = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
   		for(int i =0;i<list.size();i++){
   			if (list.get(i).containsKey("machinetype_suda")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   				list.get(i).put("machinetype_suda", exportChangeDict.getDictname(list.get(i).get("machinetype_suda").toString()));
			}
   			if (list.get(i).containsKey("machinestatus_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   				list.get(i).put("machinestatus_s", exportChangeDict.getDictname(list.get(i).get("machinestatus_s").toString()));
			}
   			if (list.get(i).containsKey("auto_hand_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   				if(list.get(i).get("auto_hand_s").equals("1")){
   					list.get(i).put("auto_hand_s","自动");
   				}
   				if(list.get(i).get("auto_hand_s").equals("0")){
   					list.get(i).put("auto_hand_s","手动");
   				}
			}
   			if (list.get(i).containsKey("producttype_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   				if(list.get(i).get("producttype_s").equals("1")){
   					list.get(i).put("producttype_s","批量");
   				}else if(list.get(i).get("producttype_s").equals("0")){
   					list.get(i).put("producttype_s","单条");
   				}else{
   					list.get(i).put("producttype_s","未知");
   				}
			}
   			listExp.add(list.get(i));
   		}
   		return listExp;
   	}
}
