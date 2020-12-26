/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.ShutDownSetServiceImpl;

/**
 * 导出处理器
 * 
 * @author 周清玉
 * @Date 2018年8月20日 下午2:30:34
 */
public class ShutdownsetExportHandler extends DefaultExcelExportHandler {

	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)throws Exception {
		ShutDownSetServiceImpl shu = (ShutDownSetServiceImpl) SpringContext.getBean("shutDownSetServiceImpl"); 

		List<Object> listATO = new ArrayList<>();
		String FACTORY = "s_factory_s";
		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		List<Map<String, Object>> listshu= shu.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		
		if(listshu.size() !=0){
			for(int i =0;i<listshu.size();i++){
				if (listshu.get(i).containsKey("status_s")){
					if(listshu.get(i).get("valid_flag_s").equals("0")){
						listshu.get(i).put("valid_flag_s", "无效");
					}else{
						listshu.get(i).put("valid_flag_s", "有效");
					}
				}
				//等级
				if (listshu.get(i).containsKey("judge_lever_s")){
					listshu.get(i).put("judge_lever_s", exportCombox.getDictname(listshu.get(i).get("judge_lever_s").toString()));
				}
			}
			for(int i =0;i<listshu.size();i++){
				listATO.add(listshu.get(i));
			}
		}
		return listATO;
	}

	
	@Override
	public void regFormatter() {
	}
}
