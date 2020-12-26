<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function showOrHide(){
        if($("#ScanTrimLog_search_form").is(":hidden")){
            $("#ScanTrimLog_search_form").show();
        }else{
            $("#ScanTrimLog_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {

		return dictFormat(v);
		
	}
	 /**
     * 接收combtree数据
     */
     var DICT_302=[];
 	
 	$.ajax({
 		url:"dict/code/302",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_302=data;
 		}
 	});
    
    /**
     * 查询方法
     */
    function filter(){
    	var list_map={};
    	list_map.begin_created_time= $('#begin_created_time').datetimebox('getValue');
    	list_map.end_created_time= $('#end_created_time').datetimebox('getValue');
    	list_map.class_id_s=$('#class_id_s').textbox('getValue');
    	 $.ajax({
		 		url:'finalcheck/qualityInspectionRecord/scanTrimLog/search',
		 		type:"post",
		 		dataType:"json",
		 		data : JSON.stringify(list_map),
				contentType:'application/json',
		 		async:false,
		 		success:function(data){
		 			$("#scantrimlog_dg").datagrid("loadData", data);  
		 		}
			 });
    }
    

    //隐藏查询栏
    function searchBar()
	{
		$("#ScanTrimLog_search_form").toggle();
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
	
	function classFormatter(v,r,i){
		if(v=='302001'){
			return '早班(8:00-16:00)'
		}else if(v=='302002'){
			return '中班(16:00-24:00)'
		}else if(v=='302003'){
			return '晚班(00:00-8:00)'
		}
	}
</script>