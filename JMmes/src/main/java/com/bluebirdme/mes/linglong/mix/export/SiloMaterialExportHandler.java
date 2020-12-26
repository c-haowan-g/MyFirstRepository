/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.export;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.mix.service.PlanServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.SiloMaterialServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * 
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class SiloMaterialExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		SiloMaterialServiceImpl service = (SiloMaterialServiceImpl) SpringContext
				.getBean(StringUtils
				// 需要将"SiloMaterialServiceImpl"首字母改为小写
						.firstCharToLowerCase("SiloMaterialServiceImpl"));
		PlanServiceImpl servicepl = (PlanServiceImpl) SpringContext
				.getBean(StringUtils
				// 需要将"SiloMaterialServiceImpl"首字母改为小写
						.firstCharToLowerCase("PlanServiceImpl"));
		List<Map<String, Object>> listeq = servicepl.getJlEquipList("051004");
		List<Object> list = new ArrayList<Object>();
		filter.set("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter,
				page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		// 转换数据，数据赋值
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				if (entityList.get(i).get("equip_code_s") != null) {
					for (int j = 0; j < listeq.size(); j++) {
						if (entityList.get(i).get("equip_code_s")
								.equals(listeq.get(j).get("p_line_name"))) {
							entityList.get(i).put("equip_code_s",
									listeq.get(j).get("description"));
							break;
						}
					}
				}
				if (entityList.get(i).get("materialtype_s") != null) {
					entityList.get(i).put(
							"materialtype_s",
							exportCombox.getDictName(entityList.get(i)
									.get("materialtype_s").toString()));
				}
				if (entityList.get(i).get("status_s") != null) {
					entityList.get(i).put(
							"status_s",
							exportCombox.getDictName(entityList.get(i)
									.get("status_s").toString()));
				}
				if (entityList.get(i).get("check_by_s") != null) {
					entityList.get(i).put(
							"check_by_s",
							exportCombox.getUserName(entityList.get(i)
									.get("check_by_s").toString()));
				}
				if (entityList.get(i).get("send_by_s") != null) {
					entityList.get(i).put(
							"send_by_s",
							exportCombox.getUserName(entityList.get(i)
									.get("send_by_s").toString()));
				}
				if (entityList.get(i).get("created_by_s") != null) {
					entityList.get(i).put(
							"created_by_s",
							exportCombox.getUserName(entityList.get(i)
									.get("created_by_s").toString()));
				}
				if (entityList.get(i).get("spare1_s") != null) {
					if (entityList.get(i).get("spare1_s").equals("0")) {
						entityList.get(i).put("spare1_s", "未下发");
					} else if (entityList.get(i).get("spare1_s").equals("1")) {
						entityList.get(i).put("spare1_s", "已下发");
					} else if (entityList.get(i).get("spare1_s").equals("2")) {
						entityList.get(i).put("spare1_s", "下发失败");
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
