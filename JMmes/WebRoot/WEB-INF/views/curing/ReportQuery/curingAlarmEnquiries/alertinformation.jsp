<!-- 

    作者      :时永良
    时间      :2018-12-21 09:12:17 
    页面名称:硫化机台报警查询(设备报警信息表)
    文件关联:
        Alertinformation.java
        AlertinformationController.java
        AlertinformationServiceImpl.java
        AlertinformationServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="alertinformation.js.jsp"%>
<script type="text/javascript" src="dict/235,201,234.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Alertinformation_dg_toolbar">
            <form id="Alertinformation_search_form" class="form" >
             <table>
				
							<!-- 机台条码 --> <spring:message code="alertinformation.column.equip_code_s" />:
						<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-textbox" data-options="label:''">
							<!-- 轮胎条码 --> <spring:message code="alertinformation.column.tyrebarcode" />:
						<input name="filter[spare1_s]" id="spare1_s" type="text" class="easyui-textbox" data-options="label:''">
							<!-- 报警等级 --> <spring:message code="alertinformation.column.alert_level_s" />:
						<input name="filter[alert_level_s]" id="alert_level_s" style="width:168px"  type="text" class="easyui-combotree" data-options="label:'',
				  			required:false,
				  			url:'dict/code/201',
				  			method:'get',
				  			label:''" ><br/>
							<!-- 报警处理状态基础数据 --> <spring:message code="alertinformation.column.alert_status_s" />:
						<input name="filter[alert_status_s]" id="alert_status_s" style="width:168px"  type="text" class="easyui-combotree" data-options="label:'',
				  			required:false,
				  			url:'dict/code/234',
				  			method:'get',
				  			label:''" >
							<!-- 报警内容 --> <spring:message code="alertinformation.column.alert_detail_s" />:
						<input name="filter[alert_detail_s]" id="alert_detail_s" like="true" type="text" class="easyui-textbox" data-options="label:''">
						 <!-- 报警来源(比如温模焖锅等) -->
						<spring:message code="alertinformation.column.alarm_from_s" />:
						<input name="filter[alarm_from_s]" id="alarm_from_s" like="true" style="width:148px;" class="easyui-combotree" data-options="label:'',
										  labelWidth:'auto',
										  panelHeight:200,
										  required:false,
										  url:'dict/code/235',
										  method:'get'">
						<br/>
						<!-- 报警时间 --> <spring:message code="alertinformation.column.created_time_t" />:
						<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''">
						<spring:message code="tip.to" />
						<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''"></td>
						<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
						<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a>						</td>
				</table>
            </form> 
        </div>
        <table id="alertinformation_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Alertinformation_dg_toolbar',
                striped:true,
                method: 'get' ,
                emptyMsg:'<spring:message code="tip.noData" />'
                
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                     <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:80,editor:{type:'textbox'}"><spring:message code="alertinformation.column.equip_code_s" /></th>
                    <!-- 报警次数 -->
                    <th data-options="field:'alarm_count_i',width:80,editor:{type:'textbox'}"><spring:message code="alertinformation.column.alarm_count_i" /></th>
                    <!-- 报警来源(比如温模焖锅等) -->
                    <th data-options="field:'alarm_from_s',width:120,formatter:codeFormatter,options:{
                    			method:'get',
                                url:'dict/code/235',
                    			required:true}"><spring:message code="alertinformation.column.alarm_from_s" /></th>
                    
                    <!-- 报警代码 -->
                   <!--  <th data-options="field:'alert_code_s',width:120,formatter:codeFormatter,options:{
                    			method:'get',
                                url:'dict/code/235',
                    			required:true}"> -->
        			 <th data-options="field:'alert_code_s',width:120"><spring:message code="alertinformation.column.alert_code_s" /></th>
                    <!-- 报警内容 -->
                    <th data-options="field:'alert_detail_s',width:200,editor:{type:'textbox'}"><spring:message code="alertinformation.column.alert_detail_s" /></th>
                    <!-- 报警等级 -->
                    <th data-options="field:'alert_level_s',width:120,formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="alertinformation.column.alert_level_s" /></th>
                    <!-- 处理结果 -->
                    <th data-options="field:'spare1_s',formatter:spearFormater,width:100,editor:{type:'textbox'}"><spring:message code="alertinformation.column.spare1_s" /></th>
                    <!-- 不通过原因 -->
                    <th data-options="field:'spare2_s',width:100,editor:{type:'textbox'}"><spring:message code="alertinformation.column.spare2_s" /></th>
                    <%-- <!-- 报警等级 -->
                    <th data-options="field:'alert_level_s',editor:{type:'combotree'}"><spring:message code="alertinformation.column.alert_level_s" /></th> --%>
                    <!-- 报警处理状态 -->
                    <th data-options="field:'alert_status_s',formatter:codeFormatter,editor:{type:'combotree',options:{
	        			method:'get',
	                    url:'dict/code/234',
	        			required:true}}"><spring:message code="alertinformation.column.alert_status_s" /></th>
                    <!-- 放行人 -->
                    <th data-options="field:'confirmor_name',editor:{type:'textbox'}"><spring:message code="alertinformation.column.quality_confirmor_s" /></th>
                    <!-- 放行时间 -->
                    <th data-options="field:'quality_confirmtime_t',editor:{type:'textbox'}"><spring:message code="alertinformation.column.quality_confirmtime_t" /></th>
                     <!-- 创建人 -->
                    <th data-options="field:'created_name',editor:{type:'textbox'}"><spring:message code="alertinformation.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="alertinformation.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Alertinformation_search_form" />
		<jsp:param name="datagridId" value="alertinformation_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.AlertinformationExportHandler" />
		<jsp:param name="serviceName" value="AlertinformationServiceImpl" />
	</jsp:include>
</body>
</html>
