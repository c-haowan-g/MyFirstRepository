<!-- 

    作者      : 王海霖
    时间      :2019-01-12 08:51:42 
    页面名称:胎胚入库实绩表
    文件关联:
        WmsinStore.java
        WmsinStoreController.java
        WmsinStoreServiceImpl.java
        WmsinStoreServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="wmsinstore.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WmsinStore_dg_toolbar">
            <form id="WmsinStore_search_form" class="form" >
                <spring:message code="wmsinstore.column.machin_no_s" />  
                <!-- 成型机号 -->
                :&emsp;<input type="text" class="easyui-combobox" name="filter[machin_no_s]" id="machin_no_s" 
							data-options="  label:'',
							required:false, 
	                		url:'building/stockmanagement/wmsinstore/combox_entcode',
				   			method: 'get',
				   			panelHeight:300,
				    		valueField:'P_LINE_NAME',
				    		textField:'P_LINE_NAME'">  
                
                <!-- SAP品号 --> 
                &emsp;<spring:message code="wmsinstore.column.material_code_s" /> 
                :&emsp;<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 条码号 --> 
                &emsp;<spring:message code="wmsinstore.column.tire_barcode_s" />
                :&emsp;<input name="filter[tire_barcode_s]" id="tire_barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 规格 --> 
                &emsp;<spring:message code="wmsinstore.column.material_spec_s" />
                :&emsp;<input name="filter[material_spec_s]" id="material_spec_s" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
                <!-- 操作时间 -->
                <spring:message code="wmsinstore.column.storeentry_time_t" /> 
				:&emsp;<input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox"  data-options="">
				                到 <input name="filter[end_created_time]" editable="true" id="end_created_time" class="easyui-datetimebox" data-options="" >
                <br>
                </form> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="CX_BAN_GANG_KCGL_WMSINSTORE_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
                <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_HIDE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        
        </div>
        <table id="wmsinstore_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
               
                toolbar: '#WmsinStore_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 条码号 -->
                    <th data-options="field:'tire_barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.tire_barcode_s" /></th>
                     <!-- 成型机号 -->
                    <th data-options="field:'creation_by_mach',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.creation_by_mach" /></th>
                    <!-- SAP品号 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.material_code_s" /></th>
                    <!-- 规格 -->
                    <th data-options="field:'material_spec_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.material_spec_s" /></th>
                     <!-- 胎胚重量 -->
                    <th data-options="field:'weight_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.weight_s" /></th>
                     <!-- 重量是否合格 -->
                    <th data-options="field:'weight_ok_s',formatter:qualifiedFormatter,width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.weight_ok_s" /></th>
                    <!-- 外观是否合格 -->
                    <th data-options="field:'appearance_ok_s',formatter:codeFormatter,width:80,editor:{type:'textbox',options:{
                    			method:'get',
                                url:'dict/code/253',
                    			required:true}}"><spring:message code="wmsinstore.column.appearance_ok_s" /></th>
                     <!-- 入库时间 -->
                    <th data-options="field:'storeentry_time_t',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.storeentry_time_t" /></th>
                     <!-- 入库位置 -->
                    <th data-options="field:'storage_location_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.storage_location_s" /></th>
                    <!-- 入库区域-->
                    <th data-options="field:'creation_by_storageZone',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.creation_by_storageZone" /></th>
                     <!-- 入库工 -->
                    <th data-options="field:'creation_by_created',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.creation_by_created" /></th>
                     <!-- 生产时间 -->
                    <th data-options="field:'production_date_t',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.production_date_s" /></th>
                    <!-- 操作工 -->
                    <th data-options="field:'creation_by_user',width:80,editor:{type:'textbox'}"><spring:message code="wmsinstore.column.creation_by_user" /></th>
                   
                </tr>
            </thead>
        </table>
    </div>
    
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WmsinStore_search_form" />
		<jsp:param name="datagridId" value="wmsinstore_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.WmsinStoreExportHandler" />
		<jsp:param name="serviceName" value="WmsinStoreServiceImpl" />
	</jsp:include>
</body>
</html>
