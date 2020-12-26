<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/basedata/vehiclesinfo/saveChanges";
    
    function printFlagFormatter(value,row,index){
        if(value=='0'){
        	return '停用';
        }else if(value=='1'){
        	return '启用';
        }
	}
	
	   /**
    *将数据库得值转换为数据字典与对应值域
    */           	
    function codeFormatter(v, r, i) {
		return dictFormat(v);
    }
	
	function flagFormat(value, row, index) {
		if ((value == "0")) {
			return "空闲";
		} else if ((value == "1")) {
			return "已用";
		}
	}
    
    function showOrHide(){
        if($("#VehiclesInfo_search_form").is(":hidden")){
            $("#VehiclesInfo_search_form").show();
        }else{
            $("#VehiclesInfo_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
   		var opts = $("#vehiclesinfo_dg").datagrid("options");
		opts.url = 'halfpart/basedata/vehiclesinfo/datagrid';
        ext.easyui.grid.search("vehiclesinfo_dg","VehiclesInfo_search_form");
    }
    
    function add() {
        var vehicles_type_s = $("#vehicles_type_s").textbox("getValue");
		ext.easyui.grid.appendAndEdit("vehiclesinfo_dg", {
			printflag_s : "1",
			vehicles_type_s : vehicles_type_s
		});
    }

    function edit() {
        var rows = $("#vehiclesinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#vehiclesinfo_dg").datagrid("getRowIndex", rows[i]);
           	//$("#vehiclesinfo_dg").datagrid("beginEdit", index);
             var value=rows[i]["flag_s"];
            
            if(value==5){
            	ext.tip.error("<spring:message code="tip.notoperational" />");
            }else{
            	$("#vehiclesinfo_dg").datagrid("beginEdit", index);
            } 
             
            
        }
    }

    function remove() {

        var rows = $("#vehiclesinfo_dg").datagrid("getSelections");
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#vehiclesinfo_dg").datagrid("getRowIndex", rows[i]);
            var value=rows[i]["flag_s"];
            
            if(value==1){
            	ext.tip.error("<spring:message code="tip.notoperational" />");
            }else{
            	 $("#vehiclesinfo_dg").datagrid("deleteRow", index);
            } 
           
        }

    }

    function save() {
        var dg = $("#vehiclesinfo_dg");

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
            $("#vehiclesinfo_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#vehiclesinfo_dg").datagrid("rejectChanges");
    }


	var checkCapacity_s = function(value) {
		if (value != null || value != undefined) {
			var k = $(this).parents('[datagrid-row-index]').attr(
					'datagrid-row-index');
			var td = $('.datagrid-body td[field=\'capacity_s\']')[k];
			var input = $(td).find('input')[0];
			if ($(input).val() == 0) {
				ext.tip.error("容量不可以为0，请重新输入")
				$(input).textbox('setValue', '');
			}
		}
	}

	var code="";
	function vehiclesBarcodeChange1(newValue, oldValue){
		code=newValue;
		if(code=="FAG"){
	 		$("#myIndexB").textbox('setValue', 'FAG');
		}
		if(code=="GAG"){
	 		$("#myIndexB").textbox('setValue', 'GAG');
		}
		$('#startcode').textbox("clear");
	    $('#endcode').textbox("clear");
	}

	//批量导入弹出框打开
    function BatchAdd() {
    	
// 		$("#myIndexA").textbox('setValue', 'GAG');
// 		$("#myIndexB").textbox('setValue', 'GAG');
		$("#Batch_dg").dialog("open");
	}
	
	//批量导入弹出框关闭
	function BatchCancel() {
		$("#Batch_dg").dialog("close");
	}


	//起始条码改变时验证
	function vehiclesBarcodeChange(newValue, oldValue){
		var standardCodeQG = /^(?!0000)\d{4}$/;
		var standardCodeBG = /^(?!00000)\d{5}$/;
  	    if ((!standardCodeQG.test(newValue))&&(!standardCodeBG.test(newValue))&&newValue!="") {
  	    	$('#startcode').textbox("clear");
  	    	$('#endcode').textbox("clear");
  	    	ext.tip.error("载具条码不规范,请检查");
  	    	return;
  	    }
  	  	var startBarcode= $('#startcode').textbox("getValue");
		if(startBarcode==""){
			return;
		}
	  	var batchNum = $('#batchNum').numberspinner("getValue");
	  	if(batchNum==""){
	  		return;
	  	}
	  	setEndCode(startBarcode,batchNum);
	}


	//数量下拉框事件
	function batchNumChange(){
		var startCode= $('#startcode').textbox("getValue");
		if(startCode==""){
			return;
		}
    	var batchNum = $('#batchNum').numberspinner('getValue');
    	if(batchNum==""){
    		return;
    	}
    	setEndCode(startCode,batchNum);
	}
	//设置终止条码文本框
	function setEndCode(startCode,batchnum){
		if(startCode.length!=4&&code=="FAG"){
    		ext.tip.error("起始条码不符合规范:要求为4位");
   		    return;
    	}
		if(startCode.length!=5&&code=="GAG"){
    		ext.tip.error("起始条码不符合规范:要求为5位");
   		    return;
    	}
    	var isnum = /^\d+$/.test(startCode.slice(0));
  	    if (isnum==false) {
  	    	ext.tip.error("起始条码不符合规范:要求不允许出现字母");
  	    	$('#barcodeFrom').textbox("clear");
  	    	return;
  	    }
  	    var endInt=parseInt(startCode);
  	    var endText=endInt+parseInt(batchnum-1);
  	   if(code=="FAG"){
  	     $('#endcode').textbox("setValue",PrefixInteger(endText,4));
  	   }
  	   if(code=="GAG"){
  		 $('#endcode').textbox("setValue",PrefixInteger(endText,5));
  	   }
	}

	//不足5位数时在前面补零
	function PrefixInteger(num, length) {
	  return (num/Math.pow(10,length)).toFixed(length).substr(2);
	}

	//批量导入弹出框传数据到后台
	function BatchSave(){
		var vehicles_type_z=$('#vehicles_type_z').textbox("getValue");
		var vehicles_type_c=$('#vehicles_type_c').textbox("getValue");
		var capacity=$('#capacity').textbox("getValue");
		var printflag=$('#printflag').textbox("getValue");
    	var startCode= $('#startcode').textbox("getValue");
    	var endCode = $('#endcode').textbox("getValue");
    	var myIndexA= $('#myIndexA').textbox("getValue");
    	var myIndexB= $('#myIndexB').textbox("getValue");
    	//var batchNum = $('#batchNum').numberspinner('getValue');
    	
    	if(vehicles_type_z==""||capacity==""||printflag==""||startCode==""||endCode==""||myIndexA==""||myIndexB==""){
    		 ext.tip.error("输入信息不完整，请检查");
    		 return;
    	}
    	 $.ajax({
	 		url:"halfpart/basedata/vehiclesinfo/BatchAdd?vehicles_type_z="+vehicles_type_z+"&vehicles_type_c="+vehicles_type_c+
	 				"&startCode="+startCode+"&endCode="+endCode+"&capacity="+capacity+"&printflag="+printflag+"&myIndexA="+myIndexA+"&myIndexB="+myIndexB,
	 		type:"get",
	 		dataType:"json",
	 		async:true,
	 		success:function(data){
	 			if(data.data=="批量导入条码成功"){
             	      ext.tip.suc(data.data);
             	      $("#vehiclesinfo_dg").datagrid("reload");
             	      $("#Batch_dg").dialog("close");
                }
                else{
                	  //$.messager.confirm("操作失败");
                	  ext.tip.error("<spring:message code="tip.vehiclesbarcodeRepeat" />");
                	  //$("#Batch_dg").form("clear");
                	  //$("#vehiclesinfo_dg").datagrid("reload");//重新加载界面数据
                      //$("#Batch_dg").dialog("close");
                }
	 			
	 		}
        }); 
  }
  
  
  function BatchCancel() {
 		 $("#Batch_dg").form("clear");
		$("#Batch_dg").dialog("close");
	} 
	
	
	var setVehicles_rfidcode_s = function(value) {
		if (value != null || value != undefined) {
			var k = $(this).parents('[datagrid-row-index]').attr(
					'datagrid-row-index');
			var td = $('.datagrid-body td[field=\'vehicles_barcode_s\']')[k];
			var input = $(td).find('input')[0];
			
			var atrkey = $("#vehiclesinfo_dg").datagrid("getEditor",{index:k,field:"atr_key"});
			var aa = $('.datagrid-body td[field=\'atr_key\']')[k];
			var input1 = $(aa).find('input')[0];
			var atrkey1 = $(input1).val();
			
			//var rows = $("#equipmentmaterial_dg").datagrid("getRows");
			//var row = rows[index];//index为行号
			//var atr_key = row.atr_key;
			
			var f = CheckRule(atrkey1,value);
			if (f == 0) {
				$(input).textbox('setValue', '');
				
			}
		}
	}
	
	    //获取url上的参数(获取工厂字段)
	function getQueryString(name) {
	    var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
	    if (result == null || result.length < 1) {
	        return "";
	    }
	    return result[1];
	}
	
	function CheckRule(atrkey,value) {
		var s_factory_s = getQueryString("factory");
		var flag = 1;
		//验证编码规则
		if (value != null && value != "") {
			var factory_class = value.substring(0, 1);
			var area = value.substring(1, 2);
			var type = value.substring(2, 3);
			var code = value.substring(3);
			var standardCodeQG = /^(?!0000)\d{4}$/;
			var standardCodeBG = /^(?!00000)\d{5}$/;
			if ((factory_class != "F") && (factory_class != "G")) {
				ext.tip.error("<spring:message code="vehicles_barcode_s.rule" />");
				flag = 0;
			} else if (area != "A") {
				ext.tip.error("<spring:message code="vehicles_barcode_s.rule" />");
				flag = 0;
			} else if (type != "G") {
				ext.tip.error("<spring:message code="vehicles_barcode_s.rule" />");
				flag = 0;
			} else if ((!standardCodeQG.test(code))&&(!standardCodeBG.test(code))) {
				ext.tip.error("<spring:message code="vehicles_barcode_s.rule" />");
			}
			
			if(!(atrkey!=null&&atrkey!='')){
				$.ajax({
			        url:"halfpart/basedata/vehiclesinfo/checkVehiclesBarcode?vehiclesBarcode="+value+"&atrkey="+atrkey,
			        type:'get',
			        dataType:'json',
			        async:false,
			        success:function(data){
			        	if(data == 0){
			        		ext.tip.error("<spring:message code="tip.vehiclesbarcodeRepeat" />");
			        		flag = 0;
			        	}
			        }
				});
			}
			return flag;
		}
	}
	
	

</script>