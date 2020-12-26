<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/baseData/ReasAlermMaintain/saveChanges";
    
   
    
    
    /**
     * 接收combtree数据
     */
     var DICT_252=[];
 	
 	$.ajax({
 		url:"dict/code/252",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_252=data;
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
    
    function showOrHide(){
        if($("#TyreReasAlermMaintain_search_form").is(":hidden")){
            $("#TyreReasAlermMaintain_search_form").show();
        }else{
            $("#TyreReasAlermMaintain_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("tyrereasalermmaintain_dg","TyreReasAlermMaintain_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("tyrereasalermmaintain_dg",{});
       
       /*  $("#tyrereasalermmaintain_dg").datagrid('insertRow', {
			index: 0,row:{}
		});

        $("#tyrereasalermmaintain_dg").datagrid("beginEdit", 0); */
    }

    function edit() {
        var rows = $("#tyrereasalermmaintain_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#tyrereasalermmaintain_dg").datagrid("getRowIndex", rows[i]);
            $("#tyrereasalermmaintain_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#tyrereasalermmaintain_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#tyrereasalermmaintain_dg").datagrid("getRowIndex", rows[i]);
            $("#tyrereasalermmaintain_dg").datagrid("deleteRow", index);
        }

    }
  /*   function toDC(v, r, i) {
		var row=$("#tyrereasalermmaintain_dg").datagrid("getData").rows[i];
		var count = row.reas_count_i;
		if(count=='0'){
        	ext.tip.error("病象统计次数不能为0");
        	
        } 
	} */
    
    function save() {
        var dg = $("#tyrereasalermmaintain_dg");

        var rows = dg.datagrid("getRows");
        var valid = false;
       
       /*   var rowData = $("#tyrereasalermmaintain_dg").datagrid("getSelections");
         var index = -1;
         for (var i = 0; i < rowData.length; i++) {
             index = $("#tyrereasalermmaintain_dg").datagrid("getRowIndex", rowData[i]);
             var count = rowData[i].reas_count_i;
             if(count=='0'){
             	ext.tip.error("病象统计次数不能为0");
             	return;
             } 
         } */
      
         
        
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
			
			$("#tyrereasalermmaintain_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />")
		}else{
        
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
        	if (data.message == '代码重复') {
                // $("#equipmentcapacity_dg").datagrid("reload");
                 ext.tip.error(data.message);
                 $("#tyrereasalermmaintain_dg").datagrid("beginEdit", 0);
             }else{
                 $("#tyrereasalermmaintain_dg").datagrid("reload");
                 ext.tip.suc("<spring:message code="tip.success" />");
             }

         });
         }
     }
     

    function cancel() {
        $("#tyrereasalermmaintain_dg").datagrid("rejectChanges");
    }


</script>