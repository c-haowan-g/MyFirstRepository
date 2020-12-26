<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "mix/baseData/carriers/saveChanges";

	function showOrHide() {
		if ($("#Carriers_search_form").is(":hidden")) {
			$("#Carriers_search_form").show();
		} else {
			$("#Carriers_search_form").hide();
		}
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("carriers_dg", "Carriers_search_form");
	};

	function add() {
		ext.easyui.grid.appendAndEdit("carriers_dg", {});
	}

	function edit() {
		var rows = $("#carriers_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#carriers_dg").datagrid("getRowIndex", rows[i]);
			$("#carriers_dg").datagrid("beginEdit", index);
			var carrier_type_s = $("#carriers_dg").datagrid('getEditor', {
				index : index,
				field : 'carrier_type_s'
			});
			$(carrier_type_s.target).textbox({
				disabled : true
			});
			var carrier_code_s = $("#carriers_dg").datagrid('getEditor', {
				index : index,
				field : 'carrier_code_s'
			});
			$(carrier_code_s.target).textbox({
				disabled : true
			});
			var carrier_desc_s = $("#carriers_dg").datagrid('getEditor', {
				index : index,
				field : 'carrier_desc_s'
			});
			$(carrier_desc_s.target).textbox({
				disabled : true
			});
			var isuse_s = $("#carriers_dg").datagrid('getEditor', {
				index : index,
				field : 'isuse_s'
			});
			$(isuse_s.target).textbox({
				disabled : true
			});
		}
	}

	function remove() {
		var rows = $("#carriers_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#carriers_dg").datagrid("getRowIndex", rows[i]);
			$("#carriers_dg").datagrid("deleteRow", index);
		}
	}

	function save() {
		var dg = $("#carriers_dg");
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
				$("#carriers_dg").datagrid("reload");
				ext.tip.suc("<spring:message code="tip.success" />");
			});
		}
	}

	function cancel() {
		$("#carriers_dg").datagrid("rejectChanges");
	}

	function codeFormatter(v, r, i) {
		var row = $("#carriers_dg").datagrid("getData").rows[i];
		if (row.isuse_s == "0") {
			r.isuse_s = "未使用";
		}
		if (row.isuse_s == "1") {
			r.isuse_s = "已使用";
		}
		if (v == null) {
			return "";
		}
		return dictFormat(v);
	}

	function toUserName(v, r, i) {
		if (v == null) {
			return v;
		}
		$.ajax({
			url : 'mix/baseData/carriers/toUserName',
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