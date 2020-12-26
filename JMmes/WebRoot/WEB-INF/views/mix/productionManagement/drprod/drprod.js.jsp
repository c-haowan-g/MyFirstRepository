<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">    
     
     
     
     //加载密炼机台信息
  	var equiplist=[];
 	$.ajax({
 		url:"mix/productionManagement/drrecord/getMixProductionInfo?plantype="+"051003",
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
    	var opts = $("#drprod_dg").datagrid("options");
        opts.url = 'mix/productionManagement/drprod/datagrid';
        ext.easyui.grid.search("drprod_dg","Drprod_search_form");
    }
    
 	 /**
     * 重新下发
     */
       function downward(){
   	    var rows= $("#drprod_dg").datagrid("getChecked");
	  	if(rows.length==0){
	  		ext.tip.warn(tip.atLeastOneSelected);
	  		return;
	  	}
	  	var ids=[];
	  	for(var i=0;i<rows.length;i++){
	  		ids.push(rows[i].atr_key);
	  	}
	  	ext.ajax.post("mix/productionManagement/drprod/downward",{ids:ids.toString()},function(data){
	  		if(data.code!=OK){
	  			ext.tip.error(data.message);
	  		}
	  		showConfirm(data.data);
		    filter();
	  	});
    }
    	//显示操作结果
	function showConfirm(msg){
		   $.messager.confirm({
			    width: 700,
			    height: 350,
			    title: '提示',
			    msg: msg,
			    fn: function (r) {
			        }
			    }
			);
	}
    /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {

    	return dictFormat(v);
    }
    
    
     function isbindtrainFormatter(v,r,i){
        if(v==0){
             return "否";        	 
        }else if(v==1){
       	     return "是";  
        }else{
       	     return v;
        }
   } 
   
     function cuttypeFormatter(v,r,i){
        if(v==1){
             return "手动切胶";        	 
        }else if(v==2){
       	     return "自动切胶";  
        }else{
       	     return v;
        }
   }      	

     function ischeckFormatter(v,r,i){
        if(v==0){
             return "否";        	 
        }else if(v==1){
       	     return "是";  
        }else{
       	     return v;
        }
   }   
   
    function isbindtrainFormatter(v,r,i){
        if(v==0){
             return "否";        	 
        }else if(v==1){
       	     return "是";  
        }else{
       	     return v;
        }
   }   
   
        function isselfcheckFormatter(v,r,i){
	        if(v==0){
	             return "合格";        	 
	        }else if(v==1){
	       	     return "不合格";  
	        }else{
	       	     return v;
	        }
	   }   
   
        function rfidisokFormatter(v,r,i){
	        if(v==0){
	             return "失败";        	 
	        }else if(v==1){
	       	     return "成功";  
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

        function synchandflagFormatter(v,r,i){
	        if(v==0){
	             return "未处理";        	 
	        }else if(v==1){
	       	     return "已处理";  
	        }else{
	       	     return v;
	        }
   }  
   
   		function issuedFormatter(v,r,i){
        	if(v==0){
            	 return "未下发";        	 
	        }else if(v==1){
	       	     return "已下发";  
	        }else if(v==2){
	        	 return "重新下发"
	        }else{
	       	     return v;
	        }
  		 }  
  		 
  		 
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
		
	  	//为了初始化页面显示“暂无数据”
	    $("#carrier").textbox("setValue","**&&***");
	    ext.easyui.grid.search("drprodimplement_dg","Drprodimplement_search_form");
	  	//点击胶料产出实绩，胶料车次产出实绩出现相关信息
	    $('#drprod_dg').datagrid({
	     //单击事件   
	 		 onClickRow:function(rowIndex,rowData){
	 		 var rows = $("#drprod_dg").datagrid("getSelections");
	 		 var carrier_code_s=rows[0].carrier_code_s;
	 		 $("#carrier").textbox("setValue",carrier_code_s);
	 			ext.easyui.grid.search("drprodimplement_dg","Drprodimplement_search_form");
	 		}
	     });
  });
</script>