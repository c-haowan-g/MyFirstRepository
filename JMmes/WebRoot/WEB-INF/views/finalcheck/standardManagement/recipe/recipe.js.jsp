<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "finalcheck/standarManagement/recipe/saveChanges";
	var saveChanges2 = path + "finalcheck/baseData/recipeItem/saveChanges2";
	var getReceipeID = path + "finalcheck/standarManagement/recipe/getRecipeID";
	var recipeid_i;

	/**
	 * 接收combtree数据
	 */
	var DICT_254 = [];

	$.ajax({
		url : "dict/code/254",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			DICT_254 = data;
		}
	});


	function userFormatter(v, r, i) {
		for (var i = 0; i < UserInfo.length; i++) {
			if (UserInfo[i].USERCODE == v) {
				return UserInfo[i].USERNAME;
			}
		}
	}

	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    function numformatter(v,r,i){
		if(v==null){
			return 0;
		}else{
			return v;
		}
	}
	
	/**
	 * 第二个table的删除
	 */
	function remove2() {
		var rows = $("#recipe_dg2").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#recipe_dg2").datagrid("getRowIndex", rows[i]);
			$("#recipe_dg2").datagrid("deleteRow", index);
		}

	}
	/**
	 * 第二个table的新增,弹出不在已选择项物料表信息
	 */
	var enttype =null;
	function add2() {

		var rows = $("#recipe_dg").datagrid("getSelected");
		if (rows == null) {
 			ext.tip.error("<spring:message code='tip.selectJudgeNum'/>");
 			return;
 		}
		enttype=rows.enttype_i;
		//urlMenu = "Part/getPartsDatagrid?enttype"+rows.enttype_i;
		$("#menu_dlg").dialog("open");
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		if($("#enttype_i").val()=="" || $("#enttype_i").val()==null){
			ext.tip.error("<spring:message code="tip.selectEntType" />");
			return;
		}
		var opts = $("#recipe_dg").datagrid("options");
		opts.url = 'finalcheck/standarManagement/recipe/datagrid';
		ext.easyui.grid.search("recipe_dg", "Recipe_search_form");
	}
	

	/**
	 * 查询物料表方法
	 */
	var filtermaterial = function() {
		ext.easyui.grid.search("materials_dg", "Material_search_form");
	}

	function add() {
		var enttype_i = $("#enttype_i").val();
		$("#recipe_dg").datagrid('insertRow', {
			index : 0,
			row : {enttype_i: enttype_i}
		});
		var rows = $("#recipe_dg").datagrid("getRows");
		$("#recipe_dg").datagrid("beginEdit", 0);
	}

	function edit() {
		var rows = $("#recipe_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#recipe_dg").datagrid("getRowIndex", rows[i]);
			$("#recipe_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {
		var rows = $("#recipe_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#recipe_dg").datagrid("getRowIndex", rows[i]);
			$("#recipe_dg").datagrid("deleteRow", index);
		}

	}

	function save() {
		var dg = $("#recipe_dg");
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
			if (data.data!="操作成功") {
				$("#recipe_dg").datagrid("reload");
            	ext.tip.error(data.data);
            }else{
            	$("#recipe_dg").datagrid("reload");
    			$("#recipe_dg2").datagrid('loadData',{total:0,rows:[]});
                ext.tip.suc("<spring:message code="tip.success" />");
            }
			/* if (data.status != 1) {
				ext.tip.error("<spring:message code="tip.error" />");
			} 
			$("#recipe_dg").datagrid("reload");
			$("#recipe_dg2").datagrid('loadData',{total:0,rows:[]});
			ext.tip.suc("<spring:message code="tip.success" />");*/
		});
	}

	function save2() {
		var rows = $("#recipe_dg").datagrid("getSelected");
		if (rows == null) {
 			ext.tip.error("<spring:message code='tip.selectJudgeNum'/>");
 			return;
 		}
		enttype=rows.enttype_i;
		var dg = $("#recipe_dg2");
		var inserted = dg.datagrid("getChanges", "inserted");
		Utils.each(inserted, function(i, d) {
			delete d.materialdesc_s;
			delete d.materialspec_s;
			delete d.pattern_s;
			delete d.cj_s;
			d.recipeid_i = recipeid_i;
		});

		var deleted = dg.datagrid("getChanges", "deleted");
		Utils.each(deleted, function(i, d) {
			delete d.materialdesc_s;
			delete d.materialspec_s;
			delete d.pattern_s;
			delete d.cj_s;
			d.recipeid_i = recipeid_i;

		});

		ext.ajax.sendJson(saveChanges2, {
			inserted : inserted,
			deleted : deleted,
			enttype:enttype
		}, function(data) {
			if (data.data!="操作成功") {
				$("#recipe_dg").datagrid("reload");
				$("#recipe_dg2").datagrid("reload");
            	ext.tip.error(data.data);
            }else{
            	$("#recipe_dg").datagrid("reload");
            	showDetial();
                ext.tip.suc("<spring:message code="tip.success" />");
            } 
			
			/*  if (data.status != 1) {
				ext.tip.error("<spring:message code="tip.error" />");
			}
			$("#recipe_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />");  */
		});
	}

	function cancel() {
		$("#recipe_dg").datagrid("rejectChanges");
	}
	function showhide() {
		$("#Recipe_search_form").toggle();
	}

	/**
	 * 保存数据至细节表 
	 */
	function saveToDetial() {
		dosaveToDetial();
		$("#menu_dlg").dialog("close");
		//showDetial();
		//save2();
	}
	function cancelToDetial() {
		$("#menu_dlg").dialog("close");
	}
     //保存数据至recipeitem表
	function dosaveToDetial() {
		var rows = $("#material_dg").datagrid('getSelections');
		
		 if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		} 
		var Srows = $("#recipe_dg2").datagrid("getRows");
		for (var i = 0; i < rows.length; i++) {
			var flag = true;
				for (var j = 0; j < Srows.length; j++) {
					if (Srows[j].itemid_s == rows[i].part_number) {
						flag = false;
					}
				}
			if (flag) {
				 $("#recipe_dg2").datagrid("appendRow", {
					itemid_s : rows[i].part_number,
					materialdesc_s : rows[i].description,
					materialspec_s : rows[i].materialspec_s,
					pattern_s : rows[i].pattern_s,
					cj_s : rows[i].cj_s
				}); 
			}
			
		}
	}
	$(function(){
		$("#recipe_dg2").datagrid({
			fit:true,
			fitColumns:true,
			emptyMsg: '<span><spring:message code='tip.noData'/></span>',
			pagination:false,
			rownumbers: true,
			singleSelect: false,
			toolbar: '#Recipe_dg_toolbar2',
			clientPaging:true,
            remoteFilter:false,
			striped:true,
			method: 'get',
            onLoadSuccess:function(data) {
			  $(this).datagrid('enableFilter');
			}
		});
		

		$("#material_dg").datagrid({
			fit:true,
            fitColumns:true,
            pagination:true,
            rownumbers:true,
            singleSelect:false,
            clientPaging:false,
            remoteFilter:true,
            method:'get',
            pageSize:30,
            pageList:[30,50,100],
            emptyMsg:'<span><spring:message code='tip.noData'/></span>',
            striped:true,
			url : "Part/getPartsDatagrid",
			onBeforeLoad : function(param) {
				var rows = $("#recipe_dg").datagrid('getSelected');
				if (rows==null) {
					return false;
				}
			},
			onLoadSuccess : function(data) {
				$(this).datagrid('enableFilter');
			}
		});
		//filter();
	});

	function load() {
		$('#material_dg').datagrid('addFilterRule', {
			field: 'enttype',
			op: 'contains',
			value: enttype
		});
		$("#material_dg").datagrid("removeFilterRule","materialcode_s");
		$("#material_dg").datagrid('reload');
	}
	//显示选择plm参数页面
	function showplmdlg(){
		var rows = $("#recipe_dg").datagrid('getSelected');
        if(rows==null){
        	ext.tip.error("请至少选择一行配方数据");
        	return;
        }
		$("#plm_dlg").dialog("open");
	}
	//行单击事件,查询规格详情
	function showDetial() {
		var rows = $("#recipe_dg").datagrid('getSelected');
		console.log(rows)
		var entType = rows.enttype_i;//设备类
		var recipeno_s = rows.recipeno_s;//配方号
		var judgeid=rows.judgeid_i;//PLM参数ID
		//取得receipe表ID
		ext.ajax.sendJson(getReceipeID, {
			enttype_i : entType,
			recipeno_s : recipeno_s
		}, function(data) {
			recipeid_i = data["0"].atr_key;
		});
		//加载配方号下对应的规格信息
		var url = "finalcheck/baseData/recipeItem/datagrid2?all=1&entType=" + entType + "&recipeno_s="
				+ recipeno_s;
		ext.ajax.get(url, function(data) {

			$('#recipe_dg2').datagrid('loadData', data);
		});
		//加载配方号下对应的PLM动平衡参数信息
		var url = "finalcheck/standarManagement/dynamicbalance/searchplmdynamicbalance?judgeid=" + judgeid;
			ext.ajax.get(url, function(data) {
				console.log(data);
				$('#dynamicbalance_dg').datagrid('loadData', data);
			});

	}
	//关闭弹出的PLM参数选择页面
    function cancelSelectPLM() {
		$("#plm_dlg").dialog("close");
	}
	//保存数据至表格
	function dosaveToPLM(){
		var rows = $("#recipe_dg").datagrid('getSelected');
		var recipeno=rows.recipeno_s;
		var rowplm= $("#dynamicbalance_add_dg").datagrid('getSelected');
		if(rowplm==null){
			ext.tip.error("请至少选择一行动平衡参数数据");
        	return;
		}
		var judgeID=rowplm.atr_key;
		var url = "finalcheck/standarManagement/recipe/saveJudgeIDToRecipe?recipeno=" + recipeno+"&judgeID="+judgeID;
		ext.ajax.get(url, function(data) {
			if(data.code==OK){
        		ext.tip.suc();
                 
        		//加载配方号下对应的PLM动平衡参数信息
        		var url = "finalcheck/standarManagement/dynamicbalance/searchplmdynamicbalance?judgeid=" + judgeID;
        			ext.ajax.get(url, function(data) {
        				console.log(data);
        				$('#dynamicbalance_dg').datagrid('loadData', data);
        			});
        		
        		return;
        	}
		});
		$("#plm_dlg").dialog("close");
	}
</script>