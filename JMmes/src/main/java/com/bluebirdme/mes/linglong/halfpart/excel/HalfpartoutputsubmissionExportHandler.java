package com.bluebirdme.mes.linglong.halfpart.excel;

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
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.service.HalfpartMachineOutputSearchServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.QualityCheckServiceImpl;

public class HalfpartoutputsubmissionExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		HalfpartMachineOutputSearchServiceImpl service = (HalfpartMachineOutputSearchServiceImpl)SpringContext.getBean(StringUtils
				.firstCharToLowerCase("HalfpartMachineOutputSearchServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		filter.set("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> oldentityList = service.datagridRowsUDA(filter,page);
		List<Map<String, Object>> entityList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listresult = service.searchUsercode();
		
		for (int i = 0; i < oldentityList.size(); i++) {
			Map<String, Object> map = oldentityList.get(i);
			String spare2_s = (String) map.get("spare2_s");
			if(null != spare2_s && !(spare2_s == "")){
				entityList.add(map);
			}
		}
		
		// 转换数据，数据赋值
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				if (entityList.get(i).get("operator1_s") != null) {
					for (Map<String, Object> map : listresult) {
						if (entityList.get(i).get("operator1_s")
								.equals(map.get("USERCODE"))) {
							entityList.get(i).put("operator1_s",
									map.get("USERNAME"));
						}
					}
				}
				if (entityList.get(i).get("assistantone_s") != null) {
					for (Map<String, Object> map : listresult) {
						if (entityList.get(i).get("assistantone_s")
								.equals(map.get("USERCODE"))) {
							entityList.get(i).put("assistantone_s",
									map.get("USERNAME"));
						}
					}
				}
				if (entityList.get(i).get("curlyworker_s") != null) {
					for (Map<String, Object> map : listresult) {
						if (entityList.get(i).get("curlyworker_s")
								.equals(map.get("USERCODE"))) {
							entityList.get(i).put("curlyworker_s",
									map.get("USERNAME"));
						}
					}
				}
				if (entityList.get(i).get("curlyassistone_s") != null) {
					for (Map<String, Object> map : listresult) {
						if (entityList.get(i).get("curlyassistone_s")
								.equals(map.get("USERCODE"))) {
							entityList.get(i).put("curlyassistone_s",
									map.get("USERNAME"));
						}
					}
				}
				if (entityList.get(i).get("outputflag_s") != null) {
					if (entityList.get(i).get("outputflag_s").equals("0")) {
						entityList.get(i).put("outputflag_s", "服务端");
					} else {
						entityList.get(i).put("outputflag_s", "客户端");
					}
				}
				if (entityList.get(i).get("solidifyflag_s") != null) {
					if (entityList.get(i).get("solidifyflag_s").equals("0")) {
						entityList.get(i).put("solidifyflag_s", "未固化");
					} else {
						entityList.get(i).put("solidifyflag_s", "已固化");
					}
				}
				if (entityList.get(i).get("outflag_s") != null) {
					if (entityList.get(i).get("outflag_s").equals("105001")) {
						entityList.get(i).put("outflag_s", "正常产出");
					} else if (entityList.get(i).get("outflag_s")
							.equals("105002")) {
						entityList.get(i).put("outflag_s", "补产出");
					} else if (entityList.get(i).get("outflag_s")
							.equals("105003")) {
						entityList.get(i).put("outflag_s", "取消产出");
					}
				}

				if (entityList.get(i).get("outclass_s") != null) {
					if (entityList.get(i).get("outclass_s").equals("118001")) {
						entityList.get(i).put("outclass_s", "早班");
					} else if (entityList.get(i).get("outclass_s")
							.equals("118002")) {
						entityList.get(i).put("outclass_s", "中班");
					} else if (entityList.get(i).get("outclass_s")
							.equals("118003")) {
						entityList.get(i).put("outclass_s", "晚班");
					}
				}

				list.add(entityList.get(i));
			}
			System.out.println(list);
		}
		return list;
	}

	@Override
	public void regFormatter() {

	}

}
