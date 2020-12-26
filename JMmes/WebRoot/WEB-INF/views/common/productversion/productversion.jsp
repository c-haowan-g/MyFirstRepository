<!-- 

    作者      :刘朋
    时间      :2018-09-22 16:49:09 
    页面名称:SAP下发生产版本
    文件关联:
        ProductVersion.java
        ProductVersionController.java
        ProductVersionServiceImpl.java
        ProductVersionServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="productversion.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProductVersion_dg_toolbar">
            <form id="ProductVersion_search_form" class="form" >
                <!-- 物料编号 -->
                <spring:message code="productversion.column.material_code_s" />:<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 生产版本号 -->
                <spring:message code="productversion.column.production_ver_s" />:<input name="filter[production_ver_s]" id="production_ver_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 接收时间 -->
                <%--  <spring:message code="productversion.column.receive_time_t" />:
                <input name="filter[start_opertime_t]" id="start_opertime_t"  class="easyui-datetimebox" data-options="label:''" >
                <spring:message code="tip.to" /><input name="filter[end_opertime_t]" id="end_opertime_t"  class="easyui-datetimebox"  > --%>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <%-- <auth:button code="SYS_JCSJCX_PRODUCTVERSION_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="productversion_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ProductVersion_dg_toolbar',
                url: 'sap/common/productversion/datagridUDA',
                striped:true,
                method: 'get' ,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 物料编号80位 -->
                    <th data-options="field:'material_code_s',width:80,editor:{type:'textbox'}"><spring:message code="productversion.column.material_code_s" /></th>
                    <!-- 物料状态 -->
                    <th data-options="field:'matstatus_s',width:80,editor:{type:'textbox'}"><spring:message code="productversion.column.matstatus_s" /></th>
                    <!-- 生产版本状态,1代表锁定，空值‘’代表未锁定 -->
                    <th data-options="field:'mksp_s',width:80,editor:{type:'textbox'}"><spring:message code="productversion.column.mksp_s" /></th>
                    <!-- 生产版本号 -->
                    <th data-options="field:'despritioner',width:80,editor:{type:'textbox'}">物料描述</th>
                    <!-- 生产版本号 -->
                    <th data-options="field:'production_ver_s',width:80,editor:{type:'textbox'}"><spring:message code="productversion.column.production_ver_s" /></th>
                    <!-- 成本收集器状态（KA允许报产） -->
                    <th data-options="field:'cost_col_status_s',width:80,editor:{type:'textbox'}"><spring:message code="productversion.column.cost_col_status_s" /></th>
                    <!-- 版本描述 -->
                    <th data-options="field:'verdesc_s',width:180,editor:{type:'textbox'}"><spring:message code="productversion.column.verdesc_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="productversion.column.receive_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
