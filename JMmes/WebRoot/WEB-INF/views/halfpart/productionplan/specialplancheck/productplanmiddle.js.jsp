<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/producttion/specialplancheck/saveChanges";
    
    function showOrHide(){
        if($("#ProductPlanMiddle_search_form").is(":hidden")){
            $("#ProductPlanMiddle_search_form").show();
        }else{
            $("#ProductPlanMiddle_search_form").hide();
        }
    }
    var productLineList=[];
    $.ajax({
        url:"halfpart/basedata/productlinemanager/getHalfPartProductionLine",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	productLineList=data;
        }
    });
    function machineFormatter(v, r, i){
        for(var i=0;i<productLineList.length;i++){
           if (v == productLineList[i].P_LINE_NAME) {
               return productLineList[i].DESCRIPTION;
           }
         }
   } 
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("productplanmiddle_dg","ProductPlanMiddle_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("productplanmiddle_dg",{});
    }

    function edit() {
        var rows = $("#productplanmiddle_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#productplanmiddle_dg").datagrid("getRowIndex", rows[i]);
            $("#productplanmiddle_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#productplanmiddle_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#productplanmiddle_dg").datagrid("getRowIndex", rows[i]);
            $("#productplanmiddle_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#productplanmiddle_dg");

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
            $("#productplanmiddle_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#productplanmiddle_dg").datagrid("rejectChanges");
    }


</script>