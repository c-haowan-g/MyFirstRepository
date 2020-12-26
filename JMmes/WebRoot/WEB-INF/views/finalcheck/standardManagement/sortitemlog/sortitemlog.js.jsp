<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/standardmagement/sortitemlog/saveChanges";
    
    function showOrHide(){
        if($("#SortItemLog_search_form").is(":hidden")){
            $("#SortItemLog_search_form").show();
        }else{
            $("#SortItemLog_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#sortitemlog_dg").datagrid("options");
    	opts.url='finalcheck/standardmagement/sortitemlog/datagrid';
        ext.easyui.grid.search("sortitemlog_dg","SortItemLog_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("sortitemlog_dg",{});
    }

    function edit() {
        var rows = $("#sortitemlog_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#sortitemlog_dg").datagrid("getRowIndex", rows[i]);
            $("#sortitemlog_dg").datagrid("beginEdit", index);
        }
    }

    function recordflagFormatter(v,r,i){
    	if(v=='A')
    		return '可用';
    	else if(v=='D')
    		return '删除';
    	else
    		return '';
    }
    function stationFormatter(v,r,i){
		if(v=='0')
			return '割毛前';
		else if(v=='1')
			return '外观前';
		else if(v=='2')
			return 'X光机';
		else if(v=='3')
			return '动平衡';
		else if(v=='4')
			return '动均前';
		else if(v=='5')
			return '入库前';
		else 
			return '';
	}
    function numFormatter(v,r,i){
    	if(v=='0')
    		return '免检';
    	else if(v=='1')
    		return '全检';
    	else 
    		return v;
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
	function factoryFormatter(v,r,i){
		if(v=='1')
			return '全钢';
		else if(v=='2')
			return '半钢';
		else 
			return '';
	}
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
		//filter();
	});
</script>