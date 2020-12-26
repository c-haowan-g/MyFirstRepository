<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}

	function showOrHide(){
        if($("#WorkList_search_form").is(":hidden")){
            $("#WorkList_search_form").show();
        }else{
            $("#WorkList_search_form").hide();
        }
    }
    //设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
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
    /**
    *查询栏
    **/
    function queryBar() {
		$("#WorkList_search_form").toggle(500);
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
     
        var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	var opts = $("#worklist_dg").datagrid("options");
		opts.url ='curing/moldManagement/mouldWorkList/getMouldWorkList';
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			   ext.easyui.grid.search("worklist_dg","WorkList_search_form");
    		}
    	}else{
    		   ext.easyui.grid.search("worklist_dg","WorkList_search_form");
    	}
    };
</script>