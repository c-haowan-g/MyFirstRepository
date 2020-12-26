<!-- 

    作者      :王超
    时间      :2020-09-08 08:14:23 
    页面名称:PLM等同物料维护
    文件关联:
        EqualMaterial.java
        EqualMaterialController.java
        EqualMaterialServiceImpl.java
        EqualMaterialServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="equalmaterial.js.jsp"%>

<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="EqualMaterial_dg_toolbar">
			<form id="EqualMaterial_search_form" class="form">
				<!-- 等同物料分组 -->
				<spring:message code="equalmaterial.column.groupname_s" />：
				<input name="filter[groupname_s]" id="groupname_s"
					style="width:150px" type="text" class="easyui-combobox"
					data-options="label:'',
                	    url:'mix/baseData/equalMaterial/getGroupnamesList',
	         		    panelHeight:200,
	         		    editable:true,
	           		    valueField:'groupname_s',
	          		    textField:'groupname_s',
	                    selectOnNavigation:false,
	           		    limitToList:true,
	           		    onChange:filter">
				<!-- 等同物料编号 -->
				<spring:message code="equalmaterial.column.materialcode_s" />：
				<input name="filter[materialcode_s]" id="materialcode_s"
					style="width:150px" type="text" class="easyui-combobox"
					data-options="label:'',
                        data:equalmatinfoList,
	         		    panelHeight:200,
	         		    editable:true,
	           		    valueField:'materialcode_s',
	          		    textField:'materialcode_s',
	                    selectOnNavigation:false,
	           		    limitToList:true,
	           		    onChange:filter">
				<!-- 等同物料名称 -->
				<spring:message code="equalmaterial.column.materialname_s" />：
				<input name="filter[materialname_s]" id="materialname_s"
					style="width:200px" type="text" class="easyui-combobox"
					data-options="label:'',
                		data:equalmatinfoList,
	         		    panelHeight:200,
	         		    editable:true,
	           		    valueField:'materialname_s',
	          		    textField:'materialname_s',
	                    selectOnNavigation:false,
	           		    limitToList:true,
	           		    onChange:filter">
				<!-- 下发标识 -->
				<spring:message code="equalmaterial.column.send_state_s" />：
				<input name="filter[send_state_s]" id="send_state_s"
					style="width:120px" type="text" class="easyui-combobox"
					data-options="editable:true,
					     data:[
					     {'value':'0','text':'未下发'},
					     {'value':'1','text':'已使用'},
					     {'value':'2','text':'下发失败'}],
					     valueField:'value',
					     textField:'text',
					     onChange:filter">
			</form>
			<auth:button code="equalmaterial.add">
				<a class="easyui-linkbutton btn-green"
					data-options="iconCls:'icon-add'" onclick="add()"><spring:message
						code="button.add" /></a>
			</auth:button>
			<auth:button code="equalmaterial.edit">
				<a class="easyui-linkbutton btn-red"
					data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message
						code="button.edit" /></a>
			</auth:button>
			<auth:button code="equalmaterial.remove">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message
						code="button.delete" /></a>
			</auth:button>
			<auth:button code="equalmaterial.save">
				<a class="easyui-linkbutton btn-blue"
					data-options="iconCls:'icon-save'" onclick="save()"><spring:message
						code="button.save" /></a>
			</auth:button>
			<auth:button code="equalmaterial.cancel">
				<a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message
						code="button.cancel" /></a>
			</auth:button>
			<auth:button code="equalmaterial.add">
				<a class="easyui-linkbutton btn-green"
					data-options="iconCls:'icon-add'" onclick="openOrclose('等级管控开启')"><spring:message
						code="等级管控开启" /></a>
			</auth:button>
			<auth:button code="equalmaterial.remove">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-remove'"
					onclick="openOrclose('等级管控关闭')"><spring:message code="等级管控关闭" /></a>
			</auth:button>
			<auth:button code="equalmaterial.export">
				<a class="easyui-linkbutton btn-deep-blue"
					data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message
						code="button.export" /></a>
			</auth:button>
			<a class="easyui-linkbutton btn-yellow"
				data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
					code="button.search" /></a>
		</div>
		<table id="equalmaterial_dg" class="easyui-datagrid"
			style="width:100%"
			data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#EqualMaterial_dg_toolbar',
                url: 'mix/baseData/equalMaterial/datagrid',
                onLoadSuccess:onLoadSuccess,
                striped:true,
                method: 'get' 
                ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true">ID</th>
					<!-- 等同物料分组 -->
					<th
						data-options="field:'groupname_s',width:120,editor:{
                  		    type:'combobox',
		                    options:{
		                        panelHeight:200,
		                        editable:true,		                     
		                        required:true,
		                        disabled:false,
		                        url:'mix/baseData/equalMaterial/getGroupnamesList',
		                        valueField:'groupname_s',
	          		            textField:'groupname_s'}}"><spring:message
							code="equalmaterial.column.groupname_s" /></th>
					<!-- 等同物料编号 -->
					<th
						data-options="field:'materialcode_s',width:120,editor:{
                  		    type:'combobox',
		                    options:{
		                        panelHeight:200,
		                        editable:true,		                     
		                        required:true,
		                        disabled:false,
		                        data:mixmatinfoList,
		                        valueField:'materialcode_s',
	          		            textField:'materialcode_s',
	          		            onSelect:onmaterialcodeselect}}"><spring:message
							code="equalmaterial.column.materialcode_s" /></th>
					<!-- 等同物料名称 -->
					<th
						data-options="field:'materialname_s',width:120,editor:{type:'textbox',
                            options:{disabled:true}}"><spring:message
							code="equalmaterial.column.materialname_s" /></th>
					<!-- 等同物料规格 -->
					<th
						data-options="field:'dummy1_s',width:120,editor:{type:'textbox',
                            options:{disabled:true}}"><spring:message
							code="equalmaterial.column.materialspec_s" /></th>
					<!-- 等同物料等级 -->
					<th
						data-options="field:'grade_i',width:120,editor:{type:'combobox',
					    options:{						             
		                    panelHeight:200,
                   		    data:[{value:'0',text:'0'},
                   		          {value:'1',text:'1'},
                   		          {value:'2',text:'2'},
                   		          {value:'3',text:'3'},
                   		          {value:'4',text:'4'},
                   		          {value:'5',text:'5'}
                   		   ]}}"><spring:message
							code="equalmaterial.column.grade_i" /></th>
					<!-- 等级管控 -->
					<th
						data-options="field:'dummy2_s',width:80,formatter:levelformatter,editor:close"><spring:message
							code="等级管控" /></th>
					<!-- 下发标识 -->
					<th
						data-options="field:'send_state_s',width:80,formatter:sendstateformatter,editor:close"><spring:message
							code="equalmaterial.column.send_state_s" /></th>
					<!-- 创建人 -->
					<th
						data-options="field:'created_by_s',width:100,formatter:toUserName,editor:close"><spring:message
							code="equalmaterial.column.created_by_s" /></th>
					<!-- 创建时间 -->
					<th data-options="field:'created_time_t',width:130,editor:close"><spring:message
							code="equalmaterial.column.created_time_t" /></th>
					<!-- 下发人 -->
					<th
						data-options="field:'send_by_s',width:100,formatter:toUserName,editor:close"><spring:message
							code="equalmaterial.column.send_by_s" /></th>
					<!-- 下发时间 -->
					<th data-options="field:'send_time_t',width:130,editor:close"><spring:message
							code="equalmaterial.column.send_time_t" /></th>
				</tr>
			</thead>
		</table>
	</div>
	<!--导出-->
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="EqualMaterial_search_form" />
		<jsp:param name="datagridId" value="equalmaterial_dg" />
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.mix.export.EqualMaterialExportHandler" />
		<jsp:param name="serviceName" value="EqualMaterialServiceImpl" />
	</jsp:include>
</body>
</html>