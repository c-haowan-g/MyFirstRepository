<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"cx/zlgl/mouldstock/saveChanges";
    
    function showOrHide(){
        if($("#Mouldstock_search_form").is(":hidden")){
            $("#Mouldstock_search_form").show();
        }else{
            $("#Mouldstock_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("mouldstock_dg","Mouldstock_search_form");
    }
    
    function queryBar() {
		$("#Mouldstock_search_form").toggle(500);
	}
    
    function add() {
    
    	$("#mouldstock_dg").datagrid('insertRow', {
			index : 0,
			row : {status_s : "154001"}
		});
    	$("#mouldstock_dg").datagrid("beginEdit", 0);
        
    }

    function edit() {
        var rows = $("#mouldstock_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mouldstock_dg").datagrid("getRowIndex", rows[i]);
            $("#mouldstock_dg").datagrid("beginEdit", index);
        }
        var store_location_s = $("#mouldstock_dg").datagrid('getEditor', {index:index,field:'store_location_s'});
			           	 $(store_location_s.target).textbox({disabled: true});//不可编辑
    }

    function remove() {

        var rows = $("#mouldstock_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mouldstock_dg").datagrid("getRowIndex", rows[i]);
            $("#mouldstock_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mouldstock_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
        for (var i = 0; i < rows.length; i++) {
            if (!dg.datagrid("validateRow", i)) {
                ext.tip.error("<spring:message code="请输入全部必填信息" />");
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
			
			$("#mouldstock_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />")
		}else{
	            
			var arysave = new Array(); 
			for(var i=0;i<inserted.length;i++){
				delete inserted[i]["created_by_name"];
			}
			var aryupdate = new Array(); 
			for(var i=0;i<updated.length;i++){
				delete updated[i]["created_by_name"];
			}
			for(var i=0;i<deleted.length;i++){
				delete deleted[i]["created_by_name"];
			}
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
			log(data)
            if (data.code==OK) {
            	$("#mouldstock_dg").datagrid("reload");
                ext.tip.suc("<spring:message code="tip.success" />")
                return;
            }
            if(data.code=='CF'){
            	ext.tip.error("<spring:message code="机头编码重复，请检查" />");
                return;
            }
			if(data.code=='WG'){
            	ext.tip.error("<spring:message code="机头编码格式错误，请检查" />");
                return;
            }
           
        });
		}
        
        
    }

    function cancel() {
        $("#mouldstock_dg").datagrid("rejectChanges");
    }
    
    /**
     * 接收combtree数据
     */
     var DICT_153=[];
     var DICT_154=[];
   
    	$.ajax({
    		url:"dict/code/153",
    		type:"get",
    		dataType:"json",
    		async:false,
    		success:function(data){
    			DICT_153=data;
    		}
    	});
    	$.ajax({
    		url:"dict/code/154",
    		type:"get",
    		dataType:"json",
    		async:false,
    		success:function(data){
    			DICT_154=data;
    		}
    	});
    	
    	function codeFormatter(v, r, i) {

    		return dictFormat(v);
    	}


</script>