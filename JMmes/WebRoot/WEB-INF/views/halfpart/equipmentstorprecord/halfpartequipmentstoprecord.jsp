<!-- 

    作者      :肖吉朔
    时间      :2020-08-20 09:13:06 
    页面名称:设备报警停机履历表
    文件关联:
        HalfpartEquipmentStoprecord.java
        HalfpartEquipmentStoprecordController.java
        HalfpartEquipmentStoprecordServiceImpl.java
        HalfpartEquipmentStoprecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="halfpartequipmentstoprecord.js.jsp"%>
<script type="text/javascript" src="dict/140,143,157,159,160.js"></script>


<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="HalfpartEquipmentStoprecord_dg_toolbar">
            <form id="HalfpartEquipmentStoprecord_search_form" class="form" >
                <!-- 机台条码  -->
                <spring:message code="halfpartequipmentstoprecord.column.equip_code_s" />
                <input name="filter[equip_code_s]" id="equip_code_s" like = "true" type="text" class="easyui-combobox" 
                data-options="label:'',
                           labelWidth:'auto',
                           panelHeight:200,
                           editable:true,
                           required:false,
                           data:productLineList,
                           valueField:'p_line_name',
                           textField:'p_line_name',
                           method:'get'">
                <!-- 报警等级 基础数据157  -->
                <spring:message code="halfpartequipmentstoprecord.column.alarm_level_s" />
                :&emsp;<input name="filter[alarm_level_s]" id="alarm_level_s" type="text" class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/157',
								      method:'get'">
				<spring:message code="halfpartequipmentstoprecord.column.downtime_source_s" />
                :&emsp;<input name="filter[downtime_source_s]" id="downtime_source_s" type="text" class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/159',
								      method:'get'" >
				 <spring:message code="halfpartequipmentstoprecord.column.downtime_status_s" />
                :&emsp;<input name="filter[downtime_status_s]" id="downtime_status_s" type="text" class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/160',
								      method:'get'">
				</br>				      
	 			<spring:message code="halfpartequipmentstoprecord.column.downtime_type_s" />
                :&emsp;<input name="filter[downtime_type_s]" id="downtime_type_s" type="text" class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/140',
								      method:'get'">
								      
                 <!-- 报警开始时间 -->
                <spring:message code="halfpartequipmentstoprecord.column.downtime_stime_t" />
                 :&emsp;<input name="filter[start_time]" type="text" editable="true" id="start_time" class="easyui-datetimebox" style="width:16%" data-options="label:''">
				 &nbsp;
				 <spring:message code="tip.to" /> 
				 &nbsp;
				 <input name="filter[end_time]" editable="true" id="end_time" class="easyui-datetimebox" style="width:16%"> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="BBJ_BAN_GANG_BBJBB_BJLLCX_DC"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="halfpartequipmentstoprecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#HalfpartEquipmentStoprecord_dg_toolbar',
                url: 'halfpart/equipmentStoprecord/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th> 
                    <!-- 机台条码  -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}" id="equip_code_sdd"><spring:message code="halfpartequipmentstoprecord.column.equip_code_s" /></th>
                    <!-- 报警类型 基础数据140  -->
                    <th data-options="field:'downtime_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.downtime_type_s" /></th>
                    <!-- 报警等级 基础数据157  -->
                    <th data-options="field:'alarm_level_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.alarm_level_s" /></th>
                    <!-- 报警代码 基础数据143  -->
                    <th data-options="field:'downtime_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.downtime_code_s" /></th>
                    <!-- 报警来源 基础数据159  -->
                    <th data-options="field:'downtime_source_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.downtime_source_s" /></th>
                    <!-- 报警内容  -->
                    <th data-options="field:'downtime_detail_s',editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.downtime_detail_s" /></th>
                    <!-- 报警开始时间 -->
                    <th data-options="field:'downtime_stime_t',editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.downtime_stime_t" /></th>
                    <!-- 报警结束时间 -->
                    <th data-options="field:'downtime_etime_t',editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.downtime_etime_t" /></th>
                    <!-- 报警次数  -->
                    <th data-options="field:'alarm_count_i',editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.alarm_count_i" /></th>
                    <!-- 报警值  -->
                    <th data-options="field:'alarm_value_s',editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.alarm_value_s" /></th>
                   <!-- 报警处理状态 基础数据160  -->
                    <th data-options="field:'downtime_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.downtime_status_s" /></th>
                    <!-- 放行人  -->
                    <th data-options="field:'username',editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.quality_confirmor_s" /></th>
                    <!-- 放行时间  -->
                    <th data-options="field:'quality_confirmtime_t',editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.quality_confirmtime_t" /></th>
                    <!-- 是否下发停机 -->
                    <th data-options="field:'stoporder_s',formatter:showControlStatus,editor:{type:'textbox'}"><spring:message code="halfpartequipmentstoprecord.column.stoporder_s" /></th>
                 </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="HalfpartEquipmentStoprecord_search_form" />
		<jsp:param name="datagridId" value="halfpartequipmentstoprecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.HalfpartEquipmentStoprecordExportHandler" />
		<jsp:param name="serviceName" value="HalfpartEquipmentStoprecordServiceImpl" />
	 </jsp:include>
</body>
</html>
