<!-- 

    作者      :王超
    时间      :2020-06-04 09:14:13 
    页面名称:手持登录履历表
    文件关联:
        PdaLoginRecord.java
        PdaLoginRecordController.java
        PdaLoginRecordServiceImpl.java
        PdaLoginRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="pdaloginrecord.js.jsp"%>
<script type="text/javascript" src="dict/301,302.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="PDALogin_Record_dg_toolbar">
            <form id="PDALogin_Record_search_form" class="form" >
                <!-- 手持编号 -->
                <spring:message code="pdalogin_record.column.equip_code_s" />：
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 班次 -->
                <spring:message code="pdalogin_record.column.class_id_s" />：
                <input name="filter[class_id_s]" id="class_id_s" type="text" class="easyui-combobox" 
	                data-options="valueField:'code',
		            			  textField:'text',
	                              required:false, 
	                              url:'dict/code/302',
	                              panelHeight:100" >
                <!-- 班组 -->
                <spring:message code="pdalogin_record.column.group_id_s" />：
                <input name="filter[group_id_s]" id="group_id_s" type="text" class="easyui-combobox" 
	                data-options="valueField:'code',
		            			  textField:'text',
	                              required:false, 
	                              url:'dict/code/301',
	                              panelHeight:100" >
                <!-- 登录人 -->
                <spring:message code="pdalogin_record.column.worker_id_s" />：
                <input name="filter[worker_id_s]" id="worker_id_s" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
				<!-- 登录时间 -->
				<spring:message code="pdalogin_record.column.login_time_t" />：
				<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" data-options="label:''">&nbsp;&nbsp;&nbsp;
				<!-- 设备IP -->
                <spring:message code="pdalogin_record.column.equip_ip_s" />&nbsp;：
                <input name="filter[equip_ip_s]" id="equip_ip_s" type="text" class="easyui-textbox" data-options="label:''" >
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="pdalogin.excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>		         
            </form> 
        </div>
        <table id="pdalogin_record_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#PDALogin_Record_dg_toolbar',
                url: 'common/pdaloginrecord/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
				<tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 手持编号 -->
                    <th data-options="field:'equip_code_s',width:120,editor:{type:'textbox'}"><spring:message code="pdalogin_record.column.equip_code_s" /></th>
                    <!-- 设备IP -->
                    <th data-options="field:'equip_ip_s',width:120,editor:{type:'textbox'}"><spring:message code="pdalogin_record.column.equip_ip_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'class_id_s',formatter:codeFormatter,width:100,editor:{type:'textbox'}"><spring:message code="pdalogin_record.column.class_id_s" /></th>
                    <!-- 班组 -->
                    <th data-options="field:'group_id_s',formatter:codeFormatter,width:100,editor:{type:'textbox'}"><spring:message code="pdalogin_record.column.group_id_s" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'s_factory_s',formatter:factoryformatter,width:100,editor:{type:'textbox'}"><spring:message code="pdalogin_record.column.s_factory_s" /></th>
                    <!-- 登录人 -->
                    <th data-options="field:'username',width:100,editor:{type:'textbox'}"><spring:message code="pdalogin_record.column.worker_id_s" /></th>
                	<!-- 登录时间 -->
                    <th data-options="field:'login_time_t',width:150,editor:{type:'textbox'}"><spring:message code="pdalogin_record.column.login_time_t" /></th>
				</tr>
            </thead>
        </table>
    </div>
    
    <!--导出-->    
	<jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="PDALogin_Record_search_form" />
		<jsp:param name="datagridId" value="pdalogin_record_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.common.ExcelHandler.PdaLoginRecordExportHandler" />
		<jsp:param name="serviceName" value="PdaLoginRecordServiceImpl" />
	</jsp:include>
</body>
</html>
