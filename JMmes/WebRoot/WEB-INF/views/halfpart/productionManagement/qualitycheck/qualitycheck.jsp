<!-- 

    作者      :葛迎祥
    时间      :2020-06-29 15:52:31 
    页面名称:质检检测履历
    文件关联:
        QualityCheck.java
        QualityCheckController.java
        QualityCheckServiceImpl.java
        QualityCheckServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="qualitycheck.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="QualityCheck_dg_toolbar">
            <form id="QualityCheck_search_form" class="form" >
                <!-- 物料编码 -->
                <spring:message code="qualitycheck.column.materialcode_s" /> : 
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-textbox" >
                <!-- 物料名称 -->
                <spring:message code="qualitycheck.column.materialname_s" /> :
                <input name="filter[materialname_s]" id="materialname_s" type="text" class="easyui-textbox" >
                <!-- 批次条码 -->
                <spring:message code="qualitycheck.column.batch_code_s" /> : 
                <input name="filter[batch_code_s]" id="batch_code_s" type="text" class="easyui-textbox" ><br/>
                <!-- 机台名称  -->
                <spring:message code="qualitycheck.column.check_point_s" /> : 
                <input name="filter[batch_name_s]" id="batch_name_s" type="text" class="easyui-textbox" >
                <!-- 质量等级 0 不合格 1 合格  -->
                <spring:message code="qualitycheck.column.tyre_status_code_s" /> : 
                <input name="filter[tyre_status_code_s]" 
	                id="tyre_status_code_s" type="text" 
	                class="easyui-combobox" 
	                data-options="textField: 'text',
								 valueField: 'value',
								 data: [{
									 text: '全部',
									 value: ''
								 },{
									 text: '合格',
									 value: '1'
								 },{
									 text: '不合格',
									 value: '0'
								 }]" >
                <!-- 不合格原因  -->
                <spring:message code="qualitycheck.column.causeofnonconformity" /> : 
                <input name="filter[check_point_s]" id="check_point_s" type="text" class="easyui-combobox" 
                       data-options="valueField:'SICKELEPHANTS_DESC_S',
			            			 textField:'SICKELEPHANTS_DESC_S',
                                     required:false, 
                                     editable:true,
                                     url:'halfpart/productionManagement/qualitycheck/searchPoint',
									 method: 'get',
									 prompt:'全部',
								     limitToList:'false',
								     panelHeight:150,
								     labelWidth:'auto'" >
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="qualityinfo_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="qualitycheck_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                onLoadSuccess:onLoadSuccess,
                toolbar: '#QualityCheck_dg_toolbar',
                url: 'halfpart/productionManagement/qualitycheck/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料代码 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'},width:100"><spring:message code="qualitycheck.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',editor:{type:'textbox'},width:150"><spring:message code="qualitycheck.column.materialname_s" /></th>
                    <!-- 载具 -->
                    <th data-options="field:'rfid_code_s',editor:{type:'textbox'},width:100"><spring:message code="qualitycheck.column.rfid_code_s" /></th>
                    <!-- 批次号 -->
                    <th data-options="field:'batch_code_s',editor:{type:'textbox'},width:160"><spring:message code="qualitycheck.column.batch_code_s" /></th>
                    <!-- 检验点，机台条码  -->
                    <th data-options="field:'description',editor:{type:'textbox'},width:100"><spring:message code="qualitycheck.column.check_point_s" /></th>
                    <!-- 产出量  -->
                    <th data-options="field:'outnum_f',editor:{type:'textbox'},width:100"><spring:message code="storagearea.column.ini_num" /></th>
                    <!-- 产出时间  -->
                    <th data-options="field:'outputtime_t',editor:{type:'textbox'},width:150"><spring:message code="storagearea.column.outputtime_t" /></th>
                    <!-- 有效期  -->
                    <th data-options="field:'valuetime',editor:{type:'textbox'},width:260"><spring:message code="tyredelay.column.validtime_s" /></th>
                    <!-- 判定结果编码(质量等级) 0 不合格 1 合格  -->
                    <th data-options="field:'tyre_status_code_s',editor:{type:'textbox'},width:100,formatter:gradeFormatter"><spring:message code="qualitycheck.column.tyre_status_code_s" /></th>
                    <!-- 不合格原因  -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'},width:150"><spring:message code="qualitycheck.column.causeofnonconformity" /></th>
                    <!-- 操作人(质检人)  -->
                    <th data-options="field:'worker_id_s',editor:{type:'textbox'},width:100"><spring:message code="qualitycheck.column.worker_id_s" /></th>
                    <!-- 操作时间(质检时间)  -->
                    <th data-options="field:'oper_time_t',editor:{type:'textbox'},width:150"><spring:message code="qualitycheck.column.oper_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="QualityCheck_search_form" />
		<jsp:param name="datagridId" value="qualitycheck_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.QualityCheckExportHandler" />
		<jsp:param name="serviceName" value="QualityCheckServiceImpl" />
    </jsp:include>
</body>
</html>
