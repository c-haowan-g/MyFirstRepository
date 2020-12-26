/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class CuringMainTypeExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void regFormatter() {
    
        // 机构代码
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
                return null;
            }
        });
        
        // 报警标记
        regFormatter("alarm_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //alarm_flag_s
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
        
        // 当前工序质量等级
        regFormatter("atpresentgradecode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //atpresentgradecode_s
                return null;
            }
        });
        
        // 外胎延时硫化标记， 1为延时硫化，其余为空
        regFormatter("curingtimedelay_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //curingtimedelay_s
                return null;
            }
        });
        
        // 硫化总时间
        regFormatter("curingtotaltime_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //curingtotaltime_s
                return null;
            }
        });
        
        // 首条确认
        regFormatter("firstflag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //firstflag_s
                return null;
            }
        });
        
        // 轮胎毛重量
        regFormatter("gross_weight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //gross_weight_s
                return null;
            }
        });
        
        // 机台
        regFormatter("machinecode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //machinecode_s
                return null;
            }
        });
        
        // 月计划
        regFormatter("monthlyplan_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //monthlyplan_s
                return null;
            }
        });
        
        // 结束时间
        regFormatter("overtime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //overtime_t
                return null;
            }
        });
        
        // 当前工序
        regFormatter("proess_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //proess_s
                return null;
            }
        });
        
        // 总质量等级
        regFormatter("quality_grade_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //quality_grade_s
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
        
        // 备用字段10
        regFormatter("reservedate10_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate10_s
                return null;
            }
        });
        
        // 备用字段1
        regFormatter("reservedate1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate1_s
                return null;
            }
        });
        
        // 备用字段2
        regFormatter("reservedate2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate2_s
                return null;
            }
        });
        
        // 备用字段3
        regFormatter("reservedate3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate3_s
                return null;
            }
        });
        
        // 备用字段4
        regFormatter("reservedate4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate4_s
                return null;
            }
        });
        
        // 备用字段5
        regFormatter("reservedate5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate5_s
                return null;
            }
        });
        
        // 备用字段6
        regFormatter("reservedate6_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate6_s
                return null;
            }
        });
        
        // 备用字段7
        regFormatter("reservedate7_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate7_s
                return null;
            }
        });
        
        // 备用字段8
        regFormatter("reservedate8_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate8_s
                return null;
            }
        });
        
        // 备用字段9
        regFormatter("reservedate9_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reservedate9_s
                return null;
            }
        });
        
        // 厂区
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });
        
        // 开始时间
        regFormatter("starttime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //starttime_t
                return null;
            }
        });
        
        // 轮胎条码
        regFormatter("tyrebarcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tyrebarcode_s
                return null;
            }
        });
        
        // 操作工ID
        regFormatter("userid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //userid_s
                return null;
            }
        });
        
        // 年周号
        regFormatter("weeklynumber_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //weeklynumber_s
                return null;
            }
        });
        
        // 物料编码
        regFormatter("materialcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialcode_s
                return null;
            }
        });
        
    }

}
