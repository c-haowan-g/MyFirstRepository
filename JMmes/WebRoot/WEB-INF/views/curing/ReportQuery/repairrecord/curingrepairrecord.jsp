<!-- 

    作者      :王超
    时间      :2020-04-09 12:00:47 
    页面名称:硫化返修记录
    文件关联:
        CuringRepairRecord.java
        CuringRepairRecordController.java
        CuringRepairRecordServiceImpl.java
        CuringRepairRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingrepairrecord.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CuringRepairRecord_dg_toolbar">
            <form id="CuringRepairRecord_search_form" class="form" >
                <!-- 返修时间 -->
                <spring:message code="curingrepairrecord.column.repair_time_s" />:<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
                <!-- 轮胎条码 -->
                <spring:message code="curingrepairrecord.column.tyre_barcode_s" />:<input name="filter[tyre_barcode_s]" id="tyre_barcode_s" type="text" class="easyui-textbox" style="width:160px" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 物料编码 -->
                <spring:message code="curingrepairrecord.column.material_code_s" />:<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" style="width:160px" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <br>
                <!-- 等级 -->
                <%-- <spring:message code="curingrepairrecord.column.repair_level_s" />:<input name="filter[patch_content_s]" id="patch_content_s" type="text" class="easyui-combotree" style="width:160px" data-options="label:'',
                    required:false,
	                editable:true,
          			panelHeight:200,
          			url:'dict/code/253',
          			method:'get'
          		" >&nbsp;&nbsp;&nbsp; --%>
                <!-- 操作人员 -->
                <spring:message code="curingrepairrecord.column.operation_people_s" />:<input name="filter[worker_id_s]" id="worker_id_s" type="text" class="easyui-textbox" style="width:160px" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="repairrecord.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="curingrepairrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CuringRepairRecord_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyre_barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.tyre_barcode_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'machinecode_s',width:78,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.machinecode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.material_code_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'mterial_desc_s',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.mterial_desc_s" /></th>
                    <!-- 硫化操作工 -->
                    <th data-options="field:'curing_operator_s',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.curing_operator_s" /></th>
                    <!-- 硫化开始时间 -->
                    <th data-options="field:'curing_start_time_t',width:120,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.curing_start_time_t" /></th>
                    <!-- 病象 -->
                    <th data-options="field:'disease_items_s',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.disease_items_s" /></th>
                    <!-- 外检操作工 -->
                    <th data-options="field:'external_operator_s',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.external_operator_s" /></th>
                    <!-- 外检操作时间 -->
                    <th data-options="field:'external_time_t',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.external_time_t" /></th>
                    <!-- 返修工号 -->
                    <th data-options="field:'worker_id_s',width:80,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.worker_id_s" /></th>
                    <!-- 返修时间 -->
                    <th data-options="field:'repair_time_s',width:120,editor:{type:'textbox'}"><spring:message code="curingrepairrecord.column.repair_time_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CuringRepairRecord_search_form" />
		<jsp:param name="datagridId" value="curingrepairrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CuringRepairRecordExportHandler" />
		<jsp:param name="serviceName" value="CuringRepairRecordServiceImpl" />
	</jsp:include> 
</body>
</html>
