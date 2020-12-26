<!-- 
    作者      :王超
    时间      :2020-08-19 08:21:54 
    页面名称:胶囊信息表
    文件关联:
        Capsule.java
        CapsuleController.java
        CapsuleServiceImpl.java
        CapsuleServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="capsule.js.jsp"%>
<script type="text/javascript" src="dict/208,228,224.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Capsule_dg_toolbar">
            <form id="Capsule_search_form" class="form" >
                <!-- 胶囊的条码/二维码/RFID芯片等 -->
                <spring:message code="capsule.column.capsule_code_s" />：
                <input name="filter[capsule_code_s]" id="capsule_code_s" style="width:140px;" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="capsule.column.material_code_s" />：
                <input name="filter[material_code_s]" id="material_code_s" style="width:140px;" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 储位地址 -->
                <spring:message code="capsule.column.store_place_s" />：
                <input name="filter[store_place_s]" id="store_place_s" style="width:140px;" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 状态 -->
                <spring:message code="capsule.column.statues_s" />：
                <input name="filter[statues_s]" id="statues_s" style="width:140px;" type="text" class="easyui-combotree" ,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/208',
	              			 method:'get'" >
	            <br>
	            <spring:message code="worklist.column.created_time_t" />：
                <input name="filter[start_time]" id="start_time" style="width:164px;" type="text" class="easyui-datetimebox" data-options="label:''" >
               	<spring:message code="tip.to" /> <input name="filter[end_time]" id="end_time" style="width:164px;" type="text" class="easyui-datetimebox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
           		<auth:button code="LH_SCGL_JNSYLL_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form>
        </div>
        <table id="capsule_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Capsule_dg_toolbar',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 胶囊的条码/二维码/RFID芯片等 -->
                    <th data-options="field:'capsule_code_s',editor:{type:'textbox'}"><spring:message code="capsule.column.capsule_code_s" /></th>
                    <!-- 胶囊规格 -->
                    <th data-options="field:'capsule_spec_s',editor:{type:'textbox'}"><spring:message code="capsule.column.capsule_spec_s" /></th>
                    <!-- 胶囊校验位码 -->
                    <th data-options="field:'parity_code_s',editor:{type:'textbox'}"><spring:message code="capsule.column.parity_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="capsule.column.material_code_s" /></th>
                    <!-- 胎胚规格 -->
                    <th data-options="field:'material_spec_s',editor:{type:'textbox'}"><spring:message code="mouldspec.column.ltgg" /></th>   
                    <!-- 状态 -->
                    <th data-options="field:'statues_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="capsule.column.statues_s" /></th>
                    <!-- 储位地址 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="capsule.column.store_place_s" /></th>
                    <!-- 最高使用次数 -->
                    <th data-options="field:'max_limit_i',editor:{type:'textbox'}"><spring:message code="capsule.column.max_limit_i" /></th>
                    <!-- 报警值 -->
                    <th data-options="field:'alarm_number_i',editor:{type:'textbox'}"><spring:message code="capsule.column.alarm_number_i" /></th>
                    <!-- 停机值 -->
                    <th data-options="field:'stop_number_i',editor:{type:'textbox'}"><spring:message code="capsulestandard.column.tingji" /></th>
                    <!-- 累计使用次数 -->
                    <th data-options="field:'total_number_i',editor:{type:'textbox'}"><spring:message code="capsule.column.total_number_i" /></th>
                    <!-- 更换原因 -->
                    <th data-options="field:'change_reason_s',formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/224',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="worklist.column.chang_reason_s" /></th>
                    <!-- 报废原因 -->
                    <th data-options="field:'scrap_reason_s',formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/224',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="capsule.column.scrap_reason_s" /></th>       <!-- 备用字段1 -->
                    <!-- 机台作业类型  1模具换上，2换胶囊，3洗模 4 模具换下 5模具修理6组装 -->
                    <th data-options="field:'operate_type_s',formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/228',
                                panelWidth:'300',
                    			required:true,
                    			}}"><spring:message code="worklist.column.operate_type_s" /></th>
                    <!-- 使用次数 -->
	                <th data-options="field:'usenumber_s',editor:{type:'textbox'}"><spring:message code="worklist.column.usenumber_s" /></th>
					<!-- 记录次数 -->
	                <th data-options="field:'usenum_current_s',editor:{type:'textbox'}"><spring:message code="worklist.column.usenum_current_s" /></th>
	                <!-- 换上人 -->
	                <th data-options="field:'execution_operator_s',editor:{type:'textbox'}"><spring:message code="worklist.column.execution_operator_s" /></th>
					<!-- 换上开始时间 -->
	                <th data-options="field:'operate_starttime_t',editor:{type:'textbox'}"><spring:message code="worklist.column.operate_starttime_s" /></th>
	                <!-- 换上结束时间 -->
	                <th data-options="field:'operate_endtime_t',editor:{type:'textbox'}"><spring:message code="worklist.column.operate_endtime_s" /></th>
	                <!-- 换下人 -->
	                <th data-options="field:'spare2_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message code="worklist.column.spare2_s" /></th>  
	                <!-- 换下时间 -->
	                <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="worklist.column.spare1_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Capsule_search_form" />
		<jsp:param name="datagridId" value="capsule_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.CapsuleExportHandler" />
		<jsp:param name="serviceName" value="CapsulesServiceImpl" />
	</jsp:include>
</body>
</html>
