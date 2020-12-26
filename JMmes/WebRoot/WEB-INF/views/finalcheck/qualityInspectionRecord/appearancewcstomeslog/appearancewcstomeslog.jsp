<!-- 

    作者      :徐秉正
    时间      :2019-12-23 10:06:53 
    页面名称:外检WCS交互日志表
    文件关联:
        Appearancewcstomeslog.java
        AppearancewcstomeslogController.java
        AppearancewcstomeslogServiceImpl.java
        AppearancewcstomeslogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="appearancewcstomeslog.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',splitfinalcheck:true,border:false" >
        <div id="Appearancewcstomeslog_dg_toolbar">
            <form id="Appearancewcstomeslog_search_form" class="form" >
            <!-- 外检时间 -->
				<spring:message code="外检时间" />:
             	<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
				type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
				class="easyui-datetimebox" style="width:170px"> 
                <!-- 主键ID -->
                <spring:message code="appearancewcstomeslog.column.id_s" />:
                <input name="filter[id_s]" id="id_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 外检机台 --><br/>
                <spring:message code="appearancewcstomeslog.column.machinecode_s" />:
                <input name="filter[machinecode_s]" id="machinecode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 轮胎条码 -->
                <spring:message code="appearancewcstomeslog.column.tirecode_s" />:
                <input name="filter[tirecode_s]" id="tirecode_s" type="text" class="easyui-textbox" data-options="label:''" >
            </form> 
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            　
        </div>
        <table id="appearancewcstomeslog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Appearancewcstomeslog_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',width:120,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.id_s" /></th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tirecode_s',width:110,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.tirecode_s" /></th>
                    <!-- 外检机台 -->
                    <th data-options="field:'machinecode_s',width:60,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.machinecode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',width:60,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.materialcode_s" /></th>
                    <!-- 规格描述 -->
                    <th data-options="field:'tirestand_s',width:60,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.tirestand_s" /></th>
                    <!-- 病象编码 -->
                    <th data-options="field:'diseasecode_s',width:60,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.diseasecode_s" /></th>
                    <!-- 病象名称 -->
                    <th data-options="field:'diseasename_s',width:60,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.diseasename_s" /></th>
                    <!-- 外检质量等级 -->
                    <th data-options="field:'gradecode_s',width:80,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.gradecode_s" /></th>
                    <!-- 外检等级描述 -->
                    <th data-options="field:'gradeinfo_s',width:80,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.gradeinfo_s" /></th>
                    <!-- 外检时间 -->
                    <th data-options="field:'inspecttime_s',width:150,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.inspecttime_s" /></th>
                    <!-- 外检人 -->
                    <th data-options="field:'inspectopr',width:100,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.inspectopr_s" /></th>
                    <!-- 外检班次 -->
                    <th data-options="field:'teamcode_s',width:60,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.teamcode_s" /></th>
                    <!-- 外检班组 -->
                    <th data-options="field:'team_s',width:60,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.team_s" /></th>
                    <!-- MES信息 -->
                    <th data-options="field:'synerr_s',width:100,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.synerr_s" /></th>
                    <!-- 同步标志位 -->
                    <th data-options="field:'synflag_s',width:70,editor:{type:'textbox'}"><spring:message code="appearancewcstomeslog.column.synflag_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Appearancewcstomeslog_search_form" />
		<jsp:param name="datagridId" value="appearancewcstomeslog_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.AppearancewcstomeslogExportHandler" />
		<jsp:param name="serviceName" value="AppearancewcstomeslogServiceImpl" />
	</jsp:include>
</body>
</html>
