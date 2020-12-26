<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    var saveChanges = path + "halfpart/productionManagement/MachineState/machinestate/saveChanges";

    function showOrHide() {
        if ($("#Machomestatis_search_form").is(":hidden")) {
            $("#Machomestatis_search_form").show();
        } else {
            $("#Machomestatis_search_form").hide();
        }
    }

    $(function () {

        $('#machinebarcode_s').combobox({
            labelWidth: 'auto',
            editable: true,
            required: false,
            url: 'halfpart/productionManagement/MachineState/machinestate/getLineNameList',
            valueField: 'P_LINE_NAME',
            textField: 'P_LINE_NAME',
            method: 'get'
        })


        /**
         * 接收combtree数据
         */
        $('#machinetype_s').combobox({
            labelWidth: 'auto',
            panelHeight: 200,
            editable: true,
            url: 'halfpart/basedata/productlinemanager/getProductLineType',
            required: false,
            valueField: 'DICTCODE_S',
            textField: 'DICTNAME_S',
            method: 'get'
        })


        /**
         * 父表格,子表格的加载以及事件监听
         * */
        $("#machomestatis_dg").datagrid({
            fit: true,
            fitColumns: true,
            pagination: true,
            rownumbers: true,
            singleSelect: false,
            emptyMsg: '<span><spring:message code='tip.noData'/></span>',
            view: detailview,
            toolbar: '#Machomestatis_dg_toolbar',
            url: 'halfpart/productionManagement/MachineState/machinestate/datagridUDA',
            striped: true,
            method: 'get',
            detailFormatter: function (rowIndex, rowData) {
                return '<table class="childrenGrid"></table>';
            },
            onExpandRow: function (index, row) {
                var parentCode = row.machinebarcode_s;
                var childrenGrid = $(this).datagrid('getRowDetail', index).find('table.childrenGrid');
                childrenGrid.datagrid({
                    url: 'halfpart/productionManagement/MachineState/machinestate/getChildrenGrid',
                    queryParams: {'machinebarcode_s': parentCode},
                    fitColumns: true,
                    singleSelect: true,
                    rownumbers: true,
                    loadMsg: '加载中，请稍后...',
                    height: 'auto',
                    columns: [[
                        {field: 'EQUIPMENTNAME_S', title: '<spring:message code="ent.column.entname_s"/>', },
                        {
                            field: 'IP_ADDRESS_S',
                            title: '<spring:message code="terminal_display.column.trml_ip_s"/>'
                        },
                        {field: 'CURRENT_BARCODE_S', title: '载具条码'},
                        {
                            field: 'CURRENT_BATCH_CODE_S',
                            title: '<spring:message code="capsules.column.batch_no_s"/>'
                        },
                        {field: 'CURRENT_MATERIAL_CODE_S', title: '物料编码'},
                        {field: 'MATERIALNAME_S', title: '物料名称'},
                        {field: 'PRODUCTIONGVER_S', title: '物料版本'},
                        {field: 'STATUS_S', title: '设备状态'},
                        {field: 'ENDWEIGHT_I', title: '称重结束'},
                        {field: 'DIFFERENTVALUE_I', title: '更换载具差值'},
                        {field: 'CONSUMEQUANTITY_F', title: '消耗量'},
                        {field: 'LEAVEQUANTITY_F', title: '剩余量'},
                        {field: 'CONFIGSTATUS_S', title: '校验结果'},
                        {field: 'PLANNO_S', title: '计划号'},
                        {field: 'PLANQUANTITY_I', title: '计划量'},
                        {field: 'OUTQUANTITY_I', title: '完成量'},
                    ]],
                    onResize: function () {
                        $('#machomestatis_dg').datagrid('fixDetailRowHeight', index);
                    },
                    onLoadSuccess: function () {
                        $('#machomestatis_dg').datagrid('fixDetailRowHeight', index);
                    }
                });

            }
        })

    });

    /**
     * 查询方法
     */
    var filter = function () {
        ext.easyui.grid.search("machomestatis_dg", "Machomestatis_search_form");
    }

    function add() {
        ext.easyui.grid.appendAndEdit("machomestatis_dg", {});
    }

    function edit() {
        var rows = $("#machomestatis_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#machomestatis_dg").datagrid("getRowIndex", rows[i]);
            $("#machomestatis_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#machomestatis_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#machomestatis_dg").datagrid("getRowIndex", rows[i]);
            $("#machomestatis_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#machomestatis_dg");

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
            $("#machomestatis_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#machomestatis_dg").datagrid("rejectChanges");
    }


    function codeFormatter(val) {
        return dictFormat(val);
    }

    function producttypeFormatter(val) {
        if (val == 0) {
            return '单条';
        }
        return '批量';
    }

    function isplateFormatter(v) {
        if (v == 0) {
            return "否";
        } else if (v == 1) {
            return "是";
        }
    }


</script>