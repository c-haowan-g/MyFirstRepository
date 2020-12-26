<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"material/baseDate/materialinventory/saveChanges";
    
    function showOrHide(){
        if($("#MaterialInventory_search_form").is(":hidden")){
            $("#MaterialInventory_search_form").show();
        }else{
            $("#MaterialInventory_search_form").hide();
        }
    }
    
  /**
     * 查询方法
     */
    var filter=function(){
        var value = $('input[name="spare10_s"]:checked').val();
        //如果是选择入库日期in_time_t
           if("in_time_t"==value){
               $('#in_time_t').datetimebox({
                   value: '3/4/2010 00:00:00',
                   required: true,
                   showSeconds: true
               });
           }
           //如果是选择质检日期product_time
          if("product_time"==value){
               $('#product_time_t').datetimebox({
                   value: '3/4/2010 00:00:00',
                   required: true,
                   showSeconds: true
               });
           } 
        //实时
        var opts = $("#materialinventory_dg").datagrid("options");
		opts.url ='material/baseDate/materialinventory/datagrid'; 
        ext.easyui.grid.search("materialinventory_dg","MaterialInventory_search_form");
       //历史
        var opts1 = $("#materialinventory_dg1").datagrid("options");
        opts1.url = 'material/baseDate/materialinventory/datagridhis'; 
        ext.easyui.grid.search("materialinventory_dg1","MaterialInventory_search_form");
    }
    $(function(){
        $('#expiredDay').textbox('setValue',30);
        $('input:radio[name="spare10_s"]').change(function(){
                var value = $('input[name="spare10_s"]:checked').val();
                //如果是选择生产日期product_time
                    $('#in_time_t').datetimebox({
                        value: null,
                        required: false,
                        showSeconds: true
                    });
                    $('#product_time_t').datetimebox({
                        value: null,
                        required: false,
                        showSeconds: true
                    });
                //如果是选择入库日期in_time
                   if("in_time"==value){
                       $('#in_time_t').datetimebox({
                           value: '3/4/2010 00:00:00',
                           required: true,
                           showSeconds: true
                       });
                   }
                   //如果是选择生产日期product_time
                   if("product_time"==value){
                       $('#product_time_t').datetimebox({
                           value: '3/4/2010 00:00:00',
                           required: true,
                           showSeconds: true
                       });
                   }
            }
        )
        $('input:radio[name="spare11_s"]').change(function(){
            var value = $('input[name="spare11_s"]:checked').val();
            $('#validSign').textbox('setValue',value);
        })



        $("#in_time_t").next().hide();
        $("#product_time_t").next().hide();
        $("#validSign").next().hide();
        $(':radio').click(function () {
            var r = $(this).attr("name");
            $(":radio[name=" + r + "]:not(:checked)").attr("tag", 0);


            if ($(this).attr("tag") == 1) {
                $(this).prop('checked',false);
                $(this).attr("tag", 0);
                if("spare11_s"==r){//如果是过期时间筛选取消
                    $('#validSign').textbox('setValue',"");
                }
                if("spare10_s"==r){//如果是入库检测时间筛选取消
                    radioTime();
                }

            }
            else {
                $(this).attr("tag",1);
            }
        });
    })

    var radioTime = function(){
        $('#in_time_t').datetimebox({
            value: null,
            required: false,
            showSeconds: true
        });
        $('#product_time_t').datetimebox({
            value: null,
            required: false,
            showSeconds: true
        });

    }

    //根据库区筛选出库位
    var getstoreUnit = function() {
        var store_type_s = $("#store_type_s").combobox("getValue");
                $("#store_code_s").combobox(
                        {
                            url : "material/baseDate/materialinventory/getStoreUnit?store_type_s="
                            + store_type_s,
                            method : "post",
                            valueField : 'STORE_CODE_S',
                            textField : 'SPARE4_S',
                            selected : 'selected'
                        });

    };
