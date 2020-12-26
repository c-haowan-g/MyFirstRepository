<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    var saveFlag = false;
    var saveChanges = path + "finalcheck/standardmagement/dynabalancereversal/saveChanges";

    function showOrHide() {
        if ($("#Dynabalancereversal_search_form").is(":hidden")) {
            $("#Dynabalancereversal_search_form").show();
        } else {
            $("#Dynabalancereversal_search_form").hide();
        }
    }


    /**
     * 接收combtree数据
     */
    var DICT_267 = [];

    $.ajax({
        url: "dict/code/267",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            DICT_267 = data;
        }
    });

    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    function onDgBeforeLoad(param) {
        param["filter[materialcode_s]"] = $("#materialcode_s").textbox("getValue");
        param["filter[materialdesc_s]"] = $("#materialdesc_s").textbox("getValue");
    }

    /**
     * 查询方法
     */
    function filter() {
        /* var opts = $("#dynabalancereversal_dg").datagrid("options");
        opts.url = 'finalcheck/standardmagement/dynabalancereversal/datagrid'; */
        ext.easyui.grid.search("dynabalancereversal_dg", "Dynabalancereversal_search_form");
    }

    function add() {
        //$("#addoredit").dialog("open");
        //获取设定反转的物料值
        /*var datas=[];
        $.ajax({
            url:'/sap/materials/dynabalancereversallist',
            type:'get',
            dataType:'json',
            async:false,
            success:function(data){
                console.log(data);
                datas=data;
            }
        });
        $("#addoredit").dialog({
            onLoad:function(){
                $("#Dynabalancereversal_dg").datagrid({data:datas});
            }
        }).dialog("open");*/
        saveFlag = false;
        ext.easyui.grid.appendAndEdit("dynabalancereversal_dg", {});
    }

    var onMaterialSelect = function (r) {
        var ed;
        editIndex = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        var code = r.MATERIALCODE_S;

        $.ajax({
            url: 'finalcheck/standardmagement/dynabalancereversal/checkCode',
            dataType: 'text',
            data: {'code': code},
            async: false,
            success: function (res) {
                if (res == 0) {
                    var count = $("#dynabalancereversal_dg").datagrid('getRows');
                    for (var i = 0; i < count.length; i++) {
                        var editor = $("#dynabalancereversal_dg").datagrid("getEditor", {
                            index: i,
                            field: "materialcode_s"
                        });
                        if (editor != null) {
                            if (code == $(editor.target).combobox('getValues')) {
                                ext.tip.error("重复数据");
                                $("#dynabalancereversal_dg").datagrid("getEditor", {
                                    index: editIndex,
                                    field: "materialdesc_s"
                                }).textbox('setValue', "");
                                return;
                            }
                        }
                    }
                    ed = $("#dynabalancereversal_dg").datagrid("getEditor", {
                        index: editIndex,
                        field: "materialdesc_s"
                    });
                    $(ed.target).textbox("setValue", r.MATERIALDESC_S);
                    return
                }
                if (saveFlag) {
                    var edit_flag = $("#dynabalancereversal_dg").datagrid("getEditor", {
                        index: editIndex,
                        field: "materialcode_s"
                    });
                    if (r.MATERIALCODE_S == $(edit_flag.target).combobox('getValue')) {
                        return;
                    }
                }
                ext.tip.error("物料编号已被占用,请重新选择");
                ed = $("#dynabalancereversal_dg").datagrid("getEditor", {index: editIndex, field: "materialdesc_s"});
                $(ed.target).textbox("setValue", "");
            }
        });

    };

    function onMaterialChange(nv, ov) {
        $(this).combobox("reload");
    }

    function onMaterialBeforeLoad(param) {
        if ($(this).combobox("getValue") == "") {
            return false;
        } else {
            param.q = $(this).combobox("getValue");
        }
    }

    function edit() {
        saveFlag = true;
        var rows = $("#dynabalancereversal_dg").datagrid("getSelections");
        if (rows.length <= 0) {
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#dynabalancereversal_dg").datagrid("getRowIndex", rows[i]);
            $("#dynabalancereversal_dg").datagrid("beginEdit", index);
        }

        /* $("#addoredit").dialog({
    		onLoad:function(){
    			$("#Dynabalancereversal_dg").datagrid({data:rows});
    		}
    	}).dialog("open"); */
    }

    function remove() {
        saveFlag = false;
        var rows = $("#dynabalancereversal_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#dynabalancereversal_dg").datagrid("getRowIndex", rows[i]);
            $("#dynabalancereversal_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        saveFlag = false;
        var dg = $("#dynabalancereversal_dg");
        var count = $("#dynabalancereversal_dg").datagrid("getRows");
        for (var i = 0; i < count.length; i++) {
            var ed = dg.datagrid("getEditor", {index: i, field: "materialdesc_s"});
            if (ed != null) {
                if ($(ed.target).textbox('getValue') == null || $(ed.target).textbox('getValue') == '') {
                    ext.tip.error("<spring:message code="tip.invalid" />");
                    return;
                }
            }
        }
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
                return;
            }
            $("#dynabalancereversal_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#dynabalancereversal_dg").datagrid("rejectChanges");
    }

    /**
     * 物料编码选择事件
     */
    function onMaterialSelect(record) {
        var index = $(this).parents("[datagrid-row-index]").attr(
            "datagrid-row-index");
        ext.ajax.get(
            "finalcheck/standardmagement/dynabalancereversal/greenTire?code=" + record.MATERIAL_CODE_S,
            function (data) {
                console.log(data);
                if (data.data.length == 0) {
                    ext.tip.warn("<spring:message code="tip.incompleteMaterialInfo" />");
                    return;
                }

                $(getEditor(index, "specification_s").target)
                    .combobox("loadData", data.data);

                if (data.data.length == 1) {
                    $(getEditor(index, "specification_s").target)
                        .combobox("select", data.data[0].specification_s);
                }
                $(getEditor(index, "material_desc_s").target)
                    .textbox("setValue", record.MATERIAL_NAME_S);//
            });

    }

</script>