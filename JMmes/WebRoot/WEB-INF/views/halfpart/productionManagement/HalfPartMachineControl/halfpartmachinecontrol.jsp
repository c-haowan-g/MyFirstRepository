<!-- 

    作者      :李新宇
    时间      :2020-03-05 11:15:54 
    页面名称:机台控制管理
    文件关联:
        Machinestate.java
        HalfPartMachineControlController.java
        HalfPartMachineControlServiceImpl.java
        HalfPartMachineControlServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="halfpartmachinecontrol.js.jsp"%>
<script type="text/javascript"  src="dict/101,119,252,211.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Machomestatis_dg_toolbar">
            <form id="search_form" class="form" >
                <spring:message code="machomestatis.column.machinebarcode_s"/> : <input name="filter[machinebarcode_s]"
                                                                                        id="machinebarcode_s" type="text"
                                                                                        class="easyui-combobox">&nbsp;&nbsp;
<%--                <!-- 设备类型 -->--%>
<%--                <spring:message code="machomestatis.column.machinetype_s"/> : <input name="filter[machinetype_s]"--%>
<%--                                                                                     id="machinetype_s" type="text"--%>
<%--                                                                                     class="easyui-textbox">--%>
            </form>
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="halfpartcontrol.logFile"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-save'" onclick="log()"><spring:message code="button.logFile" /></a></auth:button>
            <auth:button code="halfpartcontrol.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <div style="margin-top: 4px">
                <table id="control_button"></table>
            </div>
        </div>

        <table id="machomestatis_dg" class="easyui-datagrid" style="width:100%">
            <thead>
                <tr>
                </tr>
            </thead>
        </table>

    </div>

    <div id="win" class="easyui-dialog" title="机台日志"  style="width: 700px; height: 500px;"
         closed="true" >
        <table id="halfpart_log" class="easyui-datagrid">
            <thead>
                <tr>
                </tr>
            </thead>
        </table>
    </div>



    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key"/>
        <jsp:param name="formId" value="search_form"/>
        <jsp:param name="datagridId" value="machomestatis_dg"/>
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.HalfPartMachineControlExportHandler"/>
        <jsp:param name="serviceName" value="HalfPartMachineControlServiceImpl"/>
    </jsp:include>
</body>
</html>
