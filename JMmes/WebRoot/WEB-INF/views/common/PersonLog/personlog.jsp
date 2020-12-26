<!-- 

    作者      :时永良
    时间      :2018-10-17 10:49:36 
    页面名称:用户管理日志表
    文件关联:
        PersonLog.java
        PersonLogController.java
        PersonLogServiceImpl.java
        PersonLogServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="personlog.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="PersonLog_dg_toolbar">
            <form id="PersonLog_search_form" class="form" >
            <!-- 用户工号 -->
                <spring:message code="personlog.column.usercode_s" />:<input name="filter[usercode_s]" id="usercode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 用户名 -->
                <spring:message code="personlog.column.username_s" />:<input name="filter[username_s]" id="username_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 接收时间 -->
                <spring:message code="personlog.column.receive_time_t" />:<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''" >
               	 <spring:message code="tip.to" /><input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="personlog_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#PersonLog_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' ,
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                     <!-- 用户工号 -->
                    <th data-options="field:'usercode_s',editor:{type:'textbox'}"><spring:message code="personlog.column.usercode_s" /></th>
                    <!-- 用户名 -->
                    <th data-options="field:'username_s',editor:{type:'textbox'}"><spring:message code="personlog.column.username_s" /></th>
                    <!-- 密码（加密） -->
                    <th data-options="field:'userpassword_s',editor:{type:'textbox'}"><spring:message code="personlog.column.userpassword_s" /></th>
                    <!-- 性别：存储汉字 1-男，2-女 -->
                    <th data-options="field:'sex_s',editor:{type:'textbox'},formatter:sex_s_formarter"><spring:message code="personlog.column.sex_s" /></th>
                    <!-- 在职状态：存储汉字 Y-在职，N-离职 -->
                    <th data-options="field:'state_s',editor:{type:'textbox'},formatter:state_s_formarter"><spring:message code="personlog.column.state_s" /></th>
                    <!-- 主键ID(MES用户表) -->
                    <th data-options="field:'mes_id_i',editor:{type:'textbox'}"><spring:message code="personlog.column.mes_id_i" /></th>
                    <!-- 部门ID(MES用户表) -->
                    <th data-options="field:'mes_org_id_i',editor:{type:'textbox'}"><spring:message code="personlog.column.mes_org_id_i" /></th>
                    <!-- 部门ID -->
                    <th data-options="field:'org_id_s',editor:{type:'textbox'}"><spring:message code="personlog.column.org_id_s" /></th>
                    <!-- 电话号码 -->
                    <th data-options="field:'phone_s',editor:{type:'textbox'}"><spring:message code="personlog.column.phone_s" /></th>
                    <!-- 电子邮件 -->
                    <th data-options="field:'email_s',editor:{type:'textbox'}"><spring:message code="personlog.column.email_s" /></th>
                    <!-- 家庭住址 -->
                    <th data-options="field:'home_address_s',editor:{type:'textbox'}"><spring:message code="personlog.column.home_address_s" /></th>
                    <!-- 更新标记，A新增，D删除，U修改 -->
                    <th data-options="field:'iftrans_s',editor:{type:'textbox'},formatter:iftrans_s_formarter"><spring:message code="personlog.column.iftrans_s" /></th>
                    <!-- 账户状态：正常、锁定 -->
                    <th data-options="field:'accountstate_s',editor:{type:'textbox'}"><spring:message code="personlog.column.accountstate_s" /></th>
                     <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'},formatter:record_flag_s_formarter"><spring:message code="personlog.column.record_flag_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="personlog.column.receive_time_t" /></th>
                   
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
