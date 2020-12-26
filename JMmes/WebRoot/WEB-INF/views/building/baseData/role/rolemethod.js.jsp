<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"roleMethodUrl/saveChanges";
    
    function showOrHide(){
        if($("#RoleMethod_search_form").is(":hidden")){
            $("#RoleMethod_search_form").show();
        }else{
            $("#RoleMethod_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("rolemethod_dg","RoleMethod_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("rolemethod_dg",{});
    }

    function edit() {
        var rows = $("#rolemethod_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#rolemethod_dg").datagrid("getRowIndex", rows[i]);
            $("#rolemethod_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#rolemethod_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#rolemethod_dg").datagrid("getRowIndex", rows[i]);
            $("#rolemethod_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
 
        var dg = $("#rolemethod_dg");

        var rows = dg.datagrid("getRows");
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
        	
            if (data.data!="操作成功") {
                ext.tip.error(data.data);
                $("#rolemethod_dg").datagrid("reload");//重新加载界面数据
                return;
            }
            ext.tip.suc(data.data);
            $("#rolemethod_dg").datagrid("reload");//重新加载界面数据
        });
           
     }

    function cancel() {
        $("#rolemethod_dg").datagrid("rejectChanges");
    }
    /**
     *code转化
     *兰颖慧-2019/03/12
     */
    function codeFormatter(v,r,i) {
		return dictFormat(v);
	}
   /**
    *通过URL查询得到功能名称和功能代码后，在选择功能名称后触发事件自动匹配功能代码
    *兰颖慧-2019/03/18
    */
    function getEditor(index,field){
        return $("#rolemethod_dg").datagrid("getEditor",{index:index,field:field});
    }
    function onMethodCodeSelect(record){
     /*   debugger  */
   	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		 $(getEditor(index, "method_code_s").target)
        .textbox("setValue", record.ERPCODE_S);
   }
    /**
     *通过URL查询得到角色名称和角色ID后，在选择角色名称后触发事件自动匹配角色ID
     *兰颖慧-2019/03/18
     */
    function onRoleIDSelect(record){
        /*   debugger  */
      	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
   		 $(getEditor(index, "role_id_s").target)
           .textbox("setValue", record.ID);
      }
   
</script>