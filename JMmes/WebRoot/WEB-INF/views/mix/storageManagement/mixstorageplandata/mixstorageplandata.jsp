<!-- 

    作者      :陈国强
    时间      :2020-08-18 16:19:22 
    页面名称:盘库数据管理表
    文件关联:
        MixStoragePlanData.java
        MixStoragePlanDataController.java
        MixStoragePlanDataServiceImpl.java
        MixStoragePlanDataServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="mixstorageplandata.js.jsp"%>

<body class="easyui-layout" fit="true"> 
 <div class="easyui-tabs" fit="true" border="false"
		style="width: 700px; height: 250px">
	<!-- 盘库截存数据 -->	
    <div title="盘库截存数据" style="padding: 10px" >
        <div id="MixStoragePlanData_dg_toolbar">
            <form id="MixStoragePlanData_search_form" class="form" >
                <!-- 入库日期 -->
                <spring:message code="mixstorageplandata.column.in_date_s" />
                <input name="filter[in_date_s]" id="in_date_s1" style="width: 90px" type="text" class="easyui-datebox" 
                data-options="onChange:getJobName,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
                <script type="text/javascript">
						$("#in_date_s1").val(new Calendar().format("yyyyMMdd"));
				</script>
                <!-- 作业名称 -->
                <spring:message code="mixstorageplandata.column.job_name_s" />
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" 
                data-options="label:'',
                 		data:jobnamelist,
	         		   	panelHeight:150,
	         		   	editable:true,
	           		   	valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   	selectOnNavigation:false,
	           		   	limitToList:true" >
                <!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
                <spring:message code="mixstorageplandata.column.inventory_result_s" />
                <input name="filter[inventory_result_s]" id="inventory_result_s" type="text" class="easyui-combotree"
                 data-options="label:'',
                 	 			required:false,
				              	panelHeight:200,
				              	url:'dict/code/345',
				              	method:'get',
				              	onChange:filter" >
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
           		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__LOCKS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-locks'" onclick="lock()">锁定盘库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__UNLOCK"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-unlock'" onclick="unlock()">解锁盘库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__SCANNING"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-scanning'" onclick="scanning()">扫描对库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__DELEFTS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-deletes'" onclick="deletes()">无效删除</a></auth:button>
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
			 </div>
        <table id="mixstorageplandata_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixStoragePlanData_dg_toolbar',
                url: 'mix/storageManagement/mixStoragePlanData/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 数据对库处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="field:'check_hand_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_flag_s" /></th>
                    <!-- 数据对库处理时间 -->
                    <th data-options="field:'check_hand_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_time_t" /></th>
                    <!-- 数据对库处理反馈 -->
                    <th data-options="field:'check_hand_msg_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_msg_s" /></th>
                    <!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
                    <th data-options="field:'inventory_result_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_result_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'material_group_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_group_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_name_s" /></th>
                    <!-- 系统数量 -->
                    <th data-options="field:'sys_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_qty_f" /></th>
                    <!-- 系统重量 -->
                    <th data-options="field:'sys_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_weight_f" /></th>
                    <!-- 系统中库位 -->
                    <th data-options="field:'sys_loc_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_loc_s" /></th>
                    <!-- 盘点数量 -->
                    <th data-options="field:'inventory_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_qty_f" /></th>
                    <!-- 盘点重量 -->
                    <th data-options="field:'inventory_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_weight_f" /></th>
                    <!-- 盘点时库位  -->
                    <th data-options="field:'inventory_loc_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_loc_s" /></th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.lot_no_s" /></th>
                    <!-- 进厂批次 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare1_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'carrier_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.carrier_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.equip_name_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.product_time_s" /></th>
                    <!-- 入库日期 -->
                    <th data-options="field:'in_date_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.in_date_s" /></th>
                    <!-- 出库日期 -->
                    <th data-options="field:'out_date_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.out_date_s" /></th>
                    <!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
                    <th data-options="field:'datasource_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.datasource_s" /></th>
                    <!-- 创建人姓名  -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_time_t" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_time_t" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare5_s" /></th>
                    <!-- 备用字段6 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare9_s" /></th>
                    <!-- 备用字段10 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare10_s" /></th>
                    <%-- <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.arch_flag_s" /></th>
                    <!-- 单位 -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.baseunit_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_by_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_by_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.equip_code_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.id_s" /></th>
                    <!-- 盘点时库位编码 -->
                    <th data-options="field:'inventory_loc_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_loc_code_s" /></th>
                    <!-- 作业名称 -->
                    <th data-options="field:'job_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.job_name_s" /></th>
                    <!-- 盘库计划管理表作业号：外键，CM_WH_ITEM_INV_JOB.JOB_NO -->
                    <th data-options="field:'job_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.job_no_s" /></th>
                    <!-- 记录标志：A-可用，D-删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.record_flag_s" /></th>
                    <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格、特殊放行的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.state_code_s" /></th>
                    <!-- 系统中库位编码 -->
                    <th data-options="field:'sys_loc_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_loc_code_s" /></th>
                    <!-- 工厂：1-全钢、2-半钢 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.s_factory_s" /></th> --%>
                </tr>
            </thead>
        </table>
    </div>

	<!-- 盘库扫描数据 -->	
    <div title="盘库扫描数据" style="padding: 10px" >
        <div id="MixStoragePlanDataScan_dg_toolbar">
            <form id="MixStoragePlanDataScan_search_form" class="form" >
                <!-- 入库日期 -->
                <spring:message code="mixstorageplandata.column.in_date_s" />
                <input name="filter[in_date_s]" id="in_date_s2" style="width: 90px" type="text" class="easyui-datebox" 
                data-options="onChange:getJobName1,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
                <script type="text/javascript">
						$("#in_date_s2").val(new Calendar().format("yyyyMMdd"));
				</script>
                <!-- 作业名称 -->
                <spring:message code="mixstorageplandata.column.job_name_s" />
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" 
                data-options="label:'',
                 		data:jobnamelist,
	         		   	panelHeight:150,
	         		   	editable:true,
	           		   	valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   	selectOnNavigation:false,
	           		   	limitToList:true" >

                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter1()"><spring:message code="button.search" /></a>
            </form> 
           		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__LOCKS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-locks'" onclick="lock1()">锁定盘库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__UNLOCK"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-unlock'" onclick="unlock1()">解锁盘库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__SCANNING"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-scanning'" onclick="scanning1()">扫描对库</a></auth:button>
				
		   		
			 </div>
        <table id="mixstorageplandatascan_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixStoragePlanDataScan_dg_toolbar',
                url: 'mix/storageManagement/mixStoragePlanDataScan/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 数据对库处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="field:'check_hand_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_flag_s" /></th>
                    <!-- 数据对库处理时间 -->
                    <th data-options="field:'check_hand_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_time_t" /></th>
                    <!-- 数据对库处理反馈 -->
                    <th data-options="field:'check_hand_msg_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_msg_s" /></th>
                    <!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
                    <th data-options="field:'inventory_result_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_result_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'material_group_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_group_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_name_s" /></th>
                    <!-- 系统数量 -->
                    <th data-options="field:'sys_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_qty_f" /></th>
                    <!-- 系统重量 -->
                    <th data-options="field:'sys_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_weight_f" /></th>
                    <!-- 系统中库位 -->
                    <th data-options="field:'sys_loc_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_loc_s" /></th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.lot_no_s" /></th>
                    <!-- 进厂批次 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare1_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'carrier_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.carrier_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.equip_name_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.product_time_s" /></th>
                    <!-- 入库日期 -->
                    <th data-options="field:'in_date_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.in_date_s" /></th>
                    <!-- 出库日期 -->
                    <th data-options="field:'out_date_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.out_date_s" /></th>
                    <!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
                    <th data-options="field:'datasource_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.datasource_s" /></th>
                    <!-- 创建人姓名  -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_time_t" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_time_t" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare5_s" /></th>
                    <!-- 备用字段6 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare9_s" /></th>
                    <!-- 备用字段10 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare10_s" /></th>
                    <%-- <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.arch_flag_s" /></th>
                    <!-- 单位 -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.baseunit_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_by_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_by_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.equip_code_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.id_s" /></th>
                    <!-- 盘点时库位编码 -->
                    <th data-options="field:'inventory_loc_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_loc_code_s" /></th>
                    <!-- 作业名称 -->
                    <th data-options="field:'job_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.job_name_s" /></th>
                    <!-- 盘库计划管理表作业号：外键，CM_WH_ITEM_INV_JOB.JOB_NO -->
                    <th data-options="field:'job_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.job_no_s" /></th>
                    <!-- 记录标志：A-可用，D-删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.record_flag_s" /></th>
                    <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格、特殊放行的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.state_code_s" /></th>
                    <!-- 系统中库位编码 -->
                    <th data-options="field:'sys_loc_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_loc_code_s" /></th>
                    <!-- 工厂：1-全钢、2-半钢 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.s_factory_s" /></th> --%>
                </tr>
            </thead>
        </table>
    </div>

	<!-- 盘库生产数据 -->	
    <div title="盘库生产数据" style="padding: 10px" >
        <div id="MixStoragePlanDataProd_dg_toolbar">
            <form id="MixStoragePlanDataProd_search_form" class="form" >
                <!-- 入库日期 -->
                <spring:message code="mixstorageplandata.column.in_date_s" />
                <input name="filter[in_date_s]" id="in_date_s3" style="width: 90px" type="text" class="easyui-datebox" 
                data-options="onChange:getJobName2,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
                <script type="text/javascript">
						$("#in_date_s3").val(new Calendar().format("yyyyMMdd"));
				</script>
                <!-- 作业名称 -->
                <spring:message code="mixstorageplandata.column.job_name_s" />
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" 
                data-options="label:'',
                 		data:jobnamelist,
	         		   	panelHeight:150,
	         		   	editable:true,
	           		   	valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   	selectOnNavigation:false,
	           		   	limitToList:true" >
              
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter2()"><spring:message code="button.search" /></a>
            </form> 
           		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__LOCKS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-locks'" onclick="lock2()">锁定盘库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__UNLOCK"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-unlock'" onclick="unlock2()">解锁盘库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__SCANNING"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-scanning'" onclick="scanning2()">扫描对库</a></auth:button>
				
		   		
			 </div>
        <table id="mixstorageplandataprod_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixStoragePlanDataProd_dg_toolbar',
                url: 'mix/storageManagement/mixStoragePlanDataProd/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 数据对库处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="field:'check_hand_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_flag_s" /></th>
                    <!-- 数据对库处理时间 -->
                    <th data-options="field:'check_hand_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_time_t" /></th>
                    <!-- 数据对库处理反馈 -->
                    <th data-options="field:'check_hand_msg_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_msg_s" /></th>
                    <!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
                    <th data-options="field:'inventory_result_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_result_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'material_group_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_group_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_name_s" /></th>
                    <!-- 系统数量 -->
                    <th data-options="field:'sys_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_qty_f" /></th>
                    <!-- 系统重量 -->
                    <th data-options="field:'sys_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_weight_f" /></th>
                    <!-- 系统中库位 -->
                    <th data-options="field:'sys_loc_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_loc_s" /></th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.lot_no_s" /></th>
                    <!-- 进厂批次 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare1_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'carrier_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.carrier_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.equip_name_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.product_time_s" /></th>
                    <!-- 入库日期 -->
                    <th data-options="field:'in_date_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.in_date_s" /></th>
                    <!-- 出库日期 -->
                    <th data-options="field:'out_date_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.out_date_s" /></th>
                    <!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
                    <th data-options="field:'datasource_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.datasource_s" /></th>
                    <!-- 创建人姓名  -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_time_t" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_time_t" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare5_s" /></th>
                    <!-- 备用字段6 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare9_s" /></th>
                    <!-- 备用字段10 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare10_s" /></th>
                    <%-- <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.arch_flag_s" /></th>
                    <!-- 单位 -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.baseunit_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_by_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_by_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.equip_code_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.id_s" /></th>
                    <!-- 盘点时库位编码 -->
                    <th data-options="field:'inventory_loc_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_loc_code_s" /></th>
                    <!-- 作业名称 -->
                    <th data-options="field:'job_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.job_name_s" /></th>
                    <!-- 盘库计划管理表作业号：外键，CM_WH_ITEM_INV_JOB.JOB_NO -->
                    <th data-options="field:'job_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.job_no_s" /></th>
                    <!-- 记录标志：A-可用，D-删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.record_flag_s" /></th>
                    <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格、特殊放行的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.state_code_s" /></th>
                    <!-- 系统中库位编码 -->
                    <th data-options="field:'sys_loc_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_loc_code_s" /></th>
                    <!-- 工厂：1-全钢、2-半钢 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.s_factory_s" /></th> --%>
                </tr>
            </thead>
        </table>
    </div>

	<!-- 盘库出库数据 -->	
    <div title="盘库出库数据" style="padding: 10px" >
        <div id="MixStoragePlanDataOut_dg_toolbar">
            <form id="MixStoragePlanDataOut_search_form" class="form" >
                <!-- 入库日期 -->
                <spring:message code="mixstorageplandata.column.in_date_s" />
                <input name="filter[in_date_s]" id="in_date_s4" style="width: 90px" type="text" class="easyui-datebox" 
                data-options="onChange:getJobName3,formatter:dateFormat,buttons:[],parser:dateParser,label:''" >
                <script type="text/javascript">
						$("#in_date_s4").val(new Calendar().format("yyyyMMdd"));
				</script>
                <!-- 作业名称 -->
                <spring:message code="mixstorageplandata.column.job_name_s" />
                <input name="filter[job_name_s]" id="job_name_s" type="text" class="easyui-combobox" 
                data-options="label:'',
                 		data:jobnamelist,
	         		   	panelHeight:150,
	         		   	editable:true,
	           		   	valueField:'JOB_NAME_S',
	          		    textField:'JOB_NAME_S',
	                   	selectOnNavigation:false,
	           		   	limitToList:true" >
                
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter3()"><spring:message code="button.search" /></a>
            </form> 
           		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__LOCKS"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-locks'" onclick="lock3()">锁定盘库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__UNLOCK"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-unlock'" onclick="unlock3()">解锁盘库</a></auth:button>
				
		   		<auth:button code="BAN_GANG_ML_KCGL_STOCK_MANAGEMENT__SCANNING"><a class="easyui-linkbutton btn-black"
						data-options="iconCls:'icon-scanning'" onclick="scanning3()">扫描对库</a></auth:button>
				
			 </div>
        <table id="mixstorageplandataout_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MixStoragePlanDataOut_dg_toolbar',
                url: 'mix/storageManagement/mixStoragePlanDataOut/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 数据对库处理标记：0-未处理、1-已处理、2-处理失败 -->
                    <th data-options="field:'check_hand_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_flag_s" /></th>
                    <!-- 数据对库处理时间 -->
                    <th data-options="field:'check_hand_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_time_t" /></th>
                    <!-- 数据对库处理反馈 -->
                    <th data-options="field:'check_hand_msg_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.check_hand_msg_s" /></th>
                    <!-- 盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物 -->
                    <th data-options="field:'inventory_result_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_result_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'material_group_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_group_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.material_name_s" /></th>
                    <!-- 系统数量 -->
                    <th data-options="field:'sys_qty_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_qty_f" /></th>
                    <!-- 系统重量 -->
                    <th data-options="field:'sys_weight_f',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_weight_f" /></th>
                    <!-- 系统中库位 -->
                    <th data-options="field:'sys_loc_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_loc_s" /></th>
                    <!-- 批次号 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.lot_no_s" /></th>
                    <!-- 进厂批次 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare1_s" /></th>
                    <!-- 载具条码 -->
                    <th data-options="field:'carrier_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.carrier_code_s" /></th>
                    <!-- 机台名称 -->
                    <th data-options="field:'equip_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.equip_name_s" /></th>
                    <!-- 产出时间 -->
                    <th data-options="field:'product_time_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.product_time_s" /></th>
                    <!-- 入库日期 -->
                    <th data-options="field:'in_date_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.in_date_s" /></th>
                    <!-- 出库日期 -->
                    <th data-options="field:'out_date_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.out_date_s" /></th>
                    <!-- 数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化 -->
                    <th data-options="field:'datasource_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.datasource_s" /></th>
                    <!-- 创建人姓名  -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_time_t" /></th>
                    <!-- 修改人姓名 -->
                    <th data-options="field:'changed_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_name_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_time_t" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare5_s" /></th>
                    <!-- 备用字段6 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare9_s" /></th>
                    <!-- 备用字段10 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.spare10_s" /></th>
                    <%-- <!-- 归档标记 -->
                    <th data-options="field:'arch_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.arch_flag_s" /></th>
                    <!-- 单位 -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.baseunit_s" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.changed_by_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.created_by_s" /></th>
                    <!-- 机台编码 -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.equip_code_s" /></th>
                    <!-- 主键ID -->
                    <th data-options="field:'id_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.id_s" /></th>
                    <!-- 盘点时库位编码 -->
                    <th data-options="field:'inventory_loc_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.inventory_loc_code_s" /></th>
                    <!-- 作业名称 -->
                    <th data-options="field:'job_name_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.job_name_s" /></th>
                    <!-- 盘库计划管理表作业号：外键，CM_WH_ITEM_INV_JOB.JOB_NO -->
                    <th data-options="field:'job_no_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.job_no_s" /></th>
                    <!-- 记录标志：A-可用，D-删除 -->
                    <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.record_flag_s" /></th>
                    <!-- 状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格、特殊放行的）、 001004-封锁（MES不能调拨出库） -->
                    <th data-options="field:'state_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.state_code_s" /></th>
                    <!-- 系统中库位编码 -->
                    <th data-options="field:'sys_loc_code_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.sys_loc_code_s" /></th>
                    <!-- 工厂：1-全钢、2-半钢 -->
                    <th data-options="field:'s_factory_s',editor:{type:'textbox'}"><spring:message code="mixstorageplandata.column.s_factory_s" /></th> --%>
                </tr>
            </thead>
        </table>
    </div>
</div>
<jsp:include page="../../../../inc/export.jsp">
        <jsp:param name="idField" value="atr_key" />
        <jsp:param name="formId" value="MixStoragePlanData_search_form" />
        <jsp:param name="datagridId" value="mixstorageplandata_dg" />
        <jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.mix.export.MixStoragePlanDataExportHandler" />
        <jsp:param name="serviceName" value="MixStoragePlanDataServiceImpl" />
    </jsp:include>
</body>
</html>
