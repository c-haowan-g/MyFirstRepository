<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

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
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#capsule_dg").datagrid("options");
		opts.url = 'curing/moldManagement/capsule/datagrid';
        ext.easyui.grid.search("capsule_dg","Capsule_search_form");
    };
    
    function codeFormatter(v, r, i) {
	    return dictFormat(v);
    }
    
    function toUserName(v, r, i) {
	 	if(v == null) {
    		return v;
    	}
		$.ajax({
			url : 'halfpart/basedata/equipmentMaterial/toUserName',
			type : 'get',
			dataType : 'json',
			data: {
				usercode: v
			},
			async : false,
			success : function(data) {
				if(data.length == 0) {
					return v;
				}
				v = data[0].username;
			}
		});
		return v;
	}

</script>