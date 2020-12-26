<!-- 

    作者      :刘朋
    时间      :2018-11-27 16:07:15 
    页面名称:硫化报警信息表
    文件关联:
        Alertsrecord.java
        AlertsrecordController.java
        AlertsrecordServiceImpl.java
        AlertsrecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="alertsrecord.js.jsp"%>
<script type="text/javascript" src="dict/201,234,235.js"></script>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="Alertsrecord_dg_toolbar">
			<form id="Alertsrecord_search_form" class="form">
				<table>
					<tr>
						<td>
							<!-- 机台条码 --> <spring:message code="alertsrecord.column.equip_code_s" />:
						</td>
						<td><input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-textbox" data-options="label:''"></td>
						<td>
							<!-- 轮胎条码 --> <spring:message code="alertsrecord.column.tyre_barcode_s" />:
						</td>
						<td><input name="filter[tyre_barcode_s]" id="tyre_barcode_s" type="text" class="easyui-textbox" data-options="label:''"></td>
						<td>
							<!-- 报警等级 --> <spring:message code="alertsrecord.column.alert_level_s" />:
						</td>
						<td>
						<input name="filter[alert_level_s]" id="alert_level_s" style="width:168px"  type="text" class="easyui-combotree" data-options="label:'',
				  			required:false,
				  			url:'dict/code/201',
				  			method:'get',
				  			label:''" ></td>
						<td>
							<!-- 报警处理状态基础数据234  1未处理 2已下发 3已放行 4已恢复 --> <spring:message code="alertsrecord.column.alert_status_s" />:
							<input name="filter[alert_status_s]" id="alert_status_s" style="width:168px"  type="text" class="easyui-combotree" data-options="label:'',
				  			required:false,
				  			url:'dict/code/234',
				  			method:'get',
				  			label:''" >
						</td>
						<td>
						
						</td>
					</tr>
					<tr>
						<td>
							<!-- 报警内容 --> <spring:message code="alertsrecord.column.alert_content_s" />:
						</td>
						<td><input name="filter[alert_content_s]" id="alert_content_s" type="text" class="easyui-textbox" data-options="label:''"></td>
						<td>
							<!-- 报警时间 --> <spring:message code="alertsrecord.column.alert_time_s" />:
						</td>
						<td><input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''"></td>
						<td align="center"><spring:message code="tip.to" /></td>
						<td><input name="filter[end_time]" id="end_time" type="text"style="width:168px"  class="easyui-datetimebox" data-options="label:''"></td>
						<td><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
							<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a>						</td>
					</tr>
				</table>
			</form>
			
		</div>
		<table id="alertsrecord_dg" class="easyui-datagrid" style="width:100%"
			data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Alertsrecord_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' ,
                emptyMsg:'暂无数据'
                ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true"></th>
					<!-- 机台条码 -->
					<th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.equip_code_s" /></th>
					<!-- 轮胎条码 -->
					<th data-options="field:'tyre_barcode_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.tyre_barcode_s" /></th>
					<!-- 交换前条码 -->
<!-- 					<th data-options="field:'change_barcode_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.change_barcode_s" /></th> -->
					<!-- 报警时间 -->
					<th data-options="field:'alert_time_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alert_time_s" /></th>
					<!-- 报警代码 -->
					<th data-options="field:'alert_code_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alert_code_s" /></th>
					<!-- 报警来源 -->
					<th data-options="field:'alarm_from_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alarm_from_s" /></th>
					<!-- 报警内容 -->
					<th data-options="field:'alert_content_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alert_content_s" /></th>
					<!-- 步序号 -->
					<th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare1_s" /></th>
					<!-- 持续时间-->
					<th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare2_s" /></th>
					<!-- 报警次数 -->
					<th data-options="field:'alarm_number_i',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.alarm_number_i" /></th>
					<!-- 报警值 -->
					<th data-options="field:'alert_value_s',editor:{type:'textbox'},formatter:ViewFormatter"><spring:message code="alertsrecord.column.alert_value_s" /></th>
					<!-- 报警等级 -->
					<th data-options="field:'alert_level_s',formatter:codeFormatter,editor:{type:'combotree',options:{
	        			method:'get',
	                    url:'dict/code/201',
	        			required:true}}"><spring:message code="alertsrecord.column.alert_level_s" /></th>
					
					<!-- 报警处理状态基础数据234  1未处理 2已下发 3已放行 4已恢复 -->
					<th data-options="field:'alert_status_s',formatter:codeFormatter,editor:{type:'combotree',options:{
	        			method:'get',
	                    url:'dict/code/234',
	        			required:true}}"><spring:message code="alertsrecord.column.alert_status_s" /></th>
					<!-- 操作人 -->
					<th data-options="field:'operator_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.operator_s" /></th>
					<!-- 恢复时间 -->
					<th data-options="field:'recovery_time_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.recovery_time_s" /></th>
					<!-- 恢复值 -->
					<th data-options="field:'recovery_value_s',editor:{type:'textbox'},formatter:ViewFormatter"><spring:message code="alertsrecord.column.recovery_value_s" /></th>
					<!-- 确认质量 -->
					<th data-options="field:'quality_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.quality_s" /></th>
					<!-- 质量确认人 -->
					<th data-options="field:'quality_confirmor_s',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.quality_confirmor_s" /></th>
					<!-- 质量确认时间 -->
					<th data-options="field:'quality_confirmtime_t',editor:{type:'textbox'}"><spring:message code="alertsrecord.column.quality_confirmtime_t" /></th>
					

					<%-- 
					<!-- 创建时间 -->
					<th data-options="field:'created_time_t',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.created_time_t" /></th>
					<!-- 操作时间 -->
					<th data-options="field:'operatetime_t',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.operatetime_t" /></th>
					<!-- 记录标志,A可用，D删除 -->
					<th data-options="field:'record_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.record_flag_s" /></th>
					<!-- 备用字段1 -->
					<th data-options="field:'spare1_s',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare1_s" /></th>
					<!-- 备用字段2 -->
					<th data-options="field:'spare2_s',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare2_s" /></th>
					<!-- 备用字段3 -->
					<th data-options="field:'spare3_s',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare3_s" /></th>
					<!-- 备用字段4 -->
					<th data-options="field:'spare4_s',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare4_s" /></th>
					<!-- 备用字段5 -->
					<th data-options="field:'spare5_s',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.spare5_s" /></th>
					<!-- 工厂（1全钢 2半钢） -->
					<th data-options="field:'s_factory_s',width:80,editor:{type:'textbox'}"><spring:message code="alertsrecord.column.s_factory_s" /></th>
					--%>
				</tr>
			</thead>
		</table>
	</div>
	
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Alertsrecord_search_form" />
		<jsp:param name="datagridId" value="alertsrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.AlertsrecordExportHandler" />
		<jsp:param name="serviceName" value="AlertsrecordServiceImpl" />
	</jsp:include>
</body>
</html>
