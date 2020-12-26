/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
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
import com.bluebirdme.mes.linglong.finalcheck.service.SortXRaylogServiceImpl;

/**
 * 导出处理器
 *
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class SortXrayLogExportHandler extends DefaultExcelExportHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @SuppressWarnings({"rawtypes", "unchecked", "null"})
    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName)
            throws Exception {
        SortXRaylogServiceImpl service = (SortXRaylogServiceImpl) SpringContext
                .getBean(StringUtils
                        .firstCharToLowerCase("sortXRaylogServiceImpl"));
        List<Object> list = new ArrayList<Object>();
        ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
                .getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
        List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
        if (entityList != null) {
            if (entityList != null) {
                for (int i = 0; i < entityList.size(); i++) {
                    if (entityList.get(i).get("proess_i") != null) {
                        entityList.get(i).put("proess_i", exportCombox.getDictName(entityList.get(i).get("proess_i").toString()));
                    }
                    if (entityList.get(i).get("gradecd_i") != null) {
                        entityList.get(i).put("gradecd_i", exportCombox.getDictName(entityList.get(i).get("gradecd_i").toString()));
                    }
                    if (entityList.get(i).get("sorttype_i") != null) {
                        entityList.get(i).put("sorttype_i", exportCombox.getDictName(entityList.get(i).get("sorttype_i").toString()));
                    }
                    if (entityList.get(i).get("isok_i") != null) {
                        if (entityList.get(i).get("isok_i").equals("1")) {
                            entityList.get(i).put("isok_i", "成功");
                        } else {
                            entityList.get(i).put("isok_i", "失败");
                        }
                    }
                    list.add(entityList.get(i));
                }
            }
        }
        return list;
    }

	@Override
	public void regFormatter() {

	}
}
