/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;


import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.entity.SulphurStartUpStatisticsDetailed;
import com.bluebirdme.mes.linglong.curing.entity.SulphurStartUpStatisticsSummarize;
import com.bluebirdme.mes.linglong.curing.service.SulphurStartUpStatisticsServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;



/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class SulphurStartUpStatisticsExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	SulphurStartUpStatisticsServiceImpl service = (SulphurStartUpStatisticsServiceImpl) SpringContext.getBean(StringUtils
        		//需要将"StorageAreaServiceImpl"首字母改为小写
       				.firstCharToLowerCase("SulphurStartUpStatisticsServiceImpl"));
       		List<Object> list = new ArrayList<Object>();
       		List<SulphurStartUpStatisticsDetailed> entityList = service.datagridRows3(filter, page, SulphurStartUpStatisticsDetailed.class);
   		/*ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));*/
   		// 转换数据，数据赋值
   		System.out.println(entityList.size());
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   				
   				
   				/*if (entityList.get(i).containsKey("tyre_barcode_s")){
					//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
   					entityList.get(i).put("quality_status_s", "1");
				}*/
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
  
    }

}
