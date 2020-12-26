<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

$(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010 00:00:00',
			required : false,
			showSeconds : true
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010 23:59:59',
			required : false,
			showSeconds : true
		});
	});


 /**
     * 查询方法
     */
    var filter=function(){
    	var line = $('#huizong_s').checkbox('options').checked;
    	var material = $('#xiangxi_s').checkbox('options').checked;
    	//汇总
    	if(line == true && material == false){
            $("#checkgradestorage_dg").datagrid("options").url="finalcheck/qualityInspectionRecord/checkgradegradestorage/checkgradegradestorage/searchInit2";
    		ext.easyui.grid.search("checkgradestorage_dg","Checkgradestorage_search_form");
    		$('#checkgradestorage_dg').datagrid({ 
    			columns:[[
                	{field:'atr_key',checkbox:true},
                    {field:'materialcode_s',title:'轮胎品号',width:90},
                    {field:'materialname_s',title:'规格名称',width:270},
                    {field:'djcipincount_s',title:'动均次品数量',width:90},
                    {field:'djfeipincount_s',title:'动均废品数量',width:90},
                    {field:'buhegecount_s',title:'不合格总数量',width:90},
                    {field:'spare5_s',title:'备注',width:90}
                ]]
            });
    	}
    	//详细
    	if(line == false && material == true){
            $("#checkgradestorage_dg").datagrid("options").url="finalcheck/qualityInspectionRecord/checkgradegradestorage/checkgradegradestorage/searchInit3";
    		ext.easyui.grid.search("checkgradestorage_dg","Checkgradestorage_search_form");
    		$('#checkgradestorage_dg').datagrid({ 
    			columns:[[
                	{field:'atr_key',checkbox:true},
                	{field:'barcode_s',title:'轮胎条码',width:90},
                    {field:'materialcode_s',title:'轮胎品号',width:90},
                    {field:'materialname_s',title:'规格名称',width:270},
                    {field:'balnaceuniformgrade_s',title:'动均等级',formatter:codeFormatter,url:'dict/code/253',width:70},
                    {field:'buhege_s',title:'不合格项目',width:320},
                    {field:'grade_s',title:'总等级',formatter:codeFormatter,url:'dict/code/253',width:70},
                    {field:'operator_s',title:'操作人',width:70},
                    {field:'operatortime_t',title:'操作时间',width:140}
                ]]
            });
    	}
	if(line == false && material == false) {
    		ext.tip.error("选择项不能为空");
    	}
    };


/* 	 function classFormatter(v,r,i){
		if(v=='4')
			return '早班'
		/* else if(v=='302002')
			return '中班'
		else if(v=='302003')
			return '晚班'
		else
			return '' 
	}  */


function codeFormatter(v, r, i){
		return dictFormat(v);
	} 

 //导出
 /**
    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#checkgradestorage_dg").datagrid("getSelections");
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
	    var flag_code=$("#huizong_s").is(":checked");
    	var flag_type=$("#xiangxi_s").is(":checked");
		 if((flag_code)&&!(flag_type)) {
		    var title=[{atr_key:'序号'},
		    		   {materialcode_s:'物料编码'},
		               {materialname_s:'物料名称'},
		               {djcipincount_s:'动均次品数量'},
                   	   {djfeipincount_s:'动均废品数量'},
                       {buhegecount_s:'不合格总数量'},
                       {spare5_s:'备注'}]; 
		 }
		 if(!(flag_code)&&(flag_type)) {
		     var title=[{atr_key:'序号'},
		    		   {barcode_s:'轮胎条码'},
                       {materialcode_s:'轮胎品号'},
                       {materialname_s:'规格名称'},
                       {balnaceuniformgrade_s:'动均等级'},
                       {grade_s:'总等级'},
                       {operator_s:'操作人'},
                       {operatortime_t:'操作时间'}]; 
		 }
	    toExcel("机检废次品"+time,data,title); 
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
                    	 
                    	
                    	/*  if(k=="max_weight_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.round((arrData[i]['building_weight_s'] * valueMax)*1000)/1000 + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="min_weight_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.round((arrData[i]['building_weight_s'] * valueMax)*1000)/1000 + "</td>";
                    		 continue;
                    	 } 
                         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]==null? "" : arrData[i][k]) + "</td>";
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
        excelFile += "半部件库存汇总查询";  
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
    } */
   
</script>