/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.finalcheck.entity.Reas;
import com.bluebirdme.mes.linglong.finalcheck.service.ReasServiceImpl;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class ReasBLExportHandler extends DefaultExcelExportHandler {
    @Override
    public void regFormatter() {
       
    }
    public ReasServiceImpl service = (ReasServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("ReasServiceImpl"));
    public ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
    	ReasServiceImpl service = (ReasServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("ReasServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Reas> entityList = service.datagridRows(filter, page,Reas.class);
   		ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
   		// 转换下拉框
   		for (int i = 0; i < entityList.size(); i++) {
   			entityList.get(i).setCreated_by_s(exportServiceImpl.getUserName(entityList.get(i).getCreated_by_s()));
   			entityList.get(i).setChanged_by_s(exportServiceImpl.getUserName(entityList.get(i).getChanged_by_s()));
   		    entityList.get(i).setReas_grp_type_s(exportServiceImpl.getDictname(entityList.get(i).getReas_grp_type_s()));
   		    entityList.get(i).setCollet_code_s(exportServiceImpl.getDictname(entityList.get(i).getCollet_code_s()));
   		}
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				list.add(entityList.get(i));
   			}
   		
   		}
   		return list;
   	}

}
