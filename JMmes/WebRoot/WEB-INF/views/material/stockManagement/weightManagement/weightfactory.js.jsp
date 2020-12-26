<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"material/stockManagement/weightManagement/saveChanges";
    
    function showOrHide(){
        if($("#WeightFactory_search_form").is(":hidden")){
            $("#WeightFactory_search_form").show();
        }else{
            $("#WeightFactory_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
   var filter=function(){
        var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        console.info("starttime:"+starttime);
        console.info("endtime:"+endtime);
        if(starttime!="" && endtime!=""){
            if(starttime>endtime){
                ext.tip.error("时间段查询，开始时间不能大于结束时间");
            }else{
                var opts = $("#weightfactory_dg").datagrid("options");
                opts.url = 'material/stockManagement/weightManagement/datagrid';
                ext.easyui.grid.search("weightfactory_dg","WeightFactory_search_form");
            }
        }else{
            var opts = $("#weightfactory_dg").datagrid("options");
            opts.url = 'material/stockManagement/weightManagement/datagrid';
            ext.easyui.grid.search("weightfactory_dg","WeightFactory_search_form");
        }
//        ext.easyui.grid.search("weightfactory_dg","WeightFactory_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("weightfactory_dg",{});
    }

    function edit() {
        var rows = $("#weightfactory_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#weightfactory_dg").datagrid("getRowIndex", rows[i]);
            $("#weightfactory_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#weightfactory_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#weightfactory_dg").datagrid("getRowIndex", rows[i]);
            $("#weightfactory_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#weightfactory_dg");

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
            $("#weightfactory_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#weightfactory_dg").datagrid("rejectChanges");
    }
      /**
     *数据字典传值
     *
     */
    function codeFormatter(v, r, i) {
        if(v==null){
            return "";
        }
        return dictFormat(v);
    }

    function isInstore(v,r,i){
        if(0==r.is_instore_s){
            return "否";
        }else if(1==r.is_instore_s){
            return "是";
        }else{
            return "";
        }
    }

    function factoryName(v,r,i){
        if(1==r.s_factory_s){
            return "全钢";
        }else if(2==r.s_factory_s){
            return "半钢";
        }else{
            return "";
        }
    }

    function recordFlag(v,r,i){
        if("A"==r.record_flag_s){
            return "可用";
        }else if("D"==r.record_flag_s){
            return "删除";
        }else{
            return "";
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