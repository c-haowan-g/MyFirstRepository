<!-- 

    作者      :李德晓
    时间      :2020-10-07 16:04:13 
    页面名称:半部件延期履历表
    文件关联:
        DelayHandleRecord.java
        DelayHandleRecordController.java
        DelayHandleRecordServiceImpl.java
        DelayHandleRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="delayhandlerecord.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DelayHandleRecord_dg_toolbar">
            <form id="DelayHandleRecord_search_form" class="form" >
                <!-- 批次条码 -->
                批次条码：
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 载具条码 -->
                载具条码：
                <input name="filter[vehicles_code_s]" id="vehicles_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 开始时间 -->
                 <spring:message code="mddd.column.starttime_t" />
                :<input name="filter[start_time]" type="text" editable="true" id="start_time" class="easyui-datetimebox" style="width:170px" data-options="label:''">
				 
				 <spring:message code="mddd.column.overtime_t" />:
				 
                 <input name="filter[end_time]" editable="true" id="end_time" 
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="BBJ_SSGL_BAN_GANG_DELAYHANDLE_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="delayhandlerecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#DelayHandleRecord_dg_toolbar',
                url: 'halfpart/baseData/delayHandleRecord/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 批次条码 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="delayhandlerecord.column.barcode_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="delayhandlerecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="delayhandlerecord.column.created_time_t" /></th>
                    <!-- 延期人 -->
                    <th data-options="field:'delay_by_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="delayhandlerecord.column.delay_by_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materielcode_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.materielcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materielname_s',editor:{type:'textbox'}"><spring:message code="vehiclesdetailinfo.column.materialname_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="vehiclesdetailinfo.column.materialspecification_s" /></th>
                     <!-- 载具条码 -->
                    <th data-options="field:'vehicles_code_s',editor:{type:'textbox'}"><spring:message code="delayhandlerecord.column.vehicles_code_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'outputtime_t',editor:{type:'textbox'}"><spring:message code="vehiclesinfo.column.output_time_t" /></th>
                    <!-- 延期时间 -->
                    <th data-options="field:'delay_time_t',editor:{type:'textbox'}"><spring:message code="delayhandlerecord.column.delay_time_t" /></th>
                    <!-- 原有效期 -->
                    <th data-options="field:'valuetime',editor:{type:'textbox'}"><spring:message code="oldtyredelay.column.validtime_s" /></th>
                   
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="DelayHandleRecord_search_form" />
		<jsp:param name="datagridId" value="delayhandlerecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.DelayHandleRecordExportHandler" />
		<jsp:param name="serviceName" value="DelayHandleRecordServiceImpl" />
	</jsp:include>
</body>
</html>
