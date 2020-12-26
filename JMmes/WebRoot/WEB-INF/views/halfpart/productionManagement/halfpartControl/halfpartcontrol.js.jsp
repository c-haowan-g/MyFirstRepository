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
        if($("#HalfpartControl_search_form").is(":hidden")){
            $("#HalfpartControl_search_form").show();
        }else{
            $("#HalfpartControl_search_form").hide();
        }
    }
 
    function cancel() {
        $("#halfpartcontrol_dg").datagrid("rejectChanges");
    }
   
    function intTable(){
    	var machinecode_s = $('#machinecode_s').val();
    	var machinetype_s = $('#machinetype_s').val();
    	var machinestatus_s = $('#machinestatus_s').val();
		$.ajax({
	 		url:"halfpart/productionManagement/halfpartControl/searchInit?machinecode_s=" + machinecode_s
			+ "&machinetype_s=" + machinetype_s + "&machinestatus_s="
			+ machinestatus_s,
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(message){
	 			var data = message;
	 			$("#halfpartcontrol_dg").datagrid("loadData", data);  
	 		}
	 	});   
	 }
    var columnData=new Array();
    var dataJSON=null;
     $(function(){
    	 $.ajax({
 	 		url:"halfpart/productionManagement/halfpartControl/searchBy119",
 	 		type:"get",
 	 		dataType:"text",
 	 		async:false,
 	 		success:function(data){
 	 			dataJSON=JSON.parse(data);
 	 			for(var i=0;i<dataJSON.length;i++){
					var column ={};
					column["title"]=dataJSON[i].DICTNAME;
					column["field"]="A"+dataJSON[i].DICTCODE_S;
					column["formatter"]=showControlStatus;
					columnData.push(column);
 	 			}
 	 		}
 	 	}); 
    	 initTable1();
     });
     
     function initTable1(){
    	 $("#halfpartcontrol_dg").datagrid({
    		 fit:true,
             fitColumns:false,
             //pagination:true,
             rownumbers: true,
             singleSelect: false,
             toolbar: '#HalfpartControl_dg_toolbar,button_area',
             url:'halfpart/productionManagement/halfpartControl/searchInit', 
             striped:true,
             method: 'get',
             emptyMsg: '<span><spring:message code='tip.noData'/></span>',
             frozenColumns :[[
                   {field:'atr_key',title:'ID',checkbox:true,align:'center'},           
                   {field:'MACHINECODE_S',title:'<spring:message code="machinecontrol.column.machinecode_s" />',width:80},
                   {field:'MACHINETYPE_S',formatter:codeFormatter, 
	                	     options:{
			                 method:'get',
			                 url:'dict/code/211',
			                 required:true},title:'<spring:message code="machinecontrol.column.machinetype_s" />',width:80},
		           {field:'MACHINESTATUS_S',formatter:codeFormatter, 
			             options:{
		                 method:'get',
		                 url:'dict/code/101',
		                 required:true},title:'<spring:message code="machinecontrol.column.isused_s" />',width:80},
		           {field:'PROCESS_S',formatter:codeFormatter, 
				             options:{
			                 method:'get',
			                 url:'dict/code/252',
			                 required:true},title:'<spring:message code="machinecontrol.column.plant_s" />',width:80},
		           {field:'CHANGEDBY',title:'<spring:message code="machinecontrol.column.changedby" />',width:80},
		           {field:'CHANGEDTIME',title:'<spring:message code="machinecontrol.column.changedtime" />',width:150}
             ]],
             columns:[columnData]
    	 });
    	 intTable();
     }
     
     function showControlStatus(value,row,index){
    	 if((value=="1")){
     		return "受控";
     	}else if((value=="0")){
     		return "不受控";
     	}
     }
     
   //打开模态框
 	function openWindow(){
 		$('#w').window('open');
 		$("#usecontrollog_dg").datagrid("reload");
 	}
   
    var onOff = "halfpart/productionManagement/halfpartControl/onOff";
    var ids=[];
 	function on_off(dataOn) {
 		var updated = $("#halfpartcontrol_dg").datagrid("getSelections");
 		 for(var i=0; i<updated.length; i++){
 			var index=$("#halfpartcontrol_dg").datagrid("getRowIndex",updated[i]);
 		   ids.push(index);
 		} 
 		 log(ids);
 		 if(updated.length!=0){
 			ext.ajax.sendJson(onOff, {
 				dataOnOff:dataOn,
 				updated : updated
 			}, function(data) {
 				if(data.message!="ok"){
						$("#halfpartcontrol_dg").datagrid("reload");
						ext.tip.error(data.message);
						for(var i=0; i<ids.length; i++){
				 		   $('#halfpartcontrol_dg').datagrid('selectRow', ids[i]); 
				 		}
						ids=[];
				}else{
					intTable();
					ext.tip.suc("<spring:message code="tip.success" />");
					for(var i=0; i<ids.length; i++){
			 		   $('#halfpartcontrol_dg').datagrid('selectRow', ids[i]); 
			 		}
					ids=[];
				}
 			});
 		}else{
 			ext.tip.error("<spring:message code="tip.atLeastOneSelected" />");
 		} 
 	}
   
	
 	
		//导出
	    function ExcelExport() {
		    //获取grid 数据
		    var node = $("#halfpartcontrol_dg").datagrid("getSelections");
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
		    var title=[{MACHINECODE_S:'机台条码'},
	                   {MACHINETYPE_S:'机台类型'},
	                   {MACHINESTATUS_S:'机台状态'},
	                   {PROCESS_S:'所属工序'},
	                   {CHANGEDBY:'维护人'},
		               {CHANGEDTIME:'维护时间'}]; 
		    for(var i=0;i<dataJSON.length;i++){
		    	var column ={};
				column["A"+dataJSON[i].DICTCODE_S]=dataJSON[i].DICTNAME;
				title.push(column);
		    }
		    toExcel("半部件机台控制管理"+time,data,title); 
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
	                    	 if(k=="MACHINECODE_S"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['MACHINECODE_S']===null? "" : arrData[i]['MACHINECODE_S']) + "</td>";
	                    		 continue;
	                    	 } 
	                    	 if(k=="MACHINETYPE_S"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['MACHINETYPE_S']===null? "" : dictFormat(arrData[i]['MACHINETYPE_S'])) + "</td>";
	                    		 continue;
	                    	 } 
	                    	 if(k=="MACHINESTATUS_S"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['MACHINESTATUS_S']===null? "" : dictFormat(arrData[i]['MACHINESTATUS_S'])) + "</td>";
	                    		 continue;
	                    	 }
	                    	 if(k=="PROCESS_S"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['PROCESS_S']===null? "" : dictFormat(arrData[i]['PROCESS_S'])) + "</td>";
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
	                         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : showControlStatus(arrData[i][k])) + "</td>";
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
	        excelFile += "半部件机台控制管理";  
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
	  	 		url:"halfpart/productionManagement/halfpartControl/searchFromCoreMenu",
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
	  //检测屏幕自适应宽度
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
	    			if(factory=="1"){
	    		       buttons += "<td><auth:button code='Halfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}else{
	    		       buttons += "<td><auth:button code='BGHalfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2!=0&&i<Math.floor(fullWidth/182)*2){
	    			if(factory=="1"){
     	    			buttons += "<td><auth:button code='Halfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}else{
     	    			buttons += "<td><auth:button code='BGHalfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}
	    		}
	    	}
	    	buttons+="</tr>";
	    	//第二組
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2==0&&Math.floor(fullWidth/182)*2<=i&&i<Math.floor(fullWidth/182)*4){
	    			if(factory=="1"){
     	    			buttons += "<td><auth:button code='Halfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}else{
     	    			buttons += "<td><auth:button code='BGHalfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2!=0&&Math.floor(fullWidth/182)*2<=i&&i<Math.floor(fullWidth/182)*4){
	    			if(factory=="1"){
     	    			buttons += "<td><auth:button code='Halfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}else{
     	    			buttons += "<td><auth:button code='BGHalfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}
	    		}
	    	}
	    	buttons+="</tr>";
	    	//第三組
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2==0&&Math.floor(fullWidth/182)*4<=i&&i<Math.floor(fullWidth/182)*6){
	    			if(factory=="1"){
     	    			buttons += "<td><auth:button code='Halfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}else{
     	    			buttons += "<td><auth:button code='BGHalfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2!=0&&Math.floor(fullWidth/182)*4<=i&&i<Math.floor(fullWidth/182)*6){
	    			if(factory=="1"){
     	    			buttons += "<td><auth:button code='Halfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}else{
     	    			buttons += "<td><auth:button code='BGHalfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}
	    		}
	    	}
	    	buttons+="</tr>";
	    	//第四組(空余量)
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2==0&&Math.floor(fullWidth/182)*6<=i&&i<Math.floor(fullWidth/182)*8){
	    			if(factory=="1"){
     	    			buttons += "<td><auth:button code='Halfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}else{
     	    			buttons += "<td><auth:button code='BGHalfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}
	    		}
	    	}
	    	buttons+="</tr>";
	    	buttons+="<tr>";
	    	for(var i=0;i<data.length;i++){
	    		if(i%2!=0&&Math.floor(fullWidth/182)*6<=i&&i<Math.floor(fullWidth/182)*8){
	    			if(factory=="1"){
     	    			buttons += "<td><auth:button code='Halfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}else{
     	    			buttons += "<td><auth:button code='BGHalfpartl_ChargeControlOpen_on_1190011'><a style='width:180px' class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></auth:button> </td>";
	    			}
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
	  
</script>