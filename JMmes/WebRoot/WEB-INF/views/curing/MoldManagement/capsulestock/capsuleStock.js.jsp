
<!-- 胶囊库存管理 -->

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	
/* 胶囊规格属性 */
$(function(){
	/* 规格 */
	var capsule_code_s = $("#dg").datagrid('getColumnOption', 'capsule_code_s');
	
	capsule_code_s.editor={type:'combobox',
		options:
            {
			
			valueField:'CAPSULE_SPEC_S',
            textField:'CAPSULE_SPEC_S',
            panelHeight:300,
            editable:'true',
            method:'get',
            url:"lh/kcgl/jnkc/comboxCapsule_spec",
            filter: function(q, row){  
		        var opts = $(this).combobox('options');  
		        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
		    },  
            required:true,
            onChange:function (value,o) {
            	/* 选择规格带出物料编码、校验码 */
    	 	if(value!=null||value!=undefined){ 
				var k=$(this).parents('[datagrid-row-index]').attr('datagrid-row-index');
		        var td=$('.datagrid-body td[field=\'material_code_s\']')[k];
		        var input = $(td).find('input')[0];
		        var td2=$('.datagrid-body td[field=\'parity_code_s\']')[k];
		        var input2 = $(td2).find('input')[0];
		        ext.ajax.sendJson("lh/kcgl/jnkc/getDataByspec", value, function(data) {
		        	$(input).textbox('setValue',data.MATERIAL_CAPSULECODE_S);
		        	$(input).textbox('disable');
		        	$(input2).textbox('setValue',data.PARITY_CODE_S);
		        	$(input2).textbox('disable');
				});
		   }
     	}
      }
	}
});
	/**
	 *数据字典传值
	 *
	 */
	function codeFormatter(v, r, i) {
	
		return dictFormat(v);
	}

	/**
	*添加事件
	*/
	function add() {
		ext.easyui.grid.appendAndEdit("dg",{
		});
	}
	
	function queryBar() {
		$("#query_bar").toggle(500);
	}
	
	

	/**
	*修改事件
	*/
	function edit() {

		var rows = $("#dg").datagrid("getSelections");
		var index = -1;
		if (rows == "") {
			ext.tip.error("<spring:message code="tip.edit" />");
		}
		for (var i = 0; i < rows.length; i++) {
			index = $("#dg").datagrid("getRowIndex", rows[i]);
			$("#dg").datagrid("beginEdit", index);
		}

	}
	/**
	*删除事件
	*/
	function remove() {

		var rows = $("#dg").datagrid("getSelections");
		var index = -1;
		if (rows == "") {
			ext.tip.error("<spring:message code="tip.remove" />");
		}else{
        for (var i = 0; i < rows.length; i++) {
			index = $("#dg").datagrid("getRowIndex", rows[i]);
			$("#dg").datagrid("deleteRow", index);
		}
		}
	}
	/**
	*保存事件
	*/
	function save() {
		var dg = $("#dg");

		var rows = dg.datagrid("getRows");
		console.log(rows);
		var valid = false;
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
		/*  数据回传，去掉对象中的扩展字段 */
		 for (var i = 0; i < inserted.length; i++) {
			 delete inserted[i]["created_by"];
			 delete inserted[i]["changed_by"];
		 }
		 for (var i = 0; i < updated.length; i++) {
			 delete updated[i]["created_by"]
			 delete	updated[i]["changed_by"];
		 }
		 for (var i = 0; i < deleted.length; i++) {
			 delete deleted[i]["created_by"];
			 delete deleted[i]["changed_by"];
		 }
		 if(inserted.length==0 && updated.length==0 && deleted.length==0){
			 ext.tip.error("<spring:message code="tip.nosave" />");
		 }else{
			ext.ajax.sendJson("lh/kcgl/jnkc/saveChanges", {
				inserted : inserted,
				updated : updated,
				deleted : deleted
			}, function(data) {
				if (data.message != 'ok') {
					 if(data.message=="代码重复"){
						 ext.tip.error("<spring:message code="tip.repeat" />");	 
					 }else{
						 ext.tip.error("<spring:message code="tip.error" />");
					 }
				}else{
					 $("#dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
	}

	/**
	*撤销事件
	*/
	function cancel() {
		$("#dg").datagrid("rejectChanges");
	}

	/**
	*条件查询/查全部
	*/
	function doSearch(){
		ext.easyui.grid.search("dg","CapsuleStock_form");
	}	
		
	/* 导入 */
	 function importCallback(data){
			$("#dg").datagrid("reload");
		}
	//即时库存
	function countStock(){
		$("#stock_dg").datagrid("reload");
		$('#w').window('open');
	}
	
</script>