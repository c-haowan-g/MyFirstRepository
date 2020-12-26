/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.TyreReasAlerMaintainATO;
import com.bluebirdme.mes.linglong.finalcheck.service.DynaBalanceCheResultServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.TyreReasAlermMaintainServiceImpl;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class TyreReasAlermMaintainExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    private TyreReasAlermMaintainServiceImpl service=(TyreReasAlermMaintainServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("TyreReasAlermMaintainServiceImpl"));
    private ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext
			.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl")); 
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
   		List<Object> list = new ArrayList<Object>();
   		List<TyreReasAlerMaintainATO> entityList = service.datagridRows(filter, page,TyreReasAlerMaintainATO.class);
   		// 转换下拉框
   		/*for (int i = 0; i < entityList.size(); i++) {//spare1_s
   			entityList.get(i).setMachinebar_s(exportServiceImpl.getZJMachineName(entityList.get(i).getMachinebar_s()));
   			entityList.get(i).setTire_total_ratings_s(exportServiceImpl.getDictname(entityList.get(i).getTire_total_ratings_s()));
   		}*/
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				list.add(entityList.get(i));
   			}
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
        
        // 物料编号
        regFormatter("itemid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //itemid_s
                return null;
            }
        });
        
        // 工序
        regFormatter("proess_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //proess_s
                return null;
            }
        });
        
        // 病象条码
        regFormatter("reas_code_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reas_code_s
                return null;
            }
        });
        
        // 病象统计次数
        regFormatter("reas_count_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //reas_count_i
                return null;
            }
        });
        
        // 记录标志，A当前可检，D历史可检
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
