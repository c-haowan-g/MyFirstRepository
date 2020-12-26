<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/ReportQuery/maintaindetail/saveChanges";
    
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
    
    function showOrHide(){
        if($("#Maintaindetail_search_form").is(":hidden")){
            $("#Maintaindetail_search_form").show();
        }else{
            $("#Maintaindetail_search_form").hide();
        }
    }
    
    function abc(){
    	alert(a);
    	//$("#lh_qx").window('open');
    }
    
    
    /**
     * 查询方法
     */
    var filter = function(){
        var opts = $("#maintaindetail_dg").datagrid("options");
		opts.url = 'curing/ReportQuery/maintaindetail/datagrid';
        ext.easyui.grid.search("maintaindetail_dg","Maintaindetail_search_form");
    };
    
    function add() {
        ext.easyui.grid.appendAndEdit("maintaindetail_dg",{});
    }

    function edit() {
        var rows = $("#maintaindetail_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
        	debugger;
            index = $("#maintaindetail_dg").datagrid("getRowIndex", rows[i]);
            $("#maintaindetail_dg").datagrid("beginEdit", index);
        }
        $("#lh_qx").window('open');
    }

    function remove() {

        var rows = $("#maintaindetail_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#maintaindetail_dg").datagrid("getRowIndex", rows[i]);
            $("#maintaindetail_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#maintaindetail_dg");
		debugger;
        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }
        }

        var updated = dg.datagrid("getChanges", "updated");

        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        var row = $("#maintaindetail_dg").datagrid("getSelections");
        var list_map={};
        list_map.atr_key=rows[0].atr_key;
        list_map.repick_reason_s=rows[0].repick_reason_s;
        list_map.repick_method_s=rows[0].repick_method_s;
        list_map.repick_position_s=rows[0].repick_position_s;
        list_map.part_info_s=rows[0].part_info_s;
        $.ajax({
  	 		url:'curing/ReportQuery/maintaindetail/updateDate',
  	 		type:"post",
  	 		dataType:"json",
  			contentType:'application/json',
  	 		async:false,
  	 		data:JSON.stringify(list_map),
  	 		success:function(data){
  	 			if(data.code==OK){
  	    			ext.tip.suc();
  	    			filter();
  	    			return;
  	    		}
  	    		ext.tip.error(data.message);
  	 		}
  		 });
        /* ext.ajax.sendJson(saveChanges, {
            updated : updated
        }, function(data) {
            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#maintaindetail_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        }); */
    }

    function cancel() {
        $("#maintaindetail_dg").datagrid("rejectChanges");
    }
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    
    function resultFormatter(v,r,i){
    	if(v==0||v==null)
    		return "未完成";
    	else if(v==1)
    		return "已完成";
    	else if(v==2)
    		return "已确认";
    }

    function statusFormatter(v,r,i){
    	if(v==0)
    		return "呼叫中";
    	else if(v==1)
    		return "维修中";
    	else if(v==2)
    		return "维修完成";
    }
    
    function workFormatter(v,r,i){
    	if(v=="C")
    		return "硫化车间";
    	else if(v!=null)
    		return v;
    	else 
    		return "";
    }
    
	function timeFormatter(v,r,i){
		debugger;
		if(r.end_time_s==null){
			return 0;
		}
		if(r.created_time_t==null){
			return 0;
		}
		var end_time_s = new Date(r.end_time_s).getTime();
		var time = new Date(r.created_time_t).getTime();
		
		var m=parseInt(Math.abs(time-end_time_s)/1000/60);
		return m;
	}
	
	function createFormatter(v,r,i){
		debugger;
		if(r.begin_time_s==null){
			return 0;
		}
		if(r.end_time_s==null){
			return 0;
		}
		var end_time_s = new Date(r.begin_time_s).getTime();
		var time = new Date(r.end_time_s).getTime();
		
		var m=parseInt(Math.abs(time-end_time_s)/1000/60);
		return m;
	}
  	
</script>