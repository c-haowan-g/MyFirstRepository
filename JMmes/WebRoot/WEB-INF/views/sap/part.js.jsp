<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"demoTest/saveChanges";
    
    function showOrHide(){
        if($("#Part_search_form").is(":hidden")){
            $("#Part_search_form").show();
        }else{
            $("#Part_search_form").hide();
        }
    }
    
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("part_dg","Part_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("part_dg",{});
    }

    function edit() {
        var rows = $("#part_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#part_dg").datagrid("getRowIndex", rows[i]);
            $("#part_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#part_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#part_dg").datagrid("getRowIndex", rows[i]);
            $("#part_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#part_dg");

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
            $("#part_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#part_dg").datagrid("rejectChanges");
    }


</script>