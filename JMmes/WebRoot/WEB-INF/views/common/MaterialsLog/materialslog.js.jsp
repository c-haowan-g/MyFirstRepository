<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

  
    
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
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
    			var opts = $("#materialslog_dg").datagrid("options");
    	        opts.url = 'sap/MaterialLog/getData';
    			   ext.easyui.grid.search("materialslog_dg","MaterialsLog_search_form");
    		}
    	}else{
    		var opts = $("#materialslog_dg").datagrid("options");
	        opts.url = 'sap/MaterialLog/getData';
    		   ext.easyui.grid.search("materialslog_dg","MaterialsLog_search_form");
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