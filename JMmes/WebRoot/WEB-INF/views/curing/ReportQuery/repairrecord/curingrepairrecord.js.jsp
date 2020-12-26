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

    /**
     * 查询方法
     */
    var filter=function(){
    	$("#curingrepairrecord_dg").datagrid("options").url="curing/ReportQuery/CuringRepairRecord/datagrid";
        ext.easyui.grid.search("curingrepairrecord_dg","CuringRepairRecord_search_form");
    };

</script>