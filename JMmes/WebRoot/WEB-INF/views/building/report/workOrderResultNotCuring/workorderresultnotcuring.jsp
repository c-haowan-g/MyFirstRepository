<!-- 

    作者      :时永良
    时间      :2020年1月14日10:49:00
    页面名称:成型未硫化报表
    文件关联:
        WorkorderResult.java
        WorkorderResultController.java
        WorkorderResultServiceImpl.java
        WorkorderResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="workorderresultnotcuring.js.jsp"%>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkOrderResultNotCuring_dg_toolbar">
            <form id="WorkOrderResultNotCuring_search_form" class="form" >
				<spring:message code="workorderresult.column.building_date_t" />:<input name="filter[start_time]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				到 <input name="filter[end_time]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
				<!-- 胎胚条码 -->
                <spring:message code="workorderresult.column.tyre_barcode_s" />:<input name="filter[tyrebarcode_s]" id="tyrebarcode_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="workorderresult.column.material_code_s" />:<input name="filter[materialcode_s]" id="materialcode_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >
            </form> 
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="workorderresult.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="workorderresult.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button> 
        </div>
        <table id="workorderresultnotcuring_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WorkOrderResultNotCuring_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 胎胚条码 -->
                    <th data-options="field:'tyrebarcode_s',width:90,editor:{type:'textbox'}"><spring:message code="workorderresult.column.tyre_barcode_s" /></th>
                    <!-- 物料编码（品号） -->
                    <th data-options="field:'materialcode_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 物料名称（规格）-->
                    <th data-options="field:'material_name_s',width:410,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                    <!-- 产线编码 -->
                    <th data-options="field:'machinecode_s',width:70,editor:{type:'textbox'}"><spring:message code="workorderresult.column.equip_code_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'overtime_t',width:150,editor:{type:'textbox'}"><spring:message code="workorderresult.column.building_date_t" /></th>
                    <!-- 主手操作工（主机） -->
                    <th data-options="field:'worker1_name_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.workerMain_id_s" /></th>
                    <!-- 副手操作工1（辅机） -->
                    <th data-options="field:'worker2_name_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.workerAssistant_id1_s" /></th>
                    <!-- 副手操作工2（帮车） -->
                    <th data-options="field:'worker3_name_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.workerAssistant_id2_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
        <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkOrderResultNotCuring_search_form" />
		<jsp:param name="datagridId" value="workorderresultnotcuring_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.WorkorderResultNotCuringExportHandler" />
		<jsp:param name="serviceName" value="WorkorderResultServiceImpl" />
	</jsp:include>  
</body>
</html>
