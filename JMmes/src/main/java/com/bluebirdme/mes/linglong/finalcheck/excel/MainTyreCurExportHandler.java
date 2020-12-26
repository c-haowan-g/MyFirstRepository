package com.bluebirdme.mes.linglong.finalcheck.excel;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.service.MainTyreServiceImpl;
import org.xdemo.app.xutils.j2se.StringUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainTyreCurExportHandler extends DefaultExcelExportHandler {
    @Override
    public void regFormatter() {

    }

    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
        MainTyreServiceImpl service = (MainTyreServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("MainTyreServiceImpl"));
        List<Object> list = new ArrayList<Object>();
        List<Map<String, Object>> entityList = service.datagridRows2(filter, page);
        ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("exportServiceImpl"));
        // 转换数据，数据赋值
        if (entityList != null) {
            DecimalFormat df = new DecimalFormat("#.00");
            for (int i = 0; i < entityList.size(); i++) {
                if (entityList.get(i).get("totalnum") != null) {
                    if (entityList.get(i).get("totalnum").equals("0")) {
                        entityList.get(i).put("onetime_rate", "0%");
                    } else {
                        entityList.get(i).put("onetime_rate", df.format(Double.parseDouble(String.valueOf(entityList.get(i).get("onetimepass_count")))
                                / Double.parseDouble((String.valueOf(entityList.get(i).get("totalnum"))))) + "%");
                    }
                }
                int count = Integer.parseInt(String.valueOf(entityList.get(i).get("taiquanquejiao_count_s") == null ? 0 : entityList.get(i).get("taiquanquejiao_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("taicequejiao_count_s") == null ? 0 : entityList.get(i).get("taicequejiao_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("taiguanquejiao_count_s") == null ? 0 : entityList.get(i).get("taiguanquejiao_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("taijianquejiao_count_s") == null ? 0 : entityList.get(i).get("taijianquejiao_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("zawu_count_s") == null ? 0 : entityList.get(i).get("zawu_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("jiaobian_count_s") == null ? 0 : entityList.get(i).get("jiaobian_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("gemaosunshang_count_s") == null ? 0 : entityList.get(i).get("gemaosunshang_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("taiquanqipao_count_s") == null ? 0 : entityList.get(i).get("taiquanqipao_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("others_count_s") == null ? 0 : entityList.get(i).get("others_count_s")));
                int countAll = Integer.parseInt(String.valueOf(entityList.get(i).get("taiquanquejiao_count_s") == null ? 0 : entityList.get(i).get("taiquanquejiao_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("taicequejiao_count_s") == null ? 0 : entityList.get(i).get("taicequejiao_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("taiguanquejiao_count_s") == null ? 0 : entityList.get(i).get("taiguanquejiao_count_s"))) +
                        Integer.parseInt(String.valueOf(entityList.get(i).get("taijianquejiao_count_s") == null ? 0 : entityList.get(i).get("taijianquejiao_count_s")));
                entityList.get(i).put("quejiao_count_s", count);
                entityList.get(i).put("rease_count_s", countAll);

                list.add(entityList.get(i));
            }
        }
        return list;
    }
}
