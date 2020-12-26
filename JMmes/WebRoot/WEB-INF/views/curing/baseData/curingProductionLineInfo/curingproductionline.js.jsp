<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var oii = false;//全局变量表示是否展开过列表，false表示没有点击展开列表
    var saveProductLineChanges=path+"curing/baseData/curingProductionLine/saveProductLineChanges";
    var saveEquipmentModelChanges=path+"curing/baseData/curingProductionLine/saveEquipmentModelChanges";
    var saveEquipMentChanges=path+"curing/baseData/curingProductionLine/saveEquipmentChanges";
    
    function codeFormatter(v, r, i) {
		return dictFormat(v);
	}
    /**
     * 加载机台信息
     * 时永良
     * 2019-11-07
    */
    var productLineList=[];
    $.ajax({
        url:"curing/baseData/curingControl/machinecontrol/searchProductionLine",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	productLineList=data;
        }
    });
    /**
	 * 接收combtree数据
	 */
	var DICT_287=[];
	
	$.ajax({
		url:"dict/code/287",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_287=data;
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
	
	function equipmenttype(v, r, i) {
		var text = {
			'L' : "左硫化机",
			'R' : "右硫化机"
		};
		return "<font>" + text[v] + "</font>";
	}
	
	function isAllFormatter(v, r, i){
		if (v == 0) {
			return "<spring:message code='tip.no'/>";
		} else if (v == 1) {
			return "<spring:message code='tip.yes'/>";
		}
    }
	   //加载界面
	   $(function(){
		   productLineload();
	   });
         //界面
		 function productLineload(){
			 $('#productline_dg').datagrid({
		          url: 'curing/baseData/curingProductionLine/getProductline',
		          fit:true,
		          fitColumns:true,//允许表格自动缩放，以适应父容器
	              pagination:true,
	              rownumbers: true,
	              singleSelect: true,
	              loadFilter: pagerFilter,//分页用
	              remoteSort:false,
	              sorter:productionLineFilter,
	              emptyMsg: '<span><spring:message code='tip.noData'/></span>',
	              toolbar: '#productline_dg_tools',
	              view: detailview, //第一层的加号
	              detailFormatter:function(index,row){
	                    return '<div"><table id="ddv-' + index + '" ></table></div>'; 
	              }, 
	              onExpandRow: function(index,row){//点击第一层减号
	            	   oii=true;//点击展开了列表
		               var ddv = $(this).datagrid('getRowDetail',index).find('#ddv-'+index); 
		               ddv.datagrid({ 
		                	   view: detailview,//第二层的加号 
		                       url:'curing/baseData/curingProductionLine/getEquipByProductlineName?plinename='+row.p_line_name,
		                       autoRowHeight:false, 
		                       fitColumns:true,//允许表格自动缩放，以适应父容器
		                       singleSelect:true,//去掉选中效果 
		                       rownumbers:true, 
		                       loadMsg:'加载中。。。', 
		                       columns:[[ 
		                             {field:'id',checkbox:true},
		                             {field:'equip_name',title:'设备编码'},
		                             {field:'description',title:'设备名称'},
		                             {field:'machinetype_s',formatter:equipmenttype,title:'设备类型'},
		                             {field:'status_s',formatter:codeFormatter,title:'设备状态'},
		                             {field:'ip_address_s',title:'机台IP'},
		                             {field:'process_s',formatter:codeFormatter,title:'所属工序'},
		                             {field:'changeby_s',title:'操作人'}, 
									 {field:'changetime_t',title:'操作时间'}
		                       ]],
		                  detailFormatter:function(index,row2){
		                       return '<div"><table id="ddv2-' + index + '" ></table></div>'; 
		                  }, 
		                  onExpandRow: function(index2,row2){//点击第二层加号
			                  var ddv2 = $(this).datagrid('getRowDetail',index2).find('#ddv2-'+index2);
			                  ddv2.datagrid({ 
			                       url:'curing/baseData/curingProductionLine/getEquipByEquipKey?equipKey='+row2.equip_key,
			                       autoRowHeight:false, 
			                       fitColumns:true,//改变横向滚动条 
			                       singleSelect:true,//去掉选中效果 
			                       rownumbers:true, 
			                       loadMsg:'加载中。。。', 
			                       columns:[[ 
			                          {field:'equip_name',title:'子设备编码'},
									  {field:'description',title:'子设备名称'},
									  {field:'equip_type_s',formatter:codeFormatter,title:'子设备类型'},
									  {field:'device_valid_s',formatter:isAllFormatter,title:'子设备是否启用'},
									  {field:'remark_s',title:'备注'},
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
	function productionLineFilter(){
 	    $("#productline_dg").datagrid('options').pageNumber=1;//重置pageNumber
	    $("#productline_dg").datagrid('getPager').pagination('refresh', {pageNumber: 1});
	    var list_map={};
	    list_map.sortname=$("#productline_dg").datagrid('options').sortName;
	    list_map.sortorder=$("#productline_dg").datagrid('options').sortOrder;
	   	list_map.p_line_name=$('#p_line_name').combobox('getValue');
	   	list_map.description=$('#description').combobox('getValue');
	   	if((list_map.p_line_name==null||list_map.p_line_name=="")&&(list_map.description==null||list_map.description=="")){
	   		productLineload();
	   	}else{
	   	  $.ajax({
	   		url: 'curing/baseData/curingProductionLine/getProductline',
	   		type:"GET",
		    dataType:"json",
		 	data : {"list_map":JSON.stringify(list_map)},
			contentType:'application/json',
		 	async:true,
		 	success:function(data){
		 			$("#productline_dg").datagrid("loadData", data);  
		 	}
		});
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
     		 var url = 'curing/baseData/curingProductionLine/getProductlineByAreaName?areaname='+area_name;
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
		 var url = 'curing/baseData/curingProductionLine/getProductlineByAreaName?areaname='+area_name;
 	     ext.ajax.get(url, function(data) {
			$('#productline_dg_manage').datagrid('loadData', data);
		 });
	}
	$(function(){
	    $("#productline_manage_dg").dialog({onClose:function(){
		    //你想在关闭时执行的代码
			var url='curing/baseData/curingProductionLine/getProductline';
			ext.ajax.get(url, function(data) {
					$('#productline_dg').datagrid('loadData', data);
			});
		}}); 
	    $("#equipment_model_dg").dialog({onClose:function(){
		    //你想在关闭时执行的代码
			var url='curing/baseData/curingProductionLine/getProductline';
			ext.ajax.get(url, function(data) {
					$('#productline_dg').datagrid('loadData', data);
			});
		}}); 
	    $("#equipment_manage_dg").dialog({onClose:function(){
		    //你想在关闭时执行的代码
			var url='curing/baseData/curingProductionLine/getProductline';
			ext.ajax.get(url, function(data) {
					$('#productline_dg').datagrid('loadData', data);
			});
		}}); 
	})
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
		 var url = 'curing/baseData/curingProductionLine/getEquipByProductlineName?plinename='+rowData.p_line_name;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_model_manage_dg').datagrid('loadData', data);
		 });
	}
	function equipmentModelFilter(){
		var rowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
		 var url = 'curing/baseData/curingProductionLine/getEquipByProductlineName?plinename='+rowData.p_line_name;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_model_manage_dg').datagrid('loadData', data);
		 });
	}
	//添加设备机型
	function addequipmentmodel(){
		var rowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
         $("#equipment_model_manage_dg").datagrid('insertRow', {
				index: 0,row:{p_line_name:rowData.p_line_name}
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
		 $(getEditor(index, "equip_name").target).textbox("setValue", productionLine+record.value);//设备编码
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
            dg.datagrid("endEdit", i);
        }
        
        var rows1 = dg.datagrid("getRows");
        
        var ips="";
        for (var j = 0; j < rows1.length; j++) {
            if (!dg.datagrid("validateRow", j)) {
                ext.tip.error("<spring:message code="tip.invalid" />");
                return;
            }else{
            	if(rows1[j].ip_address_s != null&& rows1[j].ip_address_s!=""){
            		ips=rows1[j].ip_address_s;
            	}
            	if(rows1.length>=2){
            		if(ips!=rows1[j+1].ip_address_s){
            			ext.tip.error("<spring:message code="tip.repetition" />");
            		    return;
                	}else{
                		break;
                	}
            	}
            	
            }
        }
        var inserted = dg.datagrid("getChanges", "inserted");
        var updated = dg.datagrid("getChanges", "updated");
        var deleted = dg.datagrid("getChanges", "deleted");
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
	//取消设备机型
	function cancelequipmentmodel(){
		  $("#equipment_model_manage_dg").datagrid("rejectChanges");
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
		 var url = 'curing/baseData/curingProductionLine/getEquipByEquipKey?equipKey='+rowData.equip_key;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_dg').datagrid('loadData', data);
		 });
 	     equipkey=$("#aaa").textbox('setValue',rowData.equip_key);
	}
	function childEquipment(){
		 var index= $("#productline_dg").datagrid('getRowIndex',$('#productline_dg').datagrid('getSelected'));
		 var rowData=$("#ddv-"+index+"").datagrid('getSelected');
		 var url = 'curing/baseData/curingProductionLine/getEquipByEquipKey?equipKey='+rowData.equip_key;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_dg').datagrid('loadData', data);
		 });
	}
	//添加子设备
	function addequipment(){
         $("#equipment_dg").datagrid('insertRow', {
				index: 0,row:{device_valid_s : 0}
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
            	childEquipment();
                p_line_name='';
            }else{
                  ext.tip.suc("<spring:message code="tip.success" />");
                  childEquipment();
            }
            p_line_name='';
        });
	}
	//取消子设备
	function cancelequipment(){
		  $("#equipment_dg").datagrid("rejectChanges");
	}

	/**
     * 获取指定行、指定列的编辑器
     */
    function getEditor1(index,field){
        return $("#productline_dg_manage").datagrid("getEditor",{index:index,field:field});
    }
	function onProductionLineNameChange(nv, ov) {
		 var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		 var productionLineName= $(getEditor1(index, "p_line_name").target).textbox("getValue");
		 var logo=productionLineName.slice(3,4);
		 var newurl='curing/baseData/curingProductionLine/searchBy320?logo='+logo;
		    $.ajax({
		        url : newurl,
		        type : 'get',
		        dataType : 'json',
		        async : false,
		        success : function(data) {
		        	if(data==null||data==""){
		        		 $(getEditor1(index, "machinegroup_s").target).combobox('clear');
		        		 $(getEditor1(index, "machinegroup_s").target).combobox('loadData',"");
		        	}else{
		        		 $(getEditor1(index, "machinegroup_s").target).combobox("setValue", data[0]);//设置机台组
		        		 console.log($(getEditor1(index, "machinegroup_s").target).combobox("getValue"));
		        	}
		        }
	        });
		
	}
</script>