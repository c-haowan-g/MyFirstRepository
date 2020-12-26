<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/baseData/reas/saveChanges";
    
    var bxz={},bxl={};
    
    $(function(){
    	ext.ajax.get("dict/code/261",function(data){
    		log(data)
    	});
    });
    
    function bxzFormatter(v,r,i){
    	
    	return bxz[r];
    }
    
    /**
     * 接收combtree数据
     */
     var DICT_261=[];
 	
 	$.ajax({
 		url:"dict/code/261",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_261=data;
 		}
 	});
    /**
     * 接收combotree数据
     */
     var DICT_262=[];
 	
 	$.ajax({
 		url:"dict/code/262",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_262=data;
 		}
 	});
    
    /**
     * 接收用户数据
     */
     var UserInfo=[];
 	
 	$.ajax({
 		url:"common/comboxUser",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			UserInfo=data;
 		}
 	});
	function userFormatter(v,r,i){
 		for (var i = 0; i < UserInfo.length; i++) {
 			if(UserInfo[i].USERCODE==v){
 				return UserInfo[i].USERNAME;
 			}
 		}
 	}
  
    function formatter2(date){
    	log(date==null?"":new Calendar(date).format('yyyy-MM-dd HH:mm:ss'));
		return date==null?"":new Calendar(date).format('yyyy-MM-dd HH:mm:ss');
	}
    
    function codeFormatter(v,r,i){
    	
    	return dictFormat(v);
    }
    
    function showOrHide(){
        if($("#Reas_search_form").is(":hidden")){
            $("#Reas_search_form").show();
        }else{
            $("#Reas_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("reas_dg","Reas_search_form");
    }
    
    function add() {
    	$("#reas_dg").datagrid('insertRow', {
			index: 0,row:{}
		});

        $("#reas_dg").datagrid("beginEdit", 0);
    }

    function edit() {
        var rows = $("#reas_dg").datagrid("getSelections");
        if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#reas_dg").datagrid("getRowIndex", rows[i]);
            $("#reas_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#reas_dg").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#reas_dg").datagrid("getRowIndex", rows[i]);
            $("#reas_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#reas_dg");

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

            if (data.status != 1) {
                ext.tip.error("<spring:message code="tip.error" />");
            }
            $("#reas_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#reas_dg").datagrid("rejectChanges");
    }
    function showhide() {
    	$("#Reas_search_form").toggle();
    }

</script>