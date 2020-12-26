<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
		// 	$("#begin_created_time").datetimebox({
		// 		value : '3/4/2010 00:00:00',
		// 		required : true,
		// 		showSeconds : true
		// 	});
		// 	$("#end_created_time").datetimebox({
		// 		value : '3/4/2010 23:59:59',
		// 		required : true,
		// 		showSeconds : true
		// 	});

		filter();
	});
	
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
	/**
	 * 接收combtree数据
	 */
	var DICT_253 = [];

	$.ajax({
		url : "dict/code/253",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			if (data != null) {
				for (var i = 0; i < data.length; i++) {
					if (data[i]["code"] == "253006"
							|| data[i]["code"] == "253012"
							|| data[i]["code"] == "253013")
						DICT_253.push(data[i]);
				}
			}
		}
	});
	/**
	 * 接收病象数据
	 */
	var ReasInfo = [];

	$.ajax({
		url : "finalcheck/baseData/reas/comboxReasCodeDesc",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			ReasInfo = data;
		}
	});
	//缺陷描述显示
	function reasformatter(v, r, i) {
		for (var i = 0; i < ReasInfo.length; i++) {
			if (ReasInfo[i].REASCODE == v) {
				return ReasInfo[i].REASDESC;
			}
		}

		return v;
	}

	$(function() {
		// 外观病象下拉框
		$('#wgreascode_s').combobox({
			url : 'finalcheck/baseData/reas/comboxReasCodeDescWg',
			valueField : 'WGREASCODE',
			textField : 'WGREASDESC',
			panelHeight : 300,
			editable : 'true',
		});
		
		// X光病象下拉框
		$('#xrayreascode_s').combobox({
			url : 'finalcheck/baseData/reas/comboxReasCodeDescXray',
			valueField : 'XRAYREASCODE',
			textField : 'XRAYREASDESC',
			panelHeight : 300,
			editable : 'true',
		});
	})

	/**
	 * 查询方法
	 */
	var filter = function() {
		//     	var startTime= $('#begin_created_time').datebox("getValue");
		//     	var endTime= $('#end_created_time').datebox("getValue");
		//     	if((startTime!=""&&endTime=="")||(startTime==""&&endTime!="")){
		//     		ext.tip.error("时间输入范围不完整");
		//     		return;
		//     	}
		$("#visualmcheckdetialprint_dg").datagrid("options").url = "finalcheck/reportCenter/VisualmCheckSumPrint/datagrid2";
		ext.easyui.grid.search("visualmcheckdetialprint_dg",
				"visualmcheckdetialprint_search_form");
	}

	function add() {
		ext.easyui.grid.appendAndEdit("visualmcheckdetialprint_dg", {});
	}

	function edit() {
		var rows = $("#visualmcheckdetialprint_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#visualmcheckdetialprint_dg").datagrid("getRowIndex",
					rows[i]);
			$("#visualmcheckdetialprint_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {

		var rows = $("#visualmcheckdetialprint_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#visualmcheckdetialprint_dg").datagrid("getRowIndex",
					rows[i]);
			$("#visualmcheckdetialprint_dg").datagrid("deleteRow", index);
		}

	}

	function save() {
		var dg = $("#visualmcheckdetialprint_dg");

		var rows = dg.datagrid("getRows");
		var valid = false;
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
			$("#visualmcheckdetialprint_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	function cancel() {
		$("#visualmcheckdetialprint_dg").datagrid("rejectChanges");
	}
</script>