<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/qualityInspectionRecord/scanAppearanceLog/saveChanges";
    
    function showOrHide(){
        if($("#ScanAppearanceLog_search_form").is(":hidden")){
            $("#ScanAppearanceLog_search_form").show();
        }else{
            $("#ScanAppearanceLog_search_form").hide();
        }
    }
    
    /**
     * 接收combtree数据
     */
     var DICT_259=[];
 	
 	$.ajax({
 		url:"dict/code/259",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_259=data;
 		}
 	});
    
    /**
     * 查询方法
     */
   
	function filter() {
		var startTime = $('#begin_created_time').datebox("getValue");
		var endTime = $('#end_created_time').datebox("getValue");
		if ((startTime != "" && endTime == "")
				|| (startTime == "" && endTime != "")) {
			ext.tip.error("时间输入范围不完整");
			return;
		}
		var opts = $("#scanappearancelog_dg").datagrid("options");
		opts.url = 'finalcheck/qualityInspectionRecord/scanAppearanceLog/datagrid';
		// $("#scandynabalancelog_dg").datagrid("load");

		ext.easyui.grid.search("scanappearancelog_dg",
				"ScanAppearanceLog_search_form");
	}

	function add() {
		ext.easyui.grid.appendAndEdit("scanappearancelog_dg", {});
	}

	function edit() {
		var rows = $("#scanappearancelog_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#scanappearancelog_dg").datagrid("getRowIndex", rows[i]);
			$("#scanappearancelog_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {

		var rows = $("#scanappearancelog_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#scanappearancelog_dg").datagrid("getRowIndex", rows[i]);
			$("#scanappearancelog_dg").datagrid("deleteRow", index);
		}

	}

	function save() {
		var dg = $("#scanappearancelog_dg");

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
			$("#scanappearancelog_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	function cancel() {
		$("#scanappearancelog_dg").datagrid("rejectChanges");
	}

	function codeFormatter(v, r, i) {

		return dictFormat(v);

	}

	function mesxy(v, r, i) {

		if (v == 1) {
			return "<spring:message code='success' />";
		}
		if (v == 0) {
			return "<spring:message code='fail' />";
		}
	}

	//设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
	});

	//隐藏查询栏
	function searchBar() {
		$("#ScanAppearanceLog_search_form").toggle();
	}
</script>