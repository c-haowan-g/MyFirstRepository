<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    var saveChanges=path+"sap/VendorLog/saveChanges";
    
    function showOrHide(){
        if($("#VendorLog_search_form").is(":hidden")){
            $("#VendorLog_search_form").show();
        }else{
            $("#VendorLog_search_form").hide();
        }
    }
    
    
    /**
     * 查询方法
     */
    var filter=function(){
    	
        var start_time =$("#start_time").datetimebox("getValue");
    	var end_time=$("#end_time").datetimebox("getValue");
    	if(start_time!="" && end_time!=""){
    		if(start_time>end_time){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			var opts = $("#vendorlog_dg").datagrid("options");
    	        opts.url = 'sap/VendorLog/VendorLog/datagridOn';
    	        ext.easyui.grid.search("vendorlog_dg","VendorLog_search_form");
    		}
    	}else{
    		var opts = $("#vendorlog_dg").datagrid("options");
    		  opts.url = 'sap/VendorLog/VendorLog/datagridOn';
	        ext.easyui.grid.search("vendorlog_dg","VendorLog_search_form");
    	}
    };
    
    
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