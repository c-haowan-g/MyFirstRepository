<!-- 

    作者      :王海霖
    时间      :2019-01-15 15:07:25 
    页面名称:胎胚库存明细表
    文件关联:
        GreentireDetail.java
        GreentireDetailController.java
        GreentireDetailServiceImpl.java
        GreentireDetailServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="greentiredetail.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="GreentireDetail_dg_toolbar">
            <form id="GreentireDetail_search_form" class="form" >
                <spring:message code="greentiredetail.column.machinno_s" /> <span>:</span>  
                <!-- 成型机号 -->
                <input type="text" class="easyui-combobox" name="filter[machin_no_s]" id="machin_no_s" 
							data-options="  label:'',
							required:false, 
	                		url:'building/stockmanagement/wmsinstore/combox_entcode',
				   			method: 'get',
				   			panelHeight:300,
				    		valueField:'P_LINE_NAME',
				    		textField:'P_LINE_NAME'"> 
                
                <!-- SAP品号 -->&nbsp; &nbsp;
                <spring:message code="greentiredetail.column.material_code_s" /> <span>:</span>
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="" />'" >
                <!-- 条码号 -->&nbsp; &nbsp;
                <spring:message code="greentiredetail.column.tirebarcode_s" /> <span>:</span>
                <input name="filter[tirebarcode_s]" id="tirebarcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                 <spring:message code="greentiredetail.column.tire_car_code_s" /> <span>:</span>
                <input name="filter[tire_car_code_s]" id="tire_car_code_s" type="text"like="true" class="easyui-textbox" data-options="label:''" >
                
                <br>
                <spring:message code="wmsoutstore.column.outstoredata_s" /> <span>:</span>
                <!-- 操作时间 -->
				<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
					type="text" class="easyui-datetimebox" 
					data-options="">
				到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
					class="easyui-datetimebox" data-options="" >
					
				<spring:message code="greentiredetail.column.storagelocation_s" /> <span>:</span>
                <input name="filter[storagelocation_s]" id="storagelocation_s" type="text"like="true" class="easyui-textbox" data-options="label:''" >
                
            <br>
             </form>   
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="CX_BAN_GANG_KCGL_TPKCMX_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_HIDE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
         
        </div>
        <table id="greentiredetail_dg" class="easyui-datagrid" 
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#GreentireDetail_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'  
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 条码号 -->
                    <th data-options="field:'tirebarcode_s',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.tirebarcode_s" /></th>
                    <!-- 成型机号 -->
                    <th data-options="field:'machinno_s',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.machinno_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.material_code_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.specification_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.material_name_s" /></th>
                    <!-- 状态-->
                    <th data-options="field:'appearanceok_s',sortable:true,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			panelHeight:200,
                    			method:'get',
                                url:'dict/code/253',
                    			required:true}}"><spring:message code="wmsinstore.column.appearance_ok_s" /></th>
					<!-- 条码车 -->
                    <th data-options="field:'tire_car_code_s',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.tire_car_code_s" /></th>
                    <!-- 库存位置 -->
                    <th data-options="field:'storagelocation_s',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.storagelocation_s" /></th>
                    <!-- 生产时间 -->
                    <th data-options="field:'productiondate_t',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.productiondate_s" /></th>
                    <!-- 入库时间 -->
                    <th data-options="field:'storeentrytime_t',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.storeentrytime_t" /></th>
                    <!-- 出库时间 -->
                    <th data-options="field:'creation_by_time',editor:{type:'textbox'}"><spring:message code="greentiredetail.column.creation_by_time" /></th>
                	 <!-- 过期时间 -->
                    <th data-options="field:'greentire_beyondtime_f',formatter:dateTimeFormatter,editor:{type:'textbox'}"><spring:message code="greentiredetail.column.greentire_beyondtime_f" /></th>
                	
                	
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="GreentireDetail_search_form" />
		<jsp:param name="datagridId" value="greentiredetail_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.GreentireDetailExportHandler" />
		<jsp:param name="serviceName" value="GreentireDetailServiceImpl" />
	</jsp:include>
</body>
</html>
