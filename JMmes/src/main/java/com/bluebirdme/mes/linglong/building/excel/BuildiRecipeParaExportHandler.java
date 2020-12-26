/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.service.BuildRecipeParaServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;

/**
 * 导出处理器
 * 
 * @author Goofy qingyu_zhou PLM配方下发基础参数表
 * @Date 2018年7月13日 下午2:30:34
 */
public class BuildiRecipeParaExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		BuildRecipeParaServiceImpl service = (BuildRecipeParaServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("buildRecipeParaServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
		// ExportServiceImpl exportCombox = (ExportServiceImpl)
		// SpringContext.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		List<Map<String, Object>> listMaps = service.getComboxequiptype();
		// 转换下拉框文本
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {

				if (entityList.get(i).get("is_max_min_s") != null) {
					if (entityList.get(i).get("is_max_min_s").equals("A")) {
						entityList.get(i).put("is_max_min_s", "启用");
					} else {
						entityList.get(i).put("is_max_min_s", "停用");
					}
				}

				if (entityList.get(i).get("record_flag_s").equals("A")) {
					entityList.get(i).put("record_flag_s", "启用");
				} else {
					entityList.get(i).put("record_flag_s", "停用");
				}
				if (entityList.get(i).get("equipmenttypecode_s") != null) {
					boolean k = true;
					int j = 0;
					while (k) {
						if (j < listMaps.size()) {
							Map<String, Object> map = listMaps.get(j);
							boolean p = false;
							for (Map.Entry<String, Object> imap : map.entrySet()) {
								if (imap.getKey().equals("EQUIPMENTTYPECODE_S")) {
									if (imap.getValue().equals(entityList.get(i).get("equipmenttypecode_s"))) {
										p = true;
										continue;
									}
								}
								if (p) {
									if (imap.getKey().equals("EQUIPMENTTYPENAME_S")) {
										entityList.get(i).put("equipmenttypecode_s", imap.getValue());
										k = false;
									}
								}
							}
							j++;
						} else {
							k = false;
						}
					}
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
