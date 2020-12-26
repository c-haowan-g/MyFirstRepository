<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//胶料计划

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
	var saveChanges = path + "mix/productionplan/mixworkorderedit/saveChanges";

	function showOrHide() {
		if ($("#MixWorkOrderEdit_search_form").is(":hidden")) {
			$("#MixWorkOrderEdit_search_form").show();
		} else {
			$("#MixWorkOrderEdit_search_form").hide();
		}
	}

	//时间显示
	function timeformatter(v, r, i) {
		if (typeof (v) == "undefined" || v == "" || v == null) {
			return v;
		} else {
			return v.slice(11)
		}
	}

	var equiplist = [];
	//加载胶料机台信息
	$.ajax({
		url : "mix/basedata/factorymodel/getMixProductionInfo?plantype="
				+ "051003",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			equiplist = data;
		}
	});

	/* var equiplist2=[];
	    //加载硫磺机台信息
	  $.ajax({
		url:"mix/basedata/factorymodel/getMixProductionInfo?plantype="+"051002",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			equiplist2=data;
		}
	});*/

	var equiplist2 = [];
	//加载小料机台信息
	$.ajax({
		url : "mix/basedata/factorymodel/getMixXLProductionInfo",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			equiplist2 = data;
		}
	});

	//小料机台转换
	function equipcodeformatterxl(v, r, i) {
		for (var i = 0; i < equiplist2.length; i++) {
			if (v == equiplist2[i].p_line_name) {
				return equiplist2[i].description;
			}
		}
	};

	//胶料机台转换
	function equipcodeformatter(v, r, i) {
		for (var i = 0; i < equiplist.length; i++) {
			if (v == equiplist[i].p_line_name) {
				return equiplist[i].description;
			}
		}
	};

	function searchProductionLine(q, row) {
		var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}

	/**
	 * 获取机台
	 */
	var MixpipelineList = [];
	$.ajax({
		url : "mobile/mx/mixcbfeed/getplmByPlinename",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			MixpipelineList = data;
		}
	});

	//加载机台显示
	function plmByPlinenameformatter(v, r, i) {
		for (var i = 0; i < MixpipelineList.length; i++) {
			if (v == MixpipelineList[i].P_LINE_NAME) {
				return MixpipelineList[i].DESCRIPTION;
			}
		}
	}

	//表格加载前事件
	function dlg1BeforeLoad(param) {
		if ($("#wo_date_s").datebox("getValue") == "") {
			return false;
		}

		param["filter[wo_date_s]"] = $("#wo_date_s").datebox("getValue");
		param["filter[wo_type_s]"] = '051003';
	}

	//获取指定行、指定列的编辑器
	function getEditor1(index, field) {
		return $("#mixworkorderedit_dg").datagrid("getEditor", {
			index : index,
			field : field
		});
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("mixworkorderedit_dg",
				"MixWorkOrderEdit_search_form");

	}

	/**
	 *将数据库得值转换为数据字典与对应值域
	 */
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

	function sendstateFormatter(v, r, i) {
		if (v == 0) {
			return "未下发";
		} else if (v == 1) {
			return "已下发";
		} else if (v == 2) {
			return "下发失败";
		} else {
			return v;
		}
	}

	function spare17Formatter(v, r, i) {
		if (v == 0) {
			return "未处理";
		} else if (v == 1) {
			return "已处理";
		} else if (v == 2) {
			return "处理失败";
		} else {
			return v;
		}
	}

	function spareFormatter(v, r, i) {
		if (v == 0) {
			return "否";
		} else if (v == 1) {
			return "是";
		} else {
			return v;
		}
	}

