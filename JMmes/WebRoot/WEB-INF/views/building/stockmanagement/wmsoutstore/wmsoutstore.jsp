<!-- 

    作者      :王海霖
    时间      :2019-01-14 15:53:15 
    页面名称:胎胚出库实绩表
    文件关联:
        Wmsoutstore.java
        WmsoutstoreController.java
        WmsoutstoreServiceImpl.java
        WmsoutstoreServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="wmsoutstore.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Wmsoutstore_dg_toolbar">
            <form id="Wmsoutstore_search_form" class="form" >
                <spring:message code="wmsoutstore.column.machinno_s" /> <span>:</span>  
                <!-- 成型机号 -->
                <input type="text" class="easyui-combobox"  name="filter[machin_no_s]" id="machin_no_s" 
							data-options="  label:'',
							required:false, 
	                		width:200,
	                		url:'building/stockmanagement/wmsinstore/combox_entcode',
				   			method: 'get',
				   			panelHeight:300,
				    		valueField:'P_LINE_NAME',
				    		textField:'P_LINE_NAME'">  
                
                <!-- SAP品号 -->&nbsp; &nbsp;
                <spring:message code="wmsoutstore.column.sapcode_s" /> <span>:</span>
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
               <!-- 条码号 -->&emsp;
                <spring:message code="wmsoutstore.column.tirebarcode_s" /> <span>:</span>
                <input name="filter[tirebarcode_s]" id="tirebarcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <br>
                <spring:message code="wmsoutstore.column.outstoredata_s" /> <span>:</span>
                <!-- 操作时间 -->
				<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
					type="text" class="easyui-datetimebox" 
					data-options="">
				到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
					class="easyui-datetimebox" data-options="" >
					<br>
				
          </form> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="CX_BAN_GANG_KCGL_TPCKLL_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
                <auth:button code="CX_BAN_GANG_JCSJ_GreenTireCodePrestore_HIDE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
          
        </div>
        <table id="wmsoutstore_dg" class="easyui-datagrid" 
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Wmsoutstore_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'  
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 条码号 -->
                    <th data-options="field:'tirebarcode_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.tirebarcode_s" /></th>
                    <!-- 机台号 -->
                    <th data-options="field:'machinno_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.creation_by_mach" /></th>
                     <!-- SAP品号 -->
                    <th data-options="field:'sapcode_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.sapcode_s" /></th>
                     <!-- 计划号 -->
                    <th data-options="field:'plancode_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.plancode_s" /></th>
                     <!-- 规格 -->
                    <th data-options="field:'specification_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.specification_s" /></th>
                    <!-- 喷涂标识 -->
                    <th data-options="field:'sprayinglogo_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.sprayinglogo_s" /></th>
                    <!-- 喷涂时间 -->
                    <th data-options="field:'sprayingtime_t',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.sprayingtime_s" /></th>
                    <!-- 旋转角度 -->
                    <th data-options="field:'rotationangle_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.rotationangle_s" /></th>
                    <!-- 入库时间 -->
                    <th data-options="field:'creation_by_instoretime',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.creation_by_instoretime" /></th> 
                     <!-- 出库位置 -->
                    <th data-options="field:'outstorelocation_s',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.outstorelocation_s" /></th>
                    <!-- 出库时间 -->
                    <th data-options="field:'outstoredata_t',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.outstoredata_s" /></th>
                    <!-- 出库人名称 -->
                    <th data-options="field:'creation_by_created',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.creation_by_created" /></th>
                     <!-- 生产时间 -->
                    <th data-options="field:'creation_by_protime',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.creation_by_protime" /></th>
                    <!-- 成型工 -->
                    <th data-options="field:'creation_by_user',width:80,editor:{type:'textbox'}"><spring:message code="wmsoutstore.column.creation_by_user" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Wmsoutstore_search_form" />
		<jsp:param name="datagridId" value="wmsoutstore_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.WmsoutstoreExportHandler" />
		<jsp:param name="serviceName" value="WmsoutstoreServiceImpl" />
	</jsp:include>
</body>
</html>
