<!-- 

    作者      :王超
    时间      :2020-03-05 09:41:14 
    页面名称:半部件入库记录
    文件关联:
        InStoreRecord.java
        InStoreRecordController.java
        InStoreRecordServiceImpl.java
        InStoreRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="instorerecord.js.jsp"%>
<script type="text/javascript" src="dict/109.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="InStoreRecord_dg_toolbar">
            <form id="InStoreRecord_search_form" class="form" >
                <!-- 物料编码 -->
                <spring:message code="instorerecord.column.materielcode_s" />:<input name="filter[materielcode_s]" id="materielcode_s" style="width:160px" type="text" class="easyui-combobox" 
                	data-options="valueField:'MATERIALCODE_S',
				            			textField:'MATERIALCODE_S',
                                        required:false, 
                                        url:'halfpart/stockManagement/inStoreRecord/searchMaterialCode',
										method: 'get',
									    editable:'true',
									    prompt:'全部',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								        }"
				>&nbsp;&nbsp;&nbsp;
                <!-- 物料名称 -->
                <spring:message code="instorerecord.column.materielname_s" />:<input name="filter[materielname_s]" id="materielname_s" style="width:160px" type="text" class="easyui-combobox" 
                	data-options="valueField:'MATERIALDESC_S',
				            			textField:'MATERIALDESC_S',
                                        required:false, 
                                        url:'halfpart/stockManagement/inStoreRecord/searchMaterialName',
										method: 'get',
									    editable:'true',
									    prompt:'全部',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								        }"
				>&nbsp;&nbsp;&nbsp;
                <!-- 物料组 -->
                <spring:message code="instorerecord.column.materialgroup_s" />:<input name="filter[materialgroup_s]" id="materialgroup_s" style="width:180px" type="text" class="easyui-combobox"
                	data-options="valueField:'DICTNAME_S',
				            			textField:'DICTNAME_S',
                                        required:false, 
                                        url:'halfpart/stockManagement/inStoreRecord/searchMaterialGroup',
										method: 'get',
									    editable:'true',
									    prompt:'全部',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								        }"
				>&nbsp;&nbsp;&nbsp;
                <!-- 入库位置 -->
                <spring:message code="instorerecord.column.in_location_s" />:<input name="filter[in_location_s]" id="in_location_s" style="width:160px" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
                <!-- 批次条码 -->
                <spring:message code="plateinfo.column.batchno_s" />:<input name="filter[barcode_s]" id="barcode_s" style="width:160px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 载具条码 -->
                <spring:message code="instorerecord.column.vehicles_code_s" />:<input name="filter[vehicles_code_s]" id="vehicles_code_s" style="width:160px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 入库时间 -->
                <spring:message code="instorerecord.column.in_time_t" />:<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:180px" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:180px" data-options="label:''">&nbsp;&nbsp;&nbsp;
            </form>
            <auth:button code="instorerecord.search"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a></auth:button>
            <auth:button code="instorerecord.excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="instorerecord.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="instorerecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#InStoreRecord_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 条码号 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="plateinfo.column.batchno_s" /></th>
                    <!-- 入库量 -->
                    <th data-options="field:'inweight_f',editor:{type:'textbox'}"><spring:message code="instorerecord.column.inweight_f" /></th>
                    <!-- 生产机台 -->
                    <th data-options="field:'machinno_s', editor:{type:'textbox'}"><spring:message code="instorerecord.column.machinno_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materielcode_s',editor:{type:'textbox'}"><spring:message code="instorerecord.column.materielcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materielname_s',editor:{type:'textbox'}"><spring:message code="instorerecord.column.materielname_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'dictname_s',editor:{type:'textbox'}"><spring:message code="instorerecord.column.materialgroup_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'vehicles_code_s',editor:{type:'textbox'}"><spring:message code="instorerecord.column.vehicles_code_s" /></th>
                    <!-- 入库位置 -->
                    <th data-options="field:'in_location_s',editor:{type:'textbox'}"><spring:message code="instorerecord.column.in_location_s" /></th>
                    <!-- 入库类型 -->
                    <th data-options="field:'storage_in_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.instore_type_s" /></th>
                    <!-- 入库人 -->
                    <th data-options="field:'username',editor:{type:'textbox'}"><spring:message code="mouldstock.column.user_id_s" /></th>
                    <!-- 入库人班组 -->
                    <th data-options="field:'storage_in_class_s', editor:{type:'textbox'}"><spring:message code="instorerecord.column.storage_in_class_s" /></th>
                    <!-- 入库人班次 -->
                    <th data-options="field:'storage_in_shift_s', editor:{type:'textbox'}"><spring:message code="instorerecord.column.storage_in_shift_s" /></th>
                    <!-- 入库时间 -->
                    <th data-options="field:'in_time_t',editor:{type:'textbox'}"><spring:message code="instorerecord.column.in_time_t" /></th>
                    <!-- 工装条码(口型板) -->
                    <th data-options="field:'plate_code_s', editor:{type:'textbox'}"><spring:message code="instorerecord.column.plate_code_s" /></th>
                    <!-- 生产时间 -->
                    <th data-options="field:'productiondate_t', editor:{type:'textbox'}"><spring:message code="instorerecord.column.productiondate_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s', editor:{type:'textbox'}"><spring:message code="instorerecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t', editor:{type:'textbox'}"><spring:message code="instorerecord.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s', editor:{type:'textbox'}"><spring:message code="instorerecord.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t', editor:{type:'textbox'}"><spring:message code="instorerecord.column.changed_time_t" /></th>                  
                </tr>
            </thead>
        </table>
    </div>
    
    <!--导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="InStoreRecord_search_form" />
		<jsp:param name="datagridId" value="instorerecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.InStoreRecordExportHandler" />
		<jsp:param name="serviceName" value="InStoreRecordServiceImpl" />
	</jsp:include>
</body>
</html>
