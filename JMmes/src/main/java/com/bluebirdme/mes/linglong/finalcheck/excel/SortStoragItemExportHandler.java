/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortStoragItem;
import com.bluebirdme.mes.linglong.finalcheck.service.SortStoragItemServiceImpl;

/**
 * 导出处理器
 * @author majb
 * @Date 2018年7月13日 下午2:30:34
 */
public class SortStoragItemExportHandler extends DefaultExcelExportHandler {
    private SortStoragItemServiceImpl service=(SortStoragItemServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("SortStoragItemServiceImpl"));
    private ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext
			.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));   
    
    @Override
    public void regFormatter() {
    }
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
   		List<Object> list = new ArrayList<Object>();
   		List<SortStoragItem> entityList = service.datagridRows(filter, page,SortStoragItem.class);
        List<Map<String,Object>> entNameData=service.getEntCodeName();
        for(Map<String,Object> ent:entNameData){
        	// 转换下拉框
       		for (int i = 0; i < entityList.size(); i++) {
       			if(entityList.get(i).getEntbarcode_s().equals(ent.get("ENTBARCODE_S").toString())){
       				entityList.get(i).setEntbarcode_s(ent.get("ENTNAME_S").toString());
       			 }
       		   }
        }
        for (int i = 0; i < entityList.size(); i++) {
   				entityList.get(i).setGradecode_i(exportServiceImpl.getDictName(entityList.get(i).getGradecode_i()));
   		   }
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
   	}

}
