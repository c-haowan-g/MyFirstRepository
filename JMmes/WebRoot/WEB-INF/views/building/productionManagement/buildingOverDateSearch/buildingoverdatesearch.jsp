<!-- 

    作者      :李德晓
    时间      :2020-01-20 09:16:21 
    页面名称:成型超期查询
    文件关联:
        buildingoverdatesearch.java
        BuildingoverdatesearchController.java
        BuildingoverdatesearchServiceImpl.java
        BuildingoverdatesearchServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="buildingoverdatesearch.js.jsp"%>
<script type="text/javascript" src="dict/105,177,302,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Workerorderresult_dg_toolbar">
            <form id="Workerorderresult_search_form" class="form" >
                <!-- 物料编码 -->
                <spring:message code="workerorderresult.column.material_code_s" />:
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" style="width:170px" data-options="label:''" >
                <!-- 轮胎条码 -->
                <spring:message code="workerorderresult.column.tyre_barcode_s" />:
                <input name="filter[tyre_barcode_s]" id="tyre_barcode_s" type="text" class="easyui-textbox" style="width:170px" data-options="label:''" >
               <br>
                <!-- 开始时间 -->
                 <spring:message code="mddd.column.starttime_t" />
                :<input name="filter[start_time]" type="text" editable="true" id="start_time" class="easyui-datetimebox" style="width:170px" data-options="label:''">
				 
				 <spring:message code="mddd.column.overtime_t" />:
				 
                 <input name="filter[end_time]" editable="true" id="end_time" 
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="CX_QUAN_GANG_REPORT_11_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            
        </div>
        <table id="workerorderresult_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Workerorderresult_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
                
            <thead>
                <tr>
                     <!-- 轮胎条码 -->
                    <th data-options="field:'tyre_barcode_s',editor:{type:'textbox'}"><spring:message code="workerorderresult.column.tyre_barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="workerorderresult.column.material_code_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="workerorderresult.column.material_spec_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'building_date_t',editor:{type:'textbox'}"><spring:message code="tyredelay.column.building_time_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="output.column.machinename_s" /></th>
                    <!-- 成型工人_主手 -->
                    <th data-options="field:'worker1_id_s',formatter:worker1Formatter,editor:{type:'textbox'}"><spring:message code="buildingoverdatesearch.column.worker1_id_s" /></th>
                    <!-- 成型工人_副手 -->
                    <th data-options="field:'worker2_id_s',formatter:worker2Formatter,editor:{type:'textbox'}"><spring:message code="workerorderresult.column.worker2_id_s" /></th>
                    <!-- 帮车 -->
                    <th data-options="field:'worker3_id_s',formatter:worker3Formatter,editor:{type:'textbox'}"><spring:message code="workerorderresult.column.help_car" /></th>
                    <!-- 超期时间 -->
                    <th data-options="field:'outtime',editor:{type:'textbox'}"><spring:message code="weightinfo.column.over_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div><jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Workerorderresult_search_form" />
		<jsp:param name="datagridId" value="workerorderresult_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.BuildingOverDateSearchExportHandler" />
		<jsp:param name="serviceName" value="BuildingOverDateSearchServiceImpl" />
	</jsp:include>
    
</body>
</html>
