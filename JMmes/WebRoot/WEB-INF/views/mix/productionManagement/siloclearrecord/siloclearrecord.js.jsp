<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

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
    
    /**
     * 查询方法
     */
    var filter=function(){
  		var opts = $("#siloclearrecord_dg").datagrid("options");
        opts.url = 'mix/productionManagement/siloclearrecord/datagrid';
        ext.easyui.grid.search("siloclearrecord_dg","SiloclearRecord_search_form");
    }
    
    /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {
    		return dictFormat(v);
    }

</script>