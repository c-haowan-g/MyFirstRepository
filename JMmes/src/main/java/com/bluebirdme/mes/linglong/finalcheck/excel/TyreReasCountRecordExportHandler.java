/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.service.TyreReasCountRecordServiceImpl;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class TyreReasCountRecordExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	TyreReasCountRecordServiceImpl service = (TyreReasCountRecordServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("TyreReasCountRecordServiceImpl"));
    		//需要将"TyreReasCountRecordServiceImpl"首字母改为小写
   				
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   				
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   				if(entityList.get(i).get("created_by_s")!=null){
   					entityList.get(i).put("created_by_s",exportCombox.getUserName(entityList.get(i).get("created_by_s").toString()));
   				}
   				if(entityList.get(i).get("proess_s")!=null){
					entityList.get(i).put("proess_s", exportCombox.getDictName(entityList.get(i).get("proess_s").toString()));
				}
   				
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
        /*// 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
                return null;
            }
        });
        
        // 归档标记
        regFormatter("arch_flag1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //arch_flag1_s
                return null;
            }
        });
        
        // 修改人
        regFormatter("changed_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //changed_by_s
                return null;
            }
        });
        
        // 修改时间
        regFormatter("changed_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //changed_time_t
                return null;
            }
        });
        
        // 创建人
        regFormatter("created_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //created_by_s
                return null;
            }
        });
        
        // 创建时间
        regFormatter("created_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //created_time_t
                return null;
            }
        });
        
        // 硫化机台编码
        regFormatter("curingmachinecode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //curingmachinecode_s
                return null;
            }
        });
        
        // 物料编号
        regFormatter("itemid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //itemid_s
                return null;
            }
        });
        
        // 工序
        regFormatter("proess_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //proess_s
                return null;
            }
        });
        
        // 病象编码
        regFormatter("reas_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reas_code_s
                return null;
            }
        });
        
        // 病象条码数量
        regFormatter("reas_count_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reas_count_i
                return null;
            }
        });
        
        // 记录标志，A当前可检，D历史可检
        regFormatter("record_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //record_flag_s
                return null;
            }
        });
        
        // 排序时间
        regFormatter("sort_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sort_time_t
                return null;
            }
        });
        
        // 备用字段1
        regFormatter("spare1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare1_s
                return null;
            }
        });
        
        // 备用字段2
        regFormatter("spare2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare2_s
                return null;
            }
        });
        
        // 备用字段3
        regFormatter("spare3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare3_s
                return null;
            }
        });
        
        // 备用字段4
        regFormatter("spare4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare4_s
                return null;
            }
        });
        
        // 备用字段5
        regFormatter("spare5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare5_s
                return null;
            }
        });
        
        // 工厂（1全钢 2半钢）
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });*/
        
    }

}
