<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/devicelist/saveChanges";
    
    function showOrHide(){
        if($("#DeviceList_search_form").is(":hidden")){
            $("#DeviceList_search_form").show();
        }else{
            $("#DeviceList_search_form").hide();
        }
    }
    
    function selectrow(){
		var rows=$("#devicelist_dg").datagrid('getSelected');
		var equipmentcodes=rows.equipmentcode_s;
		var url ="common/devicelist/datagrid2?equipmentcodes="+equipmentcodes;
		ext.ajax.get(url, function(data) {
			 $('#deviceparameter_dg').datagrid('loadData',data);
		});
	}
    
 	//隐藏查询栏
    function searchBar()
	{
		$("#DeviceList_searchform").toggle();
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("devicelist_dg","DeviceList_search_form");
    	$('#deviceparameter_dg').datagrid('loadData',[]);
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("devicelist_dg",{});
    }

    function edit() {
        var rows = $("#devicelist_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#devicelist_dg").datagrid("getRowIndex", rows[i]);
            $("#devicelist_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#devicelist_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#devicelist_dg").datagrid("getRowIndex", rows[i]);
            $("#devicelist_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#devicelist_dg");

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
            $("#devicelist_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#devicelist_dg").datagrid("rejectChanges");
    }
    
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

</script>