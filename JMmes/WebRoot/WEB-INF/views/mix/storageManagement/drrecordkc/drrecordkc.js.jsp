<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/storageManagement/drRecordkc/saveChanges";
    
    function showOrHide(){
        if($("#DrRecordkc_search_form").is(":hidden")){
            $("#DrRecordkc_search_form").show();
        }else{
            $("#DrRecordkc_search_form").hide();
        }
    }
    
      //设定时间初始值从当前时间00:00:00至23:59:59
    $(document).ready(function(){
        $('#start_time').datetimebox({
            value: '3/4/2010 00:00:00',
            required: true,
            showSeconds: true
        });
        $('#end_time').datetimebox({
            value: '3/4/2010 23:59:59',
            required: true,
            showSeconds: true
        });
        filter();
    });
    
    //表格加载前事件
	function dlg1BeforeLoad(param) {

		if ($("#start_time").datebox("getValue") == "") {
			return false;
		}

		param["filter[start_time]"] = $("#start_time").datebox("getValue")
				.toString();
		param["filter[end_time]"] = $("#end_time").datebox("getValue")
				.toString();

		if ($("#lot_no_s").textbox("getValue") == "") {

		} else {
			param["filter[start_time]"] = null;
			param["filter[end_time]"] = null;
		}
	}
	
    /**
     * 查询方法
     */
    var filter=function(){
    	var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	if((starttime!=""&&endtime=="")||(starttime==""&&endtime!="")){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			$("#drrecordkc_dg").datagrid("options").url="mix/storageManagement/drRecordkc/datagrid";
    			   ext.easyui.grid.search("drrecordkc_dg","DrRecordkc_search_form");
    		}
    	}else{
    		$("#drrecordkc_dg").datagrid("options").url="mix/storageManagement/drRecordkc/datagrid";
    		   ext.easyui.grid.search("drrecordkc_dg","DrRecordkc_search_form");
    	}
        //ext.easyui.grid.search("drrecordkc_dg","DrRecordkc_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("drrecordkc_dg",{});
    }

    function edit() {
        var rows = $("#drrecordkc_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#drrecordkc_dg").datagrid("getRowIndex", rows[i]);
            $("#drrecordkc_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#drrecordkc_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#drrecordkc_dg").datagrid("getRowIndex", rows[i]);
            $("#drrecordkc_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#drrecordkc_dg");

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
            $("#drrecordkc_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#drrecordkc_dg").datagrid("rejectChanges");
    }
  /**
    *将数据库得值转换为数据字典与对应值域
  */           	
 function codeFormatter(v, r, i) {

    		return dictFormat(v);
    	}
    	
     function warehousemodeFormatter(v,r,i){
        if(v==1){
             return "指定批次";        	 
        }else if(v==2){
       	     return "指定托盘";  
        }else if(v==3){
       	     return "指定物料编码";  
        }else if(v==4){
       	     return "指定配套代码、物料编码";  
        }else if(v==5){
       	     return "指定配方名称";  
        }else if(v==6){
       	     return "指定载具编号";  
        }else{
       	     return v;
        }
   } 

     function testmatflagFormatter(v,r,i){
        if(v==0){
             return "否";        	 
        }else if(v==1){
       	     return "是";  
        }else{
       	     return v;
        }
   } 
   
     function prioritymatflagFormatter(v,r,i){
        if(v==0){
             return "否";        	 
        }else if(v==1){
       	     return "是";  
        }else{
       	     return v;
        }
   }
   
     function requeststateFormatter(v,r,i){
        if(v==0){
             return "发出请求";        	 
        }else if(v==1){
       	     return "正常反馈";  
        }else if(v==2){
       	     return "离线反馈";  
        }else{
       	     return v;
        }
   }       

</script>