<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">


    var saveStorageZoneChanges="halfpart/basedata/storagezonemanager/saveChanges";
    var saveUnitMentChanges=path+"halfpart/basedata/storageunitmanager/saveChanges";
    
	/**
	 * 基础数据text显示
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}
	function yesFormatter(v, r, i) {
		if(v==0){
			return "否";
		}else if(v==1){
			return "是";
		}else{
			return "未知";
		}
	}
	function stopFormatter(v, r, i) {
		if(v==0){
			return "停用";
		}else if(v==1){
			return "启用";
		}else{
			return "未知";
		}
	}
	function lockFormatter(v, r, i) {
		if(v==0){
			return "未锁定";
		}else if(v==1){
			return "已锁定";
		}else{
			return "未知";
		}
	}
	/**
	 * 接收combtree数据
	 */
	var DICT_227=[];
	
	$.ajax({
		url:"dict/code/227",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			DICT_227=data;
		}
	});
   /**
	* 库区划分显示转化
	* 兰颖慧
	* 2019-05-24
	*/
	var zoneDivide=[];
	var fullZoneDivide=[];
	var count=0;
	$.ajax({
		url:"dict/code/112",
		type:"get",
		dataType:"json",
		async:false,
		success:function(data){
			fullZoneDivide=data;
			for(var i=0;i<data.length;i++){
				if((data[i].code!=borderStorage)&&(data[i].code!=virtualStorage)){
					zoneDivide[count]=data[i];
					count++;
				}
			}
		}
	});
	
	function zoneDivideFormatter(v, r, i){
		for(var i=0;i<fullZoneDivide.length;i++){
			if (v == fullZoneDivide[i].code) {
				return fullZoneDivide[i].text;
			}
		}

	}

  /**
	* 物料组显示转化
	* 兰颖慧
	* 2019-05-24
	*/
    var materialGroupList=[];
    $.ajax({
        url:"sap/materials/getMaterialGroupList",
        type:"get",
        dataType:"json",
        async:true,
        success:function(data){
        	materialGroupList=data;
        }
        });
    
   /**
    * 物料组显示转化
    * 2019-05-20
    * 兰颖慧
    */
    function materialGroupFormatter(v, r, i){
         for(var i=0;i<materialGroupList.length;i++){
            if (v == materialGroupList[i].DICTCODE_S) {
                return materialGroupList[i].DICTNAME_S;
            }
          }
    } 
    /**
	* 页面刷新加载
	* 2019-05-29
	* 兰颖慧
	*/
    $(function(){
    $('#halfpart_storage_dg').datagrid({
        url: 'halfpart/basedata/storagezonemanager/zone',
        fit:true,
        fitColumns:true,
        emptyMsg: '<span><spring:message code='tip.noData'/></span>',
        singleSelect:true,
        toolbar: '#Halfpart_storage_dg_toolbar',
        striped:true,
        method: 'get'
	   });
	   // 延迟加载详细视图
	   setTimeout(LoadView,200);
    });
    function pageReload(){
        $('#halfpart_storage_dg').datagrid({
            url: 'halfpart/basedata/storagezonemanager/zone',
            fit:true,
            fitColumns:true,
            emptyMsg: '<span><spring:message code='tip.noData'/></span>',
            singleSelect:true,
            toolbar: '#Halfpart_storage_dg_toolbar',
            striped:true,
            method: 'get'
    	   });
    	   // 延迟加载详细视图
    	   setTimeout(LoadView,200);
    }
	/* 加载详细视图 */
	function LoadView(){
		var total = $("#halfpart_storage_dg").length;
		//验证当有数据的时候才加载详细视图
		 if(total>0){ 
			$('#halfpart_storage_dg').datagrid({
				view: detailview,
				detailFormatter:function(index,row){
					return '<div style="padding:2px"><table class="ddv"></table></div>';
				},
				onExpandRow: function(index,row){
					var ddv = $(this).datagrid('getRowDetail',index).find('table.ddv');
					ddv.datagrid({
						url:'halfpart/basedata/storageunitmanager/unit?zonekey='+row.storage_zone_key,
						fitColumns:true,
						singleSelect:true,
						rownumbers:true,
						loadMsg:'加载中...',
						height:'auto',
						columns:[[
									{field:'storage_unit_key',title:'库位主键 ',hidden:true},
									{field:'parent_key',title:'库位父键',hidden:true},
									{field:'storage_zone_name',title:'库区名称 ',hidden:true},
									{field:'storage_unit_name',title:'库位名称'},
									{field:'description',title:'库位描述'},
									{field:'storage_zone_barcode_s',formatter:zoneDivideFormatter,title:'库区划分'},
									{field:'machinecode_s',title:'机台条码'},
									{field:'max_storage_duration',title:'库存容量'},
									{field:'current_storage_i',title:'当前库存'},
									{field:'inventory_materialname_s',title:'存放物料名称'},
									{field:'inventory_materialcode_s',title:'存放物料编码'},
									{field:'lastintime_t',title:'最后入库时间'},
									{field:'canuse_s',title:'启用/停用',formatter:stopFormatter},
									{field:'lockflag_s',title:'是否占用',formatter:yesFormatter},
									{field:'lockinflag_s',title:'入库锁定',formatter:lockFormatter},
									{field:'lockoutflag_s',title:'出库锁定',formatter:lockFormatter},
									{field:'operater_s',title:'操作人'},
									{field:'operatetime_t',title:'操作时间'}
						         ]],
						onResize:function(){$('#halfpart_storage_dg').datagrid('fixDetailRowHeight',index);},
						onLoadSuccess:
							function(){
							   setTimeout(function(){$('#halfpart_storage_dg').datagrid('fixDetailRowHeight',index);},0);
						              } 
					});
					$('#halfpart_storage_dg').datagrid('fixDetailRowHeight',index);
				}
			});
		 } 
	}
	function zone_open(){
		 $("#Storage_zone_manage_dg").dialog("open");
		 var url ='halfpart/basedata/storagezonemanager/zone';
	     ext.ajax.get(url, function(data) {
			 $('#halfpart_storagezone_dg').datagrid('loadData', data);
		 });

	}
	//添加库区
	function zone_add(){
	
		$("#halfpart_storagezone_dg").datagrid("insertRow", {index:0,row:{}});
	    $("#halfpart_storagezone_dg").datagrid("beginEdit", 0);
	    //var row={};
		//ext.easyui.grid.appendAndEdit("halfpart_storagezone_dg",row);
	}
	//编辑库区
	function zone_edit(){
		 var rows = $("#halfpart_storagezone_dg").datagrid("getSelections");
	        if(rows.length<=0){
				ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
	    		return;
			}
	        var index = -1;
	        for (var i = 0; i < rows.length; i++) {
	            index = $("#halfpart_storagezone_dg").datagrid("getRowIndex", rows[i]);
	            $("#halfpart_storagezone_dg").datagrid("beginEdit", index); //通知界面启动编辑
                var storage_zone_name = $("#halfpart_storagezone_dg").datagrid('getEditor', {index:index,field:'storage_zone_name'});
	       	    $(storage_zone_name.target).textbox({disabled: true});//不可编辑  
	        }
	}
	//删除库区
	function zone_remove(){
		var rows = $("#halfpart_storagezone_dg").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#halfpart_storagezone_dg").datagrid("getRowIndex", rows[i]);
            $("#halfpart_storagezone_dg").datagrid("deleteRow", index);
        }
	}
	//保存库区
	function zone_save(){
        var dg = $("#halfpart_storagezone_dg");
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
        ext.ajax.sendJson(saveStorageZoneChanges, {
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (data.data!="success") {
                ext.tip.error(data.message);
                return;
            }else{
                ext.tip.suc("操作成功");
                zone_open();
            }
        });
	}
	//取消库区
	function zone_cancel(){
		  $("#halfpart_storagezone_dg").datagrid("rejectChanges");
	}
	var storagezonekey=-1;
	//库位维护页面
	function unit_open(){
		  //var index = $('#halfpart_storagezone_dg').datagrid('getRowIndex',$('#halfpart_storagezone_dg').datagrid('getSelected'));
		var rowData = $('#halfpart_storage_dg').datagrid('getSelected');
		   if(rowData==null){
		 	  ext.tip.warn("请选择一个库区后再维护");
		       return; 	
		}
		storageZoneKey=rowData.storage_zone_key;
		$("#halfpart_unit_manage_dg").dialog("open");
		var url = 'halfpart/basedata/storageunitmanager/unit?zonekey='+rowData.storage_zone_key;
		    ext.ajax.get(url, function(data) {
		              $('#halfpart_storageunit_dg').datagrid('loadData', data);
		    });
	}
	function unitReload(){
		 var rowData = $('#halfpart_storagezone_dg').datagrid('getSelected');
		 storageZoneKey=rowData.storage_zone_key;
		 var url = 'halfpart/basedata/storageunitmanager/unit?zonekey='+rowData.storage_zone_key;
 	     ext.ajax.get(url, function(data) {
			 $('#halfpart_storageunit_dg').datagrid('loadData', data);
		 });
	}
	
	//关闭新增库位
	function zong_unit_close(){
		     $("#storageunit_manage_dg").dialog("close");
	}
	//添加库位
	function unit_add(){
		var selectedZoneRow=$("#halfpart_storage_dg").datagrid("getSelected");
		//var zoneInventoryBarcode=selectedZoneRow.inventory_barcode_s;
		var zoneName=selectedZoneRow.storage_zone_name;
		var row={ //inventory_barcode_s:zoneInventoryBarcode, //用户后台调用该字段，但是不需要存储
				  storage_zone_name:zoneName,
				  max_storage_duration:99,
				  current_storage_i:0,
				  canuse_s:1,
				  lockflag_s:0,
				  lockinflag_s:0,
				  lockoutflag_s:0,
		         };
   	    ext.easyui.grid.appendAndEdit("halfpart_storageunit_dg",row);
	}
	/**
	 * 获取指定行、指定列的编辑器
	 *
	 */
	function getEditor(index,field){
	    return $("#halfpart_storageunit_dg").datagrid("getEditor",{index:index,field:field});
	}
	function getZoneEditor(index,field){
	    return $("#halfpart_storagezone_dg").datagrid("getEditor",{index:index,field:field});
	}
	function getMaterialCodeList(){
		var parentIndex = $('#halfpart_storage_dg').datagrid('getRowIndex',$('#halfpart_storagezone_dg').datagrid('getSelected'));
		var KidIndex = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		var parentRow = $('#halfpart_storage_dg').datagrid('getSelected');
	    var group=parentRow.materialgroup_s;
	    var getGroupUrl='sap/materials/getMaterialByMaterialGroupList?materialGroup='+group;
 	      $.ajax({
		      		url:getGroupUrl,
		      		type:"get",
		      		dataType:"json",
		      		async:false,
		      		success:function(data){
		      			$(getEditor(KidIndex,'inventory_materialcode_s').target).combobox('loadData',data);
		      			$(getEditor(KidIndex,'inventory_materialname_s').target).combobox('loadData',data);
		      		}
	            });  
	}
    /**
     * 根据物料名称获取物料编码
     * 兰颖慧
     * Yinghui.Lan
     * 2019-04-22 
     */
	function onSelectMaterialCode(record){
		  var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		  var getDataByMaterialNameUrl='halfpart/productionplan/dailyplan/getDataByMaterialName?materialName='+record.MATERIALDESC_S;
		  $.ajax({
		   		url:getDataByMaterialNameUrl,
		   		type:"get",
		   		dataType:"json",
		   		async:true,
		   		success:function(dataByMaterialName){
     			      $(getEditor(index, "inventory_materialcode_s").target).textbox('setValue',dataByMaterialName[0].MATERIALCODE_S);//物料编码
		   		}
	     	}); 
	    	
	  }
    /**
     * 根据物料编码获取物料名称
     * 兰颖慧
     * Yinghui.Lan
     * 2019-04-22 
     */
	function onSelectMaterialName(record){
		  var index = $(this).parents("[datagrid-row-index]").attr("datagrid-row-index");
		  var getDataByMaterialCodeUrl='halfpart/productionplan/dailyplan/getDataByMaterialCode?materialCode='+record.MATERIALCODE_S;
		  $.ajax({
		   		url:getDataByMaterialCodeUrl,
		   		type:"get",
		   		dataType:"json",
		   		async:true,
		   		success:function(dataByMaterialCode){
     			      $(getEditor(index, "inventory_materialname_s").target).textbox('setValue',dataByMaterialCode[0].MATERIALDESC_S);//物料编码
		   		}
	     	}); 
	    	
	  }
	//编辑库位
	function unit_edit(){
		 var rows = $("#halfpart_storageunit_dg").datagrid("getSelections");
	        if(rows.length<=0){
				ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
	    		return;
			}
	        var index = -1;
	        for (var i = 0; i < rows.length; i++) {
	            index = $("#halfpart_storageunit_dg").datagrid("getRowIndex", rows[i]);
	                    $("#halfpart_storageunit_dg").datagrid("beginEdit", index);
                var storage_unit_name = $("#halfpart_storageunit_dg").datagrid('getEditor', {index:index,field:'storage_unit_name'});
	       	    $(storage_unit_name.target).textbox({disabled: true});//不可编辑  
	        }
	}
	//删除库位
	function unit_remove(){
		var rows = $("#halfpart_storageunit_dg").datagrid("getSelections");
		if(rows.length<=0){
			ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
    		return;
		}
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#halfpart_storageunit_dg").datagrid("getRowIndex", rows[i]);
                    $("#halfpart_storageunit_dg").datagrid("deleteRow", index);
        }
	}
	//保存库位
	function unit_save(){
	    var dg = $("#halfpart_storageunit_dg");
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
			d.parent_key = storageZoneKey;
		});
        
        for (var i = 0; i < rows.length; i++) {
            dg.datagrid("endEdit", i);
        }

        ext.ajax.sendJson(saveUnitMentChanges,{
            inserted : inserted,
            updated : updated,
            deleted : deleted
        }, function(data) {
            if (data.data!="操作成功") {
                ext.tip.error(data.message);
                storagezonekey=-1;
            }
           else{
        	   ext.tip.suc("<spring:message code="tip.success" />");
        	   storagezonekey=-1;
        	   unit_open();
           }
        });
	}
	//取消库位
	function unit_cancel(){
		  $("#halfpart_storageunit_dg").datagrid("rejectChanges");
	}
	/**
	 * 查询按钮
	 * add by YinghuiLan
	 */
    var filter=function(){
    	description=$('#description').textbox('getValue');
    	category=$('#storage_zone_name').textbox('getValue');
    	 $.ajax({
		 		url:'halfpart/basedata/storagezonemanager/searchZoneByCategoryAndZoneName?category='+category+'&description='+description,
		 		type:"post",
		 		dataType:"json",
		 		data : JSON,
				contentType:'application/json',
		 		async:false,
		 		success:function(data){
		 			$("#halfpart_storage_dg").datagrid("loadData", data);  
		 		}
			 });
    };

	function clearStatus(){
         $('#storage_type_s').combobox('clear');
    }
</script>