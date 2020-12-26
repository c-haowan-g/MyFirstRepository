<!-- 

    作者      :whl
    时间      :2019-03-18 09:12:58 
    页面名称:角色功能对应表
    文件关联:
        RoleMethod.java
        RoleMethodController.java
        RoleMethodServiceImpl.java
        RoleMethodServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="rolemethod.js.jsp"%>
<script type="text/javascript" src="dict/-171.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="RoleMethod_dg_toolbar">
            <form id="RoleMethod_search_form" class="form" >
                  <!-- 角色名称 -->
                <spring:message code="rolemethod.column.role_name_s" />
                :&emsp;<input name="filter[role_name_s]"  id="role_name_s" type="text" class="easyui-combobox" 
                                          data-options="label:'',
                                          labelWidth:'auto',
                                          panelHeight:200,
                                          editable:'false',
										  required:false,
										  url:'roleMethodUrl/searchRoleName',
    								      valueField:'NAME', 
                                          textField:'NAME', 
										  method:'get'">   
				<!-- 功能名称 -->
                 &emsp;<spring:message code="rolemethod.column.method_name_s" />
                :&emsp;<input name="filter[method_name_s]"  id="method_name_s" type="text" class="easyui-combotree" 
                                          data-options="label:'',
                                          labelWidth:'auto',
                                          panelHeight:200,
                                          editable:'false',
										  required:false,
										  url:'dict/code/171',
										  method:'get'"> 
                &emsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_JCSJ_ROLEMETHOD_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="CX_JCSJ_ROLEMETHOD_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CX_JCSJ_ROLEMETHOD_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="CX_JCSJ_ROLEMETHOD_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CX_JCSJ_ROLEMETHOD_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="CX_JCSJ_ROLEMETHOD_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="CX_JCSJ_ROLEMETHOD_HIDE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
       
        </div>
        <table id="rolemethod_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#RoleMethod_dg_toolbar',
                url:'roleMethodUrl/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 角色名称 -->
                    <th data-options="field:'role_name_s',width:80,editor:{type:'combobox',
                                 options:{
                                          panelHeight:200,
                                          editable:false,
										  required:true,
										  url:'roleMethodUrl/searchRoleName',
										  valueField:'NAME',
                              			  textField:'NAME',
                              			  onSelect:onRoleIDSelect
                       }}"><spring:message code="rolemethod.column.role_name_s" /></th>
                    <!-- 角色ID -->
                    <th data-options="field:'role_id_s',width:80,editor:{type:'textbox',
                                 options:{
                                          panelHeight:200,
                                          editable:false,
										  required:true
                       }}"><spring:message code="rolemethod.column.role_id_s" /></th>
                    <!-- 功能名称 -->
                    <th data-options="field:'method_name_s',width:120,editor:{type:'combobox',
                        options:{
                                          panelHeight:200,
                                          editable:false,
										  required:true,
										  url:'roleMethodUrl/searchMethodName',
										  valueField:'DICTNAME_S',
                              			  textField:'DICTNAME_S',
                              			  onSelect:onMethodCodeSelect
                       }}"><spring:message code="rolemethod.column.method_name_s" /></th>
                    <!-- 功能代码 -->
                    <th data-options="field:'method_code_s',width:80,editor:{type:'textbox',
                          options:{
                                          panelHeight:200,
                                          editable:false,
										  required:true
                       }}"><spring:message code="rolemethod.column.method_code_s" /></th>

                    <!-- 创建人 -->
                    <th data-options="field:'create_name',width:80"><spring:message code="rolemethod.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:80"><spring:message code="rolemethod.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_name',width:80"><spring:message code="rolemethod.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:80"><spring:message code="rolemethod.column.changed_time_t" /></th>

                </tr>
            </thead>
        </table>
    </div>
        <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="RoleMethod_search_form" />
		<jsp:param name="datagridId" value="rolemethod_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.RoleMethodExportHandler" />
		<jsp:param name="serviceName" value="RoleMethodServiceImpl" />
    </jsp:include> 
</body>
</html>
