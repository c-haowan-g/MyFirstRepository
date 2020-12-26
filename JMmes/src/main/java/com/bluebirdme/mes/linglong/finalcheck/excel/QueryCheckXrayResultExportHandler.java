package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.service.QueryCheckXrayResultServiceImpl;

/**
 * 导出处理器
 *
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class QueryCheckXrayResultExportHandler extends DefaultExcelExportHandler {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
        QueryCheckXrayResultServiceImpl service = (QueryCheckXrayResultServiceImpl) SpringContext.getBean(StringUtils
                //需要将"QueryCheckXrayResultServiceImpl"首字母改为小写
                .firstCharToLowerCase("queryCheckXrayResultServiceImpl"));
        List<Object> list = new ArrayList<Object>();
        List<Map<String, Object>> entityList = (List<Map<String, Object>>) service.datagridUDAReWrite(filter, page).get("rows");
        ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("exportServiceImpl"));
        // 转换数据，数据赋值
        if (entityList != null) {
            for (int i = 0; i < entityList.size(); i++) {
                if (entityList.get(i).get("gradeid_s") != null) {
                    entityList.get(i).put("gradeid_s",exportCombox.getDictName(entityList.get(i).get("gradeid_s").toString()));
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
