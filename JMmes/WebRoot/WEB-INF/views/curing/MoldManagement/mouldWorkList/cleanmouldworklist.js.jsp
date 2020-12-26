<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    var saveChanges=path+"curing/moldManagement/mouldWorkList/saveChanges";
    
    
    function showOrHide(){
        if($("#WorkList_search_form").is(":hidden")){
            $("#WorkList_search_form").show();
        }else{
            $("#WorkList_search_form").hide();
        }
    }
    //设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		
		filter();
	});
    /**
    *查询栏
    **/
    function queryBar() {
		$("#WorkList_search_form").toggle(500);
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
     
        var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	var opts = $("#worklist_dg").datagrid("options");
		opts.url ='curing/moldManagement/mouldWorkList/getCleanMouldWorkList';
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			   ext.easyui.grid.search("worklist_dg","WorkList_search_form");
    		}
    	}else{
    		   ext.easyui.grid.search("worklist_dg","WorkList_search_form");
    	}
    };
    
    

 
 
    
    function add() {
        $("#worklist_dg").datagrid("appendRow", {});
        var rows = $("#worklist_dg").datagrid("getRows");
        $("#worklist_dg").datagrid("beginEdit", rows.length - 1);
    }

    function edit() {
        var rows = $("#worklist_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#worklist_dg").datagrid("getRowIndex", rows[i]);
            $("#worklist_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#worklist_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#worklist_dg").datagrid("getRowIndex", rows[i]);
            $("#worklist_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#worklist_dg");

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
            }
            $("#worklist_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#worklist_dg").datagrid("rejectChanges");
    }


</script>