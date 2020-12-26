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
import com.bluebirdme.mes.linglong.mix.service.MixProductReportServiceImpl;

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
public class MixProductReportExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MixProductReportServiceImpl service = (MixProductReportServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MixProductReportServiceImpl"首字母改为小写
   				.firstCharToLowerCase("MixProductReportServiceImpl"));
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
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
        // 机构编号： 柳州 8003
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
        
        // 备用字段1：无称量实绩原因备注
        regFormatter("dummy1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy1_s
                return null;
            }
        });
        
        // 备用字段2：小料袋关联小料车批次号
        regFormatter("dummy2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy2_s
                return null;
            }
        });
        
        // 备用字段3：物料最小存放时间或允许出库时间
        regFormatter("dummy3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy3_s
                return null;
            }
        });
        
        // 备用4
        regFormatter("dummy4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy4_s
                return null;
            }
        });
        
        // 备用字段5：月产量汇总：0-未处理、1-已处理、2-处理失败
        regFormatter("dummy5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy5_s
                return null;
            }
        });
        
        // 机台条码
        regFormatter("equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //equip_code_s
                return null;
            }
        });
        
        // 机台名称
        regFormatter("equip_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //equip_name_s
                return null;
            }
        });
        
        // 误差
        regFormatter("error_out_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //error_out_s
                return null;
            }
        });
        
        // 班组
        regFormatter("group_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //group_code_s
                return null;
            }
        });
        
        // 主键ID
        regFormatter("id_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //id_s
                return null;
            }
        });
        
        // 批次信息，长度19位 小料批次号：固定字符+工厂+生产日期+班次+机台+计划号+流水号 自动配料：FA91907011010010001 人工配料：FH91907011010010001
        regFormatter("lot_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //lot_no_s
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
        
        // 物料名称
        regFormatter("material_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_name_s
                return null;
            }
        });
        
        // 产出重量
        regFormatter("output_weight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //output_weight_s
                return null;
            }
        });
        
        // 产出时间
        regFormatter("product_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //product_time_t
                return null;
            }
        });
        
        // 生产日期
        regFormatter("prod_date_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //prod_date_s
                return null;
            }
        });
        
        // 产出状态：0-手动、1-自动
        regFormatter("prod_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //prod_state_s
                return null;
            }
        });
        
        // 产出方式
        regFormatter("prod_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //prod_type_s
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
        
        // 密炼配方BOM版本
        regFormatter("recipe_bom_version_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_bom_version_s
                return null;
            }
        });
        
        // 密炼生成配方编号，外键
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
        
        // 车次
        regFormatter("serial_id_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //serial_id_s
                return null;
            }
        });
        
        // 班次
        regFormatter("shift_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //shift_code_s
                return null;
            }
        });
        
        // 状态编码
        regFormatter("state_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //state_code_s
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
        
        // 称量总重量
        regFormatter("totalweight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //totalweight_s
                return null;
            }
        });
        
        // 托盘号
        regFormatter("tray_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tray_no_s
                return null;
            }
        });
        
        // 是否超差：0-正常、1-超差
        regFormatter("warning_sgn_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //warning_sgn_s
                return null;
            }
        });
        
        // 密炼工单跟踪表，工单号
        regFormatter("wo_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_no_s
                return null;
            }
        });
        
    }

}
