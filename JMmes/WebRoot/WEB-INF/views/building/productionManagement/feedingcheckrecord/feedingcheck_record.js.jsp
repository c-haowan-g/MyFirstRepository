<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/productionManagement/feedingCheck_Record/saveChanges";
    
    function showOrHide(){
        if($("#FeedingCheck_Record_search_form").is(":hidden")){
            $("#FeedingCheck_Record_search_form").show();
        }else{
            $("#FeedingCheck_Record_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
    //隐藏显示查询栏
    function queryBar(){
    	$("#FeedingCheck_Record_search_form").toggle(500);
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
		var opts = $("#feedingcheck_record_dg").datagrid("options");
		opts.url ='building/productionManagement/feedingCheck_Record/datagrid';
    	ext.easyui.grid.search("feedingcheck_record_dg","FeedingCheck_Record_search_form");
		
	});
    
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			$("#feedingcheck_record_dg").datagrid("options").url="building/productionManagement/feedingCheck_Record/datagrid";
    			   var a = ext.easyui.grid.search("feedingcheck_record_dg","FeedingCheck_Record_search_form");
    		}
    	}else{
    		$("#feedingcheck_record_dg").datagrid("options").url="building/productionManagement/feedingCheck_Record/datagrid";
    		   ext.easyui.grid.search("feedingcheck_record_dg","FeedingCheck_Record_search_form");
    	}
    	
        //ext.easyui.grid.search("feedingcheck_record_dg","FeedingCheck_Record_search_form");
    }
    
    //扫描类型格式化
    function scanTypeFormat(value,row,index){
    	 if((value=="1")){
     		return "客户端记录";
     	}else if((value=="2")){
     		return "服务端记录";
     	}
     }
    
    function add() {
        ext.easyui.grid.appendAndEdit("feedingcheck_record_dg",{});
    }

    function edit() {
        var rows = $("#feedingcheck_record_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#feedingcheck_record_dg").datagrid("getRowIndex", rows[i]);
            $("#feedingcheck_record_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#feedingcheck_record_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#feedingcheck_record_dg").datagrid("getRowIndex", rows[i]);
            $("#feedingcheck_record_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#feedingcheck_record_dg");

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
            $("#feedingcheck_record_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#feedingcheck_record_dg").datagrid("rejectChanges");
    }


</script>