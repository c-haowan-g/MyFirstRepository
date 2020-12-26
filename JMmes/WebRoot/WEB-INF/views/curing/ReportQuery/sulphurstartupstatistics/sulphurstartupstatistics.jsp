<!-- 
    作者      :李迺琨
    时间      :2018-12-12 16:53:01
    页面名称:硫化开车统计
    文件关联:
        SulphurStartUpStatisticsDetailed.java
        SulphurStartUpStatisticsSummarize.java
        SulphurStartUpStatisticsController.java
        SulphurStartUpStatisticsServiceImpl.java
        SulphurStartUpStatisticsServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sulphurstartupstatistics.js.jsp"%>
<script type="text/javascript" src="dict/301,302,305.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>

<body class="easyui-layout" fit="true"> 
   <div class="easyui-tabs" fit="true" border="false" style="width:700px;height:250px">
		<div title="<spring:message code='tip.detailed'/>" style="padding:10px">
		        <div id="SulphurStartUpStatistics_dg_toolbar">
		            <form id="SulphurStartUpStatistics_search_form" class="form" >
		                 <spring:message code="sulphurstartupstatistics.column.start_time_t" />:
                <input name="filter[start_time]" type="text"    id="start_time" class="easyui-datetimebox"  style="width:165px;" data-options="label:''">
               <spring:message code="sulphurstartupstatistics.column.end_time_t" />:
                <input name="filter[end_time]"    id="end_time" class="easyui-datetimebox"  style="width:165px;">
            	<!-- 机台编码 -->
            	<spring:message code="feedingrecord.column.machinecode_s" />:
				<input name="filter[equip_code_s]"  id="equip_code_s" beginWith="true" style="width:150px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:300,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'curing/report/productionSubsidiaryQuery/searchByEquipCode',
										  valueField: 'EQUIP_CODE_S',
                              			  textField: 'EQUIP_CODE_S',
										  method:'get'" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="sulphurstartupstatistics.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
		        </form> 
		        </div>
		        <table id="sulphurstartupstatistics_dg" class="easyui-datagrid" style="width:100%"
		           data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SulphurStartUpStatistics_dg_toolbar',
                striped:true,
                method: 'get',
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                
                ">
		            <thead>
		         <tr>
                 	<th data-options="field:'atr_key',checkbox:true">ID</th>
                	<!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',width:80,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.machinecode_s" /></th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyre_barcode_s',width:120,editor:{type:'textbox'}"><spring:message code="workorderresult.column.tyre_barcode_s" /></th>
                    <!-- 开模时间(分钟) -->
                    <th data-options="field:'opening_time',width:120,editor:{type:'textbox'}"><spring:message code="sulphurstartupstatistics.column.opening_time_t" /></th>
                    <!-- 合模时间(分钟) -->
                    <th data-options="field:'closeing_time',sortable:true,width:120,editor:{type:'textbox'}"><spring:message code="sulphurstartupstatistics.column.closing_time_t" /></th>
                    <!-- 物料编码(品号) -->
                    <th data-options="field:'material_code_s',width:120,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:200,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                 </tr>
		            </thead>
		        </table>
       </div>
     
      <div title="<spring:message code='tip.summarizing'/>" style="padding:10px">
         <div id="SulphurStartUpStatistics_dg_toolbar2">
		            <form id="SulphurStartUpStatistics_search_form2" class="form">
		        <spring:message code="sulphurstartupstatistics.column.start_time_t" />:
                <input name="filter[start_time]" type="text"    id="start_time2" class="easyui-datetimebox"  style="width:165px;" data-options="label:''">
                <spring:message code="sulphurstartupstatistics.column.end_time_t" />:
                <input name="filter[end_time]"    id="end_time2" class="easyui-datetimebox"  style="width:165px;">
            	<!-- 机台编码 -->
            	<spring:message code="feedingrecord.column.machinecode_s" />:
				<input name="filter[equip_code_s]"  id="equip_code_s2" beginWith="true" style="width:150px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:300,
										  required:false,
										  editable:true,
										  limitToList:false,
										   url:'curing/report/productionSubsidiaryQuery/searchByEquipCode',
										  valueField: 'EQUIP_CODE_S',
                              			  textField: 'EQUIP_CODE_S',
										  method:'get'" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter2()"><spring:message code="button.search" /></a>
            	<auth:button code="sulphurstartupstatistics.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="ExcelExport2()"><spring:message code="button.export" /></a></auth:button>
		            </form> 
		        </div>
		       <table id="sulphurstartupstatistics_dg2" class="easyui-datagrid" style="width:100%"
		           data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SulphurStartUpStatistics_dg_toolbar2',
                striped:true,
                method: 'get',
                  emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
		         <thead>
		         <tr>
                 	<th data-options="field:'atr_key',checkbox:true">IDss</th>
                	<!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',width:80,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.machinecode_s" /></th>
                    <!-- 开车率 -->
                    <th data-options="field:'driving_rate',sortable:true,width:80,formatter:drivingRateFormatter,editor:{type:'textbox'}"><spring:message code="sulphurstartupstatistics.column.driving_rate_s" /></th>
                    <!-- 开模时间(分钟) -->
                    <th data-options="field:'opening_time',sortable:true,width:120,editor:{type:'textbox'}"><spring:message code="sulphurstartupstatistics.column.opening_time_t" /></th>
                    <!-- 合模时间(分钟) -->
                    <th data-options="field:'closeing_time',sortable:true,editor:{type:'textbox'},width:120"><spring:message code="sulphurstartupstatistics.column.closing_time_t" /></th>
                    <!-- 时间段 -->
                    <th data-options="field:'time_quantum',width:280,formatter:timeFormatter,editor:{type:'textbox'}"><spring:message code="sulphurstartupstatistics.column.time_quantum_t" /></th>
                 </tr>
		         </thead>
		        </table>
		   </div>     
     </div> 
    
   <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SulphurStartUpStatistics_search_form" />
		<jsp:param name="datagridId" value="sulphurstartupstatistics_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.SulphurStartUpStatisticsExportHandler" />
		<jsp:param name="serviceName" value="SulphurStartUpStatisticsServiceImpl" />
	</jsp:include>  
	
	
	
</body>
</html>
