/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.material.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.mes.linglong.material.service.MixMaterialServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34*/

public class MixMaterialExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	MixMaterialServiceImpl service = (MixMaterialServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"MixMaterialServiceImpl"首字母改为小写
   				.firstCharToLowerCase("MixMaterialServiceImpl"));
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
   				if (entityList.get(i).get("materialtype_s") != null) {
   	                entityList.get(i).put("materialtype_s", exportCombox.getDictName((String) entityList.get(i).get("materialtype_s")));
   	            }
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}
    
    @Override
    public void regFormatter() {
        // 密炼快检检验百分比
        regFormatter("sip_i", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                if(null != value && "" != value){
                    return value+"%";
                }else{
                    return "";
                }
            }
        });
        //有效期是否管控
        regFormatter("overduecontrol_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                if ("0".equals(value)) {
                    return "否";
                } else if ("1".equals(value)) {
                    return "是";
                } else {
                    return (String) value;
                }
            }
        });
        //库存是否报警
        regFormatter("stockalarm_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                if ("0".equals(value)) {
                    return "否";
                } else if ("1".equals(value)) {
                    return "是";
                } else {
                    return (String) value;
                }
            }
        });
        //加温是否管控
        regFormatter("isheat_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                if ("0".equals(value)) {
                    return "否";
                } else if ("1".equals(value)) {
                    return "是";
                } else {
                    return (String) value;
                }
            }
        });
        //物料状态
        regFormatter("materialstatus_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                if ("01".equals(value)) {
                    return "因采购/仓库二被冻结";
                } else if ("02".equals(value)) {
                    return "因任务清单/BOM而被冻结";
                }else if ("Z1".equals(value)) {
                    return "冻结物料，只能库存收发货";
                }else if ("Z2".equals(value)) {
                    return "冻结物料，不允许所有操作";
                }else if ("Z3".equals(value)) {
                    return "冻结物料，只能库存收发货和采购";
                }else {
                    return (String) value;
                }
            }
        });
        //物料状态
        regFormatter("agenc_no_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                if ("8000".equals(value)) {
                    return "招远";
                }else if ("8002".equals(value)) {
                    return "德州";
                }else if ("8003".equals(value)) {
                    return "柳州";
                }else if ("8004".equals(value)) {
                    return "泰国";
                }else {
                    return (String) value;
                }
            }
        });

        //数据来源
        regFormatter("data_source_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                if ("0".equals(value)) {
                    return "PLM原数据";
                }else if ("1".equals(value)) {
                    return "自动生成";
                }else if ("2".equals(value)) {
                    return "SAP原数据";
                }else {
                    return (String) value;
                }
            }
        });

        //数据来源类型
        regFormatter("data_source_type_s", new IExcelValueFormatter() {
            @Override
            public String format(Object value) {
                if ("0".equals(value)) {
                    return "上辅机配方";
                }else if ("1".equals(value)) {
                    return "配料系统配方";
                }else {
                    return (String) value;
                }
            }
        });


    }
   

}
