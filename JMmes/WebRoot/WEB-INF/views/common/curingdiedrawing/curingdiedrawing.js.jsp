<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    //var saveChanges=path+"cx/jcsjcx/curingdiedrawing/saveChanges";
    
    function showOrHide(){
        if($("#CuringdieDrawing_search_form").is(":hidden")){
            $("#CuringdieDrawing_search_form").show();
        }else{
            $("#CuringdieDrawing_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("curingdiedrawing_dg","CuringdieDrawing_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("curingdiedrawing_dg",{});
    }

    function edit() {
        var rows = $("#curingdiedrawing_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingdiedrawing_dg").datagrid("getRowIndex", rows[i]);
            $("#curingdiedrawing_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#curingdiedrawing_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingdiedrawing_dg").datagrid("getRowIndex", rows[i]);
            $("#curingdiedrawing_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#curingdiedrawing_dg");

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
            $("#curingdiedrawing_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#curingdiedrawing_dg").datagrid("rejectChanges");
    }


</script>