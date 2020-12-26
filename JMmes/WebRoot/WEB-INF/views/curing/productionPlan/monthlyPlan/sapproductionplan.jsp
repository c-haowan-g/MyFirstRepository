<!-- 

    作者      :王海霖
    时间      :2018-08-07 13:15:32 
    页面名称:硫化月计划编制
    文件关联:
        SapProductionPlan.java
        SapProductionPlanController.java
        SapProductionPlanServiceImpl.java
        SapProductionPlanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sapproductionplan.js.jsp"%>

<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="SapProductionPlan_dg_toolbar">
			<form id="SapProductionPlan_search_form" class="form">
				<!-- 月份 -->
				<spring:message code="sapproductionplan.column.month_i" />:
				<input name="filter[month_i]" id="month_i" type="text"
					class="easyui-datetimespinner"
					data-options="
                	label:'',
                	formatter:formatter2,
                	parser:parser2,
                	labelWidth:50"
					style="width:140px;">
				<!-- 计划状态 -->
				<spring:message code="sapproductionplan.column.plan_status_s" />:
                <input name="filter[plan_status_s]" id="plan_status_s" type="text" style="width:150px;" class="easyui-combotree" 
                	data-options="label:'',
                	valueField:'code',
                	textField:'text',
                	url:'dict/code/217'" >
				<!-- 物料编码 -->
				<spring:message code="sapproductionplan.column.material_code_s" />:
				<input name="filter[material_code_s]" id="material_code_s"
					type="text" class="easyui-textbox"
					data-options="
                	label:''"
					style="width:150px;">
				<!-- 物料描述 -->
				<spring:message code="sapproductionplan.column.material_name_s" />:
				<input name="filter[material_name_s]" id="material_name_s"
					type="text" class="easyui-textbox"
					data-options="
                label:''"
					style="width:150px;"> <a
					class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
						code="button.search" /></a>
			</form>
			<auth:button code="LH_SCJH_YJH_ADD">
				<a class="easyui-linkbutton btn-green"
					data-options="iconCls:'icon-add'" onclick="add()"><spring:message
						code="button.add" /></a>
			</auth:button>
			<auth:button code="LH_SCJH_YJH_EDIT">
				<a class="easyui-linkbutton btn-red"
					data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message
						code="button.edit" /></a>
			</auth:button>
			<auth:button code="LH_SCJH_YJH_REMOVE">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message
						code="button.delete" /></a>
			</auth:button>
			<auth:button code="LH_SCJH_YJH_SAVE">
				<a class="easyui-linkbutton btn-blue"
					data-options="iconCls:'icon-save'" onclick="save()"><spring:message
						code="button.save" /></a>
			</auth:button>
			<auth:button code="LH_SCJH_YJH_CANCEL">
				<a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message
						code="button.cancel" /></a>
			</auth:button>
			<auth:button code="LH_SCJH_YJH_EXPORT">
				<a class="easyui-linkbutton btn-deep-blue"
					data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message
						code="button.export" /></a>
			</auth:button>
			<auth:button code="LH_SCJH_YJH_IMPORT">
				<a class="easyui-linkbutton btn-deep-blue"
					data-options="iconCls:'icon-import'" onclick="$_import()"><spring:message
						code="button.import" /></a>
			</auth:button>
			
			<a href="resources/templates/月计划导入.xlsx" target="_blank">月计划导入模板下载</a>
			
		</div>
		<table id="sapproductionplan_dg" class="easyui-datagrid"
			style="width:100%"
			data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                toolbar: '#SapProductionPlan_dg_toolbar',
                url: 'curing/productionPlan/monthlyPlan/datagrid',
                striped:true,
                rownumbers:true,
                singleSelect:true,
                method: 'get',
                onBeforeLoad:onBeforeLoad,
                onBeforeEdit:onBeforeEdit
                ">
			<thead>
				<tr>
					<th field="atr_key" checkbox="true"></th>
					<!-- 月份 -->
					<th data-options="field:'month_i',sortable:true,width:60"><spring:message
							code="sapproductionplan.column.month_i" /></th>
					<!-- 月计划号 -->
					<th data-options="field:'planno_month_s',sortable:true,width:100"><spring:message
							code="sapproductionplan.column.planno_month_s" /></th>
					<!-- 物料编码 -->
					<th
						data-options="field:'material_code_s',sortable:true,width:100,editor:{type:'combobox',options:{
                    	required:true,
                    	url:'curing/productionPlan/monthlyPlan/list',
                    	valueField: 'part_number',
                    	textField: 'part_number',
                    	limitToList:true,
                    	onSelect:onMaterialSelect,
                    	onChange:onMaterialChange,
                    	onBeforeLoad:onMaterialBeforeLoad,
                    	labelPosition: 'top',
                    	panelHeight:130,
                    	editable:true
                    }}"><spring:message
							code="sapproductionplan.column.material_code_s" /></th>
					<!-- 物料描述 -->
					<th
						data-options="field:'material_name_s',width:300,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message
							code="sapproductionplan.column.material_name_s" /></th>
					<!-- 规格 -->
					<th data-options="field:'specification_s',hidden:true,width:250,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message
							code="sapproductionplan.column.specification_s" /></th>
					<!-- 层级 -->
					<th data-options="field:'layclass_s',hidden:true,width:80,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message
							code="sapproductionplan.column.layclass_s" /></th>
					<!-- 花纹 -->
					<th data-options="field:'flowershape_s',hidden:true,width:80,editor:{type:'textbox',options:{editable:false,icons:[],disabled:true}}"><spring:message
							code="sapproductionplan.column.flowershape_s" /></th>
					<%-- <!-- 订单号 -->
					<th data-options="field:'order_sap_s',width:100"><spring:message
							code="sapproductionplan.column.order_sap_s" /></th>
					 --%>
					 <!-- 计划状态 -->
					 <th data-options="field:'plan_status_s',sortable:true,formatter:codeFormatter,width:65,
					 	editor:{type:'combotree',options:{
					 		method:'get',
                            url:'dict/code/217',
                    		required:true,
                    		editable:false,
                    		icons:[],
                    		disabled:true
					 	}}" ><spring:message
							code="sapproductionplan.column.plan_status_s" /></th>
					 
					<!-- 月计划数量 -->
					<th
						data-options="field:'quantity_plan_f',sortable:true,width:80,editor:{type:'numberspinner',options:{onChange:onChange,required:true,min:1,max:999999,precision:0,icons:[]}}"><spring:message
							code="sapproductionplan.column.quantity_plan_f" /></th>
					<!-- 超产百分比 -->
					<th
						data-options="field:'overproduction_percent_s',sortable:true,formatter:function(v,r,i){return v+'%';},width:80,editor:{type:'numberspinner',options:{suffix:'%',min:1,max:99,required:true,precision:0}}"><spring:message
							code="sapproductionplan.column.overproduction_percent_s" /></th>
					<!-- 计划开始时间 -->
					<th
						data-options="field:'plan_starttime_t',formatter:dateFormatter,sortable:true,width:80,editor:{type:'datebox',options:{onChange:validDate,required:true}}"><spring:message
							code="sapproductionplan.column.plan_starttime_t" /></th>
					<!-- 计划结束时间 -->
					<th
						data-options="field:'plan_endtime_t',formatter:dateFormatter,sortable:true,width:80,editor:{type:'datebox',options:{onChange:validDate,required:true}}"><spring:message
							code="sapproductionplan.column.plan_endtime_t" /></th>
					<!-- 备注 -->
					<th data-options="field:'memo_s',width:80,editor:{type:'textbox'}"><spring:message
							code="sapproductionplan.column.memo_s" /></th>
					<!-- 创建人-->
                    <th data-options="field:'created_by_s',width:60"><spring:message
                            code="sapproductionplan.column.created_by_s" /></th>
					<!-- 创建时间 -->
					<th data-options="field:'created_time_t',width:125"><spring:message
							code="sapproductionplan.column.created_time_t" /></th>
					<!-- 更新人 -->
                    <th data-options="field:'changed_by_s',width:60"><spring:message
                            code="sapproductionplan.column.changed_by_s" /></th>
					<!-- 更新时间 -->
					<th data-options="field:'changed_time_t',width:125"><spring:message
							code="sapproductionplan.column.changed_time_t" /></th>
				</tr>
			</thead>
		</table>
	</div>
	<jsp:include page="../../../../inc/import.jsp">
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.curing.execl.SapProductionPlanImportHandler" />
		<jsp:param name="callBackFuncName" value="callback" />
	</jsp:include>
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SapProductionPlan_search_form" />
		<jsp:param name="datagridId" value="sapproductionplan_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.execl.SapProductionPlanExportHandler" />
		<jsp:param name="serviceName" value="SapProductionPlanServiceImpl" />
	</jsp:include>
	<script type="text/javascript" src="dict/217.js"></script>
	<script type="text/javascript">
	   function callback(data){
		   filter();
		   if(data.code!=OK){
			   ext.tip.error();
			   return;
		   }
		   ext.tip.suc();
		   filter();
	   }
	</script>
</body>
</html>
