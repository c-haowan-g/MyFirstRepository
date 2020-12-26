<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"sap/materialsPlus/saveChanges";
    
    function showOrHide(){
        if($("#MaterialsPlus_search_form").is(":hidden")){
            $("#MaterialsPlus_search_form").show();
        }else{
            $("#MaterialsPlus_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("materialsplus_dg","MaterialsPlus_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("materialsplus_dg",{});
    }


    /**
	*修改事件
	*/
    function edit() {
        var rows = $("#materialsplus_dg").datagrid("getSelections");
        
        if(rows.length !=0){
        	 var index = -1;
             for (var i = 0; i < rows.length; i++) {
                 index = $("#materialsplus_dg").datagrid("getRowIndex", rows[i]);
                 $("#materialsplus_dg").datagrid("beginEdit", index);
             }
        }else{
        	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
    }

    /**
	*删除事件
	*/
    function remove() {
        var rows = $("#materialsplus_dg").datagrid("getSelections");
        if(rows.length !=0){
        	var index = -1;
            for (var i = 0; i < rows.length; i++) {
                index = $("#materialsplus_dg").datagrid("getRowIndex", rows[i]);
                $("#materialsplus_dg").datagrid("deleteRow", index);
            }

        }else{
        	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
        
    }
    
    /**
	*保存事件
	*/
    function save() {
        var dg = $("#materialsplus_dg");

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
			
			$("#materialsplus_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />");
	}else{
		for(var i=0;i<inserted.length;i++){
        	delete inserted[i]["changed_by_name"];
		}
		for(var i=0;i<updated.length;i++){
			updated[i]["amaterialcode_s"]=updated[i]["amaterialcode_s"];
			if(updated[i]["innerdia_d"]==null || updated[i]["innerdia_d"]==""){
				updated[i]["innerdia_d"]="0";
			}
			if(updated[i]["outerdia_d"]==null || updated[i]["outerdia_d"]==""){
				updated[i]["outerdia_d"]="0";
			}
			if(updated[i]["tyreheight_d"]==null || updated[i]["tyreheight_d"]==""){
				updated[i]["tyreheight_d"]="0";
			}
			if(updated[i]["tyrewidth_d"]==null || updated[i]["tyrewidth_d"]==""){
				updated[i]["tyrewidth_d"]="0";
			}
			if(updated[i]["beadwidth_d"]==null || updated[i]["beadwidth_d"]==""){
				updated[i]["beadwidth_d"]="0";
			}
			delete updated[i]["changed_by_name"];
			delete updated[i]["amaterialcode_s"];
			delete updated[i]["amaterialdesc_s"];
		}
		for(var i=0;i<deleted.length;i++){
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
        				$("#materialsplus_dg").datagrid("reload");
                      ext.tip.error("<spring:message code="tip.repeat" />");
        			  }else{
        				 $("#materialsplus_dg").datagrid("reload");
                       ext.tip.error("<spring:message code="tip.error" />");
        			  }
        		  }
              }else{
            	  $("#materialsplus_dg").datagrid("reload");
                  ext.tip.suc("<spring:message code="tip.success" />")
              }
              
        });
	}
        
    }

    function cancel() {
        $("#materialsplus_dg").datagrid("rejectChanges");
    }


</script>