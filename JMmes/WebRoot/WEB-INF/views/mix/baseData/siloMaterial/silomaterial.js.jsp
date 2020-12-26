<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "mix/baseData/siloMaterial/saveChanges";

	function showOrHide() {
		if ($("#SiloMaterial_search_form").is(":hidden")) {
			$("#SiloMaterial_search_form").show();
		} else {
			$("#SiloMaterial_search_form").hide();
		}
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("silomaterial_dg", "SiloMaterial_search_form");
	};

	function sendstateFormatter(v, r, i) {
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

	/**
	 * 获取密炼机台信息
	 */
	var equipList = [];
	$.ajax({
		url : "mix/planManagement/dayPlan/getJlEquipList?plantype=" + "051004",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			equipList = data;
		}
	});
	
	function equipCodeFormatter(v, r, i) {
		for (var i = 0; i < equipList.length; i++) {
			if (v == equipList[i].p_line_name) {
				return equipList[i].description;
			}
		}
	}

	function add() {
		var code = "QMMIXPLAN";
		var date = new Calendar().format("yyyyMMdd");
		getSerialByDate(code, date, function(data) {
			var row = {
				id_s : "MS" + data.data.substr(2, data.data.length),
				status_s : '058001',
				spare1_s : '0'
			};
			ext.easyui.grid.appendAndEdit("silomaterial_dg", row);
		});
	}

	function edit() {
		var rows = $("#silomaterial_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_s != "058001") {
				ext.tip.error("只有未审核的数据才能编辑");
				return;
			}
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#silomaterial_dg").datagrid("getRowIndex", rows[i]);
			$("#silomaterial_dg").datagrid("beginEdit", index);
			var equip_code_s = $("#silomaterial_dg").datagrid('getEditor', {
				index : index,
				field : 'equip_code_s'
			});
			$(equip_code_s.target).textbox({
				disabled : true
			});//不可编辑
			var silono_s = $("#silomaterial_dg").datagrid('getEditor', {
				index : index,
				field : 'silono_s'
			});
			$(silono_s.target).textbox({
				disabled : true
			});//不可编辑
			var pipeline_s = $("#silomaterial_dg").datagrid('getEditor', {
				index : index,
				field : 'pipeline_s'
			});
			$(pipeline_s.target).textbox({
				disabled : true
			});//不可编辑
			var material_name_s = $("#silomaterial_dg").datagrid('getEditor', {
				index : index,
				field : 'material_name_s'
			});
			$(material_name_s.target).textbox({
				disabled : true
			});//不可编辑
		}
	}

	function remove() {
		var rows = $("#silomaterial_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_s != "058001") {
				ext.tip.error("只有未审核的数据才能删除");
				return;
			}
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#silomaterial_dg").datagrid("getRowIndex", rows[i]);
			$("#silomaterial_dg").datagrid("deleteRow", index);
		}
	}

	function audit() {
		var rows = $("#silomaterial_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_s != "058001") {
				ext.tip.error("只有未审核的数据才能审核");
				return;
			}
		}
		var updated = [];
		for (var i = 0; i < rows.length; i++) {
			rows[i].status_s = "058002";
			updated.push(rows[i]);
		}
		ext.ajax.sendJson(saveChanges, {
			updated : updated
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#silomaterial_dg").datagrid("reload");
			ext.tip.suc("审核成功");
		});
	}

	function cancelAudit() {
		var rows = $("#silomaterial_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_s != "058002") {
				ext.tip.error("只有已审核的数据才能撤销审核");
				return;
			}
		}
		var updated = [];
		for (var i = 0; i < rows.length; i++) {
			rows[i].status_s = "058001";
			updated.push(rows[i]);
		}
		ext.ajax.sendJson(saveChanges, {
			updated : updated
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#silomaterial_dg").datagrid("reload");
			ext.tip.suc("撤销审核成功");
		});
	}

	function issue() {
		var rows = $("#silomaterial_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_s != "058002") {
				ext.tip.error("只有已审核的数据才能下发");
				return;
			}
		}
		var recipecodelist = [];
		for (var i = 0; i < rows.length; i++) {
			recipecodelist.push(rows[i].id_s);
		}
		ext.ajax.post("mix/baseData/siloMaterial/downward", {
			recipecodelist : recipecodelist.toString()
		}, function(data) {
			$("#silomaterial_dg").datagrid("reload");
			showConfirm(data.data);
		});
	}

	function save() {
		var dg = $("#silomaterial_dg");

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
				$("#silomaterial_dg").datagrid("reload");
				ext.tip.suc("<spring:message code="tip.success" />");
			});
		}
	}

	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

	function materialcodechanged(value, oldvalue) {
		var k = $(this).parents('[datagrid-row-index]').attr(
				'datagrid-row-index');
		var name_td = $('.datagrid-body td[field=\'material_name_s\']')[k];
		var name_input = $(name_td).find('input')[0];
		var type_td = $('.datagrid-body td[field=\'materialtype_s\']')[k];
		var type_s_input = $(type_td).find('input')[0];
		$.ajax({
			url : 'mix/baseData/siloMaterial/getNameAndTypeByCode',
			type : 'get',
			dataType : 'json',
			data : {
				materialcode : value
			},
			async : false,
			success : function(data) {
				$(name_input).textbox('setValue', data[0].materialname_s);
				$(type_s_input).textbox('setValue', data[0].materialtype_s);
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

	function cancel() {
		$("#silomaterial_dg").datagrid("rejectChanges");
	}
</script>