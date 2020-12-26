<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

  

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
		intTable();
	});
	
	//初始化表格
	function intTable(){
		   $("#dynamicbalancetestreport_dg").datagrid("options").url="finalcheck/reportCenter/DynaBalanceTestReport/filter";
		   ext.easyui.grid.search("dynamicbalancetestreport_dg","DynaBalanceTestReport_search_form");
	}
	
	function onLoadSuccess(data) {
		console.log("111");
		if (data.rows.length > 0) {
        //添加“合计”列
        $('#dynamicbalancetestreport_dg').datagrid('appendRow', {
        	curingspeccode_s:"",
        	description:'<spring:message code="dynabalancecheresultprint.column.total" />',
        	speccount:compute("speccount"),
        	dpha1:compute("dpha1"),
        	dpha1pinlv:divide(compute("dpha1"),compute("speccount")),
        	tdda1:compute("tdda1"),
        	tdda1pinlv:divide(compute("tdda1"),compute("speccount")),
        	a1:compute("a1"),
        	a1pinlv:divide(compute("a1"),compute("speccount")),
        	dpha:compute("dpha"),
        	dphapinlv:divide(compute("dpha"),compute("speccount")),
        	tdda:compute("tdda"),
        	tddapinlv:divide(compute("tdda"),compute("speccount")),
        	a:compute("a"),
        	apinlv:divide(compute("a"),compute("speccount")),
        	dpha0:compute("dpha0"),
        	dpha0pinlv:divide(compute("dpha0"),compute("speccount")),
        	tdda0:compute("tdda0"),
        	tdda0pinlv:divide(compute("tdda0"),compute("speccount")),
        	a0:compute("a0"),
        	a0pinlv:divide(compute("a0"),compute("speccount")),
        	dphd:compute("dphd"),
        	dphdpinlv:divide(compute("dphd"),compute("speccount")),
        	tddd:compute("tddd"),
        	tdddpinlv:divide(compute("tddd"),compute("speccount")),
        	erji:compute("erji"),
        	erjipinlv:divide(compute("erji"),compute("speccount")),
        });
		}
        var checkbox = $('div.datagrid-cell-check input[type=checkbox]');//先找到这个checkbox对象
		$(checkbox[checkbox.length-1]).remove(); //将最后一个元素remove掉. 
    }
	
	//最后一行禁止选中,重写easyui的onCheckAll方法,不选择最后一行, 并使用prop将全选按钮设为checked
	var onCheckAll =function (rowIndex, rowData){
		$('#dynamicbalancetestreport_dg').datagrid('uncheckRow', rowIndex.length-1); //不选择最后一行
		var checkboxHeader = $('div.datagrid-header-check input[type=checkbox]');//取到全选全不选这个元素
		checkboxHeader.prop("checked","checked");//将其设置为checked即可
	}
   /*  //禁止选中合计行
    var onClickRow = function(rowIndex, rowData) {
		$(this).datagrid('unselectRow', length);
	} */
    //指定列求和
    function compute(colName) {
        var rows = $('#dynamicbalancetestreport_dg').datagrid('getRows');
        var total = 0;
        for (var i = 0; i < rows.length; i++) {
            total += parseFloat(rows[i][colName]);
        }
        return total;
    }
    
    //指定列相除
    function divide(colName1,colName2) {
        var total = 0;
        if(colName2!=0){
        total=(colName1/colName2*100).toFixed(2)+"%";
        }else{
        total="0.00%";
        }
        return total;
    } 
    //根据条件设置表格行背景颜色
    function setRowBgColor(index, row) {
        if (row.curingspeccode_s == "") {
            return 'background-color:yellow;color:black;font-weight: bold;';
        }
    }
	
	
	
	//将表格数据导出到Excel
	function ExcelExport() {
	    //获取grid 数据
	    var node = $("#dynamicbalancetestreport_dg").datagrid("getSelections");
	    if (node == "") {
			var param=ext.form.getFormAsJson("DynaBalanceTestReport_search_form");
        	var param_get="";
        	for(var k in param){
        		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
        	}
    		$.ajax({
    			url : "finalcheck/reportCenter/DynaBalanceTestReport/searchBy?s_factory_s="+factory+"&"+param_get,
    			type : 'get',
    			dataType : 'json',
    			async : false,
    			success : function(data) {
    			     node = data; 
    			}
    		});
		}
	    if (node.length > 0) {
			for (var i = 0; i < node.length; i++) {
				if (node[i]["description"] == '<spring:message code="dynabalancecheresultprint.column.total" />') {
					//CheckTotal = true;
					node.pop();
				}
			}
		}
	    var speccount=0;
	    var dpha1=0;
	    var dpha1pinlv=0;
	    var tdda1=0;
	    var tdda1pinlv=0;
	    var a1=0;
	    var a1pinlv=0;
	    
	    var dpha=0;
	    var dphapinlv=0;
	    var tdda=0;
	    var tddapinlv=0;
	    var a=0;
	    var apinlv=0;
	    
	    var dpha0=0;
	    var dpha0pinlv=0;
	    var tdda0=0;
	    var tdda0pinlv=0;
	    var a0=0;
	    var a0pinlv=0;
	    
	    var dphd=0;
	    var dphdpinlv=0;
	    var tddd=0;
	    var tdddpinlv=0;
	    var erji=0;
	    var erjipinlv=0;
	    var CheckTotal=false;//检测是否选择合计行，true选中,false未选中
   		for (var i = 0; i < node.length; i++) { 
   			
   			speccount+= parseFloat(node[i]["speccount"]);
   			dpha1+= parseFloat(node[i]["dpha1"]);
   			dpha1pinlv= divide(dpha1,speccount);
   			tdda1+= parseFloat(node[i]["tdda1"]);
   			tdda1pinlv = divide(tdda1,speccount);
   			a1+= parseFloat(node[i]["a1"]);
   			a1pinlv = divide(a1,speccount);
   			
   			dpha+= parseFloat(node[i]["dpha"]);
   			dphapinlv= divide(dpha,speccount);
   			tdda+= parseFloat(node[i]["tdda"]);
   			tddapinlv = divide(tdda,speccount);
   			a+= parseFloat(node[i]["a"]);
   			apinlv = divide(a,speccount);
   			
   			dpha0+= parseFloat(node[i]["dpha0"]);
   			dpha0pinlv= divide(dpha0,speccount);
   			tdda0+= parseFloat(node[i]["tdda0"]);
   			tdda0pinlv = divide(tdda0,speccount);
   			a0+= parseFloat(node[i]["a0"]);
   			a0pinlv = divide(a0,speccount);
   			
   			dphd+= parseFloat(node[i]["dphd"]);
   			dphdpinlv= divide(dphd,speccount);
   			tddd+= parseFloat(node[i]["tddd"]);
   			tdddpinlv = divide(tddd,speccount);
   			erji+= parseFloat(node[i]["erji"]);
   			erjipinlv = divide(erji,speccount);
   			if(node[i]["description"]=='<spring:message code="dynabalancecheresultprint.column.total" />'){
   				CheckTotal=true;
      		}
   		}
   		
   		if(!CheckTotal){
   		//导出添加合计行
   	 		var newJson={curingspeccode_s:"",description:"<spring:message code="dynabalancecheresultprint.column.total" />",speccount:""+speccount+"",dpha1:""+dpha1+"",dpha1pinlv:""+dpha1pinlv+"",tdda1:""+tdda1+"",tdda1pinlv:""+tdda1pinlv+"",a1:""+a1+"",a1pinlv:""+a1pinlv+"",dpha:""+dpha+"",dphapinlv:""+dphapinlv+"",tdda:""+tdda+"",tddapinlv:""+tddapinlv+"",a:""+a+"",apinlv:""+apinlv+"",dpha0:""+dpha0+"",dpha0pinlv:""+dpha0pinlv+"",tdda0:""+tdda0+"",tdda0pinlv:""+tdda0pinlv+"",a0:""+a0+"",a0pinlv:""+a0pinlv+"",dphd:""+dphd+"",dphdpinlv:""+dphdpinlv+"",tddd:""+tddd+"",tdddpinlv:""+tdddpinlv+"",erji:""+erji+"",erjipinlv:""+erjipinlv+""}; 
   	 		node.push(newJson); 	
   		}
   	
    	
	    var data = JSON.stringify(node);
	    if (data == '')
	        return;
	    var myDate = new Date();
	    var time=myDate.toLocaleString( );
	    var title = [ {
			curingspeccode_s : '物料编码'
		}, {
			description : '物料描述'
		},{
			speccount : '受检总数'
		},{
			dpha1 : '动平衡A+1'
		}, {
			dpha1pinlv : '动平衡A+1品率'
		}, {
			tdda1 : '跳动度A+1'
		}, {
			tdda1pinlv : '跳动度A+1品率'
		}, {
			a1 : 'A+1'
		}, {
			a1pinlv : 'A+1品率'
		}, {
			dpha : '动平衡A'
		}, {
			dphapinlv : '动平衡A品率'
		},{
			tdda : '跳动度A'
		},{
			tddapinlv : '跳动度A品率'
		},{
			a : 'A'
		},{
			apinlv : 'A品率'
		},{
			dpha0 : '动平衡A0'
		},{
			dpha0pinlv : '动平衡A0品率'
		},{
			tdda0 : '跳动度A0'
		},{
			tdda0pinlv : '跳动度A0品率'
		},{
			a0 : 'A0'
		},{
			a0pinlv : 'A0品率'
		},{
			dphd : '动平衡D'
		},{
			dphdpinlv : '动平衡D品率'
		},{
			tddd : '跳动度D'
		},{
			tdddpinlv : '跳动度D品率'
		},{
			erji : '二级'
		},{
			erjipinlv : '二级品率'
		}];
		toExcel("动平衡检测报表" + time, data, title);
	}
	
	function toExcel(FileName, JSONData, ShowLabel) {
		//先转化json  
		var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
				: JSONData;
		var excel = '<table>';
		//设置表头  
		var row = "<tr align='left'>";//设置Excel的左居中
		for (var i = 0, l = ShowLabel.length; i < l; i++) {
			for ( var key in ShowLabel[i]) {
					row += "<td style='font-weight:bold;font-size:17px;border-bottom:1px solid black;' >"
						+ ShowLabel[i][key] + "</td>";
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
						rowData += "<td style='vnd.ms-excel.numberformat:@;border-bottom:thin solid black;'>"
							+ (arrData[i][k] === null ? "" : arrData[i][k]) + "</td>";
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
		excelFile += "动平衡检测报表";
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
	}

  
</script>