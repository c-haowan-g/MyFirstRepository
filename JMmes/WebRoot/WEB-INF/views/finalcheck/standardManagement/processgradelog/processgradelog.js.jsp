<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/standardmagement/processgradelog/saveChanges";
    
    function showOrHide(){
        if($("#ProcessGradeLog_search_form").is(":hidden")){
            $("#ProcessGradeLog_search_form").show();
        }else{
            $("#ProcessGradeLog_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#processgradelog_dg").datagrid("options");
    	opts.url='finalcheck/standardmagement/processgradelog/datagrid';
        ext.easyui.grid.search("processgradelog_dg","ProcessGradeLog_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("processgradelog_dg",{});
    }

    function edit() {
        var rows = $("#processgradelog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#processgradelog_dg").datagrid("getRowIndex", rows[i]);
            $("#processgradelog_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#processgradelog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#processgradelog_dg").datagrid("getRowIndex", rows[i]);
            $("#processgradelog_dg").datagrid("deleteRow", index);
        }

    }

    function cancel() {
        $("#processgradelog_dg").datagrid("rejectChanges");
    }
    function agencFormatter(v,r,i){
		if(v=='8002')
			return '德州';
		else if(v=='8003')
			return '柳州';
		else if(v=='8004')
			return '泰国';
		else if(v=='8023')
			return '荆门';
		else 
			return '';
	}
    function recordflagFormatter(v,r,i){
    	if(v=='A')
    		return '可用';
    	else if(v=='D')
    		return '删除';
    	else
    		return '';
    }
    function factoryFormatter(v,r,i){
		if(v=='2')
			return '半钢';
		else if(v=='1')
			return '全钢';
		else return '';
	}
    function syncflagFormatter(v,r,i){
		if(v=='A')
			return '新增';
		else if(v=='U')
			return '修改';
		else if(v=='D')
			return '删除';
		else
			return '';
	}
	function handflagFormatter(v,r,i){
		if(v=='0')
			return '未处理';
		else if(v=='1')
			return '已处理';
		else 
			return '';
	}
	function codeFormatter(v,r,i){
		return dictFormat(v);
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