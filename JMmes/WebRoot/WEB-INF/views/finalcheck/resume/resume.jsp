<!-- 

    作者      :徐秉正
    时间      :2020-05-25 08:07:02 
    页面名称:改判作业履历表
    文件关联:
        Resume.java
        ResumeController.java
        ResumeServiceImpl.java
        ResumeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="resume.js.jsp"%>
<script type="text/javascript" src="dict/253,252.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Resume_dg_toolbar">
            <form id="Resume_search_form" class="form" >
                <%-- <!-- 机构编号：招远8000；德州8002 柳州8003 泰国 8004 荆门8023 -->
                <input name="filter[agenc_no_s]" id="agenc_no_s" type="text" class="easyui-textbox" data-options="label:'<spring:message code="appearancejudgework.column.agenc_no_s" />'" > --%>
                
                
                
                
                <!-- 轮胎条码 -->
                <td class="columnTitle">
                <spring:message code="appearancejudgework.column.barcode_s" />
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                </td>
                
                 <!-- 工序-->
                <td class="columnTitle">
                <spring:message code="appearancejudgework.column.spare1_s" />
                <input name="filter[spare1_s]" id="spare1" type="text" class="easyui-combobox" data-options="label:'',
										                textField: 'label',
										                editable:'true',
														data: [{
																label: '外观',
																value: '252008'
															},{
																label: '硫化',
																value: '252006'
															},{
																label: 'X光',
																value: '252009'
															}]" >
                </td>
                
                <!-- 改判时间 -->
                <td class="columnTitle">
                <spring:message code="appearancejudgework.column.appearancejudge_time_t" />
                <!-- 操作时间 -->
                    <input name="filter[begin_created_time]" editable="true" id="begin_created_time"
                           type="text" class="easyui-datetimebox" style="width:165px"
                           data-options="label:''">
                    到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
                             class="easyui-datetimebox" style="width:165px"><br>
                </td>
                <td class="columnTitle">
                <!-- 物料编码 -->
                <spring:message code="judgework.column.curingspeccode_s" />:
                <input name="filter[curingspeccode_s]" id="curingspeccode_s" type="text" class="easyui-textbox" data-options="label:''" >
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
                <auth:button code="EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
        </div>
        <table id="resume_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Resume_dg_toolbar',
                url: '',
                striped:true,
                method: 'get',
                pageSize:300,
 				pageList:[300,600,900] 
                ">
            <thead>
                <tr>
                   <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <%-- <!-- 机构编号：招远8000；德州8002 柳州8003 泰国 8004 荆门8023 -->
                    <th data-options="field:'agenc_no_s',editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.agenc_no_s" /></th> --%>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'barcode_s',width:80,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'curingspeccode_s',width:270,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.curingspeccode_s" /></th>
                    <!-- 改判时间 -->
                    <th data-options="field:'appearancejudge_time_t',width:150,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.appearancejudge_time_t" /></th>
                    <!-- 当前等级 -->
                    <th data-options="field:'ggrade_s',editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.ggrade_s" /></th>
                    <!-- 改判等级 -->
                    <th data-options="field:'curinggradecode_s',width:60,formatter:codeFormatter,editor:{type:'textbox',options:{
                   		method:'get',
	                    url:'dict/code/253',
	        			required:true
                    
                    }}"><spring:message code="appearancejudgework.column.curinggradecode_s" /></th>
                    <%-- <!-- wuliaobianma  -->
                    <th data-options="field:'SPARE2_S',width:120,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.materialspare" /></th> --%>
                    <!-- 工序 -->
                    <th data-options="field:'spare1_s',formatter:codeFormatter,width:90,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.spare1_s" /></th>
                    <!-- 病象描述 -->
                    <th data-options="field:'reas_r_s',width:120,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.reas_r_s" /></th>
                    <!-- 改判人 -->
                    <th data-options="field:'operator_s',width:120,editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.operator_s" /></th>
                    <!-- 硫化工人 -->
                    <th data-options="field:'username_c',width:120,editor:{type:'textbox'}"><spring:message code="硫化工人 " /></th>
                    <!-- 硫化时间 -->
                    <th data-options="field:'overtime_c',width:200,editor:{type:'textbox'}"><spring:message code="硫化时间" /></th>
                    <!-- 硫化机台 -->
                    <th data-options="field:'machinecode_c',width:120,editor:{type:'textbox'}"><spring:message code="硫化机台" /></th>
                    <!-- 成型工人 -->
                    <th data-options="field:'username_b',width:120,editor:{type:'textbox'}"><spring:message code="成型工人" /></th>
                    <!-- 成型时间 -->
                    <th data-options="field:'overtime_b',width:200,editor:{type:'textbox'}"><spring:message code="成型时间" /></th>
                    <!-- 成型机台 -->
                    <th data-options="field:'machinecode_b',width:120,editor:{type:'textbox'}"><spring:message code="成型机台" /></th>
                    <%-- <!-- 记录标志(A可用 D删除) -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.record_flag_s" /></th>
                    <!-- 工厂 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="appearancejudgework.column.s_factory_s" /></th> --%>
                </tr>
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Resume_search_form" />
		<jsp:param name="datagridId" value="resume_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.ResumeExportHandler" />
		<jsp:param name="serviceName" value="ResumeServiceImpl" />
	</jsp:include>
</body>
</html>
