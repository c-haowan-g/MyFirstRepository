<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    $(function () {


        $('#machinebarcode_s').combobox({
            labelWidth: 'auto',
            editable: true,
            required: false,
            url: 'halfpart/productionManagement/MachineState/machinestate/getLineNameList',
            valueField: 'P_LINE_NAME',
            textField: 'P_LINE_NAME',
            method: 'get'
        });

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
        });


        var column = [
            {field: '', title: 'ID', checkbox: true},
            {
                field: 'p_line_name',
                title: '<spring:message code="machomestatis.column.machinebarcode_s" />',
                editor: {type: 'textbox'},
                frozen: true,
                width: 100
            },
            {
                field: 'machinename_s',
                title: '<spring:message code="machomestatis.column.machinename_s" />',
                width: 100,
                editor: {type: 'textbox'}
            },
            {
                field: 'machinestatus_s',
                title: '<spring:message code="machomestatis.column.machinestatus_s" />',
                width: 100,
                editor: {type: 'textbox'},
                formatter: codeFormatter
            },
            {
                field: 'process_s',
                title: '<spring:message code="machomestatis.column.process_s" />',
                width: 100,
                editor: {type: 'textbox'},
                formatter: codeFormatter
            },
        ];

        var buttons_top = '<div>';
        var button_bot = '<div>';
        $.ajax({
            url: 'halfpart/productionManagement/HalfPartMachineControl/halfpartmachinecontrol/searchBy119',
            dataType: 'json',
            method: 'GET',
            async: false,
            success: function (resultData) {
                for (var i = 0; i < resultData.length; i++) {
                    column.push({
                        field: 'a' + resultData[i].DICTCODE_S,
                        title: resultData[i].DICTNAME,
                        editor: {type: 'textbox'},
                        width: 135,
                        formatter: statusFormatter
                    });
                    buttons_top += '<auth:button code="HalfPart_ProductionManage_machineControl"><a class="button-open" id="open' + resultData[i].DICTCODE_S + '">'
                        + resultData[i].DICTNAME + '开启</a></auth:button>';
                    button_bot += '<auth:button code="HalfPart_ProductionManage_machineControl"><a class="button-close" id="close' + resultData[i].DICTCODE_S + '">'
                        + resultData[i].DICTNAME + '关闭</a></auth:button>';
                }
                //初始化按钮
                buttons_top += '</div>';
                button_bot += '</div>';
                var buttons = buttons_top + button_bot;
                buttonLoad(buttons);
                $(".button-open").linkbutton({
                    iconCls: 'icon-add',

                });
                $(".button-close").linkbutton({
                    iconCls: 'icon-remove',
                });
            },
            error: function (e) {
                ext.tip.error('服务器连接异常,请刷新重试');
            }
        });


        /**
         * 初始化数据表格
         * */
        $('#machomestatis_dg').datagrid({
            fit: true,
            fitColumns: false,
            pagination: true,
            rownumbers: true,
            singleSelect: false,
            toolbar: '#Machomestatis_dg_toolbar',
            url: 'halfpart/productionManagement/HalfPartMachineControl/halfpartmachinecontrol/datagridUDA',
            striped: true,
            method: 'get',
            columns: [column]
        });

        /**
         * 为动态生成的按钮绑定点击事件
         * */
        $('.button-open,.button-close').bind('click', function () {
            var row = $('#machomestatis_dg').datagrid('getSelections');
            if (row.length == 0) {
                ext.tip.error('<spring:message code="tip.selected.one.data" />');
                return;
            }
            var str = -1;
            var id = $(this).attr('id');
            var code = id.substring(id.length - 6, id.length);
            var operation = id.substring(0, id.length - 6);

            var bar_codes = [];
            for (var i = 0; i < row.length; i++) {
                bar_codes.push(row[i].p_line_name);
            }
            if (operation == 'close') {
                str = 0;
            } else if (operation == 'open') {
                str = 1;
            }

            $.ajax({
                url: 'halfpart/productionManagement/HalfPartMachineControl/halfpartmachinecontrol/changeState',
                dataType: 'text',
                traditional: true,
                data: {'oper': str, 'code': code, 'barCodes': bar_codes},
                method: 'GET',
                success: function (data) {
                    console.log(data)
                    if (data != 'success') {
                        ext.tip.error(data)
                    } else {
                        ext.tip.suc('<spring:message code="tip.success" />')
                    }
                    $('#machomestatis_dg').datagrid("reload")
                },
                error: function (ex) {
                    ext.tip.error('服务器异常,请重试!');
                }
            });
        });
    });

    function codeFormatter(value) {
        return dictFormat(value);
    }


    var saveChanges = path + "halfpart/productionManagement/MachineControl/machinecontrol/saveChanges";

    function showOrHide() {
        if ($("#Machomestatis_search_form").is(":hidden")) {
            $("#Machomestatis_search_form").show();
        } else {
            $("#Machomestatis_search_form").hide();
        }
    }

    /**
     * 查询方法
     */
    var filter = function () {
        ext.easyui.grid.search("machomestatis_dg", "search_form");
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
                /*   ext.tip.error("


                <spring:message code="tip.invalid" />");*/
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

    function statusFormatter(value) {
        if (value == 1) {
            return "开启";
        }
        if (value == 0) {
            return "关闭";
        }
    }

    /**
     * 查询机台日志
     */
    function log() {
        $("#win").dialog("open");
        $('#halfpart_log').datagrid({
            url: 'halfpart/productionManagement/HalfPartMachineControl/halfpartmachinecontrol/datagridLog',
            fit: true,
            fitColumns: false,
            rownumbers: true,
            singleSelect: false,
            striped: true,
            pagination: true,
            method: 'get',
            columns: [[
                {
                    field: 'machinebarcode_s',
                    title: '<spring:message code="machomestatis.column.machinebarcode_s" />',
                    editor: {type: 'textbox'},
                    frozen: true,
                    width: '20%'
                },
                {
                    field: 'controlitem_s',
                    title: '<spring:message code="controldetail.column.operate_item_s" />',
                    editor: {type: 'textbox'},
                    frozen: true,
                    formatter: codeFormatter,
                    width: '20%'
                },
                {
                    field: 'controlstatus_s',
                    title: '<spring:message code="machinecontrol.column.operate_status_s" />',
                    editor: {type: 'textbox'},
                    frozen: true,
                    formatter: statusFormatter,
                    width: '20%'
                },
                {
                    field: 'username',
                    title: '<spring:message code="equiipmetuda.column.changeby" />',
                    editor: {type: 'textbox'},
                    frozen: true,
                    width: '15%'
                },
                {
                    field: 'created_time_t',
                    title: '<spring:message code="equiipmetuda.column.changetime" />',
                    editor: {type: 'textbox'},
                    frozen: true,
                    width: '27%'
                },
            ]]
        });
    }

    function buttonLoad(buttons) {
        var title = '<span>机台控制按钮</span>';
        $("#control_button").panel({
            title: title,
            content: buttons,
            minHeight: "10px",
            collapsible: 'true',
            animate: true
        });
    }


</script>