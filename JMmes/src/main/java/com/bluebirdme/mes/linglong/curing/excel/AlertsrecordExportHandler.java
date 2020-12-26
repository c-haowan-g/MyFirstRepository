/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.Alertsrecord;
import com.bluebirdme.mes.linglong.curing.service.AlertsrecordServiceImpl;
import com.ibm.icu.text.DecimalFormat;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class AlertsrecordExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
		AlertsrecordServiceImpl service = (AlertsrecordServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("alertsrecordServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		filter.set("s_factory_s", LLWebUtils.factory());
		List<Map<String, Object>> entityList = service.datagridRowsUDA(filter, page);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));
		DecimalFormat df = new DecimalFormat("0.00");
		// 转换下拉框文本
		for (int i = 0; i < entityList.size(); i++) {
			if (entityList.get(i).containsKey("alarm_from_s")){
				if(entityList.get(i).get("alarm_from_s")!=null&&entityList.get(i).get("alarm_from_s")!=""){
					//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
					entityList.get(i).put("alarm_from_s", exportCombox.getDictname(entityList.get(i).get("alarm_from_s").toString()));
				}
			}
			entityList.get(i).put("alert_level_s",
					exportCombox.getDictName(entityList.get(i).get("alert_level_s").toString()));
			entityList.get(i).put("alert_status_s",
					exportCombox.getDictName(entityList.get(i).get("alert_status_s").toString()));
			entityList.get(i).put("alert_value_s",
					df.format(Double.parseDouble(entityList.get(i).get("alert_value_s").toString())));
			if (entityList.get(i).containsKey("recovery_value_s")){
				if(entityList.get(i).get("recovery_value_s")!=null&&entityList.get(i).get("recovery_value_s")!=""){
					entityList.get(i).put("recovery_value_s",
							df.format(Double.parseDouble(entityList.get(i).get("recovery_value_s").toString())));
				}
			}
		}
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				list.add(entityList.get(i));
			}
		}
		return list;
	}

	@Override
	public List<Object> getRows(Long ids[], String serviceName) {
		AlertsrecordServiceImpl service = (AlertsrecordServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("alertsrecordServiceImpl"));
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("exportServiceImpl"));
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

		List<Alertsrecord> entityList = null;
		try {
			entityList = service.datagridRows(filter, page, Alertsrecord.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 转换下拉框文本
		for (int i = 0; i < entityList.size(); i++) {
			entityList.get(i).setAlert_level_s(exportCombox.getDictName(entityList.get(i).getAlert_level_s()));
			entityList.get(i).setAlert_status_s(exportCombox.getDictName(entityList.get(i).getAlert_status_s()));
		}
		if (entityList != null) {
			for (int i = 0; i < entityList.size(); i++) {
				list.add(entityList.get(i));
			}
		}
		return list;
	}

	@Override
	public void regFormatter() {

		/*
		 * // 机构编号（招远 8000；德州 8002 柳州 8003 泰国8004 ） regFormatter("agenc_no_s",
		 * new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // agenc_no_s return null; } });
		 * 
		 * // 报警来源 regFormatter("alarm_from_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // alarm_from_s return null; } });
		 * 
		 * // 报警次数 regFormatter("alarm_number_i", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // alarm_number_i return null; }
		 * });
		 * 
		 * // 报警代码 regFormatter("alert_code_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // alert_code_s return null; } });
		 * 
		 * // 报警内容 regFormatter("alert_content_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // alert_content_s return null; }
		 * });
		 * 
		 * // 报警等级 regFormatter("alert_level_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // alert_level_s return null; }
		 * });
		 * 
		 * 
		 * 
		 * // 报警时间 regFormatter("alert_time_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // alert_time_s return null; } });
		 * 
		 * // 报警值 regFormatter("alert_value_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // alert_value_s return null; }
		 * });
		 * 
		 * // 交换前条码 regFormatter("change_barcode_s", new IExcelValueFormatter()
		 * {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // change_barcode_s return null; }
		 * });
		 * 
		 * // 创建时间 regFormatter("created_time_t", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // created_time_t return null; }
		 * });
		 * 
		 * // 机台条码 regFormatter("equip_code_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // equip_code_s return null; } });
		 * 
		 * // 操作时间 regFormatter("operatetime_t", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // operatetime_t return null; }
		 * });
		 * 
		 * // 操作人 regFormatter("operator_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // operator_s return null; } });
		 * 
		 * // 质量确认人 regFormatter("quality_confirmor_s", new
		 * IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // quality_confirmor_s return
		 * null; } });
		 * 
		 * // 质量确认时间 regFormatter("quality_confirmtime_t", new
		 * IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // quality_confirmtime_t return
		 * null; } });
		 * 
		 * // 确认质量 regFormatter("quality_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // quality_s return null; } });
		 * 
		 * // 记录标志,A可用，D删除 regFormatter("record_flag_s", new
		 * IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // record_flag_s return null; }
		 * });
		 * 
		 * // 恢复时间 regFormatter("recovery_time_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // recovery_time_s return null; }
		 * });
		 * 
		 * // 恢复值 regFormatter("recovery_value_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // recovery_value_s return null; }
		 * });
		 * 
		 * // 备用字段1 regFormatter("spare1_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // spare1_s return null; } });
		 * 
		 * // 备用字段2 regFormatter("spare2_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // spare2_s return null; } });
		 * 
		 * // 备用字段3 regFormatter("spare3_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // spare3_s return null; } });
		 * 
		 * // 备用字段4 regFormatter("spare4_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // spare4_s return null; } });
		 * 
		 * // 备用字段5 regFormatter("spare5_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // spare5_s return null; } });
		 * 
		 * // 工厂（1全钢 2半钢） regFormatter("s_factory_s", new IExcelValueFormatter()
		 * {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // s_factory_s return null; } });
		 * 
		 * // 轮胎条码 regFormatter("tyre_barcode_s", new IExcelValueFormatter() {
		 * 
		 * @Override public String format(Object value) { // return
		 * sdf.format(new Date((Long)value)); // tyre_barcode_s return null; }
		 * });
		 */

	}

}
