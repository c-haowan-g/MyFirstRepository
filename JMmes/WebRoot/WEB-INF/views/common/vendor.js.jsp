<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}

    var saveChanges=path+"common/Vendor/saveChanges";
    
    function showOrHide(){
        if($("#Vendor_search_form").is(":hidden")){
            $("#Vendor_search_form").show();
        }else{
            $("#Vendor_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("vendor_dg","Vendor_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("vendor_dg",{});
    }

    function edit() {
        var rows = $("#vendor_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#vendor_dg").datagrid("getRowIndex", rows[i]);
            $("#vendor_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#vendor_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#vendor_dg").datagrid("getRowIndex", rows[i]);
            $("#vendor_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#vendor_dg");

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
            $("#vendor_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#vendor_dg").datagrid("rejectChanges");
    }


</script>