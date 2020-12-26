<%@page import="org.xdemo.app.xutils.j2se.DateUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"lh/scgl/sap_return_result/saveChanges";
    
    function showOrHide(){
        if($("#SapReturnResult_search_form").is(":hidden")){
            $("#SapReturnResult_search_form").show();
        }else{
            $("#SapReturnResult_search_form").hide();
        }
    }
    
  
    function codeFormatter(v, r, i) {
        return dictFormat(v);
    }


    function cancel() {
        $("#sapreturnresult_dg").datagrid("rejectChanges");
    }
    
    var now="<%=DateUtils.now("yyyy-MM")%>";
    $(function() {
    	var nowdays = new Date();
    	var year=nowdays.getFullYear();
    	var month=nowdays.getMonth();
    	if(month==0){
    		month=12;
    		year=year-1;
    	}
    	if(month<10){
    		month='0'+month;
    	}
    	var myDate=new Date(year,month,0);
    	$("#beginTime").datetimebox({
			value : year+"-"+month+"-"+"01 00:00:00",
			required : true,
			showSeconds : true
		});
		$("#endTime").datetimebox({
			value : year+"-"+month+"-"+myDate.getDate()+" 23:59:59",
			required : true,
			showSeconds : true
		});
    	filter();
	});

    /**
     * 查询方法
     */
    function filter(){
    	var opts = $("#messapproduction_dg2").datagrid("options");
        opts.url = 'curing/report/productionSubsidiaryQuery/ccreport';
        ext.easyui.grid.search("messapproduction_dg2","messapproduction_search_form");
    	/* ext.ajax.get("lh/scgl/scmxcx/bcreport" , function(data) {
			$("#messapproduction_dg2").datagrid("loadData", data);
		}); */
    }
    
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}


</script>