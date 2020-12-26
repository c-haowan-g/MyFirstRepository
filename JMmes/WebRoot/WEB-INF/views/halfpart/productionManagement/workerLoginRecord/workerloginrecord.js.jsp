<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/productionManagement/workerLoginRecord/saveChanges";
    
    function showOrHide(){
        if($("#WorkerLoginRecord_search_form").is(":hidden")){
            $("#WorkerLoginRecord_search_form").show();
        }else{
            $("#WorkerLoginRecord_search_form").hide();
        }
    }
    
    $(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
		filter();
	});
    
    function flagFormat(value, row, index) {
		if ((value == "0")) {
			return "注销";
		} else if ((value == "1")) {
			return "登录";
		}
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("workerloginrecord_dg","WorkerLoginRecord_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("workerloginrecord_dg",{});
    }

    function edit() {
        var rows = $("#workerloginrecord_dg").datagrid("getSelections");
        if(rows.length<=0){
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#workerloginrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#workerloginrecord_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#workerloginrecord_dg").datagrid("getSelections");
        if(rows.length<=0){
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#workerloginrecord_dg").datagrid("getRowIndex", rows[i]);
            $("#workerloginrecord_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#workerloginrecord_dg");

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
        
        if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			$("#workerloginrecord_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />")
		}else{
	            
			var arysave = new Array(); 
			var aryupdate = new Array(); 
			
			var narySave=arysave.sort();  
			var naryUpdate=aryupdate.sort();  
			for(var i=0;i<arysave.length;i++){  
				 if (narySave[i]==narySave[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				 }
			 } 
			 for(var i=0;i<aryupdate.length;i++){  
				 if (naryUpdate[i]==naryUpdate[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return; 
				 }
			 }
			ext.ajax.sendJson(saveChanges, {
		            inserted : inserted,
		            updated : updated,
		            deleted : deleted
		    }, function(data) {
	            if (data.code!= OK ) {
	                ext.tip.error("<spring:message code="tip.error" />");
	                return;
	            }else{
	            	$("#workerloginrecord_dg").datagrid("reload");
	            	ext.tip.suc("<spring:message code="tip.success" />");
				}
	        });
		}
    }
    
    function toChangedName(v, r, i) {
    	if(v == null) {
    		return v;
    	}
		$.ajax({
			url : 'halfpart/productionManagement/workerLoginRecord/toChangedName',
			type : 'get',
			dataType : 'json',
			data: {
				usercode: v
			},
			async : false,
			success : function(data) {
				if(data.length == 0) {
					return v;
				}
				v = data[0].username;
			}
		});
		return v;
	}
	
	function codeFormatter(v, r, i) {
        if(v==null){
            return "";
        }
        return dictFormat(v);
    }
    
    function cancel() {
        $("#workerloginrecord_dg").datagrid("rejectChanges");
    }


</script>