<!-- 

    作者      :时永良
    时间      :2019年7月18日16:41:57 
    页面名称:日计划进度查询
    文件关联:
        ReportOfPlanSchedule.java
        ReportOfPlanScheduleController.java
        ReportOfPlanScheduleServiceImpl.java
        ReportOfPlanScheduleServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="reportofplanschedule.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ReportOfPlanSchedule_dg_toolbar">
            <form id="ReportOfPlanSchedule_search_form" class="form" >
                <!-- 日计划号 -->
                <spring:message code="productiondayplan.column.plan_no_s" />:
                <input name="filter[plan_no_s]" id="plan_no_s" like="true" type="text" class="easyui-textbox"style="width:140px" data-options="label:''" >
                <!-- 操作时间 -->
                <spring:message code="productiondayplan.column.production_date_s" />:
	            <input name="filter[production_date_s]" id="production_date_s" type="text" class="easyui-datebox" style="width:120px" data-options="editable:true,onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:''">
	            <script type="text/javascript">
	            $("#production_date_s").val(new Calendar().format("yyyyMMdd"));
	            </script>
	            <!-- 产线条码 -->
	            <spring:message code="productiondayplan.column.production_line_s" />:
	            <input type="text" name="filter[production_line_s]" id="production_line_s" class="easyui-combobox" data-options="data:jtxx,panelHeight:150,editable:true,valueField:'PRODUCT_LINE_S',textField:'PRODUCT_LINE_S',selectOnNavigation:false,limitToList:true,filter:searchProductionLine,onChange:filter" />
       			<br/>
       			 <!-- 物料编码 -->
       			 <spring:message code="sapproductionplan.column.material_code_s" />:
				<input name="filter[material_code_left_s]" id="material_code_left_s" like ="true"
					type="text" class="easyui-combobox"
					data-options="
                	label:'',
                    panelHeight:200,
					required:false,
					editable:'true',
					limitToList:'false',
					url:'curing/moldmanagement/moldmarkingdrawing/materialpdf/searchByMaterial',
					valueField: 'MATERIALCODE_S',
                    textField: 'MATERIALCODE_S',
					method:'get'"
					style="width:140px;">
				<!-- 物料描述 -->
				<spring:message code="sapproductionplan.column.material_name_s" />:
				<input name="filter[material_desc_left_s]" id="material_desc_left_s" like ="true"
					type="text" class="easyui-textbox"
					data-options="
                label:''">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
         		<auth:button code="LH_BB_JHJDBB_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
                </form> 
        </div>
        <table id="reportofplanschedule_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ReportOfPlanSchedule_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                    <tr>
                    <th data-options="field:'atr_key',checkbox:true"rowspan="2"></th>
                    <!-- 产线条码 -->
                    <th data-options="field:'production_line_s',editor:{type:'textbox'}"rowspan="2"><spring:message code="productiondayplan.column.production_line_s" /></th>
                    <!-- 计划生产日期 -->
                    <th data-options="field:'production_date_s',editor:{type:'textbox'}"rowspan="2"><spring:message code="productiondayplan.column.production_date_s" /></th>
                    <!-- 日计划号 -->
                    <th data-options="field:'plan_no_s',editor:{type:'textbox'}"rowspan="2"><spring:message code="productiondayplan.column.plan_no_s" /></th>
                   
                    <th colspan="3">左机台计划量</th>
                    <th colspan="3">右机台计划量</th>
                    <th colspan="11">左机台</th>
                    <th colspan="11">右机台</th>
                    </tr>
					<tr>
                    <!-- 日计划量(左) -->
                    <th data-options="field:'quantity_dayplan_left_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.quantity_dayplan_left_i" /></th>
                    <!-- 日完成量(左) -->
                    <th data-options="field:'qty_dayproduct_left_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.qty_dayproduct_left_i" /></th>
                    <!-- 左机台完成百分比 -->
                    <th data-options="field:'qty_dayproduct_left_bl',formatter:progressFormatter,editor:{type:'textbox'}"><spring:message code="productiondayplan.column.qty_dayproduct_left_bl" /></th>
                    <!-- 日计划量(右) -->
                    <th data-options="field:'quantity_dayplan_right_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.quantity_dayplan_right_i" /></th>
                    <!-- 日完成量(右) -->
                    <th data-options="field:'qty_dayproduct_right_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.qty_dayproduct_right_i" /></th>
                    <!-- 完成百分比 -->
                    <th data-options="field:'qty_dayproduct_right_bl',formatter:progressFormatter,editor:{type:'textbox'}"><spring:message code="qty_dayproduct_right_bl" /></th>
                 
                    <!-- 物料编码(左) -->
                    <th data-options="field:'material_code_left_s',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.material_code_left_s" /></th>
                    <!-- 物料名称(左) -->
                    <th data-options="field:'material_desc_left_s',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.material_desc_left_s" /></th>
                    <!-- 早班计划量-左 -->
                    <th data-options="field:'planamount_mor_left_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_mor_left_i" /></th>
                    <!-- 早班完成量(左) -->
                    <th data-options="field:'output_morclass_left_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_morclass_left_i" /></th>
                     <!-- 完成百分比 -->
                    <th data-options="field:'qty_dayproduct_left_zbwcbfb',formatter:progressFormatter,editor:{type:'textbox'} "><spring:message code="qty_dayproduct_left_zbwcbfb" /></th>
                    <!-- 中班计划量-左 -->
                    <th data-options="field:'planamount_mid_left_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_mid_left_i" /></th>
                    <!-- 中班完成量(左) -->
                    <th data-options="field:'output_midclass_left_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_midclass_left_i" /></th>
                    <!-- 完成百分比 -->
                    <th data-options="field:'qty_dayproduct_left_zwbwcbfb',formatter:progressFormatter,editor:{type:'textbox'} "><spring:message code="qty_dayproduct_left_zwbwcbfb" /></th>
                    <!-- 晚班计划量-左 -->
                    <th data-options="field:'planamount_nig_left_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_nig_left_i" /></th>
                    <!-- 晚班完成量(左) -->
                    <th data-options="field:'output_nigclass_left_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_nigclass_left_i" /></th>
                    <!-- 完成百分比 -->
                     <th data-options="field:'qty_dayproduct_left_wbwcbfb',formatter:progressFormatter,editor:{type:'textbox'} "><spring:message code="qty_dayproduct_left_wbwcbfb" /></th>
                    
                    
                    <!-- 物料编码(右) -->
                    <th data-options="field:'material_code_right_s',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.material_code_right_s" /></th>
                    <!-- 物料名称(右) -->
                    <th data-options="field:'material_desc_right_s',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.material_desc_right_s" /></th>
                    <!-- 早班计划量-右 -->
                    <th data-options="field:'planamount_mor_right_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_mor_right_i" /></th>
                    <!-- 早班完成量(右) -->
                    <th data-options="field:'output_morclass_right_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_morclass_right_i" /></th>
                    <!-- 完成百分比 -->
                    <th data-options="field:'qty_dayproduct_right_wbwcbfb',formatter:progressFormatter,editor:{type:'textbox'} "><spring:message code="qty_dayproduct_right_wbwcbfb" /></th>
                    <!-- 中班计划量-右 -->
                    <th data-options="field:'planamount_mid_right_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_mid_right_i" /></th>
                    <!-- 中班完成量(右) -->
                    <th data-options="field:'output_midclass_right_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_midclass_right_i" /></th>
                    <!-- 完成百分比 -->
                    <th data-options="field:'qty_dayproduct_right_zwcbfb',formatter:progressFormatter,editor:{type:'textbox'} "><spring:message code="qty_dayproduct_right_zwcbfb" /></th>
                    <!-- 晚班计划量-右 -->
                    <th data-options="field:'planamount_nig_right_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.planamount_nig_right_i" /></th>
                    <!-- 晚班完成量(右) -->
                    <th data-options="field:'output_nigclass_right_i',editor:{type:'textbox'}"><spring:message code="productiondayplan.column.output_nigclass_right_i" /></th>
                    <!-- 完成百分比 -->
                    <th data-options="field:'qty_dayproduct_right_wcbwcbfb',formatter:progressFormatter,editor:{type:'textbox'} "><spring:message code="qty_dayproduct_right_wcbwcbfb" /></th>
            </tr>       
          </thead>
        </table>
    </div>
      <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ReportOfPlanSchedule_search_form" />
		<jsp:param name="datagridId" value="reportofplanschedule_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.ReportOfPlanScheduleExportHandler" />
		<jsp:param name="serviceName" value="ReportOfPlanScheduleServiceImpl" />
	</jsp:include>
</body>
</html>
