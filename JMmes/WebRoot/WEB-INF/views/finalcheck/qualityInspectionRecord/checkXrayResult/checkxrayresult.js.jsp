<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    $(function () {
        $("#checktime_start").datetimebox({
            value:'3/4/2010 00:00:00',
            required: false,
            showSeconds: true
        });
        $("#checktime_end").datetimebox({
            value:'3/4/2010 23:59:59',
            required: false,
            showSeconds: true
        });
        var opts = $("#checkxrayresult_dg").datagrid("options");
        opts.url = 'finalcheck/qualityInspectionRecord/CheckXrayResult/datagridUDA';
        filter();
    });

    var saveChanges=path+"finalcheck/qualityInspectionRecord/CheckXrayResult/saveChanges";
    
    function showOrHide(){
        if($("#CheckXrayResult_search_form").is(":hidden")){
            $("#CheckXrayResult_search_form").show();
        }else{
            $("#CheckXrayResult_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        var startTime = new Date($("#checktime_start").datetimebox("getValue"));
        var endTime = new Date($("#checktime_end").datetimebox("getValue"));
        if(Math.round((endTime - startTime)/ (24 * 3600 * 1000)) > 90){
            ext.tip.error("只允许取得90天之内的数据");
            return;
        }
        ext.easyui.grid.search("checkxrayresult_dg","CheckXrayResult_search_form");
    };
    
    function add() {
        ext.easyui.grid.appendAndEdit("checkxrayresult_dg",{});
    }

    function edit() {
        var rows = $("#checkxrayresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#checkxrayresult_dg").datagrid("getRowIndex", rows[i]);
            $("#checkxrayresult_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#checkxrayresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#checkxrayresult_dg").datagrid("getRowIndex", rows[i]);
            $("#checkxrayresult_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#checkxrayresult_dg");

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
            $("#checkxrayresult_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#checkxrayresult_dg").datagrid("rejectChanges");
    }

    function codeFormatter(val){
        return dictFormat(val);
    }


</script>