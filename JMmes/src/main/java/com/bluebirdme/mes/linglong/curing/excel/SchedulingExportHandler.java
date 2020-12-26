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

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.curing.service.SchedulingServiceImpl;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class SchedulingExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		SchedulingServiceImpl service = (SchedulingServiceImpl) SpringContext
				.getBean(StringUtils
						.firstCharToLowerCase("schedulingServiceImpl"));
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> entityList= service.datagridRowsUDA(filter, page);
		for (int i = 0; i < entityList.size(); i++) {
			//判断map中是否包含指定的key
			if (entityList.get(i).containsKey("class_id_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
				entityList.get(i).put("class_id_s", exportCombox.getDictname(entityList.get(i).get("class_id_s").toString()));
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
	public void regFormatter() {

		// // 机构编号（招远 8000；德州 8002 柳州 8003 泰国8004 ）
		// regFormatter("agenc_no_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //agenc_no_s
		// return null;
		// }
		// });
		//
		// // 更新人编号
		// regFormatter("changed_by_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //changed_by_s
		// return null;
		// }
		// });
		//
		// // 更新人时间
		// regFormatter("changed_time_t", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //changed_time_t
		// return null;
		// }
		// });
		//
		// // 班次
		// regFormatter("class_id_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //class_id_s
		// return null;
		// }
		// });
		//
		// // 创建人
		// regFormatter("created_by_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //created_by_s
		// return null;
		// }
		// });
		//
		// // 创建时间
		// regFormatter("created_time_t", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //created_time_t
		// return null;
		// }
		// });
		//
		// // 结束时间
		// regFormatter("end_time_t", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //end_time_t
		// return null;
		// }
		// });
		//
		// // 机台条码
		// regFormatter("equip_code_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //equip_code_s
		// return null;
		// }
		// });
		//
		// // 备注
		// regFormatter("memo_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //memo_s
		// return null;
		// }
		// });
		//
		// // 工序
		// regFormatter("process_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //process_s
		// return null;
		// }
		// });
		//
		// // 领用日期
		// regFormatter("product_date_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //product_date_s
		// return null;
		// }
		// });
		//
		// // 记录标志(A可用，D删除)
		// regFormatter("record_flag_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //record_flag_s
		// return null;
		// }
		// });
		//
		// // 班组
		// regFormatter("shift_id_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //shift_id_s
		// return null;
		// }
		// });
		//
		// // 备用字段1
		// regFormatter("spare1_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //spare1_s
		// return null;
		// }
		// });
		//
		// // 备用字段2
		// regFormatter("spare2_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //spare2_s
		// return null;
		// }
		// });
		//
		// // 备用字段3
		// regFormatter("spare3_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //spare3_s
		// return null;
		// }
		// });
		//
		// // 备用字段4
		// regFormatter("spare4_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //spare4_s
		// return null;
		// }
		// });
		//
		// // 备用字段5
		// regFormatter("spare5_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //spare5_s
		// return null;
		// }
		// });
		//
		// // 开始时间
		// regFormatter("start_time_t", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //start_time_t
		// return null;
		// }
		// });
		//
		// // 工厂(1全钢 2半钢)
		// regFormatter("s_factory_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //s_factory_s
		// return null;
		// }
		// });
		//
		// // 人员编码
		// regFormatter("user_id_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //user_id_s
		// return null;
		// }
		// });
		//
		// // 人员名称
		// regFormatter("user_name_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //user_name_s
		// return null;
		// }
		// });
		//
		// // 人员类型
		// regFormatter("user_type_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //user_type_s
		// return null;
		// }
		// });
		//
		// // 车间
		// regFormatter("workshop_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //workshop_s
		// return null;
		// }
		// });
		//
		// // CHANGED_TIME_U
		// regFormatter("changed_time_u", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //changed_time_u
		// return null;
		// }
		// });
		//
		// // CREATED_TIME_U
		// regFormatter("created_time_u", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //created_time_u
		// return null;
		// }
		// });
		//
		// // START_TIME_U
		// regFormatter("start_time_u", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //start_time_u
		// return null;
		// }
		// });
		//
		// // CREATED_TIME_Z
		// regFormatter("created_time_z", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //created_time_z
		// return null;
		// }
		// });
		//
		// // ATR_KEY
		// regFormatter("atr_key", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //atr_key
		// return null;
		// }
		// });
		//
		// // END_TIME_Z
		// regFormatter("end_time_z", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //end_time_z
		// return null;
		// }
		// });
		//
		// // END_TIME_U
		// regFormatter("end_time_u", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //end_time_u
		// return null;
		// }
		// });
		//
		// // START_TIME_Z
		// regFormatter("start_time_z", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //start_time_z
		// return null;
		// }
		// });
		//
		// // PRODECT_DATE_T
		// regFormatter("prodect_date_t", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //prodect_date_t
		// return null;
		// }
		// });
		//
		// // CHANGED_TIME_Z
		// regFormatter("changed_time_z", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //changed_time_z
		// return null;
		// }
		// });
		//
	}

}
