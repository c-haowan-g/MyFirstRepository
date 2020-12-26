<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/stockingRecord/stockingrecord/stockingrecord/saveChanges";
    var saveChanges=path+"halfpart/ledger/ledger/saveChanges";
    function showOrHide(){
        if($("#Stockingrecord_search_form").is(":hidden")){
            $("#Stockingrecord_search_form").show();
        }else{
            $("#Stockingrecord_search_form").hide();
        }
    }
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
 		return dictFormat(v);
	}
    
	/* $.ajax({
		url:"halfpart/stockingRecord/stockingrecord/stockingrecord", //请求的url地址
		dataType:"json", //返回格式为json
		async:true,//请求是否异步，默认为异步，这也是ajax重要特性
		data:{"id":"value"}, //参数值
		type:"GET", //请求方式
		success:function(req){
		//请求成功时处理
		},
		error:function(){
		//请求出错处理
		}
		}); */
   /*  var 
    $.ajax({
    	url:"",
    	dataType:"json",
    	async:false,
    	 
    	
    	
    	
    });*/
	 // 接收combtree数据
	
	 
	var DICT_308=[];
	
	$.ajax({
		url:"dict/code/308",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_308=data;
		}
	});
    /**
     * 查询方法
     */
    var filter=function(){
    	/* var opts=$("#stockingrecord_dg").datagrid("options");
    	opts.url='halfpart/stockingRecord/stockingrecord/stockingrecord/datagrid'; */
        ext.easyui.grid.search("stockingrecord_dg","Stockingrecord_search_form");
        
        
    	/* var optss=$("#ledger_dg").datagrid("options");
    	optss.url='halfpart/ledger/ledger/datagrid'; */
        ext.easyui.grid.search("ledger_dg","Stockingrecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("stockingrecord_dg",{});
    }

    function edit() {
        var rows = $("#stockingrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#stockingrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#stockingrecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#stockingrecord_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#stockingrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#stockingrecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#stockingrecord_dg");

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
            $("#stockingrecord_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#stockingrecord_dg").datagrid("rejectChanges");
    }

    //盘库来源
    function messagefromFormatter(v,r,i){
    	if(v=='0')
			return '立库';
		else if(v=='1')
			return '人工';
		else if(v=='2')
			return 'MES';
		else
			return '';
    	
    }
    
    
    var filter1=function(){
    	var opts=$("#stockingrecord_d3g").datagrid("options");
    	opts.url='halfpart/stockingRecord/stockingrecord/stockingrecord/datagrid';
        ext.easyui.grid.search("stockingrecord_dg","Stockingrecord_search_form");
        
    }    
    /* var filter2=function(){
        ext.easyui.grid.search("stockingrecord_dg","Stockingrecord_search_form");
    } */
    
    
    $(function(){
 	   productLineload();
    }); 
    
    /* var opts=$("#stockingrecord_dg").datagrid("options");
    	opts.url='halfpart/stockingRecord/stockingrecord/stockingrecord/datagrid';
        ext.easyui.grid.search("stockingrecord_dg","Stockingrecord_search_form"); */
    
    
    
    var  searchStockData=function(){
    	$("#StockingDataClick_dg").dialog("open");
    	/* $('#stockdifferentlist_dg').datagrid({
    		
    		url: 'halfpart/stockingRecord/stockingrecord/stockingrecord/datagridLog',
            fit: true,
            fitColumns: false,
            rownumbers: true,
            singleSelect: false,
            striped: true,
            pagination: true,
            method: 'get',
    		columns:[[
				{
   						field: 'stockno_s',//盘库单号
						title: '<spring:message code="stockingrecord.column.stockno_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '10%'
				},{
   						field: 'tirebarcode_s',//条形码
						title: '<spring:message code="stockdifferentlist.column.tirebarcode_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '10%'
				},{
   						field: 'rfidno_s',//载具条码
						title: '<spring:message code="stockdifferentlist.column.rfidno_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '10%'
				},{
   						field: 'resultflag_s',//  指令执行状态 0未处理 1处理完成 2过期未处理
						title: '<spring:message code="stockdifferentlist.column.resultflag_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '10%'
				},{
   						field: 'instoretype_s',//盘库类型
						title: '<spring:message code="stockdifferentlist.column.instoretype_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '10%'
				},{
   						field: 'materialcode_s',//物料编码
						title: '<spring:message code="stockdifferentlist.column.materialcode_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '10%'
				},{
   						field: 'specification_s',//规格
						title: '<spring:message code="stockdifferentlist.column.specification_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '10%'
				},{
   						field: 'machinno_s',//生产机台
						title: '<spring:message code="stockdifferentlist.column.machinno_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '10%'
				},{
   						field: 'productiondate_t',//生产时间
						title: '<spring:message code="stockdifferentlist.column.productiondate_t" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '15%'
				},{
   						field: 'quantity_s',//生产数量
						title: '<spring:message code="stockdifferentlist.column.quantity_s" />',
					    editor: {type: 'textbox'},
						frozen: true,
						width: '7%'
				},
    		          
    		          ]]
    	}); */
    	 ext.easyui.grid.search("stockdifferentlist_dg","Stockingrecord_search_form");
    }
    function productLineload(){
    	$('#stockdifferentlist_dg').datagrid({});
    	
    }
</script>