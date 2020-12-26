<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/test/unit/saveChanges";
    
    function showOrHide(){
        if($("#SerialNumberHelp_search_form").is(":hidden")){
            $("#SerialNumberHelp_search_form").show();
        }else{
            $("#SerialNumberHelp_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("serialnumberhelp_dg","SerialNumberHelp_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("serialnumberhelp_dg",{});
    }

    function edit() {
        var rows = $("#serialnumberhelp_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#serialnumberhelp_dg").datagrid("getRowIndex", rows[i]);
            $("#serialnumberhelp_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#serialnumberhelp_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#serialnumberhelp_dg").datagrid("getRowIndex", rows[i]);
            $("#serialnumberhelp_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#serialnumberhelp_dg");

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
        /*  数据回传，去掉对象中的扩展字段 */
		 for (var i = 0; i < inserted.length; i++) {
			 delete inserted[i]["created_by_name"];
			 delete inserted[i]["changed_by_name"];
		 }
		 for (var i = 0; i < updated.length; i++) {
			 delete updated[i]["created_by_name"];
			 delete	updated[i]["changed_by_name"];
		 }
		 for (var i = 0; i < deleted.length; i++) {
			 delete deleted[i]["created_by_name"];
			 delete deleted[i]["changed_by_name"];
		 }
		 if(inserted.length==0 && updated.length==0 && deleted.length==0){
			 ext.tip.error("<spring:message code="tip.nosave" />");
		 }else{
			 ext.ajax.sendJson(saveChanges, {
		            inserted : inserted,
		            updated : updated,
		            deleted : deleted
		        }, function(data) {
		            if (data.message!="ok") {
		            	if(data.message == "代码重复"){
		            		 $("#serialnumberhelp_dg").datagrid("reload"); 
							 ext.tip.error("<spring:message code="tip.datarepeat" />");
		            	}else{
		                     ext.tip.error("<spring:message code="tip.error" />");
		            	}
		            }else{
		                $("#serialnumberhelp_dg").datagrid("reload");
		                ext.tip.suc("<spring:message code="tip.success" />")
		            }

		        });
		 }
    }

    function cancel() {
        $("#serialnumberhelp_dg").datagrid("rejectChanges");
    }
    

</script>