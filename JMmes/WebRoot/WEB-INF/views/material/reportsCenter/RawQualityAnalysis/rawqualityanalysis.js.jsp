<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/TestTaskPush/saveChanges";
    
    function showOrHide(){
        if($("#TestTaskPush_search_form").is(":hidden")){
            $("#TestTaskPush_search_form").show();
        }else{
            $("#TestTaskPush_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
       
        ext.easyui.grid.search("testtaskpush_dg","TestTaskPush_search_form");
    }

     //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
        $('#start_time').datetimebox({
            value: '3/4/2010 00:00:00',
            required: true,
            showSeconds: true
        });
        $('#end_time').datetimebox({
            value: '3/4/2010 23:59:59',
            required: true,
            showSeconds: true
        });
        filter();
    }); 
    
   /*  function add() {
        ext.easyui.grid.appendAndEdit("testtaskpush_dg",{});
    }

    function edit() {
        var rows = $("#testtaskpush_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#testtaskpush_dg").datagrid("getRowIndex", rows[i]);
            $("#testtaskpush_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#testtaskpush_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#testtaskpush_dg").datagrid("getRowIndex", rows[i]);
            $("#testtaskpush_dg").datagrid("deleteRow", index);
        }

    } */

    /* function save() {
        var dg = $("#testtaskpush_dg");

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
            $("#testtaskpush_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    } */

    function cancel() {
        $("#testtaskpush_dg").datagrid("rejectChanges");
    }


</script>