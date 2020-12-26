<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	/*  标识位 */
	var test_flag_Text=function (value, rowData, rowIndex){
		if(value==1){
			return "是";
		}else if(value==0){
			return "否";
		}
	}
	//查询栏按钮
    function queryBar() {
    		$("#testparameter_form").toggle(500);
    	}
    /**
	*修改事件
	*/
	function edit() {

		var rows = $("#testparameter_dg").datagrid("getSelections");
		var index = -1;
		if (rows == "") {
			ext.tip.error("<spring:message code="tip.edit" />");
		}
		for (var i = 0; i < rows.length; i++) {
			debugger
			var parameter_name_s=rows[i]["parameter_name_s"];
			if(parameter_name_s.indexOf("色标")!=-1){
				  var formulapara_id=$("#testparameter_dg").datagrid('getColumnOption', "formulapara_id_s" ); //通过列名获得此列
				formulapara_id.editor={
					type:'combobox',
					options:{
						panelWidth:200,
						method:'get',
				        data:colorLineInfo,
				        valueField:'ERPCODE_S',
				        textField:'DICTNAME_S',}
				}  
			}else{
				 var formulapara_id=$("#testparameter_dg").datagrid('getColumnOption', "formulapara_id_s" ); //通过列名获得此列
					formulapara_id.editor={
						type:'textbox',
						
					}  
			}
			
			
			index = $("#testparameter_dg").datagrid("getRowIndex", rows[i]);
			$("#testparameter_dg").datagrid("beginEdit", index);
			
		}

	}
	/**
	*保存事件
	*/
	function save() {
		var dg = $("#testparameter_dg");

		var rows = dg.datagrid("getRows");
		for (var i = 0; i < rows.length; i++) {
			if (!dg.datagrid("validateRow", i)) {
				ext.tip.error("请输入正确的数据");
				return;
			}
		}
		var updated = dg.datagrid("getChanges", "updated");
		 for (var i = 0; i < rows.length; i++) {
			dg.datagrid("endEdit", i);
		} 
		 if(updated.length==0 ){
			 ext.tip.error("<spring:message code="tip.nosave" />");
		 }else{
			ext.ajax.sendJson("curing/ProductionManagement/testParameter/saveChanges", {
				updated : updated,
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#testparameter_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
	}
	//启用
	function start() {
		var dg = $("#testparameter_dg");
		var rows = dg.datagrid("getRows");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["test_flag_s"]=1;
			} 
		 if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.search" />");
		 }else{
			 console.log(rows[0]["producting_dayplan_s"])
			ext.ajax.sendJson("curing/ProductionManagement/testParameter/flagChanges", {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#testparameter_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
	}
	//停用
	function stop() {
		var dg = $("#testparameter_dg");
		var rows = dg.datagrid("getRows");
		 for (var i = 0; i < rows.length; i++) {
			 rows[i]["test_flag_s"]=0;
			} 
		 if(rows.length==0 ){
			 ext.tip.error("<spring:message code="tip.search" />");
		 }else{
			 console.log(rows[0]["producting_dayplan_s"])
			ext.ajax.sendJson("curing/ProductionManagement/testParameter/flagChanges", {
				updated:rows
			}, function(data) {
				if (data.message != 'ok') {
					 ext.tip.error("<spring:message code="tip.error" />");
				}else{
					 $("#testparameter_dg").datagrid("reload"); 
					 ext.tip.suc("<spring:message code="tip.success" />");
				}
	
			});
		 }
	}
	/**
	*条件查询/查全部
	*/
	function doSearch(){
		var production_dayplan_s=$("#production_dayplan_s").textbox("getValue");
		if(production_dayplan_s==""){
			ext.tip.error("<spring:message code="tip.plandaycode" />");
		}else{
			$("#testparameter_dg").datagrid("options").url="curing/productionManagement/planCuringParameter/getParameter";
			ext.easyui.grid.search("testparameter_dg","testparameter_form");
		}
		
	}
	/**
	*撤销事件
	*/
	function cancel() {
		$("#testparameter_dg").datagrid("rejectChanges");
	}
	var datasource=[];
	//机台下拉框，选择事件
	var onChangePlan=function(value){
		
		 $.ajax({
		 		url:"curing/ProductionManagement/testParameter/getPlanByEquip?equip_code="+value["EQUIP_CODE_S"],
		 		type:"get",
		 		dataType:"json",
		 		async:false,
		 		success:function(data){
		 			datasource=data;
		 		} }); 
		
	      $("#production_dayplan_s").textbox("clear");
	      $("#production_dayplan_s").combobox("loadData",datasource);
	      $("#production_dayplan_s").combobox("select",datasource[0].PLAN_NO_S);
	}
	/**
     * 接收色标线数据
     */
     var colorLineInfo=[];
 	
 	$.ajax({
 		url:"curing/productionManagement/planCuringParameter/colorMarkingLine",
 		type:"get",
 		dataType:"json",
 		async:false,
 		success:function(data){
 			colorLineInfo=data;
 		}
 	});
	//色标线转换
	function colorMarkingLineFormatter(v,r,i){
		if(r.parameter_name_s.indexOf("色标")!=-1){
			
			for(var i=0;i<colorLineInfo.length;i++){
				if(r.parameter_value_s==colorLineInfo[i].ERPCODE_S){
					return colorLineInfo[i].DICTNAME_S;
				}
			}
		}
		else{
			return v;
		}
	}
	//色标线修改值转换
	function colorChangeFormatter(v,r,i){
		if(r.parameter_name_s.indexOf("色标")!=-1){
			for(var i=0;i<colorLineInfo.length;i++){
				if(r.formulapara_id_s==colorLineInfo[i].ERPCODE_S){
					return colorLineInfo[i].DICTNAME_S;
				}
			}
		}
		else{
			return v;
		}
	}
	
	function toUserName(v, r, i) {
	 	if(v == null) {
    		return v;
    	}
		$.ajax({
			url : 'curing/ProductionManagement/testParameter/toUserName',
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
	
</script>