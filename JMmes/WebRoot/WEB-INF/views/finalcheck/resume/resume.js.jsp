<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/resume/resume/saveChanges";
    
    function showOrHide(){
        if($("#Resume_search_form").is(":hidden")){
            $("#Resume_search_form").show();
        }else{
            $("#Resume_search_form").hide();
        }
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
    function codeFormatter(v, r, i) {
    	return dictFormat(v);
    }
    /**
     * 查询方法
     */
     var filter=function(){
     	var opts = $("#resume_dg").datagrid("options");
         opts.url='finalcheck/resume/resume/datagrid';
         ext.easyui.grid.search("resume_dg","Resume_search_form");
     }
    
    function add() {
        ext.easyui.grid.appendAndEdit("resume_dg",{});
    }

    function edit() {
        var rows = $("#resume_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#resume_dg").datagrid("getRowIndex", rows[i]);
            $("#resume_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#resume_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#resume_dg").datagrid("getRowIndex", rows[i]);
            $("#resume_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#resume_dg");

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
            $("#resume_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#resume_dg").datagrid("rejectChanges");
    }


</script>