<!-- 
/mes/WebRoot/WEB-INF/views/lh/bb/patchcuringwork/patchcuringwork.jsp
    作者      :周志祥
    时间      :2018-12-18 14:39:34 
    页面名称:硫化补硫化查询
    文件关联:
        PatchCuringWork.java
        PatchCuringWorkController.java
        PatchCuringWorkServiceImpl.java
        PatchCuringWorkServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="patchcuringwork.js.jsp"%>
<script type="text/javascript" src="dict/253,301,305,302,280,281.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="PatchCuringWork_dg_toolbar">
            <form id="PatchCuringWork_search_form" class="form" >
            	<spring:message code="patchcuringwork.column.curing_openmoulddate_t" />:
             	<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
						到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
							class="easyui-datetimebox" style="width:170px">
             	<!-- 轮胎条码 -->
             	<spring:message code="patchcuringwork.column.tyre_barcode_s" />:
                <input name="filter[tyre_barcode_s]" id="tyre_barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
             	<!-- 机台编码 -->
             	<spring:message code="patchcuringwork.column.equip_code_s" />:
                <input name="filter[equip_code_s]" like="true" id="equip_code_s" type="text" class="easyui-combobox" data-options="data:jtxx,
                panelHeight:150,
                editable:true,
                valueField:'P_LINE_NAME',
                textField:'P_LINE_NAME',
                selectOnNavigation:false,
                limitToList:true,
                filter:searchProductionLine" >
               <br/> <!-- 工单号 -->
                <spring:message code="patchcuringwork.column.plan_no_s" />:
                <input name="filter[plan_no_s]" id="plan_no_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 规格 -->
                <spring:message code="patchcuringwork.column.material_code_s" />:
                <input name="filter[material_code_s]" id="material_code_s" like="true" type="text" class="easyui-textbox" data-options="label:''" >
            
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="LH_BB_PACTHCURING_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
          </div>
        <table id="patchcuringwork_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#PatchCuringWork_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyre_barcode_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.tyre_barcode_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.equip_code_s" /></th>
                     <!-- 物料规格 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.material_code_s" /></th>
                    <!-- 规格描述 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.material_name_s" /></th>
                    <!-- 胎号
                    <th data-options="field:'tyreno_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.tyreno_s" /></th>
                     --><!-- 工单号 -->
                    <th data-options="field:'plan_no_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.plan_no_s" /></th>
                   
                    <!-- 补录类型（备用字段10） -->
                    <th data-options="field:'spare10_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.refillstype_s" /></th>
                    <!-- 补录原因（备用字段7） -->
                    <th data-options="field:'spare7_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.patchreason_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'memo_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.memos_s" /></th>
                   
                    <!-- 补录人员 -->
                    <th data-options="field:'changedbyname',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.created_by_s" /></th>
                    <!-- 补录时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.changed_time_t" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.created_time_t" /></th>
                    <!-- 硫化扫描时间 -->
                    <th data-options="field:'curings_candate_t',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.curings_candate_t" /></th>
                    <!-- 硫化合模时间 -->
                    <th data-options="field:'curing_closemoulddate_t',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.curing_closemoulddate_t" /></th>
                    <!-- 硫化开模时间 -->
                    <th data-options="field:'curing_openmoulddate_t',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.curing_openmoulddate_t" /></th>
                    <!-- 硫化班组 -->
                    <th data-options="field:'shift_id_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.shift_id_s" /></th>
                    <!-- 硫化班次 -->
                    <th data-options="field:'class_id_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.class_id_s" /></th>
                    <!-- 硫化工人 -->
                    <th data-options="field:'curingworkername',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.curing_worker_s" /></th>
                    <!-- 生产日期 -->
                    <th data-options="field:'product_date_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.product_date_s" /></th>
                    <!-- 生产版本 -->
                    <th data-options="field:'productionver_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.productionver_s" /></th>
                    <!-- 质检状态 -->
                    <th data-options="field:'quality_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.quality_status_s" /></th>
                    <!-- 单位 -->
                    <th data-options="field:'unit_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.unit_s" /></th>
               		<!-- 模具条码 -->
                   <%-- <th data-options="field:'mold_code_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.mold_code_s" /></th>
                    <!-- 胶囊条码 -->
                    <th data-options="field:'capsule_id_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.capsule_id_s" /></th>
                     <!-- 更新人编号 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.changed_by_s" /></th>
                    <!-- 更新时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="patchcuringwork.column.changed_time_t" /></th>
               		 --%>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="PatchCuringWork_search_form" />
		<jsp:param name="datagridId" value="patchcuringwork_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.PatchCuringWorkExportHandler" />
		<jsp:param name="serviceName" value="PatchCuringWorkServiceImpl" />
	</jsp:include>
</body>
</html>
