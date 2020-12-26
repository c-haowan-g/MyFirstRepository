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
import com.bluebirdme.mes.linglong.mix.service.MixStoragePlanJobServiceImpl;

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
public class MixStoragePlanJobExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MixStoragePlanJobServiceImpl service = (MixStoragePlanJobServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MixStoragePlanJobServiceImpl"首字母改为小写
   				.firstCharToLowerCase("MixStoragePlanJobServiceImpl"));
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
        
        // 结存人 
        regFormatter("balance_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //balance_by_s
                return null;
            }
        });
        
        // 结存人姓名
        regFormatter("balance_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //balance_name_s
                return null;
            }
        });
        
        // 结存数量
        regFormatter("balance_qty_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //balance_qty_f
                return null;
            }
        });
        
        // 结存标识：0-未处理、1-已处理、2-处理失败
        regFormatter("balance_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //balance_state_s
                return null;
            }
        });
        
        // 结存时间 
        regFormatter("balance_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //balance_time_t
                return null;
            }
        });
        
        // 结存重量
        regFormatter("balance_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //balance_weight_f
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
        
        // 对库人
        regFormatter("check_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_by_s
                return null;
            }
        });
        
        // 对库结束时间
        regFormatter("check_finish_time_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_finish_time_s
                return null;
            }
        });
        
        // 对库人姓名
        regFormatter("check_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_name_s
                return null;
            }
        });
        
        // 对库出库-结束时间
        regFormatter("check_out_finish_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_out_finish_time_t
                return null;
            }
        });
        
        // 对库出库-数量
        regFormatter("check_out_qty_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_out_qty_f
                return null;
            }
        });
        
        // 对库出库-开始时间
        regFormatter("check_out_start_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_out_start_time_t
                return null;
            }
        });
        
        // 对库出库标识：0-未处理、1-已处理、2-处理失败
        regFormatter("check_out_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_out_state_s
                return null;
            }
        });
        
        // 对库出库-重量
        regFormatter("check_out_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_out_weight_f
                return null;
            }
        });
        
        // 对库产出-结束时间
        regFormatter("check_prod_finish_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_prod_finish_time_t
                return null;
            }
        });
        
        // 对库产出-数量
        regFormatter("check_prod_qty_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_prod_qty_f
                return null;
            }
        });
        
        // 对库产出-开始时间
        regFormatter("check_prod_start_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_prod_start_time_t
                return null;
            }
        });
        
        // 对库产出标识：0-未处理、1-已处理、2-处理失败
        regFormatter("check_prod_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_prod_state_s
                return null;
            }
        });
        
        // 对库产出-重量
        regFormatter("check_prod_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_prod_weight_f
                return null;
            }
        });
        
        // 对库退库-重量
        regFormatter("check_returnt_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_returnt_weight_f
                return null;
            }
        });
        
        // 对库退库-结束时间
        regFormatter("check_return_finish_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_return_finish_time_t
                return null;
            }
        });
        
        // 对库退库-数量
        regFormatter("check_return_qty_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_return_qty_f
                return null;
            }
        });
        
        // 对库退库-开始时间
        regFormatter("check_return_start_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_return_start_time_t
                return null;
            }
        });
        
        // 对库退库标识：0-未处理、1-已处理、2-处理失败
        regFormatter("check_return_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_return_state_s
                return null;
            }
        });
        
        // 对库开始时间
        regFormatter("check_start_time_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_start_time_s
                return null;
            }
        });
        
        // 对库标识：0-未处理、1-已处理、2-处理失败
        regFormatter("check_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_state_s
                return null;
            }
        });
        
        // 对库时间
        regFormatter("check_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_time_t
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
        
        // 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化
        regFormatter("datasource_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //datasource_s
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
        
        // 截存人
        regFormatter("intercept_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //intercept_by_s
                return null;
            }
        });
        
        // 截存人姓名
        regFormatter("intercept_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //intercept_name_s
                return null;
            }
        });
        
        // 截存标识：0-未处理、1-已处理、2-处理失败
        regFormatter("intercept_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //intercept_state_s
                return null;
            }
        });
        
        // 截存时间
        regFormatter("intercept_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //intercept_time_t
                return null;
            }
        });
        
        // 盘点区域
        regFormatter("inventory_area_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //inventory_area_s
                return null;
            }
        });
        
        // 盘点结束时间
        regFormatter("inventory_finish_time_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //inventory_finish_time_s
                return null;
            }
        });
        
        // 盘点数量
        regFormatter("inventory_qty_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //inventory_qty_f
                return null;
            }
        });
        
        // 盘点开始时间
        regFormatter("inventory_start_time_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //inventory_start_time_s
                return null;
            }
        });
        
        // 对库盘点标识：0-未处理、1-已处理、2-处理失败
        regFormatter("inventory_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //inventory_state_s
                return null;
            }
        });
        
        // 盘点重量
        regFormatter("inventory_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //inventory_weight_f
                return null;
            }
        });
        
        // 作业日期：YYYYMMDD作业日期
        regFormatter("job_date_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //job_date_s
                return null;
            }
        });
        
        // 作业名称
        regFormatter("job_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //job_name_s
                return null;
            }
        });
        
        // 作业编号
        regFormatter("job_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //job_no_s
                return null;
            }
        });
        
        // 作业班次：302001-早班、302002-中班、302003-晚班
        regFormatter("job_shift_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //job_shift_s
                return null;
            }
        });
        
        // 作业状态： 343001-盘库开始 343002-盘库中 343003-盘库结束 343004-对库开始 343005-对库中 343006-对库结束 343007-结存开始 343008-结存结束 343009-作业完成 343010-作业作废
        regFormatter("job_status_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //job_status_s
                return null;
            }
        });
        
        // 记录标志：A-可用，D-删除 
        regFormatter("record_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //record_flag_s
                return null;
            }
        });
        
        // 备用字段10
        regFormatter("spare10_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare10_s
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
        
        // 备用字段6
        regFormatter("spare6_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare6_s
                return null;
            }
        });
        
        // 备用字段7
        regFormatter("spare7_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare7_s
                return null;
            }
        });
        
        // 备用字段8
        regFormatter("spare8_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare8_s
                return null;
            }
        });
        
        // 备用字段9
        regFormatter("spare9_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare9_s
                return null;
            }
        });
        
        // 截存结束时间
        regFormatter("sys_finish_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sys_finish_time_t
                return null;
            }
        });
        
        // 截存计划-数量
        regFormatter("sys_plan_qty_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sys_plan_qty_f
                return null;
            }
        });
        
        // 截存计划-重量
        regFormatter("sys_plan_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sys_plan_weight_f
                return null;
            }
        });
        
        // 截存开始时间
        regFormatter("sys_start_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sys_start_time_t
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
        
    }

}
