<!-- 

    作者      :葛迎祥
    时间      :2019-09-21 10:34:42 
    页面名称:投料记录
    文件关联:
        FeedingRecord.java
        FeedingRecordController.java
        FeedingRecordServiceImpl.java
        FeedingRecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="feedingrecord.js.jsp"%>
<script type="text/javascript" src="dict/308,118,137.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="FeedingRecord_dg_toolbar">
            <form id="FeedingRecord_search_form" class="form" >
               <!-- 机台条码 -->
                <spring:message code="feedingrecord.column.machinecode_s" />
                :&emsp;<input name="filter[machinecode_s]" id="machinecode_s" type="text" class="easyui-combobox"
                		 data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            limitToList:'false',
				                        	data:productLineList,
				            	            textField:'DESCRIPTION',
				            	            valueField:'P_LINE_NAME',
                                            method:'get'">
                <!-- 投料类型 -->
                 &emsp;<spring:message code="feedingrecord.column.feedingtype_s" />
                :&emsp;<input name="filter[feedingtype_s]" id="feedingtype_s" type="text" class="easyui-combotree" data-options="label:'', 
	                required:false,
	                editable:true,
          			panelHeight:200,
          			url:'dict/code/308',
          			method:'get'" >
                <!-- 批次条码 -->
                 &emsp;<spring:message code="feedingrecord.column.barcode_s" />
                :&emsp;<input name="filter[barcode_s]" id="barcode_s" type="text"  class="easyui-textbox"  data-options="label:''" >
                <!-- 班次 -->
                 &emsp;<spring:message code="feedingrecord.column.bz_class_s" />
                :&emsp;<input name="filter[bz_class_s]" id="bz_class_s" type="text" class="easyui-combotree" data-options="label:'', 
	                required:false,
          			panelHeight:150,
          			url:'dict/code/118',
          			method:'get'">
                <br>
                <!-- 载具条码 -->
                <spring:message code="feedingrecord.column.vehicles_code_s" />
                :&emsp;<input name="filter[vehicles_code_s]" id="vehicles_code_s" type="text"  class="easyui-textbox"  data-options="label:''" >
                <!-- 使用状态 -->
                 &emsp;<spring:message code="feedingrecord.column.usestatus_s" />
                :&emsp;<input name="filter[usestatus_s]" id="usestatus_s" type="text"  class="easyui-combotree"  data-options="label:'',
                	                required:false,
          			panelHeight:150,
          			url:'dict/code/137',
          			method:'get'"" >
                <!-- 投料时间 -->
                 &emsp;<spring:message code="feedingrecord.column.inputtime_t" />
                :&emsp;<input name="filter[start_time]" id="start_time" type="text" class="easyui-datetimebox" data-options="label:''"></td>
				 &nbsp;<spring:message code="tip.to" />
				 &nbsp;<input name="filter[end_time]" id="end_time" type="text" class="easyui-datetimebox" data-options="label:''"></td>
                 &emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a> 
                 <auth:button code="feedingrecord.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
          </div>
        <table id="feedingrecord_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
			                fit:true,
			                fitColumns:true,
			                pagination:true,
			                rownumbers: true,
			                singleSelect: false,
			                toolbar: '#FeedingRecord_dg_toolbar',
			                url: '',
			                striped:true,
			                method: 'get',
			                emptyMsg: '<span><spring:message code='tip.noData'/></span>'">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台条码 -->
                    <th data-options="field:'machinecode_s',formatter:machineFormatter,sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.machinecode_s" /></th>
                    <!-- 产出物料编码 -->
                    <th data-options="field:'productmat_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.productmat_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materialcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.materialcode_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'materialname_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.materialname_s" /></th>
              
                    <!-- 载具条码 -->
                    <th data-options="field:'vehicles_code_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.vehicles_code_s" /></th>
                    <!-- 原料条码 -->
                    <th data-options="field:'barcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.barcode_s" /></th>
                     <!-- 投料量（重量、数量、长度） -->
                    <th data-options="field:'feedamount_f',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.feedamount_s" /></th>
                    <!-- 消耗量-总 -->
                    <th data-options="field:'consumeamount_f',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.consumeamount_f" /></th>
                    <!-- 剩余量（重量、数量、长度） -->
                    <th data-options="field:'surplusamount_f',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.surplusamount_f" /></th>
                    
                    <!-- 投料口 -->
                    <th data-options="field:'description',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.spare1_s" /></th>                    
                    <!-- 投料计数器数 -->
                    <th data-options="field:'macnumin_f',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.macnumin_f" /></th>
                    <!-- 投料类型 -->
                    <th data-options="field:'feedingtype_s',sortable:true,formatter:codeFormatter,
                                      options:{
			                                   method:'get',
			                                   url:'dict/code/308',
			                                   required:false},editor:{type:'textbox'}"><spring:message code="feedingrecord.column.feedingtype_s" /></th>
                    <!-- 班次 -->
                    <th data-options="field:'bz_class_s',sortable:true,formatter:codeFormatter,options:{
			                 method:'get',
			                 url:'dict/code/118',
			                 required:false},editor:{type:'textbox'}"><spring:message code="feedingrecord.column.bz_class_s" /></th>
                    <!-- 投料时间 -->
                    <th data-options="field:'inputtime_t',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.inputtime_t" /></th>
                    <!-- 撤下时间 -->
                    <th data-options="field:'removetime_t',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.removetime_t" /></th>
                	<!-- 操作工名称 -->
                    <th data-options="field:'worker_name_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.worker_id_s" /></th>
                    <!-- 数据来源  0-手持 1-RFID 3-扫描枪 -->
                    <th data-options="field:'source_s',sortable:true,formatter:source_sFormatter,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.source_s" /></th>
                    <!-- 班组 -->
                    <th data-options="field:'bz_group_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.bz_group_s" /></th>
                    <!-- 是否有剩余  可删除 -->
                    <th data-options="field:'haveresidual_s',sortable:true,formatter:oneFormatter,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.haveresidual_s" /></th>
                    <!-- 撤下计数器数 -->
                    <th data-options="field:'macnumout_f',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.macnumout_f" /></th>
                    <!-- 产出数量 -->
                    <th data-options="field:'opnum_f',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.opnum_f" /></th>
                    <!-- 工单号 -->
                    <th data-options="field:'order_planno_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.order_planno_s" /></th>
                    <!-- RFID地址 -->
                    <th data-options="field:'rfidadress_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.rfidadress_s" /></th>
                    <!-- 扫描类型 0-客户端记录 1-服务端记录 -->
                    <th data-options="field:'scan_type_s',formatter:scanFormatter,sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.scan_type_s" /></th>
                    <!-- 序号 -->
                    <th data-options="field:'serialcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.serialcode_s" /></th>
                    <!-- 钢丝剔除标记 0-否 1-是 -->
                    <th data-options="field:'steeldelflag_s',sortable:true,formatter:oneFormatter,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.steeldelflag_s" /></th>
                    <!-- 钢丝压延投料记录组 A B -->
                    <th data-options="field:'steelflag_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.steelflag_s" /></th>
                    <!-- 同步类型 0-已同步 1-未同步 -->
                    <th data-options="field:'sync_type_s',sortable:true,formatter:syncFormatter,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.sync_type_s" /></th>
                    <!-- 使用状态 基础数据字典 137 -->
                    <th data-options="field:'usestatus_s',sortable:true,formatter:code137Formatter,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.usestatus_s" /></th>
                    <!-- 操作工编码 -->
                    <th data-options="field:'worker_name_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.worker_name_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',sortable:true,editor:{type:'textbox'}"><spring:message code="feedingrecord.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
      <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="FeedingRecord_search_form" />
		<jsp:param name="datagridId" value="feedingrecord_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.FeedingRecordExportHandler"/>
		<jsp:param name="serviceName" value="FeedingRecordServiceImpl" />
	</jsp:include>
    </div>
</body>
</html>
