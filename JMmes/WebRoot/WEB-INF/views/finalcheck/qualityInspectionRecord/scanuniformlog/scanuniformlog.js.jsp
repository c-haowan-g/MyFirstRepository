<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#ScanUniformLog_search_form").is(":hidden")){
            $("#ScanUniformLog_search_form").show();
        }else{
            $("#ScanUniformLog_search_form").hide();
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
 	
	function etypeFormatter(v, r, i) {
        if(v!=0){
		    return dictFormat(v);
        }else{
        	return "无";
        }
	}
    //工控下发是否成功
    function writein(v, r, i) {

		if (v == 1) {
			return "成功";
		}
		return "失败";
	}
    //MES校验是否成功
    function isok(v, r, i) {

		if (v == 1) {
			return "成功";
		}
		return "失败";
	}
    /**
     * 查询方法
     */
    var filter=function(){
    	var startTime = $('#begin_created_time').datebox("getValue");
		var endTime = $('#end_created_time').datebox("getValue");
		if ((startTime != "" && endTime == "")
				|| (startTime == "" && endTime != "")) {
			ext.tip.error("时间输入范围不完整");
			return;
		}
		var opts = $("#scanuniformlog_dg").datagrid("options");
		opts.url = 'finalcheck/qualityInspectionRecord/scanUniformLog/datagrid';
        ext.easyui.grid.search("scanuniformlog_dg","ScanUniformLog_search_form");
    }

  //设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
	});

</script>