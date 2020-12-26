<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
		return dictFormat(v);
	}

    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#sulphurstartupstatistics_dg").datagrid("options");
		opts.url = 'lh/bb/lhkctj/searchBy3';
    	ext.easyui.grid.search("sulphurstartupstatistics_dg","SulphurStartUpStatistics_search_form");
    }
	/**
	 * 第2个tab页的查询方法
	 */
	var filter2 = function() {
		var opts = $("#sulphurstartupstatistics_dg2").datagrid("options");
		opts.url = 'lh/bb/lhkctj/searchBy2';
		ext.easyui.grid.search("sulphurstartupstatistics_dg2", "SulphurStartUpStatistics_search_form2");
	}
	//页面显示的时间段字符串
	function timeFormatter(){
		var begin_created_time = $('#start_time2').val();
		var end_created_time = $('#end_time2').val();
		return begin_created_time+"~"+end_created_time;
	}
	//算出时间段分钟
	function  time(){
		var begin_created_time = $('#start_time2').val();
		var end_created_time = $('#end_time2').val();
		//截取字符串，得到日期部分"2009-12-02",用split把字符串分隔成数组
		var begin1=begin_created_time.substr(0,10).split("-");
		var end1=end_created_time.substr(0,10).split("-");
		//将拆分的数组重新组合，并实例成化新的日期对象
		var date1=new Date(begin1[1] + - + begin1[2] + - + begin1[0]);
		var date2=new Date(end1[1] + - + end1[2] + - + end1[0]);
		//得到两个日期之间的差值m，以分钟为单位
		//Math.abs(date2-date1)计算出以毫秒为单位的差值
		//Math.abs(date2-date1)/1000得到以秒为单位的差值
		//Math.abs(date2-date1)/1000/60得到以分钟为单位的差值
		var m=parseInt(Math.abs(date2-date1)/1000/60);
		//小时数和分钟数相加得到总的分钟数
		//time1.substr(11,2)截取字符串得到时间的小时数
		//parseInt(time1.substr(11,2))*60把小时数转化成为分钟
		var min1=parseInt(begin_created_time.substr(11,2))*60+parseInt(begin_created_time.substr(14,2));
		var min2=parseInt(end_created_time.substr(11,2))*60+parseInt(end_created_time.substr(14,2));
		//两个分钟数相减得到时间部分的差值，以分钟为单位
		var n=min2-min1;
		//将日期和时间两个部分计算出来的差值相加，即得到两个时间相减后的分钟数
		var minutes=m+n;
		return minutes;
	}
	//页面显示的开车率
 	function drivingRateFormatter(v,r,i){
		var begin_created_time = $('#start_time2').val();
		var end_created_time = $('#end_time2').val();
		//截取字符串，得到日期部分"2009-12-02",用split把字符串分隔成数组
		var begin1=begin_created_time.substr(0,10).split("-");
		var end1=end_created_time.substr(0,10).split("-");
		//将拆分的数组重新组合，并实例成化新的日期对象
		var date1=new Date(begin1[1] + - + begin1[2] + - + begin1[0]);
		var date2=new Date(end1[1] + - + end1[2] + - + end1[0]);
		//得到两个日期之间的差值m，以分钟为单位
		//Math.abs(date2-date1)计算出以毫秒为单位的差值
		//Math.abs(date2-date1)/1000得到以秒为单位的差值
		//Math.abs(date2-date1)/1000/60得到以分钟为单位的差值
		var m=parseInt(Math.abs(date2-date1)/1000/60);
		//小时数和分钟数相加得到总的分钟数
		//time1.substr(11,2)截取字符串得到时间的小时数
		//parseInt(time1.substr(11,2))*60把小时数转化成为分钟
		var min1=parseInt(begin_created_time.substr(11,2))*60+parseInt(begin_created_time.substr(14,2));
		var min2=parseInt(end_created_time.substr(11,2))*60+parseInt(end_created_time.substr(14,2));
		//两个分钟数相减得到时间部分的差值，以分钟为单位
		var n=min2-min1;
		//将日期和时间两个部分计算出来的差值相加，即得到两个时间相减后的分钟数
		var minutes=m+n;
	    return ((r.closeing_time/minutes)*100).toFixed(2)+"%";
	}	
	
    //设定时间初始值从当前时间00:00:00至23:59:59
    $(function(){
    	$("#start_time").datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	$("#end_time").datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    	$("#start_time2").datetimebox({
    	    value: '3/4/2010 00:00:00',
    	    required: true,
    	    showSeconds: true
    	});
    	$("#end_time2").datetimebox({
    	    value: '3/4/2010 23:59:59',
    	    required: true,
    	    showSeconds: true
    	});
    });
    
    //导出
    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#sulphurstartupstatistics_dg").datagrid("getSelections");
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
	    var title=[{equip_code_s:'机台编码'},{tyre_barcode_s:'轮胎条码'},{opening_time:'开模时间(分钟)'},{closeing_time:'合模时间(分钟)'}]; 
	    toExcel("硫化开车统计详细"+time,data,title); 
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
        excelFile += "硫化开车统计详细";  
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
    
    //导出
    function ExcelExport2() {
	    //获取grid 数据
	    var node = $("#sulphurstartupstatistics_dg2").datagrid("getSelections");
    	if (node == "") {
    		var param=ext.form.getFormAsJson("SulphurStartUpStatistics_search_form2");
        	var param_get="";
        	for(var k in param){
        		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
        	}
    		$.ajax({
    			url : "lh/bb/lhkctj/searchBy?s_factory_s="+factory+"&"+param_get,
    			type : 'get',
    			dataType : 'json',
    			async : false,
    			success : function(data) {
    			     node = data; 
    			}
    		});
			
		}
    	//debugger;
	    var data = JSON.stringify(node);
	    if (data == '')
	        return;
	    var myDate = new Date();
	    var time=myDate.toLocaleString( );
	    var title=[{equip_code_s:'机台编码'},{driving_rate:'开车率(%)'},{opening_time:'开模时间(分钟)'},{closeing_time:'合模时间(分钟)'},{time_quantum:'时间段'}]; 
	    toExcel2("硫化开车统计汇总"+time,data,title); 
	}
    
    
    //FileName 生成的Excel文件名称
    function toExcel2(FileName, JSONData, ShowLabel) {  
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
                    	 if(k=="driving_rate"){
	                   		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i]['closeing_time']/time()*100).toFixed(2)+"%" + "</td>";
	                   		 continue;
                   	     }
                    	 if(k=="time_quantum"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + timeFormatter() + "</td>";
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
        excelFile += "硫化开车统计汇总";  
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