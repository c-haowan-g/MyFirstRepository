<!-- 

    作者      :司乔靖
    时间      :2019-02-16 08:53:13 
    页面名称:投料扫描及校验表
    文件关联:
        FeedingCheck_Record.java
        FeedingCheck_RecordController.java
        FeedingCheck_RecordServiceImpl.java
        FeedingCheck_RecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="feedingcheck_record.js.jsp"%>
<script type="text/javascript" src="dict/174,173.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="FeedingCheck_Record_dg_toolbar">
            <form id="FeedingCheck_Record_search_form" class="form" >
            	<table cellspacing="3">
            		<tr>
            			<td>
			                <!-- 物料编码(SAP品号) -->
			                <spring:message code="feedingcheck_record.column.material_code_s" />: 
            			</td>
            			<td>
			                <input name="filter[material_code_s]" id="material_code_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
            			</td>
            			<td>
             			   <!-- 投料口编码 -->
			                <spring:message code="feedingcheck_record.column.feeding_code_s" />: 
            			</td>
            			<td>
			                <input name="filter[feeding_code_s]" id="feeding_code_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
            			</td>
            			<td>
			                <!-- 批次/条码 -->
			                <spring:message code="feedingcheck_record.column.batchno_s" />: 
            			</td>
            			<td>
			                <input name="filter[batchno_s]" id="batchno_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
            			</td>
            			<td>
			                <!-- 机台条码 -->
			                <spring:message code="feedingcheck_record.column.equip_code_s" />: 
            			</td>
            			<td>
			                <input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                                  width:'90px',
                                 required:false, 
                                 url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name'" >
            			</td>
            		</tr>
            		<tr>
            			<td>
			                <!-- 工装RFID条码 -->
			                <spring:message code="feedingcheck_record.column.rfid_code_s" />: 
            			</td>
            			<td>
                			<input name="filter[rfid_code_s]" id="rfid_code_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
            			</td>
            			<td>
			                <!-- 开始投料时间 -->
							<spring:message code="feedingcheck_record.column.start_time" />: 
            			</td>
            			<td>
							<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''">
            			</td>
            			<td>
							<!-- 结束投料时间 -->
							<spring:message code="feedingcheck_record.column.end_time" /> 
            			</td>
            			<td>
							<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''">
            			</td>
            			<td>
		             	   <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
		                </td>
            		</tr>
            	</table>
            </form> 
       		<auth:button code="feedingcheck_record.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="feedingcheck_record.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a></auth:button>
           
        </div>
        <table id="feedingcheck_record_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#FeedingCheck_Record_dg_toolbar',
                striped:true,
                method: 'get' ,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.material_name_s" /></th>
                    <!-- 物料编码(SAP品号) -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.material_code_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.equip_code_s" /></th>
                    <!-- 物料类型 -->
                    <th data-options="field:'material_type_s',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.material_type_s" /></th>
                    <!-- 批次条码 -->
                    <th data-options="field:'batchno_s',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.batchno_s" /></th>
                    <!-- 投料状态 -->
                    <th data-options="field:'status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.status_s" /></th>
                    <!-- 工装RFID条码 -->
                    <th data-options="field:'rfid_code_s',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.rfid_code_s" /></th>
                    <!-- 投料时间 -->
                    <th data-options="field:'in_time_t',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.in_time_t" /></th>
                    <!-- 移出时间 -->
                    <th data-options="field:'out_time_t',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.out_time_t" /></th>
                    <!-- 操作工名称 -->
                    <th data-options="field:'worker_id_s',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.worker_id_s" /></th>
                    <!-- 防错结果 -->
                    <th data-options="field:'feeding_result_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.feeding_result_s" /></th>
                    <!-- 错误原因 -->
                    <th data-options="field:'error_s',editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.error_s" /></th>
                    <!-- 扫描类型 -->
                    <th data-options="field:'scan_type_s',formatter:scanTypeFormat,editor:{type:'textbox'}"><spring:message code="feedingcheck_record.column.scan_type_s" /></th>
                </tr>
            </thead>  
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="FeedingCheck_Record_search_form" />
		<jsp:param name="datagridId" value="feedingcheck_record_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.FeedingCheck_RecordExportHandler" />
		<jsp:param name="serviceName" value="FeedingCheck_RecordServiceImpl" />
	</jsp:include> 
</body>
</html>
