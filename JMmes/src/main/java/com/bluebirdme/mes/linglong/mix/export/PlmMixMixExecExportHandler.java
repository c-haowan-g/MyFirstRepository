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
import com.bluebirdme.mes.linglong.mix.service.PlmMixMixExecServiceImpl;

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
public class PlmMixMixExecExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	PlmMixMixExecServiceImpl service = (PlmMixMixExecServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"PlmMixMixExecServiceImpl"首字母改为小写
   				.firstCharToLowerCase("PlmMixMixExecServiceImpl"));
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
    
        // 动作代码
        regFormatter("act_code_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //act_code_i
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
        
        // 冷却鼓速度
        regFormatter("coolspeed_mix_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //coolspeed_mix_d
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
        
        // 塑解剂称上允许误差
        regFormatter("degrad_allow_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //degrad_allow_s
                return null;
            }
        });
        
        // 塑解剂称上设定重量（精度增加一位）
        regFormatter("degrad_weight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //degrad_weight_s
                return null;
            }
        });
        
        // 备用1
        regFormatter("dummy1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy1_s
                return null;
            }
        });
        
        // 备用2
        regFormatter("dummy2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy2_s
                return null;
            }
        });
        
        // 备用3
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
        
        // 备用5
        regFormatter("dummy5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy5_s
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
        
        // 步序
        regFormatter("mix_id_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mix_id_i
                return null;
            }
        });
        
        // 开练机序号
        regFormatter("openequip_id_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //openequip_id_i
                return null;
            }
        });
        
        // 开炼机速度
        regFormatter("openmixspeed_mix_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //openmixspeed_mix_d
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
        
        // 配方编号-13位：外键，INT_PLM_MIXRECIPE.RECIPE_CODE
        regFormatter("recipe_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_code_s
                return null;
            }
        });
        
        // 数据来源类型：0-上辅机配方、1-配料系统配方
        regFormatter("recipe_source_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipe_source_type_s
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
        
        // 辊距
        regFormatter("rollor_mix_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //rollor_mix_d
                return null;
            }
        });
        
        // 胶温
        regFormatter("rubtemp_mix_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //rubtemp_mix_d
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
        
        // 1#-3#小料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败
        regFormatter("sync_hand_flag_flauto_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_hand_flag_flauto_s
                return null;
            }
        });
        
        // 数据同步处理标记：0-未处理、1-已处理、2-处理失败
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
        
        // 工厂（1全钢 2半钢）
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });
        
        // 压力
        regFormatter("set_press_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_press_d
                return null;
            }
        });
        
        // 转速
        regFormatter("set_rota_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_rota_d
                return null;
            }
        });
        
        // 能量
        regFormatter("set_enter_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_enter_d
                return null;
            }
        });
        
        // 功率
        regFormatter("set_power_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_power_d
                return null;
            }
        });
        
        // 温度
        regFormatter("set_temp_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_temp_d
                return null;
            }
        });
        
        // 持续时间
        regFormatter("set_time_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_time_d
                return null;
            }
        });
        
        // 速差比
        regFormatter("speeddiff_mix_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //speeddiff_mix_d
                return null;
            }
        });
        
        // 条件代码
        regFormatter("term_code_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //term_code_d
                return null;
            }
        });
        
        // 水温
        regFormatter("watrtemp_mix_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //watrtemp_mix_d
                return null;
            }
        });
        
    }

}
