<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
		 function codeFormatter(v,r,i){
		    	
		    	return dictFormat(v);
		    }
	 	
    function queryBar() {
		$("#EntDetial_dg_toolbar").toggle(500);
	}
    /**
     * 查询方法
     */
     function doSearch(){
    	var opts = $("#detial_dg").datagrid("options");
 		opts.url = 'finalcheck/qualityInspectionRecord/appearanceOperatingDetial/datagrid2';
    	var starttime =$("#start_opertime_t").datetimebox("getValue");
    	var endtime=$("#end_opertime_t").datetimebox("getValue");
    	if((starttime!=""&&endtime=="")||(starttime==""&&endtime!="")){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			ext.easyui.grid.search("detial_dg","Detial_search_form");
    		}
    	}else{
    		ext.easyui.grid.search("detial_dg","Detial_search_form");
    	}
 		
 	}
    
     /**
      * 返修品查询方法
      */
      function fanxiuSearch(){
     	var opts = $("#detial_dg").datagrid("options");
  		opts.url = 'finalcheck/qualityInspectionRecord/appearanceOperatingDetial/fanxiuSearch';
     	var starttime =$("#start_opertime_t").datetimebox("getValue");
     	var endtime=$("#end_opertime_t").datetimebox("getValue");
     	if((starttime!=""&&endtime=="")||(starttime==""&&endtime!="")){
     		ext.tip.error("时间输入范围不完整");
     		return;
     	}
     	if(starttime!="" && endtime!=""){
     		if(starttime>endtime){
     			ext.tip.error("<spring:message code="tip.date" />");
     		}else{
     			ext.easyui.grid.search("detial_dg","Detial_search_form");
     		}
     	}else{
     		ext.easyui.grid.search("detial_dg","Detial_search_form");
     	}
  		
  	}
    
      function levFormatter(v,r,i){
       	if(v=='1'){
       		return '割毛';
       	}else if(v=='2'){
       		return '返修';
       	}else{
       		return '正常';
       	}
       }
    
    
   //设定时间初始值从当前时间00:00:00至23:59:59
 	$(document).ready(function() {
 		$('#start_opertime_t').datetimebox({
 			value : '3/4/2010 00:00:00',
 			required : true,
 			showSeconds : true
 		});
 		$('#end_opertime_t').datetimebox({
 			value : '3/4/2010 23:59:59',
 			required : true,
 			showSeconds : true
 		});
 		doSearch();
 	});

    
</script>