<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "finalcheck/baseData/reas/saveChanges";

	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

	function showOrHide() {
		if ($("#Reas_search_form").is(":hidden")) {
			$("#Reas_search_form").show();
		} else {
			$("#Reas_search_form").hide();
		}
	}

    /**
     * 接收combtree数据
     */
     var DICT_261=[];
 	
 	$.ajax({
 		url:"dict/code/261",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_261=data;
 		}
 	});
 	
    /**
     * 接收combtree数据
     */
     var DICT_262=[];
 	
 	$.ajax({
 		url:"dict/code/262",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_262=data;
 		}
 	});
	
    /**
     * 接收用户数据
     */
     var UserInfo=[];
 	
 	$.ajax({
 		url:"common/comboxUser",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			UserInfo=data;
 		}
 	});
   function userFormatter(v,r,i){
 		for (var i = 0; i < UserInfo.length; i++) {
 			if(UserInfo[i].USERCODE==v){
 				return UserInfo[i].USERNAME;
 			}
 		}
 	}


	
	
	
	
	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("reas_dg", "Reas_search_form");
	}

	function add() {
		$("#reas_dg").datagrid('insertRow', {
			index : 0,
			row : {}
		});
		var rows = $("#reas_dg").datagrid("getRows");
		$("#reas_dg").datagrid("beginEdit", rows.length - 1);
	}

	function edit() {
		var rows = $("#reas_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#reas_dg").datagrid("getRowIndex", rows[i]);
			$("#reas_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {

		var rows = $("#reas_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#reas_dg").datagrid("getRowIndex", rows[i]);
			$("#reas_dg").datagrid("deleteRow", index);
		}
	}

	function save() {
		var dg = $("#reas_dg");

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

		var v1Editor, v2Editor, v3Editor, v4Editor, v5Editor, v1, v2, v3, v4, v5;
		for (var i = 0; i < rows.length; i++) {
			v1Editor = dg.datagrid('getEditor', {
				index : i,
				field : 'raw_s'
			});
			if (!v1Editor) {
				continue;
			}
			v1 = $(v1Editor.target).numberbox('getValue');

			v2Editor = dg.datagrid('getEditor', {
				index : i,
				field : 'banburying_s'
			});
			v2 = $(v2Editor.target).numberbox('getValue');

			v3Editor = dg.datagrid('getEditor', {
				index : i,
				field : 'frontend_s'
			});
			v3 = $(v3Editor.target).numberbox('getValue');

			v4Editor = dg.datagrid('getEditor', {
				index : i,
				field : 'molding_s'
			});
			v4 = $(v4Editor.target).numberbox('getValue');

			v5Editor = dg.datagrid('getEditor', {
				index : i,
				field : 'curing_s'
			});
			v5 = $(v5Editor.target).numberbox('getValue');

			if (parseFloat(parseFloat(v1) + parseFloat(v2) + parseFloat(v3)
					+ parseFloat(v4) + parseFloat(v5)) != 1) {
				ext.tip.error("<spring:message code='tip.proportion'/>");
				return;
			}
			dg.datagrid("endEdit", i);
		}
		ext.ajax.sendJson(saveChanges, {
			inserted : inserted,
			updated : updated,
			deleted : deleted
		}, function(data) {
			if (data.status != 1) {
				ext.tip.error("<spring:message code="tip.error" />");
			}
			$("#reas_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")
		});
	}

	function cancel() {
		$("#reas_dg").datagrid("rejectChanges");
	}

	function showhide() {
		$("#Reas_search_form").toggle();
	}
</script>