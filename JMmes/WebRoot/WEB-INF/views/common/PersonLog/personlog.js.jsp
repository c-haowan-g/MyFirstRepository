<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
//更新标记
var iftrans_s_formarter=function (value, rowData, rowIndex){
	if(value=="A"){
		return "新增";
	}else if(value=="D"){
		return "删除";
	}else if(value=="U"){
		return "修改";
	}else{
		return value;
	}
}
//记录标志
var record_flag_s_formarter=function (value, rowData, rowIndex){
	if(value=="A"){
		return "可用";
	}else if(value=="D"){
		return "删除";
	}else{
		return value;
	}
}
//状态
var state_s_formarter=function (value, rowData, rowIndex){
	if(value=="Y"){
		return "在职";
	}else if(value=="N"){
		return "离职";
	}else{
		return value;
	}
}
//性别
var sex_s_formarter=function (value, rowData, rowIndex){
	if(value=="1"){
		return "男";
	}else if(value=="2"){
		return "女";
	}else{
		return value;
	}
}
    
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
    			var opts = $("#personlog_dg").datagrid("options");
    	        opts.url = 'common/PersonLog/getData';
    			   ext.easyui.grid.search("personlog_dg","PersonLog_search_form");
    		}
    	}else{
    		var opts = $("#personlog_dg").datagrid("options");
            opts.url = 'common/PersonLog/getData';
    		   ext.easyui.grid.search("personlog_dg","PersonLog_search_form");
    	}
    }
    
  //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
    	$('#start_time').datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	$('#end_time').datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    	filter();
    	});

</script>