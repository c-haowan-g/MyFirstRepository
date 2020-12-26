/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.service.ScanUniformLogServiceImpl;

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
public class ScanUniformLogExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	ScanUniformLogServiceImpl service = (ScanUniformLogServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"ScanUniformLogServiceImpl"首字母改为小写
   				.firstCharToLowerCase("scanUniformLogServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if (entityList.get(i).containsKey("isok_s")){
   					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   	 				if(entityList.get(i).get("isok_s").equals("0")){
   	 					entityList.get(i).put("isok_s", "失败");
   	 				}else if(entityList.get(i).get("isok_s").equals("1")){
   	 					entityList.get(i).put("isok_s", "成功");
   	 				}
   				}
   	 			if (entityList.get(i).containsKey("writein_s")){
   					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   	 				if(entityList.get(i).get("writein_s").equals("0")){
   	 					entityList.get(i).put("writein_s", "失败");
   	 				}else if(entityList.get(i).get("writein_s").equals("1")){
   	 					entityList.get(i).put("writein_s", "成功");
   	 				}
   				}
   	 			if (entityList.get(i).containsKey("etype_s")){
   					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
   	 				if(entityList.get(i).get("etype_s").equals("0")){
   	 					entityList.get(i).put("etype_s", "无");
   	 				}else {
   	 					entityList.get(i).put("etype_s", exportCombox.getDictname(entityList.get(i).get("etype_s").toString()));
   	 				}
   				}
   	 		}
   			for(int i =0;i<entityList.size();i++){
   	 			list.add(entityList.get(i));
   	 		}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
       /* // 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
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
        
        // 轮胎条码：MainTyre 表 BARCODE
        regFormatter("barcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //barcode_s
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
        
        // 设备ID：质检设备信息表主键ID
        regFormatter("entbarcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //entbarcode_s
                return null;
            }
        });
        
        // MES校验错误类型： 1:轮胎条码 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配
        regFormatter("etype_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //etype_s
                return null;
            }
        });
        
        // 质量等级编码
        regFormatter("gradecd_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //gradecd_i
                return null;
            }
        });
        
        // 班组编号
        regFormatter("groupcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //groupcode_s
                return null;
            }
        });
        
        // MES校验是否成功：0-失败，1-成功
        regFormatter("isok_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //isok_s
                return null;
            }
        });
        
        // 品号
        regFormatter("itemid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //itemid_s
                return null;
            }
        });
        
        // 当前工序
        regFormatter("proess_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //proess_i
                return null;
            }
        });
        
        // 配方号：D_BS_Recipe 表 ID
        regFormatter("recipeno_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //recipeno_i
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
        
        // MES备注
        regFormatter("remark_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //remark_s
                return null;
            }
        });
        
        // 班次编号
        regFormatter("shiftcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //shiftcode_s
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
        
        // 轮胎状态编码：0-待检、1-合格、2-不合格
        regFormatter("statecd_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //statecd_i
                return null;
            }
        });
        
        // 工厂(1.全钢 2.半钢)
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });
        
        // 轮胎类型：B-半钢、Q-全钢、G-工程胎等、X光-斜交、S-试验胎
        regFormatter("tyretype_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //tyretype_s
                return null;
            }
        });
        
        // 外胎重量
        regFormatter("weight_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //weight_s
                return null;
            }
        });
        
        // 工控下发备注
        regFormatter("writeinremark_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //writeinremark_s
                return null;
            }
        });
        
        // 工控下发是否成功：0-失败、1-成功
        regFormatter("writein_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //writein_s
                return null;
            }
        });*/
        
    }

}
