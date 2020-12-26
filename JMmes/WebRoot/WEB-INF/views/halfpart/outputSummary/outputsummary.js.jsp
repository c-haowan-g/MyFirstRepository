<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/outputSummary/saveChanges";
    
    function showOrHide(){
        if($("#OutputSummary_search_form").is(":hidden")){
            $("#OutputSummary_search_form").show();
        }else{
            $("#OutputSummary_search_form").hide();
        }
    }
    
    //隐藏显示查询栏
    function queryBar(){
    	$("#OutputSummary_search_form").toggle(500);
    }
  //基础数据text显示
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}
  /*   //导出
	function exportExcel(){
		var s_factory_s = getQueryString("factory");
		var sumFlag = $('input[name="sumFlag"]:checked').val();
		var url = "halfpart/outputSummary/export?sumFlag="+sumFlag+"&s_factory_s="+s_factory_s;
		window.location.href=url;
	} */
    
    //设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
		$('#start_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$('#end_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		var sumFlag = $('input[name="sumFlag"]:checked').val();
		var opts = $("#outputsummary_dg").datagrid("options");
		opts.url ="halfpart/outputSummary/search?sumFlag="+sumFlag;
    	ext.easyui.grid.search("outputsummary_dg","OutputSummary_search_form");
		
	});
	
    /**
     * 查询方法
     */
     function filter(){
     	var starttime =$("#start_time").datetimebox("getValue");
     	var endtime=$("#end_time").datetimebox("getValue");
     	var sumFlag = $('input[name="sumFlag"]:checked').val();
     	if(starttime!="" && endtime!=""){
     		if(starttime>endtime){
     			ext.tip.error("<spring:message code="tip.date" />");
     		}else{
     			$("#outputsummary_dg").datagrid("options").url="halfpart/outputSummary/search?sumFlag="+sumFlag;
     			ext.easyui.grid.search("outputsummary_dg","OutputSummary_search_form");
     		}
     	}else{
     		$("#outputsummary_dg").datagrid("options").url="halfpart/outputSummary/search?sumFlag="+sumFlag;
     		ext.easyui.grid.search("outputsummary_dg","OutputSummary_search_form");
     	}
    }
    
    function filter_1(){
    	var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	var sumFlag = $('input[name="sumFlag"]:checked').val();
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			$("#outputsummary_dg").datagrid("options").url="halfpart/outputSummary/search_1?sumFlag="+sumFlag;
    			ext.easyui.grid.search("outputsummary_dg","OutputSummary_search_form");
    		}
    	}else{
    		$("#outputsummary_dg").datagrid("options").url="halfpart/outputSummary/search_1?sumFlag="+sumFlag;
    	    ext.easyui.grid.search("outputsummary_dg","OutputSummary_search_form");
    	}
    };
    
    //获取url上的参数
	function getQueryString(name) {
	    var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
	    if (result == null || result.length < 1) {
	        return "";
	    }
	    return result[1];
	}
    
    function add() {
        ext.easyui.grid.appendAndEdit("outputsummary_dg",{});
    }

    function edit() {
        var rows = $("#outputsummary_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#outputsummary_dg").datagrid("getRowIndex", rows[i]);
            $("#outputsummary_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#outputsummary_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#outputsummary_dg").datagrid("getRowIndex", rows[i]);
            $("#outputsummary_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#outputsummary_dg");
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
            $("#outputsummary_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />");

        });
    }

    function cancel() {
        $("#outputsummary_dg").datagrid("rejectChanges");
    }
    
    function getData(){
    	var starttime =$("#start_time").datetimebox("getValue");
    	var endtime=$("#end_time").datetimebox("getValue");
    	//var sumFlag = $('input[name="sumFlag"]:checked').val();
    	var checked=$('input[type=checkbox]:checked');
        if('undefined'==typeof(checked.val())){
          	ext.tip.error("<spring:message code="tip.noSelect" />");
          	return;
        }
    	var sumFlag=new Array();
        $.each(checked,function(){
        	sumFlag.push($(this).val());
        });
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
				var selectfieldarray=new Array();
		    	var unselectfieldarray=new Array();
		    	if($("#machinecode_s").is(":checked")){
		    		selectfieldarray.push('machinecode_s');
		    		selectfieldarray.push('machinename_s');
		    		
		    	}else{
		    	    unselectfieldarray.push('machinecode_s');
		    	    unselectfieldarray.push('machinename_s');
		    	    
		    	}
		    	if($("#materialcode_s").is(":checked")){
		    		selectfieldarray.push('materialcode_s');
		    		selectfieldarray.push('materialname_s');
		    	}else{
		    	    unselectfieldarray.push('materialcode_s');
		    	    unselectfieldarray.push('materialname_s');
		    	}
		    	if($("#outclass_s").is(":checked")){
			    	  selectfieldarray.push('outclass_s');
			    }else{
			    	   unselectfieldarray.push('outclass_s');
			    }
		    	/* if($("#operator1_s").is(":checked")){
			    	  selectfieldarray.push('operator1_s');
			    }else{
			    	   unselectfieldarray.push('operator1_s');
			    } */
		    	$.each(selectfieldarray, function(i, val){  
                     $('#outputsummary_dg').datagrid('showColumn',val);
				  }); 
			    $.each(unselectfieldarray, function(i, val){  
		    	    $('#outputsummary_dg').datagrid('hideColumn',val);
			    }); 
    			$("#outputsummary_dg").datagrid("options").url="halfpart/outputSummary/filter?sumFlag="+sumFlag;
    			ext.easyui.grid.search("outputsummary_dg","OutputSummary_search_form");
    		}
    	}else{
    		$("#outputsummary_dg").datagrid("options").url="halfpart/outputSummary/filter?sumFlag="+sumFlag;
    	    ext.easyui.grid.search("outputsummary_dg","OutputSummary_search_form");
    	}
    };
    
    function exportExcel() {
	    //获取grid 数据
	    var node = $("#outputsummary_dg").datagrid("getSelections");
    	if (node == "") {
			ext.tip.error("<spring:message code="tip.excel" />");
			return;	
		}
    	//debugger;
	    var data = JSON.stringify(node);
	    if (data == '')
	        return;
	    var myDate = new Date();
	    var time=myDate.toLocaleString( );
	    if($("#machinecode_s").is(":checked")){
	    	 var title=[{machinecode_s:'机台条码'},
	 	               {machinename_s:'机台名称'},
	 	              {outnum_f:'产出总量'},
	 	              {amount_i:'汇总量'}]; 
	    	
	    }
	     if($("#materialcode_s").is(":checked")){
	    	 var title=[
	                    {materialcode_s:'物料编码'},
	 	               {materialname_s:'物料名称'},
	 	              {outnum_f:'产出总量'},
	 	               {amount_i:'汇总量'}];
	    	
	    }
	    if($("#outclass_s").is(":checked")){
	    	 var title=[
	 	               {outclass_s:'产出班次'},
	 	              {outnum_f:'产出总量'},
	 	               {amount_i:'汇总量'}];
	    	
	    }
	    if(($("#machinecode_s").is(":checked"))&&($("#materialcode_s").is(":checked"))){
	    	var title=[{machinecode_s:'机台条码'},
		               {machinename_s:'机台名称'},
	                   {materialcode_s:'物料编码'},
		               {materialname_s:'物料名称'},
		               {outnum_f:'产出总量'},
		               {amount_i:'汇总量'}];
	    	
	    }
	    if(($("#machinecode_s").is(":checked"))&&($("#outclass_s").is(":checked"))){
	    	var title=[{machinecode_s:'机台条码'},
		               {machinename_s:'机台名称'},
		               {outclass_s:'产出班次'},
		               {outnum_f:'产出总量'},
		               {amount_i:'汇总量'}];
	    	
	    }
	    if(($("#materialcode_s").is(":checked"))&&($("#outclass_s").is(":checked"))){
	    	var title=[
	                   {materialcode_s:'物料编码'},
		               {materialname_s:'物料名称'},
		               {outclass_s:'产出班次'},
		               {outnum_f:'产出总量'},
		               {amount_i:'汇总量'}];
	    	
	    }
	    if(($("#materialcode_s").is(":checked"))&&($("#outclass_s").is(":checked"))
	    		&&($("#machinecode_s").is(":checked"))){
	    	   var title=[{machinecode_s:'机台条码'},
            {machinename_s:'机台名称'},
            {materialcode_s:'物料编码'},
            {materialname_s:'物料名称'},
            {outclass_s:'产出班次'},
            {amount_i:'汇总量'},
            {outnum_f:'产出总量'}]; 
	    	   
	    	
	    }
	 
	    toExcel("半部件产量汇总查询"+time,data,title); 
	}
    //FileName 生成的Excel文件名称
    function toExcel(FileName, JSONData, ShowLabel) {  
        //先转化json  
        var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;  
        var excel = '<table>';      
        //设置表头  
        var row = "<tr align='left'>";//设置Excel的左居中
        for (var i = 0, l = ShowLabel.length; i < l; i++) {  
            for (var key in ShowLabel[i]) {
                row += "<td style='font-weight:bold;font-size:17px;border-bottom:1px solid black;'>" + ShowLabel[i][key] + '</td>';  
            }
        }
        //换行  
        excel += row + "</tr>";  
          
        //设置数据  
        for (var i = 0; i < arrData.length; i++) {  
            var rowData = "<tr align='left'>"; 

            for (var y = 0; y < ShowLabel.length; y++) {
                for(var k in ShowLabel[y]){
                	//alert(arrData[i]['CONTROLSTATUS_S']);
                    if (ShowLabel[y].hasOwnProperty(k)) {
                    	
                    	 if(k=="outclass_s"){
                   		     rowData+="<td style='vnd.ms-excel.numberformat:@'>" + dictFormat(arrData[i]['outclass_s']) + "</td>";
                   		     continue;
                   	     } 
                    	/*  if(k=="max_weight_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.round((arrData[i]['building_weight_s'] * valueMax)*1000)/1000 + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="min_weight_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.round((arrData[i]['building_weight_s'] * valueMax)*1000)/1000 + "</td>";
                    		 continue;
                    	 } */
                         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : arrData[i][k]) + "</td>";
                         //vnd.ms-excel.numberformat:@ 输出为文本
                    }
                }
            }
            excel += rowData + "</tr>";  
        }  
        excel += "</table>";  

        var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";  
        excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';  
        excelFile += '<meta http-equiv="content-type" content="application/vnd.ms-excel';  
        excelFile += '; charset=UTF-8">';  
        excelFile += "<head>";  
        excelFile += "<!--[if gte mso 9]>";  
        excelFile += "<xml>";  
        excelFile += "<x:ExcelWorkbook>";  
        excelFile += "<x:ExcelWorksheets>";  
        excelFile += "<x:ExcelWorksheet>";  
        excelFile += "<x:Name>";  
        excelFile += "半部件产量汇总查询";  
        excelFile += "</x:Name>";  
        excelFile += "<x:WorksheetOptions>";  
        excelFile += "<x:DisplayGridlines/>";  
        excelFile += "</x:WorksheetOptions>";  
        excelFile += "</x:ExcelWorksheet>";  
        excelFile += "</x:ExcelWorksheets>";  
        excelFile += "</x:ExcelWorkbook>";  
        excelFile += "</xml>";  
        excelFile += "<![endif]-->";  
        excelFile += "</head>";  
        excelFile += "<body>";  
        excelFile += excel;  
        excelFile += "</body>";  
        excelFile += "</html>";  

        var uri = 'data:application/vnd.ms-excel;charset=utf-8,' + encodeURIComponent(excelFile);  
        var link = document.createElement("a");      
        link.href = uri;  
          
        link.style = "visibility:hidden";  
        link.download = FileName + ".xls";  
          
        document.body.appendChild(link);  
        link.click();  
        document.body.removeChild(link);  
    } 
</script>