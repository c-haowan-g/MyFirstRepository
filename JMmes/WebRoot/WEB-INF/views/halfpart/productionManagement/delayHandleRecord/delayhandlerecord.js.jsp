<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/baseData/delayHandleRecord/saveChanges";
    //设定时间初始值从当前时间00:00:00至23:59:59
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
    function showOrHide(){
        if($("#DelayHandleRecord_search_form").is(":hidden")){
            $("#DelayHandleRecord_search_form").show();
        }else{
            $("#DelayHandleRecord_search_form").hide();
        }
    }
     /* 获取参数类型 */
     var basetypesList=[];
   	$.ajax({
	        url:'halfpart/baseData/delayHandleRecord/searchUsercode',
	        type:'get',
	        dataType:'json',
	        async:false,
	        success:function(data){
	        	basetypesList=data;
	        }});
	   /**
    * 参数显示显示转化
    * ldx
    */
    function operatorFormatter(v, r, i){
         for(var i=0;i<basetypesList.length;i++){
            if (v == basetypesList[i].USERCODE) {
                return basetypesList[i].USERNAME;
            }
          }
    } 
    
    /**
     * 查询方法
     */
    var filter=function(){
        var opts = $("#delayhandlerecord_dg").datagrid("options");
		opts.url ='halfpart/baseData/delayHandleRecord/datagrid';
        ext.easyui.grid.search("delayhandlerecord_dg","DelayHandleRecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("delayhandlerecord_dg",{});
    }

    function edit() {
        var rows = $("#delayhandlerecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#delayhandlerecord_dg").datagrid("getRowIndex", rows[i]);
            $("#delayhandlerecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#delayhandlerecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#delayhandlerecord_dg").datagrid("getRowIndex", rows[i]);
            $("#delayhandlerecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#delayhandlerecord_dg");

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
            $("#delayhandlerecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#delayhandlerecord_dg").datagrid("rejectChanges");
    }


</script>