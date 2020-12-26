/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.FeedrecordServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class FeedrecordExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	FeedrecordServiceImpl service = (FeedrecordServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"FeedrecordServiceImpl"首字母改为小写
   				.firstCharToLowerCase("feedrecordServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		List<String>  listresult = service.getHalfPartProductionLine();
   	// 转换数据，数据赋值
   
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if (entityList.get(i).get("materialcode_s") != null) {
                    entityList.get(i).put("materialcode_s", exportCombox.getDictName((String) entityList.get(i).get("materialcode_s")));
                }
   				if(entityList.get(i).get("machinecode_s")!=null){
                    entityList.get(i).put("DESCRIPTION", exportCombox.getDictName((String) entityList.get(i).get("DESCRIPTION")));

   				}
   				if (entityList.get(i).get("bz_class_s") != null) {
                    entityList.get(i).put("bz_class_s", exportCombox.getDictName((String) entityList.get(i).get("bz_class_s")));
                }
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    	
    }
}
    /*
        // 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
                return null;
            }*/
        

        
       /* // 原料条码
        regFormatter("barcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //barcode_s
                return null;
            }
        });
        
        // 班次
        regFormatter("bz_class_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //bz_class_s
                return null;
            }
        });
        
        // 班组
        regFormatter("bz_group_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //bz_group_s
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
        
        // 消耗量-总
        regFormatter("consumeamount_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //consumeamount_f
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
        
        // 投料量（重量、数量、长度）
        regFormatter("feedamount_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //feedamount_s
                return null;
            }
        });
        
        // 投料类型
        regFormatter("feedingtype_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //feedingtype_s
                return null;
            }
        });
        
        // 是否有剩余  可删除
        regFormatter("haveresidual_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //haveresidual_s
                return null;
            }
        });
        
        // 投料时间
        regFormatter("inputtime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //inputtime_t
                return null;
            }
        });
        
        // 机台条码
        regFormatter("machinecode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //machinecode_s
                return null;
            }
        });
        
        // 投料计数器数
        regFormatter("macnumin_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //macnumin_f
                return null;
            }
        });
        
        // 撤下计数器数
        regFormatter("macnumout_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //macnumout_f
                return null;
            }
        });
        
        // 物料编码
        regFormatter("materialcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materialcode_s
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
        
        // 备注
        regFormatter("memo_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //memo_s
                return null;
            }
        });
        
        // 产出数量
        regFormatter("opnum_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //opnum_f
                return null;
            }
        });
        
        // 工单号
        regFormatter("order_planno_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //order_planno_s
                return null;
            }
        });
        
        // 产出物料编码
        regFormatter("productmat_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //productmat_s
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
        
        // 撤下时间
        regFormatter("removetime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //removetime_t
                return null;
            }
        });
        
        // RFID地址
        regFormatter("rfidadress_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //rfidadress_s
                return null;
            }
        });
        
        // 扫描类型 0-客户端记录 1-服务端记录
        regFormatter("scan_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //scan_type_s
                return null;
            }
        });
        
        // 序号
        regFormatter("serialcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //serialcode_s
                return null;
            }
        });
        
        // 数据来源  0-手持 1-RFID 3-扫描枪
        regFormatter("source_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //source_s
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
        
        // 钢丝剔除标记 0-否 1-是
        regFormatter("steeldelflag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //steeldelflag_s
                return null;
            }
        });
        
        // 钢丝压延投料记录组 A B
        regFormatter("steelflag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //steelflag_s
                return null;
            }
        });
        
        // 剩余量（重量、数量、长度）
        regFormatter("surplusamount_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //surplusamount_f
                return null;
            }
        });
        
        // 同步类型 0-已同步 1-未同步
        regFormatter("sync_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //sync_type_s
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
        
        // 使用状态 基础数据字典 107
        regFormatter("usestatus_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //usestatus_s
                return null;
            }
        });
        
        // 载具条码
        regFormatter("vehicles_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //vehicles_code_s
                return null;
            }
        });
        
        // 操作工名称
        regFormatter("worker_id_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //worker_id_s
                return null;
            }
        });
        
        // 操作工编码
        regFormatter("worker_name_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //worker_name_s
                return null;
            }
        });
        
    }
*/
//}
