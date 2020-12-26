<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/basedata/vehiclesDetailInfo/saveChanges";
    
    function showOrHide(){
        if($("#VehiclesDetailInfo_search_form").is(":hidden")){
            $("#VehiclesDetailInfo_search_form").show();
        }else{
            $("#VehiclesDetailInfo_search_form").hide();
        }
    }
    
    
     /**
     * 根据口新版编码设置口型板规格
     */
    function onSetPlateSpec(record){
    	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	var getPlateSpecEditor=$("#vehiclesdetailinfo_dg").datagrid("getEditor",{
    		index : index,
    		field : "vehiclesspecification_s"});
    	$(getPlateSpecEditor.target).combobox("setValue",record.MOUTHPLATESPECIFICATION_S);
    	var getPlateSpecEditor=$("#vehiclesdetailinfo_dg").datagrid("getEditor",{
    		index : index,
    		field : "spare1_s"});
    	$(getPlateSpecEditor.target).combobox("setValue",record.FLAG_S);
    }
    
     /**
     * 根据口型板规格设置口新版编码
     */
    function onSetPlateCode(record){
    	var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
    	var getPlateSpecEditor=$("#vehiclesdetailinfo_dg").datagrid("getEditor",{
    		index : index,
    		field : "vehicles_barcode_s"});
    	$(getPlateSpecEditor.target).combobox("setValue",record.VEHICLES_BARCODE_S);
    	var getPlateSpecEditor=$("#vehiclesdetailinfo_dg").datagrid("getEditor",{
    		index : index,
    		field : "spare1_s"});
    	$(getPlateSpecEditor.target).combobox("setValue",record.FLAG_S);
    }
    
    
    /**
	 * 根据物料规格设置物料编码和物料名称
	 */
	function onSetMatCodeDesc(record){
		var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		var getMaterialCodeEditor = $("#vehiclesdetailinfo_dg").datagrid('getEditor', {
			index : index,
			field : "materialcode_s"
		});
		$(getMaterialCodeEditor.target).combobox("setValue",record.MATERIALCODE_S);
		var getMaterialDescEditor = $("#vehiclesdetailinfo_dg").datagrid('getEditor', {
			index : index,
			field : "materialname_s"
		});
		$(getMaterialDescEditor.target).textbox("setValue",record.MATERIALDESC_S);
    }
	/**
	 * 根据物料编码设置物料规格和物料名称
	 */
	function onSetMatDescSpec(record){
		var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		var getMaterialSpecEditor = $("#vehiclesdetailinfo_dg").datagrid('getEditor', {
			index : index,
			field : "materialspecification_s"
		});
		$(getMaterialSpecEditor.target).combobox("setValue",record.OLDMATCODE_S);
		var getMaterialDescEditor = $("#vehiclesdetailinfo_dg").datagrid('getEditor', {
			index : index,
			field : "materialname_s"
		});
		$(getMaterialDescEditor.target).textbox("setValue",record.MATERIALDESC_S);
	}
    
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#vehiclesdetailinfo_dg").datagrid("options");
		opts.url= 'halfpart/basedata/vehiclesDetailInfo/datagrid';
        ext.easyui.grid.search("vehiclesdetailinfo_dg","VehiclesDetailInfo_search_form");
        
    }
    
    function add() {
        ext.easyui.grid.appendAndEdit("vehiclesdetailinfo_dg",{});
    }

    function edit() {
        var rows = $("#vehiclesdetailinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#vehiclesdetailinfo_dg").datagrid("getRowIndex", rows[i]);
            $("#vehiclesdetailinfo_dg").datagrid("beginEdit", index);
        }
    }

    function remove() {

        var rows = $("#vehiclesdetailinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#vehiclesdetailinfo_dg").datagrid("getRowIndex", rows[i]);
             var value=rows[i]["spare1_s"];
            if(value==1){
            	ext.tip.error("<spring:message code="tip.notoperational" />");
            }else{
            	$("#vehiclesdetailinfo_dg").datagrid("deleteRow", index);
            }
        }
    }

    function save() {
        var dg = $("#vehiclesdetailinfo_dg");
		var valid = false;
        var rows = dg.datagrid("getRows");
        
      
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
            if (data.message == '代码重复') {
                $("#equipmentcapacity_dg").datagrid("reload");
                ext.tip.error(data.message);
            }else{
                $("#equipmentcapacity_dg").datagrid("reload");
                ext.tip.suc("<spring:message code="tip.success" />");
            }

        });

			
    }

    function cancel() {
        $("#vehiclesdetailinfo_dg").datagrid("rejectChanges");
    }


	//复制
	function copy() {
		var rows = $("#vehiclesdetailinfo_dg").datagrid("getSelections");
		if (rows.length == 0) {
			ext.tip.error("<spring:message code="tip.noCopyData" />");
		} else if (rows.length > 1) {
			ext.tip.error("<spring:message code="tip.onlyOneSelected" />");
		} else {
			ext.easyui.grid.appendAndEdit("vehiclesdetailinfo_dg", {
				vehicles_barcode_s : rows[0]['vehicles_barcode_s'],
				vehiclesspecification_s : rows[0]['vehiclesspecification_s'],
				materialcode_s : rows[0]['materialcode_s'],
				materialspecification_s : rows[0]['materialspecification_s'],
				materialname_s : rows[0]['materialname_s']
			});
		}

	}
	
	
	//批量增加
	function bacthAdd(){
		$("#bacthAdd").dialog("open");
		//getPlateInfo();
		//getMaterialInfo();
	}

	var reload=function(){
		 $("#vehiclesdetailinfo_dg").datagrid("reload");
	    };
	    
	//批量里查询口型板信息    
	var getPlateInfo=function(){
    	var opts = $("#plateinfo_dg").datagrid("options");
		opts.url = 'halfpart/plateinfo/datagrid';
        ext.easyui.grid.search("plateinfo_dg","PlateInfo_search_form");
    }
    
    var getMaterialInfo=function(){
    	var opts = $("#material_dg").datagrid("options");
		opts.url = 'halfpart/basedata/vehiclesDetailInfo/searchMaterialDescription';
        ext.easyui.grid.search("material_dg","Material_search_form");
    }
    
    
    function bacthsave() {
		// 口型板选择
		var vehicles_rows = $("#plateinfo_dg").datagrid("getSelections");
		//物料选择
		var material_rows = $("#material_dg").datagrid("getSelections");
		
		if(vehicles_rows.length==0){
			ext.tip.error("<spring:message code="tip.error" />");
		}else if(material_rows.length==0){
			ext.tip.error("<spring:message code="tip.error" />");
		}else{
			//批量组合新数据
			var bacthData = [];
			for (var i = 0 ;i< vehicles_rows.length;i++){
				for (var j = 0 ;j< material_rows.length;j++){
					var newdata = {};
					newdata["vehicles_barcode_s"] = vehicles_rows[i]["vehicles_barcode_s"];
					newdata["vehiclesspecification_s"] = vehicles_rows[i]["mouthplatespecification_s"];
					newdata["spare1_s"] = vehicles_rows[i]["flag_s"];
					newdata["materialcode_s"] = material_rows[j]["MATERIALCODE_S"];
					newdata["materialname_s"] = material_rows[j]["MATERIALDESC_S"];
					newdata["materialspecification_s"] = material_rows[j]["OLDMATCODE_S"];
					bacthData.push(newdata);
				}
			}
			var inserted =bacthData;
			ext.ajax.sendJson(saveChanges, {
					inserted : inserted
					}, function(data) {
            		if (data.message == '代码重复') {
               			$("#equipmentcapacity_dg").datagrid("reload");
                		ext.tip.error(data.message);
            		}else{
               			$("#equipmentcapacity_dg").datagrid("reload");
                		ext.tip.suc("<spring:message code="tip.success" />");
            		}
        		});
		}
	}
	
	
	
	   //导出
    function ExcelExport() {
	    //获取grid 数据
	    var node = $("#vehiclesdetailinfo_dg").datagrid("getSelections");
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
	    var title=[{atr_key:'序号'},
	    		   {vehicles_barcode_s:'口型板条码'},
	               {vehiclesspecification_s:'口型板规格'},
	               {materialcode_s:'物料编码'},
	               {materialspecification_s:'物料规格'},
	               {materialname_s:'物料名称'},
	               {created_by_s:'创建人'},
	               {created_time_t:'创建时间'},
	               {changed_by_s:'修改人'},
	               {changed_time_t:'修改时间'}]; 
	    toExcel("口型板规格对应信息查询",data,title); 
	}
    //FileName 生成的Excel文件名称
    function toExcel(FileName, JSONData, ShowLabel) {  
        //先转化json  x
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
        excelFile += "口型板规格对应信息查询";  
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