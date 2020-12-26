<!-- 

    作者      :孙尊龙
    时间      :2020-05-04 11:48:45 
    页面名称:取消硫化作业履历表
    文件关联:
        CuringCancelWork.java
        CuringCancelWorkController.java
        CuringCancelWorkServiceImpl.java
        CuringCancelWorkServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="curingcancelwork.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="CuringCancelWork_dg_toolbar">
            <form id="CuringCancelWork_search_form" class="form" >
<%--                <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 荆门 8023 -->--%>
<%--                <input name="filter[agenc_no_s]" id="agenc_no_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="curingcancelwork.column.agenc_no_s" />'" >--%>
                <!-- 取消硫化操作时间 -->
                <td class="columnTitle">
                    <spring:message code="curingcancelwork.column.curing_cancel_time_t" />:
                    <!-- 操作时间 -->
                    <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
                           type="text" class="easyui-datetimebox" style="width:165px"
                           data-options="label:''">
                    到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
                             class="easyui-datetimebox" style="width:165px">
                </td>

                <!-- 轮胎条码 -->
                <td class="columnTitle">
                    <spring:message code="curingcancelwork.column.tyrebarcode_s" />
                    <input name="filter[tyrebarcode_s]" id="tyrebarcode_s" type="text" class="easyui-textbox" style="width:140px" data-options="label:''" >
                </td>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
<%--                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a>--%>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a>

            </form>
        </div>
        <table id="curingcancelwork_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CuringCancelWork_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',

                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyrebarcode_s',width:120,editor:{type:'textbox'}"><spring:message code="curingcancelwork.column.tyrebarcode_s" /></th>
                    <!-- 机台编号 -->
                    <th data-options="field:'equip_code_s',width:120,editor:{type:'textbox'}"><spring:message code="detial.column.equip_code_s" /></th>
                    <!-- 硫化工人 -->
                    <th data-options="field:'curing_worker_s',width:120,editor:{type:'textbox'}"><spring:message code="curingcancelwork.column.curing_worker_s" /></th>
                    <!-- 硫化开始时间 -->
                    <th data-options="field:'curing_state_time_t',width:120,editor:{type:'textbox'}"><spring:message code="curingcancelwork.column.curing_state_time_t" /></th>
                    <!-- 取消硫化操作时间 -->
                    <th data-options="field:'curing_cancel_time_t',width:120,editor:{type:'textbox'}"><spring:message code="curingcancelwork.column.curing_cancel_time_t" /></th>
                    <!-- 操作人 -->
                    <th data-options="field:'operator_s',width:120,editor:{type:'textbox'}"><spring:message code="curingcancelwork.column.operator_s" /></th>

                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="CuringCancelWork_search_form" />
        <jsp:param name="datagridId" value="curingcancelwork_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CuringCancelWorkExportHandler" />
        <jsp:param name="serviceName" value="CuringCancelWorkServiceImpl" />
    </jsp:include>
</body>
</html>
