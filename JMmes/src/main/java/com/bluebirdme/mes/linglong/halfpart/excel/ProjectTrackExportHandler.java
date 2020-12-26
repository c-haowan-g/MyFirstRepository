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

import com.bluebirdme.mes.linglong.halfpart.entity.dto.ProductPlanATO;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.halfpart.service.ProjectTrackServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class ProjectTrackExportHandler extends DefaultExcelExportHandler {
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    @Override
		public List<Object> getRows(Filter filter, Page page,String serviceName) throws Exception {
	    	List<Object> listExp = new ArrayList<>();
	    	ProjectTrackServiceImpl service = (ProjectTrackServiceImpl) SpringContext.getBean(StringUtils
					.firstCharToLowerCase("projectTrackServiceImpl"));
			List<ProductPlanATO> list = service.datagridRows(filter, page, ProductPlanATO.class);
			ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
			
			// 转换下拉框
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
				 // <!-- 计划状态：基础数据104 -->
					list.get(i).setStatus_s(exportCombox.getDictname(list.get(i).getStatus_s()));
				}
			}
			
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
				 // <!-- 物料组：基础数据308 -->
					list.get(i).setMaterialgroup_s(exportCombox.getDictname(list.get(i).getMaterialgroup_s()));
				}
			}
			
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
				 // <!-- 客户标识  设置基础数据字典 317 -->
					list.get(i).setCustomerflag_s(exportCombox.getDictname(list.get(i).getCustomerflag_s()));
				}
			}
			
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
				 // <!-- 完成进度加% -->
					list.get(i).setFulfillment_of_schedule(list.get(i).getFulfillment_of_schedule()+"%");
				}
			}
			for(int i =0;i<list.size();i++){
				listExp.add(list.get(i));
			}
			return listExp;
		}
	    
	    @Override
	    public void regFormatter() {
	    
	    }
}
