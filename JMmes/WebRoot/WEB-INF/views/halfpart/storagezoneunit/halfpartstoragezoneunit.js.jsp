<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">


    var saveStorageZoneChanges = "halfpart/basedata/storagezonemanager/saveChanges";
    var saveUnitMentChanges = path + "halfpart/basedata/storageunitmanager/saveChanges";
    var borderStorage = 112001;
    var virtualStorage = 112002;
    var virtualStorage = 112004;

    /**
     * 基础数据text显示
     */
    function codeFormatter(v, r, i) {
        return dictFormat(v);
    }

    function yesFormatter(v, r, i) {
        if (v == 0) {
            return "否";
        } else if (v == 1) {
            return "是";
        } else {
            return "未知";
        }
    }

    function stopFormatter(v, r, i) {
        if (v == 0) {
            return "停用";
        } else if (v == 1) {
            return "启用";
        } else {
            return "未知";
        }
    }

    function lockFormatter(v, r, i) {
        if (v == 0) {
            return "未锁定";
        } else if (v == 1) {
            return "已锁定";
        } else {
            return "未知";
        }
    }

    /**
     * 接收combtree数据
     */
    var DICT_227 = [];

    $.ajax({
        url: "dict/code/227",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            DICT_227 = data;
        }
    });
    /**
     * 库区划分显示转化
     * 兰颖慧
     * 2019-05-24
     */
    var zoneDivide = [];
    var fullZoneDivide = [];
    var count = 0;
    $.ajax({
        url: "dict/code/112",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            fullZoneDivide = data;
            for (var i = 0; i < data.length; i++) {
                if ((data[i].code != borderStorage) && (data[i].code != virtualStorage)) {
                    zoneDivide[count] = data[i];
                    count++;
                }
            }
        }
    });

    function zoneDivideFormatter(v, r, i) {
        for (var i = 0; i < fullZoneDivide.length; i++) {
            if (v == fullZoneDivide[i].code) {
                return fullZoneDivide[i].text;
            }
        }

    }

    /**
     * 物料组显示转化
     * 兰颖慧
     * 2019-05-24
     */
    var materialGroupList = [];
    $.ajax({
        url: "sap/materials/getMaterialGroupList",
        type: "get",
        dataType: "json",
        async: true,
        success: function (data) {
            materialGroupList = data;
        }
    });

    /**
     * 物料组显示转化
     * 2019-05-20
     * 兰颖慧
     */
    function materialGroupFormatter(v, r, i) {
        for (var i = 0; i < materialGroupList.length; i++) {
            if (v == materialGroupList[i].DICTCODE_S) {
                return materialGroupList[i].DICTNAME_S;
            }
        }
    }

    /* 加载详细视图 */
    function LoadView() {
        var total = $("#halfpart_storagezone_dg").length;
        //验证当有数据的时候才加载详细视图
        if (total > 0) {
            $('#halfpart_storagezone_dg').datagrid({
                view: detailview,
                loadFilter: pagerFilter,
                singleSelect: true,
                fitColumns: true,//允许表格自动缩放，以适应父容器
                pagination: true,
                rownumbers: true,
                detailFormatter: function (index, row) {
                    return '<div style="padding:2px"><table class="ddv"></table></div>';
                },
                onExpandRow: function (index, row) {
                    var ddv = $(this).datagrid('getRowDetail', index).find('table.ddv');
                    ddv.datagrid({
                        url: 'halfpart/basedata/storageunitmanager/unit?zonekey=' + row.storage_zone_key,
                        fitColumns: true,
                        singleSelect: true,
                        rownumbers: true,
                        loadMsg: '加载中...',
                        height: 'auto',
                        columns: [[
                            {field: 'storage_unit_key', title: '库位主键 ', hidden: true},
                            {field: 'parent_key', title: '库位父键 ', hidden: true},
                            {field: 'storage_zone_name', title: '库区名称', hidden: true},
                            {field: 'storage_unit_name', title: '库位名称'},
                            {field: 'description', title: '库位描述', width: 100},
                            {
                                field: 'storage_zone_barcode_s',
                                formatter: zoneDivideFormatter,
                                title: '库位划分',
                                width: 120
                            },
                            {field: 'machinecode_s', title: '机台条码', width: 120},
                            {field: 'max_storage_duration', title: '库存容量', width: 80},
                            {field: 'current_storage_i', title: '当前库存', width: 80},
                            {field: 'inventory_materialname_s', title: '存放规格', width: 100},
                            {field: 'inventory_materialcode_s', title: '物料编码', width: 130},
                            {field: 'lastintime_t', title: '最后入库时间', width: 120},
                            {field: 'canuse_s', title: '启用/停用', formatter: stopFormatter, width: 90},
                            {field: 'lockflag_s', title: '是否占用', formatter: yesFormatter, width: 80},
                            {field: 'lockinflag_s', title: '入库锁定', formatter: lockFormatter, width: 100},
                            {field: 'lockoutflag_s', title: '出库锁定', formatter: lockFormatter, width: 100},
                            {field: 'operater_s', title: '操作人', width: 90},
                            {field: 'operatetime_t', title: '操作时间', width: 100}
                        ]],
                        onResize: function () {
                            $('#halfpart_storagezone_dg').datagrid('fixDetailRowHeight', index);
                        },
                        onLoadSuccess:
                            function () {
                                setTimeout(function () {
                                    $('#halfpart_storagezone_dg').datagrid('fixDetailRowHeight', index);
                                }, 0);
                            }
                    });
                    $('#halfpart_storagezone_dg').datagrid('fixDetailRowHeight', index);
                }
            });
        }
    }

    /**
     *页面刷新加载
     *add by ChengmingLiu
     */
    $(function () {
        $('#halfpart_storagezone_dg').datagrid({
            url: 'halfpart/basedata/storagezonemanager/zone',
            fit: true,
            fitColumns: true,
            emptyMsg: '<span><spring:message code='tip.noData'/></span>',
            singleSelect: false,
            toolbar: '#Reas_dg_toolbar',
            striped: true,
            method: 'get'
        });
        // 延迟加载详细视图
        setTimeout(LoadView, 200);
    });


    //添加库区
    function zone_add() {
        $("#halfpart_storagezone_dg2").datagrid("insertRow", {index: 0, row: {}});
        $("#halfpart_storagezone_dg2").datagrid("beginEdit", 0);
    }

    //编辑库区
    function zone_edit() {
        var rows = $("#halfpart_storagezone_dg2").datagrid("getSelections");
        if (rows.length <= 0) {
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#halfpart_storagezone_dg2").datagrid("getRowIndex", rows[i]);
            $("#halfpart_storagezone_dg2").datagrid("beginEdit", index); //通知界面启动编辑
            //var materialGroup=$("#halfpart_storagezone_dg").datagrid('getEditor', {index:index,field:'materialgroup_s'});
            //$(materialGroup.target).combobox({readonly: true});//不可编辑
        }
    }

    //删除库区
    function zone_remove() {
        var rows = $("#halfpart_storagezone_dg2").datagrid("getSelections");
        if (rows.length <= 0) {
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        for (var i = 0; i < rows.length; i++) {
            index = $("#halfpart_storagezone_dg2").datagrid("getRowIndex", rows[i]);
            $("#halfpart_storagezone_dg2").datagrid("deleteRow", index);
        }
       /*  var zoneCode=rows[0].category;
        var materialGroupCode=rows[0].materialgroup_s;
        $.ajax({
            url:'halfpart/basedata/storagezonemanager/productPlanExistJudge?zoneCode='+zoneCode+'&materialGroupCode='+materialGroupCode,
            type:'get',
            dataType:'json',
            async:false,
            success:function(data){
                if(data==true){
                    var index = -1;
                    for (var i = 0; i < rows.length; i++) {
                        index = $("#halfpart_storagezone_dg").datagrid("getRowIndex", rows[i]);
                        $("#halfpart_storagezone_dg").datagrid("deleteRow", index);
                    }
                }else{
                    ext.tip.error("存在日计划维护了该产线下物料，不允许删除");
                }
            }

        });*/
    }

    //保存库区
    function zone_save() {
        var dg = $("#halfpart_storagezone_dg2");
        var rows = dg.datagrid("getRows");
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("无效数据");
                return;
            }
        }
        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");


        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }


        ext.ajax.sendJson(saveStorageZoneChanges, {
            inserted: inserted,
            updated: updated,
            deleted: deleted
        }, function (data) {
            if (data.data != "success") {
                ext.tip.error(data.data);
                return;
            } else {
                ext.tip.suc("操作成功");
                dg.datagrid("reload");
            }
        });
    }

    //取消库区
    function zone_cancel() {
        $("#halfpart_storagezone_dg2").datagrid("rejectChanges");
    }

    var storagezonekey = -1;
    var row_name = "";

    //库位维护页面
    function zone_unit() {

        // 获取选中行的Index的值
        var index = $('#halfpart_storagezone_dg').datagrid('getRowIndex', $('#halfpart_storagezone_dg').datagrid('getSelected'));
        if (index < 0) {
            ext.tip.warn("请选择一个库区后再维护");
            return;
        }
        var rowData = $('#halfpart_storagezone_dg').datagrid('getSelected');
        if (rowData == null) {
            ext.tip.warn("请选择一个库区后再维护");
            return;
        }
        row_name = rowData.storage_zone_name;
        storageZoneKey = rowData.storage_zone_key;
        materialGroup = rowData.materialgroup_s;
        $("#halfpart_unit_manage_dg").dialog("open");
        var url = 'halfpart/basedata/storageunitmanager/unit?zonekey=' + rowData.storage_zone_key + '&materialGroup=' + materialGroup;
        ext.ajax.get(url, function (data1) {
            ext.ajax.get(url, function (data2) {
                $('#halfpart_storageunit_dg').datagrid('loadData', data2);
            });
        });
    }

    function unitReload() {
        var rowData = $('#halfpart_storagezone_dg').datagrid('getSelected');
        storageZoneKey = rowData.storage_zone_key;
        materialGroup = rowData.materialgroup_s;
        var url = 'halfpart/basedata/storageunitmanager/unit?zonekey=' + rowData.storage_zone_key + '&materialGroup=' + materialGroup;
        ext.ajax.get(url, function (data) {
            $('#halfpart_storageunit_dg').datagrid('loadData', data);
        });
    }

    //关闭新增库位
    function zong_unit_close() {
        $("#storageunit_manage_dg").dialog("close");
    }

    //添加库位
    function unit_add() {
        var selectedZoneRow = $("#halfpart_storagezone_dg").datagrid("getSelected");
        //var zoneInventoryBarcode=selectedZoneRow.inventory_barcode_s;
        var zoneName = selectedZoneRow.storage_zone_name;
        var row = { //inventory_barcode_s:zoneInventoryBarcode, //用户后台调用该字段，但是不需要存储
            storage_unit_name: row_name + "_",
            max_storage_duration: 99,
            current_storage_i: 0,
            canuse_s: 1,
            lockflag_s: 0,
            lockinflag_s: 0,
            lockoutflag_s: 0,
        };
        $("#halfpart_storageunit_dg").datagrid("insertRow", {index: 0, row});
        $("#halfpart_storageunit_dg").datagrid("beginEdit", 0);
    }

    /**
     * 库位名称排重
     * @author 李新宇
     * */
    var commit_flag = true;

    function correct_name(v) {
        const expression = /^\d{4}$/;
        return expression.test(v);
    }

    function checkUnit(e) {
        //判断后4位是否为数字
        const v = e.currentTarget.value;
        let v_subName = v.substring(v.indexOf("_") + 1, v.length)
        if (!correct_name(v_subName)) {
            ext.tip.warn('后缀名称必须是4位数字!')
            e.currentTarget.value = row_name + "_";
            commit_flag = false;
            return;
        }

        //判断新增的数据中是否有重复
        let rows = $('#halfpart_storageunit_dg').datagrid('getRows');
        let index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        for (let i = 0; i < rows.length; i++) {
            let target = $('#halfpart_storageunit_dg').datagrid('getEditor', {index: i, field: 'storage_unit_name'})
            console.log(target)
            if (target != null) {
                if ($(target.target.textbox('getValue')).selector !== "" && i !== index) {
                    if ($(target.target.textbox('getValue')).selector === e.currentTarget.value) {
                        unit_name_error(e)
                        return;
                    }
                }
            }

            //判断已有的数据中是否有重复
            if (rows[i].storage_unit_name === v) {
                unit_name_error(e)
                return;
            }
        }
        commit_flag = true;
    }


    function unit_name_error(e) {
        e.currentTarget.value = row_name + "_";
        commit_flag = false;
        ext.tip.error('库位名称相同,请核实后重新输入!');
    }

    /**
     * 获取指定行、指定列的编辑器
     *
     */
    function getEditor(index, field) {
        return $("#halfpart_storageunit_dg").datagrid("getEditor", {index: index, field: field});
    }

    function getZoneEditor(index, field) {
        return $("#halfpart_storagezone_dg").datagrid("getEditor", {index: index, field: field});
    }

    function getMaterialCodeList() {
        var parentIndex = $('#halfpart_storagezone_dg').datagrid('getRowIndex', $('#halfpart_storagezone_dg').datagrid('getSelected'));
        var KidIndex = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        var parentRow = $('#halfpart_storagezone_dg').datagrid('getSelected');
        var group = parentRow.materialgroup_s;
        var getGroupUrl = 'sap/materials/getMaterialByMaterialGroupList?materialGroup=' + group;
        $.ajax({
            url: getGroupUrl,
            type: "get",
            dataType: "json",
            async: false,
            success: function (data) {
                $(getEditor(KidIndex, 'inventory_materialname_s').target).combobox('loadData', data);
            }
        });
    }

    function getMaterialCodeByName(record) {
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        $.ajax({
            url: 'halfpart/productionplan/dailyplan/getDataByMaterialName?materialName=' + record.MATERIALDESC_S,
            type: "get",
            dataType: "json",
            async: false,
            success: function (data) {
                $(getEditor(index, 'inventory_materialcode_s').target).textbox('setValue', data[0].MATERIALCODE_S);
            }
        });
    }

    //编辑库位
    function unit_edit() {
        var rows = $("#halfpart_storageunit_dg").datagrid("getSelections");
        if (rows.length <= 0) {
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index = -1;
        var zoneBarcode = null;
        for (var i = 0; i < rows.length; i++) {
            zoneBarcode = rows[i].storage_zone_barcode_s;
            /* if(zoneBarcode==borderStorage||zoneBarcode==virtualStorage){
                ext.tip.error("投入线边库和投入虚拟库不可编辑！");
                return;
            } */
            index = $("#halfpart_storageunit_dg").datagrid("getRowIndex", rows[i]);
            $("#halfpart_storageunit_dg").datagrid("beginEdit", index);
            /*var equip_name = $("#storageunit_dg").datagrid('getEditor', {index:index,field:'equip_name'});
            $(equip_name.target).textbox({disabled: true});//不可编辑  */
        }
    }

    //删除库位
    function unit_remove() {
        var rows = $("#halfpart_storageunit_dg").datagrid("getSelections");
        if (rows.length <= 0) {
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index = -1;
        //var zoneBarcode=null;
        for (var i = 0; i < rows.length; i++) {
            /* zoneBarcode=rows[i].storage_zone_barcode_s;
          if(zoneBarcode==borderStorage||zoneBarcode==virtualStorage){
                ext.tip.error("投入线边库和投入虚拟库不可删除！");
                return;
          } */
            index = $("#halfpart_storageunit_dg").datagrid("getRowIndex", rows[i]);
            $("#halfpart_storageunit_dg").datagrid("deleteRow", index);
        }
    }

    //保存库位
    function unit_save() {

        var dg = $("#halfpart_storageunit_dg");
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

        if (!commit_flag & deleted.length == 0) {
            ext.tip.error("<spring:message code="tip.invalid" />");
            return;
        }

        Utils.each(inserted, function (i, d) {
            d.parent_key = storageZoneKey;
        });

        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }

        ext.ajax.sendJson(saveUnitMentChanges, {
            inserted: inserted,
            updated: updated,
            deleted: deleted
        }, function (data) {
            if (data.data != "操作成功") {
                ext.tip.error(data.data);
                storagezonekey = -1;
            }
            // $("#storageunit_dg").datagrid("reload");
            else {
                ext.tip.suc("<spring:message code="tip.success" />");
                storagezonekey = -1;
                unitReload();
            }
            // storageunitManage();
        });
    }

    //取消库位
    function unit_cancel() {
        $("#halfpart_storageunit_dg").datagrid("rejectChanges");
    }

    /**
     * 查询按钮
     * add by YinghuiLan
     */
    var filter = function () {
        description = $('#description').textbox('getValue');
        category = $('#category').textbox('getValue');
        $.ajax({
            url: 'halfpart/basedata/storagezonemanager/searchZoneByCategoryAndZoneName?category=' + category + '&description=' + description,
            type: "post",
            dataType: "json",
            data: JSON,
            contentType: 'application/json',
            async: false,
            success: function (data) {
                $("#halfpart_storagezone_dg").datagrid("loadData", data);
            }
        });
    };

    function clearStatus() {
        $('#storage_type_s').combobox('clear');
    }

    function zoneAndMaterialGroupJudge(record) {
        var rowData = $('#halfpart_storagezone_dg').datagrid('getSelected');
        if (rowData == null) {
            var myIndex = $(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
            var zoneName = $(getZoneEditor(myIndex, 'category').target).combobox('getValue');
            var judgeUrl = 'halfpart/basedata/storagezonemanager/zoneAndMaterialGroupJudge?zoneName=' + zoneName + '&materialGroup=' + record.DICTCODE_S;
            $.ajax({
                url: judgeUrl,
                type: 'get',
                dataType: 'json',
                data: JSON,
                contentTyoe: 'application/json',
                async: true,
                success: function (data) {
                    if (data == true) {
                        $(getZoneEditor(myIndex, 'materialgroup_s').target).combobox('clear');
                        ext.tip.error("当前库区下已维护该物料组，请选择其他物料组！");
                    }
                }
            });
        } else {
            var myIndex = $(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
            $(getZoneEditor(myIndex, 'materialgroup_s').target).combobox({readonly: true});
        }

    }

    /* 	$(function () {
            var pageCount=50;  //分页总数量
              // $("#pagination").pagination(pageCount); //简单初始化方法
                $("#test").pagination(pageCount,    //分布总数量，必须参数
                         {
                    callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                          prev_text: "« 上一页",
                          next_text: "下一页 »",
                          items_per_page:10,
                          num_edge_entries: 2,       //两侧首尾分页条目数
                          num_display_entries: 10,    //连续分页主体部分分页条目数
                          current_page: 0,   //当前页索引
                         });
         }); */

    function zone_unit_qu() {
        $('#halfpart_storagezone_dg2').datagrid({
            url: 'halfpart/basedata/storagezonemanager/zone',
            fit: true,
            fitColumns: true,
            emptyMsg: '<span><spring:message code='tip.noData'/></span>',
            singleSelect: false,
            striped: true,
            method: 'get'
        });

        // 延迟加载详细视图
        setTimeout(LoadView, 200);
        $('#manage_dg').dialog("open")

    }

    /**
     * 库区新增判重
     * 李新宇
     */
    function checkZone(e) {
        const v = e.currentTarget.value
        let rows = $('#halfpart_storagezone_dg2').datagrid('getRows');
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        for (let i = 0; i < rows.length; i++) {
            if (typeof (rows[i].storage_zone_name) == 'undefined') {
                let target = $('#halfpart_storagezone_dg2').datagrid('getEditor', {
                    index: i,
                    field: 'storage_zone_name'
                })
                if ($(target.target.textbox('getValue')).selector != "" && i != index) {
                    if ($(target.target.textbox('getValue')).selector === e.currentTarget.value) {
                        e.currentTarget.value = "";
                        ext.tip.error('库区相同,请核实后重新输入!');
                    }
                }
            }
            if (rows[i].storage_zone_name === v) {
                e.currentTarget.value = "";
                ext.tip.error('库区相同,请核实后重新输入!');
            }
        }
    }

    //主界面分页用(假分页，先查询页面，再走JS进行分页)
    function pagerFilter(data) {
        if (typeof data.length == 'number' && typeof data.splice == 'function') {   // is array
            data = {
                total: data.length,
                rows: data
            }
        }
        var dg = $(this);
        var opts = dg.datagrid('options');
        var pager = dg.datagrid('getPager');
        pager.pagination({
            onSelectPage: function (pageNumber, pageSize) {
                opts.pageNumber = pageNumber;
                opts.pageSize = pageSize;
                pager.pagination('refresh', {
                    pageNumber: pageNumber,
                    pageSize: pageSize
                });
                dg.datagrid('loadData', data);
            },
            onRefresh: function () {
                dg.datagrid('reload');
            }
        });
        if (!data.originalRows) {
            data.originalRows = (data.rows);
        }
        var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
        var end = start + parseInt(opts.pageSize);
        data.rows = (data.originalRows.slice(start, end));
        return data;
    }
</script>