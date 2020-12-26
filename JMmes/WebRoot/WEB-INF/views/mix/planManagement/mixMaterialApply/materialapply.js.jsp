<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function() {
		filter();
	});
	
	var codejl = "QMMIXPLAN";

	var saveChanges = path + "mix/planManagement/materialApply/saveChanges";

	function showOrHide() {
		if ($("#MaterialApply_search_form").is(":hidden")) {
			$("#MaterialApply_search_form").show();
		} else {
			$("#MaterialApply_search_form").hide();
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
	 * 查询方法
	 */
	var filter = function() {
		var opts = $("#materialapply_dg").datagrid("options");
		opts.url = 'mix/planManagement/materialApply/datagrid';
		ext.easyui.grid.search("materialapply_dg", "MaterialApply_search_form");
	};

	function add() {
		var dateTimeboxData = $("#prod_date_s").datebox("getValue");
		if (dateTimeboxData == "") {
			ext.tip.warn("请选择生产日期");
			return;
		}
		var date1 = dateTimeboxData;
		var date2 = new Calendar().format("yyyyMMdd");
		if (date1 < date2) {
			ext.tip.warn("不能添加当前日期之前的计划");
			return;
		}
		var equip_Code = $("#equip_code_sjl").combobox("getValue");
		if(equip_Code == "" || equip_Code == null) {
	    	ext.tip.warn("请选择机台");
	    	return;
	    }
	    var shift_code = $("#prod_shift_s").combobox("getValue");
		if(shift_code == "" || shift_code == null) {
	    	ext.tip.warn("请选择班次");
	    	return;
	    }
		var type = $("#spare1_s").combobox("getValue");
	    if(type == "" || type == null) {
	    	ext.tip.warn("请选择申请类型");
	    	return;
	    }
	    
	    var tt=$('#materialapply_dg').datagrid('getColumnOption', 'equip_code_s');
	    var ttt=$('#materialapply_dg').datagrid('getColumnOption', 'prod_shift_s');
        tt.editor=close;
        ttt.editor=close;
	    
	    getSerialByDate(codejl, dateTimeboxData, function(data) {
	    	var wo = "";
		    if(type == "0") {
		    	wo = "YL" + equip_Code + data.data.substring(5, 14) + shift_code.substring(shift_code.length - 1, shift_code.length);
		    } else {
		    	wo = "ML" + equip_Code + data.data.substring(5, 14) + shift_code.substring(shift_code.length - 1, shift_code.length);
		    }
		    var row = {
				prod_date_s : dateTimeboxData,
				equip_code_s : equip_Code,
				prod_shift_s : shift_code,
				apply_no_s : wo,
				status_check_s : "064001",
				spare1_s : type
			};
			ext.easyui.grid.appendAndEdit("materialapply_dg", row);
		});
	}

	function edit() {
		var rows = $("#materialapply_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_check_s != "064001") {
				ext.tip.error("只有未审核的数据才能编辑");
				return;
			}
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#materialapply_dg").datagrid("getRowIndex", rows[i]);
			$("#materialapply_dg").datagrid("beginEdit", index);
			var apply_no_s = $("#materialapply_dg").datagrid('getEditor', {
				index : index,
				field : 'apply_no_s'
			});
			$(apply_no_s.target).textbox({
				disabled : true
			});//不可编辑
		}
	}

	function remove() {
		var rows = $("#materialapply_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_check_s != "064001") {
				ext.tip.error("只有未审核的数据才能删除");
				return;
			}
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#materialapply_dg").datagrid("getRowIndex", rows[i]);
			$("#materialapply_dg").datagrid("deleteRow", index);
		}
	}

	//审核
	function audit() {
		var rows = $("#materialapply_dg").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_check_s != '064001') {
				ext.tip.warn("状态不是未审核，其余状态不允许审核操作");
				return;
			}
		}
		var updated = [];
		for (var i = 0; i < rows.length; i++) {
			rows[i].status_check_s = "064002";
			updated.push(rows[i]);
		}
		ext.ajax.sendJson(saveChanges, {
			updated : updated
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#materialapply_dg").datagrid("reload");
			ext.tip.suc("审核成功");
		});
	}
	//撤销审核
	function cancelAudit() {
		var rows = $("#materialapply_dg").datagrid("getChecked");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].status_check_s != '064002') {
				ext.tip.warn("状态不是已审核，其余状态不允许撤销审核操作");
				return;
			}
		}
		var updated = [];
		for (var i = 0; i < rows.length; i++) {
			rows[i].status_check_s = "064001";
			updated.push(rows[i]);
		}
		ext.ajax.sendJson(saveChanges, {
			updated : updated
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
				return;
			}
			$("#materialapply_dg").datagrid("reload");
			ext.tip.suc("撤销审核成功");
		});
	}

	function save() {
		var dg = $("#materialapply_dg");
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
				$("#materialapply_dg").datagrid("reload");
				ext.tip.suc("<spring:message code="tip.success" />");
			});
		}
	}

	//表格行单击事件   
	function selectrow() {
		var rows = $("#materialapply_dg").datagrid('getSelected');
		var apply_no_s = rows.apply_no_s;
		//加载子表信息
		ext.ajax.post("mix/planManagement/materialApplyRecord/datagridrows", {
			"filter[apply_no_s]" : apply_no_s,
			all : 1
		}, function(data) {
			$('#materialapplyrecord_dg').datagrid('loadData', data);
		});
	}

	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

	function checkstate(v, r, i) {
		if (v == 0) {
			return "未审核";
		} else if (v == 1) {
			return "已审核";
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

	function searchMixEquipName(v, r, i) {
		if (v == null) {
			return v;
		}
		$.ajax({
			url : 'mix/planManagement/materialApply/searchMixEquipName',
			type : 'get',
			dataType : 'json',
			data : {
				equipcode : v
			},
			async : false,
			success : function(data) {
				if (data.length == 0) {
					return v;
				}
				v = data[0].description;
			}
		});
		return v;
	}

	function materialcodechanged(value, oldvalue) {
		var k = $(this).parents('[datagrid-row-index]').attr(
				'datagrid-row-index');
		var name_td = $('.datagrid-body td[field=\'material_name_s\']')[k];
		var name_input = $(name_td).find('input')[0];
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
			}
		});
	}

	function planStatusColorSetting(value, row, index) {
		if (value == "064001") {
			return 'text-align: center;';
		} else if (value == "064002") {
			return 'background-color:#00FFFF;text-align: center;';
		} else if (value == "064003") {
			return 'background-color:#FF1493;text-align: center;';
		} else if (value == "064004") {
			return 'background-color:#FFE4B5;text-align: center;';
		}
	}

	function cancel() {
		$("#materialapply_dg").datagrid("rejectChanges");
	}

	function spare1Formatter(v, r, i) {
		if (v == 0) {
			return "原材料领料";
		} else if (v == 1) {
			return "密炼领料";
		} else {
			return v;
		}
	};
</script>