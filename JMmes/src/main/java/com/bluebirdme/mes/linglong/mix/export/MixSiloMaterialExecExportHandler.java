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
import com.bluebirdme.mes.linglong.mix.service.MixSiloMaterialExecServiceImpl;

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
public class MixSiloMaterialExecExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MixSiloMaterialExecServiceImpl service = (MixSiloMaterialExecServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MixSiloMaterialExecServiceImpl"首字母改为小写
   				.firstCharToLowerCase("MixSiloMaterialExecServiceImpl"));
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
        
        // 数据同步下发GUID，同一次报文传递的数据
        regFormatter("guid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //guid_s
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
        
        // 物料类别(上辅机定义)：055001-炭黑、055002-小药、055003-粉料、055004-油料、055005-胶料 ：对应INT_PLM_MIXMATERIAL表MATERIALTYPE
        regFormatter("materialtype_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialtype_s
                return null;
            }
        });
        
        // 物料编码：对应INT_PLM_MIXMATERIAL表MATERIALCODE
        regFormatter("material_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_code_s
                return null;
            }
        });
        
        // 物料名称：对应INT_PLM_MIXMATERIAL表MATERIALNAME
        regFormatter("material_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_name_s
                return null;
            }
        });
        
        // 输送线：加载炭黑、油料输送线基础数据
        regFormatter("pipeline_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //pipeline_s
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
        
        // 下发时间
        regFormatter("send_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //send_time_t
                return null;
            }
        });
        
        // 料仓号：加载机台对应配置料仓号
        regFormatter("silono_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //silono_s
                return null;
            }
        });
        
        // 下发标识：0-未下发、1-已下发、2-下发失败
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
        
        // 使用状态：058001-未审核、058002-已审核、058003-正下发、058004-已下发、058005-已执行、058006-已关闭
        regFormatter("status_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //status_s
                return null;
            }
        });
        
        // 供应商代码 例如：100019|100018
        regFormatter("supplycode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //supplycode_s
                return null;
            }
        });
        
        // 供应商名称 例如：A|B
        regFormatter("supplyname_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //supplyname_s
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
        
        // 数据同步下发MES机台条码
        regFormatter("sync_equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_equip_code_s
                return null;
            }
        });
        
        // 数据同步下发MES机台名称
        regFormatter("sync_equip_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_equip_name_s
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
        
        // 1#炭黑输送-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_cb1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_cb1_s
                return null;
            }
        });
        
        // 2#炭黑输送-数据同步处理标记：0-未处理、1-已处理、3-处理失败
        regFormatter("sync_hand_flag_cb2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_cb2_s
                return null;
            }
        });
        
        // 3#炭黑输送-数据同步处理标记：0-未处理、1-已处理、4-处理失败
        regFormatter("sync_hand_flag_cb3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_cb3_s
                return null;
            }
        });
        
        // 1#-3#炭黑输送-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_cb_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_cb_s
                return null;
            }
        });
        
        // 1#小料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_flauto1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_flauto1_s
                return null;
            }
        });
        
        // 2#小料上辅机-数据同步处理标记：0-未处理、1-已处理、3-处理失败
        regFormatter("sync_hand_flag_flauto2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_flauto2_s
                return null;
            }
        });
        
        // 3#小料上辅机-数据同步处理标记：0-未处理、1-已处理、4-处理失败
        regFormatter("sync_hand_flag_flauto3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_flauto3_s
                return null;
            }
        });
        
        // 1#-3#小料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_flauto_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_flauto_s
                return null;
            }
        });
        
        // 1#油料输送-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_oil1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_oil1_s
                return null;
            }
        });
        
        // 2#油料输送-数据同步处理标记：0-未处理、1-已处理、3-处理失败
        regFormatter("sync_hand_flag_oil2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_oil2_s
                return null;
            }
        });
        
        // 3#油料输送-数据同步处理标记：0-未处理、1-已处理、4-处理失败
        regFormatter("sync_hand_flag_oil3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_oil3_s
                return null;
            }
        });
        
        // 1#-3#油料输送-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_oil_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_oil_s
                return null;
            }
        });
        
        // 1#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_poly1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_poly1_s
                return null;
            }
        });
        
        // 2#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、3-处理失败
        regFormatter("sync_hand_flag_poly2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_poly2_s
                return null;
            }
        });
        
        // 3#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、4-处理失败
        regFormatter("sync_hand_flag_poly3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_poly3_s
                return null;
            }
        });
        
        // 4#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、5-处理失败
        regFormatter("sync_hand_flag_poly4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_poly4_s
                return null;
            }
        });
        
        // 5#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、6-处理失败
        regFormatter("sync_hand_flag_poly5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_poly5_s
                return null;
            }
        });
        
        // 1#-8#胶料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_poly_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_poly_s
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
        
        // 1#炭黑输送-数据同步处理反馈
        regFormatter("sync_hand_msg_cb1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_cb1_s
                return null;
            }
        });
        
        // 2#炭黑输送-数据同步处理反馈
        regFormatter("sync_hand_msg_cb2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_cb2_s
                return null;
            }
        });
        
        // 3#炭黑输送-数据同步处理反馈
        regFormatter("sync_hand_msg_cb3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_cb3_s
                return null;
            }
        });
        
        // 1#小料上辅机-数据同步处理反馈
        regFormatter("sync_hand_msg_flauto1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_flauto1_s
                return null;
            }
        });
        
        // 2#小料上辅机-数据同步处理反馈
        regFormatter("sync_hand_msg_flauto2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_flauto2_s
                return null;
            }
        });
        
        // 3#小料上辅机-数据同步处理反馈
        regFormatter("sync_hand_msg_flauto3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_flauto3_s
                return null;
            }
        });
        
        // 1#油料输送-数据同步处理反馈
        regFormatter("sync_hand_msg_oil1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_oil1_s
                return null;
            }
        });
        
        // 2#油料输送-数据同步处理反馈
        regFormatter("sync_hand_msg_oil2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_oil2_s
                return null;
            }
        });
        
        // 3#油料输送-数据同步处理反馈
        regFormatter("sync_hand_msg_oil3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_oil3_s
                return null;
            }
        });
        
        // 1#胶料上辅机-数据同步处理反馈
        regFormatter("sync_hand_msg_poly1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_poly1_s
                return null;
            }
        });
        
        // 2#胶料上辅机-数据同步处理反馈
        regFormatter("sync_hand_msg_poly2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_poly2_s
                return null;
            }
        });
        
        // 3#胶料上辅机-数据同步处理反馈
        regFormatter("sync_hand_msg_poly3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_poly3_s
                return null;
            }
        });
        
        // 4#胶料上辅机-数据同步处理反馈
        regFormatter("sync_hand_msg_poly4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_poly4_s
                return null;
            }
        });
        
        // 5#胶料上辅机-数据同步处理反馈
        regFormatter("sync_hand_msg_poly5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_msg_poly5_s
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
        
        // 1#炭黑输送-数据同步处理时间
        regFormatter("sync_hand_time_cb1_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_cb1_t
                return null;
            }
        });
        
        // 2#炭黑输送-数据同步处理时间
        regFormatter("sync_hand_time_cb2_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_cb2_t
                return null;
            }
        });
        
        // 3#炭黑输送-数据同步处理时间
        regFormatter("sync_hand_time_cb3_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_cb3_t
                return null;
            }
        });
        
        // 1#小料上辅机-数据同步处理时间
        regFormatter("sync_hand_time_flauto1_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_flauto1_t
                return null;
            }
        });
        
        // 2#小料上辅机-数据同步处理时间
        regFormatter("sync_hand_time_flauto2_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_flauto2_t
                return null;
            }
        });
        
        // 3#小料上辅机-数据同步处理时间
        regFormatter("sync_hand_time_flauto3_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_flauto3_t
                return null;
            }
        });
        
        // 1#油料输送-数据同步处理时间
        regFormatter("sync_hand_time_oil1_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_oil1_t
                return null;
            }
        });
        
        // 2#油料输送-数据同步处理时间
        regFormatter("sync_hand_time_oil2_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_oil2_t
                return null;
            }
        });
        
        // 3#油料输送-数据同步处理时间
        regFormatter("sync_hand_time_oil3_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_oil3_t
                return null;
            }
        });
        
        // 1#胶料上辅机-数据同步处理时间
        regFormatter("sync_hand_time_poly1_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_poly1_t
                return null;
            }
        });
        
        // 2#胶料上辅机-数据同步处理时间
        regFormatter("sync_hand_time_poly2_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_poly2_t
                return null;
            }
        });
        
        // 3#胶料上辅机-数据同步处理时间
        regFormatter("sync_hand_time_poly3_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_poly3_t
                return null;
            }
        });
        
        // 4#胶料上辅机-数据同步处理时间
        regFormatter("sync_hand_time_poly4_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_poly4_t
                return null;
            }
        });
        
        // 5#胶料上辅机-数据同步处理时间
        regFormatter("sync_hand_time_poly5_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_time_poly5_t
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
        
        // 数据同步下发工单号
        regFormatter("sync_wo_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_wo_no_s
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
