<!-- 

    作者      :徐秉正
    时间      :2020-05-15 13:22:56 
    页面名称:外观改判作业记录履历
    文件关联:
        Appearancejudgework.java
        AppearancejudgeworkController.java
        AppearancejudgeworkServiceImpl.java
        AppearancejudgeworkServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="appearancejudgework.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Appearancejudgework_dg_toolbar">
            <form id="Appearancejudgework_search_form" class="form" >
                <%-- <!-- 机构编号：招远8000；德州8002 柳州8003 泰国 8004 荆门8023 -->
                <input name="filter[agenc_no_s]" id="agenc_no_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="appearancejudgework.column.agenc_no_s" />'" > --%>
                
                
                
                
                <!-- 轮胎条码 -->
                <td class="columnTitle">
                <spring:message code="appearancejudgework.column.barcode_s" />
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                </td>
                
                
                
                <!-- 改判时间 -->
                <td class="columnTitle">
                <spring:message code="appearancejudgework.column.appearancejudge_time_t" />
                <!-- 操作时间 -->
                    <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
                           type="text" class="easyui-datetimebox" style="width:165px"
                           data-options="label:''">
                    到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
                             class="easyui-datetimebox" style="width:165px">
                </td>
                
                
                
                <%-- <!-- 改判等级 -->
                <input name="filter[curinggradecode_s]" id="curinggradecode_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="appearancejudgework.column.curinggradecode_s" />'" >
                <!-- 物料编码 -->
                <input name="filter[curingspeccode_s]" id="curingspeccode_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="appearancejudgework.column.curingspeccode_s" />'" >
                <!-- 改判人 -->
                <input name="filter[operator_s]" id="operator_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="appearancejudgework.column.operator_s" />'" >
                <!-- 记录标志(A可用 D删除) -->
                <input name="filter[record_flag_s]" id="record_flag_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="appearancejudgework.column.record_flag_s" />'" >
                <!-- 工厂 -->
                <input name="filter[s_factory_s]" id="s_factory_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="appearancejudgework.column.s_factory_s" />'" > --%>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            
        </div>
        <table id="appearancejudgework_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Appearancejudgework_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <%-- <!-- 机构编号：招远8000；德州8002 柳州8003 泰国 8004 荆门8023 -->
                    <th data-options="field:'agenc_no_s',editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.agenc_no_s" /></th> --%>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'barcode_s',width:90,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'curingspeccode_s',width:200,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.curingspeccode_s" /></th>
                    <!-- 改判时间 -->
                    <th data-options="field:'appearancejudge_time_t',width:120,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.appearancejudge_time_t" /></th>
                    <!-- 当前等级 -->
                    <th data-options="field:'ggrade_s',editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.ggrade_s" /></th>
                    <!-- 改判等级 -->
                    <th data-options="field:'curinggradecode_s',width:60,formatter:codeFormatter,editor:{type:'textbox',options:{
                   		method:'get',
	                    url:'dict/code/253',
	        			required:true
                    
                    }}"><spring:message code="appearancejudgework.column.curinggradecode_s" /></th>
                    
                    <!-- 改判人 -->
                    <th data-options="field:'operator_s',width:120,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.operator_s" /></th>
                    <%-- <!-- 记录标志(A可用 D删除) -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.record_flag_s" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.s_factory_s" /></th> --%>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
