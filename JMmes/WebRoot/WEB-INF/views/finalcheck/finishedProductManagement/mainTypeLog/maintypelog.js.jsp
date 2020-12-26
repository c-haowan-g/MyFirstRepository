<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#MainTypeLog_search_form").is(":hidden")){
            $("#MainTypeLog_search_form").show();
        }else{
            $("#MainTypeLog_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#maintypelog_dg").datagrid("options");
    	opts.url ='finalcheck/finishedProductManagement/mainTypeLog/datagrid'
        ext.easyui.grid.search("maintypelog_dg","MainTypeLog_search_form");
    }
    
    function hsitoryfilter(){
    	var opts = $("#maintypelog_dg_history").datagrid("options");
    	opts.url ='finalcheck/finishedProductManagement/mainTypecurLog/datagrid'
        ext.easyui.grid.search("maintypelog_dg_history","MainTypeHistoryLog_search_form");
    }
    
    function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
    function recordflagFormatter(v,r,i){
    	if(v=='A')
    		return '可用';
    	else if(v=='D')
    		return '删除';
    	else
    		return '';
    }
	function buildFormatter(v,r,i){
		if(v=='0')
			return '否';
		else if(v=='1')
			return '是';
		else 
			return '';
	}
	function curingFormatter(v,r,i){
		if(v=='0')
			return '否';
		else if(v=='1')
			return '是';
		else 
			return '';
	}
	function curingtimeFormatter(v,r,i){
		if(v=='1')
			return'延时硫化';
		else 
			return '';
	}
	function isrckFormatter(v,r,i){
		if(v=='0')
			return '未复检';
		else if(v=='1')
			return '已复检过';
		else 
			return '';
	}
	function returnstatusFormatter(v,r,i){
		if(v=='S')
			return '处理成功';
		else if(v=='E')
			return '处理失败';
		else if(v=='U')
			return '处理异常';
		else 
			return '';
	}
	function saletypeFormatter(v,r,i){
		if(v=='0')
			return '内销';
		else if(v=='1')
			return '外销';
		else return '';
	}
	function statecodeFormatter(v,r,i){
		if(v=='0')
			return '待检';
		else if(v=='1')
			return '合格';
		else if(v=='2')
			return '不合格';
		else 
			return '';
	}
	function syncflagFormatter(v,r,i){
		if(v=='0')
			return '未处理';
		else if(v=='1')
			return '已处理';
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
	function trackFormatter(v,r,i){
		if(v=='1')
			return '返修';
		else if(v=='2')
			return '割毛';
		else 
			return v;
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
		$('#begin_created_time_history').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_created_time_history').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		
		filter();
	});
</script>