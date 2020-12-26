<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"lh/bb/curingalarmcount/saveChanges";
    
    function showOrHide(){
        if($("#CuringAlarmCount_search_form").is(":hidden")){
            $("#CuringAlarmCount_search_form").show();
        }else{
            $("#CuringAlarmCount_search_form").hide();
        }
    }
  //加载产线信息
	var jtxx = [];
	$.ajax({
		url : 'curing/baseData/curingProductionLine/searchDescription',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			jtxx = data;
		}
	});
    /**
     * 查询方法
     */
    var filter=function(){
        var starttime = $("#begin_created_time").datetimebox("getValue");
		var endtime = $("#end_created_time").datetimebox("getValue");
		if (starttime != "" && endtime != "") {
			if (starttime > endtime) {
				ext.tip.error("<spring:message code="tip.date" />");
			} else {
				$("#curingalarmcount_dg").datagrid("options").url = "curing/report/curingalarmcount/datagridUDA";
				ext.easyui.grid.search("curingalarmcount_dg",
						"CuringAlarmCount_search_form");
			}
		} else {
			$("#curingalarmcount_dg").datagrid("options").url = "curing/report/curingalarmcount/datagridUDA";
			ext.easyui.grid.search("curingalarmcount_dg",
					"CuringAlarmCount_search_form");
		}
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("curingalarmcount_dg",{});
    }

    function edit() {
        var rows = $("#curingalarmcount_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingalarmcount_dg").datagrid("getRowIndex", rows[i]);
            $("#curingalarmcount_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#curingalarmcount_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingalarmcount_dg").datagrid("getRowIndex", rows[i]);
            $("#curingalarmcount_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#curingalarmcount_dg");

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
            $("#curingalarmcount_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#curingalarmcount_dg").datagrid("rejectChanges");
    }
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