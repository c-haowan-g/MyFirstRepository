package com.bluebirdme.mes.linglong.curing.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.MachineControlServiceImpl;

/**
 * 硫化机台控制管理
 * 
 * @author 周清玉
 * @Date 2018-08-10 13:31:38
 */
public class MachineControlExportHandler extends DefaultExcelExportHandler {
	HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	HttpSession session = request.getSession();

	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		MachineControlServiceImpl shu = (MachineControlServiceImpl) SpringContext.getBean("machineControlServiceImpl");

		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu= shu.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		// 转换下拉框
		for (int i = 0; i < listshu.size(); i++) {
			// 机台状态
			//判断map中是否包含指定的key
			if (listshu.get(i).containsKey("status_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
				listshu.get(i).put("status_s", exportCombox.getDictname(listshu.get(i).get("status_s").toString()));
			}
		}
		for (int i = 0; i < listshu.size(); i++) {
			listATO.add(listshu.get(i));
		}

		return listATO;
	}
	@Override
	public void regFormatter() {
		
        //是否温模，1是，0，否
		regFormatter("mold_heatflag_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});

		// 是否单机运行 1 是 0 否
		regFormatter("offlinerunflag_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});

		// 警报需解除受控 1：是 （受控） 0：否（不受控，自动解除）
		regFormatter("alarm_controlflag_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});

		// 首模需验证 受控 1：是 0：否（首模不需验证）
		regFormatter("firstmold_controlflag_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});
		// <!-- 验证放行标志，0不放行，1：放行 -->
		regFormatter("verification_mark_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});
		// 胎胚时效性验证 1：是 0： 否
		regFormatter("tyre_timever_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});

		// 胚胎领用验证 1：是 0： 否
		regFormatter("tyre_pickver_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});

		// 后工序停机控制开关 1：是 0： 否
		regFormatter("qs_stop_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});

		// 后充气受控 1：是 0： 否
		regFormatter("tyrebar_controlflag_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});
		
		// 投料管控 1：是 0： 否
		regFormatter("tyre_feeding_s", new IExcelValueFormatter() {
			public String format(Object value) {
				// TODO Auto-generated method stub
				if(value!=null){
					if (value.equals("0")) {
						return "否";
					} else if (value.equals("1")) {
						return "是";
					} else {
						return (String) value;
					}
				}else{
					return null;
				}
			}
		});
	}
}
