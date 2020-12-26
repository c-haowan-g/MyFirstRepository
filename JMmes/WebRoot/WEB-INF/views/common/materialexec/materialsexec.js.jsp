<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/materialexec/materialsexec/saveChanges";
    
    function showOrHide(){
        if($("#MaterialsExec_search_form").is(":hidden")){
            $("#MaterialsExec_search_form").show();
        }else{
            $("#MaterialsExec_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    var value = $('input[name="dummy4_s"]:checked').val();
        var url='common/materialexec/materialsexec/datagrid2';
        //如果是实时的
        if("real_time"==value){
            url='common/materialexec/materialsexec/datagrid2';
            //如果是历史数据
        }else if("his_time"==value){
            url='common/materialexec/materialsexec/datagridhis';
        }

        var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        console.info("starttime"+starttime);
        console.info("endtime"+endtime);
        if(starttime!="" && endtime!=""){
            if(starttime>endtime){
                ext.tip.error("<spring:message code="tip.date" />");
            }else{
                var opts = $("#materialsexec_dg").datagrid("options");
                opts.url = url;
                ext.easyui.grid.search("materialsexec_dg","MaterialsExec_search_form");
            }
        }else{
            var opts = $("#materialsexec_dg").datagrid("options");
            opts.url = url;
            ext.easyui.grid.search("materialsexec_dg","MaterialsExec_search_form");
        }
       // ext.easyui.grid.search("materialsexec_dg","MaterialsExec_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("materialsexec_dg",{});
    }

    function edit() {
        var rows = $("#materialsexec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#materialsexec_dg").datagrid("getRowIndex", rows[i]);
            $("#materialsexec_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#materialsexec_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#materialsexec_dg").datagrid("getRowIndex", rows[i]);
            $("#materialsexec_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#materialsexec_dg");

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
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#materialsexec_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#materialsexec_dg").datagrid("rejectChanges");
    }
 function syncFlag(v,r,i){
        if("A"==r.sync_flag_s){
            return "新增";
        }else if("U"==r.sync_flag_s){
            return "修改";
        }else if("D"==r.sync_flag_s){
            return "删除";
        }else{
            return r.sync_flag_s;
        }
    }

    function syncHandFlag(v,r,i){
        if("0"==r.sync_hand_flag_s){
            return "未处理";
        }else if("1"==r.sync_hand_flag_s){
            return "已处理";
        }else{
            return r.sync_hand_flag_s;
        }
    }

    function codeFormatter(v, r, i) {
        return dictFormat(v);
    }

    function matStatus(v,r,i){
        if("01"==r.matstatus_s){
            return "因采购/仓库二被冻结";
        }else if("02"==r.matstatus_s){
            return "因任务清单/BOM而被冻结";
        }else if("Z1"==r.matstatus_s){
            return "冻结物料，只能库存收发货";
        }else if("Z2"==r.matstatus_s){
            return "冻结物料，不允许所有、作、";
        }else if("Z3"==r.matstatus_s){
            return "冻结物料，只能库存收发货和采购";
        }else{
            return r.matstatus_s;
        }
    }

    function Status(v,r,i){
        if("01"==r.status_s){
            return "因采购/仓库二被冻结";
        }else if("02"==r.status_s){
            return "因任务清单/BOM而被冻结";
        }else if("Z1"==r.status_s){
            return "冻结物料，只能库存收发货";
        }else if("Z2"==r.status_s){
            return "冻结物料，不允许所有、作、";
        }else if("Z3"==r.status_s){
            return "冻结物料，只能库存收发货和采购";
        }else{
            return r.status_s;
        }
    }

    //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
        $('#start_time').datetimebox({
            value: '3/4/2010 00:00:00',
            required: true,
            showSeconds: true
        });
        $('#end_time').datetimebox({
            value: '3/4/2010 23:59:59',
            required: true,
            showSeconds: true
        });
        filter();
    });

</script>