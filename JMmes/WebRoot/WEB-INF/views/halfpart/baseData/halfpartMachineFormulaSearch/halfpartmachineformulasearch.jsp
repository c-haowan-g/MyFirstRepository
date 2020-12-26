<!-- 

    作者      :李德晓
    时间      :2020-03-11 15:06:47 
    页面名称:半部件机台工艺参数查询
    文件关联:
        halfpartMachineFormulaSearch.java
        halfpartMachineFormulaSearchController.java
        halfpartMachineFormulaSearchServiceImpl.java
        halfpartMachineFormulaSearchServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="halfpartmachineformulasearch.js.jsp"%>
<<script type="text/javascript" src="dict/-308.js"></script>
<script type="text/javascript" src="dict/104,-118,328.js"></script>
<<script type="text/javascript" src="dict/-307.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="halfpartMachineFormulaSearch_dg_toolbar">
            <form id="halfpartMachineFormulaSearch_search_form" class="form" >
               
                 <!-- 机台名称 -->
                <spring:message code="machinecontrol.column.equip_name_s" />:
                <input name="filter[equip_code_s]" id="equip_code_s" style="width:150px" type="text" class="easyui-combobox"
                	data-options="label:'',
                        url:'halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch/searchEquip_code_s',
                        labelWidth:'auto',
                        panelHeight:200,
                        data:productLineList,
                        editable:true,
                        required:false,
                        valueField:'P_LINE_NAME',
          			    textField:'DESCRIPTION',
                        method:'get'"
                 >&nbsp;&nbsp;&nbsp;
                <!-- 物料编码（SAP品号） -->
                <spring:message code="machine_formula.column.material_code_s" />:
                <input name="filter[material_code_s]" id="material_code_s" style="width:150px" type="text" class="easyui-combobox" 
               data-options="label:'',
                        url:'halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch/searchMaterial_code_s', 
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        data:materialGroupList,
                        required:false,
          			    valueField:'MATERIALCODE_S',
          			    textField:'MATERIALCODE_S',
                        method:'get'"
                 >&nbsp;&nbsp;&nbsp;
                  <!-- 版本号 -->
                 <spring:message code="route.column.version" />:
                  <input name="filter[version_s]" id="version_s" type="text" class="easyui-textbox" style="width:150px" data-options="label:''" ><br>
                <!-- 产品阶段 -->
                <spring:message code="halfpartmachineformulasearch.column.production_step_s" />:
                <input name="filter[production_step_s]" id="production_step_s" style="width:150px" type="text" class="easyui-combobox" 
                data-options="label:'',
                       url:'halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch/searchProduction_step_s',
                        labelWidth:'auto',
                        panelHeight:200,
                        data:production_step_sList,
                        editable:true,
                        required:false,
                        valueField:'DICTCODE_S',
          			    textField:'DICTNAME_S',
                        method:'get'"
                 >&nbsp;&nbsp;&nbsp;
                <!-- 物料名称 -->
                <spring:message code="productiondayplan.column.material_desc_s" />:
                <input name="filter[material_desc_s]" id="material_desc_s" style="width:150px" type="text" class="easyui-combobox" 
                data-options="label:'',
                        url:'halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch/searchMaterial_desc_s',
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        required:false,
                        valueField:'MATDESCFULL_S',
          			    textField:'MATDESCFULL_S',
                        method:'get'"
                 >
            
            </form> 
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="hmfs_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="hmfs_search_hide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="halfpartmachineformulasearch_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                url :'halfpart/halfpartMachineFormulaSearch/halfpartmachineformulasearch/datagrid',
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#halfpartMachineFormulaSearch_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'',checkbox:true">ID</th>
                     <!-- 机台名称 -->
                    <th data-options="field:'equip_code_s',formatter:equipmentcodeFormatter,sortable:true,editor:{type:'textbox'}"><spring:message code="machinecontrol.column.equip_name_s" /></th>
                    <!-- 参数类型名称 -->
                    <th data-options="field:'parmtypename_s',editor:{type:'textbox'}"><spring:message code="formla.column.parmtypename_s" /></th>
                    <!-- 工艺参数名称 -->
                    <th data-options="field:'parameter_name_s',editor:{type:'textbox'}"><spring:message code="tolerancepara.column.parmname_s" /></th>
                    <!-- 工艺参数标准值 -->
                    <th data-options="field:'parameter_standardvalue_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineformulasearch.column.parameter_standardvalue_s" /></th>
                    <!-- 工艺参数上限值 -->
                    <th data-options="field:'parameter_uppervalue_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineformulasearch.column.parameter_up" /></th>
                    <!-- 工艺参数下限值 -->
                    <th data-options="field:'parameter_lowervalue_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineformulasearch.column.parameter_down" /></th>
                    <!-- 工艺参数PLC值 -->
                    <th data-options="field:'parameter_plcvalue_s',editor:{type:'textbox'}"><spring:message code="plc_value_plc" /></th>
                    <!-- 物料编码（SAP品号） -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineformulasearch.column.material_code_s" /></th>
                    <!-- 产品阶段 -->
                    <th data-options="field:'production_step_s',formatter:production_step_sFormatter,sortable:true,editor:{type:'textbox'}"><spring:message code="halfpartmachineformulasearch.column.production_step_s" /></th>
                    <!-- 版本号 -->
                    <th data-options="field:'version_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineformulasearch.column.version_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="halfpartmachineformulasearch.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="halfpartmachineformulasearch.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="halfpartMachineFormulaSearch_search_form" />
		<jsp:param name="datagridId" value="halfpartmachineformulasearch_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.HalfpartMachineFormulaSearchExportHandler" />
		<jsp:param name="serviceName" value="HalfpartMachineFormulaSearchServiceImpl.java" />
	</jsp:include>
</body>
</html>
