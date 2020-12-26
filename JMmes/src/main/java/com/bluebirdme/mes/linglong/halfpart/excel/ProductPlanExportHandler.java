/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlan;
import com.bluebirdme.mes.linglong.halfpart.service.MaterialAgingServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.ProductPlanServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 *
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class ProductPlanExportHandler extends DefaultExcelExportHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void regFormatter() {

    }


    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
        ProductPlanServiceImpl service = (ProductPlanServiceImpl) SpringContext.getBean(StringUtils
                //需要将"MaterialsPlusServiceImpl"首字母改为小写
                .firstCharToLowerCase("ProductPlanServiceImpl"));
        List<Object> list = new ArrayList<Object>();
        List<Map<String, Object>> entityList = service.searchRows(filter, page, null);
        ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
                .firstCharToLowerCase("exportServiceImpl"));
        // 转换数据，数据赋值
        if (entityList != null) {
            for (int i = 0; i < entityList.size(); i++) {

                list.add(entityList.get(i));
            }
        }
        return list;
    }

}
