<!-- 

    作者      :时永良
    时间      :2018-10-17 09:02:58 
    页面名称:组织机构日志表
    文件关联:
        OrgLog.java
        OrgLogController.java
        OrgLogServiceImpl.java
        OrgLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="orglog.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="OrgLog_dg_toolbar">
            <form id="OrgLog_search_form" class="form" >
            	<!-- 部门id -->
                <spring:message code="orglog.column.mes_id_i" />:<input name="filter[mes_id_i]" id="mes_id_i" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 部门名称 -->
                <spring:message code="orglog.column.name_s" />:<input name="filter[name_s]" id="name_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 接收时间 -->
                <spring:message code="orglog.column.receive_time_t" />:
                <input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
               	 <spring:message code="tip.to" /><input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="orglog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#OrgLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' ,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 主键ID(MES部门表) -->
                    <th data-options="field:'mes_id_i',editor:{type:'textbox'}"><spring:message code="orglog.column.mes_id_i" /></th>
                     <!-- 组织ID -->
                    <th data-options="field:'org_id_s',editor:{type:'textbox'}"><spring:message code="orglog.column.org_id_s" /></th>
                    <!-- 父ID(MES部门表) -->
                    <th data-options="field:'mes_pid_i',editor:{type:'textbox'}"><spring:message code="orglog.column.mes_pid_i" /></th> 
                    <!-- 父组织ID -->
                    <th data-options="field:'parent_id_s',editor:{type:'textbox'}"><spring:message code="orglog.column.parent_id_s" /></th> 
                    <!-- 部门名称 -->
                    <th data-options="field:'name_s',editor:{type:'textbox'}"><spring:message code="orglog.column.name_s" /></th>
                    <!-- 更新标记，A新增，D删除，U修改 -->
                    <th data-options="field:'iftrans_s',editor:{type:'textbox'},formatter:iftrans_s_formarter"><spring:message code="orglog.column.iftrans_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="orglog.column.receive_time_t" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'},formatter:record_flag_s_formarter"><spring:message code="orglog.column.record_flag_s" /></th>
                    <!-- 排序 -->
                    <th data-options="field:'sortno_i',editor:{type:'textbox'}"><spring:message code="orglog.column.sortno_i" /></th>
                    <!-- 状态：Y-有效，N-无效 -->
                    <th data-options="field:'state_s',editor:{type:'textbox'},formatter:state_s_formarter"><spring:message code="orglog.column.state_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'memo_s',editor:{type:'textbox'}"><spring:message code="orglog.column.memo_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
