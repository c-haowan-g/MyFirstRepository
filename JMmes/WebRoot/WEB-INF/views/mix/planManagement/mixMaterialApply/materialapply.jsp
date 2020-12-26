<!-- 

    作者      :王超
    时间      :2020-08-07 09:12:17 
    页面名称:密炼领料管理
    文件关联:
        MaterialApply.java
        MaterialApplyController.java
        MaterialApplyServiceImpl.java
        MaterialApplyServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="materialapply.js.jsp"%>
<script type="text/javascript" src="dict/005,051,302,064.js"></script>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="MaterialApply_dg_toolbar">
			<form id="MaterialApply_search_form" class="form">
				<!-- 工厂 -->
				<spring:message code="工厂" />：
				<input name="filter[s_factory_s]" style="width:120px;"
					id="s_factory_s" type="text" class="easyui-combobox"
					,
                        data-options="label:'',
	              			 textField: 'label',
	              			 onLoadSuccess : function(){
			                     $('#s_factory_s').combobox('setValue','2');
			                 },
							 data: [
							     {label: '半钢',
								 value: '2'},
								 {label: '全钢',
								 value: '1'}]">
				<!-- 用料生产日期 -->
				<spring:message code="materialapply.column.prod_date_s" />：
				<input name="filter[prod_date_s]" style="width:120px;"
					id="prod_date_s" type="text" class="easyui-datebox"
					data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:''">
				<script type="text/javascript">
					$("#prod_date_s").val(new Calendar().format("yyyyMMdd"));
				</script>
				<!-- 机台条码 -->
				<spring:message code="生产机台" />：
				<input name="filter[equip_code_s]" style="width:180px;"
					id="equip_code_sjl" type="text" class="easyui-combobox"
					data-options="valueField:'p_line_name',
	            			  textField:'description',
                              required:false, 
                              url:'mix/planManagement/dayPlan/searchMixEquip',
							  method: 'get',
						      editable:'true',
						      limitToList:false,
						      panelHeight:200,
							  filter: function(q, row){  
					              var opts = $(this).combobox('options');  
					              return row[opts.textField].indexOf(q) >= 0;
					    	 }">
				<!-- 所属计划类型用料：051001-小料计划、051002-硫磺计划、051003-胶料计划 -->
				<spring:message code="materialapply.column.prod_type_s" />：
				<input name="filter[prod_type_s]" style="width:120px;"
					id="prod_type_s" type="text" class="easyui-combotree"
					,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/051',
	              			 method:'get'">
				<!-- 用料生产班次：302001-早班、302002-中班、302003-晚班 -->
				<spring:message code="materialapply.column.prod_shift_s" />：
				<input name="filter[prod_shift_s]" style="width:120px;"
					id="prod_shift_s" type="text" class="easyui-combotree"
					,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/302',
	              			 method:'get'">
				<br>
				<!-- 申请状态 -->
				<spring:message code="状态" />：
				<input name="filter[status_check_s]" style="width:120px;"
					id="status_check_s" type="text" class="easyui-combotree"
					,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/064',
	              			 method:'get'">
				<!-- 用料生产物料编码 -->
				<spring:message code="materialapply.column.material_code_s" />：
				<input name="filter[material_code_s]" style="width:120px;"
					id="material_code_s" type="text" class="easyui-textbox"
					data-options="label:''">
				<!-- 申请类型 -->
				<spring:message code="申请类型" />：
				<input name="filter[spare1_s]" style="width:180px;" id="spare1_s"
					type="text" class="easyui-combobox"
					,
                        data-options="label:'',
	              			 textField: 'label',
	              			 editable:'true',
							 data: [
							     {label: '原材料领料',
								 value: '0'},
								 {label: '密炼领料',
								 value: '1'}]">
			</form>
			<auth:button code="JM_Mixer_PlanManagement_materialApply_add">
				<a class="easyui-linkbutton btn-green" style="margin-left:3.5px;"
					data-options="iconCls:'icon-add'" onclick="add()"><spring:message
						code="button.add" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_PlanManagement_materialApply_edit">
				<a class="easyui-linkbutton btn-red"
					data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message
						code="button.edit" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_PlanManagement_materialApply_remove">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message
						code="button.delete" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_PlanManagement_materialApply_save">
				<a class="easyui-linkbutton btn-blue"
					data-options="iconCls:'icon-save'" onclick="save()"><spring:message
						code="button.save" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_PlanManagement_materialApply_cancel">
				<a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message
						code="button.cancel" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_PlanManagement_materialApply_audit">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-shenhe'" onclick="audit()"><spring:message
						code="button.audit" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_PlanManagement_materialApply_cancelaudit">
				<a class="easyui-linkbutton btn-black"
					data-options="iconCls:'icon-fanshenhe'" onclick="cancelAudit()"><spring:message
						code="button.cancelAudit" /></a>
			</auth:button>
			<auth:button code="JM_Mixer_PlanManagement_materialApply_export">
				<a class="easyui-linkbutton btn-deep-blue"
					data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message
						code="button.export" /></a>
			</auth:button>
			<a class="easyui-linkbutton btn-yellow"
				data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
					code="button.search" /></a>
		</div>
		<table id="materialapply_dg" class="easyui-datagrid"
			style="width:100%"
			data-options="
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#MaterialApply_dg_toolbar',
                onSelect:selectrow,
                striped:true,
                method: 'get'
                ">
			<thead>
				<tr>
					<th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
					<th colspan="4">用料生产信息</th>
					<th colspan="20">领料申请信息</th>
				</tr>
				<tr>
					<!-- 用料生产信息 -->
					<!-- 用料生产日期 -->
					<th
						data-options="field:'prod_date_s',width:100,editor:{type:'textbox',
                            options:{
                           	editable:false,
			                required:true,
			                disabled:true}}"><spring:message
							code="materialapply.column.prod_date_s" /></th>
					<!-- 用料生产班次：302001-早班、302002-中班、302003-晚班 -->
					<th
						data-options="field:'prod_shift_s',width:100,formatter:codeFormatter,editor:{type:'combotree',
                            options:{panelHeight:160,
                            editable:false,
				            required:true,
			                url:'dict/code/302'}}"><spring:message
							code="materialapply.column.prod_shift_s" /></th>
					<!-- 用料生产机台名称 -->
					<th
						data-options="field:'equip_code_s',width:150,formatter:searchMixEquipName,editor:{type:'combobox',options:{
                 			valueField:'p_line_name',
	            			textField:'description',
                            required:true, 
                            url:'mix/planManagement/dayPlan/searchMixEquip',
							method: 'get',
						    editable:'true',
						    limitToList:false,
						    panelHeight:200}}"><spring:message
							code="materialapply.column.equip_name_s" /></th>
					<!-- 所属计划类型用料：051001-小料计划、051002-硫磺计划、051003-胶料计划 -->
					<th
						data-options="field:'prod_type_s',width:150,formatter:codeFormatter,editor:{type:'combotree',
                            options:{panelHeight:160,
                            editable:false,
				            required:true,
			                url:'dict/code/051'}}"><spring:message
							code="materialapply.column.prod_type_s" /></th>

					<!-- 领料申请信息 -->
					<!-- 领料申请单号：固定字符+工厂+生产日期+班次+四位流水号 例如 YL92019070110001 -->
					<th
						data-options="field:'apply_no_s',width:160,editor:{type:'textbox',
                            options:{
                           	editable:true,
			                required:true}}"><spring:message
							code="materialapply.column.apply_no_s" /></th>
					<!-- 领料申请需求类型 -->
					<th
						data-options="field:'spare1_s',formatter:spare1Formatter,editor:close"><spring:message
							code="领料申请需求类型" /></th>
					<!-- 申请单号状态 -->
					<th
						data-options="field:'status_check_s',formatter:codeFormatter,styler:planStatusColorSetting,editor:close"><spring:message
							code="materialapply.column.status_check_s" /></th>
					<!-- 用料生产物料编码 -->
					<th
						data-options="field:'material_code_s',width:150,editor:{type:'combobox',options:{
                 			valueField:'materialcode_s',
	            			textField:'materialcode_s',
                            required:true, 
                            url:'mix/baseData/siloMaterial/getMixMaterials',
							method: 'get',
						    editable:'true',
						    limitToList:false,
						    panelHeight:150,
						    onChange:materialcodechanged}}"><spring:message
							code="materialapply.column.material_code_s" /></th>
					<!-- 用料生产物料名称 -->
					<th
						data-options="field:'material_name_s',width:150,editor:{type:'textbox',
                            options:{disabled:true}}"><spring:message
							code="materialapply.column.material_name_s" /></th>
					<!-- 用料生产数量 -->
					<th
						data-options="field:'qty_apply_f',editor:{type:'numberbox',options:{
                    					required:true,
                    					editable:true,
                    					precision:0,
                    					min:0
                    					}}"><spring:message
							code="materialapply.column.qty_apply_f" /></th>
					<!-- 接收：数量 -->
					<th data-options="field:'qty_receive_f',editor:{type:'textbox'}"><spring:message
							code="materialapply.column.qty_receive_f" /></th>
					<!-- 接收允许超差数量 -->
					<th
						data-options="field:'qty_allow_receive_f',editor:{type:'textbox'}"><spring:message
							code="materialapply.column.qty_allow_receive_f" /></th>
					<!-- 发料库区 -->
					<th
						data-options="field:'spare3_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
							code="materialapply.column.spare3_s" /></th>
					<!-- 接收库区：062001-胶料库、062002-线边库、062003-历史库 -->
					<th data-options="field:'store_type_s',editor:{type:'textbox'}"><spring:message
							code="materialapply.column.store_type_s" /></th>
					<!-- 接收库位 -->
					<th data-options="field:'store_code_s',editor:{type:'textbox'}"><spring:message
							code="materialapply.column.store_code_s" /></th>
					<!-- 数据来源：075008-密炼生产、075013-半部件手持 -->
					<th data-options="field:'data_source_s',editor:close"><spring:message
							code="materialapply.column.data_source_s" /></th>
					<!-- 审核人 -->
					<th
						data-options="field:'check_by_s',formatter:toUserName,editor:close"><spring:message
							code="materialapply.column.check_by_s" /></th>
					<!-- 审核时间 -->
					<th data-options="field:'check_time_t',editor:close"><spring:message
							code="materialapply.column.check_time_t" /></th>
					<!-- 结单人 -->
					<th
						data-options="field:'close_by_s',formatter:toUserName,editor:close"><spring:message
							code="materialapply.column.close_by_s" /></th>
					<!-- 结单日期 -->
					<th data-options="field:'close_time_t',editor:close"><spring:message
							code="materialapply.column.close_time_t" /></th>
					<!-- 修改人 -->
					<th
						data-options="field:'changed_by_s',formatter:toUserName,editor:close"><spring:message
							code="materialapply.column.changed_by_s" /></th>
					<!-- 修改时间 -->
					<th data-options="field:'changed_time_t',editor:close"><spring:message
							code="materialapply.column.changed_time_t" /></th>
					<!-- 创建人 -->
					<th
						data-options="field:'created_by_s',formatter:toUserName,editor:close"><spring:message
							code="materialapply.column.created_by_s" /></th>
					<!-- 创建时间 -->
					<th data-options="field:'created_time_t',editor:close"><spring:message
							code="materialapply.column.created_time_t" /></th>
				</tr>
			</thead>
		</table>
	</div>

	<div data-options="region:'south',split:true,border:false"
		style="height:200px;">
		<div class="easyui-tabs"
			data-options="region:'center',fit:true,border:false">
			<div title="领料明细">
				<table id="materialapplyrecord_dg" class="easyui-datagrid"
					style="width:100%"
					data-options="  
		                fit:true,
		                fitColumns:true,
		                pagination:false,
		                rownumbers: false,
		                singleSelect: true,
		                striped:true,
		                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
		                remoteSort:false,
		                method: 'get' 
		                ">
					<thead>
						<tr>
							<th data-options="field:'atr_key',checkbox:true">ID</th>
							<!-- 领料申请单号：固定字符+工厂+生产日期+班次+四位流水号 例如 YL92019070110001 -->
							<th data-options="field:'apply_no_s',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.apply_no_s" /></th>
							<!-- 接收单号：领料申请单号+四位流水号 例如：YL920190701100010001 -->
							<th data-options="field:'receive_no_s',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.receive_no_s" /></th>
							<!-- 接收批次 -->
							<th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.lot_no_s" /></th>
							<!-- 接收物料编码 -->
							<th
								data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.material_code_s" /></th>
							<!-- 接收物料名称 -->
							<th
								data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.material_name_s" /></th>
							<!-- 接收数量 -->
							<th data-options="field:'qty_s',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.qty_s" /></th>
							<!-- 接收单位 -->
							<th data-options="field:'unit_s',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.unit_s" /></th>
							<!-- 接收时间 -->
							<th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.receive_time_t" /></th>
							<!-- 创建人：发料人 -->
							<th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.created_by_s" /></th>
							<!-- 创建时间：发料时间 -->
							<th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message
									code="materialapplyrecord.column.created_time_t" /></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
	<!--导出-->
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="MaterialApply_search_form" />
		<jsp:param name="datagridId" value="materialapply_dg" />
		<jsp:param name="handlerClass"
			value="com.bluebirdme.mes.linglong.mix.export.MaterialApplyExportHandler" />
		<jsp:param name="serviceName" value="MaterialApplyServiceImpl" />
	</jsp:include>
</body>
</html>