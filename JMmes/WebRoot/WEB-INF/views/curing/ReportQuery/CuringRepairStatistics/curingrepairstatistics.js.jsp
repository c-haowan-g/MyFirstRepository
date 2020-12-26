<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function showOrHide(){
        if($("#CuringRepairStatistics_search_form").is(":hidden")){
            $("#CuringRepairStatistics_search_form").show();
        }else{
            $("#CuringRepairStatistics_search_form").hide();
        }
    }
    
    $(document).ready(function() {
		/* $('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		}); */
		$("#month_s").datetimespinner("setValue",formatter2(new Date()));
	});
    
    function formatter2(date){
		return date==null?"":new Calendar(date).format('yyyy-MM');
	}
    
    function parser2(s){
		if (!s){return null;}
		var ss = s.split('-');
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		if (!isNaN(y) && !isNaN(m)){
			return new Date(y,m-1,1);
		} else {
			return new Date();
		}
	}
    
    function getFormJson(formId){
	    if($("#"+formId).length==0){
	        return {};
	    }
		
	    var formJsonArray=$("#"+formId).serializeArray();
	    
	    var likes=$("#"+formId+" [like=true]");
	    var ins=$("#"+formId+" [in=true]");
	    var beginWith=$("#"+formId+" [beginWith=true]");
	    var endWith=$("#"+formId+" [endWith=true]");
	    
	    var operators={};
	    $.each(likes,function(index,e){
	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
	    	operators[eleName]="contains:";
	    });
	    $.each(ins,function(index,e){
	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
	    	operators[eleName]="in:";
	    });
	    
	    $.each(beginWith,function(index,e){
	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
	    	operators[eleName]="beginWith:";
	    });
	    
	    $.each(endWith,function(index,e){
	    	eleName=Utils.isEmpty($(e).attr("textboxname"))?$(e).attr("name"):$(e).attr("textboxname");
	    	operators[eleName]="endWith:";
	    });
	    
	    
	    var formJson={};
	    
	    Utils.each(formJsonArray,function(i,e){
	        if(Utils.trim(e.value)!=""){
	        	formJson[e.name]=(operators[e.name]==undefined?"":operators[e.name])+Utils.trim(e.value);
	        }
	    });
	    console.log(formJson);
	    return formJson;
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var work_id = $('#work_id').checkbox('options').checked;
    	var material_code = $('#material_code').checkbox('options').checked;
    	
    	if(work_id == true && material_code == true){
    		var opts = $("#curingrepairstatistics_dg").datagrid("options");
            opts.url = "curing/ReportQuery/CuringRepairStatistics/datagridUDA";
//             ext.easyui.grid.search("curingrepairstatistics_dg","CuringRepairStatistics_search_form");
            $("#curingrepairstatistics_dg").datagrid("reload", getFormJson("CuringRepairStatistics_search_form"));
            $('#curingrepairstatistics_dg').datagrid({ 
    			columns:[[
                	{field:'atr_key',checkbox:true},
                    {field:'worker_id_s',title:'<spring:message code="curingrepairstatistics.column.worker_id_s" />',width:80},
                    {field:'material_code_s',title:'<spring:message code="curingrepairstatistics.column.material_code_s" />',width:80},
                    {field:'mterial_desc_s',title:'<spring:message code="curingrepairstatistics.column.mterial_desc_s" />',width:360},
                    {field:'month_s',title:'<spring:message code="curingrepairstatistics.column.month_s" />',width:80},
                    {field:'total_num_i',title:'<spring:message code="curingrepairstatistics.column.total_num_i" />',width:80},
                    {field:'oneday_i',title:'<spring:message code="curingrepairstatistics.column.oneday_i" />',width:80},
                    {field:'twoday_i',title:'<spring:message code="curingrepairstatistics.column.twoday_i" />',width:80},
                    {field:'threeday_i',title:'<spring:message code="curingrepairstatistics.column.threeday_i" />',width:80},
                    {field:'fourday_i',title:'<spring:message code="curingrepairstatistics.column.fourday_i" />',width:80},
                    {field:'fiveday_i',title:'<spring:message code="curingrepairstatistics.column.fiveday_i" />',width:80},
                    {field:'sixday_i',title:'<spring:message code="curingrepairstatistics.column.sixday_i" />',width:80},
                    {field:'sevenday_i',title:'<spring:message code="curingrepairstatistics.column.sevenday_i" />',width:80},
                    {field:'eightday_i',title:'<spring:message code="curingrepairstatistics.column.eightday_i" />',width:80},
                    {field:'nineday_i',title:'<spring:message code="curingrepairstatistics.column.nineday_i" />',width:80},
                    {field:'tenday_i',title:'<spring:message code="curingrepairstatistics.column.tenday_i" />',width:80},
                    {field:'elevenday_i',title:'<spring:message code="curingrepairstatistics.column.elevenday_i" />',width:80},
                    {field:'twelvenday_i',title:'<spring:message code="curingrepairstatistics.column.twelvenday_i" />',width:80},
                    {field:'thirteenday_i',title:'<spring:message code="curingrepairstatistics.column.thirteenday_i" />',width:80},
                    {field:'fourteenday_i',title:'<spring:message code="curingrepairstatistics.column.fourteenday_i" />',width:80},
                    {field:'fifteenday_i',title:'<spring:message code="curingrepairstatistics.column.fifteenday_i" />',width:80},
                    {field:'sixteenday_i',title:'<spring:message code="curingrepairstatistics.column.sixteenday_i" />',width:80},
                    {field:'seventeenday_i',title:'<spring:message code="curingrepairstatistics.column.seventeenday_i" />',width:80},
                    {field:'eighteenday_i',title:'<spring:message code="curingrepairstatistics.column.eighteenday_i" />',width:80},
                    {field:'ninteenday_i',title:'<spring:message code="curingrepairstatistics.column.ninteenday_i" />',width:80},
                    {field:'twentyday_i',title:'<spring:message code="curingrepairstatistics.column.twentyday_i" />',width:80},
                    {field:'twentyoneday_i',title:'<spring:message code="curingrepairstatistics.column.twentyoneday_i" />',width:80},
                    {field:'twentytwoday_i',title:'<spring:message code="curingrepairstatistics.column.twentytwoday_i" />',width:80},
                    {field:'twentythreeday_i',title:'<spring:message code="curingrepairstatistics.column.twentythreeday_i" />',width:80},
                    {field:'twentyfourday_i',title:'<spring:message code="curingrepairstatistics.column.twentyfourday_i" />',width:80},
                    {field:'twentyfiveday_i',title:'<spring:message code="curingrepairstatistics.column.twentyfiveday_i" />',width:80},
                    {field:'twentysixday_i',title:'<spring:message code="curingrepairstatistics.column.twentysixday_i" />',width:80},
                    {field:'twentysevenday_i',title:'<spring:message code="curingrepairstatistics.column.twentysevenday_i" />',width:80},
                    {field:'twentyeightday_i',title:'<spring:message code="curingrepairstatistics.column.twentyeightday_i" />',width:80},
                    {field:'twentynineday_i',title:'<spring:message code="curingrepairstatistics.column.twentynineday_i" />',width:80},
                    {field:'thirtyday_i',title:'<spring:message code="curingrepairstatistics.column.thirtyday_i" />',width:80},
                    {field:'thirtyoneday_i',title:'<spring:message code="curingrepairstatistics.column.thirtyoneday_i" />',width:80}
                ]]
            });
    	}
    	
    	if(work_id == true && material_code == false){
    		var opts = $("#curingrepairstatistics_dg").datagrid("options");
            opts.url = "curing/ReportQuery/CuringRepairStatistics/datagridUDA";
            ext.easyui.grid.search("curingrepairstatistics_dg","CuringRepairStatistics_search_form");
            $('#curingrepairstatistics_dg').datagrid({ 
    			columns:[[
                	{field:'atr_key',checkbox:true},
                	{field:'worker_id_s',title:'<spring:message code="curingrepairstatistics.column.worker_id_s" />',width:80},
                	{field:'month_s',title:'<spring:message code="curingrepairstatistics.column.month_s" />',width:80},
                    {field:'total_num_i',title:'<spring:message code="curingrepairstatistics.column.total_num_i" />',width:80},
                    {field:'oneday_i',title:'<spring:message code="curingrepairstatistics.column.oneday_i" />',width:80},
                    {field:'twoday_i',title:'<spring:message code="curingrepairstatistics.column.twoday_i" />',width:80},
                    {field:'threeday_i',title:'<spring:message code="curingrepairstatistics.column.threeday_i" />',width:80},
                    {field:'fourday_i',title:'<spring:message code="curingrepairstatistics.column.fourday_i" />',width:80},
                    {field:'fiveday_i',title:'<spring:message code="curingrepairstatistics.column.fiveday_i" />',width:80},
                    {field:'sixday_i',title:'<spring:message code="curingrepairstatistics.column.sixday_i" />',width:80},
                    {field:'sevenday_i',title:'<spring:message code="curingrepairstatistics.column.sevenday_i" />',width:80},
                    {field:'eightday_i',title:'<spring:message code="curingrepairstatistics.column.eightday_i" />',width:80},
                    {field:'nineday_i',title:'<spring:message code="curingrepairstatistics.column.nineday_i" />',width:80},
                    {field:'tenday_i',title:'<spring:message code="curingrepairstatistics.column.tenday_i" />',width:80},
                    {field:'elevenday_i',title:'<spring:message code="curingrepairstatistics.column.elevenday_i" />',width:80},
                    {field:'twelvenday_i',title:'<spring:message code="curingrepairstatistics.column.twelvenday_i" />',width:80},
                    {field:'thirteenday_i',title:'<spring:message code="curingrepairstatistics.column.thirteenday_i" />',width:80},
                    {field:'fourteenday_i',title:'<spring:message code="curingrepairstatistics.column.fourteenday_i" />',width:80},
                    {field:'fifteenday_i',title:'<spring:message code="curingrepairstatistics.column.fifteenday_i" />',width:80},
                    {field:'sixteenday_i',title:'<spring:message code="curingrepairstatistics.column.sixteenday_i" />',width:80},
                    {field:'seventeenday_i',title:'<spring:message code="curingrepairstatistics.column.seventeenday_i" />',width:80},
                    {field:'eighteenday_i',title:'<spring:message code="curingrepairstatistics.column.eighteenday_i" />',width:80},
                    {field:'ninteenday_i',title:'<spring:message code="curingrepairstatistics.column.ninteenday_i" />',width:80},
                    {field:'twentyday_i',title:'<spring:message code="curingrepairstatistics.column.twentyday_i" />',width:80},
                    {field:'twentyoneday_i',title:'<spring:message code="curingrepairstatistics.column.twentyoneday_i" />',width:80},
                    {field:'twentytwoday_i',title:'<spring:message code="curingrepairstatistics.column.twentytwoday_i" />',width:80},
                    {field:'twentythreeday_i',title:'<spring:message code="curingrepairstatistics.column.twentythreeday_i" />',width:80},
                    {field:'twentyfourday_i',title:'<spring:message code="curingrepairstatistics.column.twentyfourday_i" />',width:80},
                    {field:'twentyfiveday_i',title:'<spring:message code="curingrepairstatistics.column.twentyfiveday_i" />',width:80},
                    {field:'twentysixday_i',title:'<spring:message code="curingrepairstatistics.column.twentysixday_i" />',width:80},
                    {field:'twentysevenday_i',title:'<spring:message code="curingrepairstatistics.column.twentysevenday_i" />',width:80},
                    {field:'twentyeightday_i',title:'<spring:message code="curingrepairstatistics.column.twentyeightday_i" />',width:80},
                    {field:'twentynineday_i',title:'<spring:message code="curingrepairstatistics.column.twentynineday_i" />',width:80},
                    {field:'thirtyday_i',title:'<spring:message code="curingrepairstatistics.column.thirtyday_i" />',width:80},
                    {field:'thirtyoneday_i',title:'<spring:message code="curingrepairstatistics.column.thirtyoneday_i" />',width:80}
                ]]
            });
    	}
    	
    	if(work_id == false && material_code == true){
    		var opts = $("#curingrepairstatistics_dg").datagrid("options");
            opts.url = "curing/ReportQuery/CuringRepairStatistics/datagridUDA";
            ext.easyui.grid.search("curingrepairstatistics_dg","CuringRepairStatistics_search_form");
            $('#curingrepairstatistics_dg').datagrid({ 
    			columns:[[
                	{field:'atr_key',checkbox:true},
                    {field:'material_code_s',title:'<spring:message code="curingrepairstatistics.column.material_code_s" />',width:80},
                    {field:'mterial_desc_s',title:'<spring:message code="curingrepairstatistics.column.mterial_desc_s" />',width:360},
                    {field:'total_num_i',title:'<spring:message code="curingrepairstatistics.column.total_num_i" />',width:80},
                    {field:'month_s',title:'<spring:message code="curingrepairstatistics.column.month_s" />',width:80},
                    {field:'oneday_i',title:'<spring:message code="curingrepairstatistics.column.oneday_i" />',width:80},
                    {field:'twoday_i',title:'<spring:message code="curingrepairstatistics.column.twoday_i" />',width:80},
                    {field:'threeday_i',title:'<spring:message code="curingrepairstatistics.column.threeday_i" />',width:80},
                    {field:'fourday_i',title:'<spring:message code="curingrepairstatistics.column.fourday_i" />',width:80},
                    {field:'fiveday_i',title:'<spring:message code="curingrepairstatistics.column.fiveday_i" />',width:80},
                    {field:'sixday_i',title:'<spring:message code="curingrepairstatistics.column.sixday_i" />',width:80},
                    {field:'sevenday_i',title:'<spring:message code="curingrepairstatistics.column.sevenday_i" />',width:80},
                    {field:'eightday_i',title:'<spring:message code="curingrepairstatistics.column.eightday_i" />',width:80},
                    {field:'nineday_i',title:'<spring:message code="curingrepairstatistics.column.nineday_i" />',width:80},
                    {field:'tenday_i',title:'<spring:message code="curingrepairstatistics.column.tenday_i" />',width:80},
                    {field:'elevenday_i',title:'<spring:message code="curingrepairstatistics.column.elevenday_i" />',width:80},
                    {field:'twelvenday_i',title:'<spring:message code="curingrepairstatistics.column.twelvenday_i" />',width:80},
                    {field:'thirteenday_i',title:'<spring:message code="curingrepairstatistics.column.thirteenday_i" />',width:80},
                    {field:'fourteenday_i',title:'<spring:message code="curingrepairstatistics.column.fourteenday_i" />',width:80},
                    {field:'fifteenday_i',title:'<spring:message code="curingrepairstatistics.column.fifteenday_i" />',width:80},
                    {field:'sixteenday_i',title:'<spring:message code="curingrepairstatistics.column.sixteenday_i" />',width:80},
                    {field:'seventeenday_i',title:'<spring:message code="curingrepairstatistics.column.seventeenday_i" />',width:80},
                    {field:'eighteenday_i',title:'<spring:message code="curingrepairstatistics.column.eighteenday_i" />',width:80},
                    {field:'ninteenday_i',title:'<spring:message code="curingrepairstatistics.column.ninteenday_i" />',width:80},
                    {field:'twentyday_i',title:'<spring:message code="curingrepairstatistics.column.twentyday_i" />',width:80},
                    {field:'twentyoneday_i',title:'<spring:message code="curingrepairstatistics.column.twentyoneday_i" />',width:80},
                    {field:'twentytwoday_i',title:'<spring:message code="curingrepairstatistics.column.twentytwoday_i" />',width:80},
                    {field:'twentythreeday_i',title:'<spring:message code="curingrepairstatistics.column.twentythreeday_i" />',width:80},
                    {field:'twentyfourday_i',title:'<spring:message code="curingrepairstatistics.column.twentyfourday_i" />',width:80},
                    {field:'twentyfiveday_i',title:'<spring:message code="curingrepairstatistics.column.twentyfiveday_i" />',width:80},
                    {field:'twentysixday_i',title:'<spring:message code="curingrepairstatistics.column.twentysixday_i" />',width:80},
                    {field:'twentysevenday_i',title:'<spring:message code="curingrepairstatistics.column.twentysevenday_i" />',width:80},
                    {field:'twentyeightday_i',title:'<spring:message code="curingrepairstatistics.column.twentyeightday_i" />',width:80},
                    {field:'twentynineday_i',title:'<spring:message code="curingrepairstatistics.column.twentynineday_i" />',width:80},
                    {field:'thirtyday_i',title:'<spring:message code="curingrepairstatistics.column.thirtyday_i" />',width:80},
                    {field:'thirtyoneday_i',title:'<spring:message code="curingrepairstatistics.column.thirtyoneday_i" />',width:80}
                ]]
            });
    	}
    	
    	if(work_id == false && material_code == false){
    		ext.tip.error("统计方式不能为空");
    	}
    }
    
</script>