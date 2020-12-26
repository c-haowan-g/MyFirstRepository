<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
	function selectrow(){
		var rows=$("#buildingprocess_dg").datagrid('getSelected');
		var ids=rows.id_s;
		var url ="common/BuildingprocessLog/buildingprocesslog/datagrid2?ids="+ids;
		ext.ajax.get(url, function(data) {
			 $('#buildingprocess_dg2').datagrid('loadData',data);
	});
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("buildingprocess_dg","BuilDingProcess_search_form");
    	$('#buildingprocess_dg2').datagrid('loadData',[]);
    }
    
    function flag(v, r, i) {

		if (v == 'A') {
			return "是";
		}
		return "否";
	}
    
    function valuemax(v, r, i) {
		if (v == '1') {
			return "包含";
		}
		return "不包含";
	}
    
    function codeFormatter(v, r, i) {

		return dictFormat(v);
	}


</script>