<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#ScanXrayLog_search_form").is(":hidden")){
            $("#ScanXrayLog_search_form").show();
        }else{
            $("#ScanXrayLog_search_form").hide();
        }
    }
    
    /**
     * 接收combtree数据
     */
     var DICT_259=[];
 	
 	$.ajax({
 		url:"dict/code/259",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_259=data;
 		}
 	});
    
    /**
     * 查询方法
     */
    function filter(){
    	  var startTime= $('#begin_created_time').datebox("getValue");
	    	var endTime= $('#end_created_time').datebox("getValue");
	    	if((startTime!=""&&endTime=="")||(startTime==""&&endTime!="")){
	    		ext.tip.error("时间输入范围不完整");
	    		return;
	    	}
    	var opts = $("#scanxraylog_dg").datagrid("options");
        opts.url = 'finalcheck/qualityInspectionRecord/scanXrayLog/datagrid';
      //  $("#scanxraylog_dg").datagrid("load");
        ext.easyui.grid.search("scanxraylog_dg","ScanXrayLog_search_form");
    }
    
    //隐藏查询栏
    function searchBar()
	{
		$("#ScanXrayLog_search_form").toggle();
	}
    
    function codeFormatter(v, r, i) {

		return dictFormat(v);
		
	}

    function mesxy(v,r,i){
		
		if(v==1){
			return "成功";
		}
		return "失败";
	}	
    
    //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
    	$('#begin_created_time').datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	$('#end_created_time').datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    	filter();
    	});


</script>