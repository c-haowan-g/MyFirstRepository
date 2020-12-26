/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.halfpart.service.ProductPlanMiddleServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.ShifthandoverRecordServiceImpl;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class ProductPlanMiddleExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	ProductPlanMiddleServiceImpl service = (ProductPlanMiddleServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"ShifthandoverRecordServiceImpl"首字母改为小写
   				.firstCharToLowerCase("productPlanMiddleServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   			    // <!-- 机台 -->
   				if(entityList.get(i).get("equip_code_s")!=null&&entityList.get(i).get("equip_code_s")!=null){
   					entityList.get(i).put("equip_code_s", service.getHalfPartName(entityList.get(i).get("equip_code_s").toString()));
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
