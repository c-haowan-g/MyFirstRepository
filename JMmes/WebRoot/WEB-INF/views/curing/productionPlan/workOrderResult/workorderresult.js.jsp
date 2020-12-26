<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#WorkOrderResult_search_form").is(":hidden")){
            $("#WorkOrderResult_search_form").show();
        }else{
            $("#WorkOrderResult_search_form").hide();
        }
    }
    
    function formatRate(v,r,i){
    	if(v == null){
    		return '0.00%';
    	}
    	else{
    		return v;
    	}
    }
    
    
    /**
     * 日期格式化
     */
    function dateFormat(date){
    	return new Calendar(date).format("yyyyMMdd");
    }
    
    /**
     * 解析指定格式日期
     */
    function dateParser(s){
    	if(!s)return new Date();
    	return new Date(s.substring(0,4),parseInt(s.substring(4,6))-1,s.substring(6,8));
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("workorderresult_dg","WorkOrderResult_search_form");
    }
    
    function onDgBeforeLoad(param){
    	if($("#production_date_s").datebox("getValue")==""){
    		return false;
    	}
    	param["filter[production_date_s]"]=$("#production_date_s").datebox("getValue");
    }



</script>