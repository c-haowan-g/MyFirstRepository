<!-- 

    作者      :徐秉正
    时间      :2020-03-06 16:32:51 
    页面名称:半部件计划跟踪
    文件关联:
        Productplan.java
        ProductplanController.java
        ProductplanServiceImpl.java
        ProductplanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="projecttrack.js.jsp"%>
<script type="text/javascript" src="dict/104,308,328.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="ProjectTrack_dg_toolbar">
            <form id="ProjectTrack_search_form" class="form" >
               <!-- 机台号 -->
                <spring:message code="projecttrack.column.spare1_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" class="easyui-combobox" 
                          data-options="
                                        labelWidth:'auto',
                                        panelHeight:150,
                                        valueField:'P_LINE_NAME',
				            			textField:'DESCRIPTION',
				            			data:productLineList,
									    editable:'true',
									    required:false, 
									    method:'get'">
                <!-- 日计划号：生成规则 -->
                <spring:message code="projecttrack.column.planno_s" />:&emsp;<input name="filter[planno_s]" id="planno_s"  beginWith="true" class="easyui-combobox"  
                          data-options="valueField:'PLANNO_S',
				            			textField:'PLANNO_S',
                                        required:false, 
                                        url:'halfpart/productionplan/projecttrack/searchPlanno',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}">&nbsp;&nbsp;&nbsp; 
                <!-- 计划开始时间 -->
                <spring:message code="projecttrack.column.planstarttime_t" />:&emsp;<input name="filter[planstarttime_t]" id="planstarttime_t" editable="true" type="text" class="easyui-datetimebox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                                        到：<input name="filter[planfinishtime_t]" id="planfinishtime_t" editable="true" type="text" class="easyui-datetimebox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="projecttrack.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="projecttrack.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="projecttrack_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#ProjectTrack_dg_toolbar',
               
                striped:true,
                method: 'get',
                onLoadSuccess:onLoadSuccess,
                onCheck:onCheck,
                onUncheck:onUncheck,
                emptyMsg: '<span><spring:message code='tip.noData'/></span>'
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台号 -->
                    <th data-options="field:'spare1_s',width:120,sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.equip_code_s" /></th>
                    <!-- 日计划号：生成规则 -->
                    <th data-options="field:'planno_s',width:120,sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.planno_s" /></th>
                    <!-- 计划状态：基础数据104 -->
                    <th data-options="field:'status_s',formatter:codeFormatter,width:80,sortable:true,editor:{type:'textbox',
                                options:{
				                 method:'get',
				                 url:'dict/code/104',
				                 required:true}}"><spring:message code="projecttrack.column.status_s" /></th>
                    <!-- 计划生产日期 -->
                    <th data-options="field:'plandate_s',width:80,sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.plandate_s" /></th>
                    <!-- 物料组：基础数据308 -->
                    <th data-options="field:'materialgroup_s',formatter:codeFormatter,sortable:true,editor:{type:'textbox',
                                options:{
				                 method:'get',
				                 url:'dict/code/308',
				                 required:true}}"><spring:message code="projecttrack.column.materialgroup_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',width:80,sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',width:200,sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.materialname_s" /></th>
                    <!-- 客户标识  设置基础数据字典 328 -->
                    <th data-options="field:'customerflag_s',formatter:codeFormatter,width:80,sortable:true,editor:{type:'textbox',
                                options:{
				                 method:'get',
				                 url:'dict/code/328',
				                 required:true}}"><spring:message code="projecttrack.column.customerflag_s" /></th>
                    <!-- 工单完成量 -->
                    <th data-options="field:'planfinish_f',width:80,sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.planfinish_i" /></th>
                    <!-- 确认计划量  -->
                    <th data-options="field:'planquantityconfirm_f',width:80,sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.planquantityconfirm_f" /></th>
                    <!-- 完成进度 -->
                    <th data-options="field:'fulfillment_of_schedule',formatter:progressBar,width:110,sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.fulfillment_of_schedule" /></th>
                    <!-- 计划开始时间 -->
                    <th data-options="field:'planstarttime_t',sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.planstarttime_t" /></th>
                    <!-- 计划结束时间 -->
                    <th data-options="field:'planfinishtime_t',sortable:true,editor:{type:'textbox'}"><spring:message code="projecttrack.column.planfinishtime_t" /></th> 
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="ProjectTrack_search_form" />
		<jsp:param name="datagridId" value="projecttrack_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.ProjectTrackExportHandler" />
		<jsp:param name="serviceName" value="ProjectTrackServiceImpl" />
	</jsp:include>  
</body>
</html>
