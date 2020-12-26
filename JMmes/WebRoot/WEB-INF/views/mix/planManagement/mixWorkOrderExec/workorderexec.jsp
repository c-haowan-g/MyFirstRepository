<!-- 

    作者      :王超
    时间      :2020-08-07 09:07:42 
    页面名称:密炼工单下发
    文件关联:
        WorkOrderExec.java
        WorkOrderExecController.java
        WorkOrderExecServiceImpl.java
        WorkOrderExecServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="workorderexec.js.jsp"%>
<script type="text/javascript" src="dict/302,054.js"></script>
<body class="easyui-layout" fit="true">
	<div class="easyui-tabs"
		data-options="region:'center',split:true,border:false">
		<div title="胶料计划">
			<div id="WorkOrderExec_dg_toolbarjl">
				<form id="WorkOrderExec_search_formjl" class="form">
					<!-- 机台条码  -->
					<spring:message code="workorderexec.column.equip_code_s" />：
					<input name="filter[equip_code_s]" id="equip_code_s" type="text"
						class="easyui-combobox"
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
					<!-- 工单号 -->
					<spring:message code="workorderexec.column.wo_no_s" />：
					<input name="filter[wo_no_s]" id="wo_no_s" type="text"
						class="easyui-textbox" data-options="label:''">
					<!-- 同步时间 -->
					<spring:message code="workorderexec.column.sync_create_time_t" />：
					<input name="filter[begintime]" editable="true"
						id="begin_created_timejl" type="text" class="easyui-datetimebox"
						style="width:160px" data-options="label:''">到 <input
						name="filter[endtime]" editable="true" id="end_created_timejl"
						type="text" class="easyui-datetimebox" style="width:160px"
						data-options="label:''"> <br>
					<!-- 数据同步处理标记：0-未处理、1-已处理 -->
					<spring:message code="workorderexec.column.sync_hand_flag_s" />：
					<input name="filter[sync_hand_flag_s]" id="sync_hand_flag_s"
						type="text" class="easyui-combobox"
						data-options="editable:true,
							     data:[
							     {'value':'0','text':'未处理'},
							     {'value':'1','text':'已处理'}],
							     valueField:'value',
							     textField:'text'">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filterjl()"><spring:message
							code="button.search" /></a>
					<auth:button code="JM_Mixer_PlanManagement_woOrderExec_export">
						<a class="easyui-linkbutton btn-deep-blue"
							data-options="iconCls:'icon-excel'" onclick="export_jl()"><spring:message
								code="button.export" /></a>
					</auth:button>
				</form>
			</div>
			<table id="workorderexec_dgjl" class="easyui-datagrid"
				style="width:100%"
				data-options="  
	                fit:true,
	                fitColumns:false,
	                pagination:true,
	                rownumbers: true,
	                singleSelect: false,
	                toolbar: '#WorkOrderExec_dg_toolbarjl',
	                striped:true,
	                method: 'get' 
	                ">
				<thead>
					<tr>
						<th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
						<th colspan="5">数据同步</th>
						<th colspan="12">生产工单信息</th>
						<th colspan="14">工单快检信息</th>
						<th colspan="8">其它</th>
					</tr>
					<tr>
						<!-- 数据同步 -->
						<!-- 数据同步处理：A-新增、U-修改、D-删除 -->
						<th data-options="field:'sync_flag_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_flag_s" /></th>
						<!-- 数据同步处理标记：0-未处理、1-已处理 -->
						<th
							data-options="field:'sync_hand_flag_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_hand_flag_s" /></th>
						<!-- 同步时间 -->
						<th
							data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_create_time_t" /></th>
						<!-- 数据同步处理反馈 -->
						<th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_hand_msg_s" /></th>
						<!-- 数据同步处理时间 -->
						<th
							data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_hand_time_t" /></th>

						<!-- 生产工单信息 -->
						<!-- 工单号 -->
						<th data-options="field:'wo_no_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_no_s" /></th>
						<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
						<th
							data-options="field:'wo_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_status_s" /></th>
						<!-- 工单生产日期 -->
						<th data-options="field:'wo_date_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_date_s" /></th>
						<!-- 工单班次：302001-早班、302002-中班、302003-晚班 -->
						<th
							data-options="field:'wo_shift_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_shift_s" /></th>
						<!-- 工单顺序号 -->
						<th data-options="field:'wo_seq_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_seq_i" /></th>
						<!-- 工单计划数量 -->
						<th data-options="field:'qty_plan_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_plan_i" /></th>
						<!-- 工单完成数量 -->
						<th data-options="field:'qty_complete_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_complete_i" /></th>
						<!-- 机台名称 -->
						<th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.equip_name_s" /></th>
						<!-- 物料编码 -->
						<th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.material_code_s" /></th>
						<!-- 物料名称 -->
						<th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.material_name_s" /></th>
						<!-- 密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE -->
						<th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.recipe_code_s" /></th>
						<!-- 密炼配方BOM版本 -->
						<th
							data-options="field:'recipe_bom_version_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.recipe_bom_version_s" /></th>

						<!-- 工单快检信息 -->
						<!-- 当前称量车次 -->
						<th data-options="field:'weightche_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.weightche_s" /></th>
						<!-- 密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO -->
						<th data-options="field:'plan_no_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.plan_no_s" /></th>
						<!-- 执行开始时间 -->
						<th
							data-options="field:'act_start_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.act_start_time_t" /></th>
						<!-- 执行结束时间 -->
						<th
							data-options="field:'act_finish_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.act_finish_time_t" /></th>
						<!-- 快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE -->
						<th
							data-options="field:'quickcheck_recipe_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.quickcheck_recipe_code_s" /></th>
						<!-- 快检工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭 -->
						<th data-options="field:'status_check_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.status_check_s" /></th>
						<!-- 工单检验量：车数*检验百分比 -->
						<th data-options="field:'qty_check_f',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_check_f" /></th>
						<!-- 工单检验完成量 -->
						<th
							data-options="field:'qty_check_complete_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_check_complete_i" /></th>
						<!-- 开始检验车次号 -->
						<th
							data-options="field:'begin_check_train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.begin_check_train_num_s" /></th>
						<!-- 结束检验车次号 -->
						<th
							data-options="field:'end_check_train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.end_check_train_num_s" /></th>
						<!-- 检验合格数量 -->
						<th
							data-options="field:'qty_check_good_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_check_good_i" /></th>
						<!-- 检验不合格数量 -->
						<th data-options="field:'qty_check_bad_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_check_bad_i" /></th>
						<!-- 执行开始时间：展示DD HH:MM:MM -->
						<th
							data-options="field:'act_start_checktime_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.act_start_checktime_t" /></th>
						<!-- 执行结束时间：展示DD HH:MM:MM -->
						<th
							data-options="field:'act_finish_checktime_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.act_finish_checktime_t" /></th>

						<!-- 工单快检信息 -->
						<!-- 下发人 -->
						<th
							data-options="field:'send_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.send_by_s" /></th>
						<!-- 下发时间 -->
						<th data-options="field:'send_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.send_time_t" /></th>
						<!-- 审核人 -->
						<th
							data-options="field:'check_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.check_by_s" /></th>
						<!-- 审核时间 -->
						<th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.check_time_t" /></th>
						<!-- 修改人 -->
						<th
							data-options="field:'changed_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.changed_by_s" /></th>
						<!-- 修改时间 -->
						<th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.changed_time_t" /></th>
						<!-- 创建人 -->
						<th
							data-options="field:'created_by_s',formatter:toUserName,editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.created_by_s" /></th>
						<!-- 创建时间 -->
						<th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.created_time_t" /></th>
					</tr>
				</thead>
			</table>
		</div>
		<div title="小料计划">
			<div id="WorkOrderExec_dg_toolbarxl">
				<form id="WorkOrderExec_search_formxl" class="form">
					<!-- 机台条码  -->
					<spring:message code="workorderexec.column.equip_code_s" />：
					<input name="filter[equip_code_s]" id="equip_code_s" type="text"
						class="easyui-combobox"
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
					<!-- 工单号 -->
					<spring:message code="workorderexec.column.wo_no_s" />：
					<input name="filter[wo_no_s]" id="wo_no_s" type="text"
						class="easyui-textbox" data-options="label:''">
					<!-- 同步时间 -->
					<spring:message code="workorderexec.column.sync_create_time_t" />：
					<input name="filter[begintime]" editable="true"
						id="begin_created_timexl" type="text" class="easyui-datetimebox"
						style="width:160px" data-options="label:''">到 <input
						name="filter[endtime]" editable="true" id="end_created_timexl"
						type="text" class="easyui-datetimebox" style="width:160px"
						data-options="label:''"> <br>
					<!-- 数据同步处理标记：0-未处理、1-已处理 -->
					<spring:message code="workorderexec.column.sync_hand_flag_s" />：
					<input name="filter[sync_hand_flag_s]" id="sync_hand_flag_s"
						type="text" class="easyui-combobox"
						data-options="editable:true,
							     data:[
							     {'value':'0','text':'未处理'},
							     {'value':'1','text':'已处理'}],
							     valueField:'value',
							     textField:'text'">
					<a class="easyui-linkbutton btn-yellow"
						data-options="iconCls:'icon-search'" onclick="filterxl()"><spring:message
							code="button.search" /></a>
					<auth:button code="JM_Mixer_PlanManagement_woOrderExec_export">
					<a class="easyui-linkbutton btn-deep-blue"
						data-options="iconCls:'icon-excel'" onclick="export_xl()"><spring:message
							code="button.export" /></a>
					</auth:button>
				</form>
			</div>
			<table id="workorderexec_dgxl" class="easyui-datagrid"
				style="width:100%"
				data-options="  
	                fit:true,
	                fitColumns:false,
	                pagination:true,
	                rownumbers: true,
	                singleSelect: false,
	                toolbar: '#WorkOrderExec_dg_toolbarxl',
	                striped:true,
	                method: 'get' 
	                ">
				<thead>
					<tr>
						<th rowspan="2" data-options="field:'atr_key',checkbox:true"></th>
						<th colspan="5">数据同步</th>
						<th colspan="12">生产工单信息</th>
						<th colspan="14">工单快检信息</th>
						<th colspan="8">其它</th>
					</tr>
					<tr>
						<!-- 数据同步 -->
						<!-- 数据同步处理：A-新增、U-修改、D-删除 -->
						<th data-options="field:'sync_flag_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_flag_s" /></th>
						<!-- 数据同步处理标记：0-未处理、1-已处理 -->
						<th
							data-options="field:'sync_hand_flag_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_hand_flag_s" /></th>
						<!-- 同步时间 -->
						<th
							data-options="field:'sync_create_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_create_time_t" /></th>
						<!-- 数据同步处理反馈 -->
						<th data-options="field:'sync_hand_msg_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_hand_msg_s" /></th>
						<!-- 数据同步处理时间 -->
						<th
							data-options="field:'sync_hand_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.sync_hand_time_t" /></th>

						<!-- 生产工单信息 -->
						<!-- 工单号 -->
						<th data-options="field:'wo_no_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_no_s" /></th>
						<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
						<th data-options="field:'wo_status_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_status_s" /></th>
						<!-- 工单生产日期 -->
						<th data-options="field:'wo_date_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_date_s" /></th>
						<!-- 工单班次：302001-早班、302002-中班、302003-晚班 -->
						<th data-options="field:'wo_shift_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_shift_s" /></th>
						<!-- 工单顺序号 -->
						<th data-options="field:'wo_seq_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.wo_seq_i" /></th>
						<!-- 工单计划数量 -->
						<th data-options="field:'qty_plan_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_plan_i" /></th>
						<!-- 工单完成数量 -->
						<th data-options="field:'qty_complete_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_complete_i" /></th>
						<!-- 机台名称 -->
						<th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.equip_name_s" /></th>
						<!-- 物料编码 -->
						<th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.material_code_s" /></th>
						<!-- 物料名称 -->
						<th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.material_name_s" /></th>
						<!-- 密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE -->
						<th data-options="field:'recipe_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.recipe_code_s" /></th>
						<!-- 密炼配方BOM版本 -->
						<th
							data-options="field:'recipe_bom_version_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.recipe_bom_version_s" /></th>

						<!-- 工单快检信息 -->
						<!-- 当前称量车次 -->
						<th data-options="field:'weightche_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.weightche_s" /></th>
						<!-- 密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO -->
						<th data-options="field:'plan_no_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.plan_no_s" /></th>
						<!-- 执行开始时间 -->
						<th
							data-options="field:'act_start_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.act_start_time_t" /></th>
						<!-- 执行结束时间 -->
						<th
							data-options="field:'act_finish_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.act_finish_time_t" /></th>
						<!-- 快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE -->
						<th
							data-options="field:'quickcheck_recipe_code_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.quickcheck_recipe_code_s" /></th>
						<!-- 快检工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭 -->
						<th data-options="field:'status_check_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.status_check_s" /></th>
						<!-- 工单检验量：车数*检验百分比 -->
						<th data-options="field:'qty_check_f',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_check_f" /></th>
						<!-- 工单检验完成量 -->
						<th
							data-options="field:'qty_check_complete_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_check_complete_i" /></th>
						<!-- 开始检验车次号 -->
						<th
							data-options="field:'begin_check_train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.begin_check_train_num_s" /></th>
						<!-- 结束检验车次号 -->
						<th
							data-options="field:'end_check_train_num_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.end_check_train_num_s" /></th>
						<!-- 检验合格数量 -->
						<th
							data-options="field:'qty_check_good_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_check_good_i" /></th>
						<!-- 检验不合格数量 -->
						<th data-options="field:'qty_check_bad_i',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.qty_check_bad_i" /></th>
						<!-- 执行开始时间：展示DD HH:MM:MM -->
						<th
							data-options="field:'act_start_checktime_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.act_start_checktime_t" /></th>
						<!-- 执行结束时间：展示DD HH:MM:MM -->
						<th
							data-options="field:'act_finish_checktime_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.act_finish_checktime_t" /></th>

						<!-- 工单快检信息 -->
						<!-- 下发人 -->
						<th data-options="field:'send_by_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.send_by_s" /></th>
						<!-- 下发时间 -->
						<th data-options="field:'send_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.send_time_t" /></th>
						<!-- 审核人 -->
						<th data-options="field:'check_by_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.check_by_s" /></th>
						<!-- 审核时间 -->
						<th data-options="field:'check_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.check_time_t" /></th>
						<!-- 修改人 -->
						<th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.changed_by_s" /></th>
						<!-- 修改时间 -->
						<th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.changed_time_t" /></th>
						<!-- 创建人 -->
						<th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.created_by_s" /></th>
						<!-- 创建时间 -->
						<th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message
								code="workorderexec.column.created_time_t" /></th>
					</tr>
				</thead>
			</table>
		</div>
	</div>
</body>
</html>