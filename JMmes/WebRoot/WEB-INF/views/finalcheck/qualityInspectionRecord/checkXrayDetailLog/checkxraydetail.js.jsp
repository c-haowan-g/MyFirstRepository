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
        if($("#CheckXrayDetail_search_form").is(":hidden")){
            $("#CheckXrayDetail_search_form").show();
        }else{
            $("#CheckXrayDetail_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#checkxraydetail_dg").datagrid("options");
		opts.url = 'finalcheck/qualityInspectionRecord/checkXrayDetailLog/datagrid';
        ext.easyui.grid.search("checkxraydetail_dg","CheckXrayDetail_search_form");
    }
    
 	

   


</script>