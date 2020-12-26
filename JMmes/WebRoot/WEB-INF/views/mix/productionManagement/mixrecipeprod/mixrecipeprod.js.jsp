<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/productionManagement/mixrecipeprod/saveChanges";
    
    function showOrHide(){
        if($("#MixRecipeProd_search_form").is(":hidden")){
            $("#MixRecipeProd_search_form").show();
        }else{
            $("#MixRecipeProd_search_form").hide();
        }
    }
    //获取指定行、指定列的编辑器
    function getEditor1(index,field){
        return $("#mixrecipeprod_dg").datagrid("getEditor",{index:index,field:field});
    }
    /**
     * 解析指定格式日期
     */
    function dateParser(s) {
        if (!s)
            return new Date();
        return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
            .substring(6, 8));
    }

    /**
     * 日期格式化
     */
    function dateFormat(date) {
        return new Calendar(date).format("yyyyMMdd");
    }
    /**
     * 查询方法
     */
    var filter=function(){
    var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        if(starttime!="" && endtime!=""){
            if(starttime>endtime){
                ext.tip.error("<spring:message code="tip.date" />");
            }else{
                var opts = $("#mixrecipeprod_dg").datagrid("options");
                opts.url ='mix/productionManagement/mixrecipeprod/datagrid';
                ext.easyui.grid.search("mixrecipeprod_dg","MixRecipeProd_search_form");
            }
        }else{
            var opts = $("#mixrecipeprod_dg").datagrid("options");
            opts.url ='mix/productionManagement/mixrecipeprod/datagrid';
            ext.easyui.grid.search("mixrecipeprod_dg","MixRecipeProd_search_form");
        }
        //ext.easyui.grid.search("mixrecipeprod_dg","MixRecipeProd_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixrecipeprod_dg",{});
    }

    function edit() {
        var rows = $("#mixrecipeprod_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixrecipeprod_dg").datagrid("getRowIndex", rows[i]);
            $("#mixrecipeprod_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixrecipeprod_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixrecipeprod_dg").datagrid("getRowIndex", rows[i]);
            $("#mixrecipeprod_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixrecipeprod_dg");

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
            $("#mixrecipeprod_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixrecipeprod_dg").datagrid("rejectChanges");
    }

     //右上方表格行单击事件   
     function selectrow(){
     
      var rows=$("#mixrecipeprod_dg").datagrid('getSelected');
      var lot_no_s=rows.lot_no_s;  
      //加载子表信息
    	ext.ajax.post("mix/productionManagement/drprodxl/datagrid",{"filter[dummy2_s]":lot_no_s,all:1},function(data){
    		 $('#drprodxl_dg').datagrid('loadData', data);
    	});
    }
    //表格加载前事件
	function dlg1BeforeLoad(param) {
		if ($("#start_time").datebox("getValue") == "") {
			return false;
		}

		param["filter[start_time]"] = $("#start_time").datebox("getValue");
		param["filter[end_time]"] = $("#end_time").datebox("getValue");
		
		if ($("#lot_no_s").textbox("getValue") == "") {
			
		}else{
			param["filter[start_time]"] = null;
			param["filter[end_time]"] = null;
		}
	}
   var equiplist2=[];
	    //加载小料机台信息
     $.ajax({
 		url:"mix/report/mixmonthlyreport/mixmonthlyreport/getMixXLProductionInfo",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			equiplist2=data;
 		}
 	});  
 	
	//小料机台转换
	function equipcodeformatterxl(v,r,i){
		 for(var i=0;i<equiplist2.length;i++){
			 if(v==equiplist2[i].p_line_name){
				 return equiplist2[i].description;
			 }
		 }  
	} ;
    
    	function searchProductionLine(q, row) {
		var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	} 
	 /**
    *将数据库的值转为对应值域
    */
         function warningsgnFormatter(v,r,i){
        if(v==0){
             return "正常";        	 
        }else if(v==1){
       	     return "超差";  
        }else{
       	     return v;
        }
        }
        
        
        function cbrecycletypeFormatter(v,r,i){
        if(v==0){
             return "不回收";        	 
        }else if(v==1){
       	     return "回收";  
        }else{
       	     return v;
        }
   }  
   
         function syncflagFormatter(v,r,i){
        if(v==0){
             return "使用";        	 
        }else if(v==1){
       	     return "不使用";  
        }else{
       	     return v;
        }
   }       
    
    
    
    
    
    
         function ismixedFormatter(v,r,i){
        if(v='Yes'){
             return "掺胶";        	 
        }else if(v='No'){
       	     return "不掺胶";  
        }else{
       	     return v;
        }
   } 
   
        function isuseareatempFormatter(v,r,i){
        if(v==0){
             return "不使用";        	 
        }else if(v==1){
       	     return "使用";  
        }else{
       	     return v;
        }
   } 
   
      function prescriptionstageFormatter(v,r,i){
        if(v='ZC'){
             return "正常";        	 
        }else if(v='SY'){
       	     return "不正常";  
        }else{
       	     return v;
        }
   } 
   
      function cbrecycletypeFormatter(v,r,i){
        if(v==0){
             return "回收";        	 
        }else if(v==1){
       	     return "不回收";  
        }else{
       	     return v;
        }
   } 


      function datasourceFormatter(v,r,i){
        if(v==0){
             return "PLM原数据";        	 
        }else if(v==1){
       	     return "自动生成";  
        }else{
       	     return v;
        }
   } 

      function datasourcetypeFormatter(v,r,i){
        if(v==0){
             return "上辅机配方";        	 
        }else if(v==1){
       	     return "配料系统配方";  
        }else{
       	     return v;
        }
   } 
   
   
         function  dummy1Formatter(v,r,i){
        if(v='TC'){
             return "投产";        	 
        }else if(v='XS'){
       	     return "小试";  
        }else if(v='ZS'){
       	     return "中试";  
        }else if(v='DS'){
       	     return "大试";  
        }else{
       	     return v;
        }
   } 
   
   
        function recordflagFormatter(v,r,i){
        if(v='A'){
             return "可用";        	 
        }else if(v='D'){
       	     return "删除";  
        }else{
       	     return v;
        }
   } 
 
 
   function sendstateFormatter(v,r,i){
        if(v==0){
             return "未下发";        	 
        }else if(v==1){
       	     return "已下发";  
        }else if(v==2){
       	     return "下发失败";  
        }else{
       	     return v;
        }
   }  
 
         function syncflagFormatter(v,r,i){
        if(v='A'){
             return "新增";        	 
        }else if(v='U'){
       	     return "修改";  
        }else if(v='D'){
       	     return "删除";  
        }else{
       	     return v;
        }
   } 
   
        function synchandflagflhandFormatter(v,r,i){
        if(v==0){
             return "未处理";        	 
        }else if(v==1){
       	     return "已处理";  
        }else if(v==2){
       	     return "处理失败";  
        }else{
       	     return v;
        }
   } 
   
   
      function checkstateFormatter(v,r,i){
        if(v==0){
             return "未审核";        	 
        }else if(v==1){
       	     return "已审核";  
        }else{
       	     return v;
        }
   } 
   
  	//获取父物料类型数据字典对应关系
  	var ParentMrpDict = [];
  	ext.ajax.get("common/plm/mixrecipe/getDictFormatter?dictcode=" + "330",
  			function(data) {
  				ParentMrpDict = data;
  			});
  	function parentMrpformatter(v, r, i) {
  		for (var j = 0; j < ParentMrpDict.length; j++) {
  			if (v == ParentMrpDict[j].ERPCODE_S) {
  				return ParentMrpDict[j].DICTNAME_S;
  			}
  		}
  		return v;
  	}
      
      
           /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {

    		return dictFormat(v);
    	}
   
</script>