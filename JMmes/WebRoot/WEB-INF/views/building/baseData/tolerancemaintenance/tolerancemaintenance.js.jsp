<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/baseData/tolerancemaintenance/toleranceMaintenance/saveChanges";
    
    /**
     * 加载机台信息
     * 时永良 
     * 2020年3月7日13:30:583
    */
    var productLineList=[];
    $.ajax({
    	
        url:"halfpart/baseData/tolerancemaintenance/toleranceMaintenance/getBuildingProductionLine",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	
        	productLineList=data;
        }
    });
    
    function equipmentFormatter(v, r, i) {
        for (var i = 0; i < productLineList.length; i++) {
            if (v == productLineList[i].P_LINE_NAME) {
                return productLineList[i].DESCRIPTION;
            }
        }

    }
    
    function showOrHide(){
        if($("#ToleranceMaintenance_search_form").is(":hidden")){
            $("#ToleranceMaintenance_search_form").show();
        }else{
            $("#ToleranceMaintenance_search_form").hide();
        }
    }
    
    /**
     * 基础数据text显示
     */
    function codeFormatter(v, r, i) {
      if(v==null){
          return "";
      }
        return dictFormat(v);
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var buildingProcess='252005';
        var opts = $("#tolerancemaintenance_dg").datagrid("options");
		opts.url = 'halfpart/baseData/tolerancemaintenance/toleranceMaintenance/datagridByProcess?process='+buildingProcess;
		ext.easyui.grid.search("tolerancemaintenance_dg","ToleranceMaintenance_search_form");
    }
    
    $(document).ready(function() {
	    filter();
	});
    
    function add() {
        ext.easyui.grid.appendAndEdit("tolerancemaintenance_dg",{});
    }

    function edit() {
        var rows = $("#tolerancemaintenance_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#tolerancemaintenance_dg").datagrid("getRowIndex", rows[i]);
            $("#tolerancemaintenance_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#tolerancemaintenance_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#tolerancemaintenance_dg").datagrid("getRowIndex", rows[i]);
            $("#tolerancemaintenance_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#tolerancemaintenance_dg");

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
            $("#tolerancemaintenance_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#tolerancemaintenance_dg").datagrid("rejectChanges");
    }


</script>