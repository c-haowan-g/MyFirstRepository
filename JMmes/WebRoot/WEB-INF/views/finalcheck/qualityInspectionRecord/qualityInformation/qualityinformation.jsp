<!-- 

    作者      :whl
    时间      :2019-02-10 13:58:38 
    页面名称:质量汇总信息
    文件关联:
        QualityInformation.java
        QualityInformationController.java
        QualityInformationServiceImpl.java
        QualityInformationServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="qualityinformation.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="QualityInformation_dg_toolbar">
            <form id="QualityInformation_search_form" class="form" >
				<!-- 硫化开始时间 -->
				<spring:message code="productcheckinformation.column.start_time" />:
				<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''">
				<!-- 硫化结束时间 -->
				<spring:message code="productcheckinformation.column.end_time" />:
				<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''">
                <auth:button code="qualityinfo.search"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a></auth:button>
            	<auth:button code="qualityinfo.excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="qualityinformation_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#QualityInformation_dg_toolbar',
                striped:true,
                method: 'get' ,
                emptyMsg:'暂无数据'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 一级品数量 -->
                    <th data-options="field:'a_count',width:80,editor:{type:'textbox'}"><spring:message code="qualityinformation.column.a_count" /></th>
                    <!-- 二级品数量 -->
                    <th data-options="field:'b_count',width:80,editor:{type:'textbox'}"><spring:message code="qualityinformation.column.b_count" /></th>
                    <!-- 废品数量 -->
                    <th data-options="field:'waste_count',width:80,editor:{type:'textbox'}"><spring:message code="qualityinformation.column.waste_count" /></th>
                    <!-- 外检不合格数量 -->
                    <th data-options="field:'visual_waste_count',width:80,editor:{type:'textbox'}"><spring:message code="qualityinformation.column.visual_waste_count" /></th>
                    <!-- 动平衡检不合格数量 -->
                    <th data-options="field:'dynamic_waste_count',width:80,editor:{type:'textbox'}"><spring:message code="qualityinformation.column.dynamic_waste_count" /></th>
                    <!-- x光检不合格数量 -->
                    <th data-options="field:'xlight_waste_count',width:80,editor:{type:'textbox'}"><spring:message code="qualityinformation.column.xlight_waste_count" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <!--导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="QualityInformation_search_form" />
		<jsp:param name="datagridId" value="qualityinformation_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.MainTyreExportHandler" />
		<jsp:param name="serviceName" value="MainTyreServiceImpl" />
	</jsp:include>
</body>
</html>
