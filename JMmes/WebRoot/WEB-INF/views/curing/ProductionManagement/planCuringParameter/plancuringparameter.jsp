<!-- 

    作者      :whl
    时间      :2018-09-04 18:37:22 
    页面名称:工艺参数查询（后改为PLC正执行的参数）
    文件关联:
        PlanCuringParameter.java
        PlanCuringParameterController.java
        PlanCuringParameterServiceImpl.java
        PlanCuringParameterServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="plancuringparameter.js.jsp"%>
<style type="text/css">
table {
	/*列宽由表格宽度和列宽度设定*/
	table-layout: fixed;
}
</style>
<body class="easyui-layout" fit="true">
	<form id="PlanDayParameter_search_form" class="form">
		<table class="formTable">
			<tr>
				<td class="columnTitle">
					<!-- 机台条码 --> 
					<spring:message code="plandayparameter.column.production_line" />:
				</td>
				<td><input name="filter[production_line_s]" id="equip_code_left_s" type="text" class="easyui-textbox" data-options="label:''"></td>
				<td class="columnTitle">
					<!-- 胎胚条码（左） --> 
					<spring:message code="plandayparameter.column.production_bom_left_s" />:
				</td>
				<td><input name="filter[specification_left_s]" id="production_bom_left_s" type="text" class="easyui-textbox" data-options="label:''"></td>
			</tr>
			<tr>
				<td class="columnTitle">
					<!-- 胎胚条码（右） --> 
					<spring:message code="plandayparameter.column.production_bom_right_s" />:
				</td>
				<td><input name="filter[specification_right_s]" id="production_bom_right_s" type="text" class="easyui-textbox" data-options="label:''"></td>
				<td class="columnTitle"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a></td>
			</tr>
		</table>
	</form>
	<div data-options="region:'west',split:true" style="width:60%;">
		<table id="plandayparameter_dg" class="easyui-datagrid" style="width:100%"
			data-options="  
			                fit:true,
			                fitColumns:false,
			                pagination:true,
			                rownumbers: true,
			                singleSelect: true,
			                toolbar: '#PlanDayParameter_search_form',
			                url: 'curing/productionManagement/planCuringParameter/getPlan',
			                striped:true,
			                method: 'get',
			                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
			                title:'<span><spring:message code='plandayparameter.column.plan_info'/></span>',
			                ">
			<thead>
				<tr>
					<!-- <th data-options="field:'atr_key',checkbox:true">ID</th> -->
					<!-- 日计划号-->
					<th data-options="field:'plan_no_s',width:100,editor:{type:'textbox'}"><spring:message code="plandayparameter.column.plan_no_s" /></th>
					<!-- 机台条码 -->
					<th data-options="field:'production_line_s',width:100,editor:{type:'textbox'}"><spring:message code="plandayparameter.column.production_line" /></th>
					<!-- 机台名称-->
					<th data-options="field:'equip_group_s',width:100,editor:{type:'textbox'}"><spring:message code="plandayparameter.column.equip_group_s" /></th>
					<!-- 胎胚名称(左) -->
					<th data-options="field:'material_code_left_s',width:100,editor:{type:'textbox'},formatter:parameter"><spring:message code="plandayparameter.column.material_code_left_s" /></th>
					<!-- 胎胚名称(右) -->
					<th data-options="field:'material_code_right_s',width:100,editor:{type:'textbox'},formatter:parameterr"><spring:message code="plandayparameter.column.material_code_right_s" /></th>
					<!-- 胎胚品号（左） -->
					<th data-options="field:'specification_left_s',width:100,editor:{type:'textbox'}"><spring:message code="plandayparameter.column.production_bom_left_s" /></th>
					<!-- 胎胚品号（右） -->
					<th data-options="field:'specification_right_s',width:100,editor:{type:'textbox'}"><spring:message code="plandayparameter.column.production_bom_right_s" /></th>
					<!-- 修改时间 -->
					<th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="plandayparameter.column.changed_time_t" /></th>
					<!-- 创建时间 -->
					<th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="plandayparameter.column.created_time_t" /></th>
				</tr>
			</thead>
		</table>
	</div>
	<div data-options="region:'center',title:'',split:true" style="width:40%;">
		<form id="plancuringparameter_form" style="display:none">
			<!-- 日计划号 -->
			<input name="filter[producting_dayplan_s]" id="production_dayplan_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="plandayparameter.column.plan_no_s" />'"> 
			<input name="filter[tyre_materialcode_s]" id="tyre_materialcode_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="plandayparameter.production_bom_left_s" />'">
			<input name="filter[material_code_left_s]" id="material_code_left_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="plandayparameter.column.plan_no_s" />'"> 
			<%-- <input name="filter[material_code_right_s]" id="material_code_right_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="plandayparameter.column.plan_no_s" />'">  --%>
			
		</form>
		<table id="plancuringparameter_dg" class="easyui-datagrid" style="width:100%"
			data-options="  
             fit:true,
             fitColumns:true,
             pagination:true,
             rownumbers: true,
             singleSelect: true,
             toolbar: '',
             striped:true,
             pageSize: 100,
             method: 'get' ,
             emptyMsg:'<span><spring:message code='tip.noData'/></span>',
             title:'<span><spring:message code='plandayparameter.column.formula_info'/></span>',
             ">
			<thead>
				<tr>
					<!-- <th data-options="field:'ATR_KEY',checkbox:true">ID</th> -->
					<!-- 参数名称 -->
					<th data-options="field:'parameter_name_s',width:80,editor:{type:'textbox'}"><spring:message code="plancuringparameter.column.parameter_name_s" /></th>
					<!-- 参数值 -->
					<th data-options="field:'parameter_value_s',width:80,editor:{type:'textbox'},formatter:colorMarkingLineFormatter"><spring:message code="plancuringparameter.column.parameter_value_s" /></th>
				</tr>
			</thead>
		</table>
	</div>
	<!-- 	导出-->
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="PlanDayParameter_search_form" />
		<jsp:param name="datagridId" value="plandayparameter_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.ExcelHandler.PlanCuringParameterExportHandler" />
		<jsp:param name="serviceName" value="PlanCuringParameterServiceImpl" />
	</jsp:include>
</body>
</html>
