<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"${url}/saveChanges";
    
    function showOrHide(){
        if($("#${entityName}_search_form").is(":hidden")){
            $("#${entityName}_search_form").show();
        }else{
            $("#${entityName}_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("${entityName?lower_case}_dg","${entityName}_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("${entityName?lower_case}_dg",{});
    }

    function edit() {
        var rows = $("#${entityName?lower_case}_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#${entityName?lower_case}_dg").datagrid("getRowIndex", rows[i]);
            $("#${entityName?lower_case}_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#${entityName?lower_case}_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#${entityName?lower_case}_dg").datagrid("getRowIndex", rows[i]);
            $("#${entityName?lower_case}_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#${entityName?lower_case}_dg");

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
            $("#${entityName?lower_case}_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#${entityName?lower_case}_dg").datagrid("rejectChanges");
    }


</script>