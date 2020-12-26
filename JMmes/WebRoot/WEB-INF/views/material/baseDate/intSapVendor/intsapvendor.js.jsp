<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/intsapvendor/saveChanges";
    
    function showOrHide(){
        if($("#IntSapVendor_search_form").is(":hidden")){
            $("#IntSapVendor_search_form").show();
        }else{
            $("#IntSapVendor_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {
    	
		return dictFormat(v);
	}
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("intsapvendor_dg","IntSapVendor_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("intsapvendor_dg",{});
    }

    function edit() {
        var rows = $("#intsapvendor_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#intsapvendor_dg").datagrid("getRowIndex", rows[i]);
            $("#intsapvendor_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#intsapvendor_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#intsapvendor_dg").datagrid("getRowIndex", rows[i]);
            $("#intsapvendor_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#intsapvendor_dg");

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
            $("#intsapvendor_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#intsapvendor_dg").datagrid("rejectChanges");
    }


</script>