<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	
	
    var saveChanges=path+"curing/baseData/DotControl/saveChanges";
    
    function showOrHide(){
        if($("#DOTControl_search_form").is(":hidden")){
            $("#DOTControl_search_form").show();
        }else{
            $("#DOTControl_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("dotcontrol_dg","DOTControl_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("dotcontrol_dg",{
        	isvlid_s: new Calendar().format("1")
        });
        
    }

    function edit() {
        var rows = $("#dotcontrol_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#dotcontrol_dg").datagrid("getRowIndex", rows[i]);
            $("#dotcontrol_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#dotcontrol_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#dotcontrol_dg").datagrid("getRowIndex", rows[i]);
            $("#dotcontrol_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#dotcontrol_dg");

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
				$("#dotcontrol_dg").datagrid("reload");
	            ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
	        for(var i=0;i<inserted.length;i++){
				delete inserted[i]["created_by_name"];
				delete inserted[i]["changed_by_name"];
			}
			for(var i=0;i<updated.length;i++){
				delete updated[i]["created_by_name"];
				delete updated[i]["changed_by_name"];
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
	      				$("#dotcontrol_dg").datagrid("reload");
	                    ext.tip.error("<spring:message code="tip.repeat" />");
	      			  }else{
	      				 $("#dotcontrol_dg").datagrid("reload");
	                     ext.tip.error("<spring:message code="tip.error" />");
	      			  }
	      		  }
	            }else{
	          	  $("#dotcontrol_dg").datagrid("reload");
	                ext.tip.suc("<spring:message code="tip.success" />")
	            }
        	});
		}
    }

    function cancel() {
        $("#dotcontrol_dg").datagrid("rejectChanges");
    }


</script>