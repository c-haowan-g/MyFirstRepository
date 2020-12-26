
<!-- 胶囊模具库位维护 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	

	/* 库存类型 */
	var inventory_type_s="";
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
		 if(inserted.length==0 && updated.length==0 && deleted.length==0){
			 ext.tip.error("<spring:message code="tip.nosave" />");
		 }else{
			ext.ajax.sendJson("lh/jcgl/mjjnkw/saveAll", {
				inserted : inserted,
				updated : updated,
				deleted : deleted
			}, function(data) {
				console.log(data)
				if (data.code==1) {
					 if(data.message=="代码重复"){
						 ext.tip.error("<spring:message code="tip.repeat" />");	 
					 }else{
						 ext.tip.error("<spring:message code="tip.error" />");
					 }
				}else{
					 $("#dg").datagrid("reload"); 
					 $("#tree").tree("reload"); 
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
		ext.easyui.grid.search("dg","condition_form");
	}	
	/* 初始化tree**************************************************** */
	$(document).ready(function() {
		initTree();
	});
	function TreeSearch(){
		ext.easyui.grid.search("dg","tree_form");
	}
/**
 * 左侧库存类型树形菜单
 */
 function initTree(){
		$("#tree").tree({  
			 url:'lh/jcgl/mjjnkw/getOrgTree',  
			 method: 'GET',  
			 animate: true,  
			 cascadeCheck:true,//层叠选中  
			 lines:true,//显示虚线效果  
			 onLoadSuccess:function(node,data){  
			  var nodeDep = $('#tree').tree('find',checkeid);  
			  if (null != nodeDep && undefined != nodeDep)  
			  {  
			      $('#tree').tree('check',nodeDep.target);  
			  }  
			 },  
			 onClick:function(node){  
			      if(node.id==null){
			    	  $("#inventory_type_tree").val(node.text);
			    	  $("#inventory_name_cn_tree").val("");
			    	  $("#inventory_type").combobox("setValue",node.text); 
 					/* 默认给库存类型赋值 */
			    	  inventory_type_s=node.text;
			      }else{
			    	  $("#inventory_name_cn_tree").val(node.text);
			    	  var checknodes = $("#tree").tree("getParent", node.target);
			    	  $("#inventory_type_tree").val(checknodes.text); 
			    	  $("#inventory_type").combobox("setValue",checknodes.text); 
			    	  /* 默认给库存类型赋值 */
			    	  inventory_type_s=checknodes.text;
			      }
			      
			    /* $("#inventory_name_cn_tree").val()  点击左侧树形菜单，条件查询右侧数据 */
			      TreeSearch();
			    	
				}   
			});
	}
	
 /**
	*添加事件
	*/
	function add() {
		ext.easyui.grid.appendAndEdit("dg",{
			inventory_type_s:inventory_type_s,
			inventory_name_cn_s:$("#inventory_name_cn_tree").val()
		});
	}

</script>