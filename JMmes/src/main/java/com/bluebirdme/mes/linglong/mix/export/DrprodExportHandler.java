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
import com.bluebirdme.mes.linglong.mix.service.DrprodServiceImpl;

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
public class DrprodExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	DrprodServiceImpl service = (DrprodServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"DrprodServiceImpl"首字母改为小写
   				.firstCharToLowerCase("DrprodServiceImpl"));
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
        
        // 基本单位
        regFormatter("baseunit_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //baseunit_s
                return null;
            }
        });
        
        // 开始车次
        regFormatter("begin_train_num_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //begin_train_num_i
                return null;
            }
        });
        
        // 载具条码：M + 8 位流水号
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
        
        // 误差值
        regFormatter("cutpoly_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //cutpoly_weight_d
                return null;
            }
        });
        
        // 切胶方式：1-手动切胶、2-自动切胶
        regFormatter("cut_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //cut_type_s
                return null;
            }
        });
        
        // 结束车次
        regFormatter("end_train_num_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //end_train_num_i
                return null;
            }
        });
        
        // 机台编码：设备类型（2 位）+流水号（3 位） 例如 01001
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
        
        // 物料过期日期
        regFormatter("expiry_date_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //expiry_date_t
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
        
        // 是否绑定产出车次：0-否、1-是
        regFormatter("is_bindtrain_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_bindtrain_s
                return null;
            }
        });
        
        // 检验标识：0-否、1-是
        regFormatter("is_check_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_check_s
                return null;
            }
        });
        
        // 自检标识：0-合格、1-不合格
        regFormatter("is_selfcheck_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //is_selfcheck_s
                return null;
            }
        });
        
        // 批次信息，长度19位： 母胶批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 M919070110100100015 终炼胶批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 F919070110100100015
        regFormatter("lot_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //lot_no_s
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
        
        // 配套
        regFormatter("matchingcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //matchingcode_s
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
        
        // 金属探测数
        regFormatter("metal_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //metal_num_s
                return null;
            }
        });
        
        // 打印方式： 069001-未打印 069002-已打印（手动） 069003-已打印（自动） 069004-补充打印
        regFormatter("print_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //print_type_s
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
        
        // 产出工位（胶架移除工位）：值域 0、1、2，0-摆片，1、2-卷曲位
        regFormatter("prod_location_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //prod_location_s
                return null;
            }
        });
        
        // 产出方式： 068001-手动产出（正常计划） 068002-自动产出（正常计划） 068003-手动产出（离线计划） 068004-自动产出（离线计划
        regFormatter("prod_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //prod_type_s
                return null;
            }
        });
        
        // 质量备注
        regFormatter("qc_mark_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qc_mark_s
                return null;
            }
        });
        
        // 实际重量
        regFormatter("real_weight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //real_weight_s
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
        
        // RFID读取错误类型： 074001-离线载具条码未读到 074002-在线载具条码未读到 074003-载具条码MES不存在 074004-载具条码MES类型错误 074005-载具条码MES状态错误 074006-其它
        regFormatter("rfid_etype_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //rfid_etype_s
                return null;
            }
        });
        
        // RFID读取是否成功：0-失败，1-成功
        regFormatter("rfid_isok_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //rfid_isok_s
                return null;
            }
        });
        
        // RFID读取备注
        regFormatter("rfid_remark_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //rfid_remark_s
                return null;
            }
        });
        
        // 快检开始车次
        regFormatter("set_begin_train_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_begin_train_num_s
                return null;
            }
        });
        
        // 快检结束车次
        regFormatter("set_end_train_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_end_train_num_s
                return null;
            }
        });
        
        // 设定重量
        regFormatter("set_weight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //set_weight_s
                return null;
            }
        });
        
        // 架子数
        regFormatter("shelves_num_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //shelves_num_s
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
        
        // 提前量
        regFormatter("slowdown_weight_d", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //slowdown_weight_d
                return null;
            }
        });
        
        // 备用字段10：下发时间
        regFormatter("spare10_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare10_s
                return null;
            }
        });
        
        // 备用字段1：物料最小存放时间或允许出库时间
        regFormatter("spare1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare1_s
                return null;
            }
        });
        
        // 备用字段2：配方名称
        regFormatter("spare2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare2_s
                return null;
            }
        });
        
        // 备用字段3：最小存放时间(h)
        regFormatter("spare3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare3_s
                return null;
            }
        });
        
        // 备用字段4：最长存放时间(h)
        regFormatter("spare4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare4_s
                return null;
            }
        });
        
        // 备用字段5：下发标识：0-未下发、1-已下发
        regFormatter("spare5_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare5_s
                return null;
            }
        });
        
        // 备用字段6：生胶（车次消耗原材料胶料），名称+批次生产日期
        regFormatter("spare6_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare6_s
                return null;
            }
        });
        
        // 备用字段7：塑解剂（车次消耗原材料胶料），名称+重量
        regFormatter("spare7_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare7_s
                return null;
            }
        });
        
        // 备用字段8：下发人
        regFormatter("spare8_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare8_s
                return null;
            }
        });
        
        // 备用字段9：下发姓名
        regFormatter("spare9_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //spare9_s
                return null;
            }
        });
        
        // 接片人
        regFormatter("splice_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //splice_by_s
                return null;
            }
        });
        
        // 接片人姓名
        regFormatter("splice_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //splice_name_s
                return null;
            }
        });
        
        // 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库）
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
        
        // 库区编码：062001-胶料库、062002-线边库、062003-历史库
        regFormatter("store_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //store_type_s
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
        
        // 托盘编号
        regFormatter("tray_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tray_code_s
                return null;
            }
        });
        
        // 立库编号（1、2、3、4、5...）
        regFormatter("warehouseid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //warehouseid_s
                return null;
            }
        });
        
        // 密炼工单跟踪表，工单号，外键，MX_PP_WO_EDIT.WO_NO
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
