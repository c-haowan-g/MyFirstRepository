<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"lh/dotrecord/saveChanges";
    
    function showOrHide(){
        if($("#DotRecord_search_form").is(":hidden")){
            $("#DotRecord_search_form").show();
        }else{
            $("#DotRecord_search_form").hide();
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
    	var opts = $("#dotrecord_dg").datagrid("options");
		opts.url = 'curing/dotrecord/datagridUDA';
        ext.easyui.grid.search("dotrecord_dg","DotRecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("dotrecord_dg",{});
    }

    function edit() {
        var rows = $("#dotrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#dotrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#dotrecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#dotrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#dotrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#dotrecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#dotrecord_dg");

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
            $("#dotrecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#dotrecord_dg").datagrid("rejectChanges");
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