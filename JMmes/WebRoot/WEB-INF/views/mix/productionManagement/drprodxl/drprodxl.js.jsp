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
    
     //加载小料机台信息
  	var equiplist=[];
 	$.ajax({
 		url:"mix/productionManagement/drrecord/getMixProductionInfo?plantype="+"051001",
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
   		var opts = $("#drprodxl_dg").datagrid("options");
        opts.url = 'mix/productionManagement/drprodxl/datagrid';
        ext.easyui.grid.search("drprodxl_dg","Drprodxl_search_form");
    }
    
    
    function selectrow(){
     
      var rows=$("#drprodxl_dg").datagrid('getSelected');
      var recipe_code_s=rows.recipe_code_s;
      var recipeprod_id_s=rows.lot_no_s;   
      var sync_wo_no_s=rows.wo_no_s;
      
      //加载子表信息
    	ext.ajax.post("mix/qualityManagement/plmmixrecipeexechis/datagrid",{"filter[recipe_code_s]":recipe_code_s,"filter[sync_wo_no_s]":sync_wo_no_s,all:1 },function(data){
    		 $('#mixmrecipeexechis_dg').datagrid('loadData', data);  		
    	});
    	 ext.ajax.post("mix/productionManagement/mixrecipeweightprod/datagrid",{"filter[recipeprod_id_s]":recipeprod_id_s,all:1},function(data){  	 
    		 $('#mixrecipeweightprod_dg').datagrid('loadData', data);  		
    	});

    }
    /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {

    		return dictFormat(v);
    	}
     function warningsgnFormatter(v,r,i){
        if(v==0){
             return "正常";        	 
        }else if(v==1){
       	     return "超差";  
        }else{
       	     return v;
        }
      }


   	
   	function isuseareatempFormatter(v,r,i){
        if(v==0){
             return "不使用";        	 
        }else if(v==1){
       	     return "使用";  
        }else{
       	     return v;
        }
   }


   
      function datasourceFormatter(v,r,i){
        if(v==0){
             return "PLM原数据";        	 
        }else if(v==1){
       	     return "自动生成";  
        }else{
       	     return v;
        }
   } 
    function datasourcetypeFormatter(v,r,i){
        if(v==0){
             return "上辅机配方";        	 
        }else if(v==1){
       	     return "配料系统配方";  
        }else{
       	     return v;
        }
   } 
   
   

   
        function recordflagFormatter(v,r,i){
        if(v='A'){
             return "可用";        	 
        }else if(v='D'){
       	     return "删除";  
        }else{
       	     return v;
        }
   } 
 
 
   function sendstateFormatter(v,r,i){
        if(v==0){
             return "未下发";        	 
        }else if(v==1){
       	     return "已下发";  
        }else if(v==2){
       	     return "下发失败";  
        }else{
       	     return v;
        }
   } 
 
         function syncflagFormatter(v,r,i){
        if(v='A'){
             return "新增";        	 
        }else if(v='U'){
       	     return "修改";  
        }else if(v='D'){
       	     return "删除";  
        }else{
       	     return v;
        }
   } 
   
        function synchandflagflhandFormatter(v,r,i){
        if(v==0){
             return "未处理";        	 
        }else if(v==1){
       	     return "已处理";  
        }else if(v==2){
       	     return "处理失败";  
        }else{
       	     return v;
        }
   } 
   
   
      function checkstateFormatter(v,r,i){
        if(v==0){
             return "未审核";        	 
        }else if(v==1){
       	     return "已审核";  
        }else{
       	     return v;
        }
   } 
</script>