<!-- 

    作者      :刘朋
    时间      :2019-02-26 11:45:20 
    页面名称:成型产量数据sap上报数据-------固化页面
    文件关联:
        WorkOrderResult.java
        WorkOrderResultController.java
        WorkOrderResultServiceImpl.java
        WorkOrderResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="moldingsap.js.jsp"%>
<script type="text/javascript" src="dict/301,302,193.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MoldingSap_dg_toolbar">
            <form id="MoldingSap_search_form" class="form" >
                <spring:message code="dailyreportoffinishedproductqualityinspection.column.buildingtime_t" />
                :&nbsp;<input name="filter[start_time]" type="text"  id="start_time" class="easyui-datetimebox"  style="width:150px;" data-options="label:''">
                &emsp;<spring:message code="tip.to" />&emsp;
                <input name="filter[end_time]"    id="end_time" class="easyui-datetimebox"  style="width:150px;">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="CX_BAN_GANG_BBGL_SAP_SOLIDCHOOSE"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-shenhe'" onclick="Solidification()"><spring:message code="button.curing" /></a></auth:button>
            </form> 
        </div>
        <table id="MoldingSap_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MoldingSap_dg_toolbar',
                pageSize: 100,
                pageList: [100,200,300,400],
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                 	<th data-options="field:'atr_key',checkbox:true">ID</th>
                 	<!-- 班次-->
                    <th data-options="field:'building_shift_s',align:'center',width:150,formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="moldingproductsap.column.building_shift_s" /></th>
                    <!-- 生产版本-->
                    <th data-options="field:'production_ver_s',align:'center',width:150,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.productionver_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',align:'center',width:150,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 规格描述 -->
                    <th data-options="field:'material_name_s',align:'center',width:150,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                    <!-- 合计数量-->
                    <th data-options="field:'total',align:'center',width:150,editor:{type:'textbox'}"><spring:message code="dynabalancecheresultprint.column.total" /></th>
                    
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MoldingSap_search_form" />
		<jsp:param name="datagridId" value="MoldingSap_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.lh.ExcelHandler.WorkOrderResultExportHandler" />
		<jsp:param name="serviceName" value="WorkOrderResultServiceImpl" />
	</jsp:include>
</body>
</html>
