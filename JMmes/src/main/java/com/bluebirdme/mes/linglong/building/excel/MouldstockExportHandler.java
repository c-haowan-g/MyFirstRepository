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

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.entity.Mouldstock;
import com.bluebirdme.mes.linglong.building.service.MouldstockServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class MouldstockExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void regFormatter() {
    }

    @Override
	public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
    	List<Object> listExp = new ArrayList<>();
    	MouldstockServiceImpl service = (MouldstockServiceImpl) SpringContext.getBean("mouldstockServiceImpl");
		List<Map<String, Object>> list = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportChangeDict = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		for(int i =0;i<list.size();i++){
			if (list.get(i).containsKey("status_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   				list.get(i).put("status_s", exportChangeDict.getDictname(list.get(i).get("status_s").toString()));
			}
			if (list.get(i).containsKey("capsule_type_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   				list.get(i).put("capsule_type_s", exportChangeDict.getDictname(list.get(i).get("capsule_type_s").toString()));
			}
			listExp.add(list.get(i));
		}
		return listExp;
	}
}
