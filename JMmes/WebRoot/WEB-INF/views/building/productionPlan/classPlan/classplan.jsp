<!-- 

    作者      :王海霖
    时间      :2019-03-16 12:37:27 
    页面名称:成型班次计划表查询
    文件关联:
        ClassPlan.java
        ClassPlanController.java
        ClassPlanServiceImpl.java
        ClassPlanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="classplan.js.jsp"%>
<script type="text/javascript" src="dict/301,302,169,193.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkOrder_dg_toolbar">
            <form id="WorkOrder_search_form" class="form" >
            	<!-- 执行日期 -->
				<spring:message code="classplan.column.production_date_s" />
				:&emsp;<input name="filter[production_date_s]" id="production_date_s" type="text" class="easyui-datebox" data-options="onChange:filter,buttons:[],formatter:dateFormat,parser:dateParser,label:''">
                &emsp;<!-- 生产班次 -->
                <spring:message code="classplan.column.class_id_s" />
                :&emsp;<input name="filter[class_id_s]" id="class_id_s" type="text" class="easyui-combotree" data-options="label:'',valueField:'code',
                	textField:'text',
                	url:'dict/code/193'" >
                <!-- 胎胚物料编码（SAP品号） -->
                &emsp;<spring:message code="classplan.column.material_code_s" />
                :&emsp;<input name="filter[material_code_s]" like=true id="material_code_s" type="text" class="easyui-combobox" 
                         data-options="label:'',
                                       panelHeight:200,
									   required:false,
									   editable:'true',
									   url:'Part/halbMaterialListForDay',
									   valueField: 'PART_NUMBER',
                              		   textField: 'PART_NUMBER',
									   method:'get',
									   icons:[{iconCls:'icon-clear',
					                   handler:clearMaterial}]">
	            <br>
                <!-- 工单号 -->
                <spring:message code="classplan.column.order_code_s" />
                :&emsp;&emsp;<input name="filter[order_code_s]" like=true id="order_code_s" type="text" class="easyui-combobox" 
                         data-options="label:'',
                                       panelHeight:200,
									   required:false,
									   editable:'true',
									   url:'building/productionmanagement/classplan/searchOrderCode',
									   valueField:'ORDER_CODE_S',
                              		   textField:'ORDER_CODE_S',
									   method:'get',
									   icons:[{iconCls:'icon-clear',
					                   handler:clearOrder}]">
                <!-- 日计划号 -->
                &emsp;<spring:message code="classplan.column.plan_no_s" />
                :&emsp;<input name="filter[plan_no_s]" like=true id="plan_no_s" type="text" class="easyui-combobox" 
                         data-options="label:'',
                                       panelHeight:200,
									   required:false,
									   editable:'true',
									   url:'building/productionmanagement/classplan/searchPlanCode',
									   valueField:'PLAN_NO_S',
                              		   textField:'PLAN_NO_S',
									   method:'get',
									   icons:[{iconCls:'icon-clear',
					                   handler:clearPlan}]">
                 <!-- 机台条码 -->
                &emsp;<spring:message code="classplan.column.equip_code_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                                 required:false, 
                                 url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name',
	                             icons:[{iconCls:'icon-clear',
					             handler:clearEquip}]" >
	             &nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="workorder_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WorkOrder_dg_toolbar',
                url: 'building/productionmanagement/classplan/datagrid',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 工单号 -->
                    <th data-options="field:'order_code_s',editor:{type:'textbox'}"><spring:message code="classplan.column.order_code_s" /></th>
                    <!-- 工单顺序 -->
                    <th data-options="field:'order_queue_i',editor:{type:'textbox'}"><spring:message code="classplan.column.order_queue_i" /></th>
                    <!-- 执行日期 -->
                    <th data-options="field:'production_date_s',editor:{type:'textbox'}"><spring:message code="classplan.column.production_date_s" /></th>
                    <!-- 工单状态 -->
                    <th data-options="field:'status_s',formatter:codeFormatter"><spring:message code="classplan.column.status_s" /></th>
                    <!-- 计划数量 -->
                    <th data-options="field:'quantity_order_i',editor:{type:'textbox'}"><spring:message code="classplan.column.quantity_order_i" /></th>
                    <!-- 实际数量 -->
                    <th data-options="field:'quantity_real_i',editor:{type:'textbox'}"><spring:message code="classplan.column.quantity_real_i" /></th>
                    <!-- 日计划号 -->
                    <th data-options="field:'plan_no_s',editor:{type:'textbox'}"><spring:message code="classplan.column.plan_no_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="classplan.column.equip_code_s" /></th>
                    <!-- 胎胚物料编码（SAP品号） -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="classplan.column.material_code_s" /></th>
                    <!-- 胎胚物料名称 -->
                    <th data-options="field:'material_desc_s',editor:{type:'textbox'}"><spring:message code="classplan.column.material_desc_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="classplan.column.specification_s" /></th>
                    <!-- 胎胚版本号 -->
                    <th data-options="field:'version_s',editor:{type:'textbox'}"><spring:message code="classplan.column.version_s" /></th>
                    <!-- 产品阶段 -->
                    <th data-options="field:'production_step_s',formatter:stepFormatter,editor:{type:'textbox'}"><spring:message code="classplan.column.production_step_s" /></th>
                    <!-- 工艺配方索引 -->
                    <th data-options="field:'processbom_index_s',editor:{type:'textbox'}"><spring:message code="classplan.column.processbom_index_s" /></th>
                    <!-- 生产班次 -->
                    <th data-options="field:'class_id_s',formatter:codeFormatter"><spring:message code="classplan.column.class_id_s" /></th>
                    <!-- 操作主手姓名 -->
                    <th data-options="field:'mainworker_name_s',editor:{type:'textbox'}"><spring:message code="classplan.column.mainworker_name_s" /></th>
                    <!-- 操作副手姓名 -->
                    <th data-options="field:'assistantworker_name_s',editor:{type:'textbox'}"><spring:message code="classplan.column.assistantworker_name_s" /></th>
                    <!-- 开始时间 -->
                    <th data-options="field:'start_time_t',editor:{type:'textbox'}"><spring:message code="classplan.column.start_time_t" /></th>
                    <!-- 结束时间 -->
                    <th data-options="field:'end_time_t',formatter:timeFormatter,editor:{type:'textbox'}"><spring:message code="classplan.column.end_time_t" /></th>
                    <!-- 关闭原因 -->
                    <th data-options="field:'close_reason_s',hidden:true,editor:{type:'textbox'}"><spring:message code="classplan.column.close_reason_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'createdname',editor:{type:'textbox'}"><spring:message code="classplan.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="classplan.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changebyname',editor:{type:'textbox'}"><spring:message code="classplan.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="classplan.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
