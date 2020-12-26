<!-- 

    作者      :王超
    时间      :2020-08-07 09:08:35 
    页面名称:密炼工单跟踪
    文件关联:
        WorkOrderEdit.java
        WorkOrderEditController.java
        WorkOrderEditServiceImpl.java
        WorkOrderEditServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="workorderedit.js.jsp"%>
<script type="text/javascript" src="dict/302,054.js"></script>
<body class="easyui-layout" fit="true">
	<div class="easyui-tabs"
		data-options="region:'center',split:true,border:false">
		<div title="胶料计划">
			<div id="WorkOrderEdit_dg_toolbarjl">
				<form id="WorkOrderEdit_search_formjl" class="form">
					<!-- 工单生产日期 -->
					<spring:message code="workorderedit.column.wo_date_s" />：
					<input name="filter[wo_date_s]" style="width:100px;"
						id="wo_date_sjl" type="text" class="easyui-datebox"
						data-options="onChange:filterjl,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:''">
					<script type="text/javascript">
						$("#wo_date_sjl")
								.val(new Calendar().format("yyyyMMdd"));
					</script>
					<!-- 机台条码  -->
					<spring:message code="workorderedit.column.equip_code_s" />：
					<input name="filter[equip_code_s]" style="width:140px;"
						id="equip_code_s" type="text" class="easyui-combobox"
						data-options="valueField:'p_line_name',
		            			  textField:'description',
                                  required:false, 
                                  data:jlequipList,
								  method: 'get',
							      editable:'true',
							      limitToList:false,
							      panelHeight:200">
					<!-- 生产班次 -->
					<spring:message code="workorderedit.column.wo_shift_s" />：
					<input name="filter[wo_shift_s]" style="width:100px;"
						id="wo_shift_s" type="text" class="easyui-combotree"
						,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:150,
	              			 url:'dict/code/302',
	              			 method:'get'">
					<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
					<spring:message code="workorderedit.column.wo_status_s" />：
					<input name="filter[wo_status_s]" style="width:100px;"
						id="wo_status_s" type="text" class="easyui-combotree"
						,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/054',
	              			 method:'get'">
					<!-- 工单号 -->
					<spring:message code="workorderedit.column.wo_no_s" />：
					<input name="filter[wo_no_s]" style="width:140px;" id="wo_no_s"
						type="text" class="easyui-textbox" data-options="label:''">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filterjl()"><spring:message
							code="button.search" /></a> <br>
					<!-- 物料编码 -->
					<spring:message code="workorderedit.column.material_code_s" />：
					<input name="filter[material_code_s]" style="width:100px;"
						id="material_code_s" type="text" class="easyui-textbox"
						data-options="label:''">
					<!-- 下发标识 -->
					<spring:message code="workorderedit.column.send_state_s" />：
					<input name="filter[send_state_s]" style="width:140px;"
						id="send_state_s" type="text" class="easyui-combobox"
						data-options="editable:true,
							     data:[
							     {'value':'0','text':'未下发'},
							     {'value':'1','text':'已下发'},
							     {'value':'2','text':'下发失败'}],
							     valueField:'value',
							     textField:'text'">
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_sendjl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-version'" onclick="issuejl()"><spring:message
								code="button.returnissued" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_setmasterjl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-user'" onclick="setupjl()"><spring:message
								code="button.mastersetup" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_closejl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-no'" onclick="closejl()"><spring:message
								code="button.closewo" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_upjl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-upper'" onclick="upjl()"><spring:message
								code="button.upwo" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_downjl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-down'" onclick="downjl()"><spring:message
								code="button.downwo" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_patchjl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-list'" onclick="patchjl()"><spring:message
								code="button.pibatch" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_exportjl">
						<a class="easyui-linkbutton btn-deep-blue"
							data-options="iconCls:'icon-excel'" onclick="export_jl()"><spring:message
								code="button.export" /></a>
					</auth:button>
				</form>
			</div>
			<table id="workorderedit_dgjl" class="easyui-datagrid"
				style="width:100%"
				data-options="  
	                fit:true,
	                fitColumns:false,
	                pagination:true,
	                rownumbers: true,
	                singleSelect: false,
	                toolbar: '#WorkOrderEdit_dg_toolbarjl',
	                striped:true,
	                method: 'get' 
	                ">
				<thead>
					<tr>
						<th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
						<th colspan="16">生产工单信息</th>
						<th colspan="13">工单快检信息</th>
						<th colspan="8">其它</th>
					</tr>
					<tr>
						<!-- 生产工单信息 -->
						<!-- 工单号 -->
						<th data-options="field:'wo_no_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_no_s" /></th>
						<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
						<th
							data-options="field:'wo_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_status_s" /></th>
						<!-- 下发标识 -->
						<th
							data-options="field:'send_state_s',formatter:sendstateformatter,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.send_state_s" /></th>
						<!-- 工单生产日期 -->
						<th data-options="field:'wo_date_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_date_s" /></th>
						<!-- 工单班次：302001-早班、302002-中班、302003-晚班 -->
						<th
							data-options="field:'wo_shift_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_shift_s" /></th>
						<!-- 工单顺序号 -->
						<th data-options="field:'wo_seq_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_seq_i" /></th>
						<!-- 工单计划数量 -->
						<th data-options="field:'qty_plan_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_plan_i" /></th>
						<!-- 工单完成数量 -->
						<th data-options="field:'qty_complete_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_complete_i" /></th>
						<!-- 机台名称 -->
						<th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.equip_name_s" /></th>
						<!-- 物料编码 -->
						<th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.material_code_s" /></th>
						<!-- 物料名称 -->
						<th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.material_name_s" /></th>
						<!-- 密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE -->
						<th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.recipe_code_s" /></th>
						<!-- 密炼配方BOM版本 -->
						<th
							data-options="field:'recipe_bom_version_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.recipe_bom_version_s" /></th>
						<!-- 当前称量车次 -->
						<th data-options="field:'weightche_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.weightche_s" /></th>
						<!-- 密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO -->
						<th data-options="field:'plan_no_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.plan_no_s" /></th>
						<!-- 执行开始时间 -->
						<th
							data-options="field:'act_start_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.act_start_time_t" /></th>
						<!-- 执行结束时间 -->
						<th
							data-options="field:'act_finish_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.act_finish_time_t" /></th>

						<!-- 工单快检信息 -->
						<!-- 硫变仪机台条码 -->
						<th data-options="field:'sa_equip_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.sa_equip_code_s" /></th>
						<!-- 门尼仪机台条码 -->
						<th data-options="field:'mi_equip_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.mi_equip_code_s" /></th>
						<!-- 快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE -->
						<th
							data-options="field:'quickcheck_recipe_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.quickcheck_recipe_code_s" /></th>
						<!-- 快检工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭 -->
						<th
							data-options="field:'status_check_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.status_check_s" /></th>
						<!-- 工单检验量：车数*检验百分比 -->
						<th data-options="field:'qty_check_f',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_check_f" /></th>
						<!-- 工单检验完成量 -->
						<th
							data-options="field:'qty_check_complete_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_check_complete_i" /></th>
						<!-- 开始检验车次号 -->
						<th
							data-options="field:'begin_check_train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.begin_check_train_num_s" /></th>
						<!-- 结束检验车次号 -->
						<th
							data-options="field:'end_check_train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.end_check_train_num_s" /></th>
						<!-- 当前检验车次 -->
						<th data-options="field:'train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.train_num_s" /></th>
						<!-- 检验合格数量 -->
						<th
							data-options="field:'qty_check_good_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_check_good_i" /></th>
						<!-- 检验不合格数量 -->
						<th data-options="field:'qty_check_bad_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_check_bad_i" /></th>
						<!-- 执行开始时间：展示DD HH:MM:MM -->
						<th
							data-options="field:'act_start_checktime_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.act_start_checktime_t" /></th>
						<!-- 执行结束时间：展示DD HH:MM:MM -->
						<th
							data-options="field:'act_finish_checktime_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.act_finish_checktime_t" /></th>

						<!-- 其它 -->
						<!-- 下发人 -->
						<th
							data-options="field:'send_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.send_by_s" /></th>
						<!-- 下发时间 -->
						<th data-options="field:'send_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.send_time_t" /></th>
						<!-- 审核人 -->
						<th
							data-options="field:'check_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.check_by_s" /></th>
						<!-- 审核时间 -->
						<th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.check_time_t" /></th>
						<!-- 修改人 -->
						<th
							data-options="field:'changed_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.changed_by_s" /></th>
						<!-- 修改时间 -->
						<th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.changed_time_t" /></th>
						<!-- 创建人 -->
						<th
							data-options="field:'created_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.created_by_s" /></th>
						<!-- 创建时间 -->
						<th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.created_time_t" /></th>
					</tr>
				</thead>
			</table>
		</div>
		<div title="小料计划">
			<div id="WorkOrderEdit_dg_toolbarxl">
				<form id="WorkOrderEdit_search_formxl" class="form">
					<!-- 工单生产日期 -->
					<spring:message code="workorderedit.column.wo_date_s" />：
					<input name="filter[wo_date_s]" style="width:100px;"
						id="wo_date_sxl" type="text" class="easyui-datebox"
						data-options="onChange:filterxl,formatter:dateFormat,buttons:[],parser:dateParser,labelWidth:100,label:''">
					<script type="text/javascript">
						$("#wo_date_sxl")
								.val(new Calendar().format("yyyyMMdd"));
					</script>
					<!-- 机台条码  -->
					<spring:message code="workorderedit.column.equip_code_s" />：
					<input name="filter[equip_code_s]" style="width:140px;"
						id="equip_code_s" type="text" class="easyui-combobox"
						data-options="valueField:'p_line_name',
		            			  textField:'description',
                                  required:false, 
                                  data:xlequipList,
								  method: 'get',
							      editable:'true',
							      limitToList:false,
							      panelHeight:200">
					<!-- 生产班次 -->
					<spring:message code="workorderedit.column.wo_shift_s" />：
					<input name="filter[wo_shift_s]" style="width:100px;"
						id="wo_shift_s" type="text" class="easyui-combotree"
						,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:150,
	              			 url:'dict/code/302',
	              			 method:'get'">
					<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
					<spring:message code="workorderedit.column.wo_status_s" />：
					<input name="filter[wo_status_s]" style="width:100px;"
						id="wo_status_s" type="text" class="easyui-combotree"
						,
                        data-options="label:'',
	              			 required:false,
	              			 panelHeight:200,
	              			 url:'dict/code/052',
	              			 method:'get'">
					<!-- 工单号 -->
					<spring:message code="workorderedit.column.wo_no_s" />：
					<input name="filter[wo_no_s]" style="width:140px;" id="wo_no_s"
						type="text" class="easyui-textbox" data-options="label:''">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filterxl()"><spring:message
							code="button.search" /></a> <br>
					<!-- 物料编码 -->
					<spring:message code="workorderedit.column.material_code_s" />：
					<input name="filter[material_code_s]" style="width:100px;"
						id="material_code_s" type="text" class="easyui-textbox"
						data-options="label:''">
					<!-- 下发标识 -->
					<spring:message code="workorderedit.column.send_state_s" />：
					<input name="filter[send_state_s]" style="width:140px;"
						id="send_state_s" type="text" class="easyui-combobox"
						data-options="editable:true,
							     data:[
							     {'value':'0','text':'未下发'},
							     {'value':'1','text':'已下发'},
							     {'value':'2','text':'下发失败'}],
							     valueField:'value',
							     textField:'text'">
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_sendxl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-version'" onclick="issuexl()"><spring:message
								code="button.returnissued" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_setmasterxl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-user'" onclick="setupxl()"><spring:message
								code="button.mastersetup" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_closexl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-no'" onclick="closexl()"><spring:message
								code="button.closewo" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_upxl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-upper'" onclick="upxl()"><spring:message
								code="button.upwo" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_downxl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-down'" onclick="downxl()"><spring:message
								code="button.downwo" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_patchxl">
						<a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-list'" onclick="patchxl()"><spring:message
								code="button.pibatch" /></a>
					</auth:button>
					<auth:button code="JM_Mixer_PlanManagement_woOrderEdit_exportxl">
						<a class="easyui-linkbutton btn-deep-blue"
							data-options="iconCls:'icon-excel'" onclick="export_xl()"><spring:message
								code="button.export" /></a>
					</auth:button>
				</form>
			</div>
			<table id="workorderedit_dgxl" class="easyui-datagrid"
				style="width:100%"
				data-options="  
	                fit:true,
	                fitColumns:false,
	                pagination:true,
	                rownumbers: true,
	                singleSelect: false,
	                toolbar: '#WorkOrderEdit_dg_toolbarxl',
	                striped:true,
	                method: 'get' 
	                ">
				<thead>
					<tr>
						<th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
						<th colspan="16">生产工单信息</th>
						<th colspan="13">工单快检信息</th>
						<th colspan="8">其它</th>
					</tr>
					<tr>
						<!-- 生产工单信息 -->
						<!-- 工单号 -->
						<th data-options="field:'wo_no_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_no_s" /></th>
						<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
						<th
							data-options="field:'wo_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_status_s" /></th>
						<!-- 下发标识 -->
						<th
							data-options="field:'send_state_s',formatter:sendstateformatter,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.send_state_s" /></th>
						<!-- 工单生产日期 -->
						<th data-options="field:'wo_date_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_date_s" /></th>
						<!-- 工单班次：302001-早班、302002-中班、302003-晚班 -->
						<th
							data-options="field:'wo_shift_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_shift_s" /></th>
						<!-- 工单顺序号 -->
						<th data-options="field:'wo_seq_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.wo_seq_i" /></th>
						<!-- 工单计划数量 -->
						<th data-options="field:'qty_plan_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_plan_i" /></th>
						<!-- 工单完成数量 -->
						<th data-options="field:'qty_complete_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_complete_i" /></th>
						<!-- 机台名称 -->
						<th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.equip_name_s" /></th>
						<!-- 物料编码 -->
						<th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.material_code_s" /></th>
						<!-- 物料名称 -->
						<th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.material_name_s" /></th>
						<!-- 密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE -->
						<th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.recipe_code_s" /></th>
						<!-- 密炼配方BOM版本 -->
						<th
							data-options="field:'recipe_bom_version_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.recipe_bom_version_s" /></th>
						<!-- 当前称量车次 -->
						<th data-options="field:'weightche_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.weightche_s" /></th>
						<!-- 密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO -->
						<th data-options="field:'plan_no_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.plan_no_s" /></th>
						<!-- 执行开始时间 -->
						<th
							data-options="field:'act_start_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.act_start_time_t" /></th>
						<!-- 执行结束时间 -->
						<th
							data-options="field:'act_finish_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.act_finish_time_t" /></th>

						<!-- 工单快检信息 -->
						<!-- 硫变仪机台条码 -->
						<th data-options="field:'sa_equip_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.sa_equip_code_s" /></th>
						<!-- 门尼仪机台条码 -->
						<th data-options="field:'mi_equip_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.mi_equip_code_s" /></th>
						<!-- 快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE -->
						<th
							data-options="field:'quickcheck_recipe_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.quickcheck_recipe_code_s" /></th>
						<!-- 快检工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭 -->
						<th
							data-options="field:'status_check_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.status_check_s" /></th>
						<!-- 工单检验量：车数*检验百分比 -->
						<th data-options="field:'qty_check_f',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_check_f" /></th>
						<!-- 工单检验完成量 -->
						<th
							data-options="field:'qty_check_complete_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_check_complete_i" /></th>
						<!-- 开始检验车次号 -->
						<th
							data-options="field:'begin_check_train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.begin_check_train_num_s" /></th>
						<!-- 结束检验车次号 -->
						<th
							data-options="field:'end_check_train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.end_check_train_num_s" /></th>
						<!-- 当前检验车次 -->
						<th data-options="field:'train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.train_num_s" /></th>
						<!-- 检验合格数量 -->
						<th
							data-options="field:'qty_check_good_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_check_good_i" /></th>
						<!-- 检验不合格数量 -->
						<th data-options="field:'qty_check_bad_i',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.qty_check_bad_i" /></th>
						<!-- 执行开始时间：展示DD HH:MM:MM -->
						<th
							data-options="field:'act_start_checktime_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.act_start_checktime_t" /></th>
						<!-- 执行结束时间：展示DD HH:MM:MM -->
						<th
							data-options="field:'act_finish_checktime_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.act_finish_checktime_t" /></th>

						<!-- 其它 -->
						<!-- 下发人 -->
						<th
							data-options="field:'send_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.send_by_s" /></th>
						<!-- 下发时间 -->
						<th data-options="field:'send_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.send_time_t" /></th>
						<!-- 审核人 -->
						<th
							data-options="field:'check_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.check_by_s" /></th>
						<!-- 审核时间 -->
						<th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.check_time_t" /></th>
						<!-- 修改人 -->
						<th
							data-options="field:'changed_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.changed_by_s" /></th>
						<!-- 修改时间 -->
						<th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.changed_time_t" /></th>
						<!-- 创建人 -->
						<th
							data-options="field:'created_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.created_by_s" /></th>
						<!-- 创建时间 -->
						<th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderedit.column.created_time_t" /></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
	<div id="setup_dlg" class="easyui-dialog"
		title="<strong>主机手设置</strong>" maximizable="true" minimizable="true"
		style="width: 80%; height: 80%;"
		data-options="
			    resizable:true,
   			    modal:true,
                iconCls:'icon-window',
                closed:true">
		<div class="easyui-layout" fit="true" border="false"
			style="width: 700px; height: 350px;">
			<div
				data-options="region:'west',split:true,iconCls:'icon-curringmachine'"
				title="机台主机手信息" style="width: 45%">
				<table id="geterpcode_dg" class="easyui-datagrid"
					data-options="  
                        fit:true,
						fitColumns:true,
						singleSelect: true,																	 
						striped:true,																
						method: 'get'">
					<thead>
						<tr>
							<th data-options="field:'atr_key',checkbox:true" rowspan="1"></th>
							<th
								data-options="field:'ERPCODE_S',width:100,formatter:plmByPlinenameformatter"><spring:message
									code="机台条码" /></th>
							<th data-options="field:'DICTNAME_S',width:100"><spring:message
									code="设置信息" /></th>
							<th data-options="field:'DICTNAME_EN_S',width:100"><spring:message
									code="工号" /></th>
							<th data-options="field:'DICTNAME_TH_S',width:100"><spring:message
									code="姓名" /></th>
						</tr>
					</thead>
				</table>
			</div>
			<div data-options="region:'center',iconCls:'icon-user'" title="主机手信息">
				<div id="Setup_dg_toolbar">
					<form id="Setup_search_form" class="form">
						<span onclick="show()"> <input type="radio" name="radio"
							onclick="show()" value="real_time" checked> <spring:message
								code="<strong>当前用户</strong>" /> <input type="radio"
							name="radio" onclick="show()" value="his_time"> <spring:message
								code="<strong>全部用户</strong>" />
						</span> <a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-search'" onclick="filtersetup()"><spring:message
								code="button.search" /></a> <a class="easyui-linkbutton btn-black"
							data-options="iconCls:'icon-ok'" onclick="set()">确认</a>
					</form>
				</div>
				<table id="setupdlg" class="easyui-datagrid"
					data-options="
					    fit:true,
					    fitColumns:true,
						singleSelect: true,
						pagination:true,									 
						striped:true,	
						toolbar: '#Setup_dg_toolbar',								
						method: 'get'">
					<thead>
						<tr>
							<th data-options="field:'atr_key',checkbox:true" rowspan="1"></th>
							<th data-options="field:'created_by_s',width:100"><spring:message
									code="工号" /></th>
							<th data-options="field:'created_name_s',width:100"><spring:message
									code="姓名" /></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>
	<div id="equalmaterial_dlg" class="easyui-dialog" title="批报表"
		maximized="true" maximizable="true" minimizable="true"
		style="width: 70%;"
		data-options="
            resizable:true,
			modal:true,
            iconCls:'icon-window',
            closed:true">
		<table>
			<tr>
				<td><spen id="wo_no_s1"></spen> &nbsp;&nbsp;&nbsp; <spen
						id="equip_name_s1"></spen> &nbsp;&nbsp;&nbsp; <spen
						id="wo_shift_s1"></spen> &nbsp;&nbsp;&nbsp; <spen id="spare8_s1"></spen>&nbsp;&nbsp;&nbsp;
					<spen id="qty_plan_i1"></spen>&nbsp;&nbsp;&nbsp; <spen
						id="qty_complete_i1"></spen></td>
			</tr>
			<tr>
				<td><spen id="act_start_time_t1"></spen> &nbsp;&nbsp;&nbsp; <spen
						id="act_finish_time_t1"></spen></td>
			</tr>
		</table>
		<table id="equalmaterialdg" class="easyui-datagrid" title="报表明细"
			data-options="
		    	fit:true,
				fitColumns:true,
				singleSelect: false,
				pagination:true,									 
				striped:true,									
				method:'get'">
			<thead>
				<tr>
					<th data-options="field:'N_NAME_S'"><spring:message code="" /></th>
					<th data-options="field:'SERIAL_ID_I'"><spring:message
							code="车次号" /></th>
					<th data-options="field:'RECIPETIME_I'"><spring:message
							code="配方时间" /></th>
					<th data-options="field:'MIXTIME_I'"><spring:message
							code="炼胶时间" /></th>
					<th data-options="field:'INTERVALS_I'"><spring:message
							code="间隔时间" /></th>
					<th data-options="field:'ADDNRTIME_I'"><spring:message
							code="加胶时间" /></th>
					<th data-options="field:'ADDCBTIME_I'"><spring:message
							code="加炭黑时间" /></th>
					<th data-options="field:'ADDOILTIME_I'"><spring:message
							code="加油时间" /></th>
					<th data-options="field:'DISCHARGETEMP_F'"><spring:message
							code="排胶温度" /></th>
					<th data-options="field:'DISCHARGEPOWER_F'"><spring:message
							code="排胶功率" /></th>
					<th data-options="field:'DISCHARGEENERGY_F'"><spring:message
							code="排胶能量" /></th>
					<th data-options="field:'CALIBRATION_SAID'"><spring:message
							code="检量称" /></th>
					<th data-options="field:'SMALL_MATERIAL'"><spring:message
							code="小料" /></th>
					<th data-options="field:'RUBBER'"><spring:message code="胶料" /></th>
					<th data-options="field:'CARBON_BLACK'"><spring:message
							code="炭黑" /></th>
					<th data-options="field:'ALL_NUM'"><spring:message code="总重" /></th>
				</tr>
			</thead>
		</table>
	</div>
</body>
</html>