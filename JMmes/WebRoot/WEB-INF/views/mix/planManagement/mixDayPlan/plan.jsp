<!-- 
    作者      :王超
    时间      :2020-08-04 16:31:44 
    页面名称:密炼日计划表
    文件关联:
        Plan.java
        PlanController.java
        PlanServiceImpl.java
        PlanServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="plan.js.jsp"%>
<script type="text/javascript" src="dict/052,053.js"></script>
<body class="easyui-layout" fit="true">
	<div class="easyui-tabs"
		data-options="region:'center',split:true,border:false">
		<div title="胶料计划">
			<div id="Plan_dg_toolbarjl">
				<form id="Plan_search_formjl" class="form">
					<!-- 计划生产日期 -->
					<spring:message code="plan.column.plan_date_s" />：
					<input name="filter[plan_date_s]" style="width:100px;"
						id="plan_date_sjl" type="text" class="easyui-datebox"
						data-options="onChange:filterjl,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:''">
					<script type="text/javascript">
						$("#plan_date_sjl").val(
								new Calendar().format("yyyyMMdd"));
					</script>
					<!-- 机台条码 -->
					<spring:message code="plan.column.equip_code_s" />：
					<input name="filter[equip_code_s]" style="width:140px;"
						id="equip_code_sjl" type="text" class="easyui-combobox"
						data-options="valueField:'p_line_name',
				            			textField:'description',
                                        required:false, 
                                        data:jlequipList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){
								        var opts = $(this).combobox('options');
								        return row[opts.textField].indexOf(q) >= 0;
								    	}">
					<!-- 计划状态 -->
					<spring:message code="plan.column.plan_status_s" />：
					<input name="filter[plan_status_s]" style="width:100px;"
						id="plan_status_sjl" type="text" class="easyui-combotree"
						,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/052',
	              			 method:'get'">
					<!-- 物料编码 -->
					<spring:message code="plan.column.material_code_s" />：
					<input name="filter[material_code_s]" style="width:120px;"
						id="material_code_sjl" type="text" class="easyui-textbox"
						data-options="label:''">
					<!-- 日计划号 -->
					<spring:message code="plan.column.plan_no_s" />：
					<input name="filter[plan_no_s]" style="width:120px;"
						id="plan_no_sjl" type="text" class="easyui-textbox"
						data-options="label:''"><a
						class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filterjl()"><spring:message
							code="button.search" /></a>
				</form>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jladd">
					<a class="easyui-linkbutton btn-green"
						data-options="iconCls:'icon-add'" onclick="addjl()"><spring:message
							code="button.add" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jledit">
					<a class="easyui-linkbutton btn-red"
						data-options="iconCls:'icon-edit'" onclick="editjl()"><spring:message
							code="button.edit" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jlremove">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-remove'" onclick="removejl()"><spring:message
							code="button.delete" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jlsave">
					<a class="easyui-linkbutton btn-blue"
						data-options="iconCls:'icon-save'" onclick="savejl()"><spring:message
							code="button.save" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jlcancel">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-no'" onclick="canceljl()"><spring:message
							code="button.cancel" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jlcopy">
					<a class="easyui-linkbutton btn-green"
						data-options="iconCls:'icon-copy'" onclick="copyjl()"><spring:message
							code="button.copy" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jlaudit">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-shenhe'" onclick="auditjl()"><spring:message
							code="button.audit" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jlcancelaudit">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-fanshenhe'" onclick="cancelAuditjl()"><spring:message
							code="button.cancelAudit" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jltoorder">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-supplier'" onclick="issuejl()"><spring:message
							code="button.generateworkorder" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jltomaterialapply">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-formula'"
						onclick="generatematapplyplanjl()"><spring:message
							code="button.generatematapplyplan" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_upjl">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-upper'" onclick="upjl()"><spring:message
							code="button.planup" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_downjl">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-down'" onclick="downjl()"><spring:message
							code="button.plandown" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_jlexport">
					<a class="easyui-linkbutton btn-deep-blue"
						data-options="iconCls:'icon-excel'" onclick="export_jl()"><spring:message
							code="button.export" /></a>
				</auth:button>
			</div>
			<table id="plan_dgjl" class="easyui-datagrid" style="width:100%"
				data-options="  
	                fit:true,
	                fitColumns:false,
	                pagination:true,
	                rownumbers: true,
	                singleSelect: false,
	                toolbar: '#Plan_dg_toolbarjl',
	                striped:true,
	                method: 'get' 
	                ">
				<thead>
					<tr>
						<th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
						<th colspan="10">计划基本信息</th>
						<th colspan="6">配方基本信息</th>
						<th colspan="2">日计划量</th>
						<th colspan="2">早班计划量</th>
						<th colspan="2">中班计划量</th>
						<th colspan="2">晚班计划量</th>
						<th colspan="8">早班计划执行情况</th>
						<th colspan="8">中班计划执行情况</th>
						<th colspan="8">晚班计划执行情况</th>
						<!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES -->
						<th rowspan="2" data-options="field:'datasource_s',editor:close"><spring:message
								code="plan.column.datasource_s" /></th>
						<!-- 审核人 -->
						<th rowspan="2"
							data-options="field:'check_by_s',formatter:toUserName,editor:close"><spring:message
								code="plan.column.check_by_s" /></th>
						<!-- 审核时间 -->
						<th rowspan="2" data-options="field:'check_time_t',editor:close"><spring:message
								code="plan.column.check_time_t" /></th>
						<!-- 下发人 -->
						<th rowspan="2"
							data-options="field:'send_by_s',formatter:toUserName,editor:close"><spring:message
								code="plan.column.send_by_s" /></th>
						<!-- 下发时间 -->
						<th rowspan="2" data-options="field:'send_time_t',editor:close"><spring:message
								code="plan.column.send_time_t" /></th>
						<!-- 修改人 -->
						<th rowspan="2"
							data-options="field:'changed_by_s',formatter:toUserName,editor:close"><spring:message
								code="plan.column.changed_by_s" /></th>
						<!-- 修改时间 -->
						<th rowspan="2" data-options="field:'changed_time_t',editor:close"><spring:message
								code="plan.column.changed_time_t" /></th>
						<!-- 创建人 -->
						<th rowspan="2"
							data-options="field:'created_by_s',formatter:toUserName,editor:close"><spring:message
								code="plan.column.created_by_s" /></th>
						<!-- 创建时间 -->
						<th rowspan="2" data-options="field:'created_time_t',editor:close"><spring:message
								code="plan.column.created_time_t" /></th>
					</tr>
					<tr>
						<!-- 计划基本信息 -->
						<!-- 计划生产日期 -->
						<th
							data-options="field:'plan_date_s',width:80,editor:{type:'textbox',
	                    	options:{
	                    		disabled:true
	                    	}}"><spring:message
								code="plan.column.plan_date_s" /></th>
						<!-- 日计划号 -->
						<th
							data-options="field:'plan_no_s',width:140,editor:{type:'textbox',
	                    	options:{
	                    		editable:'false',
	                    	}}"><spring:message
								code="plan.column.plan_no_s" /></th>
						<!-- 审核状态：0-未审核、1-已审核 -->
						<th
							data-options="field:'plan_status_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.plan_status_s" /></th>
						<!-- 下发标识：0-未下发、1-已下发、2-下发失败 -->
						<th
							data-options="field:'send_state_s',formatter:sendstateFormatter,editor:close"><spring:message
								code="plan.column.send_state_s" /></th>
						<!-- 机台名称 -->
						<th
							data-options="field:'equip_code_s',width:150,formatter:equipCodeFormatterJl,editor:{type:'combobox',options:{
                    					valueField:'p_line_name',
				            			textField:'description',
                                        required:true, 
                                        data:jlequipList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
									    onSelect:onequipcodeselect1,
										filter: function(q, row){
								        var opts = $(this).combobox('options');
								        return row[opts.textField].indexOf(q) >= 0;
								    	}}}"><spring:message
								code="plan.column.equip_name_s" /></th>
						<!--执行顺序-->
						<th
							data-options="field:'spare8_s',editor:{type:'textbox',options:{disabled:true}}"><spring:message
								code="mixdayplan.column.spare8_s" /></th>
						<!-- 硫变仪机台条码 -->
						<th data-options="field:'sa_equip_code_s',editor:{type:'textbox'}"><spring:message
								code="plan.column.sa_equip_code_s" /></th>
						<!-- 门尼仪机台条码 -->
						<th data-options="field:'mi_equip_code_s',editor:{type:'textbox'}"><spring:message
								code="plan.column.mi_equip_code_s" /></th>
						<!-- 物料编码 -->
						<th
							data-options="field:'material_code_s',width:120,editor:{type:'combobox',options:{
                 			valueField:'mater_code_s',
	            			textField:'mater_code_s',
                            required:true,
						    editable:'true',
						    limitToList:false,
						    panelHeight:100,
						    onSelect:materialcodechangedjl}}"><spring:message
								code="plan.column.material_code_s" /></th>
						<!-- 物料名称 -->
						<th
							data-options="field:'material_name_s',width:120,editor:{type:'textbox',
                            options:{disabled:true}}"><spring:message
								code="plan.column.material_name_s" /></th>
						<!-- 配方基本信息 -->
						<!-- 密炼生成配方编号 -->
						<th
							data-options="field:'mixrecipe_recipe_code_s',width:130,editor:{type:'combobox',
                               options:{
	                               method:'get',
	                               required:true,
	                               panelHeight:100,
	                               valueField:'recipe_code_s',
						           textField:'recipe_code_s',
						           onSelect:onRecipeSelect1
						       }}"><spring:message
								code="plan.column.mixrecipe_recipe_code_s" /></th>
						<!-- 密炼配方BOM版本 -->
						<th
							data-options="field:'recipe_bom_version_s',editor:{type:'textbox',
	                        options:{disabled:true}}"><spring:message
								code="plan.column.recipe_bom_version_s" /></th>
						<!-- 是否有等同物料 -->
						<th
							data-options="field:'spare9_s',formatter:isspare9Formatter,editor:{type:'combobox',
				            options:
	                            { 
	                              editable:false,
	                              valueField:'value',
	                              textField:'text',
	                              method:'get',
	                              data: [{
									text: '否',
									value: 0
								},{
									text: '是',
									value: 1
								}],
                            required:true}}"><spring:message
								code="mixdayplan.column.spare9_s" /></th>
						<!-- 等同物料编码 -->
						<th
							data-options="field:'spare10_s',width:120,formatter:materialnameformatter,editor:{type:'textbox'}"><spring:message
								code="mixdayplan.column.spare10_s" /></th>
						<!-- 快检检验配方编号 -->
						<th
							data-options="field:'quickcheck_recipe_code_s',width:130,editor:{type:'combobox',
                               options:{
	                               method:'get',
	                               panelHeight:100,
	                               valueField:'recipe_code_s',
						           textField:'recipe_code_s'
						       }}"><spring:message
								code="plan.column.quickcheck_recipe_code_s" /></th>
						<!-- 密炼快检检验百分比 -->
						<th
							data-options="field:'sip_s',editor:{type:'textbox',options:{disabled:true}}"><spring:message
								code="mixdayplan.column.sip_s" /></th>
						<!-- 日计划量 -->
						<th
							data-options="field:'qty_plan_i',width:60,editor:{type:'numberspinner',options:{min:1,max:8888888,disabled:true,editable:false,required:true,icons:[]}}"><spring:message
								code="plan.column.qty_plan_i" /></th>
						<!-- 日计划检验量：车数*检验百分比 -->
						<th
							data-options="field:'qty_check_plan_f',width:60,editor:{type:'numberspinner',options:{min:0,max:8888888,disabled:true,editable:false,icons:[]}}"><spring:message
								code="plan.column.qty_check_plan_f" /></th>

						<!-- 早班计划量 -->
						<th
							data-options="field:'qty_mor_i',width:60,editor:{type:'numberspinner',options:{required:true,min:1,max:8888888,onChange:onCountChange1,icons:[]}}"><spring:message
								code="plan.column.qty_mor_i" /></th>
						<!-- 早班计划检验量：车数*检验百分比 -->
						<th
							data-options="field:'qty_check_mor_f',width:60,editor:{type:'numberspinner',options:{min:0,max:8888888,disabled:true,onChange:onCheckCountChange1,icons:[]}}"><spring:message
								code="plan.column.qty_check_mid_f" /></th>

						<!-- 中班计划量 -->
						<th
							data-options="field:'qty_mid_i',width:60,editor:{type:'numberspinner',options:{required:true,min:1,max:8888888,onChange:onCountChange1,icons:[]}}"><spring:message
								code="plan.column.qty_mid_i" /></th>
						<!-- 中班计划检验量：车数*检验百分比 -->
						<th
							data-options="field:'qty_check_mid_f',width:60,editor:{type:'numberspinner',options:{min:0,max:8888888,disabled:true,onChange:onCheckCountChange1,icons:[]}}"><spring:message
								code="plan.column.qty_check_mor_f" /></th>

						<!-- 晚班计划量 -->
						<th
							data-options="field:'qty_nig_i',width:60,editor:{type:'numberspinner',options:{required:true,min:1,max:8888888,onChange:onCountChange1,icons:[]}}"><spring:message
								code="plan.column.qty_nig_i" /></th>
						<!-- 晚班计划检验量：车数*检验百分比 -->
						<th
							data-options="field:'qty_check_nig_f',width:60,editor:{type:'numberspinner',options:{min:0,max:8888888,disabled:true,onChange:onCheckCountChange1,icons:[]}}"><spring:message
								code="plan.column.qty_check_nig_f" /></th>

						<!-- 早班计划执行情况 -->
						<!-- 早班状态 -->
						<th
							data-options="field:'status_mor_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_mor_s" /></th>
						<!-- 早班检查状态 -->
						<th
							data-options="field:'status_check_mor_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_check_mor_s" /></th>
						<!-- 早班检验合格数量 -->
						<th data-options="field:'qty_check_good_mor_i',editor:close"><spring:message
								code="plan.column.qty_check_good_mor_i" /></th>
						<!-- 早班检验不合格数量 -->
						<th data-options="field:'qty_check_bad_mor_i',editor:close"><spring:message
								code="plan.column.qty_check_bad_mor_i" /></th>
						<!-- 早班执行开始时间 -->
						<th data-options="field:'act_start_time_mor_t',editor:close"><spring:message
								code="plan.column.act_start_time_mor_t" /></th>
						<!-- 早班执行结束时间 -->
						<th data-options="field:'act_finish_time_mor_t',editor:close"><spring:message
								code="plan.column.act_finish_time_mor_t" /></th>
						<!-- 早班检查开始时间 -->
						<th data-options="field:'act_start_checktime_mor_t',editor:close"><spring:message
								code="plan.column.act_start_checktime_mor_t" /></th>
						<!-- 早班检查结束时间 -->
						<th data-options="field:'act_finish_checktime_mor_t',editor:close"><spring:message
								code="plan.column.act_finish_checktime_mor_t" /></th>

						<!-- 中班计划执行情况 -->
						<!-- 中班状态 -->
						<th
							data-options="field:'status_mid_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_mid_s" /></th>
						<!-- 中班检查状态 -->
						<th
							data-options="field:'status_check_mid_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_check_mid_s" /></th>
						<!-- 中班检验合格数量 -->
						<th data-options="field:'qty_check_good_mid_i',editor:close"><spring:message
								code="plan.column.qty_check_good_mid_i" /></th>
						<!-- 中班检验不合格数量 -->
						<th data-options="field:'qty_check_bad_mid_i',editor:close"><spring:message
								code="plan.column.qty_check_bad_mid_i" /></th>
						<!-- 中班执行开始时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_start_time_mid_t',editor:close"><spring:message
								code="plan.column.act_start_time_mid_t" /></th>
						<!-- 中班执行结束时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_finish_time_mid_t',editor:close"><spring:message
								code="plan.column.act_finish_time_mid_t" /></th>
						<!-- 中班检查开始时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_start_checktime_mid_t',editor:close"><spring:message
								code="plan.column.act_start_checktime_mid_t" /></th>
						<!-- 中班检查结束时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_finish_checktime_mid_t',editor:close"><spring:message
								code="plan.column.act_finish_checktime_mid_t" /></th>

						<!-- 晚班计划执行情况 -->
						<!-- 晚班状态 -->
						<th
							data-options="field:'status_nig_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_nig_s" /></th>
						<!-- 晚班检查状态 -->
						<th
							data-options="field:'status_check_nig_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_check_nig_s" /></th>
						<!-- 晚班检验合格数量 -->
						<th data-options="field:'qty_check_good_nig_i',editor:close"><spring:message
								code="plan.column.qty_check_good_nig_i" /></th>
						<!-- 晚班检验不合格数量 -->
						<th data-options="field:'qty_check_bad_nig_i',editor:close"><spring:message
								code="plan.column.qty_check_bad_nig_i" /></th>
						<!-- 晚班执行开始时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_start_time_nig_t',editor:close"><spring:message
								code="plan.column.act_start_time_nig_t" /></th>
						<!-- 晚班执行结束时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_finish_time_nig_t',editor:close"><spring:message
								code="plan.column.act_finish_time_nig_t" /></th>
						<!-- 晚班检查开始时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_start_checktime_nig_t',editor:close"><spring:message
								code="plan.column.act_start_checktime_nig_t" /></th>
						<!-- 晚班检查结束时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_finish_checktime_nig_t',editor:close"><spring:message
								code="plan.column.act_finish_checktime_nig_t" /></th>
					</tr>
				</thead>
			</table>
		</div>
		<div title="小料计划">
			<div id="Plan_dg_toolbarxl">
				<form id="Plan_search_formxl" class="form">
					<!-- 计划生产日期 -->
					<spring:message code="plan.column.plan_date_s" />：
					<input name="filter[plan_date_s]" style="width:100px;"
						id="plan_date_sxl" type="text" class="easyui-datebox"
						data-options="onChange:filterxl,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:''">
					<script type="text/javascript">
						$("#plan_date_sxl").val(
								new Calendar().format("yyyyMMdd"));
					</script>
					<!-- 机台条码 -->
					<spring:message code="plan.column.equip_code_s" />：
					<input name="filter[equip_code_s]" style="width:140px;"
						id="equip_code_sxl" type="text" class="easyui-combobox"
						data-options="valueField:'p_line_name',
				            			textField:'description',
                                        required:false, 
                                        data:xlequipList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){
								        var opts = $(this).combobox('options');
								        return row[opts.textField].indexOf(q) >= 0;
								    	}">
					<!-- 计划状态 -->
					<spring:message code="plan.column.plan_status_s" />：
					<input name="filter[plan_status_s]" style="width:100px;"
						id="plan_status_s" type="text" class="easyui-combotree"
						,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/052',
	              			 method:'get'">
					<!-- 物料编码 -->
					<spring:message code="plan.column.material_code_s" />：
					<input name="filter[material_code_s]" style="width:120px;"
						id="material_code_s" type="text" class="easyui-textbox"
						data-options="label:''">
					<!-- 日计划号 -->
					<spring:message code="plan.column.plan_no_s" />：
					<input name="filter[plan_no_s]" style="width:120px;"
						id="plan_no_s" type="text" class="easyui-textbox"
						data-options="label:''"><a
						class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filterxl()"><spring:message
							code="button.search" /></a>
				</form>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xladd">
					<a class="easyui-linkbutton btn-green"
						data-options="iconCls:'icon-add'" onclick="addxl()"><spring:message
							code="button.add" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xledit">
					<a class="easyui-linkbutton btn-red"
						data-options="iconCls:'icon-edit'" onclick="editxl()"><spring:message
							code="button.edit" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xlremove">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-remove'" onclick="removexl()"><spring:message
							code="button.delete" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xlsave">
					<a class="easyui-linkbutton btn-blue"
						data-options="iconCls:'icon-save'" onclick="savexl()"><spring:message
							code="button.save" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xlcancel">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-no'" onclick="cancelxl()"><spring:message
							code="button.cancel" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xlcopy">
					<a class="easyui-linkbutton btn-green"
						data-options="iconCls:'icon-copy'" onclick="copyxl()"><spring:message
							code="button.copy" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xlaudit">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-shenhe'" onclick="auditxl()"><spring:message
							code="button.audit" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xlcancelaudit">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-fanshenhe'" onclick="cancelAuditxl()"><spring:message
							code="button.cancelAudit" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xltoorder">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-supplier'" onclick="issuexl()"><spring:message
							code="button.generateworkorder" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xltomaterialapply">
					<a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-formula'"
						onclick="generatematapplyplanxl()"><spring:message
							code="button.generatematapplyplan" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_upxl">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-upper'" onclick="upxl()"><spring:message
							code="button.planup" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_downxl">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-down'" onclick="downxl()"><spring:message
							code="button.plandown" /></a>
				</auth:button>
				<auth:button code="JM_Mixer_PlanManagement_dayplan_xlexport">
					<a class="easyui-linkbutton btn-deep-blue"
						data-options="iconCls:'icon-excel'" onclick="export_xl()"><spring:message
							code="button.export" /></a>
				</auth:button>
			</div>
			<table id="plan_dgxl" class="easyui-datagrid" style="width:100%"
				data-options="  
	                fit:true,
	                fitColumns:false,
	                pagination:true,
	                rownumbers: true,
	                singleSelect: false,
	                toolbar: '#Plan_dg_toolbarxl',
	                striped:true,
	                method: 'get' 
	                ">
				<thead>
					<tr>
						<th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
						<th colspan="10">计划基本信息</th>
						<th colspan="6">配方基本信息</th>
						<th colspan="2">日计划量</th>
						<th colspan="2">早班计划量</th>
						<th colspan="2">中班计划量</th>
						<th colspan="2">晚班计划量</th>
						<th colspan="8">早班计划执行情况</th>
						<th colspan="8">中班计划执行情况</th>
						<th colspan="8">晚班计划执行情况</th>
						<!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES -->
						<th rowspan="2" data-options="field:'datasource_s',editor:close"><spring:message
								code="plan.column.datasource_s" /></th>
						<!-- 审核人 -->
						<th rowspan="2"
							data-options="field:'check_by_s',formatter:toUserName,editor:close"><spring:message
								code="plan.column.check_by_s" /></th>
						<!-- 审核时间 -->
						<th rowspan="2" data-options="field:'check_time_t',editor:close"><spring:message
								code="plan.column.check_time_t" /></th>
						<!-- 下发人 -->
						<th rowspan="2"
							data-options="field:'send_by_s',formatter:toUserName,editor:close"><spring:message
								code="plan.column.send_by_s" /></th>
						<!-- 下发时间 -->
						<th rowspan="2" data-options="field:'send_time_t',editor:close"><spring:message
								code="plan.column.send_time_t" /></th>
						<!-- 修改人 -->
						<th rowspan="2"
							data-options="field:'changed_by_s',formatter:toUserName,editor:close"><spring:message
								code="plan.column.changed_by_s" /></th>
						<!-- 修改时间 -->
						<th rowspan="2" data-options="field:'changed_time_t',editor:close"><spring:message
								code="plan.column.changed_time_t" /></th>
						<!-- 创建人 -->
						<th rowspan="2"
							data-options="field:'created_by_s',formatter:toUserName,editor:close"><spring:message
								code="plan.column.created_by_s" /></th>
						<!-- 创建时间 -->
						<th rowspan="2" data-options="field:'created_time_t',editor:close"><spring:message
								code="plan.column.created_time_t" /></th>
					</tr>
					<tr>
						<!-- 计划基本信息 -->
						<!-- 计划生产日期 -->
						<th
							data-options="field:'plan_date_s',width:80,editor:{type:'textbox',
	                    	options:{
	                    		disabled:true
	                    	}}"><spring:message
								code="plan.column.plan_date_s" /></th>
						<!-- 日计划号 -->
						<th
							data-options="field:'plan_no_s',width:140,editor:{type:'textbox',
	                    	options:{
	                    		required:true
	                    	}}"><spring:message
								code="plan.column.plan_no_s" /></th>
						<!-- 审核状态：0-未审核、1-已审核 -->
						<th
							data-options="field:'plan_status_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.plan_status_s" /></th>
						<!-- 下发标识：0-未下发、1-已下发、2-下发失败 -->
						<th
							data-options="field:'send_state_s',formatter:sendstateFormatter,editor:close"><spring:message
								code="plan.column.send_state_s" /></th>
						<!-- 机台名称 -->
						<th
							data-options="field:'equip_code_s',width:150,formatter:equipCodeFormatterXl,editor:{type:'combobox',options:{
                    					valueField:'p_line_name',
				            			textField:'description',
                                        required:true, 
                                        data:xlequipList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
									    onSelect:onequipcodeselect2,
										filter: function(q, row){
								        var opts = $(this).combobox('options');
								        return row[opts.textField].indexOf(q) >= 0;
								    	}}}"><spring:message
								code="plan.column.equip_name_s" /></th>
						<!--执行顺序-->
						<th
							data-options="field:'spare8_s',editor:{type:'textbox',options:{disabled:true}}"><spring:message
								code="mixdayplan.column.spare8_s" /></th>
						<!-- 硫变仪机台条码 -->
						<th data-options="field:'sa_equip_code_s',editor:{type:'textbox'}"><spring:message
								code="plan.column.sa_equip_code_s" /></th>
						<!-- 门尼仪机台条码 -->
						<th data-options="field:'mi_equip_code_s',editor:{type:'textbox'}"><spring:message
								code="plan.column.mi_equip_code_s" /></th>
						<!-- 物料编码 -->
						<th
							data-options="field:'material_code_s',width:120,editor:{type:'combobox',options:{
                 			valueField:'mater_code_s',
					        textField:'mater_code_s',
                            required:true, 
						    editable:'true',
						    limitToList:false,
						    panelHeight:100,
						    onSelect:materialcodechangedxl}}"><spring:message
								code="plan.column.material_code_s" /></th>
						<!-- 物料名称 -->
						<th
							data-options="field:'material_name_s',width:120,editor:{type:'textbox',
	                        options:{disabled:true}}"><spring:message
								code="plan.column.material_name_s" /></th>
						<!-- 配方基本信息 -->
						<!-- 密炼生成配方编号 -->
						<th
							data-options="field:'mixrecipe_recipe_code_s',width:130,editor:{type:'combobox',
                               options:{
	                               method:'get',
	                               required:true,
	                               panelHeight:100,
	                               valueField:'recipe_code_s',
						           textField:'recipe_code_s',
						           onSelect:onRecipeSelect2
						       }}"><spring:message
								code="plan.column.mixrecipe_recipe_code_s" /></th>
						<!-- 密炼配方BOM版本 -->
						<th
							data-options="field:'recipe_bom_version_s',editor:{type:'textbox',
	                        options:{disabled:true}}"><spring:message
								code="plan.column.recipe_bom_version_s" /></th>
						<!-- 是否有等同物料 -->
						<th
							data-options="field:'spare9_s',formatter:isspare9Formatter,editor:{type:'combobox',
				            options:
	                            { 
	                              editable:false,
	                              valueField:'value',
	                              textField:'text',
	                              method:'get',
	                              data: [{
									text: '否',
									value: 0
								},{
									text: '是',
									value: 1
								}],
                            required:true}}"><spring:message
								code="mixdayplan.column.spare9_s" /></th>
						<!-- 等同物料编码 -->
						<th
							data-options="field:'spare10_s',width:120,formatter:materialnameformatter,editor:{type:'textbox'}"><spring:message
								code="mixdayplan.column.spare10_s" /></th>
						<!-- 快检检验配方编号 -->
						<th
							data-options="field:'quickcheck_recipe_code_s',width:130,editor:{type:'combobox',
                               options:{
	                               method:'get',
	                               panelHeight:100,
	                               valueField:'recipe_code_s',
						           textField:'recipe_code_s'
						       }}"><spring:message
								code="plan.column.quickcheck_recipe_code_s" /></th>
						<!-- 密炼快检检验百分比 -->
						<th
							data-options="field:'sip_s',editor:{type:'textbox',options:{editable:false}}"><spring:message
								code="mixdayplan.column.sip_s" /></th>
						<!-- 日计划量 -->
						<th
							data-options="field:'qty_plan_i',width:60,editor:{type:'numberspinner',options:{min:1,max:8888888,disabled:true,editable:false,required:true,icons:[]}}"><spring:message
								code="plan.column.qty_plan_i" /></th>
						<!-- 日计划检验量：车数*检验百分比 -->
						<th
							data-options="field:'qty_check_plan_f',width:60,editor:{type:'numberspinner',options:{min:0,max:8888888,disabled:true,editable:false,icons:[]}}"><spring:message
								code="plan.column.qty_check_plan_f" /></th>

						<!-- 早班计划量 -->
						<th
							data-options="field:'qty_mor_i',width:60,editor:{type:'numberspinner',options:{required:true,min:1,max:8888888,onChange:onCountChange2,icons:[]}}"><spring:message
								code="plan.column.qty_mor_i" /></th>
						<!-- 早班计划检验量：车数*检验百分比 -->
						<th
							data-options="field:'qty_check_mor_f',width:60,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCheckCountChange2,icons:[]}}"><spring:message
								code="plan.column.qty_check_mid_f" /></th>

						<!-- 中班计划量 -->
						<th
							data-options="field:'qty_mid_i',width:60,editor:{type:'numberspinner',options:{required:true,min:1,max:8888888,onChange:onCountChange2,icons:[]}}"><spring:message
								code="plan.column.qty_mid_i" /></th>
						<!-- 中班计划检验量：车数*检验百分比 -->
						<th
							data-options="field:'qty_check_mid_f',width:60,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCheckCountChange2,icons:[]}}"><spring:message
								code="plan.column.qty_check_mor_f" /></th>

						<!-- 晚班计划量 -->
						<th
							data-options="field:'qty_nig_i',width:60,editor:{type:'numberspinner',options:{required:true,min:1,max:8888888,onChange:onCountChange2,icons:[]}}"><spring:message
								code="plan.column.qty_nig_i" /></th>
						<!-- 晚班计划检验量：车数*检验百分比 -->
						<th
							data-options="field:'qty_check_nig_f',width:60,editor:{type:'numberspinner',options:{min:0,max:8888888,onChange:onCheckCountChange2,icons:[]}}"><spring:message
								code="plan.column.qty_check_nig_f" /></th>

						<!-- 早班计划执行情况 -->
						<!-- 早班状态 -->
						<th
							data-options="field:'status_mor_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_mor_s" /></th>
						<!-- 早班检查状态 -->
						<th
							data-options="field:'status_check_mor_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_check_mor_s" /></th>
						<!-- 早班检验合格数量 -->
						<th data-options="field:'qty_check_good_mor_i',editor:close"><spring:message
								code="plan.column.qty_check_good_mor_i" /></th>
						<!-- 早班检验不合格数量 -->
						<th data-options="field:'qty_check_bad_mor_i',editor:close"><spring:message
								code="plan.column.qty_check_bad_mor_i" /></th>
						<!-- 早班执行开始时间 -->
						<th data-options="field:'act_start_time_mor_t',editor:close"><spring:message
								code="plan.column.act_start_time_mor_t" /></th>
						<!-- 早班执行结束时间 -->
						<th data-options="field:'act_finish_time_mor_t',editor:close"><spring:message
								code="plan.column.act_finish_time_mor_t" /></th>
						<!-- 早班检查开始时间 -->
						<th data-options="field:'act_start_checktime_mor_t',editor:close"><spring:message
								code="plan.column.act_start_checktime_mor_t" /></th>
						<!-- 早班检查结束时间 -->
						<th data-options="field:'act_finish_checktime_mor_t',editor:close"><spring:message
								code="plan.column.act_finish_checktime_mor_t" /></th>

						<!-- 中班计划执行情况 -->
						<!-- 中班状态 -->
						<th
							data-options="field:'status_mid_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_mid_s" /></th>
						<!-- 中班检查状态 -->
						<th
							data-options="field:'status_check_mid_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_check_mid_s" /></th>
						<!-- 中班检验合格数量 -->
						<th data-options="field:'qty_check_good_mid_i',editor:close"><spring:message
								code="plan.column.qty_check_good_mid_i" /></th>
						<!-- 中班检验不合格数量 -->
						<th data-options="field:'qty_check_bad_mid_i',editor:close"><spring:message
								code="plan.column.qty_check_bad_mid_i" /></th>
						<!-- 中班执行开始时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_start_time_mid_t',editor:close"><spring:message
								code="plan.column.act_start_time_mid_t" /></th>
						<!-- 中班执行结束时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_finish_time_mid_t',editor:close"><spring:message
								code="plan.column.act_finish_time_mid_t" /></th>
						<!-- 中班检查开始时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_start_checktime_mid_t',editor:close"><spring:message
								code="plan.column.act_start_checktime_mid_t" /></th>
						<!-- 中班检查结束时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_finish_checktime_mid_t',editor:close"><spring:message
								code="plan.column.act_finish_checktime_mid_t" /></th>

						<!-- 晚班计划执行情况 -->
						<!-- 晚班状态 -->
						<th
							data-options="field:'status_nig_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_nig_s" /></th>
						<!-- 晚班检查状态 -->
						<th
							data-options="field:'status_check_nig_s',formatter:codeFormatter,editor:close"><spring:message
								code="plan.column.status_check_nig_s" /></th>
						<!-- 晚班检验合格数量 -->
						<th data-options="field:'qty_check_good_nig_i',editor:close"><spring:message
								code="plan.column.qty_check_good_nig_i" /></th>
						<!-- 晚班检验不合格数量 -->
						<th data-options="field:'qty_check_bad_nig_i',editor:close"><spring:message
								code="plan.column.qty_check_bad_nig_i" /></th>
						<!-- 晚班执行开始时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_start_time_nig_t',editor:close"><spring:message
								code="plan.column.act_start_time_nig_t" /></th>
						<!-- 晚班执行结束时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_finish_time_nig_t',editor:close"><spring:message
								code="plan.column.act_finish_time_nig_t" /></th>
						<!-- 晚班检查开始时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_start_checktime_nig_t',editor:close"><spring:message
								code="plan.column.act_start_checktime_nig_t" /></th>
						<!-- 晚班检查结束时间：展示DD HH:MM:MM -->
						<th data-options="field:'act_finish_checktime_nig_t',editor:close"><spring:message
								code="plan.column.act_finish_checktime_nig_t" /></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<div id="mixplanjl-copy" title="<spring:message code="button.copy" />"
		class="easyui-dialog" style="width:90%;height:90%;"
		data-options="
                closed:true,
                iconCls: 'icon-save',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#mixplanjl-copy').dialog('close');
                    }
                }],
                onOpen:function(){
                    $('#copyWinjl').attr('src','view?page=mix/planManagement/mixDayPlan/mixdayplancopyjl&factory='+factory);
                }
            ">
		<iframe id="copyWinjl" src="" width="100%" height="100%"
			frameborder="no" border="0" marginwidth="0" marginheight="0"
			scrolling="no" allowtransparency="yes"> </iframe>
	</div>

	<div id="mixplanxl-copy" title="<spring:message code="button.copy" />"
		class="easyui-dialog" style="width:90%;height:90%;"
		data-options="
                closed:true,
                iconCls: 'icon-save',
                maximizable:true,
                buttons: [{
                    iconCls:'icon-no',
                    text:'<spring:message code="button.close" />',
                    handler:function(){
                       $('#mixplanxl-copy').dialog('close');
                    }
                }],
                onOpen:function(){
                    $('#copyWinxl').attr('src','view?page=mix/planManagement/mixDayPlan/mixdayplancopyxl&factory='+factory);
                }
            ">
		<iframe id="copyWinxl" src="" width="100%" height="100%"
			frameborder="no" border="0" marginwidth="0" marginheight="0"
			scrolling="no" allowtransparency="yes"> </iframe>
	</div>
	<div id="equalmaterial_dlgjl" class="easyui-dialog"
		title="等同物料选择(有等同物料必须选择等同物料,每组等同物料只能选择一个,类型为称量不可选)"
		style="width:80%;height:70%;"
		data-options="
            resizable:true,
			modal:true,
            iconCls:'icon-window',
            closed:true,
            buttons: [{
                text:'保存',
                iconCls:'icon-ok',
                handler:function(){
                    dosaveEqalMaterialjl();
                }
            },{
                text:'取消',
                 iconCls:'icon-cancel',
                handler:function(){
                    cancelEqalMaterialjl();
                }
            }]
            ">
		<table id="equalmaterialdgjl" class="easyui-datagrid"
			style="width:150%"
			data-options="  
			    fit:true,
				fitColumns:true,
				singleSelect: false,									 
				onLoadSuccess:onLoadSuccessjl, 
				striped:true,
				onSelect:selectrowjl,
				method: 'get'">
			<thead>
				<!--rowStyler:rowStylerChange,-->
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<!-- 等同物料分组-->
					<th data-options="field:'GROUPNAME_S'"><spring:message
							code="等同物料分组" /></th>
					<!-- 类型-->
					<th data-options="field:'FLAG'"><spring:message
							code="mixdayplan.column.flag" /></th>
					<!-- 称量物料编码-->
					<th data-options="field:'CHILD_MATERCODE_S'"><spring:message
							code="称量物料编码" /></th>
					<!-- 称量物料名称-->
					<th data-options="field:'CHILD_MATERNAME_S'"><spring:message
							code="称量物料名称" /></th>
					<!-- 等同物料编码-->
					<th data-options="field:'MATERIALCODE_S'"><spring:message
							code="等同物料编码" /></th>
					<!-- 等同物料名称-->
					<th data-options="field:'MATERIALNAME_S'"><spring:message
							code="等同物料名称" /></th>
					<!-- 等同物料等级-->
					<th data-options="field:'GRADE_I'"><spring:message
							code="等同物料等级" /></th>
					<!-- 原材料库存量-->
					<th data-options="field:'RMCOUNT'"><spring:message
							code="原材料库存量" /></th>
					<!-- 料罐配置机台-->
					<th data-options="field:'EQUIP_NAME_S'"><spring:message
							code="料罐配置机台" /></th>
					<!-- 配套供应商-->
					<th data-options="field:'SUPPLYCODE_S'"><spring:message
							code="配套供应商" /></th>
					<!-- 原材料供应商-->
					<th data-options="field:'SUPPLIER_CODE_S'"><spring:message
							code="原材料供应商" /></th>
					<!-- 进厂批次-->
					<th data-options="field:'LOT_NO_S'"><spring:message
							code="进厂批次" /></th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="equalmaterial_dlgxl" class="easyui-dialog"
		title="等同物料选择(有等同物料必须选择等同物料,每组等同物料只能选择一个,类型为称量不可选)"
		style="width:80%;height:70%;"
		data-options="
            resizable:true,
			modal:true,
            iconCls:'icon-window',
            closed:true,
            buttons: [{
                text:'保存',
                iconCls:'icon-ok',
                handler:function(){
                    dosaveEqalMaterialxl();
                }
            },{
                text:'取消',
                 iconCls:'icon-cancel',
                handler:function(){
                    cancelEqalMaterialxl();
                }
            }]
            ">
		<table id="equalmaterialdgxl" class="easyui-datagrid"
			style="width:150%"
			data-options="  
			    fit:true,
				fitColumns:true,
				singleSelect: false,									 
				onLoadSuccess:onLoadSuccessxl, 
				striped:true,
				onSelect:selectrowxl,
				method: 'get'">
			<thead>
				<!--rowStyler:rowStylerChange,-->
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<!-- 等同物料分组-->
					<th data-options="field:'GROUPNAME_S'"><spring:message
							code="等同物料分组" /></th>
					<!-- 类型-->
					<th data-options="field:'FLAG'"><spring:message
							code="mixdayplan.column.flag" /></th>
					<!-- 称量物料编码-->
					<th data-options="field:'CHILD_MATERCODE_S'"><spring:message
							code="称量物料编码" /></th>
					<!-- 称量物料名称-->
					<th data-options="field:'CHILD_MATERNAME_S'"><spring:message
							code="称量物料名称" /></th>
					<!-- 等同物料编码-->
					<th data-options="field:'MATERIALCODE_S'"><spring:message
							code="等同物料编码" /></th>
					<!-- 等同物料名称-->
					<th data-options="field:'MATERIALNAME_S'"><spring:message
							code="等同物料名称" /></th>
					<!-- 等同物料等级-->
					<th data-options="field:'GRADE_I'"><spring:message
							code="等同物料等级" /></th>
					<!-- 原材料库存量-->
					<th data-options="field:'RMCOUNT'"><spring:message
							code="原材料库存量" /></th>
					<!-- 料罐配置机台-->
					<th data-options="field:'EQUIP_NAME_S'"><spring:message
							code="料罐配置机台" /></th>
					<!-- 配套供应商-->
					<th data-options="field:'SUPPLYCODE_S'"><spring:message
							code="配套供应商" /></th>
					<!-- 原材料供应商-->
					<th data-options="field:'SUPPLIER_CODE_S'"><spring:message
							code="原材料供应商" /></th>
					<!-- 进厂批次-->
					<th data-options="field:'LOT_NO_S'"><spring:message
							code="进厂批次" /></th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>