<!-- 

    作者      :时永良
    时间      :2019-02-26 17:37:56 
    页面名称:成型日计划表查询
    文件关联:
        CxProductionDayPlan.java
        CxProductionDayPlanController.java
        CxProductionDayPlanServiceImpl.java
        CxProductionDayPlanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="productiondayplansearch.js.jsp"%>
<script type="text/javascript" src="dict/152,-307,328.js"></script>

<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="CxProductionDayPlan_dg_toolbar">
			<form id="CxProductionDayPlan_search_form" class="form">

                <!-- 设备条码 -->
                <spring:message code="cxproductiondayplan.column.equip_code_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                                 required:false, 
                                 url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name',
	                             icons:[{iconCls:'icon-clear',
					             handler:clearEquipCode}]" >

				<!-- 胎胚物料编码（SAP品号） -->
				<spring:message code="cxproductiondayplan.column.material_code_s" />
				:&emsp;<input name="filter[material_code_s]" like=true id="material_code_s" type="text" class="easyui-combobox" data-options="label:'',
				                 required:false, 
                                 url:'Part/halbMaterialListForDay',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'PART_NUMBER',
	                             textField:'PART_NUMBER',
	                             icons:[{iconCls:'icon-clear',
					             handler:clearMaterial}]">
				
				<!-- 规格代码 -->
				<spring:message code="cxproductiondayplan.column.specification_s" />
                :&emsp;<input name="filter[specification_s]" like=true id="specification_s" type="text" class="easyui-textbox" data-options="width:100,labelWidth:100,label:''" >
				
				
				<!-- 计划生产日期 -->
				<spring:message code="cxproductiondayplan.column.production_date_t" />
				:&emsp;<input name="filter[production_date_s]" id="production_date_s" type="text" class="easyui-datebox" data-options="onChange:filter,buttons:[],formatter:dateFormat,parser:dateParser,label:''">
				     <script type="text/javascript">
                $("#production_date_s").val(new Calendar().format("yyyyMMdd"));
                </script>
			
				<br><!-- 计划状态 -->
				<spring:message code="cxproductiondayplan.column.status_s" />
				:&emsp;<input name="filter[status_s]" id="status_s" type="text" class="easyui-combobox" data-options="label:'',
				                    url:'dict/code/152',
				                    valueField:'code',
				                    icons:[{iconCls:'icon-clear',
					                handler:clearPlanStatus}]">
			
				&nbsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
			<auth:button code="CX_BAN_GANG_PRODUCTIONPLANSEARCH_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
			</form>
		</div>
		<table id="cxproductiondayplan_dg" class="easyui-datagrid" style="width:100%"
			data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CxProductionDayPlan_dg_toolbar',
                url: 'building/productionPlan/productiondayplan/datagrid',
                striped:true,
                onBeforeLoad:onDgBeforeLoad,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
			<thead>
				<tr>
					<th data-options="required:true,field:'atr_key',checkbox:true"></th>
					<!-- 日计划号 -->
					<th data-options="required:true,field:'plan_no_s',editor:{type:'textbox',options:{editable:false,icons:[]}}"><spring:message code="cxproductiondayplan.column.plan_no_s" /></th>
					<!-- 计划状态 -->
					<th data-options="required:true,formatter:codeFormatter,field:'status_s',editor:{type:'combobox',width:100,options:{url:'dict/code/152',disabled:true,valueField:'code'}}"><spring:message code="cxproductiondayplan.column.status_s" /></th>
					<!-- 设备条码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'combobox',options:{panelHeight:200,required:true,icons:[],editable:true,data:jtxx}}"><spring:message code="productiondayplan.column.equip_code_s" /></th>
			        <!-- 计划生产日期 -->
					<th data-options="required:true,field:'production_date_s',width:100,editor:{type:'textbox',options:{required:true,editable:false,icons:[]}}"><spring:message code="cxproductiondayplan.column.production_date_s" /></th>
			        <!-- 胎胚物料编码（SAP品号） -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.material_code_s" /></th>
                    <!-- 胎胚物料名称 -->
                    <th data-options="field:'material_desc_s',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.material_desc_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.specification_s" /></th>
                    <!-- 日计划量 -->
                    <th data-options="field:'quantity_dayplan_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.quantity_dayplan_i" /></th>
                    <!-- 日完成量 -->
                    <th data-options="field:'quantity_dayproduct_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.quantity_dayproduct_i" /></th>
                    <!-- 日完成百分比 -->
                    <th data-options="field:'quantity_dayproduct_finishbl',formatter:progressFormatter,editor:{type:'textbox'}">日完成量百分比</th>
                    
                    <!-- 早班计划量 -->
                    <th data-options="field:'planamount_mor_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_mor_i" /></th>
                    <!-- 早班完成量 -->
                    <th data-options="field:'output_morclass_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_morclass_i" /></th>
                    <!-- 早班完成百分比 -->
                    <th data-options="field:'planamount_mor_finishbl',formatter:progressFormatter,editor:{type:'textbox'}">早班完成量百分比</th>
                    
                    <!-- 中班计划量 -->
                    <th data-options="field:'planamount_mid_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_mid_i" /></th>
                    <!-- 中班完成量 -->
                    <th data-options="field:'output_midclass_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_midclass_i" /></th>
                    <!-- 中班完成百分比 -->
                    <th data-options="field:'planamount_mid_finishbl',formatter:progressFormatter,editor:{type:'textbox'}">中班完成量百分比</th>
                    
                    
                    <!-- 晚班计划量 -->
                    <th data-options="field:'planamount_nig_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_nig_i" /></th>
                    <!-- 晚班完成量 -->
                    <th data-options="field:'output_nigclass_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_nigclass_i" /></th>
                    <!-- 晚班完成百分比 -->
                    <th data-options="field:'planamount_nig_finishbl',formatter:progressFormatter,editor:{type:'textbox'}">晚班完成量百分比</th>
                    
                   
			  
			   </tr>
			</thead>
		</table>
	</div>
	</div><jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CxProductionDayPlan_search_form" />
		<jsp:param name="datagridId" value="cxproductiondayplan_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.ProductionDayPlanSearchExportHandler" />
		<jsp:param name="serviceName" value="CxProductionDayPlanServiceImpl" />
	</jsp:include>
</body>
</html>
