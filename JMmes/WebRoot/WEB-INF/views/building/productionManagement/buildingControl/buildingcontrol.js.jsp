<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
	
    function showOrHide(){
        $("#BuildingControl_search_form").toggle(500);
    }
 
    function cancel() {
        $("#buildingcontrol_dg").datagrid("rejectChanges");
    }
   
    function intTable(){
    	var machinename_s = $('#machinename_s').val();
    	var machinegroup_s = $('#machinegroup_s').val();
    	var machinestatus_s = $('#machinestatus_s').val();
		$.ajax({
	 		url:"building/productionManagement/buildingControl/searchInit?machinename_s=" + machinename_s
			+ "&machinegroup_s=" + machinegroup_s + "&machinestatus_s="
			+ machinestatus_s,
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(message){
	 			var data = message;
	 			$("#buildingcontrol_dg").datagrid("loadData", data);  
	 		}
	 	});   
	 }
    var columnData=new Array();
    var dataJSON=null;
     $(function(){
    	 $.ajax({
 	 		url:"building/productionManagement/buildingControl/searchBy196",
 	 		type:"get",
 	 		dataType:"text",
 	 		async:false,
 	 		success:function(data){
 	 			dataJSON=JSON.parse(data);
 	 			for(var i=0;i<dataJSON.length;i++){
				var column ={};
				column["title"]=dataJSON[i].DICTNAME;
				column["field"]="A"+dataJSON[i].DICTCODE_S;
				column["formatter"]=showControlStatus3;
				columnData.push(column);
 	 			}
 	 			
 	 		}
 	 	}); 
    	 initTable1();
     });
     
     function initTable1(){
    	 $("#buildingcontrol_dg").datagrid({
    		 fit:true,
             fitColumns:false,
             pagination:true,
             rownumbers: true,
             singleSelect: false,
             toolbar: '#BuildingControl_dg_toolbar,button_area',
             url:'building/productionManagement/buildingControl/searchInit', 
             striped:true,
             method: 'get',
             loadFilter: pagerFilter,//分页用
             emptyMsg: '<span><spring:message code='tip.noData'/></span>',
             frozenColumns :[[
                   {field:'atr_key',title:'ID',checkbox:true,align:'center'},           
                   {field:'MACHINENAME_S',title:'<spring:message code="buildingcontrol.column.machinename_s" />',width:150},
                   {field:'MACHINESTATUS_S',formatter:codeFormatter, 
	                	     options:{
			                 method:'get',
			                 url:'dict/code/101',
			                 required:true},title:'<spring:message code="buildingcontrol.column.machinestatus_s" />',width:80},
		           {field:'MACHINEGROUP_S',formatter:codeFormatter, 
			             options:{
		                 method:'get',
		                 url:'dict/code/320',
		                 required:true},title:'<spring:message code="buildingcontrol.column.machinegroup_s" />',width:80},
		           {field:'CHANGEDBY',title:'<spring:message code="buildingcontrol.column.changedby" />',width:80},
		           {field:'CHANGEDTIME',title:'<spring:message code="buildingcontrol.column.changedtime" />',width:150}
             ]],
             columns:[columnData]
    	 });
    	 intTable();
     }
    //主界面分页用(假分页，先查询页面，再走JS进行分页)
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
 	         },
	 	    onRefresh:function(){
	 	    	dg.datagrid('reload');
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
     function showControlStatus3(value,row,index){
    	 if((value=="1")){
     		return "开启";
     	}else if((value=="0")){
     		return "关闭";
     	}
     }
     
    var onOff = "building/productionManagement/buildingControl/onOff";
    var ids=[];
 	function on_off(dataOn) {
 		var updated = $("#buildingcontrol_dg").datagrid("getSelections");
 		 for(var i=0; i<updated.length; i++){
  			var index=$("#buildingcontrol_dg").datagrid("getRowIndex",updated[i]);
  		   ids.push(index);
  		} 
 		 if(updated.length!=0){
 			ext.ajax.sendJson(onOff, {
 				dataOnOff:dataOn,
 				updated : updated
 			}, function(data) {
 				if(data.message!="ok"){
 					    intTable();
						ext.tip.error(data.message);
						for(var i=0; i<ids.length; i++){
				 		   $('#buildingcontrol_dg').datagrid('selectRow', ids[i]); 
				 		}
						ids=[];
				}else{
					    intTable();
						ext.tip.suc("<spring:message code="tip.success" />");
						for(var i=0; i<ids.length; i++){
				 		   $('#buildingcontrol_dg').datagrid('selectRow', ids[i]); 
				 		}
						ids=[];
				}
 			});
 		}else{
 			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
 		} 
 	}
   
	//打开模态框
	function openWindow(){
		$('#w').window('open');
		$("#usecontrollog_dg").datagrid("reload");
	}
	
		//导出
	    function ExcelExport() {
		    //获取grid 数据
		    var node = $("#buildingcontrol_dg").datagrid("getSelections");
		    console.log(node);
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
		    var title=[{MACHINENAME_S:'机台名称'},
	                   {MACHINESTATUS_S:'机台状态'},
	                   {MACHINEGROUP_S:'机台组'},
	                   {CHANGEDBY:'维护人'},
		               {CHANGEDTIME:'维护时间'}]; 
		    for(var i=0;i<dataJSON.length;i++){
		    	var column ={};
				column["A"+dataJSON[i].DICTCODE_S]=dataJSON[i].DICTNAME;
				title.push(column);
		    }
		    toExcel("成型机台开关控制管理"+time,data,title); 
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
	                    if (ShowLabel[y].hasOwnProperty(k)) {
	                    	 if(k=="MACHINENAME_S"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['MACHINENAME_S']===null? "" : arrData[i]['MACHINENAME_S']) + "</td>";
	                    		 continue;
	                    	 } 
	                    	 if(k=="MACHINESTATUS_S"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['MACHINESTATUS_S']===null? "" : dictFormat(arrData[i]['MACHINESTATUS_S'])) + "</td>";
	                    		 continue;
	                    	 } 
	                    	 if(k=="MACHINEGROUP_S"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['MACHINEGROUP_S']===null? "" : dictFormat(arrData[i]['MACHINEGROUP_S'])) + "</td>";
	                    		 continue;
	                    	 }
	                    	 if(k=="CHANGEDBY"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['CHANGEDBY']===null? "" : arrData[i]['CHANGEDBY']) + "</td>";
	                    		 continue;
	                    	 } 
	                    	 if(k=="CHANGEDTIME"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['CHANGEDTIME']===null? "" : arrData[i]['CHANGEDTIME']) + "</td>";
	                    		 continue;
	                    	 } 
	                         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : showControlStatus3(arrData[i][k])) + "</td>";
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
	        excelFile += "成型机台开关控制管理";  
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
	  
	  
	  
	    var toolbar = []; 
	    $(function () {
		    $.ajax({
	  	 		url:"building/productionManagement/buildingControl/searchFromCoreMenu",
	  	 		type:"get",
	  	 		dataType:"text",
	  	 		async:false,
	  	 		success:function(data){
	  	 			var json=JSON.parse(data);
	  	 			console.log(json)
	  	 			Callback(json);
	  	 			toolbar=json;
	  	 		}
	    	 });
		    LoadButtonInfo(); 
	    });
	    
	    var fullWidth=document.documentElement.clientWidth;
	  //将回调函数中的数据放到Panel的title中
	    function Callback(data) {

	    	var title = "<span class='splitcss'></span><span class='desc'>机台控制开关</span><span class='splitcss'></span>";
	    	var buttons="";
	    	buttons+="<table width: 100%; >";
	    	//第一組
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2==0&&i<Math.floor(fullWidth/182)*2){
	    			buttons += "<td><auth:button code='buildingcontrol.stand-alone_on_1960011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2!=0&&i<Math.floor(fullWidth/182)*2){
	    			buttons += "<td><auth:button code='buildingcontrol.stand-alone_on_1960011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    		}
	    	}
	    	buttons+="</tr>";
	    	//第二組
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2==0&&Math.floor(fullWidth/182)*2<=i&&i<Math.floor(fullWidth/182)*4){
	    			buttons += "<td><auth:button code='buildingcontrol.stand-alone_on_1960011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2!=0&&Math.floor(fullWidth/182)*2<=i&&i<Math.floor(fullWidth/182)*4){
	    			buttons += "<td><auth:button code='buildingcontrol.stand-alone_on_1960011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    		}
	    	}
	    	buttons+="</tr>";
	    	//第三組
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2==0&&Math.floor(fullWidth/182)*4<=i&&i<Math.floor(fullWidth/182)*6){
	    			buttons += "<td><auth:button code='buildingcontrol.stand-alone_on_1960011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2!=0&&Math.floor(fullWidth/182)*4<=i&&i<Math.floor(fullWidth/182)*6){
	    			buttons += "<td><auth:button code='buildingcontrol.stand-alone_on_1960011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    		}
	    	}
	    	buttons+="</tr>";
	    	//第四組(空余量)
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2==0&&Math.floor(fullWidth/182)*6<=i&&i<Math.floor(fullWidth/182)*8){
	    			buttons += "<td><auth:button code='buildingcontrol.stand-alone_on_1960011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2!=0&&Math.floor(fullWidth/182)*6<=i&&i<Math.floor(fullWidth/182)*8){
	    			buttons += "<td><auth:button code='buildingcontrol.stand-alone_on_1960011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="</table>";
	    	//加载Panel
	    	$("#button_area").panel({
	    		title:title,
	    		content:buttons,
	    		minHeight:"10px",
	    		collapsible: 'true'
	    	});
	    }
	  
	  //在Panel的title属性中渲染linkbutton按钮
	    function LoadButtonInfo() {
	    	$.each(toolbar, function (i, item) {
    			//加载按钮属性
	    		if(item.CODE.substring(item.CODE.length-1)=="0"){
		    		$("#button_area").panel('body').find('a.panel_' + item.PINYININDEX + '').linkbutton({
		    		iconCls: 'icon-remove',
		    		text: item.NAME,
			    	});
	    		}else{
		    		$("#button_area").panel('body').find('a.panel_' + item.PINYININDEX + '').linkbutton({
		    		iconCls: 'icon-add',
		    		text: item.NAME,
		    		
			    	});
	    		}
	    		
		    	$('#' + item.PINYININDEX + '').bind('click', function () {
		    		on_off(item.CODE.substring(item.CODE.length-7));
		    	});
	    	});
	    }
	  
	  //设定时间初始值从当前时间00:00:00至23:59:59
		$(document).ready(function() {
			$('#begin_created_time').datetimebox({
				value : '3/4/2010 00:00:00',
				required : true,
				showSeconds : true
			});
			$('#end_created_time').datetimebox({
				value : '3/4/2010 23:59:59',
				required : true,
				showSeconds : true
			});
			filter();
		});
	  
		/**
	     * 查询方法
	     */
	    function filter(){
	    	var opts = $("#usecontrollog_dg").datagrid("options");
			opts.url = 'building/productionManagement/buildingControl/searchByModal';
	        ext.easyui.grid.search("usecontrollog_dg","Usecontrollog_search_form");
	    }
	  
</script>