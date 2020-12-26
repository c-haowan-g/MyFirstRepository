<!-- 

    作者      :王海霖/李德晓增加查询条件创建时间，修改查询条件延期时间
    时间      :2020-02-26 15:36:01 
    页面名称:胎胚延期表
    文件关联:
        TyreDelay.java
        TyreDelayController.java
        TyreDelayServiceImpl.java
        TyreDelayServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="tyredelay.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="TyreDelay_dg_toolbar">
            <form id="TyreDelay_search_form" class="form" >
            <spring:message code="delayhandlerecord.column.created_time_t" />:
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
									type="text" class="easyui-datetimebox" style="width:165px"
									data-options="label:''">
								到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
									class="easyui-datetimebox" style="width:165px">
            <!-- 轮胎条码 -->
            <spring:message code="tyredelay.column.tyrebarcode_s" />:
            <input name="filter[tyrebarcode_s]" id="tyrebarcode_s" type="text" class="easyui-textbox" data-options="label:''" ><br>
            
            <spring:message code="delayhandlerecord.column.delay_time_t" />:
                <input name="filter[begin_delay_time]" editable="false" id="begin_delay_time"
									type="text" class="easyui-datetimebox" style="width:165px"
									data-options="label:''">
								到 <input name="filter[end_delay_time]" editable="false" id="end_delay_time"
									class="easyui-datetimebox" style="width:165px">
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="CX_QUAN_GANG_REPORT_TYREDELAY_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            
        </div>
        <table id="tyredelay_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#TyreDelay_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyrebarcode_s',editor:{type:'textbox'}"><spring:message code="tyredelay.column.tyrebarcode_s" /></th>
                     <!-- 物料编号 -->
                    <th data-options="field:'materialcode_s',editor:{type:'textbox'}"><spring:message code="tyredelay.column.materialcode_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'materialdesc_s',editor:{type:'textbox'}"><spring:message code="tyredelay.column.materialdesc_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'building_time_s',editor:{type:'textbox'}"><spring:message code="tyredelay.column.building_time_s" /></th>
                     <!-- 有效期 -->
                    <th data-options="field:'validtime_s',editor:{type:'textbox'}"><spring:message code="tyredelay.column.validtime_s" /></th>
                    <!-- 延期人 -->
                    <th data-options="field:'delay_by_s',editor:{type:'textbox'}"><spring:message code="tyredelay.column.delay_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="delayhandlerecord.column.created_time_t" /></th>
                    <!-- 延期时间 -->
                    <th data-options="field:'delay_time_t',editor:{type:'textbox'}"><spring:message code="tyredelay.column.delay_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
    	<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="TyreDelay_search_form" />
		<jsp:param name="datagridId" value="tyredelay_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.TyreDelayExportHandler" />
		<jsp:param name="serviceName" value="TyreDelayServiceImpl" />
	</jsp:include>
</body>
</html>
