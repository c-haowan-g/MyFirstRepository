<!-- 

    作者      :刘朋
    时间      :2019-08-22
    页面名称:产出实绩表
    文件关联:
        BuildWasteReport.java
        BuildWasteReportController.java
        BuildWasteReportServiceImpl.java
        BuildWasteReportServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="buildwastereport.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="BuildWasteReport_dg_toolbar">
            <form id="BuildWasteReport_search_form" class="form" >
                <spring:message code="buildwastereport.column.building_date_t" />:
                <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
									type="text" class="easyui-datetimebox" style="width:165px"
									data-options="label:''">
								到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
									class="easyui-datetimebox" style="width:165px">
                
                <!-- 胎胚编码 -->
                <spring:message code="buildwastereport.column.material_code_s" />:
                <input name="filter[material_code_s]" id="material_code_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 描述 -->
                <spring:message code="buildwastereport.column.material_name_s" />:
                <input name="filter[material_name_s]" id="material_name_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
               <br/>
                <!-- 外胎物料编码 -->
                <spring:message code="buildwastereport.column.curingspeccode_s" />:
                <input name="filter[curingspeccode_s]" id="curingspeccode_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 描述 -->
                <spring:message code="buildwastereport.column.materialspec_s" />:
                <input name="filter[materialspec_s]" id="materialspec_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
               
                <%--  <!-- 胎胚重量 -->
                <input name="filter[building_weight_s]" id="building_weight_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="buildwastereport.column.building_weight_s" />'" >
                <!-- 修改人 -->
                <input name="filter[changed_by_s]" id="changed_by_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="buildwastereport.column.changed_by_s" />'" >
              --%><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="CX_QUAN_GANG_REPORT_ZLBB_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
      
            </form> 
        </div>
        <table id="buildwastereport_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#BuildWasteReport_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 胎胚规格 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.material_code_s" /></th>
                    <!-- 描述-->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.material_name_s" /></th>
               		<!-- code-->
                    <th data-options="field:'curingspeccode_s',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.curingspeccode_s" /></th>
               		<!-- 规格描述 -->
                    <th data-options="field:'materialspec_s',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.materialspec_s" /></th>
               		<!-- 总产量 -->
                    <th data-options="field:'sumcount',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.TotalQuantity" /></th>
                    <!-- 一级品 -->
                    <th data-options="field:'gradea',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.GradeA" /></th>
                    <!-- A0 -->
                    <th data-options="field:'gradea0',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.GradeA0" /></th>
                    <!-- 二级品 -->
                    <th data-options="field:'secondlevel',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.secondlevel" /></th>
                  	<!-- 废品 -->
                    <th data-options="field:'waste',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.waste" /></th> 
                    <!--特废 -->
                    <th data-options="field:'specialwaste',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.specialwaste" /></th> 
                 	
                 	<!--sumwaste -->
                    <th data-options="field:'sumwaste',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.sumwaste" /></th>
                    <!-- buildwaste -->
                    <th data-options="field:'buildwaste',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.buildwaste" /></th>
                    <!-- curingwaste -->
                    <th data-options="field:'curingwaste',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.curingwaste" /></th>
                    <!-- dynawaste -->
                    <th data-options="field:'dynawaste',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.dynawaste" /></th>
                  	<!-- xlightwaste -->
                    <th data-options="field:'xlightwaste',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.xlightwaste" /></th> 
                    <!--visuwaste -->
                    <th data-options="field:'visuwaste',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.visuwaste" /></th> 
               
               </tr>
            </thead>
        </table>
    </div>
   <jsp:include page="../../../../inc/export.jsp">
    	<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="BuildWasteReport_search_form" />
		<jsp:param name="datagridId" value="buildwastereport_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.BuildWasteReportExportHandler" />
		<jsp:param name="serviceName" value="BuildWasteReportServiceImpl" />
	</jsp:include>
</body>
</html>
