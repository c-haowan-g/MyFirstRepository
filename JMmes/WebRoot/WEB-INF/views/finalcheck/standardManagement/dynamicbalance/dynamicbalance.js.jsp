<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/standardmagement/dynamicbalance/saveChanges";
    
    function showOrHide(){
        if($("#DynamicBalance_search_form").is(":hidden")){
            $("#DynamicBalance_search_form").show();
        }else{
            $("#DynamicBalance_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("dynamicbalance_dg","DynamicBalance_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("dynamicbalance_dg",{});
    }

    function edit() {
        var rows = $("#dynamicbalance_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#dynamicbalance_dg").datagrid("getRowIndex", rows[i]);
            $("#dynamicbalance_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#dynamicbalance_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#dynamicbalance_dg").datagrid("getRowIndex", rows[i]);
            $("#dynamicbalance_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#dynamicbalance_dg");

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
            $("#dynamicbalance_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#dynamicbalance_dg").datagrid("rejectChanges");
    }


</script>