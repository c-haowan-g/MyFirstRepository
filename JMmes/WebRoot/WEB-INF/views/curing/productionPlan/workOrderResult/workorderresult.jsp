<!-- 

    作者      :时永良
    时间      :2019-01-16 15:45:07 
    页面名称:硫化生产分析
    文件关联:
        WorkOrderResult.java
        WorkOrderResultController.java
        WorkOrderResultServiceImpl.java
        WorkOrderResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="workorderresult.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkOrderResult_dg_toolbar">
            <form id="WorkOrderResult_search_form" class="form" >
            	<table class="formTable">
					<tr>
						<td class="columnTitle">
							<spring:message code="workorderresult.column.equip_code_s" />:
			            </td>
						<td class="columnData">
							<!-- 机台条码 -->
			                <input name="filter[equip_code_s]" id="equip_code_s" type="text" beginWith=true class="easyui-textbox" style="width:150px" data-options="label:''" >
						</td>
						
						<td class="columnTitle">
			            	<spring:message code="workorderresult.column.material_code_s" />:
			            </td>
						<td class="columnData">
							<!-- 物料编码  品号-->
			                <input name="filter[material_code_s]" id="material_code_s" type="text" beginWith=true class="easyui-textbox" style="width:150px" data-options="label:''" >
						</td>
						
						<td class="columnTitle">
							<spring:message code="workorderresult.column.materialspec_s" />:
			            </td>
						<td class="columnData">
							<!-- 规格描述 -->
			                <input name="filter[materialspec_s]" id="materialspec_s" type="text" like="true" class="easyui-textbox" style="width:150px" data-options="label:''" >
						</td>
						
						<td class="columnTitle">
							<spring:message code="workorderresult.column.production_date_s" />:
				        </td>
						<td class="columnData">
							<!-- 硫化生产时间 -->
				            <input name="filter[production_date_s]" id="production_date_s" type="text" beginWith=true class="easyui-datebox" style="width:150px" data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:''">
				            <script type="text/javascript">
				            	$("#production_date_s").val(new Calendar().format("yyyyMMdd"));
				            </script>
						</td>
						<td class="columnTitle">
							<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
							<auth:button code="LH_BB_LHSCFX_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
						</td>
						<!-- <td class="columnData">
						</td> -->
				</table>
            </form> 
        </div>
        <table id="workorderresult_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WorkOrderResult_dg_toolbar',
                url: 'curing/report/productionSubsidiaryQuery/datagrid',
                striped:true,
                method: 'get',
                onBeforeLoad:onDgBeforeLoad,
                emptyMsg:'暂无数据',
                halign: 'center'
                
                ">
            <thead>
            	<tr>
            		<th data-options="colspan:6"></th>
            		<!-- 一班16：00-24：00 -->
                    <th data-options="width:180,colspan:3,editor:{type:'textbox'}"><spring:message code="workorderresult.column.class_one_i" /></th>
                    <!-- 二班00：00-08：00 -->
					<th data-options="width:180,colspan:3,editor:{type:'textbox'}"><spring:message code="workorderresult.column.class_two_i" /></th>
					<!-- 三班08：00-16：00 -->
					<th data-options="width:180,colspan:3,editor:{type:'textbox'}"><spring:message code="workorderresult.column.class_three_i" /></th>
                </tr>
                <tr>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.equip_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'materialspec_s',width:450,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.material_name_s" /></th>
                    
                    <!-- 日计划 -->
                    <th data-options="field:'quantity_dayplan_i',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.quantity_dayplan_i" /></th>
                    <!-- 日完成 -->
                    <th data-options="field:'qty_dayproduct_i',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.qty_dayproduct_i" /></th>
                    <!-- 日计划完成率 -->
                    <th data-options="field:'dayratio',width:90,editor:{type:'textbox'}"><spring:message code="workorderresult.column.qty_dayproduct_rate_i" /></th>
                    <!-- 早班日计划 -->
                    <th data-options="field:'planamount_mor_i',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.planamount_i" /></th>
                    <!-- 早班日完成 -->
                    <th data-options="field:'qty_morprocuct_i',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.output_class_i" /></th>
                    <!-- 早班日完成率 -->
                    <th data-options="field:'morratio',width:60,editor:{type:'textbox'},formatter:formatRate"><spring:message code="workorderresult.column.output_class_rate_i" /></th>
                    <!-- 中班日计划 -->
                    <th data-options="field:'planamount_mid_i',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.planamount_i" /></th>
                    <!-- 中班日完成 -->
                    <th data-options="field:'qty_midproduct_i',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.output_class_i" /></th>
                    <!-- 中班日完成率 -->
                    <th data-options="field:'midratio',width:60,editor:{type:'textbox'},formatter:formatRate"><spring:message code="workorderresult.column.output_class_rate_i" /></th>
                    <!-- 晚班日计划 -->
                    <th data-options="field:'planamount_nig_i',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.planamount_i" /></th>
                    <!-- 晚班日完成 -->
                    <th data-options="field:'qty_nigproduct_i',width:60,editor:{type:'textbox'}"><spring:message code="workorderresult.column.output_class_i" /></th>
                    <!-- 晚班日完成率 -->
                    <th data-options="field:'nigratto',width:60,editor:{type:'textbox'},formatter:formatRate"><spring:message code="workorderresult.column.output_class_rate_i" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
   <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkOrderResult_search_form" />
		<jsp:param name="datagridId" value="workorderresult_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.WorkOrderResult2ExportHandler" />
		<jsp:param name="serviceName" value="WorkOrderResultServiceImpl" />
		
	</jsp:include>
</body>
</html>
