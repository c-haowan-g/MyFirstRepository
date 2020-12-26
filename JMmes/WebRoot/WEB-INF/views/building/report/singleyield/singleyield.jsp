<!-- 

    作者      :刘朋
    时间      :2019-8-22 
    页面名称:个人台账
    文件关联:
        BuildingQuotaAll.java
        BuildQuotaController.java
        BuildQuotaServiceImpl.java
        BuildQuotaServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="singleyield.js.jsp"%>
<style type="text/css">
.columnTitle {
	padding: 6px 10px
}
</style>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkOrderResultPrint_dg_toolbar">
            <form id="WorkOrderResultPrint_search_form" class="form" >
		            <td class="columnTitle">
		            <spring:message code="workorderresultprint.column.curing_closemoulddate_t" />:
		                  	<!-- 操作时间 -->
						<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
									type="text" class="easyui-datetimebox" style="width:165px"
									data-options="label:''">
								到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
									class="easyui-datetimebox" style="width:165px">
						</td>
						<td class="columnTitle">
						<spring:message code="workorderresultprint.column.created_by_s" />:
		                <!-- 创建人 -->
		                <input name="filter[workname]" like="true" id="workname" type="text" class="easyui-textbox" data-options="label:''" >
		               </td>
		             <%--   <td class="columnTitle">
		               <spring:message code="workorderresultprint.column.equip_code_s" />:
		               <!-- 机台编码 -->
		               <input name="filter[equip_code_s]" id="equip_code_s" like="true" style="width:120px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'lh/scgl/scmxcx/searchByEquipCode',
										  valueField: 'EQUIP_CODE_S',
                              			  textField: 'EQUIP_CODE_S',
										  method:'get'">
		                
		                </td> --%>
		                <br/>	
		                <!-- 规格描述 -->
		                <spring:message code="workorderresult.column.material_code_s" />:
		                <input name="filter[material_code_s]" like="true" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
		                <spring:message code="workorderresult.column.material_name_s" />:
		                <!-- 规格描述 -->
		                <input name="filter[material_name_s]" like="true" id="material_name_s" type="text" class="easyui-textbox" data-options="label:''" >
		               
		                <spring:message code="buildwastereport.column.curingspeccode_s" />:
		                <input name="filter[curingspeccode_s]" like="true" id="curingspeccode_s" type="text" class="easyui-textbox" data-options="label:''" >
		               	<spring:message code="buildwastereport.column.materialspec_s" />:
		                <input name="filter[curingspecdesc_s]" like="true" id="curingspecdesc_s" type="text" class="easyui-textbox" data-options="label:''" >
		               
		                
		               
		               <a class="easyui-linkbutton btn-yellow"data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
		               <auth:button code="CX_QUAN_GANG_REPORT__export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>	
		     </form> 
         </div>
        <table id="workorderresultprint_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WorkOrderResultPrint_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr> 
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 创建人 -->
                    <th data-options="field:'workname',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.created_by_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.equip_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                    <!-- 外胎物料编码 -->
                    <th data-options="field:'curingspeccode_s',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.curingspeccode_s" /></th>
                    <!-- 外胎物料名称 -->
                    <th data-options="field:'curingspecdesc_s',editor:{type:'textbox'}"><spring:message code="buildwastereport.column.materialspec_s" /></th>
                    <!--定额-->
                    <th data-options="field:'quotacount',editor:{type:'textbox'}"><spring:message code="b_mm_quota.column.quotacount_s" /></th>
                    <!-- 总产量 -->
                    <th data-options="field:'yieldcount',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.TotalQuantity" /></th>
                    <!-- 废次品 -->
                    <th data-options="field:'secondlevel',editor:{type:'textbox'}"><spring:message code="maintyre.column.feicipin_count_s" /></th> 
                    <!-- 废品 -->
                    <th data-options="field:'waste',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.waste" /></th> 
					
					<!--质量达成率 -->
                    <th data-options="field:'arate',formatter:aratecompletionrate,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.qualitycompletionrate" /></th> 
                    <!--完成工时 -->
                    <th data-options="field:'gongshi',formatter:finishhours,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.finishhours" /></th> 
              		<!--足额完成率 -->
                    <th data-options="field:'dingerate',formatter:adequatecompletionrate,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.adequatecompletionrate" /></th> 
                </tr>
            </thead>
        </table>
    </div>
    
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkOrderResultPrint_search_form" />
		<jsp:param name="datagridId" value="workorderresultprint_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.BuildQuotaExportHandler" />
		<jsp:param name="serviceName" value="BuildQuotaServiceImpl" />
	</jsp:include>
</body>
</html>