/* 	function completionrateFormatter(v, r, i) {
		if (v == "undefined" || v == null || v == "") {
			return "0%";
		} else {
			return v + "%";
		}
	} */
	
	    
    /**
     * 设置datagrid进度条
     */
    function completionrateFormatter(v, r, i){

    		if (v == "undefined" || v == null || v == "") {
        		value=0;
        	}else{
        	   value=v;
        	}
    		
    	
    	return "<div class='easyui-progressbar progressbar easyui-fluid' style='width:100px'><div class='progressbar-text' style='width:100px;z-index:100'>"+ value + "%</div> <div class='progressbar-value'  style='width:"+ value + "%;background-color:#00FF99'>&nbsp;&nbsp;</div></div>"; 
    	
    }

	function equipcodeFormatter(v, r, i) {
		if (v == 90105) {
			return "M1-F430-1#";
		} else if (v == 90106) {
			return "M1-F270-1#";
		} else if (v == 90107) {
			return "M1-F270-2#";
		} else if (v == 90108) {
			return "M1-F270-3#";
		} else if (v == 90201) {
			return "1#自动配料";
		} else if (v == 90202) {
			return "1#自动配料";
		} else if (v == 90203) {
			return "2#自动配料";
		} else if (v == 90101) {
			return "M1-F370-2#";
		} else if (v == 90102) {
			return "M1-F370-3#";
		} else if (v == 90103) {
			return "M1-F370-4#";
		} else if (v == 90104) {
			return "M1-F370-5#";
		} else {
			return v;
		}
	}
	function add() {
		ext.easyui.grid.appendAndEdit("mixworkorderedit_dg", {});
	}

	function edit() {
		var rows = $("#mixworkorderedit_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixworkorderedit_dg").datagrid("getRowIndex", rows[i]);
			$("#mixworkorderedit_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {

		var rows = $("#mixworkorderedit_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixworkorderedit_dg").datagrid("getRowIndex", rows[i]);
			$("#mixworkorderedit_dg").datagrid("deleteRow", index);
		}

	}

	function save() {
		var dg = $("#mixworkorderedit_dg");

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
			$("#mixworkorderedit_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	//显示操作结果
	function showConfirm(msg) {
		$.messager.confirm({
			width : 700,
			height : 350,
			title : '提示',
			msg : msg,
			fn : function(r) {
			}
		});
	}

	function getDg() {
		return $("#mixworkorderedit_dg");
	}

	//获取选择行数据
	function getRecipecodelist() {
		var rows = getDg().datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn("请勾选显示区的复选框");
			return;
		}

		var recipecodelist = [];

		for (var i = 0; i < rows.length; i++) {
			recipecodelist.push(rows[i].wo_no_s);
		}
		return recipecodelist;
	}

	//获取选择行数据
	function getRecipecodelistbycheck() {
		var rows = getDg().datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn("请勾选显示区的复选框");
			return;
		}

		var recipecodelist = [];

		for (var i = 0; i < rows.length; i++) {

			var data = "";
			data = rows[i].wo_date_s + "|" + rows[i].wo_shift_s + "|"
					+ rows[i].equip_code_s;

			recipecodelist.push(data);
		}

		var temp = []; //一个新的临时数组
		for (var i = 0; i < recipecodelist.length; i++) {
			if (temp.indexOf(recipecodelist[i]) == -1) {
				temp.push(recipecodelist[i]);
			}
		}

		return temp;
	}

	//下发
	function downward() {

		var off = "close";

		//校验是否设置主机手
		if (getRecipecodelistbycheck() == ""
				|| getRecipecodelistbycheck() == null) {
			return;
		}
		ext.ajax.post("mix/productionplan/mixworkorderedit/check", {
			recipecodelist : getRecipecodelistbycheck().toString()
		}, function(data) {
			if (data.data == "") {
				//下发
				if (getRecipecodelist() == "" || getRecipecodelist() == null) {
					return;
				}
				ext.ajax.post("mix/productionplan/mixworkorderedit/downward", {
					recipecodelist : getRecipecodelist().toString()
				}, function(data) {
					if (data.code == OK) {
						showConfirm(data.data);
						return;
					}
					ext.tip.error(data.message);
				});

			} else {
				showConfirm(data.data);
				return;
			}

		});

	}
	//批报表
	function batch() {

		//获取选中行
		var rows = $("#mixworkorderedit_dg").datagrid("getSelections");
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

	//工单关闭
	function end() {
		if (getRecipecodelist() == "" || getRecipecodelist() == null) {
			return;
		}

		$.messager.confirm("关闭确认", "确认关闭所选工单?", function(r) {
			if (r) {

				ext.ajax.post("mix/productionplan/mixworkorderedit/end", {
					recipecodelist : getRecipecodelist().toString()
				}, function(data) {
					if (data.code == OK) {
						showConfirm(data.data);
						return;
					}
					ext.tip.error(data.message);
				});

			}
		});
	}

	//显示操作结果
	function showConfirm(msg) {
		$.messager.confirm({
			width : 700,
			height : 350,
			title : '提示',
			msg : msg,
			fn : function(r) {
			}
		});
	}
	//上移
	function upward() {
		var rows = $("#mixworkorderedit_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].atr_key);
		}

		ext.ajax.post("mix/productionplan/mixworkorderedit/upward", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//下移
	function down() {
		var rows = $("#mixworkorderedit_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].atr_key);
		}

		ext.ajax.post("mix/productionplan/mixworkorderedit/down", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	function cancel() {
		$("#mixworkorderedit_dg").datagrid("rejectChanges");
	}

	//硫磺计划

	//表格加载前事件
	function dlg1BeforeLoad1(param) {
		if ($("#wo_date_slh").datebox("getValue") == "") {
			return false;
		}

		param["filter[wo_date_s]"] = $("#wo_date_slh").datebox("getValue");
		param["filter[wo_type_s]"] = '051002';
	}
	/**
	 * 查询方法
	 */
	var filter1 = function() {
		ext.easyui.grid.search("mixworkorderedit_dg2",
				"MixWorkOrderEdit_search_form2");
	}

	/**
	 *将数据库得值转换为数据字典与对应值域
	 */
	function codeFormatter1(v, r, i) {

		return dictFormat(v);
	}

	function add1() {
		ext.easyui.grid.appendAndEdit("mixworkorderedit_dg2", {});
	}

	function edit1() {
		var rows = $("#mixworkorderedit_dg2").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixworkorderedit_dg2").datagrid("getRowIndex", rows[i]);
			$("#mixworkorderedit_dg2").datagrid("beginEdit", index);
		}
	}

	function remove1() {

		var rows = $("#mixworkorderedit_dg2").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixworkorderedit_dg2").datagrid("getRowIndex", rows[i]);
			$("#mixworkorderedit_dg2").datagrid("deleteRow", index);
		}

	}

	function save1() {
		var dg = $("#mixworkorderedit_dg2");

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
			$("#mixworkorderedit_dg2").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	function cancel1() {
		$("#mixworkorderedit_dg2").datagrid("rejectChanges");
	}
	//小料计划

	//表格加载前事件
	function dlg1BeforeLoad2(param) {
		if ($("#wo_date_sl").datebox("getValue") == "") {
			return false;
		}

		param["filter[wo_date_s]"] = $("#wo_date_sl").datebox("getValue");
		//param["filter[wo_type_s]"] = '051001';	
	}
	/**
	 * 查询方法
	 */
	var filter2 = function() {
		ext.easyui.grid.search("mixworkorderedit_dg3",
				"MixWorkOrderEdit_search_form3");
	}

	/**
	 *将数据库得值转换为数据字典与对应值域
	 */
	function codeFormatter2(v, r, i) {

		return dictFormat(v);
	}

	function add2() {
		ext.easyui.grid.appendAndEdit("mixworkorderedit_dg3", {});
	}

	function edit2() {
		var rows = $("#mixworkorderedit_dg3").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixworkorderedit_dg3").datagrid("getRowIndex", rows[i]);
			$("#mixworkorderedit_dg3").datagrid("beginEdit", index);
		}
	}

	function remove2() {

		var rows = $("#mixworkorderedit_dg3").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixworkorderedit_dg3").datagrid("getRowIndex", rows[i]);
			$("#mixworkorderedit_dg3").datagrid("deleteRow", index);
		}

	}

	function save2() {
		var dg = $("#mixworkorderedit_dg3");

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
			$("#mixworkorderedit_dg3").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	function getDg1() {
		return $("#mixworkorderedit_dg3");
	}

	//获取选择行数据
	function getRecipecodelist1() {
		var rows = getDg1().datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn("请勾选显示区的复选框");
			return;
		}

		var recipecodelist = [];

		for (var i = 0; i < rows.length; i++) {
			recipecodelist.push(rows[i].wo_no_s);
		}
		return recipecodelist;
	}

	//获取选择行数据
	function getRecipecodelistbycheck1() {
		var rows = getDg1().datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn("请勾选显示区的复选框");
			return;
		}

		var recipecodelist = [];

		for (var i = 0; i < rows.length; i++) {

			var data = "";
			data = rows[i].wo_date_s + "|" + rows[i].wo_shift_s + "|"
					+ rows[i].equip_code_s;

			recipecodelist.push(data);
		}

		var temp = []; //一个新的临时数组
		for (var i = 0; i < recipecodelist.length; i++) {
			if (temp.indexOf(recipecodelist[i]) == -1) {
				temp.push(recipecodelist[i]);
			}
		}

		return temp;
	}

	//下发
	function downward1() {

		var off = "close";

		//校验是否设置主机手
		if (getRecipecodelistbycheck1() == ""
				|| getRecipecodelistbycheck1() == null) {
			return;
		}
		ext.ajax.post("mix/productionplan/mixworkorderedit/check", {
			recipecodelist : getRecipecodelistbycheck1().toString()
		},
				function(data) {
					if (data.data == "") {
						//下发
						if (getRecipecodelist1() == ""
								|| getRecipecodelist1() == null) {
							return;
						}
						ext.ajax.post(
								"mix/productionplan/mixworkorderedit/downward",
								{
									recipecodelist : getRecipecodelist1()
											.toString()
								}, function(data) {
									if (data.code == OK) {
										showConfirm(data.data);
										return;
									}
									ext.tip.error(data.message);
								});

					} else {
						showConfirm(data.data);
						return;
					}

				});
	}

	//批报表
	function batch1() {

		//获取选中行
		var rows = $("#mixworkorderedit_dg3").datagrid("getSelections");
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

	//主机手设置-------------------------------------------start

	//全局变量接收数据

	var wo_Date;
	var wo_Shift;
	var erpcode_s;

	//触发主机收设置页面
	function setup() {

/* 		var rows = $("#mixworkorderedit_dg").datagrid("getSelections");
		;
		if (rows.length == 0) {
			ext.tip.warn("请选择一条数据!");
			return;
		} else if (rows.length > 1) {
			ext.tip.warn("只能选中一条数据!");
			return;
		}

		wo_Date = rows[0].wo_date_s;
		wo_Shift = rows[0].wo_shift_s;
		erpcode_s= rows[0].equip_code_s; */

		$("#setup_dlg").dialog("open");
		var url = 'mix/productionplan/mixworkorderedit/setup';

		var value = $('input[name="radio"]:checked').val();
		var url = 'mix/productionplan/mixworkorderedit/setup';
		//如果查询当前用户
		if ("real_time" == value) {
			url = 'mix/productionplan/mixworkorderedit/setup';
			//如果查询全部用户
		} else if ("his_time" == value) {
			url = 'mix/productionplan/mixworkorderedit/setup2';
		}

		var opts = $("#setupdlg").datagrid("options");
		opts.url = url;
		ext.easyui.grid.search("setupdlg", "Setup_search_form");

		var url = "mix/productionplan/mixworkorderedit/geterpcode";
		ext.ajax.get(url, function(data) {
			$('#geterpcode_dg').datagrid('loadData', data);
			return;
		});
		

	}

	//触发主机收设置页面
	function setup1() {

/* 		var rows = $("#mixworkorderedit_dg3").datagrid("getSelections");
		;
		if (rows.length == 0) {
			ext.tip.warn("请选择一条数据!");
			return;
		} else if (rows.length > 1) {
			ext.tip.warn("只能选中一条数据!");
			return;
		}

		wo_Date = rows[0].wo_date_s;
		wo_Shift = rows[0].wo_shift_s; */

		$("#setup_dlg").dialog("open");
		var url = 'mix/productionplan/mixworkorderedit/setup';

		var value = $('input[name="radio"]:checked').val();
		var url = 'mix/productionplan/mixworkorderedit/setup';
		//如果查询当前用户
		if ("real_time" == value) {
			url = 'mix/productionplan/mixworkorderedit/setup';
			//如果查询全部用户
		} else if ("his_time" == value) {
			url = 'mix/productionplan/mixworkorderedit/setup2';
		}

		var opts = $("#setupdlg").datagrid("options");
		opts.url = url;
		ext.easyui.grid.search("setupdlg", "Setup_search_form");

		/* $("#setupdlg").datagrid("enableFilter"); */

		var url = "mix/productionplan/mixworkorderedit/geterpcode";
		ext.ajax.get(url, function(data) {
			$('#geterpcode_dg').datagrid('loadData', data);
			return;
		});
	}

	//调用主机手设置接口
	function set() {
		var editors = $("#setupdlg").datagrid("getSelections");
		 var rows = $("#geterpcode_dg").datagrid("getSelections"); 
		if (editors.length == 0) {
			ext.tip.warn("请选择一条用户数据!");
			return;
		}
		if (rows.length == 0) {
			ext.tip.warn("请选择一条机台数据!");
			return;
		} 

		var ids = [];
/*  		ids.push(wo_Date);
		ids.push(wo_Shift); */
		ids.push(rows[0].ERPCODE_S);
		ids.push(editors[0].created_by_s);
		ids.push(editors[0].created_name_s); 
		ids.push("set");

		ext.ajax.post("mix/productionplan/mixworkorderedit/set", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			ext.tip.warn(data.data);
			filterBySet();
			filtersetup();

		});
	}

	//单选框点击事件
	function show() {
		var value = $('input[name="radio"]:checked').val();
		if ("real_time" == value) {
			/* $('#Setup_equip_code_s').next().show();
			document.getElementById("span_id").innerHTML = "机台条码"; */
			var url = 'mix/productionplan/mixworkorderedit/setup';
			var opts = $("#setupdlg").datagrid("options");
			opts.url = url;
			ext.easyui.grid.search("setupdlg", "Setup_search_form");
		} else if ("his_time" == value) {
			/* $('#Setup_equip_code_s').next().hide();
			document.getElementById("span_id").innerHTML = ""; */
			var url = 'mix/productionplan/mixworkorderedit/setup2';
			var opts = $("#setupdlg").datagrid("options");
			opts.url = url;
			ext.easyui.grid.search("setupdlg", "Setup_search_form");
		}
	}

	/**
	 *   主机收用户设置页面查询方法
	 */
	var filtersetup = function() {

		var value = $('input[name="radio"]:checked').val();
		var url = 'mix/productionplan/mixworkorderedit/setup';
		//如果查询当前用户
		if ("real_time" == value) {
			url = 'mix/productionplan/mixworkorderedit/setup';
			//如果查询全部用户
		} else if ("his_time" == value) {
			url = 'mix/productionplan/mixworkorderedit/setup2';
		}

		var opts = $("#setupdlg").datagrid("options");
		opts.url = url;
		ext.easyui.grid.search("setupdlg", "Setup_search_form");

	}

	/**
	 *   主机手机台设置页面查询方法
	 */
	var filterBySet = function() {

		var url = "mix/productionplan/mixworkorderedit/geterpcode";
		ext.ajax.get(url, function(data) {
			$('#geterpcode_dg').datagrid('loadData', data);
			return;
		});

	}

	//主机收设置-------------------------------------------end

	//工单关闭
	function end1() {
		if (getRecipecodelist1() == "" || getRecipecodelist1() == null) {
			return;
		}

		$.messager.confirm("关闭确认", "确认关闭所选工单?", function(r) {
			if (r) {

				ext.ajax.post("mix/productionplan/mixworkorderedit/end", {
					recipecodelist : getRecipecodelist1().toString()
				}, function(data) {
					if (data.code == OK) {
						showConfirm(data.data);
						return;
					}
					ext.tip.error(data.message);
				});

			}
		});
	}
	//上移
	function upward1() {
		var rows = $("#mixworkorderedit_dg3").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].atr_key);
		}

		ext.ajax.post("mix/productionplan/mixworkorderedit/upward", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	//下移
	function down1() {
		var rows = $("#mixworkorderedit_dg3").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		var ids = [];

		for (var i = 0; i < rows.length; i++) {
			ids.push(rows[i].atr_key);
		}

		ext.ajax.post("mix/productionplan/mixworkorderedit/down", {
			ids : ids.toString()
		}, function(data) {
			if (data.code != OK) {
				ext.tip.error(data.message);
			}
			showConfirm(data.data);
			filter();
		});
	}

	function cancel2() {
		$("#mixworkorderedit_dg3").datagrid("rejectChanges");
	}

	//合并单元格
	function onLoadSuccess(data) {
		$("#mixworkorderedit_dg").datagrid("autoMergeCells", [ 'wo_shift_s' ]);
	}
	//合并单元格
	function onLoadSuccess1(data) {
		$("#mixworkorderedit_dg2").datagrid("autoMergeCells", [ 'wo_shift_s' ]);
	}
	//合并单元格
	function onLoadSuccess2(data) {
		$("#mixworkorderedit_dg3").datagrid("autoMergeCells", [ 'wo_shift_s' ]);
	}
</script>