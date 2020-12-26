/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.export;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.mix.service.WorkOrderExecServiceImpl;

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
public class WorkOrderExecExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	WorkOrderExecServiceImpl service = (WorkOrderExecServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"WorkOrderExecServiceImpl"首字母改为小写
   				.firstCharToLowerCase("WorkOrderExecServiceImpl"));
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
    
        // 执行结束时间：展示DD HH:MM:MM
        regFormatter("act_finish_checktime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //act_finish_checktime_t
                return null;
            }
        });
        
        // 执行结束时间
        regFormatter("act_finish_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //act_finish_time_t
                return null;
            }
        });
        
        // 执行开始时间：展示DD HH:MM:MM
        regFormatter("act_start_checktime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //act_start_checktime_t
                return null;
            }
        });
        
        // 执行开始时间
        regFormatter("act_start_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //act_start_time_t
                return null;
            }
        });
        
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
        
        // 开始检验车次号
        regFormatter("begin_check_train_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //begin_check_train_num_s
                return null;
            }
        });
        
        // 开始生产车次号
        regFormatter("begin_proc_train_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //begin_proc_train_num_s
                return null;
            }
        });
        
        // BOM版本：胶料计划
        regFormatter("bom_ver_id_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //bom_ver_id_s
                return null;
            }
        });
        
        // 工器具的条码：小料车
        regFormatter("carrier_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //carrier_code_s
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
        
        // 结束检验车次号
        regFormatter("end_check_train_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //end_check_train_num_s
                return null;
            }
        });
        
        // 结束生产车次号
        regFormatter("end_proc_train_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //end_proc_train_num_s
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
        
        // 主键ID
        regFormatter("id_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //id_s
                return null;
            }
        });
        
        // 料仓是否清理：0-否、1-是 增粘/补强树脂类：每月清理一次料仓，其它类每三个月清理一次料仓； 不溶性硫磺和硫磺粉料仓：每月清理一次,其它类每三个月清理一次料仓
        regFormatter("is_silo_clean_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_silo_clean_s
                return null;
            }
        });
        
        // 主机手
        regFormatter("master_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //master_by_s
                return null;
            }
        });
        
        // 主机手姓名
        regFormatter("master_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //master_name_s
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
        
        // 备注：母胶卡片显示-生胶（车次消耗原材料胶料），名称+批次生产日期-MEMO
        regFormatter("memo_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //memo_s
                return null;
            }
        });
        
        // 门尼仪机台条码
        regFormatter("mi_equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mi_equip_code_s
                return null;
            }
        });
        
        // 门尼仪机台名称
        regFormatter("mi_equip_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mi_equip_name_s
                return null;
            }
        });
        
        // 密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO
        regFormatter("plan_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //plan_no_s
                return null;
            }
        });
        
        // 成本收集器版本
        regFormatter("production_ver_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //production_ver_s
                return null;
            }
        });
        
        // 检验不合格数量
        regFormatter("qty_check_bad_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qty_check_bad_i
                return null;
            }
        });
        
        // 工单检验完成量
        regFormatter("qty_check_complete_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qty_check_complete_i
                return null;
            }
        });
        
        // 工单检验量：车数*检验百分比
        regFormatter("qty_check_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qty_check_f
                return null;
            }
        });
        
        // 检验合格数量
        regFormatter("qty_check_good_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qty_check_good_i
                return null;
            }
        });
        
        // 工单完成数量
        regFormatter("qty_complete_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qty_complete_i
                return null;
            }
        });
        
        // 工单计划数量
        regFormatter("qty_plan_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qty_plan_i
                return null;
            }
        });
        
        // 快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE
        regFormatter("quickcheck_recipe_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //quickcheck_recipe_code_s
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
        
        // 密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE
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
        
        // 硫变仪机台条码
        regFormatter("sa_equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sa_equip_code_s
                return null;
            }
        });
        
        // 硫变仪机台名称
        regFormatter("sa_equip_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sa_equip_name_s
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
        
        // 密炼快检检验百分比
        regFormatter("sip_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sip_s
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
        
        // 快检数据同步处理时间
        regFormatter("spare11_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare11_s
                return null;
            }
        });
        
        // 快检数据同步处理标记：0-未处理、1-已处理
        regFormatter("spare12_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare12_s
                return null;
            }
        });
        
        // 快检数据同步处理反馈
        regFormatter("spare13_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare13_s
                return null;
            }
        });
        
        // 密炼产出数据同步处理时间
        regFormatter("spare14_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare14_s
                return null;
            }
        });
        
        // 密炼产出数据同步处理标记：0-未处理、1-已处理
        regFormatter("spare15_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare15_s
                return null;
            }
        });
        
        // 密炼产出数据同步处理反馈
        regFormatter("spare16_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare16_s
                return null;
            }
        });
        
        // 备用字段17：根据曲线车次是否检查：0-未处理、1-已处理、2-处理失败
        regFormatter("spare17_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare17_s
                return null;
            }
        });
        
        // 备用字段18：根据曲线车次检查情况
        regFormatter("spare18_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare18_s
                return null;
            }
        });
        
        // 备用字段19：根据曲线车次检查处理时间
        regFormatter("spare19_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare19_s
                return null;
            }
        });
        
        // 备用字段1：密炼接口预留
        regFormatter("spare1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare1_s
                return null;
            }
        });
        
        // 备用字段20：母胶卡片显示-塑解剂（车次消耗原材料胶料），名称+重量-SPARE20
        regFormatter("spare20_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare20_s
                return null;
            }
        });
        
        // 备用字段2：密炼接口预留
        regFormatter("spare2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare2_s
                return null;
            }
        });
        
        // 备用字段3：密炼接口预留
        regFormatter("spare3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare3_s
                return null;
            }
        });
        
        // 备用字段4：密炼接口预留
        regFormatter("spare4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare4_s
                return null;
            }
        });
        
        // 备用字段5：密炼接口预留
        regFormatter("spare5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare5_s
                return null;
            }
        });
        
        // 备用字段6：是否生成领料计划：0-否、1-是
        regFormatter("spare6_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare6_s
                return null;
            }
        });
        
        // 备用字段7：密炼接口预留，配套
        regFormatter("spare7_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare7_s
                return null;
            }
        });
        
        // 备用字段8：计划生成：配方名称
        regFormatter("spare8_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare8_s
                return null;
            }
        });
        
        // 备用字段9：计划生成：是否有等同物料：0-否、1-是
        regFormatter("spare9_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare9_s
                return null;
            }
        });
        
        // 快检工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭
        regFormatter("status_check_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //status_check_s
                return null;
            }
        });
        
        // 同步时间
        regFormatter("sync_create_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_create_time_t
                return null;
            }
        });
        
        // 数据同步处理：A-新增、U-修改、D-删除
        regFormatter("sync_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_flag_s
                return null;
            }
        });
        
        // 数据同步处理标记：0-未处理、1-已处理
        regFormatter("sync_hand_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_s
                return null;
            }
        });
        
        // 数据同步处理反馈
        regFormatter("sync_hand_msg_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_s
                return null;
            }
        });
        
        // 数据同步处理时间
        regFormatter("sync_hand_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_t
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
        
        // 当前检验车次
        regFormatter("train_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //train_num_s
                return null;
            }
        });
        
        // 当前称量车次
        regFormatter("weightche_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //weightche_s
                return null;
            }
        });
        
        // 工单生产日期
        regFormatter("wo_date_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_date_s
                return null;
            }
        });
        
        // 工单班组：301001-甲班、301002-乙班、301003-丙班
        regFormatter("wo_group_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_group_s
                return null;
            }
        });
        
        // 工单号
        regFormatter("wo_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_no_s
                return null;
            }
        });
        
        // 工单顺序号
        regFormatter("wo_seq_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_seq_i
                return null;
            }
        });
        
        // 工单班次：302001-早班、302002-中班、302003-晚班
        regFormatter("wo_shift_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_shift_s
                return null;
            }
        });
        
        // 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭
        regFormatter("wo_status_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_status_s
                return null;
            }
        });
        
        // 计划类型：051001-小料计划、051002-硫磺计划、051003-胶料计划（包括快检计划信息）
        regFormatter("wo_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //wo_type_s
                return null;
            }
        });
        
    }

}
