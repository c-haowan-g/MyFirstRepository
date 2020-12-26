<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#curingmonthplanlog_dg").datagrid("options");
		opts.url='common/interfacelog/curingmonthplan/searchBy'; 
    	ext.easyui.grid.search("curingmonthplanlog_dg","CuringMonthPlanLog_search_form"); 
    }
    
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    
    //设定时间初始值从当前时间00:00:00至23:59:59
    $(function(){
    	$("#start_time").datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	$("#end_time").datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    	filter();
    });
    function formatter_factory(v, r, i){
    	if (v==1){
    		return "全钢";
    	}
    	else if (v==2){
    		return "半钢";
    	}
    }
    function formatter_recordflag(v, r, i){
    	if (v=="A"){
    		return "可用";
    	}
    	else if (v=="D"){
    		return "删除";
    	}
    }
    function formatter_change(v, r, i) {
    	if (v==0){
    		return "未处理";
    	}
    	else if (v==1){
    		return "已处理";
    	}
    	
     }  
 
	function formatter_changee(v, r, i) {
		if (v == "A") {
			return "新增";
		} else if (v == "U") {
			return "修改";
		} else if (v == "D") {
			return "删除";
		}
	}
	function formatter_firstflag(v, r, i){
		if (v==0){
    		return "否";
    	}
    	else if (v==1){
    		return "是";
    	}
	}
	function formatter_update_flag(v, r, i){
		if (v==0){
    		return "未更新";
    	}
    	else if (v==1){
    		return "已更新";
    	}
	}
</script>