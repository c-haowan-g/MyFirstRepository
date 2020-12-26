/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.excel;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.material.service.MaterialInventoryServiceImpl;
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
public class MaterialInventoryExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MaterialInventoryServiceImpl service = (MaterialInventoryServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MaterialInventoryServiceImpl"首字母改为小写
   				.firstCharToLowerCase("MaterialInventoryServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   	    Map<String, String> map = filter.getFilter();
   	    if (null == map.get("product_time_t") && null == map.get("in_time_t")) {
         map.remove("start_time");
         map.remove("end_time");
        } 
   	    if (null == map.get("validSign") || "".equals(map.get("validSign")) || "all".equals(map.get("validSign"))) {
         map.remove("validSign");
         map.remove("expiredDay");
       } 
        if (null != map.get("validSign") && "expired".equals(map.get("validSign"))) {
         map.remove("validSign");
         String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
         map.put("expiry_date_t", dateNow);
         map.remove("expiredDay");
       } 
        if (null != map.get("validSign") && "recent".equals(map.get("validSign"))) {
         map.remove("validSign");
         Object o = map.get("expiredDay");
         map.remove("expiredDay");
         String future = LocalDateTime.now().plusDays(Long.valueOf((String)o).longValue()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
         map.put("expired_day", future);
       } 
   	     map.remove("spare11_s");
   	    filter.setFilter(map);
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
    
        // SAP报产固化标识：0-未固化、1-已固化
       /* regFormatter("actual_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //actual_flag_s
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
        
        // 载具编号
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
        
        // 检测人
        regFormatter("check_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_by_s
                return null;
            }
        });
        
        // 最终检测结果
        regFormatter("check_result_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //check_result_s
                return null;
            }
        });
        
        // 检测日期
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
        
        // 允许出库日期
        regFormatter("date_allow_out_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //date_allow_out_t
                return null;
            }
        });
        
        // SAP内向交货单表，内向交货单行号
        regFormatter("dn_dnitem_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dn_dnitem_s
                return null;
            }
        });
        
        // SAP内向交货单表，内向交货单号
        regFormatter("dn_dnno_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dn_dnno_s
                return null;
            }
        });
        
        // SAP内向交货单表，出货单单号
        regFormatter("dn_salordid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dn_salordid_s
                return null;
            }
        });
        
        // SAP内向交货单表，出货单行号
        regFormatter("dn_salorditem_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dn_salorditem_s
                return null;
            }
        });
        
        // 物料过期日期
        regFormatter("expiry_date_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //expiry_date_t
                return null;
            }
        });
        
        // 超期处理次数
        regFormatter("expiry_hand_count_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //expiry_hand_count_i
                return null;
            }
        });
        
        // 超期处理备注
        regFormatter("expiry_hand_remark_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //expiry_hand_remark_s
                return null;
            }
        });
        
        // 等级编码
        regFormatter("grade_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //grade_code_s
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
        
        // 入库日期
        regFormatter("in_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //in_time_t
                return null;
            }
        });
        
        // 进厂批次（G固定字符+4位年号+-固定字符+4位流水号）例如：G2019-0001
        regFormatter("lot_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //lot_no_s
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
        
        // 物料类别(上辅机定义)
        regFormatter("materialtype_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialtype_s
                return null;
            }
        });
        
        // 物料类别（SAP定义）
        regFormatter("materialtype_sap_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialtype_sap_s
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
        
        // 入库数量
        regFormatter("num_in_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //num_in_i
                return null;
            }
        });
        
        // 是否超期:0-正常状态 1-超期
        regFormatter("outofdateflag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outofdateflag_s
                return null;
            }
        });
        
        // 是否优先使用：0-否、1-是
        regFormatter("prioritymat_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //prioritymat_flag_s
                return null;
            }
        });
        
        // 供应商原料批次号生产日期
        regFormatter("product_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //product_time_t
                return null;
            }
        });
        
        // 入库重量
        regFormatter("qty_in_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qty_in_f
                return null;
            }
        });
        
        // 库存剩余重量
        regFormatter("qty_left_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qty_left_f
                return null;
            }
        });
        
        // 放行原因
        regFormatter("reas_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reas_code_s
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
        
        // SAP报产冲销标识：0-否、1-是
        regFormatter("reverser_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reverser_flag_s
                return null;
            }
        });
        
        // 自检标识：默认0合格，1不合格
        regFormatter("self_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //self_flag_s
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
        
        // 备用字段1：数量
        regFormatter("spare1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare1_s
                return null;
            }
        });
        
        // 备用字段2：单件重量
        regFormatter("spare2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare2_s
                return null;
            }
        });
        
        // 备用字段3：库区名称
        regFormatter("spare3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare3_s
                return null;
            }
        });
        
        // 备用字段4：库位名称
        regFormatter("spare4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare4_s
                return null;
            }
        });
        
        // 备用字段5：发料状态：010001-待发料、010002-发料中、010003-发料完成
        regFormatter("spare5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare5_s
                return null;
            }
        });
        
        // 备用字段6：DQW检测项名称-气味等级是否合格：0-无DQW检测项，1-合格，2-不合格
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
        
        // 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格、特殊放行的）、 001004-封锁（MES不能调拨出库） 001005-特殊放行（24小时内无检测结果可操作，反之不允许）
        regFormatter("state_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //state_code_s
                return null;
            }
        });
        
        // 库位编号
        regFormatter("store_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //store_code_s
                return null;
            }
        });
        
        // 库区类型：005001-常温库、005002-加温库、005003-称量预入库、005004-线边库、005006-炭黑库、005007-辅料库、005008-硫磺库、005009-橡胶库、005010-骨架材料库、005011-油料库、005012-立体库、005013-白炭黑库
        regFormatter("store_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //store_type_s
                return null;
            }
        });
        
        // 供应商编号
        regFormatter("supplier_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //supplier_code_s
                return null;
            }
        });
        
        // 供应商原料批次号（9位品号+生产日期+6供应商编号）：21位或23位 例如：1010000091904271005500001
        regFormatter("supplier_lot_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //supplier_lot_no_s
                return null;
            }
        });
        
        // 供应商全称
        regFormatter("supplier_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //supplier_name_s
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
        
        // 截存开始时间
        regFormatter("sys_start_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sys_start_time_t
                return null;
            }
        });
        
        // 是否试验料：0-否，1-是
        regFormatter("testmat_flag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //testmat_flag_s
                return null;
            }
        });
        
        // TDM检测任务推送表，MES业务主键
        regFormatter("test_mesbusinesscode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //test_mesbusinesscode_s
                return null;
            }
        });
        
        // 托盘编号
        regFormatter("tray_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tray_code_s
                return null;
            }
        });
        
        // 立库编号
        regFormatter("warehouseid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //warehouseid_s
                return null;
            }
        });
        
        // 出库目标位置
        regFormatter("warehouse_location_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //warehouse_location_s
                return null;
            }
        });
        
        // 出库方式
        regFormatter("warehouse_mode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //warehouse_mode_s
                return null;
            }
        });
        
        // 原材料称量表，计量单号
        regFormatter("weight_number_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //weight_number_s
                return null;
            }
        });*/
        
    }

}
