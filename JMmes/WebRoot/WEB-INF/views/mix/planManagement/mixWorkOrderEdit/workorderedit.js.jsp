<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		filterjl();
		filterxl();
	});

	var saveChanges = path + "mix/planManagement/workOrderEdit/saveChanges";

	function showOrHide() {
		if ($("#WorkOrderEdit_search_form").is(":hidden")) {
			$("#WorkOrderEdit_search_form").show();
		} else {
			$("#WorkOrderEdit_search_form").hide();
		}
	}

	/**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}

	/**
	 * 解析指定格式日期
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
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

	/**
	 * 查询方法
	 */
	var filterjl = function() {
		var opts = $("#workorderedit_dgjl").datagrid("options");
		opts.url = 'mix/planManagement/workOrderEdit/datagridjl';
		ext.easyui.grid.search("workorderedit_dgjl",
				"WorkOrderEdit_search_formjl");
	};

	/**
	 * 查询方法
	 */
	var filterxl = function() {
		var opts = $("#workorderedit_dgxl").datagrid("options");
		opts.url = 'mix/planManagement/workOrderEdit/datagridxl';
		ext.easyui.grid.search("workorderedit_dgxl",
				"WorkOrderEdit_search_formxl");
	};

	function add() {
		ext.easyui.grid.appendAndEdit("workorderedit_dg", {});
	}

	function edit() {
		var rows = $("#workorderedit_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#workorderedit_dg").datagrid("getRowIndex", rows[i]);
			$("#workorderedit_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {
		var rows = $("#workorderedit_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#workorderedit_dg").datagrid("getRowIndex", rows[i]);
			$("#workorderedit_dg").datagrid("deleteRow", index);
		}
	}

	function save() {
		var dg = $("#workorderedit_dg");
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
			$("#workorderedit_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />");
		});
	}

	function issuejl() {
		if (getRecipecodelistbycheckjl() == ""
				|| getRecipecodelistbycheckjl() == null) {
			return;
		}
		ext.ajax.post("mix/planManagement/workOrderEdit/check", {
			recipecodelist : getRecipecodelistbycheckjl().toString()
		}, function(data) {
			if (data.data == "") {
				if (getRecipecodelistjl() == ""
						|| getRecipecodelistjl() == null) {
					return;
				}
				ext.ajax.post("mix/planManagement/workOrderEdit/downward", {
					recipecodelist : getRecipecodelistjl().toString()
				}, function(data) {
					$("#workorderedit_dgjl").datagrid("reload");
					showConfirm(data.data);
					return;
				});
			} else {
				showConfirm(data.data);
				return;
			}
		});
	}

	function issuexl() {
		if (getRecipecodelistbycheckxl() == ""
				|| getRecipecodelistbycheckxl() == null) {
			return;
		}
		ext.ajax.post("mix/planManagement/workOrderEdit/check", {
			recipecodelist : getRecipecodelistbycheckxl().toString()
		}, function(data) {
			if (data.data == "") {
				if (getRecipecodelistxl() == ""
						|| getRecipecodelistxl() == null) {
					return;
				}
				ext.ajax.post("mix/planManagement/workOrderEdit/downward", {
					recipecodelist : getRecipecodelistxl().toString()
				}, function(data) {
					$("#workorderedit_dgxl").datagrid("reload");
					showConfirm(data.data);
					return;
				});
			} else {
				showConfirm(data.data);
				return;
			}
		});
	}

	function getRecipecodelistbycheckjl() {
		var rows = $("#workorderedit_dgjl").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var recipecodelist = [];
		for (var i = 0; i < rows.length; i++) {
			var data = "";
			data = rows[i].wo_date_s + "|" + rows[i].wo_shift_s + "|"
					+ rows[i].equip_code_s;
			recipecodelist.push(data);
		}
		var temp = [];
		for (var i = 0; i < recipecodelist.length; i++) {
			if (temp.indexOf(recipecodelist[i]) == -1) {
				temp.push(recipecodelist[i]);
			}
		}
		return temp;
	}

	function getRecipecodelistjl() {
		var rows = $("#workorderedit_dgjl").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var recipecodelist = [];
		for (var i = 0; i < rows.length; i++) {
			recipecodelist.push(rows[i].wo_no_s);
		}
		return recipecodelist;
	}

	function getRecipecodelistbycheckxl() {
		var rows = $("#workorderedit_dgxl").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var recipecodelist = [];
		for (var i = 0; i < rows.length; i++) {
			var data = "";
			data = rows[i].wo_date_s + "|" + rows[i].wo_shift_s + "|"
					+ rows[i].equip_code_s;
			recipecodelist.push(data);
		}
		var temp = [];
		for (var i = 0; i < recipecodelist.length; i++) {
			if (temp.indexOf(recipecodelist[i]) == -1) {
				temp.push(recipecodelist[i]);
			}
		}
		return temp;
	}

	function getRecipecodelistxl() {
		var rows = $("#workorderedit_dgxl").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var recipecodelist = [];
		for (var i = 0; i < rows.length; i++) {
			recipecodelist.push(rows[i].wo_no_s);
		}
		return recipecodelist;
	}

	function setupjl() {
		$("#setup_dlg").dialog("open");
		var value = $('input[name="radio"]:checked').val();
		var url = '';
		if ("real_time" == value) {
			url = 'mix/planManagement/workOrderEdit/setup';
		} else if ("his_time" == value) {
			url = 'mix/planManagement/workOrderEdit/setup2';
		}
		var opts = $("#setupdlg").datagrid("options");
		opts.url = url;
		ext.easyui.grid.search("setupdlg", "Setup_search_form");
		var url = 'mix/planManagement/workOrderEdit/geterpcode';
		ext.ajax.get(url, function(data) {
			$('#geterpcode_dg').datagrid('loadData', data);
			return;
		});
	}

	function setupxl() {
		$("#setup_dlg").dialog("open");
		var value = $('input[name="radio"]:checked').val();
		var url = '';
		if ("real_time" == value) {
			url = 'mix/planManagement/workOrderEdit/setup';
		} else if ("his_time" == value) {
			url = 'mix/planManagement/workOrderEdit/setup2';
		}
		var opts = $("#setupdlg").datagrid("options");
		opts.url = url;
		ext.easyui.grid.search("setupdlg", "Setup_search_form");
		var url = 'mix/planManagement/workOrderEdit/geterpcode';
		ext.ajax.get(url, function(data) {
			$('#geterpcode_dg').datagrid('loadData', data);
			return;
		});
	}

	function closejl() {
		if (getRecipecodelistjl() == "" || getRecipecodelistjl() == null) {
			return;
		}
		$.messager.confirm("关闭确认", "确认关闭所选工单？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/workOrderEdit/end", {
					recipecodelist : getRecipecodelistjl().toString()
				}, function(data) {
					$("#workorderedit_dgjl").datagrid("reload");
					showConfirm(data.data);
					return;
				});
			}
		});
	}

	function closexl() {
		if (getRecipecodelistxl() == "" || getRecipecodelistxl() == null) {
			return;
		}
		$.messager.confirm("关闭确认", "确认关闭所选工单？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/workOrderEdit/end", {
					recipecodelist : getRecipecodelistxl().toString()
				}, function(data) {
					$("#workorderedit_dgxl").datagrid("reload");
					showConfirm(data.data);
					return;
				});
			}
		});
	}

	function upjl() {
		if (getRecipecodelistjl() == "" || getRecipecodelistjl() == null) {
			return;
		}
		$.messager.confirm("上移确认", "确认上移所选工单？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/workOrderEdit/upward", {
					recipecodelist : getRecipecodelistjl().toString()
				}, function(data) {
					$("#workorderedit_dgjl").datagrid("reload");
					showConfirm(data.data);
					return;
				});
			}
		});
	}

	function upxl() {
		if (getRecipecodelistxl() == "" || getRecipecodelistxl() == null) {
			return;
		}
		$.messager.confirm("上移确认", "确认上移所选工单？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/workOrderEdit/upward", {
					recipecodelist : getRecipecodelistxl().toString()
				}, function(data) {
					$("#workorderedit_dgxl").datagrid("reload");
					showConfirm(data.data);
					return;
				});
			}
		});
	}

	function downjl() {
		if (getRecipecodelistjl() == "" || getRecipecodelistjl() == null) {
			return;
		}
		$.messager.confirm("下移确认", "确认下移所选工单？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/workOrderEdit/down", {
					recipecodelist : getRecipecodelistjl().toString()
				}, function(data) {
					$("#workorderedit_dgjl").datagrid("reload");
					showConfirm(data.data);
					return;
				});
			}
		});
	}

	function downxl() {
		if (getRecipecodelistxl() == "" || getRecipecodelistxl() == null) {
			return;
		}
		$.messager.confirm("下移确认", "确认下移所选工单？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/workOrderEdit/down", {
					recipecodelist : getRecipecodelistxl().toString()
				}, function(data) {
					$("#workorderedit_dgxl").datagrid("reload");
					showConfirm(data.data);
					return;
				});
			}
		});
	}

	function patchjl() {
		var rows = $("#workorderedit_dgjl").datagrid("getSelections");
		if (rows.length != 1) {
			ext.tip.error("请选择一条数据");
			return;
		}
		var wo_shift_s_1 = rows[0].wo_shift_s;
		if (wo_shift_s_1 == 302001) {
			wo_shift_s_1 = "早班";
		} else if (wo_shift_s_1 == 302002) {
			wo_shift_s_1 = "中班";
		} else if (wo_shift_s_1 == 302003) {
			wo_shift_s_1 = "晚班";
		}
		var act_start_time_t_1 = rows[0].act_start_time_t;
		if (act_start_time_t_1 == "" || act_start_time_t_1 == null
				|| act_start_time_t_1 == "null") {
			act_start_time_t_1 = "";
		}
		var act_finish_time_t_1 = rows[0].act_finish_time_t;
		if (act_finish_time_t_1 == "" || act_finish_time_t_1 == null
				|| act_finish_time_t_1 == "null") {
			act_finish_time_t_1 = "";
		}
		$("#wo_no_s1").text("工单号" + rows[0].wo_no_s);
		$("#equip_name_s1").text("生产机台" + rows[0].equip_name_s);
		$("#wo_shift_s1").text("班次" + wo_shift_s_1);
		$("#spare8_s1").text("配方名称" + rows[0].recipe_code_s);
		$("#qty_plan_i1").text("计划量" + rows[0].qty_plan_i);
		$("#qty_complete_i1").text("完成量" + rows[0].qty_complete_i);
		$("#act_start_time_t1").text("开始时间" + act_start_time_t_1);
		$("#act_finish_time_t1").text("结束时间" + act_finish_time_t_1);

		var url = "mix/planManagement/workOrderEdit/getbatch?recipecode="
				+ rows[0].wo_no_s;
		ext.ajax.get(url, function(data) {
			$('#equalmaterialdg').datagrid('loadData', data);
			return;
		});
		$("#equalmaterial_dlg").dialog("open");
	}

	function patchxl() {
		var rows = $("#workorderedit_dgxl").datagrid("getSelections");
		if (rows.length != 1) {
			ext.tip.error("请选择一条数据");
			return;
		}
		var wo_shift_s_1 = rows[0].wo_shift_s;
		if (wo_shift_s_1 == 302001) {
			wo_shift_s_1 = "早班";
		} else if (wo_shift_s_1 == 302002) {
			wo_shift_s_1 = "中班";
		} else if (wo_shift_s_1 == 302003) {
			wo_shift_s_1 = "晚班";
		}
		var act_start_time_t_1 = rows[0].act_start_time_t;
		if (act_start_time_t_1 == "" || act_start_time_t_1 == null
				|| act_start_time_t_1 == "null") {
			act_start_time_t_1 = "";
		}
		var act_finish_time_t_1 = rows[0].act_finish_time_t;
		if (act_finish_time_t_1 == "" || act_finish_time_t_1 == null
				|| act_finish_time_t_1 == "null") {
			act_finish_time_t_1 = "";
		}
		$("#wo_no_s1").text("工单号" + rows[0].wo_no_s);
		$("#equip_name_s1").text("生产机台" + rows[0].equip_name_s);
		$("#wo_shift_s1").text("班次" + wo_shift_s_1);
		$("#spare8_s1").text("配方名称" + rows[0].recipe_code_s);
		$("#qty_plan_i1").text("计划量" + rows[0].qty_plan_i);
		$("#qty_complete_i1").text("完成量" + rows[0].qty_complete_i);
		$("#act_start_time_t1").text("开始时间" + act_start_time_t_1);
		$("#act_finish_time_t1").text("结束时间" + act_finish_time_t_1);

		var url = "mix/planManagement/workOrderEdit/getbatch?recipecode="
				+ rows[0].wo_no_s;
		ext.ajax.get(url, function(data) {
			$('#equalmaterialdg').datagrid('loadData', data);
			return;
		});
		$("#equalmaterial_dlg").dialog("open");
	}

	function show() {
		var value = $('input[name="radio"]:checked').val();
		if ("real_time" == value) {
			var url = 'mix/planManagement/workOrderEdit/setup';
			var opts = $("#setupdlg").datagrid("options");
			opts.url = url;
			ext.easyui.grid.search("setupdlg", "Setup_search_form");
		} else if ("his_time" == value) {
			var url = 'mix/planManagement/workOrderEdit/setup2';
			var opts = $("#setupdlg").datagrid("options");
			opts.url = url;
			ext.easyui.grid.search("setupdlg", "Setup_search_form");
		}
	}

	var filtersetup = function() {
		var value = $('input[name="radio"]:checked').val();
		var url = '';
		if ("real_time" == value) {
			url = 'mix/planManagement/workOrderEdit/setup';
		} else if ("his_time" == value) {
			url = 'mix/planManagement/workOrderEdit/setup2';
		}
		var opts = $("#setupdlg").datagrid("options");
		opts.url = url;
		ext.easyui.grid.search("setupdlg", "Setup_search_form");
	};

	var filterBySet = function() {
		var url = "mix/planManagement/workOrderEdit/geterpcode";
		ext.ajax.get(url, function(data) {
			$('#geterpcode_dg').datagrid('loadData', data);
			return;
		});
	};

	function set() {
		var editors = $("#setupdlg").datagrid("getSelections");
		var rows = $("#geterpcode_dg").datagrid("getSelections");
		if (editors.length == 0) {
			ext.tip.warn("请选择主机手");
			return;
		}
		if (rows.length == 0) {
			ext.tip.warn("请选择机台");
			return;
		}
		var ids = [];
		ids.push(rows[0].ERPCODE_S);
		ids.push(editors[0].created_by_s);
		ids.push(editors[0].created_name_s);
		ids.push("set");
		ext.ajax.post("mix/planManagement/workOrderEdit/set", {
			ids : ids.toString()
		}, function(data) {
			ext.tip.warn(data.data);
			filterBySet();
			filtersetup();
		});
	}

	var MixpipelineList = [];
	$.ajax({
		url : "mix/planManagement/dayPlan/searchMixEquip",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			MixpipelineList = data;
		}
	});

	function plmByPlinenameformatter(v, r, i) {
		for (var i = 0; i < MixpipelineList.length; i++) {
			if (v == MixpipelineList[i].p_line_name) {
				return MixpipelineList[i].p_line_name;
			}
		}
		return null;
	}

	function cancel() {
		$("#workorderedit_dg").datagrid("rejectChanges");
	}

	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

	function sendstateformatter(v, r, i) {
		if (v == '0') {
			return '未下发';
		} else if (v == '1') {
			return '已下发';
		} else if (v == '2') {
			return '下发失败';
		} else {
			return v;
		}
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

	//显示操作结果
	function showConfirm(msg) {
		$.messager.confirm({
			width : 300,
			height : 200,
			title : '提示',
			msg : msg,
			fn : function(r) {

			}
		});
	}

	//胶料导出
	function export_jl() {
		//获取grid 数据
		var node = $("#workorderedit_dgjl").datagrid("getSelections");
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
			wo_no_s : '工单号'
		}, {
			wo_status_s : '工单状态'
		}, {
			send_state_s : '下发标识'
		}, {
			wo_date_s : '生产日期'
		}, {
			wo_shift_s : '工单班次'
		}, {
			wo_seq_i : '顺序号'
		}, {
			qty_plan_i : '计划数'
		}, {
			qty_complete_i : '完成数'
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
			act_start_time_t : '工单开始时间'
		}, {
			act_finish_time_t : '工单结束时间'
		}, {
			sa_equip_code_s : '硫变机台'
		}, {
			mi_equip_code_s : '门尼机台'
		}, {
			quickcheck_recipe_code_s : '快检配方'
		}, {
			status_check_s : '工单状态'
		}, {
			qty_check_f : '工单检验量'
		}, {
			qty_check_complete_i : '检验完成量'
		}, {
			begin_check_train_num_s : '开始检验车次号'
		}, {
			end_check_train_num_s : '结束检验车次号'
		}, {
			train_num_s : '当前检验车次'
		}, {
			qty_check_good_i : '检验合格数量'
		}, {
			qty_check_bad_i : '检验不合格数量'
		}, {
			act_start_checktime_t : '检验开始时间'
		}, {
			act_finish_checktime_t : '检验结束时间'
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
		var node = $("#workorderedit_dgxl").datagrid("getSelections");
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
			wo_no_s : '工单号'
		}, {
			wo_status_s : '工单状态'
		}, {
			send_state_s : '下发标识'
		}, {
			wo_date_s : '生产日期'
		}, {
			wo_shift_s : '工单班次'
		}, {
			wo_seq_i : '顺序号'
		}, {
			qty_plan_i : '计划数'
		}, {
			qty_complete_i : '完成数'
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
			act_start_time_t : '工单开始时间'
		}, {
			act_finish_time_t : '工单结束时间'
		}, {
			sa_equip_code_s : '硫变机台'
		}, {
			mi_equip_code_s : '门尼机台'
		}, {
			quickcheck_recipe_code_s : '快检配方'
		}, {
			status_check_s : '工单状态'
		}, {
			qty_check_f : '工单检验量'
		}, {
			qty_check_complete_i : '检验完成量'
		}, {
			begin_check_train_num_s : '开始检验车次号'
		}, {
			end_check_train_num_s : '结束检验车次号'
		}, {
			train_num_s : '当前检验车次'
		}, {
			qty_check_good_i : '检验合格数量'
		}, {
			qty_check_bad_i : '检验不合格数量'
		}, {
			act_start_checktime_t : '检验开始时间'
		}, {
			act_finish_checktime_t : '检验结束时间'
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
							if (arrData[i]['wo_status_s'] == '054001') {
								wo_status_s = "未生产";
							} else if (arrData[i]['wo_status_s'] == '054002') {
								wo_status_s = "已生产";
							} else if (arrData[i]['wo_status_s'] == '054003') {
								wo_status_s = "已执行";
							} else if (arrData[i]['wo_status_s'] == '054004') {
								wo_status_s = "已暂停";
							} else if (arrData[i]['wo_status_s'] == '054005') {
								wo_status_s = "已关闭";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ wo_status_s + "</td>";
							continue;
						}
						if (k == "send_state_s") {
							var send_state_s = "";
							if (arrData[i]['send_state_s'] == '0') {
								send_state_s = "未下发";
							} else if (arrData[i]['send_state_s'] == '1') {
								send_state_s = "已下发";
							} else if (arrData[i]['send_state_s'] == '2') {
								send_state_s = "下发失败";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ send_state_s + "</td>";
							continue;
						}
						if (k == "wo_shift_s") {
							var wo_shift_s = "";
							if (arrData[i]['wo_shift_s'] == '302001') {
								wo_shift_s = "早班";
							} else if (arrData[i]['wo_shift_s'] == '302002') {
								wo_shift_s = "中班";
							} else if (arrData[i]['wo_shift_s'] == '302003') {
								wo_shift_s = "晚班";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ wo_shift_s + "</td>";
							continue;
						}
						if (k == "status_check_s") {
							var status_check_s = "";
							if (arrData[i]['status_check_s'] == '054001') {
								status_check_s = "未生产";
							} else if (arrData[i]['status_check_s'] == '054002') {
								status_check_s = "已生产";
							} else if (arrData[i]['status_check_s'] == '054003') {
								status_check_s = "已执行";
							} else if (arrData[i]['status_check_s'] == '054004') {
								status_check_s = "已暂停";
							} else if (arrData[i]['status_check_s'] == '054005') {
								status_check_s = "已关闭";
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
</script>