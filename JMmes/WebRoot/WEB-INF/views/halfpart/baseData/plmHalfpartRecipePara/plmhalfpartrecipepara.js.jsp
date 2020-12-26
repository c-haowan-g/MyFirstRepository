<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/baseData/plmHalfpartRecipePara/saveChanges"; 
    
    function showOrHide(){
        if($("#PLMHalfpartRecipePara_search_form").is(":hidden")){
            $("#PLMHalfpartRecipePara_search_form").show();
        }else{
            $("#PLMHalfpartRecipePara_search_form").hide();
        }
    }
    /* 获取参数类型 */
     var basetypesList=[];
   	$.ajax({
	        url:'halfpart/baseData/plmHalfpartRecipePara/searchBasetype_s',
	        type:'get',
	        dataType:'json',
	        async:false,
	        success:function(data){
	        	basetypesList=data;
	        }});
	   /**
    * 参数显示显示转化
    * 2019-05-20
    * ldx
    */
    function basetypesFormatter(v, r, i){
         for(var i=0;i<basetypesList.length;i++){
            if (v == basetypesList[i].ERPCODE_S) {
                return basetypesList[i].DICTNAME_S;
            }
          }
    } 
	        
	  var equipTypeList=[];
   	$.ajax({
	        url:'halfpart/baseData/plmHalfpartRecipePara/searchEquipmenttypecode_s',
	        type:'get',
	        dataType:'json',
	        async:false,
	        success:function(data){
	        	equipTypeList=data;
	        }});
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
	function typeFormatter(v,r,i){
	   for(var i=0;i<typeList.length;i++){
		   if(v==typeList[i].code){
			   return typeList[i].text;
		   }
	   }
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("plmhalfpartrecipepara_dg","PLMHalfpartRecipePara_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("plmhalfpartrecipepara_dg",{});
    }

    function edit() {
        var rows = $("#plmhalfpartrecipepara_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plmhalfpartrecipepara_dg").datagrid("getRowIndex", rows[i]);
            $("#plmhalfpartrecipepara_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#plmhalfpartrecipepara_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plmhalfpartrecipepara_dg").datagrid("getRowIndex", rows[i]);
            $("#plmhalfpartrecipepara_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#plmhalfpartrecipepara_dg");

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
			
			$("#plmhalfpartrecipepara_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />")
		}else{
        ext.ajax.sendJson(saveChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {

            if (data.code!=OK) {
                ext.tip.error("<spring:message code="tip.error" />");
                return;
            }
            $("#plmhalfpartrecipepara_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
        }
    }
 
   function startaddress(){
    	var dg = $("#plmhalfpartrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["is_max_min_s"]="A";
			} 
		 if(rows.length==0 ){
			 ext.tip.error("至少选择一条数据");
		 }else{
			ext.ajax.sendJson(saveChanges, {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("操作失败");
				}else{
					 $("#plmhalfpartrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("操作成功");
				}
	
			});
		 }
    }
    
    
    function stopaddress(){
    	var dg = $("#plmhalfpartrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["is_max_min_s"]="D";
			} 
		 if(rows.length==0 ){
			 ext.tip.error("至少选择一条数据");
		 }else{
			ext.ajax.sendJson(saveChanges, {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("操作失败");
				}else{
					 $("#plmhalfpartrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("操作成功");
				}
	
			});
		 }
    }
    
    
    //启用
    function start() {
    	var dg = $("#plmhalfpartrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["record_flag_s"]="A";
			} 
		 if(rows.length==0 ){
			 ext.tip.error("至少选择一条数据");
		 }else{
			ext.ajax.sendJson(saveChanges, {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("操作失败");
				}else{
					 $("#plmhalfpartrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("操作成功");
				}
	
			});
		 }
    }
  //停用
    function stop() {
    	var dg = $("#plmhalfpartrecipepara_dg");
		var rows = dg.datagrid("getSelections");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["record_flag_s"]="D";
			} 
		 if(rows.length==0 ){
			 ext.tip.error("至少选择一条数据");
		 }else{
			ext.ajax.sendJson(saveChanges, {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("操作失败");
				}else{
					 $("#plmhalfpartrecipepara_dg").datagrid("reload"); 
					 ext.tip.suc("操作成功");
				}
	
			});
		 }
    }
    
    function cancel() {
        $("#plmhalfpartrecipepara_dg").datagrid("rejectChanges");
    }
        //是否启用，A启用，D停用
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
	 /*   页面初始化查询，与上次value比较，一样不进行后台SQL查询*/
     var oldValue=1;
    var oldValueName="";
    function basetypeText(value){
    	if(value!=oldValue){
    		$.ajax({
    			url:"halfpart/baseData/plmHalfpartRecipePara/searchBasetype_s?erpcode_s="+value,
    			type:"get",
    			dataType:"json",
    			async:false,
    			success:function(data){
    				oldValueName=data[0]["DICTNAME_S"];
    			}
    		});
    		oldValue=value;
    	    return oldValueName;
    	}
    	return oldValueName;
    } 
    
    	
</script>