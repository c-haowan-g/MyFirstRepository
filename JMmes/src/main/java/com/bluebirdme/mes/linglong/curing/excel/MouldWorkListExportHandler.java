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
import com.bluebirdme.mes.linglong.curing.service.MouldWorkListServiceImpl;

/**
 * 导出处理器
 * 
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class MouldWorkListExportHandler extends DefaultExcelExportHandler {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@SuppressWarnings({ "rawtypes", "unchecked", "null" })
	@Override
	public List<Object> getRows(Filter filter, Page page, String serviceName)
			throws Exception {
		MouldWorkListServiceImpl service = (MouldWorkListServiceImpl) SpringContext
				.getBean(StringUtils
						.firstCharToLowerCase("mouldWorkListServiceImpl"));
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext
				.getBean(StringUtils.firstCharToLowerCase("exportServiceImpl"));
		List<Object> list = new ArrayList<Object>();
		List<Map<String, Object>> entityList= service.datagridRowsUDA(filter, page);
		for (int i = 0; i < entityList.size(); i++) {
			//判断map中是否包含指定的key
			if (entityList.get(i).containsKey("operate_type_s")){
				//如果存在，可以直接put新的键值对。新的值会自动覆盖之前的。
				entityList.get(i).put("operate_type_s", exportCombox.getDictname(entityList.get(i).get("operate_type_s").toString()));
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
		// // 胶囊条码
		// regFormatter("capsule_code_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //capsule_code_s
		// return null;
		// }
		// });
		//
		// // 修改人
		// regFormatter("changed_by_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //changed_by_s
		// return null;
		// }
		// });
		//
		// // 修改时间
		// regFormatter("changed_time_t", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //changed_time_t
		// return null;
		// }
		// });
		//
		// // 更换原因
		// regFormatter("chang_reason_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //chang_reason_s
		// return null;
		// }
		// });
		//
		// // 是否检查漏油
		// regFormatter("check_oilspill_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //check_oilspill_s
		// return null;
		// }
		// });
		//
		// // 作业班次
		// regFormatter("class_id_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //class_id_s
		// return null;
		// }
		// });
		//
		// // 洗模类型 /修理类型
		// regFormatter("clent_ype_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //clent_ype_s
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
		// // 当前物料编码
		// regFormatter("current_material_code_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //current_material_code_s
		// return null;
		// }
		// });
		//
		// // 作业人
		// regFormatter("execution_operator_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //execution_operator_s
		// return null;
		// }
		// });
		//
		// // 是否结束 0:未结束 1：已结束
		// regFormatter("isend_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //isend_s
		// return null;
		// }
		// });
		//
		// // 能否正常使用
		// regFormatter("isvalid_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //isvalid_s
		// return null;
		// }
		// });
		//
		// // 当前规格编码
		// regFormatter("lastspeccode_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //lastspeccode_s
		// return null;
		// }
		// });
		//
		// // 机台编码
		// regFormatter("machinecode_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //machinecode_s
		// return null;
		// }
		// });
		//
		// // 模具条码
		// regFormatter("moldcode_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //moldcode_s
		// return null;
		// }
		// });
		//
		// // 备注
		// regFormatter("mold_code_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //mold_code_s
		// return null;
		// }
		// });
		//
		// // 作业结束时间
		// regFormatter("operate_endtime_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //operate_endtime_s
		// return null;
		// }
		// });
		//
		// // 作业开始时间
		// regFormatter("operate_starttime_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //operate_starttime_s
		// return null;
		// }
		// });
		//
		// // 机台作业类型 1模具换上，2换胶囊，3洗模 4 模具换下 5模具修理6组装
		// regFormatter("operate_type_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //operate_type_s
		// return null;
		// }
		// });
		//
		// // 换模计划号
		// regFormatter("planno_changemold_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //planno_changemold_s
		// return null;
		// }
		// });
		//
		// // 生产日期
		// regFormatter("product_date_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //product_date_s
		// return null;
		// }
		// });
		//
		// // 记录标志，A可用，D删除
		// regFormatter("record_flag_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //record_flag_s
		// return null;
		// }
		// });
		//
		// // 是否更换密封圈
		// regFormatter("replace_seals_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //replace_seals_s
		// return null;
		// }
		// });
		//
		// // 作业班组
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
		// // 工厂（1全钢 2半钢）
		// regFormatter("s_factory_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //s_factory_s
		// return null;
		// }
		// });
		//
		// // 使用次数
		// regFormatter("usenumber_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //usenumber_s
		// return null;
		// }
		// });
		//
		// // 当前记录次数
		// regFormatter("usenum_current_s", new ExcelValueFormatter() {
		// @Override
		// public String format(Object value) {
		// //return sdf.format(new Date((Long)value));
		// //usenum_current_s
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
