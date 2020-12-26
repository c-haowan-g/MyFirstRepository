<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"/DADFDS/saveChanges";
    
    function showOrHide(){
        if($("#Foo_search_form").is(":hidden")){
            $("#Foo_search_form").show();
        }else{
            $("#Foo_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("foo_dg","Foo_search_form");
    }
    
    function add() {
        $("#foo_dg").datagrid("appendRow", {});
        var rows = $("#foo_dg").datagrid("getRows");
        $("#foo_dg").datagrid("beginEdit", rows.length - 1);
    }

    function edit() {
        var rows = $("#foo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#foo_dg").datagrid("getRowIndex", rows[i]);
            $("#foo_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#foo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#foo_dg").datagrid("getRowIndex", rows[i]);
            $("#foo_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#foo_dg");

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
            $("#foo_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#foo_dg").datagrid("rejectChanges");
    }


</script>