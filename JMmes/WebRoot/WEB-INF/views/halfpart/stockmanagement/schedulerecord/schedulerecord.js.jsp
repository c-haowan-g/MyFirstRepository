<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/basedata/ScheduleRecord/saveChanges";
    
    $(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
        var opts = $("#schedulerecord_dg").datagrid("options");
		opts.url = 'halfpart/production/ScheduleRecord/datagrid';
	});
	
    function showOrHide(){
        if($("#ScheduleRecord_search_form").is(":hidden")){
            $("#ScheduleRecord_search_form").show();
        }else{
            $("#ScheduleRecord_search_form").hide();
        }
    }
    var productLineList=[];
    $.ajax({
        url:"halfpart/basedata/productlinemanager/getHalfPartProductionLine",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	productLineList=data;
        }
    });
    
    function equipDescFormatter(v,r,x){
    	for(var i=0;i<productLineList.length;i++){
    		var aaa=productLineList[i].P_LINE_NAME;
        	if(v==productLineList[i].P_LINE_NAME){
        		$(getEditor(x,"equipmentcode_s").target).textbox("setValue",v);
        		$(getEditor(x,"equipmentdesc_s").target).textbox("setValue",productLineList[i].DESCRIPTION);
        	}
    	}
    }
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("schedulerecord_dg","ScheduleRecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("schedulerecord_dg",{});
    }

    function edit() {
        var rows = $("#schedulerecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#schedulerecord_dg").datagrid("getRowIndex", rows[i]);
            $("#schedulerecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#schedulerecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#schedulerecord_dg").datagrid("getRowIndex", rows[i]);
            $("#schedulerecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#schedulerecord_dg");

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
            $("#schedulerecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#schedulerecord_dg").datagrid("rejectChanges");
    }
    function schedulestatus(v, r, i) {

		if (v == '0') {
			return "未完成";
		}else if(v == '1'){
			return "完成";
		}
		return "";
	}
    function scheduletype(v, r, i) {

		if (v == '0') {
			return "自动";
		}else if(v == '1'){
			return "手动";
		}
		return "";
	}
	 function codeFormatter(v, r, i) {
    		return dictFormat(v);
    }
</script>