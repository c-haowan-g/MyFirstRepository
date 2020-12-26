<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    $(function () {
        $("#scanning_time_s").datetimebox({
            value:'3/4/2010 00:00:00',
            required: false,
            showSeconds: true
        });
        $("#scanning_time_end").datetimebox({
            value:'3/4/2010 23:59:59',
            required: false,
            showSeconds: true
        });
        filter();
    });

    var saveChanges=path+"building/productionManagement/feedingQueueLog/effdingqueuelog/saveChanges";
    
    function showOrHide(){
        if($("#FeedingQueueLog_search_form").is(":hidden")){
            $("#FeedingQueueLog_search_form").show();
        }else{
            $("#FeedingQueueLog_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        var startTime = new Date($("#scanning_time_s").datetimebox("getValue"));
        var endTime = new Date($("#scanning_time_end").datetimebox("getValue"));
        if(Math.round((endTime - startTime)/ (24 * 3600 * 1000)) > 90){
            ext.tip.error("只允许取得90天之内的数据");
            return;
        }
        var opts = $("#feedingqueuelog_dg").datagrid("options");
        opts.url = 'curing/ReportQuery/FeedingQueueLog/feedingqueuelog/datagrid';
        ext.easyui.grid.search("feedingqueuelog_dg","FeedingQueueLog_search_form");
    };
    
    function add() {
        ext.easyui.grid.appendAndEdit("feedingqueuelog_dg",{});
    }

    function edit() {
        var rows = $("#feedingqueuelog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#feedingqueuelog_dg").datagrid("getRowIndex", rows[i]);
            $("#feedingqueuelog_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#feedingqueuelog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#feedingqueuelog_dg").datagrid("getRowIndex", rows[i]);
            $("#feedingqueuelog_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#feedingqueuelog_dg");

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
            $("#feedingqueuelog_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#feedingqueuelog_dg").datagrid("rejectChanges");
    }

    function formatterBySign(val,row){
        if(val == 'A'){
            return '可用';
        }
        return '删除';
    }

    function codeFormatter(val, r, i) {
        return dictFormat(val);
    }



</script>