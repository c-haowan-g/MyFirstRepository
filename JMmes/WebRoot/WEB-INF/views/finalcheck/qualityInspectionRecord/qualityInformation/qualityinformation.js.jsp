<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/qualityInspectionRecord/qualityInformation/saveChanges";
    
    function showOrHide(){
        if($("#QualityInformation_search_form").is(":hidden")){
            $("#QualityInformation_search_form").show();
        }else{
            $("#QualityInformation_search_form").hide();
        }
    }
    
    //设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
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
		var opts = $("#qualityinformation_dg").datagrid("options");
		opts.url ='finalcheck/qualityInspectionRecord/qualityInformation/datagrid';
    	ext.easyui.grid.search("qualityinformation_dg","QualityInformation_search_form");
		
		
	});
    
    /**
     * 查询方法
     */
    var filter=function(){
        var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			$("#qualityinformation_dg").datagrid("options").url="finalcheck/qualityInspectionRecord/qualityInformation/datagrid";
    			   ext.easyui.grid.search("qualityinformation_dg","QualityInformation_search_form");
    		}
    	}else{
    		$("#qualityinformation_dg").datagrid("options").url="finalcheck/qualityInspectionRecord/qualityInformation/datagrid";
    		   ext.easyui.grid.search("qualityinformation_dg","QualityInformation_search_form");
    	}
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("qualityinformation_dg",{});
    }

    function edit() {
        var rows = $("#qualityinformation_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#qualityinformation_dg").datagrid("getRowIndex", rows[i]);
            $("#qualityinformation_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#qualityinformation_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#qualityinformation_dg").datagrid("getRowIndex", rows[i]);
            $("#qualityinformation_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#qualityinformation_dg");

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
            $("#qualityinformation_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#qualityinformation_dg").datagrid("rejectChanges");
    }


</script>