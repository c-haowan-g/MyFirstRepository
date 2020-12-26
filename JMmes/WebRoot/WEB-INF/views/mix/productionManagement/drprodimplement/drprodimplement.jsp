<!-- 

    作者      :陈国强
    时间      :2020-09-15 08:21:00 
    页面名称:密炼胶料产出车次实绩表
    文件关联:
        DrprodImplement.java
        DrprodImplementController.java
        DrprodImplementServiceImpl.java
        DrprodImplementServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="drprodimplement.js.jsp"%>
<script type="text/javascript"
	src="dict/301,302,069,068,074,075,062,321,301,323,001.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DrprodImplement_dg_toolbar">
            <form id="DrprodImplement_search_form" class="form" >
                <!-- 工单生产日期 -->
				<spring:message code="drprodimplement.column.prod_date_s" />
				<input name="filter[start_time]" id="start_time" style="width: 90px"
					type="text" class="easyui-datebox"
					data-options="formatter:dateFormat,buttons:[],parser:dateParser,label:''">
				<script type="text/javascript">
					$("#start_time").val(new Calendar().format("yyyyMMdd"));
				</script>

				&nbsp;<strong>到</strong>&nbsp; <input name="filter[end_time]"
					id="end_time" style="width: 90px" type="text"
					class="easyui-datebox"
					data-options="formatter:dateFormat,buttons:[],parser:dateParser,label:''">
				<script type="text/javascript">
					$("#end_time").val(new Calendar().format("yyyyMMdd"));
				</script>

				<!-- 班次 -->
				&nbsp;&nbsp;
				<spring:message code="生产班次" />
				<input name="filter[shift_code_s]" id="shift_code_s" type="text"
					style="width: 90px" class="easyui-combotree"
					data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/302',
				              			 method:'get',
				              			 onChange:filter
				              			">




				<!-- 机台编码：设备类型（2 位）+流水号（3 位） 例如 01001 -->
				<!-- 机台条码  -->
				&nbsp; &nbsp;
				<spring:message code="drprodimplement.column.equip_code_s" />
				&nbsp; <input name="filter[equip_code_s]" id="equip_code_s"
					style="width: 110px" type="text" class="easyui-combobox"
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


				<!-- 产出方式 -->
				&nbsp;&nbsp;
				<spring:message code="产出方式" />
				<input name="filter[prod_type_s]" id="prod_type_s" type="text"
					style="width: 180px" class="easyui-combotree"
					data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/068',
				              			 method:'get',
				              			 onChange:filter
				              			">


				<!--下发标识-->
				&nbsp;&nbsp;
				<spring:message code="drprodimplement.column.spare4_s" />
				： <input name="filter[spare4_s]" id="spare4_s" type="text"
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


				<!-- 物料编码 -->
				&nbsp;&nbsp;
				<spring:message code="物料编码" />
				&nbsp;<input name="filter[material_code_s]" id="material_code_s"
					type="text" class="easyui-textbox" data-options="label:''">
				<!-- 物料名称 -->
				&nbsp;&nbsp;
				<spring:message code="物料名称" />
				&nbsp;<input name="filter[material_name_s]" id="material_name_s"
					type="text" class="easyui-textbox" data-options="label:''">

				<!-- 密炼工单跟踪表，工单号，外键，MX_PP_WO_EDIT.WO_NO -->
				&nbsp;&nbsp;
				<spring:message code="drprodimplement.column.wo_no_s" />
				&nbsp;<input name="filter[wo_no_s]" id="wo_no_s" type="text"
					class="easyui-textbox" data-options="label:''">
				<!-- 批次信息，长度19位： 母胶批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 M919070110100100015 终炼胶批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 F919070110100100015 -->
				&nbsp;&nbsp;
				<spring:message code="drprodimplement.column.lot_no_s" />
				&nbsp;<input name="filter[lot_no_s]" id="lot_no_s" type="text"
					class="easyui-textbox" data-options="label:''"> <a
					class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-search'" onclick="filter()"><spring:message
						code="button.search" /></a> <a class="easyui-linkbutton btn-yellow"
					data-options="iconCls:'icon-search'" onclick="ccreal()">车次图</a>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="export()"><spring:message code="button.export" /></a></auth:button> --%>
        </div>
        <table id="drprodimplement_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#DrprodImplement_dg_toolbar',
                url: 'mix/productionManagement/drprodimplement/datagrid',
                striped:true,
                onSelect:selectrow,
                onBeforeLoad:dlg1BeforeLoad,
                method: 'get' 
                ">
            <thead>
                <tr>
                   
					<!-- 生产日期 -->
					<th data-options="field:'prod_date_s',width:65"><spring:message
							code="生产日期" /></th>
					<!-- 班组 -->
					<th
						data-options="field:'group_code_s',formatter:codeFormatter,width:40"><spring:message
							code="drprodimplement.column.group_code_s" /></th>
					<!-- 班次 -->
					<th
						data-options="field:'shift_code_s',formatter:codeFormatter,width:40"><spring:message
							code="drprodimplement.column.shift_code_s" /></th>
					<!-- 机台名称 -->
					<th data-options="field:'equip_name_s',width:100"><spring:message
							code="drprodimplement.column.equip_name_s" /></th>
					<!-- 物料名称 -->
					<th data-options="field:'material_name_s',width:120"><spring:message
							code="drprodimplement.column.material_name_s" /></th>
					<!-- 物料编码 -->
					<th data-options="field:'material_code_s',width:80"><spring:message
							code="drprodimplement.column.material_code_s" /></th>
					<!-- 备用字段4 -->
					<th
						data-options="field:'spare4_s',formatter:spare4Formatter,width:80"><spring:message
							code="drprodimplement.column.spare4_s" /></th>
					<!-- 密炼工单跟踪表，工单号，外键，MX_PP_WO_EDIT.WO_NO -->
					<th data-options="field:'wo_no_s',width:120"><spring:message
							code="drprodimplement.column.wo_no_s" /></th>
					<!-- 密炼配方BOM版本 -->
					<th data-options="field:'recipe_bom_version_s',width:82"><spring:message
							code="drprodimplement.column.recipe_bom_version_s" /></th>
					<!-- 密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE -->
					<th data-options="field:'recipe_code_s',width:120"><spring:message
							code="drprodimplement.column.recipe_code_s" /></th>
					<!-- 间隔时间 -->
					<th data-options="field:'intervals_i',width:60"><spring:message
							code="drprodimplement.column.intervals_i" /></th>
					<!-- 车次号 -->
					<th data-options="field:'serial_id_i',width:80"><spring:message
							code="上辅机车次号" /></th>
					<!-- 车次号 -->
					<th data-options="field:'mes_serial_id_i',width:80"><spring:message
							code="MES车次号" /></th>
					<!-- JPW -->
							<th data-options="field:'jpw_s',width:80"><spring:message
									code="接收次数" /></th>
					<!-- 状态编码 -->
					<th
						data-options="field:'state_code_s',formatter:codeFormatter,width:80"><spring:message
							code="drprodimplement.column.state_code_s" /></th>
					<!-- 产出重量 -->
					<th data-options="field:'weight_s',width:80"><spring:message
							code="drprodimplement.column.weight_s" /></th>
					<!-- 设定车次 -->
					<th data-options="field:'allche_s',width:80"><spring:message
							code="drprodimplement.column.allche_s" /></th>
					<!-- 炼胶时间 -->
					<th data-options="field:'mixtime_i',width:80"><spring:message
							code="drprodimplement.column.mixtime_i" /></th>
					<!-- 开始时间 -->
					<th data-options="field:'start_datetime_s',width:140"><spring:message
							code="drprodimplement.column.start_datetime_s" /></th>
					<!-- 产出时间 -->
					<th data-options="field:'product_time_t',width:140"><spring:message
							code="drprodimplement.column.product_time_t" /></th>
					<!-- 加炭黑时间 -->
					<th data-options="field:'addcbtime_i',width:80"><spring:message
							code="drprodimplement.column.addcbtime_i" /></th>
					<!-- 加胶时间 -->
					<th data-options="field:'addnrtime_i',width:80"><spring:message
							code="drprodimplement.column.addnrtime_i" /></th>
					<!-- 加油时间  -->
					<th data-options="field:'addoiltime_i',width:80"><spring:message
							code="drprodimplement.column.addoiltime_i" /></th>
					<!-- 排胶能量 -->
					<th data-options="field:'dischargeenergy_f',width:80"><spring:message
							code="drprodimplement.column.dischargeenergy_f" /></th>
					<!-- 排胶功率 -->
					<th data-options="field:'dischargepower_f',width:80"><spring:message
							code="drprodimplement.column.dischargepower_f" /></th>
					<!-- 排胶温度 -->
					<th data-options="field:'dischargetemp_f',width:80"><spring:message
							code="drprodimplement.column.dischargetemp_f" /></th>
					<!-- 胶料车次批次号，长度19位： 母胶车次批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 MC91907011010010001 终炼胶车次批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 FC91907011010010001 -->
					<th data-options="field:'lot_no_s',width:160"><spring:message
							code="drprodimplement.column.lot_no_s" /></th>
					<!-- 机台编码 -->
					<th data-options="field:'equip_code_s',width:65"><spring:message
							code="drprodimplement.column.equip_code_s" /></th>

					<!-- 数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检 -->
					<th
						data-options="field:'datasource_s',formatter:codeFormatter,width:80"><spring:message
							code="drprodimplement.column.datasource_s" /></th>
					<!-- 产出方式 -->
					<th
						data-options="field:'prod_type_s',formatter:codeFormatter,width:130"><spring:message
							code="drprodimplement.column.prod_type_s" /></th>
					<!-- 接收时间 -->
					<th data-options="field:'receive_time_t',width:140"><spring:message
							code="drprodimplement.column.receive_time_t" /></th>
					<!-- 配方时间 -->
					<th data-options="field:'recipetime_i',width:80"><spring:message
							code="drprodimplement.column.recipetime_i" /></th>
					<!-- 创建人 -->
					<th data-options="field:'created_name_s',width:60"><spring:message
							code="drprodimplement.column.created_by_s" /></th>
					<!-- 创建时间 -->
					<th data-options="field:'created_time_t',width:140"><spring:message
							code="drprodimplement.column.created_time_t" /></th>
					<!-- 备用字段2 -->
					<th data-options="field:'spare2_s',width:80"><spring:message
							code="drprodimplement.column.spare2_s" /></th>
					<!-- 备用字段3 -->
					<th data-options="field:'spare3_s',width:140"><spring:message
							code="drprodimplement.column.spare3_s" /></th>
					<!-- 备用字段5 -->
					<th
						data-options="field:'spare5_s',formatter:spare5Formatter,width:80"><spring:message
							code="drprodimplement.column.spare5_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <div data-options="region:'south',split:true" style="height: 200px;">
		<div class="easyui-tabs" id="content_tab"
			data-options="fit:true,tools:'#tab-tools'">
			<div title="配方信息" style="padding: 10px">
				<table id="mixmrecipeexechis_dg" class="easyui-datagrid"
					style="width: 100%"
					data-options="
						                fit:true,
						                fitColumns:false,
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
							<!-- 机台代码 -->
							<th data-options="field:'equip_code_s',width:65"><spring:message
									code="drpfexec.column.equip_code_s" /></th>
							<!-- 父物料名称 -->
							<th data-options="field:'mater_name_s',width:100"><spring:message
									code="drpfexec.column.mater_name_s" /></th>
							<!-- 父物料类型： 母胶(LLMasterBatch) 终炼胶M(LLFinalBatchMPart) -->
							<th
								data-options="field:'mater_type_s',formatter:parentMrpformatter,width:90"><spring:message
									code="drpfexec.column.mater_type_s" /></th>
							<!-- 父物料SAP品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F） -->
							<th data-options="field:'mater_code_s',width:100"><spring:message
									code="drpfexec.column.mater_code_s" /></th>
							<!-- 父物料SAP品号 -->
							<th data-options="field:'mater_code_temp_s',width:100"><spring:message
									code="drpfexec.column.mater_code_temp_s" /></th>
							<!-- 配方名称：父物料名称+工艺类型（是否掺胶+配方阶段+工艺类型） -->
							<th data-options="field:'recipe_code_name_s',width:120"><spring:message
									code="drpfexec.column.recipe_code_name_s" /></th>
							<!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
							<th data-options="field:'recipe_code_s',width:110"><spring:message
									code="drpfexec.column.recipe_code_s" /></th>
							<!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
							<th
								data-options="field:'recipe_status_s',formatter:codeFormatter,width:65"><spring:message
									code="drpfexec.column.recipe_status_s" /></th>
							<!-- 是否掺胶：Yes-掺胶、No-不掺胶 -->
							<th
								data-options="field:'ismixed_s',formatter:ismixedFormatter,width:65"><spring:message
									code="drpfexec.column.ismixed_s" /></th>
							<!-- 是否使用三区温度：0-不使用、1-使用 -->
							<th
								data-options="field:'is_useareatemp_s',formatter:isuseareatempFormatter,width:110"><spring:message
									code="drpfexec.column.is_useareatemp_s" /></th>
							<!-- 配套 -->
							<th data-options="field:'matchingcode_s',width:80"><spring:message
									code="drpfexec.column.matchingcode_s" /></th>
							<!-- 架子数 -->
							<th data-options="field:'shelf_num_i',width:80"><spring:message
									code="drpfexec.column.shelf_num_i" /></th>
							<!-- 补偿温度 -->
							<th data-options="field:'makeup_temp_i',width:65"><spring:message
									code="drpfexec.column.makeup_temp_i" /></th>
							<!-- 侧壁温度 -->
							<th data-options="field:'side_temp_i',width:80"><spring:message
									code="drpfexec.column.side_temp_i" /></th>
							<!-- 卸料门温度 -->
							<th data-options="field:'ddoor_temp_i',width:80"><spring:message
									code="drpfexec.column.ddoor_temp_i" /></th>
							<!-- 转子温度 -->
							<th data-options="field:'roll_temp_i',width:80"><spring:message
									code="drpfexec.column.roll_temp_i" /></th>
							<!-- 加硫限制 -->
							<th
								data-options="field:'dischangetime_i',formatter:DischangetimeFormatter,width:80"><spring:message
									code="drpfexec.column.dischangetime_i" /></th>
							<!-- 审核状态：0-未审核、1-已审核 -->
							<th
								data-options="field:'check_state_s',formatter:checkstateFormatter,width:80"><spring:message
									code="drpfexec.column.check_state_s" /></th>
							<!-- 工艺类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗 -->
							<th
								data-options="field:'routing_type_s',formatter:productTypeformatter,width:80"><spring:message
									code="drpfexec.column.routing_type_s" /></th>
							<!-- 下发标识（下发成功后置逻辑删除）：0-未下发、1-已下发 -->
							<!-- 区分阶段（小试XS、中试ZS、大试DS、投产TC） -->
							<th
								data-options="field:'dummy1_s',formatter:dummy1Formatter,width:80"><spring:message
									code="drpfexec.column.dummy1_s" /></th>
							<!-- 最高进胶温度 -->
							<th data-options="field:'max_inploytemp_i',width:80"><spring:message
									code="drpfexec.column.max_inploytemp_i" /></th>
							<!-- 最低进胶温度 -->
							<th data-options="field:'min_inploytemp_i',width:80"><spring:message
									code="drpfexec.column.min_inploytemp_i" /></th>
							<!-- 超温最短时间 -->
							<th data-options="field:'overtemp_mintime_i',width:80"><spring:message
									code="drpfexec.column.overtemp_mintime_i" /></th>
							<!-- 紧急排胶温度 -->
							<th data-options="field:'overtemp_temp_i',width:80"><spring:message
									code="drpfexec.column.overtemp_temp_i" /></th>
							<!-- 超时排胶时间 -->
							<th data-options="field:'overtime_time_i',width:80"><spring:message
									code="drpfexec.column.overtime_time_i" /></th>
							<!-- 小料包重量 -->
							<th data-options="field:'pack_weight_s',width:80"><spring:message
									code="drpfexec.column.pack_weight_s" /></th>
							<!-- 配方阶段：ZC-正常、SY-不正常 -->
							<th
								data-options="field:'prescriptionstage_s',formatter:prescriptionstageFormatter,width:80"><spring:message
									code="drpfexec.column.prescriptionstage_s" /></th>
							<!-- 父物料PLM版本 -->
							<th data-options="field:'b_version_s',width:110"><spring:message
									code="drpfexec.column.b_version_s" /></th>
							<!-- 父物料工艺PLM版本 -->
							<th data-options="field:'r_version_s',width:110"><spring:message
									code="drpfexec.column.r_version_s" /></th>
							<!-- 炭黑回收时间 -->
							<th data-options="field:'cb_recycletime_i',width:80"><spring:message
									code="drpfexec.column.cb_recycletime_i" /></th>
							<!-- 炭黑回收类型：0-不回收、1-回收 -->
							<th
								data-options="field:'cb_recycletype_s',formatter:cbrecycletypeformatter,width:80"><spring:message
									code="drpfexec.column.cb_recycletype_s" /></th>
							<!-- 设定重量 -->
							<th data-options="field:'set_weigh_d',width:100"><spring:message
									code="drpfexec.column.set_weigh_d" /></th>

							<!-- 数据来源：0-PLM原数据、1-自动生成 -->
							<th
								data-options="field:'data_source_s',formatter:datasourceFormatter,width:100"><spring:message
									code="drpfexec.column.data_source_s" /></th>
							<!-- 数据来源类型：0-上辅机配方、1-配料系统配方 -->
							<th
								data-options="field:'data_source_type_s',formatter:datasourcetypeFormatter,width:100"><spring:message
									code="drpfexec.column.data_source_type_s" /></th>

							<!-- 每车标准时间 -->
							<th data-options="field:'dummy2_s',width:80"><spring:message
									code="drpfexec.column.dummy2_s" /></th>
							<!-- 配方替代号 -->
							<th data-options="field:'edt_code_s',width:80"><spring:message
									code="drpfexec.column.edt_code_s" /></th>

							<!-- 配方启停人 -->
							<th data-options="field:'recipe_name_s',width:90"><spring:message
									code="drpfexec.column.recipe_by_s" /></th>
							<!-- 配方启停时间 -->
							<th data-options="field:'recipe_time_t',width:80"><spring:message
									code="drpfexec.column.recipe_time_t" /></th>
							<th
								data-options="field:'send_state_s',formatter:sendstateFormatter,width:80"><spring:message
									code="drpfexec.column.send_state_s" /></th>
							<!-- 接收时间 -->
							<th data-options="field:'receive_time_t',width:140"><spring:message
									code="drpfexec.column.receive_time_t" /></th>
							<!-- 下发时间 -->
							<th data-options="field:'send_time_t',width:140"><spring:message
									code="drpfexec.column.send_time_t" /></th>
							<!-- 同步时间 -->
							<th data-options="field:'sync_create_time_t',width:140"><spring:message
									code="drpfexec.column.sync_create_time_t" /></th>
							<!-- 数据同步处理：A-新增、U-修改、D-删除 -->
							<th
								data-options="field:'sync_flag_s',formatter:syncflagFormatter,width:140"><spring:message
									code="drpfexec.column.sync_flag_s" /></th>
							<!-- 数据同步处理时间 -->
							<th data-options="field:'sync_hand_time_t',width:140"><spring:message
									code="drpfexec.column.sync_hand_time_t" /></th>
							<!-- 人工配料-数据同步处理标记：0-未处理、1-已处理、2-处理失败 -->
							<th
								data-options="field:'sync_hand_flag_flhand_s',formatter:synchandflagflhandFormatter,width:130"><spring:message
									code="drpfexec.column.sync_hand_flag_flhand_s" /></th>
							<!-- 数据同步处理标记：0-未处理、1-已处理、2-处理失败 -->
							<th
								data-options="field:'sync_hand_flag_s',formatter:synchandflagflhandFormatter,width:120"><spring:message
									code="drpfexec.column.sync_hand_flag_s" /></th>
							<!-- 数据同步处理反馈 -->
							<th data-options="field:'sync_hand_msg_s',width:120"><spring:message
									code="drpfexec.column.sync_hand_msg_s" /></th>
							<!-- 人工配料-数据同步处理反馈 -->
							<th data-options="field:'sync_hand_msg_flhand_s',width:160"><spring:message
									code="drpfexec.column.sync_hand_msg_flhand_s" /></th>
							<!-- 人工配料-数据同步处理时间 -->
							<th data-options="field:'sync_hand_time_flhand_t',width:160"><spring:message
									code="drpfexec.column.sync_hand_time_flhand_t" /></th>
							<!-- 修改人 -->
							<th data-options="field:'changed_name_s',width:60"><spring:message
									code="drpfexec.column.changed_by_s" /></th>
							<!-- 修改时间 -->
							<th data-options="field:'changed_time_t',width:140"><spring:message
									code="drpfexec.column.changed_time_t" /></th>
							<!-- 审核人 -->
							<th data-options="field:'check_name_s',width:60"><spring:message
									code="drpfexec.column.check_by_s" /></th>
							<!-- 审核时间 -->
							<th data-options="field:'check_time_t',width:140"><spring:message
									code="drpfexec.column.check_time_t" /></th>

						</tr>
					</thead>
				</table>
			</div>
			<div title="称量信息" style="padding: 10px">
				<table id="drprodimplementcl_dg" class="easyui-datagrid"
					style="width: 100%"
					data-options="
						                fit:true,
						                fitColumns:false,
						                pagination:false,
						                rownumbers: true,
						                singleSelect: true,
						                striped:true,
						                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
						                remoteSort:false,
						                method: 'get'
					">
					<thead>
						<tr>
						<!-- 称量序号 -->
							<th data-options="field:'weight_id_s',width:80"><spring:message
									code="drprodimplementcl.column.weight_id_s" /></th>
						   <!-- 称量类型（称量类型定义） -->
							 <th
								data-options="field:'weight_type_s',formatter:weightTypeformatter,width:80"><spring:message
									code="drprodimplementcl.column.weight_type_s" /></th>
							<!-- 物料编码 -->
							<th data-options="field:'material_code_s',width:80"><spring:message
									code="drprodimplementcl.column.material_code_s" /></th>
							<!-- 物料名称 -->
							<th data-options="field:'material_name_s',width:180"><spring:message
									code="drprodimplementcl.column.material_name_s" /></th>
							<!-- 设定重量 -->
							<th data-options="field:'set_weight_s',width:80"><spring:message
									code="drprodimplementcl.column.set_weight_s" /></th>
							<!-- 实际重量 -->
							<th data-options="field:'real_weight_s',width:80"><spring:message
									code="drprodimplementcl.column.real_weight_s" /></th>
							<!-- 允许误差 -->
							<th data-options="field:'error_allow_s',width:80"><spring:message
									code="drprodimplementcl.column.error_allow_s" /></th>
							<!-- 备用字段4 -->
							<th
								data-options="field:'spare4_s',formatter:warningsgn4Formatter,width:60"><spring:message
									code="超差标识" /></th>
							<!-- 实际误差 -->
							<th data-options="field:'error_out_s',width:80"><spring:message
									code="drprodimplementcl.column.error_out_s" /></th>
							<!-- 是否超差（没有判定结果） -->
							<th
								data-options="field:'warning_sgn_s',formatter:ischeckFormatter,width:80"><spring:message
									code="drprodimplementcl.column.warning_sgn_s" /></th>
							<!-- 称量时间 -->
							<th data-options="field:'weight_time_s',width:140"><spring:message
									code="drprodimplementcl.column.weight_time_s" /></th>
							<!-- 消耗批次号 -->
							<th data-options="field:'lot_no_s',width:120"><spring:message
									code="drprodimplementcl.column.lot_no_s" /></th>
							<!-- 创建人 -->
							<th data-options="field:'created_name_s',width:60"><spring:message
									code="drprodimplementcl.column.created_by_s" /></th>
							<!-- 接收时间 -->
							<th data-options="field:'receive_time_t',width:140"><spring:message
									code="drprodimplementcl.column.receive_time_t" /></th>
							<!-- 创建时间 -->
							<th data-options="field:'created_time_t',width:140"><spring:message
									code="drprodimplementcl.column.created_time_t" /></th>
							<!-- 备用字段1 -->
							<th data-options="field:'spare1_s',width:65"><spring:message
									code="生产方式" /></th>
							<!-- 备用字段2 -->
							<th
								data-options="field:'spare2_s',formatter:spare2Formatter,width:130"><spring:message
									code="投料防错校验开关" /></th>
							<!-- 备用字段3 -->
							<th data-options="field:'spare3_s',width:220"><spring:message
									code="防错校验打开，无消耗批次号原因备注" /></th>
							<!-- 备用字段5 -->
							<th data-options="field:'spare5_s',width:80"><spring:message
									code="drprodimplementcl.column.spare5_s" /></th>
						</tr>
					</thead>
				</table>
			</div>


			<div title="工艺信息" style="padding: 10px">
				<table id="drprodimplementgy_dg" class="easyui-datagrid"
					style="width: 100%"
					data-options="
						                fit:true,
						                fitColumns:false,
						                pagination:false,
						                rownumbers: true,						                
						                singleSelect: true,
						                striped:true,
						                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
						                remoteSort:false,
						                method: 'get'
					">
					<thead>
						<tr>
							<!-- 步序 -->
							<th data-options="field:'mix_id_i',width:80"><spring:message
									code="drprodimplementgy.column.mix_id_i" /></th>
							<!-- 条件代码 --> 
							<th
								data-options="field:'term_code_s',formatter:conditionformatter,width:100"><spring:message
									code="drprodimplementgy.column.term_code_s" /></th>
									<!-- 动作代码 -->
							<th data-options="field:'act_code_s',formatter:actionformatter,width:100"><spring:message
									code="drprodimplementgy.column.act_code_s" /></th>
							<!-- 持续时间 -->
							<th data-options="field:'set_time_d',width:80"><spring:message
									code="drprodimplementgy.column.set_time_d" /></th>
							<!-- 温度 -->
							<th data-options="field:'set_temp_d',width:80"><spring:message
									code="drprodimplementgy.column.set_temp_d" /></th>
							<!-- 功率 -->
							<th data-options="field:'set_power_d',width:80"><spring:message
									code="drprodimplementgy.column.set_power_d" /></th>
							<!-- 能量 -->
							<th data-options="field:'set_enter_d',width:80"><spring:message
									code="drprodimplementgy.column.set_enter_d" /></th>
							<!-- 压力 -->
							<th data-options="field:'set_press_d',width:80"><spring:message
									code="drprodimplementgy.column.set_press_d" /></th>
							<!-- 转速 -->
							<th data-options="field:'set_rota_d',width:80"><spring:message
									code="drprodimplementgy.column.set_rota_d" /></th>
							<!-- 冷却鼓速度（一次法参数） -->
							<th data-options="field:'coolspeed_mix_d',width:80"><spring:message
									code="drprodimplementgy.column.coolspeed_mix_d" /></th>
							<!-- 开炼机速度（一次法参数） -->
							<th data-options="field:'openmixspeed_mix_d',width:80"><spring:message
									code="drprodimplementgy.column.openmixspeed_mix_d" /></th>
							<!-- 辊距（一次法参数） -->
							<th data-options="field:'rollor_mix_d',width:80"><spring:message
									code="drprodimplementgy.column.rollor_mix_d" /></th>
							<!-- 胶温（一次法参数） -->
							<th data-options="field:'rubtemp_mix_d',width:80"><spring:message
									code="drprodimplementgy.column.rubtemp_mix_d" /></th>
							<!-- 速差比（一次法参数） -->
							<th data-options="field:'speeddiff_mix_d',width:80"><spring:message
									code="drprodimplementgy.column.speeddiff_mix_d" /></th>
							<!-- 水温（一次法参数） -->
							<th data-options="field:'watrtemp_mix_d',width:80"><spring:message
									code="drprodimplementgy.column.watrtemp_mix_d" /></th>
							<!-- 接收时间 -->
							<th data-options="field:'receive_time_t',width:140"><spring:message
									code="drprodimplementgy.column.receive_time_t" /></th>							
							<!-- 创建人 -->
							<th data-options="field:'created_name_s',width:60"><spring:message
									code="drprodimplementgy.column.created_by_s" /></th>
							<!-- 创建时间 -->
							<th data-options="field:'created_time_t',width:140"><spring:message
									code="drprodimplementgy.column.created_time_t" /></th>
							<!-- 备用1 -->
							<th data-options="field:'spare1_s',width:80"><spring:message
									code="drprodimplementgy.column.spare1_s" /></th>
							<!-- 备用2 -->
							<th data-options="field:'spare2_s',width:80"><spring:message
									code="drprodimplementgy.column.spare2_s" /></th>
							<!-- 备用3 -->
							<th data-options="field:'spare3_s',width:80"><spring:message
									code="drprodimplementgy.column.spare3_s" /></th>
							<!-- 备用4 -->
							<th data-options="field:'spare4_s',width:80"><spring:message
									code="drprodimplementgy.column.spare4_s" /></th>
							<!-- 备用5 -->
							<th data-options="field:'spare5_s',width:80"><spring:message
									code="drprodimplementgy.column.spare5_s" /></th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
</body>
</html>
