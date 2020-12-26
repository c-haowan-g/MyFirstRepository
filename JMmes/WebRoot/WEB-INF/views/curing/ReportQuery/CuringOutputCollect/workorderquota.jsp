<!-- 

    作者      :周清玉
    时间      :2019-09-04 11:17:18 
    页面名称:硫化产量报表
    文件关联:
        WorkOrderResultPrint.java
        WorkOrderResultPrintController.java
        WorkOrderResultPrintServiceImpl.java
        WorkOrderResultPrintServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="workorderquota.js.jsp"%>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkOrderResultPrint_dg_toolbar">
            <form id="WorkOrderResultPrint_search_form" class="form" >
		            <spring:message code="workorderresultprint.column.curing_closemoulddate_t" />:
		                  	<!-- 操作时间 -->
						<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
									type="text" class="easyui-datetimebox" style="width:165px"
									data-options="label:''">
								到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
									class="easyui-datetimebox" style="width:165px">
						
		                <spring:message code="workorderresultprint.column.equip_code_s" />:
		                <input name="filter[equip_code_s]" id="equip_code_s" like="true" style="width:120px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'curing/report/productionSubsidiaryQuery/searchByEquipCode',
										  valueField: 'EQUIP_CODE_S',
                              			  textField: 'EQUIP_CODE_S',
										  method:'get'">
		               <%--  <spring:message code="workorderresultprint.column.material_name_s" />:
		                <!-- 规格描述 -->
		                <input name="filter[material_name_s]" like="true" id="material_name_s" type="text" class="easyui-textbox" data-options="label:''" >
		                 --%><spring:message code="workorderresultprint.column.material_code_s" />:
		                <input name="filter[material_code_s]" like="true" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
		                <input type="checkbox" class="checkbox"  value="1" id="equipcode" name="change" checked="true">机台编码
		                <input type="checkbox" class="checkbox"  value="2" id="material" name="change" >物料编码
		                <input type="checkbox" class="checkbox"  value="3" id="curingid" name="change">硫化工人
		                <a class="easyui-linkbutton btn-yellow"data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
	     <auth:button code="LH_BB_LHCLBB_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="ExcelExport()"><spring:message code="button.export" /></a></auth:button>
		     </form> 
                </div>
        <table id="workorderresultprint_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                striped:true,
                rownumbers: true,
                singleSelect: false,
                onLoadSuccess:onLoadSuccess,
                rowStyler:setRowBgColor,
                toolbar: '#WorkOrderResultPrint_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: '',
                pageSize: 15,
       			pageList: [15,30,50,100,200],
                striped:true,
                method: 'get' ,
                loadFilter: pagerFilter
                ">
            <thead>
                <tr> 
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',hidden:true,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.equip_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',hidden:true,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.material_code_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'material_name_s',hidden:true,editor:{type:'textbox'}"><spring:message code="qualitycheck.column.material_spec_s" /></th>
                    
                    <!-- 硫化工人 -->
                    <th data-options="field:'username',hidden:true,width:60,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.created_by_s" /></th>
                   
                    <!-- 总产量 -->
                    <th data-options="field:'totalquantity',width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.TotalQuantity" /></th>
                    <!-- 一级品 -->
                    <th data-options="field:'gradea',width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.GradeA" /></th>
                    <!-- A0 -->
                    <th data-options="field:'gradea0',width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.GradeA0" /></th>
                    <!-- 二级品 -->
                    <th data-options="field:'secondlevel',width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.secondlevel" /></th>
                  	<!-- 废品 -->
                    <th data-options="field:'waste',width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.waste" /></th> 
                    <!--特废 -->
                    <th data-options="field:'specialwaste',width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.specialwaste" /></th> 
                 	<!--质量达成率 -->
                    <th data-options="field:'qualitycompletionrate',formatter:qualitycompletionrate,width:80,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.qualitycompletionrate" /></th> 
                </tr>
            </thead>
        </table>
    </div>
    
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkOrderResultPrint_search_form" />
		<jsp:param name="datagridId" value="workorderresultprint_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.WorkOrderResultPrintExportHandler" />
		<jsp:param name="serviceName" value="WorkOrderResultPrintServiceImpl" />
	</jsp:include> 
</body>
</html>
