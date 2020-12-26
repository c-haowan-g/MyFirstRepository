<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/baseData/entlog/saveChanges";
    
    function showOrHide(){
        if($("#EntLog_search_form").is(":hidden")){
            $("#EntLog_search_form").show();
        }else{
            $("#EntLog_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#entlog_dg").datagrid("options");
    	opts.url ='finalcheck/baseData/entlog/datagrid'
        ext.easyui.grid.search("entlog_dg","EntLog_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("entlog_dg",{});
    }

    function edit() {
        var rows = $("#entlog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#entlog_dg").datagrid("getRowIndex", rows[i]);
            $("#entlog_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#entlog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#entlog_dg").datagrid("getRowIndex", rows[i]);
            $("#entlog_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#entlog_dg");

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
            $("#entlog_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#entlog_dg").datagrid("rejectChanges");
    }

	function flagFormatter(v,r,i){
		if(v=='0')
			return '未处理'
		else if(v=='1')
			return '已处理'
		else
			return ''
	}
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
	function syncflagFormatter(v,r,i){
		if(v=='A')
			return '新增';
		else if(v=='U')
			return '修改';
		else if(v=='D')
			return '删除';
		else
			return '';
	}
	function facotryFormatter(v,r,i){
		if(v=='1')
			return '全钢';
		else if(v=='2')
			return '半钢';
		else
			return '';
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
		//filter();
	});
</script>