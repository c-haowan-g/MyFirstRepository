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
	});
    
    function showOrHide(){
        if($("#OutStoreRecord_search_form").is(":hidden")){
            $("#OutStoreRecord_search_form").show();
        }else{
            $("#OutStoreRecord_search_form").hide();
        }
    }
        
    /**
     * 查询方法
     */
    var filter=function(){
    	var val = $('#barcode_s').textbox('getValue');
    	if(val != "") {
    		$('#begin_created_time').datetimebox({
				value : '',
				required : false,
				showSeconds : true
			});
			$('#end_created_time').datetimebox({
				value : '',
				required : false,
				showSeconds : true
			});
    	}
    	var opts = $("#outstorerecord_dg").datagrid("options");
		opts.url = 'halfpart/stockManagement/outStoreRecord/datagrid';
        ext.easyui.grid.search("outstorerecord_dg","OutStoreRecord_search_form");
    };

    function codeFormatter(v, r, i) {
		if(v == null) {
			  return v;
		}
	    return dictFormat(v);
    }

</script>