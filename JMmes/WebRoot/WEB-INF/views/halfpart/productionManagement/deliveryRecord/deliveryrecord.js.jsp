<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/deliveryRecord/saveChanges";
    
    function showOrHide(){
        if($("#DeliveryRecord_search_form").is(":hidden")){
            $("#DeliveryRecord_search_form").show();
        }else{
            $("#DeliveryRecord_search_form").hide();
        }
    }
    
    var productLineList=[];
    $.ajax({
        url:"halfpart/basedata/productlinemanager/getHalfPartProductionLine",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	productLineList=data;
        }
    });
    
    function onchangebatchcode (newValue, oldValue) {	
    	//获取选中的值
       	var batchcode = newValue;
       	if(batchcode == null || batchcode == ''){
       		$('#start_time').datetimebox('setValue',null);
       		$('#start_time').datetimebox({disabled:false});
       		$('#end_time').datetimebox('setValue',null);
       		$('#end_time').datetimebox({disabled:false});
       	}else{
       		$('#start_time').datetimebox({disabled:true});
       		$('#end_time').datetimebox({disabled:true});
       	}
     } 
    
    /**
	 * 接收combtree数据
	 */
  	var DICT_118=[];
	$.ajax({
		url:"dict/code/118",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_118=data;
		}
	});
    
    //设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
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
		var opts = $("#deliveryrecord_dg").datagrid("options");
		opts.url ='halfpart/deliveryRecord/datagrid';
    	ext.easyui.grid.search("deliveryrecord_dg","DeliveryRecord_search_form");
		
	});
    
    //隐藏显示查询栏
    function queryBar(){
    	$("#DeliveryRecord_search_form").toggle(500);
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
   		var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			$("#deliveryrecord_dg").datagrid("options").url="halfpart/deliveryRecord/datagrid";
    			   ext.easyui.grid.search("deliveryrecord_dg","DeliveryRecord_search_form");
    		}
    	}else{
    		$("#deliveryrecord_dg").datagrid("options").url="halfpart/deliveryRecord/datagrid";
    		   ext.easyui.grid.search("deliveryrecord_dg","DeliveryRecord_search_form");
    	}
        
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("deliveryrecord_dg",{});
    }

    function edit() {
        var rows = $("#deliveryrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#deliveryrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#deliveryrecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#deliveryrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#deliveryrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#deliveryrecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#deliveryrecord_dg");

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
            $("#deliveryrecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#deliveryrecord_dg").datagrid("rejectChanges");
    }


</script>