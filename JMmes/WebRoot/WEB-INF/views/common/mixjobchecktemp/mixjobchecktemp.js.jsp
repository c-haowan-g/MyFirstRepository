<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"common/MixJobCheckTemp/saveChanges";
    
    function showOrHide(){
        if($("#MixJobCheckTemp_search_form").is(":hidden")){
            $("#MixJobCheckTemp_search_form").show();
        }else{
            $("#MixJobCheckTemp_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    var opts = $("#mixjobchecktemp_dg").datagrid("options");
        opts.url = 'common/MixJobCheckTemp/datagridUDA';
        ext.easyui.grid.search("mixjobchecktemp_dg","MixJobCheckTemp_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixjobchecktemp_dg",{});
    }

    function edit() {
        var rows = $("#mixjobchecktemp_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixjobchecktemp_dg").datagrid("getRowIndex", rows[i]);
            $("#mixjobchecktemp_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixjobchecktemp_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixjobchecktemp_dg").datagrid("getRowIndex", rows[i]);
            $("#mixjobchecktemp_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixjobchecktemp_dg");

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
            $("#mixjobchecktemp_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixjobchecktemp_dg").datagrid("rejectChanges");
    }
 function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    var checkNote=[];
    $.ajax({
        url:"dict/code/079",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            checkNote=data;
        }
    });

    var checkType=[];
    $.ajax({
        url:"dict/code/080",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            checkType=data;
        }
    });

    var checkRate=[];
    $.ajax({
        url:"dict/code/081",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            checkRate=data;
        }
    });

    var checkName=[];
    $.ajax({
        url:"dict/code/082",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            checkName=data;
        }
    });

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

    function getEditor(index,field){
        return $("#mixjobchecktemp_dg").datagrid("getEditor",{index:index,field:field});
    };
    var checkItemCodes=[];
    function oncheckType(value){
        //value.check_type_s
        var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        //     $(getEditor(index, "check_itemcode_s").target).textbox('setValue',value.code);
        // var allContext = $("#mixjobchecktemp_dg").datagrid("getRows");
            purl='common/MixJobCheckTemp/getMaxCode?check_note_s='+value.code;
            if(""!=value.code){
                $.ajax({
                    url:purl,
                    type:"get",
                    dataType:"json",
                    async:false,
                    success:function(data){
                        if(null!=data&&(0!=data.length)){
                            var check_itemcode_s = data[0].CHECK_ITEMCODE_S;
                            check_itemcode_s= parseInt(check_itemcode_s)+1;
                            check_itemcode_s="0"+check_itemcode_s;
                            $(getEditor(index, "check_itemcode_s").target).textbox('setValue',check_itemcode_s);
                        }else{
                            $(getEditor(index, "check_itemcode_s").target).textbox('setValue',value.code+"001");
                        }
                        // $(getEditor(index, "recipe_name_carwash_s").target).combobox('loadData',data);
                    }
                });
            }
    }

</script>