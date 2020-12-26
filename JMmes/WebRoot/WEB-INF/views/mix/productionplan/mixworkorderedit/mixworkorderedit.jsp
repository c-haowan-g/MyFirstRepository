<!-- 

    作者      :mengh
    时间      :2019-08-06 09:35:37 
    页面名称:密炼工单跟踪
    文件关联:
        MixWorkOrderEdit.java
        MixWorkOrderEditController.java
        MixWorkOrderEditServiceImpl.java
        MixWorkOrderEditServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixworkorderedit.js.jsp"%>
<script type="text/javascript" src="dict/054,302,053.js"></script>

<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div class="easyui-tabs" fit="true" border="false"
			style="width: 700px; height: 250px">
			<div title="<spring:message code='胶料计划'/>" style="padding: 10px">
				<div id="MixWorkOrderEdit_dg_toolbar">
					<form id="MixWorkOrderEdit_search_form" class="form">
						<!-- 工单生产日期 -->
						<spring:message code="drtrack.column.wo_date_s" />
						<input name="filter[wo_date_s]" id="wo_date_s" style="width: 90px"
							type="text" class="easyui-datebox"
							data-options="onChange:filter,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
						<script type="text/javascript">
							var dateby;
							$
									.ajax({
										url : "mobile/mx/mixdismantling/GetCurProdDate",
										type : "get",
										dataType : "json",
										async : false,
										success : function(data) {
											dateby = data;
										}
									});
							$("#wo_date_s").val(dateby);
						</script>

						<!-- 班次 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.wo_shift_s" />
						<input name="filter[wo_shift_s]" id="wo_shift_s" type="text"
							style="width: 90px" class="easyui-combotree"
							data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/302',
				              			 method:'get',
				              			 onChange:filter
				              			">

						<!-- 机台条码 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.equip_code_s" />
						<input name="filter[equip_code_s]" id="equip_code_s" type="text"
							style="width: 128px" class="easyui-combobox"
							data-options="label:'',
                       data:equiplist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter">
						<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.wo_status_s" />
						<input name="filter[wo_status_s]" id="wo_status_s" type="text"
							style="width: 100px" class="easyui-combotree"
							data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/054',
				              			 method:'get'">

						<!--下发标识-->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.send_state_s" />
						： <input name="filter[send_state_s]" id="send_state_s" type="text"
							class="easyui-combobox" style="width: 100px"
							data-options="label:'',
                                                       textField: 'label',
														data: [{
																label: '未下发',
																value: '0'
															},{
																label: '已下发',
																value: '1'
															},{
																label: '下发失败',
																value: '2'
															}],
															onChange:filter">

						<!-- 工单号 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.wo_no_s" />
						<input name="filter[wo_no_s]" id="wo_no_s" type="text"
							class="easyui-textbox" style="width: 130px"
							data-options="label:''">
						<!-- 物料编码 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.material_code_s" />
						<input name="filter[material_code_s]" id="material_code_s"
							type="text" class="easyui-textbox" style="width: 100px"
							data-options="label:''"> &nbsp;&nbsp;<a
							class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
								code="button.search" /></a> &nbsp;&nbsp;
						<auth:button code="MIXDAYPLAN_PRODUCENEEDPLAN">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-ok'" onclick="downward()">工单下发上辅机</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_BATCH">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-user'" onclick="setup()">主机手设置</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_END">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-clear'" onclick="end()">工单关闭</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_UPWARD">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-undo'" onclick="upward()">上移</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_DOWN">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-redo'" onclick="down()">下移</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_BATCH">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-print'" onclick="batch()">批报表</a>
						</auth:button>
					</form>
				</div>
				<table id="mixworkorderedit_dg" class="easyui-datagrid"
					style="width: 100%"
					data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixWorkOrderEdit_dg_toolbar',
                url: 'mix/productionplan/mixworkorderedit/datagrid',
                striped:true,
                remoteSort:true,
                onBeforeLoad:dlg1BeforeLoad,
                onLoadSuccess:onLoadSuccess,                
                method: 'get' 
               
                ">
					<thead>
						<tr>
							<th data-options="field:'atr_key',checkbox:true" rowspan="2"></th>
							<th colspan="21"><strong>生产工单信息</strong></th>
							<th colspan="13"><strong>生产快检信息</strong></th>
							<th colspan="12"><strong>其他</strong></th>
						</tr>
						<tr>
							<!-- 工单班次：302001-早班、302002-中班、302003-晚班 -->
							<th
								data-options="field:'wo_shift_s',formatter:codeFormatter,width:40"><spring:message
									code="drtrack.column.wo_shift_s" /></th>
							<!-- 机台条码 -->
							<th
								data-options="field:'equip_code_s',sortable:true,formatter:equipcodeformatter,width:100"><spring:message
									code="drtrack.column.equip_code_s" /></th>
							<!-- 物料名称 -->
							<th
								data-options="field:'material_name_s',sortable:true,width:100"><spring:message
									code="drtrack.column.material_name_s" /></th>
							<!-- 生产配方名称-->
							<th data-options="field:'spare8_s',width:120"><spring:message
									code="生产配方名称" /></th>
							<!-- 工单顺序号 -->
							<th data-options="field:'wo_seq_i',width:50"><spring:message
									code="drtrack.column.wo_seq_i" /></th>
							<!-- 工单号 -->
							<th data-options="field:'wo_no_s',sortable:true,width:110"><spring:message
									code="drtrack.column.wo_no_s" /></th>
							<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
							<th
								data-options="field:'wo_status_s',formatter:codeFormatter,width:60"><spring:message
									code="drtrack.column.wo_status_s" /></th>
							<!-- 下发标识 -->
							<th
								data-options="field:'send_state_s',formatter:sendstateFormatter,width:60"><spring:message
									code="drtrack.column.send_state_s" /></th>
							<!--   是否生成领料计划 0 否 1 是 -->
							<th
								data-options="field:'spare6_s',formatter:spareFormatter,width:60"><spring:message
									code="drtrack.column.spare6_s" /></th>
							<!-- 工单计划数量 -->
							<th data-options="field:'qty_plan_i',width:60"><spring:message
									code="drtrack.column.qty_plan_i" /></th>
							<!-- 工单完成数量 -->
							<th data-options="field:'qty_complete_i',width:60"><spring:message
									code="drtrack.column.qty_complete_i" /></th>
							<!-- 完成率 -->
							<th
								data-options="field:'completion_rate',formatter:completionrateFormatter,width:120"><spring:message
									code="完成率" /></th>
							<!-- 物料编码 -->
							<th data-options="field:'material_code_s',sortable:true,width:80"><spring:message
									code="drtrack.column.material_code_s" /></th>
							<%--  <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:80"><spring:message code="drtrack.column.material_name_s" /></th> --%>
							<!-- 快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE -->
							<th data-options="field:'recipe_code_s',width:100"><spring:message
									code="生产配方编码" /></th>
							<!-- 密炼配方BOM版本 -->
							<th data-options="field:'recipe_bom_version_s',width:45"><spring:message
									code="drtrack.column.recipe_bom_version_s" /></th>
							<!-- 是否有等同 -->
							<th
								data-options="field:'spare9_s',formatter:spareFormatter,width:80"><spring:message
									code="是否有等同" /></th>
							<!-- 等同物料 -->
							<th data-options="field:'spare10_s',width:120"><spring:message
									code="等同物料" /></th>
							<!-- 当前称量车次 -->
							<th data-options="field:'weightche_s',width:60"><spring:message
									code="drtrack.column.weightche_s" /></th>
							<!-- 备用字段17 -->
							<th
								data-options="field:'spare17_s',formatter:spare17Formatter,width:135"><spring:message
									code="根据曲线车次是否检查" /></th>
							<!-- 备用字段18 -->
							<th data-options="field:'spare18_s',width:135"><spring:message
									code="根据曲线车次检查情况" /></th>
							<!-- 备用字段19 -->
							<th data-options="field:'spare19_s',width:165"><spring:message
									code="根据曲线车次检查处理时间" /></th>
							<!-- 密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO -->
							<th data-options="field:'plan_no_s',sortable:true,width:120"><spring:message
									code="drtrack.column.plan_no_s" /></th>
							<!-- 执行开始时间 -->
							<th
								data-options="field:'act_start_time_t',sortable:true,formatter:timeformatter,width:80"><spring:message
									code="drtrack.column.act_start_time_t" /></th>
							<!-- 执行结束时间 -->
							<th
								data-options="field:'act_finish_time_t',sortable:true,formatter:timeformatter,width:80"><spring:message
									code="drtrack.column.act_finish_time_t" /></th>
							<!-- 快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE -->
							<th
								data-options="field:'quickcheck_recipe_code_s',sortable:true,width:100"><spring:message
									code="drtrack.column.quickcheck_recipe_code_s" /></th>
							<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
							<th
								data-options="field:'status_check_s',formatter:codeFormatter,width:80"><spring:message
									code="drtrack.column.status_check_s" /></th>
							<!-- 工单检验量：车数*检验百分比 -->
							<th data-options="field:'qty_check_f',width:60"><spring:message
									code="drtrack.column.qty_check_f" /></th>
							<!-- 工单检验完成量 -->
							<th data-options="field:'qty_check_complete_i',width:60"><spring:message
									code="drtrack.column.qty_check_complete_i" /></th>
							<!-- 开始检验车次号 -->
							<th data-options="field:'begin_check_train_num_s',width:80"><spring:message
									code="drtrack.column.begin_check_train_num_s" /></th>
							<!-- 结束检验车次号 -->
							<th data-options="field:'end_check_train_num_s',width:80"><spring:message
									code="drtrack.column.end_check_train_num_s" /></th>
							<!-- 检验合格数量 -->
							<th data-options="field:'qty_check_good_i',width:60"><spring:message
									code="drtrack.column.qty_check_good_i" /></th>
							<!-- 检验不合格数量 -->
							<th data-options="field:'qty_check_bad_i',width:80"><spring:message
									code="drtrack.column.qty_check_bad_i" /></th>
							<!-- 执行开始时间：展示DD HH:MM:MM -->
							<th
								data-options="field:'act_start_checktime_t',sortable:true,formatter:timeformatter,width:80"><spring:message
									code="drtrack.column.act_start_checktime_t" /></th>
							<!-- 执行结束时间：展示DD HH:MM:MM -->
							<th
								data-options="field:'act_finish_checktime_t',sortable:true,formatter:timeformatter,width:80"><spring:message
									code="drtrack.column.act_finish_checktime_t" /></th>
							<!-- 主机手 -->
							<th data-options="field:'master_name_s',width:60"><spring:message
									code="drprod.column.master_by_s" /></th>
							<!-- 创建人 -->
							<th data-options="field:'created_name_s',width:60"><spring:message
									code="drtrack.column.created_by_s" /></th>
							<!-- 创建时间 -->
							<th data-options="field:'created_time_t',sortable:true,width:140"><spring:message
									code="drtrack.column.created_time_t" /></th>
							<!-- 修改人 -->
							<th data-options="field:'changed_name_s',width:60"><spring:message
									code="drtrack.column.changed_by_s" /></th>
							<!-- 修改时间 -->
							<th data-options="field:'changed_time_t',sortable:true,width:140"><spring:message
									code="drtrack.column.changed_time_t" /></th>

							<!-- 下发人 -->
							<th data-options="field:'send_name_s',width:60"><spring:message
									code="drtrack.column.send_by_s" /></th>
							<!-- 下发时间 -->
							<th data-options="field:'send_time_t',sortable:true,width:140"><spring:message
									code="drtrack.column.send_time_t" /></th>
							<!-- 备用字段1 -->
							<th data-options="field:'spare1_s',width:80"><spring:message
									code="drtrack.column.spare1_s" /></th>
							<!-- 备用字段2 -->
							<th data-options="field:'spare2_s',width:80"><spring:message
									code="drtrack.column.spare2_s" /></th>
							<!-- 备用字段3 -->
							<th data-options="field:'spare3_s',width:80"><spring:message
									code="drtrack.column.spare3_s" /></th>
							<!-- 备用字段4 -->
							<th data-options="field:'spare4_s',width:80"><spring:message
									code="drtrack.column.spare4_s" /></th>
							<!-- 备用字段5 -->
							<th data-options="field:'spare5_s',width:80"><spring:message
									code="drtrack.column.spare5_s" /></th>
						</tr>
					</thead>
				</table>
			</div>

			<div title="<spring:message code='小料计划'/>" style="padding: 10px">
				<div id="MixWorkOrderEdit_dg_toolbar3">
					<form id="MixWorkOrderEdit_search_form3" class="form">
						<!-- 工单生产日期 -->
						<spring:message code="drtrack.column.wo_date_s" />
						<input name="filter[wo_date_s]" id="wo_date_sl"
							style="width: 90px" type="text" class="easyui-datebox"
							data-options="onChange:filter2,formatter:dateFormat,buttons:[],parser:dateParser,label:''">
						<script type="text/javascript">
							var dateby;
							$
									.ajax({
										url : "mobile/mx/mixdismantling/GetCurProdDate",
										type : "get",
										dataType : "json",
										async : false,
										success : function(data) {
											dateby = data;
										}
									});
							$("#wo_date_sl").val(dateby);
						</script>
						<!-- 班次 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.wo_shift_s" />
						<input name="filter[wo_shift_s]" id="wo_shift_s" type="text"
							style="width: 90px" class="easyui-combotree"
							data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/302',
				              			 method:'get',
				              			 onChange:filter
				              			">
						<!-- 机台条码 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.equip_code_s" />
						&nbsp; <input name="filter[equip_code_s]" id="equip_code_s"
							type="text" style="width: 128px" class="easyui-combobox"
							data-options="label:'',
                       data:equiplist2,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filter2">
						<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
						<spring:message code="drtrack.column.wo_status_s" />
						<input name="filter[wo_status_s]" id="wo_status_s" type="text"
							style="width: 100px" class="easyui-combotree"
							data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/054',
				              			 method:'get'">
						<!--下发标识-->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.send_state_s" />
						： <input name="filter[send_state_s]" id="send_state_s" type="text"
							class="easyui-combobox" style="width: 100px"
							data-options="label:'',
                                                       textField: 'label',
														data: [{
																label: '未下发',
																value: '0'
															},{
																label: '已使用',
																value: '1'
															},{
																label: '下发失败',
																value: '2'
															}],
															onChange:filter">
						<!-- 工单号 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.wo_no_s" />
						<input name="filter[wo_no_s]" id="wo_no_s" type="text"
							class="easyui-textbox" style="width: 130px"
							data-options="label:''">
						<!-- 物料编码 -->
						&nbsp;&nbsp;
						<spring:message code="drtrack.column.material_code_s" />
						<input name="filter[material_code_s]" id="material_code_s"
							type="text" class="easyui-textbox" style="width: 100px"
							data-options="label:''"> <a
							class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-search'" onclick="filter2()"><spring:message
								code="button.search" /></a> &nbsp;&nbsp;
						<auth:button code="MIXDAYPLAN_PRODUCENEEDPLAN">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-ok'" onclick="downward1()">工单下发上辅机</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT1_BATCH">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-user'" onclick="setup1()">主机手设置</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_END">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-clear'" onclick="end1()">工单关闭</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_UPWARD">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-undo'" onclick="upward1()">上移</a>
						</auth:button>
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_DOWN">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-redo'" onclick="down1()">下移</a>
						</auth:button>
						<%-- 
						&nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_BATCH">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-print'" onclick="batch1()">批报表</a>
						</auth:button> --%>

					</form>
				</div>
				<table id="mixworkorderedit_dg3" class="easyui-datagrid"
					style="width: 100%"
					data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixWorkOrderEdit_dg_toolbar3',
                url: 'mix/productionplan/mixworkorderedit/datagrid2',
                striped:true,
                remoteSort:true,
                onBeforeLoad:dlg1BeforeLoad2, 
                onLoadSuccess:onLoadSuccess2,             
                method: 'get' 
                ">
					<thead>
						<tr>
							<th data-options="field:'atr_key',checkbox:true" rowspan="2"></th>
							<th colspan="20"><strong>生产工单信息</strong></th>
							<th colspan="14"><strong>其他</strong></th>
						</tr>
						<tr>
							<!-- 工单班次：302001-早班、302002-中班、302003-晚班 -->
							<th
								data-options="field:'wo_shift_s',formatter:codeFormatter,width:60"><spring:message
									code="drtrack.column.wo_shift_s" /></th>
							<!-- 机台条码 -->
							<th
								data-options="field:'equip_code_s',sortable:true,formatter:equipcodeformatterxl,width:150"><spring:message
									code="drtrack.column.equip_code_s" /></th>
							<!-- 物料名称 -->
							<th
								data-options="field:'material_name_s',sortable:true,width:220"><spring:message
									code="drtrack.column.material_name_s" /></th>
							<!-- 工单顺序号 -->
							<th data-options="field:'wo_seq_i',width:50"><spring:message
									code="drtrack.column.wo_seq_i" /></th>
							<!-- 工单号 -->
							<th data-options="field:'wo_no_s',sortable:true,width:120"><spring:message
									code="drtrack.column.wo_no_s" /></th>
							<!-- 工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭 -->
							<th
								data-options="field:'wo_status_s',formatter:codeFormatter,width:60"><spring:message
									code="drtrack.column.wo_status_s" /></th>
							<!-- 下发标识 -->
							<th
								data-options="field:'send_state_s',formatter:sendstateFormatter,width:60"><spring:message
									code="drtrack.column.send_state_s" /></th>
							<!--   是否生成领料计划 0 否 1 是 -->
							<th
								data-options="field:'spare6_s',formatter:spareFormatter,width:60"><spring:message
									code="drtrack.column.spare6_s" /></th>
							<!-- 工单计划数量 -->
							<th data-options="field:'qty_plan_i',width:60"><spring:message
									code="drtrack.column.qty_plan_i" /></th>
							<!-- 工单完成数量 -->
							<th data-options="field:'qty_complete_i',width:60"><spring:message
									code="drtrack.column.qty_complete_i" /></th>
							<!-- 完成率 -->
							<th
								data-options="field:'completion_rate',formatter:completionrateFormatter,width:60"><spring:message
									code="完成率" /></th>
							<!-- 物料编码 -->
							<th data-options="field:'material_code_s',sortable:true,width:80"><spring:message
									code="drtrack.column.material_code_s" /></th>
							<!-- 快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE -->
							<th data-options="field:'recipe_code_s',sortable:true,width:110"><spring:message
									code="生产配方编码" /></th>
							<!-- 生产配方名称-->
							<th data-options="field:'spare8_s',width:220"><spring:message
									code="生产配方名称" /></th>
							<!-- 密炼配方BOM版本 -->
							<th data-options="field:'recipe_bom_version_s',width:40"><spring:message
									code="drtrack.column.recipe_bom_version_s" /></th>
							<!-- 是否有等同 -->
							<th
								data-options="field:'spare9_s',formatter:spareFormatter,width:80"><spring:message
									code="是否有等同" /></th>
							<!-- 等同物料 -->
							<th data-options="field:'spare10_s',width:150"><spring:message
									code="等同物料" /></th>
							<!-- 当前称量车次 -->
							<th data-options="field:'train_num_s',width:80"><spring:message
									code="drtrack.column.weightche_s" /></th>
							<%-- 							<th
								data-options="field:'spare17_s',formatter:spare17Formatter,width:135"><spring:message
									code="根据曲线车次是否检查" /></th>
							<!-- 备用字段18 -->
							<th data-options="field:'spare18_s',width:135"><spring:message
									code="根据曲线车次检查情况" /></th>
							<!-- 备用字段19 -->
							<th data-options="field:'spare19_s',width:165"><spring:message
									code="根据曲线车次检查处理时间" /></th> --%>
							<!-- 密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO -->
							<th data-options="field:'plan_no_s',width:110"><spring:message
									code="drtrack.column.plan_no_s" /></th>
							<!-- 执行开始时间 -->
							<th
								data-options="field:'act_start_time_t',sortable:true,formatter:timeformatter,width:80"><spring:message
									code="drtrack.column.act_start_time_t" /></th>
							<!-- 执行结束时间 -->
							<th
								data-options="field:'act_finish_time_t',sortable:true,formatter:timeformatter,width:80"><spring:message
									code="drtrack.column.act_finish_time_t" /></th>
							<!-- 主机手 -->
							<th data-options="field:'master_name_s',width:60"><spring:message
									code="drprod.column.master_by_s" /></th>
							<!-- 创建人 -->
							<th data-options="field:'created_name_s',width:60"><spring:message
									code="drtrack.column.created_by_s" /></th>
							<!-- 创建时间 -->
							<th data-options="field:'created_time_t',sortable:true,width:140"><spring:message
									code="drtrack.column.created_time_t" /></th>
							<!-- 修改人 -->
							<th data-options="field:'changed_name_s',width:60"><spring:message
									code="drtrack.column.changed_by_s" /></th>
							<!-- 修改时间 -->
							<th data-options="field:'changed_time_t',sortable:true,width:140"><spring:message
									code="drtrack.column.changed_time_t" /></th>
							<!-- 下发人 -->
							<th data-options="field:'send_name_s',width:60"><spring:message
									code="drtrack.column.send_by_s" /></th>
							<!-- 下发时间 -->
							<th data-options="field:'send_time_t',sortable:true,width:140"><spring:message
									code="drtrack.column.send_time_t" /></th>
							<!-- 备用字段1 -->
							<th data-options="field:'spare1_s',width:80"><spring:message
									code="drtrack.column.spare1_s" /></th>
							<!-- 备用字段2 -->
							<th data-options="field:'spare2_s',width:0"><spring:message
									code="drtrack.column.spare2_s" /></th>
							<!-- 备用字段3 -->
							<th data-options="field:'spare3_s',width:80"><spring:message
									code="drtrack.column.spare3_s" /></th>
							<!-- 备用字段4 -->
							<th data-options="field:'spare4_s',width:80"><spring:message
									code="drtrack.column.spare4_s" /></th>
							<!-- 备用字段5 -->
							<th data-options="field:'spare5_s',width:80"><spring:message
									code="drtrack.column.spare5_s" /></th>

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
		                closed:true,       
		                ">

		<table>
			<tr>
				<td><spen id="wo_no_s1">工单号:</spen> &nbsp;&nbsp;&nbsp;<spen
						id="equip_name_s1">生产机台:</spen> &nbsp;&nbsp;&nbsp;<spen
						id="wo_shift_s1">班次:</spen> &nbsp;&nbsp;&nbsp;<spen id="spare8_s1">配方名称:</spen>&nbsp;&nbsp;&nbsp;
					<spen id="qty_plan_i1">设定:</spen>&nbsp;&nbsp;&nbsp;<spen
						id="qty_complete_i1">完成:</spen></td>
			</tr>
			<tr>
				<td><spen id="act_start_time_t1">开始时间:</spen>&nbsp;&nbsp;&nbsp;<spen
						id="act_finish_time_t1">结束时间:</spen></td>
			</tr>
		</table>
		<table id="equalmaterialdg" class="easyui-datagrid" title="报表明细"
			data-options="  fit:true,
									fitColumns:true,
									singleSelect: false,
									 pagination:true,									 
									striped:true,									
									method: 'get',																	
									">
			<thead>
				<tr>


					<th data-options="field:'N_NAME_S'"><spring:message code="" /></th>
					<!--车次号-->
					<th data-options="field:'SERIAL_ID_I'"><spring:message
							code="车次号" /></th>
					<!-- 配方时间-->
					<th data-options="field:'RECIPETIME_I'"><spring:message
							code="配方时间" /></th>
					<!-- 炼胶时间-->
					<th data-options="field:'MIXTIME_I'"><spring:message
							code="炼胶时间" /></th>
					<!-- 间隔时间-->
					<th data-options="field:'INTERVALS_I'"><spring:message
							code="间隔时间" /></th>
					<!-- 加胶时间-->
					<th data-options="field:'ADDNRTIME_I'"><spring:message
							code="加胶时间" /></th>
					<!-- 加炭黑时间-->
					<th data-options="field:'ADDCBTIME_I'"><spring:message
							code="加炭黑时间" /></th>
					<!--加油时间-->
					<th data-options="field:'ADDOILTIME_I'"><spring:message
							code="加油时间" /></th>
					<!-- 排胶温度-->
					<th data-options="field:'DISCHARGETEMP_F'"><spring:message
							code="排胶温度" /></th>
					<!-- 排胶功率-->
					<th data-options="field:'DISCHARGEPOWER_F'"><spring:message
							code="排胶功率" /></th>
					<!-- 排胶能量-->
					<th data-options="field:'DISCHARGEENERGY_F'"><spring:message
							code="排胶能量" /></th>
					<!-- 检量称-->
					<th data-options="field:'CALIBRATION_SAID'"><spring:message
							code="检量称" /></th>
					<!-- 小料-->
					<th data-options="field:'SMALL_MATERIAL'"><spring:message
							code="小料" /></th>
					<!-- 胶料-->
					<th data-options="field:'RUBBER'"><spring:message code="胶料" /></th>
					<!-- 炭黑-->
					<th data-options="field:'CARBON_BLACK'"><spring:message
							code="炭黑" /></th>
					<!-- 总重-->
					<th data-options="field:'ALL_NUM'"><spring:message code="总重" /></th>
				</tr>
			</thead>
		</table>
	</div>


	<div id="setup_dlg" class="easyui-dialog"
		title="<strong>主机手设置界面</strong>" maximizable="true" minimizable="true"
		style="width: 80%; height: 80%;"
		data-options="
		                resizable:true,
		    			modal:true,
		                iconCls:'icon-window',
		                closed:true,       
		                ">
		<div class="easyui-layout" fit="true" border="false"
			style="width: 700px; height: 350px;">

			<div data-options="region:'west',split:true" title="机台主机手设置信息"
				style="width: 45%">


				<table id="geterpcode_dg" class="easyui-datagrid"
					data-options="  
                                    fit:true,
									fitColumns:true,
									singleSelect: true,																	 
									striped:true,																
									method: 'get',	
                ">
					<thead>
						<tr>
							<th data-options="field:'atr_key',checkbox:true" rowspan="1"></th>
							<!-- 机台条码-->
							<th
								data-options="field:'ERPCODE_S',formatter:plmByPlinenameformatter"><spring:message
									code="机台条码" /></th>
							<!-- 设置信息 -->
							<th data-options="field:'DICTNAME_S'"><spring:message
									code="设置信息" /></th>
							<!-- DICTNAME_EN_S-->
							<th data-options="field:'DICTNAME_EN_S'"><spring:message
									code="工号" /></th>
							<!-- DICTNAME_TH_S-->
							<th data-options="field:'DICTNAME_TH_S'"><spring:message
									code="姓名" /></th>
						</tr>
					</thead>
				</table>


			</div>




			<div data-options="region:'center',iconCls:'icon-ok'" title="主机手信息">

				<div id="Setup_dg_toolbar">
					<form id="Setup_search_form" class="form">
						<span οnclick="show()"> <input type="radio" name="radio"
							onclick="show()" value="real_time" checked> <spring:message
								code="<strong>当前用户</strong>" /> <input type="radio"
							name="radio" value="his_time" onclick="show()"> <spring:message
								code="<strong>全部用户</strong>" />
						</span>
						<!-- <!-- 机台条码 -->
						<!--  
					&nbsp;&nbsp; <span id="span_id"> 机台条码 </span> <input
						name="filter[equip_code_s]" id="Setup_equip_code_s" type="text"
						style="width: 128px" class="easyui-combobox"
						data-options="label:'',
                       data:equiplist,
	         		   panelHeight:150,
	         		   editable:true,
	           		   valueField:'p_line_name',
	          		   textField:'description',
	                   selectOnNavigation:false,
	           		   limitToList:true,
	          		   filter:searchProductionLine,
	           		   onChange:filtersetup"> -->
						&nbsp;&nbsp; <a class="easyui-linkbutton btn-yellow"
							data-options="iconCls:'icon-search'" onclick="filtersetup()"><spring:message
								code="button.search" /></a> &nbsp;&nbsp;
						<auth:button code="MIXWORKORDEREDIT_BATCH">
							<a class="easyui-linkbutton btn-black"
								data-options="iconCls:'icon-ok'" onclick="set()">确认</a>
						</auth:button>

					</form>
				</div>


				<table id="setupdlg" class="easyui-datagrid"
					data-options="  fit:true,
									fitColumns:true,
									singleSelect: true,
									 pagination:true,									 
									striped:true,	
									toolbar: '#Setup_dg_toolbar',								
									method: 'get',																	
									">
					<thead>
						<tr>


							<th data-options="field:'atr_key',checkbox:true" rowspan="1"></th>
							<!-- 工号-->
							<th data-options="field:'created_by_s'"><spring:message
									code="工号" /></th>
							<!-- 主机手姓名-->
							<th data-options="field:'created_name_s'"><spring:message
									code="姓名" /></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
