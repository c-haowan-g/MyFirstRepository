<!-- 

    作者      :时永良
    时间      :2020-12-04 14:58:57 
    页面名称:成型砝码公差维护表
    文件关联:
        ToleranceMaintenance.java
        ToleranceMaintenanceController.java
        ToleranceMaintenanceServiceImpl.java
        ToleranceMaintenanceServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="tolerancemaintenance.js.jsp"%>
<script type="text/javascript" src="dict/252.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ToleranceMaintenance_dg_toolbar">
            <form id="ToleranceMaintenance_search_form" class="form" >
                <!-- 产线名称 -->
                <spring:message code="tolerancemaintenance.column.productionline_s" />
                <input name="filter[productionline_s]" id="productionline_s" type="text" class="easyui-combobox"  
                      data-options="label:'',
                           labelWidth:'auto',
                           panelHeight:200,
                           editable:true,
                           required:false,
                           data:productLineList,
                           valueField:'P_LINE_NAME',
                           textField:'DESCRIPTION',
                           method:'get'" >
                <!-- 砝码标准重量 -->
                <spring:message code="tolerancemaintenance.column.standardweight_s" />
                <input name="filter[standardweight_s]" id="standardweight_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 公差值 -->
                <spring:message code="tolerancemaintenance.column.tolerance_s" />
                <input name="filter[tolerance_s]" id="tolerance_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="tolerancemaintenance_add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="tolerancemaintenance_edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="tolerancemaintenance_save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="tolerancemaintenance_cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="tolerancemaintenance_excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="tolerancemaintenance_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ToleranceMaintenance_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>'  
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 产线名称 -->
                    <th data-options="field:'productionline_s',width:140,formatter:equipmentFormatter,editor:{type:'combobox',options:{ 
										   labelWidth:'auto',
                                           panelHeight:200,
										   required:true,
										   editable:true,
										   disabled:false,
										   data:productLineList,
				                           valueField:'P_LINE_NAME',
				                           textField:'DESCRIPTION'
					                      }}"><spring:message code="tolerancemaintenance.column.productionline_s" /></th>
                    <!-- 砝码标准重量 -->
                    <th data-options="field:'standardweight_s',width:120,editor:{type:'textbox',options:{
							          required:true,
							          editable:true
                                    }}"><spring:message code="tolerancemaintenance.column.standardweight_s" /></th>
                    <!-- 公差值 -->
                    <th data-options="field:'tolerance_s',width:120,editor:{type:'textbox',options:{
							          required:true,
							          editable:true
                                    }}"><spring:message code="tolerancemaintenance.column.tolerance_s" /></th>
                    <!-- 工序 -->
                    <th data-options="field:'spare1_s',width:100,formatter:codeFormatter,editor:{type:'combotree',
                                          options:{
													method:'get',
													required:true,
													url:'dict/code/252'
													
													}}">工序</th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:100"><spring:message code="tolerancemaintenance.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:140"><spring:message code="tolerancemaintenance.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:100"><spring:message code="tolerancemaintenance.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:140"><spring:message code="tolerancemaintenance.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ToleranceMaintenance_search_form" />
		<jsp:param name="datagridId" value="tolerancemaintenance_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.ToleranceMaintenanceExportHandler" />
		<jsp:param name="serviceName" value="ToleranceMaintenanceServiceImpl" />
    </jsp:include> 
</body>
</html>
