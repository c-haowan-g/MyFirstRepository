<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"unitstatus/saveChanges";
    
    function showOrHide(){
        if($("#unitstatus_search_form").is(":hidden")){
            $("#unitstatus_search_form").show();
        }else{
            $("#unitstatus_search_form").hide();
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
  //检测次数，成型硫化不保存此字段，默认
	function checknumberFormatter(v){
		if(v==null){
			return "——";
		}else{
			return v;
		}
	}
  //病象
  function reasFormatter(v){
	  if(v==null){
			return "——";
		}else{
			return v;
		}
  }
  //unit状态装换
    function showStatus(v){
    	if(v=='Created'){
    		return '创建';
    	}else if(v=='Started'){
    		return '已执行';
    	}else if(v=='Completed'){
    		return '已完成';
    	}else if(v=='Finished'){
    		return '生产结束';
    	}else if(v=='Shipped'){
    		return '发货';
    	}else if(v=='Closed'){
    		return '订单关闭';
    	}else if(v=='Received'){
    		return '生产恢复';
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
		var opts = $("#unitstatus_dg").datagrid("options");
		opts.url = "unitstatus/datagridUDA";
		 ext.easyui.grid.search("unitstatus_dg","unitstatus_search_form");
	}

    function add() {
       var rows = $("#unitstatus_dg").datagrid("getSelected");
       if(rows==null){
    	   ext.tip.error("请选择一条数据");
           return;
       }
       var step=$("#step").textbox("getValue");
       var reason=$("#reason").textbox("getValue");
       var flag=$("#flag").textbox("getValue");
       if(step!=""&&reason!=""&&flag!=""){
    	   
    	 $.ajax({
		 		url:"unitstatus/updateSerialStatus?serial_number="+rows.serial_number+"&step="+step+"&reason="+reason+"&flag="+flag,
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			$("#unitstatus_dg").datagrid("reload");
		 		} });  
       }else{
    	   ext.tip.error("生产数据不能为空");
       }
    }
    
    function scan() {
        var rows = $("#unitstatus_dg").datagrid("getSelected");
        
        var step=$("#step").textbox("getValue");
        var reason=$("#reason").textbox("getValue");
        var flag=$("#flag").textbox("getValue");
        var scan=$("#scan").textbox("getValue");
        var orderitem=$("#orderitem").textbox("getValue");
        if(step!=""&&reason!=""&&flag!=""){
     	   
     	 $.ajax({
 		 		url:"unitstatus/updateSerialStatus?serial_number="+scan+"&step="+step+"&reason="+reason+"&flag="+flag+"&orderitem="+orderitem,
 		 		type:"get",
 		 		dataType:"json",
 		 		async:false,
 		 		success:function(data){
 		 			$("#unitstatus_dg").datagrid("reload");
 		 		} });  
        }else{
     	   ext.tip.error("生产数据不能为空");
        }
     }

    function edit() {
        var rows = $("#unitstatus_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#unitstatus_dg").datagrid("getRowIndex", rows[i]);
            $("#unitstatus_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#unitstatus_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#unitstatus_dg").datagrid("getRowIndex", rows[i]);
            $("#unitstatus_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#unitstatus_dg");

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
            $("#unitstatus_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#unitstatus_dg").datagrid("rejectChanges");
    }


</script>