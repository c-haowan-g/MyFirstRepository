<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/productionManagement/mixmaterialreturn/saveChanges";
    
    $(function(){ 
  		  
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
    var opts = $("#mixmaterialreturn_dg").datagrid("options");
        opts.url = 'mix/productionManagement/mixmaterialreturn/datagrid';
        ext.easyui.grid.search("mixmaterialreturn_dg","MixMaterialReturn_search_form");
    }
    
	 /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {
    		return dictFormat(v);
    }
    
   function isornotFormatter(v,r,i){
	        if(v==0){
	             return "否";        	 
	        }else if(v==1){
	       	     return "是";  
	        }else{
	       	     return v;
	        }
	   	} 


</script>