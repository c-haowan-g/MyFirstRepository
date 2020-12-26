<!-- 
    作者      :王超
    时间      :2020-08-03 15:29:17 
    页面名称:密炼料仓物料维护表
    文件关联:
        SiloMaterial.java
        SiloMaterialController.java
        SiloMaterialServiceImpl.java
        SiloMaterialServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="silomaterial.js.jsp"%>
<script type="text/javascript" src="dict/055,058.js"></script>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="SiloMaterial_dg_toolbar">
			<form id="SiloMaterial_search_form" class="form">
				<!-- 机台条码 -->
				<spring:message code="silomaterial.column.equip_code_s" />：
				<input name="filter[equip_code_s]" style="width:160px;"
					id="equip_code_s" type="text" class="easyui-combobox"
					data-options="valueField:'p_line_name',
				            			textField:'description',
                                        required:false, 
                                        data:equipList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){
								        var opts = $(this).combobox('options');
								        return row[opts.textField].indexOf(q) >= 0;
								    	}">
				<!-- 使用状态：058001-未审核、058002-已审核、058003-正下发、058004-已下发、058005-已执行、058006-已关闭 -->
				<spring:message code="silomaterial.column.status_s" />：
				<input name="filter[status_s]" style="width:140px;" id="status_s"
					type="text" class="easyui-combotree"
					,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/058',
	              			 method:'get'">
				<!-- 下发标识 -->
				<spring:message code="workorderedit.column.send_state_s" />：
				<input name="filter[spare1_s]" style="width:140px;"
					id="send_state_s" type="text" class="easyui-combobox"
					data-options="editable:true,
							     data:[
							     {'value':'0','text':'未下发'},
							     {'value':'1','text':'已下发'},
							     {'value':'2','text':'下发失败'}],
							     valueField:'value',
							     textField:'text'">
				<!-- 物料编码：对应INT_PLM_MIXMATERIAL表MATERIALCODE -->
				<spring:message code="silomaterial.column.material_code_s" />：
				<input name="filter[material_code_s]" style="width:140px;"
					id="material_code_s" type="text" class="easyui-combobox"
					data-options="valueField:'p_line_name',
				            			valueField:'materialcode_s',
	            						textField:'materialcode_s',
                                        url:'mix/baseData/siloMaterial/getMixMaterials',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){
								        var opts = $(this).combobox('options');
								        return row[opts.textField].indexOf(q) >= 0;
								    	}">
				<a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
						code="button.search" /></a>
			</form>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_add">
				<a class="easyui-linkbutton btn-green"
					data-options="iconCls:'icon-add'" onclick="add()"><spring:message
						code="button.add" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_edit">
				<a class="easyui-linkbutton btn-red"
					data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message
						code="button.edit" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_remove">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message
						code="button.delete" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_save">
				<a class="easyui-linkbutton btn-blue"
					data-options="iconCls:'icon-save'" onclick="save()"><spring:message
						code="button.save" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_cancel">
				<a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message
						code="button.cancel" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_audit">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-shenhe'" onclick="audit()"><spring:message
						code="button.audit" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_cancelaudit">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-fanshenhe'" onclick="cancelAudit()"><spring:message
						code="button.cancelAudit" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_send">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-version'" onclick="issue()"><spring:message
						code="button.issue" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_BaseData_siloMaterial_export">
				<a class="easyui-linkbutton btn-deep-blue"
					data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message
						code="button.export" /></a>
			</auth:button>
		</div>
		<table id="silomaterial_dg" class="easyui-datagrid" style="width:100%"
			data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SiloMaterial_dg_toolbar',
                url: 'mix/baseData/siloMaterial/datagrid',
                striped:true,
                method: 'get' 
                ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true">ID</th>
					<!-- 机台条码 -->
					<th
						data-options="field:'equip_code_s',width:150,formatter:equipCodeFormatter,editor:{type:'combobox',options:{
                 			valueField:'p_line_name',
	            			textField:'description',
                            required:true, 
                            data:equipList,
							method: 'get',
						    editable:'true',
						    limitToList:false,
						    panelHeight:200}}"><spring:message
							code="silomaterial.column.equip_name_s" /></th>
					<!-- 料仓号：加载机台对应配置料仓号 -->
					<th
						data-options="field:'silono_s',width:100,editor:{type:'textbox',
                            options:{
                            editable:true,
				            required:true}}"><spring:message
							code="silomaterial.column.silono_s" /></th>
					<!-- 输送线：加载炭黑、油料输送线基础数据 -->
					<th
						data-options="field:'pipeline_s',width:100,editor:{type:'textbox',
                            options:{
                            editable:true,
				            required:true}}"><spring:message
							code="silomaterial.column.pipeline_s" /></th>
					<!-- 物料编码：对应INT_PLM_MIXMATERIAL表MATERIALCODE -->
					<th
						data-options="field:'material_code_s',width:120,editor:{type:'combobox',options:{
                 			valueField:'materialcode_s',
	            			textField:'materialcode_s',
                            required:true, 
                            url:'mix/baseData/siloMaterial/getMixMaterials',
							method: 'get',
						    editable:'true',
						    limitToList:false,
						    panelHeight:200,
						    onChange:materialcodechanged,
							filter: function(q, row){  
					        var opts = $(this).combobox('options');  
					        return row[opts.textField].indexOf(q) >= 0;
					    	}}}"><spring:message
							code="silomaterial.column.material_code_s" /></th>
					<!-- 物料名称：对应INT_PLM_MIXMATERIAL表MATERIALNAME -->
					<th
						data-options="field:'material_name_s',width:180,editor:{type:'textbox',
                            options:{disabled:true}}"><spring:message
							code="silomaterial.column.material_name_s" /></th>
					<!-- 物料类别(上辅机定义)：055001-炭黑、055002-小药、055003-粉料、055004-油料、055005-胶料 ：对应INT_PLM_MIXMATERIAL表MATERIALTYPE -->
					<th
						data-options="field:'materialtype_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
					 		method:'get',
                            url:'dict/code/055',
                    		required:true,
                    		editable:false,
                    		disabled:true
					 	}}"><spring:message
							code="silomaterial.column.materialtype_s" /></th>
					<!-- 使用状态：058001-未审核、058002-已审核、058003-正下发、058004-已下发、058005-已执行、058006-已关闭 -->
					<th
						data-options="field:'status_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
					 		method:'get',
                            url:'dict/code/058',
                    		required:true,
                    		editable:false,
                    		disabled:true
					 	}}"><spring:message
							code="silomaterial.column.status_s" /></th>
					<!-- 下发标识 -->
					<th
						data-options="field:'spare1_s',formatter:sendstateFormatter,width:80,editor:close"><spring:message
							code="workorderedit.column.send_state_s" /></th>
					<!-- 供应商名称 例如：A|B -->
					<th
						data-options="field:'supplyname_s',width:100,editor:{type:'textbox'}"><spring:message
							code="silomaterial.column.supplyname_s" /></th>
					<!-- 审核人 -->
					<th
						data-options="field:'check_by_s',width:100,formatter:toUserName,editor:close"><spring:message
							code="silomaterial.column.check_by_s" /></th>
					<!-- 审核时间 -->
					<th data-options="field:'check_time_t',width:130,editor:close"><spring:message
							code="silomaterial.column.check_time_t" /></th>
					<!-- 下发人 -->
					<th
						data-options="field:'send_by_s',width:100,formatter:toUserName,editor:close"><spring:message
							code="silomaterial.column.send_by_s" /></th>
					<!-- 下发时间 -->
					<th data-options="field:'send_time_t',width:130,editor:close"><spring:message
							code="silomaterial.column.send_time_t" /></th>
					<!-- 创建人 -->
					<th
						data-options="field:'created_by_s',width:100,formatter:toUserName,editor:close"><spring:message
							code="silomaterial.column.created_by_s" /></th>
					<!-- 创建时间 -->
					<th data-options="field:'created_time_t',width:130,editor:close"><spring:message
							code="silomaterial.column.created_time_t" /></th>
				</tr>
			</thead>
		</table>
	</div>
	<!--导出-->
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="SiloMaterial_search_form" />
		<jsp:param name="datagridId" value="silomaterial_dg" />
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.mix.export.SiloMaterialExportHandler" />
		<jsp:param name="serviceName" value="SiloMaterialServiceImpl" />
	</jsp:include>
</body>
</html>