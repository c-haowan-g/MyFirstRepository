<%@page import="org.xdemo.app.xutils.j2se.DateUtils"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

    var saveChanges=path+"curing/ProductionManagement/sap_return_result/saveChanges";
    
    function showOrHide(){
        if($("#SapReturnResult_search_form").is(":hidden")){
            $("#SapReturnResult_search_form").show();
        }else{
            $("#SapReturnResult_search_form").hide();
        }
    }
    
  //报产方式
    function bcTypeFormatter(v, r, i) {
        if (v == '01') {
            return '报产';
        } else if (v == '02') {
            return '冲产';
        }
    }
  
    function codeFormatter(v, r, i) {
        return dictFormat(v);
    }
    
  //固化标识转换
    function ghFormatter(v, r, i) {
        if (v == '1') {
            return '已固化';
        } else {
            return '未固化';
        }
    }

    function rsFormatter(v, r, i) {
        if (v == '0') {
            return 'SAP未读取';
        } else if (v == '1') {
            return '已读取';
        } else if (v == '2') {
            return '正常';
        } else if (v == '3') {
            return '错误';
        } else {
            return v;
        }
    }
    
    function onMesSapDgBeforeLoad(param){
    	param["filter[product_type_s]"]="02";
    }
    
    /**
     * 查询方法
     */
    var filter=function(){
        ext.easyui.grid.search("messapproduction_dg","MesSapProduction_search_form");
    }


    
    
    function save() {

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
        
        for(var i=0;i<deleted.length;i++){
        	deleted[i].record_flag_s="D";
        }

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
            $("#sapreturnresult_dg").datagrid("reload");
            ext.tip.suc("<spring:message code="tip.success" />")

        });
    }

    function cancel() {
        $("#sapreturnresult_dg").datagrid("rejectChanges");
    }
    
    var now="<%=DateUtils.now("yyyy-MM")%>";
    
    $(document).ready(function(){
    	var cal=new Calendar(now);
    	$("#beginTime").datetimebox("setValue", now+"-01 00:00:00");
    	var lastDay=Calendar.lastDayOfMonth(cal.format("yyyy"),cal.format("MM"));
    	$("#endTime").datetimebox("setValue", now+"-"+lastDay+" 23:59:59");
    });

	function onEndSelect(d) {
		var month = new Calendar(d).format("yyyy-MM");
		if (month != now) {
			$("#endTime").datetimebox("setValue", "");
			$("#endTime").datetimebox("hidePanel");
			return;
		}
		guhua_filter();
	}

	function onBeginSelect(d) {
		var month = new Calendar(d).format("yyyy-MM");
		if (month != now) {
			$("#beginTime").datetimebox("setValue", "");
			$("#beginTime").datetimebox("hidePanel");
			return;
		}
		guhua_filter();
	}

	//上报数据
	function reporttosap() {
		ext.ajax.get("curing/report/productionSubsidiaryQuery/reporttosap", function(data) {
			if (data.code == OK) {
				ext.tip.suc();
				filter();
			}

			if (data.code == ERROR) {
				ext.tip.error("上报失败");
			}
		});
	}

	function guhua_dlg() {
		$("#guhua_dlg").dialog("open");
		guhua_filter();
	}

	function guhua_filter() {
		var beginTime = $("#beginTime").datetimebox("getValue");
		var endTime = $("#endTime").datetimebox("getValue");
		if (beginTime == "" || endTime == "") {
			return;
		}
		var material_code_s = $("#material_code").textbox("getValue");
		ext.ajax.get("curing/ProductionManagement/sap_return_result/guhua?beginTime=" + beginTime
				+ "&endTime=" + endTime+"&material_code_s="+material_code_s, function(data) {
			$("#messapproduction_dg2").datagrid("loadData", data.data);
		});
	}

	function guhua() {
		var rows = $("#messapproduction_dg2").datagrid("getSelections");
		var beginTime = $("#beginTime").datetimebox("getValue");
		var endTime = $("#endTime").datetimebox("getValue");
		debugger;
		var data = {
			inserted : rows,
			begintime : beginTime,
			endtime : endTime
		};
		ext.ajax.sendJson("curing/ProductionManagement/sap_return_result/guhua", data, function(
				data) {
			if (data.code==1) {
				 ext.tip.error("<spring:message code="data.message" />");
				 return;
			}
			guhua_filter();
			console.log(data);
		});
		
	}
	function onMtSelect(r){
		var index = $(this).parents("[datagrid-row-index]").attr(
        "datagrid-row-index");
		var editor = getEditor("messapproduction_dg", index, "material_name_s").target;
		$(editor).textbox("setValue", r.materialname_s || '无');
		
		editor = getEditor("messapproduction_dg", index, "pro_version_s").target;
		$(editor).combobox("clear");
		$(editor).combobox("loadData", []);
		ext.ajax.get(
		        "common/material/version?materialCode=" + r.materialcode_s,
		        function(data) {
		            $(editor).combobox("loadData", data);
		        });
	}
	
	/**
     * 获取指定行、指定列的编辑器
     */
    function getEditor(dgId, index, field) {
        try {
            return $("#" + dgId).datagrid("getEditor", {
                index : index,
                field : field
            });
        } catch (e) {
            return null;
        }

    }

    /**
     * 获取指定行、指定列的编辑器
     */
    function getEditorValue(dgId, index, field) {
        return $("#" + dgId).datagrid("getEditor", {
            index : index,
            field : field
        });
    }

    /**
     * 清空指定行指定列的值
     */
    function clearFieldValue(dgId, index, field) {
        try {
            $(getEditor(dgId, index, field).target).combobox("clear")
        } catch (e) {
        }
        try {
            $(getEditor(dgId, index, field).target).numberspinner("clear")
        } catch (e) {
        }
        try {
            $(getEditor(dgId, index, field).target).textbox("clear")
        } catch (e) {
        }
        try {
            $(getEditor(dgId, index, field).target).combobox("clear")
        } catch (e) {
        }

    }

    function getRowByIndex(dgId, index) {
        return $("#" + dgId).datagrid("getRows")[index];
    }

    function getFieldValue(dgId, index, field) {
        var v = "";
        if (getEditor(dgId, index, field) == null) {
            return getRowByIndex(dgId, index)[field];
        }
        try {
            v = $(getEditor(dgId, index, field).target).combobox("getValue");
        } catch (e) {
        }
        try {
            v = $(getEditor(dgId, index, field).target).numberspinner(
                    "getValue");
        } catch (e) {
        }
        try {
            v = $(getEditor(dgId, index, field).target).textbox("getValue");
        } catch (e) {
        }
        try {
            v = $(getEditor(dgId, index, field).target).combobox("getValue");
        } catch (e) {
        }

        return v;
    }
    
    function onOrderBeforeLoad(param){
    	param["type"]="02";
    }
	
	function save(){
	    
		var data={};
        
        var rows=$("#messapproduction_dg").datagrid("getRows");
        
        var inserted=$("#messapproduction_dg").datagrid("getChanges","inserted");
        var deleted=$("#messapproduction_dg").datagrid("getChanges","deleted");
        var updated=$("#messapproduction_dg").datagrid("getChanges","updated");
        
        data.inserted=inserted;
        data.deleted=deleted;
        data.updated=updated;
        debugger;
        for(var i=0;i<rows.length;i++){
            if(!$("#messapproduction_dg").datagrid("validateRow",i)){
                return;
            }
        }
        
        for(var i=0;i<rows.length;i++){
            $("#messapproduction_dg").datagrid("endEdit",i);
        }
        var _inserted=[];
        
        Utils.each(inserted,function(i,e){
        	_inserted.push({serid_s:e.serid_s,material_code_s:e.material_code_s,material_name_s:e.material_name_s,class_id_s:e.class_id_s,total:e.actual_quantity_f,productionver_s:e.pro_version_s});
        });
        
        var _updated=[];
        
        Utils.each(updated,function(i,e){
        	_updated.push({atr_key:e.atr_key,material_code_s:e.material_code_s,material_name_s:e.material_name_s,class_id_s:e.class_id_s,total:e.actual_quantity_f,productionver_s:e.pro_version_s});
        });
        
        var _deleted=[];
       
        Utils.each(deleted,function(i,e){
        	_deleted.push({atr_key:e.atr_key,material_code_s:e.material_code_s,material_name_s:e.material_name_s,class_id_s:e.class_id_s,total:e.actual_quantity_f,productionver_s:e.pro_version_s});
        });
       
        ext.ajax.sendJson("curing/ProductionManagement/sap_return_result/guhua", {inserted:_inserted,updated:_updated,deleted:_deleted}, function(data) {
            if(data.code==OK){
            	ext.tip.suc("保存成功");
            	filter();
            	return;
            }
            ext.tip.error(data.msg);
        });
	}
	
	function add(){
		$("#messapproduction_dg").datagrid("insertRow",{
			index:0,
			row:{
				s_factory_s:factory,
				product_type_s:'02',
				storage_loc_s:(factory=='1'?'L290':'L190'),
				record_sap_flag_s:0,
				process_s:252006,
				reverser_flag_s:1,
				solid_flag_s:1
			}
		});
		
		$("#messapproduction_dg").datagrid("beginEdit",0);
		var editor=getEditor("messapproduction_dg", 0, "serid_s").target;
        $(editor).combobox({readonly:false,editable:true});
	}
	
	function enableCellEditing(data){
	}
	
	function edit(){
		var rows = $("#messapproduction_dg").datagrid("getChecked");
		
		for (var i = 0; i < rows.length; i++) {
            var atk=rows[i].atr_key;
            var index=$("#messapproduction_dg").datagrid("getRowIndex",rows[i]);
            $("#messapproduction_dg").datagrid("beginEdit", index);
            if(atk){
                var editor = getEditor("messapproduction_dg", index, "material_code_s").target;
                $(editor).combobox({readonly:true});
                $(editor).combobox("setValue",rows[i].material_code_s);
                ext.ajax.get(
                        "common/material/version?materialCode=" + rows[i].material_code_s,
                        function(data) {
                        	editor=getEditor("messapproduction_dg", index, "pro_version_s").target;
                            $(editor).combobox("loadData", data);
              });
            }
        }
	}
	
	function remove(){
		var rows = $("#messapproduction_dg").datagrid("getChecked");
		for (var i = 0; i < rows.length; i++) {
            var index=$("#messapproduction_dg").datagrid("getRowIndex",rows[i]);
            $("#messapproduction_dg").datagrid("deleteRow", index);
        }
	}
	
	  function codeFormatter(v, r, i) {
	        return dictFormat(v);
	    }
</script>