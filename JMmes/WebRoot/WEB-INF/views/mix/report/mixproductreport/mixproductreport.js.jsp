<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"mix/report/mixproductreport/mixproductreport/saveChanges";
    
    function showOrHide(){
        if($("#MixProductReport_search_form").is(":hidden")){
            $("#MixProductReport_search_form").show();
        }else{
            $("#MixProductReport_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
         var equipCode = $("#equip_code_s").val();
        var starttime =$("#start_time").datetimebox("getValue");
        var endtime=$("#end_time").datetimebox("getValue");
        if(starttime!="" && endtime!=""){
            if(starttime>endtime){
                ext.tip.error("<spring:message code="tip.date" />");
            }else{
                var opts = $("#mixproductreport_dg").datagrid("options");
                equipCode = equipCode.substring(0,3);
                if(equipCode=="901"){
                    opts.url = 'mix/report/mixproductreport/mixproductreport/datagrid';
                }else if(equipCode=="902"){
                    opts.url = 'mix/report/mixproductreport/mixproductreport/datagrid2';
                }else{
                    opts.url = 'mix/report/mixproductreport/mixproductreport/datagrid3';
                }
                ext.easyui.grid.search("mixproductreport_dg","MixProductReport_search_form");
            }
        }else{
            var opts = $("#mixproductreport_dg").datagrid("options");
            equipCode = equipCode.substring(0,3);
            if(equipCode=="901"){
                opts.url = 'mix/report/mixproductreport/mixproductreport/datagrid';
            }else if(equipCode=="902"){
                opts.url = 'mix/report/mixproductreport/mixproductreport/datagrid2';
            }else{
                opts.url = 'mix/report/mixproductreport/mixproductreport/datagrid3';
            }
            ext.easyui.grid.search("mixproductreport_dg","MixProductReport_search_form");
        }
        ext.easyui.grid.search("mixproductreport_dg","MixProductReport_search_form");
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("mixproductreport_dg",{});
    }

    function edit() {
        var rows = $("#mixproductreport_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixproductreport_dg").datagrid("getRowIndex", rows[i]);
            $("#mixproductreport_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#mixproductreport_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#mixproductreport_dg").datagrid("getRowIndex", rows[i]);
            $("#mixproductreport_dg").datagrid("deleteRow", index);
        }

    }

    function save() {
        var dg = $("#mixproductreport_dg");

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
            $("#mixproductreport_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#mixproductreport_dg").datagrid("rejectChanges");
    }
var equiplist=[];
    //加载胶料机台信息
    $.ajax({
        url:"mix/report/mixmonthlyreport/mixmonthlyreport/getMixProductionInfo?plantype="+"051004",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            equiplist=data;
        }
    });

    function searchProductionLine(q, row) {
        var opts = $(this).combobox('options');
        return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
    }

    //设定时间初始值从当前时间00:00:00至23:59:59
    //表格加载前事件
    function dlg1BeforeLoad(param) {

        if ($("#start_time").datebox("getValue") == "") {
            return false;
        }

        param["filter[start_time]"] = $("#start_time").datebox("getValue")
            .toString();
        param["filter[end_time]"] = $("#end_time").datebox("getValue")
            .toString();

    }

    /**
     * 解析指定格式日期
     */
    function dateParser(s) {
        if (!s)
            return new Date();
        return new Date(s.substring(0, 4), parseInt(s.substring(4, 6)) - 1, s
            .substring(6, 8));
    }

    /**
     * 日期格式化
     */
    function dateFormat(date) {
        return new Calendar(date).format("yyyyMMdd");
    }

    function codeFormatter(v, r, i) {

        return dictFormat(v);
    }

    var shiftCode=[];
    $.ajax({
        url:"dict/code/302",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            shiftCode=data;
        }
    });

    function doExport(){
       /*  var param=ext.form.getFormAsJson("MixProductReport_search_form");
        console.log(param)
        var param_get="";

        for(var k in param){
            param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
        }
        window.open(path+"mix/report/mixproductreport/mixproductreport/exportCSV?s_factory_s="+factory+param_get); */
        	//获取grid 数据
	    var node = $("#mixproductreport_dg").datagrid("getSelections");
    	if (node == "") {
    		var param=ext.form.getFormAsJson("MixProductReport_search_form");
        	var param_get="";
        	for(var k in param){
        		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
        	}
    		$.ajax({
    			url : "mix/report/mixproductreport/mixproductreport/exportCSV?s_factory_s="+factory + param_get,
    			type : 'get',
    			dataType : 'json',
    			async : false,
    			success : function(data) {
    			     node = data; 
    			}
    		});
		}
		
		
		 
	    var data = JSON.stringify(node);
	    if (data == '')
	        return;
	    var myDate = new Date();
	    var time=myDate.toLocaleString( );
	    var title=[{product_time_t:'产出时间'},{shift_code_s:'班次'},{group_code_s:'班组 '},{equip_name_s:'机台名称 '}
	             ,{material_name_s:'物料名称 '},{created_name_s:'主机手'},{trainCount:'总车数'},{totalWeight:'总重量'},{recipe_code_name_s:'配方类型'},
	            ]; 
	    toExcel("密炼产量报表"+time,data,title); 
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
                    	 /* if(k=="curing_openmoulddate"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : finishhours1(arrData[i].spare1_s,arrData[i].totalquantity)) + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="curing_closemoulddate"){					
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]===null? "" : adequatecompletionrate1(arrData[i].spare1_s,arrData[i].totalquantity)) + "</td>";
                    		 continue;
                    	 } 
                    	 if(k=="qualitycompletionrate"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.floor(arrData[i]['gradea']/arrData[i]['totalquantity']/0.996*100*1000)/1000+'%'; + "</td>";
                    		 continue;
                    	 }*/
                    	 if(k=="shift_code_s"){
                    		 if(arrData[i][k]==="302001"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('早班') + "</td>";
                    		 }
                    		 else if(arrData[i][k]==="302002"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('中班') + "</td>";
                    		 }
                    		 else if(arrData[i][k]==="302003"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('晚班') + "</td>";
                    		 }
                    		 else{
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('') + "</td>";	 
                    		 } 	 
                    		 continue;
                    	 } 
                    	 if(k=="group_code_s"){
                    		 if(arrData[i][k]==="301001"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('甲班') + "</td>";
                    		 }
                    		 else if(arrData[i][k]==="301002"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('乙班') + "</td>";
                    		 }
                    		 else if(arrData[i][k]==="301003"){
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('丙班') + "</td>";
                    		 }
                    		 else{
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('') + "</td>";	 
                    		 } 	 
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
        excelFile += "密炼产量报表";  
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