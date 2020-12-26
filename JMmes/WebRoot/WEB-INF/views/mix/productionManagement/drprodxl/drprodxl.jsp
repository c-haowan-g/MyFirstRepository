<!-- 

    作者      :栾和源
    时间      :2020-08-07 11:15:06 
    页面名称:密炼小料包产出实绩表
    文件关联:
        Drprodxl.java
        DrprodxlController.java
        DrprodxlServiceImpl.java
        DrprodxlServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="drprodxl.js.jsp"%>
<script type="text/javascript" src="dict/075,301,302,321,322,323,332,335,333.js"></script>
 
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Drprodxl_dg_toolbar">
            <form id="Drprodxl_search_form" class="form" >
                <!-- 机台条码 -->
                <spring:message code="drprodxl.column.equip_code_s" />&nbsp;
                <input name="filter[equip_code_s]" id="equip_code_s" type="text" style="width:120px" class="easyui-combobox" data-options="label:'',
                				   data:equiplist,
				         		   panelHeight:150,
				         		   editable:true,
				           		   valueField:'p_line_name',
				          		   textField:'description',
				                   selectOnNavigation:false,
				           		   limitToList:true,
				          		   filter:searchProductionLine,
				           		   onChange:filter" >&nbsp;&nbsp;
                <!-- 物料编码 -->
                &nbsp;&nbsp;<spring:message code="drprodxl.column.material_code_s" />
                &nbsp;<input name="filter[material_code_s]" id="material_code_s" type="text" style="width:110px" class="easyui-textbox" data-options="label:''" >
                <!-- 物料名称 -->
                &nbsp;&nbsp;<spring:message code="drprodxl.column.material_name_s" />
                &nbsp;<input name="filter[material_name_s]" id="material_name_s" type="text" style="width:110px" class="easyui-textbox" data-options="label:''" >
                <!-- 密炼工单跟踪表，工单号 -->
                &nbsp;&nbsp;<spring:message code="drprodxl.column.wo_no" />
                &nbsp;<input name="filter[wo_no_s]" id="wo_no_s" type="text" style="width:110px" class="easyui-textbox" data-options="label:''" >
                <!-- 批次信息，长度19位 小料批次号：固定字符+工厂+生产日期+班次+机台+计划号+流水号 自动配料：FA91907011010010001 人工配料：FH91907011010010001 -->
                &nbsp;&nbsp;<spring:message code="drprodxl.column.lot_no" />
                &nbsp;<input name="filter[lot_no_s]" id="lot_no_s" type="text" style="width:110px" class="easyui-textbox" data-options="label:''" >
                <!-- 投料时间 -->
                &nbsp;&nbsp;<spring:message code="drprodxl.column.prod_date_s" />&nbsp;:&nbsp;<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				&nbsp;到 &nbsp;<input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="drprodxl_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Drprodxl_dg_toolbar',
                url: '',
                onSelect:selectrow,
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 机台条码 -->
                  	<th data-options="field:'equip_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.equip_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.equip_name_s" /></th>
                    <!-- 密炼工单跟踪表，工单号 -->
                    <th data-options="field:'wo_no_s',width:'120px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.wo_no" /></th>
                    <!-- 批次信息，长度19位 小料批次号：固定字符+工厂+生产日期+班次+机台+计划号+流水号 自动配料：FA91907011010010001 人工配料：FH91907011010010001 -->
                    <th data-options="field:'lot_no_s',width:'120px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.lot_no" /></th>                  
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_t',width:'130px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.product_time_t" /></th>
                    <!-- 产出重量 -->
                    <th data-options="field:'output_weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.output_weight_s" /></th>
                    <!-- 称量总重量 -->
                    <th data-options="field:'totalweight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.totalweight_s" /></th>
                    <!-- 误差 -->
                    <th data-options="field:'error_out_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.error_out_s" /></th>
                    <!-- 是否超差：0-正常、1-超差 -->
                    <th data-options="field:'warning_sgn_s',width:'80px',formatter:warningsgnFormatter,editor:{type:'textbox'}"><spring:message code="drprodxl.column.warning_sgn" /></th>
                    <!-- 车次 -->
                    <th data-options="field:'serial_id_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.serial_id_s" /></th>
                    <!-- 托盘号 -->
                    <th data-options="field:'tray_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.tray_no_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.material_code_s" /></th>    
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.material_name_s" /></th>
                    <!-- 班组 -->
                    <th data-options="field:'group_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprodxl.column.group_code_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'shift_code_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprodxl.column.shift_code_s" /></th>
                    <!-- 密炼生成配方编号，外键 -->
                    <th data-options="field:'recipe_code_s',width:'120px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.recipe_code" /></th> 
                    <!-- 密炼配方BOM版本 -->
                    <th data-options="field:'recipe_bom_version_s',width:'120px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.recipe_bom_version_s" /></th>                   
                    <!-- 数据来源 -->
                    <th data-options="field:'datasource_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="drprodxl.column.datasource" /></th>   
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="drprodxl.column.receive_time_t" /></th>
                   </tr> 
            </thead>
        </table>
    </div>
    <div data-options="region:'south',split:true" style="height:200px;">
    	    <div class="easyui-tabs" id="content_tab" data-options="fit:true,tools:'#tab-tools'">   
  	           <div title="配方信息" style="padding:10px">
  	           		 <table id="mixmrecipeexechis_dg" class="easyui-datagrid" style="width:100%"
                       data-options="
						                fit:true,
						                fitColumns:false,
						                pagination:true,
						                rownumbers: true,
						                singleSelect: true,
						                url: '',
						                striped:true,
						                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
						                remoteSort:false,
						                method: 'get' ">
						                
					<thead>
             		<tr>   
  	           			<!-- 机台代码 -->
                    	<th data-options="field:'equip_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.equip_code_s" /></th>
                    	<!-- 父物料名称 -->
                   		<th data-options="field:'mater_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.mater_name_s" /></th>
                    	<!-- 父物料类型： 母胶(LLMasterBatch) 终炼胶M(LLFinalBatchMPart) -->
                   	 	<th data-options="field:'mater_type_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.mater_type" /></th>
                    	<!-- 父物料SAP品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F） -->
                   		<th data-options="field:'mater_code_s',width:'120px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.mater_code" /></th>
                    	<!-- 是否掺胶：Yes-掺胶、No-不掺胶 -->
	                    <th data-options="field:'ismixed_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.ismixed" /></th>
	                    <!-- 是否使用三区温度：0-不使用、1-使用 -->
	                    <th data-options="field:'is_useareatemp_s',width:'120px',formatter:isuseareatempFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.is_useareatemp" /></th>
	                    <!-- 补偿温度 -->
	                    <th data-options="field:'makeup_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.makeup_temp_i" /></th>
	                    <!-- 配套 -->
	                    <th data-options="field:'matchingcode_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.matchingcode_s" /></th>
	                    <!-- 最高进胶温度 -->
	                    <th data-options="field:'max_inploytemp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.max_inploytemp_i" /></th>
	                    <!-- 最低进胶温度 -->
	                    <th data-options="field:'min_inploytemp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.min_inploytemp_i" /></th>
	                    <!-- 超温最短时间 -->
	                    <th data-options="field:'overtemp_mintime_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.overtemp_mintime_i" /></th>
	                    <!-- 紧急排胶温度 -->
	                    <th data-options="field:'overtemp_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.overtemp_temp_i" /></th>
	                    <!-- 超时排胶时间 -->
	                    <th data-options="field:'overtime_time_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.overtime_time_i" /></th>
	                    <!-- 小料包重量 -->
	                    <th data-options="field:'pack_weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.pack_weight_s" /></th>
	                    <!-- 配方阶段：ZC-正常、SY-不正常 -->
	                    <th data-options="field:'prescriptionstage_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.prescriptionstage" /></th>
	                    <!-- 父物料PLM版本 -->
	                    <th data-options="field:'b_version_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.b_version_s" /></th>
	                    <!-- 炭黑回收时间 -->
	                    <th data-options="field:'cb_recycletime_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.cb_recycletime_i" /></th>
	                    <!-- 炭黑回收类型：0-不回收、1-回收 -->
	                    <th data-options="field:'cb_recycletype_s',width:'100px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.cb_recycletype" /></th>
	                    <!-- 设定重量 -->
	                    <th data-options="field:'set_weigh_d',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.set_weigh_d" /></th>
	                    <!-- 架子数 -->
	                    <th data-options="field:'shelf_num_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.shelf_num_i" /></th>
	                    <!-- 侧壁温度 -->
	                    <th data-options="field:'side_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.side_temp_i" /></th>
	                    <!-- 数据来源：0-PLM原数据、1-自动生成 -->
	                    <th data-options="field:'data_source_s',width:'80px',formatter:datasourceFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.data_source" /></th>
	                    <!-- 数据来源类型：0-上辅机配方、1-配料系统配方 -->
	                    <th data-options="field:'data_source_type_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.data_source_type_s" /></th>
	                    <!-- 卸料门温度 -->
	                    <th data-options="field:'ddoor_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.ddoor_temp_i" /></th>
	                    <!-- 加硫限制 -->
	                    <th data-options="field:'dischangetime_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.dischangetime_i" /></th>
	                    <!-- 审核状态：0-未审核、1-已审核 -->
	                    <th data-options="field:'check_state_s',width:'80px',formatter:checkstateFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.check_state" /></th>
	                    <!-- 区分阶段（小试XS、中试ZS、大试DS、投产TC） -->
	                    <th data-options="field:'dummy1_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.dummy1" /></th>
	                    <!-- 每车标准时间 -->
	                    <th data-options="field:'dummy2_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.dummy2_s" /></th>
	                    <!-- 配方替代号 -->
	                    <th data-options="field:'edt_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.edt_code_s" /></th>
	                    <!-- 配方名称：父物料名称+工艺类型（是否掺胶+配方阶段+工艺类型） -->
	                    <th data-options="field:'recipe_code_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.recipe_code_name" /></th>
	                    <!-- 配方编号-13位：Java系统当前时间 例如 1552888628141 -->
	                    <th data-options="field:'recipe_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.recipe_code" /></th>
	                    <!-- 配方状态：323001-待用、323002-正用、323003-停用 -->
	                    <th data-options="field:'recipe_status_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.recipe_status" /></th>
	                    <!-- 配方启停人 -->
	                    <th data-options="field:'recipe_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.recipe_by_s" /></th>
	                    <!-- 配方启停时间 -->
	                    <th data-options="field:'recipe_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.recipe_time_t" /></th>
						<!-- 父物料工艺PLM版本 -->
	                    <th data-options="field:'r_version_s',width:'120px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.r_version_s" /></th>
	                    <!-- 转子温度 -->
	                    <th data-options="field:'roll_temp_i',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.roll_temp_i" /></th>
	                    <!-- 工艺类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗 -->
	                    <th data-options="field:'routing_type_s',width:'80px',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.routing_type" /></th>
	                    <!-- 下发标识：0-未下发、1-已下发、2-下发失败 -->
	                    <th data-options="field:'send_state_s',width:'80px',formatter:sendstateFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.send_state" /></th>
	                    <!-- 下发时间 -->
	                    <th data-options="field:'send_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.send_time_t" /></th>
	                    <!-- 接收时间 -->
	                    <th data-options="field:'receive_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.receive_time_t" /></th>
	                    <!-- 同步时间 -->
	                    <th data-options="field:'sync_create_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.sync_create_time_t" /></th>
	                    <!-- 数据同步处理：A-新增、U-修改、D-删除 -->
	                    <th data-options="field:'sync_flag_s',width:'120px',formatter:syncflagFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.sync_flag" /></th>
	                    <!-- 数据同步处理时间 -->
	                    <th data-options="field:'sync_hand_time_t',width:'120px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.sync_hand_time_t" /></th>
	                    <!-- 数据同步处理标记：0-未处理、1-已处理、2-处理失败已处理 -->
	                    <th data-options="field:'sync_hand_flag_s',width:'120px',formatter:synchandflagflhandFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.sync_hand_flag" /></th>
	                    <!-- 数据同步处理反馈 -->
	                    <th data-options="field:'sync_hand_msg_s',width:'120px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.sync_hand_msg_s" /></th>
	                    <!-- 人工配料-数据同步处理标记：0-未处理、1-已处理、2-处理失败 -->
	                    <th data-options="field:'sync_hand_flag_flhand_s',width:'160px',formatter:synchandflagflhandFormatter,editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.sync_hand_flag_flhand" /></th>
	                    <!-- 人工配料-数据同步处理反馈 -->
	                    <th data-options="field:'sync_hand_msg_flhand_s',width:'160px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.sync_hand_msg_flhand_s" /></th>
	                    <!-- 人工配料-数据同步处理时间 -->
	                    <th data-options="field:'sync_hand_time_flhand_t',width:'160px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.sync_hand_time_flhand_t" /></th>
	                    <!-- 修改人 -->
	                    <th data-options="field:'changed_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.changed_by_s" /></th>
	                    <!-- 修改时间 -->
	                    <th data-options="field:'changed_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.changed_time_t" /></th>
	                    <!-- 审核人 -->
	                    <th data-options="field:'check_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.check_by_s" /></th>
	                    <!-- 审核时间 -->
	                    <th data-options="field:'check_time_t',width:'80px',editor:{type:'textbox'}"><spring:message code="mixmrecipeexechis.column.check_time_t" /></th>
	                  </tr>
	                  </thead>
	               </table>
  	           </div>
  	           <div title="称量信息" style="padding:10px">
                <table id="mixrecipeweightprod_dg" class="easyui-datagrid" style="width:100%"
                       data-options="
						                fit:true,
						                fitColumns:false,
						                pagination:false,
						                rownumbers: false,
						                singleSelect: true,
						                striped:true,
						                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
						                remoteSort:false,
						                method: 'get'">
           		 <thead>   
           		 <tr>        
           		 
           			<!-- 称量序号 -->
                    <th data-options="field:'weight_id_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.weight_id_s" /></th>
                    <!-- 称量时间 -->
                    <th data-options="field:'weight_time_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.weight_time_s" /></th>
                    <!-- 称量类型（称量类型定义） -->
                    <th data-options="field:'weight_type_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.weight_type" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.material_name_s" /></th>
                    <!-- 实际重量 -->
                    <th data-options="field:'real_weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.real_weight_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',width:'140px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.receive_time_t" /></th>
                    <!-- 允许误差 -->
                    <th data-options="field:'error_allow_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.error_allow_s" /></th>
                    <!-- 实际误差 -->
                    <th data-options="field:'error_out_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.error_out_s" /></th>
                    <!-- 消耗批次号 -->
                    <th data-options="field:'lot_no_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.lot_no_s" /></th>
                    <!-- 设定重量 -->
                    <th data-options="field:'set_weight_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.set_weight_s" /></th>
                    <!-- 是否超差（没有判定结果） -->
                    <th data-options="field:'warning_sgn_s',formatter:warningsgnFormatter,width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.warning_sgn" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',width:'80px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:'140px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.created_time_t" /></th>
                    <!-- 投料防错校验开关：C-关闭，B-打开 -->
                    <th data-options="field:'spare1_s',width:'150px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.spare1" /></th>
                    <!-- 防错校验打开，无消耗批次号原因备注 例如：当前防错开关下发计划号-接收时间(yyyy-MM-dd hh:mm:ss): FW92004231030-2020-04-24 16:33:22 -->
                    <th data-options="field:'spare2_s',width:'150px',editor:{type:'textbox'}"><spring:message code="mixrecipeweightprod.column.spare2" /></th>    
                </tr>
            </thead>
        </table>
      </div>
  	</div>
   </div>
</body>
</html>
