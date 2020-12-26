<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "mix/baseData/equalMaterial/saveChanges";

	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("equalmaterial_dg", "EqualMaterial_search_form");
	};

	/* var groupnameList = [];
	$.ajax({
	    url:"mix/baseData/equalMaterial/getGroupnamesList",
	    type:"get",
	    dataType:"json",
	    async:false,
	    success:function(data){
	    	groupnameList = data;
	    }
	}); */

	var equalmatinfoList = [];
	$.ajax({
		url : "mix/baseData/equalMaterial/getEqualMatInfo",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			equalmatinfoList = data;
		}
	});

	var mixmatinfoList = [];
	$.ajax({
		url : "mix/baseData/equalMaterial/getMixMatInfo",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			mixmatinfoList = data;
		}
	});

	function add() {
		var groupname = $("#groupname_s").combobox("getValue");
		var row = {
			groupname_s : groupname,
			send_state_s : '0',
			dummy2_s : '1'
		};
		ext.easyui.grid.appendAndEdit("equalmaterial_dg", row);
	}

	function edit() {
		var rows = $("#equalmaterial_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#equalmaterial_dg").datagrid("getRowIndex", rows[i]);
			$("#equalmaterial_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {
		var rows = $("#equalmaterial_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#equalmaterial_dg").datagrid("getRowIndex", rows[i]);
			$("#equalmaterial_dg").datagrid("deleteRow", index);
		}
	}

	function save() {
		var dg = $("#equalmaterial_dg");
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
			ext.ajax.sendJson(saveChanges, {
				inserted : inserted,
				updated : updated,
				deleted : deleted
			}, function(data) {
				if (data.code != OK) {
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				}
				$("#equalmaterial_dg").datagrid("reload");
				ext.tip.suc("<spring:message code="tip.success" />");
			});
		}
	}

	function cancel() {
		$("#equalmaterial_dg").datagrid("rejectChanges");
	}

	function onLoadSuccess(data) {
		$("#equalmaterial_dg").datagrid("autoMergeCells", [ 'groupname_s' ]);
	}

	function sendstateformatter(v, r, i) {
		if (v == 0) {
			return "未下发";
		} else if (v == 1) {
			return "已使用";
		} else if (v == 2) {
			return "下发失败";
		} else {
			return v;
		}
	}

	function levelformatter(v, r, i) {
		if (v == 0) {
			return "关闭";
		} else if (v == 1) {
			return "开启";
		} else {
			return v;
		}
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

	function openOrclose(type) {
		var openOrclose = "mix/baseData/equalMaterial/openOrclose";
		var updated = $("#equalmaterial_dg").datagrid("getSelections");
		if (updated.length == 1) {
			ext.ajax.sendJson(openOrclose, {
				type : type,
				updated : updated
			}, function(data) {
				if (data.data != "error") {
					if (data.message != "ok") {
						$("#equalmaterial_dg").datagrid("reload");
						ext.tip.error("<spring:message code="tip.error" />");
					} else {
						$("#equalmaterial_dg").datagrid("reload");
						ext.tip.suc("<spring:message code="tip.success" />");
					}
					;
				} else {
					$("#equalmaterial_dg").datagrid("reload");
					ext.tip.error(data.message);
				}
				;
			});
		} else {
			ext.tip.error("请选择一条数据");
		}
		;
	}

	function onmaterialcodeselect(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		$(getEditor(index, "materialname_s").target).textbox("setValue",
				record.materialname_s);
		$(getEditor(index, "dummy1_s").target).textbox("setValue",
				record.materialspec_s);
	}

	function getEditor(index, field) {
		return $("#equalmaterial_dg").datagrid("getEditor", {
			index : index,
			field : field
		});
	}
</script>