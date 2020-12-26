/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.MachinestateServiceImpl;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class MachinestateExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MachinestateServiceImpl service = (MachinestateServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MachomestatisServiceImpl"首字母改为小写
   				.firstCharToLowerCase("machinestateServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		filter.getFilter().put("s_factory_s","1");
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
				if(entityList.get(i).get("machinestatus_s") != null){
					entityList.get(i).put("machinestatus_s",exportCombox.getDictname((String) entityList.get(i).get("machinestatus_s")));
				}
				if(entityList.get(i).get("machinetype_s") != null){
					entityList.get(i).put("machinetype_s",exportCombox.getDictname((String) entityList.get(i).get("machinetype_s")));
				}
				if(entityList.get(i).get("producttype_s") != null){
					String type = null;
					if(entityList.get(i).get("producttype_s").equals("1")){
						type = "批量";
					}else type = "单条";
					entityList.get(i).put("producttype_s",type);
				}
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
      /*  // 机构编号：数据字典 303： 招远 8000；德州 8002  柳州 8003 泰国 8004
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
                return null;
            }
        });*/
    }

}
