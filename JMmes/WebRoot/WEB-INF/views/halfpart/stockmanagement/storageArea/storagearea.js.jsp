<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/stockmanagement/storageArea/saveChanges";
    var date=new Date();
    var hours=date.getHours();
    var beginTime;
    var endTime;
    if(hours>=0&&hours<8){
    	beginTime='3/4/2010 00:00:00';
    	endTime='3/4/2010 08:00:00';
    }else if(hours>=8&&hours<16){
    	beginTime='3/4/2010 08:00:00';
    	endTime='3/4/2010 16:00:00';
    }else if(hours>=16&&hours<24){
    	beginTime='3/4/2010 16:00:00';
    	endTime='3/4/2010 24:00:00';
    }
    
     $(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : beginTime,
			required : true,
			showSeconds : true
		});
		
		$('#end_created_time').datetimebox({
			value : endTime,
			required : true,
			showSeconds : true
		});
	}); 
    
    function showOrHide(){
        if($("#StorageArea_search_form").is(":hidden")){
            $("#StorageArea_search_form").show();
        }else{
            $("#StorageArea_search_form").hide();
        }
    }
    
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    
     var materialGroupList=[];
    $.ajax({
        url:"sap/materials/getMaterialGroupList",
        type:"get",
        dataType:"json",
        async:true,
        success:function(data){
        	materialGroupList=data;
        }
    });
    
    function materialGroupFormatter(v, r, i){
         for(var i=0;i<materialGroupList.length;i++){
            if (v == materialGroupList[i].DICTCODE_S) {
                return materialGroupList[i].DICTNAME_S;
            }
          }
    } 
    
    function showOrHide(){
        if($("#StorageArea_search_form").is(":hidden")){
            $("#StorageArea_search_form").show();
        }else{
            $("#StorageArea_search_form").hide();
        }
    }
    
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var barCode=$("#barcode_s").textbox("getValue");
    	if(barCode!=''){
    		$('#begin_created_time').datetimebox('setValue', '');
    		$('#end_created_time').datetimebox('setValue', '');
    	}
    	var opts = $("#storagearea_dg").datagrid("options");
		opts.url = 'halfpart/stockmanagement/storageArea/datagrid';
        ext.easyui.grid.search("storagearea_dg","StorageArea_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("storagearea_dg",{});
    }

    function edit() {
        var rows = $("#storagearea_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#storagearea_dg").datagrid("getRowIndex", rows[i]);
            $("#storagearea_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#storagearea_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#storagearea_dg").datagrid("getRowIndex", rows[i]);
            $("#storagearea_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#storagearea_dg");

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
            $("#storagearea_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#storagearea_dg").datagrid("rejectChanges");
    }


</script>