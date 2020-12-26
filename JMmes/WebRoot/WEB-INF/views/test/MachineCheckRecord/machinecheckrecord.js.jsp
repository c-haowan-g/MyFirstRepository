<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"test/MachineCheckRecord/saveChanges";
    
    function showOrHide(){
        if($("#MachineCheckRecord_search_form").is(":hidden")){
            $("#MachineCheckRecord_search_form").show();
        }else{
            $("#MachineCheckRecord_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("machinecheckrecord_dg","MachineCheckRecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("machinecheckrecord_dg",{});
    }

    function edit() {
        var rows = $("#machinecheckrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#machinecheckrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#machinecheckrecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#machinecheckrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#machinecheckrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#machinecheckrecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#machinecheckrecord_dg");

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
            $("#machinecheckrecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#machinecheckrecord_dg").datagrid("rejectChanges");
    }


</script>