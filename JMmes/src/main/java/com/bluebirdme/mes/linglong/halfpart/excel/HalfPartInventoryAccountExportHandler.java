/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.HalfPartInventoryAccountServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.LedgerServiceImpl;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 *
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class HalfPartInventoryAccountExportHandler extends DefaultExcelExportHandler {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
        HalfPartInventoryAccountServiceImpl service = (HalfPartInventoryAccountServiceImpl) SpringContext.getBean(StringUtils
                //需要将"LedgerServiceImpl"首字母改为小写
                .firstCharToLowerCase("halfPartInventoryAccountServiceImpl"));
        List<Object> list = new ArrayList<Object>();
        List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page, null);
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
                if (entityList.get(i).get("quality_status_s") != null) {
                    entityList.get(i).put("quality_status_s", exportCombox.getDictName((String) entityList.get(i).get("quality_status_s")));
                }
                if (entityList.get(i).get("isrunout_s") != null) {
                    if (entityList.get(i).get("isrunout_s").equals("1")) {
                        str = "是";
                    } else if (entityList.get(i).get("isrunout_s").equals("0")) {
                        str = "否";
                    }
                    entityList.get(i).put("isrunout_s", str);
                }
                if (entityList.get(i).get("m_units_s") != null) {
                    entityList.get(i).put("m_units_s", exportCombox.getDictName((String) entityList.get(i).get("m_units_s")));
                }
                if (entityList.get(i).get("inorout_s") != null) {
                    if (entityList.get(i).get("inorout_s").equals("1")) {
                        str = "盘库入库";
                    } else if (entityList.get(i).get("inorout_s").equals("0")) {
                        str = "正常入库";
                    }
                    entityList.get(i).put("inorout_s", str);
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
