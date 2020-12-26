/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.halfpart.service.WorkerLoginRecordServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class WorkerLoginRecordExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	WorkerLoginRecordServiceImpl shu = (WorkerLoginRecordServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("workerLoginRecordServiceImpl"));

		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu = shu.datagridRowsUDA(filter, page);

		if (listshu != null) {
			for (int i = 0; i < listshu.size(); i++) {
				if (listshu.get(i).containsKey("equip_code_s")){
					//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
					listshu.get(i).put("equip_code_s", listshu.get(i).get("equip_code_s").toString());
				}
				if (listshu.get(i).containsKey("worker_id_s")){
					//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
					listshu.get(i).put("worker_id_s", listshu.get(i).get("worker_id_s").toString());
				}
				if (listshu.get(i).containsKey("worker_name_s")){
					if (listshu.get(i).get("worker_name_s") == null) {
						listshu.get(i).put("worker_name_s", shu.toChangedName(listshu.get(i).get("worker_id_s").toString()).get(0).get("username"));
					}else {
						listshu.get(i).put("worker_name_s", listshu.get(i).get("worker_name_s").toString());
					}
				}
				if (listshu.get(i).containsKey("worker_type_s")){
					if (listshu.get(i).get("worker_type_s") == null) {
						listshu.get(i).put("worker_type_s", "");
					} else {
						listshu.get(i).put("worker_type_s", shu.toWorkerType(listshu.get(i).get("worker_type_s").toString()).get(0).get("dictname_s"));	
					}
				}
				
				if (listshu.get(i).containsKey("login_type_s")){
					if (listshu.get(i).get("login_type_s") == null) {
						listshu.get(i).put("login_type_s", "");
					} else {
						if (listshu.get(i).get("login_type_s").toString().equals("1")) {
							listshu.get(i).put("login_type_s", "登录");	
						}else if (listshu.get(i).get("login_type_s").toString().equals("0")) {
							listshu.get(i).put("login_type_s", "注销");	
						}
					}
				}
				
				if (listshu.get(i).containsKey("group_s")){
					if (listshu.get(i).get("group_s") == null) {
						listshu.get(i).put("group_s", "");
					} else {
						if (listshu.get(i).get("group_s").toString().equals("301001")) {
							listshu.get(i).put("group_s", "甲班");	
						}else if (listshu.get(i).get("group_s").toString().equals("301002")) {
							listshu.get(i).put("group_s", "乙班");	
						}else if (listshu.get(i).get("group_s").toString().equals("301003")) {
							listshu.get(i).put("group_s", "丙班");	
						}
					}
				}
				if (listshu.get(i).containsKey("classid_s")){
					if (listshu.get(i).get("classid_s") == null) {
						listshu.get(i).put("classid_s", "");
					} else {
						if (listshu.get(i).get("classid_s").toString().equals("118001")) {
							listshu.get(i).put("classid_s", "早班");	
						}else if (listshu.get(i).get("classid_s").toString().equals("118002")) {
							listshu.get(i).put("classid_s", "中班");	
						}else if (listshu.get(i).get("classid_s").toString().equals("118003")) {
							listshu.get(i).put("classid_s", "晚班");	
						}
					}
				}
				if (listshu.get(i).containsKey("created_by_s")){
					if (listshu.get(i).get("created_by_s") == null) {
						listshu.get(i).put("created_by_s", "");
					} else {
						listshu.get(i).put("created_by_s", shu.toChangedName(listshu.get(i).get("created_by_s").toString()).get(0).get("username"));	
					}
				}
				if (listshu.get(i).containsKey("created_time_t")){
					//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
					listshu.get(i).put("created_time_t", listshu.get(i).get("created_time_t"));
				}
				if (listshu.get(i).containsKey("changed_by_s")){
					if (listshu.get(i).get("changed_by_s") == null) {
						listshu.get(i).put("changed_by_s", "");
					} else {
						listshu.get(i).put("changed_by_s", shu.toChangedName(listshu.get(i).get("changed_by_s").toString()).get(0).get("username"));	
					}
				}
				if (listshu.get(i).containsKey("changed_time_t")){
					if (listshu.get(i).get("changed_time_t") == null) {
						listshu.get(i).put("changed_time_t", "");
					} else {
						listshu.get(i).put("changed_time_t", listshu.get(i).get("changed_time_t"));	
					}
				}
			}
		}
		if (listshu != null) {
			for (int i = 0; i < listshu.size(); i++) {
				listATO.add(listshu.get(i));
			}
		}
		return listATO;
   	}
    
    @Override
    public void regFormatter() {
        
    }

}
