<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	//设定时间初始值从当前时间00:00:00至23:59:59
	$(function() {
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
	});
	
	function getData(){
		var starttime =$("#begin_created_time").datetimebox("getValue");
		var endtime=$("#end_created_time").datetimebox("getValue");
		var checked=$('input[type=checkbox]:checked');
	    if('undefined'==typeof(checked.val())){
	      	ext.tip.error("<spring:message code="tip.noSelect" />");
	      	return;
	    }
		var sumFlag=new Array();
	    $.each(checked,function(){
	    	sumFlag.push($(this).val());
	    });
		if(starttime!="" && endtime!=""){
			if(starttime>endtime){
				ext.tip.error("<spring:message code="tip.date" />");
				return;
			}else{
				var selectfieldarray=new Array();
		    	var unselectfieldarray=new Array();
		    	if($("#curingmachinecode_s").is(":checked")){
		    		selectfieldarray.push('curingmachinecode_s');
		    	}else{
		    	    unselectfieldarray.push('curingmachinecode_s');
		    	}
		    	if($("#buildinmachinecode_s").is(":checked")){
		    		selectfieldarray.push('buildinmachinecode_s');
		    	}else{
		    	    unselectfieldarray.push('buildinmachinecode_s');
		    	}
		    	if($("#dynaBalancemachinecode_s").is(":checked")){
		    		selectfieldarray.push('dynabalancemachinecode_s');
		    	}else{
		    	    unselectfieldarray.push('dynabalancemachinecode_s');
		    	}
		    	$.each(selectfieldarray, function(i, val){  
	                $('#dynabalancecheresultprint_dg').datagrid('showColumn',val);
				  }); 
			    $.each(unselectfieldarray, function(i, val){  
		    	    $('#dynabalancecheresultprint_dg').datagrid('hideColumn',val);
			    }); 
				$("#dynabalancecheresultprint_dg").datagrid("options").url="finalcheck/qualityInspectionRecord/dynaBalanceCheResultPrintBG/filter?sumFlag="+sumFlag;
				ext.easyui.grid.search("dynabalancecheresultprint_dg","DynaBalanceCheResultPrint_search_form");
			}
		}else{
			ext.tip.error("<spring:message code="tip.date" />");
			return;
		}
	};
	
	
	/* var buildingMachineCodeName=[];
	$.ajax({
			url:"building/basedata/productline/getProductlineByProcess?process=252005",
			type:"get",
			dataType:"json",
			async:true,
			success:function(data){
				buildingMachineCodeName=data;
			}
	});
	function buildingMachineCodeFormatter(v, r, i) {
	    if(v!=null){
	    	for(var i=0;i<buildingMachineCodeName.length;i++){
	    		if(v==buildingMachineCodeName[i].p_line_name){
	    			return buildingMachineCodeName[i].description;
	    		}
	    	}
	    }else{
	    	return "补录";
	    }
    } */
	 function buildingMachineCodeFormatter(v, r, i){
		 if(v!=null){
			 return v;
		 }else{
			 return "补录"; 
		 }
	 }
	/* var curingMachineCodeName=[];
	$.ajax({
			url:"curing/baseData/curingControl/machinecontrol/searchProductionLine",
			type:"get",
			dataType:"json",
			async:true,
			success:function(data){
				curingMachineCodeName=data;
			}
	});
	function curingMachineCodeFormatter(v, r, i) {
	    if(v!=null){
	    	for(var i=0;i<curingMachineCodeName.length;i++){
	    		if(v==curingMachineCodeName[i].p_line_name){
	    			return curingMachineCodeName[i].description;
	    		}
	    	}
	    }else{
	    	return "补录";
	    }
    }  */
    
    
    
    
    //导出
	function exportExcel(){
		//获取grid 数据
	    var node = $("#dynabalancecheresultprint_dg").datagrid("getSelections");
	 	
	 	if (node != "") {
	 		//debugger;	
		    var data = JSON.stringify(node);
		    if (data == '')
		        return;
		    var myDate = new Date();
		    var time=myDate.toLocaleString( );
			var isbuildingselect =$("#buildinmachinecode_s").is(":checked");
			var iscuringselect =$("#curingmachinecode_s").is(":checked");
			var isdynabalanceselect =$("#dynaBalancemachinecode_s").is(":checked");
			var  title=[];
			 if((isbuildingselect==true)&&(iscuringselect!=true)&&(isdynabalanceselect!=true)){
			 	title=[{buildinmachinecode_s:'成型机台'}
		             ,{curingspeccode_s:'物料编码'},{description:'物料描述'},{speccount:'受检总数'}
		             ,{dpha1:'动平衡A+1'},{dpha1pinlv:'动平衡A+1品率'}
		             ,{tdda1:'跳动度A+1'},{tdda1pinlv:'跳动度A+1品率'}
                     ,{jyxa1:'均匀性A+1'},{jyxa1pinlv:'均匀性A+1品率'}
                     ,{a1:'A+1'}
		             ,{a1pinlv:'A+1品率'},{dpha:'动平衡A'},{dphapinlv:'动平衡A品率'}
		             ,{tdda:'跳动度A'},{tddapinlv:'跳动度A品率'}
		             ,{jyxa:'均匀性A'},{jyxapinlv:'均匀性A品率'}
		             ,{a:'A'}
		             ,{apinlv:'A品率'},{dpha0:'动平衡A0'},{dpha0pinlv:'动平衡A0品率'}
		             ,{tdda0:'跳动度A0'},{tdda0pinlv:'跳动度A0品率'}
		             ,{jyxa0:'均匀性A0'},{jyxa0pinlv:'均匀性A0品率'}
		             ,{a0:'A0'}
		             ,{dphd:'动平衡D'},{dphdpinlv:'动平衡D品率'},{tddd:'跳动度D'},{tdddpinlv:'跳动度D品率'},{jyxd:'均匀性D'},{jyxdpinlv:'均匀性D品率'}
		             ,{erji:'二级'},{erjipinlv:'二级品率'}]; 
			 }
			 if((isbuildingselect!=true)&&(iscuringselect==true)&&(isdynabalanceselect!=true)){
			 	title=[{curingmachinecode_s:'硫化机台'}
		             ,{curingspeccode_s:'物料编码'},{description:'物料描述'},{speccount:'受检总数'}
		             ,{dpha1:'动平衡A+1'},{dpha1pinlv:'动平衡A+1品率'}
		             ,{tdda1:'跳动度A+1'},{tdda1pinlv:'跳动度A+1品率'},{jyxa1:'均匀性A+1'},{jyxa1pinlv:'均匀性A+1品率'},{a1:'A+1'}
		             ,{a1pinlv:'A+1品率'},{dpha:'动平衡A'},{dphapinlv:'动平衡A品率'}
		             ,{tdda:'跳动度A'},{tddapinlv:'跳动度A品率'},{jyxa:'均匀性A'},{jyxapinlv:'均匀性A品率'},{a:'A'}
		             ,{apinlv:'A品率'},{dpha0:'动平衡A0'},{dpha0pinlv:'动平衡A0品率'}
		             ,{tdda0:'跳动度A0'},{tdda0pinlv:'跳动度A0品率'},{jyxa0:'均匀性A0'},{jyxa0pinlv:'均匀性A0品率'},{a0:'A0'}
		             ,{dphd:'动平衡D'},{dphdpinlv:'动平衡D品率'},{tddd:'跳动度D'},{tdddpinlv:'跳动度D品率'},{jyxd:'均匀性D'},{jyxdpinlv:'均匀性D品率'}
		             ,{erji:'二级'},{erjipinlv:'二级品率'}]; 
			 }
			 if((isbuildingselect!=true)&&(iscuringselect!=true)&&(isdynabalanceselect==true)){
			 	title=[{dynabalancemachinecode_s:'动平衡机台'}
		             ,{curingspeccode_s:'物料编码'},{description:'物料描述'},{speccount:'受检总数'}
		             ,{dpha1:'动平衡A+1'},{dpha1pinlv:'动平衡A+1品率'}
		             ,{tdda1:'跳动度A+1'},{tdda1pinlv:'跳动度A+1品率'},{jyxa1:'均匀性A+1'},{jyxa1pinlv:'均匀性A+1品率'},{a1:'A+1'}
		             ,{a1pinlv:'A+1品率'},{dpha:'动平衡A'},{dphapinlv:'动平衡A品率'}
		             ,{tdda:'跳动度A'},{tddapinlv:'跳动度A品率'},{jyxa:'均匀性A'},{jyxapinlv:'均匀性A品率'},{a:'A'}
		             ,{apinlv:'A品率'},{dpha0:'动平衡A0'},{dpha0pinlv:'动平衡A0品率'}
		             ,{tdda0:'跳动度A0'},{tdda0pinlv:'跳动度A0品率'},{jyxa0:'均匀性A0'},{jyxa0pinlv:'均匀性A0品率'},{a0:'A0'}
		             ,{dphd:'动平衡D'},{dphdpinlv:'动平衡D品率'},{tddd:'跳动度D'},{tdddpinlv:'跳动度D品率'},{jyxd:'均匀性D'},{jyxdpinlv:'均匀性D品率'}
		             ,{erji:'二级'},{erjipinlv:'二级品率'}]; 
			 }
			 if((isbuildingselect==true)&&(iscuringselect==true)&&(isdynabalanceselect!=true)){
			 	title=[{buildinmachinecode_s:'成型机台'}
		             ,{curingmachinecode_s:'硫化机台'}
		             ,{curingspeccode_s:'物料编码'},{description:'物料描述'},{speccount:'受检总数'}
		             ,{dpha1:'动平衡A+1'},{dpha1pinlv:'动平衡A+1品率'}
		             ,{tdda1:'跳动度A+1'},{tdda1pinlv:'跳动度A+1品率'},{jyxa1:'均匀性A+1'},{jyxa1pinlv:'均匀性A+1品率'},{a1:'A+1'}
		             ,{a1pinlv:'A+1品率'},{dpha:'动平衡A'},{dphapinlv:'动平衡A品率'}
		             ,{tdda:'跳动度A'},{tddapinlv:'跳动度A品率'},{jyxa:'均匀性A'},{jyxapinlv:'均匀性A品率'},{a:'A'}
		             ,{apinlv:'A品率'},{dpha0:'动平衡A0'},{dpha0pinlv:'动平衡A0品率'}
		             ,{tdda0:'跳动度A0'},{tdda0pinlv:'跳动度A0品率'},{jyxa0:'均匀性A0'},{jyxa0pinlv:'均匀性A0品率'},{a0:'A0'}
		             ,{dphd:'动平衡D'},{dphdpinlv:'动平衡D品率'},{tddd:'跳动度D'},{tdddpinlv:'跳动度D品率'},{jyxd:'均匀性D'},{jyxdpinlv:'均匀性D品率'}
		             ,{erji:'二级'},{erjipinlv:'二级品率'}]; 
			 }
			 if((isbuildingselect==true)&&(iscuringselect!=true)&&(isdynabalanceselect==true)){
			 	title=[{buildinmachinecode_s:'成型机台'}
		             ,{dynabalancemachinecode_s:'动平衡机台'}
		             ,{curingspeccode_s:'物料编码'},{description:'物料描述'},{speccount:'受检总数'}
		             ,{dpha1:'动平衡A+1'},{dpha1pinlv:'动平衡A+1品率'}
		             ,{tdda1:'跳动度A+1'},{tdda1pinlv:'跳动度A+1品率'},{jyxa1:'均匀性A+1'},{jyxa1pinlv:'均匀性A+1品率'},{a1:'A+1'}
		             ,{a1pinlv:'A+1品率'},{dpha:'动平衡A'},{dphapinlv:'动平衡A品率'}
		             ,{tdda:'跳动度A'},{tddapinlv:'跳动度A品率'},{jyxa:'均匀性A'},{jyxapinlv:'均匀性A品率'},{a:'A'}
		             ,{apinlv:'A品率'},{dpha0:'动平衡A0'},{dpha0pinlv:'动平衡A0品率'}
		             ,{tdda0:'跳动度A0'},{tdda0pinlv:'跳动度A0品率'},{jyxa0:'均匀性A0'},{jyxa0pinlv:'均匀性A0品率'},{a0:'A0'}
		             ,{dphd:'动平衡D'},{dphdpinlv:'动平衡D品率'},{tddd:'跳动度D'},{tdddpinlv:'跳动度D品率'},{jyxd:'均匀性D'},{jyxdpinlv:'均匀性D品率'}
		             ,{erji:'二级'},{erjipinlv:'二级品率'}]; 
			 }
			 if((isbuildingselect!=true)&&(iscuringselect==true)&&(isdynabalanceselect==true)){
			 	title=[{curingmachinecode_s:'硫化机台'},{dynabalancemachinecode_s:'动平衡机台'}
		             ,{curingspeccode_s:'物料编码'},{description:'物料描述'},{speccount:'受检总数'                    }
		             ,{dpha1:'动平衡A+1'},{dpha1pinlv:'动平衡A+1品率'}
		             ,{tdda1:'跳动度A+1'},{tdda1pinlv:'跳动度A+1品率'},{jyxa1:'均匀性A+1'},{jyxa1pinlv:'均匀性A+1品率'},{a1:'A+1'}
		             ,{a1pinlv:'A+1品率'},{dpha:'动平衡A'},{dphapinlv:'动平衡A品率'}
		             ,{tdda:'跳动度A'},{tddapinlv:'跳动度A品率'},{jyxa:'均匀性A'},{jyxapinlv:'均匀性A品率'},{a:'A'}
		             ,{apinlv:'A品率'},{dpha0:'动平衡A0'},{dpha0pinlv:'动平衡A0品率'}
		             ,{tdda0:'跳动度A0'},{tdda0pinlv:'跳动度A0品率'},{jyxa0:'均匀性A0'},{jyxa0pinlv:'均匀性A0品率'},{a0:'A0'}
		             ,{dphd:'动平衡D'},{dphdpinlv:'动平衡D品率'},{tddd:'跳动度D'},{tdddpinlv:'跳动度D品率'},{jyxd:'均匀性D'},{jyxdpinlv:'均匀性D品率'}
		             ,{erji:'二级'},{erjipinlv:'二级品率'}]; 
			 }
			 if((isbuildingselect==true)&&(iscuringselect==true)&&(isdynabalanceselect==true)){
			 	title=[{buildinmachinecode_s:'成型机台'}
		             ,{curingmachinecode_s:'硫化机台'},{dynabalancemachinecode_s:'动平衡机台'}
		             ,{curingspeccode_s:'物料编码'},{description:'物料描述'},{speccount:'受检总数'}
		             ,{dpha1:'动平衡A+1'},{dpha1pinlv:'动平衡A+1品率'}
		             ,{tdda1:'跳动度A+1'},{tdda1pinlv:'跳动度A+1品率'},{jyxa1:'均匀性A+1'},{jyxa1pinlv:'均匀性A+1品率'},{a1:'A+1'}
		             ,{a1pinlv:'A+1品率'},{dpha:'动平衡A'},{dphapinlv:'动平衡A品率'}
		             ,{tdda:'跳动度A'},{tddapinlv:'跳动度A品率'},{jyxa:'均匀性A'},{jyxapinlv:'均匀性A品率'},{a:'A'}
		             ,{apinlv:'A品率'},{dpha0:'动平衡A0'},{dpha0pinlv:'动平衡A0品率'}
		             ,{tdda0:'跳动度A0'},{tdda0pinlv:'跳动度A0品率'},{jyxa0:'均匀性A0'},{jyxa0pinlv:'均匀性A0品率'},{a0:'A0'}
		             ,{dphd:'动平衡D'},{dphdpinlv:'动平衡D品率'},{tddd:'跳动度D'},{tdddpinlv:'跳动度D品率'},{jyxd:'均匀性D'},{jyxdpinlv:'均匀性D品率'}
		             ,{erji:'二级'},{erjipinlv:'二级品率'}]; 
			 }
		    console.log(title)
		    toExcel("动平衡检测结果汇总"+time,data,title);
		 	
	 	}else{
	 		var starttime =$("#begin_created_time").datetimebox("getValue");
			var endtime=$("#end_created_time").datetimebox("getValue");
			var checked=$('input[type=checkbox]:checked');
		    if('undefined'==typeof(checked.val())){
		      	ext.tip.error("<spring:message code="tip.noSelect1" />");
		      	return;
		    }
			var sumFlag=new Array();
		    $.each(checked,function(){
		    	sumFlag.push($(this).val());
		    });
		    
		    var curingspeccode=$("#curingspeccode_s").textbox("getValue");
			var url = "finalcheck/qualityInspectionRecord/dynaBalanceCheResultPrintBG/export?sumFlag="+sumFlag+"&starttime="+starttime+"&endtime="+endtime+"&curingspeccode="+curingspeccode;
			window.location.href=url;
	 	}  
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
                    	 
                    	
                    	/*  if(k=="max_weight_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + Math.round((arrData[i]['building_weight_s'] * valueMax)*1000)/1000 + "</td>";
                    		 continue;
                    	 }*/
                    	 if(k=="buildinmachinecode_s"){
                    		 rowData+="<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]==null? "补录" : arrData[i][k]) + "</td>";
                    		 continue;
                    	 } 
                         rowData += "<td style='vnd.ms-excel.numberformat:@'>" + (arrData[i][k]==null? "" : arrData[i][k]) + "</td>";
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
        excelFile += "动平衡检测结果汇总";  
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