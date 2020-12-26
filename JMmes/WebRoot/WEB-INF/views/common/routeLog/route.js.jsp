<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/routeLog/routelog/saveChanges";
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("route_dg","Route_search_form");
    }
    
    function clearStatus(){
		$('#routecode_s').combobox('clear');
	}
    
    function add() {
        ext.easyui.grid.appendAndEdit("route_dg",{});
    }

    function edit() {
        var rows = $("#route_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#route_dg").datagrid("getRowIndex", rows[i]);
            $("#route_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#route_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#route_dg").datagrid("getRowIndex", rows[i]);
            $("#route_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#route_dg");

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
            $("#route_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#route_dg").datagrid("rejectChanges");
    }


</script>