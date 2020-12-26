<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    function codeFormatter(v, r, i) {
    	if(dictFormat(v)==null)
    		return r.matgrp_s;
		return dictFormat(v);
	}
    
	 /**
     * 接收combtree数据
     */
     var DICT_308=[];
 	
 	$.ajax({
 		url:"dict/code/-308",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_308=data;
 		}
 	});
    function showOrHide(){
        if($("#MaterialsPlus_search_form").is(":hidden")){
            $("#MaterialsPlus_search_form").show();
        }else{
            $("#MaterialsPlus_search_form").hide();
        }
    }
    
    function showfilterByMaterialgrp(){
    	filter();
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("materialsplus_dg","MaterialsPlus_search_form");
    }
    
    
    var singlefilter=function(){
    	ext.easyui.grid.search("materialsplus_dg1","MaterialsPlus_search_form1");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("materialsplus_dg1",{});
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
	var saveChanges=path+"sap/materialTimelinessMaintain/saveChanges";
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
        
	if(updated.length ==0 && deleted.length ==0){
			
			$("#materialsplus_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />");
	}else{
		for(var i=0;i<updated.length;i++){
			debugger;
			//updated[i]["materialcode_s"]=updated[i]["amaterialcode_s"];
			if(updated[i]["smalltime_f"]==null || updated[i]["smalltime_f"]==""){
				updated[i]["smalltime_f"]="0";
			}
			if(updated[i]["overtime_f"]==null || updated[i]["overtime_f"]==""){
				updated[i]["overtime_f"]="0";
			}
			//update[i]["spare1_s"]=updated[i]["matgrp_s"];
			 updated[i]["matgrp_s"];
			delete updated[i]["changed_by_name"];
		}
		for(var i=0;i<deleted.length;i++){
			delete updated[i]["matgrp_s"];
			delete updated[i]["amaterialcode_s"];
			delete updated[i]["amaterialdesc_s"];
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
    
	/**
	*单个页面修改事件
	*/
    function editsingle() {
        var rows = $("#materialsplus_dg1").datagrid("getSelections");
        
        if(rows.length !=0){
        	 var index = -1;
             for (var i = 0; i < rows.length; i++) {
                 index = $("#materialsplus_dg1").datagrid("getRowIndex", rows[i]);
                 $("#materialsplus_dg1").datagrid("beginEdit", index);
                 //物料编码
        		 var amaterialcode_s = $("#materialsplus_dg1").datagrid('getEditor', {index:index,field:'equipmentcode_s'});
            	 $(amaterialcode_s.target).textbox({disabled: true});//不可编辑
             }
        }else{
        	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
    }
    /**
	*单个页面删除事件
	*/
    function removesingle() {
        var rows = $("#materialsplus_dg1").datagrid("getSelections");
        if(rows.length !=0){
        	var index = -1;
            for (var i = 0; i < rows.length; i++) {
                index = $("#materialsplus_dg1").datagrid("getRowIndex", rows[i]);
                $("#materialsplus_dg1").datagrid("deleteRow", index);
            }

        }else{
        	ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
        }
        
    }

    /**
	*保存事件
	*/
    function savesingle() {
        var dg = $("#materialsplus_dg1");

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
        debugger;
		if(updated.length ==0 && deleted.length ==0&&inserted.length==0){
				
				$("#materialsplus_dg1").datagrid("reload");
	            ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
			for(var i=0;i<updated.length;i++){
				updated[i]["materialcode_s"]=updated[i]["amaterialcode_s"];
				if(updated[i]["smalltime_f"]==null || updated[i]["smalltime_f"]==""){
					updated[i]["smalltime_f"]="0";
				}
				if(updated[i]["overtime_f"]==null || updated[i]["overtime_f"]==""){
					updated[i]["overtime_f"]="0";
				}
				delete updated[i]["amaterialcode_s"];
				delete updated[i]["amaterialdesc_s"];
				delete updated[i]["matgrp_s"];
				delete updated[i]["changed_by_name"];
			}
			for(var i=0;i<deleted.length;i++){
				delete deleted[i]["matgrp_s"];
				delete deleted[i]["amaterialcode_s"];
				delete deleted[i]["amaterialdesc_s"];
				delete deleted[i]["changed_by_name"];
			}
			for(var i=0;i<inserted.length;i++){
				inserted[i]["materialcode_s"]=inserted[i]["amaterialcode_s"];
				inserted[i]["materialdesc_s"]=inserted[i]["amaterialdesc_s"];
				delete inserted[i]["amaterialcode_s"];
				delete inserted[i]["amaterialdesc_s"];
				delete inserted[i]["matgrp_s"];
				delete inserted[i]["changed_by_name"];
			}
	        ext.ajax.sendJson("sap/materialTimelinessMaintain/savesingleChanges", {
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

    function onMaterialSelect(record){
    	debugger;
    	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		$(getEditor(index, "amaterialdesc_s").target)
         .textbox("setValue", record.MATERIALDESC_S);//规格
        
		/* var url ="cx/qualitymanagement/buildquota/datagrid2?materialcode_s="+record.MATERIALCODE_S;
		ext.ajax.get(url, function(data) {
			$(getEditor(index, "tyretype_s").target)
	         	.textbox("setValue", data[0]);//规格
		});
		
		var url2="cx/qualitymanagement/buildquota/datagrid3?materialcode_s="+record.MATERIALCODE_S;
		ext.ajax.get(url2, function(data) {
			$(getEditor(index, "materialspec_s").target)
	         	.textbox("setValue", data[0]);//规格
		}); */
}
    function getEditor(index,field){
        return $("#materialsplus_dg1").datagrid("getEditor",{index:index,field:field});
 	}
    
    function cancelsingle() {
        $("#materialsplus_dg1").datagrid("rejectChanges");
    }
    function s() {
        $("#materialsplus_dg").datagrid("rejectChanges");
    }

</script>