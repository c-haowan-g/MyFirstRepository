<!--

作者 :李新宇
时间 :2020-03-04 08:36:33
页面名称:机台信息状态表
文件关联:
Machinestate.java
MachinestateController.java
MachinestateServiceImpl.java
MachinestateServiceImpl.xml
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../../inc/meta.jsp" %>
<%@ include file="machinestate.js.jsp" %>
<script type="text/javascript" src="dict/101,211.js"></script>
<body class="easyui-layout" fit="true">
<div data-options="region:'center',split:true,border:false">
    <div id="Machomestatis_dg_toolbar">
        <form id="Machomestatis_search_form" class="form">
            <!-- 机台条码：需给规则 -->
            <spring:message code="machomestatis.column.machinebarcode_s"/> : <input name="filter[machinebarcode_s]"
                                                                                    id="machinebarcode_s" type="text"
                                                                                    class="easyui-combobox">&nbsp;&nbsp;
            <!-- 设备类型 -->
            <spring:message code="machomestatis.column.machinetype_s"/> : <input name="filter[machinetype_s]"
                                                                                 id="machinetype_s" type="text"
                                                                                 class="easyui-textbox"
                                                                                 data-options="label:''">
            &nbsp;&nbsp;
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'"
               onclick="filter()"><spring:message code="button.search"/></a>
            <auth:button code="MACHINESTATUS_EXPORT"><a class="easyui-linkbutton btn-deep-blue"
                                                        data-options="iconCls:'icon-excel'"
                                                        onclick="$_export()"><spring:message code="button.export"/></a></auth:button>
        </form>
    </div>
    <table id="machomestatis_dg" class="easyui-datagrid" style="width:100%">
        <thead>
        <tr>
            <th data-options="field:'atr_key',checkbox:true">ID</th>
            <!-- 机台条码 -->
            <th data-options="width:'10%',field:'machinebarcode_s',editor:{type:'textbox'}"><spring:message
                    code="machomestatis.column.machinebarcode_s"/></th>
            <!-- 设备类型 -->
            <th formatter="codeFormatter" data-options="width:'10%',field:'machinetype_s',editor:{type:'textbox'}">
                <spring:message code="machomestatis.column.machinetype_s"/></th>
            <!-- 机台状态-->
            <th formatter="codeFormatter" data-options="width:'10%',field:'machinestatus_s',editor:{type:'textbox'}">
                <spring:message code="machomestatis.column.machinestatus_s"/></th>
            <!-- 当前物料名称 -->
            <th data-options="width:'20%',field:'materialname_s',editor:{type:'textbox'}"><spring:message
                    code="machomestatis.column.materialname_s"/></th>
            <!-- 是否有口型版 -->
            <th formatter="isplateFormatter" data-options="width:'10%',field:'isplate_s',editor:{type:'textbox'}"><spring:message
                    code="machomestatis.column.isplate_s"/></th>
            <!-- 物料版本 -->
            <th data-options="width:'10%',field:'productiongver_s',editor:{type:'textbox'}"><spring:message
                    code="machomestatis.column.productiongver_s"/></th>
            <!-- 墊布层数 -->
            <th data-options="width:'10%',field:'clothliner_s',editor:{type:'textbox'}"><spring:message
                    code="machomestatis.column.clothliner_s"/></th>
            <!-- 产出打印数量 -->
            <th data-options="width:'10%',field:'printquantity_s',editor:{type:'textbox'}"><spring:message
                    code="machomestatis.column.printquantity_s"/></th>
            <!-- 生产模式 ：0单条或 1批量 -->
            <th formatter="producttypeFormatter"
                data-options="width:'10%',field:'producttype_s',editor:{type:'textbox'}"><spring:message
                    code="machomestatis.column.producttype_s"/></th>

        </tr>
        </thead>
    </table>
</div>

<jsp:include page="../../../../inc/export.jsp">
    <jsp:param name="idField" value="atr_key"/>
    <jsp:param name="formId" value="Machomestatis_search_form"/>
    <jsp:param name="datagridId" value="machomestatis_dg"/>
    <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.MachinestateExportHandler"/>
    <jsp:param name="serviceName" value="MachomestatisServiceImpl"/>
</jsp:include>
</body>
</html>
