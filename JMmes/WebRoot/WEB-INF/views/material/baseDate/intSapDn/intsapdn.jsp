<!-- 

    作者      :李昂
    时间      :2020-08-05 08:23:47 
    页面名称:发布内向交货单到 MES 系统（SAP->MES）行项目信息
    文件关联:
        IntSapDn.java
        IntSapDnController.java
        IntSapDnServiceImpl.java
        IntSapDnServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="intsapdn.js.jsp"%>

<body class="easyui-layout" fit="true">
    <div data-options="region:'center',split:true,border:false" >
        <div id="IntSapDn_dg_toolbar">
            <form id="IntSapDn_search_form" class="form" >
                <!-- 单据日期 -->
                
              <%--  	<spring:message code="intsapdn.column.deliverydate_s" />
                 :&emsp;<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
				type="text" class="easyui-datetimebox" style="width:165px"data-options="label:''">
				
				&emsp;到&emsp; <input name="filter[end_created_time]" editable="true" id="end_created_time"
				class="easyui-datetimebox" style="width:165px"> --%>
				
				
				<spring:message code="intsapdn.column.deliverydate_s" />
				:&emsp;<input name="filter[begin_deliverydate_time]" id="begin_deliverydate_time" type="text" class="easyui-datebox" data-options="onChange:filter,buttons:[],formatter:dateFormat,parser:dateParserStart,width:100,label:''">
				 到
				:&emsp;<input name="filter[end_deliverydate_time]" id="end_deliverydate_time" type="text" class="easyui-datebox" data-options="onChange:filter,buttons:[],formatter:dateFormat,parser:dateParserEnd,width:100,label:''">
				
				<script type="text/javascript">
                $("#begin_deliverydate_time").val(new Calendar().format("yyyyMMdd"));
				$("#end_deliverydate_time").val(new Calendar().format("yyyyMMdd"));
                </script>
				
                <!-- ERP 内向交货单行号 -->
                &emsp;<spring:message code="intsapdn.column.dnitem_s" />
                :&emsp;<input name="filter[dnitem_s]" id="dnitem_s" type="text" class="easyui-textbox" data-options="label:''" >
               	
                <!-- 物料编码 -->
                &emsp;<spring:message code="intsapdn.column.matid_s" />
                :&emsp;<input name="filter[matid_s]" id="matid_s" type="text" class="easyui-textbox" data-options="label:''" >
                </br>
                <!-- ERP 内向交货单号 -->
                <spring:message code="intsapdn.column.dnno_s" />
                :&emsp;<input name="filter[dnno_s]" id="dnno_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                <!-- 车牌号 -->
                <spring:message code="intsapdn.column.dummy3_s" />
                :&emsp;<input name="filter[dummy3_s]" id="dummy3_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="RAW_Basic Data_LLBM03_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="intsapdn_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#IntSapDn_dg_toolbar',
                 emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: 'material/intsapdn/datagrid',
                striped:true,
                onBeforeLoad:onDgBeforeLoad,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    
                    
                    <!-- 出货单单号 -->
                    <th data-options="field:'salordid_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.salordid_s" /></th>
                    <!-- 出货单行号 -->
                    <th data-options="field:'salorditem_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.salorditem_s" /></th>
                    
                    
                    
                    <!-- ERP内向交货单号 -->
                    <th data-options="field:'dnno_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.dnno_s" /></th>
                    <!-- ERP 内向交货单行号 -->
                    <th data-options="field:'dnitem_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.dnitem_s" /></th>
                    <!-- 单据日期 -->
                    <th data-options="field:'deliverydate_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.deliverydate_s" /></th>
                     <!-- 供应商编号 -->
                    <th data-options="field:'suppliercode_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.suppliercode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'matid_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.matid_s" /></th>
                    <!-- 交货数量 -->
                    <th data-options="field:'deliveryqty_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.deliveryqty_s" /></th>
                    <!-- ERP 采购订单号 -->
                    <th data-options="field:'referenceno_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.referenceno_s" /></th>
                     <!-- 供货批号 -->
                    <th data-options="field:'lotno_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.lotno_s" /></th>
                    <!-- 预留字段 3 -->
                    <th data-options="field:'dummy3_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.dummy3_s" /></th>
                    <!-- 预留字段 1 -->
                    <th data-options="field:'dummy1_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.dummy1_s" /></th>
                    <!-- 预留字段 2 -->
                    <th data-options="field:'dummy2_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.dummy2_s" /></th>
                    
                    <!-- 预留字段 4 -->
                    <th data-options="field:'dummy4_s',editor:{type:'textbox'}"><spring:message code="intsapdn.column.dummy4_s" /></th>
                   
                    
                    
                    
                   
                </tr>
            </thead>
        </table>
    </div>
     <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="IntSapDn_search_form" />
		<jsp:param name="datagridId" value="intsapdn_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.IntSapDnExportHandler" />
		<jsp:param name="serviceName" value="IntSapDnServiceImpl" />
	</jsp:include>
</body>
</html>
