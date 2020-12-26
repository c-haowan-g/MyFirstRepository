<%@page import="org.xdemo.app.xutils.j2se.DateUtils" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<script type="text/javascript">

    function codeFormatter(v, r, i) {
        return dictFormat(v);
    }

    //更改冲产报产颜色
    var cellStyler = function (value, row, index) {
        if (value == "01") {
            return 'background-color:#d4f5d7;';
        } else if (value == "02") {
            return 'background-color:#f5dbdb;';
        } else if (value == "03") {
            return 'background-color:#fa3101;';
        }
    }
    //更改上报状态的颜色列
    var cellSapRecordStyler = function (value, row, index) {
        if (value == "0") {
            return 'background-color:#caf0b5;';
        } else if (value == "1") {
            return 'background-color:#f2e1b7;';
        } else if (value == "2") {
            return 'background-color:#06fa01;';
        } else if (value == "3") {
            return 'background-color:#fa3101;';
        }
    }
    //固化标识颜色转换
    var solidflagStyler = function (value, row, index) {
        if (value == "0") {
            return 'background-color:#caf0b5;';
        }
    }

    //固化标识转换
    function ghFormatter(v, r, i) {
        if (v == '1') {
            return '已固化';
        } else {
            return '未固化';
        }
    }
	//添加标识转换
    function tjFormatter(v, r, i) {
        if (v == '1') {
            return '已添加';
        } else {
            return '未添加';
        }
    }
    //报产方式
    function bcTypeFormatter(v, r, i) {
        if (v == '01') {
            return '报产';
        } else if (v == '02') {
            return '冲产';
        } else if (v == '03') {
            return '异常';
        }
    }

    function rsFormatter(v, r, i) {
        if (v == '0') {
            return 'SAP未读取';
        } else if (v == '1') {
            return '已读取';
        } else if (v == '2') {
            return '正常';
        } else if (v == '3') {
            return '错误';
        } else {
            return v;
        }
    }

    $(function () {
        $('#process_s').textbox("setValue", "252006");
        $("#process_s").next().hide();
        filter();
    });

    /**
     * 查询方法
     */
    function filter() {
        ext.easyui.grid.search("messapproduction_dg",
            "MesSapProduction_search_form");
    }

    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(dgId, index, field) {
        try {
            return $("#" + dgId).datagrid("getEditor", {
                index: index,
                field: field
            });
        } catch (e) {
            return null;
        }

    }

    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditorValue(dgId, index, field) {
        return $("#" + dgId).datagrid("getEditor", {
            index: index,
            field: field
        });
    }

    /**
     * 清空指定行指定列的值
     */
    function clearFieldValue(dgId, index, field) {
        try {
            $(getEditor(dgId, index, field).target).combobox("clear")
        } catch (e) {
        }
        try {
            $(getEditor(dgId, index, field).target).numberspinner("clear")
        } catch (e) {
        }
        try {
            $(getEditor(dgId, index, field).target).textbox("clear")
        } catch (e) {
        }
        try {
            $(getEditor(dgId, index, field).target).combobox("clear")
        } catch (e) {
        }

    }

    function getRowByIndex(dgId, index) {
        return $("#" + dgId).datagrid("getRows")[index];
    }

    function getFieldValue(dgId, index, field) {
        var v = "";
        if (getEditor(dgId, index, field) == null) {
            return getRowByIndex(dgId, index)[field];
        }

        try {
            v = $(getEditor(dgId, index, field).target).combobox("getValue");
        } catch (e) {
        }
        try {
            v = $(getEditor(dgId, index, field).target).numberspinner(
                "getValue");
        } catch (e) {
        }
        try {
            v = $(getEditor(dgId, index, field).target).textbox("getValue");
        } catch (e) {
        }
        try {
            v = $(getEditor(dgId, index, field).target).combobox("getValue");
        } catch (e) {
        }

        return v;
    }

    var now = "<%=DateUtils.now("yyyy-MM")%>";
    $(document).ready(function () {
        var cal = new Calendar(now);
        $("#blbeginTime").datetimebox("setValue", now + "-01 00:00:00");
        var lastDay = Calendar.lastDayOfMonth(cal.format("yyyy"), cal.format("MM"));
        $("#blendTime").datetimebox("setValue", now + "-" + lastDay + " 23:59:59");

        $("#lhbeginTime").datetimebox("setValue", now + "-01 00:00:00");
        $("#lhendTime").datetimebox("setValue", now + "-" + lastDay + " 23:59:59");

        $("#beginTime").datetimebox("setValue", now + "-01 00:00:00");
        $("#endTime").datetimebox("setValue", now + "-" + lastDay + " 23:59:59");

        $("#ccbeginTime").datetimebox("setValue", now + "-01 00:00:00");
        $("#ccendTime").datetimebox("setValue", now + "-" + lastDay + " 23:59:59");
    });

    /*---------------------------------  报产固化--------------------------------------------- */
    //报产固化(第一个按钮)
    function report() {
        $("#report_dlg").dialog("open");
    }

    /*---------------------------------  报产上报--------------------------------------------- */
    //报产上报(第二个按钮)
    function reporttosap() {
        var rows = $("#messapproduction_dg").datagrid("getChecked");
        if (rows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var batchidlist = [];

        for (var i = 0; i < rows.length; i++) {
            if (rows[i].record_sap_flag_s == '2') {
                ext.tip.warn(rows[i].batch_id_s + '-----' + "数据已经上报");
                return;
            }
            if (rows[i].product_type_s != '01') {
                ext.tip.warn(rows[i].batch_id_s + '-----' + "数据请选择其他的上报按钮");
                return;
            }else{
                //if(rows[i].solid_flag_s=='0')
                batchidlist.push(rows[i].batch_id_s);
            }

        }
        ext.ajax.post("curing/report/productionSubsidiaryQuery/reporttosapBySelectRow", {batchidlist: batchidlist.toString()}, function (data) {
            if (data.code == OK) {
                ext.tip.suc();
                filter();
                return;
            }
            ext.tip.error(data.message);
        });
    }

    /*---------------------------------  冲产固化--------------------------------------------- */
    //冲产固化(第三个按钮)
    function reflush() {
        $("#reflush_dlg").dialog("open");
    }

    /*---------------------------------  冲产上报--------------------------------------------- */
    //冲产上报(第四个按钮)
    function reflushtosap() {
        var rows = $("#messapproduction_dg").datagrid("getChecked");
        if (rows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var batchidlist = [];

        for (var i = 0; i < rows.length; i++) {
            if (rows[i].record_sap_flag_s == '2') {
                ext.tip.warn(rows[i].batch_id_s + '-----' + "数据已经上报");
                return;
            }
            if (rows[i].product_type_s != '02') {
                ext.tip.warn(rows[i].batch_id_s + '-----' + "数据请选择其他的上报按钮");
                return;
            }else{
                //if(rows[i].solid_flag_s=='0')
                batchidlist.push(rows[i].batch_id_s);
            }
        }
        ext.ajax.post("curing/report/productionSubsidiaryQuery/reflushtosapBySelectRow", {batchidlist: batchidlist.toString()}, function (data) {
            if (data.code == OK) {
                ext.tip.suc();
                filter();
                return;
            }
            ext.tip.error(data.message);
        });
    }
      /*---------------------------------  冲产上报之后将返回成功的数据从生产实绩表变成未固化--------------------------------------------- */
    //冲产上报(第七个按钮)
    function repeattosap() {
        var rows = $("#messapproduction_dg").datagrid("getChecked");
        if (rows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        var batchidlist = [];

        for (var i = 0; i < rows.length; i++) {
            if (rows[i].record_sap_flag_s != '2') {
                ext.tip.warn(rows[i].batch_id_s + '-----' + "数据上报返回状态不是成功");
                return;
            }
            if (rows[i].spare5_s == '1') {
                ext.tip.warn(rows[i].batch_id_s + '-----' + "报产数据已添加");
                return;
            }
            if (rows[i].product_type_s != '02') {
                ext.tip.warn(rows[i].batch_id_s + '-----' + "数据请选择其他的上报按钮");
                return;
            }else{
                //if(rows[i].solid_flag_s=='0')
                batchidlist.push(rows[i].batch_id_s);
            }
        }
        ext.ajax.post("curing/report/productionSubsidiaryQuery/repeattosapBySelectRow", {batchidlist: batchidlist.toString()}, function (data) {
            if (data.code == OK) {
                ext.tip.suc();
                filter();
                return;
            }
            ext.tip.error(data.message);
        });
    }
    // /*---------------------------------  异常固化--------------------------------------------- */
    // //异常固化(第七个按钮)
    // function abnormal() {
    //     $("#abnormal_dlg").dialog("open");
    // }
    //
    // /*---------------------------------  异常上报--------------------------------------------- */
    // //异常上报(第八个按钮)
    // function abnormaltosap() {
    //     var rows = $("#messapproduction_dg").datagrid("getChecked");
    //     if (rows.length == 0) {
    //         ext.tip.warn(tipSelectAtLeastOne);
    //         return;
    //     }
    //     var batchidlist = [];
    //
    //     for (var i = 0; i < rows.length; i++) {
    //         if (rows[i].record_sap_flag_s == '2') {
    //             ext.tip.warn(rows[i].batch_id_s + '-----' + "数据已经上报");
    //             return;
    //         }
    //         if (rows[i].product_type_s != '03') {
    //             ext.tip.warn(rows[i].batch_id_s + '-----' + "数据请选择其他的上报按钮");
    //             return;
    //         }else{
    //             //if(rows[i].solid_flag_s=='0')
    //             batchidlist.push(rows[i].batch_id_s);
    //         }
    //     }
    //     ext.ajax.post("curing/report/productionSubsidiaryQuery/abnormaltosapBySelectRow", {batchidlist: batchidlist.toString()}, function (data) {
    //         if (data.code == OK) {
    //             ext.tip.suc();
    //             filter();
    //             return;
    //         }
    //         ext.tip.error(data.message);
    //     });
    // }
    /*---------------------------------  报产/冲产明细 --------------------------------------------- */
    //明细按钮(第五个按钮)
    function productionDetail() {
        var selectrows = $("#messapproduction_dg").datagrid("getChecked");

        if (selectrows.length == 0) {
            ext.tip.warn(tipSelectAtLeastOne);
            return;
        }
        if (selectrows.length > 1) {
            ext.tip.error("<spring:message code="tip.OneSelectedToDetail" />");
            return;
        }
        //弹出明细窗口
        $("#workorderresult_detail_dg").dialog("open");
        ext.ajax.sendJson("curing/report/productionSubsidiaryQuery/productionDetail2", {
            selectedrows: selectrows
        }, function (data) {
            $('#detail_dg').datagrid('loadData', data);
        });
    }

    /*---------------------------------  版本变更--------------------------------------------- */
    var indexes = {};

    function onVersionDgBeforeLoad(param) {
        if (param) {
            param["filter[RECORD_SAP_FLAG_S]"] = 3;//此处3为SAP返回错误信息，才会查询出数据（0：未读取，1：正常，3：错误）
            param["filter[process_s]"] = 252006;
        }
    }

    function version() {
        $("#version_dlg").dialog("open");
        $("#messapproduction_dg2").datagrid("reload");
    }

    /**
     * 查询方法，版本变更(第六个按钮)
     */
    var version_filter = function () {
        ext.easyui.grid.search("messapproduction_dg2",
            "MesSapProduction_search_form2");
        indexes = {};
    };

    /**
     * 修改版本，版本变更(第六个按钮)
     */
    function editVersion() {
        var rows = $("#messapproduction_dg2").datagrid("getSelections");
        if (rows.length == 0) {
            return;
        }

        for (var i = 0; i < rows.length; i++) {
            var index = $("#messapproduction_dg2").datagrid("getRowIndex",
                rows[i]);
            indexes[index] = index;
            $("#messapproduction_dg2").datagrid("beginEdit", index);
        }
    }

    function onComboboxBeforeLoad2(param) {
        var index = $(this).parents("[datagrid-row-index]").attr(
            "datagrid-row-index");
        var mtCode = getFieldValue("messapproduction_dg2", index,
            "material_code_s");
        param["materialCode"] = mtCode;
    }

    /**
     * 保存，版本变更(第六个按钮)
     */
    function saveVersion() {

        if (JSON.stringify(indexes) == "{}") {
            return;
        }

        var data = [];

        for (var index in indexes) {
            if (getFieldValue("messapproduction_dg2", index, "pro_version_s_new") === '') {
                ext.tip.error('修改版本不可为空');
                return;
            }
            if ( typeof(getFieldValue("messapproduction_dg2", index, "pro_version_s_new")) == "undefined" ) {
                ext.tip.error('修改版本有误');
                return;
            }
            data.push({
                atr_key: getFieldValue("messapproduction_dg2", index,
                    "atr_key"),
                pro_version_s: getFieldValue("messapproduction_dg2", index,
                    "pro_version_s_new")
            });
        }

        ext.ajax.sendJson("curing/mesapproduction/saveVersion", data,
            function (data) {
                if (data.message == '操作成功') {
                    ext.tip.suc("保存成功");
                    version_filter();
                    return;
                }
                ext.tip.error(data.message);
            });
    }

    /**
     * 取消，版本变更(第六个按钮)
     */
    function cancel() {
        $("#messapproduction_dg2").datagrid("rejectChanges");
    }

    function dateFormat(date) {
        return new Calendar(date).format("yyyyMMdd");
    }

    function dateParser(s) {
        if (!s)
            return new Date();
        return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
            .substring(6, 8));
    }
    /**
     * 导出
     */
    function ExcelExport() {
        //获取grid 数据
        //var node = $("#messapproduction_dg").datagrid("getSelections");
        var node ="";
        if (node == "") {
            var param=ext.form.getFormAsJson("MesSapProduction_search_form");
            var param_get="";
            for(var k in param){
                param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
            }
            $.ajax({
                url : "curing/patchmesapproduction/searchBy?s_factory_s="+factory+"&"+param_get,
                type : 'get',
                dataType : 'json',
                async : false,
                success : function(data) {
                    node = data;
                }
            });

        }

        var data = JSON.stringify(node);
        if (data == '')
            return;
        var myDate = new Date();
        var time=myDate.toLocaleString( );
        var title=[{tyre_barcode_s:'轮胎条码'},{equip_code_s:'机台编码'},{material_code_s:'物料编码'},{material_name_s:'物料名称'},{class_id_s:'班次'}
            ,{curing_grade_s:'硫化质量等级'},{product_date_s:'生产日期'},{product_type_s:'报产方式'},{post_date_s:'过账日期'},{serid_s:'报产流水号'}
            ,{batch_id_s:'上传批次号'},{doc_date_s:'凭证日期'},{batch_s:'产品下线批次'},{pro_version_s:'生产版本'}
            ,{solid_flag_s:'固化标识'},{record_sap_flag_s:'上报状态'},{storage_loc_s:'下线库位'},{operate_usernane_s:'上传人'},{operate_time_s:'上传时间'}];
        toExcel("硫化和sap集成报产"+time,data,title);
    }
    //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function() {
        $('#begin_created_time').datetimebox({
            value : '3/4/2010 00:00:00',
            required : true,
            showSeconds : true
        });
        $('#end_created_time').datetimebox({
            value : '3/4/2010 23:59:59',
            required : true,
            showSeconds : true
        });
        filter();
    });
    function classFormatter(v,r,i){
        if(v=='302001')
            return '早班';
        else if(v=='302002')
            return '中班';
        else if(v=='302003')
            return '晚班';
        else
            return '';
    }
    //FileName 生成的Excel文件名称
    function toExcel(FileName, JSONData, ShowLabel) {
        //先转化json
        var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
        var excel = '<table>';
        //设置表头
        var row = "<tr align='left'>";//设置Excel的左居中
        for (var i = 0, l = ShowLabel.length; i < l; i++) {
            for (var key in ShowLabel[i]) {
                row += "<td>" + ShowLabel[i][key] + '</td>';
            }
        }
        //换行
        excel += row + "</tr>";

        //设置数据
        for (var i = 0; i < arrData.length; i++) {
            var rowData = "<tr align='left'>";

            for (var y = 0; y < ShowLabel.length; y++) {
                for(var k in ShowLabel[y]){
                    if (ShowLabel[y].hasOwnProperty(k)) {
                        // if (k="product_type_s"){
                        //     if(arrData[i][k]==="01"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('报产') + "</td>";
                        //     }
                        //     else if(arrData[i][k]==="02"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('冲产') + "</td>";
                        //     }
                        //     else if(arrData[i][k]==="03"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('异常') + "</td>";
                        //     }
                        //     else{
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('') + "</td>";
                        //     }
                        //     //continue;
                        // }
                        // if (k="solid_flag_s"){
                        //     if(arrData[i][k]==="1"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('已固化') + "</td>";
                        //     }
                        //     else if(arrData[i][k]==="0"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('未固化') + "</td>";
                        //     }
                        //     else{
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('') + "</td>";
                        //     }
                        //     //continue;
                        // }
                        // if (k="record_sap_flag_s"){
                        //     if(arrData[i][k]==="0"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('SAP未读取') + "</td>";
                        //     }
                        //     else if(arrData[i][k]==="1"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('已读取') + "</td>";
                        //     }
                        //     else if(arrData[i][k]==="2"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('正常') + "</td>";
                        //     }
                        //     else if(arrData[i][k]==="3"){
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('错误') + "</td>";
                        //     }
                        //     else{
                        //         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('') + "</td>";
                        //     }
                        //     //continue;
                        // }
                        if(k=="class_id_s"){
                            if(arrData[i][k]==="302001"){
                                rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('早班') + "</td>";
                            }
                            else if(arrData[i][k]==="302002"){
                                rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('中班') + "</td>";
                            }
                            else if(arrData[i][k]==="302003"){
                                rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('晚班') + "</td>";
                            }
                            else{
                                rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('') + "</td>";
                            }
                            continue;
                        }
                        rowData += "<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : arrData[i][k]) + "</td>";
                        //vnd.ms-excel.numberformat:@ 输出为文本
                    }
                }
            }
            excel += rowData + "</tr>";
        }
        excel += "</table>";

        var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
        excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
        excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel';
        excelFile += '; charset=UTF-8">';
        excelFile += "<head>";
        excelFile += "<!--[if gte mso 9]>";
        excelFile += "<xml>";
        excelFile += "<x:ExcelWorkbook>";
        excelFile += "<x:ExcelWorksheets>";
        excelFile += "<x:ExcelWorksheet>";
        excelFile += "<x:Name>";
        excelFile += "硫化报产明细";
        excelFile += "</x:Name>";
        excelFile += "<x:WorksheetOptions>";
        excelFile += "<x:DisplayGridlines/>";
        excelFile += "</x:WorksheetOptions>";
        excelFile += "</x:ExcelWorksheet>";
        excelFile += "</x:ExcelWorksheets>";
        excelFile += "</x:ExcelWorkbook>";
        excelFile += "</xml>";
        excelFile += "<![endif]-->";
        excelFile += "</head>";
        excelFile += "<body>";
        excelFile += excel;
        excelFile += "</body>";
        excelFile += "</html>";

        var uri = 'data:application/vnd.ms-excel;charset=utf-8,' + encodeURIComponent(excelFile);
        var link = document.createElement("a");
        link.href = uri;

        link.style = "visibility:hidden";
        link.download = FileName + ".xls";

        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    }
</script>