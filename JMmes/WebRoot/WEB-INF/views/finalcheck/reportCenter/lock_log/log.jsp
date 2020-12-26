<!-- 

    作者      :陈国强
    时间      :2020-12-02 16:35:01 
    页面名称:轮胎锁定记录表
    文件关联:
        Log.java
        LogController.java
        LogServiceImpl.java
        LogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="log.js.jsp"%>
<script type="text/javascript" src="dict/253,001,062,073.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Log_dg_toolbar">
            <form id="Log_search_form" class="form" >
                <!--  锁定时间 -->
                <spring:message code="log.column.lock_tiem_t" />
                <input name="filter[begin_lock_time]" editable="true" id="begin_lock_time" type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input
					name="filter[end_lock_time]" editable="true" id="end_lock_time" class="easyui-datetimebox" style="width:170px">
			    <!-- 轮胎条码 -->
                <spring:message code="log.column.barcode_s" />
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                </br>
                <!--  解锁时间 -->
                <spring:message code="log.column.unlock_tiem_t" />
                <input name="filter[begin_unlock_time]" editable="true" id="begin_unlock_time" type="text" class="easyui-datetimebox" style="width:170px" data-options="label:''"> 到 <input
					name="filter[end_unlock_time]" editable="true" id="end_unlock_time" class="easyui-datetimebox" style="width:170px">
                
                <!-- 轮胎条码（胶囊破裂） -->
                <spring:message code="log.column.tyrebarcode_s" />
                <input name="filter[tyrebarcode_s]" id="tyrebarcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
           <%--  <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="log_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Log_dg_toolbar',
                url: 'finalcheck/qualityInspectionRecord/log/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="log.column.barcode_s" /></th>
                    <!-- 锁定前等级 -->
                    <th data-options="field:'lock_ago_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="log.column.lock_ago_s" /></th>
                    <!-- 锁定人员编码 -->
                    <th data-options="field:'username',editor:{type:'textbox'}"><spring:message code="log.column.lock_by_s" /></th>
                    <%-- <!-- 锁定人员 -->
                    <th data-options="field:'lock_name_s',editor:{type:'textbox'}"><spring:message code="log.column.lock_name_s" /></th>
                     --%><!-- 锁定后等级 -->
                    <th data-options="field:'lock_rear_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="log.column.lock_rear_s" /></th>
                    <!-- 锁定原因 -->
                    <th data-options="field:'lock_reas_s',formatter:islock_reas_s,editor:{type:'textbox'}"><spring:message code="log.column.lock_reas_s" /></th>
                    <!-- 锁定备注 -->
                    <th data-options="field:'lock_remark_s',editor:{type:'textbox'}"><spring:message code="log.column.lock_remark_s" /></th>
                    <!-- 锁定时间 -->
                    <th data-options="field:'lock_time_t',editor:{type:'textbox'}"><spring:message code="log.column.lock_tiem_t" /></th>
                    <%-- <!-- 记录标志(A可用 D删除) -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="log.column.record_flag_s" /></th>
                     --%><!-- 当前状态（1已锁定，0已解锁） -->
                    <th data-options="field:'state_s',formatter:isTestmatFlag,editor:{type:'textbox'}"><spring:message code="log.column.state_s" /></th>
                   <%--  <!-- 工厂 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="log.column.s_factory_s" /></th>
                     --%><!-- 轮胎条码（胶囊破裂） -->
                    <th data-options="field:'tyrebarcode_s',editor:{type:'textbox'}"><spring:message code="log.column.tyrebarcode_s" /></th>
                    <!-- 解锁人员编码 -->
                    <th data-options="field:'unlock_by_s',editor:{type:'textbox'}"><spring:message code="log.column.unlock_by_s" /></th>
                    <!-- 解锁人员 -->
                    <th data-options="field:'unlock_name_s',editor:{type:'textbox'}"><spring:message code="log.column.unlock_name_s" /></th>
                    <!-- 解锁原因 -->
                    <th data-options="field:'unlock_reas_s',editor:{type:'textbox'}"><spring:message code="log.column.unlock_reas_s" /></th>
                    <!-- 解锁时间 -->
                    <th data-options="field:'unlock_time_t',editor:{type:'textbox'}"><spring:message code="log.column.unlock_tiem_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
