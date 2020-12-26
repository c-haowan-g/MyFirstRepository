<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"/halfpart/plateinfo/saveChanges";
    
    function showOrHide(){
        if($("#PlateInfo_search_form").is(":hidden")){
            $("#PlateInfo_search_form").show();
        }else{
            $("#PlateInfo_search_form").hide();
        }
    }
    
    function flagFormat(value, row, index) {
		if ((value == "0")) {
			return "未使用";
		} else if ((value == "1")) {
			return "已使用";
		}
	}
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#plateinfo_dg").datagrid("options");
		opts.url = 'halfpart/plateinfo/datagrid';
        ext.easyui.grid.search("plateinfo_dg","PlateInfo_search_form");
        
      
    }
    
    
    
    function add() {
        
          $("#plateinfo_dg").datagrid('insertRow', {
			index : 0,
			row : {vehicles_type_s : "口型板",
				   flag_s : 0}
		});
    	$("#plateinfo_dg").datagrid("beginEdit", 0);
        
    }

    function edit() {
        var rows = $("#plateinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plateinfo_dg").datagrid("getRowIndex", rows[i]);
            var value=rows[i]["flag_s"];
             if(value==1){
            	ext.tip.error("<spring:message code="tip.notoperational" />");
            }else{
            	$("#plateinfo_dg").datagrid("beginEdit", index);
            }
        }
    }

    function remove() {

        var rows = $("#plateinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#plateinfo_dg").datagrid("getRowIndex", rows[i]);
             var value=rows[i]["flag_s"];
            
            if(value==1){
            	ext.tip.error("<spring:message code="tip.notoperational" />");
            }else{
            	$("#plateinfo_dg").datagrid("deleteRow", index);
            }
        }

    }

    function save() {
        var dg = $("#plateinfo_dg");

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
            $("#plateinfo_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#plateinfo_dg").datagrid("rejectChanges");
    }




 //导出
    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#plateinfo_dg").datagrid("getSelections");
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
	    var title=[{vehicles_barcode_s:'口型板编码'},
	               {vehicles_rfidcode_s:'RFID码'},
	               {flag_s:'口型板状态'},
	               {mouthplatespecification_s:'口型板规格'},
	               {vehicles_type_s:'工装类型'},
	               {internaldiameter_s:'内径'},
	               {thickness_s:'厚度'},
	               {currentlocation_s:'当前位置'},
	               {begintime_t:'开始使用时间'},
	               {endtime_t:'结束使用时间'},
	               {changed_by_s:'修改人'},
	               {changed_time_t:'修改时间'},
	               {usecount_i:'累计使用次数'}]; 
	    toExcel("半部件全钢口型板信息维护"+time,data,title); 
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
        excelFile += "半部件全钢口型板信息维护";  
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