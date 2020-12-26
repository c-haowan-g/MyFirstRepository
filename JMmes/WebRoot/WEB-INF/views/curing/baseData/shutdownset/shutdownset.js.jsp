<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/baseData/shutdownset/saveChanges";
    
    function showOrHide(){
        if($("#Shutdownset_search_form").is(":hidden")){
            $("#Shutdownset_search_form").show();
        }else{
            $("#Shutdownset_search_form").hide();
        }
    }
    
    /**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("shutdownset_dg","Shutdownset_search_form");
    }
    
    function add() {
    	ext.easyui.grid.appendAndEdit("shutdownset_dg",{
    		valid_flag_s: new Calendar().format("1")
			});
    }

    function edit() {
        var rows = $("#shutdownset_dg").datagrid("getSelections");
		if(rows.length !=0){
			var index = -1;
	        for (var i = 0; i < rows.length; i++) {
	            index = $("#shutdownset_dg").datagrid("getRowIndex", rows[i]);
	            $("#shutdownset_dg").datagrid("beginEdit", index);
	        }
		}else{
			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
		}
        
    }

    function remove() {
    	var rows = $("#shutdownset_dg").datagrid("getSelections");
    	/**var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#shutdownset_dg").datagrid("getRowIndex", rows[i]);
            	$("#shutdownset_dg").datagrid("deleteRow", index);
        }
        var deleted = $("#shutdownset_dg").datagrid("getChanges", "deleted");
    	if(deleted!=null&&deleted.length>0){
    		for(var i=0;i<deleted.length;i++){
    			delete deleted[i]["created_by_name"];
				delete deleted[i]["changed_by_name"];
    		}
    		ext.ajax.sendJson(saveChanges, {
 	            deleted : deleted,
 	         }, function(data) {
 	        	$("#shutdownset_dg").datagrid("reload");
 	         });
    	}**/
    	if(rows.length !=0){
            var index = -1;
            for (var i = 0; i < rows.length; i++) {
                index = $("#shutdownset_dg").datagrid("getRowIndex", rows[i]);
                $("#shutdownset_dg").datagrid("deleteRow", index);
            }
    	}else{
    		ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
    	}
    }

    function save() {
        var dg = $("#shutdownset_dg");

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
				$("#materialpdf_dg").datagrid("reload");
	            ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
	        for(var i=0;i<inserted.length;i++){
				delete inserted[i]["created_by_name"];
				delete inserted[i]["changed_by_name"];
				if(inserted[i]["set_time_s"]==0){
	            	  ext.tip.error("<spring:message code="tip.invalid" />");
	            	  $("#shutdownset_dg").datagrid("reload");
	            	  return;
	            }  
				if(inserted[i]["alarm_number_s"]==0){
	            	  ext.tip.error("<spring:message code="tip.invalid" />");
	            	  $("#shutdownset_dg").datagrid("reload");
	            	  return;
	            }  
			}
			for(var i=0;i<updated.length;i++){
				delete updated[i]["created_by_name"];
				delete updated[i]["changed_by_name"];
				if(updated[i]["set_time_s"]==0){
	            	  ext.tip.error("<spring:message code="tip.invalid" />");
	            	  $("#shutdownset_dg").datagrid("reload");
	            	  return;
	            }  
				if(updated[i]["alarm_number_s"]==0){
	            	  ext.tip.error("<spring:message code="tip.invalid" />");
	            	  $("#shutdownset_dg").datagrid("reload");
	            	  return;
	            }  
			}
			for(var i=0;i<deleted.length;i++){
				delete deleted[i]["created_by_name"];
				delete deleted[i]["changed_by_name"];
			}
	        ext.ajax.sendJson(saveChanges, {
	            inserted : inserted,
	            updated : updated,
	            deleted : deleted
	        }, function(data) {
	
	        	if (data.code != 0) {
	        		  if(data.code == 1){
	        			  if(data.message=="代码重复"){
	        				$("#shutdownset_dg").datagrid("reload");
	                      ext.tip.error("<spring:message code="tip.repeat" />");
	        			  }else{
	        				 $("#shutdownset_dg").datagrid("reload");
	                       ext.tip.error("<spring:message code="tip.error" />");
	        			  }
	        		  }
	              }else{
	            	  $("#shutdownset_dg").datagrid("reload");
	                  ext.tip.suc("<spring:message code="tip.success" />");
	              }
	
	        	});
	   		}
    }
    function cancel() {
        $("#shutdownset_dg").datagrid("rejectChanges");
    }

  	
    

</script>