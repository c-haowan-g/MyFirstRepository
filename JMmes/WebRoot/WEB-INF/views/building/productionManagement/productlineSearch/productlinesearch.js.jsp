<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/**
	 * 基础数据text显示
	 */
	function codeFormatter(v, r, i) {
	  if(v==null){
		  return "";
	  }
		return dictFormat(v);
	}
	function isAllFormatter(v, r, i){
		if (v == 0) {
			return "<spring:message code='tip.no'/>";
		} else if (v == 1) {
			return "<spring:message code='tip.yes'/>";
		}
    }
	
    var isAllCellStyler=function (value,row,index){
    	 if (value=="0"){
    		 return 'background-color:#ffb6c1';
    	 }
    	 else if (value=="1"){
    		 return 'background-color:#ccff99';
    	 }
    }
    function rowStylerChange(index,row){
    	if(row.equip_type_s=="161002"){
    		return 'background-color:#ccff99;';
    	}
    }
    
	function materialTypeFormatter(v, r, i){
		for(var i=0;i<DICT_MaterialType.length;i++){
			if(v==DICT_MaterialType[i].DICTCODE_S){
				return  DICT_MaterialType[i].DICTNAME_S;
			}
		}
	}
	/**
	 * 接收combtree数据
	 */
	var DICT_117=[];
	
	$.ajax({
		url:"dict/code/-117",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_117=data;
		}
	});
	
	/**
	 * 接收combtree数据
	 */
	var DICT_353=[];
	
	$.ajax({
		url:"dict/code/353",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_353=data;
		}
	});
	
	/**
	 * 接收combtree数据
	 */
	var DICT_252=[];
	
	$.ajax({
		url:"dict/code/252",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_252=data;
		}
	});
	/**
	 * 接收combtree数据
	 */
	var DICT_161=[];
	
	$.ajax({
		url:"dict/code/161",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_161=data;
		}
	});
	/**
	 * 接收combtree数据
	 */
  var DICT_320=[];
	
	$.ajax({
		url:"dict/code/320",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_320=data;
		}
	});
	/**
	 * 接收combtree数据
	 */
  var DICT_189=[];
	
	$.ajax({
		url:"dict/code/189",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_189=data;
		}
	});
   

	var setting = {

		check : {
			enable : true,
			chkboxType : {
				"Y" : "ps",
				"N" : "s"
			}
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pid"
			},
			key : {
				name : "name"
			}
		}
	};
	
	function filter(){
        ext.easyui.grid.search("user_dg","user_search_form");
   }
//界面
	$(function(){
		  $('#productline_dg_manage').datagrid({
	          url: 'building/basedata/productline/getProductline?process_s=252005',
              emptyMsg: '<span><spring:message code='tip.noData'/></span>',
              striped:true,
              onClickRow:clickRow,
              method: 'get',
              singleSelect:true
		   });
	});
	//上方设备类型下拉框选择事件
	function equipmenttypeSelect(){
		var rowData = $('#equipment_dg_manage').datagrid('getSelected');
		var rowIndex = $('#equipment_dg_manage').datagrid('getRowIndex',rowData);
		clickRow1(rowIndex, rowData);
	}
	
	
	
	//上方行单击事件
	function clickRow(){
		var productlinerow = $("#productline_dg_manage").datagrid('getSelected');
		if(productlinerow==null){
 			return;
		}
		var selectProductlinename = productlinerow.p_line_name;
		var url = 'building/basedata/productline/getEquipByProductlineName?plinename='+selectProductlinename;
		ext.ajax.get(url, function(data) {
			 $('#equipment_model_dg').datagrid('loadData', data);
			 var newData=[];
			 $('#equipment_dg_manage').datagrid('loadData',newData);
		});
	}
	
	//单机设备机型触发子设备事件
	function clickRow1(rowIndex, rowData){
		var t = $('#equipmenttype').combotree('tree');
		var n = t.tree('getSelected');	
		var fieldarray=['description','equip_type_s','device_valid_s','current_batch_code_s',
		                'current_barcode_s','bom_material_code_s','current_material_code_s','configstatus_s','configclassmes_s','specialcontrol_s',
						'configresult_s','ip_address_s','status_s','half_confirm_s','line_amount_i',
						'configclassname_s','current_material_spec_s','currentmaterielamount_i','currentmaterielsurplusamount_i','equip_name','rfid_antenna_code_s']; 
		var fieldarray2=['tire_shelf_code_s','tire_material_code_s','tire_full_number_i',
		            	 'tire_real_number_i', 'barcode_s','barcodelast_s','scanstatus_s','scanstatuslast_s']; 
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
		var equipmentrow = $("#equipment_model_dg").datagrid('getSelected');
		if(equipmentrow==null){
 			return;
		}
		var selectEquipmentKey = equipmentrow.equip_key;
		var url = 'building/basedata/productline/getEquipByEquipKey?equipKey='+selectEquipmentKey;
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
</script>