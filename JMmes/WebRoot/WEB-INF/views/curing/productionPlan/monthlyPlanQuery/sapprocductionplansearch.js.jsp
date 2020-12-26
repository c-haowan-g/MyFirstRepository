<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function dateChangeFormatter(v,r,i){
    	return v.substr(0,10);
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("sapprocductionplansearch_dg","SapProcductionPlanSearch_search_form");
    }
    
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
    
    $(document).ready(function(){
		$("#month_i").datetimespinner("setValue",formatter2(new Date()));
		filter();
	});
    
    function onBeforeLoad(param){
		if(param["filter[month_i]"]!=undefined){
			param["filter[month_i]"]=param["filter[month_i]"].replace("-","");
		}
	}
    
    function completionRate(value,row,index){
    	if(row.quantity_plan_f!=null && row.quantity_actual_f!=null && row.quantity_plan_f!=0){
    		var num=(row.quantity_actual_f/row.quantity_plan_f)*100;
    		return num.toFixed(2)+"%";
    	}
    	return "";
    	
    }

</script>