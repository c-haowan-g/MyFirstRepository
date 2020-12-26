<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges = path + "finalchenk/standardManagement/processgrade/saveChanges";

	function showOrHide() {
		if ($("#ProcessGrade_search_form").is(":hidden")) {
			$("#ProcessGrade_search_form").show();
		} else {
			$("#ProcessGrade_search_form").hide();
		}
	}
	
	$(function(){
		$("#processgrade_dg2").datagrid("showColumn","dictcode_s");//显示列
		$("#processgrade_dg2").datagrid("hideColumn","gradedesc_s");//隐藏列
	})
	
	    /**
     * 接收combtree数据
     */
     var DICT_252=[];
 	
 	$.ajax({
 		url:"dict/code/252",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_252=data;
 		}
 	});
	
	
	function selectrow() {
		var rows = $("#processgrade_dg1").datagrid('getSelected');
		var ids = rows.dictcode_s;
		var url = "finalchenk/standardManagement/processgrade/gradessel?ids=" + ids;
		var  a="";
		ext.ajax.get(url, function(data) {
			a=data;
			$('#processgrade_dg2').datagrid('loadData', data);
			$.each(data, function(idx, val) {//遍历JSON  
				$("#processgrade_dg2").datagrid("selectRow", idx);//如果后台传过来的数据表示要选中，则此表示一记载就选中  
			});
			var coreurl = "finalchenk/standardManagement/processgrade/coresel";
				ext.ajax.sendJson(coreurl,"", function(data) {
				for (var i = 0; i < data.length; i++){
					var flag=true;
					for(k = 0; k < a.length; k++){
						if(a[k].gradedesc_s==data[i].DICTNAME_S){
							 flag=false;
						}
					}
					if(flag){
						var row_data = {
								gradecode_i : data[i].DICTCODE_S,
								gradedesc_s:  data[i].DICTNAME_S
						}
						$("#processgrade_dg2").datagrid('appendRow', row_data);
					}
				}
			});
			$("#processgrade_dg2").datagrid("hideColumn","dictcode_s");//显示列
			$("#processgrade_dg2").datagrid("showColumn","gradedesc_s");//隐藏列
		});
	}
	
	//先删除所有数据在获取选中行添加
	function save2(){
		var gxid=$("#processgrade_dg1").datagrid("getSelected");//获取选中行工序
		var selections = $("#processgrade_dg2").datagrid("getSelections");
		console.log(selections);
		var gzwhurl=path + "finalchenk/standardManagement/processgrade/delgxdj?gxid="+gxid.dictcode_s;//将选中行的工序dictcode_s传到后台
		ext.ajax.get(gzwhurl, function(data) {
			Utils.each(selections, function(i, d) {
				d.proess_i = gxid.dictcode_s;d.proessdesc_s=gxid.dictname_s;
			});
			var gzwhurl=path + "finalchenk/standardManagement/processgrade/saveChanges";
			ext.ajax.sendJson(gzwhurl, {
				inserted : selections,
			}, function(data) {
				if (data.code != OK) {
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				}
				$("#processgrade_dg").datagrid("reload");
				ext.tip.suc("<spring:message code="tip.success" />");

			});
		});
	}
	
	/**  
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("processgrade_dg", "ProcessGrade_search_form");
	}

	function add() {
		ext.easyui.grid.appendAndEdit("processgrade_dg", {});
	}

	function edit() {
		var rows = $("#processgrade_dg").datagrid("	");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#processgrade_dg").datagrid("getRowIndex", rows[i]);
			$("#processgrade_dg").datagrid("beginEdit", index);
		}
	}

	function remove() {

		var rows = $("#processgrade_dg").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			index = $("#processgrade_dg").datagrid("getRowIndex", rows[i]);
			$("#processgrade_dg").datagrid("deleteRow", index);
		}

	}

	function save() {
		var dg = $("#processgrade_dg");

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
			$("#processgrade_dg").datagrid("reload");
			ext.tip.suc("<spring:message code="tip.success" />")

		});
	}

	function cancel() {
		$("#processgrade_dg").datagrid("rejectChanges");
	}

	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

	//隐藏查询栏
	function searchBar() {
		$("#ProcessGrade_search_form").toggle();
	}

	//合并单元格
	function onLoadSuccess(data) {
		$("#processgrade_dg").datagrid("autoMergeCells",['proess_i']);
	}
</script>