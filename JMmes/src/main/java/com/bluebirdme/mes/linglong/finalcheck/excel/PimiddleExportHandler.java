/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.service.PimiddleServiceImpl;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class PimiddleExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		//filter.set("s_factory_s", "2");
		//filter.set("agenc_no_s", FactoryConstant.LIU_ZHOU_CODE);
		PimiddleServiceImpl service = (PimiddleServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("PimiddleServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> entityList= service.datagridRowsUDA(filter, page);
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				//判断map中是否包含指定的key
				if (entityList.get(i).containsKey("class_id_s")){
					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
					if(entityList.get(i).get("class_id_s").equals("302001")){
						entityList.get(i).put("class_id_s","早班" );
					}
					if(entityList.get(i).get("class_id_s").equals("302002")){
						entityList.get(i).put("class_id_s","中班" );
					}
					if(entityList.get(i).get("class_id_s").equals("302003")){
						entityList.get(i).put("class_id_s","晚班" );
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
