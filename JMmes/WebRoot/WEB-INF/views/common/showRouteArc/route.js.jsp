<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#Route_search_form").is(":hidden")){
            $("#Route_search_form").show();
        }else{
            $("#Route_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var routeName=$("#routename").textbox("getValue");
    	var urlList = "route/datagridUDA1?routeName="+routeName;
    	$("#route_dg").datagrid('options').url=urlList;  
    	ext.easyui.grid.search("route_dg","Route_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("route_dg",{});
    }

    function edit() {
        var rows = $("#route_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#route_dg").datagrid("getRowIndex", rows[i]);
            $("#route_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#route_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#route_dg").datagrid("getRowIndex", rows[i]);
            $("#route_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#route_dg");

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
            $("#route_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#route_dg").datagrid("rejectChanges");
    }
    
   /*  function classFormatter(v,r,i){
		if(v=='252004'){
			return '半部件'
		}else if(v=='252005'){
			return '成型'
		}else if(v=='252006'){
			return '硫化'
		}else if(v=='252007'){
			return '割毛'
		}else if(v=='252008'){
			return '外观'
		}else if(v=='252009'){
			return 'X光'
		}else if(v=='252010'){
			return '动平衡'
		}else if(v=='252011'){
			return '均匀性'
		}else if(v=='252013'){
			return '入库'
		}else if(v=='252014'){
			return '发货'
		}else if(v=='252015'){
			return '退车间'
		}else if(v==''){
			return '流程为空'
		}else{
			return v;
		}
	} */

</script>