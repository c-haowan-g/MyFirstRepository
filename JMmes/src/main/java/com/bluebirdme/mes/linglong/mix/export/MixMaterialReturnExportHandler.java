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
import com.bluebirdme.mes.linglong.mix.entity.MixMaterialReturn;
import com.bluebirdme.mes.linglong.mix.service.MixMaterialReturnServiceImpl;
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
public class MixMaterialReturnExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MixMaterialReturnServiceImpl service = (MixMaterialReturnServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MixMaterialReturnServiceImpl"首字母改为小写
   				.firstCharToLowerCase("MixMaterialReturnServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<MixMaterialReturn> entityList = service.datagridRows(filter, page,MixMaterialReturn.class);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   	// 转换数据，数据赋值
   		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).setGroup_code_s(
					exportCombox.getDictName((entityList.get(i).getGroup_code_s().toString())));// 班组
			entityList.get(i).setShift_code_s(
					exportCombox.getDictName((entityList.get(i).getShift_code_s().toString())));// 班次
			entityList.get(i).setReturn_type_s(
					exportCombox.getDictName((entityList.get(i).getReturn_type_s().toString())));// 登记类型
			entityList.get(i).setWorkarea_s(
					exportCombox.getDictName((entityList.get(i).getWorkarea_s().toString())));// 退回工区
		}
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    public String formatString(Object value) {
        if ("1".equals(value))
          return "是"; 
        if ("0".equals(value))
          return "否"; 
        return null;
      }
      
    @Override
    public void regFormatter() {

    	// 是否色标与胶号一样：0-否、1-是
        regFormatter("is_colorcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
            	return MixMaterialReturnExportHandler.this.formatString(value);
            }
        });
        
        // 是否存在杂物：0-否、1-是
        regFormatter("is_impurity_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                return MixMaterialReturnExportHandler.this.formatString(value);
            }
        });
        
        // 是否已打印流转卡（扉子）：0-否、1-是
        regFormatter("is_print_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
            	return MixMaterialReturnExportHandler.this.formatString(value);
            }
        });
        
        // 是否为机头返回胶：0-否、1-是
        regFormatter("is_return_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
            	return MixMaterialReturnExportHandler.this.formatString(value);
            }
        });
    	
    	
        /*// 机构编号： 柳州 8003
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
        
        // 载具条码
        regFormatter("carrier_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //carrier_code_s
                return null;
            }
        });
        
        // 胶案重量
        regFormatter("carrier_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //carrier_weight_f
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
        
        // 物料过期日期
        regFormatter("expiry_date_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //expiry_date_t
                return null;
            }
        });
        
        // 班组：301001-甲班、301002-乙班、301003-丙班
        regFormatter("group_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //group_code_s
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
        
       
        
        // 批次号
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
        
        // 备注
        regFormatter("memo_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //memo_s
                return null;
            }
        });
        
        // 净重
        regFormatter("net_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //net_weight_f
                return null;
            }
        });
        
        // 产出时间
        regFormatter("prod_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //prod_time_t
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
        
        // 登记类型：078001-返回胶、078002-退库
        regFormatter("return_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //return_type_s
                return null;
            }
        });
        
        // 班次：302001-早班、302002-中班、302003-晚班
        regFormatter("shift_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //shift_code_s
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
        
        // 工厂：1-全钢、2-半钢
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });
        
        // 皮重
        regFormatter("tare_weight_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tare_weight_f
                return null;
            }
        });
        
        // 退回工区：077001-密炼、077002-半部件、077003-成型
        regFormatter("workarea_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //workarea_s
                return null;
            }
        });*/
        
    }

}
