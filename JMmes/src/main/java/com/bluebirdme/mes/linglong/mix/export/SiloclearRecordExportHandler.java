/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.export;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.mix.entity.SiloclearRecord;
import com.bluebirdme.mes.linglong.mix.service.SiloclearRecordServiceImpl;
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
public class SiloclearRecordExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	SiloclearRecordServiceImpl service = (SiloclearRecordServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"SiloclearRecordServiceImpl"首字母改为小写
   				.firstCharToLowerCase("SiloclearRecordServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<SiloclearRecord> entityList = service.datagridRows(filter, page,SiloclearRecord.class);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		for (int i = 0; i < entityList.size(); i++) {
			
			
			entityList.get(i).setSilo_type_s(
					exportCombox.getDictName((entityList.get(i).getSilo_type_s().toString())));// 料仓类型
			entityList.get(i).setShift_code_s(
					exportCombox.getDictName((entityList.get(i).getShift_code_s().toString())));// 班次
			entityList.get(i).setDatasource_s(
					exportCombox.getDictName((entityList.get(i).getDatasource_s().toString())));// 数据来源
		}
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
      /*  // 机构编号： 柳州 8003
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
                return null;
            }
        });
        
        // 归档标记
        regFormatter("arch_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //arch_flag_s
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
        
        // 修改人姓名
        regFormatter("changed_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //changed_name_s
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
        
        // 清理人
        regFormatter("clear_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //clear_by_s
                return null;
            }
        });
        
        // 清理人姓名
        regFormatter("clear_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //clear_name_s
                return null;
            }
        });
        
        // 清理时间
        regFormatter("clear_time_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //clear_time_s
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
        
        // 创建人姓名
        regFormatter("created_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //created_name_s
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
        
        // 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES
        regFormatter("datasource_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //datasource_s
                return null;
            }
        });
        
        // 机台编码
        regFormatter("equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //equip_code_s
                return null;
            }
        });
        
        // 班组：301001-甲班、301002-乙班、301003-丙班
        regFormatter("group_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //group_code_s
                return null;
            }
        });
        
        // 主键，同时在从表中关联主键
        regFormatter("id_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //id_s
                return null;
            }
        });
        
        // 物料编码
        regFormatter("material_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_code_s
                return null;
            }
        });
        
        // 接收时间
        regFormatter("receive_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //receive_time_t
                return null;
            }
        });
        
        // 密炼生成配方编号
        regFormatter("recipe_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_code_s
                return null;
            }
        });
        
        // 记录标志，A可用，D删除
        regFormatter("record_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //record_flag_s
                return null;
            }
        });
        
        // 班次：302001-早班、302002-中班、302003-晚班
        regFormatter("shift_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //shift_code_s
                return null;
            }
        });
        
        // 料仓号（1、2、3…7）
        regFormatter("silono_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //silono_s
                return null;
            }
        });
        
        // 料仓类型： 057001-密炼机胶架投料口 057002-碎胶机胶架投料口 057003-自动小料 057004-人工小料 057005-一次法小料 057006-油罐 057007-炭黑罐 057008-白炭黑罐
        regFormatter("silo_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //silo_type_s
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
        
        // 配套供应商编号
        regFormatter("supplier_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //supplier_code_s
                return null;
            }
        });
        
        // 工厂：1-全钢、2-半钢
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });
        
        // 重量
        regFormatter("weight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //weight_s
                return null;
            }
        });
        
        // 密炼工单跟踪表，工单号，外键，MX_PP_WO.WO_NO
        regFormatter("wo_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_no_s
                return null;
            }
        });
        */
    }

}
