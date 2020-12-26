<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    var oii = false;//全局变量表示是否展开过列表，false表示没有点击展开列表
    var saveProductLineChanges=path+"building/basedata/productline/saveChanges";
    var saveEquipmentModelChanges=path+"building/basedata/productline/saveEquipmentModelChanges";
    var saveEquipMentChanges=path+"building/basedata/productline/saveEquipmentChanges";
    $(function(){
	    $("#productline_manage_dg").dialog({onClose:function(){
		    //你想在关闭时执行的代码
			var url= 'building/basedata/productline/getProductline?process_s=252005';
			ext.ajax.get(url, function(data) {
					$('#productline_dg').datagrid('loadData', data);
			});
		}}); 
	    $("#equipment_model_dg").dialog({onClose:function(){
		    //你想在关闭时执行的代码
			var url= 'building/basedata/productline/getProductline?process_s=252005';
			ext.ajax.get(url, function(data) {
					$('#productline_dg').datagrid('loadData', data);
			});
		}}); 
	    $("#equipment_manage_dg").dialog({onClose:function(){
		    //你想在关闭时执行的代码
			var url= 'building/basedata/productline/getProductline?process_s=252005';
			ext.ajax.get(url, function(data) {
					$('#productline_dg').datagrid('loadData', data);
			});
		}}); 
	    $("#equipmentclass_manage_dg").dialog({onClose:function(){
		    //你想在关闭时执行的代码
			var url= 'building/basedata/productline/getProductline?process_s=252005';
			ext.ajax.get(url, function(data) {
					$('#productline_dg').datagrid('loadData', data);
			});
		}}); 
	})
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
	
	/**
     * 接收设备机型
     */
     var equipmentModelList=[];
 	
 	$.ajax({
 		url:"building/basedata/productline/equipmentModelList",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			equipmentModelList=data;
 		}
 	});
 	
    
	/**
	 * 接收combo数据
	 */
	var DICT_MaterialType=[];
	
	$.ajax({
		url:"building/basedata/productline/materialTypeList",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_MaterialType=data;
		}
	});
	
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
	var DICT_211=[];
	
	$.ajax({
		url:"dict/code/211",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_211=data;
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
	var DICT_198=[];
	
	$.ajax({
		url:"dict/code/198",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_198=data;
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
	
    //界面
	$(function(){
		  $('#productline_dg').datagrid({
	          url: 'building/basedata/productline/getProductline?process_s=252005',
	          fit:true,
	          fitColumns:true,//允许表格自动缩放，以适应父容器
              pagination:true,
              rownumbers: true,
              singleSelect: true,
              loadFilter: pagerFilter,//分页用
              remoteSort:false,
              emptyMsg: '<span><spring:message code='tip.noData'/></span>',
              toolbar: '#Reas_dg_toolbar',
              view: detailview, //第一层的加号
              detailFormatter:function(index,row){
                    return '<div"><table id="ddv-' + index + '" ></table></div>'; 
              }, 
              onExpandRow: function(index,row){//点击第一层减号
            	   oii=true;//点击展开了列表
	               var ddv = $(this).datagrid('getRowDetail',index).find('#ddv-'+index); 
	               ddv.datagrid({ 
	                	   view: detailview,//第二层的加号 
	                       url:'building/basedata/productline/getEquipByProductlineName?plinename='+row.p_line_name,
	                       autoRowHeight:false, 
	                       fitColumns:true,//允许表格自动缩放，以适应父容器
	                       singleSelect:true,//去掉选中效果 
	                       rownumbers:true, 
	                       loadMsg:'加载中。。。', 
	                       columns:[[ 
	                             {field:'id',checkbox:true},
	                             {field:'equip_name',title:'设备编码'},
	                             {field:'description',title:'设备名称'},
	                             {field:'machinetype_s',formatter:codeFormatter,title:'设备类'},
	                             {field:'equip_type_s',formatter:codeFormatter,title:'设备类型'},
	                             {field:'remarks_s',title:'额定能力'},
	                             {field:'model_s',title:'型号'},
	                             {field:'specification_s',title:'规格'},
	                             {field:'factory_s',title:'厂商'},
	                             {field:'manufacturingtime_t',title:'制造年月'},
	                             {field:'shape_s',title:'外形尺寸'},
	                             {field:'weight_s',title:'重量'},
	                             {field:'servicelife_s',title:'使用年限'},
	                             {field:'activetime_t',title:'启用时间'},
	                             {field:'department_s',title:'所属部门'},
	                             {field:'responsible_s',title:'责任人'},
	                             {field:'process_s',formatter:codeFormatter,title:'所属工序'}
	                       ]],
	                  detailFormatter:function(index,row2){
	                       return '<div"><table id="ddv2-' + index + '" ></table></div>'; 
	                  }, 
	                  onExpandRow: function(index2,row2){//点击第二层加号
		                  var ddv2 = $(this).datagrid('getRowDetail',index2).find('#ddv2-'+index2);
		                  ddv2.datagrid({ 
		                       url:'building/basedata/productline/getEquipByEquipKey?equipKey='+row2.equip_key,
		                       autoRowHeight:false, 
		                       fitColumns:true,//改变横向滚动条 
		                       singleSelect:true,//去掉选中效果 
		                       rownumbers:true, 
		                       loadMsg:'加载中。。。', 
		                       columns:[[ 
		                          {field:'equip_name',title:'子设备编码'},
								  {field:'description',title:'子设备名称'},
								  {field:'erpcode_s',title:'余料控制百分比'},
								  {field:'equip_type_s',formatter:codeFormatter,title:'子设备类型'},
								  {field:'productionline_code_s',title:'子设备组号'},
								  {field:'ip_address_s',title:'设备IP'},
								  {field:'configclassmes_s',formatter:codeFormatter,title:'物料类型'},
								  {field:'specialcontrol_s',title:'特殊要求'},
								  {field:'remark_s',title:'备注'},
								  {field:'rfid_antenna_code_s',title:'RFID设备编码'},
								  {field:'rfidaddress_s',title:'RFID逻辑地址'},
								  {field:'current_batch_code_s',title:'当前物料批次条码'},
								  {field:'current_barcode_s',title:'当前物料编码（RFID条码）'},
								  {field:'current_material_code_s',title:'当前物料编码'},
								  {field:'last_barcode_s',title:'上一个工装条码'},
								  {field:'last_material_code_s',title:'上一个物料编码'},
								  {field:'last_batch_code_s',title:'上一个物料批次编码'},
								  {field:'configstatus_s',formatter:isAllFormatter,title:'是否启用校验'},
								  {field:'configresult_s',title:'投料校验结果'},
								  {field:'beginweight_f',title:'正向投料称重起始重量'},
								  {field:'endweight_f',title:'正向投料称重结束重量'},
								  {field:'differentvalue_f',title:'更换载具差值'},
								  {field:'status_s',formatter:isAllFormatter,title:'设备状态 0不正常1正常'},
								  {field:'bom_material_code_s',title:'BOM物料'},
								  {field:'half_confirm_s',title:'半卷料确认'},
								  {field:'line_amount_i',title:'物料线边数量'},
								  {field:'configclassname_s',title:'物料大类名称'},
								  {field:'current_material_spec_s',title:'当前物料规格'},
								  {field:'currentmaterielamount_f',title:'当前投料物料总数量'},
								  {field:'currentmaterielsurplusamount_f',title:'当前投料物料剩余数量'},
								  {field:'device_valid_s',formatter:isAllFormatter,title:'子设备是否启用'},
								  {field:'changeby_s',title:'操作人'}, 
								  {field:'changetime_t',title:'操作时间'}
		                       ]],
		                    onResize:function(){
		                        ddv.datagrid('fixDetailRowHeight',index2);
		                        $('#productline_dg').datagrid('fixDetailRowHeight',index);
		                    },
		                    onLoadSuccess:function(){
		                        setTimeout(function(){
		                        	ddv.datagrid('fixDetailRowHeight',index2);
		                        	ddv.datagrid('fixRowHeight',index2);//防止出现滑动条 
		                            $('#productline_dg').datagrid('fixDetailRowHeight',index);
		                            $('#productline_dg').datagrid('fixRowHeight',index);//防止出现滑动条 
		                        },0);
		                    }
		                  });
	                  },
	                  onCollapseRow:function(index2,row2){//点击第二层减号
	                	  var ddv2 = $(this).datagrid('getRowDetail',index2).find('#ddv2-'+index2);
	                	  ddv2.datagrid({
	                		 onResize:function(){
	                			 ddv.datagrid('fixDetailRowHeight',index2);
	                			 $('#productline_dg').datagrid('fixDetailRowHeight',index);
	                		 } 
	                	  });
	                	  ddv.datagrid('fixDetailRowHeight',index2);
	                      $('#productline_dg').datagrid('fixDetailRowHeight',index);
	                  },
                  onResize:function(){
                	  $('#productline_dg').datagrid('fixDetailRowHeight',index); 
                  },
                  onLoadSuccess:function(){
                	  setTimeout(function(){
                          $('#productline_dg').datagrid('fixDetailRowHeight',index);
                          $('#productline_dg').datagrid('fixRowHeight',index);//防止出现滑动条 
                      },0);
                  },
                  });
                  },
                  onCollapseRow:function(index,row){//点击第一层减号
                	  var ddv = $(this).datagrid('getRowDetail',index).find('#ddv-'+index);
                	  ddv.datagrid({
                		 onResize:function(){
                			 $('#productline_dg').datagrid('fixDetailRowHeight',index);
                		 } 
                	  });
                      $('#productline_dg').datagrid('fixDetailRowHeight',index);
                  }
		   });
	});
    
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
     
	//子设备维护设备类型更改事件
	function enttypeChange(newValue, oldValue){
            if(newValue=='161002'){
   			 ext.tip.warn("产出口只能维护一个，请注意");			 
   			 }
	   		if(newValue=='161001'){
	   		 ext.tip.warn("投料口必须维护物料类型，请注意"); 	   		
	   		}
	}
	var area_name="";
	//产线维护页面
	function productlineManage(){
		  // 获取选中行的Index的值
		 var rowData = $('#productline_dg').datagrid("getRows");//获取选中的工段数据
         $("#productline_manage_dg").dialog("open");
		 if(rowData!=null||rowData!=""){
		     area_name=rowData[0].area_name;
		 }
     		 var url = 'building/basedata/productline/getProductlineByAreaName?areaname='+area_name;
     	     ext.ajax.get(url, function(data) {
    			$('#productline_dg_manage').datagrid('loadData', data);
    		 });
	}
	//弹出产线页面重新查询
	function filter(){
		 var rowData = $('#productline_dg').datagrid("getRows");//获取选中的工段数据
		 if(rowData!=null||rowData!=""){
		     area_name=rowData[0].area_name;
		 }
		 var url = 'building/basedata/productline/getProductlineByAreaName?areaname='+area_name;
 	     ext.ajax.get(url, function(data) {
			$('#productline_dg_manage').datagrid('loadData', data);
		 });
	}
	//关闭新增产线页面
	function cancelshowproductlineadd(){
		 $("#productline_manage_dg").dialog("close");
	}
	//添加产线
	function addproductline(){
		 $("#productline_dg_manage").datagrid('insertRow', {
				index: 0,row:{}
			});
	     $("#productline_dg_manage").datagrid("beginEdit", 0);
	}
	//编辑产线
	function editproductline(){
		 var rows = $("#productline_dg_manage").datagrid("getSelections");
	        if(rows.length<=0){
				ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
	    		return;
			}
	        var index = -1;
	        for (var i = 0; i < rows.length; i++) {
	            index = $("#productline_dg_manage").datagrid("getRowIndex", rows[i]);
	            $("#productline_dg_manage").datagrid("beginEdit", index);
	            var p_line_name = $("#productline_dg_manage").datagrid('getEditor', {index:index,field:'p_line_name'});
	           	$(p_line_name.target).textbox({disabled: true});//不可编辑
	        }
	}
	//删除产线
	function removeproductline(){
		var rows = $("#productline_dg_manage").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#productline_dg_manage").datagrid("getRowIndex", rows[i]);
            $("#productline_dg_manage").datagrid("deleteRow", index);
        }
	}
	//保存产线
	function saveproductline(){
        var dg = $("#productline_dg_manage");
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
        
		Utils.each(inserted, function(i, d) {
			d.area_name = area_name;
		});
        
        
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }
        ext.ajax.sendJson(saveProductLineChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (data.data!="操作成功") {
                ext.tip.error(data.data);
                filter();
            }else{
                 ext.tip.suc("<spring:message code="tip.success" />");
                 filter();
            } 
        });
	}
	//取消产线
	function cancelproductline(){
		  $("#productline_dg_manage").datagrid("rejectChanges");
	}
	
	
	//设备机型维护
	function equipmentModel(){
		 
		  var rowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
	      if(rowData==null){
	    	  ext.tip.warn("请选择一个产线后再维护");
	          return; 	
		  }
		  
		 $("#equipment_model_dg").dialog("open");
		 var url = 'building/basedata/productline/getEquipByProductlineName?plinename='+rowData.p_line_name;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_model_manage_dg').datagrid('loadData', data);
		 });
	}
	function equipmentModelFilter(){
		var rowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
		 var url = 'building/basedata/productline/getEquipByProductlineName?plinename='+rowData.p_line_name;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_model_manage_dg').datagrid('loadData', data);
		 });
	}
	//添加设备机型
	function addequipmentmodel(){
         $("#equipment_model_manage_dg").datagrid('insertRow', {
				index: 0,row:{}
			});
	     $("#equipment_model_manage_dg").datagrid("beginEdit", 0);
	}
	
	/**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(index,field){
        return $("#equipment_model_manage_dg").datagrid("getEditor",{index:index,field:field});
    }
    
	function onEquipmentModelSelect(record){
		 var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		 var rowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
		 var productionLine=rowData.p_line_name;
		 $(getEditor(index, "equip_name").target).textbox("setValue", productionLine+"_"+record.DICTCODE_S);//设备编码
	}
	 
	//编辑设备机型
	function editequipmentmodel(){
		var rows = $("#equipment_model_manage_dg").datagrid("getSelections");
        if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipment_model_manage_dg").datagrid("getRowIndex", rows[i]);
            $("#equipment_model_manage_dg").datagrid("beginEdit", index);
            var equip_name = $("#equipment_model_manage_dg").datagrid('getEditor', {index:index,field:'equip_name'});
           	$(equip_name.target).textbox({disabled: true});//不可编辑
        }
	}
	//删除设备机型
	function removeequipmentmodel(){
		var rows = $("#equipment_model_manage_dg").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipment_model_manage_dg").datagrid("getRowIndex", rows[i]);
            $("#equipment_model_manage_dg").datagrid("deleteRow", index);
        }
	}
	//保存设备机型
	function saveequipmentmodel(){
		 var rowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
	      if(rowData==null){
	    	  ext.tip.warn("请选择一个产线后再维护");
	          return; 	
		  }
        var dg = $("#equipment_model_manage_dg");
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
        
        Utils.each(inserted, function(i, d) {
			d.p_line_name=rowData.p_line_name;
		});
	
        ext.ajax.sendJson(saveEquipmentModelChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (data.message!="操作成功") {
            	ext.tip.error(data.message);
            	equipmentModelFilter();
                p_line_name='';
            }else{
                  ext.tip.suc("<spring:message code="tip.success" />");
                  equipmentModelFilter();
            }
            p_line_name='';
        });
	}
	//取消子设备
	function cancelequipmentmodel(){
		  $("#equipment_model_manage_dg").datagrid("rejectChanges");
	}
	
	//添加子设备
	function addequipment(){
         $("#equipment_dg").datagrid('insertRow', {
				index: 0,row:{}
			});
	     $("#equipment_dg").datagrid("beginEdit", 0);
	}
	//编辑子设备
	function editequipment(){
		 var rows = $("#equipment_dg").datagrid("getSelections");
	        if(rows.length<=0){
				ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
	    		return;
			}
	        var index = -1;
	        for (var i = 0; i < rows.length; i++) {
	            var equip_type=$('#equipment_dg').datagrid('getColumnOption', 'equip_type_s'); //通过列名获得此列
	            equip_type.editor={}; 
	            var configclassmes_s=$('#equipment_dg').datagrid('getColumnOption', 'configclassmes_s'); //通过列名获得此列
	            configclassmes_s.editor={}; 
	           
	            
	            var specialcontrol_s=$('#equipment_dg').datagrid('getColumnOption', 'specialcontrol_s'); //通过列名获得此列
	            specialcontrol_s.editor={}; 
	            
	            
	            index = $("#equipment_dg").datagrid("getRowIndex", rows[i]);
	            $("#equipment_dg").datagrid("beginEdit", index);
	            
	        }
	}
	//删除子设备
	function removeequipment(){
		var rows = $("#equipment_dg").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipment_dg").datagrid("getRowIndex", rows[i]);
            $("#equipment_dg").datagrid("deleteRow", index);
        }
	}
	//保存子设备
	function saveequipment(){
		 var index= $("#productline_dg").datagrid('getRowIndex',$('#productline_dg').datagrid('getSelected'));
		 var rowData=$("#ddv-"+index+"").datagrid('getSelected');//获取选中的工段数据
	      if(rowData==null){
	    	  ext.tip.warn("请选择一个设备机型后再维护");
	          return; 	
		  }
        var dg = $("#equipment_dg");
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
        
        Utils.each(inserted, function(i, d) {
			d.p_line_name=rowData.p_line_name;
		});
	    var equipKey=$("#aaa").textbox("getValue");
        ext.ajax.sendJson(saveEquipMentChanges, {
        	equipKey : equipKey,
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (data.data!="操作成功") {
            	ext.tip.error(data.data);
            	childEquipmentFilter();
                p_line_name='';
            }else{
                  ext.tip.suc("<spring:message code="tip.success" />");
                  childEquipmentFilter();
            }
            p_line_name='';
        });
	}
	//取消子设备
	function cancelequipment(){
		  $("#equipment_dg").datagrid("rejectChanges");
	}
	
	var equipkey=null;
	//子设备投料口\产出口维护 
	function equipmentManage(){
		 var index= $("#productline_dg").datagrid('getRowIndex',$('#productline_dg').datagrid('getSelected'));
		 var equipmentModelData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
		 if(equipmentModelData==null){
	    	  ext.tip.warn("请选择一个设备机型后再维护");
	    	  return;
		 }else{
	    	  if(oii){
	    		var oi=$("#ddv-"+index+"").datagrid('getChecked');
	    		if(oi.length==0){
	    			ext.tip.warn("请选择一个设备机型后再维护");
	 	 	    	return;
	    		}	
	    	  }
	    	  else{
	    		 ext.tip.warn("请选择一个设备机型后再维护");
	 	    	 return;
	    	  }
		 } 
		 var rowData=$("#ddv-"+index+"").datagrid('getSelected');
		 $("#equipment_manage_dg").dialog("open");
		 var url = 'building/basedata/productline/getEquipByEquipKey?equipKey='+rowData.equip_key;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_dg').datagrid('loadData', data);
		 });
 	     equipkey=$("#aaa").textbox('setValue',rowData.equip_key);
	}
	function childEquipmentFilter(){
		 var index= $("#productline_dg").datagrid('getRowIndex',$('#productline_dg').datagrid('getSelected'));
		 var rowData=$("#ddv-"+index+"").datagrid('getSelected');
		 var url = 'building/basedata/productline/getEquipByEquipKey?equipKey='+rowData.equip_key;
	     ext.ajax.get(url, function(data) {
			$('#equipment_dg').datagrid('loadData', data);
		 });
	}
	
	//维护设备类
	function equipmentClassManage(){
     		 $("#equipmentclass_manage_dg").dialog("open");
     		 var url = 'building/basedata/productline/searchBy189';
     	     ext.ajax.get(url, function(data) {
    			$('#equipmentclass_dg_manage').datagrid('loadData', data);
    		 }); 
	}
	function equipmentClassFilter(){
		 var url = 'building/basedata/productline/searchBy189';
	     ext.ajax.get(url, function(data) {
			$('#equipmentclass_dg_manage').datagrid('loadData', data);
		 });
	}
	
	//添加设备类（往数据字典中添加）
	function add(){
         $("#equipmentclass_dg_manage").datagrid('insertRow', {
				index: 0,row:{deleted_i : 0}
			});
	     $("#equipmentclass_dg_manage").datagrid("beginEdit", 0);
	}
	//修改设备类
	function edit() {
		var rows = $("#equipmentclass_dg_manage").datagrid("getSelections");
		var index = -1;
		for (var i = 0; i < rows.length; i++) {
			if (rows[i].deleted == 1) {
				ext.tip.warn("无效字典数据无法更改");
				continue;
			}
			index = $("#equipmentclass_dg_manage").datagrid("getRowIndex", rows[i]);
			$("#equipmentclass_dg_manage").datagrid("beginEdit", index);
			var dictcode = $("#equipmentclass_dg_manage").datagrid('getEditor', {index:index,field:'dictcode_s'});
	        $(dictcode.target).textbox({disabled: true});//不可编辑
		}
	}
	
	function save() {
		var dg = $("#equipmentclass_dg_manage");

		var rows = dg.datagrid("getRows");
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("请输入正确的数据");
				return;
			}
		}

		var inserted = dg.datagrid("getChanges", "inserted");
		var updated = dg.datagrid("getChanges", "updated");
		var deleted = dg.datagrid("getChanges", "deleted");
		for (var i = 0; i < rows.length; i++) {
	            dg.datagrid("endEdit", i);
	    }

		ext.ajax.sendJson("building/basedata/productline/saveDictChanges", {
			inserted : inserted,
			updated : updated,
			deleted : deleted
		}, function(data) {

			if (data.code == ERROR) {
				ext.tip.error(data.message + ":" + data.data);
				equipmentClassFilter();
				return;
			}

			if (data.code != OK) {
				ext.tip.error("保存失败");
				equipmentClassFilter();
				return;
			}
			
			ext.tip.suc("保存成功");
			equipmentClassFilter();
		});
	}
	function deleted(v, r, i) {
		var text = {
			0 : "有效",
			1 : "无效"
		};
		if (v == 0) {
			return "<font color='green'>" + text[v] + "</font>";
		}
		return "<font color='red'>" + text[v] + "</font>";
	}

	function cancel() {
		$("#equipmentclass_dg_manage").datagrid("rejectChanges");
	}
	
</script>