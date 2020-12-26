<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/reportCenter/ufmdbresult/saveChanges";
    
    function showOrHide(){
        if($("#UfmDBResult_search_form").is(":hidden")){
            $("#UfmDBResult_search_form").show();
        }else{
            $("#UfmDBResult_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#ufmdbresult_dg").datagrid("options");
		opts.url = "finalcheck/reportCenter/ufmdbresult/datagridUDA";
        ext.easyui.grid.search("ufmdbresult_dg","UfmDBResult_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("ufmdbresult_dg",{});
    }

    function edit() {
        var rows = $("#ufmdbresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#ufmdbresult_dg").datagrid("getRowIndex", rows[i]);
            $("#ufmdbresult_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#ufmdbresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#ufmdbresult_dg").datagrid("getRowIndex", rows[i]);
            $("#ufmdbresult_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#ufmdbresult_dg");

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
            $("#ufmdbresult_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#ufmdbresult_dg").datagrid("rejectChanges");
    }

    function ufqualiFormatter(v,r,i){
    	if(r.ufquali!=null&&r.ufcount!=null)
    		return ((r.ufcount/r.ufquali*100*100)/100).toFixed(2)+"%";
    }
    
    function dbqualiFormatter(v,r,i){
    	if(r.dbcount!=null&&r.dbquali!=null)
    		return ((r.dbcount/r.dbquali*100*100)/100).toFixed(2)+"%";
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