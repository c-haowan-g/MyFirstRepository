/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.entity.MoldgGetReady;
import com.bluebirdme.mes.linglong.curing.service.MoldgGetReadyServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class MoldgGetReadyExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
    	MoldgGetReadyServiceImpl shu = (MoldgGetReadyServiceImpl) SpringContext.getBean("moldgGetReadyServiceImpl"); 
    	
		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu= shu.datagridRowsUDA(filter, page);
		if(listshu.size() !=0){
			for(int i =0;i<listshu.size();i++){
				if (listshu.get(i).containsKey("status_s")){
					if(listshu.get(i).get("status_s").equals("0")){
						listshu.get(i).put("status_s", "未备模");
					}else{
						listshu.get(i).put("status_s", "已备模");
					}
				}
				listATO.add(listshu.get(i));
			}
		}
		return listATO;
	}
    
   /* @Override
	public List<Object> getRows(Long ids[], String serviceName) {
    	MoldgGetReadyServiceImpl service = (MoldgGetReadyServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("moldgGetReadyServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		Filter filter = new Filter();
		MoldgGetReady ato = null;
		String idsString = "";
		for (int i = 0; i < ids.length; i++) {
			if (ids[i].toString().equals("")) {
				break;
			}
			idsString = idsString + "," + ids[i].toString();
		}
		idsString = idsString.substring(1);
		filter.set("ids", "in:" + idsString);
		Page page = new Page();
		page.setAll(1);

		List<MoldgGetReady> entityList = null;
		try {
			entityList = service.datagridRows(filter, page, MoldgGetReady.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 转换下拉框
		for (int i = 0; i < entityList.size(); i++) {
			try {
				ato=new MoldgGetReady();
				ato=entityList.get(i);
				if(entityList.get(i).getStatus_s().equals("0")){
					ato.setStatus_s("未备模");
				}else{
					ato.setStatus_s("已备模");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				list.add(entityList.get(i));
			}
		}
		return list;
	}*/
	
    
    @Override
    public void regFormatter() {
    /*
        // 机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //agenc_no_s
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
        
        // 换模班次
        regFormatter("class_id_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //class_id_s
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
        
        // 机台编码 (不区分左右模)
        regFormatter("equip_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //equip_code_s
                return null;
            }
        });
        
        // 执行开始时间
        regFormatter("excute_begintime_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //excute_begintime_t
                return null;
            }
        });
        
        // 执行结束时间
        regFormatter("excute_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //excute_time_t
                return null;
            }
        });
        
        // 执行情况   0：未执行   1：执行完成
        regFormatter("executive_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //executive_s
                return null;
            }
        });
        
        // 花纹(左模)
        regFormatter("flowercode_left_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //flowercode_left_s
                return null;
            }
        });
        
        // 右模花纹
        regFormatter("flowercode_right_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //flowercode_right_s
                return null;
            }
        });
        
        // 是否温模
        regFormatter("heat_mold_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //heat_mold_s
                return null;
            }
        });
        
        // 物料编码(左模)
        regFormatter("material_code_left_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_code_left_s
                return null;
            }
        });
        
        // 右模物料编码
        regFormatter("material_code_right_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_code_right_s
                return null;
            }
        });
        
        // 物料名称(左模)
        regFormatter("material_name_left_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_name_left_s
                return null;
            }
        });
        
        // 右模物料名称
        regFormatter("material_name_right_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //material_name_right_s
                return null;
            }
        });
        
        // 模具分类
        regFormatter("modle_sort_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //modle_sort_s
                return null;
            }
        });
        
        // 右模模具条码
        regFormatter("moldbarcode_right_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //moldbarcode_right_s
                return null;
            }
        });
        
        // 模具条码 （左模）
        regFormatter("mold_barcode_left_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mold_barcode_left_s
                return null;
            }
        });
        
        // 换模日期
        regFormatter("mold_changetime_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mold_changetime_s
                return null;
            }
        });
        
        // 备模确认时间
        regFormatter("mold_conf_time_t", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mold_conf_time_t
                return null;
            }
        });
        
        // 备模确认人
        regFormatter("mold_conf_worker_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //mold_conf_worker_s
                return null;
            }
        });
        
        // 旧右模模具条码
        regFormatter("old_moldbarcode_right_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //old_moldbarcode_right_s
                return null;
            }
        });
        
        // 旧模具条码 （左模）
        regFormatter("old_mold_barcode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //old_mold_barcode_s
                return null;
            }
        });
        
        // 计划编号
        regFormatter("planno_changemold_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //planno_changemold_s
                return null;
            }
        });
        
        // 计划数量控制  0：否 1：是  根据编制的换模计划时间启用控制，执行后释放控制0
        regFormatter("plannum_control_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //plannum_control_s
                return null;
            }
        });
        
        // 硫化生产计划.PLAN_NO
        regFormatter("plan_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //plan_no_s
                return null;
            }
        });
        
        // 计划状态    300401,已编制  300402，已下发 300403，已组装  300404，已换模
        regFormatter("plan_status_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //plan_status_s
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
        
        // 规格(左模)
        regFormatter("speccode_left_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //speccode_left_s
                return null;
            }
        });
        
        // 右模规格
        regFormatter("speccode_right_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //speccode_right_s
                return null;
            }
        });
        
        // 备模状态 已备模、待备模
        regFormatter("status_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //status_s
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
        });*/
        
    }

}
