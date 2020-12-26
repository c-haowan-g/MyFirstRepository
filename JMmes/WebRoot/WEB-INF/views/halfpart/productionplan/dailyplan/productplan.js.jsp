<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">
    var overallPlanData = "";
    var overallorder = 0;
    $(function () {
        overallPlanData = $("#plandate_s").datebox("getValue");
        getLatestOrder(overallPlanData);
    });

    function getLatestOrder(planData) {
        $.ajax({
            url: 'halfpart/productionplan/dailyplan/getMaxPlanOrder?planData=' + planData,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.length == 0) {
                    overallorder = 0;
                }
                overallorder = data[0];
            }
        });
    }

    var saveChanges = path + "halfpart/productionplan/dailyplan/saveChanges";

    function showOrHide() {
        if ($("#ProductPlan_search_form").is(":hidden")) {
            $("#ProductPlan_search_form").show();
        } else {
            $("#ProductPlan_search_form").hide();
        }
    }

    function planStatusColorSetting(value, row, index) {
        if (value == "104001") {
            return 'text-align: center;';
        } else if (value == "104002") {
            return 'background-color:#FFFF00;text-align: center;';
        } else if (value == "104003") {
            return 'background-color:#00FFFF;text-align: center;';
        } else if (value == "104004") {
            return 'background-color:#00FF00;text-align: center;';
        } else if (value == "104005") {
            return 'background-color:#FF0000;text-align: center;';
        } else if (value == "104006") {
            return 'background-color:#C0C0C0;text-align: center;';
        }
    }

    function centerSetting(value, row, index) {
        return 'text-align: center;';
    }

    function getDg() {
        return $("#productplan_dg");  //$("#a_dg"):获取并返回选中的标签页
    }

    function getSortDg() {
        return $("#productplanresort_dg");  //$("#a_dg"):获取并返回选中的标签页
    }

    function codeFormatter(v, r, i) {
        if (v == null) {
            return "";
        }
        return dictFormat(v);
    }

    function productStageFormatter(v, r, i) {
        if (v == '01') {
            return "试制";
        } else if (v == '02') {
            return "试产";
        } else if (v == '03') {
            return "投产";
        } else {
            return v;
        }
    }

    function autoJudgeFormatter(v, r, i) {
        if (v == 0) {
            return "否";
        }
        if (v == 1) {
            return "是";
        }
        if (v == null) {
            return "未知";
        }
    }

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
     * 获取半部件用物料信息
     * 2019/07/08
     * 兰颖慧
     */
    var materialList = [];
    $.ajax({
        url: "sap/materials/getMaterialList",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            materialList = data;
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

    /**
     * 日期格式化
     * 2019/03/12
     * 兰颖慧
     */
    function dateFormat(date) {
        return new Calendar(date).format("yyyyMMdd");
    }

    /**
     * 解析指定格式日期
     * 2019/03/12
     * 兰颖慧
     */
    function dateParser(s) {
        if (!s)
            return new Date();
        return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s.substring(6, 8));
    }

    /**
     * 班次显示转化
     * 2019-05-20
     * 兰颖慧
     */
    var classList = [];
    $.ajax({
        url: "dict/code/118",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            classList = data;
        }
    });

    function classCodeFormatter(v, r, i) {
        for (var i = 0; i < classList.length; i++) {
            if (v == classList[i].code) {
                return classList[i].text;
            }
        }

    }

    /**
     * 计划状态显示转化
     * 2019-05-20
     * 兰颖慧
     */
    var planStatus = [];
    $.ajax({
        url: "dict/code/104",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            planStatus = data;
        }
    });

    function planStatusFormatter(v, r, i) {
        for (var i = 0; i < planStatus.length; i++) {
            if (v == planStatus[i].code) {
                return planStatus[i].text;
            }
        }

    }

    var productLineList = [];
    $.ajax({
        url: "halfpart/basedata/productlinemanager/getHalfPartProductionLine",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            productLineList = data;
        }
    });

    /**
     * 主界面加载触发（按时间加载当天数据）
     * 2019-05-20
     * 兰颖慧
     */
    function onDgBeforeLoad(param) {
        if ($("#plandate_s").datebox("getValue") == "") {
            return false;
        }
        param["filter[plandate_s]"] = $("#plandate_s").datebox("getValue");
    }

    /**
     * 查询方法
     * 2019-04-21
     * 兰颖慧
     */
    function filter() {
        overallPlanData = $("#plandate_s").datebox("getValue");
        getLatestOrder(overallPlanData);
        ext.easyui.grid.search("productplan_dg", "ProductPlan_search_form");
    };

    /**
     * 日计划添加前的校验提示（可优化）,校验成功添加日计划
     * 2019-05-22
     * 兰颖慧
     */
    function judge() {
        var planData = $("#plandate_s").datebox("getValue");     //初始默认获取查询栏选择的计划日期;
        var myDate = new Calendar().format("yyyyMMdd");
        var newDate = new Date();
        var hours = newDate.getHours();

        if (planData == null || planData == "") {
            return "计划时间不可为空";
        }
        if (planData < myDate) {
            return "不可添加选定日期之前 的计划";
        }
        if (planData == myDate && hours >= 16) {
            return "已过16：00，允许新建明日及以后的计划，请在查询栏重新选择计划生产日期";
        }
        var equipCode = $("#equip_code_s").combobox("getValue");  //初始默认获取查询栏选择的机台号
        if (equipCode == null || equipCode == "") {
            if (confirm("仅钢丝圈和热帖不需要选择机台,是否需要选择机台") == true) {
                return "请在查询栏选择机台";
            }
        }
        return "";
    }

    function add() {
        var planData = $("#plandate_s").datebox("getValue");     //初始默认获取查询栏选择的计划日期;
        var equipCode = $("#equip_code_s").combobox("getValue");  //初始默认获取查询栏选择的机台号
        var equipDesc = $("#equip_code_s").combobox("getText");  //初始默认获取查询栏选择的机台号
        $.ajax({
            url: "sap/materials/getMaterialList",
            type: "get",
            dataType: "json",
            async: false,
            success: function (data) {
                materialList = data;
            }
        });
        var judgeResult = judge();
        if (!(judgeResult == "")) {
            ext.tip.warn(judgeResult);
            return;
        }
        overallorder++;
        var customerFlag = '328001';  //客户标识，初始默认无特殊要求
        var planStatus = '104001';    //计划状态，初始默认未审核
        var planOutput = 1;         //日计划产量，初始默认0
        var auto = 0;                 //是否自动
        var rows = {};
        rows.status_s = planStatus;
        rows.morn_status_s = planStatus;
        rows.noon_status_s = planStatus;
        rows.even_status_s = planStatus;
        rows.plandate_s = planData;
        rows.equip_code_s = equipCode;
        rows.spare1_s = equipDesc;
//      rows.productstage_s = '03';
        rows.customerflag_s = customerFlag;
        rows.noon_planquantityconfirm_f = planOutput;
        rows.even_planquantityconfirm_f = planOutput;
        rows.morn_planquantityconfirm_f = planOutput;
        rows.handflag_s = auto;
        rows.noon_plan_order_i = overallorder;
        rows.even_plan_order_i = overallorder;
        rows.morn_plan_order_i = overallorder;
        rows.paraversion_s = '1';
//      rows.repiceno_s = '1';
        var urlPlanNo = 'halfpart/productionplan/dailyplan/createPlanCode?planData=' + planData; //创建日计划号
        $.ajax({
            url: urlPlanNo,
            type: 'get',
            dataType: 'json',
            async: true,
            success: function (urlPlanNo) {
                rows.spare3_s = urlPlanNo[0],
                    rows.noon_planno_s = urlPlanNo[0],
                    rows.even_planno_s = urlPlanNo[1],
                    rows.morn_planno_s = urlPlanNo[2],
                    ext.easyui.grid.appendAndEdit("productplan_dg", rows);
            }
        });
    }

    /**
     * 日计划编辑
     * 2019-04-12
     * 兰颖慧
     */
    function edit() {
        var rows = $("#productplan_dg").datagrid("getSelections");
        if (rows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var index = -1;
        var ids = []; //声明数组
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].status_s == '104001') {
                var index = -1;
                index = $("#productplan_dg").datagrid("getRowIndex", rows[i]);
                $("#productplan_dg").datagrid("beginEdit", index);
            } else {
                ext.tip.warn("仅未审核的计划可编辑");
            }
            ;
        }
        ;
    }

    /**
     * 日计划删除
     * 2019-04-12
     * 兰颖慧
     */
    function remove() {
        var rows = $("#productplan_dg").datagrid("getSelections");//getChecked:返回复选框中选中的所有行
        if (rows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var ids = []; //声明数组
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].status_s == '104001') {
                var index = -1;
                index = $("#productplan_dg").datagrid("getRowIndex", rows[i]);
                $("#productplan_dg").datagrid("deleteRow", index);
            } else {
                ext.tip.warn("仅未审核的计划可删除");
            }
            ;
        }
        ;
    }

    /**
     * 日计划保存
     * 2019-04-12
     * 兰颖慧
     */
    function save() {
        var dg = $("#productplan_dg");
        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
            ;
        }
        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");
        var noon_planquantityconfirm_f = 1;
        var even_planquantityconfirm_f = 1;
        var morn_planquantityconfirm_f = 1;
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        if (inserted.length > 0) {
            for (var i = 0; i < inserted.length; i++) {
                noon_planquantityconfirm_f = inserted[i].noon_planquantityconfirm_f;
                even_planquantityconfirm_f = inserted[i].even_planquantityconfirm_f;
                morn_planquantityconfirm_f = inserted[i].morn_planquantityconfirm_f;
                if ((noon_planquantityconfirm_f == 0) && (even_planquantityconfirm_f == 0) && (morn_planquantityconfirm_f == 0)) {
                    ext.tip.error("存在计划三班计划数量都为0");
                    return;
                }
            }
        }
        ext.ajax.sendJson(saveChanges, {
            inserted: inserted,
            updated: updated,
            deleted: deleted
        }, function (data) {
            if (data.message != "ok") {
                ext.tip.error(data.message);
            } else {
                ext.tip.suc("<spring:message code="tip.success" />");
            }
            $("#productplan_dg").datagrid("reload");
        });
    }

    /**
     * 日计划重排序后保存
     * 2019-05-22
     * 兰颖慧
     */
    function sortDataSave() {
        var dg = $("#productplanresort_dg");
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

            if (data.message != "ok") {
                ext.tip.error("<spring:message code="tip.invalid" />");
            } else {
                ext.tip.suc("<spring:message code="tip.success" />");
            }
            resortDataLoad();


        });
    }

    /**
     * 日计划编辑取消
     * 2019-04-12
     * 兰颖慧
     */
    function cancel() {
        var planData = $("#plandate_s").datebox("getValue");
        getLatestOrder(planData);
        $("#productplan_dg").datagrid("rejectChanges");
    }

    /**
     * 日计划重排序编辑取消
     * 2019-04-12
     * 兰颖慧
     */
    function sortDataCancel() {
        $("#productplanresort_dg").datagrid("rejectChanges");
    }

    /**
     * 获取机台条码
     * 2019-04-12
     * 兰颖慧
     */
    function onEquipcodeSelect(item) {
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        var producteDate = $(getEditor(index, "production_date_s").target).textbox("getValue");
        var url = 'cx/scgl/rjh/getPlanqueue?equipcode=' + item.value + "&productdate=" + producteDate;
        $.ajax({
            url: url,
            type: 'get',
            dataType: 'json',
            async: true,
            success: function (data) {
                $(getEditor(index, "plan_queue_i").target).textbox('setValue', data);
            } //设置顺序号
        });
    }

    /**
     * 半部件日计划审核
     * 2019/04/25
     * 兰颖慧
     */
    function audit() {
        var rows = getDg().datagrid("getChecked");//getChecked:返回复选框中选中的所有行
        if (rows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var ids = []; //声明数组
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].status_s != '104001') {
                ext.tip.warn("请核对所选计划的状态，仅未审核状态允许审核");
                return;
            }
            //ids.push(rows[i].atr_key);
            ids.push(rows[i].morn_atr_key);
            ids.push(rows[i].noon_atr_key);
            ids.push(rows[i].even_atr_key);
        }

        ext.ajax.post("halfpart/productionplan/dailyplan/audit", {ids: ids.toString()},
            function (data) { //ext.ajax.post:用于客户端向服务端传输数据
                if (data.code == OK) {
                    ext.tip.suc();
                    filter();
                    return;
                }
                ext.tip.error(data.message);
            });
    }

    /**
     * 半部件日计划取消 审核
     * 2019/04/22
     * 兰颖慧
     */
    function auditCancel() {
        var rows = getDg().datagrid("getSelections");
        if (rows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var ids = [];
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].status_s != '104002') {
                //ext.tip.warn("<spring:message code="tip.unaudited" />");
                ext.tip.warn("请核对所选计划的状态，仅已审核状态允许撤销审核");
                return;
            }
            ids.push(rows[i].morn_atr_key);
            ids.push(rows[i].noon_atr_key);
            ids.push(rows[i].even_atr_key);
        }
        ext.ajax.post("halfpart/productionplan/dailyplan/auditCancel", {ids: ids.toString()}, function (data) {
            if (data.code != OK) {
                return;
            }
            ext.tip.suc();
            filter();
        });
    }

    /**
     * 半部件日计划关闭
     * 2019/04/22
     * 兰颖慧
     */
    function planClose() {
        var rows = getDg().datagrid("getChecked");//getChecked:返回复选框中选中的所有行
        if (rows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var ids = []; //声明数组
        for (var i = 0; i < rows.length; i++) {
            if (rows[i].status_s == '104006') {
                continue;
            }
            ids.push(rows[i].morn_atr_key);
            ids.push(rows[i].noon_atr_key);
            ids.push(rows[i].even_atr_key);
        }
        if (ids.length > 0) {
            ext.ajax.post("halfpart/productionplan/dailyplan/planClose", {ids: ids.toString()},
                function (data) { //ext.ajax.post:用于客户端向服务端传输数据
                    if (data.code == OK) {
                        ext.tip.suc();
                        filter();
                        return;
                    }
                    ext.tip.error(data.message);
                });
        }
    }

    /**
     * 重排序弹出界面
     * 2019-05-21
     * 兰颖慧
     */
    function resetOrder() {
        if ($("#plandate_s").datebox("getValue") == "" || $("#plandate_s").datebox("getValue") == null) {
            alert("请选择计划日期、班次和机台");
        } else if ($("#classcode_s").combobox("getValue") == "" || $("#classcode_s").combobox("getValue") == null) {
            alert("请选择计划日期、班次和机台");
        } else if ($("#equip_code_s").combobox("getValue") == "" || $("#equip_code_s").combobox("getValue") == null) {
            alert("请选择计划日期、班次和机台");
        } else {
            $("#ProductPlanResort").dialog("open");
        }
    }

    /**
     * 重排序弹出界面前按照生产日期、班次和机台加载数据
     * 2019-05-21
     * 兰颖慧
     */
    function resortDataLoad() {
        var planDate = $("#plandate_s").datebox("getValue");
        var classCode = $("#classcode_s").combobox("getValue");
        var equipCode = $("#equip_code_s").combobox("getValue");
        $.ajax({
            url: 'halfpart/productionplan/dailyplan/getSortingData?planDate=' + planDate + '&equipCode=' + equipCode + '&classCode=' + classCode,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (data) {
                $("#productplanresort_dg").datagrid('loadData', data);
            }
        });
    }

    /**
     * 上移
     * 2019-04-21
     * 兰颖慧
     *
     */
    function upper() {
        var planData = $("#plandate_s").datebox("getValue");     //初始默认获取查询栏选择的计划日期
        if (planData == null) {
            alert("请选择日期！");
        }
        var allRows = getSortDg().datagrid('getRows');      //获得界面的所有行
        var selectedRows = getSortDg().datagrid('getSelections');//获取所有的选择行
        var currentRow = getSortDg().datagrid('getSelected');//获得待上移行（选中行）
        var currentRowIndex = getSortDg().datagrid('getRowIndex', currentRow);////获得待上移行（选中行）的下标
        if (selectedRows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        if (selectedRows.length > 1) {
            ext.tip.warn("只能选择一条");
            return;
        }
        if (currentRowIndex == 0) {
            ext.tip.warn("当前行不可上移");
            return;
        }
        var upperRow = allRows[currentRowIndex - 1];        //获得当前行的上一行
        var currentOrder = upperRow.plan_order_i;       //获得待上移行（选中行）的order
        var upperOrder = currentRow.plan_order_i;
        var upperRowIndex = currentRowIndex - 1;
        getSortDg().datagrid('deleteRow', currentRowIndex);      //删除选中行
        getSortDg().datagrid('insertRow', {index: (currentRowIndex - 1), row: currentRow});  //插入行
        getSortDg().datagrid('updateRow', {
            index: upperRowIndex,
            row: {plan_order_i: currentOrder}
        });
        getSortDg().datagrid('updateRow', {
            index: currentRowIndex,
            row: {plan_order_i: upperOrder}
        });
        getSortDg().datagrid('selectRow', upperRowIndex);
    }

    /**
     * 下移
     * 2019-04-21
     * 兰颖慧
     *
     */
    function lower() {
        var allRows = getSortDg().datagrid('getRows');      //获得界面的所有行
        var selectedRows = getSortDg().datagrid('getSelections');//获取所有的选择行
        var currentRow = getSortDg().datagrid('getSelected');//获得待下移行（选中行）
        var currentRowIndex = getSortDg().datagrid('getRowIndex', currentRow);
        if (selectedRows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        if (selectedRows.length > 1) {
            ext.tip.warn("只能选择一条");
            return;
        }
        if (currentRowIndex == allRows.length - 1) {
            ext.tip.warn("当前行不可下移");
            return;
        }
        var lowerRow = allRows[currentRowIndex + 1];        //获得当前行的下一行
        var currentOrder = currentRow.plan_order_i;      //获得待上移行（选中行）的order
        var lowerOrder = lowerRow.plan_order_i;
        var lowerRowIndex = currentRowIndex + 1;
        getSortDg().datagrid('deleteRow', currentRowIndex);      //删除选中行
        getSortDg().datagrid('insertRow', {index: lowerRowIndex, row: currentRow});  //插入行
        getSortDg().datagrid('updateRow', {
            index: lowerRowIndex,
            row: {plan_order_i: lowerOrder}
        });
        getSortDg().datagrid('updateRow', {
            index: currentRowIndex,
            row: {plan_order_i: currentOrder}
        });
        getSortDg().datagrid('selectRow', lowerRowIndex);
    }

    /**
     *审核-SOS测试
     *黄文娟
     **/
    function auditSosTest() {
        ext.ajax.post("halfpart/productionplan/dailyplan/saveProductPlan",
            function (data) { //ext.ajax.post:用于客户端向服务端传输数据
                if (data.code == OK) {
                    ext.tip.suc();
                    filter();
                    return;
                }
                ext.tip.error(data.message);
            });
    }

    /**
     * 根据物料编码和产品阶段进行后台校验，校验成功返回对应的工艺版本号、配方版本、 生产版本（SAP下发版本号，校验失败返回相应提示
     * 兰颖慧
     * 2019-04-22
     */
    function checkAndLoadData(newData, oldData) {
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        var specification_s = $(getEditor(index, "specification_s").target).textbox('getValue');
        var materialCode = $(getEditor(index, "materialcode_s").target).textbox('getValue');
        var productVersion = $(getEditor(index, "sapversion_s").target).textbox('getValue');
        if (specification_s == null || specification_s == "" || materialCode == null || materialCode == "") {
            if (!(newData != "" && oldData == "")) {
                alert("请先选择物料！");
                return;
            }
        }
        if (newData == null || newData == "") {
            return;
        }
        var checkAndGetVersionByCode = 'halfpart/productionplan/dailyplan/checkBomAndVersion?materialCode=' + materialCode + '&productStage=' + newData + '&productVersion=' + productVersion;
        var getCheckedDataByMaterialCode = 'halfpart/productionplan/dailyplan/getCheckedDataByMaterialCode?materialCode=' + materialCode + '&productStage=' + newData;
        $.ajax({
            url: checkAndGetVersionByCode,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (dataByMaterialCode) {
                if (dataByMaterialCode == "StandardData") {
                    $.ajax({
                        url: getCheckedDataByMaterialCode,
                        type: 'get',
                        dataType: 'json',
                        async: false,
                        success: function (checkedData) {
                            $(getEditor(index, "paraversion_s").target).textbox("setValue", checkedData[0].PROCESSVERSION_S);
                            $(getEditor(index, "repiceno_s").target).textbox("setValue", checkedData[0].VERSION_S);
                            $(getEditor(index, "parameterid_s").target).textbox("setValue", checkedData[0].ID_S);
                        }
                    });
                } else {
                    alert(dataByMaterialCode);
                    $(getEditor(index, "productstage_s").target).combobox("clear");
                    $(getEditor(index, "paraversion_s").target).textbox("clear");
                    $(getEditor(index, "repiceno_s").target).textbox("clear");
                    $(getEditor(index, "parameterid_s").target).textbox("clear");
                }


            }
        });
    }

    /**
     * 获取指定行、指定列的编辑器
     * 2019-04-21
     * 兰颖慧
     */
    function getEditor(index, field) {
        return $("#productplan_dg").datagrid("getEditor", {index: index, field: field});
    };

    /**
     * 日计划复制
     * 2019-04-21
     * 兰颖慧
     */
    function copy() {
        $("#productplancopy_dg").dialog("open");
        $('#copyframe').attr('src', 'view?page=halfpart/productionplan/dailyplan/productplancopy&factory=' + factory);
    };

    function reLoadDataGrid() {
        $('#productplan_dg').datagrid("reload");
    }
    
    function closeWindow(){
    	setTimeout(function(){
	    	$('#productplancopy_dg').dialog('close');
    	}, 300);
    }

    /**
     * 选择物料规格后,清除数据并设置新的物料编码相关信息
     * 2019年08-21
     * 兰颖慧
     */
    function onSetMatDescCodeGroup(record) {
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        $.ajax({
            url: 'halfpart/productionplan/dailyplan/getMatInfoByMatSpec?materialSpec=' + record.OLDMATCODE_S,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.length == 0) {
                    alert("物料规格:" + record.OLDMATCODE_S + "对应的物料的SAP下发版本(生产版本)不存在");
                    $(getEditor(index, "spare9_s").target).textbox('clear');//物料名称(备用字段)
                    $(getEditor(index, "materialname_s").target).textbox('clear');//物料名称
                    $(getEditor(index, "materialcode_s").target).combobox('clear');//物料编码
                    $(getEditor(index, "materialgroup_s").target).textbox('clear');//物料组编码
                    $(getEditor(index, "materialdesc_s").target).textbox('clear');//物料组名称
                    $(getEditor(index, "sapversion_s").target).textbox('clear');//生产版本
                    $(getEditor(index, "overpercent_f").target).textbox('clear');//物料超产百分比
                    $(getEditor(index, "productstage_s").target).textbox('clear');//产品阶段
                    $(getEditor(index, "repiceno_s").target).combobox('setValue','');//配方版本(BOM版本)
                    //$(getEditor(index, "paraversion_s").target).combobox('setValue','');//工艺版本
                    //$(getEditor(index, "parameterid_s").target).combobox('setValue','');//工艺版本ID
                }
                ;
                $(getEditor(index, "spare9_s").target).textbox('setValue', data[0].SUBITEMDESC_S);//物料名称(备用字段)
                $(getEditor(index, "materialname_s").target).textbox('setValue', data[0].MATERIALDESC_S);//物料名称
                $(getEditor(index, "materialcode_s").target).combobox('setValue', data[0].MATERIALCODE_S);//物料规格
                $(getEditor(index, "materialgroup_s").target).textbox('setValue', data[0].DICTCODE_S);//物料组编码
                $(getEditor(index, "materialdesc_s").target).textbox('setValue', data[0].DICTNAME_S);//物料组名称
                $(getEditor(index, "sapversion_s").target).textbox('setValue', data[0].PRODUCTION_VER_S);//生产版本
                $(getEditor(index, "overpercent_f").target).textbox('setValue', data[0].SORTNO_I);//物料超产百分比
				$(getEditor(index, "productstage_s").target).combobox('setValue',data[0].PROPHASE_S);//产品阶段
                $(getEditor(index, "repiceno_s").target).combobox('setValue',data[0].MASTERREVISION_S);//配方版本(BOM版本)
                //$(getEditor(index, "paraversion_s").target).combobox('setValue','');//工艺版本
                //$(getEditor(index, "parameterid_s").target).combobox('setValue','');//工艺版本ID
            }
        });
    };

    /**
     * 选择物料编码后,清除数据并设置新的物料编码相关信息
     * 2019年08-21
     * 兰颖慧
     */
    function onSetMatDescSpecGroup(record) {
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        $.ajax({
            url: 'halfpart/productionplan/dailyplan/getMatInfoByMatCode?materialCode=' + record.MATERIALCODE_S,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.length == 0) {
                    alert("物料编码:" + record.MATERIALCODE_S + "对应的物料的生产版本不存在");
                    $(getEditor(index, "spare9_s").target).textbox('clear');//物料名称(备用字段)
                    $(getEditor(index, "materialname_s").target).textbox('clear');//物料名称
                    $(getEditor(index, "specification_s").target).combobox('clear');//物料规格
                    $(getEditor(index, "materialgroup_s").target).textbox('clear');//物料组编码
                    $(getEditor(index, "materialdesc_s").target).textbox('clear');//物料组名称
                    $(getEditor(index, "sapversion_s").target).textbox('clear');//生产版本
                    $(getEditor(index, "overpercent_f").target).textbox('clear');//物料超产百分比
                    $(getEditor(index, "productstage_s").target).textbox('clear');//产品阶段
                    $(getEditor(index, "repiceno_s").target).combobox('setValue','');//配方版本(BOM版本)
                    //$(getEditor(index, "paraversion_s").target).combobox('setValue','');//工艺版本
                    //$(getEditor(index, "parameterid_s").target).combobox('setValue','');//工艺版本ID
                }
                ;
                $(getEditor(index, "spare9_s").target).textbox('setValue', data[0].SUBITEMDESC_S);//物料名称(备用字段)
                $(getEditor(index, "materialname_s").target).textbox('setValue', data[0].MATERIALDESC_S);//物料名称
                $(getEditor(index, "specification_s").target).combobox('setValue', data[0].OLDMATCODE_S);//物料规格
                $(getEditor(index, "materialgroup_s").target).textbox('setValue', data[0].DICTCODE_S);//物料组编码
                $(getEditor(index, "materialdesc_s").target).textbox('setValue', data[0].DICTNAME_S);//物料组名称
                $(getEditor(index, "sapversion_s").target).textbox('setValue', data[0].PRODUCTION_VER_S);//生产版本
                $(getEditor(index, "overpercent_f").target).textbox('setValue', data[0].SORTNO_I);//物料超产百分比
			  	$(getEditor(index, "productstage_s").target).combobox('setValue',data[0].PROPHASE_S);//产品阶段
                $(getEditor(index, "repiceno_s").target).combobox('setValue',data[0].MASTERREVISION_S);//配方版本(BOM版本)
                //$(getEditor(index, "paraversion_s").target).combobox('setValue','');//工艺版本
                //$(getEditor(index, "parameterid_s").target).combobox('setValue','');//工艺版本ID
            }
        });
    };

    /**
     * 选择物料名称后,清除数据并设置新的物料编码相关信息
     * 2019年08-21
     * 兰颖慧
     */
    /* function onSetMatCodeSpecGroup(record) {
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        $.ajax({
            url: 'halfpart/productionplan/dailyplan/getMatInfoByMatDesc?materialDesc=' + record.MATERIALDESC_S,
            type: 'get',
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.length == 0) {
                    alert("物料规格:" + record.MATERIALDESC_S + "对应的物料的SAP下发版本(生产版本)不存在");
                    $(getEditor(index, "materialcode_s").target).combobox('clear');//物料编码
                    $(getEditor(index, "specification_s").target).combobox('clear');//物料规格
                    $(getEditor(index, "materialgroup_s").target).textbox('clear');//物料组编码
                    $(getEditor(index, "materialdesc_s").target).textbox('clear');//物料组名称
                    $(getEditor(index, "sapversion_s").target).textbox('clear');//生产版本
                    $(getEditor(index, "overpercent_f").target).textbox('clear');//物料超产百分比
                }
                $(getEditor(index, "materialcode_s").target).combobox('setValue', data[0].MATERIALCODE_S);//物料编码
                $(getEditor(index, "specification_s").target).combobox('setValue', data[0].OLDMATCODE_S);//物料规格
                $(getEditor(index, "materialgroup_s").target).textbox('setValue', data[0].DICTCODE_S);//物料组编码
                $(getEditor(index, "materialdesc_s").target).textbox('setValue', data[0].DICTNAME_S);//物料组名称
                $(getEditor(index, "sapversion_s").target).textbox('setValue', data[0].PRODUCTION_VER_S);//生产版本
                $(getEditor(index, "overpercent_f").target).textbox('setValue', data[0].SORTNO_I);//物料超产百分比
            }
        });
    }; */

    /**
     * 日计划按日自动编制
     * 2019年08-21
     * 兰颖慧
     */
    function planAutoMakingByDate() {
        var choose = confirm("计划倒推会删除指定半部件计划日期的所有计划并根据成型计划的胎胚信息生成新的半部件计划,是否执行倒推？");
        if (choose == true) {
            var currentDate = new Calendar().format("yyyyMMdd");
            var buildingDate = $('#buildingDate').datebox('getValue');
            var halfpartDate = $('#plandate_s').datebox('getValue');
            //1.判断半部件计划日期是否在明天及以后
            if (halfpartDate < currentDate) {
                ext.tip.warn("只能倒推明天及以后的半部件计划，请重新选择半部件计划日期");
                return;
            }
            $('#planautomakingbydate').linkbutton('disable');
            $('#planautomakingbyclass').linkbutton('disable');
            $('#searchId').linkbutton('disable');
            $("#loading").attr("style", "display:block;background:#00FFFF;text-align:center;height:10%;text-align:center;line-height:50px;font-size:30px");//显示div
            $.ajax({
                url: 'halfpart/productionplan/automaking/planAutoMaking?halfPartDate=' + halfpartDate + '&buildingDate=' + buildingDate + '&model=' + "date",
                type: "get",
                dataType: "json",
                async: true,
                success: function (data) {
                    $.messager.alert({
                        width: 700,
                        height: 350,
                        title: '未排产信息',
                        msg: data
                    });
                    $("#loading").attr("style", "display:none;");//显示div
                    $('#planautomakingbydate').linkbutton('enable');
                    $('#planautomakingbyclass').linkbutton('enable');
                    $('#searchId').linkbutton('enable');
                }
            });
        } else {
            return;
        }
        $("#productplan_dg").datagrid("reload");
    };

    /**
     * 日计划一键复制
     *
     */
    function oneClickCopy() {
        var fromPlanDate = $("#plandate_s").datebox("getValue");
        var toPlanDate = $("#plandate_to_s").datebox("getValue");
        var url = 'halfpart/productionplan/dailyplan/oneClickCopy?fromPlanDate=' + fromPlanDate + "&toPlanDate=" + toPlanDate;
        var choose = confirm("是否一键复制日期：" + fromPlanDate + "的计划到" + "日期" + toPlanDate + "？");
        if (choose == true) {
            ext.ajax.get(url, function (data) {
                if (!(data.message == "ok")) {
                    ext.tip.error("<spring:message code="tip.error" />");
                    return;
                }
                ext.tip.suc("<spring:message code="tip.success" />");
                $("#productplan_dg").datagrid("reload");
            });
        } else {
            ext.tip.warn("<spring:message code="tip.updatefromdateandtodate" />");
        }
    };

    /**
     * 日计划一键审核
     *
     */
    function oneClickAudit() {
        var fromPlanDate = $("#plandate_s").datebox("getValue");
        var url = 'halfpart/productionplan/dailyplan/oneClickAudit?planDate=' + fromPlanDate;
        var choose = confirm("是否一键审核" + fromPlanDate + "的所有未审核计划？");
        if (choose == true) {
            ext.ajax.get(url, function (data) {
                if (!(data.message == "ok")) {
                    ext.tip.error("<spring:message code="tip.error" />");
                    return;
                }
                ext.tip.suc("<spring:message code="tip.success" />");
                $("#productplan_dg").datagrid("reload");
            });
        } else {
            ext.tip.warn("<spring:message code="tip.updatenewdate" />");
        }
    };

    /**
     * 日计划一键撤销审核
     *
     */
    function oneClickCancelAudit() {
        var fromPlanDate = $("#plandate_s").datebox("getValue");
        var url = 'halfpart/productionplan/dailyplan/oneClickCancelAudit?planDate=' + fromPlanDate;
        var choose = confirm("是否一键撤销审核" + fromPlanDate + "的所有已审核计划？");
        if (choose == true) {
            ext.ajax.get(url, function (data) {
                if (!(data.message == "ok")) {
                    ext.tip.error("<spring:message code="tip.error" />");
                    return;
                }
                ext.tip.suc("<spring:message code="tip.success" />");
                $("#productplan_dg").datagrid("reload");
            });
        } else {
            ext.tip.warn("<spring:message code="tip.updatenewdate" />");
        }
    };


</script>