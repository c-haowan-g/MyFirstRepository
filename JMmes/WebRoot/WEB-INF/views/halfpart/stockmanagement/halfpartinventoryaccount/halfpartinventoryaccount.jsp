<!--

作者 :李新宇
时间 :2020-03-12 08:17:06
页面名称:(半部件)库存台账
文件关联:
HalfPartInventoryAccountController.java
HalfPartInventoryAccountServiceImpl.java
HalfPartInventoryAccountServiceImpl.xml
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ include file="../../../../inc/meta.jsp" %>
<%@ include file="halfpartinventoryaccount.js.jsp" %>
<script type="text/javascript"  src="dict/106,305,112,308.js"></script>
<body class="easyui-layout" fit="true">
<div data-options="region:'center',split:true,border:false">
    <div id="Ledger_dg_toolbar">
        <form id="Ledger_search_form" class="form">
            <div>
                <!-- 物料编码 -->
                <spring:message code="ledger.column.materielcode_s"/> : <input name="filter[materielcode_s]"
                                                                               id="materielcode_s" type="text"
                                                                               class="easyui-textbox"
                                                                               data-options="label:''">&nbsp;&nbsp;&nbsp;
                是否过期 : <input name="filter[expire]" type="text" class="easyui-combobox" id="expire">&nbsp;&nbsp;&nbsp;
                <!-- 质量状态 基础数据106 -->
                <spring:message code="ledger.column.quality_status_s"/> : <input name="filter[quality_status_s]"
                                                                                 id="quality_status_s" type="text" style="width: 100px">
                <!-- 过期时间 -->
                <spring:message code="ledger.column.outputtime_t"/> : <input name="filter[start_time]" id="start_time"
                                                                          type="text" class="easyui-datebox">
                <spring:message code="tip.to"/> : <input name="filter[end_time]" id="end_time"
                                                                          type="text" class="easyui-datebox">
            </div>
            <div style="margin-top: 5px">
                <!-- 库存类型 基础数据112  -->
                <spring:message code="ledger.column.stocktype_s"/> : <input name="filter[stocktype_s]" id="stocktype_s"
                                                                            type="text" class="easyui-textbox"
                                                                            data-options="label:''" style="width: 100px">&nbsp;&nbsp;&nbsp;
                <spring:message code="ledger.column.vehicles_code_s"/> : <input name="filter[vehicles_code_s]"
                                                                                id="vehicles_code_s" type="text"
                                                                                class="easyui-textbox" style="width: 100px">&nbsp;&nbsp;&nbsp;
                <!-- 物料组 基础数据308 -->
                <spring:message code="ledger.column.m_group_s"/> : <input name="filter[m_group_s]" id="m_group_s"
                                                                          type="text" style="width: 180px">&nbsp;&nbsp;
                <!-- 是否申请延期 0 否 1 是  -->
                <spring:message code="ledger.column.isrequest_s"/> : <input name="filter[isrequest_s]" id="isrequest_s"
                                                                            type="text" class="easyui-textbox" style="width: 20px">&nbsp;&nbsp;&nbsp;
                <!-- 距超期时间H  -->
                <spring:message code="ledger.column.overdue_time"/> : <input name="filter[overdue_time]"
                                                                                id="overdue_time" type="text"
                                                                                class="easyui-textbox" style="width: 100px">
            </div>
        </form>
        <div style="margin-bottom: 5px">
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'"
               onclick="filter()"><spring:message code="button.search"/></a>
            <auth:button code="LENGER_OUTTIME_BUTTON"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-add'"
                                                         onclick="Apply()">超期申请</a></auth:button>
            <auth:button code="LENGER_CHANGETIME_BUTTON"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-add'"
                                                            onclick="handle()">延期处理</a> </auth:button>
            <auth:button code="LENGER_EXPORT_BUTTON"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'"
                                                        onclick="$_export()"><spring:message code="button.export"/></a></auth:button>
        </div>
    </div>
    <table id="ledger_dg" class="easyui-datagrid" style="width:100%"
           data-options="
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Ledger_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
        <thead>
        <tr>
            <th data-options="field:'atr_key',checkbox:true">ID</th>
            <!-- 条码号 -->
            <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.barcode_s"/></th>
            <!-- 物料组 基础数据308 -->
            <th formatter="codeFormatter" data-options="field:'m_group_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.m_group_s"/></th>
            <!-- 物料编码 -->
            <th data-options="field:'materielcode_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.materielcode_s"/></th>
            <!-- 物料名称 -->
            <th data-options="field:'materielname_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.materielname_s"/></th>
            <!-- 载具条码 -->
            <th data-options="field:'vehicles_code_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.vehicles_code_s"/></th>
            <!-- 产出初始数量/长度 /重量(半部件产出) -->
            <th data-options="field:'yl_num_f',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.yl_num_f"/></th>
            <!-- 当前剩余 数量/长度/ 重量 -->
            <th data-options="field:'l_num_f',width:80,editor:{type:'textbox'}"><spring:message 
            	code="lenger.column.l_num_f" /></th>
            <!-- 当前库存位置 推荐库位 -->
            <th data-options="field:'location_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.location_s"/></th>
            <!-- 库存类型 基础数据112  -->
            <th data-options="field:'stocktype_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message 
                    code="lenger.column.stocktype_s" /></th>
            <!-- 质量状态 基础数据106 -->
            <th formatter="codeFormatter" data-options="field:'quality_status_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.quality_status_s"/></th>
            <!-- 产出时间 -->
            <th data-options="field:'outputtime_t',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.outputtime_t"/></th>
            <!-- 过期时间 -->
            <th data-options="field:'outtime_t',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.outtime_t"/></th>
            <!-- 延期时间，按小时计算 -->
            <th data-options="field:'delaytime_t',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.delaytime_t"/></th>
            <!-- 是否用完 0 否1 是 -->
            <th formatter="isrunoutFormatter" data-options="field:'isrunout_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.isrunout_s"/></th>
            <!-- 计量单位 基础数据305 -->
            <th  formatter="codeFormatter" data-options="field:'m_units_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.m_units_s"/></th>
            <!-- 工装条码(口型板) -->
            <th data-options="field:'plate_code_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.plate_code_s"/></th>
            <!-- 质检人 -->
            <th data-options="field:'qualityby_name',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.qualityby_s"/></th>
            <!-- 质检时间 -->
            <th data-options="field:'qualitydate_t',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.qualitydate_t"/></th>
            <!-- 库存操作标记 0 正常入库 1 盘库入库 -->
            <th formatter="inoroutFormatter" data-options="field:'inorout_s',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.inorout_s"/></th>
            <!-- 修改人 -->
            <th data-options="field:'changed_name',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.changed_by_s"/></th>
            <!-- 修改时间 -->
            <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.changed_time_t"/></th>
            <!-- 生产时间 -->
            <th data-options="field:'productiondate_t',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.productiondate_t"/></th>
            <!-- 主手 -->
            <th data-options="field:'mainoperator_name',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.mainoperator_s"/></th>
            <!-- 副手 -->
            <th data-options="field:'assistantoperator_name',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.assistantoperator_s"/></th>
            <!-- 卷曲工 -->
            <th data-options="field:'rollworker_name',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.rollworker_s"/></th>
            <!-- 卷曲工 副手-->
            <th data-options="field:'jugfs_name',editor:{type:'textbox'}"><spring:message
                    code="ledger.column.jugfs_name"/></th>
        </tr>
        </thead>
    </table>
</div>


<jsp:include page="../../../../inc/export.jsp">
    <jsp:param name="idField" value="atr_key"/>
    <jsp:param name="formId" value="Ledger_search_form"/>
    <jsp:param name="datagridId" value="ledger_dg"/>
    <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.HalfPartInventoryAccountExportHandler"/>
    <jsp:param name="serviceName" value="HalfPartInventoryAccountServiceImpl"/>
</jsp:include>
</body>
</html>
