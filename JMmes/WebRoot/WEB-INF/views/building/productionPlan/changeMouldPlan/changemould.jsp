<!-- 

    作者      :whl
    时间      :2019-03-08 13:58:56 
    页面名称:换工装计划表
    文件关联:
        ChangeMould.java
        ChangeMouldController.java
        ChangeMouldServiceImpl.java
        ChangeMouldServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="changemould.js.jsp"%>
<script type="text/javascript" src="dict/170.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false">
        <div id="ChangeMould_dg_toolbar">
            <form id="ChangeMould_search_form" class="form">
                <!-- 成型日计划号 -->
                <spring:message code="changemould.column.production_plan_no_s"/>
                :&emsp;<input name="filter[production_plan_no_s]" id="production_plan_no_s" type="text" class="easyui-combobox" 
                                          data-options="label:'',
                                          panelHeight:200,
                                          required:false,
                                          editable:'true',
                                          url:'building/productionplan/changemould/searchMoldDailyPlanCode',
                                          valueField:'PLAN_NO_S', 
                                          textField:'PLAN_NO_S',  
                                          method:'get',
                                          icons:[{iconCls:'icon-clear',
					                      handler:clearPlan}]">
                <!-- 产线条码  -->
                 &emsp;<spring:message code="changemould.column.equip_code_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" 
                                          data-options="label:'',
                                          panelHeight:200,
										  required:false,
										  editable:'true',
										  url:'building/basedata/productline/getProductline?process_s=252005',
										  valueField:'p_line_name',
                              			  textField:'p_line_name',
										  method:'get',
										  icons:[{iconCls:'icon-clear',
					                      handler:clearEquip}]">  
                <!-- 胎胚物料编码（SAP品号） -->
                 &emsp;<spring:message code="changemould.column.material_code_s" />
                :&emsp;<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-combobox" 
                                          data-options="label:'',
                                          panelHeight:200,
										  required:false,
										  editable:'true',
										  url:'Part/halbMaterialListForDay',
										  valueField: 'PART_NUMBER',
                              			  textField: 'PART_NUMBER',
										  method:'get',
										  icons:[{iconCls:'icon-clear',
					                      handler:clearMaterial}]">              
                <br>
                <!-- 换工装日期 -->
                 <spring:message code="changemould.column.changetime_s" />
				:&emsp;&emsp;<input name="filter[changetime_s]" id="changetime_s" type="text" class="easyui-datebox" 
				                    data-options="onChange:filter,formatter:dateFormat,parser:dateParser,label:''"> 
				                    
				<script type="text/javascript">
                $("#changetime_s").val(new Calendar().format("yyyyMMdd"));
                </script>
               
                &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_PLAN_CHANGEMOULD_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <%-- 
            <auth:button code="CX_PLAN_CHANGEMOULD_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            --%>
            <auth:button code="CX_PLAN_CHANGEMOULD_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="CX_PLAN_CHANGEMOULD_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            &emsp;
            <auth:button code="CX_PLAN_CHANGEMOULD_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-cancel'" onclick="cancel()"><spring:message code="button.cancel" /></a></auth:button>
            <auth:button code="CX_PLAN_CHANGEMOULD_AUDIT"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-shenhe'" onclick="audit()"><spring:message code="button.audit" /></a></auth:button>
            <auth:button code="CX_PLAN_CHANGEMOULD_CANCELAUDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-fanshenhe'" onclick="cancelAudit()"><spring:message code="button.cancelAudit" /></a></auth:button>
           <%--  <auth:button code="CX_PLAN_CHANGEMOULD_CLOSE"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-clear'" onclick="offPlan()"><spring:message code="button.close" /></a></auth:button> --%>
            <auth:button code="CX_PLAN_CHANGEMOULD_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            &emsp;
            <auth:button code="CX_PLAN_CHANGEMOULD_HIDE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="changemould_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ChangeMould_dg_toolbar',
                striped:true,
                method: 'get',
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 顺序号 -->
                    <th data-options="field:'plan_queue_s',editor:{type:'textbox'}"><spring:message code="changemould.column.plan_queue_s" /></th>
                    <!-- 换工装计划编号 -->
                    <th data-options="required:true,field:'plan_no_s'"><spring:message code="changemould.column.plan_no_s" /></th>
                    <!-- 机台编码-->
                    <th data-options="field:'equip_code_s',width:140,editor:{type:'combobox',options:{
                                          panelHeight:200,
										  required:true,
										  editable:'false',
										  url:'building/basedata/productline/getProductline?process_s=252005',
										  valueField:'p_line_name',
                              			  textField:'p_line_name',
                              			  onSelect:onMoldDaliyCodeSelect}}"><spring:message code="changemould.column.equip_code_s" /></th>
                    <!-- 成型日计划号 -->
                    <th data-options="field:'production_plan_no_s',width:170,editor:{type:'combobox',options:{
                                          panelHeight:200,
                    					  required:true,
										  editable:'false',
                                          valueField:'PLAN_NO_S',
                              			  textField:'PLAN_NO_S',
                              			  onSelect:onPlanNoSelect}}"><spring:message code="changemould.column.production_plan_no_s" /></th>
                     <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:100,editor:{type:'textbox',options:{
					    required:true,
					     editable:false
					    }}"><spring:message code="changemould.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:170,editor:{type:'textbox',options:{
					    required:true,
					     editable:false
					    }}"><spring:message code="changemould.column.material_name_s" /></th>
                    <!-- 换工装计划状态 -->
                    <th data-options="field:'plan_status_s',formatter:codeFormatter"><spring:message code="changemould.column.plan_status_s" /></th>
                    <!-- 审核人 -->
                    <th data-options="field:'auditbyname'"><spring:message code="changemould.column.audit_by_s" /></th>
                    <!-- 审核时间 -->
                    <th data-options="field:'audit_time_t'"><spring:message code="changemould.column.audit_time_t" /></th>
                    <!-- 更换人 -->
                    <th data-options="field:'changebyname'"><spring:message code="changemould.column.changed_by_s" /></th>
                    <!-- 换工装执行开始时间 -->
                    <th data-options="field:'excute_begintime_t'"><spring:message code="changemould.column.excute_begintime_t" /></th>
                    <!-- 换工装执行结束时间 -->
                    <th data-options="field:'excute_time_t'"><spring:message code="changemould.column.excute_time_t" /></th>
                  </tr>
            </thead>
        </table>
   </div>
   <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ChangeMould_search_form" />
		<jsp:param name="datagridId" value="changemould_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.ChangeMouldExportHandler" />
		<jsp:param name="serviceName" value="ChangeMouldServiceImpl" />
    </jsp:include> 
</body>
</html>
