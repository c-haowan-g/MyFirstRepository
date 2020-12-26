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
import com.bluebirdme.mes.linglong.mix.service.PlmMixRecipeServiceImpl;

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
public class PlmMixRecipeExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	PlmMixRecipeServiceImpl service = (PlmMixRecipeServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"PlmMixRecipeServiceImpl"首字母改为小写
   				.firstCharToLowerCase("PlmMixRecipeServiceImpl"));
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
    
        // 父物料PLM版本
        regFormatter("b_version_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //b_version_s
                return null;
            }
        });
        
        // 炭黑回收时间
        regFormatter("cb_recycletime_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //cb_recycletime_i
                return null;
            }
        });
        
        // 炭黑回收类型：0-不回收、1-回收
        regFormatter("cb_recycletype_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //cb_recycletype_s
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
        
        // 审核人
        regFormatter("check_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_by_s
                return null;
            }
        });
        
        // 审核人姓名
        regFormatter("check_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_name_s
                return null;
            }
        });
        
        // 审核状态：0-未审核、1-已审核
        regFormatter("check_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_state_s
                return null;
            }
        });
        
        // 审核时间
        regFormatter("check_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_time_t
                return null;
            }
        });
        
        // 误差值
        regFormatter("cutpoly_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //cutpoly_weight_d
                return null;
            }
        });
        
        // 数据来源：0-PLM原数据、1-自动生成
        regFormatter("data_source_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //data_source_s
                return null;
            }
        });
        
        // 数据来源类型：0-上辅机配方、1-配料系统配方
        regFormatter("data_source_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //data_source_type_s
                return null;
            }
        });
        
        // 卸料门温度
        regFormatter("ddoor_temp_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //ddoor_temp_i
                return null;
            }
        });
        
        // 加硫限制
        regFormatter("dischangetime_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dischangetime_i
                return null;
            }
        });
        
        // 区分阶段（小试XS、中试ZS、大试DS、投产TC）
        regFormatter("dummy1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy1_s
                return null;
            }
        });
        
        // 每车标准时间
        regFormatter("dummy2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy2_s
                return null;
            }
        });
        
        // 原材料气味控制
        regFormatter("dummy3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy3_s
                return null;
            }
        });
        
        // 原材料等级控制
        regFormatter("dummy4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy4_s
                return null;
            }
        });
        
        // 备用5
        regFormatter("dummy5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy5_s
                return null;
            }
        });
        
        // 配方替代号
        regFormatter("edt_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //edt_code_s
                return null;
            }
        });
        
        // 机台代码
        regFormatter("equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //equip_code_s
                return null;
            }
        });
        
        // GUID，同一次报文传递的数据
        regFormatter("guid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //guid_s
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
        
        // 是否掺胶：Yes-掺胶、No-不掺胶
        regFormatter("ismixed_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //ismixed_s
                return null;
            }
        });
        
        // 是否使用三区温度：0-不使用、1-使用
        regFormatter("is_useareatemp_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_useareatemp_s
                return null;
            }
        });
        
        // MES机台条码
        regFormatter("mes_equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mes_equip_code_s
                return null;
            }
        });
        
        // MES机台名称
        regFormatter("mes_equip_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mes_equip_name_s
                return null;
            }
        });
        
        // 补偿温度
        regFormatter("makeup_temp_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //makeup_temp_i
                return null;
            }
        });
        
        // 配套
        regFormatter("matchingcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //matchingcode_s
                return null;
            }
        });
        
        // 父物料名称
        regFormatter("mater_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mater_name_s
                return null;
            }
        });
        
        // 父物料类型： 母胶(LLMasterBatch) 终炼胶M(LLFinalBatchMPart)
        regFormatter("mater_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mater_type_s
                return null;
            }
        });
        
        // 父物料SAP品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F）
        regFormatter("mater_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mater_code_s
                return null;
            }
        });
        
        // 父物料SAP品号
        regFormatter("mater_code_temp_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mater_code_temp_s
                return null;
            }
        });
        
        // 最高进胶温度
        regFormatter("max_inploytemp_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //max_inploytemp_i
                return null;
            }
        });
        
        // 最低进胶温度
        regFormatter("min_inploytemp_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //min_inploytemp_i
                return null;
            }
        });
        
        // 超温最短时间
        regFormatter("overtemp_mintime_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //overtemp_mintime_i
                return null;
            }
        });
        
        // 紧急排胶温度
        regFormatter("overtemp_temp_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //overtemp_temp_i
                return null;
            }
        });
        
        // 超时排胶时间
        regFormatter("overtime_time_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //overtime_time_i
                return null;
            }
        });
        
        // 小料包重量
        regFormatter("pack_weight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //pack_weight_s
                return null;
            }
        });
        
        // 工厂代码
        regFormatter("plant_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //plant_s
                return null;
            }
        });
        
        // 配方阶段：ZC-正常、SY-不正常
        regFormatter("prescriptionstage_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //prescriptionstage_s
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
        
        // 配方启停人
        regFormatter("recipe_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_by_s
                return null;
            }
        });
        
        // 配方名称：父物料名称+工艺类型（是否掺胶+配方阶段+工艺类型）
        regFormatter("recipe_code_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_code_name_s
                return null;
            }
        });
        
        // 配方编号-13位：Java系统当前时间 例如 1552888628141
        regFormatter("recipe_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_code_s
                return null;
            }
        });
        
        // 配方启停人姓名
        regFormatter("recipe_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_name_s
                return null;
            }
        });
        
        // 配方状态：323001-待用、323002-正用、323003-停用
        regFormatter("recipe_status_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_status_s
                return null;
            }
        });
        
        // 配方启停时间
        regFormatter("recipe_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_time_t
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
        
        // 父物料工艺PLM版本
        regFormatter("r_version_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //r_version_s
                return null;
            }
        });
        
        // 转子温度
        regFormatter("roll_temp_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //roll_temp_i
                return null;
            }
        });
        
        // 工艺类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗
        regFormatter("routing_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //routing_type_s
                return null;
            }
        });
        
        // SAP可选文本
        regFormatter("sap_version_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sap_version_s
                return null;
            }
        });
        
        // 下发人
        regFormatter("send_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_by_s
                return null;
            }
        });
        
        // 下发人姓名
        regFormatter("send_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_name_s
                return null;
            }
        });
        
        // 下发标识：0-未下发、1-已下发、2-下发失败
        regFormatter("send_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_state_s
                return null;
            }
        });
        
        // 下发时间
        regFormatter("send_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_time_t
                return null;
            }
        });
        
        // 提前量
        regFormatter("slowdown_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //slowdown_weight_d
                return null;
            }
        });
        
        // 设定重量
        regFormatter("set_weigh_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_weigh_d
                return null;
            }
        });
        
        // 架子数
        regFormatter("shelf_num_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //shelf_num_i
                return null;
            }
        });
        
        // 侧壁温度
        regFormatter("side_temp_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //side_temp_i
                return null;
            }
        });
        
    }

}
