<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/baseData/lockManagement/saveChanges";
     var editIndex=undefined;	
    function showOrHide(){
        if($("#LockManagement_search_form").is(":hidden")){
            $("#LockManagement_search_form").show();
        }else{
            $("#LockManagement_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
   
        ext.easyui.grid.search("lockmanagement_dg","LockManagement_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("lockmanagement_dg",{});
    }

    function edit() {
        var rows = $("#lockmanagement_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#lockmanagement_dg").datagrid("getRowIndex", rows[i]);
            $("#lockmanagement_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#lockmanagement_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#lockmanagement_dg").datagrid("getRowIndex", rows[i]);
            $("#lockmanagement_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#lockmanagement_dg");

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
            $("#lockmanagement_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#lockmanagement_dg").datagrid("rejectChanges");
    }

function rules(v,r,i){
		if(v=='1'){
			return '胶囊漏';
		}else {
			return '1';
		}
	};
	
	var onMaterialSelect=function(r){
		
		var ed;
        editIndex=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        
        ed = $("#lockmanagement_dg").datagrid("getEditor", {index:editIndex,field:"reas_code_s"});
        $(ed.target).textbox("setValue", r.REAS_CODE_S);
       
        
	};

	function onMaterialChange(nv,ov){
		$(this).combobox("reload");
	}
	 
	 function onMaterialBeforeLoad(param){
	 
		  var row=$("#lockmanagement_dg").datagrid("getRows");
		 if($(this).combobox("getValue")==""){
			 if(row.reas_cn_s){
				 param.reas_code_s=row.reas_cn_s;
			 }
		 }else{
			 param.reas_code_s=$(this).combobox("getValue");
		 }
		 
	 }
	 var onMatSelect=function(r){
		
		var ed;
        editIndex=$(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
        
        ed = $("#lockmanagement_dg").datagrid("getEditor", {index:editIndex,field:"reas_code_s"});
        $(ed.target).textbox("setValue", r.code);
       
        
	};
	 function onMatBeforeLoad(param){
	 
		  var row=$("#lockmanagement_dg").datagrid("getRows");
		 if($(this).combobox("getValue")==""){
			 if(row.control_rules_s){
				 param.reas_code_s=row.control_rules_s;
			 }
		 }else{
			 param.reas_code_s=$(this).combobox("getValue");
		 }
		 
	 }
	  /**
     *将数据库得值转换为数据字典与对应值域
     */
    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }
	 //病象描述
     function operatorFormatter(v, r, i){
 		if(v == "") {
 			return "";
 		}
 		
 		var url='finalcheck/baseData/lockManagement/getrea';
 		
 		
 	    	$.ajax({
 	    		url:url,
 	    		type:'get',
 	    		dataType:'json',
 	    		async:false,
 	    		data: {
 	    		    reas_code: v
 	    		},
 	    		success:function(data){
 	    		 	for(var j = 0;j<data.length;j++){
 	    		 	var e=data[j].REAS_CODE_S;
 	    		 	if(e==r.reas_cn_s){
 	    		 	v=data[j].REAS_CN_S;
 	    		 	return v;}
 	    		 	
 	    		 	}
 				}
 	    	});
 	    	return v;
 		} 	
	
</script>