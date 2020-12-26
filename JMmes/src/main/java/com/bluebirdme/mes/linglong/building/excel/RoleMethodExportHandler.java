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
import com.bluebirdme.mes.linglong.building.entity.RoleMethod;
import com.bluebirdme.mes.linglong.building.service.RoleMethodServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class RoleMethodExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void regFormatter() {
    }
    @Override
	public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
    	List<Object> listExp = new ArrayList<>();
    	RoleMethodServiceImpl service = (RoleMethodServiceImpl) SpringContext.getBean("roleMethodServiceImpl");
		List<Map<String,Object>> list = service.datagridRowsUDA(filter, page);
		if (list != null) {
			for(int i =0;i<list.size();i++){
				listExp.add(list.get(i));
			}
		}
		return listExp;
	}

}
