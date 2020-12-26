<!-- 

    作者      :王超
    时间      :2020-03-05 09:19:29 
    页面名称:半部件出库记录
    文件关联:
        OutStoreRecord.java
        OutStoreRecordController.java
        OutStoreRecordServiceImpl.java
        OutStoreRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="outstorerecord.js.jsp"%>
<script type="text/javascript" src="dict/110.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="OutStoreRecord_dg_toolbar">
            <form id="OutStoreRecord_search_form" class="form" >
                <!-- 物料编码 -->
                <spring:message code="outstorerecord.column.materielcode_s" />:<input name="filter[materielcode_s]" id="materielcode_s" style="width:160px" type="text" class="easyui-combobox" 
                	data-options="valueField:'MATERIALCODE_S',
				            			textField:'MATERIALCODE_S',
                                        required:false, 
                                        url:'halfpart/stockManagement/outStoreRecord/searchMaterialCode',
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
                <spring:message code="outstorerecord.column.materielname_s" />:<input name="filter[materielname_s]" id="materielname_s" style="width:160px" type="text" class="easyui-combobox" 
                	data-options="valueField:'MATERIALDESC_S',
				            			textField:'MATERIALDESC_S',
                                        required:false, 
                                        url:'halfpart/stockManagement/outStoreRecord/searchMaterialName',
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
                <spring:message code="outstorerecord.column.materialgroup_s" />:<input name="filter[materialgroup_s]" id="materialgroup_s" style="width:180px" type="text" class="easyui-combobox"
                	data-options="valueField:'DICTNAME_S',
				            			textField:'DICTNAME_S',
                                        required:false, 
                                        url:'halfpart/stockManagement/outStoreRecord/searchMaterialGroup',
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
                <!-- 出库位置 -->
                <spring:message code="outstorerecord.column.out_place_ss" />:<input name="filter[out_place_s]" id="out_location_s" style="width:160px" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
                <!-- 批次条码 -->
                <spring:message code="plateinfo.column.batchno_s" />:<input name="filter[barcode_s]" id="barcode_s" style="width:160px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 载具条码 -->
                <spring:message code="instorerecord.column.vehicles_code_s" />:<input name="filter[vehicles_code_s]" id="vehicles_code_s" style="width:160px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 出库时间 -->
                <spring:message code="outstorerecord.column.out_time_t" />:<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:180px" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:180px" data-options="label:''">&nbsp;&nbsp;&nbsp;
            </form> 
            <auth:button code="outstorerecord.search"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a></auth:button>
            <auth:button code="outstorerecord.excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="outstorerecord.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="outstorerecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#OutStoreRecord_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 条码号 -->
                    <th data-options="field:'barcode_s',width:100,editor:{type:'textbox'}"><spring:message code="plateinfo.column.batchno_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materielcode_s',width:100,editor:{type:'textbox'}"><spring:message code="outstorerecord.column.materielcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materielname_s',width:100,editor:{type:'textbox'}"><spring:message code="outstorerecord.column.materielname_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'dictname_s',width:100,editor:{type:'textbox'}"><spring:message code="outstorerecord.column.materialgroup_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'vehicles_code_s',width:100,editor:{type:'textbox'}"><spring:message code="instorerecord.column.vehicles_code_s" /></th>
                    <!-- 出库量 -->
                    <th data-options="field:'out_weight_s',width:100,editor:{type:'textbox'}"><spring:message code="instorerecord.column.outweight_f" /></th>
                    <!-- 出库位置 -->
                    <th data-options="field:'out_place_s',width:100,editor:{type:'textbox'}"><spring:message code="outstorerecord.column.out_place_ss" /></th>
                    <!-- 出库类型 -->
                    <th data-options="field:'storage_out_type_s',formatter:codeFormatter,width:100,editor:{type:'textbox'}"><spring:message code="outstorerecord.column.storage_out_type_ss" /></th>
                    <!-- 出库人 -->
                    <th data-options="field:'username',width:100,editor:{type:'textbox'}"><spring:message code="outstorerecord.column.storage_out_worker_s" /></th>
                    <!-- 出库时间 -->
                    <th data-options="field:'out_time_t',width:100,editor:{type:'textbox'}"><spring:message code="outstorerecord.column.out_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <!--导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="OutStoreRecord_search_form" />
		<jsp:param name="datagridId" value="outstorerecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.OutStoreRecordExportHandler" />
		<jsp:param name="serviceName" value="OutStoreRecordServiceImpl" />
	</jsp:include>
</body>
</html>
