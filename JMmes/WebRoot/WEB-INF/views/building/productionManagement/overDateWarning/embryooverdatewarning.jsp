<!-- 

    作者      :李德晓
    时间      :2020-07-06 13:52:23 
    页面名称:胎胚超期预警
    文件关联:
        EmbryoOverDateWarning.java
        EmbryoOverDateWarningController.java
        EmbryoOverDateWarningServiceImpl.java
        EmbryoOverDateWarningServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="embryooverdatewarning.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="EmbryoOverDateWarning_dg_toolbar">
            <form id="EmbryoOverDateWarning_search_form" class="form" >
                <!-- 查询时间 -->
                <spring:message code="routelog.column.search_time" />:
                <input name="filter[search_time]" id="search_time" type="datetime" class="easyui-datetimebox" 
                data-options="label:''" >
                <!-- 机台条码 -->
                <spring:message code="embryooverdatewarning.column.equip_code_s" />:
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox"
                 data-options="label:'',
                         required:false, 
                                 url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name'"
                 >
                <!-- 物料编码 -->
                <spring:message code="embryooverdatewarning.column.material_code_s" />:
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 距超期时间 -->
                <spring:message code="toweightinfo.column.over_time_t" />:
                <input name="filter[to_out_time]" id="to_out_time" type="text" class="easyui-textbox" data-options="required:true" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="embryooverdatewarning_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="embryooverdatewarning_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#EmbryoOverDateWarning_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyre_barcode_s',editor:{type:'textbox'}"><spring:message code="embryooverdatewarning.column.tyre_barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="embryooverdatewarning.column.material_code_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'material_spec_s',editor:{type:'textbox'}"><spring:message code="embryooverdatewarning.column.material_spec_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="embryooverdatewarning.column.equip_code_s" /></th>
                    <!-- 成型生产时间 -->
                    <th data-options="field:'building_date_t',editor:{type:'textbox'}"><spring:message code="embryooverdatewarning.column.building_date_t" /></th>
                    <!-- 超期时间 -->
                    <th data-options="field:'outtime',editor:{type:'textbox'}"><spring:message code="weightinfo.column.over_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="EmbryoOverDateWarning_search_form" />
		<jsp:param name="datagridId" value="embryooverdatewarning_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.EmbryoOverDateWarningExportHandler" />
		<jsp:param name="serviceName" value="EmbryoOverDateWarningServiceImpl" />
  </jsp:include>
</body>

</html>
