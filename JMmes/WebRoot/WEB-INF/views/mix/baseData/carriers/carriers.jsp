<!-- 
    作者      :王超
    时间      :2020-08-03 15:27:50 
    页面名称:密炼载具信息表
    文件关联:
        Carriers.java
        CarriersController.java
        CarriersServiceImpl.java
        CarriersServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="carriers.js.jsp"%>
<script type="text/javascript" src="dict/061.js"></script>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="Carriers_dg_toolbar">
			<form id="Carriers_search_form" class="form">
				<!-- 载具类型 -->
				<spring:message code="carriers.column.carrier_type_s" />：
				<input name="filter[carrier_type_s]" id="carrier_type_s"
					type="text" class="easyui-combobox"
					data-options="valueField:'code',
		            			  textField:'text',
		            			  editable:true,
	                              required:false, 
	                              url:'dict/code/061',
	                              panelHeight:160">
				<!-- 状态 -->
				<spring:message code="carriers.column.isuse_s" />：
				<input name="filter[isuse_s]" id="isuse_s" type="text"
					class="easyui-combobox"
					data-options="editable:true,
							     data:[
							     {'value':'0','text':'未使用'},
							     {'value':'1','text':'已使用'}],
							     valueField:'value',
							     textField:'text'">
				<!-- 工器具的条码/二维码/RFID芯片等，唯一 -->
				<spring:message code="carriers.column.carrier_code_s" />：
				<input name="filter[carrier_code_s]" id="carrier_code_s"
					type="text" class="easyui-textbox" data-options="label:''">
				<a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
						code="button.search" /></a>
			</form>
			<auth:button code="mixcarriers.add">
				<a class="easyui-linkbutton btn-green"
					data-options="iconCls:'icon-add'" onclick="add()"><spring:message
						code="button.add" /></a>
			</auth:button>
			<auth:button code="mixcarriers.edit">
				<a class="easyui-linkbutton btn-red"
					data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message
						code="button.edit" /></a>
			</auth:button>
			<auth:button code="mixcarriers.remove">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message
						code="button.delete" /></a>
			</auth:button>
			<auth:button code="mixcarriers.save">
				<a class="easyui-linkbutton btn-blue"
					data-options="iconCls:'icon-save'" onclick="save()"><spring:message
						code="button.save" /></a>
			</auth:button>
			<auth:button code="mixcarriers.cancel">
				<a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message
						code="button.cancel" /></a>
			</auth:button>
			<auth:button code="mixcarriers.export">
				<a class="easyui-linkbutton btn-deep-blue"
					data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message
						code="button.export" /></a>
			</auth:button>
		</div>
		<table id="carriers_dg" class="easyui-datagrid" style="width:100%"
			data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Carriers_dg_toolbar',
                url: 'mix/baseData/carriers/datagrid',
                striped:true,
                method: 'get' 
                ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true">ID</th>
					<!-- 载具类型 -->
					<th
						data-options="field:'carrier_type_s', width:100, formatter:codeFormatter, editor:{type:'combotree',
                        options:{panelHeight:160,
                            editable:false,
				            required:true,
			                url:'dict/code/061'}
			            }"><spring:message
							code="carriers.column.carrier_type_s" /></th>
					<!-- 工器具的条码/二维码/RFID芯片等，唯一 -->
					<th
						data-options="field:'carrier_code_s', width:100, editor:{type:'textbox',
                        options:{
				            required:true
			            }}"><spring:message
							code="carriers.column.carrier_code_s" /></th>
					<!-- 工器具名称 -->
					<th
						data-options="field:'carrier_desc_s', width:100, editor:{type:'textbox'}"><spring:message
							code="carriers.column.carrier_desc_s" /></th>
					<!-- 最大装载数量 -->
					<th
						data-options="field:'load_maxnum_i',editor:{type:'textbox',
                        options:{
				            required:true
			            }}"><spring:message
							code="carriers.column.load_maxnum_i" /></th>
					<!-- 状态 -->
					<th
						data-options="field:'isuse_s', width:100, editor:{type:'combobox',
                        options:{required:true,
							     editable:false,
							     data:[
							     {'value':'0','text':'未使用'},
							     {'value':'1','text':'已使用'}],
							     valueField:'value',
							     textField:'text'}}"><spring:message
							code="carriers.column.isuse_s" /></th>
					<!-- 自身重量 -->
					<th
						data-options="field:'dead_weight_f',editor:{type:'textbox',
                        options:{
				            required:true
			            }}"><spring:message
							code="carriers.column.dead_weight_f" /></th>
					<!-- 修改人 -->
					<th
						data-options="field:'changed_by_s',formatter:toUserName,editor:close"><spring:message
							code="carriers.column.changed_by_s" /></th>
					<!-- 修改时间 -->
					<th data-options="field:'changed_time_t',editor:close"><spring:message
							code="carriers.column.changed_time_t" /></th>
					<!-- 创建人 -->
					<th
						data-options="field:'created_by_s',formatter:toUserName,editor:close"><spring:message
							code="carriers.column.created_by_s" /></th>
					<!-- 创建时间 -->
					<th data-options="field:'created_time_t',editor:close"><spring:message
							code="carriers.column.created_time_t" /></th>
				</tr>
			</thead>
		</table>
	</div>
	<!--导出-->
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Carriers_search_form" />
		<jsp:param name="datagridId" value="carriers_dg" />
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.mix.export.CarriersExportHandler" />
		<jsp:param name="serviceName" value="CarriersServiceImpl" />
	</jsp:include>
</body>
</html>