<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"halfpart/basedata/equipmentMaterial/saveChanges";
    
    function showOrHide(){
        if($("#EquipmentMaterial_search_form").is(":hidden")){
            $("#EquipmentMaterial_search_form").show();
        }else{
            $("#EquipmentMaterial_search_form").hide();
        }
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
    	var opts = $("#equipmentmaterial_dg").datagrid("options");
		opts.url = 'halfpart/basedata/equipmentMaterial/datagrid';
        ext.easyui.grid.search("equipmentmaterial_dg","EquipmentMaterial_search_form");
    };
    
    //批量设置主物料页面
	function setprimarymaterial(){
        var opts = $("#material_dg").datagrid("options");
		opts.url = 'halfpart/basedata/equipmentMaterial/searchMaterialGroup';
        ext.easyui.grid.search("material_dg","materialcode_search_form");
        $("#setprimarymaterial_dg").dialog("open");
	}
    
    //批量设置副物料页面
    function setsecondmaterial() {
        var opts = $("#material_dg1").datagrid("options");
		opts.url = 'halfpart/basedata/equipmentMaterial/searchMaterialGroup';
        ext.easyui.grid.search("material_dg1","materialcode_search_form1");
        $("#setsecondmaterial_dg").dialog("open");
    }
    
    //保存主物料设置
    function setprimarymaterial_save() {
    	var eqname = $('#equipmentcodes1').combobox('getValue');
    	if(eqname == "") {
    		ext.tip.warn("请选择机台");
    		return;
    	}
    	var rows1 = $("#material_dg").datagrid("getSelections");
        if(rows1.length == 0){
            ext.tip.warn("请选择物料组");
            return;
		}else{
			var inserted = [];
            for(var i = 0; i < rows1.length; i++) {
            	var item = {};
            	item['materialgroup_s'] = rows1[i].materialgroup_s;
            	item['equipmentcode_s'] = eqname;
            	item['isprimary_s'] = "0";
            	inserted.push(item);
            }
            ext.ajax.sendJson(saveChanges, {
	            inserted : inserted
	        }, function(data) {
	            if (data.code!=OK) {
	                ext.tip.error("<spring:message code="tip.error" />");
	                return;
	            }
	            $("#setprimarymaterial_dg").dialog("close");
	            $("#equipmentmaterial_dg").datagrid("reload");
	            ext.tip.suc("<spring:message code="tip.success" />");
	        });
		}
    }
    
    //保存副物料设置
    function setsecondmaterial_save() {
    	var eqname = $('#equipmentcodes2').combobox('getValue');
    	if(eqname == "") {
    		ext.tip.warn("请选择机台");
    		return;
    	}
    	var rows1 = $("#material_dg1").datagrid("getSelections");
        if(rows1.length == 0){
            ext.tip.warn("请选择物料组");
            return;
		}else{
			var inserted = [];
            for(var i = 0; i < rows1.length; i++) {
            	var item = {};
            	item['materialgroup_s'] = rows1[i].materialgroup_s;
            	item['equipmentcode_s'] = eqname;
            	item['isprimary_s'] = "1";
            	inserted.push(item);
            }
            ext.ajax.sendJson(saveChanges, {
	            inserted : inserted
	        }, function(data) {
	            if (data.code!=OK) {
	                ext.tip.error("<spring:message code="tip.error" />");
	                return;
	            }
	            $("#setsecondmaterial_dg").dialog("close");
	            $("#equipmentmaterial_dg").datagrid("reload");
	            ext.tip.suc("<spring:message code="tip.success" />");
	        });
		}
    }
    
    //添加
    function add() {
        ext.easyui.grid.appendAndEdit("equipmentmaterial_dg",{});
    }

	//修改
    function edit() {
        var rows = $("#equipmentmaterial_dg").datagrid("getSelections");
        if(rows.length<=0){
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipmentmaterial_dg").datagrid("getRowIndex", rows[i]);
            $("#equipmentmaterial_dg").datagrid("beginEdit", index);
            var eq = $("#equipmentmaterial_dg").datagrid('getEditor', {index:index,field:'description'});
			$(eq.target).combobox('disable');
        };
    }

	//删除
    function remove() {
        var rows = $("#equipmentmaterial_dg").datagrid("getSelections");
        if(rows.length<=0){
            ext.tip.error("<spring:message code='tip.atLeastOneSelected'/>");
            return;
        }
        var index = -1;
        for (var i = 0; i < rows.length; i++) {
            index = $("#equipmentmaterial_dg").datagrid("getRowIndex", rows[i]);
            $("#equipmentmaterial_dg").datagrid("deleteRow", index);
        }

    }

	//保存
    function save() {
        var dg = $("#equipmentmaterial_dg");

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
        
        if(inserted.length ==0 && updated.length ==0 && deleted.length ==0){
			
			$("#equipmentmaterial_dg").datagrid("reload");
            ext.tip.error("<spring:message code="tip.nosave" />");
		}else{
			for (var i = 0; i < updated.length; i++) {
	            updated[i].materialgroup_s = updated[i].dictname_s;
	        }
	        for (var i = 0; i < inserted.length; i++) {
	            inserted[i]['materialgroup_s'] = inserted[i].dictname_s;
            	inserted[i]['equipmentcode_s'] = inserted[i].description;
	            
	        }
			var arysave = new Array(); 
			var aryupdate = new Array(); 
			
			var narySave=arysave.sort();  
			var naryUpdate=aryupdate.sort();  
			for(var i=0;i<arysave.length;i++){  
				 if (narySave[i]==narySave[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return;
				 }
			 } 
			 for(var i=0;i<aryupdate.length;i++){  
				 if (naryUpdate[i]==naryUpdate[i+1]){  
					ext.tip.error("<spring:message code="tip.error" />");
					return; 
				 }
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
	            var opts = $("#equipmentmaterial_dg").datagrid("options");
				opts.url = 'halfpart/basedata/equipmentMaterial/datagrid';
		        ext.easyui.grid.search("equipmentmaterial_dg","EquipmentMaterial_search_form");
	            ext.tip.suc("<spring:message code="tip.success" />");
	
	        });
		}
        
    }

    function cancel() {
        $("#equipmentmaterial_dg").datagrid("rejectChanges");
    }
    
    function isprimary_material(v, r, i) {
		if(v == "0" ){
			return "是"; 
		}else {
			return "否"; 
		}
	}
	     
     function toEquipName(v, r, i) {
    	if(v == null) {
    		return v;
    	}
		$.ajax({
			url : 'halfpart/basedata/equipmentMaterial/toEquipName',
			type : 'get',
			dataType : 'json',
			data: {
				equipcode: v
			},
			async : false,
			success : function(data) {
				if(data.length == 0) {
					return v;
				}
				v = data[0].equipname;
			}
		});
		return v;
	}	
	
	 function toUserName(v, r, i) {
	 	if(v == null) {
    		return v;
    	}
		$.ajax({
			url : 'halfpart/basedata/equipmentMaterial/toUserName',
			type : 'get',
			dataType : 'json',
			data: {
				usercode: v
			},
			async : false,
			success : function(data) {
				if(data.length == 0) {
					return v;
				}
				v = v + data[0].username;
			}
		});
		return v;
	}
	
	function getNameByGroupCode(v, r, i) {
		$.ajax({
			url : 'halfpart/basedata/equipmentMaterial/getNameByGroupCode',
			type : 'get',
			dataType : 'json',
			data: {
				materialgroup_s: v
			},
			async : false,
			success : function(data) {
				v = data[0].dictname_s;
			}
		});
		return v;
	}
	
	function isp(v, r, i) {
		return "是";
	}
	
	function iss(v, r, i) {
		return "否";
	}
	function onEquipSelect() {
		var eqname = $('#equipmentcodes1').combobox('getValue');
		if(eqname != "") {
			$.ajax({
				url : 'halfpart/basedata/equipmentMaterial/filteByEquipName',
				type : 'get',
				dataType : 'json',
				data: {
					eqname: eqname
				},
				async : false,
				success : function(data) {
					$("#material_dg").datagrid('loadData',data);
				}
			});
		}
	}
	
	function onEquipSelect1() {
		var eqname = $('#equipmentcodes2').combobox('getValue');
		if(eqname != "") {
			$.ajax({
				url : 'halfpart/basedata/equipmentMaterial/filteByEquipName',
				type : 'get',
				dataType : 'json',
				data: {
					eqname: eqname
				},
				async : false,
				success : function(data) {
					$("#material_dg1").datagrid('loadData',data);
				}
			});
		}
	}


</script>