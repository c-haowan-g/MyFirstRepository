<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/CuringOutputCollect/WorkOrderQuota/saveChanges";
    
    function showOrHide(){
        if($("#WorkOrderResultPrint_search_form").is(":hidden")){
            $("#WorkOrderResultPrint_search_form").show();
        }else{
            $("#WorkOrderResultPrint_search_form").hide();
        }
    }
    
    //主界面分页用(假分页，先查询页面，再走JS进行分页)
	function pagerFilter(data) {
	     if (typeof data.length == 'number' && typeof data.splice == 'function') {   // is array
	         data = {
	             total: data.length,
	             rows: data
	         }
	     }
	     var dg = $(this);
	     var opts = dg.datagrid('options');
	     var pager = dg.datagrid('getPager');
	     pager.pagination({
	         onSelectPage: function (pageNumber,pageSize) {
	             opts.pageNumber = pageNumber;
	             opts.pageSize = pageSize;
	             pager.pagination('refresh', {
	                 pageNumber: pageNumber,
	                 pageSize: pageSize
	             });
	             dg.datagrid('loadData', data);
	         },
	         onRefresh:function(){
	 	    	dg.datagrid('reload');
	    	 }
	     });
	     if (!data.originalRows) {
	         data.originalRows = (data.rows);
	     } 
	     var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
	     var end = start + parseInt(opts.pageSize);
	     data.rows = (data.originalRows.slice(start, end));
	     return data;
	 }
    
    /**
     * 查询方法
     */
   function filter(){
    	var change="";
    	var objs=document.getElementsByName("change");
    	for(var i=0;i<objs.length;i++){
    		if(objs[i].checked){
    			change+=objs[i].value+"_";
    		}
    	}
    	if(change==""){
    		 ext.tip.warn("最少选择一项进行查询");
    		 return;
    	}
    	
    	
    	
        var list_map={};
        list_map.begin_created_time=$('#begin_created_time').val();
        list_map.end_created_time=$('#end_created_time').val();
        list_map.material_code_s=$('#material_code_s').val();
        list_map.equip_code_s=$('#equip_code_s').val();
        list_map.change=change;
        $.ajax({
			url : 'curing/CuringOutputCollect/WorkOrderQuota/selectWorkOrderData',
			type : "post",
			dataType : "json",
			contentType:'application/json',
  	 		async:false,
  	 		data:JSON.stringify(list_map),
			success : function(data) {
				if(data.code==OK){
					var selectfieldarray=new Array();
			    	var unselectfieldarray=new Array();
			    	var isequipcodeselect =$("#equipcode").is(":checked");
			    	if(isequipcodeselect==true){
			    		selectfieldarray.push('equip_code_s');
			    	}else{
			    		unselectfieldarray.push('equip_code_s');
			    	}
			    	var ismaterialselect =$("#material").is(":checked");
			    	if(ismaterialselect==true){
			    		selectfieldarray.push('material_code_s');
			    		selectfieldarray.push('material_name_s');
			    	}else{
			    		unselectfieldarray.push('material_code_s');
			    		unselectfieldarray.push('material_name_s');
			    	}
			    	var iscuringidselect =$("#curingid").is(":checked");
			    	if(iscuringidselect==true){
			    		selectfieldarray.push('username');
			    	}else{
			    		unselectfieldarray.push('username');
			    	}
			    	
			    	 $.each(selectfieldarray, function(i, val){  
				    	 $('#workorderresultprint_dg').datagrid('showColumn', val);
					  }); 
			    	 $.each(unselectfieldarray, function(i, val){  
				    	 $('#workorderresultprint_dg').datagrid('hideColumn', val);
					  }); 
  	    			$("#workorderresultprint_dg").datagrid("loadData", data.data);
  	    			return;
  	    		}
				
			}
		});
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
	
	function qualitycompletionrate(v,r,i){
    	if(r.totalquantity=="")
 			return "";
    	return Math.floor((r.gradea/r.totalquantity/0.996*100)*1000)/1000+"%";
    }
	
    function remove() {

        var rows = $("#workorderresultprint_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#workorderresultprint_dg").datagrid("getRowIndex", rows[i]);
            $("#workorderresultprint_dg").datagrid("deleteRow", index);
        }

    }
	//上方行单击事件
	function clickRow(rowIndex, rowData){
		var objs=document.getElementsByName("change");
    	for(var i=0;i<objs.length;i++){
    		if(objs[i].checked){
    			change+=objs[i].value+"_";
    		}
    	}
    	var fieldarray=['atr_key','totalquantity','gradea','gradea0','secondlevel','waste','specialwaste','qualitycompletionrate']
    	if(change.indexOf("1")!=-1){
    	}
    	if(change.indexOf("2")!=-1){
    	}
    	if(change.indexOf("3")!=-1){
    	}
			//产出口特殊处理
		if(n!=null&&n.code=='161002'){
		    $.each(fieldarray, function(i, val){  
		    	 $('#equipment_dg_manage').datagrid('hideColumn', val);
			  }); 
		    $.each(fieldarray2, function(i, val){  
		    	 $('#equipment_dg_manage').datagrid('showColumn', val);
			  }); 
		}else{
			 $.each(fieldarray, function(i, val){  
		    	 $('#equipment_dg_manage').datagrid('showColumn', val);
			  }); 
		}
		if(n!=null&&n.code=='161001'){
		    $.each(fieldarray2, function(i, val){  
		    	 $('#equipment_dg_manage').datagrid('hideColumn', val);
			  });  
		}
		
		
		var productlinerow = $("#productline_dg_manage").datagrid('getSelected');
		if(productlinerow==null){
 			return;
		}
		var selectProductlinename = productlinerow.p_line_name;
		var url = 'common/basedata/productlinemanager/getEquipByProductlineName?plinename='+selectProductlinename;
		ext.ajax.get(url, function(data) {
			var newData=[];
			  if(n==null){
				  newData=data;
			  }else{
				  $.each(data, function(i, val){  
						 if(val.equip_type_s==n.code&&n!=null){
							 newData.push(data[i]);
						 }
					  });
			  }
			 $('#equipment_dg_manage').datagrid('loadData', newData);
			
		});
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

    
    function cancel() {
        $("#workorderresultprint_dg").datagrid("rejectChanges");
    }
    
    var length=0;//定义数据行数，用于
	function onLoadSuccess(data) {
		if (data.rows.length > 0) {
			length=data.rows;
			//alert(compute("gradea0"));
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
								material_name_s : "",
								class_id_s: '<spring:message code="dynabalancecheresultprint.column.total" />',
								totalquantity : totalquantity,
								gradea : gradea,
								gradea0 : gradea0,
								secondlevel : secondlevel,
								waste : waste,
								specialwaste : specialwaste
							});
		}
		
		//去掉合计行的CheckBox
		 var checkbox = $('div.datagrid-cell-check input[type=checkbox]');//先找到这个checkbox对象
		$(checkbox[checkbox.length - 1]).remove(); //将最后一个元素remove掉. 

	}
	
	//根据条件设置表格行背景颜色
	function setRowBgColor(index, row) {
		 if (row.material_name_s == "" && row.equip_code_s == "") {
			return 'background-color:yellow;color:black;font-weight: bold;';
		} 
	}
    
    function finishhours(v,r,i){
    	if(r.spare1_s=="")
    		return "";
    	debugger;
    	var hours=(r.spare1_s*100+2*100)/100;
    	//单台设备定额
    	var de=parseInt(450/hours*2);
    	de=parseInt(de);
    	console.log(de);
    	//单台工时
    	var dthours= 8/(de*10);
    	return (dthours*r.totalquantity).toFixed(4);
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
    
    function qualitycompletionrate(v,r,i){
    	if(r.totalquantity=="")
 			return "";
    	return Math.floor((r.gradea/r.totalquantity/1*100)*1000)/1000+"%";
    }

    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#workorderresultprint_dg").datagrid("getSelections");
    	if (node == "") {
    	
    		var change="";
    	var objs=document.getElementsByName("change");
    	for(var i=0;i<objs.length;i++){
    		if(objs[i].checked){
    			change+=objs[i].value+"_";
    		}
    	}
    	
    	
    	
        var list_map={};
        list_map.begin_created_time=$('#begin_created_time').val();
        list_map.end_created_time=$('#end_created_time').val();
        list_map.material_code_s=$('#material_code_s').val();
        list_map.equip_code_s=$('#equip_code_s').val();
        list_map.change=change;
        $.ajax({
			url : 'curing/CuringOutputCollect/WorkOrderQuota/selectWorkOrderData',
			type : "post",
			dataType : "json",
			contentType:'application/json',
  	 		async:false,
  	 		data:JSON.stringify(list_map),
			success : function(data) {
				node=data.data;
				
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
		//var CheckTotal = false;//检测是否选择合计行，true选中,false未选中
		for (var i = 0; i < node.length; i++) {
			totalquantity += parseFloat(node[i]["totalquantity"]);
			gradea += parseFloat(node[i]["gradea"]);
			gradea0 += parseFloat(node[i]["gradea0"]);
			secondlevel += parseFloat(node[i]["secondlevel"]);
			waste += parseFloat(node[i]["waste"]);
			specialwaste += parseFloat(node[i]["specialwaste"]);
			qualitycompletionrate = Math.floor((gradea/totalquantity/1*100)*1000)/1000+"%";
		}
		
		var newJson = {};
		
		var isequipcodeselect =$("#equipcode").is(":checked");
		var ismaterialselect =$("#material").is(":checked");
		var iscuringidselect =$("#curingid").is(":checked");
		if((isequipcodeselect==true)&&(ismaterialselect!=true)&&(iscuringidselect!=true)){
			newJson = {
					atr_key : "",
					equip_code_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					totalquantity : "" + totalquantity + "",
					gradea : "" + gradea + "",
					gradea0 :"" + gradea0 + "",
					secondlevel : "" + secondlevel + "",
					waste : "" + waste + "",
					specialwaste : "" + specialwaste + "",
					qualitycompletionrate: "" + qualitycompletionrate + ""
			};
		
		}
		
		if((isequipcodeselect!=true)&&(ismaterialselect==true)&&(iscuringidselect!=true)){
			newJson = {
					atr_key : "",
					material_code_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					material_name_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					totalquantity : "" + totalquantity + "",
					gradea : "" + gradea + "",
					gradea0 :"" + gradea0 + "",
					secondlevel : "" + secondlevel + "",
					waste : "" + waste + "",
					specialwaste : "" + specialwaste + "",
					qualitycompletionrate: "" + qualitycompletionrate + ""
			};
		
		}
		
		if((isequipcodeselect!=true)&&(ismaterialselect!=true)&&(iscuringidselect==true)){
			newJson = {
					atr_key : "",
					username : '<spring:message code="dynabalancecheresultprint.column.total" />',
					totalquantity : "" + totalquantity + "",
					gradea : "" + gradea + "",
					gradea0 :"" + gradea0 + "",
					secondlevel : "" + secondlevel + "",
					waste : "" + waste + "",
					specialwaste : "" + specialwaste + "",
					qualitycompletionrate: "" + qualitycompletionrate + ""
			};
		
		}
		
		if((isequipcodeselect==true)&&(ismaterialselect==true)&&(iscuringidselect!=true)){
			newJson = {
					atr_key : "",
					equip_code_s : "",
					material_code_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					material_name_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					totalquantity : "" + totalquantity + "",
					gradea : "" + gradea + "",
					gradea0 :"" + gradea0 + "",
					secondlevel : "" + secondlevel + "",
					waste : "" + waste + "",
					specialwaste : "" + specialwaste + "",
					qualitycompletionrate: "" + qualitycompletionrate + ""
			};
		
		}
		
		if((isequipcodeselect==true)&&(ismaterialselect!=true)&&(iscuringidselect==true)){
			newJson = {
					atr_key : "",
					equip_code_s : "",
					username : '<spring:message code="dynabalancecheresultprint.column.total" />',
					totalquantity : "" + totalquantity + "",
					gradea : "" + gradea + "",
					gradea0 :"" + gradea0 + "",
					secondlevel : "" + secondlevel + "",
					waste : "" + waste + "",
					specialwaste : "" + specialwaste + "",
					qualitycompletionrate: "" + qualitycompletionrate + ""
			};
		
		}
		
		if((isequipcodeselect!=true)&&(ismaterialselect==true)&&(iscuringidselect==true)){
			newJson = {
					atr_key : "",
					material_code_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					material_name_s : "",
					username : '<spring:message code="dynabalancecheresultprint.column.total" />',
					totalquantity : "" + totalquantity + "",
					gradea : "" + gradea + "",
					gradea0 :"" + gradea0 + "",
					secondlevel : "" + secondlevel + "",
					waste : "" + waste + "",
					specialwaste : "" + specialwaste + "",
					qualitycompletionrate: "" + qualitycompletionrate + ""
			};
		
		}
		
		if((isequipcodeselect==true)&&(ismaterialselect==true)&&(iscuringidselect==true)){
			newJson = {
					atr_key : "",
					equip_code_s:"",
					material_code_s : '<spring:message code="dynabalancecheresultprint.column.total" />',
					material_name_s : "",
					username : '<spring:message code="dynabalancecheresultprint.column.total" />',
					totalquantity : "" + totalquantity + "",
					gradea : "" + gradea + "",
					gradea0 :"" + gradea0 + "",
					secondlevel : "" + secondlevel + "",
					waste : "" + waste + "",
					specialwaste : "" + specialwaste + "",
					qualitycompletionrate: "" + qualitycompletionrate + ""
			};
		
		}
		
      	
			node.push(newJson);
    	//debugger;
	    var data = JSON.stringify(node);
	    if (data == '')
	        return;
	    var myDate = new Date();
	    var time=myDate.toLocaleString( );
	    var title=[];
	    if((isequipcodeselect==true)&&(ismaterialselect!=true)&&(iscuringidselect!=true)){
	    	 title=[{equip_code_s:'机台名称'}
	             ,{totalquantity:'总产量'},{gradea:'A'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
	             ,{specialwaste:'特废'},{qualitycompletionrate:'质量达成率'}]; 
	    
	    }
	    if((isequipcodeselect!=true)&&(ismaterialselect==true)&&(iscuringidselect!=true)){
	    	 title=[{material_code_s:'物料编码'},{material_name_s:'物料规格'}
	             ,{totalquantity:'总产量'},{gradea:'A'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
	             ,{specialwaste:'特废'},{qualitycompletionrate:'质量达成率'}]; 
	    
	    }
	    if((isequipcodeselect!=true)&&(ismaterialselect!=true)&&(iscuringidselect==true)){
	    	 title=[{username:'操作人员'}
	             ,{totalquantity:'总产量'},{gradea:'A'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
	             ,{specialwaste:'特废'},{qualitycompletionrate:'质量达成率'}]; 
	    
	    }
	    
	    if((isequipcodeselect==true)&&(ismaterialselect==true)&&(iscuringidselect!=true)){
	    	 title=[{equip_code_s:'机台名称'},{material_code_s:'物料编码'},{material_name_s:'物料规格'}
	             ,{totalquantity:'总产量'},{gradea:'A'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
	             ,{specialwaste:'特废'},{qualitycompletionrate:'质量达成率'}]; 
	    
	    }
	    
	    if((isequipcodeselect==true)&&(ismaterialselect!=true)&&(iscuringidselect==true)){
	    	 title=[{equip_code_s:'机台名称'},{username:'操作人员'}
	             ,{totalquantity:'总产量'},{gradea:'A'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
	             ,{specialwaste:'特废'},{qualitycompletionrate:'质量达成率'}]; 
	    
	    }
	    
	    if((isequipcodeselect!=true)&&(ismaterialselect==true)&&(iscuringidselect==true)){
	    	 title=[{material_code_s:'物料编码'},{material_name_s:'物料规格'},{username:'操作人员'}
	             ,{totalquantity:'总产量'},{gradea:'A'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
	             ,{specialwaste:'特废'},{qualitycompletionrate:'质量达成率'}]; 
	    
	    }
	    if((isequipcodeselect==true)&&(ismaterialselect==true)&&(iscuringidselect==true)){
	    	 title=[{equip_code_s:'机台名称'},{material_code_s:'物料编码'},{material_name_s:'物料规格'},{username:'操作人员'}
	             ,{totalquantity:'总产量'},{gradea:'A'},{gradea0:'A0'},{secondlevel:'二级品'},{waste:'废品'}
	             ,{specialwaste:'特废'},{qualitycompletionrate:'质量达成率'}]; 
	    
	    }
	    
	    
	    toExcel("硫化产量汇总"+time,data,title);
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
	        		index = '<spring:message code="workorderresultprint.column.created_by_s" />';
	        		continue;
	        	}
	        	if (index == "equip_code_s") {
	        		index = '<spring:message code="workorderresultprint.column.equip_code_s" />';
	        		continue;
	        	}
	        	if (index == "material_code_s") {
	        		index = '<spring:message code="workorderresultprint.column.material_code_s" />';
	        		continue;
	        	}
	        	if (index == "material_name_s") {
	        		index = '<spring:message code="workorderresultprint.column.material_name_s" />';
	        		continue;
	        	}
	        	if(index=="totalquantity"){
	        		index='<spring:message code="workorderresultprint.column.TotalQuantity" />';
	        		continue;
	        	}
	        	if(index=="gradea"){
	        		index='<spring:message code="workorderresultprint.column.GradeA" />';
	        		continue;
	        	}
	        	if(index=="gradea0"){
	        		index='<spring:message code="workorderresultprint.column.GradeA0" />';
	        		continue;
	        	}
	        	if(index=="secondlevel"){
	        		index= '<spring:message code="workorderresultprint.column.secondlevel" />';
	        		continue;
	        	}
	        	if(index=="waste"){
	        		index= '<spring:message code="workorderresultprint.column.waste" />';
	        		continue;
	        	}
	        	if(index=="specialwaste"){
	        		index= '<spring:message code="workorderresultprint.column.specialwaste" />';
	        		continue;
	        	}
	        	if(index=="spare1_s"){
	        		index= '<spring:message code="workorderresultprint.column.curringalltime" />';
	        		continue;
	        	}
	        	if(index=="qualitycompletionrate"){
	        		index='<spring:message code="workorderresultprint.column.qualitycompletionrate" />';
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
	        	if(index=="class_id_s"){
	        		continue;
	        	}else if(index =="atr_key"){
	        		continue;
	        	}else{
	            	row += '"' + arrData[i][index] + '",';
	            }
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
	
	function classFormatter(v,r,i){
		if(v=='302001')
			return '早班'
		else if(v=='302002')
			return '中班'
		else if(v=='302003')
			return '晚班'
		else
			return ''
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
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]*arrData[i]['totalquantity']).toFixed(4) + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="curing_closemoulddate"){					
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.floor(arrData[i][k]*100*1000)/1000+'%'; + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="qualitycompletionrate"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.floor(arrData[i]['gradea']/arrData[i]['totalquantity']/1*100*1000)/1000+'%'; + "</td>";
                    		 continue;
                    	 }
                    	 if(k=="class_id_s"){
                    		 if(arrData[i][k]==="302001")
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('早班') + "</td>";
                    		 else if(arrData[i][k]==="302002")
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('中班') + "</td>";
                    		 else if(arrData[i][k]==="302003")
                    			 rowData += "<td style='vnd.ms-excel.numberformat:@'>" + ('晚班') + "</td>";
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