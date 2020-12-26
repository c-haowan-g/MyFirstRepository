<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"finalcheck/reportCenter/curing/saveChanges";
    
    function showOrHide(){
        if($("#MainTyre_search_form").is(":hidden")){
            $("#MainTyre_search_form").show();
        }else{
            $("#MainTyre_search_form").hide();
        }
    }
	//设定时间初始值从当前时间00:00:00至23:59:59
	$(document).ready(function() {
        $("#begin_created_time").datetimebox({
            value:'3/4/2010 00:00:00',
            required: false,
            showSeconds: true
        });
        $("#end_created_time").datetimebox({
            value:'3/4/2010 23:59:59',
            required: false,
            showSeconds: true
        });
		filter();
	});
	
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#maintyre_dg").datagrid("options");
		opts.url = 'finalcheck/reportCenter/curing/datagridappearanceonetimecheckrate';
        ext.easyui.grid.search("maintyre_dg","MainTyre_search_form");
    }
    //外观一次交检率
    function rateformatter(v,r,i){
    	if(r.totalnum=='0'){
    		return '0%';
    	}
    	return (r.onetimepass_count/r.totalnum*100).toFixed(2)+"%";
    }
    //缺胶数量=前面几个汇总
    function quejiaoformatter(v,r,i){
    	var value= parseInt(r.taiquanquejiao_count_s)+parseInt(r.taicequejiao_count_s)+parseInt(r.taiguanquejiao_count_s)+parseInt(r.taijianquejiao_count_s);
    	return value;
    }
    //缺陷合计
    function reasformatter(v,r,i){
    	var value= 
        parseInt(r.taiquanquejiao_count_s)+parseInt(r.taicequejiao_count_s)+parseInt(r.taiguanquejiao_count_s)+parseInt(r.taijianquejiao_count_s)+
    	parseInt(r.zawu_count_s)+
    	parseInt(r.jiaobian_count_s)+
    	parseInt(r.gemaosunshang_count_s)+
    	parseInt(r.taiquanqipao_count_s)+
    	parseInt(r.others_count_s);
    	return value;
    }
    //导出数据
    function excelexport(){
    	 //获取grid 数据
	    var node = $("#maintyre_dg").datagrid("getSelections");
	    if (node == "") {
			ext.tip.error("<spring:message code="tip.excel" />");
			return;	
		}
	    var data = JSON.stringify(node);
	    if (data == '')
	        return;
	    var myDate = new Date();
	    var time=myDate.toLocaleString( );
	    outCsv(data, "外观一次交检合格率报表"+time, true);
    }
	function outCsv(JSONData, ReportTitle, ShowLabel) {
	    var CSV = '';
	    /*在第一集的行或行报告title */
	    /* 如果JSONData不是一个对象然后JSON.parse将解析对象中的JSON字符串  */
	    var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
	    /*这将产生的header label*/
	    if (ShowLabel) {
	        var row = "";
	        /*  这个循环将从数组的第一个索引中提取标签。 */
	        for (var index in arrData[0]) {
	        	/*现在将每个值的字符串，用逗号分开   根据实际情况重新赋值 */
	        	
	        	if(index=="checkdate"){
	        		index='<spring:message code="checktrimlog.column.created_time_t" />';
	        	}
	        	
	        	if(index=="banci"){
	        		index='<spring:message code="messapproduction.column.class_id_s" />';
	        	}
	        	
	        	if(index=="totalnum"){
	        		index='<spring:message code="maintyre.column.curingspeccode_count_s" />';
	        	}
	        	if(index=="onetimepass_count"){
	        		index='<spring:message code="maintype.column.onetimepass_count" />';
	        	}
	        	if(index=="onetime_rate"){
	        		index='<spring:message code="maintype.column.onetime_rate" />';
	        	}
	        	if(index=="taiquanquejiao_count_s"){
	        		index='<spring:message code="maintyre.column.taiquanquejiao_count_s" />';
	        	}
	        	if(index=="taicequejiao_count_s"){
	        		index='<spring:message code="maintyre.column.taicequejiao_count_s" />';
	        	}
	        	if(index=="taiguanquejiao_count_s"){
	        		index='<spring:message code="maintyre.column.taiguanquejiao_count_s" />';
	        	}
	        	if(index=="taijianquejiao_count_s"){
	        		index='<spring:message code="maintyre.column.taijianquejiao_count_s" />';
	        	}
	        	if(index=="quejiao_count_s"){
	        		index='<spring:message code="maintyre.column.quejiao_count_s" />';
	        	}
	        	if(index=="zawu_count_s"){
	        		index='<spring:message code="maintyre.column.zawu_count_s" />';
	        	}
	        	
	        	if(index=="jiaobian_count_s"){
	        		index='<spring:message code="maintyre.column.jiaobian_count_s" />';
	        	}
	        	if(index=="gemaosunshang_count_s"){
	        		index='<spring:message code="maintyre.column.gemaosunshang_count_s" />';
	        	}
	        	if(index=="taiquanqipao_count_s"){
	        		index='<spring:message code="maintyre.column.taiquanqipao_count_s" />';
	        	}
	        	if(index=="feicipin_count_s"){
	        		index='<spring:message code="maintyre.column.feicipin_count_s" />';
	        	}
	        	if(index=="totalrework_count_s"){
	        		index='<spring:message code="maintyre.column.totalrework_count_s" />';
	        	}
	        	if(index=="others_count_s"){
	        		index='<spring:message code="maintyre.column.others_count_s" />';
	        	}
	        	if(index=="rease_count_s"){
	        		index='<spring:message code="maintyre.column.rease_count_s" />';
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
	            row += '"' + arrData[i][index] + '",';
	        }
	        console.log(row)
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
</script>