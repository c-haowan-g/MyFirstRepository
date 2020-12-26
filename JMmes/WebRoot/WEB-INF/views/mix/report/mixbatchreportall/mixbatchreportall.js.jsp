<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "mix/report/mixbatchreportall/saveChanges";

	function showOrHide() {
		if ($("#MixBatchReportAll_search_form").is(":hidden")) {
			$("#MixBatchReportAll_search_form").show();
		} else {
			$("#MixBatchReportAll_search_form").hide();
		}
	}

	$(function() {
		filter();
	})

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

	//表格加载前事件
	function dlg1BeforeLoad(param) {

		if ($("#start_time").datebox("getValue") == "") {
			return false;
		}

		param["filter[start_time]"] = $("#start_time").datebox("getValue")
				.toString();
		param["filter[end_time]"] = $("#end_time").datebox("getValue")
				.toString();

	}

	var equipcodelist = [];
	var date = new Calendar().format("yyyyMMdd");
	//加载机台名称
	$.ajax({
		url : "mix/report/mixbatchreportall/getequipcodelist?begindate=" + date
				+ "&enddate=" + date,
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			equipcodelist = data;
		}
	});

	var recipecodelist = [];
	//加载配方名称
	$.ajax({
		url : "mix/report/mixbatchreportall/getrecipecodelist?begindate="
				+ date + "&enddate=" + date,
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			recipecodelist = data;
		}
	});

	/**
	 * 点击获取机台名称
	 */
	var getequipcode = function() {
		var starttime = $("#start_time").datetimebox("getValue");
		var endtime = $("#end_time").datetimebox("getValue");
		if (starttime != "" && endtime != "") {
			if (starttime > endtime) {
				ext.tip.error("<spring:message code="tip.date" />");
			} else {
				$("#equip_code_s")
						.combobox(
								{
									url : "mix/report/mixbatchreportall/getequipcodelist?begindate="
											+ starttime + "&enddate=" + endtime,
									method : "post",
									valueField : 'EQUIP_CODE_S',
									textField : 'EQUIP_NAME_S',
									selected : 'selected'
								});

				$("#recipe_code_s")
						.combobox(
								{
									url : "mix/report/mixbatchreportall/getrecipecodelist?begindate="
											+ starttime + "&enddate=" + endtime,
									method : "post",
									valueField : 'RECIPE_CODE_S',
									textField : 'SPARE8_S',
									selected : 'selected'
								});
			}
		}

	};

	/**
	 * 点击获取配方
	 */
	var getrecipecode = function() {
		var starttime = $("#start_time").datetimebox("getValue");
		var endtime = $("#end_time").datetimebox("getValue");
		if (starttime != "" && endtime != "") {
			if (starttime > endtime) {
				ext.tip.error("<spring:message code="tip.date" />");
			} else {

				$("#recipe_code_s")
						.combobox(
								{
									url : "mix/report/mixbatchreportall/getrecipecodelist?begindate="
											+ starttime + "&enddate=" + endtime,
									method : "post",
									valueField : 'RECIPE_CODE_S',
									textField : 'SPARE8_S',
									selected : 'selected'
								});
			}
		}

	};
	
	/**
	 * 机台点击获取配方
	 */
	var getrecipecodebycode = function() {
		var starttime = $("#start_time").datetimebox("getValue");
		var endtime = $("#end_time").datetimebox("getValue");
		var equipcode = $("#equip_code_s").combobox("getValue");
		if (starttime != "" && endtime != "") {
			if (starttime > endtime) {
				ext.tip.error("<spring:message code="tip.date" />");
			} else {

				$("#recipe_code_s")
						.combobox(
								{
									url : "mix/report/mixbatchreportall/getrecipecodebycodelist?begindate="
											+ starttime + "&enddate=" + endtime+"&equipcode="+equipcode,
									method : "post",
									valueField : 'RECIPE_CODE_S',
									textField : 'SPARE8_S',
									selected : 'selected'
								});
			}
		}

	};

	//左上方表格行单击事件   
	function selectrow() {

		//获取选中行
		var rows = $("#mixbatchreportall_dg").datagrid("getSelections");

		var materialcode = rows[0].material_code_s;

		var starttime = $("#start_time").datetimebox("getValue");
		var endtime = $("#end_time").datetimebox("getValue");
		var equipcode = $("#equip_code_s").combobox("getValue");
		var woshift = $("#wo_shift_s").combotree("getValue");
		var recipecode = $("#recipe_code_s").combobox("getValue");
		if (equipcode == "") {
			equipcode = null
		}
		if (woshift == "") {
			woshift = null
		}
		if (woshift == "") {
			woshift = null
		}
		if (recipecode == "") {
			recipecode = null
		}
		ext.ajax.post("mix/report/mixbatchreportall/datagridclick", {
			"filter[start_time]" : starttime,
			"filter[end_time]"   : endtime,			
			"filter[equip_code_s]" : equipcode,
			"filter[wo_shift_s]" : woshift,
			"filter[recipe_code_s]" : recipecode,
			"filter[material_code_s]" : materialcode,
			all : 1
		}, function(data) {
			$('#groupname_dg').datagrid('loadData', data);
		});

	}

	//右上方表格行单击事件   
	function selectrow1() {

		//获取选中行
		var rows = $("#groupname_dg").datagrid("getSelections");
		if (rows != "" && rows != null) {
			var wo_shift_s_1 = rows[0].wo_shift_s;
			if (wo_shift_s_1 == 302001) {
				wo_shift_s_1 = "早班";
			} else if (wo_shift_s_1 == 302002) {
				wo_shift_s_1 = "中班";
			} else if (wo_shift_s_1 == 302003) {
				wo_shift_s_1 = "晚班";
			}
			var act_start_time_t_1 = rows[0].act_start_time_t;
			if (act_start_time_t_1 == "" || act_start_time_t_1 == null
					|| act_start_time_t_1 == "null") {
				act_start_time_t_1 = "";
			}
			var act_finish_time_t_1 = rows[0].act_finish_time_t;
			if (act_finish_time_t_1 == "" || act_finish_time_t_1 == null
					|| act_finish_time_t_1 == "null") {
				act_finish_time_t_1 = "";
			}
			//基础数据        
			$("#wo_no_s1").text("工单号: " + rows[0].wo_no_s);
			$("#equip_name_s1").text("生产机台: " + rows[0].equip_name_s);
			$("#wo_shift_s1").text("班次: " + wo_shift_s_1);
			$("#spare8_s1").text("配方名称: " + rows[0].spare8_s);
			$("#qty_plan_i1").text("计划量: " + rows[0].qty_plan_i);
			$("#qty_complete_i1").text("完成量: " + rows[0].qty_complete_i);
			$("#act_start_time_t1").text("开始时间: " + act_start_time_t_1);
			$("#act_finish_time_t1").text("结束时间: " + act_finish_time_t_1);

			//报表明细
			var url = "mix/productionplan/mixworkorderedit/getbatch?recipecode="
					+ rows[0].wo_no_s;
			ext.ajax.get(url, function(data) {
				$('#equalmaterialdg').datagrid('loadData', data);
				return;
			});
			$("#equalmaterial_dlg").dialog("open");
		} else {
			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		}

	}

	//批报表
	function batch() {

		var data = $('#groupname_dg').datagrid('getData');

		if (data.total == 1) {

			var row = $('#groupname_dg').datagrid('getData').rows[0];

			var wo_shift_s_1 = row.wo_shift_s;
			if (wo_shift_s_1 == 302001) {
				wo_shift_s_1 = "早班";
			} else if (wo_shift_s_1 == 302002) {
				wo_shift_s_1 = "中班";
			} else if (wo_shift_s_1 == 302003) {
				wo_shift_s_1 = "晚班";
			}
			var act_start_time_t_1 = row.act_start_time_t;
			if (act_start_time_t_1 == "" || act_start_time_t_1 == null
					|| act_start_time_t_1 == "null") {
				act_start_time_t_1 = "";
			}
			var act_finish_time_t_1 = row.act_finish_time_t;
			if (act_finish_time_t_1 == "" || act_finish_time_t_1 == null
					|| act_finish_time_t_1 == "null") {
				act_finish_time_t_1 = "";
			}
			//基础数据        
			$("#wo_no_s1").text("工单号: " + row.wo_no_s);
			$("#equip_name_s1").text("生产机台: " + row.equip_name_s);
			$("#wo_shift_s1").text("班次: " + wo_shift_s_1);
			$("#spare8_s1").text("配方名称: " + row.spare8_s);
			$("#qty_plan_i1").text("计划量: " + row.qty_plan_i);
			$("#qty_complete_i1").text("完成量: " + row.qty_complete_i);
			$("#act_start_time_t1").text("开始时间: " + act_start_time_t_1);
			$("#act_finish_time_t1").text("结束时间: " + act_finish_time_t_1);

			//报表明细
			var url = "mix/productionplan/mixworkorderedit/getbatch?recipecode="
					+ row.wo_no_s;
			ext.ajax.get(url, function(data) {
				$('#equalmaterialdg').datagrid('loadData', data);
				return;
			});
			$("#equalmaterial_dlg").dialog("open");

		} else if (data.total > 1) {
			//获取选中行
			var rows = $("#groupname_dg").datagrid("getSelections");
			if (rows != "" && rows != null) {
				var wo_shift_s_1 = rows[0].wo_shift_s;
				if (wo_shift_s_1 == 302001) {
					wo_shift_s_1 = "早班";
				} else if (wo_shift_s_1 == 302002) {
					wo_shift_s_1 = "中班";
				} else if (wo_shift_s_1 == 302003) {
					wo_shift_s_1 = "晚班";
				}
				var act_start_time_t_1 = rows[0].act_start_time_t;
				if (act_start_time_t_1 == "" || act_start_time_t_1 == null
						|| act_start_time_t_1 == "null") {
					act_start_time_t_1 = "";
				}
				var act_finish_time_t_1 = rows[0].act_finish_time_t;
				if (act_finish_time_t_1 == "" || act_finish_time_t_1 == null
						|| act_finish_time_t_1 == "null") {
					act_finish_time_t_1 = "";
				}
				//基础数据        
				$("#wo_no_s1").text("工单号: " + rows[0].wo_no_s);
				$("#equip_name_s1").text("生产机台: " + rows[0].equip_name_s);
				$("#wo_shift_s1").text("班次: " + wo_shift_s_1);
				$("#spare8_s1").text("配方名称: " + rows[0].spare8_s);
				$("#qty_plan_i1").text("计划量: " + rows[0].qty_plan_i);
				$("#qty_complete_i1").text("完成量: " + rows[0].qty_complete_i);
				$("#act_start_time_t1").text("开始时间: " + act_start_time_t_1);
				$("#act_finish_time_t1").text("结束时间: " + act_finish_time_t_1);

				//报表明细
				var url = "mix/productionplan/mixworkorderedit/getbatch?recipecode="
						+ rows[0].wo_no_s;
				ext.ajax.get(url, function(data) {
					$('#equalmaterialdg').datagrid('loadData', data);
					return;
				});
				$("#equalmaterial_dlg").dialog("open");
			} else {
				ext.tip
						.error("<spring:message code="tip.atLeastOneSelected" />");
			}
		} else {
			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		}
	}

	/**
	 *将数据库得值转换为数据字典与对应值域
	 */
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		var url = 'mix/report/mixbatchreportall/datagrid';

		var starttime = $("#start_time").datetimebox("getValue");
		var endtime = $("#end_time").datetimebox("getValue");
		if (starttime != "" && endtime != "") {
			if (starttime > endtime) {
				ext.tip.error("<spring:message code="tip.date" />");
			} else {

				var opts = $("#mixbatchreportall_dg").datagrid("options");
				opts.url = url;
				ext.easyui.grid.search("mixbatchreportall_dg",
						"MixBatchReportAll_search_form");

			}
		} else {
			var opts = $("#mixbatchreportall_dg").datagrid("options");
			opts.url = url;
			ext.easyui.grid.search("mixbatchreportall_dg",
					"MixBatchReportAll_search_form");
		}

		/* var starttime = $("#start_time").datetimebox("getValue");
		var equipcode = $("#equip_code_s").combobox("getValue");
		var woshift = $("#wo_shift_s").combotree("getValue");
		var recipecode = $("#recipe_code_s").combobox("getValue");
		if (equipcode == "") {
			equipcode = null
		}
		if (woshift == "") {
			woshift = null
		}
		if (woshift == "") {
			woshift = null
		}
		if (recipecode == "") {
			recipecode = null
		}
		ext.ajax.post("mix/report/mixbatchreportall/datagridclick", {
			"filter[wo_date_s]" : starttime,
			"filter[equip_code_s]" : equipcode,
			"filter[wo_shift_s]" : woshift,
			"filter[recipe_code_s]" : recipecode,
			all : 1
		}, function(data) {
			$('#groupname_dg').datagrid('loadData', data);
		});
		 */
	}

	function add() {
		ext.easyui.grid.appendAndEdit("mixbatchreportall_dg", {});
	}

	function edit() {
		var rows = $("#mixbatchreportall_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixbatchreportall_dg").datagrid("getRowIndex", rows[i]);
			$("#mixbatchreportall_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {

		var rows = $("#mixbatchreportall_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixbatchreportall_dg").datagrid("getRowIndex", rows[i]);
			$("#mixbatchreportall_dg").datagrid("deleteRow", index);
		}

	}

	function save() {
		var dg = $("#mixbatchreportall_dg");

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
			$("#mixbatchreportall_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	function cancel() {
		$("#mixbatchreportall_dg").datagrid("rejectChanges");
	}
</script>