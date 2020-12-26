<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">



    
    function showOrHide(){
        if($("#WorkOrderResult_search_form").is(":hidden")){
            $("#WorkOrderResult_search_form").show();
        }else{
            $("#WorkOrderResult_search_form").hide();
        }
    }
    
 
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("appearanceSortingScanningRate_dg","appearanceSortingScanningRate_search_form");
    }
    




    //设定时间初始值从当前时间00:00:00至23:59:59
     $(function(){
    	$("#start_time").datetimebox({
    		value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	$("#end_time").datetimebox({
    		 value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    	var opts = $("#appearanceSortingScanningRate_dg").datagrid("options");
		opts.url = 'finalcheck/reportCenter/sortingrate/getAll';
    	ext.easyui.grid.search("appearanceSortingScanningRate_dg","appearanceSortingScanningRate_search_form");
    }); 
    
/*      function Textformatter(v,r,i){
    	 if(v==1){
    		 return	 "动平衡设备"+1+"#";
    	 }else if(v==2){
    		 return	 "动平衡设备"+2+"#";
    	 }else{
    		 return	 "动平衡设备"+3+"#";
    	 }
     	
     } */
   
     function spFormatter(v,r,i){
     	return v+"%";
     }

</script>