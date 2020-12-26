<!-- 

    作者      :王超
    时间      :2020-07-10 10:09:16 
    页面名称:成型胎胚车信息查询
    文件关联:
        TireCarReal.java
        TireCarRealController.java
        TireCarRealServiceImpl.java
        TireCarRealServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="tirecarreal.js.jsp"%>
<script type="text/javascript" src="dict/227.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="TireCarReal_dg_toolbar">
            <form id="TireCarReal_search_form" class="form" >
                <!-- 胎胚车描述 -->
                <%-- <spring:message code="tirecarreal.column.tire_shelf_description_s" />：
                <input name="filter[tire_shelf_description_s]" id="tire_shelf_description_s" type="text" class="easyui-textbox" data-options="label:''" > --%>
                <!-- 胎胚车名称 -->
                <%-- <spring:message code="tirecarreal.column.tire_shelf_name_s" />：
                <input name="filter[tire_shelf_name_s]" id="tire_shelf_name_s" type="text" class="easyui-textbox" data-options="label:''" > --%>
                <!-- 物料编码 -->
                <spring:message code="tirecarreal.column.material_code_s" />：
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料规格 -->
                <spring:message code="tirecarreal.column.material_spec_s" />：
                <input name="filter[material_spec_s]" id="material_spec_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 库位编码 -->
                <spring:message code="tirecarreal.column.placebar_s" />：
                <input name="filter[placebar_s]" id="placebar_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 胎胚车编号 -->
                <spring:message code="tirecarreal.column.tire_shelf_code_s" />：
                <input name="filter[tire_shelf_code_s]" id="tire_shelf_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 位置状态 -->
                <br>
                <spring:message code="tirecarreal.column.placestatus_s" />：
                <input name="filter[placestatus_s]" id="placestatus_s" type="text" class="easyui-combobox" 
                    data-options="valueField:'code',
	            			  textField:'text',
                              required:false, 
                              url:'dict/code/227',
                              panelHeight:150"
                >
                <!-- 存放类型 -->
                <spring:message code="tirecarreal.column.storetype_s" />：
                <input name="filter[storetype_s]" id="storetype_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a>
                </form> 
        </div>
        <table id="tirecarreal_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#TireCarReal_dg_toolbar',
                url: 'building/reportquery/tirecarreal/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 胎胚车编号 -->
                    <th data-options="field:'tire_shelf_code_s',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.tire_shelf_code_s" /></th>
                    <!-- 胎胚车描述 -->
                    <th data-options="field:'tire_shelf_description_s',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.tire_shelf_description_s" /></th>
                    <!-- 胎胚车名称 -->
                    <th data-options="field:'tire_shelf_name_s',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.tire_shelf_name_s" /></th>
                    <!-- 胎胚条码 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.barcode_s" /></th>
                    <!-- 胎胚过期时间 -->
                    <th data-options="field:'greentire_beyondtime_f',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.greentire_beyondtime_f" /></th>
                    <!-- 胎胚停放时间 -->
                    <th data-options="field:'greentire_parktime_f',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.greentire_parktime_f" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'instoretime_t',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.instoretime_t" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.material_code_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'material_spec_s',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.material_spec_s" /></th>
                    <!-- 库位编码 -->
                    <th data-options="field:'placebar_s',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.placebar_s" /></th>
                    <!-- 位置状态 -->
                    <th data-options="field:'placestatus_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="tirecarreal.column.placestatus_s" /></th>
                    <!-- 存放类型 -->
                    <th data-options="field:'storetype_s',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.storetype_s" /></th>
                    <!-- 更新人 -->
                    <th data-options="field:'changed_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message code="tirecarreal.column.changed_by_s" /></th>
                    <!-- 更新时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message code="tirecarreal.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="tirecarreal.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="TireCarReal_search_form" />
		<jsp:param name="datagridId" value="tirecarreal_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.TireCarRealExportHandler" />
		<jsp:param name="serviceName" value="TireCarRealServiceImpl" />
	</jsp:include>
</body>
</html>
