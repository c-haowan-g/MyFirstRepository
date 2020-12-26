<!-- 

    作者      :时永良
    时间      :2019-03-06 18:31:24 
    页面名称:机台信息状态表
    文件关联:
        MachineStatus.java
        MachineStatusController.java
        MachineStatusServiceImpl.java
        MachineStatusServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="machinestatus.js.jsp"%>
<script type="text/javascript" src="dict/189,101.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MachineStatus_dg_toolbar">
            <form id="MachineStatus_search_form" class="form" >
                <!-- 机台类型 -->
                <spring:message code="cxproductiondayplan.column.equip_type_s" />
                :&emsp;<input name="filter[machinetype_suda]" id="machinetype_suda" type="text" class="easyui-combobox" data-options="label:'', 
                              required:false,
                              data:enttypeList,
                              method:'get',
                              valueField:'DICTCODE_S',
			                  textField:'DICTNAME_S'" >
                
                <!-- 机台条码：需给规则 -->
                <spring:message code="machinestatus.column.machinebarcode_s" />
                :&emsp;<input name="filter[machinebarcode_s]" id="machinebarcode_s" type="text" class="easyui-combobox" data-options="label:'',
                               
                                 required:false, 
                                 url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name'" >
                <!-- 机台状态：数据字典 101 -->
                <spring:message code="machinestatus.column.machinestatus_s" />
                :&emsp;<input name="filter[machinestatus_s]" id="machinestatus_s" type="text" class="easyui-combotree" data-options="label:'', 
                             
                              required:false,
                              data:DICT_101,
                              method:'get'" >
                <!-- 当前物料编码 -->
                <spring:message code="machinestatus.column.materialcode_s" />
                :&emsp;<input name="filter[materialcode_s]" id="materialcode_s" like=true type="text" class="easyui-combobox" data-options="label:'',
                                
                                 required:false, 
                                 url:'building/productionManagement/machineStatus/comboxMaterial',
	                             method: 'get',
	                             editable:true,
	                             valueField:'MATERIALCODE_S',
	                             textField:'MATERIALCODE_S',
	                             icons:[{iconCls:'icon-clear',
					             handler:clearMaterial}]"> 
           
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="CX_SCGL_QUANGANG_MACHINESTATUS_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
          </form> 
        </div>
        <table id="machinestatus_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MachineStatus_dg_toolbar',
                url: 'building/productionManagement/machineStatus/datagrid',
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据'  
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'machinebarcode_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.machinebarcode_s" /></th>
                    <!-- 机台类型 -->
                    <th data-options="field:'machinetype_suda',align:'center',formatter:codeFormatter"><spring:message code="cxproductiondayplan.column.equip_type_s" /></th>
                    <!-- 机台状态：数据字典 101 -->
                    <th data-options="field:'machinestatus_s',align:'center',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="machinestatus.column.machinestatus_s" /></th>
                    <!-- 机头编码 -->
                    <th data-options="field:'mouldcode_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.mouldcode_s" /></th>
                    <!-- 自动/手动要料状态 -->
                    <th data-options="field:'auto_hand_s',align:'center',formatter:autohandFormatter,editor:{type:'textbox'}"><spring:message code="machinestatus.column.auto_hand_s" /></th>
                    <!-- 首条计数 -->
                    <th data-options="field:'firstnum_i',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.firstnum_i" /></th>
                    <!-- 当前物料编码 -->
                    <th data-options="field:'materialcode_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.materialcode_s" /></th>
                    <!-- 当前物料名称 -->
                    <th data-options="field:'materialname_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.materialname_s" /></th>
                    <!-- 当前物料规格 -->
                    <th data-options="field:'materialspec_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.materialspec_s" /></th>
                    <!-- 物料版本 -->
                    <th data-options="field:'productiongver_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.productiongver_s" /></th>
                    <!-- 物料过期时间 -->
                    <th data-options="field:'material_beyondtime_f'"><spring:message code="machinestatus.column.material_beyondtime_f" /></th>
                    <!-- 物料存放时间 -->
                    <th data-options="field:'material_parktime_f'"><spring:message code="machinestatus.column.material_parktime_f" /></th>
                    <!-- 工单编号 -->
                    <th data-options="field:'order_code_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.order_code_s" /></th>
                    <!-- 工单计划量 -->
                    <th data-options="field:'order_quantity_i',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.order_quantity_i" /></th>
                    <!-- 工单完成量 -->
                    <th data-options="field:'order_finishi_i',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.order_finishi_i" /></th>
                     <!-- 当前计划号 -->
                    <th data-options="field:'planno_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.planno_s" /></th>
                    <!-- 计划量 -->
                    <th data-options="field:'planquantity_i',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.planquantity_i" /></th>
                     <!-- 完成量 -->
                    <th data-options="field:'outquantity_i',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.outquantity_i" /></th>
                    <!-- 生产模式 ：0单条或 1批量 -->
                    <th data-options="field:'producttype_s',align:'center',formatter:producttypeFormatter,editor:{type:'textbox'}"><spring:message code="machinestatus.column.producttype_s" /></th>
                    <!-- 姓名1 -->
                    <th data-options="field:'worker1_name_s',width:80,editor:{type:'textbox'}"><spring:message code="machinestatus.column.worker1_name_s" /></th>
                    <!-- 姓名2 -->
                    <th data-options="field:'worker2_name_s',width:80,editor:{type:'textbox'}"><spring:message code="machinestatus.column.worker2_name_s" /></th>
                    <!-- 姓名3 -->
                    <th data-options="field:'worker3_name_s',width:80,editor:{type:'textbox'}"><spring:message code="machinestatus.column.worker3_name_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'remarks_s',align:'center',editor:{type:'textbox'}"><spring:message code="machinestatus.column.remarks_s" /></th>
                    <!-- 上一个物料编码 -->
                    <th data-options="field:'lastmaterialcode_s'"><spring:message code="machinestatus.column.lastmaterialcode_s" /></th>
                    <!-- 上一个物料名称 -->
                     <th data-options="field:'lastmaterialname_s'"><spring:message code="machinestatus.column.lastmaterialname_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changeusername',align:'center'"><spring:message code="machinestatus.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',align:'center'"><spring:message code="machinestatus.column.changed_time_t" /></th>
                 </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MachineStatus_search_form" />
		<jsp:param name="datagridId" value="machinestatus_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.MachineStatusExportHandler" />
		<jsp:param name="serviceName" value="MachineStatusServiceImpl" />
  </jsp:include> 
</body>
</html>
