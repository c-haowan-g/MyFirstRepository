<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/plm/commonplmdynamicbalancelog/saveChanges";
    
    
  //设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			showSeconds : true
		});
	});
    function clearcheckStatus(){
		$('#check_state_s').combobox('clear');
	}
	function clearStatus(){
		$('#send_state_s').combobox('clear');
	}
	//调用数据字典，323001-待用-黄色、323002-正用-绿色、323003-停用-红色
    function codeFormatter(v,r,i){
    	return dictFormat(v);
	}
	function recipeStatusCellStyler(v, r, i){
		  if(v==323001){
			return 'background-color:yellow;';
		  }else if(v==323002){
		    return 'background-color:#00FF00;';
		  }else if(v==323003){
		    return 'background-color:red;';
		  }
	}
	//0-未审核-红色、1-已审核-绿色
    function checkStateFormatter(v, r, i){
    	if(v==1){
    		return "已审核";
    	}else {
    		return "未审核";
    	}
    }
    function checkStateCellStyler(v, r, i){
		if(v==1){
			return 'background-color:#00FF00;';
		}else{
			return 'background-color:red;';
		}
	}
    //0-未下发-红色、1-已下发-绿色
	function sendStateformatter(v, r, i){
		if(v==1){
    		return "已下发";
    	}else {
    		return "未下发";
    	}
	}
	function sendStateCellStyler(v, r, i){
		if(v==1){
			return 'background-color:#00FF00;';
		}else{
			return 'background-color:red;';
		}
	}
    function showOrHide(){
        if($("#CommonPlmDynamicBalanceLog_search_form").is(":hidden")){
            $("#CommonPlmDynamicBalanceLog_search_form").show();
        }else{
            $("#CommonPlmDynamicBalanceLog_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var startTime = $('#begin_created_time').datebox("getValue");
		var endTime = $('#end_created_time').datebox("getValue");
		if ((startTime != "" && endTime == "")
				|| (startTime == "" && endTime != "")) {
			ext.tip.error("时间输入范围不完整");
			return;
		}
        ext.easyui.grid.search("commonplmdynamicbalancelog_dg","CommonPlmDynamicBalanceLog_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("commonplmdynamicbalancelog_dg",{});
    }

    function edit() {
        var rows = $("#commonplmdynamicbalancelog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#commonplmdynamicbalancelog_dg").datagrid("getRowIndex", rows[i]);
            $("#commonplmdynamicbalancelog_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#commonplmdynamicbalancelog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#commonplmdynamicbalancelog_dg").datagrid("getRowIndex", rows[i]);
            $("#commonplmdynamicbalancelog_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#commonplmdynamicbalancelog_dg");

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
            $("#commonplmdynamicbalancelog_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    
    function cancel() {
        $("#commonplmdynamicbalancelog_dg").datagrid("rejectChanges");
    }


</script>