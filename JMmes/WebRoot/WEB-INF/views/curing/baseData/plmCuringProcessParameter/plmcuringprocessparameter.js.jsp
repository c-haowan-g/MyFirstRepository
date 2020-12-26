<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/baseData/plmCuringProcessParameter/saveChanges";
    
    function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

    
    function showOrHide(){
        if($("#PlmCuringProcessParameter_search_form").is(":hidden")){
            $("#PlmCuringProcessParameter_search_form").show();
        }else{
            $("#PlmCuringProcessParameter_search_form").hide();
        }
    }
    
    function selectrow() {
		var rows = $("#plmcuringprocessparameter_dg").datagrid('getSelected');
		var route_name = rows.route_name;
		var url = "curing/baseData/plmCuringProcessParameter/datagridUDA3?route_name=" + route_name;
		ext.ajax.get(url, function(data) {
			$('#plmcuringprocessparameterlist_dg').datagrid('loadData', data);
		});
	}
   
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    
  	//隐藏显示查询栏
	function queryBar() {
		$("#CuringProductionLineInfo_search_form").toggle(500);
	}
  	
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("plmcuringprocessparameter_dg","PlmCuringProcessParameter_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("plmcuringprocessparameter_dg",{});
    }

    function edit() {
        var rows = $("#plmcuringprocessparameter_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plmcuringprocessparameter_dg").datagrid("getRowIndex", rows[i]);
            $("#plmcuringprocessparameter_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#plmcuringprocessparameter_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plmcuringprocessparameter_dg").datagrid("getRowIndex", rows[i]);
            $("#plmcuringprocessparameter_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#plmcuringprocessparameter_dg");

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

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#plmcuringprocessparameter_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#plmcuringprocessparameter_dg").datagrid("rejectChanges");
    }


</script>