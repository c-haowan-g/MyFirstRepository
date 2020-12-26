<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    $(function () {
        var url_path = 'finalcheck/qualityInspectionRecord/checkxrayResultLog/checkxrayresultlog/datagridUDA';
        var options = $('#checkxrayresultlog_dg').datagrid("options");;

        $("#start_checktime").datetimebox({
            value:'3/4/2010 00:00:00',
            required: false,
            showSeconds: true
        });
        $("#end_checktime_s").datetimebox({
            value:'3/4/2010 23:59:59',
            required: false,
            showSeconds: true
        });

        options.url = url_path;
        filter();
    });

    var saveChanges=path+"finalcheck/qualityInspectionRecord/checkxrayResultLog/checkxrayresultlog/saveChanges";
    
    function showOrHide(){
        if($("#CheckxrayResultlog_search_form").is(":hidden")){
            $("#CheckxrayResultlog_search_form").show();
        }else{
            $("#CheckxrayResultlog_search_form").hide();
        }
    }

    var entCodeName=[];
    $.ajax({
        url:"finalcheck/baseData/entmodel/SearchEnt?equip_type=254003",
        type:"get",
        dataType:"json",
        async:true,
        success:function(data){
            entCodeName=data;
        }
    });
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("checkxrayresultlog_dg","CheckxrayResultlog_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("checkxrayresultlog_dg",{});
    }

    function edit() {
        var rows = $("#checkxrayresultlog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#checkxrayresultlog_dg").datagrid("getRowIndex", rows[i]);
            $("#checkxrayresultlog_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#checkxrayresultlog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#checkxrayresultlog_dg").datagrid("getRowIndex", rows[i]);
            $("#checkxrayresultlog_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#checkxrayresultlog_dg");

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
            $("#checkxrayresultlog_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#checkxrayresultlog_dg").datagrid("rejectChanges");
    }

    function codeFormatter(v) {
        return dictFormat(v);
    }


</script>