<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"lh/bb/lhclbb/saveChanges";
    
    function showOrHide(){
        if($("#WorkOrderResultPrint_search_form").is(":hidden")){
            $("#WorkOrderResultPrint_search_form").show();
        }else{
            $("#WorkOrderResultPrint_search_form").hide();
        }
    }
    
    
    /**
     * 查询方法
     */
    function filter(){
    	var opts = $("#workorderresultprint_dg").datagrid("options");
		opts.url = 'building/qualitymanagement/buildquota/searchsingleyield';
        ext.easyui.grid.search("workorderresultprint_dg","WorkOrderResultPrint_search_form");
    }
    /**
     * 查询产线
     */
	function searchProductionLine(q, row) {
		var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}
	//加载产线信息
	var jtxx = [];
	$.ajax({
		url : 'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			jtxx = data;
		}
	});
    function remove() {

        var rows = $("#workorderresultprint_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#workorderresultprint_dg").datagrid("getRowIndex", rows[i]);
            $("#workorderresultprint_dg").datagrid("deleteRow", index);
        }

    }

    
    function cancel() {
        $("#workorderresultprint_dg").datagrid("rejectChanges");
    }
    
     function finishhours(v,r,i){
    	 debugger;
    	if(r.quotacount==null||r.quotacount=="")
    		return "0";
    	return ((8/r.quotacount)*r.yieldcount).toFixed(2);
    }
     function adequatecompletionrate(v,r,i){
    	if(r.quotacount==null)
    		return "0";
    	return ((8/r.quotacount)*r.yieldcount/8).toFixed(2)+"%";
    }
   
    function aratecompletionrate(v,r,i){
    	if(r.yieldcount==null||r.yieldcount==0)
 			return "";
    	return ((r.yieldcount-r.waste-r.secondlevel)/r.yieldcount*100).toFixed(2)+"%";
    } 
	
	//设定时间初始值从当前时间00:00:00至23:59:59
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
</script>