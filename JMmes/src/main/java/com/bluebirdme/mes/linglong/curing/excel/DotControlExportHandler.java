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
import com.bluebirdme.mes.linglong.curing.service.DotControlServiceImpl;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器 周清玉 念周号编制
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class DotControlExportHandler extends DefaultExcelExportHandler {
    
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
		DotControlServiceImpl service = (DotControlServiceImpl)SpringContext
				.getBean(StringUtils.firstCharToLowerCase("dotControlServiceImpl"));
		List<Object> list = new ArrayList<>();
		List<Map<String,Object>> listshu= service.datagridRowsz(filter, page);
		
		for(int i =0;i<listshu.size();i++){
			list.add(listshu.get(i));
		}
		
		return list;
	}
	
	
    @Override
    public void regFormatter() {
    	 // 是否温模，1是，0，否
        regFormatter("isvlid_s", new IExcelValueFormatter() {
            public String format(Object value) {
            	String a =null;
				if(value.equals("0")){
					a="无效";
				}else{
					a="有效";
				}
				
				return a;
            }
        });
    }

}
