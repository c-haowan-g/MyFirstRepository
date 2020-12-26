<!-- 

    作者      :王超
    时间      :2020-01-20 09:59:31 
    页面名称:操作工登录履历表
    文件关联:
        WorkerLoginRecord.java
        WorkerLoginRecordController.java
        WorkerLoginRecordServiceImpl.java
        WorkerLoginRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="workerloginrecord.js.jsp"%>
<script type="text/javascript" src="dict/122,118,301.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WorkerLoginRecord_dg_toolbar">
            <form id="WorkerLoginRecord_search_form" class="form" >
                <!-- 机台条码 -->
                <spring:message code="workerloginrecord.column.equip_code_s" />：<input name="filter[equip_code_s]" id="equip_code_s" style="width:120px" type="text" class="easyui-combobox"
                	data-options="valueField:'P_LINE_NAME',
				            			textField:'P_LINE_NAME',
                                        required:false, 
                                        url:'halfpart/productionManagement/workerLoginRecord/searchEquipCode',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:150,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}"
                 >&nbsp;&nbsp;&nbsp;
                <!-- 工号 -->
                <spring:message code="workerloginrecord.column.worker_id_s" />：<input name="filter[worker_id_s]" id="worker_id_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 操作工类型 -->
                <spring:message code="workerloginrecord.column.worker_type_s" />：<input name="filter[worker_type_s]" id="worker_type_s" style="width:120px" type="text" class="easyui-combobox"
                	data-options="valueField:'code',
		            			  textField:'text',
                                  required:false, 
                                  url:'dict/code/122',
                                  panelHeight:150"
                >&nbsp;&nbsp;&nbsp;
                <!-- 班次 -->
                <spring:message code="workerloginrecord.column.classid_s" />：<input name="filter[classid_s]" id="classid_s" style="width:120px" type="text" class="easyui-combobox" 
	                data-options="valueField:'code',
		            			  textField:'text',
	                              required:false, 
	                              url:'dict/code/118',
	                              panelHeight:150" >
                <br>
                <!-- 登录类型 -->
                <spring:message code="login_type_s" />：<input name="filter[login_type_s]" id="login_type_s" style="width:120px" type="text" class="easyui-combobox"
                	data-options="required:false,
							      editable:false,
							      data:[
							      {'value':'1','text':'登录'},
							      {'value':'0','text':'注销'}],
							      valueField:'value',
							      textField:'text'"
                >&nbsp;&nbsp;&nbsp;
                <!-- 姓名 -->
                <spring:message code="workerloginrecord.column.worker_name_s" />：<input name="filter[worker_name_s]" id="worker_name_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 登录时间 -->
				<spring:message code="pdalogin_record.column.login_time_t" />：
				<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" data-options="label:''">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	<auth:button code="workerloginrecord.excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            <%-- <auth:button code="workerloginrecord.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="workerloginrecord.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="workerloginrecord.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="workerloginrecord.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="workerloginrecord.no"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button> --%>
            
        </div>
        <table id="workerloginrecord_dg" fitcolumns="true" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WorkerLoginRecord_dg_toolbar',
                url: 'halfpart/productionManagement/workerLoginRecord/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:100,editor:{type:'textbox',options:{required:true}}"><spring:message code="workerloginrecord.column.equip_code_s" /></th>
                    <!-- 工号 -->
                    <th data-options="field:'worker_id_s',width:100,editor:{type:'textbox',options:{required:true}}"><spring:message code="workerloginrecord.column.worker_id_s" /></th>
                    <!-- 姓名 -->
                    <th data-options="field:'worker_name_s',width:80,editor:{type:'textbox'}"><spring:message code="workerloginrecord.column.worker_name_s" /></th>
                    <!-- 操作工类型 -->
                    <th data-options="field:'worker_type_s',formatter:codeFormatter,width:80,editor:{type:'combobox',options:{
                    				 valueField:'code',
		            			     textField:'text',
                                     required:false, 
                                     url:'dict/code/122',
                                     panelHeight:150}}"><spring:message code="workerloginrecord.column.worker_type_s" /></th>
                    <!-- 班组 -->
                    <%-- <th data-options="field:'group_s',formatter:codeFormatter,width:80,editor:{type:'combobox',options:{
                    				 valueField:'code',
		            			     textField:'text',
                                     required:false, 
                                     url:'dict/code/301',
                                     panelHeight:150}}"><spring:message code="workerloginrecord.column.group_s" /></th> --%>
                    <!-- 登录类型 -->
                    <th data-options="field:'login_type_s',formatter:flagFormat,width:80,editor:close"><spring:message code="login_type_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'classid_s',formatter:codeFormatter,width:80,editor:{type:'combobox',options:{
                    				 valueField:'code',
		            			     textField:'text',
                                     required:false, 
                                     url:'dict/code/118',
                                     panelHeight:150}}"><spring:message code="workerloginrecord.column.classid_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'cuusername',width:80,editor:close"><spring:message code="workerloginrecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:125,editor:close"><spring:message code="workerloginrecord.column.created_time_t" /></th>
                    <%-- <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',formatter:toChangedName,width:80,editor:close"><spring:message code="workerloginrecord.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:125,editor:close"><spring:message code="workerloginrecord.column.changed_time_t" /></th> --%>
                </tr>
            </thead>
        </table>
    </div>
     <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkerLoginRecord_search_form" />
		<jsp:param name="datagridId" value="workerloginrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.WorkerLoginRecordExportHandler" />
		<jsp:param name="serviceName" value="WorkerLoginRecordServiceImpl" />
	</jsp:include>
</body>
</html>
