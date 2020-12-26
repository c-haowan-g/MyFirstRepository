<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/*     var equiplist = [];
	 var process = '';
	 if(factory == 1){
	 process = '80031MX';
	 }else{
	 process = '80032MX';
	 } */
	//加载密炼机台信息
	/* 	$.ajax({
	 url : 'common/basedata/factorymodel/getProductionInfoByAreaName?areaname='+process,
	 type : 'get',
	 dataType : 'json',
	 async : false,
	 success : function(data) {
	 equiplist = data;
	 }
	 }); */
	//胶料机台名称转换
	/*     function equipcodeformatter1(v,r,i){
	 for(var i=0;i<equiplist.length;i++){
	 if(v==equiplist[i].p_line_name){
	 return equiplist[i].description;
	 }
	 }  
	 } ; */
	//接收物料数据
	/* var materialCodeList = [];
	$.ajax({
		url:"common/plm/mixrecipeedit/mixJLMaterialList",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			materialCodeList=data;
		}
	}); */

	var DICT_052 = [];
	$.ajax({
		url : "dict/code/052",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			DICT_052 = data;
		}
	});
	//基础数据text显示
	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
	//审核状态
	function checkStatusFormatter(v, r, i) {
		if (v == 0) {
			return '未审核';
		} else if (v == 1) {
			return '已审核';
		}
	}
	//下发状态
	function letDownFormatter(v, r, i) {
		if (v == 0) {
			return '未下发';
		} else if (v == 1) {
			return '已下发';
		}
	}
	function searchProductionLine(q, row) {
		var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
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

	var saveChanges = path + "mix/planManagement/dayPlan/saveChanges";

	function showOrHide() {
		if ($("#MixDayPlan_search_form").is(":hidden")) {
			$("#MixDayPlan_search_form").show();
		} else {
			$("#MixDayPlan_search_form").hide();
		}
	}
	var planStatusCellStyler = function(value, row, index) {
		if (value == "052002") {
			return 'background-color:#adff2f;';
		}
	};

	//胶料计划

	//获取指定行、指定列的编辑器
	function getEditor1(index, field) {
		return $("#mixdayplan_copy_dg").datagrid("getEditor", {
			index : index,
			field : field
		});
	}
	//获取数据框得值
	function getNumberSpinnerValue1(index, field) {
		return parseInt($(getEditor1(index, field).target).numberspinner(
				"getValue")) || 0;
	}
	//计划量联动
	function onCountChange1(nv, ov) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var zaocount = getNumberSpinnerValue1(index, "qty_mor_i");
		var zhongcount = getNumberSpinnerValue1(index, "qty_mid_i");
		var wancount = getNumberSpinnerValue1(index, "qty_nig_i");
		var dayCount = zaocount + zhongcount + wancount;
		if (dayCount == 0) {
			ext.tip.error("计划总数不能为0");
			return;
		}
		$(getEditor1(index, "qty_plan_i").target).textbox("setValue", dayCount);
	}
	//抽检量联动
	function onCheckCountChange1(nv, ov) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var zaocount = getNumberSpinnerValue1(index, "qty_check_mor_f");
		var zhongcount = getNumberSpinnerValue1(index, "qty_check_mid_f");
		var wancount = getNumberSpinnerValue1(index, "qty_check_nig_f");
		var dayCount = zaocount + zhongcount + wancount;
		if (dayCount == 0) {
			ext.tip.error("计划总数不能为0");
			return;
		}
		$(getEditor1(index, "qty_check_plan_f").target).textbox("setValue",
				dayCount);
	}
	//表格加载前事件
	function dlg1BeforeLoad(param) {
		if ($("#datebox_to").datebox("getValue") == "") {
			return false;
		}
		param["filter[plan_date_s]"] = $("#datebox_to").datebox("getValue");
		param["filter[plan_type_s]"] = '051003';
	}
	//物料名称选择事件
	function onMaterialNameSelect1(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		$(getEditor1(index, "material_code_s").target).combobox("select",
				record.MATER_CODE_S);
	}
	//物料选择触发事件
	function onMaterialSelect1(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		$(getEditor1(index, "material_name_s").target).textbox("setValue",
				record.MATER_NAME_S);//物料描述
		var equipcode = $(getEditor1(index, "equip_code_s").target).textbox(
				"getValue");
		if (equipcode == "") {
			ext.tip.error("请先选择机台");
			return;
		}
		var plandate = $(getEditor1(index, "plan_date_s").target).textbox(
				"getValue");
		if (plandate == "") {
			ext.tip.error("请先选择时间");
			return;
		}
		;

		//带出生产顺序
		/* var plandate= $(getEditor1(index, "plan_date_s").target).textbox("getValue");
		if(plandate==""){
				 ext.tip.error("请先选择时间");
		    	return;
		} ;
		ext.ajax.get("mix/productionplan/mixdayplan/getMixPlanMaxSeq?equipcode="+equipcode+"&materialcode="+record.MATER_CODE_S+"&plandate="+plandate,function(data){
			    $(getEditor1(index, "spare8_s").target).textbox("setValue", data);
			}); */
		ext.ajax.get("mix/productionplan/mixdayplan/getAddInfoList?equipcode="
				+ equipcode + "&materialcode=" + record.MATER_CODE_S
				+ "&palntype=" + "051003", function(data) {
			if (data.code != OK) {
				showConfirm(data.message);
				return;
			}
			$(getEditor1(index, "mixrecipe_recipe_code_s").target).combobox(
					"loadData", data.data[0]);
			$(getEditor1(index, "quickcheck_recipe_code_s").target).combobox(
					"loadData", data.data[1]);
			$(getEditor1(index, "sip_s").target).textbox("setValue",
					data.data[2]);
			var v = $(getEditor1(index, "mixrecipe_recipe_code_s").target)
					.combobox('getData');
			//如果就一个数据的话，就直接填充值了
			if (v.length == 1) {
				var recipe_code_s = v[0].recipe_code_s;//配方名称
				$(getEditor1(index, "mixrecipe_recipe_code_s").target)
						.combobox("select", recipe_code_s);
			}
		});
	}
	//配方编号选择事件
	function onRecipeSelect1(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		$(getEditor1(index, "spare7_s").target).textbox("setValue",
				record.recipe_code_name_s);//配方名称
		$(getEditor1(index, "recipe_bom_version_s").target).textbox("setValue",
				record.b_version_s);//配方物料版本
		var dateTimeboxData = $("#datebox_to").datebox("getValue");
		var equipcode = $(getEditor1(index, "equip_code_s").target).textbox(
				"getValue");
		if (equipcode == "") {
			ext.tip.error("请先选择机台");
			return;
		}
		;
		var plandate = $(getEditor1(index, "plan_date_s").target).textbox(
				"getValue");
		if (plandate == "") {
			ext.tip.error("请先选择时间");
			return;
		}
		;
		var materialcode = $(getEditor1(index, "material_code_s").target)
				.textbox("getValue");
		if (materialcode == "") {
			ext.tip.error("请先选择物料编码");
			return;
		}
		;
		/* 	//同机台，同规格,同配方不能再做计划
			$.ajax({
			 		url:"mix/productionplan/mixdayplan/validEquipcodeExitInPlan?plandate=" + plandate+"&equipment="+equipcode+"&materialcode="+materialcode+"&recipecode="+record.recipe_code_s,
			 		type:"get",
			 		dataType:"json",
			 		async:false,
			 		success:function(data){
			 			if (data.data != true) {
			 				ext.tip.error("同一机台，同物料，同配方，只允许做一个计划");
			 				return;
						}
			 		}
			 	}); */
		ext.ajax
				.get(
						"mix/productionplan/mixdayplan/getAddInfoListByRecipecode?recipecode="
								+ record.recipe_code_s + "&productdate="
								+ dateTimeboxData,
						function(data) {
							if (data.code != OK) {
								showConfirm(data.message);
								return;
							}
							$(getEditor1(index, "plan_no_s").target).textbox(
									"setValue", data.data[0]);
							$(
									getEditor1(index,
											"quickcheck_recipe_code_s").target)
									.combobox("loadData", data.data[1]);
							$(getEditor1(index, "equip_code_s").target)
									.combobox("select", data.data[2]);
							$(getEditor1(index, "material_code_s").target)
									.combobox("select", data.data[3]);
							var v = $(
									getEditor1(index,
											"quickcheck_recipe_code_s").target)
									.combobox('getData');
							//如果就一个数据的话，就直接填充值了
							if (v.length == 1) {
								var recipe_code_s = v[0].recipe_code_s;//检查配方名称
								$(
										getEditor1(index,
												"quickcheck_recipe_code_s").target)
										.combobox("select", recipe_code_s);
							}
						});
	}
	//机台编码选择事件
	function onequipcodeselect1(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		$(getEditor1(index, "material_code_s").target).combobox("clear");
		//接收胶料物料数据
		ext.ajax.get("common/plm/mixrecipeedit/mixJLMaterialList?equipcode="
				+ record.p_line_name, function(data) {
			$(getEditor1(index, "material_code_s").target).combobox("loadData",
					data);
			var v = $(getEditor1(index, "material_code_s").target).combobox(
					'getData');
			//如果就一个数据的话，就直接填充值了
			if (v.length == 1) {
				var material_code_s = v[0].MATER_CODE_S;//
				$(getEditor1(index, "material_code_s").target).combobox(
						"select", material_code_s);
			}
			$(getEditor1(index, "material_name_s").target).combobox("loadData",
					data);
			var v2 = $(getEditor1(index, "material_name_s").target).combobox(
					'getData');
			//如果就一个数据的话，就直接填充值了
			if (v2.length == 1) {
				var material_name_s = v2[0].MATER_NAME_S;//
				$(getEditor1(index, "material_name_s").target).combobox(
						"select", material_name_s);
			}
		});
		$(getEditor1(index, "equip_name_s").target).textbox("setValue",
				record.description);//机台名称
	}
	//查询方法
	var filter = function() {
		ext.easyui.grid.search("mixdayplan_copy_dg", "MixDayPlan_search_form");
	};
	//新增方法
	function add() {
		var dateTimeboxData = $("#datebox_to").datebox("getValue");
		//新增的计划号时间用的是上方下拉框的时间
		if (dateTimeboxData == "") {
			ext.tip.error("上方下拉框请选择日期");
		}
		var date1 = dateTimeboxData;
		var date2 = new Calendar().format("yyyyMMdd");
		if (date1 < date2) {
			ext.tip.error("不能添加当前日期之前的计划");
			return;
		}
		var row = {
			plan_type_s : 051003,
			plan_date_s : dateTimeboxData,
			check_state_s : '0',
			send_state_s : '0',
			plan_status_s : '052001',
			status_mor_s : '052001',
			status_mid_s : '052001',
			status_nig_s : '052001',
			s_factory_s : factory,
			agenc_no_s : 8003
		};
		ext.easyui.grid.appendAndEdit("mixdayplan_copy_dg", row);
	}
	//编辑
	function edit() {
		var rows = $("#mixdayplan_copy_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixdayplan_copy_dg").datagrid("getRowIndex", rows[i]);
			$("#mixdayplan_copy_dg").datagrid("beginEdit", index);
		}
	}
	//删除
	function remove() {
		var rows = $("#mixdayplan_copy_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#mixdayplan_copy_dg").datagrid("getRowIndex", rows[i]);
			$("#mixdayplan_copy_dg").datagrid("deleteRow", index);
		}
	}
	function getRowByIndex(index) {
		return $("#mixdayplan_copy_dg").datagrid("getRows")[index];
	}
	/**
	 * 获取指定行、指定列的编辑器
	 */
	function getEditor(index, field) {
		return $("#mixdayplan_copy_dg").datagrid("getEditor", {
			index : index,
			field : field
		});
	}
	function getFieldValue(index, field) {
		var v = "";
		if (getEditor(index, field) == null) {
			return getRowByIndex(index)[field];
		}
		try {
			v = $(getEditor(index, field).target).combobox("getValue");
		} catch (e) {
		}
		try {
			v = $(getEditor(index, field).target).numberspinner("getValue");
		} catch (e) {
		}
		try {
			v = $(getEditor(index, field).target).textbox("getValue");
		} catch (e) {
		}
		try {
			v = $(getEditor(index, field).target).combobox("getValue");
		} catch (e) {
		}
		return v;
	}
	function getRowValues(index) {
		var cs = $("#mixdayplan_copy_dg").datagrid('getColumnFields');
		var fcs = $("#mixdayplan_copy_dg").datagrid('getColumnFields', true);
		var rows = $("#mixdayplan_copy_dg").datagrid("getRows");
		var row = rows[index];
		for (var i = 0; i < cs.length; i++) {
			if (cs[i] == "atr_key")
				continue;
			row[cs[i]] = getFieldValue(index, cs[i]);
		}
		for (var j = 0; j < fcs.length; j++) {
			if (fcs[j] == "atr_key")
				continue;
			row[fcs[j]] = getFieldValue(index, fcs[j]);
		}
		return row;
	}
	//保存
	function save() {
		var dg = $("#mixdayplan_copy_dg");
		var rows = dg.datagrid("getRows");
		if (rows.length == 0) {
			ext.tip.error("<spring:message code="tip.nosave" />");
			return;
		}
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("<spring:message code="tip.invalid" />");
				return;
			}
		}
		for (var i = 0; i < rows.length; i++) {
			dg.datagrid("endEdit", i);
		}
		var rowsSended = [];
		for (var i = 0; i < rows.length; i++) {
			rowsSended.push(getRowValues(i));
		}
		ext.ajax.sendJson(saveChanges, {
			inserted : rowsSended
		}, function(data) {
			if (data.code == OK) {
				ext.tip.suc("操作成功");
			} else {
				ext.tip.error(data.message);
			}
		});
	}

	function cancel() {
		$("#mixdayplan_copy_dg").datagrid("rejectChanges");
	}

	//复制
	function copy() {
		var fromDate = $("#datebox_from").datebox("getValue");
		var toDate = $("#datebox_to").datebox("getValue");
		// 被复制的日期计划不能为空
		// 要复制的日期不能已经安排计划
		if (fromDate == "" || fromDate == null || toDate == null
				|| toDate == "") {
			ext.tip.warn("开始或结束时间请选择完整");
			return;
		}
		var dateNow = new Calendar().format("yyyyMMdd");
		if (toDate < dateNow) {
			ext.tip.warn("不能添加当前日期之前的计划");
			return;
		}
		ext.ajax.post("mix/planManagement/dayPlan/copy", {
			"filter[plan_date_s]" : fromDate,
			plantype : '051003',
			todate : toDate,
			all : 1
		}, function(data) {
			if (data.code != OK) {
				showConfirm(data.message);
				return;
			}
			if (data.data[0].length == 0) {
				ext.tip.warn("选择的日期" + fromDate + "不存在符合条件的日计划");
				return;
			}
			$("#mixdayplan_copy_dg").datagrid("loadData", data.data[0]);
			var rows = $("#mixdayplan_copy_dg").datagrid("getRows");
			var index = -1;
			for (var i = 0; i < rows.length; i++) {
				index = $("#mixdayplan_copy_dg").datagrid("getRowIndex",
						rows[i]);
				$("#mixdayplan_copy_dg").datagrid("beginEdit", index);
			}
		});
	}
	//配方名称转换
	/*     function recipecodeformatter1(v,r,i){
	 return r.spare7_s;
	 } */
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
</script>