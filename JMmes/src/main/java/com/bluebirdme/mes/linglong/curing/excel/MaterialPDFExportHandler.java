/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.MaterialPdfServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class MaterialPDFExportHandler extends DefaultExcelExportHandler {
	
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
		MaterialPdfServiceImpl shu = (MaterialPdfServiceImpl) SpringContext.getBean("materialPdfServiceImpl"); 
		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu= shu.datagridRowsUDA(filter, page);
		if(listshu.size() !=0){
			for(int i =0;i<listshu.size();i++){
				if (listshu.get(i).containsKey("is_flag_s")){
					if(listshu.get(i).get("is_flag_s").equals("0")){
						listshu.get(i).put("is_flag_s", "无效");
					}else{
						listshu.get(i).put("is_flag_s", "有效");
					}
				}
				listATO.add(listshu.get(i));
			}
		}
		return listATO;
	}
	
	@Override
	public void regFormatter() {
		
	}

}
