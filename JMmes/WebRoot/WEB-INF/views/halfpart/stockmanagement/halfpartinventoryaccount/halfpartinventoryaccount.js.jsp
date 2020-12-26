<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    var saveChanges = path + "halfpart/productionManagement/HalfPartLedger/halfpartledger/saveChanges";

    function showOrHide() {
        if ($("#Ledger_search_form").is(":hidden")) {
            $("#Ledger_search_form").show();
        } else {
            $("#Ledger_search_form").hide();
        }
    }

    $(function () {
        //是否过期
        $('#expire').combobox({
            data: [
                {label: '全部', value: 0},
                {label: '是', value: 1},
                {label: '否', value: 2},
            ],
            textField: 'label',
            valueField: 'value',
            width: 100
        });

        var materialGroupList = [];
        $.ajax({
            url: "sap/materials/getMaterialGroupList",
            type: "get",
            dataType: "json",
            async: false,
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    let item = {'text': data[i].DICTNAME_S, 'code': data[i].DICTCODE_S};
                    materialGroupList.push(item);
                }
                console.log(materialGroupList)
            }
        });

        //物料组
        $('#m_group_s').combobox({
            data: materialGroupList,
            textField: 'text',
            valueField: 'code',
            method: 'get',
            panelHeight: 200,
        });

        //质量状态
        var qualitys_state = [{text: '全部', code: 0}];
        $.ajax({
            url: 'dict/code/106',
            dataType: 'json',
            method: 'get',
            async: false,
            success: function (by_106) {
                for (var i = 0; i < by_106.length; i++) {
                    qualitys_state.push(by_106[i])
                }
            }
        });
        $('#quality_status_s').combobox({
            data: qualitys_state,
            textField: 'text',
            valueField: 'code',
        });

        //库存类型
        var inventory_type = [{text: '全部', code: 0}];
        $.ajax({
            url: 'dict/code/112',
            dataType: 'json',
            method: 'get',
            async: false,
            success: function (by_112) {
                for (var i = 0; i < by_112.length; i++) {
                    inventory_type.push(by_112[i])
                }
            }
        });
        $('#stocktype_s').combobox({
            data: inventory_type,
            textField: 'text',
            valueField: 'code',
            panelHeight: 150
        });

        //是否延期
        $('#isrequest_s').combobox({
            data: [
                {label: '是', value: 1},
                {label: '否', value: 0},
            ],
            textField: 'label',
            required: true,
            valueField: 'value',
            value: 0,
            width: 137,
        });

        //时间控件
        $("#start_time").datetimebox({
            value: '3/4/2010 00:00:00',
            required: false,
            showSeconds: true
        });

        $("#end_time").datetimebox({
            value: '3/4/2010 23:59:59',
            required: false,
            showSeconds: true
        });

        var opts = $("#ledger_dg").datagrid("options");
        opts.url = 'halfpart/stockmanagement/halfpartInventoryAccount/halfpartinventoryaccount/datagridUDA';
        filter();
    });


    /**
     * 查询方法
     */
    var filter = function () {
        console.log($('#isrequest_s').val())
        ext.easyui.grid.search("ledger_dg", "Ledger_search_form");
    }

    function add() {
        ext.easyui.grid.appendAndEdit("ledger_dg", {});
    }

    function edit() {
        var rows = $("#ledger_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#ledger_dg").datagrid("getRowIndex", rows[i]);
            $("#ledger_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#ledger_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#ledger_dg").datagrid("getRowIndex", rows[i]);
            $("#ledger_dg").datagrid("deleteRow", index);
        }

    }

    function isrunoutFormatter(v) {
        if (v == 1) {
            return "是";
        } else if (v == 2) {
            return "否";
        }
    }

    function inoroutFormatter(v) {
        if (v == 1) {
            return "盘库入库";
        } else if (v == 0) {
            return "正常入库";
        }
    }

    function codeFormatter(v) {
        return dictFormat(v);
    }

    function save() {
        var dg = $("#ledger_dg");

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
            $("#ledger_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")
        });
    }

    function cancel() {
        $("#ledger_dg").datagrid("rejectChanges");
    }

    /**
     * 超期申请
     */
    function Apply() {
        var row = $("#ledger_dg").datagrid("getSelections");
        var atr_keys = [];
        for (var i = 0; i < row.length; i++) {
            var now = new Date();
            var date = new Date(row[i].outtime_t);
            if (now > date) {
                atr_keys.push(row[i].atr_key);
            } else {
                ext.tip.error('<spring:message code="data.not.expired" />');
            }
        }
        if (atr_keys.length != 0) {
            $.ajax({
                url: 'halfpart/stockmanagement/halfpartInventoryAccount/halfpartinventoryaccount/Apply',
                dataType: 'text',
                data: {'atr_keys': atr_keys},
                method: 'get',
                traditional: true,
                async: false,
                success: function (suc) {
                    if (suc == 'success') {
                        ext.tip.suc('<spring:message code="tip.success" />');
                        $("#ledger_dg").datagrid("reload");
                    } else if (suc == 'error') {
                        ext.tip.error('<spring:message code="tip.error" />');
                    } else {
                        ext.tip.error(suc);
                    }
                }
            });
        }
    }

    /**
     * 延期处理
     */
    function handle() {
        var row = $("#ledger_dg").datagrid("getSelections");
        var atr_keys = [];
        for (var i = 0; i < row.length; i++) {
            if (row[i].isrequest_s == 1) {
                atr_keys.push(row[i].atr_key);
            } else {
                ext.tip.error('所选数据未超期申请!');
            }
        }
        if (atr_keys.length != 0) {
            $.ajax({
                url: 'halfpart/stockmanagement/halfpartInventoryAccount/halfpartinventoryaccount/handle',
                data: {atr_keys: atr_keys},
                dataType: 'text',
                method: 'get',
                traditional: true,
                success: function (data) {
                    if (data == "success") {
                        ext.tip.suc('<spring:message code="tip.success" />');
                        $("#ledger_dg").datagrid("reload");
                    } else {
                        ext.tip.error('<spring:message code="tip.error" />');
                    }
                }
            })
        }
    }


</script>