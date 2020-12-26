<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		$('#begin_created_timejl').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_created_timejl').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});

		$('#begin_created_timexl').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_created_timexl').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
		filterjl();
		filterxl();
	});

	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

	/**
	 * 获取胶料机台信息
	 */
	var jlequipList = [];
	$.ajax({
		url : "mix/planManagement/dayPlan/getJlEquipList?plantype=" + "051003",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			jlequipList = data;
		}
	});

	/**
	 * 获取小料机台信息
	 */
	var xlequipList = [];
	$.ajax({
		url : "mix/planManagement/dayPlan/getXlEquipList",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			xlequipList = data;
		}
	});

	var saveChanges = path + "mix/planManagement/workOrderExec/saveChanges";

	function showOrHide() {
		if ($("#WorkOrderExec_search_form").is(":hidden")) {
			$("#WorkOrderExec_search_form").show();
		} else {
			$("#WorkOrderExec_search_form").hide();
		}
	}

	/**
	 * 查询方法
	 */
	var filterjl = function() {
		var opts = $("#workorderexec_dgjl").datagrid("options");
		opts.url = 'mix/planManagement/workOrderExec/datagridjl';
		ext.easyui.grid.search("workorderexec_dgjl",
				"WorkOrderExec_search_formjl");
	};

	/**
	 * 查询方法
	 */
	var filterxl = function() {
		var opts = $("#workorderexec_dgxl").datagrid("options");
		opts.url = 'mix/planManagement/workOrderExec/datagridxl';
		ext.easyui.grid.search("workorderexec_dgxl",
				"WorkOrderExec_search_formxl");
	};

	function add() {
		ext.easyui.grid.appendAndEdit("workorderexec_dg", {});
	}

	function edit() {
		var rows = $("#workorderexec_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#workorderexec_dg").datagrid("getRowIndex", rows[i]);
			$("#workorderexec_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {
		var rows = $("#workorderexec_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#workorderexec_dg").datagrid("getRowIndex", rows[i]);
			$("#workorderexec_dg").datagrid("deleteRow", index);
		}
	}

	function save() {
		var dg = $("#workorderexec_dg");
		var rows = dg.datagrid("getRows");
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("<spring:message code="tip.invalid" />");
				return;
			}
		}

		var inserted = dg.datagrid("getChanges", "inserted");
		var updated = dg.datagrid("getChanges", "updated");
		var deleted = dg.datagrid("getChanges", "deleted");

		for (var i = 0; i < rows.length; i++) {
			dg.datagrid("endEdit", i);
		}
		ext.ajax.sendJson(saveChanges, {
			inserted : inserted,
			updated : updated,
			deleted : deleted
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#workorderexec_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />");
		});
	}

	function cancel() {
		$("#workorderexec_dg").datagrid("rejectChanges");
	}

	//胶料导出
	function export_jl() {
		//获取grid 数据
		var node = $("#workorderexec_dgjl").datagrid("getSelections");
		if (node == "") {
			ext.tip.error("<spring:message code="tip.excel" />");
			return;
		}
		var data = JSON.stringify(node);
		if (data == '')
			return;
		var title = [ {
			atr_key : '序号'
		}, {
			sync_flag_s : '同步类型'
		}, {
			sync_hand_flag_s : '处理标记'
		}, {
			sync_create_time_t : '同步时间'
		}, {
			sync_hand_msg_s : '处理反馈'
		}, {
			sync_hand_time_t : '处理时间'
		}, {
			wo_no_s : '工单号'
		}, {
			wo_status_s : '工单状态'
		}, {
			wo_date_s : '生产日期'
		}, {
			wo_shift_s : '工单班次'
		}, {
			wo_seq_i : '顺序号'
		}, {
			qty_plan_i : '计划量'
		}, {
			qty_complete_i : '完成量'
		}, {
			equip_name_s : '机台名称'
		}, {
			material_code_s : '物料编码'
		}, {
			material_name_s : '物料名称'
		}, {
			recipe_code_s : '配方编号'
		}, {
			recipe_bom_version_s : '配方版本'
		}, {
			weightche_s : '当前车次'
		}, {
			plan_no_s : '日计划号'
		}, {
			act_start_time_t : '执行开始时间'
		}, {
			act_finish_time_t : '执行结束时间'
		}, {
			quickcheck_recipe_code_s : '快件配方编号'
		}, {
			status_check_s : '快检工单状态'
		}, {
			qty_check_f : '工单检验量'
		}, {
			qty_check_complete_i : '工单检验完成量'
		}, {
			begin_check_train_num_s : '开始检验车次号'
		}, {
			end_check_train_num_s : '结束检验车次号'
		}, {
			qty_check_good_i : '检验合格数量'
		}, {
			qty_check_bad_i : '检验不合格数量'
		}, {
			act_start_checktime_t : '执行开始时间'
		}, {
			act_finish_checktime_t : '执行结束时间'
		}, {
			send_by_s : '下发人'
		}, {
			send_time_t : '下发时间'
		}, {
			check_by_s : '审核人'
		}, {
			check_time_t : '审核时间'
		}, {
			changed_by_s : '修改人'
		}, {
			changed_time_t : '修改时间'
		}, {
			created_by_s : '创建人'
		}, {
			created_time_t : '创建时间'
		} ];
		toExcel("密炼胶料工单导出", data, title);
	}

	//小料导出
	function export_xl() {
		//获取grid 数据
		var node = $("#workorderexec_dgxl").datagrid("getSelections");
		if (node == "") {
			ext.tip.error("<spring:message code="tip.excel" />");
			return;
		}
		var data = JSON.stringify(node);
		if (data == '')
			return;
		var title = [ {
			atr_key : '序号'
		}, {
			sync_flag_s : '同步类型'
		}, {
			sync_hand_flag_s : '处理标记'
		}, {
			sync_create_time_t : '同步时间'
		}, {
			sync_hand_msg_s : '处理反馈'
		}, {
			sync_hand_time_t : '处理时间'
		}, {
			wo_no_s : '工单号'
		}, {
			wo_status_s : '工单状态'
		}, {
			wo_date_s : '生产日期'
		}, {
			wo_shift_s : '工单班次'
		}, {
			wo_seq_i : '顺序号'
		}, {
			qty_plan_i : '计划量'
		}, {
			qty_complete_i : '完成量'
		}, {
			equip_name_s : '机台名称'
		}, {
			material_code_s : '物料编码'
		}, {
			material_name_s : '物料名称'
		}, {
			recipe_code_s : '配方编号'
		}, {
			recipe_bom_version_s : '配方版本'
		}, {
			weightche_s : '当前车次'
		}, {
			plan_no_s : '日计划号'
		}, {
			act_start_time_t : '执行开始时间'
		}, {
			act_finish_time_t : '执行结束时间'
		}, {
			quickcheck_recipe_code_s : '快件配方编号'
		}, {
			status_check_s : '快检工单状态'
		}, {
			qty_check_f : '工单检验量'
		}, {
			qty_check_complete_i : '工单检验完成量'
		}, {
			begin_check_train_num_s : '开始检验车次号'
		}, {
			end_check_train_num_s : '结束检验车次号'
		}, {
			qty_check_good_i : '检验合格数量'
		}, {
			qty_check_bad_i : '检验不合格数量'
		}, {
			act_start_checktime_t : '执行开始时间'
		}, {
			act_finish_checktime_t : '执行结束时间'
		}, {
			send_by_s : '下发人'
		}, {
			send_time_t : '下发时间'
		}, {
			check_by_s : '审核人'
		}, {
			check_time_t : '审核时间'
		}, {
			changed_by_s : '修改人'
		}, {
			changed_time_t : '修改时间'
		}, {
			created_by_s : '创建人'
		}, {
			created_time_t : '创建时间'
		} ];
		toExcel("密炼小料工单导出", data, title);
	}

	//FileName 生成的Excel文件名称
	function toExcel(FileName, JSONData, ShowLabel) {
		//先转化json  x
		var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
				: JSONData;
		var excel = '<table>';
		//设置表头  
		var row = "<tr align='left'>";//设置Excel的左居中
		for (var i = 0, l = ShowLabel.length; i < l; i++) {
			for ( var key in ShowLabel[i]) {
				row += "<td style='font-weight:bold;font-size:17px;border-bottom:1px solid black;'>"
						+ ShowLabel[i][key] + '</td>';
			}
		}
		//换行  
		excel += row + "</tr>";
		//设置数据  
		for (var i = 0; i < arrData.length; i++) {
			var rowData = "<tr align='left'>";
			for (var y = 0; y < ShowLabel.length; y++) {
				for ( var k in ShowLabel[y]) {
					//alert(arrData[i]['CONTROLSTATUS_S']);
					if (ShowLabel[y].hasOwnProperty(k)) {
						if (k == "wo_status_s") {
							var wo_status_s = "";
							if (arrData[i]['wo_status_s'] != null) {
								wo_status_s = codeFormatter(
										arrData[i]['wo_status_s'], null, null);
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ wo_status_s + "</td>";
							continue;
						}
						if (k == "wo_shift_s") {
							var wo_shift_s = "";
							if (arrData[i]['wo_shift_s'] != null) {
								wo_shift_s = codeFormatter(
										arrData[i]['wo_shift_s'], null, null);
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ wo_shift_s + "</td>";
							continue;
						}
						if (k == "status_check_s") {
							var status_check_s = "";
							if (arrData[i]['status_check_s'] != null) {
								status_check_s = codeFormatter(
										arrData[i]['status_check_s'], null,
										null);
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ status_check_s + "</td>";
							continue;
						}
						if (k == "check_by_s") {
							var check_by_s = "";
							if (arrData[i]['check_by_s'] != null) {
								check_by_s = toUserName(
										arrData[i]['check_by_s'], null, null);
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ check_by_s + "</td>";
							continue;
						}
						if (k == "send_by_s") {
							var send_by_s = "";
							if (arrData[i]['send_by_s'] != null) {
								send_by_s = toUserName(arrData[i]['send_by_s'],
										null, null);
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ send_by_s + "</td>";
							continue;
						}
						if (k == "changed_by_s") {
							var changed_by_s = "";
							if (arrData[i]['changed_by_s'] != null) {
								changed_by_s = toUserName(
										arrData[i]['changed_by_s'], null, null);
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ changed_by_s + "</td>";
							continue;
						}
						if (k == "created_by_s") {
							var created_by_s = "";
							if (arrData[i]['created_by_s'] != null) {
								created_by_s = toUserName(
										arrData[i]['created_by_s'], null, null);
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ created_by_s + "</td>";
							continue;
						}
						rowData += "<td style='vnd.ms-excel.numberformat:@'>"
								+ (arrData[i][k] === null ? "" : arrData[i][k])
								+ "</td>";
						//vnd.ms-excel.numberformat:@ 输出为文本
					}
				}
			}
			excel += rowData + "</tr>";
		}
		excel += "</table>";
		var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
		excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
		excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel';  
        excelFile += '; charset=UTF-8">';
		excelFile += "<head>";
		excelFile += "<!--[if gte mso 9]>";
		excelFile += "<xml>";
		excelFile += "<x:ExcelWorkbook>";
		excelFile += "<x:ExcelWorksheets>";
		excelFile += "<x:ExcelWorksheet>";
		excelFile += "<x:Name>";
		excelFile += FileName;
		excelFile += "</x:Name>";
		excelFile += "<x:WorksheetOptions>";
		excelFile += "<x:DisplayGridlines/>";
		excelFile += "</x:WorksheetOptions>";
		excelFile += "</x:ExcelWorksheet>";
		excelFile += "</x:ExcelWorksheets>";
		excelFile += "</x:ExcelWorkbook>";
		excelFile += "</xml>";
		excelFile += "<![endif]-->";
		excelFile += "</head>";
		excelFile += "<body>";
		excelFile += excel;
		excelFile += "</body>";
		excelFile += "</html>";

		var uri = 'data:application/vnd.ms-excel;charset=utf-8,'
				+ encodeURIComponent(excelFile);
		var link = document.createElement("a");
		link.href = uri;
		link.style = "visibility:hidden";
		link.download = FileName + ".xls";
		document.body.appendChild(link);
		link.click();
		document.body.removeChild(link);
	}

	function toUserName(v, r, i) {
		if (v == null) {
			return v;
		}
		$.ajax({
			url : 'mix/baseData/siloMaterial/toUserName',
			type : 'get',
			dataType : 'json',
			data : {
				usercode : v
			},
			async : false,
			success : function(data) {
				if (data.length == 0) {
					return v;
				}
				v = v + data[0].username;
			}
		});
		return v;
	}
</script>