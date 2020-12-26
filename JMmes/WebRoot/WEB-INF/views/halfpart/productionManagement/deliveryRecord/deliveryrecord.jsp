<!-- 

    作者      :葛迎祥
    时间      :2020-03-09 08:20:56 
    页面名称:半部件配送履历
    文件关联:
        DeliveryRecord.java
        DeliveryRecordController.java
        DeliveryRecordServiceImpl.java
        DeliveryRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="deliveryrecord.js.jsp"%>
<script type="text/javascript" src="dict/118.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DeliveryRecord_dg_toolbar">
            <form id="DeliveryRecord_search_form" class="form" >
                <!-- 机台条码 -->
                <spring:message code="deliveryrecord.column.machinecode_s" />
                :&emsp;<input name="filter[machinecode_s]" id="machinecode_s" type="text" like="true" class="easyui-combobox"
                              data-options="label:'',
			                				panelHeight:200,
							            	required:false,
											editable:'true',
											limitToList:'false',
							            	data:productLineList,
							            	textField:'DESCRIPTION',
							            	valueField:'P_LINE_NAME',
							            	method:'get'" >
                <!-- 批次条码 -->
                 &emsp;<spring:message code="deliveryrecord.column.batchcode_s" />
                :&emsp;<input name="filter[batchcode_s]" id="batchcode_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
                <!-- 载具条码 -->
                 &emsp;<spring:message code="deliveryrecord.column.vehiclecode_s" />
                :&emsp;<input name="filter[vehiclecode_s]" id="vehiclecode_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
                <!-- 班次 -->
                 &emsp;<spring:message code="deliveryrecord.column.class_s" />
                :&emsp;<input name="filter[class_s]" id="class_s" type="text" class="easyui-combotree" like="true" data-options="label:'',
			          			required:false,
			          			panelHeight:150,
			          			url:'dict/code/118',
			          			method:'get'" >
			    <br>
                <!-- 拉料库位 -->
                <spring:message code="deliveryrecord.column.fromlocation_s" />
                :&emsp;<input name="filter[fromlocation_s]" id="fromlocation_s" type="text" like="true" class="easyui-textbox" data-options="label:''" >
                <!-- 配送开始时间 -->
				 &emsp;<spring:message code="deliveryrecord.column.start_time" />
				:&emsp;<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''">
				<!-- 配送结束时间 -->
				 &emsp;<spring:message code="deliveryrecord.column.end_time" />
				:&emsp;<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''">
            	 &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="deliveryrecord.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
                </form> 
            <auth:button code="deliveryrecord.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="deliveryrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
			                fit:true,
			                fitColumns:true,
			                pagination:true,
			                rownumbers: true,
			                singleSelect: false,
			                toolbar: '#DeliveryRecord_dg_toolbar',
			                url: 'halfpart/deliveryRecord/datagrid',
			                striped:true,
			                method: 'get', 
			                emptyMsg: '<span><spring:message code='tip.noData'/></span>'">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',width:100,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',width:120,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.materialname_s" /></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'machinecode_s',width:100,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.machinecode_s" /></th>
                    <!-- 批次条码 -->
                    <th data-options="field:'batchcode_s',width:100,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.batchcode_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'vehiclecode_s',width:100,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.vehiclecode_s" /></th>
                    <!-- 拉料库位 -->
                    <th data-options="field:'fromlocation_s',width:100,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.fromlocation_s" /></th>
                    <!-- 重量 -->
                    <th data-options="field:'weight_s',width:100,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.weight_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'class_s',width:100,sortable:true,editor:{type:'textbox',
                                      options:{
                                               method:'get',
                                               data:DICT_118}}"><spring:message code="deliveryrecord.column.class_s" /></th>
                    <!-- 配送人工号 -->
                    <th data-options="field:'deliveryer_s',width:100,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.deliveryer_s" /></th>
                    <!-- 配送时间 -->
                    <th data-options="field:'deliverytime_t',width:100,sortable:true,editor:{type:'textbox'}"><spring:message code="deliveryrecord.column.deliverytime_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="DeliveryRecord_search_form" />
		<jsp:param name="datagridId" value="deliveryrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.DeliveryRecordExportHandler" />
		<jsp:param name="serviceName" value="DeliveryRecordServiceImpl" />
	</jsp:include> 
</body>
</html>
