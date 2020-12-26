<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "common/halfPartProcess/saveChanges";

	function showOrHide() {
		if ($("#HalfPartProcess_search_form").is(":hidden")) {
			$("#HalfPartProcess_search_form").show();
		} else {
			$("#HalfPartProcess_search_form").hide();
		}
	}

	function selectrow() {
		var rowData = $("#halfpartprocess_dg").datagrid('getSelected');
		if (rowData == null) {
			return;
		}
		var storageZoneKey = rowData.storage_zone_key;
		
		var url = "halfpart/basedata/storageunitmanager/getZoneList?zonekey=" + rowData.storage_zone_key;
		ext.ajax.get(url, function(data) {
			$("#testDiv").html(data);
		});
	}

	//隐藏查询栏
	function searchBar() {
		$("#HalfPartProcess_search_form").toggle();
	}

	$(document).ready(function() {
		filter();
	});

	/**
	 * 查询按钮
	 */
	function filter() {
		description = $('#description').textbox('getValue');
		category = $('#storage_zone_name').textbox('getValue');
		$.ajax({
			url : 'halfpart/basedata/storagezonemanager/searchZoneByCategoryAndZoneName?category='
					+ category + '&description=' + description,
			type : "post",
			dataType : "json",
			data : JSON,
			contentType : 'application/json',
			async : false,
			success : function(data) {
				$("#halfpartprocess_dg").datagrid("loadData", data);
			}
		});
	};

	function add() {
		ext.easyui.grid.appendAndEdit("halfpartprocess_dg", {});
	}

	function edit() {
		var rows = $("#halfpartprocess_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#halfpartprocess_dg").datagrid("getRowIndex", rows[i]);
			$("#halfpartprocess_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {
		var rows = $("#halfpartprocess_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#halfpartprocess_dg").datagrid("getRowIndex", rows[i]);
			$("#halfpartprocess_dg").datagrid("deleteRow", index);
		}

	}

	function save() {
		var dg = $("#halfpartprocess_dg");

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
			$("#halfpartprocess_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	function cancel() {
		$("#halfpartprocess_dg").datagrid("rejectChanges");
	}

</script>