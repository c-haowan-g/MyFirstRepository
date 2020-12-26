<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "curing/productionPlan/dailyPlan/saveChanges";

	var action = "";

	var code = "LHRJH";

	var jtxx = [];

	var editingIndex = -1;

	function dg() {
		return $("#productiondayplan_dg");
	}
	//根据胎胚条码查询规格信息
	function specFormatter1(value,row,index){
		var spec="";
		  $.ajax({
		 		url:"Part/searchByMaterialCode?partNumber="+row.specification_left_s,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			spec= data.MatDescFull;
		 		}
		 	});
		  var lastIndex=spec.lastIndexOf(' ');
		  spec= spec.substring(lastIndex+1);
		  return spec;
	}
	//根据胎胚条码查询规格信息
	function specFormatter2(value,row,index){
		var spec="";
		  $.ajax({
		 		url:"Part/searchByMaterialCode?partNumber="+row.specification_right_s,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			spec= data.MatDescFull;
		 		}
		 	});	
		  var lastIndex=spec.lastIndexOf(' ');
		  spec= spec.substring(lastIndex+1);
		  return spec;
	}

	function editOrder(index) {
		var value = $(
				"[datagrid-row-index=" + index + "] [field=plan_queue_s] div")
				.text();
		var input = "<input id='plan_queue_s"
				+ index
				+ "' type='text' style='width:100%;' class='easyui-numberspinner' value='"
				+ value + "' >";
		$("[datagrid-row-index=" + index + "] [field=plan_queue_s] div")
				.empty();
		$("[datagrid-row-index=" + index + "] [field=plan_queue_s] div")
				.append(input);
		$("#plan_queue_s" + index).numberspinner({
			min : 1,
			max : 99
		});
	}

	function setOrder() {

		$.messager.confirm('<spring:message code="tip.cancelEdit" />',
				'<spring:message code="tip.cancelEdit" />?', function(r) {
					if (r) {

						$("[disable=true]").linkbutton("disable");
						$("[disable=false]").linkbutton("enable");
						dg().datagrid("rejectChanges");
						var total = dg().datagrid("getRows").length;
						for (var i = 0; i < total; i++) {
							editOrder(i);
						}
					}
				});

	}
    //保存日计划
	function saveOrder() {

		var ids = [];

		var sorts = {};
		var rows = $("#productiondayplan_dg").datagrid("getRows");

		Utils.each(rows,
						function(i, r) {
							if ($("#plan_queue_s" + i)
									.numberspinner("getValue") != "") {
								sorts[$("#plan_queue_s" + i).numberspinner(
										"getValue")] = r.atr_key;
							}
						});

		for (var i = 0; i < rows.length; i++) {

			if (!sorts[i + 1]) {
				ext.tip.warn("<spring:message code="tip.noSortNumber" />:"
						+ (i + 1));
				return;
			}
			ids.push(sorts[i + 1]);
		}

		ext.ajax.get("curing/productionPlan/dailyPlan/sort?ids=" + ids.join(","), function(data) {
			if (data.code == OK) {
				$("[disable=true]").linkbutton("enable");
				$("[disable=false]").linkbutton("disable");
				ext.tip.suc(); 
				filter();
				parent.filter();
				return;
			}else{
				ext.tip.error();
			}
		});

	}

	$(function() {

		var date = parent.$("#production_date_s").datebox("getValue");
		var line = parent.$("#production_line_s").combobox("getValue");

		var row = parent.$("#productiondayplan_dg").datagrid("getChecked");

		if (date != "") {
			$("#production_date_s").datebox("setValue", date);
		}

		if (line != "") {
			$("#production_line_s").combobox("setValue", line);
		}

		if (row.length != 0) {
			$("#production_date_s").datebox("setValue",
					row[0].production_date_s);
			$("#production_line_s").combobox("setValue",
					row[0].production_line_s);
		}

	});

	function onBeginEdit(index, row) {
		editingIndex = index;
	}

	function onEndEdit(index, row) {
		editingIndex = -1;
	}

	//加载产线信息
	$.ajax({
		url : 'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			jtxx = data;
		}
	});

	function onLoadSuccess(data) {
		editingIndex = -1;
	}

	function onDgBeforeLoad(param) {
		if ($("#production_date_s").datebox("getValue") == "") {
			return false;
		}
		if ($("#production_line_s").combobox("getValue") == "") {
			return false;
		}
		param["filter[production_date_s]"] = $("#production_date_s").datebox(
				"getValue");
		param["filter[production_line_s]"] = $("#production_line_s").combobox(
				"getValue");
	}

	function showOrHide() {
		if ($("#ProductionDayPlan_search_form").is(":hidden")) {
			$("#ProductionDayPlan_search_form").show();
		} else {
			$("#ProductionDayPlan_search_form").hide();
		}
	}

	/**
	 * 选择完日期，加载序列号
	 */
	function onDateSelect(date) {

		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");

		var ed = $("#productiondayplan_dg").datagrid('getEditor', {
			index : index,
			field : "plan_no_s"
		});
		getSerialByDate(code, new Calendar(date).format("yyyyMMdd"), function(
				data) {
			var fields = [ "production_line_s", "plan_queue_s",
					"equip_code_left_s", "equip_code_right_s",
					"material_code_left_s", "material_code_right_s",
					"material_desc_left_s", "material_desc_right_s",
					/* "productionver_left_s",
					"productionver_right_s", */
					"production_step_left_s", "production_step_right_s",
					"specification_left_s", "specification_right_s",
					"childbom_ver_left_s", "childbom_ver_right_s","processbom_index_build_s",
					"processbom_index_curing_s", "planamount_mor_left_i",
					"planamount_mor_right_i", "planamount_mid_left_i",
					"planamount_mid_right_i", "planamount_nig_left_i",
					"planamount_nig_right_i", "quantity_dayplan_left_i",
					"quantity_dayplan_right_i", "reason_midclass_left_s",
					"reason_midclass_right_s", "reason_morclass_left_s",
					"reason_morclass_right_s", "reason_nigclass_left_s",
					"reason_nigclass_right_s", "memo_left_s", "memo_right_s" ];
			for ( var k in fields) {
				//clearFieldValue(index, fields[k]);
			}
			$(ed.target).textbox("setValue", data.data);
			loadYesterdayPlan(index);
		});
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
	 * 加载昨天的计划，
	 * 触发条件：产线或者计划日期发生变化，且二者都不为空
	 */
	function loadYesterdayPlan(index, lineCode) {
		var dateEditor = $("#productiondayplan_dg").datagrid('getEditor', {
			index : index,
			field : "production_date_s"
		});
		var lineCodeEditor = $("#productiondayplan_dg").datagrid('getEditor', {
			index : index,
			field : "production_line_s"
		});

		var dateValue = $(dateEditor.target).textbox("getValue");
		var codeValue = $(lineCodeEditor.target).textbox("getValue");

		if (lineCode) {
			codeValue = lineCode;
		}

		if (dateValue == "" || codeValue == "") {
			return;
		}
		var date = new Date(dateValue.substring(0, 4), parseInt(dateValue
				.substring(4, 6)) - 1, dateValue.substring(6, 8));
		var cal = new Calendar(date);
		cal.add(Calendar.field.DAY_OF_MONTH, -1);

		//加载昨日计划
		ext.ajax.get("curing/productionPlan/dailyPlan/daily/" + cal.format("yyyyMMdd") + "/"
				+ codeValue, function(data) {
			setFieldValue(index, "plan_queue_s", $("#productiondayplan_dg")
					.datagrid("getRows").length);
			setFieldValue(index, "planamount_mor_left_i", 0);
			setFieldValue(index, "planamount_mid_left_i", 0);
			setFieldValue(index, "planamount_nig_left_i", 0);
			if (data.data.lastPlan == null) {
				// 找不到昨日的日计划，这里要从后台查询左右摸条码，用户去完善计划其他信息
				ext.ajax.get("curing/productionPlan/dailyPlan/machines/" + codeValue, function(
						machines) {
					if (machines.data == null || machines.data.length == 0) {
						return;
					}
					var ms = machines.data;
					for (var i = 0; i < ms.length; i++) {
						if (ms[i].equip_code_s.replace(codeValue, "") == "L") {
							$(getEditor(index, "equip_code_left_s").target)
									.textbox("setValue", ms[i].equip_code_s);
						} else {
							$(getEditor(index, "equip_code_right_s").target)
									.textbox("setValue", ms[i].equip_code_s);
						}
					}

				});
				return;
			} else {
				var plan = data.data.lastPlan;
				//如果昨天的左右模条码一致，则报错
				if(plan.equip_code_left_s==plan.equip_code_right_s){
				    ext.tip.error(codeValue+'机台的前日计划左右模条码一样，不允许添加');
				    editingIndex = -1;
	            	$("#productiondayplan_dg").datagrid("rejectChanges");
			        return;
				}
				setFieldValue(index, "equip_code_left_s",
						plan.equip_code_left_s);
				setFieldValue(index, "equip_code_right_s",
						plan.equip_code_right_s);
				setFieldValue(index, "material_code_left_s",
						plan.material_code_left_s);
				setFieldValue(index, "material_code_right_s",
						plan.material_code_right_s);
				setFieldValue(index, "material_desc_left_s",
						plan.material_desc_left_s);
				setFieldValue(index, "material_desc_right_s",
						plan.material_desc_right_s);
				/* setFieldValue(index, "productionver_left_s", plan.productionver_left_s);
				setFieldValue(index, "productionver_right_s", plan.productionver_right_s); */
				setFieldValue(index, "production_step_left_s",
						plan.production_step_left_s);
				setFieldValue(index, "production_step_right_s",
						plan.production_step_right_s);
				setFieldValue(index, "specification_left_s",
						plan.specification_left_s);
				setFieldValue(index, "specification_right_s",
						plan.specification_right_s);
				setFieldValue(index, "childbom_ver_left_s",
						plan.childbom_ver_left_s);
				setFieldValue(index, "childbom_ver_right_s",
						plan.childbom_ver_right_s);
				setFieldValue(index, "processbom_index_build_s",
						plan.processbom_index_build_s);
				setFieldValue(index, "processbom_index_curing_s",
						plan.processbom_index_curing_s);
				setFieldValue(index, "planamount_mor_left_i",
						plan.planamount_mor_left_i);
				setFieldValue(index, "planamount_mor_right_i",
						plan.planamount_mor_right_i);
				setFieldValue(index, "planamount_mid_left_i",
						plan.planamount_mid_left_i);
				setFieldValue(index, "planamount_mid_right_i",
						plan.planamount_mid_right_i);
				setFieldValue(index, "planamount_nig_left_i",
						plan.planamount_nig_left_i);
				setFieldValue(index, "planamount_nig_right_i",
						plan.planamount_nig_right_i);
				setFieldValue(index, "quantity_dayplan_left_i",
						plan.quantity_dayplan_left_i);
				setFieldValue(index, "quantity_dayplan_right_i",
						plan.quantity_dayplan_right_i);
				setFieldValue(index, "reason_midclass_left_s",
						plan.reason_midclass_left_s);
				setFieldValue(index, "reason_midclass_right_s",
						plan.reason_midclass_right_s);
				setFieldValue(index, "reason_morclass_left_s",
						plan.reason_morclass_left_s);
				setFieldValue(index, "reason_morclass_right_s",
						plan.reason_morclass_right_s);
				setFieldValue(index, "reason_nigclass_left_s",
						plan.reason_nigclass_left_s);
				setFieldValue(index, "reason_nigclass_right_s",
						plan.reason_nigclass_right_s);
				setFieldValue(index, "memo_left_s", plan.memo_left_s);
				setFieldValue(index, "memo_right_s", plan.memo_right_s);
			}
		});
	}

	function materialClear_left() {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var zao_right = getNumberSpinnerValue(index, "planamount_mor_right_i");
		var zhong_right = getNumberSpinnerValue(index, "planamount_mid_right_i");
		var wan_right = getNumberSpinnerValue(index, "planamount_nig_right_i");

		setFieldValue(index, "planamount_mor_left_i", 0);
		setFieldValue(index, "planamount_mid_left_i", 0);
		setFieldValue(index, "planamount_nig_left_i", 0);

		setFieldValue(index, "planamount_mor_right_i", zao_right);
		setFieldValue(index, "planamount_mid_right_i", zhong_right);
		setFieldValue(index, "planamount_nig_right_i", wan_right);

	}

	function materialClear_right() {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		setFieldValue(index, "planamount_mor_left_i", 0);
		setFieldValue(index, "planamount_mid_left_i", 0);
		setFieldValue(index, "planamount_nig_left_i", 0);

		setFieldValue(index, "planamount_mor_right_i", 0);
		setFieldValue(index, "planamount_mid_right_i", 0);
		setFieldValue(index, "planamount_nig_right_i", 0);
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("productiondayplan_dg",
				"ProductionDayPlan_search_form");
	}

	function add() {
		if (editingIndex != -1) {
			ext.tip.warn("请先保存");
			return;
		}
		action = "ADD";
		var lineCode = $("#production_line_s").combobox("getValue");
		if (lineCode == "") {
			ext.tip.warn("<spring:message code="tip.selectLineCode" />");
			return;
		}
		var tomorrow = $("#production_date_s").datebox("getValue");
		getSerialByDate(code, tomorrow, function(data) {
			ext.easyui.grid.appendAndEdit("productiondayplan_dg", {
				production_date_s : tomorrow,
				plan_no_s : data.data,
				production_line_s : lineCode
			});
			loadYesterdayPlan(0, $("#production_line_s").combobox("getValue"));
		});

	}

	function edit() {
		if (editingIndex != -1) {
			ext.tip.warn("请先保存");
			return;
		}
		var rows = $("#productiondayplan_dg").datagrid("getSelections");
		var index = -1;
		action = "EDIT";
		for (var i = 0; i < rows.length; i++) {
			index = $("#productiondayplan_dg").datagrid("getRowIndex", rows[i]);
			if (rows[i].status_s != '218001') {
				ext.tip
						.warn("<spring:message code="tip.forbiddenDeleteOrEdit" />");
				break;
			}
			$("#productiondayplan_dg").datagrid("beginEdit", index);
		}
	}

	
	function remove() {
		var rows = $("#productiondayplan_dg").datagrid("getChecked");
		if (rows.length == 0) {
			ext.tip.warn(tipSelectAtLeastOne);
			return;
		}

		$.messager.confirm('<spring:message code="tip.confirmDelete" />',
				'<spring:message code="tip.confirmDelete" />?', function(r) {
					if (r) {
						var deletedRow = rows[0];
						if (!deletedRow.atr_key) {
							$("#productiondayplan_dg").datagrid(
									"deleteRow",
									$("#productiondayplan_dg").datagrid(
											"getRowIndex", deletedRow));
							return;
						}
						ext.ajax.get("curing/productionPlan/dailyPlan/delete2?ids="
								+ deletedRow.atr_key, function(data) {
							if (data.code == OK) {
								ext.tip.suc();
								filter();
								return;
							} else {
								ext.tip.error(data.message);
							}
						});
					}
				});

	}

	/**
	 * 获取指定行、指定列的编辑器
	 */
	function getEditor(index, field) {
		return $("#productiondayplan_dg").datagrid("getEditor", {
			index : index,
			field : field
		});
	}

	/**
	 * 物料编码加载前
	 */
	function onMaterialBeforeLoad(param) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var row = $("#productiondayplan_dg").datagrid("getRows")[index];
		param.date = row.production_date_s + " "
				+ new Calendar().format("HH:mm:ss");
	}

	/**
	 * 左模物料编码选择事件
	 */
	function onMaterialSelect_left(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		//选择左模，之后要情况的列值
		var fields = [
		/* "productionver_left_s",
		"productionver_right_s", */
		"production_step_left_s", "production_step_right_s",
				"specification_left_s", "specification_right_s",
				"childbom_ver_left_s", "childbom_ver_right_s","processbom_index_build_s",
				"processbom_index_curing_s", "planamount_mor_left_i",
				"planamount_mor_right_i", "planamount_mid_left_i",
				"planamount_mid_right_i", "planamount_nig_left_i",
				"planamount_nig_right_i", "quantity_dayplan_left_i",
				"quantity_dayplan_right_i", "reason_midclass_left_s",
				"reason_midclass_right_s", "reason_morclass_left_s",
				"reason_morclass_right_s", "reason_nigclass_left_s",
				"reason_nigclass_right_s", "memo_left_s", "memo_right_s" ];

		for ( var k in fields) {
			clearFieldValue(index, fields[k]);
		}

		ext.ajax
				.get(
						"curing/productionPlan/dailyPlan/greenTire?code=" + record.MATERIAL_CODE_S,
						function(data) {
							if (data.data.length == 0) {
								ext.tip.warn("<spring:message code="tip.incompleteMaterialInfo" />");
								return;
							}

							$(getEditor(index, "specification_left_s").target)
									.combobox("loadData", data.data);
							$(getEditor(index, "specification_right_s").target)
									.combobox("loadData", data.data);
							
							$(getEditor(index, "production_step_left_s").target)
                            .combobox("loadData", data.data);
						    $(getEditor(index, "production_step_right_s").target)
                            .combobox("loadData", data.data);
						    $(getEditor(index, "material_code_right_s").target)
							.textbox("setValue", record.MATERIAL_CODE_S);
							$(getEditor(index, "material_desc_right_s").target)
									.textbox("setValue", record.MATERIAL_NAME_S);
							$(getEditor(index, "material_desc_left_s").target)
									.textbox("setValue", record.MATERIAL_NAME_S);//
							
							if (data.data.length == 1) {
								$(getEditor(index,"specification_left_s").target)
										.combobox("select",data.data[0].specification_left_s);
								$(getEditor(index,"specification_right_s").target)
										.combobox("select",data.data[0].specification_right_s);
							}else if(data.data.length>1){
								debugger
								for(var i=0;i<data.data.length;i++){
									//产品阶段默认带出顺序：投产03》试产02》试制01
									console.log(data.data[i].production_step_left_s)
									if(data.data[i].production_step_left_s=="03"){
										$(getEditor(index,"specification_left_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_right_s);
										debugger
										return;
									}
									
								}
								for(var i=0;i<data.data.length;i++){
									 if(data.data[i].production_step_left_s=="02"){
										$(getEditor(index,"specification_left_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_right_s);
										return;
									} 
								}
								for(var i=0;i<data.data.length;i++){
									 if(data.data[i].production_step_left_s=="01"){
										$(getEditor(index,"specification_left_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_right_s);
										return;
									}
								}
							}
							//map.put("productionver_left_s", costCollector(code));
							//map.put("productionver_right_s", costCollector(code));

							/* $(getEditor(index, "productionver_left_s").target).textbox("setValue",data.data[0].productionver_left_s);
							$(getEditor(index, "productionver_right_s").target).textbox("setValue",data.data[0].productionver_right_s); */

							
						});

	}
	/**
	*右模物料编码选择事件
	*/
function onMaterialSelect_right(record) {
		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");

		var fields = [ 	"productionver_right_s", 
						"production_step_right_s",
						"specification_right_s", 
						"childbom_ver_right_s",
						"reason_midclass_right_s",
						"reason_morclass_right_s", 
						"reason_nigclass_right_s",
						"memo_right_s",
						"planamount_mor_right_i",
						"planamount_mid_right_i",
						"planamount_nig_right_i",
						"quantity_dayplan_right_i",
						];

		for ( var k in fields) {
			clearFieldValue(index, fields[k]);
		}
		ext.ajax.get("curing/productionPlan/dailyPlan/greenTire?code=" + record.MATERIAL_CODE_S,
				function(data) {
					if (data.data.length == 0) {
								ext.tip.warn("<spring:message code="tip.incompleteMaterialInfo" />");
								return;
							}
					 $(getEditor(index, "specification_right_s").target).combobox("loadData", data.data);
		             $(getEditor(index, "production_step_right_s").target).combobox("loadData", data.data);
		
		
		             $(getEditor(index, "material_code_right_s").target)
		                     .textbox("setValue", record.MATERIAL_CODE_S);
		             $(getEditor(index, "material_desc_right_s").target)
		                     .textbox("setValue", record.MATERIAL_NAME_S);
		             if (data.data.length == 1) {
							$(getEditor(index,"specification_right_s").target)
									.combobox("select",data.data[0].specification_right_s);
						}
						else if(data.data.length>1){
								debugger
								for(var i=0;i<data.data.length;i++){
									//产品阶段默认带出顺序：投产03》试产02》试制01
									console.log(data.data[i].production_step_left_s)
									if(data.data[i].production_step_left_s=="03"){
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
										
										debugger
										return;
									}
									
								}
								for(var i=0;i<data.data.length;i++){
									 if(data.data[i].production_step_left_s=="02"){
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
										
										return;
									} 
								}
								for(var i=0;i<data.data.length;i++){
									 if(data.data[i].production_step_left_s=="01"){
										$(getEditor(index,"specification_right_s").target)
										 .combobox("setValue",data.data[i].specification_left_s);
									
										return;
									}
								}
							}
				});
	}
	/**
	 * 清空指定行指定列的值
	 */
	function clearFieldValue(index, field) {
		if (action == "EDIT") {
			return;
		}
		try {
			$(getEditor(index, field).target).combobox("clear")
		} catch (e) {
		}
		try {
			$(getEditor(index, field).target).numberspinner("clear")
		} catch (e) {
		}
		try {
			$(getEditor(index, field).target).textbox("clear")
		} catch (e) {
		}
		try {
			$(getEditor(index, field).target).combobox("clear")
		} catch (e) {
		}

	}

	function onMaterialChage_left(nv, ov) {
		if(ov!=""){
			if(nv.length==9){
			ext.ajax.get(
					"curing/productionPlan/dailyPlan/greenTire?code=" + nv,
					function(data) {
						if (data.data.length == 0) {
							ext.tip.warn("<spring:message code="tip.incompleteMaterialInfo" />");
							return;
						}
						/* if(data.data.length>1){
							debugger
							$(getEditor(0, "specification_left_s").target).combobox("clear");
							$(getEditor(0, "specification_right_s").target).combobox("clear");
							$(getEditor(0, "spec_right_s").target).textbox("clear");
							$(getEditor(0, "spec_left_s").target).textbox("clear");
						} */
					});
			}
		}
		if (nv == "") {
			var index = $(this).parents("[datagrid-row-index]").attr(
			"datagrid-row-index");
			var fields = [ "material_code_right_s", "material_desc_left_s",
					"material_desc_right_s",
					/* "productionver_left_s",
					"productionver_right_s", */
					"production_step_left_s", "production_step_right_s",
					"specification_left_s", "specification_right_s",
					"childbom_ver_left_s", "childbom_ver_right_s","processbom_index_build_s",
					"processbom_index_curing_s", "planamount_mor_left_i",
					"planamount_mor_right_i", "planamount_mid_left_i",
					"planamount_mid_right_i", "planamount_nig_left_i",
					"planamount_nig_right_i", "quantity_dayplan_left_i",
					"quantity_dayplan_right_i", "reason_midclass_left_s",
					"reason_midclass_right_s", "reason_morclass_left_s",
					"reason_morclass_right_s", "reason_nigclass_left_s",
					"reason_nigclass_right_s", "memo_left_s", "memo_right_s" ];

			for ( var k in fields) {
				clearFieldValue(index, fields[k]);
			}
		}
	}

	function onMaterialChage_right(nv, ov) {
		if (nv == "") {
			var fields = [ "material_desc_right_s", "productionver_right_s",
					"production_step_right_s", "specification_right_s",
					"childbom_ver_right_s", "planamount_mor_right_i",
					"planamount_mid_right_i", "planamount_nig_right_i",
					"quantity_dayplan_right_i", "reason_midclass_right_s",
					"reason_morclass_right_s", "reason_nigclass_right_s",
					"memo_right_s" ];

			for ( var k in fields) {
				clearFieldValue(index, fields[k]);
			}
		}
	}

	

	function onStageSelect_left(record) {
		debugger
		var index = $(this).parents("[datagrid-row-index]").attr(
		"datagrid-row-index");
		var specification_left_s=record.specification_left_s.substring(0,9);
		  $.ajax({
		 		url:"Part/searchByMaterialCode?partNumber="+specification_left_s,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			var spec=data.MatDescFull;
		 			var lastIndex=spec.lastIndexOf(' ');
		 			  spec= spec.substring(lastIndex+1);
		 			$(getEditor(index, "spec_left_s").target).textbox("setValue",spec);
		 		}
		 	});
		var m1=getFieldValue(index, "material_code_left_s"),m2=getFieldValue(index, "material_code_right_s");
		$(getEditor(index, "production_step_left_s").target).combobox("setValue",
                record.production_step_left_s);
		$(getEditor(index, "childbom_ver_left_s").target).textbox("setValue",
                record.childbom_ver_left_s);
		$(getEditor(index, "processbom_index_build_s").target).textbox(
                "setValue", record.processbom_index_build_s);
		$(getEditor(index, "processbom_index_curing_s").target).textbox(
                "setValue", record.processbom_index_curing_s);
		
		if(m1!=m2){
			return;
		}
		
		
		$(getEditor(index, "specification_right_s").target).combobox(
				"setValue", record.specification_left_s);
		
		$(getEditor(index, "specification_right_s").target).combobox(
				"setValue", record.specification_right_s);

		
		
		$(getEditor(index, "production_step_right_s").target).combobox("setValue",
				record.production_step_right_s);
		
		$(getEditor(index, "childbom_ver_right_s").target).textbox("setValue",
                record.childbom_ver_right_s);
		
		
	}

	function onStageSelect_right(record) {

		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");
		var specification_right_s=record.specification_right_s.substring(0,9);
		  $.ajax({
		 		url:"Part/searchByMaterialCode?partNumber="+specification_right_s,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			var spec=data.MatDescFull;
		 			var lastIndex=spec.lastIndexOf(' ');
		 			  spec= spec.substring(lastIndex+1);
		 			$(getEditor(index, "spec_right_s").target).textbox("setValue",
		 					spec);
		 		}
		 	});
		
		
		var m1=getFieldValue(index, "material_code_left_s"),
		m2=getFieldValue(index, "material_code_right_s");
		$(getEditor(index, "production_step_right_s").target).combobox("setValue",
                record.production_step_right_s);
		$(getEditor(index, "childbom_ver_right_s").target).textbox("setValue",
                record.childbom_ver_right_s);
		$(getEditor(index, "spare8_s").target).textbox(
                "setValue", record.processbom_index_build_s);
		$(getEditor(index, "spare10_s").target).textbox(
                "setValue", record.processbom_index_curing_s);
		
		if(m1!=m2){
			return;
		}
		
		
		$(getEditor(index, "specification_right_s").target).combobox(
				"setValue", record.specification_left_s);
		
		$(getEditor(index, "specification_right_s").target).combobox(
				"setValue", record.specification_right_s);

		
		
	
		
		
        $(getEditor(index, "production_step_right_s").target).combobox("setValue",
                record.production_step_right_s);
        
        $(getEditor(index, "childbom_ver_right_s").target).textbox("setValue",
                record.childbom_ver_right_s);
        
	}

	/**
	 * 计划量联动
	 */
	function onCountChange(nv, ov) {

		var index = $(this).parents("[datagrid-row-index]").attr(
				"datagrid-row-index");

		var field = $(this).parents("td[field]").attr("field");

		if (field.indexOf("left") != -1) {
			$(getEditor(index, field.replace("left", "right")).target)
					.numberspinner("setValue", nv);
		}

		var zao_left = getNumberSpinnerValue(index, "planamount_mor_left_i");
		var zhong_left = getNumberSpinnerValue(index, "planamount_mid_left_i");
		var wan_left = getNumberSpinnerValue(index, "planamount_nig_left_i");
		var leftCount = zao_left + zhong_left + wan_left;

		var zao_right = getNumberSpinnerValue(index, "planamount_mor_right_i");
		var zhong_right = getNumberSpinnerValue(index, "planamount_mid_right_i");
		var wan_right = getNumberSpinnerValue(index, "planamount_nig_right_i");

		var rightCount = zao_right + zhong_right + wan_right;

		$(getEditor(index, "quantity_dayplan_left_i").target).textbox(
				"setValue", leftCount);
		$(getEditor(index, "quantity_dayplan_right_i").target).textbox(
				"setValue", rightCount);

	}

	function getNumberSpinnerValue(index, field) {
		return parseInt($(getEditor(index, field).target).numberspinner(
				"getValue")) || 0;
	}

	function onEndEdit(index, row) {
		editingIndex = -1;
	}

	function getRowByIndex(index) {
		return $("#productiondayplan_dg").datagrid("getRows")[index];
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

	function save() {

		if (editingIndex == -1) {
			return;
		}

		/* 
		1. 同一天，分机台的顺序号不能重复
		2. 同一天，统机台，物料编码不能重复（是否区分左右摸）  不区分
		                                                    左模：A,右：B
		                                                    左：B，右：A
		3. 校验左右摸月计划量
		 */

		var dg = $("#productiondayplan_dg");

		var rows = dg.datagrid("getRows");

		//数据有效性校验
		if (!dg.datagrid("validateRow", editingIndex)) {
			ext.tip.error("<spring:message code="tip.invalid" />");
			return;
		}

		//顺序号校验,左右摸校验
		//var queue={},material_left={},material_right={};
		var order = getFieldValue(editingIndex, "plan_queue_s");
		var mtcode_left = getFieldValue(editingIndex, "material_code_left_s");//左物料编码
		var mtcode_right = getFieldValue(editingIndex, "material_code_right_s");//右物料编码
		var spec_left = getFieldValue(editingIndex, "specification_left_s");//左胎胚编码
		spec_left=spec_left.substring(0,9);
		var spec_right = getFieldValue(editingIndex, "specification_right_s");//右胎胚编码
		spec_right=spec_right.substring(0,9);
		var prostep_left=getFieldValue(editingIndex, "production_step_left_s");//左产品阶段
		var prostep_right=getFieldValue(editingIndex, "production_step_right_s");//右产品阶段
		var prostatus_s=getFieldValue(editingIndex, "status_s");//计划状态
		
		//校验左右日计划量，不允许同时为空，允许某个为空
		if(getFieldValue(editingIndex, "quantity_dayplan_left_i")==0&&getFieldValue(editingIndex, "quantity_dayplan_right_i")==0){
			ext.tip.warn("日计划左右机台数量不能同时为0");
			return;
		}
		
		
		for (var i = 0; i < rows.length; i++) {

			if (editingIndex == i) {
				continue;
			}
			

			if (order == rows[i].plan_queue_s) {
				ext.tip.warn("顺序号重复");
				return;
			}
			
			//判断物料编码-->胎胚编码-->产品阶段
			//左物料
			if (mtcode_left == rows[i].material_code_left_s) {
				//右物料
				if(mtcode_right == rows[i].material_code_right_s){
					//左胎胚编码
					if(spec_left==rows[i].specification_left_s){
						//右胎胚编码
						if(spec_right==rows[i].specification_right_s){
							//左阶段
							if(prostep_left==rows[i].production_step_left_s){
								//右阶段
								if(prostep_right==rows[i].production_step_right_s){
								//计划状态
								 if(rows[i].status_s!='218004'){
								    ext.tip.warn("当前机台，其他的->同规格物料计划状态必须均为“已关闭”状态才可添加");
									return;
								 }
								}
							}
						}
					}
				}
			}
		}

		var row = getRowValues(editingIndex);
		
		 var isParameterTestValue="0";//"0"不是试验胎参数，"1"是试验胎参数
		 $.ajax({
		 		url:"curing/productionPlan/dailyPlan/validparameteristest?productdate=" + row.production_date_s
		 		+"&equipcode="+row.production_line_s
		 		+"&materialcode="+row.material_code_left_s,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
						  if(data.data=="1"){
						      $.messager.defaults = { ok: "是", cancel: "否" };
						      $.messager.confirm("操作提示", "<font color=ff0000>"+"前一日为试验胎参数，是否下发前一日的试验胎参数？", function (data) {
          	 				  if (data) {
            	                  isParameterTestValue="1"; 
        		  		 	  }else{
        		  		 	      isParameterTestValue="0"; 
        		  		 	  }
        		  		 	  row.reason_midclass_left_s=isParameterTestValue;
							/* dg.datagrid("endEdit", editingIndex); */

							ext.ajax.post("curing/productionPlan/dailyPlan/save", row, function(data) {
									if (data.code == OK) {
										dg.datagrid("endEdit", editingIndex);
											ext.tip.suc();
										filter();
										parent.filter();
										return;
										} else {
										ext.tip.error(data.message);
									}
								});
   				   		  });  
		 		    }else{
		 		  			  row.reason_midclass_left_s=isParameterTestValue;
							/* dg.datagrid("endEdit", editingIndex); */

								ext.ajax.post("curing/productionPlan/dailyPlan/save", row, function(data) {
									if (data.code == OK) {
											dg.datagrid("endEdit", editingIndex);
											ext.tip.suc();
											filter();
											parent.filter();
											return;
											} else {
												ext.tip.error(data.message);
												}
											});
		 		    }
				}
		 	});
	}

	function getRowValues(index) {
		var cs = $("#productiondayplan_dg").datagrid('getColumnFields');
		var fcs = $("#productiondayplan_dg").datagrid('getColumnFields', true);

		var rows = $("#productiondayplan_dg").datagrid("getRows");

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

	function cancel() {
		editingIndex = -1;
		
		$("[disable=true]").linkbutton("enable");
        $("[disable=false]").linkbutton("disable");
        
		$("#productiondayplan_dg").datagrid("rejectChanges");
	}

	function searchProductionLine(q, row) {
		var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}

	function setFieldValue(index, field, value) {
		var editor = $(getEditor(index, field).target);
		try {
			editor.numberspinner("setValue", value);
		} catch (e) {
		}
		try {
			editor.textbox("setValue", value);
		} catch (e) {
		}
		try {
			editor.combobox("setValue", value);
		} catch (e) {
		}
		try {
			editor.datebox("setValue", value);
		} catch (e) {
		}
		try {
			editor.numberbox("setValue", value);
		} catch (e) {
		}
	}
	//校验左成本
	function onMaterialVer_left(record){
		var index = $(this).parents("[datagrid-row-index]").attr(
		"datagrid-row-index");
		var materialleftEditor = $("#productiondayplan_dg").datagrid('getEditor', {
			index : index,
			field : "material_code_left_s"
		});
		var materialleft = $(materialleftEditor.target).textbox("getValue");
		$.ajax({
		 		url:"curing/productionPlan/dailyPlan/greenTire?code=" + materialleft,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			for(var i=0;i<data.data.length;i++){
		 				if(data.data[i].specification_left_s==record){
		 					//验证成本
		 					$.ajax({
		 				 		url:"curing/productionPlan/dailyPlan/cost?code=" + materialleft+"&masterrevision="+data.data[i].childbom_ver_left_s+"&childcode="+data.data[i].childspecification_left_s,
		 				 		type:"get",
		 				 		dataType:"json",
		 				 		async:false,
		 				 		success:function(data){
		 				 			if (data.code != 0) {
		 				 				ext.tip.error("<spring:message code="tip.validmaterialcb" />");
		 							}
		 				 		}
		 				 	});
		 				}
		 			}
		 		}
		 	});
	}
	//校验右成本
	function onMaterialVer_right(record){
			var index = $(this).parents("[datagrid-row-index]").attr(
		"datagrid-row-index");
		var materialleftEditor = $("#productiondayplan_dg").datagrid('getEditor', {
			index : index,
			field : "material_code_right_s"
		});
		var materialleft = $(materialleftEditor.target).textbox("getValue");
		$.ajax({
		 		url:"curing/productionPlan/dailyPlan/greenTire?code=" + materialleft,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			for(var i=0;i<data.data.length;i++){
		 				if(data.data[i].specification_right_s==record){
		 					//验证成本
		 					$.ajax({
		 				 		url:"curing/productionPlan/dailyPlan/cost?code=" + materialleft+"&masterrevision="+data.data[i].childbom_ver_left_s+"&childcode="+data.data[i].childspecification_left_s,
		 				 		type:"get",
		 				 		dataType:"json",
		 				 		async:false,
		 				 		success:function(data){
		 				 			if (data.code != 0) {
		 				 				ext.tip.error("<spring:message code="tip.validmaterialcb" />");
		 							}
		 				 		}
		 				 	});
		 				}
		 			}
		 		}
		 	});
	}
</script>