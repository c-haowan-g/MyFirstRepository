package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.HalfPartMachineControlServiceImpl;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 *
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class HalfPartMachineControlExportHandler extends DefaultExcelExportHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
        HalfPartMachineControlServiceImpl service = (HalfPartMachineControlServiceImpl) SpringContext.getBean(StringUtils
                //需要将"MachomestatisServiceImpl"首字母改为小写
                .firstCharToLowerCase("halfPartMachineControlServiceImpl"));
        List<Object> list = new ArrayList<Object>();
        List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
        ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("exportServiceImpl"));
        // 转换数据，数据赋值
        List<Map<String, Object>> data = service.searchBy119();
        if (entityList != null) {
            for (int i = 0; i < entityList.size(); i++) {
                /**举例说明
                 if(entityList.get(i).get("dbcount")!=null&&entityList.get(i).get("sumcount")!=null){
                 entityList.get(i).put("dbcount", (Double.parseDouble(entityList.get(i).get("dbcount").toString())*100.0/Double.parseDouble(entityList.get(i).get("sumcount").toString())*100)/100+"%");
                 }*/

                for (int j = 0; j < data.size(); j++) {
                    if (entityList.get(i).get("a" + data.get(j).get("DICTCODE_S")) != null) {
                        System.out.println(entityList.get(i).get("a" + data.get(j).get("DICTCODE_S")));
                        if (Integer.parseInt(entityList.get(i).get("a" + data.get(j).get("DICTCODE_S")).toString()) == 1) {
                            entityList.get(i).put("a" + data.get(j).get("DICTCODE_S"), "开启");
                        } else {
                            entityList.get(i).put("a" + data.get(j).get("DICTCODE_S"), "关闭");
                        }
                    }
                }
                if (entityList.get(i).get("machinetype_s") != null) {
                    entityList.get(i).put("machinetype_s", exportCombox.getDictName((String) entityList.get(i).get("machinetype_s")));
                }
                if (entityList.get(i).get("machinestatus_s") != null) {
                    entityList.get(i).put("machinestatus_s", exportCombox.getDictName((String) entityList.get(i).get("machinestatus_s")));
                }
                if (entityList.get(i).get("process_s") != null) {
                    entityList.get(i).put("process_s", exportCombox.getDictName((String) entityList.get(i).get("process_s")));
                }
                if (entityList.get(i).get("category") != null) {
                    entityList.get(i).put("category", exportCombox.getDictName((String) entityList.get(i).get("category")));
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
