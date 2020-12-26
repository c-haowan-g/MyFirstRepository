<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#CheckXrayLog_search_form").is(":hidden")){
            $("#CheckXrayLog_search_form").show();
        }else{
            $("#CheckXrayLog_search_form").hide();
        }
    }
    
    /**
     * 接收combtree数据
     */
     var DICT_252=[];
 	
 	$.ajax({
 		url:"dict/code/252",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_252=data;
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
    	var opts = $("#checkxraylog_dg").datagrid("options");
        opts.url = 'finalcheck/qualityInspectionRecord/checkXrayLog/datagrid';
       // $("#checkxraylog_dg").datagrid("load");
        ext.easyui.grid.search("checkxraylog_dg","CheckXrayLog_search_form");
    }
    
      //隐藏查询栏
    function searchBar()
	{
		$("#CheckXrayLog_search_form").toggle();
	}
      
    function codeFormatter(v, r, i) {

		return dictFormat(v);
		
	}
    
    function onBeforeLoad(){
    	var begintime=$("#begin_created_time").datetimebox('getValue');
    	var endtime=$("#end_created_time").datetimebox('getValue');
    	if(begintime!=null&&endtime!=null)
    		 filter();
    	else
    		return false;
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