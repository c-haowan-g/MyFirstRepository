<!-- 

    作者      :李新宇
    时间      :2020-01-20 09:33:58 
    页面名称:设备报警停机实时表
    文件关联:
        EquipmentRealTime.java
        EquipmentRealTimeController.java
        EquipmentRealTimeServiceImpl.java
        EquipmentRealTimeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="equipmentrealtime.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="EquipmentRealTime_dg_toolbar">
            <form id="EquipmentRealTime_search_form" class="form" >
            	<!-- 报警时间 -->
            	<spring:message code="alertsrecodes.column.alert_time_s"/>:
            	<input name="filter[downtime_stime_t]" id="downtime_stime_t" type="text" class="easyui-datetimebox" data-options="" >
            	<!-- 报警时间 -->
                &nbsp;<spring:message code="tip.to" />:
            	<input name="filter[downtime_etime_t]" id="downtime_etime_t" type="text" class="easyui-datetimebox" data-options="" >
            	<!-- 机台条码 -->
                &nbsp;&nbsp;<spring:message code="equipmentrealtime.column.equip_code_s"/>:
            	<input style="width: 100px" name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="" like="true">
            	<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>

                <auth:button code="EquipmentRealTime_Export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form>
        </div>
        <table id="equipmentrealtime_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#EquipmentRealTime_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<spring:message code='tip.noData'/>'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true,width:'5%'">ID</th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'},width:'15%'"><spring:message code="equipmentrealtime.column.equip_code_s" /></th>
                    <!-- 报警内容 -->
                    <th data-options="field:'downtime_detail_s',editor:{type:'textbox'},width:'40%'"><spring:message code="equipmentrealtime.column.downtime_detail_s" /></th>
                    <!-- 报警开始时间 -->
                    <th data-options="field:'downtime_stime_t',editor:{type:'textbox'},width:'15%'"><spring:message code="equipmentrealtime.column.downtime_stime_t" /></th>
                    <!-- 放行人 -->
                    <th data-options="field:'quality_confirmor_s',editor:{type:'textbox'},width:'14%'"><spring:message code="equipmentrealtime.column.quality_confirmor_s" /></th>
                    <!-- 放行时间 -->
                    <th data-options="field:'quality_confirmtime_t',editor:{type:'textbox'},width:'15%'"><spring:message code="equipmentrealtime.column.quality_confirmtime_t" /></th>
                </tr>
            </thead>
        </table>
    </div>

    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="EquipmentRealTime_search_form" />
        <jsp:param name="datagridId" value="equipmentrealtime_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.EquipmentRealTimeExportHandler" />
        <jsp:param name="serviceName" value="EquipmentRealTimeServiceImpl" />
    </jsp:include>
</body>
</html>
