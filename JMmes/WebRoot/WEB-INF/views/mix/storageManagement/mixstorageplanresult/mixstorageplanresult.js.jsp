<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/storageManagement/mixStoragePlanResult/saveChanges";
    
    function showOrHide(){
        if($("#MixStoragePlanResult_search_form").is(":hidden")){
            $("#MixStoragePlanResult_search_form").show();
        }else{
            $("#MixStoragePlanResult_search_form").hide();
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
		url : "mix/storageManagement/mixStoragePlanData/getJobName?date="
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
    
    
    	//推算结存
    function lock(){
	    var rows= $("#mixstorageplanresult_dg").datagrid("getChecked");
  	if(rows.length==0){
  		ext.tip.warn(tipSelectAtLeastOne);
  		return;
  	}
  	
  	var ids=[];
  	
 
  		ids.push(rows[0].job_no_s);
  	
  	
  	ext.ajax.post("mix/storageManagement/mixStoragePlanResult/lock",{ids:ids.toString()},function(data){
  		if(data.code!=OK){
  			ext.tip.error(data.message);
  		}
  		showConfirm(data.data);
	    filter();
  	});
}
	//保存结存
    function onsave(){
	    var rows= $("#mixstorageplanresult_dg").datagrid("getChecked");
  	if(rows.length==0){
  		ext.tip.warn(tipSelectAtLeastOne);
  		return;
  	}
  	
  	var ids=[];
  	
 
  		ids.push(rows[0].job_no_s);
  	
  	
  	ext.ajax.post("mix/storageManagement/mixStoragePlanResult/onsave",{ids:ids.toString()},function(data){
  		if(data.code!=OK){
  			ext.tip.error(data.message);
  		}
  		showConfirm(data.data);
	    filter();
  	});
}
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("mixstorageplanresult_dg","MixStoragePlanResult_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixstorageplanresult_dg",{});
    }

    function edit() {
        var rows = $("#mixstorageplanresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixstorageplanresult_dg").datagrid("getRowIndex", rows[i]);
            $("#mixstorageplanresult_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixstorageplanresult_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixstorageplanresult_dg").datagrid("getRowIndex", rows[i]);
            $("#mixstorageplanresult_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixstorageplanresult_dg");

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
            $("#mixstorageplanresult_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixstorageplanresult_dg").datagrid("rejectChanges");
    }


</script>