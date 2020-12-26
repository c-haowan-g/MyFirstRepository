<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "finalcheck/reportCenter/sortltem/saveChanges";
	var saveChanges4 = path + "finalcheck/reportCenter/sortltem/updateNum_i";
	var saveChanges5 = path + "finalcheck/reportCenter/sortltem/updateNum_i5";
	var saveChangesSortGrade = path + "finalcheck/reportcenter/sortgrade/saveChanges";
	
	function classFormatter(v,r,i){
		if(v=='0'){
			return '备胎';
		}else if(v=='1'){
			return '正常胎';
		}
	}
	function stationFormatter(){
		var selectedstation =  $('#station_i').combobox("getValue");
        
		  var datasource = [];
	      
		  $.ajax({
		 		url:"finalcheck/reportCenter/sortltem/SearchEntToRulesOfTheQuery?equip_type="+selectedstation,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			datasource=data;
		 		}
		 	});
		  $("#entbarcode_s").combobox("clear");
	      $("#entbarcode_s").combobox("loadData", datasource); 
	     
		
	}
	function stationFormatter2(){
		var selectedstation =  $('#station_i3').combobox("getValue");
        
		  var datasource = [];
	      
		  $.ajax({
		 		url:"finalcheck/reportCenter/sortltem/SearchEnt?equip_type="+selectedstation,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			datasource=data;
		 		}
		 	});
		  $("#entbarcode_s3").combobox("clear");
	      $("#entbarcode_s3").combobox("loadData", datasource);
		
	}
	
	
	 /**
     * 接收combtree数据
     */
     var DICT_260=[];
 	
 	$.ajax({
 		url:"dict/code/260",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_260=data;
 		}
 	});
	

	
	
	
	/**
	 * 显示或隐藏第一个tab页的查询栏
	 */
	function showOrHide() {
		if ($("#Sortltem_search_form").is(":hidden")) {
			$("#Sortltem_search_form").show();
		} else {
			$("#Sortltem_search_form").hide();
		}
	}
	/**
	 * 显示或隐藏第四个tab页的查询栏
	 */
	function showOrHide4() {
		if ($("#Sortltem_search_form4").is(":hidden")) {
			$("#Sortltem_search_form4").show();
		} else {
			$("#Sortltem_search_form4").hide();
		}
	}
