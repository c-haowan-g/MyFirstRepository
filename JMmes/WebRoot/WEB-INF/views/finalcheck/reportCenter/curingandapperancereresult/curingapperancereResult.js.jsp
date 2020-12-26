
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var saveChanges=path+"finalcheck/reportCenter/curing/saveChanges";
    
    function showOrHide(){
        if($("#curingAndApperanceQualification_search_form").is(":hidden")){
            $("#curingAndApperanceQualification_search_form").show();
        }else{
            $("#curingAndApperanceQualification_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#curingAndApperanceQualification_dg").datagrid("options");
    	opts.url = 'finalcheck/reportCenter/curing/getCuringAndAppearanceQualification';
        ext.easyui.grid.search("curingAndApperanceQualification_dg","curingAndApperanceQualification_search_form");
    };
    
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
    	filter();
    });
	
	function reworkpreossFormatter(v,r,i){
		if(r.appearancecheckoutputcount==0){
			return "100.00%";
		}else{
			var rate=(r.appearancecheckoutputcount-r.failcount)/r.appearancecheckoutputcount*100;
			return rate.toFixed(2)+"%";
		}
	}
	//加载上方下拉框产线信息
	 var jtxx=[];
	    $.ajax({
	    	url:'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
	    	type:'get',
	    	dataType:'json',
	    	async:false,
	    	success:function(data){
	    		console.log(data);
	    		jtxx=data;
	    	}
	    });
	
  
</script>