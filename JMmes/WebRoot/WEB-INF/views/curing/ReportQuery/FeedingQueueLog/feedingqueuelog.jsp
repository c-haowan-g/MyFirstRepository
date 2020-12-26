<!-- 

    作者      :李新宇
    时间      :2020-02-20 15:23:30 
    页面名称:硫化扫描日志
    文件关联:
        FeedingQueueLog.java
        FeedingQueueLogController.java
        FeedingQueueLogServiceImpl.java
        FeedingQueueLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="feedingqueuelog.js.jsp"%>
<script type="text/javascript" src="dict/213.js"></script>
<body class="easyui-layout" fit="true">
    <div data-options="region:'center',split:true,border:false" >
        <div id="FeedingQueueLog_dg_toolbar">
            <form id="FeedingQueueLog_search_form" class="form" >
                <!-- 机台编号 -->
                <spring:message code="feedingqueuelog.column.equip_code_s" />:<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-textbox" data-options="" >
                <!-- 胎胚编码 -->
                &nbsp;&nbsp;&nbsp;<spring:message code="workorderresult.column.tyre_barcode_s" />:<input name="filter[tyrebar_code_s]" id="tyrebar_code_s" type="text" class="easyui-textbox" data-options="" >
                <!-- 投料时间 -->
                &nbsp;&nbsp;&nbsp;<spring:message code="feedingqueuelog.column.scanning_time_t" />:<input name="filter[scanning_time_s]" id="scanning_time_s" type="text" class="easyui-datetimebox" data-options="" >
                <spring:message code="tip.to" />:<input name="filter[scanning_time_end]" id="scanning_time_end" type="text" class="easyui-datetimebox" data-options="" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form>

        </div>
        <table id="feedingqueuelog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#FeedingQueueLog_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 机台条码 -->
                    <th data-options="width:'15%',field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="feedingqueuelog.column.equip_code_s" /></th>
                    <!-- 胎胚条码 -->
                    <th data-options="width:'20%',field:'tyrebar_code_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.tyre_barcode_s" /></th>
                    <!-- 状态 300501、待硫化 300502、硫化中 -->
                    <th formatter="codeFormatter" data-options="
			                 method:'get',
			                 url:'dict/code/213'
			                 ,width:'15%',field:'status_s',editor:{type:'textbox'}"><spring:message code="feedingqueuelog.column.status_s" /></th>
                    <!-- 投料人 -->
                    <th data-options="width:'20%',field:'created_by_s',editor:{type:'textbox'}"><spring:message code="feedingqueuelog.column.feeder" /></th>
                    <!-- 投料时间 -->
                    <th data-options="width:'20%',field:'scanning_time_t',editor:{type:'textbox'}"><spring:message code="feedingqueuelog.column.scanning_time_t" /></th>
                    <!-- 投料时间 -->
                    <th data-options="width:'20%',field:'product_operator_s',editor:{type:'textbox'}"><spring:message code="feedingqueuelog.column.product_operator_s" /></th>
                </tr>
            </thead>
        </table>
    </div>

    <jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="FeedingQueueLog_search_form" />
        <jsp:param name="datagridId" value="feedingqueuelog_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.FeedingQueueLogExportHandler" />
        <jsp:param name="serviceName" value="FeedingQueueLogServiceImpl" />
    </jsp:include>
</body>
</html>
