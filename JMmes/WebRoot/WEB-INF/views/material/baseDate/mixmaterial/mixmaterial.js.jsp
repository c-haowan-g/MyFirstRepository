<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"material/baseDate/mixmaterial/mixmaterial/saveChanges";
    
    function showOrHide(){
        if($("#MixMaterial_search_form").is(":hidden")){
            $("#MixMaterial_search_form").show();
        }else{
            $("#MixMaterial_search_form").hide();
        }
    }
     /*    var materialType=[];
     $.ajax({
     url:"dict/code/055",
     type:"get",
     dataType:"json",
     async:false,
     success:function(data){
     materialType=data;
     }
     });
     function materialTypeFormatter(v,r,i){
     for(var i=0;i<materialType.length;i++){
     if(v==materialType[i].code){
     return materialType[i].text;
     }
     }
     }*/
    //显示操作结果
    function showConfirm(msg){
        $.messager.confirm({
                width: 700,
                height: 350,
                title: '操作结果',
                msg: msg,
                fn: function (r) {
                    filter();
                }
            }
        );
    }


    /**
     * 获得物料信息
     * 兰颖慧
     * 2019-06-03
     */
    var materialInfo = [];
    $.ajax({
        url: "sap/materials/halbMaterialList",
        type: "get",
        dataType: "json",
        async: false,
        success: function (data) {
            materialInfo = data;
        }
    });

    function materialStatusFormatter(v, r, i) {
        if (v == '01' || v == 01 || v == "01") {
            return "因采购/仓库二被冻结 ";
        } else if (v == '02' || v == 02) {
            return "因任务清单/BOM而被冻结";
        } else if (v == 'Z1') {
            return "冻结物料，只能库存收发货";
        } else if (v == 'Z2') {
            return "冻结物料，不允许所有操作";
        } else if (v == 'Z3') {
            return "冻结物料，只能库存收发货和采购";
        } else {
            return "";
        }
    }

    //允许误差
   /*  function errorAllow(v, r, i) {
        if (v != null && v.substr(0, 1) == ".") {
            v = "0" + v;
            return v;
        } else {
            return v;
        }
    } */
    //数据类型来源
    function dataSourceInfo(v, r, i) {
        if (v == 1) {
            return "配料系统配方";
        } else if (v == 0) {
            return "上辅机配方";
        } else {
            return v;
        }
    }

    function getDg(){
        return $("#mixmaterial_dg");
    }

    //获取选择行数据
    function getMixmaterialList(){
        var rows=getDg().datagrid("getChecked");
        if(rows.length==0){
            ext.tip.warn("请勾选显示区的复选框");
            return;
        }
        var mixmaterialList=[];

        for(var i=0;i<rows.length;i++){
            mixmaterialList.push(rows[i].materialcode_s);
        }
        return mixmaterialList;
    }

    //下发
    function downward() {
        if(getMixmaterialList()==""||getMixmaterialList()==null){
            return;
        }
        ext.ajax.post("matreial/baseDate/mixmaterial/mixmaterial/downward",{mixmaterialList:getMixmaterialList().toString()},function(data){
            if(data.code==OK){
                showConfirm(data.data);
                return;
            }
            ext.tip.error(data.message);
        });
    }

    function isNotFormatter(v, r, i) {
        if (v == 0) {
            return "否";
        } else if (v == 1) {
            return "是";
        } else {
            return "";
        }
    }
    function dataSourceFormatter(v, r, i) {
        if (v == 0) {
            return "PLM原数据";
        } else if (v == 1) {
            return "自动生成";
        } else if (v == 2) {
            return "SAP原数据";
        } else {
            return "";
        }
    }
    /* function dataSourceTypeFormatter(v, r, i) {
        if (v == 0) {
            return "上辅机配方 ";
        } else if (v == 1) {
            return "配料系统配方";
        } else {
            return "";
        }
    } */
    /* function errorAllowFormatter(v, r, i) {
        if (v == 0) {
            return "上辅机配方 ";
        } else if (v == 1) {
            return "配料系统配方";
        } else {
            return "";
        }
    } */
    function agencNoFormatter(v, r, i) {
        if (v == 8000) {
            return "招远";
        } else if (v == 8002) {
            return "德州";
        } else if (v == 8003) {
            return "柳州";
        } else if (v == 8004) {
            return "泰国";
        } else {
            return "";
        }
    }
    /* $(function(){
        $('input:checkbox[name="inMaterial"]').change(function(){
            var value = $('input[name="inMaterial"]:checked').val();
            console.info("在里面");
            console.info(value);
        });
    }); */
    
    /**
     * 查询方法
     */
    var filter = function () {
         ext.easyui.grid.search("mixmaterial_dg","MixMaterial_search_form");
    }

    function add() {
        ext.easyui.grid.appendAndEdit("mixmaterial_dg", {});
    }

    function edit() {
        var rows = $("#mixmaterial_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixmaterial_dg").datagrid("getRowIndex", rows[i]);
            $("#mixmaterial_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixmaterial_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixmaterial_dg").datagrid("getRowIndex", rows[i]);
            $("#mixmaterial_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixmaterial_dg");

        var rows = dg.datagrid("getRows");
        if (null != rows.length && 0 != rows.length) {
            var i = 0;
            for (i = 0; i < rows.length; i++) {
                console.info(rows[i].sip_i);
                if (null != rows[i].sip_i && "" != rows[i].sip_i) {
                    if (rows[i].sip_i > 100 || rows[i].sip_i < 0) {
                        ext.tip.error("密炼快检百分比填写有误");
                        return;
                    }
                }
            }
        }


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
        if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			//$("#mixmaterial_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />")
		}else{
        ext.ajax.sendJson(saveChanges, {
            inserted: inserted,
            updated: updated,
            deleted: deleted
        }, function (data) {

            /* if (null != data.message && data.message != "") {
                var message = data.message;
                ext.tip.error(message);
                return;
            } */


            if (data.code != OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                 $("#mixmaterial_dg").datagrid("reload");
                return;
            }
            $("#mixmaterial_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
        }
    }

    function cancel() {
        $("#mixmaterial_dg").datagrid("rejectChanges");
    }

    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    function sipDisplay(v, r, i) {
        if (null != r.sip_i && "" != r.sip_i) {
            return r.sip_i + "%";
        } else {
            return "";
        }
    }

    function isHeatFormatter(v, r, i) {
        if ("0" == r.isheat_s) {
            return "否";
        } else if ("1" == r.isheat_s) {
            return "是";
        } else {
            return r.isheat_s;
        }
    }

    function sendStateFormatter(v,r,i){
        if(0==r.send_state_s){
            return "未下发";
        }else if(1==r.send_state_s){
            return "已下发";
        }else if(2==r.send_state_s){
            return "下发失败";
        }else{
            return r.send_state_s;
        }
    }

    function overDueControlFormatter(v,r,i){
        if ("0" == r.overduecontrol_s) {
            return "否";
        } else if ("1" == r.overduecontrol_s) {
            return "是";
        } else {
            return r.overduecontrol_s;
        }
    }
    function getEditor(index,field){
        return $("#mixmaterial_dg").datagrid("getEditor",{index:index,field:field});
    };

    function onOverduecontrol(value){
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        var val = $(this).parents("[datagrid-row]").val();
        console.info(value);
        var smalltime_f = $(getEditor(index, "smalltime_f").target).textbox('getValue');
        var overtime_f = $(getEditor(index, "overtime_f").target).textbox('getValue');
        var alarmvalue_f = $(getEditor(index, "alarmvalue_f").target).textbox('getValue');
        var minimumstock_f = $(getEditor(index, "minimumstock_f").target).textbox('getValue');
        var maximumstock_f = $(getEditor(index, "maximumstock_f").target).textbox('getValue');
        var maxheattime_f = $(getEditor(index, "maxheattime_f").target).textbox('getValue');
        var minheattime_f= $(getEditor(index, "minheattime_f").target).textbox('getValue');
        var sip_i = $(getEditor(index, "sip_i").target).textbox('getValue');
        if(""==sip_i){
            $(getEditor(index, "sip_i").target).textbox('setValue',0);
        }
        if(""==smalltime_f){
            $(getEditor(index, "smalltime_f").target).textbox('setValue',0);
        }
        if(""==smalltime_f){
            $(getEditor(index, "smalltime_f").target).textbox('setValue',0);
        }
        if(""==overtime_f){
            $(getEditor(index, "overtime_f").target).textbox('setValue',0);
        }
        if(""==alarmvalue_f){
            $(getEditor(index, "alarmvalue_f").target).textbox('setValue',0);
        }
        if(""==minimumstock_f){
            $(getEditor(index, "minimumstock_f").target).textbox('setValue',0);
        }
        if(""==maximumstock_f){
            $(getEditor(index, "maximumstock_f").target).textbox('setValue',0);
        }
        if(""==maxheattime_f){
            $(getEditor(index, "maxheattime_f").target).textbox('setValue',0);
        }
        if(""==minheattime_f){
            $(getEditor(index, "minheattime_f").target).textbox('setValue',0);
        }
    }


</script>