<!--

作者 :李新宇
时间 :2020-02-24 08:38:10
页面名称:X光质检信息表
文件关联:
CheckXrayResult.java
CheckXrayResultController.java
CheckXrayResultServiceImpl.java
CheckXrayResultServiceImpl.xml
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../../inc/meta.jsp" %>
<%@ include file="checkxrayresult.js.jsp" %>
<script type="text/javascript" src="dict/253,302.js"></script>
<body class="easyui-layout" fit="true">
<div data-options="region:'center',split:true,border:false">
    <div id="CheckXrayResult_dg_toolbar">
        <form id="CheckXrayResult_search_form" class="form">
            <!-- 检测时间开始 -->
            <spring:message code="checkxrayresult.column.checktime_s"/>: <input name="filter[checktime_start]"
                                                                                id="checktime_start" type="text"
                                                                                class="easyui-textbox" data-options="">
            <!-- 检测时间结束 -->
            <spring:message code="tip.to"/>: <input name="filter[checktime_end]"
                                                                                id="checktime_end" type="text"
                                                                                class="easyui-textbox" data-options="">
            &nbsp;&nbsp;
            <!-- 条码号 -->
            <spring:message code="checkxrayresult.column.tyrebarcode_s"/>: <input name="filter[tyrebarcode_s]"
                                                                                  id="tyrebarcode_s" type="text"
                                                                                  class="easyui-textbox"
                                                                                  data-options="">
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'"
               onclick="filter()"><spring:message code="button.search"/></a>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'"
                                       onclick="$_export()"><spring:message code="button.export"/></a></auth:button>
        </form>
    </div>
    <table id="checkxrayresult_dg" class="easyui-datagrid" style="width:100%"
           data-options="
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#CheckXrayResult_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
        <thead>
        <tr>
            <th data-options="field:'atr_key',checkbox:true">ID</th>
            <!-- 设备ID -->
            <th data-options="width:'15%',field:'equipid_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.equipid_s"/></th>
            <!-- 条码号 -->
            <th data-options="width:'20%',field:'tyrebarcode_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.tyrebarcode_s"/></th>
            <!-- 检测等级 -->
            <th formatter="codeFormatter" data-options="width:'10%',field:'gradeid_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.gradeid_s"/></th>
            <!-- 检查次数 -->
            <th data-options="width:'10%',field:'checkseq_i',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.checkseq_i"/></th>
            <!-- 检测时间 -->
            <th data-options="width:'25%',field:'checktime',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.checktime_s"/></th>
            <!-- 检测人员ID -->
            <th data-options="width:'10%',field:'username',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.userid_s"/></th>
            <!-- 检测人员班次 -->
            <th formatter="codeFormatter" data-options="width:'10%',field:'usershift_s',editor:{type:'textbox'}"><spring:message
                    code="checkxrayresult.column.usershift_s"/></th>
        </tr>
        </thead>
    </table>

</div>

<jsp:include page="../../../../inc/export.jsp">
    <jsp:param name="idField" value="atr_key"/>
    <jsp:param name="formId" value="CheckXrayResult_search_form"/>
    <jsp:param name="datagridId" value="checkxrayresult_dg"/>
    <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.CheckXrayResultExportHandler"/>
    <jsp:param name="serviceName" value="CheckXrayResultServiceImpl"/>
</jsp:include>
</body>
</html>
