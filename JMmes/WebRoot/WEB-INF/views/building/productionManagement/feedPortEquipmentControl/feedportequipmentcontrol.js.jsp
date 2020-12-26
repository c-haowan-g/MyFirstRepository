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
        if($("#FeederNoseControl_search_form").is(":hidden")){
            $("#FeederNoseControl_search_form").show();
        }else{
            $("#FeederNoseControl_search_form").hide();
        }
    }
 
    function cancel() {
        $("#FeederNoseControl_dg").datagrid("rejectChanges");
    }
    
    
    function intTable(){
    	var machinename_s = $('#machinename_s').val();
		var machinegroup_s = $('#machinegroup_s').val();
		$.ajax({
	 		url:"building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol/searchInit?machinename_s=" + machinename_s
			+ "&machinegroup_s=" + machinegroup_s,
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(message){
	 			var data = message;
	 			$("#FeederNoseControl_dg").datagrid("loadData", data);  
	 		}
	 	});   
	 }
    
    var columnData=new Array();
    var dataJSON=null;
     $(function(){
    	 $.ajax({
 	 		url:"building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol/searchByDictionary",
 	 		type:"get",
 	 		dataType:"text",
 	 		async:false,
 	 		success:function(data){
 	 			dataJSON=JSON.parse(data);
 	 			for(var i=0;i<dataJSON.length;i++){
				var column ={};
				column["title"]=dataJSON[i].DICTNAME;
				column["width"]="100px";
				column["field"]="A"+dataJSON[i].DICTCODE_S;
				column["formatter"]=showControlStatus;
				columnData.push(column);
 	 			}
 	 		}
 	 	}); 
    	 initTable1();
     });
     
     function initTable1(){
    	 $("#FeederNoseControl_dg").datagrid({
    		 fit:true,
             fitColumns:false,
             //pagination:true,
             rownumbers: true,
             singleSelect: false,
             toolbar: '#FeederNoseControl_dg_toolbar',
             url:'building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol/searchInit', 
             striped:true,
             method: 'get',
             emptyMsg: '<span><spring:message code='tip.noData'/></span>',
             frozenColumns :[[
                   {field:'atr_key',title:'ID',checkbox:true,align:'center'},           
                   {field:'MACHINENAME_S',title:'<spring:message code="buildingcontrol.column.machinename_s" />',width:150},
                   {field:'MACHINEGROUP_S',formatter:codeFormatter, 
			             options:{
		                 method:'get',
		                 url:'dict/code/320',
		                 required:true},title:'<spring:message code="buildingcontrol.column.machinegroup_s" />',width:80}
             ]],
             columns:[columnData]
    	 });
    	 intTable();
     }
     
    var onOff = "building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol/onOff";
 	function on_off(dataOn) {
 		var updated = $("#FeederNoseControl_dg").datagrid("getSelections");
 		 if(updated.length!=0){
 			ext.ajax.sendJson(onOff, {
 				dataOnOff:dataOn,
 				updated : updated
 			}, function(data) {
 					if (data.message != "ok") {
 						intTable();
 						ext.tip.error(data.message);
 					}else {
 						//$("#FeederNoseControl_dg").datagrid("reload");
 						intTable();
 						ext.tip.suc("<spring:message code="tip.success" />");
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
	
	  function showControlStatus(value,row,index){
		  if((value=="1")){
	      		return "开启";
	      	}else if((value=="0")){
	      		return "关闭";
	      	}
	  }
	  
	  
		//导出
	    function ExcelExport() {
		    //获取grid 数据
		    var node = $("#FeederNoseControl_dg").datagrid("getSelections");
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
		               {MACHINEGROUP_S:'机台组'}]; 
		    for(var i=0;i<dataJSON.length;i++){
		    	var column ={};
				column["A"+dataJSON[i].DICTCODE_S]=dataJSON[i].DICTNAME;
				title.push(column);
		    }
		    toExcel("成型机台投料口控制管理"+time,data,title); 
		}
	    //FileName 生成的Excel文件名称
	    function toExcel(FileName, JSONData, ShowLabel) {  
	        //先转化json  
	        var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;  
	        var excel = '<table>';      
	        //设置表头  
	        var row = "<tr align='left'>";//设置Excel的左居中
	        for (var i = 0;i < ShowLabel.length; i++) {  
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
	                    	 if(k=="MACHINEGROUP_S"){
	                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['MACHINEGROUP_S']===null? "" : dictFormat(arrData[i]['MACHINEGROUP_S'])) + "</td>";
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
	        excelFile += "成型机台投料口控制管理";  
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
		  //页面加载时onload事件
		    $(function () {
			    $.ajax({
		  	 		url:"building/productionManagement/feedPortEquipmentControl/feedportequipmentcontrol/searchFromCoreMenu",
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
		  
		  //将回调函数中的数据放到Panel的title中
		    function Callback(data) {
		    	var title = "<span class='splitcss'></span><span class='desc'>投料口开关</span><span class='splitcss'></span>";
		    	var buttons="";
		    	buttons+="<table width: 100%; >";
		    	//第一組
		    	buttons+="<tr>";
		    	for(var i=0;i<data.length;i++){
		    		if(i%2==0&&i<14){
		    			buttons += "<td><a class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></td>";
		    		}
		    	}
		    	buttons+="</tr>";
		    	buttons+="<tr>";
		    	for(var i=0;i<data.length;i++){
		    		if(i%2!=0&&i<14){
		    			buttons += "<td><a class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></td>";
		    		}
		    	}
		    	buttons+="</tr>";
		    	//第二組
		    	buttons+="<tr>";
		    	for(var i=0;i<data.length;i++){
		    		if(i%2==0&&14<=i&&i<28){
		    			buttons += "<td><a class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a></td>";
		    		}
		    	}
		    	buttons+="</tr>";
		    	buttons+="<tr>";
		    	for(var i=0;i<data.length;i++){
		    		if(i%2!=0&&14<=i&&i<28){
		    			buttons += "<td><a class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a> </td>";
		    		}
		    	}
		    	buttons+="</tr>";
		    	//第三組(空余量)
		    	buttons+="<tr>";
		    	for(var i=0;i<data.length;i++){
		    		if(i%2==0&&28<=i&&i<42){
		    			buttons += "<td><a class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a> </td>";
		    		}
		    	}
		    	buttons+="</tr>";
		    	buttons+="<tr>";
		    	for(var i=0;i<data.length;i++){
		    		if(i%2!=0&&28<=i&&i<42){
		    			buttons += "<td><a class='panel_" + data[i].PINYININDEX + "' id='" + data[i].PINYININDEX + "'  ></a> </td>";
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
		    		console.log(item.CODE.substring("+++++++++++++_______________+"+item.CODE.length-1));
	    			//加载按钮属性
		    		if(item.CODE.substring(item.CODE.length-1)=="1"){
			    		$("#button_area").panel('body').find('a.panel_' + item.PINYININDEX + '').linkbutton({
			    		iconCls: 'icon-add',
			    		text: item.NAME,
				    	});
		    		}else{
			    		$("#button_area").panel('body').find('a.panel_' + item.PINYININDEX + '').linkbutton({
			    		iconCls: 'icon-remove',
			    		text: item.NAME,
				    	});
		    		}
		    		
			    	$('#' + item.PINYININDEX + '').bind('click', function () {
			    		on_off(item.CODE.substring(item.CODE.length-7));
			    	});
		    	});
		    }
</script>