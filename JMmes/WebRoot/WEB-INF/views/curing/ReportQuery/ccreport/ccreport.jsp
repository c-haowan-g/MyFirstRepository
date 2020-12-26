<!-- 

    作者      :周清玉
    时间      :2019-09-5 13:31:11 
    页面名称:报产跨月
    文件关联:
        SapReturnResult.java
        SapReturnResultController.java
        SapReturnResultServiceImpl.java
        SapReturnResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<script type="text/javascript" src="dict/252,302,301.js"></script>
<%@ include file="ccreport.js.jsp"%>
<script type="text/javascript">
$.extend($.fn.textbox.defaults, {
    "icons" : []
});
</script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="MesSapProduction_dg_toolbar2">
            <form id="messapproduction_search_form" class="form" >
              	<spring:message code="maintyrecur.column.curingclosemouldtime_t" />
				<input name="filter[beginTime]" type="text" id="beginTime" class="easyui-datetimebox" style="width:150px;" data-options="label:''">
				<spring:message code="tip.to" />
				<input name="filter[endTime]" id="endTime" class="easyui-datetimebox" style="width:150px;" data-options="">
				
				<spring:message code="messapproduction.column.material_code_s" />
				<input name="filter[material_code]" id="material_code" like="true" class="easyui-textbox" style="width:150px;" data-options="">
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()">
					<spring:message code="button.search" />
				</a>
				<auth:button code="SRR_REPORT_EXPORT1"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()">
				<spring:message code="button.export" />
				</a>
				</auth:button>
            </form> 
        </div>
       <table id="messapproduction_dg2" class="easyui-datagrid" style="width:100%" data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MesSapProduction_dg_toolbar2',
                striped:true,
                method: 'get' 
                ">
			<thead>
				<tr>
					<th data-options="field:'',checkbox:true"></th>
					<th data-options="field:'material_code_s',editor:{type:'textbox'},width:100">物料编码</th>
					<th data-options="field:'material_name_s',editor:{type:'textbox'},width:100">物料名称</th>
					<th data-options="field:'productionver_s',editor:{type:'textbox'},width:100">生产版本</th>
					<th data-options="field:'class_id_s',editor:{type:'textbox'},formatter:codeFormatter,width:100">班组</th>
					<th data-options="field:'total',editor:{type:'textbox'},width:100">数量</th>
				</tr>
			</thead>
		</table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="messapproduction_search_form" />
		<jsp:param name="datagridId" value="messapproduction_dg2" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.lh.ExcelHandler.BcreportExportHandler" />
		<jsp:param name="serviceName" value="WorkOrderResultServiceImpl" />
	</jsp:include>
</body>
</html>