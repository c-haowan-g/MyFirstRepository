/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanXrayLogServiceImpl;

/**
 * 导出处理器
 * @author 马健斌
 * @Date 2018年7月13日 下午2:30:34
 */
public class ScanXrayLogExportHandler extends DefaultExcelExportHandler {
    
    
    @Override
    public void regFormatter() {
    	regFormatter("isok_s", new IExcelValueFormatter() {

			public String format(Object value) {
				// TODO Auto-generated method stub
				System.out.println(value);
				if (value == null) {
					return "";
				} else if (value.equals("0")) {
					return "失败";
				} else {
					return "成功";
				}
			}
		});
      
    }
    
    @Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
    	ScanXrayLogServiceImpl shu = (ScanXrayLogServiceImpl) SpringContext.getBean("scanXrayLogServiceImpl"); 

		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu= shu.datagridRowsUDA(filter, page);
		for(int i =0;i<listshu.size();i++){
			listATO.add(listshu.get(i));
		}
		
		return listATO;
	}

}
