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
	    filter();
	});
	//上限值
	var valueMax;
	//下限值
	var valueMin;
	function getWeightData(){
		$.ajax({
			url : 'building/productionManagement/workOrderResult/getWeightData',
			type : 'get',
			dataType : 'json',
			async : false,
			success : function(data) {
				valueMax = data[0].VALUEMAX_S.substring(1,data[0].VALUEMAX_S.length);
				valueMin = data[0].VALUEMIN_S.substring(1,data[0].VALUEMIN_S.length);
			}
		});
	} 
	function onEquipSelect(){
		var eqname = $('#formula_index_s').combobox('getValue');
		if(eqname=="360004"){
			$.ajax({
				url : 'building/productionManagement/workOrderResult/search',
				type : 'get',
				dataType : 'json',
				 /* data: {
					eqname: eqname
				}, */  
				async : false,
				success : function(data) {
					console.log(data);
					$("#workorderresult_dg").datagrid('loadData',data);
				}
			});
			
		}
		
		
	}
	
	
	 //$("#formula_index_s").is("")
	function classFormatter(v,r,i){
		if(v=='360001')
			return '新增';
		//filter();
		else if(v=='360002')
			return '条码替换';
		else if(v=='360003')
			return '规格更改';
		
		else
			return '';
	}
	
	
	function weightFormatter(value, rowData, rowIndex){
		if(rowData.spare5_s == null ){
			if(rowData.building_weight_s == null){
				return "";
			}
			return "合格";
		}
		return rowData.spare5_s;
	}
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
 		return dictFormat(v);
	}
	/**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(index,field){
        var rowId = $("#workorderresult_dg").datagrid("getEditor",{index:index,field:field});
        return rowId;
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
 		return v;
	}
	
    function showOrHide(){
        if($("#WorkorderResult_search_form").is(":hidden")){
            $("#WorkorderResult_search_form").show();
        }else{
            $("#WorkorderResult_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    /* 	var eqname = $('#formula_index_s').combobox('getValue');
    
    	if(eqname=="全部"){
    		var opt=$("#workorderresult_dg").datagrid("options");
	        opt.url='building/productionManagement/workOrderResult/search';
	        ext.easyui.grid.search("workorderresult_dg","WorkorderResult_search_form");
    		
    	}else if(eqname=="全部"||eqname==""||eqname=="360001"||eqname=="360002"||eqname=="360003"||eqname==""){
			var opts = $("#workorderresult_dg").datagrid("options");
			opts.url = 'building/productionManagement/workOrderResult/searchInit';
	        ext.easyui.grid.search("workorderresult_dg","WorkorderResult_search_form");
    	}
    
    } */
    var opts = $("#workorderresult_dg").datagrid("options");
	opts.url = 'building/productionManagement/workOrderResult/searchInit';
    ext.easyui.grid.search("workorderresult_dg","WorkorderResult_search_form"); 
    }   
    	
   
	function solid_yflag_s(value){
		if(value=='0'||value==''){
			return '否';
		}else if(value=='1'){
			return '是';
		}
	}
	
	function first_s(value){
		if(value=='0'){
			return '是';
		}else if(value=='1'){
			return '否';
		}
	}
	
    //导出
    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#workorderresult_dg").datagrid("getSelections");
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
	    var title=[{tyre_barcode_s:'胎胚条码'},
	               {plan_no_s:'日计划号'},
                   {work_order_id_s:'工单编号'},
	               {equip_code_s:'机台条码'},
	               {tire_car_code_s:'胎胚车号'},
	               {material_code_s:'物料编码'},
	               {material_name_s:'物料名称'},
	               {building_date_t:'产出时间 '},
	               {standard_weight_s:'标准重量'},
	               {building_weight_s:'胎胚重量'},
	               {max_weight_s:'胎胚上限重量'},
	               {min_weight_s:'胎胚下限重量'},
	               {quality_status_s:'质量状态'},
	               {add_flag_s:'是否补成型'},
	               {first_s:'是否首条'},
	               {workerMain_id_s:'一段操作工'},
	               {workerAssistant_id_s:'二段操作工'},
	               {solid_yflag_s:'是否固化'},
	               {solid_time_s:'固化时间'}]; 
	    toExcel("成型生成实绩查询"+time,data,title); 
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
        excelFile += "成型生成实绩查询";  
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
function doExport(){
    	var param=ext.form.getFormAsJson("WorkorderResult_search_form");
    	console.log(param)
    	var param_get="";
    	
    	for(var k in param){
    		param_get=param_get+"&"+k.replace("filter[","").replace("]","")+"="+param[k];
    	}
    	window.open(path+"building/productionManagement/workOrderResult/export?s_factory_s="+factory+param_get);
    }
</script>