<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
    
    function clicktree(node){
    	$("#tree_model").tree("expand",node.target);
    }
    //初始化树节点数字
    var treelevel=null;
    //树节点上点击事件
    function selecttree(node){
    	var currentNode = $("#tree_model").tree("getSelected");
		treelevel = getLevel(currentNode, 0);
		$.ajax({
	 		url:"common/basedata/factorymodel/getTreeNodeInfo?level="+treelevel+"&key="+currentNode.id,
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(data){
	 			$("#Infoname").textbox("setValue",code=data[0].name);
	 			$("#Infodescription").textbox("setValue",currentNode.text);
	 		}
	 	});
		
		
		$("#infoTypeList").datalist("selectRow",treelevel);
		
    	$("#tree_model").tree("expand",node.target);
    }
    
	function getLevel(node, level) {
		if ($("#tree_model").tree("getParent", node.target) == null) {
			return level;
		} else {
			return getLevel($("#tree_model").tree("getParent", node.target),
					++level);
		}
	}
	//添加
    function add() {
    	var currentNode = $("#tree_model").tree("getSelected");
    	if(currentNode==null){
    		ext.tip.error("请在左侧树点击要添加的位置");
    		return;
    	}
    	treelevel = getLevel(currentNode, 0);
    	if(treelevel==6){
    		ext.tip.error("暂不支持子设备下继续维护");
    		return;
    	}
    	$("#main_dlg").dialog("open");
    }
	
    //添加页面初始化时候清除内容
	function maindlgOpen(){
		$("#modelName").textbox('clear');
		$("#modelDescription").textbox('clear');
	}
    //添加保存
    function addsave() {
    	var currentNode = $("#tree_model").tree("getSelected");
    	//var parentNode=$("#tree_model").tree("getParent", currentNode.target);
    	var modelName=$("#modelName").textbox("getValue");
    	var modelDescription=$("#modelDescription").textbox("getValue");
    	var list_map={};
    	list_map.level=treelevel;//
		list_map.parentcode=currentNode.id;//
		list_map.name=modelName;
		list_map.description=modelDescription;
		 $.ajax({
		 		url:'common/basedata/factorymodel/add',
		 		type:"post",
		 		dataType:"json",
		 		data : JSON.stringify(list_map),
				contentType:'application/json',
		 		async:false,
		 		success:function(data){
		 			$("#main_dlg").dialog("close");
		 			ext.tip.suc("操作成功");
		 			$("#tree_model").tree('append', {
		 				parent: currentNode.target,
		 				data: [{
		 					id: data.id,
		 					text: data.text
		 				}]
		 			});
		 			
		 		}
		 });
    }

    //弹出新增页面的取消按钮
    function addcancel() {
    	$("#main_dlg").dialog("close");
    }
    
    //编辑
    function edit() {
    	var currentNode = $("#tree_model").tree("getSelected");
    	if(currentNode==null){
    		ext.tip.error("请在左侧树点击要编辑的节点");
    		return;
    	}
    	$("#mainedit_dlg").dialog("open");
    }
    //编辑页面初始化时候复赋值
	function maineditdlgOpen(){
		var currentNode = $("#tree_model").tree("getSelected");
		treelevel = getLevel(currentNode, 0);
		$.ajax({
	 		url:"common/basedata/factorymodel/getTreeNodeInfo?level="+treelevel+"&key="+currentNode.id,
	 		type:"get",
	 		dataType:"json",
	 		async:false,
	 		success:function(data){
	 			$("#modelEditName").textbox("setValue",code=data[0].name);
	 			$("#modelEditDescription").textbox("setValue",currentNode.text);
	 		}
	 	});
	}
    //编辑保存
    function editsave(){
    	var currentNode = $("#tree_model").tree("getSelected");
    	var modelName=$("#modelEditName").textbox("getValue");
    	var modelDescription=$("#modelEditDescription").textbox("getValue");
    	var list_map={};
    	list_map.level=treelevel;//
    	list_map.id=currentNode.id;
		list_map.name=modelName;
		list_map.description=modelDescription;
		 $.ajax({
		 		url:'common/basedata/factorymodel/edit',
		 		type:"post",
		 		dataType:"json",
		 		data : JSON.stringify(list_map),
				contentType:'application/json',
		 		async:false,
		 		success:function(data){
		 			$("#mainedit_dlg").dialog("close");
		 			ext.tip.suc("操作成功");
		 			if (currentNode){
		 				$("#tree_model").tree('update', {
		 					target: currentNode.target,
		 					text: modelDescription
		 				});
		 			}
		 		}
		 });
    }
    //弹出编辑页面的取消按钮
    function editcancel(){
    	$("#mainedit_dlg").dialog("close");
    }
    //删除
	function remove(){
		var currentNode = $("#tree_model").tree("getSelected");
    	var parentNode=$("#tree_model").tree("getParent", currentNode.target);
    	var chilNode=$("#tree_model").tree("getChildren", currentNode.target);
    	treelevel = getLevel(currentNode, 0);
    	if(chilNode.length!=0){
    		ext.tip.error("请先全部删除子节点");
    		return;
    	}
    	var list_map={};
    	list_map.level=treelevel;//
		list_map.parentcode=parentNode.id;//
		list_map.code=currentNode.id;
		 $.ajax({
		 		url:'common/basedata/factorymodel/remove',
		 		type:"post",
		 		dataType:"json",
		 		data : JSON.stringify(list_map),
				contentType:'application/json',
		 		async:false,
		 		success:function(data){
		 			ext.tip.suc("操作成功");
		 			$("#tree_model").tree('remove', currentNode.target);
		 		}
		 });
	}
	 //保存右侧名称描述修改
    function savenamedescription(){
    	var currentNode = $("#tree_model").tree("getSelected");
    	if(currentNode==null){
    		ext.tip.error("请在左侧树点击要编辑的节点");
    		return;
    	}
    	var modelName=$("#Infoname").textbox("getValue");
    	var modelDescription=$("#Infodescription").textbox("getValue");
    	var list_map={};
    	list_map.level=treelevel;
    	list_map.id=currentNode.id;
		list_map.name=modelName;
		list_map.description=modelDescription;
		 $.ajax({
		 		url:'common/basedata/factorymodel/edit',
		 		type:"post",
		 		dataType:"json",
		 		data : JSON.stringify(list_map),
				contentType:'application/json',
		 		async:true,
		 		success:function(data){
		 			ext.tip.suc("操作成功");
		 			if (currentNode){
		 				$("#tree_model").tree('update', {
		 					target: currentNode.target,
		 					text: modelDescription
		 				});
		 			}
		 		}
		 });
    }
</script>