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
import com.bluebirdme.mes.linglong.mix.service.FeedSwitchServiceImpl;

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
public class FeedSwitchExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	FeedSwitchServiceImpl service = (FeedSwitchServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"FeedSwitchServiceImpl"首字母改为小写
   				.firstCharToLowerCase("FeedSwitchServiceImpl"));
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
        
        // 接片-控制：0-关、1-开
        regFormatter("is_autosp_switch_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_autosp_switch_s
                return null;
            }
        });
        
        // 工单-洗车校验：0-关、1-开
        regFormatter("is_carwash_switch_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_carwash_switch_s
                return null;
            }
        });
        
        // 日计划-等同物料选择：0-关、1-开
        regFormatter("is_equal_switch_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_equal_switch_s
                return null;
            }
        });
        
        // 工单-顺序执行：0-关、1-开
        regFormatter("is_inorder_exec_switch_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_inorder_exec_switch_s
                return null;
            }
        });
        
        // 工单-主机手设置：0-关、1-开
        regFormatter("is_master_switch_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_master_switch_s
                return null;
            }
        });
        
        // 防错物料组名称：例如 半成品-母胶,半成品-混炼胶
        regFormatter("material_groupname_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_groupname_s
                return null;
            }
        });
        
        // 防错物料组：例如 300001,300002
        regFormatter("material_group_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_group_s
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
        
        // 备用字段10
        regFormatter("spare10_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare10_s
                return null;
            }
        });
        
        // 备用字段1： 父物料类型： 母胶(LLMasterBatch)、 终炼胶(LLFinalBatchMPart)、 硫磺小料包(LLSulfurBagBatch)、 普通小料包(LLOrdinaryBagBatch)
        regFormatter("spare1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare1_s
                return null;
            }
        });
        
        // 备用字段2：备注：例如 MW92007071008[已执行]
        regFormatter("spare2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare2_s
                return null;
            }
        });
        
        // 备用字段3：状态：关闭、打开
        regFormatter("spare3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare3_s
                return null;
            }
        });
        
        // 备用字段4：接片错误描述
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
        
        // 接片-胶案移入工位（只有终炼有）：0-摆片，1、2-卷曲位
        regFormatter("sp_carriermovein_loc_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_carriermovein_loc_s
                return null;
            }
        });
        
        // 接片-胶案移入信号：1-胶案架移入，0-MES读取后复位
        regFormatter("sp_carriermovein_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_carriermovein_s
                return null;
            }
        });
        
        // 接片-胶案移出信号：1-胶案架移出，0-MES读取后复位（PLC收到胶案移出信号为0后，由PLC清空产出重量）
        regFormatter("sp_carriermoveout_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_carriermoveout_s
                return null;
            }
        });
        
        // 接片-胶案产出工位（只有终炼有）：0-摆片，1、2-卷曲位
        regFormatter("sp_carriermove_loc_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_carriermove_loc_s
                return null;
            }
        });
        
        // 接片-胶案重量
        regFormatter("sp_carrierweight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_carrierweight_d
                return null;
            }
        });
        
        // 接片-当前动作：MES给PLC，用于MES客户端展示： 准备收胶：胶案移入->MES读RFID->读胶案重量->MES下发标准->结束； 1-完成胶案移入，胶案称量中； 2-完成胶案称重，标准下发中； 3- RFID未读取到，请手动移出； 4-未选择工单，请选择工单； 收胶控制： 摆片->移出->卡片打印->结束 6-完成标准下发，摆片中； 7-产出重量为零，不允许移出； 8-产出重量正常，卡片打印中； 收胶完成： 11-收胶完成；
        regFormatter("sp_curaction_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_curaction_s
                return null;
            }
        });
        
        // 接片-误差值
        regFormatter("sp_cutpolyweight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_cutpolyweight_d
                return null;
            }
        });
        
        // 接片-通讯心跳
        regFormatter("sp_netheart_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_netheart_i
                return null;
            }
        });
        
        // 接片-自动/手动模式：0-自动、1-手动
        regFormatter("sp_onlineoffline_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_onlineoffline_s
                return null;
            }
        });
        
        // 接片-产出重量
        regFormatter("sp_prodweight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_prodweight_d
                return null;
            }
        });
        
        // 接片-运行模式：0-联网运行、1-单机运行
        regFormatter("sp_runmode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_runmode_s
                return null;
            }
        });
        
        // 接片-架子数
        regFormatter("sp_shelf_num_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_shelf_num_i
                return null;
            }
        });
        
        // 接片-提前量
        regFormatter("sp_slowdownweight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_slowdownweight_d
                return null;
            }
        });
        
        // 接片-标准重量
        regFormatter("sp_standweight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_standweight_d
                return null;
            }
        });
        
        // 接片-工单号
        regFormatter("sp_wo_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sp_wo_no_s
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
