<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/updateinforecord/updateinforecord/saveChanges";
    
    function showOrHide(){
        if($("#UpdateInfo_search_form").is(":hidden")){
            $("#UpdateInfo_search_form").show();
        }else{
            $("#UpdateInfo_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("updateinfo_dg","UpdateInfo_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("updateinfo_dg",{});
    }

    function edit() {
        var rows = $("#updateinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#updateinfo_dg").datagrid("getRowIndex", rows[i]);
            $("#updateinfo_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#updateinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#updateinfo_dg").datagrid("getRowIndex", rows[i]);
            $("#updateinfo_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#updateinfo_dg");

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
            $("#updateinfo_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#updateinfo_dg").datagrid("rejectChanges");
    }


</script>