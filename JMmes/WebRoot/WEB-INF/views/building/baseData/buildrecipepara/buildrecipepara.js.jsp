<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"building/basedata/buildrecipepara/saveChanges";
    
  var enttypeList=[];
 	
 	$.ajax({

 		url:"building/basedata/buildrecipepara/comboxequiptype",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			enttypeList=data;
 		}
 	});
    
 	function enttypefromatter(v,r,i){
 		for(var i=0;i<enttypeList.length;i++){
 			if(v==enttypeList[i].EQUIPMENTTYPECODE_S){
 				return enttypeList[i].EQUIPMENTTYPENAME_S;
 			}
 		}
 		return v;
 	}
    
    function showOrHide(){
        if($("#BuildRecipePara_search_form").is(":hidden")){
            $("#BuildRecipePara_search_form").show();
        }else{
            $("#BuildRecipePara_search_form").hide();
        }
    }
    /*   参数类型， 1成型，2硫化*/
	var basetypeText=function (value, rowData, rowIndex){
		if(value==1){
			return "成型";
		}else if(value==2){
			return "硫化";
		}
	}
	/*   是否启用，A启用，D停用*/
	var recordflagText=function (value, rowData, rowIndex){
		if(value=="A"){
			return "启用";
		}else if(value=="D"){
			return "停用";
		}
	}
  //是否启用颜色处理
	var cellStyler=function (value,row,index){
		if (value=="A"){
			return 'background-color:#ccff99;';
		}else if (value=="D"){
			return 'background-color:#ffcc99;';
		}
	}
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("buildrecipepara_dg","BuildRecipePara_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("buildrecipepara_dg",{});
    }

    function edit() {
        var rows = $("#buildrecipepara_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#buildrecipepara_dg").datagrid("getRowIndex", rows[i]);
            $("#buildrecipepara_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#buildrecipepara_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#buildrecipepara_dg").datagrid("getRowIndex", rows[i]);
            $("#buildrecipepara_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#buildrecipepara_dg");

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
        Utils.each(updated, function(i, d) {
			delete d.changebyname;
		});
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#buildrecipepara_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#buildrecipepara_dg").datagrid("rejectChanges");
    }
    function openaddress(){
    	var dg = $("#buildrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["is_max_min_s"]="A";
			 delete rows[i]["changebyname"];
			} 
		 if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		 }else{
			ext.ajax.sendJson(saveChanges, {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#buildrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
    }
    
    function closeaddress(){
    	var dg = $("#buildrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["is_max_min_s"]="D";
			 delete rows[i]["changebyname"];
			} 
		 if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		 }else{
			ext.ajax.sendJson(saveChanges, {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#buildrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
    }
    
    
    //开启
	function openpara(){
		var dg = $("#buildrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["record_flag_s"]="A";
			} 
		 if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		 }else{
			ext.ajax.sendJson(saveChanges, {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#buildrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
	}
    //关闭
	function closepara(){
		var dg = $("#buildrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["record_flag_s"]="D";
			} 
		 if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		 }else{
			ext.ajax.sendJson(saveChanges, {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#buildrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
	}

</script>