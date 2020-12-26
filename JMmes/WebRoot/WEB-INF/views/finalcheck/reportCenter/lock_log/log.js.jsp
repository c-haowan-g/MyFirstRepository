<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/qualityInspectionRecord/log/saveChanges";
    
    function showOrHide(){
        if($("#Log_search_form").is(":hidden")){
            $("#Log_search_form").show();
        }else{
            $("#Log_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("log_dg","Log_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("log_dg",{});
    }

    function edit() {
        var rows = $("#log_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#log_dg").datagrid("getRowIndex", rows[i]);
            $("#log_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#log_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#log_dg").datagrid("getRowIndex", rows[i]);
            $("#log_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#log_dg");

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
            $("#log_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#log_dg").datagrid("rejectChanges");
    }
    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }
    function isTestmatFlag(v,r,i){
        if("0"==r.state_s){
            return "已解锁";
        }else if("1"==r.state_s){
            return "已锁定";
        }else{
            return "";
        }
    }
    function islock_reas_s(v,r,i){
        if("0"==r.lock_reas_s){
            return "外观改判";
        }else if("1"==r.lock_reas_s){
            return "硫化换胶囊";
        }else{
            return "";
        }
    }

</script>