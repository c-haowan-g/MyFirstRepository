<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
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
    	var opts = $("#appearancewcstomeslog_dg").datagrid("options");
		opts.url = 'finalcheck/baseData/appearancewcstomeslog/datagrid';
        ext.easyui.grid.search("appearancewcstomeslog_dg","Appearancewcstomeslog_search_form");
    }
    
    function codeFormatter(v, r, i) {

		return dictFormat(v);
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