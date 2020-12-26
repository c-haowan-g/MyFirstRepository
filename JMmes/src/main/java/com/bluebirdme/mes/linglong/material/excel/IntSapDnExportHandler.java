/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.material.service.IntSapDnServiceImpl;

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
public class IntSapDnExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	IntSapDnServiceImpl service = (IntSapDnServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"IntSapDnServiceImpl"首字母改为小写
   				.firstCharToLowerCase("IntSapDnServiceImpl"));
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
    /*
        // 单据日期
        regFormatter("deliverydate_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //deliverydate_s
                return null;
            }
        });
        
        // 交货数量
        regFormatter("deliveryqty_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //deliveryqty_s
                return null;
            }
        });
        
        // ERP 内向交货单行号
        regFormatter("dnitem_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dnitem_s
                return null;
            }
        });
        
        // ERP内向交货单号
        regFormatter("dnno_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dnno_s
                return null;
            }
        });
        
        // 预留字段 1
        regFormatter("dummy1_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy1_s
                return null;
            }
        });
        
        // 预留字段 2
        regFormatter("dummy2_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy2_s
                return null;
            }
        });
        
        // 预留字段 3
        regFormatter("dummy3_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy3_s
                return null;
            }
        });
        
        // 预留字段 4
        regFormatter("dummy4_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //dummy4_s
                return null;
            }
        });
        
        // 供货批号
        regFormatter("lotno_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //lotno_s
                return null;
            }
        });
        
        // 物料编码
        regFormatter("matid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //matid_s
                return null;
            }
        });
        
        // ERP 采购订单行号
        regFormatter("referenceitem_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //referenceitem_s
                return null;
            }
        });
        
        // ERP 采购订单号
        regFormatter("referenceno_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //referenceno_s
                return null;
            }
        });
        
        // 出货单单号
        regFormatter("salordid_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //salordid_s
                return null;
            }
        });
        
        // 出货单行号
        regFormatter("salorditem_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //salorditem_s
                return null;
            }
        });
        
        // 供应商编号
        regFormatter("suppliercode_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                //return sdf.format(new Date((Long)value));
                //suppliercode_s
                return null;
            }
        });*/
        
    }

}
