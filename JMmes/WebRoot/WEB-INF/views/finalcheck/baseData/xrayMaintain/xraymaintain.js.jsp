<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    var saveChanges = path + "finalcheck/baseData/xrayMaintain/saveChanges";

    function cancel() {
        $("#xraymaintain_dg").datagrid("rejectChanges");
    }

    /**
     * 接收物料数据
     */
    var materialCodeList = [];

    $.ajax({
        url: "finalcheck/baseData/xrayMaintain/fertMaterialList",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            materialCodeList = data;

        }
    });

    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(index, field) {
        return $("#xraymaintain_dg").datagrid("getEditor", {index: index, field: field});
    }

    //物料选择后->带出列信息，比如物料描述
    function onMaterialSelect(record) {
        var dg = $("#xraymaintain_dg");
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        var allData = dg.datagrid('getRows');
        for (var i = 0; i < allData.length; i++) {
            if (index != i) {
                var code_combobox = dg.datagrid("getEditor", {index: i, field: 'material_code_s'});
                if (code_combobox != null) {
                    var code = $(code_combobox.target).combobox('getValue');
                    if(code == record.PART_NUMBER){
                        ext.tip.error('<spring:message code="xraymaintain.tip.error.material_code_s.is.occupied" />');
                        return;
                    }
                }
            }
        }
        $(getEditor(index, "material_desc_s").target).textbox("setValue", record.DESCRIPTION);//物料描述
    }

    /**
     * 查询方法
     */
    var filter = function () {
        ext.easyui.grid.search("xraymaintain_dg", "XrayMaintain_search_form");
    }

    function add() {
        ext.easyui.grid.appendAndEdit("xraymaintain_dg", {});
    }

    function edit() {
        var rows = $("#xraymaintain_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#xraymaintain_dg").datagrid("getRowIndex", rows[i]);
            $("#xraymaintain_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#xraymaintain_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#xraymaintain_dg").datagrid("getRowIndex", rows[i]);
            $("#xraymaintain_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#xraymaintain_dg");

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
            if (data.message != "success") {
                ext.tip.error(data.message);
            } else {
                ext.tip.suc("<spring:message code="tip.success"/>")
            }
            $("#xraymaintain_dg").datagrid("reload");
        });
    }

    function cancel() {
        $("#xraymaintain_dg").datagrid("rejectChanges");
    }


</script>