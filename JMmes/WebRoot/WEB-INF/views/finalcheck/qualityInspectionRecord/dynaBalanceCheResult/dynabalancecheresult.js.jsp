<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function doExport(){
    	var param=ext.form.getFormAsJson("DynaBalanceCheResult_search_form");
    	console.log(param)
    	var param_get="";
    	
    	for(var k in param){
    		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
    	}
    	window.open(path+"finalcheck/qualitylnspectionRecord/dynaBalanceCheResult/export?s_factory_s="+factory+param_get);
    }
    
    function showOrHide(){
        if($("#DynaBalanceCheResult_search_form").is(":hidden")){
            $("#DynaBalanceCheResult_search_form").show();
        }else{
            $("#DynaBalanceCheResult_search_form").hide();
        }
    }
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
  
    
 	
 	  var entCodeName=[];
 		$.ajax({
 	 		url:"finalcheck/baseData/entmodel/SearchEnt?equip_type=254004",
 	 		type:"get",
 	 		dataType:"json",
 	 		async:true,
 	 		success:function(data){
 	 			entCodeName=data;
 	 		}
 	 	});
 	    
 	    function entCodeFormatter(v,r,i){
 	    	for(var i=0;i<entCodeName.length;i++){
 	    		if(v==entCodeName[i].EQUIP_NAME){
 	    			return entCodeName[i].DESCRIPTION;
 	    		}
 	    	}
 	    }
 	function testmodeFormatter(v){
 		if(v==0){
 			return "正常测试";
 		}else if(v==1){
 			return "精度测试";
 		}else{
 			return v;
 		}
 	}
    /**
     * 查询方法
     */
    
    function filter(){
    	var startTime= $('#begin_created_time').datebox("getValue");
	    var endTime= $('#end_created_time').datebox("getValue");
	    if((startTime!=""&&endTime=="")||(startTime==""&&endTime!="")){
	    	ext.tip.error("时间输入范围不完整");
	    	return;
	    }
    	var opts = $("#dynabalancecheresult_dg").datagrid("options");
        opts.url = 'finalcheck/qualitylnspectionRecord/dynaBalanceCheResult/datagrid';
       // $("#dynabalancecheresult_dg").datagrid("load");
    	
        ext.easyui.grid.search("dynabalancecheresult_dg","DynaBalanceCheResult_search_form");
    }
    
    //隐藏查询栏
    function searchBar()
	{
		$("#DynaBalanceCheResult_search_form").toggle();
	}
    
  	//设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
    	$('#begin_created_time').datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	$('#end_created_time').datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    		filter();
    	});


</script>