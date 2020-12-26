/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.service.BgcheckgradestorageServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class BgcheckgradestorageExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	BgcheckgradestorageServiceImpl shu = (BgcheckgradestorageServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"BgcheckgradestorageServiceImpl"首字母改为小写
   				.firstCharToLowerCase("BgcheckgradestorageServiceImpl"));

    	List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu = new ArrayList<>();
		filter.set("s_factory_s", LLWebUtils.factory());
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		int m = 0;
		int n = 0;
		if (filter.toString().contains("huizong_s")) {
			m = 1;
		}
		if (filter.toString().contains("xiangxi_s")) {
			n = 1;
		}
   		// 转换数据，数据赋值
		if (m == 1 && n == 0) {
			listshu = shu.codeRowsUDA(filter, page);
			if (listshu != null) {
				for (int i = 0; i < listshu.size(); i++) {
					
				}
			}
		}else if(m == 0 && n == 1){
			listshu = shu.typeRowsUDA(filter, page);
			if (listshu != null) {
				for (int i = 0; i < listshu.size(); i++) {
					listshu.get(i).put("balnaceuniformgrade_s", exportCombox.getDictname(listshu.get(i).get("balnaceuniformgrade_s").toString()));
					listshu.get(i).put("grade_s", exportCombox.getDictname(listshu.get(i).get("grade_s").toString()));
				}
			}
			
		}
		if (listshu != null) {
			for (int i = 0; i < listshu.size(); i++) {
				listATO.add(listshu.get(i));
			}
		}
		return listATO;
	}
    
    @Override
    public void regFormatter() {
    	
    }
}
