<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/MoldManagement/moldoutstore/saveChanges";
    
    function showOrHide(){
        if($("#Moldoutstore_search_form").is(":hidden")){
            $("#Moldoutstore_search_form").show();
        }else{
            $("#Moldoutstore_search_form").hide();
        }
    }
    
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    
    /**
     * 接收combtree数据
     */
     var DICT_302=[];
     var DICT_301=[];
     var DICT_220=[];
 	$.ajax({
 		url:"dict/code/301",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_301=data;
 		}
 	});
 	
 	$.ajax({
 		url:"dict/code/302",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_302=data;
 		}
 	});
 	$.ajax({
 		url:"dict/code/220",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_220=data;
 		}
 	});
    
    /**
     * 查询方法
     */
    function filter(){
    	var opts = $("#moldoutstore_dg").datagrid("options");
        opts.url = 'curing/MoldManagement/moldoutstore/datagrid';
        ext.easyui.grid.search("moldoutstore_dg","Moldoutstore_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("moldoutstore_dg",{});
    }

    function edit() {
        var rows = $("#moldoutstore_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#moldoutstore_dg").datagrid("getRowIndex", rows[i]);
            $("#moldoutstore_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#moldoutstore_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#moldoutstore_dg").datagrid("getRowIndex", rows[i]);
            $("#moldoutstore_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#moldoutstore_dg");

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
            $("#moldoutstore_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#moldoutstore_dg").datagrid("rejectChanges");
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

</script>