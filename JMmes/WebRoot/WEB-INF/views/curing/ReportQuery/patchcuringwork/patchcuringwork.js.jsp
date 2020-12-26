<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

   
    function showOrHide(){
        if($("#PatchCuringWork_search_form").is(":hidden")){
            $("#PatchCuringWork_search_form").show();
        }else{
            $("#PatchCuringWork_search_form").hide();
        }
    }
    
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
	
	function classFormatter(v,r,i){
		if(v=='280001')
			return '新增';
		else if(v=='280002')
			return '条码替换';
		else if(v=='280003')
			return '规格更改';
		else if(v=='281001')
			return '正常返修';
		else if(v=='281002')
			return '条码缺失';
		else if(v=='281003')
			return '计划有误';
		else if(v=='281004')
			return '设备故障';
		else if(v=='281005')
			return '系统异常';	
	}
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#patchcuringwork_dg").datagrid("options");
		opts.url = 'curing/report/patchcuringwork/datagridUDA';
        ext.easyui.grid.search("patchcuringwork_dg","PatchCuringWork_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("patchcuringwork_dg",{});
    }

    function edit() {
        var rows = $("#patchcuringwork_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#patchcuringwork_dg").datagrid("getRowIndex", rows[i]);
            $("#patchcuringwork_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#patchcuringwork_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#patchcuringwork_dg").datagrid("getRowIndex", rows[i]);
            $("#patchcuringwork_dg").datagrid("deleteRow", index);
        }

    }

   

    function cancel() {
        $("#patchcuringwork_dg").datagrid("rejectChanges");
    }

    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    /**
     * 查询产线
     */
	function searchProductionLine(q, row) {
		var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}
	//加载产线信息
	var jtxx = [];
	$.ajax({
		url : 'curing/baseData/curingProductionLine/searchDescription',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			jtxx = data;
		}
	});
	
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