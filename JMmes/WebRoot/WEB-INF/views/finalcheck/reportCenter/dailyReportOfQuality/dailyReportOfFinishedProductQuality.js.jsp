<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var index = "a";//选择合并所有行用到
	function codeFormatter(v, r, i) {

		return dictFormat(v);
	}

	//设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
		$("#begin_created_time").datetimebox({
			value : '3/4/2010 00:00:00',
			required : true,
			showSeconds : true
		});
		$("#end_created_time").datetimebox({
			value : '3/4/2010 23:59:59',
			required : true,
			showSeconds : true
		});
		//filter();
	});

	 function filter(){
	    var data=$("#DailyReportOfFinishedProductQualityInspection_dg").datagrid("options");
	    data.url="finalcheck/reportCenter/dailyReportOfQuality/datagrid2";
	    ext.easyui.grid.search("DailyReportOfFinishedProductQualityInspection_dg","DailyReportOfFinishedProductQualityInspection_search_form");
	 } 

	var rowspan = 1;
	//将表格数据导出到Excel
	function ExcelExport() {
		//获取grid 数据
		var node = $("#DailyReportOfFinishedProductQualityInspection_dg")
				.datagrid("getSelections");
		if (node == "") {
			ext.tip.error("<spring:message code="tip.excel" />");
			return;
		}

		/* for (var i = node.length - 1; i > 0; i--) {
			//判断是否存在合并数据
			if (node[i]["CURINGSPECCODE_S"] == node[i - 1]["CURINGSPECCODE_S"]
					&& node[i]["MATERIALSPEC_S"] == node[i - 1]["MATERIALSPEC_S"]
					&& node[i]["PATTERN_S"] == node[i - 1]["PATTERN_S"]) {
				rowspan++;
				delete node[i]["CURINGSPECCODE_S"];
				delete node[i]["MATERIALSPEC_S"];
				delete node[i]["PATTERN_S"];
			} else {
				node[i - 1].rowspan = rowspan;//遍历遇到不同数据的时候停止累加，向数组里添加合并数量
				rowspan = 1;//遍历遇到不同数据的时候停止累加，初始化变量
			}
			node[i - 1].rowspan = rowspan;
		} */

		var data = JSON.stringify(node);
		if (data == '')
			return;
		var myDate = new Date();
		var time = myDate.toLocaleString();
		//outCsv(data, "成品质量检查日报表" + time, true);
		var title = [ {
			CURINGSPECCODE_S : '物料编码'
		}, {
			MATERIALSPEC_S : '产品规格'
		}, {
			PATTERN_S : '花纹'
		}, {
			A_COUNT_S : 'A级品数量'
		}, {
			B_COUNT_S : 'B级品数量'
		}, {
			YIJI_COUNT_S : '一级品数量'
		}, {
			ERJI_COUNT_S : '二级品数量'
		}, {
			FEIPIN_COUNT_S : '废品数量'
		},{
			BUHEGE_COUNT_S : '不合格品数量'
		} ];
		toExcel("成品质量检查日报表" + time, data, title);

	}

	/* //合并单元格
	function onLoadSuccess(data) {
		var mark = 1; //这里涉及到简单的运算，mark是计算每次需要合并的格子数
		for (var i = 1; i < data.rows.length; i++) { //这里循环表格当前的数据
			if ((data.rows[i]['CURINGSPECCODE_S'] == data.rows[i - 1]['CURINGSPECCODE_S'])) { //后一行的值与前一行的值做比较，相同就需要合并
				mark += 1;
				$(this).datagrid('mergeCells', { //判断合并复选框
					index : i + 1 - mark,
					field : 'ATR_KEY',
					rowspan : mark
				});
				$(this).datagrid('mergeCells', { //这是判断物料编号
					index : i + 1 - mark,
					field : 'CURINGSPECCODE_S',
					rowspan : mark
				});
				if ((data.rows[i]['MATERIALSPEC_S'] == data.rows[i - 1]['MATERIALSPEC_S'])) {
					$(this).datagrid('mergeCells', { //这是判断规格
						index : i + 1 - mark,
						field : 'MATERIALSPEC_S',
						rowspan : mark
					});
					if ((data.rows[i]['PATTERN_S'] == data.rows[i - 1]['PATTERN_S'])) {
						$(this).datagrid('mergeCells', { //这是判断花纹
							index : i + 1 - mark,
							field : 'PATTERN_S',
							rowspan : mark
						});
					}
				}
			} else {
				mark = 1;
			}
		}
	} */

	/**
	 * 接收病象数据
	 */
	var ReasInfo = [];

	$.ajax({
		url : "finalcheck/baseData/reas/comboxReasCodeDesc",
		type : "get",
		dataType : "json",
		async : false,
		success : function(data) {
			ReasInfo = data;
		}
	});
	//缺陷描述显示
	function reasformatter(v, r, i) {
		for (var i = 0; i < ReasInfo.length; i++) {
			if (ReasInfo[i].REASCODE == v) {
				return ReasInfo[i].REASDESC;
			}
		}
	}

	//-----------------------------点击选中合并的所有行
	//判断rowIndex是否被选中
	//调用方法：$("#dg").datagrid("isChecked", { rowIndex: rowIndex })
	/* $.extend($.fn.datagrid.methods, {
		isChecked : function(dg, param) {
			var flag = false;//是否选中
			var allRows = $(dg).datagrid('getChecked'); //获取所有被选中的行
			$.each(allRows, function(index, item) {
				if (param.rowIndex == $(dg).datagrid('getRowIndex', item)) {
					flag = true;
					return false;//return false终止循环，return true,跳出循环，进入下一次循环，跟函数返回值无关
				}
			});
			return flag;
		}
	});

	function onCheck(rowIndex, rowData) {
		if (index == "a") {
			index = rowIndex;
			var CURINGSPECCODE_S = rowData["CURINGSPECCODE_S"];
			var rows = $("#DailyReportOfFinishedProductQualityInspection_dg")
					.datagrid("getRows");
			for (var i = 0; i < rows.length; i++) {
				if (rows[i]["CURINGSPECCODE_S"] == CURINGSPECCODE_S) {
					$("#DailyReportOfFinishedProductQualityInspection_dg")
							.datagrid("checkRow", i);
				}
			}
			index = "a";
		}
	}
	function onUncheck(rowIndex, rowData) {
		if (index == "a") {
			index = rowIndex;
			var CURINGSPECCODE_S = rowData["CURINGSPECCODE_S"];
			var rows = $("#DailyReportOfFinishedProductQualityInspection_dg")
					.datagrid("getRows");
			for (var i = 0; i < rows.length; i++) {
				if (rows[i]["CURINGSPECCODE_S"] == CURINGSPECCODE_S) {
					$("#DailyReportOfFinishedProductQualityInspection_dg")
							.datagrid("uncheckRow", i);

				}
			}
			index = "a";
		}
	} */

	
	//表格样式
	function toExcel(FileName, JSONData, ShowLabel) {
		intTable();//初始化表格
		//先转化json  
		var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
				: JSONData;
		var excel = "<table id='myTable' >";
		//设置表头  
		var row = "<tr align='left'>";//设置Excel的左居中
		for (var i = 0, l = ShowLabel.length; i < l; i++) {
			for ( var key in ShowLabel[i]) {
				if(key=='MATERIALSPEC_S'){
					row += "<td colspan='5' style='font-weight:bold;font-size:17px;border-bottom:1px solid black;'>"
						+ ShowLabel[i][key] + "</td>";
				}else{
					row += "<td style='font-weight:bold;font-size:17px;border-bottom:1px solid black;' >"
						+ ShowLabel[i][key] + "</td>";
				}
			}
		}
		//换行  
		excel += row + "</tr>";

		//设置数据  
		for (var i = 0; i < arrData.length; i++) {
			var rowData = "<tr align='left'>";

			for (var y = 0; y < ShowLabel.length; y++) {

				for ( var k in ShowLabel[y]) {
					if (ShowLabel[y].hasOwnProperty(k)) {
						//vnd.ms-excel.numberformat:@ 输出为文本
						if (k == "CURINGSPECCODE_S"
								&& arrData[i][k] != undefined) {
							console.log(arrData[i]["rowspan"])
							//物料编码
							rowData += "<td  style='vnd.ms-excel.numberformat:@;border-bottom:thin solid black;'>"
									+ (arrData[i][k] === null ? ""
											: arrData[i][k]) + "</td>";
						} else if (k == "MATERIALSPEC_S"
								&& arrData[i][k] != undefined) {
							//规格
							rowData += "<td  colspan='5' style='vnd.ms-excel.numberformat:@;border-bottom:thin solid black;'>"
									+ (arrData[i][k] === null ? ""
											: arrData[i][k]) + "</td>";
						} else if (k == "PATTERN_S"
								&& arrData[i][k] != undefined) {
							//花纹
							rowData += "<td  style='vnd.ms-excel.numberformat:@;border-bottom:thin solid black;'>"
									+ (arrData[i][k] === null ? ""
											: arrData[i][k]) + "</td>";
						} else if (arrData[i][k] != undefined) {
							rowData += "<td style='vnd.ms-excel.numberformat:@;border-bottom:thin solid black;'>"
									+ (arrData[i][k] === null ? ""
											: arrData[i][k]) + "</td>";
						}
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
		excelFile += "成品质量检查日报表";
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

		// 如果浏览器是IE
		if (window.navigator.msSaveOrOpenBlob) {
			var blob = new Blob(
					[ decodeURIComponent(encodeURIComponent(excelFile)) ], {
						type : "data:text/csv;charset=utf-8,"
					});
			navigator.msSaveBlob(blob, FileName + '.xls');
		} else {
			var uri = 'data:application/vnd.ms-excel;charset=utf-8,'
					+ encodeURIComponent(excelFile);
			var link = document.createElement("a");
			link.href = uri;
			link.style = "visibility:hidden";
			link.download = FileName + ".xls";
			document.body.appendChild(link);
			link.click();
			document.body.removeChild(link);
		}
		rowspan = 1;//初始化合并行变量
	}

	//-----------------以下暂且不用
	function outCsv(JSONData, ReportTitle, ShowLabel) {
		var CSV = '';
		/*在第一集的行或行报告title */
		//CSV += "成品质量检查日报表" + '\r\n';
		/* 如果JSONData不是一个对象然后JSON.parse将解析对象中的JSON字符串  */
		var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
				: JSONData;
		/*这将产生的header label*/
		if (ShowLabel) {
			var row = "";
			/*  这个循环将从数组的第一个索引中提取标签。 */
			for ( var index in arrData[0]) {
				/*现在将每个值的字符串，用逗号分开   根据实际情况重新赋值 */
				if (index == "CURINGSPECCODE_S") {
					index = '<spring:message code="maintyre.column.curingspeccode_s" />';
				}
				if (index == "MATERIALSPEC_S") {
					index = '<spring:message code="visualmchecksumprint.column.product_standard_s" />';
				}
				if (index == "PATTERN_S") {
					index = '<spring:message code="dynamicbalance.column.pattern_s" />';
				}
				if (index == "ERJI_COUNT_S") {
					index = '<spring:message code="visualmchecksumprint.column.secondlevel_count_s" />';
				}
				if (index == "FEIPIN_COUNT_S") {
					index = '<spring:message code="dynabalancecheresultprint.column.fp_count_s" />';
				}
				if (index == "REASCODE_S") {
					index = '<spring:message code="dailyReport.column.reascode_s" />';
				}
				if (index == "REASCODE_COUNT_S") {
					index = '<spring:message code="hhhh.column.reascode_count_s" />';
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
			for ( var index in arrData[i]) {
				row += '"' + arrData[i][index] + '",';
			}

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
			var blob = new Blob([ decodeURIComponent(encodeURI(uriie)) ], {
				type : "data:text/csv;charset=utf-8,"
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
</script>