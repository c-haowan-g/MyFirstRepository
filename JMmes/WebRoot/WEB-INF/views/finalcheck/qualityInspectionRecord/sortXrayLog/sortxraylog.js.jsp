<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function showOrHide(){
        if($("#SortXRaylog_search_form").is(":hidden")){
            $("#SortXRaylog_search_form").show();
        }else{
            $("#SortXRaylog_search_form").hide();
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
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#sortxraylog_dg").datagrid("options");
		opts.url = 'finalcheck/qualitylnspectionRecord/sortXrayLog/searchBy';
        ext.easyui.grid.search("sortxraylog_dg","SortXRaylog_search_form");
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

    
    function etypeFormatter(v,r,i){
		if(v=='259001')
			return '轮胎条码';
		else if(v=='259002')
			return '机台信息不存在';
		else if(v=='259003')
			return '规格索引不存在';
		else if(v=='259004')
			return '轮胎状态不允许分配';
		else if(v=='259005')
			return '轮胎规格规则未维护';
		else if(v=='259006')
			return '滑道异常';
		else if(v=='259007')
			return '机台停止';
		else if(v=='259008')
			return '扫描头未读取到条码';
		else if(v=='259009')
			return '轮胎状态不允许检测';
		else if(v=='259010')
			return '其它';
		else 
			return '';
	}
    
    function isokFormatter(v,r,i){
		if(v=='0')
			return '失败';
		else if(v=='1')
			return '成功';
		else 
			return '';
	}
    
    function writeinFormatter(v,r,i){
		if(v=='0')
			return '失败';
		else if(v=='1')
			return '成功';
		else 
			return '';
	}
  
    function recordFormatter(v,r,i){
		if(v=='A')
			return '可用';
		else if(v=='D')
			return '删除';
		else 
			return '';
	}
    function codeFormatter(v, r, i) {

   		return dictFormat(v);
   		
   	}
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
</script>