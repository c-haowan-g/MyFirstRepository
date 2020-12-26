<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"material/reportsCenter/whiteminvrecord/saveChanges";
    
    function showOrHide(){
        if($("#WhItemInvRecord_search_form").is(":hidden")){
            $("#WhItemInvRecord_search_form").show();
        }else{
            $("#WhItemInvRecord_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	 
        ext.easyui.grid.search("whiteminvrecord_dg","WhItemInvRecord_search_form");
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
  
	  function codeFormatter(v, r, i) {

	        return dictFormat(v);
	    }
	function isTestmatFlag(v,r,i){
        if("0"==r.testmat_flag_s){
            return "否";
        }else if("1"==r.testmat_flag_s){
            return "是";
        }else{
            return "";
        }
    }

    function isPrioritymatFlag(v,r,i){
        if("0"==r.prioritymat_flag_s){
            return "无DQW检测项";
        }else if("1"==r.prioritymat_flag_s){
            return "合格";
        }else if("2"==r.prioritymat_flag_s){
            return "不合格";
        }else{
        	return "";
        }
    }

</script>