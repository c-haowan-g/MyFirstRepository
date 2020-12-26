<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	 $(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	    filter();
	});
    function showOrHide(){
        if($("#WorkOrderResultNotCuring_search_form").is(":hidden")){
            $("#WorkOrderResultNotCuring_search_form").show();
        }else{
            $("#WorkOrderResultNotCuring_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var startTime= $('#begin_created_time').datebox("getValue");
	    var endTime= $('#end_created_time').datebox("getValue");
	    if((startTime!=""&&endTime=="")||(startTime==""&&endTime!="")){
	    	ext.tip.error("时间输入范围不完整");
	    	return;
	    }
    	var opts = $("#workorderresultnotcuring_dg").datagrid("options");
		opts.url = 'building/productionManagement/workOrderResult/searchWorkOrderResultByNotCuring';
        ext.easyui.grid.search("workorderresultnotcuring_dg","WorkOrderResultNotCuring_search_form");
    };
</script>