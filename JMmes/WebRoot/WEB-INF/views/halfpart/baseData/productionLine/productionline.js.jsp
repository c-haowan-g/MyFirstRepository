<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var oii = false;//全局变量表示是否展开过列表，false表示没有点击展开列表
    var saveProductLineChanges=path+"halfpart/basedata/productlinemanager/saveProductLineChanges";
    var saveEquipmentModelChanges=path+"halfpart/basedata/productlinemanager/saveEquipmentModelChanges";
    var saveEquipMentChanges=path+"halfpart/basedata/productlinemanager/saveEquipmentChanges";
  
    /**
     * 加载机台信息
     * 时永良 
     * 2020年3月7日13:30:583
    */
    var productLineList=[];
    $.ajax({
        url:"halfpart/basedata/productlinemanager/getHalfPartProductionLine",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	productLineList=data;
        }
    });
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
    * 获取物料类型
    * 2020年3月7日13:30:55
    * 时永良
    */
    var configclass=[];
    $.ajax({
        url:"Part/getMaterialGroupList",
        type:"get",
        dataType:"json",
        async:true,
        success:function(data){
        	configclass=data;
        }
        });
    function configClassFormatter(v, r, i){
    	for(var i=0;i<configclass.length;i++){
    		if(v==configclass[i].DICTCODE_S){
    			return configclass[i].DICTNAME_S;
    		}
    	}
    }
    /**
     * 接收combo数据
     */
    var DICT_MaterialType=[];
    
    $.ajax({
        url:"halfpart/basedata/productlinemanager/materialTypeList",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            DICT_MaterialType=data;
        }
    });
    /**
     * 接收328客户标识数据
     */
    var CustomerList=[];
    
    $.ajax({
        url:"dict/code/328",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
        	CustomerList=data;
        }
    });
    function customerFormatter(v,r,i){
    	for(var i=0;i<CustomerList.length;i++){
   		 if (v == CustomerList[i].code) {
   	          return CustomerList[i].text;
   	     }
   	}
    }
    function statusFormatter(v, r, i){
        if        (v == '0') {
            return "停用";
        } else if (v == '1') {
            return "启用";
        } else{
        	return "未知";
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
    
 var DICT_308=[];
    
    $.ajax({
        url:"dict/code/308",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            DICT_308=data;
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
        url:"dict/code/115",
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
   
  var DICT_319=[];
    
    $.ajax({
        url:"dict/code/319",
        type:"get",
        dataType:"json",
        async:false,
        success:function(data){
            DICT_319=data;
        }
    });
     function PlmEquipCodeFormatter(v,r,i){
		for(var i=0;i<DICT_319.length;i++){
			 if (v == DICT_319[i].code) {
			     return DICT_319[i].text;
			 }
		}
    } 
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
    
    
   function productLineload(){
       $('#productline_dg').datagrid({
     	  url: 'halfpart/basedata/productlinemanager/getProductline?process_s=252004',
           fit:true,
           fitColumns:true,
           pagination:true,
           loadFilter: pagerFilter,
           rownumbers: true,
           remoteSort:false,
           emptyMsg: '<span><spring:message code='tip.noData'/></span>',
           toolbar: '#productline_dg_tools',
           striped:true,
           method: 'get',
           singleSelect:true,
             view: detailview,//第一层的加号
             detailFormatter:function(index,row){
                 return '<div style="padding:2px"><table id="ddv-' + index + '" ></table></div>'; 
             }, 
             onExpandRow: function(index,row){//点击第一层减号
            	 oii=true;//点击展开了列表
	             var ddv = $(this).datagrid('getRowDetail',index).find('#ddv-'+index); 
                 ddv.datagrid({
                	 view: detailview,//第二层的加号 
                     url:'halfpart/basedata/productlinemanager/getEquipByProductlineName?plinename='+row.p_line_name,
                     autoRowHeight:false, 
                     fitColumns:true,//允许表格自动缩放，以适应父容器
                     singleSelect:true,//去掉选中效果 
                     rownumbers:true, 
                     loadMsg:'加载中。。。',
                     columns:[[
                                 {field:'id',checkbox:true},
	                             {field:'equip_name',title:'设备编码'},
	                             {field:'description',title:'设备名称'},
	                             {field:'machinetype_s',formatter:codeFormatter,title:'设备类型'},
                                 {field:'uda_3',formatter:PlmEquipCodeFormatter,title:'PLM设备代码'},
                                 {field:'uda_4',formatter:kouxingban,title:'是否有口型板'},
                                 {field:'factory_s',formatter:customerFormatter,title:'配套厂家'},
                                 {field:'process_s',width:300,formatter:codeFormatter,title:'所属工序'}
                             ]],
                    detailFormatter:function(index,row2){
      	                    return '<div"><table id="ddv2-' + index + '" ></table></div>'; 
      	            },           
      	          onExpandRow: function(index2,row2){//点击第二层加号
	                  var ddv2 = $(this).datagrid('getRowDetail',index2).find('#ddv2-'+index2);
	                  ddv2.datagrid({ 
	                       url:'halfpart/basedata/productlinemanager/getEquipByEquipKey?equipKey='+row2.equip_key,
	                       autoRowHeight:false, 
	                       fitColumns:true,//改变横向滚动条 
	                       singleSelect:true,//去掉选中效果 
	                       rownumbers:true, 
	                       loadMsg:'加载中。。。', 
	                       columns:[[ 
	                                 {field:'equip_name',title:'子设备编号'},
	                                 {field:'description',title:'子设备名称'},
	                                 {field:'equip_type_s',formatter:codeFormatter,title:'子设备类型'},
	                                 {field:'productionline_code_s',title:'子设备组号'},
	                                 {field:'ip_address_s',title:'设备IP'},
	                                 {field:'configclass_s',formatter:codeFormatter,title:'物料类型'},
	                                 {field:'plasticnumber_i',title:'投入胶案数量'},
	                                 {field:'specialselect_s',title:'特殊选择'},
	                                 {field:'rfidaddress_s',title:'RFID逻辑地址'},
	                                 {field:'intoutaddress_s',title:'工装移入移出逻辑地址'},
	                                 {field:'outputgroup_s',title:'产出分组'},
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
 };
 
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
 
 function filter(){
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
		   		url:'halfpart/basedata/productlinemanager/getProductline',
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
 
 
   //加载界面
   $(function(){
	   productLineload();
   });
   
   function getQueryString(name) {
	    var result = window.location.search.match(new RegExp("[\?\&]" + name + "=([^\&]+)", "i"));
	    if (result == null || result.length < 1) {
	        return "";
	    }
	    return result[1];
	}
   
    //机台维护页面
    function productlineManage(){
		var HalfPartProcess='252004';
		/* var rowData = $('#productline_dg').datagrid("getRows");//获取选中的工段数据
		if(rowData==null){
		    ext.tip.warn("无机台数据");
		    return;   
		} */
		$("#productline_manage_dg").dialog("open");
        var url= 'halfpart/basedata/productlinemanager/getProductline?process_s='+HalfPartProcess;
		ext.ajax.get(url, function(data) {
		   $('#productline_dg_manage').datagrid('loadData', data);
		});
    }
    function productlineReload(){
		var HalfPartProcess='252004';
        var url= 'halfpart/basedata/productlinemanager/getProductline?process_s='+HalfPartProcess;
		ext.ajax.get(url, function(data) {
		   $('#productline_dg_manage').datagrid('loadData', data);
		});
    }

    //添加机台
    function addproductline(){
    	$('#productline_dg_manage').datagrid('insertRow', {
    		index:0,row:{isplate_s:'0',
    			         productlinestatus_s:'1'}
    	});
        $('#productline_dg_manage').datagrid('beginEdit', 0);
    }
    //编辑机台
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
    //删除机台
    function removeproductline(){
    	var rows = $("#productline_dg_manage").datagrid("getSelections");
        if(rows.length<=0){
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
    	var allLines=[];
    	var noRemovedLine=[];
    	var indexResult=[];
        var index = -1;
    	for(var i=0;i<rows.length;i++){
    		allLines.push(rows[i].p_line_name);
    	}
    	$.ajax({
	    		url:'halfpart/basedata/productlinemanager/zoneExistJudge?productLine='+allLines,
	    	    type:'get',
	    	    dataType:'json',
	    	    async:false,
    	        success:function(data){
    	        	if(data!=null||data.length!=0){
    	        		for(var i=0;i<data.length;i++){
    	        			noRemovedLine.push(data[i]);
    	        		}
    	        	}
    	        }
    	});
    	if(noRemovedLine.length==0||noRemovedLine==null){
            for (var i = 0; i < rows.length; i++) {
                index = $("#productline_dg_manage").datagrid("getRowIndex", rows[i]);
                $("#productline_dg_manage").datagrid("deleteRow", index);
            }
    	}
    	else{
            for (var i = 0; i < rows.length; i++) {
            	for(var j=0;j<noRemovedLine.length;j++){
                	if(rows[i].p_line_name==noRemovedLine[j]){
                		break;
                	}
            	}
            	if(j==noRemovedLine.length){
            		indexResult.push(i);
            	}
            	indexResult;
            }
            indexResult;
            for(var z=0;z<indexResult.length;z++){
            	index = $("#productline_dg_manage").datagrid("getRowIndex", rows[indexResult[z]]);
            	$("#productline_dg_manage").datagrid("deleteRow", index);
            }
    		ext.tip.error(noRemovedLine+"机台已维护库区库位关系，无法删除,其他机台可删除，请保存");
    	}

    }
    //保存机台
    function saveproductline(){
    	var s_factory_s = getQueryString("factory");
    	var area_name=null;
    	if(s_factory_s==1){
    		area_name ="80231A";
    	}else{
    		area_name ="80232A";
    	}
    	
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
                    if(data.data!="操作成功"){
                          ext.tip.error(data.data);
                          productlineReload();
                    }
                    else{
                    	  ext.tip.suc("<spring:message code="tip.success" />");
                    	  productlineReload();
                    }
        });
    }
    //取消机台
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
		 var url = 'halfpart/basedata/productlinemanager/getEquipByProductlineName?plinename='+rowData.p_line_name;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_model_manage_dg').datagrid('loadData', data);
		 });
	}
	function equipmentModelFilter(){
		var rowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
		 var url = 'halfpart/basedata/productlinemanager/getEquipByProductlineName?plinename='+rowData.p_line_name;
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
		 var url = 'halfpart/basedata/productlinemanager/getEquipByEquipKey?equipKey='+rowData.equip_key;
 	     ext.ajax.get(url, function(data) {
			$('#equipment_dg').datagrid('loadData', data);
		 });
 	     equipkey=$("#aaa").textbox('setValue',rowData.equip_key);
	}
    
    function equipManageReload(){
		 var index= $("#productline_dg").datagrid('getRowIndex',$('#productline_dg').datagrid('getSelected'));
		 var rowData=$("#ddv-"+index+"").datagrid('getSelected');
		 var url = 'halfpart/basedata/productlinemanager/getEquipByEquipKey?equipKey='+rowData.equip_key;
	     ext.ajax.get(url, function(data) {
			$('#equipment_dg').datagrid('loadData', data);
		 });
	}
    
    //关闭新增子设备
    function cancelshowequipmentadd(){
         $("#equipment_manage_dg").dialog("close");
    }
    function cancelshowproductlineadd(){
        $("#productline_manage_dg").dialog("close");
   }
    //添加子设备
    function addequipment(){
    	 
         $("#equipment_dg").datagrid('insertRow', {index: 0,row:{plasticnumber_i:1}});
         $("#equipment_dg").datagrid("beginEdit", 0);
    }
   var equipTypeJudge=function(record){
	    var index= $("#productline_dg").datagrid('getRowIndex',$('#productline_dg').datagrid('getSelected'));
	    var rowData=$("#ddv-"+index+"").datagrid('getSelected');
	    var lineName=rowData.equip_name;
	    var newIndex = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
     	var plasticNum = $('#equipment_dg').datagrid('getEditor', {index:newIndex,field:'plasticnumber_i'});
     	var equipTypeDg = $('#equipment_dg').datagrid('getEditor', {index:newIndex,field:'equip_type_s'});
     	var outputGroup = $('#equipment_dg').datagrid('getEditor', {index:newIndex,field:'outputgroup_s'});
     	$(plasticNum.target).textbox({disabled:false});
	    $(outputGroup.target).combobox({disabled:false});
	    var inputKey='115001'; 
	    var outputKey='115002';
	    var plateKey='115003'; 
        //var seletedRowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
        var plate = rowData.uda_4;
        if(plate=='0'&&record==plateKey){
        	ext.tip.warn("该机台下不可维护口型版类型的子设备护");
        	$(equipTypeDg.target).combotree('clear');
        	$(plasticNum.target).textbox('clear');
        }
        if(plate=='0'&&record==outputKey){
        	$(plasticNum.target).textbox('setValue',0);
        	$(outputGroup.target).combobox('setValue','A');
        	$(outputGroup.target).combobox({readonly: false});
        	$(plasticNum.target).textbox({readonly: true});
        }
        if(plate=='0'&&record==inputKey){
        	$(plasticNum.target).textbox('setValue',1);
        	$(plasticNum.target).textbox({readonly:false});
        	$(outputGroup.target).combobox({readonly: true});
        }
        if(plate=='1'&&record==inputKey){
        	$(plasticNum.target).textbox('setValue',1);
        	$(plasticNum.target).textbox({readonly:false});
        	$(outputGroup.target).combobox({readonly: true});
        }
        if(plate=='1'&&record==outputKey){
        	$(plasticNum.target).textbox('setValue','0');
        	$(plasticNum.target).textbox({readonly: true});
        	$(outputGroup.target).combobox('setValue','A');
        }
        if(plate=='1'&&record==plateKey){
        	$(plasticNum.target).textbox('setValue','0');
        	$(plasticNum.target).textbox({readonly: true});
        	$(outputGroup.target).combobox({readonly: true});
        }
        //var lineName = seletedRowData.p_line_name;
        var type =$(equipTypeDg.target).combotree('getValue');
     	var equipName = $('#equipment_dg').datagrid('getEditor', {index:newIndex,field:'equip_name'});
     	$(equipName.target).textbox('setValue',lineName+"_"+type+"_");
        return;
    };
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
                var equipType=$("#equipment_dg").datagrid("getEditor", {index:index,field:'equip_type_s'});
                $(equipType.target).textbox({disabled:true});
                var equipName=$("#equipment_dg").datagrid("getEditor", {index:index,field:'equip_name'});
                $(equipName.target).textbox({disabled:true});

            }
          /*index = $("#equipment_dg").datagrid("getRowIndex", rows[i]);
            $("#equipment_dg").datagrid("beginEdit", index);
            var equip_name = $("#equipment_dg").datagrid('getEditor', {index:index,field:'equip_name'});
            $(equip_name.target).textbox({disabled: true});//不可编辑
            var equip_type=$('#equipment_dg').datagrid('getColumnOption', 'equip_type_s'); //通过列名获得此列
            equip_type.editor={};  */
            
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
         var rowData = $('#productline_dg').datagrid('getSelected');//获取选中的工段数据
          if(rowData==null){
              ext.tip.warn("请选择一个机台后再维护");
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
                p_line_name='';
                //equipManageReload;
            }else{
                ext.tip.suc("<spring:message code="tip.success" />");
                p_line_name='';
                equipManageReload();
            }
        });
    }
    //取消子设备
    function cancelequipment(){
          $("#equipment_dg").datagrid("rejectChanges");
    }
    
    function kouxingban(v,r,i){
    	if(v=="1"){
    		return "有";
    	}
    	if(v=="0"){
    		return "无";
    	}
    	return "未知";
    }
    function onPlasticJudge(newpara,prepara){
    	if(prepara==1&&newpara==0){
    	    var newIndex = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
         	var plastic = $('#productline_dg_manage').datagrid('getEditor', {index:newIndex,field:'isplate_s'});
         	var line = $('#productline_dg_manage').datagrid('getEditor', {index:newIndex,field:'p_line_name'});
         	var lineName=$(line.target).textbox('getValue');
    	    $.ajax({
    	        url:"halfpart/basedata/productlinemanager/plasticJudge?lineName="+lineName,
    	        type:"get",
    	        dataType:"json",
    	        async:true,
    	        success:function(data){
    	        	if(data==true){
    	        		ext.tip.error("该机台下存在口型板型子设备！");
    	        		$(plastic.target).combobox('setValue',1);
    	        	}
    	        }
    	        });        
    	}
    }
	function clearStatus(){
		return;
	}
	
	function plasticNumberJudge(preData,newData){
    	var newIndex = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
     	var plasticNumber = $('#equipment_dg').datagrid('getEditor', {index:newIndex,field:'plasticnumber_i'});
     	var equipType= $('#equipment_dg').datagrid('getEditor', {index:newIndex,field:'equip_type_s'});
        var equipTypeData=$(equipType.target).textbox('getValue');
        if(equipTypeData=='115001'){
        	if(newData=='0'||preData=='0'){
        		$(plasticNumber.target).textbox('setValue','1');
             	ext.tip.warn("提示：投料口下投入胶案量至少为1");
    		}
        	
        }
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
		 var logo=productionLineName.slice(3,6);
		 if(logo!=null&&logo!=""){
			 var newurl='halfpart/basedata/productlinemanager/searchBy211?logo='+logo;
			    $.ajax({
			        url : newurl,
			        type : 'get',
			        dataType : 'json',
			        async : false,
			        success : function(data) {
			        	if(data==null||data==""){
			        		 $(getEditor1(index, "category").target).combobox('clear');
			        		 $(getEditor1(index, "category").target).combobox('loadData',"");
			        		 ext.tip.error("输入的机台条码无对应的机台类型，请重新输入！");
			        	}else{
			        		 $(getEditor1(index, "category").target).combobox("setValue", data[0]);//设置机台类型
			        		 console.log($(getEditor1(index, "category").target).combobox("getValue"));
			        	}
			        }
		        });
		 }
	}
</script>