<!-- 

    作者      :时永良
    时间      :2020-12-08 13:34:03 
    页面名称:半部件校称记录表
    文件关联:
        CalibRationRecord.java
        CalibRationRecordController.java
        CalibRationRecordServiceImpl.java
        CalibRationRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<script type="text/javascript" src="dict/118,301.js"></script>
<%@ include file="calibrationrecord.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CalibRationRecord_dg_toolbar">
            <form id="CalibRationRecord_search_form" class="form" >
            <!-- 操作时间 -->
                <spring:message code="calibrationrecord.column.detectiontime_t" />
                <input name="filter[start_time]" id="start_time" editable="true" type="text" class="easyui-datetimebox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                                        到：<input name="filter[end_time]" id="end_time" editable="true" type="text" class="easyui-datetimebox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 班组 -->
                <spring:message code="calibrationrecord.column.classcode_s" />
                <input name="filter[classcode_s]" id="classcode_s" type="text" class="easyui-combobox" data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:classcodeList,
										    textField:'text',
										    valueField:'text',
										    method:'get'" >
                <!-- 班次 -->
                <spring:message code="calibrationrecord.column.classteam_s" />
                <input name="filter[classteam_s]" id="classteam_s" type="text" class="easyui-combobox"  data-options="labelWidth:'auto',
                                            panelHeight:100,
										    required:false,
										    editable:false,
										    data:classteamList,
										    textField:'text',
										    valueField:'text',
										    method:'get'" >
                <!-- 产线名称 -->
                <spring:message code="calibrationrecord.column.productionline_s" />
                <input name="filter[productionline_s]" id="productionline_s" type="text" class="easyui-combobox"  
                         data-options="label:'',
                           labelWidth:'auto',
                           panelHeight:200,
                           editable:true,
                           required:false,
                           data:productLineList,
                           valueField:'P_LINE_NAME',
                           textField:'P_LINE_NAME',
                           method:'get'" >
                <!-- 称量重量 -->
                <spring:message code="calibrationrecord.column.weight_f" />
                <input name="filter[weight_f]" id="weight_f" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 操作人 -->
                <spring:message code="calibrationrecord.column.workerid_s" />
                <input name="filter[workerid_s]" id="workerid_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="calibrationrecord_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="calibrationrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CalibRationRecord_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>'  
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 设备 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.spare1_s" /></th>
                    <!-- 班组 -->
                    <th data-options="field:'classcode_s',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.classcode_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'classteam_s',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.classteam_s" /></th>
                    <!-- 检测时间 -->
                    <th data-options="field:'detectiontime_t',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.detectiontime_t" /></th>
                    <!-- 产线名称 -->
                    <th data-options="field:'productionline_s',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.productionline_s" /></th>
                    <!-- 称量结果 -->
                    <th data-options="field:'result_s',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.result_s" /></th>
                    <!-- 标准重量 -->
                    <th data-options="field:'standardweight_f',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.standardweight_f" /></th>
                    <!-- 公差值 -->
                    <th data-options="field:'tolerance_f',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.tolerance_f" /></th>
                    <!-- 称量重量 -->
                    <th data-options="field:'weight_f',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.weight_f" /></th>
                    <!-- 操作人 -->
                    <th data-options="field:'workerid_s',editor:{type:'textbox'}"><spring:message code="calibrationrecord.column.workerid_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="CalibRationRecord_search_form" />
		<jsp:param name="datagridId" value="calibrationrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.CalibRationRecordExportHandler" />
		<jsp:param name="serviceName" value="CalibRationRecordServiceImpl" />
    </jsp:include> 
</body>
</html>
