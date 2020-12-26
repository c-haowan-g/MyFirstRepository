package com.bluebirdme.mes.linglong.finalcheck.excel;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.service.DynaBalanceTestReportServiceImpl;
import org.xdemo.app.xutils.j2se.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynaBalanceTestReportExportHandler extends DefaultExcelExportHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
        DynaBalanceTestReportServiceImpl service = (DynaBalanceTestReportServiceImpl) SpringContext.getBean(StringUtils
                //需要将"LedgerServiceImpl"首字母改为小写
                .firstCharToLowerCase("dynaBalanceTestReportServiceImpl"));
        List<Object> list = new ArrayList<Object>();
        List<Map<String, Object>> entityList = service.getRows(filter, page);
        ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("exportServiceImpl"));
        // 转换数据，数据赋值
        if (entityList != null) {
            String str = null;
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

    }
}
