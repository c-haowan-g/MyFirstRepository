<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
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
        ext.easyui.grid.search("curingrecipepara_dg","Curingrecipepara_search_form");
    }
    


	function add() {
        ext.easyui.grid.appendAndEdit("curingrecipepara_dg",{
        	record_flag_s : "D"
        	
        });
    }

    function edit() {
    	 var rows = $("#curingrecipepara_dg").datagrid("getSelections");
         if (rows == "") {
 			ext.tip.error("<spring:message code="tip.edit" />");
 		 }

    	  for (var i = 0; i < rows.length; i++) {
             index = $("#curingrecipepara_dg").datagrid("getRowIndex", rows[i]);
       
        
             $("#curingrecipepara_dg").datagrid("beginEdit", index);
             
             if(rows[i]["logicaladdress_s"]!=null){
            	 var ed = $("#curingrecipepara_dg").datagrid('getEditor', {index:index,field:'logicaladdress_s'});
            	 $(ed.target).textbox({disabled: true});//不可编辑
          	 }
          	 var basetype = $("#curingrecipepara_dg").datagrid('getEditor', {index:index,field:'basetype_s'});
             $(basetype.target).textbox({disabled: true});//不可编辑
             var parmcode = $("#curingrecipepara_dg").datagrid('getEditor', {index:index,field:'parmcode_s'});
             $(parmcode.target).textbox({disabled: true});//不可编辑
             var parmname = $("#curingrecipepara_dg").datagrid('getEditor', {index:index,field:'parmname_s'});
             $(parmname.target).textbox({disabled: true});//不可编辑
             var parmtypecode = $("#curingrecipepara_dg").datagrid('getEditor', {index:index,field:'parmtypecode_s'});
             $(parmtypecode.target).textbox({disabled: true});//不可编辑
             var parmtypename = $("#curingrecipepara_dg").datagrid('getEditor', {index:index,field:'parmtypename_s'});
             $(parmtypename.target).textbox({disabled: true});//不可编辑
    	  }              
    }
    
    
    function remove() {

        var rows = $("#curingrecipepara_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#curingrecipepara_dg").datagrid("getRowIndex", rows[i]);
            $("#curingrecipepara_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#curingrecipepara_dg");

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
        if(inserted.length ==0 && updated.length ==0 && deleted.length ==0 ){
			 $("#curingrecipepara_dg").datagrid("reload");
			 ext.tip.error("<spring:message code="tip.nosave" />");
		 }else{
	        ext.ajax.sendJson("curing/baseData/curingRecipePara/saveChanges", {
	            inserted : inserted,
            	updated : updated,
            	deleted : deleted
	        }, function(data) {
	        	if (data.message != "ok") {
					if(data.message == "代码重复"){
						 ext.tip.error("<spring:message code="tip.repeat" />");
					}else{
						 ext.tip.error("<spring:message code="tip.error" />");
					}
				}else{
				
					 $("#curingrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	        });
		 }
    }
    //启用
    function start() {
    	var dg = $("#curingrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["record_flag_s"]="A";
			} 
		 if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		 }else{
			ext.ajax.sendJson("curing/baseData/curingRecipePara/saveChanges", {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#curingrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
    }
  //停用
    function stop() {
    	var dg = $("#curingrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["record_flag_s"]="D";
			} 
		 if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		 }else{
			ext.ajax.sendJson("curing/baseData/curingRecipePara/saveChanges", {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#curingrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
    }
    function cancel() {
        $("#curingrecipepara_dg").datagrid("rejectChanges");
    }


</script>