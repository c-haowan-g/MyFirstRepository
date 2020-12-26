<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/reportquery/tireupdateresume/saveChanges";
    
    function showOrHide(){
    	if($("#TireUpdateResume_search_form").is(":hidden")){
            $("#TireUpdateResume_search_form").show();
        }else{
            $("#TireUpdateResume_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	 ext.easyui.grid.search("tireupdateresume_dg","TireUpdateResume_search_form");
    }
    
    function queryBar() {
		$("#TireUpdateResume_search_form").toggle(500);
	}
   
   //设定时间初始值从当前时间00:00:00至23:59:59
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
     
    
    


</script>