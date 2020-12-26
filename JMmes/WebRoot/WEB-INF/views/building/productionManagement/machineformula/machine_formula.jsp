<!-- 

    作者      :whl
    时间      :2019-02-18 13:47:29 
    页面名称:成型工艺配方查询
    文件关联:
        Machine_Formula.java
        Machine_FormulaController.java
        Machine_FormulaServiceImpl.java
        Machine_FormulaServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="machine_formula.js.jsp"%>
<script type="text/javascript" src="dict/189.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'west',split:true" title="<spring:message code="machine_formula.column.cxgypfcs" />" style="width:40%;" >
        <div id="Machine_Formula_dg_toolbar">
        	<form id="Machine_Formula_search_form" class="form" >
        			<tr>
        				<td>
			                <!-- 机台条码 -->
			                <spring:message code="machine_formula.column.equip_code_s" />: 
			                <input name="filter[equip_code_s]" id="equip_code_s" type="text" like="true" class="easyui-combobox" data-options="label:'',
			                	panelHeight:150,
			                	valueField:'EQUIP_CODE_S',
				            	textField:'EQUIP_CODE_S',
				            	required:false,
								editable:'true',
								limitToList:'false',
				            	url:'building/productionManagement/machine_Formula/searchByEquipCode',
				            	method:'get',
				            	width:'130px'
			                " >
        				</td>
        				<td>
			                <!-- 产品阶段 -->
			                <spring:message code="machine_formula.column.production_step_s" />: 
			                <input name="filter[production_step_s]" id="production_step_s" type="text" like="true" class="easyui-combobox" data-options="label:'',
			                	panelHeight:150,
			                	valueField:'PRODUCTION_STEP_S',
				            	textField:'PRODUCTION_STEP_NAME',
				            	required:false,
								editable:'true',
								limitToList:'false',
				            	url:'building/productionManagement/machine_Formula/searchByProductionStep',
				            	method:'get',
				            	width:'90px'
			                " >
        				</td>
        				<br>
        				<td>
        			       <!-- 是否在执行 -->
        			       <spring:message code="formula.column.status" />:
        			        <input name="filter[status_s]" id="status_s" type="text" class="easyui-switchbutton" checked data-options="label:'',onText:'是',offText:'否'">
        			    </td>
        			</tr>
        			<tr>
        			&nbsp;&nbsp;&nbsp;&nbsp;
        				<td>
			                <!-- 胎胚物料编码（SAP品号） -->
			                <spring:message code="machine_formula.column.material_code_s" />: 
			                <input name="filter[material_code_s]" id="material_code_s" type="text" like="true" class="easyui-combobox" data-options="label:'',
			                	panelHeight:150,
			                	valueField:'MATERIAL_CODE_S',
				            	textField:'MATERIAL_CODE_S',
				            	required:false,
								editable:'true',
								limitToList:'false',
				            	url:'building/productionManagement/machine_Formula/searchByMaterialCode',
				            	method:'get',
				            	width:'130px'
			                " >
        				</td>
        					<br>
        				<td>
			                <!-- 胎胚版本号 -->
			                <spring:message code="machine_formula.column.version_s" />: 
			                <input name="filter[version_s]" id="version_s" type="text" class="easyui-combobox" like="true" data-options="label:'',
			                	panelHeight:150,
			                	valueField:'VERSION_S',
				            	textField:'VERSION_S',
				            	required:false,
								editable:'true',
								limitToList:'false',
				            	url:'building/productionManagement/machine_Formula/searchByVersion',
				            	method:'get',
				            	width:'90px'
			                " >
        				</td>
        				
        				<td>
        				 <!-- 机台类型 -->
        				  <spring:message code="formula.column.equip_type_s" />:
        			      <input name="filter[equip_type_s]" id="equip_type_s" type="text" class="easyui-combotree" data-options="label:'', 
                              required:false,
                              data:DICT_189,
                              method:'get'" >
        			   
        			    </td>
        			</tr>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <%-- <auth:button code="machine_formula.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="exportExcel()"><spring:message code="button.export" /></a></auth:button> --%>
            <auth:button code="machine_formula.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="machine_formula_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#Machine_Formula_dg_toolbar',
                striped:true,
                method: 'get' ,
                onSelect:selectrow,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="machine_formula.column.equip_code_s" /></th>
                    <!-- 胎胚物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="machine_formula.column.material_code_s" /></th>
                    <!-- 产品阶段 -->
                    <th data-options="field:'production_step_s',formatter:codematter,editor:{type:'textbox'}"><spring:message code="machine_formula.column.production_step_s" /></th>
                    <!-- 胎胚版本号 -->
                    <th data-options="field:'version_s',editor:{type:'textbox'}"><spring:message code="machine_formula.column.version_s" /></th>
                    <!-- 工艺配方 -->
                    <th data-options="field:'processbom_index_s',editor:{type:'textbox'}"><spring:message code="formula.column.processbom_index_s" /></th>
                  </tr>
            </thead>
        </table>
    </div>
	
	<div data-options="region:'center',split:true" title="<spring:message code="machine_formula.column.pfcxlb" />" style="width:100px;">
 		 <table id="machine_formula_dg2" class="easyui-datagrid" style="width:60%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:false,
                rownumbers: true,
                singleSelect: true,
                striped:true,
                remoteSort:false,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <!-- 参数索引 -->
                    <th data-options="field:'PARAMETER_ID_S',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.parameter_id_s" /></th>
                    <!-- 参数描述 -->
                    <th data-options="field:'PARMTYPE_NAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.parmtype_name_s" /></th>
                    <!-- 参数名 -->
                    <th data-options="field:'PARAMETER_NAME_S',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.parameter_name_s" /></th>
                    <!-- 参数值 -->
                    <th data-options="field:'PARAMETER_PLCVALUE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.parameter_plcvalue_s" /></th>
                    <!-- 参数标准值 -->
                    <th data-options="field:'PARAMETER_STANDARDVALUE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.parameter_standardvalue_s" /></th>
                    <!-- 标准上限 -->
                    <th data-options="field:'PARAMETER_UPPERVALUE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.parameter_uppervalue_s" /></th>
                    <!-- 标准下限 -->
                    <th data-options="field:'PARAMETER_LOWERVALUE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.parameter_lowervalue_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'CHANGED_TIME_T',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.changed_time_t" /></th>
                    <!-- 修改来源 -->
                    <th data-options="field:'ALTER_SOURCE_S',sortable:true,editor:{type:'textbox'}"><spring:message code="machine_formula.column.alter_source_s" /></th>
                </tr>
            </thead>
        </table>
    </div>

</body>
</html>
