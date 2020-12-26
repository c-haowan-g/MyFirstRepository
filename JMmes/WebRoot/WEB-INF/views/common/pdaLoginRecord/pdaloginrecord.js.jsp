<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function showOrHide(){
        if($("#PDALogin_Record_search_form").is(":hidden")){
            $("#PDALogin_Record_search_form").show();
        }else{
            $("#PDALogin_Record_search_form").hide();
        }
    }
    
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
        ext.easyui.grid.search("pdalogin_record_dg","PDALogin_Record_search_form");
    };
    
    function factoryformatter(v, r, i) {
		if(v == "1" ){
			return "全钢"; 
		}else {
			return "半钢"; 
		}
	}
	
	function codeFormatter(v, r, i) {
        return dictFormat(v);
    }


</script>