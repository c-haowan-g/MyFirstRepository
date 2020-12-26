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
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.ReasServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.VisualmCheckSumPrintServiceImpl;

/**
 * 导出处理器 
 * 
 * @author 周清玉 成品质量检查原始记录表
 * @Date 2018年7月13日 下午2:30:34
 */
public class VisualmCheckSumPrintExportHandler extends DefaultExcelExportHandler {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private VisualmCheckSumPrintServiceImpl service = (VisualmCheckSumPrintServiceImpl) SpringContext
			.getBean(StringUtils.firstCharToLowerCase("visualmCheckSumPrintServiceImpl"));
	private ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils
			.firstCharToLowerCase("exportServiceImpl"));

	@Override
	public void regFormatter() {
	}

	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		List<Object> list = new ArrayList<Object>();
		
		String factoryString = LLWebUtils.factory();
		String factoryCodeString = FactoryConstant.JING_MEN_CODE;
		filter.set("s_factory_s", factoryString);
		filter.set("agenc_no_s", factoryCodeString);
		List<Map<String, Object>> entityList = service.datagridRows2(filter,page);
		ExportServiceImpl exportServiceImpl = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));
		ReasServiceImpl reasServiceImpl = (ReasServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("reasServiceImpl"));
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				// 硫化质量等级字典转换
				if(entityList.get(i).get("curinggradecode_s")!=null){
					entityList.get(i).put("curinggradecode_s", exportServiceImpl.getDictName(entityList.get(i).get("curinggradecode_s").toString()));
				}
				// 外检质量等级字典转换
				if(entityList.get(i).get("visualgradecode_s")!=null){
					entityList.get(i).put("visualgradecode_s", exportServiceImpl.getDictName(entityList.get(i).get("visualgradecode_s").toString()));
				}
				// X光质量等级字典转换
				if(entityList.get(i).get("xraygradecode_s")!=null){
					entityList.get(i).put("xraygradecode_s", exportServiceImpl.getDictName(entityList.get(i).get("xraygradecode_s").toString()));
				}
				// 动平衡质量等级字典转换
				if(entityList.get(i).get("dynamicbalancegradecode_s")!=null){
					entityList.get(i).put("dynamicbalancegradecode_s", exportServiceImpl.getDictName(entityList.get(i).get("dynamicbalancegradecode_s").toString()));
				}
				// 外检病象名称格式转换
				if(entityList.get(i).get("visualreascode_s")!=null){
					List<Map<String, Object>> listMap = reasServiceImpl.getComboxReasCodeDesc();
					for (int j = 0; j < listMap.size(); j++) {
						Map<String, Object> map = listMap.get(j);
						if(entityList.get(i).get("visualreascode_s").toString().equals(map.get("REASCODE").toString())){
							entityList.get(i).put("visualreascode_s", map.get("REASDESC").toString());
						}
					}
					
				}
				// X光病象名称格式转换
				if(entityList.get(i).get("xrayreascode_s")!=null){
					List<Map<String, Object>> listMap = reasServiceImpl.getComboxReasCodeDesc();
					for (int j = 0; j < listMap.size(); j++) {
						Map<String, Object> map = listMap.get(j);
						if(entityList.get(i).get("xrayreascode_s").toString().equals(map.get("REASCODE").toString())){
							entityList.get(i).put("xrayreascode_s", map.get("REASDESC").toString());
						}
					}
					
				}
				list.add(entityList.get(i));
			}
		}
		return list;
	}

	@Override
	public List<Object> getRows(Long ids[], String serviceName) {
		List<Object> list = new ArrayList<Object>();
		Filter filter = new Filter();
		String idsString = "";
		for (int i = 0; i < ids.length; i++) {
			if (ids[i].toString().equals("")) {
				break;
			}
			idsString = idsString + "," + ids[i].toString();
		}
		idsString = idsString.substring(1);
		filter.set("ids", "in:" + idsString);
		Page page = new Page();
		page.setAll(1);

		List<Map<String, Object>> entityList = null;
		try {
			entityList = service.datagridRows2(filter, page);
			if (entityList != null) {
				for (int i = 0; i < entityList.size(); i++) {
					list.add(entityList.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
