<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">

function onBeforeLoad(param){
	var row=$("#devtools_tables_dg").datagrid("getSelected");
	if(row==null)return false;
	param.tblName=row.name;
}

function add(){
	var row=ext.easyui.grid.getSelected("devtools_tables_dg");
    if(row==null)return false;
    var at_name=row.name;
    var pos=at_name.toUpperCase().lastIndexOf("_");
    if(pos>=0){
    	at_name=at_name.substring(pos+1,at_name.length);
    }
    
    $("#entityName").textbox("setValue",at_name);
    $("#tableName").textbox("setValue",row.name);
    $("#comment").textbox("setValue",row.memo);
    $("#tblName").val(row.name);
    
    $("#devtools_dlg").dialog("open");
}

function cancel(){
	$("#devtools_dlg").dialog("close");
}

function save(){
	if($("#entityName").textbox("getValue")==$("#entityName").textbox("getValue").toUpperCase()){
		ext.tip.error("请不要使用全大写的类名");
		return;
	}
	$('#devtools_form').form('submit', {
		onSubmit:function(){
			//验证表单中validtype类型是否满足
			var isValid = $(this).form('validate');
	        return isValid;
		},
	    success: function(data){
	        var data = eval('(' + data + ')');  // change the JSON string to javascript object
	        if(data.code==OK){
	        	//devtools/down?uuid=9cd83a5c-f8d4-4eea-ba36-672e11f9c313&entityName=FEEDINGRECORd
	        	console.log("devtools/down?uuid="+data.data+"&entityName="+$("#entityName").textbox("getValue"));
	        	location.href="devtools/down?uuid="+data.data+"&entityName="+$("#entityName").textbox("getValue");
	        }else{
	        	ext.tip.error("生成失败:"+data.message);
	        }
	    }
	});
	
}

























</script>