<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"/halfpart/stockmanagement/ledger/saveChanges";
    
    function showOrHide(){
        if($("#Ledger_search_form").is(":hidden")){
            $("#Ledger_search_form").show();
        }else{
            $("#Ledger_search_form").hide();
        }
    }
    /**
     * 获取半部件用物料信息
     */
     var materialList=[];
     $.ajax({
         url:"sap/materials/getMaterialList",
         type:"get",
         dataType:"json",
         async:false,
         success:function(data){
         	materialList=data;
         }
         });
     var productLineList=[];
     $.ajax({
         url:"halfpart/basedata/productlinemanager/getHalfPartProductionLine",
         type:"get",
         dataType:"json",
         async:false,
         success:function(data){
         	productLineList=data;
         }
         });
  	

     var qualityStatus=[];
     $.ajax({
  			url:'dict/code/106',
  			type : "get",
  			dataType : "json",
  			async:false,
  			success : function(data){
  				qualityStatus=data;
  			}
     });
     function qualityStatusFormatter(v, r, i){
         for(var i=0;i<qualityStatus.length;i++){
            if (v == qualityStatus[i].code) {
                return qualityStatus[i].text;
            }
          }
    };
    
    var storageType=[];
    $.ajax({
			url:'dict/code/227',
			type : "get",
			dataType : "json",
			async:false,
			success : function(data){
				storageType=data;
			}
    });
    function storageTypeFormatter(v, r, i){
        for(var i=0;i<storageType.length;i++){
           if (v == storageType[i].code) {
               return storageType[i].text;
           }
         }
   };
    /**
     * 查询方法
     */
     function filter(){
     	$("#ledger_dg").datagrid('options').pageNumber=1;//重置pageNumber
     	$("#ledger_dg").datagrid('getPager').pagination('refresh', {pageNumber: 1});
     	var sortname ="";
     	sortname=$("#ledger_dg").datagrid('options').sortName;
     	var sortorder="";
     	sortorder=$("#ledger_dg").datagrid('options').sortOrder;
     	
     	var equip_code_s=$('#equip_code_s_s').combobox("getValue");
     	var equipdescription_s=$("#equipdescription_s_s").combobox("getValue");
     	var location_s=$('#location_s_s').textbox("getValue");
     	var materielcode_s=$('#materielcode_s_s').combobox("getValue");
     	var materielname_s=$('#materielname_s_s').combobox("getValue");
     	var queryCondition = new Array();
     	queryCondition={equip_code_s:equip_code_s,equipdescription_s:equipdescription_s,location_s:location_s,materielcode_s:materielcode_s,materielname_s:materielname_s,sortname:sortname,sortorder:sortorder};
     	var checked=$('input[type=checkbox]:checked');
         if('undefined'==typeof(checked.val())){
           	ext.tip.error("<spring:message code="tip.noSelect" />");
           	return;
         }
         var summaryCondition=new Array();
         $.each(checked,function(){
         	summaryCondition.push($(this).val());
         });
         $.ajax({
              url:'halfpart/stockmanagement/ledger/getSummaryInfo',
              type : "GET",
              data : {"queryCondition":JSON.stringify(queryCondition),"summaryCondition":summaryCondition},
 			 dataType : "json",
 			 contentType:'application/json',
   	 		 async:false,
   	 		 traditional:true,
   	 		 success : function(data) {
 				if(data.code==OK){
 					var selectfieldarray=new Array();
 			    	var unselectfieldarray=new Array();
 			    	if($("#barcode_s").is(":checked")){
 			    		selectfieldarray.push('barcode_s');
 			    	}else{
 			    	    unselectfieldarray.push('barcode_s');
 			    	}
 			    	if($("#vehicles_code_s").is(":checked")){
 			    		selectfieldarray.push('vehicles_code_s');
 			    	}else{
 			    	    unselectfieldarray.push('vehicles_code_s');
 			    	}
 			    	if($("#materielcode_s").is(":checked")){
 				    	  selectfieldarray.push('materielcode_s');
 				    }else{
 				    	   unselectfieldarray.push('materielcode_s');
 				    }
 			    	if($("#materielname_s").is(":checked")){
 				    	  selectfieldarray.push('materielname_s');
 				    }else{
 				    	   unselectfieldarray.push('materielname_s');
 				    }
 			    	if($("#quality_status_s").is(":checked")){
 			    		selectfieldarray.push('quality_status_s');
 			    	}else{
 			    	    unselectfieldarray.push('quality_status_s');
 			    	}
 			    	if($("#equip_code_s").is(":checked")){
 			    		selectfieldarray.push('equip_code_s');
 			    	}else{
 			    	    unselectfieldarray.push('equip_code_s');
 			    	}
 			    	if($("#equipdescription_s").is(":checked")){
 			    		selectfieldarray.push('equipdescription_s');
 			    	}else{
 			    	    unselectfieldarray.push('equipdescription_s');
 			    	}
 			    	if($("#mainoperator_s").is(":checked")){
 			    		selectfieldarray.push('mainoperator_s');
 			    	}else{
 			    	    unselectfieldarray.push('mainoperator_s');
 			    	}
 			    	if($("#location_s").is(":checked")){
 			    		selectfieldarray.push('location_s');
 			    	}else{
 			    	    unselectfieldarray.push('location_s');
 			    	}
 			    	if($("#productiondate_t").is(":checked")){
 			    		selectfieldarray.push('productiondate_t');
 			    	}else{
 			    	    unselectfieldarray.push('productiondate_t');
 			    	}
 			    	if($("#outputtime_t").is(":checked")){
 			    		selectfieldarray.push('outputtime_t');
 			    	}else{
 			    	    unselectfieldarray.push('outputtime_t');
 			    	}
 			    	if($("#stocktype_s").is(":checked")){
 			    		selectfieldarray.push('stocktype_s');
 			    	}else{
 			    	    unselectfieldarray.push('stocktype_s');
 			    	}
 			    	$.each(selectfieldarray, function(i, val){  
 	                     $('#ledger_dg').datagrid('showColumn',val);
 					  }); 
 				    $.each(unselectfieldarray, function(i, val){  
 			    	    $('#ledger_dg').datagrid('hideColumn',val);
 				    }); 
 				    $("#ledger_dg").datagrid("loadData", data.data);
 				    summaryInfo=data.data;
 				    return;
 				  }
 			}
         }); 
     }
     function pagerFilter(data) {
         if (typeof data.length == 'number' && typeof data.splice == 'function') {   // is array
             data = {
                 total: data.length,
                 rows: data
             }
         }
         var dg = $(this);
         var opts = dg.datagrid('options');
         var pager = dg.datagrid('getPager');
         pager.pagination({
             onSelectPage: function (pageNumber,pageSize) {
                 opts.pageNumber = pageNumber;
                 opts.pageSize = pageSize;
                 pager.pagination('refresh', {
                     pageNumber: pageNumber,
                     pageSize: pageSize
                 });
                 dg.datagrid('loadData', data);
             }
         });
         if (!data.originalRows) {
             data.originalRows = (data.rows);
         } 
         var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
         var end = start + parseInt(opts.pageSize);
         data.rows = (data.originalRows.slice(start, end));
         return data;
     }
     
     
     //导出方法
     function ExcelExport() {
    	 
	    //获取grid 数据
	    var node = $("#ledger_dg").datagrid("getSelections");
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
	    var title=[{materielcode_s:'物料编码'},{materielname_s:'物料名称'},{stocktype_s:'库存类型'},{current_num_f:'当前汇总量'}]; 
	    toExcel("半部件库存结果汇总"+time,data,title);
	    //outCsv(data, "硫化结果汇总"+time, true);
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
                row += "<td>" + ShowLabel[i][key] + '</td>';  
            }
        }
        //换行  
        excel += row + "</tr>";  
          
        //设置数据  
        for (var i = 0; i < arrData.length; i++) {  
            var rowData = "<tr align='left'>"; 

            for (var y = 0; y < ShowLabel.length; y++) {
                for(var k in ShowLabel[y]){
                    if (ShowLabel[y].hasOwnProperty(k)) {
                     if(k=="stocktype_s"){
	                     rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['stocktype_s']===null? "" : dictFormat(arrData[i]['stocktype_s'])) + "</td>";
	                     continue;
	                  } 
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
        excelFile += "{worksheet}";  
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
	 
    function codeFormatter(v, r, i) {
		return dictFormat(v);
    }
  
  
   
    
</script>