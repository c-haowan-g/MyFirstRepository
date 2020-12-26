<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    var saveChanges=path+"view?page=common/khzsj/customer/saveChanges";
    
    function showOrHide(){
        if($("#Customer_search_form").is(":hidden")){
            $("#Customer_search_form").show();
        }else{
            $("#Customer_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("customer_dg","Customer_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("customer_dg",{});
    }

    function edit() {
        var rows = $("#customer_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#customer_dg").datagrid("getRowIndex", rows[i]);
            $("#customer_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#customer_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#customer_dg").datagrid("getRowIndex", rows[i]);
            $("#customer_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#customer_dg");

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
            $("#customer_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#customer_dg").datagrid("rejectChanges");
    }


</script>