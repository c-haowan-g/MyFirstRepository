<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/production/FeedingRecord/saveChanges";
    $(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	    filter();
	});
	
    function source_sFormatter(v, r, i) {
        if(v=='0'){
            return "手持";
        }
        if(v=='1'){
        	return "RFID";
        }
        if(v=='3'){
        	return "扫描枪";
        }
    }
    
    function oneFormatter(v, r, i) {
        if(v=='0'){
            return "否";
        }
        if(v=='1'){
        	return "是";
        }
    }
    
    function syncFormatter(v, r, i) {
        if(v=='0'){
            return "未同步";
        }
        if(v=='1'){
        	return "已同步";
        }
    }
    
    
    var code137_List=[];
    $.ajax({
        url:"dict/code/137",
        type:"get",
        dataType:"json",
        async:true,
        success:function(data){
        	code137_List=data;
        }
    });
    
    function code137Formatter(v, r, i) {
    	for(var i=0;i<code137_List.length;i++){
    		 if (v == code137_List[i].code) {
    	          return code137_List[i].text;
    	     }
    	}
    }
    
    function syncFormatter(v, r, i) {
        if(v=='0'){
            return "未同步";
        }
        if(v=='1'){
        	return "已同步";
        }
    }
    
    function scanFormatter(v, r, i) {
        if(v=='0'){
            return "客户端记录";
        }
        if(v=='1'){
        	return "服务端记录";
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
    
    function machineFormatter(v, r, i) {
       for(i=0;i<productLineList.length;i++){
    	   if(v==productLineList[i].P_LINE_NAME){
    		   return productLineList[i].DESCRIPTION;
    	   }
       }    
    }
    
    function showOrHide(){
        if($("#FeedingRecord_search_form").is(":hidden")){
            $("#FeedingRecord_search_form").show();
        }else{
            $("#FeedingRecord_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        var opts = $("#feedingrecord_dg").datagrid("options");
		opts.url = 'halfpart/production/FeedingRecord/datagrid';
        ext.easyui.grid.search("feedingrecord_dg","FeedingRecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("feedingrecord_dg",{});
    }

    function edit() {
        var rows = $("#feedingrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#feedingrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#feedingrecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#feedingrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#feedingrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#feedingrecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#feedingrecord_dg");

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
            $("#feedingrecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#feedingrecord_dg").datagrid("rejectChanges");
    }
    
   function codeFormatter(v, r, i) {
    		return dictFormat(v);
    }

</script>