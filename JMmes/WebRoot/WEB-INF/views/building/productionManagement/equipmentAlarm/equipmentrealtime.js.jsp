<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    $(function () {
        $('#equip_code_s').combobox({
            valueField: 'EQUIP_CODE_S',
            textField: 'EQUIP_CODE_S',
            url: 'building/productionManagement/equipmentAlarm/equipmentalarm/equipCodeList',
            editable: true,
            panelHeight: 150,
            panelWidth: 100
        })

        $("#downtime_stime_t").datetimebox({
            value:'3/4/2010 00:00:00',
            required: false,
            showSeconds: true
        });
        $("#downtime_etime_t").datetimebox({
            value:'3/4/2010 23:59:59',
            required: false,
            showSeconds: true
        });
        filter();
    });

    var saveChanges = path + "building/productionManagement/equipmentAlarm/equipmentalarm/saveChanges";

    function showOrHide() {
        if ($("#EquipmentRealTime_search_form").is(":hidden")) {
            $("#EquipmentRealTime_search_form").show();
        } else {
            $("#EquipmentRealTime_search_form").hide();
        }
    }

    /**
     * 查询方法
     */
    var filter = function () {
        var startTime = new Date($("#downtime_etime_t").datetimebox("getValue"));
        var endTime = new Date($("#downtime_etime_t").datetimebox("getValue"));
        if(Math.round((endTime - startTime)/ (24 * 3600 * 1000)) > 90){
            ext.tip.error("只允许取得90天之内的数据");
            return;
        }
        if($('#downtime_etime_t').val()!=''){
            if ($('#downtime_stime_t').val() < $('#downtime_etime_t').val()) {
                ext.easyui.grid.search("equipmentrealtime_dg", "EquipmentRealTime_search_form");
            } else {
                $.messager.alert('输入有误', '结束如期不可以小于开始日期!请重新选择');
            }
        }else {
            ext.easyui.grid.search("equipmentrealtime_dg", "EquipmentRealTime_search_form");
        }
        var opts = $("#equipmentrealtime_dg").datagrid("options");
		opts.url ='building/productionManagement/equipmentAlarm/equipmentalarm/datagridUDA';
    	ext.easyui.grid.search("equipmentrealtime_dg","EquipmentRealTime_search_form");
    };

    function add() {
        ext.easyui.grid.appendAndEdit("equipmentrealtime_dg", {});
    }

    function edit() {
        var rows = $("#equipmentrealtime_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipmentrealtime_dg").datagrid("getRowIndex", rows[i]);
            $("#equipmentrealtime_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#equipmentrealtime_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipmentrealtime_dg").datagrid("getRowIndex", rows[i]);
            $("#equipmentrealtime_dg").datagrid("deleteRow", index);
        }
    }

    function save() {
        var dg = $("#equipmentrealtime_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid"/>");
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
            $("#equipmentrealtime_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#equipmentrealtime_dg").datagrid("rejectChanges");
    }


</script>