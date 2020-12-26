<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/report/mixrfridscanningrate/saveChanges";
    
    function showOrHide(){
        if($("#MixRfridScanningrate_search_form").is(":hidden")){
            $("#MixRfridScanningrate_search_form").show();
        }else{
            $("#MixRfridScanningrate_search_form").hide();
        }
    }
    //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
        $('#start_time').datetimebox({
            value: '3/4/2010 00:00:00',
            required: true,
            showSeconds: true
        });
        $('#end_time').datetimebox({
            value: '3/4/2010 23:59:59',
            required: true,
            showSeconds: true
        });
        filter();
    });
    
        var equiplist2=[];
	    //加载小料机台信息
     $.ajax({
 		url:"mix/report/mixmonthlyreport/mixmonthlyreport/getRfidByPlinename",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			equiplist2=data;
 		}
 	});  
	//小料机台转换
	function equipcodeformatterlh(v,r,i){
		 for(var i=0;i<equiplist2.length;i++){
			 if(v==equiplist2[i].p_line_name){
				 return equiplist2[i].description;
			 }
		 }  
	} ;
	
	function planStatusColorSetting(value,row,index){
		return 'text-align: center;';
	}
    
    
 	function spFormatter(v,r,i){   
    	return v+"%";        	 
   	}
    
    /**
     * 查询方法
     */
    var filter=function(){
     var url='mix/report/mixrfridscanningrate/getAll';
       
        var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        if(starttime!="" && endtime!=""){
            if(starttime>endtime){
                ext.tip.error("<spring:message code="tip.date" />");
            }else{
                var opts = $("#mixrfridscanningrate_dg").datagrid("options");
                opts.url =url;
                ext.easyui.grid.search("mixrfridscanningrate_dg","MixRfridScanningrate_search_form");
            }
        }else{
            var opts = $("#mixrfridscanningrate_dg").datagrid("options");
            opts.url =url;
            ext.easyui.grid.search("mixrfridscanningrate_dg","MixRfridScanningrate_search_form");
        }
        
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixrfridscanningrate_dg",{});
    }

    function edit() {
        var rows = $("#mixrfridscanningrate_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixrfridscanningrate_dg").datagrid("getRowIndex", rows[i]);
            $("#mixrfridscanningrate_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixrfridscanningrate_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixrfridscanningrate_dg").datagrid("getRowIndex", rows[i]);
            $("#mixrfridscanningrate_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixrfridscanningrate_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }

        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");

        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#mixrfridscanningrate_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixrfridscanningrate_dg").datagrid("rejectChanges");
    }


</script>