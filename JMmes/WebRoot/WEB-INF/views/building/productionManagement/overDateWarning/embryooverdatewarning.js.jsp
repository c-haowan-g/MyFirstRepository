<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/overDateWarning/embryooverdatewarning/saveChanges";
    
    function showOrHide(){
        if($("#EmbryoOverDateWarning_search_form").is(":hidden")){
            $("#EmbryoOverDateWarning_search_form").show();
        }else{
            $("#EmbryoOverDateWarning_search_form").hide();
        }
    }
    
        //时间控件
       /*  $(document).ready(function() {
		$('#search_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#to_out_time').textbox({
			value : 6,
			required : false
			
		});
		filter();
	
	}); */
    
    /**
     * 查询方法
     */
    var filter=function(){
    $("#embryooverdatewarning_dg").datagrid("options").url="building/overDateWarning/embryooverdatewarning/datagrid";
        ext.easyui.grid.search("embryooverdatewarning_dg","EmbryoOverDateWarning_search_form");
         
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("embryooverdatewarning_dg",{});
    }

    function edit() {
        var rows = $("#embryooverdatewarning_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#embryooverdatewarning_dg").datagrid("getRowIndex", rows[i]);
            $("#embryooverdatewarning_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#embryooverdatewarning_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#embryooverdatewarning_dg").datagrid("getRowIndex", rows[i]);
            $("#embryooverdatewarning_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#embryooverdatewarning_dg");

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
            $("#embryooverdatewarning_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#embryooverdatewarning_dg").datagrid("rejectChanges");
    }


</script>