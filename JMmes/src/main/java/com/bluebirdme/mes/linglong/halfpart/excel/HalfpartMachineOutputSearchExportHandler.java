/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.HalfpartMachineOutputSearchServiceImpl;
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
public class HalfpartMachineOutputSearchExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	HalfpartMachineOutputSearchServiceImpl service = (HalfpartMachineOutputSearchServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"HalfpartMachineOutputSearchServiceImpl"首字母改为小写
   				.firstCharToLowerCase("HalfpartMachineOutputSearchServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		List<Map<String, Object>> listresult = service.searchUsercode();
   		// 转换数据，数据赋值
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				/**举例说明
   				if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
   					entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
   				}*/
   				if(entityList.get(i).get("operator1_s")!=null){
   					for (Map<String, Object> map : listresult) {
						if(entityList.get(i).get("operator1_s").equals(map.get("USERCODE"))){
							entityList.get(i).put("operator1_s", map.get("USERNAME"));
						}
					}
   				}
   				if(entityList.get(i).get("assistantone_s")!=null){
   					for (Map<String, Object> map : listresult) {
						if(entityList.get(i).get("assistantone_s").equals(map.get("USERCODE"))){
							entityList.get(i).put("assistantone_s", map.get("USERNAME"));
						}
					}
   				}
   				if(entityList.get(i).get("curlyworker_s")!=null){
   					for (Map<String, Object> map : listresult) {
						if(entityList.get(i).get("curlyworker_s").equals(map.get("USERCODE"))){
							entityList.get(i).put("curlyworker_s", map.get("USERNAME"));
						}
					}
   				}
   				if(entityList.get(i).get("curlyassistone_s")!=null){
   					for (Map<String, Object> map : listresult) {
						if(entityList.get(i).get("curlyassistone_s").equals(map.get("USERCODE"))){
							entityList.get(i).put("curlyassistone_s", map.get("USERNAME"));
						}
					}
   				}
   				if (entityList.get(i).get("outputflag_s") != null) {
					if (entityList.get(i).get("outputflag_s").equals("0")) {
						entityList.get(i).put("outputflag_s", "服务端");
					} else {
						entityList.get(i).put("outputflag_s", "客户端");
					}
				}
   				if (entityList.get(i).get("solidifyflag_s") != null) {
					if (entityList.get(i).get("solidifyflag_s").equals("0")) {
						entityList.get(i).put("solidifyflag_s", "未固化");
					} else {
						entityList.get(i).put("solidifyflag_s", "已固化");
					}
				}
				if (entityList.get(i).get("outflag_s") != null) {
					if (entityList.get(i).get("outflag_s").equals("105001")) {
						entityList.get(i).put("outflag_s", "正常产出");
					} else if(entityList.get(i).get("outflag_s").equals("105002")){
						entityList.get(i).put("outflag_s", "补产出");
					}else if(entityList.get(i).get("outflag_s").equals("105003")){
					    entityList.get(i).put("outflag_s", "取消产出");
					}
				}
				
				if (entityList.get(i).get("outclass_s") != null) {
					if (entityList.get(i).get("outclass_s").equals("118001")) {
						entityList.get(i).put("outclass_s", "早班");
					} else if(entityList.get(i).get("outclass_s").equals("118002")){
						entityList.get(i).put("outclass_s", "中班");
					}else if(entityList.get(i).get("outclass_s").equals("118003")){
					    entityList.get(i).put("outclass_s", "晚班");
					}
				}
				
				
   				list.add(entityList.get(i));
   			}
   			System.out.println(list);
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
    
        /*// 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
                return null;
            }
        });
        
        // 副手
        regFormatter("assistantone_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //assistantone_s
                return null;
            }
        });
        
        // 副手
        regFormatter("assistantthree_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //assistantthree_s
                return null;
            }
        });
        
        // 副手
        regFormatter("assistanttwo_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //assistanttwo_s
                return null;
            }
        });
        
        // 产出批次条码
        regFormatter("barcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //barcode_s
                return null;
            }
        });
        
        // 更正前载具
        regFormatter("changebeforevehicles_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //changebeforevehicles_s
                return null;
            }
        });
        
        // 修改人(补产出人、取消产出人)
        regFormatter("changed_by_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //changed_by_s
                return null;
            }
        });
        
        // 修改时间(补产出时间、取消产出时间)
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
        
        // 卷曲工 副手
        regFormatter("curlyassistantthree_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //curlyassistantthree_s
                return null;
            }
        });
        
        // 卷曲工 副手
        regFormatter("curlyassistone_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //curlyassistone_s
                return null;
            }
        });
        
        // 卷曲工 副手
        regFormatter("curlyassisttwo_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //curlyassisttwo_s
                return null;
            }
        });
        
        // 卷曲工主手
        regFormatter("curlyworker_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //curlyworker_s
                return null;
            }
        });
        
        // 更正前规格
        regFormatter("column_11_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //column_11_s
                return null;
            }
        });
        
        // 产出口
        regFormatter("exportcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //exportcode_s
                return null;
            }
        });
        
        // 产出开始时间
        regFormatter("inputtime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //inputtime_t
                return null;
            }
        });
        
        // 产出是否入库 0 否 1是
        regFormatter("isstore_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //isstore_s
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
        
        // 机台名称
        regFormatter("machinename_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //machinename_s
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
        
        // 规格
        regFormatter("materspec_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //materspec_s
                return null;
            }
        });
        
        // 主手操作工
        regFormatter("operator1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //operator1_s
                return null;
            }
        });
        
        // 产出班次
        regFormatter("outclass_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outclass_s
                return null;
            }
        });
        
        // 产出标记 基础数据105 105001正常产出105002补产出105003取消产出
        regFormatter("outflag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outflag_s
                return null;
            }
        });
        
        // 产出班组
        regFormatter("outgroup_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outgroup_s
                return null;
            }
        });
        
        // 产出量（重量，数量，长度）
        regFormatter("outnum_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outnum_f
                return null;
            }
        });
        
        // 产出存储标记 0服务端 1客户端
        regFormatter("outputflag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outputflag_s
                return null;
            }
        });
        
        // 产出结束时间
        regFormatter("outputtime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //outputtime_t
                return null;
            }
        });
        
        // 日计划号-工单号
        regFormatter("planno_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //planno_s
                return null;
            }
        });
        
        // 工装条码(口型板)
        regFormatter("plate_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //plate_code_s
                return null;
            }
        });
        
        // 打印次数
        regFormatter("printcount_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //printcount_i
                return null;
            }
        });
        
        // 是否打印  0：否 1 是
        regFormatter("printstatus_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //printstatus_s
                return null;
            }
        });
        
        // 生产版本
        regFormatter("productionversion_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //productionversion_s
                return null;
            }
        });
        
        // 质检人
        regFormatter("qualityby_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qualityby_s
                return null;
            }
        });
        
        // 质检时间
        regFormatter("qualitydate_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qualitydate_t
                return null;
            }
        });
        
        // 质量状态 基础数据 106 
        regFormatter("qualitystate_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //qualitystate_s
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
        
        // 产出更正前的数量
        regFormatter("repairoutquantity_f", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //repairoutquantity_f
                return null;
            }
        });
        
        // 报工流水号
        regFormatter("serid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //serid_s
                return null;
            }
        });
        
        // 固化标识 
        regFormatter("solidifyflag_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //solidifyflag_s
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
        
        // 工厂（1全钢 2半钢）
        regFormatter("s_factory_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //s_factory_s
                return null;
            }
        });
        
        // 使用状态 当前批次的状态 基础数据107
        regFormatter("use_state_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //use_state_s
                return null;
            }
        });
        
        // 载具条码(工字轮)
        regFormatter("vehicles_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //vehicles_code_s
                return null;
            }
        });*/
        
    }

}
