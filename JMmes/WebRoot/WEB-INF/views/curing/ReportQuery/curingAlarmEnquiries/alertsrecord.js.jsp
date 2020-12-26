<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#Alertsrecord_search_form").is(":hidden")){
            $("#Alertsrecord_search_form").show();
        }else{
            $("#Alertsrecord_search_form").hide();
        }
    }
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
	
    //设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
	});
    
    function ViewFormatter(val,rowData,rowIndex){
    	if(val!=null){
    		return parseFloat(val).toFixed(2);
    	}
    }
    /**
     * 查询方法
     */
    var filter=function(){
        
        var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	if((starttime!=""&&endtime=="")||(starttime==""&&endtime!="")){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			$("#alertsrecord_dg").datagrid("options").url="curing/report/alertsrecord/datagridUDA";
    			   ext.easyui.grid.search("alertsrecord_dg","Alertsrecord_search_form");
    		}
    	}else{
    		$("#alertsrecord_dg").datagrid("options").url="curing/report/alertsrecord/datagridUDA";
    		   ext.easyui.grid.search("alertsrecord_dg","Alertsrecord_search_form");
    	}
    };
   
    
    
    function add() {
        ext.easyui.grid.appendAndEdit("alertsrecord_dg",{});
    }

    function edit() {
        var rows = $("#alertsrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#alertsrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#alertsrecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#alertsrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#alertsrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#alertsrecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#alertsrecord_dg");

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
            $("#alertsrecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#alertsrecord_dg").datagrid("rejectChanges");
    }


</script>