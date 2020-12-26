<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"view?page=halfpart/stockingRecord/stockingmain&factory=2/saveChanges";
    
    function showOrHide(){
        if($("#Stockingmain_search_form").is(":hidden")){
            $("#Stockingmain_search_form").show();
        }else{
            $("#Stockingmain_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {
    	return dictFormat(v);
    }
    function typeFormatter(v,r,i){
    	if(v==1){
    		return "正式库盘库";
    	}else if(v==2){
    		return "线边库盘库";
    	}
    }
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("stockingmain_dg","Stockingmain_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("stockingmain_dg",{});
    }

    function edit() {
        var rows = $("#stockingmain_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#stockingmain_dg").datagrid("getRowIndex", rows[i]);
            $("#stockingmain_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#stockingmain_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#stockingmain_dg").datagrid("getRowIndex", rows[i]);
            $("#stockingmain_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#stockingmain_dg");

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
            $("#stockingmain_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#stockingmain_dg").datagrid("rejectChanges");
    }


</script>