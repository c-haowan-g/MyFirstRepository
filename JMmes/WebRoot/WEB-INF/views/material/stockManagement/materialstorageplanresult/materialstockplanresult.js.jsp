<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"material/stockMangement/materialstockplanpesult/saveChanges";
    
    function showOrHide(){
        if($("#MaterialStockPlanResult_search_form").is(":hidden")){
            $("#MaterialStockPlanResult_search_form").show();
        }else{
            $("#MaterialStockPlanResult_search_form").hide();
        }
    }
    /**
	 * 日期格式化
	 */
	function dateFormat(date) {
		return new Calendar(date).format("yyyyMMdd");
	}

	/**
	 * 解析指定格式日期
	 */
	function dateParser(s) {
		if (!s)
			return new Date();
		return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
				.substring(6, 8));
	}
	
	var jobnamelist = [];
	var date = new Calendar().format("yyyyMMdd");
	//加载计划名称
	$.ajax({
		url : "material/stockManagement/materialstorageplandata/getJobName?date="
				+date,
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			jobnamelist = data;
		}
	});
	
    
	//显示操作结果
	function showConfirm(msg){
		   $.messager.confirm({
			    width: 700,
			    height: 350,
			    title: '提示',
			    msg: msg,
			    fn: function (r) {
			        }
			    }
			);
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("materialstockplanresult_dg","MaterialStockPlanResult_search_form");
    }
    	//推算结存
    function lock(){
	    var rows= $("#materialstockplanresult_dg").datagrid("getChecked");
  	if(rows.length==0){
  		ext.tip.warn(tipSelectAtLeastOne);
  		return;
  	}
  	
  	var ids=[];
  	
 
  		ids.push(rows[0].job_no_s);
  	
  	
  	ext.ajax.post("material/stockMangement/materialstockplanpesult/lock",{ids:ids.toString()},function(data){
  		if(data.code!=OK){
  			ext.tip.error(data.message);
  		}
  		showConfirm(data.data);
	    filter();
  	});
}
	//保存结存
    function onsave(){
	    var rows= $("#materialstockplanresult_dg").datagrid("getChecked");
  	if(rows.length==0){
  		ext.tip.warn(tipSelectAtLeastOne);
  		return;
  	}
  	
  	var ids=[];
  	
 
  		ids.push(rows[0].job_no_s);
  	
  	
  	ext.ajax.post("material/stockMangement/materialstockplanpesult/onsave",{ids:ids.toString()},function(data){
  		if(data.code!=OK){
  			ext.tip.error(data.message);
  		}
  		showConfirm(data.data);
	    filter();
  	});
}
    function add() {
        ext.easyui.grid.appendAndEdit("materialstockplanresult_dg",{});
    }

    function edit() {
        var rows = $("#materialstockplanresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#materialstockplanresult_dg").datagrid("getRowIndex", rows[i]);
            $("#materialstockplanresult_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#materialstockplanresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#materialstockplanresult_dg").datagrid("getRowIndex", rows[i]);
            $("#materialstockplanresult_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#materialstockplanresult_dg");

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
            $("#materialstockplanresult_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#materialstockplanresult_dg").datagrid("rejectChanges");
    }


</script>