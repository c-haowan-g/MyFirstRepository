<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/productionManagement/record/saveChanges";
     //设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		//filter();
	});
	 /**
	 * 基础数据text显示
	 */
	function codeFormatter(v, r, i) {
	  if(v==null){
		  return "";
	  }
		return dictFormat(v);
	}
    
    function showOrHide(){
        if($("#Record_search_form").is(":hidden")){
            $("#Record_search_form").show();
        }else{
            $("#Record_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("record_dg","Record_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("record_dg",{});
    }

    function edit() {
        var rows = $("#record_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#record_dg").datagrid("getRowIndex", rows[i]);
            $("#record_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#record_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#record_dg").datagrid("getRowIndex", rows[i]);
            $("#record_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#record_dg");

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
            $("#record_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#record_dg").datagrid("rejectChanges");
    }


</script>