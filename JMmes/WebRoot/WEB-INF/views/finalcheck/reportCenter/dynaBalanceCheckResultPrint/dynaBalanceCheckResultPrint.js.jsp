<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
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
	});
	
	function getData(){
		var starttime =$("#begin_created_time").datetimebox("getValue");
		var endtime=$("#end_created_time").datetimebox("getValue");
		var checked=$('input[type=checkbox]:checked');
	    if('undefined'==typeof(checked.val())){
	      	ext.tip.error("<spring:message code="tip.noSelect" />");
	      	return;
	    }
		var sumFlag=new Array();
	    $.each(checked,function(){
	    	sumFlag.push($(this).val());
	    });
		if(starttime!="" && endtime!=""){
			if(starttime>endtime){
				ext.tip.error("<spring:message code="tip.date" />");
				return;
			}else{
				var selectfieldarray=new Array();
		    	var unselectfieldarray=new Array();
		    	if($("#curingmachinecode_s").is(":checked")){
		    		selectfieldarray.push('curingmachinecode_s');
		    	}else{
		    	    unselectfieldarray.push('curingmachinecode_s');
		    	}
		    	if($("#buildinmachinecode_s").is(":checked")){
		    		selectfieldarray.push('buildinmachinecode_s');
		    	}else{
		    	    unselectfieldarray.push('buildinmachinecode_s');
		    	}
		    	if($("#dynaBalancemachinecode_s").is(":checked")){
		    		selectfieldarray.push('dynabalancemachinecode_s');
		    	}else{
		    	    unselectfieldarray.push('dynabalancemachinecode_s');
		    	}
		    	$.each(selectfieldarray, function(i, val){  
	                $('#dynabalancecheresultprint_dg').datagrid('showColumn',val);
				  }); 
			    $.each(unselectfieldarray, function(i, val){  
		    	    $('#dynabalancecheresultprint_dg').datagrid('hideColumn',val);
			    }); 
				$("#dynabalancecheresultprint_dg").datagrid("options").url="finalcheck/qualityInspectionRecord/dynaBalanceCheResultPrint/filter?sumFlag="+sumFlag;
				ext.easyui.grid.search("dynabalancecheresultprint_dg","DynaBalanceCheResultPrint_search_form");
			}
		}else{
			ext.tip.error("<spring:message code="tip.date" />");
			return;
		}
	};
	
	
	/* var buildingMachineCodeName=[];
	$.ajax({
			url:"building/basedata/productline/getProductlineByProcess?process=252005",
			type:"get",
			dataType:"json",
			async:true,
			success:function(data){
				buildingMachineCodeName=data;
			}
	});
	function buildingMachineCodeFormatter(v, r, i) {
	    if(v!=null){
	    	for(var i=0;i<buildingMachineCodeName.length;i++){
	    		if(v==buildingMachineCodeName[i].p_line_name){
	    			return buildingMachineCodeName[i].description;
	    		}
	    	}
	    }else{
	    	return "补录";
	    }
    } */
	 function buildingMachineCodeFormatter(v, r, i){
		 if(v!=null){
			 return v;
		 }else{
			 return "补录"; 
		 }
	 }
	/* var curingMachineCodeName=[];
	$.ajax({
			url:"curing/baseData/curingControl/machinecontrol/searchProductionLine",
			type:"get",
			dataType:"json",
			async:true,
			success:function(data){
				curingMachineCodeName=data;
			}
	});
	function curingMachineCodeFormatter(v, r, i) {
	    if(v!=null){
	    	for(var i=0;i<curingMachineCodeName.length;i++){
	    		if(v==curingMachineCodeName[i].p_line_name){
	    			return curingMachineCodeName[i].description;
	    		}
	    	}
	    }else{
	    	return "补录";
	    }
    }  */
    
    
    
    
    //导出
	function exportExcel(){
    	var starttime =$("#begin_created_time").datetimebox("getValue");
		var endtime=$("#end_created_time").datetimebox("getValue");
		var checked=$('input[type=checkbox]:checked');
	    if('undefined'==typeof(checked.val())){
	      	ext.tip.error("<spring:message code="tip.noSelect1" />");
	      	return;
	    }
		var sumFlag=new Array();
	    $.each(checked,function(){
	    	sumFlag.push($(this).val());
	    });
	    
	    var curingspeccode=$("#curingspeccode_s").textbox("getValue");
		var url = "finalcheck/qualityInspectionRecord/dynaBalanceCheResultPrint/export?sumFlag="+sumFlag+"&starttime="+starttime+"&endtime="+endtime+"&curingspeccode="+curingspeccode;
		window.location.href=url;
	}
</script>