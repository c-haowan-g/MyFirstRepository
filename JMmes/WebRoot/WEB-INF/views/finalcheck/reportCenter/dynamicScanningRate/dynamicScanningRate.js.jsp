<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">



    
    function showOrHide(){
        if($("#WorkOrderResult_search_form").is(":hidden")){
            $("#WorkOrderResult_search_form").show();
        }else{
            $("#WorkOrderResult_search_form").hide();
        }
    }
    
 
    var entCodeName=[];
	 var dphCodeName=[];
		$.ajax({
	 		url:"common/combox_entcode",
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(data){
	 			debugger;
	 			for(var i=0;i<data.length;i++){
	 				if(data[i].ENTNAME_S.indexOf("动平衡")!=-1&&data[i].ENTNAME_S.indexOf("动平衡机")==-1){
	 					dphCodeName.push(data[i]);
	 				}
	 			}
	 			entCodeName=dphCodeName;
	 		}
	 	});
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("dynamicscanningrate_dg","dynamicscanningrate_search_form");
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
    	var opts = $("#dynamicscanningrate_dg").datagrid("options");
		opts.url = 'finalcheck/reportCenter/dynamicScanningRate/getAll';
    	ext.easyui.grid.search("dynamicscanningrate_dg","dynamicscanningrate_search_form");
    }); 
    
    function spFormatter(v,r,i){
    	return v+"%";
    }


</script>