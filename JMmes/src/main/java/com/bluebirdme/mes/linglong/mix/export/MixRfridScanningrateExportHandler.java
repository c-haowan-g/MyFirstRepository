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
import com.bluebirdme.mes.linglong.mix.service.MixRfridScanningrateServiceImpl;

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
public class MixRfridScanningrateExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MixRfridScanningrateServiceImpl service = (MixRfridScanningrateServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MixRfridScanningrateServiceImpl"首字母改为小写
   				.firstCharToLowerCase("MixRfridScanningrateServiceImpl"));
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
    
        // 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
                return null;
            }
        });
        
        // 警报值
        regFormatter("alarmvalue_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //alarmvalue_f
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
        
        // 基本单位
        regFormatter("baseunit_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //baseunit_s
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
        
        // 创建人
        regFormatter("created_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //created_by_s
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
        
        // 数据来源：0-PLM原数据、1-自动生成、2-SAP原数据
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
        
        // 备用1：接口预留，物料规格 例如 HT204/41
        regFormatter("dummy1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy1_s
                return null;
            }
        });
        
        // 备用2：接口预留，等同物料等级，与等同物料代码对应 例如 0、1、2、3…
        regFormatter("dummy2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy2_s
                return null;
            }
        });
        
        // 备用字段3
        regFormatter("dummy3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy3_s
                return null;
            }
        });
        
        // 备用字段4
        regFormatter("dummy4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy4_s
                return null;
            }
        });
        
        // 备用字段5
        regFormatter("dummy5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy5_s
                return null;
            }
        });
        
        // 等同物料分组
        regFormatter("equivalentmaterial_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //equivalentmaterial_s
                return null;
            }
        });
        
        // 允许误差： 0.3-炭黑 0.02-粉料 0.1-油料 2-返回胶 0.3-胶料允许误差：0.3-返回胶
        regFormatter("error_allow_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //error_allow_d
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
        
        // 内径
        regFormatter("innerdia_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //innerdia_d
                return null;
            }
        });
        
        // 加温是否管控：0-否、1-是
        regFormatter("isheat_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //isheat_s
                return null;
            }
        });
        
        // 配套代码：例如：DV代表大众
        regFormatter("matchingcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //matchingcode_s
                return null;
            }
        });
        
        // 物料编号
        regFormatter("materialcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialcode_s
                return null;
            }
        });
        
        // 物料组
        regFormatter("materialgroup_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialgroup_s
                return null;
            }
        });
        
        // 物料名称
        regFormatter("materialname_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialname_s
                return null;
            }
        });
        
        // 物料规格
        regFormatter("materialspec_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialspec_s
                return null;
            }
        });
        
        // 物料状态：为空正常可用，反之亦然 01-因采购/仓库二被冻结 02-因任务清单/BOM而被冻结 Z1-冻结物料，只能库存收发货 Z2-冻结物料，不允许所有操作 Z3-冻结物料，只能库存收发货和采购
        regFormatter("materialstatus_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialstatus_s
                return null;
            }
        });
        
        // 物料类别(上辅机定义)：055001-炭黑、055002-小药、055003-粉料、055004-油料、055005-胶料
        regFormatter("materialtype_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialtype_s
                return null;
            }
        });
        
        // 物料类别（SAP定义）：ROH-原辅料、HALB-半成品、FERT-产成品、ZUVA-零价值物料、ROH1-材料
        regFormatter("materialtype_sap_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialtype_sap_s
                return null;
            }
        });
        
        // 最短加温时间
        regFormatter("maxheattime_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //maxheattime_f
                return null;
            }
        });
        
        // 最大库存
        regFormatter("maximumstock_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //maximumstock_f
                return null;
            }
        });
        
        // 最长加温时间
        regFormatter("minheattime_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //minheattime_f
                return null;
            }
        });
        
        // 最小库存
        regFormatter("minimumstock_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //minimumstock_f
                return null;
            }
        });
        
        // 外径
        regFormatter("outerdia_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outerdia_d
                return null;
            }
        });
        
        // 有效期是否管控：0-否、1-是
        regFormatter("overduecontrol_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //overduecontrol_s
                return null;
            }
        });
        
        // 最长存放时间(h)
        regFormatter("overtime_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //overtime_f
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
        regFormatter("sip_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sip_i
                return null;
            }
        });
        
        // 最小存放时间(h)
        regFormatter("smalltime_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //smalltime_f
                return null;
            }
        });
        
        // 库存是否报警：0-否、1-是
        regFormatter("stockalarm_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //stockalarm_s
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
        
        // 截面高密炼快检检验百分比
        regFormatter("tyreheight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tyreheight_d
                return null;
            }
        });
        
    }

}
