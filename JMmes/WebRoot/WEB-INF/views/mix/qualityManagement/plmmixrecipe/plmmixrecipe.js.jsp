<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(document).ready(function() {
		filter();
	});
      
     //加载密炼机台信息
  	var equiplist=[];
 	$.ajax({
 		url:"mix/productionManagement/drrecord/getMixProductionInfo?plantype="+"051003",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			equiplist=data;
 		}
 	});
    
     function searchProductionLine(q, row) {
	 	var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}
	
	//返回称量调整页面dg
	function getWeightDg() {
		return $("#plmmixweight_dg");
	}
	//称量编辑
	function edit() {
		var rows = getWeightDg().datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("请至少选择一行数据");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = getWeightDg().datagrid("getRowIndex", rows[i]);
			getWeightDg().datagrid("beginEdit", index);
		}
	}
	function formatterWeightSetWeight(v, r, i) {
		return fomatFloat(v, 2);
	}
	
	function changeweight() {
		var rows = getWeightDg().datagrid("getRows");
		for (var i = 0; i < rows.length; i++) {
			if (!getWeightDg().datagrid("validateRow", i)) {
				ext.tip.error("<spring:message code="tip.invalid" />");
				return;
			}
		}
		var updated = getWeightDg().datagrid("getChanges", "updated");
		for (var i = 0; i < rows.length; i++) {
			getWeightDg().datagrid("endEdit", i);
		}

		var ids = [];
		var weight = [];
		Utils.each(updated, function(i, d) {
			ids.push(d.id_s);
			weight.push(d.set_weight_d);
		});
		ext.ajax.post("mix/qualityManagement/plmmixweight/changeweight", {
			ids : ids.toString(),
			weight : weight.toString()
		}, function(data) {
			if (data.code == OK) {
				showConfirm2(data.data);
				return;
			}
			ext.tip.error(data.message);
		});
	
	}
	
	function getDg() {
		return $("#plmmixrecipe_dg");
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
			/* if(rows[i].check_state_s!='0'){
				ext.tip.warn((i+1)+"<spring:message code="tip.row" /><spring:message code="tip.audited" />");
				return;
			} */
			recipecodelist.push(rows[i].recipe_code_s);
		}
		return recipecodelist;
	}
	//审核
	function audit() {
		if (getRecipecodelist() == "" || getRecipecodelist() == null) {
			return;
		}
		ext.ajax.post("mix/qualityManagement/plmmixrecipe/audit", {
			recipecodelist : getRecipecodelist().toString()
		}, function(data) {
			if (data.code == OK) {
				showConfirm(data.data);
				return;
			}
			ext.tip.error(data.message);
		});
	}
	
	//撤销审核
	function cancelaudit() {
		if (getRecipecodelist() == "" || getRecipecodelist() == null) {
			return;
		}
		ext.ajax.post("mix/qualityManagement/plmmixrecipe/cancelaudit", {
			recipecodelist : getRecipecodelist().toString()
		}, function(data) {
			if (data.code == OK) {
				showConfirm(data.data);
				return;
			}
			ext.tip.error(data.message);
		});
	}
	
	//下发
	function downward() {
		if (getRecipecodelist() == "" || getRecipecodelist() == null) {
			return;
		}
		ext.ajax.post("mix/qualityManagement/plmmixrecipe/downward", {
			recipecodelist : getRecipecodelist().toString()
		}, function(data) {
			if (data.code == OK) {
				showConfirm(data.data);
				return;
			}
			ext.tip.error(data.message);
		});
	}
	
	//待用
	function startrecipe() {
		if (getRecipecodelist() == "" || getRecipecodelist() == null) {
			return;
		}
		ext.ajax.post("mix/qualityManagement/plmmixrecipe/startrecipe", {
			recipecodelist : getRecipecodelist().toString()
		}, function(data) {
			if (data.code == OK) {
				showConfirm(data.data);
				return;
			}
			ext.tip.error(data.message);
		});
	}

	//停用
	function stoprecipe() {
		if (getRecipecodelist() == "" || getRecipecodelist() == null) {
			return;
		}
		ext.ajax.post("mix/qualityManagement/plmmixrecipe/stoprecipe", {
			recipecodelist : getRecipecodelist().toString()
		}, function(data) {
			if (data.code == OK) {
				showConfirm(data.data);
				return;
			}
			ext.tip.error(data.message);
		});
	}

	
	//显示操作结果
	function showConfirm(msg) {
		$.messager.confirm({
			width : 700,
			height : 350,
			title : '操作结果',
			msg : msg,
			fn : function(r) {
				filter();
			}
		});
	}
	//显示操作结果
	function showConfirm2(msg) {
		$.messager.confirm({
			width : 700,
			height : 350,
			title : '操作结果',
			msg : msg,
			fn : function(r) {

			}
		});
	}
	
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#plmmixrecipe_dg").datagrid("options");
        opts.url = 'mix/qualityManagement/plmmixrecipe/datagrid';
        ext.easyui.grid.search("plmmixrecipe_dg","PlmMixRecipe_search_form");
    }
    
     function selectrow(){
     
      var rows=$("#plmmixrecipe_dg").datagrid('getSelected');
      		
      	//加载配方详细信息	
		$("#slowdown_weight_d").html(rows.slowdown_weight_d);

		$("#cutpoly_weight_d").html(rows.cutpoly_weight_d);

		$("#mes_equip_code_s_sp").html(rows.mes_equip_code_s);

		$("#mes_equip_name_s").html(rows.mes_equip_name_s);

		$("#equip_code_s_sp").html(rows.equip_code_s);

		$("#edt_code_s_sp").html(rows.edt_code_s);
		
		$("#recipe_status_s_sp").html(codeFormatter(rows.recipe_status_s,null,null));

		$("#max_inploytemp_i_sp").html(rows.max_inploytemp_i);

		$("#mater_code_s_sp").html(rows.mater_code_s);

		$("#set_weigh_d_sp").html(rows.set_weigh_d);

		$("#dischangetime_i_sp").html(codeFormatter(rows.dischangetime_i, null, null));//加硫限制

		$("#mater_type_s_sp").html(codeFormatter(rows.mater_type_s, null, null));

		$("#cb_recycletype_s_sp").html(codeFormatter(rows.cb_recycletype_s, null, null));

		$("#plant_s_sp").html(rows.plant_s);

		$("#mater_name_s_sp").html(rows.mater_name_s);

		$("#cb_recycletime_i_sp").html(rows.cb_recycletime_i);

		$("#receive_time_t_sp").html(rows.receive_time_t);

		$("#b_version_s_sp").html(rows.b_version_s);

		$("#overtemp_mintime_i_sp").html(rows.overtemp_mintime_i);

		$("#overtime_time_i_sp").html(rows.overtime_time_i);

		$("#r_version_s_sp").html(rows.r_version_s);

		$("#overtemp_temp_i_sp").html(rows.overtemp_temp_i);

		$("#dummy1_s_sp").html(codeFormatter(rows.dummy1_s, null, null));

		$("#min_inploytemp_i_sp").html(rows.min_inploytemp_i);

		$("#ismixed_s_sp").html(codeFormatter(rows.ismixed_s, null, null));

		$("#makeup_temp_i_sp").html(rows.makeup_temp_i);

		$("#matchingcode_s_sp").html(rows.matchingcode_s);

		$("#is_useareatemp_s_sp").html(isuseareatempformatter(rows.is_useareatemp_s));//是否使用三区温度

		$("#dummy2_s_sp").html(rows.dummy2_s);

		$("#shelf_num_i_sp").html(rows.shelf_num_i);

		$("#side_temp_i_sp").html(rows.side_temp_i);

		$("#dummy3_s_sp").html(rows.dummy3_s);

		$("#routing_type_s_sp").html(codeFormatter(rows.routing_type_s, null, null));//工艺类型321

		$("#roll_temp_i_sp").html(rows.roll_temp_i);

		$("#dummy4_s_sp").html(rows.dummy4_s);

		$("#prescriptionstage_s_sp").html(codeFormatter(rows.prescriptionstage_s, null, null));// 配方阶段332

		$("#ddoor_temp_i_sp").html(rows.ddoor_temp_i);

		$("#dummy5_s_sp").html(rows.dummy5_s);
      //加载子表信息
    	 ext.ajax.post("mix/qualityManagement/plmmixweight/datagrid",{"filter[recipe_code_s]":rows.recipe_code_s,all:1 },function(data){
    		 $('#plmmixweight_dg').datagrid('loadData', data);  		
    	}); 
    	 ext.ajax.post("mix/qualityManagement/plmmixmix/datagrid",{"filter[recipe_code_s]":rows.recipe_code_s,all:1},function(data){  	 
    		 $('#plmmixmix_dg').datagrid('loadData', data);  		
    	}); 

    }
    
   function fomatFloat(num, n) {
		var f = parseFloat(num);
		if (isNaN(f)) {
			return false;
		}
		f = Math.round(num * Math.pow(10, n)) / Math.pow(10, n);
		var s = f.toString();
		var rs = s.indexOf('.');
		if (rs < 0) {
			rs = s.length;
			s += '.';
		}
		while (s.length <= rs + n) {
			s += '0';
		}
		return s;
	}
	//汇总重量列
	function onWeightLoadSuccess(data) {
		if (data.rows.length > 0) {
			//添加“合计”列
			var setweight = 0;
			for (var i = 0; i < data.rows.length; i++) {
				setweight += Number(data.rows[i].set_weight_d);
			}
			var upselectrow = $("#plmmixrecipe_dg").datagrid(
					'getSelected');
			var matertype = upselectrow.mater_type_s;
			
			if (matertype == '330001'
					|| matertype == '330002') {
				setweight = fomatFloat(setweight, 1);
			} else if (matertype == '330003'
					|| matertype == '330004') {
				setweight = fomatFloat(setweight, 2);
			} 
			$('#plmmixweight_dg').datagrid('appendRow', {
				weight_id_i : "总计：",
				set_weight_d : setweight
			});
		}
	}
    
    function setWeightSumRowBgColor(index, row) {
		if (row.child_matercode_s == null && row.child_matername_s == null) {
			return 'background-color:yellow;color:black;font-weight: bold;';
		}
	}
    /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {
		return dictFormat(v);
    }
    
    function isuseareatempformatter(v,r,i){
	        if(v==0){
	             return "不使用";        	 
	        }else if(v==1){
	       	     return "使用";  
	        }else{
	       	     return v;
	        }
	   	} 
    
    function checkstateformatter(v,r,i){
	        if(v==0){
	             return "未审核";        	 
	        }else if(v==1){
	       	     return "已审核";  
	        }else{
	       	     return v;
	        }
	} 
	
	//左侧树单击事件
	function clicktree(event, treeId, treeNode) {
		var treeselecttext = treeNode.ID;
		$("#mater_code_s").textbox("setValue", treeselecttext);
		$("#mater_name_s").textbox("setValue", '');
		filter();
	};
	
	//弹出物料选择页面onopen事件
	function menuDlgOpen() {
		$("#materialcodedlg").datagrid("removeFilterRule", "FLAG");
		$("#materialcodedlg").datagrid("removeFilterRule", "MATERIALCODE_S");
		$("#materialcodedlg").datagrid("removeFilterRule", "MATERIALDESC_S");
		$("#materialcodedlg").datagrid("removeFilterRule", "MATERIALSPEC_S");
		$("#materialcodedlg").datagrid("removeFilterRule", "MATGRP_S");
		$("#materialcodedlg").datagrid('reload');
	}
	
	//物料组显示值转换
	function matgrpformatter(v, r, i) {
		if (v == "300001") {
			return "半成品-母胶";
		} else if (v == "300002") {
			return "半成品-混炼胶";
		}
		return v;
	}
	//物料页面修改行颜色
	function materialRowStylerChange(index, row) {
		if (row.FLAG == "无") {
			return 'background-color:LightPink';
		} else {
			return 'background-color:LightGreen';
		}
	}
	
	//弹出物料编码框双击按钮
	function materialcodedlgdbclick(rowIndex, rowData) {
		var materialcode_s = rowData.MATERIALCODE_S;
		showtree(materialcode_s);
		$("#mater_code_s").textbox("setValue", materialcode_s);
		$("#menu_dlg").dialog("close");
		filter();
	};
	//加载树
	function showtree(matercode) {
		var url = "common/plm/mixrecipe/tree?id=" + matercode;
		ext.ajax.get(url, function(data) {
			menuTree = $.fn.zTree.init($("#tree_menu"), setting, data);
			menuTree.expandAll(true);
		});
	}
	
	//获取条件代码数据字典对应关系
	var ConditionDict = [];
	ext.ajax.get("common/plm/mixrecipe/getDictFormatter?dictcode=" + "326",
			function(data) {
				ConditionDict = data;
			});
	//获取动作代码数据字典对应关系
	var ActionDict = [];
	ext.ajax.get("common/plm/mixrecipe/getDictFormatter?dictcode=" + "325",
			function(data) {
				ActionDict = data;
			});

	function conditionformatter(v, r, i) {
		for (var j = 0; j < ConditionDict.length; j++) {
			if (v == ConditionDict[j].ERPCODE_S) {
				return v + '-' + ConditionDict[j].DICTNAME_S
			}
		}
		return v;
	}
	function actionformatter(v, r, i) {
		for (var j = 0; j < ActionDict.length; j++) {
			if (v == ActionDict[j].ERPCODE_S) {
				return v + '-' + ActionDict[j].DICTNAME_S
			}
		}
		return v;
	}
</script>