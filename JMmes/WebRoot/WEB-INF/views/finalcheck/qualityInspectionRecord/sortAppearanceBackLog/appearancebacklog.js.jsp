<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

function codeFormatter(v, r, i) {

	return dictFormat(v);
	
}

function IsokFormatter(v){
	if(v==1){
		return "成功";
	}else if(v==0){
		return "失败";
	}else{
		return v;
	}
}
function WriteinFormatter(v){
	if(v==0){
		return "成功";
	}else if(v==1){
		return "失败";
	}else{
		return v;
	}
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
	filter();
});
/**
 * 接收combtree数据
 */
 var DICT_252=[];
 var DICT_259=[];
 var DICT_260=[];
 var DICT_253=[];
	
	$.ajax({
		url:"dict/code/252",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_252=data;
		}
	});
	
	$.ajax({
		url:"dict/code/259",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_259=data;
		}
	});
	$.ajax({
		url:"dict/code/260",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_260=data;
		}
	});
	$.ajax({
		url:"dict/code/253",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_253=data;
		}
	});

    
    /**
     * 查询方法
     */
    var filter=function(){
		var opts = $("#sortappearancebacklog_dg").datagrid("options");
		opts.url = 'finalcheck/qualitylnspectionRecord/sortAppearanceBackLog/getSortAppearanceBackLog';
        ext.easyui.grid.search("sortappearancebacklog_dg","SortAppearanceBackLog_search_form");
    }
    
    

</script>