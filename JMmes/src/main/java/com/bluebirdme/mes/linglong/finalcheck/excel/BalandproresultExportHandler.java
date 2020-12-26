package com.bluebirdme.mes.linglong.finalcheck.excel;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.service.BalandproresultServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.DailyReportOfFinishedProductQualityInspectionServiceImpl;
import org.xdemo.app.xutils.j2se.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BalandproresultExportHandler  extends DefaultExcelExportHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
        BalandproresultServiceImpl service = (BalandproresultServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("BalandproresultServiceImpl"));
        List<Object> list = new ArrayList<Object>();
        List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
        ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("exportServiceImpl"));
        // 转换数据，数据赋值
        if (entityList != null) {
            String str = null;
            for (int i = 0; i < entityList.size(); i++) {
                list.add(entityList.get(i));
            }
        }
        return list;
    }


    @Override
    public void regFormatter() {

    }
}
