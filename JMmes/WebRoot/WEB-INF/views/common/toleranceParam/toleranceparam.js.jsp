<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/toleranceparam/saveChanges";
    
    function showOrHide(){
        if($("#ToleranceParam_search_form").is(":hidden")){
            $("#ToleranceParam_search_form").show();
        }else{
            $("#ToleranceParam_search_form").hide();
        }
    }
    
    function selectrow(){
		var rows=$("#toleranceparam_dg").datagrid('getSelected');
		var ids=rows.id_s;
		var url ="common/toleranceparam/datagrid2?ids="+ids;
		ext.ajax.get(url, function(data) {
			 $('#tolerancepara_dg').datagrid('loadData',data);
		});
	}
    
 	//隐藏查询栏
    function searchBar()
	{
		$("#ToleranceParam_searchform").toggle();
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("toleranceparam_dg","ToleranceParam_search_form");
    	$('#tolerancepara_dg').datagrid('loadData',[]);
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("toleranceparam_dg",{});
    }

    function edit() {
        var rows = $("#toleranceparam_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#toleranceparam_dg").datagrid("getRowIndex", rows[i]);
            $("#toleranceparam_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#toleranceparam_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#toleranceparam_dg").datagrid("getRowIndex", rows[i]);
            $("#toleranceparam_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#toleranceparam_dg");

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
            $("#toleranceparam_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#toleranceparam_dg").datagrid("rejectChanges");
    }

</script>