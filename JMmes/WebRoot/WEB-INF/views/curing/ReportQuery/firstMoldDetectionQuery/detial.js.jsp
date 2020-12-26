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
	function doSearch() {
		var opts = $("#detial_dg").datagrid("options");
		opts.url = 'curing/ReportQuery/firstMoldDetectionQuery/getDetial';
		ext.easyui.grid.search("detial_dg", "Detial_search_form");
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