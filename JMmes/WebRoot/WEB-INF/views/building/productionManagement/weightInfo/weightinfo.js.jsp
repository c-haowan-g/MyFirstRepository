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
	    getWeightData();
	    //filter();
	   
	});
	//上限值
	var valueMax;

	//下限值
	var valueMin;

	
	function getWeightData(){
		$.ajax({
			url : 'building/productionManagement/weightInfo/getWeightData',
			type : 'get',
			dataType : 'json',
			async : false,
			success : function(data) {
				valueMax = data[0].VALUEMAX_S.substring(1,data[0].VALUEMAX_S.length);
				valueMin = data[0].VALUEMIN_S.substring(1,data[0].VALUEMIN_S.length);
			}
		});
	} 
	 
	
	function material_name_Formatter(v, r, i){
		var row=$("#weightinfo_dg").datagrid("getData").rows[i];
		$.ajax({
				url : 'building/productionManagement/weightInfo/getMaterialName',
				type : 'get',
				dataType : 'json',
				data: {
					begin_time : $("#begin_created_time").datetimebox("getValue"),
					end_time : $("#end_created_time").datetimebox("getValue"),
					material_code_s : row.material_code_s
				},
				async : false,
				success : function(data) {
					r.material_name_s=data[0].MATERIAL_NAME_S;
				}
			});    
			
			
			return v;
	
	
	}
	
	
	
	//上限/下限重量赋值
	function max_min_Formatter(v, r, i) {
		if(v == null ){
			v = 0;
		}
		r.max_weight_s = Math.round((v * valueMax)*1000)/1000; 
		r.min_weight_s = Math.round((v * valueMin)*1000)/1000; 
		//$(getEditor(i, "max_weight_s").target).textbox('setValue',(v * valueMax));
		//$(getEditor(i, "min_weight_s").target).textbox('setValue',(v * valueMin));
		    var row=$("#weightinfo_dg").datagrid("getData").rows[i];
		    
			$.ajax({
				url : 'building/productionManagement/weightInfo/getWeightPercent',
				type : 'get',
				dataType : 'json',
				data: {
					begin_time : $("#begin_created_time").datetimebox("getValue"),
					end_time : $("#end_created_time").datetimebox("getValue"),
					equip_code_s : row.equip_code_s,
					material_code_s : row.material_code_s,
					standard_weight_s : v,
					max_weight_s : Math.round((v * valueMax)*1000)/1000,
					min_weight_s : Math.round((v * valueMin)*1000)/1000
				},
				async : false,
				success : function(data) {
					r.weight_ok_s=data[0].WEIGHT_OK_S;
					r.weight_sml_s=data[0].WEIGHT_SML_S;
					r.weight_big_s=data[0].WEIGHT_BIG_S;
					r.weight_rate_s=Math.round(data[0].WEIGHT_OK_S/row.total_number_count*10000)/100+"%";
				}
			});    
		 
 		return v;
	}
	
    function showOrHide(){
        if($("#WeightInfo_search_form").is(":hidden")){
            $("#WeightInfo_search_form").show();
        }else{
            $("#WeightInfo_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#weightinfo_dg").datagrid("options");
		opts.url = 'building/productionManagement/weightInfo/searchInit';
        ext.easyui.grid.search("weightinfo_dg","WeightInfo_search_form");
    }
    
	
	
    //导出
    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#weightinfo_dg").datagrid("getSelections");
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
	    var title=[{equip_code_s:'机台条码'},
	               {material_code_s:'物料编码'},
	               {material_name_s:'物料名称'},
	               {standard_weight_s:'标准重量'},
	               {max_weight_s:'胎胚上限重量'},
	               {min_weight_s:'胎胚下限重量'},
	               {total_number_count:'总数'},
	               {weight_ok_s:'重量合格数量'},
	               {weight_sml_s:'重量超轻数量'},
	               {weight_big_s:'重量超重数量'},
	               {weight_rate_s:'合格率'}]; 
	    toExcel("胎胚重量合格率查询"+time,data,title); 
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
                    	 if(k=="quality_status_s"){
                   		     rowData+="<td style='vnd.ms-excel.numberformat:@'>" + dictFormat(arrData[i]['quality_status_s']) + "</td>";
                   		     continue;
                   	     } 
                    	 if(k=="first_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + dictFormat(arrData[i]['first_s']) + "</td>";
                    		 continue;
                    	 } 
                    	 if(k=="add_flag_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + dictFormat(arrData[i]['add_flag_s']) + "</td>";
                    		 continue;
                    	 } 
                    	 if(k=="solid_yflag_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + solid_yflag_s(arrData[i]['solid_yflag_s']) + "</td>";
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
        excelFile += "胎胚重量合格率查询";  
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