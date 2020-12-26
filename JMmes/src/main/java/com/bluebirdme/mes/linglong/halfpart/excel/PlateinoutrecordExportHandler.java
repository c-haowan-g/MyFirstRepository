/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.PlateinoutrecordServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class PlateinoutrecordExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	PlateinoutrecordServiceImpl service = (PlateinoutrecordServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"PlateinoutrecordServiceImpl"首字母改为小写
   				.firstCharToLowerCase("plateinoutrecordServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		filter.set("s_factory_s", LLWebUtils.factory());
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if (entityList.get(i).get("materialgroup_s") != null) {
                    entityList.get(i).put("materialgroup_s", exportCombox.getDictName((String) entityList.get(i).get("sapm_group_s")));
                }
   				
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
//    
//        // 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
//        regFormatter("agenc_no_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //agenc_no_s
//                return null;
//            }
//        });
//        
//        // 批次条码
//        regFormatter("batch_no_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //batch_no_s
//                return null;
//            }
//        });
//        
//        // 修改人
//        regFormatter("changed_by_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //changed_by_s
//                return null;
//            }
//        });
//        
//        // 修改时间
//        regFormatter("changed_time_t", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //changed_time_t
//                return null;
//            }
//        });
//        
//        // 创建人
//        regFormatter("created_by_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //created_by_s
//                return null;
//            }
//        });
//        
//        // 创建时间
//        regFormatter("created_time_t", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //created_time_t
//                return null;
//            }
//        });
//        
//        // 调入位置
//        regFormatter("in_location_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //in_location_s
//                return null;
//            }
//        });
//        
//        // 位置
//        regFormatter("location_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //location_s
//                return null;
//            }
//        });
//        
//        // 主键
//        regFormatter("mainid_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //mainid_s
//                return null;
//            }
//        });
//        
        // 物料组
//        regFormatter("materialgroup_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //materialgroup_s
//                return null;
//            }
//        });
//        
//        // 物料编码 
//        regFormatter("materielcode_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //materielcode_s
//                return null;
//            }
//        });
//        
//        // 物料名称 
//        regFormatter("materielname_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //materielname_s
//                return null;
//            }
//        });
//        
//        // 操作班组 
//        regFormatter("operate_class_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //operate_class_s
//                return null;
//            }
//        });
//        
//        // 操作班次 
//        regFormatter("operate_shift_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //operate_shift_s
//                return null;
//            }
//        });
//        
//        // 操作类型 0 换上 1 换下
//        regFormatter("operate_type_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //operate_type_s
//                return null;
//            }
//        });
//        
//        // 调出位置
//        regFormatter("out_location_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //out_location_s
//                return null;
//            }
//        });
//        
//        // 生产计划号(记录入库时生产的计划号) 
//        regFormatter("plan_no_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //plan_no_s
//                return null;
//            }
//        });
//        
//        // 口型板条码
//        regFormatter("plate_no_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //plate_no_s
//                return null;
//            }
//        });
//        
//        // 规格 
//        regFormatter("plate_spec_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //plate_spec_s
//                return null;
//            }
//        });
//        
//        // 记录标志，A可用，D删除
//        regFormatter("record_flag_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //record_flag_s
//                return null;
//            }
//        });
//        
//        // 载具条码
//        regFormatter("rfid_no_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //rfid_no_s
//                return null;
//            }
//        });
//        
//        // SAP物料组 基础数据308 外部系统301开头的
//        regFormatter("sapm_group_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //sapm_group_s
//                return null;
//            }
//        });
//        
//        // 备用字段10
//        regFormatter("spare10_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare10_s
//                return null;
//            }
//        });
//        
//        // 备用字段1
//        regFormatter("spare1_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare1_s
//                return null;
//            }
//        });
//        
//        // 备用字段2
//        regFormatter("spare2_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare2_s
//                return null;
//            }
//        });
//        
//        // 备用字段3
//        regFormatter("spare3_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare3_s
//                return null;
//            }
//        });
//        
//        // 备用字段4
//        regFormatter("spare4_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare4_s
//                return null;
//            }
//        });
//        
//        // 备用字段5
//        regFormatter("spare5_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare5_s
//                return null;
//            }
//        });
//        
//        // 备用字段6
//        regFormatter("spare6_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare6_s
//                return null;
//            }
//        });
//        
//        // 备用字段7
//        regFormatter("spare7_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare7_s
//                return null;
//            }
//        });
//        
//        // 备用字段8
//        regFormatter("spare8_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare8_s
//                return null;
//            }
//        });
//        
//        // 备用字段9
//        regFormatter("spare9_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //spare9_s
//                return null;
//            }
//        });
//        
//        // 工厂（1全钢 2半钢）
//        regFormatter("s_factory_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //s_factory_s
//                return null;
//            }
//        });
//        
//        // 数量
//        regFormatter("weight_i", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //weight_i
//                return null;
//            }
//        });
//        
//        // 操作人
//        regFormatter("workid_s", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //workid_s
//                return null;
//            }
//        });
//        
//        // 操作时间
//        regFormatter("worktime_t", new IExcelValueFormatter() {
//            @Override
//            public String format(Object value) {
//                //return sdf.format(new Date((Long)value));
//                //worktime_t
//                return null;
//            }
//        });
//        
    }

}
