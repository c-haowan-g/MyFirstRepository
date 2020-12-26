<!-- 

    作者      :李昂
    时间      :2020-08-07 08:55:29 
    页面名称:原材料库存操作履历表
    文件关联:
        WhItemInvRecord.java
        WhItemInvRecordController.java
        WhItemInvRecordServiceImpl.java
        WhItemInvRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="whiteminvrecord.js.jsp"%>
<script type="text/javascript" src="dict/005,008,004,001,006.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WhItemInvRecord_dg_toolbar">
            <form id="WhItemInvRecord_search_form" class="form" >
               
               
                <!-- 库存操作时间 -->
                <spring:message code="whiteminvrecord.column.enter_time_t" />
                 :&emsp;<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
				type="text" class="easyui-datetimebox" style="width:165px"data-options="label:''">
				
				&emsp;到&emsp; <input name="filter[end_created_time]" editable="true" id="end_created_time"
				class="easyui-datetimebox" style="width:165px">
				
                
                <!-- 库区类型：005001-常温库、005002-加温库、005003-称量预入库、005004-线边库、005006-炭黑库、005007-辅料库、005008-硫磺库、005009-橡胶库、005010-骨架材料库、005011-油料库、005012-立体库、005013-白炭黑库 -->
                <spring:message code="whiteminvrecord.column.store_type_s" />
                
                <input name="filter[store_type_s]" id="store_type_s"  type="text" class="easyui-combotree" style="width: 165px;"
                        data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/005',
				              			 method:'get'" >
                <!-- 库存操作类型：008001-入库、008002-出库、008003-移库、008004-发料、008005-第三方反馈、008006-盘库 -->
                <spring:message code="whiteminvrecord.column.inv_type_s" />
                :&emsp;
                <input name="filter[inv_type_s]" id="inv_type_s"  type="text" class="easyui-combotree"
                        data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/008',
				              			 method:'get'" >
                </br>
                <!-- 库存操作区分： 004001-采购新增入临时库 004002-采购新增入正式库 004003-手动入库 004004-退库入库 004010-生产出库 004011-手动出库 004012-检查出库 004013-不良出库  004020-生产移库 004021-手动移库 004022-检查移库 004023-不良移库 004024-手动盘库 004030-手动发料 004031-自动发料 004040-库存更新 004041-其它 -->
                <spring:message code="whiteminvrecord.column.warehouse_type_s" />
                <input name="filter[warehouse_type_s]" id="warehouse_type_s"  type="text" class="easyui-combotree"
                       data-options="label:'',
				              			 required:false,
				              			 panelHeight:200,
				              			 url:'dict/code/004',
				              			 method:'get'" >
               
               
               
                <!-- 计量单号 -->
                <spring:message code="whiteminvrecord.column.weight_number_s" />
                <input name="filter[weight_number_s]" id="weight_number_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- SAP内向交货单表，内向交货单号 -->
                <spring:message code="whiteminvrecord.column.dn_dnno_s" />
                <input name="filter[dn_dnno_s]" id="dn_dnno_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="whiteminvrecord.column.material_code_s" />
                :&emsp;<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                </br>
                <!-- 进厂批次（G固定字符+4位年号+-固定字符+4位流水号）例如：G2019-0001 -->
                <spring:message code="whiteminvrecord.column.lot_no_s" />
                :&emsp;<input name="filter[lot_no_s]" id="lot_no_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                
                
               
                
                
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="RAW_Reports Center_LLRP02_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
           </div>
        <table id="whiteminvrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WhItemInvRecord_dg_toolbar',
                url: 'material/reportsCenter/whiteminvrecord/datagrid',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                     <!-- 进厂批次（G固定字符+4位年号+-固定字符+4位流水号）例如：G2019-0001 -->
                    <th data-options="field:'lot_no_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.lot_no_s" /></th>
                     <!-- 供应商全称 -->
                    <th data-options="field:'supplier_name_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.supplier_name_s" /></th>
                     <!-- 库存重量 -->
                    <th data-options="field:'qty_left_f',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.qty_left_f" /></th>
                    <!-- 操作库存重量 -->
                    <th data-options="field:'qty_f',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.qty_f" /></th>
                    <!-- 库存操作时间 -->
                    <th data-options="field:'enter_time_t',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.enter_time_t" /></th>
                      <!-- 供应商编号 -->
                    <th data-options="field:'supplier_code_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.supplier_code_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.materialgroup_s" /></th>
                    <!-- 物料类别(上辅机定义) -->
                    <th data-options="field:'materialtype_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.materialtype_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.material_code_s" /></th>
                    <!-- 放行原因 -->
                    <th data-options="field:'reas_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.reas_code_s" /></th>
                    <!-- 立库编号（1、2、3、4、5...） -->
                    <th data-options="field:'warehouseid_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.warehouseid_s" /></th>
                    <!-- 库位编号 -->
                    <th data-options="field:'store_code_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.store_code_s" /></th>
                    <!-- 库区类型：005001-常温库、005002-加温库、005003-称量预入库、005004-线边库、005006-炭黑库、005007-辅料库、005008-硫磺库、005009-橡胶库、005010-骨架材料库、005011-油料库、005012-立体库、005013-白炭黑库 -->
                    <th data-options="field:'store_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.store_type_s" /></th>
                    <!-- 备用字段4：库位名称 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare4_s" /></th>
                     <!-- 库存操作类型：008001-入库、008002-出库、008003-移库、008004-发料、008005-第三方反馈、008006-盘库 -->
                    <th data-options="field:'inv_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.inv_type_s" /></th>
                    <!-- 出库目标位置 -->
                    <th data-options="field:'warehouse_location_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.warehouse_location_s" /></th>
                    <!-- 出库方式 -->
                    <th data-options="field:'warehouse_mode_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.warehouse_mode_s" /></th>
                    <!-- 托盘编号 -->
                    <th data-options="field:'tray_code_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.tray_code_s" /></th>
                     <!-- 库存操作备注 -->
                    <th data-options="field:'warehouse_remark_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.warehouse_remark_s" /></th>
                    <!-- 库存操作区分： 004001-采购新增入临时库 004002-采购新增入正式库 004003-手动入库 004004-退库入库 004010-生产出库 004011-手动出库 004012-检查出库 004013-不良出库  004020-生产移库 004021-手动移库 004022-检查移库 004023-不良移库 004024-手动盘库 004030-手动发料 004031-自动发料 004040-库存更新 004041-其它 -->
                    <th data-options="field:'warehouse_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.warehouse_type_s" /></th>
                    <!-- 载具编号 -->
                    <th data-options="field:'carrier_code_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.carrier_code_s" /></th>
                     <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.material_name_s" /></th>
                     <!-- 基本单位 -->
                    <th data-options="field:'baseunit_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.baseunit_s" /></th>
                    <!-- 是否试验料：0-否，1-是 -->
                    <th data-options="field:'testmat_flag_s',formatter:isTestmatFlag,editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.testmat_flag_s" /></th>
                    <!-- 是否优先使用：0-否、1-是 -->
                    <th data-options="field:'prioritymat_flag_s',formatter:isTestmatFlag,editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.prioritymat_flag_s" /></th>
                    <!-- 供应商原料批次号生产日期 -->
                    <th data-options="field:'product_time_t',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.product_time_t" /></th>
                    <!-- 原材料称量表，计量单号 -->
                    <th data-options="field:'weight_number_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.weight_number_s" /></th>
                	<!-- SAP内向交货单表，内向交货单行号 -->
                    <th data-options="field:'dn_dnitem_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.dn_dnitem_s" /></th>
                    <!-- SAP内向交货单表，内向交货单号 -->
                    <th data-options="field:'dn_dnno_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.dn_dnno_s" /></th>
                     <!-- SAP内向交货单表，出货单单号 -->
                    <th data-options="field:'dn_salordid_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.dn_salordid_s" /></th>
                    <!-- SAP内向交货单表，出货单行号 -->
                    <th data-options="field:'dn_salorditem_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.dn_salorditem_s" /></th>
                    <!-- 入库、出库请求时间 -->
                    <th data-options="field:'request_time_t',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.request_time_t" /></th>
                    <!-- 请求备注 -->
                    <th data-options="field:'request_remark_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.request_remark_s" /></th>
                    <!-- 请求状态 -->
                    <th data-options="field:'request_state_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.request_state_s" /></th>
                    <!-- 接收时间 -->
                    <th data-options="field:'receive_time_t',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.receive_time_t" /></th>
                    <!-- 接收备注 -->
                    <th data-options="field:'receive_remark_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.receive_remark_s" /></th>
                    <!-- 创建人姓名 -->
                    <th data-options="field:'created_name_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.created_name_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.changed_by_s" /></th>
        			<!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.changed_time_t" /></th>
                   	 <!-- 备用字段6：DQW检测项名称-气味等级是否合格：0-无DQW检测项，1-合格，2-不合格 -->
                    <th data-options="field:'spare5_s',formatter:isPrioritymatFlag,editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare5_s" /></th>
                   	<!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare1_s" /></th>
                    <!-- 备用字段2：单件重量 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare2_s" /></th>
                    <!-- 备用字段3：库区名称 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare3_s" /></th>
                   
                    <!-- 备用字段6 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare9_s" /></th>
                	<!-- 备用字段10 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="whiteminvrecord.column.spare10_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
     <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key"/>
		<jsp:param name="formId" value="WhItemInvRecord_search_form" />
		<jsp:param name="datagridId" value="whiteminvrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.material.excel.WhItemInvRecordExportHandler" />
		<jsp:param name="serviceName" value="WhItemInvRecordServiceImpl" />
	</jsp:include>
</body>
</html>
