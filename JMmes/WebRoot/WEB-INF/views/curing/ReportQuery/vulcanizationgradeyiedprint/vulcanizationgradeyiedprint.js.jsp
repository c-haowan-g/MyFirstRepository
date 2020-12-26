<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"lh/bb/lhclbb/saveChanges";
    
    function showOrHide(){
        if($("#vulcanizationgradeyieldprint_search_form").is(":hidden")){
            $("#vulcanizationgradeyieldprint_search_form").show();
        }else{
            $("#vulcanizationgradeyieldprint_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        
        //赋值弹窗时间
        var beginTime=$('#begin_created_time').textbox("getValue");
		var endTime=$('#end_created_time').textbox("getValue");
		$('#begin_created_time_detail').val(beginTime);
		$('#end_created_time_detail').val(endTime);
    	var opts = $("#vulcanizationgradeyieldprint_dg").datagrid("options");
		opts.url = 'lh/bb/lhdjclbb/datagrid';
        ext.easyui.grid.search("vulcanizationgradeyieldprint_dg","vulcanizationgradeyieldprint_search_form");
        
    };
    var filterDoubleClick=function(index,row){
        $('#usercode_detail').val(row.usercode);
        console.log(row.usercode);
        var opts = $("#controldetail_dg").datagrid("options");
        opts.url = 'lh/bb/lhdjclbb/datagrid_detail';
        ext.easyui.grid.search("controldetail_dg","Detail_dg_toolbar_form");
    };
    //双击时间
    function openDouleDatagrid(index,row)
	{
		$('#w').window('open');
		filterDoubleClick(index,row);
		
	}
   
    function remove() {

        var rows = $("#vulcanizationgradeyieldprint_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#vulcanizationgradeyieldprint_dg").datagrid("getRowIndex", rows[i]);
            $("#vulcanizationgradeyieldprint_dg").datagrid("deleteRow", index);
        }

    }
	
    $(function(){
		var day=new Calendar().format("yyyy-MM-dd");
		 $('#begin_created_time').textbox("setValue",day);
		 $('#end_created_time').textbox("setValue",day);
		 $('#begin_created_time_detail').val(day);
		 $('#end_created_time_detail').val(day);
  	});
  //设定时间初始值从当前时间00:00:00至23:59:59
	/* $(document).ready(function() {
		$('#begin_created_time').datetimebox({
			value : '3/4/2010',
			required : true,
			showSeconds : false
		});
		$('#end_created_time').datetimebox({
			value : '3/4/2010',
			required : true,
			showSeconds : false
		});
		//filter();
	});  */
     function dateParse(dateString){
        return new Date(dateString.substring(0,4),dateString.substring(4,6)-1,dateString.substring(6,8));
    }
    
    function myformatter(date){
        return new Calendar(date).format("yyyyMMdd");
    }
    
    function cancel() {
        $("#vulcanizationgradeyieldprint_dg").datagrid("rejectChanges");
    }
    
    function finishhours(v,r,i){
        if(r.active_output==0){
            return "0.00%";
        }
    	//一级品/实际生产*100
    	return (Math.floor(r.gradea/r.active_output*10000)/100).toFixed(2)+"%";
    }
    function adequatecompletionrate(v,r,i){
        if(r.active_output==0){
            return "0.00%";
        }
        //二级品+A0级+一级品/实际生产*100
    	return (Math.floor((r.gradea+r.secondlevel)/r.active_output*10000)/100).toFixed(2)+"%";
    }
    
    function qualitycompletionrate(v,r,i){
        if(r.quantity_plan==0){
            return "0.00%";
        }
        //实际生产/计划量*100
    	return (Math.floor(r.active_output/r.quantity_plan*10000)/100).toFixed(2)+"%";
    }

    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#vulcanizationgradeyieldprint_dg").datagrid("getSelections");
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
	    var title=[{username:'姓名'},{quantity_plan:'计划量'},{active_output:'实际产量'},{gradea:'一级品'}
	             ,{secondlevel:'二级品'},{waste:'废品'},{first_grade:'一级品率'},{percentofpass:'合格率'},{qualitycompletionrate:'完成率'}]; 
	    toExcel("硫化等级产量报表"+time,data,title);
	    //outCsv(data, "硫化结果汇总"+time, true);
	}
	function outCsv(JSONData, ReportTitle, ShowLabel) {
	    var CSV = '';
	    /*在第一集的行或行报告title */
	    //CSV += "硫化结果汇总" + '\r\n\n';
	    /* 如果JSONData不是一个对象然后JSON.parse将解析对象中的JSON字符串  */
	    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
	  
	    /*这将产生的header label*/
	    if (ShowLabel) {
	        var row = "";
	        /*  这个循环将从数组的第一个索引中提取标签。 */
	        for (var index in arrData[0]) {
	        	/*现在将每个值的字符串，用逗号分开   根据实际情况重新赋值 */
	        	if(index=="class_id_s"){
	        		continue;
	        	}
	        	if(index =="atr_key"){
	        		continue;
	        	}
	        	if (index == "username") {
	        		index = '<spring:message code="vgyp.column.name" />';
	        		continue;
	        	}
	        	if (index == "quantity_plan") {
	        		index = '<spring:message code="vgyp.column.quantity_plan" />';
	        		continue;
	        	}
	        	if (index == "active_output") {
	        		index = '<spring:message code="vgyp.column.active_output" />';
	        		continue;
	        	}
	        	if(index=="gradea"){
	        		index='<spring:message code="vgyd.column.gradea" />';
	        		continue;
	        	}
	        	if(index=="secondlevel"){
	        		index= '<spring:message code="vgyp.column.secondleve" />';
	        		continue;
	        	}
	        	if(index=="waste"){
	        		index= '<spring:message code="vgyp.column.waste" />';
	        		continue;
	        	}
	        	if(index=="first_grade"){
	        		index= '<spring:message code="vgyp.column.first_grade" />';
	        		continue;
	        	}
	        	if(index=="percentofpass"){
	        		index='<spring:message code="vgyp.column.percentofpass" />';
	        		continue;
	        	}
	        	if(index=="qualitycompletionrate"){
	        		index='<spring:message code="vgyp.column.completionrate" />';
	        		continue;
	        	}
	        	row += index + ',';
	        }
	        //截取标题对象内的数据。
	        row = row.slice(0, -1);
	        /* 附加带换行符的标签行  */
	        CSV += row + '\r\n';
	    }
	    //  开始遍历取数据
	    for (var i = 0; i < arrData.length; i++) {
	        var row = "";
	        /*第二环路将提取每一列并将其转换成字符串逗号分开 */
	        for (var index in arrData[i]) {
	        	debugger;
	        	if(index =="atr_key"){
	        		continue;
	        	}else{
	            	row += '"' + arrData[i][index] + '",';
	            }
	        }
	        console.log(row);
	        row.slice(0, row.length - 1);
	        //在每行后面都有换行符
	        CSV += row + '\r\n';
	    }
	    if (CSV == '') {
	        alert("Invalid data");
	        return;
	    }
	    //  定义一个文件名
	    var fileName = "";
	    //这将从标题中删除空格，并将其替换为下划线
	    fileName += ReportTitle.replace(/ /g, "_");
	    // 如果浏览器是IE
	    if (window.navigator.msSaveOrOpenBlob) {
	        var csvContent = "\ufeff";
	        var uriie = csvContent + CSV;
	        var blob = new Blob([decodeURIComponent(encodeURI(uriie))], {
	            type: "data:text/csv;charset=utf-8,"
	        });
	        navigator.msSaveBlob(blob, fileName + '.xls');
	    } else {
	        var csvContent = "data:text/csv;charset=utf-8,\ufeff";
	        var uriother = csvContent + CSV;
	        var encodedUri = encodeURI(uriother);
	        var link = document.createElement("a");
	        link.setAttribute("href", encodedUri);
	        link.setAttribute("download", fileName + ".xls");
	        document.body.appendChild(link);
	        link.click();
	    }
	}
	
	function classFormatter(v,r,i){
		if(v=='302001')
			return '早班';
		else if(v=='302002')
			return '中班';
		else if(v=='302003')
			return '晚班';
		else
			return '';
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
                    	 if(k=="first_grade"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (Math.floor(arrData[i]['gradea']/arrData[i]['active_output']*10000)/100).toFixed(2)+ "</td>";
                    		 continue;
                    	 }
                    	 if(k=="percentofpass"){					
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (Math.floor((arrData[i]['gradea']+arrData[i]['secondlevel'])/arrData[i]['active_output']*10000)/100).toFixed(2)+'%'; + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="qualitycompletionrate"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (Math.floor(arrData[i]['active_output']/arrData[i]['quantity_plan']*10000)/100).toFixed(2)+'%'; + "</td>";
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
</script>