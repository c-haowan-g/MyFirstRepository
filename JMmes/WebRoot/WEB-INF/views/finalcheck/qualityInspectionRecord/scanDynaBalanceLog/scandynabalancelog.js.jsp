<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    var saveChanges = path + "/finalcheck/qualityInspectionRecord/scanDynaBalanceLog/saveChanges";

    function showOrHide() {
        if ($("#ScanDynaBalanceLog_search_form").is(":hidden")) {
            $("#ScanDynaBalanceLog_search_form").show();
        } else {
            $("#ScanDynaBalanceLog_search_form").hide();
        }
    }

    /**
     * 接收combtree数据
     */
    var DICT_259 = [];

    $.ajax({
        url: "dict/code/259",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            DICT_259 = data;
        }
    });


    /**
     * 查询方法
     */



    function filter() {
        var startTime = $('#begin_created_time').datebox("getValue");
        var endTime = $('#end_created_time').datebox("getValue");
        if ((startTime != "" && endTime == "")
            || (startTime == "" && endTime != "")) {
            ext.tip.error("时间输入范围不完整");
            return;
        }
        var opts = $("#scandynabalancelog_dg").datagrid("options");
        opts.url = 'finalcheck/qualityInspectionRecord/scanDynaBalanceLog/datagrid';
        // $("#scandynabalancelog_dg").datagrid("load");

        ext.easyui.grid.search("scandynabalancelog_dg",
            "ScanDynaBalanceLog_search_form");
    }

    function add() {
        $("#scandynabalancelog_dg").datagrid("appendRow", {});
        var rows = $("#scandynabalancelog_dg").datagrid("getRows");
        $("#scandynabalancelog_dg").datagrid("beginEdit", rows.length - 1);
    }

    function edit() {
        var rows = $("#scandynabalancelog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#scandynabalancelog_dg")
                .datagrid("getRowIndex", rows[i]);
            $("#scandynabalancelog_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#scandynabalancelog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#scandynabalancelog_dg")
                .datagrid("getRowIndex", rows[i]);
            $("#scandynabalancelog_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#scandynabalancelog_dg");

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
            inserted: inserted,
            updated: updated,
            deleted: deleted
        }, function (data) {

            if (data.code != OK) {
                ext.tip.error("<spring:message code="tip.error" />");
            }
            $("#scandynabalancelog_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#scandynabalancelog_dg").datagrid("rejectChanges");
    }

    //隐藏查询栏
    function searchBar() {
        $("#ScanDynaBalanceLog_search_form").toggle();
    }

    function etypeFormatter(v, r, i) {
        if (v != 0) {
            return dictFormat(v);
        } else {
            return "无";
        }
    }

    function mesxy(v, r, i) {

        if (v == 1) {
            return "成功";
        }
        return "失败";
    }

    //设定时间初始值从当前时间00:00:00至23:59:59
    $(function () {
        $('#begin_created_time').datetimebox({
            value: '3/4/2010 00:00:00',
            required: true,
            showSeconds: true
        });
        $('#end_created_time').datetimebox({
            value: '3/4/2010 23:59:59',
            required: true,
            showSeconds: true
        });
        filter();


    });
    var DICT_267 = [];
    $.ajax({
        url: "finalcheck/qualityInspectionRecord/scanDynaBalanceLog/267",
        type: "get",
        dataType: "json",
        success: function (data) {
            DICT_267 = data;
        }
    });

    function dictFormatter(v, i) {
        if(v == 0){
            return '';
        }
        if (v != null) {
            var index = -1 ;
            for (var i = 0; i < DICT_267.length; i++) {
                if(DICT_267[i].SORTNO_I == v){
                    return DICT_267[i].DICTNAME_S;
                }
            }
        }
        return v;
    }

</script>