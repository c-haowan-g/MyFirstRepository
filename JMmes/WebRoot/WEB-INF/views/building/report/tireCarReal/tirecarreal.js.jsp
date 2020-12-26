<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/reportquery/tirecarreal/saveChanges";
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("tirecarreal_dg","TireCarReal_search_form");
    };
    
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
	
	function toUserName(v, r, i) {
	 	if(v == null) {
    		return v;
    	}
		$.ajax({
			url : 'building/reportquery/tirecarreal/toUserName',
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