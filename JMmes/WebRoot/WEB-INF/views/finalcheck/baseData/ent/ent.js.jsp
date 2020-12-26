<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    var saveChanges=path+"finalcheck/baseData/ent/saveChanges";
    /**
     * 接收combox数据
     */
     var DICT_254=[];
 	
 	$.ajax({
 		url:"dict/code/254",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_254=data;
 		}
 	});
 	  /**
     * 接收combox数据
     */
     var DICT_260=[];
 	
 	$.ajax({
 		url:"dict/code/260",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_260=data;
 		}
 	});
    /**
     * 接收combox数据
     */
     var DICT_255=[];
 	
 	$.ajax({
 		url:"dict/code/255",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			DICT_255=data;
 		}
 	});
    
    function showOrHide(){
        if($("#Ent_search_form").is(":hidden")){
            $("#Ent_search_form").show();
        }else{
            $("#Ent_search_form").hide();
        }
    }
    function codeFormatter(v,r,i){
    	
    	return dictFormat(v);
    }
    
    function spareFormatter(v,r,i){
    	if(v=="0")
    		return "否";
    	else if(v=="1")
    		return "是";
    	else 
    		return "";
    }
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("ent_dg","Ent_search_form");
    }
    
    function add() {
        $("#ent_dg").datagrid('insertRow', {
			index: 0,row:{}
		});
        $("#ent_dg").datagrid("beginEdit", 0);
    }

    function edit() {
        var rows = $("#ent_dg").datagrid("getSelections");
        if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#ent_dg").datagrid("getRowIndex", rows[i]);
            $("#ent_dg").datagrid("beginEdit", index);
            if(rows[i]["enttype_i"]!="254002"){
            	 //规格
	    		 var spare2_s = $("#ent_dg").datagrid('getEditor', {index:index,field:'spare2_s'});
            	 $(spare2_s.target).textbox('clear');
	           	 $(spare2_s.target).textbox({disabled: true});//不可编辑
            }
        }
    }

    function remove() {
        var rows = $("#ent_dg").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#ent_dg").datagrid("getRowIndex", rows[i]);
            $("#ent_dg").datagrid("deleteRow", index);
        }
    }

    
  var exitEntbarcode= function (value,o){
		  var  entBarcode =value;
    	var rows = $("#ent_dg").datagrid("getSelections");
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].entbarcode_s==entBarcode){
    			return;
    		}
    	}
    	
    	
    		$.ajax({
          		url:"finalcheck/baseData/ent/entBarcodeExit?entBarcode="+entBarcode,
          		type:"get",
          		dataType:"json",
          		async:false,
          		success:function(data){
          			if(data[0].COUNT!=0){
          				ext.tip.error(entBarcode+"机台条码已经存在");
          			}
          			else{
          				
          			};
          			
          		}
    		
          	});
    }
    
    
    function save() {
    	//表名是：AT_D_EM_Ent
        var dg = $("#ent_dg");
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
        var isPause1=false;
        var flag=0;
        for(var i=0;i<updated.length;i++){
       	 for(var k=0;k<updated.length;k++){
       		 if(updated[i].entbarcode_s==updated[k].entbarcode_s){
       			flag=flag+1;
       			if(flag>1){
       				ext.tip.error("编辑的机台存在条码重复，请检查");
       				isPause1=true;
       			 }
              };
            }
       	 flag=0;
       }
        var isPause2=false;
        var iflag=0;
        for(var i=0;i<inserted.length;i++){
          	 for(var k=0;k<inserted.length;k++){
          		 if(inserted[i].entbarcode_s==inserted[k].entbarcode_s){
          			iflag=iflag+1;
          			if(iflag>1){
          				ext.tip.error("新增的机台存在条码重复，请检查");
          				isPause2=true;
          			 }
                 };
               }
          }
        if(isPause1||isPause2){
        	 setTimeout(function(){
            	 ext.ajax.sendJson(saveChanges, {
                     inserted : inserted,
                     updated : updated,
                     deleted : deleted
                 }, function(data) {
                     if (data.code!=OK) {
                         ext.tip.error("<spring:message code="tip.error" />");
                     }
                     $("#ent_dg").datagrid("reload");
                     ext.tip.suc("<spring:message code="tip.success" />");
                 });
            	},2000);
        }
        else{
        	ext.ajax.sendJson(saveChanges, {
                inserted : inserted,
                updated : updated,
                deleted : deleted
            }, function(data) {
                if (data.code!=OK) {
                    ext.tip.error("<spring:message code="tip.error" />");
                }
                $("#ent_dg").datagrid("reload");
                ext.tip.suc("<spring:message code="tip.success" />");
            });
        }
        
        
       
    }

    function cancel() {
        $("#ent_dg").datagrid("rejectChanges");
    }
    
    function showhide() {
    	$("#Ent_search_form").toggle();
    }
    //强制开关按钮
    function on_off(buttontype){
    	var rows=$("#ent_dg").datagrid("getChecked");
    	if(rows.length==0){
    		ext.tip.warn(tipSelectAtLeastOne);
    		return;
    	}
    	//获取界面选择的ID
    	var ids=[];
    	for(var i=0;i<rows.length;i++){
    		if(rows[i].enttype_i=="254002"){
    			ids.push(rows[i].atr_key);
    		}
    	}
    	ext.ajax.post("finalcheck/baseData/ent/forced",{ids:ids.toString(),foreType:buttontype},function(data){
    		if(data.code==OK){
    			ext.tip.suc();
    			filter();
    			return;
    		}
    		ext.tip.error(data.message);
    	});
    }

</script>