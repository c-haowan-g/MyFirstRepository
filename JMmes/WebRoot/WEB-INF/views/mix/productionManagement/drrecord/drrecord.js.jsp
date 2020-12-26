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
		filter1();
	});
     
    //加载密炼机台信息
  	var equiplist=[];
 	$.ajax({
 		url:"mix/productionManagement/drrecord/getMixProductionInfo?plantype="+"051004",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			equiplist=data;
 		}
 	});
    
     function searchProductionLine(q, row) {
	 	var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}
    /**
     * 查询方法
     */
    var filter=function(){
   		var opts = $("#drrecord_dg").datagrid("options");
        opts.url = 'mix/productionManagement/drrecord/datagrid';
        ext.easyui.grid.search("drrecord_dg","Drrecord_search_form");
    }

	 /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {
    		return dictFormat(v);
    }
      /**
     * 查询方法
     */
    var filter1=function(){
    	var opts = $("#drrequest_dg").datagrid("options");
        opts.url = 'mix/productionmanagement/drrequest/datagrid';
        ext.easyui.grid.search("drrequest_dg","Drrequest_search_form");
    }
    
    function useglueFormatter(v,r,i){
	        if(v==0){
	             return "不掺胶";        	 
	        }else if(v==1){
	       	     return "掺胶";  
	        }else{
	       	     return v;
	        }
	   	} 
	   	
	   	function formulastatusFormatter(v,r,i){
        	if(v=="ZC"){
            	 return "正常";        	 
	        }else if(v=="BZC"){
	       	     return "不正常";  
	        }else if(v=="SY"){
	        	 return "实验";
	        }else{
	       	     return v;
	        }
  		 }  
  		 
  		 	function formulastyleFormatter(v,r,i){
        	if(v==1){
            	 return "正常";        	 
	        }else if(v==2){
	       	     return "反炼";  
	        }else if(v==3){
	        	 return "洗车";
	        }else if(v==4){
	       	     return "反洗";
	        }else if(v==5){
	        	return "正洗";
	        }else{
	        	return v;
	        }
  		 }  
    
</script>