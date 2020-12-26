<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "mix/planManagement/dayPlan/saveChanges";

	var codejl = "QMMIXPLAN";
	var codexl = "QSMIXPLAN";

	$(document).ready(function() {
		filterjl();
		filterxl();
	});

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
	 * 获取密炼物料信息
	 */
	var materialnameList = [];
	$.ajax({
		url : "mix/planManagement/dayPlan/getMixMatInfo",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			materialnameList = data;
		}
	});

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
	 * 等同物料名称转换 
	 */
	function materialnameformatter(v, r, i) {
		if (v == null || v == "") {
			return '';
		}
		var materialcodestr1 = "";
		var materialcodestr2 = "";
		var materialcodestr3 = "";
		var materialcodearr1 = v.split("|");
		for (var i = 0; i < materialcodearr1.length; i++) {
			if (i == 0) {
				var materialcodearr01 = materialcodearr1[i].split("=");
				for (var j = 0; j < materialcodearr01.length; j++) {
					var materialcode = materialcodearr01[j];
					for (var k = 0; k < materialnameList.length; k++) {
						if (materialcode == materialnameList[k].materialcode_s) {
							if (materialnameList[k].materialspec_s != null
									&& materialnameList[k].materialspec_s != "") {
								materialcodestr1 += materialnameList[k].materialspec_s
										+ "=";
							} else {
								materialcodestr1 += materialnameList[k].materialname_s
										+ "=";
							}
							break;
						}
					}
				}
			} else if (i == 1) {
				var materialcodearr02 = materialcodearr1[i].split("=");
				for (var j = 0; j < materialcodearr02.length; j++) {
					var materialcode = materialcodearr02[j];
					for (var k = 0; k < materialnameList.length; k++) {
						if (materialcode == materialnameList[k].materialcode_s) {
							if (materialnameList[k].materialspec_s != null
									&& materialnameList[k].materialspec_s != "") {
								materialcodestr2 += materialnameList[k].materialspec_s
										+ "=";
							} else {
								materialcodestr2 += materialnameList[k].materialname_s
										+ "=";
							}
							break;
						}
					}
				}
			} else if (i == 2) {
				var materialcodearr03 = materialcodearr1[i].split("=");
				for (var j = 0; j < materialcodearr03.length; j++) {
					var materialcode = materialcodearr03[j];
					for (var k = 0; k < materialnameList.length; k++) {
						if (materialcode == materialnameList[k].materialcode_s) {
							if (materialnameList[k].materialspec_s != null
									&& materialnameList[k].materialspec_s != "") {
								materialcodestr3 += materialnameList[k].materialspec_s
										+ "=";
							} else {
								materialcodestr3 += materialnameList[k].materialname_s
										+ "=";
							}
							break;
						}
					}
				}
			}
		}
		var returnstr = "";
		if (materialcodearr1.length == 1) {
			materialcodestr1 = materialcodestr1.substr(0,
					materialcodestr1.length - 1);
			returnstr = materialcodestr1;
		} else if (materialcodearr1.length == 2) {
			materialcodestr1 = materialcodestr1.substr(0,
					materialcodestr1.length - 1);
			materialcodestr2 = materialcodestr2.substr(0,
					materialcodestr2.length - 1);
			returnstr = materialcodestr1 + '|' + materialcodestr2;
		} else if (materialcodearr1.length == 3) {
			materialcodestr1 = materialcodestr1.substr(0,
					materialcodestr1.length - 1);
			materialcodestr2 = materialcodestr2.substr(0,
					materialcodestr2.length - 1);
			materialcodestr3 = materialcodestr3.substr(0,
					materialcodestr3.length - 1);
			returnstr = materialcodestr1 + '|' + materialcodestr2 + '|'
					+ materialcodestr3;
		}
		return returnstr;
	}

	/**
	 * 查询方法
	 */
	var filterjl = function() {
		var opts = $("#plan_dgjl").datagrid("options");
		opts.url = 'mix/planManagement/dayPlan/datagridjl';
		ext.easyui.grid.search("plan_dgjl", "Plan_search_formjl");
	};

	/**
	 * 查询方法
	 */
	var filterxl = function() {
		var opts = $("#plan_dgxl").datagrid("options");
		opts.url = 'mix/planManagement/dayPlan/datagridxl';
		ext.easyui.grid.search("plan_dgxl", "Plan_search_formxl");
	};

	function addjl() {
		var dateTimeboxData = $("#plan_date_sjl").datebox("getValue");
		var equipcode = $("#equip_code_sjl").combobox("getValue");
		var equipname = $("#equip_code_sjl").combobox("getText");
		//新增的计划号时间用的是上方下拉框的时间
		if (dateTimeboxData == "") {
			ext.tip.error("请选择生产日期");
		}
		var date1 = dateTimeboxData;
		var date2 = new Calendar().format("yyyyMMdd");
		if (date1 < date2) {
			ext.tip.error("不能添加当前日期之前的计划");
			return;
		}
		getSerialByDate(codejl, dateTimeboxData, function(data) {
			var row = {
				plan_type_s : '051003',
				plan_status_s : '052001',
				plan_date_s : dateTimeboxData,
				plan_no_s : data.data,
				check_state_s : '0',
				send_state_s : '0',
				equip_code_s : equipcode,
				equip_name_s : equipname,
				status_mor_s : '052001',
				status_mid_s : '052001',
				status_nig_s : '052001',
				status_check_mor_s : '053001',
				status_check_mid_s : '053001',
				status_check_nig_s : '053001'
			};
			ext.easyui.grid.appendAndEdit("plan_dgjl", row);
		});
	}

	function addxl() {
		var dateTimeboxData = $("#plan_date_sxl").datebox("getValue");
		var equipcode = $("#equip_code_sxl").combobox("getValue");
		var equipname = $("#equip_code_sxl").combobox("getText");
		//新增的计划号时间用的是上方下拉框的时间
		if (dateTimeboxData == "") {
			ext.tip.error("请选择生产日期");
		}
		var date1 = dateTimeboxData;
		var date2 = new Calendar().format("yyyyMMdd");
		if (date1 < date2) {
			ext.tip.error("不能添加当前日期之前的计划");
			return;
		}
		getSerialByDate(codexl, dateTimeboxData, function(data) {
			var row = {
				plan_type_s : '051001',
				plan_status_s : '052001',
				plan_date_s : dateTimeboxData,
				plan_no_s : data.data,
				check_state_s : '0',
				send_state_s : '0',
				equip_code_s : equipcode,
				equip_name_s : equipname,
				status_mor_s : '052001',
				status_mid_s : '052001',
				status_nig_s : '052001',
				status_check_mor_s : '053001',
				status_check_mid_s : '053001',
				status_check_nig_s : '053001'
			};
			ext.easyui.grid.appendAndEdit("plan_dgxl", row);
		});
	}

	function editjl() {
		var rows = $("#plan_dgjl").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052001') {
				ext.tip.warn("状态不是未审核，其余状态不允许编辑");
				return;
			}
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#plan_dgjl").datagrid("getRowIndex", rows[i]);
			$("#plan_dgjl").datagrid("beginEdit", index);
		}
	}

	function editxl() {
		var rows = $("#plan_dgxl").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052001') {
				ext.tip.warn("状态不是未审核，其余状态不允许编辑");
				return;
			}
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#plan_dgxl").datagrid("getRowIndex", rows[i]);
			$("#plan_dgxl").datagrid("beginEdit", index);
		}
	}

	function removejl() {
		var rows = $("#plan_dgjl").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052001') {
				ext.tip.warn("状态不是未审核，其余状态不允许删除");
				return;
			}
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#plan_dgjl").datagrid("getRowIndex", rows[i]);
			$("#plan_dgjl").datagrid("deleteRow", index);
		}
	}

	function removexl() {
		var rows = $("#plan_dgxl").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052001') {
				ext.tip.warn("状态不是未审核，其余状态不允许删除");
				return;
			}
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#plan_dgxl").datagrid("getRowIndex", rows[i]);
			$("#plan_dgxl").datagrid("deleteRow", index);
		}
	}

	function savejl() {
		var dg = $("#plan_dgjl");
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
		if (inserted.length == 0 && updated.length == 0 && deleted.length == 0) {
			ext.tip.error("<spring:message code="tip.nosave" />");
		} else {
			var arysave = new Array();
			var aryupdate = new Array();

			var narySave = arysave.sort();
			var naryUpdate = aryupdate.sort();
			for (var i = 0; i < arysave.length; i++) {
				if (narySave[i] == narySave[i + 1]) {
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				}
			}
			for (var i = 0; i < aryupdate.length; i++) {
				if (naryUpdate[i] == naryUpdate[i + 1]) {
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				}
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
				$("#plan_dgjl").datagrid("reload");
				ext.tip.suc("<spring:message code="tip.success" />");
			});
		}
	}

	function savexl() {
		var dg = $("#plan_dgxl");
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
		if (inserted.length == 0 && updated.length == 0 && deleted.length == 0) {
			ext.tip.error("<spring:message code="tip.nosave" />");
		} else {
			var arysave = new Array();
			var aryupdate = new Array();
			var narySave = arysave.sort();
			var naryUpdate = aryupdate.sort();
			for (var i = 0; i < arysave.length; i++) {
				if (narySave[i] == narySave[i + 1]) {
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				}
			}
			for (var i = 0; i < aryupdate.length; i++) {
				if (naryUpdate[i] == naryUpdate[i + 1]) {
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				}
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
				$("#plan_dgxl").datagrid("reload");
				ext.tip.suc("<spring:message code="tip.success" />");
			});
		}
	}

	function checkstateformatter(v, r, i) {
		if (v == "0") {
			return "未审核";
		} else {
			return "已审核";
		}
	}

	//计划量联动
	function onCountChange1(nv, ov) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var zaocount = getNumberSpinnerValue1(index, "qty_mor_i");
		var zhongcount = getNumberSpinnerValue1(index, "qty_mid_i");
		var wancount = getNumberSpinnerValue1(index, "qty_nig_i");
		var dayCount = zaocount + zhongcount + wancount;

		$(getEditor1(index, "qty_plan_i").target).textbox("setValue", dayCount);
		var sip = getNumberSpinnerValue1(index, "sip_s");
		var zaocheckcount = Math.ceil(zaocount * sip / 100);
		$(getEditor1(index, "qty_check_mor_f").target).textbox("setValue",
				zaocheckcount);
		var zhongcheckcount = Math.ceil(zhongcount * sip / 100);
		$(getEditor1(index, "qty_check_mid_f").target).textbox("setValue",
				zhongcheckcount);
		var wancheckcount = Math.ceil(wancount * sip / 100);
		$(getEditor1(index, "qty_check_nig_f").target).textbox("setValue",
				wancheckcount);
		var daycheckCount = zaocheckcount + zhongcheckcount + wancheckcount;
		$(getEditor1(index, "qty_check_plan_f").target).textbox("setValue",
				daycheckCount);
	}

	//抽检量联动
	function onCheckCountChange1(nv, ov) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var zaocount = getNumberSpinnerValue1(index, "qty_check_mor_f");
		var zhongcount = getNumberSpinnerValue1(index, "qty_check_mid_f");
		var wancount = getNumberSpinnerValue1(index, "qty_check_nig_f");
		var dayCount = zaocount + zhongcount + wancount;
		$(getEditor1(index, "qty_check_plan_f").target).textbox("setValue",
				dayCount);
	}

	//计划量联动
	function onCountChange2(nv, ov) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var zaocount = getNumberSpinnerValue2(index, "qty_mor_i");
		var zhongcount = getNumberSpinnerValue2(index, "qty_mid_i");
		var wancount = getNumberSpinnerValue2(index, "qty_nig_i");
		var dayCount = zaocount + zhongcount + wancount;

		$(getEditor2(index, "qty_plan_i").target).textbox("setValue", dayCount);
		var sip = getNumberSpinnerValue2(index, "sip_s");
		var zaocheckcount = Math.ceil(zaocount * sip / 100);
		$(getEditor2(index, "qty_check_mor_f").target).textbox("setValue",
				zaocheckcount);
		var zhongcheckcount = Math.ceil(zhongcount * sip / 100);
		$(getEditor2(index, "qty_check_mid_f").target).textbox("setValue",
				zhongcheckcount);
		var wancheckcount = Math.ceil(wancount * sip / 100);
		$(getEditor2(index, "qty_check_nig_f").target).textbox("setValue",
				wancheckcount);
		var daycheckCount = zaocheckcount + zhongcheckcount + wancheckcount;
		$(getEditor2(index, "qty_check_plan_f").target).textbox("setValue",
				daycheckCount);
	}

	//抽检量联动
	function onCheckCountChange2(nv, ov) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var zaocount = getNumberSpinnerValue2(index, "qty_check_mor_f");
		var zhongcount = getNumberSpinnerValue2(index, "qty_check_mid_f");
		var wancount = getNumberSpinnerValue2(index, "qty_check_nig_f");
		var dayCount = zaocount + zhongcount + wancount;
		$(getEditor2(index, "qty_check_plan_f").target).textbox("setValue",
				dayCount);
	}

	//获取指定行、指定列的编辑器
	function getEditor1(index, field) {
		return $("#plan_dgjl").datagrid("getEditor", {
			index : index,
			field : field
		});
	}

	//获取数据框得值
	function getNumberSpinnerValue1(index, field) {
		return parseInt($(getEditor1(index, field).target).numberspinner(
				"getValue")) || 0;
	}

	//获取指定行、指定列的编辑器
	function getEditor2(index, field) {
		return $("#plan_dgxl").datagrid("getEditor", {
			index : index,
			field : field
		});
	}

	//获取数据框得值
	function getNumberSpinnerValue2(index, field) {
		return parseInt($(getEditor2(index, field).target).numberspinner(
				"getValue")) || 0;
	}

	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

	//审核
	function auditjl() {
		var rows = $("#plan_dgjl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052001') {
				ext.tip.warn("状态不是未审核，其余状态不允许审核操作");
				return;
			}
		}
		var updated = [];
		for (var i = 0; i < rows.length; i++) {
			rows[i].plan_status_s = "052002";
			updated.push(rows[i]);
		}
		ext.ajax.sendJson(saveChanges, {
			updated : updated
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#plan_dgjl").datagrid("reload");
			ext.tip.suc("审核成功");
		});
	}
	//撤销审核
	function cancelAuditjl() {
		var rows = $("#plan_dgjl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许撤销审核操作");
				return;
			}
		}
		var updated = [];
		for (var i = 0; i < rows.length; i++) {
			rows[i].plan_status_s = "052001";
			updated.push(rows[i]);
		}
		ext.ajax.sendJson(saveChanges, {
			updated : updated
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#plan_dgjl").datagrid("reload");
			ext.tip.suc("撤销审核成功");
		});
	}

	//下发
	function issuejl() {
		var rows = $("#plan_dgjl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许下发操作");
				return;
			}
			if (rows[i].send_state_s != '0') {
				ext.tip.warn("计划已下发");
				return;
			}
			ids.push(rows[i].plan_no_s);
		}
		ext.ajax.post("mix/planManagement/dayPlan/downwardbysos", {
			ids : ids.toString()
		}, function(data) {
			showConfirm(data.data);
			$("#plan_dgjl").datagrid("reload");
		});
	}

	//审核
	function auditxl() {
		var rows = $("#plan_dgxl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052001') {
				ext.tip.warn("状态不是未审核，其余状态不允许审核操作");
				return;
			}
		}
		var updated = [];
		for (var i = 0; i < rows.length; i++) {
			rows[i].plan_status_s = "052002";
			updated.push(rows[i]);
		}
		ext.ajax.sendJson(saveChanges, {
			updated : updated
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#plan_dgxl").datagrid("reload");
			ext.tip.suc("审核成功");
		});
	}
	//撤销审核
	function cancelAuditxl() {
		var rows = $("#plan_dgxl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许撤销审核操作");
				return;
			}
		}
		var updated = [];
		for (var i = 0; i < rows.length; i++) {
			rows[i].plan_status_s = "052001";
			updated.push(rows[i]);
		}
		ext.ajax.sendJson(saveChanges, {
			updated : updated
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#plan_dgxl").datagrid("reload");
			ext.tip.suc("撤销审核成功");
		});
	}

	//下发
	function issuexl() {
		var rows = $("#plan_dgxl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许下发操作");
				return;
			}
			ids.push(rows[i].plan_no_s);
		}
		ext.ajax.post("mix/planManagement/dayPlan/downwardbysos", {
			ids : ids.toString()
		}, function(data) {
			showConfirm(data.data);
			$("#plan_dgxl").datagrid("reload");
		});
	}

	//胶料上移
	function upjl() {
		var rows = $("#plan_dgjl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许上移操作");
				return;
			}
			ids.push(rows[i].plan_no_s);
		}
		$.messager.confirm("上移确认", "确认上移所选计划？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/dayPlan/upward", {
					ids : ids.toString()
				}, function(data) {
					showConfirm(data.data);
					$("#plan_dgjl").datagrid("reload");
				});
			}
		});
	}

	//小料上移
	function upxl() {
		var rows = $("#plan_dgxl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许上移操作");
				return;
			}
			ids.push(rows[i].plan_no_s);
		}
		$.messager.confirm("上移确认", "确认上移所选计划？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/dayPlan/upward", {
					ids : ids.toString()
				}, function(data) {
					showConfirm(data.data);
					$("#plan_dgxl").datagrid("reload");
				});
			}
		});
	}

	//胶料下移
	function downjl() {
		var rows = $("#plan_dgjl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许下移操作");
				return;
			}
			ids.push(rows[i].plan_no_s);
		}
		$.messager.confirm("下移确认", "确认下移所选计划？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/dayPlan/down", {
					ids : ids.toString()
				}, function(data) {
					showConfirm(data.data);
					$("#plan_dgjl").datagrid("reload");
				});
			}
		});
	}

	//小料下移
	function downxl() {
		var rows = $("#plan_dgxl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许下移操作");
				return;
			}
			ids.push(rows[i].plan_no_s);
		}
		$.messager.confirm("下移确认", "确认下移所选计划？", function(r) {
			if (r) {
				ext.ajax.post("mix/planManagement/dayPlan/down", {
					ids : ids.toString()
				}, function(data) {
					showConfirm(data.data);
					$("#plan_dgxl").datagrid("reload");
				});
			}
		});
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

	var equalindex = -1;
	//机台编码选择事件胶料
	function onequipcodeselect1(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		$(getEditor1(index, "material_code_s").target).combobox("clear");
		//接收胶料物料数据
		ext.ajax.get("mix/planManagement/dayPlan/mixJLMaterialList?equipcode="
				+ record.p_line_name, function(data) {
			if (data.length == 0) {
				ext.tip.error("未查询到该机台的密炼配方，请联系技术人员维护");
				return;
			}
			$(getEditor1(index, "material_code_s").target).combobox("loadData",
					data);
			//如果就一个数据的话，就直接填充值了
			if (data.length == 1) {
				var material_code_s = data[0].mater_code_s;
				$(getEditor1(index, "material_code_s").target).combobox(
						"select", material_code_s);
			}
		});
	}

	//机台编码选择事件小料
	function onequipcodeselect2(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		$(getEditor2(index, "material_code_s").target).combobox("clear");
		var equip_code_s = record.p_line_name;
		//var materialcode = equip_code_s.substring(1, 3);
		var mater_type_s = "ALL";
		var equipcode = equip_code_s.substring(0, 1);
		/* if (materialcode == "02") {
			mater_type_s = "LLOrdinaryBagBatch";
		} else if (materialcode == "34") {
			mater_type_s = "LLSulfurBagBatch";
		} else if (materialcode == "10") {
			mater_type_s = "ALL";
		} */
		//接收小料物料数据
		ext.ajax.get("mix/planManagement/dayPlan/mixXLMaterialList?equipcode="
				+ equipcode + "&mater_type_s=" + mater_type_s, function(data) {
			if (data.length == 0) {
				ext.tip.error("未查询到该机台的密炼配方，请联系技术人员维护");
				return;
			}
			$(getEditor2(index, "material_code_s").target).combobox("loadData",
					data);
			//如果就一个数据的话，就直接填充值了
			if (data.length == 1) {
				var material_code_s = data[0].mater_code_s;
				$(getEditor2(index, "material_code_s").target).combobox(
						"select", material_code_s);
			}
		});
	}

	//物料选择触发事件胶料
	function materialcodechangedjl(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		for (var i = 0; i < materialnameList.length; i++) {
			if (record.mater_code_s == materialnameList[i].materialcode_s) {
				$(getEditor1(index, "material_name_s").target).textbox(
						"setValue", materialnameList[i].materialname_s);//物料描述
				break;
			}
		}
		var equipcode = $(getEditor1(index, "equip_code_s").target).combobox(
				"getValue");
		if (equipcode == "") {
			ext.tip.error("请先选择机台");
			return;
		}
		;
		var plandate = $(getEditor1(index, "plan_date_s").target).textbox(
				"getValue");
		if (plandate == "") {
			ext.tip.error("请先选择时间");
			return;
		}
		;
		//带出生产顺序
		ext.ajax.get(
				"mix/planManagement/dayPlan/getMixDayPlanMaxSeq?equipcode="
						+ equipcode + "&plandate=" + plandate, function(data) {
					$(getEditor1(index, "spare8_s").target).textbox("setValue",
							data);
				});
		ext.ajax.get("mix/planManagement/dayPlan/getAddInfoList?equipcode="
				+ equipcode + "&materialcode=" + record.mater_code_s
				+ "&palntype=" + "051003", function(data) {
			if (data.code != OK) {
				showConfirm(data.message);
				return;
			}
			$(getEditor1(index, "mixrecipe_recipe_code_s").target).combobox(
					"loadData", data.data[0]);
			/* $(getEditor1(index, "quickcheck_recipe_code_s").target).combobox("loadData",data.data[1]); */
			if (data.data[2] != "0.0") {
				$(getEditor1(index, "quickcheck_recipe_code_s").target)
						.combobox({
							required : true
						});
				$(getEditor1(index, "sip_s").target).textbox({
					required : true
				});
				$(getEditor1(index, "sip_s").target).textbox("setValue",
						data.data[2]);
			}
			var v1 = $(getEditor1(index, "mixrecipe_recipe_code_s").target)
					.combobox('getData');
			//如果就一个数据的话，就直接填充值了
			if (v1.length == 1) {
				var recipe_code_s = v1[0].recipe_code_s;//配方名称
				$(getEditor1(index, "mixrecipe_recipe_code_s").target)
						.combobox("select", recipe_code_s);
			}
			/* var v2 = $(getEditor1(index, "quickcheck_recipe_code_s").target).combobox('getData');
			//如果就一个数据的话，就直接填充值了
			if(v2.length == 1){
			    var recipe_code_s = v2[0].recipe_code_s;//配方名称
				$(getEditor1(index, "quickcheck_recipe_code_s").target).combobox("select",recipe_code_s);
			} */
		});
	}

	//物料选择触发事件小料
	function materialcodechangedxl(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		for (var i = 0; i < materialnameList.length; i++) {
			if (record.mater_code_s == materialnameList[i].materialcode_s) {
				$(getEditor2(index, "material_name_s").target).textbox(
						"setValue", materialnameList[i].materialname_s);//物料描述
				break;
			}
		}
		var equipcode = $(getEditor2(index, "equip_code_s").target).combobox(
				"getValue");
		if (equipcode == "") {
			ext.tip.error("请先选择机台");
			return;
		}
		;
		var plandate = $(getEditor2(index, "plan_date_s").target).textbox(
				"getValue");
		if (plandate == "") {
			ext.tip.error("请先选择时间");
			return;
		}
		;
		//带出生产顺序
		ext.ajax.get(
				"mix/planManagement/dayPlan/getMixDayPlanMaxSeq?equipcode="
						+ equipcode + "&plandate=" + plandate, function(data) {
					$(getEditor2(index, "spare8_s").target).textbox("setValue",
							data);
				});
		ext.ajax.get("mix/planManagement/dayPlan/getAddInfoList?equipcode="
				+ equipcode + "&materialcode=" + record.mater_code_s
				+ "&palntype=" + "051003", function(data) {
			if (data.code != OK) {
				showConfirm(data.message);
				return;
			}
			$(getEditor2(index, "mixrecipe_recipe_code_s").target).combobox(
					"loadData", data.data[0]);
			//$(getEditor2(index, "quickcheck_recipe_code_s").target).combobox("loadData",data.data[1]);
			if (data.data[2] != "0.0") {
				$(getEditor2(index, "quickcheck_recipe_code_s").target)
						.combobox({
							required : true
						});
				$(getEditor2(index, "sip_s").target).textbox({
					required : true
				});
				$(getEditor2(index, "sip_s").target).textbox("setValue",
						data.data[2]);
			}
			var v1 = $(getEditor2(index, "mixrecipe_recipe_code_s").target)
					.combobox('getData');
			//如果就一个数据的话，就直接填充值了
			if (v1.length == 1) {
				var recipe_code_s = v1[0].recipe_code_s;//配方名称
				$(getEditor2(index, "mixrecipe_recipe_code_s").target)
						.combobox("select", recipe_code_s);
			}
			/* var v2 = $(getEditor2(index, "quickcheck_recipe_code_s").target).combobox('getData');
			//如果就一个数据的话，就直接填充值了
			if(v2.length == 1){
			    var recipe_code_s = v2[0].recipe_code_s;//配方名称
				$(getEditor2(index, "quickcheck_recipe_code_s").target).combobox("select",recipe_code_s);  
			} */
		});
	}

	//配方编号选择事件
	function onRecipeSelect1(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		equalindex = index;
		var bcversion = record.b_version_s;
		var recipecode = record.recipe_code_s;
		$(getEditor1(index, "recipe_bom_version_s").target).textbox("setValue",
				bcversion);//配方物料版本
		var equipcode = $(getEditor1(index, "equip_code_s").target).textbox(
				"getValue");
		if (equipcode == "") {
			ext.tip.error("请先选择机台");
			return;
		}
		;
		var plandate = $(getEditor1(index, "plan_date_s").target).textbox(
				"getValue");
		if (plandate == "") {
			ext.tip.error("请先选择时间");
			return;
		}
		;
		var materialcode = $(getEditor1(index, "material_code_s").target)
				.textbox("getValue");
		if (materialcode == "") {
			ext.tip.error("请先选择物料编码");
			return;
		}
		;
		//同机台，同规格,同配方不能再做计划
		$
				.ajax({
					url : "mix/planManagement/dayPlan/validEquipcodeExitInPlan?plandate="
							+ plandate
							+ "&equipment="
							+ equipcode
							+ "&materialcode="
							+ materialcode
							+ "&recipecode="
							+ recipecode,
					type : "get",
					dataType : "json",
					async : false,
					success : function(data) {
						if (data.data != true) {
							ext.tip.error("同一机台，同物料，同配方，只允许做一个计划");
						} else {
							ext.ajax
									.get(
											"mix/planManagement/dayPlan/getAddInfoListByRecipecode?recipecode="
													+ recipecode
													+ "&productdate="
													+ plandate,
											function(data) {
												if (data.code != OK) {
													showConfirm(data.message);
													return;
												} else {
													$(
															getEditor1(index,
																	"quickcheck_recipe_code_s").target)
															.combobox(
																	"loadData",
																	data.data[0]);
													var v = $(
															getEditor1(index,
																	"quickcheck_recipe_code_s").target)
															.combobox('getData');
													//如果就一个数据的话，就直接填充值了
													if (v.length == 1) {
														var recipe_code_s = v[0].recipe_code_s;//检查配方名称
														$(
																getEditor1(
																		index,
																		"quickcheck_recipe_code_s").target)
																.combobox(
																		"select",
																		recipe_code_s);
													}
													//等同物料处理
													var equipcode = $(
															getEditor1(index,
																	"equip_code_s").target)
															.textbox("getValue");
													var materialcode = $(
															getEditor1(index,
																	"material_code_s").target)
															.textbox("getValue");
													var url = "mix/planManagement/dayPlan/getEqualMaterialcode?recipecode="
															+ recipecode
															+ "&equipcode="
															+ equipcode
															+ "&materialcode="
															+ materialcode;
													ext.ajax
															.get(
																	url,
																	function(
																			data) {
																		if (data.length > 0) {
																			$(
																					"#equalmaterial_dlgjl")
																					.dialog(
																							"open");
																			$(
																					'#equalmaterialdgjl')
																					.datagrid(
																							'loadData',
																							data);
																			$(
																					getEditor1(
																							index,
																							"spare9_s").target)
																					.combobox(
																							"select",
																							"1");
																		} else {
																			$(
																					getEditor1(
																							index,
																							"spare9_s").target)
																					.combobox(
																							"select",
																							"0");
																		}
																	});
												}
											});
						}
					}
				});
	}

	//配方编号选择事件
	function onRecipeSelect2(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		equalindex = index;
		var bcversion = record.b_version_s;
		var recipecode = record.recipe_code_s;
		$(getEditor2(index, "recipe_bom_version_s").target).textbox("setValue",
				bcversion);//配方物料版本
		var equipcode = $(getEditor2(index, "equip_code_s").target).textbox(
				"getValue");
		if (equipcode == "") {
			ext.tip.error("请先选择机台");
			return;
		}
		;
		var plandate = $(getEditor2(index, "plan_date_s").target).textbox(
				"getValue");
		if (plandate == "") {
			ext.tip.error("请先选择时间");
			return;
		}
		;
		var materialcode = $(getEditor2(index, "material_code_s").target)
				.textbox("getValue");
		if (materialcode == "") {
			ext.tip.error("请先选择物料编码");
			return;
		}
		;
		//同机台，同规格,同配方不能再做计划
		$
				.ajax({
					url : "mix/planManagement/dayPlan/validEquipcodeExitInPlan?plandate="
							+ plandate
							+ "&equipment="
							+ equipcode
							+ "&materialcode="
							+ materialcode
							+ "&recipecode="
							+ recipecode,
					type : "get",
					dataType : "json",
					async : false,
					success : function(data) {
						if (data.data != true) {
							ext.tip.error("同一机台，同物料，同配方，只允许做一个计划");
							return;
						} else {
							ext.ajax
									.get(
											"mix/planManagement/dayPlan/getAddInfoListByRecipecode?recipecode="
													+ recipecode
													+ "&productdate="
													+ plandate,
											function(data) {
												if (data.code != OK) {
													showConfirm(data.message);
													return;
												} else {
													$(
															getEditor2(index,
																	"quickcheck_recipe_code_s").target)
															.combobox(
																	"loadData",
																	data.data[1]);
													var v = $(
															getEditor2(index,
																	"quickcheck_recipe_code_s").target)
															.combobox('getData');
													//如果就一个数据的话，就直接填充值了
													if (v.length == 1) {
														var recipe_code_s = v[0].recipe_code_s;//检查配方名称
														$(
																getEditor2(
																		index,
																		"quickcheck_recipe_code_s").target)
																.combobox(
																		"select",
																		recipe_code_s);
													}
													//等同物料处理
													var equipcode = $(
															getEditor2(index,
																	"equip_code_s").target)
															.textbox("getValue");
													var materialcode = $(
															getEditor2(index,
																	"material_code_s").target)
															.textbox("getValue");
													var url = "mix/planManagement/dayPlan/getEqualMaterialcode?recipecode="
															+ recipecode
															+ "&equipcode="
															+ equipcode
															+ "&materialcode="
															+ materialcode;
													ext.ajax
															.get(
																	url,
																	function(
																			data) {
																		if (data.length > 0) {
																			$(
																					"#equalmaterial_dlgxl")
																					.dialog(
																							"open");
																			$(
																					'#equalmaterialdgxl')
																					.datagrid(
																							'loadData',
																							data);
																			$(
																					getEditor2(
																							index,
																							"spare9_s").target)
																					.combobox(
																							"select",
																							"1");
																		} else {
																			$(
																					getEditor2(
																							index,
																							"spare9_s").target)
																					.combobox(
																							"select",
																							"0");
																		}
																	});
												}
											});
						}
					}
				});
	}

	//生成领料计划
	function generatematapplyplanjl() {
		var rows = $("#plan_dgjl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许生成领料计划");
				return;
			}
			ids.push(rows[i].plan_no_s);
		}
		ext.ajax.post("mix/planManagement/dayPlan/producerecivelist", {
			ids : ids.toString()
		}, function(data) {
			showConfirm(data.data);
			$("#plan_dgjl").datagrid("reload");
		});
	}

	//生成领料计划
	function generatematapplyplanxl() {
		var rows = $("#plan_dgxl").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var ids = [];
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].plan_status_s != '052002') {
				ext.tip.warn("状态不是已审核，其余状态不允许生成领料计划");
				return;
			}
			ids.push(rows[i].plan_no_s);
		}
		ext.ajax.post("mix/planManagement/dayPlan/producerecivelist", {
			ids : ids.toString()
		}, function(data) {
			showConfirm(data.data);
			$("#plan_dgxl").datagrid("reload");
		});
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

	//等同物料选择事件jl
	function dosaveEqalMaterialjl() {
		var rows = $("#equalmaterialdgjl").datagrid('getChecked');
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var row = $("#equalmaterialdgjl").datagrid('getRows');
		var j = 0;
		var id = "";
		for (var i = 0; i < row.length; i++) {
			if (id != row[i]['GROUPNAME_S']) {
				id = row[i]['GROUPNAME_S'];
				j++;
			}
		}
		if (rows.length < j) {
			ext.tip.error("请保证每个物料组都至少有一条数据!");
			return;
		}
		var rmcount = [];
		for (var i = 0; i < row.length; i++) {
			if (row[i]['RMCOUNT'] != "undefined" && row[i]['RMCOUNT'] != null
					&& row[i]['RMCOUNT'] != "") {
				rmcount.push(row[i].GROUPNAME_S);
			}
		}
		var temp = [];
		for (var i = 0; i < rmcount.length; i++) {
			if (temp.indexOf(rmcount[i]) == -1) {
				temp.push(rmcount[i]);
			}
		}
		var result = "";
		for (var i = 0; i < rows.length; i++) {
			if (rows[i]['GROUPNAME_S'] == temp[i]) {
				if (rows[i]['RMCOUNT'] == "undefined"
						|| rows[i]['RMCOUNT'] == null
						|| rows[i]['RMCOUNT'] == ""
						|| rows[i]['RMCOUNT'] == "0") {
					ext.tip.error("请选择有库存量的等同数据");
					return;
				}
			}
			if (rows[i]['FLAG'] == "称量") {
				result = result + rows[i].CHILD_MATERCODE_S + "|";
			} else {
				result = result + rows[i].CHILD_MATERCODE_S + "="
						+ rows[i].MATERIALCODE_S + "|";
			}
		}
		result = result.substring(0, result.length - 1);//去掉最后的竖线
		$(getEditor1(equalindex, "spare10_s").target).textbox("setValue",
				result);
		$("#equalmaterial_dlgjl").dialog("close");
	}

	//等同物料选择事件xl
	function dosaveEqalMaterialxl() {
		var rows = $("#equalmaterialdgxl").datagrid('getChecked');
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var row = $("#equalmaterialdgxl").datagrid('getRows');
		var j = 0;
		var id = "";
		for (var i = 0; i < row.length; i++) {
			if (id != row[i]['GROUPNAME_S']) {
				id = row[i]['GROUPNAME_S'];
				j++;
			}
		}
		if (rows.length < j) {
			ext.tip.error("请保证每个物料组都至少有一条数据!");
			return;
		}
		var rmcount = [];
		for (var i = 0; i < row.length; i++) {
			if (row[i]['RMCOUNT'] != "undefined" && row[i]['RMCOUNT'] != null
					&& row[i]['RMCOUNT'] != "") {
				rmcount.push(row[i].GROUPNAME_S);
			}
		}
		var temp = [];
		for (var i = 0; i < rmcount.length; i++) {
			if (temp.indexOf(rmcount[i]) == -1) {
				temp.push(rmcount[i]);
			}
		}
		var result = "";
		for (var i = 0; i < rows.length; i++) {
			/* if (rows[i]['GROUPNAME_S'] == temp[i]) {
				if (rows[i]['RMCOUNT'] == "undefined" || rows[i]['RMCOUNT'] == null || rows[i]['RMCOUNT'] == "" || rows[i]['RMCOUNT'] == "0") {
					ext.tip.error("请选择有库存量的等同数据");
					return;
				}
			} */
			if (rows[i]['FLAG'] == "称量") {
				result = result + rows[i].CHILD_MATERCODE_S + "|";
			} else {
				result = result + rows[i].CHILD_MATERCODE_S + "="
						+ rows[i].MATERIALCODE_S + "|";
			}
		}
		result = result.substring(0, result.length - 1);//去掉最后的竖线
		$(getEditor2(equalindex, "spare10_s").target).textbox("setValue",
				result);
		$("#equalmaterial_dlgxl").dialog("close");
	}

	//合并单元格
	function onLoadSuccessjl(data) {
		$("#equalmaterialdgjl").datagrid("autoMergeCells", [ 'GROUPNAME_S' ]);
	}
	//合并单元格
	function onLoadSuccessxl(data) {
		$("#equalmaterialdgxl").datagrid("autoMergeCells", [ 'GROUPNAME_S' ]);
	}

	function selectrowjl() {
		var row = $("#equalmaterialdgjl").datagrid('getSelected');
		var GROUPNAME_S = row.GROUPNAME_S;
		var rows = $("#equalmaterialdgjl").datagrid('getRows');
		for (var i = 0; i < rows.length; i++) {
			var id = rows[i]['GROUPNAME_S'];//获取指定列
			indexs = i;
			if (id == GROUPNAME_S) {
				$("#equalmaterialdgjl").datagrid("unselectRow", indexs); //取消复选框
			}
		}
		return;
	}

	function selectrowxl() {
		var row = $("#equalmaterialdgxl").datagrid('getSelected');
		var GROUPNAME_S = row.GROUPNAME_S;
		var rows = $("#equalmaterialdgxl").datagrid('getRows');
		for (var i = 0; i < rows.length; i++) {
			var id = rows[i]['GROUPNAME_S'];//获取指定列
			indexs = i;
			if (id == GROUPNAME_S) {
				$("#equalmaterialdgxl").datagrid("unselectRow", indexs); //取消复选框
			}
		}
		return;
	}

	function sendstateFormatter(v, r, i) {
		if (v == "0") {
			return "未下发";
		} else if (v == "1") {
			return "已下发";
		} else if (v == "2") {
			return "下发失败";
		}
		return v;
	}

	function cancelEqalMaterialjl() {
		$("#equalmaterial_dlgjl").dialog("close");
	}

	function cancelEqalMaterialxl() {
		$("#equalmaterial_dlgxl").dialog("close");
	}

	function isspare9Formatter(v, r, i) {
		if (r.spare10_s == "" || r.spare10_s == null) {
			return "否";
		}
		if (v == "0") {
			return "否";
		}
		if (v == "1") {
			return "是";
		}
		return v;
	}

	function copyjl() {
		$("#mixplanjl-copy").dialog("open");
	}

	function copyxl() {
		$("#mixplanxl-copy").dialog("open");
	}

	function canceljl() {
		$("#plan_dgjl").datagrid("rejectChanges");
	}

	function cancelxl() {
		$("#plan_dgxl").datagrid("rejectChanges");
	}

	//导出
	function export_jl() {
		//获取grid 数据
		var node = $("#plan_dgjl").datagrid("getSelections");
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
			plan_date_s : '生产日期'
		}, {
			plan_no_s : '日计划号'
		}, {
			plan_status_s : '计划状态'
		}, {
			send_state_s : '下发标识'
		}, {
			equip_code_s : '机台条码'
		}, {
			spare8_s : '顺序号'
		}, {
			sa_equip_code_s : '硫变机台'
		}, {
			mi_equip_code_s : '门尼机台'
		}, {
			material_code_s : '物料编码'
		}, {
			material_name_s : '物料名称'
		}, {
			mixrecipe_recipe_code_s : '生产配方'
		}, {
			recipe_bom_version_s : '配方版本'
		}, {
			spare9_s : '是否有等同'
		}, {
			spare10_s : '等同物料编码'
		}, {
			quickcheck_recipe_code_s : '快检配方'
		}, {
			sip_s : '快检百分比'
		}, {
			qty_plan_i : '日计划量'
		}, {
			qty_check_plan_f : '日检查量'
		}, {
			qty_mor_i : '早计划量'
		}, {
			qty_check_mor_f : '早检查量'
		}, {
			qty_mid_i : '中计划量'
		}, {
			qty_check_mid_f : '中检查量'
		}, {
			qty_nig_i : '晚计划量'
		}, {
			qty_check_nig_f : '晚检查量'
		}, {
			status_mor_s : '早班状态'
		}, {
			status_check_mor_s : '早班检查状态'
		}, {
			qty_check_good_mor_i : '早班合格量'
		}, {
			qty_check_bad_mor_i : '早班不合格量'
		}, {
			act_start_time_mor_t : '早班生产开始时间'
		}, {
			act_finish_time_mor_t : '早班生产结束时间'
		}, {
			act_start_checktime_mor_t : '早班检查开始时间'
		}, {
			act_finish_checktime_mor_t : '早班检查结束时间'
		}, {
			status_mid_s : '中班状态'
		}, {
			status_check_mid_s : '中班检查状态'
		}, {
			qty_check_good_mid_i : '中班合格量'
		}, {
			qty_check_bad_mid_i : '中班不合格量'
		}, {
			act_start_time_mid_t : '中班生产开始时间'
		}, {
			act_finish_time_mid_t : '中班生产结束时间'
		}, {
			act_start_checktime_mid_t : '中班检查开始时间'
		}, {
			act_finish_checktime_mid_t : '中班检查结束时间'
		}, {
			status_nig_s : '晚班状态'
		}, {
			status_check_nig_s : '晚班检查状态'
		}, {
			qty_check_good_nig_i : '晚班合格量'
		}, {
			qty_check_bad_nig_i : '晚班不合格量'
		}, {
			act_start_time_nig_t : '晚班生产开始时间'
		}, {
			act_finish_time_nig_t : '晚班生产结束时间'
		}, {
			act_start_checktime_nig_t : '晚班检查开始时间'
		}, {
			act_finish_checktime_nig_t : '晚班检查结束时间'
		}, {
			datasource_s : '数据来源'
		}, {
			check_by_s : '审核人'
		}, {
			check_time_t : '审核时间'
		}, {
			send_by_s : '下发人'
		}, {
			send_time_t : '下发时间'
		}, {
			changed_by_s : '修改人'
		}, {
			changed_time_t : '修改时间'
		}, {
			created_by_s : '创建人'
		}, {
			created_time_t : '创建时间'
		} ];
		toExcel("密炼胶料计划导出", data, title);
	}

	//导出
	function export_xl() {
		//获取grid 数据
		var node = $("#plan_dgxl").datagrid("getSelections");
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
			plan_date_s : '生产日期'
		}, {
			plan_no_s : '日计划号'
		}, {
			plan_status_s : '计划状态'
		}, {
			send_state_s : '下发标识'
		}, {
			equip_code_s : '机台条码'
		}, {
			spare8_s : '顺序号'
		}, {
			sa_equip_code_s : '硫变机台'
		}, {
			mi_equip_code_s : '门尼机台'
		}, {
			material_code_s : '物料编码'
		}, {
			material_name_s : '物料名称'
		}, {
			mixrecipe_recipe_code_s : '生产配方'
		}, {
			recipe_bom_version_s : '配方版本'
		}, {
			spare9_s : '是否有等同'
		}, {
			spare10_s : '等同物料编码'
		}, {
			quickcheck_recipe_code_s : '快检配方'
		}, {
			sip_s : '快检百分比'
		}, {
			qty_plan_i : '日计划量'
		}, {
			qty_check_plan_f : '日检查量'
		}, {
			qty_mor_i : '早计划量'
		}, {
			qty_check_mor_f : '早检查量'
		}, {
			qty_mid_i : '中计划量'
		}, {
			qty_check_mid_f : '中检查量'
		}, {
			qty_nig_i : '晚计划量'
		}, {
			qty_check_nig_f : '晚检查量'
		}, {
			status_mor_s : '早班状态'
		}, {
			status_check_mor_s : '早班检查状态'
		}, {
			qty_check_good_mor_i : '早班合格量'
		}, {
			qty_check_bad_mor_i : '早班不合格量'
		}, {
			act_start_time_mor_t : '早班生产开始时间'
		}, {
			act_finish_time_mor_t : '早班生产结束时间'
		}, {
			act_start_checktime_mor_t : '早班检查开始时间'
		}, {
			act_finish_checktime_mor_t : '早班检查结束时间'
		}, {
			status_mid_s : '中班状态'
		}, {
			status_check_mid_s : '中班检查状态'
		}, {
			qty_check_good_mid_i : '中班合格量'
		}, {
			qty_check_bad_mid_i : '中班不合格量'
		}, {
			act_start_time_mid_t : '中班生产开始时间'
		}, {
			act_finish_time_mid_t : '中班生产结束时间'
		}, {
			act_start_checktime_mid_t : '中班检查开始时间'
		}, {
			act_finish_checktime_mid_t : '中班检查结束时间'
		}, {
			status_nig_s : '晚班状态'
		}, {
			status_check_nig_s : '晚班检查状态'
		}, {
			qty_check_good_nig_i : '晚班合格量'
		}, {
			qty_check_bad_nig_i : '晚班不合格量'
		}, {
			act_start_time_nig_t : '晚班生产开始时间'
		}, {
			act_finish_time_nig_t : '晚班生产结束时间'
		}, {
			act_start_checktime_nig_t : '晚班检查开始时间'
		}, {
			act_finish_checktime_nig_t : '晚班检查结束时间'
		}, {
			datasource_s : '数据来源'
		}, {
			check_by_s : '审核人'
		}, {
			check_time_t : '审核时间'
		}, {
			send_by_s : '下发人'
		}, {
			send_time_t : '下发时间'
		}, {
			changed_by_s : '修改人'
		}, {
			changed_time_t : '修改时间'
		}, {
			created_by_s : '创建人'
		}, {
			created_time_t : '创建时间'
		} ];
		toExcel("密炼小料计划导出", data, title);
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
						if (k == "plan_status_s") {
							var plan_status_s = "";
							if (arrData[i]['plan_status_s'] == '052001') {
								plan_status_s = "未审核";
							} else if (arrData[i]['plan_status_s'] == '052002') {
								plan_status_s = "已审核";
							} else if (arrData[i]['plan_status_s'] == '052003') {
								plan_status_s = "未下发";
							} else if (arrData[i]['plan_status_s'] == '052004') {
								plan_status_s = "已下发";
							} else if (arrData[i]['plan_status_s'] == '052005') {
								plan_status_s = "已执行";
							} else if (arrData[i]['plan_status_s'] == '052006') {
								plan_status_s = "已关闭";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ plan_status_s + "</td>";
							continue;
						}
						if (k == "send_state_s") {
							var send_state_s = "";
							if (arrData[i]['send_state_s'] == '0') {
								send_state_s = "未审核";
							} else if (arrData[i]['send_state_s'] == '1') {
								send_state_s = "已审核";
							} else if (arrData[i]['send_state_s'] == '2') {
								send_state_s = "未下发";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ send_state_s + "</td>";
							continue;
						}
						if (k == "status_mor_s") {
							var status_mor_s = "";
							if (arrData[i]['status_mor_s'] == '052001') {
								status_mor_s = "未审核";
							} else if (arrData[i]['status_mor_s'] == '052002') {
								status_mor_s = "已审核";
							} else if (arrData[i]['status_mor_s'] == '052003') {
								status_mor_s = "未下发";
							} else if (arrData[i]['status_mor_s'] == '052004') {
								status_mor_s = "已下发";
							} else if (arrData[i]['status_mor_s'] == '052005') {
								status_mor_s = "已执行";
							} else if (arrData[i]['status_mor_s'] == '052006') {
								status_mor_s = "已关闭";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ status_mor_s + "</td>";
							continue;
						}
						if (k == "status_mid_s") {
							var status_mid_s = "";
							if (arrData[i]['status_mid_s'] == '052001') {
								status_mid_s = "未审核";
							} else if (arrData[i]['status_mid_s'] == '052002') {
								status_mid_s = "已审核";
							} else if (arrData[i]['status_mid_s'] == '052003') {
								status_mid_s = "未下发";
							} else if (arrData[i]['status_mid_s'] == '052004') {
								status_mid_s = "已下发";
							} else if (arrData[i]['status_mid_s'] == '052005') {
								status_mid_s = "已执行";
							} else if (arrData[i]['status_mid_s'] == '052006') {
								status_mid_s = "已关闭";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ status_mid_s + "</td>";
							continue;
						}
						if (k == "status_nig_s") {
							var status_nig_s = "";
							if (arrData[i]['status_nig_s'] == '052001') {
								status_nig_s = "未审核";
							} else if (arrData[i]['status_nig_s'] == '052002') {
								status_nig_s = "已审核";
							} else if (arrData[i]['status_nig_s'] == '052003') {
								status_nig_s = "未下发";
							} else if (arrData[i]['status_nig_s'] == '052004') {
								status_nig_s = "已下发";
							} else if (arrData[i]['status_nig_s'] == '052005') {
								status_nig_s = "已执行";
							} else if (arrData[i]['status_nig_s'] == '052006') {
								status_nig_s = "已关闭";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ status_nig_s + "</td>";
							continue;
						}
						if (k == "status_check_mor_s") {
							var status_check_mor_s = "";
							if (arrData[i]['status_check_mor_s'] == '053001') {
								status_check_mor_s = "未审核";
							} else if (arrData[i]['status_check_mor_s'] == '053002') {
								status_check_mor_s = "已审核";
							} else if (arrData[i]['status_check_mor_s'] == '053003') {
								status_check_mor_s = "未下发";
							} else if (arrData[i]['status_check_mor_s'] == '053004') {
								status_check_mor_s = "已下发";
							} else if (arrData[i]['status_check_mor_s'] == '053005') {
								status_check_mor_s = "已执行";
							} else if (arrData[i]['status_check_mor_s'] == '053006') {
								status_check_mor_s = "已关闭";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ status_check_mor_s + "</td>";
							continue;
						}
						if (k == "status_check_mid_s") {
							var status_check_mid_s = "";
							if (arrData[i]['status_check_mid_s'] == '053001') {
								status_check_mid_s = "未审核";
							} else if (arrData[i]['status_check_mid_s'] == '053002') {
								status_check_mid_s = "已审核";
							} else if (arrData[i]['status_check_mid_s'] == '053003') {
								status_check_mid_s = "未下发";
							} else if (arrData[i]['status_check_mid_s'] == '053004') {
								status_check_mid_s = "已下发";
							} else if (arrData[i]['status_check_mid_s'] == '053005') {
								status_check_mid_s = "已执行";
							} else if (arrData[i]['status_check_mid_s'] == '053006') {
								status_check_mid_s = "已关闭";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ status_check_mid_s + "</td>";
							continue;
						}
						if (k == "status_check_nig_s") {
							var status_check_nig_s = "";
							if (arrData[i]['status_check_nig_s'] == '053001') {
								status_check_nig_s = "未审核";
							} else if (arrData[i]['status_check_nig_s'] == '053002') {
								status_check_nig_s = "已审核";
							} else if (arrData[i]['status_check_nig_s'] == '053003') {
								status_check_nig_s = "未下发";
							} else if (arrData[i]['status_check_nig_s'] == '053004') {
								status_check_nig_s = "已下发";
							} else if (arrData[i]['status_check_nig_s'] == '053005') {
								status_check_nig_s = "已执行";
							} else if (arrData[i]['status_check_nig_s'] == '053006') {
								status_check_nig_s = "已关闭";
							}
							rowData += "<td style='vnd.ms-excel.numberformat:@'>"
									+ status_check_nig_s + "</td>";
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

	function equipCodeFormatterJl(v, r, i) {
		for (var i = 0; i < jlequipList.length; i++) {
			if (v == jlequipList[i].p_line_name) {
				return jlequipList[i].description;
			}
		}
	}

	function equipCodeFormatterXl(v, r, i) {
		for (var i = 0; i < xlequipList.length; i++) {
			if (v == xlequipList[i].p_line_name) {
				return xlequipList[i].description;
			}
		}
	}
</script>