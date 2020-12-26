<!-- 

    作者      :时永良
    时间      :2019-04-25 09:29:47 
    页面名称:设备报警停机履历表
    文件关联:
        EquipmentStopRecord.java
        EquipmentStopRecordController.java
        EquipmentStopRecordServiceImpl.java
        EquipmentStopRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="equipmentstoprecord.js.jsp"%>
<script type="text/javascript" src="dict/157,172,158,159,160.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="EquipmentStopRecord_dg_toolbar">
            <form id="EquipmentStopRecord_search_form" class="form" >
                <!-- 设备条码 -->
                <spring:message code="cxproductiondayplan.column.equip_code_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                                 required:false, 
                                 url:'building/basedata/productline/getProductline?process_s=252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name',
	                             icons:[{iconCls:'icon-clear',
					             handler:clearEquipCode}]" >
                <!-- 报警等级 -->
                <spring:message code="equipmentstoprecord.column.alarm_level_s" />
                :&emsp;<input name="filter[alarm_level_s]" id="alarm_level_s" type="text" class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/157',
								      method:'get'">
                <!-- 报警代码 -->
                <spring:message code="equipmentstoprecord.column.downtime_code_s" />
                :&emsp;<input name="filter[downtime_code_s]" id="downtime_code_s" type="text"class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/172',
								      method:'get'">
                <!-- 报警来源 -->
                <spring:message code="equipmentstoprecord.column.downtime_source_s" />
                :&emsp;<input name="filter[downtime_source_s]" id="downtime_source_s" type="text" class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/159',
								      method:'get'">
                 <br>
                <!-- 报警处理状态 -->
                <spring:message code="equipmentstoprecord.column.downtime_status_s" />
                :&emsp;<input name="filter[downtime_status_s]" id="downtime_status_s" type="text" class="easyui-combotree" 
                        data-options="label:'',
                                      labelWidth:'auto',
                                      panelHeight:200,
                                      editable:false,
								      required:false,
								      url:'dict/code/160',
								      method:'get'">


                <!-- 报警开始时间 -->
                <spring:message code="equipmentstoprecord.column.downtime_etime_t" />
                 :&emsp;<input name="filter[start_time]" type="text" editable="true" id="start_time" class="easyui-datetimebox" style="width:16%" data-options="label:''">
				 &nbsp;
				 <spring:message code="tip.to" /> 
				 &nbsp;
				 <input name="filter[end_time]" editable="true" id="end_time" class="easyui-datetimebox" style="width:16%"> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_SCGL_QUAN_GANG_EQUIPMENTSTOPRECORD_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="equipmentstoprecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                rowStyler:rowStylerChange,
                singleSelect: false,
                toolbar: '#EquipmentStopRecord_dg_toolbar',
                url: '',
                pageSize: 25,
                pageList: [25,50,75,100],
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据'   
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.equip_code_s" /></th>
                    <!-- 报警次数 -->
                    <th data-options="field:'alarm_count_i',align:'center',editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.alarm_count_i" /></th>
                    <!-- 报警等级 -->
                    <th data-options="field:'alarm_level_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.alarm_level_s" /></th>
                    <!-- 报警代码 -->
                    <th data-options="field:'downtime_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.downtime_code_s" /></th>
                    <!-- 报警内容 -->
                    <th data-options="field:'downtime_detail_s',editor:{type:'textbox'}"><spring:message code="equipmentrealtime.column.downtime_detail_s" /></th>
                    <!-- 报警来源 -->
                    <th data-options="field:'downtime_source_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.downtime_source_s" /></th>
                    <!-- 报警处理状态 -->
                    <th data-options="field:'downtime_status_s',align:'center',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.downtime_status_s" /></th>
                    <!-- 报警开始时间 -->
                    <th data-options="field:'downtime_stime_t',editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.downtime_stime_t" /></th>
                    <!-- 报警结束时间 -->
                    <th data-options="field:'downtime_etime_t',editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.downtime_etime_t" /></th>
                    <!-- 报警类型 -->
                    <th data-options="field:'downtime_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.downtime_type_s" /></th>
                    <!-- 放行人 -->
                    <th data-options="field:'qualityconfirmorname',editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.quality_confirmor_s" /></th>
                    <!-- 放行时间 -->
                    <th data-options="field:'quality_confirmtime_t',editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.quality_confirmtime_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changebyname',editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="equipmentstoprecord.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="EquipmentStopRecord_search_form" />
		<jsp:param name="datagridId" value="equipmentstoprecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.EquipmentStopRecordExportHandler" />
		<jsp:param name="serviceName" value="EquipmentStopRecordServiceImpl" />
     </jsp:include> 
</body>
</html>
