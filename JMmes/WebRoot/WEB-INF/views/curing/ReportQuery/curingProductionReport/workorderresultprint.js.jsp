<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    
    function showOrHide(){
        if($("#WorkOrderResultPrint_search_form").is(":hidden")){
            $("#WorkOrderResultPrint_search_form").show();
        }else{
            $("#WorkOrderResultPrint_search_form").hide();
        }
    }
    
    
    /**
     * 查询方法
     */
    function filter(){
    	var opts = $("#workorderresultprint_dg").datagrid("options");
		opts.url = 'curing/ReportQuery/curingProductionReport/datagrid';
        ext.easyui.grid.search("workorderresultprint_dg","WorkOrderResultPrint_search_form");
    }
    /**
     * 查询产线
     */
	function searchProductionLine(q, row) {
		var opts = $(this).combobox('options');
		return row[opts.textField].toUpperCase().indexOf(q.toUpperCase()) >= 0;
	}
	//加载产线信息
	var jtxx = [];
	$.ajax({
		url : 'curing/baseData/curingProductionLineInfo/comboxProductlineEqu',
		type : 'get',
		dataType : 'json',
		async : false,
		success : function(data) {
			jtxx = data;
		}
	});
    
    function finishhours(v,r,i){
    	if(r.spare1_s=="")
    		return "";
    	var hours=(r.spare1_s*100+2*100)/100;
    	//单台设备定额
    	var de=parseInt(450/hours*2);
    	de=parseInt(de);
    	console.log(de);
    	//单台工时
    	var dthours= 8/(de*10);
    	return (dthours*r.totalquantity).toFixed(4);
    }
    function finishhours1(spare1_s,totalquantity){
    	if(spare1_s=="")
    		return "";
    	var hours=(spare1_s*100+2*100)/100;
    	//单台设备定额
    	var de=parseInt(450/hours*2);
    	de=parseInt(de);
    	console.log(de);
    	//单台工时
    	var dthours= 8/(de*10);
    	return (dthours*totalquantity).toFixed(4);
    }
    function adequatecompletionrate(v,r,i){
    	if(r.spare1_s=="")
    		return "";
    	var hours=(r.spare1_s*100+2*100)/100;
    	//单台设备定额
    	var de=parseInt(450/hours*2);
    	//单台工时
    	var dthours=8/(de*10);
    	var a=Math.floor((dthours*r.totalquantity/8)*100*1000)/1000;
    	return a+"%";
    }
    function adequatecompletionrate1(spare1_s,totalquantity){
    	if(spare1_s=="")
    		return "";
    	var hours=(spare1_s*100+2*100)/100;
    	//单台设备定额
    	var de=parseInt(450/hours*2);
    	//单台工时
    	var dthours=8/(de*10);
    	var a=Math.floor((dthours*totalquantity/8)*100*1000)/1000;
    	return a+"%";
    }
    function qualitycompletionrate(v,r,i){
    	if(r.totalquantity=="")
 			return "";
    	return Math.floor((r.gradea/r.totalquantity/0.996*100)*1000)/1000+"%";
    }

    var length=0;//定义数据行数，用于
	function onLoadSuccess(data) {
		if (data.rows.length > 0) {
			length=data.rows.length;
			//添加“合计”列
			var gradea=0;
			var gradea0=0;
			var secondlevel=0;
			var waste=0;
			var specialwaste=0;
			var totalquantity=0;
			for(var i=0;i<data.rows.length;i++){
				totalquantity+=data.rows[i].totalquantity;
				gradea+=data.rows[i].gradea;
				gradea0+=data.rows[i].gradea0;
				secondlevel+=data.rows[i].secondlevel;
				waste+=data.rows[i].waste;
				specialwaste=data.rows[i].specialwaste;
			}
			$('#workorderresultprint_dg')
					.datagrid('appendRow',{
								atr_key : "",
								username : "",
								equip_code_s : "",
								material_code_s : "",
								material_name_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
								class_id_s: "",
								totalquantity : totalquantity,
								gradea : gradea,
								gradea0 : gradea0,
								secondlevel : secondlevel,
								waste : waste,
								specialwaste : specialwaste,
								spare1_s:0
							});
		}
		//去掉合计行的CheckBox
		var checkbox = $('div.datagrid-cell-check input[type=checkbox]');//先找到这个checkbox对象
		$(checkbox[checkbox.length - 1]).remove(); //将最后一个元素remove掉. 

	}
	//重写easyui的onCheckAll方法,不选择最后一行, 并使用prop将全选按钮设为checked
	var onCheckAll = function(rowIndex, rowData) {
		$('#workorderresultprint_dg').datagrid('uncheckRow',
				rowIndex.length - 1); //不选择最后一行
		var checkboxHeader = $('div.datagrid-header-check input[type=checkbox]');//取到全选全不选这个元素
		checkboxHeader.prop("checked", "checked");//将其设置为checked即可
	}
	//禁止选中合计行
	var onClickRow = function(rowIndex, rowData) {
		$(this).datagrid('unselectRow', length);
	}
	//根据条件设置表格行背景颜色
	function setRowBgColor(index, row) {
		 if (row.material_code_s == "" && row.equip_code_s == "") {
			return 'background-color:yellow;color:black;font-weight: bold;';
		} 
	}
	
    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#workorderresultprint_dg").datagrid("getSelections");
    	if (node == "") {
    		var param=ext.form.getFormAsJson("WorkOrderResultPrint_search_form");
        	var param_get="";
        	for(var k in param){
        		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
        	}
    		$.ajax({
    			url : "curing/ReportQuery/curingProductionReport/searchBy?s_factory_s="+factory+"&"+param_get,
    			type : 'get',
    			dataType : 'json',
    			async : false,
    			success : function(data) {
    			     node = data; 
    			}
    		});
		}
        var totalquantity = 0;
		var gradea = 0;
		var gradea0 = 0;
		var secondlevel = 0;
		var waste = 0;
		var specialwaste = 0;
		var qualitycompletionrate = 0;
		var CheckTotal = false;//检测是否选择合计行，true选中,false未选中
		for (var i = 0; i < node.length; i++) {
			totalquantity += parseFloat(node[i]["totalquantity"]);
			gradea += parseFloat(node[i]["gradea"]);
			gradea0 += parseFloat(node[i]["gradea0"]);
			secondlevel += parseFloat(node[i]["secondlevel"]);
			waste += parseFloat(node[i]["waste"]);
			specialwaste += parseFloat(node[i]["specialwaste"]);
			qualitycompletionrate = Math.floor((gradea/totalquantity/0.996*100)*1000)/1000+"%";
		}
		if (!CheckTotal) {
			//导出添加合计行
			var newJson = {
					atr_key : "",
					username : "",
					equip_code_s : "",
					material_code_s : "",
					material_name_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					class_id_s: "",
					totalquantity : "" + totalquantity + "",
					gradea : "" + gradea + "",
					gradea0 :"" + gradea0 + "",
					secondlevel : "" + secondlevel + "",
					waste : "" + waste + "",
					specialwaste : "" + specialwaste + "",
					spare1_s:"",
					qualitycompletionrate: "" + qualitycompletionrate + ""
			};
			node.push(newJson);
		} 
	    var data = JSON.stringify(node);
	    if (data == '')
	        return;
	    var myDate = new Date();
	    var time=myDate.toLocaleString( );
	    var title=[{username:'操作人员'},{equip_code_s:'机台名称'},{material_code_s:'物料规格'},{material_name_s:'规格描述'},{class_id_s:'硫化班次'}
	             ,{totalquantity:'总产量'},{gradea:'A级'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
	             ,{specialwaste:'特废'},{curing_openmoulddate:'完成工时'},{curing_closemoulddate:'定额完成率'},{qualitycompletionrate:'质量达成率'}]; 
	    toExcel("硫化结果汇总"+time,data,title);
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
                    	 if(k=="curing_openmoulddate"){
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
                    	 }
                    	 if(k=="class_id_s"){
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
        excelFile += "硫化产量等级";  
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