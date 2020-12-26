<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
		 function codeFormatter(v,r,i){
		    	
		    	return dictFormat(v);
		    }
		     var sysmptom;
		    function operatorFormatter(v, r, i){
		     for(var i=0; i<sysmptom.length;i++)
		     {
		    if( v==sysmptom[i].REAS_CODE_S)
		    {
		    return sysmptom[i].REAS_CN_S;
		    }
		   if(i==sysmptom.length-1){
		   return v;}
		 
		     }
		    
		    }
		    
 
   //病象描述
     function sysmptom1(){
 		
 		var url='finalcheck/statistatement/statistatement/searchcode';
 		
 		
 	    	$.ajax({
 	    		url:url,
 	    		type:'get',
 	    		dataType:'json',
 	    		async:false,
 	    		
 	    		success:function(data){
 	    		 sysmptom=data;	
 				}
 	    	});
 	    	
 		}
	 	
    function queryBar() {
		$("#EntDetial_dg_toolbar").toggle(500);
	}
	
	
	 var filter=function(){
	sysmptom1();
	 var line = $('#huizong_s').checkbox('options').checked;
    	var material = $('#xiangxi_s').checkbox('options').checked;
    	//汇总
    	if(line == true && material == false){
           var opts = $("#detial_dg").datagrid("options");
 		opts.url = 'finalcheck/statistatement/statistatement/datagrid';
    	var starttime =$("#start_opertime_t").datetimebox("getValue");
    	var endtime=$("#end_opertime_t").datetimebox("getValue");
    	if((starttime!=""&&endtime=="")||(starttime==""&&endtime!="")){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			ext.easyui.grid.search("detial_dg","Detial_search_form");
    		}
    	}else{
    		ext.easyui.grid.search("detial_dg","Detial_search_form");
    	}
    		$('#detial_dg').datagrid({ 
    			columns:[[
                	{field:'atr_key',checkbox:true},
                    {field:'itemid_s',title:'物料编码',width:90},
                    {field:'materialdesc_s',title:'物料规格',width:270},
                    {field:'gradecd_s',title:'等级',formatter:codeFormatter,url:'dict/code/253',width:90},
                    {field:'reascd_s',title:'病象描述',formatter:operatorFormatter,width:90},
                    {field:'proess_s',title:'病象类',formatter:levFormatter,width:90},
                    {field:'num',title:'数量',width:90}
                ]]
            });
    	}
    	//详细
    	if(line == false && material == true){
            var opts = $("#detial_dg").datagrid("options");
 		opts.url = 'finalcheck/statistatement/statistatement/datagrid1';
    	var starttime =$("#start_opertime_t").datetimebox("getValue");
    	var endtime=$("#end_opertime_t").datetimebox("getValue");
    	if((starttime!=""&&endtime=="")||(starttime==""&&endtime!="")){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			ext.easyui.grid.search("detial_dg","Detial_search_form");
    		}
    	}else{
    		ext.easyui.grid.search("detial_dg","Detial_search_form");
    	}
    		$('#detial_dg').datagrid({ 
    			columns:[[
                	{field:'atr_key',checkbox:true},
                	{field:'barcode_s',title:'轮胎条码',width:90},
                    {field:'itemid_s',title:'物料编码',width:90},
                    {field:'materialdesc_s',title:'物料规格',width:270},
                    {field:'gradecd_s',title:'等级',formatter:codeFormatter,url:'dict/code/253',width:90},
                    {field:'reascd_s',title:'病象描述',formatter:operatorFormatter,width:90},
                    {field:'proess_s',title:'病象类',formatter:levFormatter,width:90},
                   
                ]]
            });
    	}
	if(line == false && material == false) {
    		ext.tip.error("选择项不能为空");
    	}
    };
    /**
     * 查询方法
     */
     function doSearch(){
    	var opts = $("#detial_dg").datagrid("options");
 		opts.url = 'finalcheck/statistatement/statistatement/datagrid';
    	var starttime =$("#start_opertime_t").datetimebox("getValue");
    	var endtime=$("#end_opertime_t").datetimebox("getValue");
    	if((starttime!=""&&endtime=="")||(starttime==""&&endtime!="")){
    		ext.tip.error("时间输入范围不完整");
    		return;
    	}
    	if(starttime!="" && endtime!=""){
    		if(starttime>endtime){
    			ext.tip.error("<spring:message code="tip.date" />");
    		}else{
    			ext.easyui.grid.search("detial_dg","Detial_search_form");
    		}
    	}else{
    		ext.easyui.grid.search("detial_dg","Detial_search_form");
    	}
 		
 	}
    
     function levFormatter(v,r,i){
     	if(v=='252008')
     		return '外观病象';
     	
     	else
     		return 'X光病象';
     }
     
    /*  //病象描述
     function operatorFormatter(v, r, i){
 		if(v == "") {
 			return "";
 		}
 		var row=$("#detial_dg").datagrid("getData").rows[i];
 		var url='finalcheck/statistatement/statistatement/searchUsercode';
 		
 		
 	    	$.ajax({
 	    		url:url,
 	    		type:'get',
 	    		dataType:'json',
 	    		async:false,
 	    		data: {
 	    		    reas_code: v
 	    		},
 	    		success:function(data){
 	    		 	if(data.length > 0) {
 					    v = data[0].reas_cn_s;
 				    }
 				}
 	    	});
 	    	return v;
 		} */
 	
     /* 获取参数类型 
    /*  var basetypesList=[];
   	$.ajax({
	        url:'finalcheck/statistatement/statistatement/searchUsercode',
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
    *
    function operatorFormatter(v, r, i){
         for(var i=0;i<basetypesList.length;i++){
            if (v == basetypesList[i].REAS_CODE_S) {
                return basetypesList[i].REAS_CN_S;
            }
          }
    } 
    
    
    
    
    
    
     */
    
    
   //设定时间初始值从当前时间00:00:00至23:59:59
 	$(document).ready(function() {
 		$('#start_opertime_t').datetimebox({
 			value : '3/4/2010 00:00:00',
 			required : true,
 			showSeconds : true
 		});
 		$('#end_opertime_t').datetimebox({
 			value : '3/4/2010 23:59:59',
 			required : true,
 			showSeconds : true
 		});
 		symptom1();
 		//doSearch();
 	});
   
 	/*  function exportExcel() {
 	    //获取grid 数据
 	    var node = $("#detial_dg").datagrid("getSelections");
     	if (node == "") {
 			ext.tip.error("<spring:message code="tip.excel" />");
 			return;	
 		}
     	 var data = JSON.stringify(node);
 	    if (data == '')
 	        return;
 	    var myDate = new Date();
 	    var time=myDate.toLocaleString( );
 	   var  title=[{itemid_s:'品号'},{materialdesc_s:'规格名称'},{gradecd_s:'等级'},{reascd_s:'病象描述'},{proess_s:'病象类描述'},{num:'数量'}
       ];
 	 /*  for(var i=0;i<dataJSON.length;i++){
	    	var column ={};
			column["A"+dataJSON[i].REAS_CODE_S]=dataJSON[i].REAS_CN_S;
			title.push(column);
	    } 
 	    toExcel("质检统计报表"+time,data,title); 
 	
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
                     	
                     	 if(k=="gradecd_s"){
                    		     rowData+="<td style='vnd.ms-excel.numberformat:@'>" + dictFormat(arrData[i]['gradecd_s']) + "</td>";
                    		     continue;
                    	     }  
                		 if(k=="reascd_s"){
                		     rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['reascd_s']) + "</td>";
                		     continue;
                	     }  
                     	 if(k=="proess_s"){
                     		if(arrData[i][k]==="252008"){
                   			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('外观病象') + "</td>";
                     		}else{
                   			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('X光病象') + "</td>";
                   			 }
                		     continue;
                	     }  
                     	 
                     	 if(k=="max_weight_s"){
                     		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.round((arrData[i]['building_weight_s'] * valueMax)*1000)/1000 + "</td>";
                     		 continue;
                     	 }
                     	 if(k=="min_weight_s"){
                     		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.round((arrData[i]['building_weight_s'] * valueMax)*1000)/1000 + "</td>";
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
         excelFile += "质检统计报表";  
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
     }  */

</script>