/**
	 * 显示或隐藏第五个tab页的查询栏
	 */
	function showOrHide5() {
		if ($("#Sortltem_search_form5").is(":hidden")) {
			$("#Sortltem_search_form5").show();
		} else {
			$("#Sortltem_search_form5").hide();
		}
	}
	/**
	 * 第一个tab页的查询方法
	 */
	var filter = function() {
		var station_i = $("#station_i").val();
		if (station_i == "" || station_i == null) {
			ext.tip.error("<spring:message code='tip.station'/>");
			return;
		}
	/* 	var entbarcode_s = $("#entbarcode_s").val();
		if (entbarcode_s == "" || entbarcode_s == null) {
			ext.tip.error("<spring:message code='tip.selectEnt'/>");
			return;
		} */
		var opts = $("#sortltem_dg").datagrid("options");
		opts.url = 'finalcheck/reportCenter/sortltem/datagrid1';
		ext.easyui.grid.search("sortltem_dg", "Sortltem_search_form");
	}

	/**
	 * 第二个tab页的查询方法
	 */
	var filter2 = function() {
		var station_i = $("#station_i2").val();
		if (station_i == "" || station_i == null) {
			ext.tip.error("<spring:message code='tip.station'/>");
			return;
		}
		var opts = $("#sortgrade_dg").datagrid("options");
		opts.url = 'finalcheck/reportcenter/sortgrade/datagrid';
		var opts = $("#processgrade_dg").datagrid("options");
		opts.url = 'finalchenk/standardManagement/processgrade/datagrid2';
		ext.easyui.grid.search("sortgrade_dg", "Grade_search_form");
		ext.easyui.grid.search("processgrade_dg", "Grade_search_form");
	}

	/**
	 * 第三个tab的查询方法
	 */
	var filter3 = function() {
		var station_i = $("#station_i3").val();
		if (station_i == "" || station_i == null) {
			ext.tip.error("<spring:message code='tip.station'/>");
			return;
		}
		var entbarcode_s = $("#entbarcode_s3").val();
		if (entbarcode_s == "" || entbarcode_s == null) {
			ext.tip.error("<spring:message code='tip.selectEnt'/>");
			return;
		}
		var opts = $("#recipeItem_dg").datagrid("options");
		opts.url = 'finalcheck/baseData/recipeItem/datagrid3';
		var opts = $("#sortItem_dg3").datagrid("options");
		opts.url = 'finalcheck/reportCenter/sortltem/datagrid1';
		ext.easyui.grid.search("recipeItem_dg", "Sortltem_search_form3");
		ext.easyui.grid.search("sortItem_dg3", "Sortltem_search_form3");
	}

	/**
	 * 第4个tab页的查询方法
	 */
	var filter4 = function() {
		var station_i = $("#station_i4").val();
		if (station_i == "" || station_i == null) {
			ext.tip.error("<spring:message code='tip.station'/>");
			return;
		} 
		var opts = $("#sortltem_dg4").datagrid("options");
		opts.url = 'finalcheck/reportCenter/sortltem/datagrid4';
		ext.easyui.grid.search("sortltem_dg4", "Sortltem_search_form4");
	}

	/**
	 * 第4个tab页的编辑方法
	 */
	function edit4() {
		var rows = $("#sortltem_dg4").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#sortltem_dg4").datagrid("getRowIndex", rows[i]);
			$("#sortltem_dg4").datagrid("beginEdit", index);
		}
	}
	
	/**
	 * 第5个tab页的查询方法
	 */
	var filter5 = function() {
		var opts = $("#sortltem_dg5").datagrid("options");
		opts.url = 'finalcheck/reportCenter/sortltem/datagrid4';
		ext.easyui.grid.search("sortltem_dg5", "Sortltem_search_form5");
	}
	
	/**
	 * 第5个tab页的编辑方法
	 */
	function edit5() {
		var rows = $("#sortltem_dg5").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#sortltem_dg5").datagrid("getRowIndex", rows[i]);
			$("#sortltem_dg5").datagrid("beginEdit", index);
		}
	}
	
	
	/**
	 * 第五个tab页的保存方法
	 */
	function save5() {
		var dg = $("#sortltem_dg5");

		var rows = dg.datagrid("getRows");
		var valid = false;
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("<spring:message code="tip.invalid" />");
				return;
			}
		}
		var updated = dg.datagrid("getChanges", "updated");

		for (var i = 0; i < rows.length; i++) {
			dg.datagrid("endEdit", i);
		}
		ext.ajax.sendJson(saveChanges5, {
			updated : updated,
			enttype:$('#num_i5').combobox("getValue")
		}, function(data) {

			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
			}
			$("#sortltem_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")
		});
	}
	function cancel5() {
		$("#sortltem_dg5").datagrid("rejectChanges");
	}
	
	/**
	 * 第二个tab页右侧table数据
	 */
	function editsortgrade() {
		var rows = $("#sortgrade_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#sortgrade_dg").datagrid("getRowIndex", rows[i]);
			$("#sortgrade_dg").datagrid("beginEdit", index);
		}
	}
	/**
	 * 第一个tab页删除数据方法
	 */
	function remove() {

		var rows = $("#sortltem_dg").datagrid("getSelections");
		if (rows.length <= 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#sortltem_dg").datagrid("getRowIndex", rows[i]);
			$("#sortltem_dg").datagrid("deleteRow", index);
		}

	}
	/**
	 * 第一个tab页保存数据方法
	 */
	function save() {
		var dg = $("#sortltem_dg");

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
		//由于实体类不对应,需要把table中来自其他表的键删掉
		Utils.each(deleted, function(i, d) {
			delete d.materialdesc_s;
			delete d.materialspec_s;
			delete d.pattern_s;
			delete d.cj_s;
			delete d.entname_s;
			delete d.recipeno_s;
			delete d.changebyname;
			delete d.createdname;
		});

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
			}
			$("#sortltem_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}
	/**
	 * 第二个tab页保存按钮方法
	 */
	function saveSortGrade() {

		var station_i = $("#station_i2").val();
		var dg = $("#sortgrade_dg");
		var rows = dg.datagrid("getRows");
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("<spring:message code="tip.invalid" />");
				return;
			}
		}
		var updated = dg.datagrid("getChanges", "updated");
		var inserted = dg.datagrid("getChanges", "inserted");
		var deleted = dg.datagrid("getChanges", "deleted");
		for (var i = 0; i < rows.length; i++) {
			dg.datagrid("endEdit", i);
		}
		Utils.each(updated, function(i, d) {
			d.station_i = station_i;
		});
		Utils.each(inserted, function(i, d) {
			d.station_i = station_i;
		});
		ext.ajax.sendJson(saveChangesSortGrade, {
			updated : updated,
			inserted : inserted,
			deleted : deleted
		}, function(data) {
			if (data.status != 1) {
				ext.tip.error("<spring:message code="tip.error" />");
			}
			$("#sortgrade_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")
		});
	}
	/**
	 * 第三个tab页保存按钮方法
	 */
	function save3() {
		var dg = $("#sortItem_dg3");

		var rows = dg.datagrid("getRows");
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("<spring:message code="tip.invalid" />");
				return;
			}
		}
		var updated = dg.datagrid("getChanges", "updated");
		var inserted = dg.datagrid("getChanges", "inserted");
		var deleted = dg.datagrid("getChanges", "deleted");

		for (var i = 0; i < rows.length; i++) {
			dg.datagrid("endEdit", i);
		}
		var station_i = $("#station_i3").combobox('getValue');

		var entbarcode_s = $("#entbarcode_s3").combotree('getValue');

		Utils.each(inserted, function(i, d) {
			delete d.materialdesc_s;
			delete d.materialspec_s;
			delete d.pattern_s;
			delete d.cj_s;
			delete d.entname_s;
			delete d.recipeno_s;
			delete d.changebyname;
			delete d.createdname;
			d.station_i = station_i;
			d.entbarcode_s = entbarcode_s;
		});
		Utils.each(updated, function(i, d) {
			delete d.materialdesc_s;
			delete d.materialspec_s;
			delete d.pattern_s;
			delete d.cj_s;
			delete d.entname_s;
			delete d.recipeno_s;
			delete d.changebyname;
			delete d.createdname;
			d.station_i = station_i;
			d.entbarcode_s = entbarcode_s;
		});

		Utils.each(deleted, function(i, d) {
			delete d.materialdesc_s;
			delete d.materialspec_s;
			delete d.pattern_s;
			delete d.cj_s;
			delete d.entname_s;
			delete d.recipeno_s;
			delete d.changebyname;
			delete d.createdname;
			d.station_i = station_i;
			d.entbarcode_s = entbarcode_s;
		});
		ext.ajax.sendJson(saveChanges, {
			updated : updated,
			inserted : inserted,
			deleted : deleted
		}, function(data) {

			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
			}
			$("#sortltem_dg").datagrid("reload");
			$("#sortItem_dg3").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}
	/**
	 * 第四个tab页的保存方法
	 */
	function save4() {
		var dg = $("#sortltem_dg4");

		var rows = dg.datagrid("getRows");
		var valid = false;
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("<spring:message code="tip.invalid" />");
				return;
			}
		}
		var updated = dg.datagrid("getChanges", "updated");

		for (var i = 0; i < rows.length; i++) {
			dg.datagrid("endEdit", i);
		}
		ext.ajax.sendJson(saveChanges4, {
			updated : updated,
			enttype:$('#station_i4').combobox("getValue")
		}, function(data) {

			if (data.code != OK) {
				ext.tip.error("<spring:message code="tip.error" />");
			}
			$("#sortltem_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")
		});
	}

	function cancel() {
		$("#sortltem_dg").datagrid("rejectChanges");
	}
	function cancel4() {
		$("#sortltem_dg4").datagrid("rejectChanges");
	}
	/**
	 * 基础数据text显示
	 */
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
	/**
	 * 第二个tab页右侧table中后工序处理,操作,0是允许,1是不允许
	 */
	function isCheckFormatter(v, r, i) {

		if (r.ischeck_i == 0) {
			return "<spring:message code='tip.notallow'/>";
		} else if (r.ischeck_i == 1) {
			return "<spring:message code='tip.allow'/>";
		}
	}

	/**
	 * 全部向前2 clickallback
	 */
	function clickallforward() {
		$("#processgrade_dg").datagrid('selectAll');
		doForward();
	}

	/**
	 * 全部向后2 
	 */
	function clickallback() {
		$("#sortgrade_dg").datagrid('selectAll');
		doBack();
	}

	/**
	 * 向右2 
	 */
	function clickforwardone() {
		doForward();
	}

	/**
	 * 向左2
	 */
	function clickbackone() {
		doBack();
	}

	function doForward() {
		var rows = $("#processgrade_dg").datagrid('getSelections');
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var index = $('#sortgrade_dg').datagrid('getRows').length - 1;
		var rowindex = 0;
		for (var i = 0; i < rows.length; i++) {

			if (rowindex == 0)
				rowindex = index + 1;
			else
				rowindex++;

			$('#sortgrade_dg').datagrid('insertRow', {
				index : rowindex,
				row : {
					proess_i : rows[i].proess_i,
					gradecd_i : rows[i].gradecode_i,
					ischeck_i : 1
				}
			});
			$("#sortgrade_dg").datagrid("beginEdit", rowindex);
		}
		clearDatagridSelectedRecord("processgrade_dg");
	}

	function doBack() {
		var rows = $("#sortgrade_dg").datagrid('getSelections');
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var Srows = $("#processgrade_dg").datagrid('getRows');
		for (var i = 0; i < rows.length; i++) {

			$('#processgrade_dg').datagrid('appendRow', {
				proess_i : rows[i].proess_i,
				gradecode_i : rows[i].gradecd_i
			});
		}
		clearDatagridSelectedRecord("sortgrade_dg");
	}

	/**
	 * 全部向前3 clickallback
	 */
	function clickallforward3() {
		$("#recipeItem_dg").datagrid('selectAll');
		doForward3();
	}

	/**
	 * 全部向后3 
	 */
	function clickallback3() {
		$("#sortItem_dg3").datagrid('selectAll');
		doBack3();
	}

	/**
	 * 向右3
	 */
	function clickforwardone3() {
		doForward3();
	}

	/**
	 * 向左3
	 */
	function clickbackone3() {
		doBack3();
	}

	function doForward3() {
		var station_i = $("#station_i3").val();
		if (station_i == "" || station_i == null) {
			ext.tip.error("<spring:message code='tip.station'/>");
			return;
		}
		var rows = $("#recipeItem_dg").datagrid('getSelections');
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var Srows = $("#sortItem_dg3").datagrid('getRows');
		console.log(Srows);
       
		for (var i = 0; i < rows.length; i++) {
			var num=1;//抽检比例默认值
			var flag = true;
			for (var j = 0; j < Srows.length; j++) {
				if (Srows[j].itemid_s == rows[i].itemid_s&&Srows[j].recipeno_s == rows[i].recipeno_s) {
					flag = false;
				}
			}
			if (flag) {
				var url ="finalcheck/reportCenter/sortltem/getNum_i?itemid_s="+rows[i].itemid_s+ "&station_i="+station_i;
				$.ajax({
					url : url,
					dataType : 'json',
					data : null,
					async:false,
					success:function(data) {
						if(data !=null){
							num=data[0].NUM_I;
						};
			     }
				});
			};
				console.log(num);
				$('#sortItem_dg3').datagrid('appendRow', {
					
					num_i:num,
					itemid_s : rows[i].itemid_s,
					materialdesc_s : rows[i].materialdesc_s,
					materialspec_s : rows[i].materialspec_s,
					recipeno_s : rows[i].recipeno_s,
					pattern_s : rows[i].pattern_s,
					cj_s : rows[i].cj_s
				});
			}
		
		clearDatagridSelectedRecord("recipeItem_dg");
	}

	function doBack3() {
		var rows = $("#sortItem_dg3").datagrid('getSelections');
		if (rows.length == 0) {
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
			return;
		}
		var Srows = $("#recipeItem_dg").datagrid('getRows');

		for (var i = 0; i < rows.length; i++) {
			var flag = true;
			for (var j = 0; j < Srows.length; j++) {
				if (Srows[j].itemid_s == rows[i].itemid_s&&Srows[j].recipeno_s == rows[i].recipeno_s) {
					flag = false;
				}
			}
			if (flag) {
				$('#recipeItem_dg').datagrid('appendRow', {
					itemid_s : rows[i].itemid_s,
					materialdesc_s : rows[i].materialdesc_s,
					materialspec_s : rows[i].materialspec_s,
					pattern_s : rows[i].pattern_s,
					cj_s : rows[i].cj_s,
					recipeno_s : rows[i].recipeno_s
				});
			}
		}
		clearDatagridSelectedRecord("sortItem_dg3");
	}

	/**
	 * 清空datagrid中的选择数据
	 */
	function clearDatagridSelectedRecord(datagridId) {
		var rows = $("#" + datagridId).datagrid("getSelections");

		var copyRows = [];
		for (var j = 0; j < rows.length; j++) {
			copyRows.push(rows[j]);
		}
		for (var i = 0; i < copyRows.length; i++) {
			var index = $("#" + datagridId)
					.datagrid('getRowIndex', copyRows[i]);
			$("#" + datagridId).datagrid('deleteRow', index);
		}
	}
</script>