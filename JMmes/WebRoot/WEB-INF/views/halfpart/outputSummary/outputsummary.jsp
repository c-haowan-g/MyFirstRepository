<!-- 

    作者      :徐秉正
    时间      :2020-03-13 
    页面名称:半部件产量汇总
    文件关联:
        OutputSummary.java
        OutputSummaryController.java
        OutputSummaryServiceImpl.java
        OutputSummaryServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="outputsummary.js.jsp"%>
<script type="text/javascript" src="dict/118.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="OutputSummary_dg_toolbar">
            <form id="OutputSummary_search_form" class="form" >
            
                <!-- 产出开始时间 -->
				<spring:message code="output.column.start_time" />:&nbsp;
				<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:'',width:'150px',required:true">
				<!-- 产出结束时间 -->
				<spring:message code="output.column.end_time" />:&nbsp;
				<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:'',width:'150px',required:true">
            	
            	<span>汇总方式：</span>
            	<!-- 机台条码 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="machinecode_s" id="machinecode_s"/>
            	<spring:message code="output.column.machinecode_s" />
            	<!-- 物料编码 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="materialcode_s" id="materialcode_s"/>
            	<spring:message code="output.column.materialcode_s" />
            	<!-- 产出班次 -->
                <input style="position:relative;top:4px;zoom:150%;"  type="checkbox" name="sumFlag" value="outclass_s" id="outclass_s"/>
            	<spring:message code="output.column.outclass_s" />
            	
                <%-- <!-- 机台条码 -->
                <input name="filter[machinecode_s]" id="machinecode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <input name="filter[materialcode_s]" id="materialcode_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="outputsummary.column.materialcode_s" />'" >
                <!-- 产出班次 -->
                <input name="filter[outclass_s]" id="outclass_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="outputsummary.column.outclass_s" />'" >
                 --%>
            </form> 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="getData()"><spring:message code="button.search" /></a>
            <%-- <auth:button code="outputsummary.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button> --%>
            <auth:button code="outputsummary.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="exportExcel()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="outputsummary.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="outputsummary_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#OutputSummary_dg_toolbar',
                striped:true,
                method: 'get', 
                emptyMsg: '<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'machinecode_s',width:80,editor:{type:'textbox'}"><spring:message code="output.column.machinecode_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'machinename_s',width:80,editor:{type:'textbox'}"><spring:message code="output.column.machinename_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',width:80,editor:{type:'textbox'}"><spring:message code="output.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',width:80,editor:{type:'textbox'}"><spring:message code="output.column.materialname_s" /></th>
                    <!-- 产出班次 -->
                    <th data-options="field:'outclass_s',width:80,formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="output.column.outclass_s" /></th>
                    <!-- 汇总量 -->
                    <th data-options="field:'amount_i',width:80,editor:{type:'textbox'}"><spring:message code="output.column.amount_i" /></th>
                     <!-- 产出量-->
                    <th data-options="field:'outnum_f',editor:{type:'textbox'}"><spring:message code="output.column.outnum_f" /></th>
                </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="OutputSummary_search_form" />
		<jsp:param name="datagridId" value="outputsummary_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.OutputSummaryExportHandler" />
		<jsp:param name="serviceName" value="OutputSummaryServiceImpl" />
	</jsp:include>  
</body>
</html>
