<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/basedata/curingmaintype/saveChanges";
    
    function showOrHide(){
        if($("#CuringMainType_search_form").is(":hidden")){
            $("#CuringMainType_search_form").show();
        }else{
            $("#CuringMainType_search_form").hide();
        }
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
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#curingmaintype_dg").datagrid("options");
		opts.url = 'curing/basedata/curingmaintype/datagridUDA';
		ext.easyui.grid.search("curingmaintype_dg","CuringMainType_search_form");
    }
    function add() {
        ext.easyui.grid.appendAndEdit("curingmaintype_dg",{});
    }

    function edit() {
        var rows = $("#curingmaintype_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingmaintype_dg").datagrid("getRowIndex", rows[i]);
            $("#curingmaintype_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#curingmaintype_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingmaintype_dg").datagrid("getRowIndex", rows[i]);
            $("#curingmaintype_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#curingmaintype_dg");

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
            $("#curingmaintype_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#curingmaintype_dg").datagrid("rejectChanges");
    }

	  function curingtotaltime_s(v,r,i){
         if(v==null){
              return "————";        	 
         }else if(v==1){
        	  return "是";  
         }else if(v==0){
        	  return "否";  
         }else{
        	  return v;
         }
    }

    function curingtimeschange(v,r,i){
        if(v==null){
            return "————";
        }else{
            return v;
        }
    }
/**
     * 接收combtree数据
     */
     var DICT_253=[];
     var DICT_252=[];
   
    	$.ajax({
    		url:"dict/code/253",
    		type:"get",
    		dataType:"json",
    		async:false,
    		success:function(data){
    			DICT_253=data;
    		}
    	});
    	$.ajax({
    		url:"dict/code/252",
    		type:"get",
    		dataType:"json",
    		async:false,
    		success:function(data){
    			DICT_252=data;
    		}
    	});
    	
    	function codeFormatter(v, r, i) {
            if(v==null){
                return "————";
            }
    		return dictFormat(v);
    	}

</script>