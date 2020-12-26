<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"unithistory/saveChanges";
    
    function showOrHide(){
        if($("#unithistory_search_form").is(":hidden")){
            $("#unithistory_search_form").show();
        }else{
            $("#unithistory_search_form").hide();
        }
    }
  //设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
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

//  开始运行状态
    function start_complete_status(v){
  	  if(v=='1'){
  		  return '开始';
  	  }else if(v=='2'){
  		  return '完成';
  	  }else if(v=='3'){
  		  return '开始+完成';
  	  }
    }
    /**
     * 查询方法
     */
    var filter=function(){
		var startTime = $('#start_time').datebox("getValue");
		var endTime = $('#end_time').datebox("getValue");
		if ((startTime != "" && endTime == "")
				|| (startTime == "" && endTime != "")) {
			ext.tip.error("时间输入范围不完整");
			return;
		}
		var opts = $("#unithistory_dg").datagrid("options");
		opts.url = "unithistory/datagridUDA";
		 ext.easyui.grid.search("unithistory_dg","unithistory_search_form");
	}
    function add() {
       var rows = $("#unithistory_dg").datagrid("getSelected");
       var step=$("#step").textbox("getValue");
       var reason=$("#reason").textbox("getValue");
       if(step!=""&&reason!=""){
    	   
    	 $.ajax({
		 		url:"unithistory/updateSerialStatus?serial_number="+rows.serial_number+"&step="+step+"&reason="+reason,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			$("#unithistory_dg").datagrid("reload");
		 		} });  
       }
    }

    function edit() {
        var rows = $("#unithistory_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#unithistory_dg").datagrid("getRowIndex", rows[i]);
            $("#unithistory_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#unithistory_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#unithistory_dg").datagrid("getRowIndex", rows[i]);
            $("#unithistory_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#unithistory_dg");

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
            $("#unithistory_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#unithistory_dg").datagrid("rejectChanges");
    }


</script>