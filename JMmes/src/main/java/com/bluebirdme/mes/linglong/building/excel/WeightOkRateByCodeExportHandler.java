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

import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.building.service.WeightOkRateByCodeServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2020年1月20日 上午8:11:20
 */
public class WeightOkRateByCodeExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	WeightOkRateByCodeServiceImpl shu = (WeightOkRateByCodeServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("weightOkRateByCodeServiceImpl"));

		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu = new ArrayList<>();
		filter.set("s_factory_s", LLWebUtils.factory());
		int m = 0;
		int n = 0;
		if (filter.toString().contains("line_spec_s")) {
			m = 1;
		}
		if (filter.toString().contains("material_spec_s")) {
			n = 1;
		}
		if (m == 1 && n == 1) {
			listshu = shu.datagridRowsUDA(filter, page);
			if (listshu != null) {
				for (int i = 0; i < listshu.size(); i++) {
					if (listshu.get(i).get("add_flag_s").toString().equals("105001")) {
						listshu.get(i).put("add_flag_s", "正常产出");
					}else {
						listshu.get(i).put("add_flag_s", "补产出");
					}
				}
			}
		} else if(m == 1 && n == 0) {
			listshu = shu.datagridRowsUDA1(filter, page);
			if (listshu != null) {
				for (int i = 0; i < listshu.size(); i++) {
					if (listshu.get(i).get("add_flag_s").toString().equals("105001")) {
						listshu.get(i).put("add_flag_s", "正常产出");
					}else {
						listshu.get(i).put("add_flag_s", "补产出");
					}
				}
			}
		} else {
			listshu = shu.datagridRowsUDA2(filter, page);
			if (listshu != null) {
				for (int i = 0; i < listshu.size(); i++) {
					if (listshu.get(i).get("add_flag_s").toString().equals("105001")) {
						listshu.get(i).put("add_flag_s", "正常产出");
					}else {
						listshu.get(i).put("add_flag_s", "补产出");
					}
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
