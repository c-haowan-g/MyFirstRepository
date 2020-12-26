<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

	function selectrow() {
		var rows = $("#curingprocess_dg").datagrid('getSelected');
		var ids = rows.id_s;
		var url = "common/CuringprocessLog/curingprocesslog/datagrid2?ids=" + ids;
		ext.ajax.get(url, function(data) {
			$('#curingprocess_dg2').datagrid('loadData', data);
		});
	}

	/**
	 * 查询方法
	 */
	var filter = function() {
		ext.easyui.grid.search("curingprocess_dg", "CuringProcess_search_form");
	}

	function flag(v, r, i) {

		if (v == 'A') {
			return "是";
		}
		return "否";
	}

	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

</script>