<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path
			+ "halfpart/baseData/halfpartMachineOutput/saveChanges";

	function showOrHide() {
		if ($("#HalfpartMachineOutputSearch_search_form").is(":hidden")) {
			$("#HalfpartMachineOutputSearch_search_form").show();
		} else {
			$("#HalfpartMachineOutputSearch_search_form").hide();
		}
	}

	//设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
	});
	//查询机台名称
	var productLineList = [];
	$.ajax({
		url : "halfpart/basedata/productlinemanager/getHalfPartProductionLine",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			productLineList = data;
		}
	});
	function outputflagFormatter(v, r, i) {
		if (v == "0") {

			return "服务端";
		} else if (v == "1") {

			return "客户端";
		}
	}

	function solidifyflagFormatter(v, r, i) {
		if (v == "0") {

			return "未固化";
		} else if (v == "1") {

			return "已固化";
		}
	}
	function outflagFormatter(v, r, i) {
		if (v == "105001") {

			return "正常产出";
		} else if (v == "105002") {

			return "补产出";
		} else if (v == "105003") {

			return "取消产出";

		}
	}
	function outclassFormatter(v, r, i) {
		if (v == "118001") {

			return "早班";
		} else if (v == "118002") {

			return "中班";
		} else if (v == "118003") {

			return "晚班";

		}
	}
	function codeFormatter(v, r, i) {
		if (v == null) {
			return "";
		}

		return dictFormat(v);
	}
	function valuetimeFormatter(v, r, i) {

		if (r.stoptime_t == null || r.outtime_t == null) {
			r.valuetime = "";
		}

		return r.valuetime;
	}

	function outclassFormatter(v, r, i) {
		if (v == "118001") {

			return "早班";
		} else if (v == "118002") {

			return "中班";
		} else if (v == "118003") {

			return "晚班";

		}
	}
	
	function stateFormatter(v, r, i) {
		if(v == "0" ){
		
			return "未检测"; 
		}else if(v == "1"){
		
			return "合格"; 
		}else if(v == "2"){
		
			return "不合格";
		
		}else{
			return "";
		}
	} 

	/* 获取参数类型 */
	var basetypesList = [];
	$.ajax({
		url : 'halfpart/baseData/halfpartMachineOutput/searchUsercode',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			
	basetypesList = data;
		}
	});
	/**
	 * 参数显示显示转化
	 * 2019-05-20
	 * ldx
	 */
	function operatorFormatter(v, r, i) {
		for (var i = 0; i < basetypesList.length; i++) {
			if (v == basetypesList[i].USERCODE) {
				return basetypesList[i].USERNAME;
			}
		}
	}
	/**
	 * 查询方法
	 */
	var filter = function() {
		var opts = $("#halfpartmachineoutputsearch_dg").datagrid("options");
		opts.url = 'halfpart/baseData/halfpartMachineOutput/datagrid';
		ext.easyui.grid.search("halfpartmachineoutputsearch_dg",
				"HalfpartMachineOutputSearch_search_form");
	}

	function add() {
		ext.easyui.grid.appendAndEdit("halfpartmachineoutputsearch_dg", {});
	}

	function edit() {
		var rows = $("#halfpartmachineoutputsearch_dg").datagrid("getSelections");
		var index = -1;
		if(rows.length == 0){
        	ext.tip.error("请选择一条数据!");
            return;
        }
		for (var i = 0; i < rows.length; i++) {
			index = $("#halfpartmachineoutputsearch_dg").datagrid("getRowIndex", rows[i]);
			$("#halfpartmachineoutputsearch_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {

		var rows = $("#halfpartmachineoutputsearch_dg").datagrid(
				"getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#halfpartmachineoutputsearch_dg").datagrid(
					"getRowIndex", rows[i]);
			$("#halfpartmachineoutputsearch_dg").datagrid("deleteRow", index);
		}

	}

	function save() {
		var dg = $("#halfpartmachineoutputsearch_dg");

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
			$("#halfpartmachineoutputsearch_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	function cancel() {
		$("#halfpartmachineoutputsearch_dg").datagrid("rejectChanges");
	}
</script>