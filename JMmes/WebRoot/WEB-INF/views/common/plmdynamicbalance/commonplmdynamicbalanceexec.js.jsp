<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/plm/commonplmdynamicbalanceexec/saveChanges";
    //引用323数据字典
    function codeFormatter(v,r,i){
    	return dictFormat(v);
    }
    function clearcheckStatus(){
        $('#check_state_s').combobox('clear');
    }
    function clearStatus(){
    	$('#send_state_s').combobox('clear');
    }
    //背景颜色设置、323001-待用-黄色、323002-正用-绿色、323003-停用-红色
    function recipeStatusCellStyler(v,r,i){
       if(v==323002){
          return 'background-color:	#00FF00;';
       }else if(v==323003){
          return 'background-color:red;';
       }else{
          return 'background-color:yellow;';
       }
   }
    //0-未审核-红色、1-已审核-绿色、空-未维护-红色
    function checkStateFormatter(v,r,i){
    	   if(v==0){
    	      return "未审核";
    	   }else if(v==1){
    	      return "已审核";
    	   }else{
    	      return "未审核";
    	   }
    	}
    
    function checkStateCellStyler(v,r,i){
  	   if(v==1){
  	     return 'background-color:#00FF00;';
  	   }else if(v==0){
  	     return 'background-color:red;';
  	   }
  	}
  
    //0-未下发-红色、1-已下发-绿色、空-未下发-红色
    function letdownFormatter(v,r,i){
       if(v==1){
         return "已下发";
       }else{
         return "未下发";
       }
    }
    function letdownCellStyler(v,r,i){
    	   if(v==1){
    	     return 'background-color:#00FF00;';
    	   }else{
    	     return 'background-color:red;';
    	   }
    	}
    
    function showOrHide(){
        if($("#CommonPLMDynamicBalanceExec_search_form").is(":hidden")){
            $("#CommonPLMDynamicBalanceExec_search_form").show();
        }else{
            $("#CommonPLMDynamicBalanceExec_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("commonplmdynamicbalanceexec_dg","CommonPLMDynamicBalanceExec_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("commonplmdynamicbalanceexec_dg",{});
    }

    function edit() {
        var rows = $("#commonplmdynamicbalanceexec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#commonplmdynamicbalanceexec_dg").datagrid("getRowIndex", rows[i]);
            $("#commonplmdynamicbalanceexec_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#commonplmdynamicbalanceexec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#commonplmdynamicbalanceexec_dg").datagrid("getRowIndex", rows[i]);
            $("#commonplmdynamicbalanceexec_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#commonplmdynamicbalanceexec_dg");

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
            $("#commonplmdynamicbalanceexec_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#commonplmdynamicbalanceexec_dg").datagrid("rejectChanges");
    }


</script>