//    var store_type_s = $("#store_type_s").combobox("getValue");
    var unitlist = [];
 /*   $.ajax({
        url : "material/baseDate/materialinventory/getStoreUnit?store_type_s="
            + store_type_s,
        type : "get",
        dataType : "json",
        async : false,
        success : function(data) {
            unitlist = data;
        }
    });*/

    var spare5 = [];
    $.ajax({
        url : "dict/code/010",
        type : "get",
        dataType : "json",
        async : false,
        success : function(data) {
            spare5 = data;
        }
    });
    function add() {
        ext.easyui.grid.appendAndEdit("materialinventory_dg",{});
    }

    function edit() {
        var rows = $("#materialinventory_dg").datagrid("getSelections");
        if (rows == "") {
            ext.tip.error("至少选择一条数据");
        }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#materialinventory_dg").datagrid("getRowIndex", rows[i]);
            $("#materialinventory_dg").datagrid("beginEdit", index);
        }
    }
    function specialReleaseBefore(sign){
        passOverSign="";
        passOverSign=sign;
        var row = $("#materialinventory_dg").datagrid("getSelections");
        if(row.length==0){
            ext.tip.error("请选择至少一条数据");
            return;
        }
        $("#rea_dlg").dialog("open");
    }
 function specialReleaseAfter(){
        var row = $("#materialinventory_dg").datagrid("getSelections");
        if (row == "") {
            ext.tip.error("至少选择一条数据");
        }
        var form_data = ext.form.getFormAsJson("reason_form");
        var list_map={};
        var lotList= [];
        var storeList=[];
        var stateList=[];
        var reaList=[];
        var finalList=[];
        var signList=[];
        for(var i=0;i<row.length;i++){
            lotList.push(row[i].supplier_lot_no_s);//供应商编码
            storeList.push(row[i].store_code_s);//库位编码
            stateList.push(row[i].state_code_s);//状态编码
            reaList.push(row[i].reas_code_s);//放行原因
            finalList.push($("#spare7_s").val());//备注
            signList.push(passOverSign);
        }
        var url="material/baseDate/materialinventory/specialRelease";
       /* if("pass"==passOverSign){
            url="material/baseDate/materialinventory/specialRelease";
        }else if("over"==passOverSign){
            url="material/baseDate/materialinventory/specialRelease2";
        }*/

        ext.ajax.post(url, {"lotList":lotList,"storeList":storeList,"stateList":stateList,"reaList":reaList,"finalList":finalList,"sign":signList}, function(data) {
            showConfirm(data.data);
            cancel1();
            $("#user_dg").datagrid("reload");
        }, function(data) {
            ext.tip.error();
        });
    }
    //显示操作结果
    function showConfirm(msg){
        $.messager.confirm({
                width: 700,
                height: 350,
                title: '提示',
                msg: msg,
                fn: function (r) {
                    filter();
                }
            }
        );
    }

    function remove() {

        var rows = $("#materialinventory_dg").datagrid("getSelections");
        var index = -1;
        if (rows == "") {
            ext.tip.error("请选择要清除的数据！");
        }else{
            $.messager.confirm('清除确认', '确认清除?', function(r){
                if (r){
                    for (var i = 0; i < rows.length; i++) {
                        index = $("#materialinventory_dg").datagrid("getRowIndex", rows[i]);
                        $("#materialinventory_dg").datagrid("deleteRow", index);
                    }
                    //删除后保存
                    save();
                }
            });

        }
     /*   for (var i = 0; i < rows.length; i++) {
            index = $("#materialinventory_dg").datagrid("getRowIndex", rows[i]);
            $("#materialinventory_dg").datagrid("deleteRow", index);
        }*/
    }
   function save() {
        var dg = $("#materialinventory_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
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
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("操作失败");
                return;
            }
            $("#materialinventory_dg").datagrid("reload");
            ext.tip.suc("操作成功")

        });
    }

    function cancel() {
        $("#materialinventory_dg").datagrid("rejectChanges");
    }

    function cancel1() {
        $("#rea_dlg").dialog("close");
    }

    var materialType=[];
    $.ajax({
        url:"dict/code/-304",
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
    }



    var storeType=[];
    $.ajax({
        url:"dict/code/005",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            storeType=data;
        }
    });

    function storeTypeFormatter(v,r,i){
        for(var i=0;i<storeType.length;i++){
            if(v==storeType[i].code){
                return storeType[i].text;
            }
        }
    }

    var stateCode=[];
    $.ajax({
        url:"dict/code/001",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            stateCode=data;
        }
    });

    function spare5Formatter(v,r,i){
        if("010001"==r.spare5_s){
            return "待发料";
        }
        if("010002"==r.spare5_s){
            return "发料中";
        }
        if("010003"==r.spare5_s){
            return "发料完成";
        }
    }
    function spare6Formatter(v,r,i){
        if("0"==r.spare6_s){
            return "无DQW检测项";
        }else if("1"==r.spare6_s){
            return "合格";
        }else if("2"==r.spare6_s){
            return "不合格";
        }else{
            return r.spare6_s;
        }
    }

    function stateCodeFormatter(v,r,i){
        for(var i=0;i<stateCode.length;i++){
            if(v==stateCode[i].code){
                return stateCode[i].text;
            }
        }
    }

       $(document).ready(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		filter();
	});

    function codeFormatter(v, r, i) {
        if(v==null){
            return "";
        }
        return dictFormat(v);
    }

    function isTestmat(v,r,i){
        if("0"==r.testmat_flag_s){
            return "否";
        }else if("1"==r.testmat_flag_s){
            return "是";
        }else{
            return "";
        }
    }

    function isPrioritymat(v,r,i){
        if("0"==r.prioritymat_flag_s){
            return "否";
        }else if("1"==r.prioritymat_flag_s){
            return "是";
        }else{
            return "";
        }
    }

    function selfFlag(v,r,i){
        if("0"==r.self_flag_s){
            return "合格";
        }else if("1"==r.self_flag_s){
            return "不合格";
        }else{
            return "";
        }
    }

    function outofdateflag(v,r,i){
        if("0"==r.outofdateflag_s){
            return "正常状态";
        }else if("1"==r.outofdateflag_s){
            return "超期";
        }else{
            return "";
        }
    }

    function warehouseMode(v,r,i){
        if("1"==r.warehouse_mode_s){
            return "指定供应商原料批次";
        }else if("2"==r.warehouse_mode_s){
            return "指定托盘出库";
        }else if("3"==r.warehouse_mode_s){
            return "指定物料编码";
        }else if("4"==r.warehouse_mode_s){
            return "指定供应商编码、物料编码";
        }
    }

    $("#mutex").onclick(
        function(){
            alter.info("shit!");

        }
    )

    
</script>