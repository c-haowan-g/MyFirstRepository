<!-- 

    作者      :时永良
    时间      :2019年7月17日16:31:08
    页面名称:生产明细查询
    文件关联:
        WorkOrderResult.java
        WorkOrderResultController.java
        WorkOrderResultServiceImpl.java
        WorkOrderResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="workorderresult.js.jsp"%>
<script type="text/javascript" src="dict/301,302,305,253.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>

<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="WorkOrderResult_dg_toolbar">
			<form id="WorkOrderResult_search_form" class="form">
				<!-- 轮胎条码 -->
				<spring:message code="workorderresult.column.tyre_barcode_s" />:
				<input name="filter[tyre_barcode_s]" id="tyre_barcode_s" style="width:130px;"  type="text" class="easyui-textbox" data-options="label:''">
				<!-- 机台编码 -->
				<spring:message code="c_mm_workorderresult.column.equip_code_s" />:
				<input name="filter[equip_code_s]" id="equip_code_s" beginWith=true style="width:120px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'curing/report/productionSubsidiaryQuery/searchByEquipCode',
										  valueField: 'EQUIP_CODE_S',
                              			  textField: 'EQUIP_CODE_S',
										  method:'get'">
				<!-- 硫化班次 -->
				<spring:message code="workorderresult.column.class_id_s" />:
				<input name="filter[class_id_s]" id="class_id_s" beginWith=true style="width:120px;" type="text" class="easyui-combotree" data-options="label:'',
						                  labelWidth:'auto',
										  panelWidth:'15%',
										  panelHeight:100,
										  required:false,
										  url:'dict/code/302',
										  method:'get'">
				<!-- 胶囊条码 -->
				<spring:message code="workorderresult.column.capsule_id_s" />:
				<input name="filter[capsule_id_s]" id="capsule_id_s" style="width:100px;" beginWith=true type="text" class="easyui-textbox" data-options="label:''">
				<!-- 固化标识 -->
				<spring:message code="workorderresult.column.solidif_yflag_sATO" />:
				<input  name="filter[solidif_yflag_s]" id="solidif_yflag_s" type="text" class="easyui-combobox" style="width:100px" data-options="label:'',
                                        required:false, 
                                       	 data: [{
											text: '请选择',
											value: ''
										},{
											text: '已固化',
											value: '1'
										},{
											text: '未固化',
											value: '0'
										}],
			                             method: 'get'">
			    <br>
			    <!-- 硫化等级 -->
				<spring:message code="workorderresultprint.column.spare5_s" />:
				<input name="filter[spare5_s]" id="spare5_s" beginWith=true style="width:100px;" type="text" class="easyui-combotree" data-options="label:'',
						                  labelWidth:'auto',
										  panelHeight:150,
										  required:false,
										  url:'dict/code/253',
										  method:'get'">
				<!-- 物料编码 -->
				<spring:message code="workorderresult.column.material_code_s" />:
				<input name="filter[material_code_s]" id="material_code_s" beginWith=true style="width:130px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'curing/report/productionSubsidiaryQuery/searchByMaterial',
										  valueField: 'MATERIALCODE_S',
                              			  textField: 'MATERIALCODE_S',
										  method:'get'">
				<!-- 生产报工流水号 -->
				<spring:message code="c_mm_workorderresult.column.spare1_s" />:
				<input name="filter[spare1_s]" id="spare1_s" style="width:120px;" beginWith=true type="text" class="easyui-textbox" data-options="label:''">

				<spring:message code="workorderresult.column.curing_openmoulddate_t" />:
				<input name="filter[start_time]" type="text" id="start_time" class="easyui-datetimebox" style="width:150px;" data-options="label:''">
				<spring:message code="tip.to" />
				&emsp;
				<input name="filter[end_time]" id="end_time" class="easyui-datetimebox" style="width:150px;">
				<br>
				<!-- 模具条码 -->
				<spring:message code="左模具条码" />:
				<input name="filter[mold_code_left]" id="mold_code_left" style="width:120px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'curing/report/productionSubsidiaryQuery/searchMoldCode',
										  valueField: 'mold_code_s',
                              			  textField: 'mold_code_s',
										  method:'get'">
			    <spring:message code="右模具条码" />:
				<input name="filter[mold_code_right]" id="mold_code_right" style="width:120px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'curing/report/productionSubsidiaryQuery/searchMoldCode',
										  valueField: 'mold_code_s',
                              			  textField: 'mold_code_s',
										  method:'get'">
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()">
					<spring:message code="button.search" />
				</a>
				<auth:button code="WorkOrderResult.export">
					<a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()">
						<spring:message code="button.export" />
					</a>
				</auth:button>
				<auth:button code="productionDetail">
					 <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-log'" onclick="searchDxyl()">
						<spring:message code="button.searchDxyl" />
					</a>
				</auth:button>
            
			</form>
		</div>
		<table id="workorderresult_dg" class="easyui-datagrid" style="width:100%" data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: true,
                toolbar: '#WorkOrderResult_dg_toolbar',
                striped:true,
                method: 'get',
                onDblClickRow:onDblClickRow,
                emptyMsg:'暂无数据' 
                ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true">ID</th>
					<!-- 轮胎条码 -->
					<th data-options="field:'tyre_barcode_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.tyre_barcode_s" /></th>
					<!-- 硫化质量等级 -->
					<th data-options="field:'spare5_s',formatter:codeFormatter,sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.spare5_s" /></th>
					<!-- 机台编码 -->
					<th data-options="field:'equip_code_s',sortable:true,editor:{type:'textbox'}"><spring:message code="c_mm_workorderresult.column.equip_code_s" /></th>
					<!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 规格描述 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                    <!-- 生产日期 -->
					<th data-options="field:'product_date_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.product_date_s" /></th>
					<!-- 硫化工人 -->
					<th data-options="field:'curing_worker_s_name',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.curing_worker_s" /></th>
					<!-- 硫化扫描时间 -->
					<th data-options="field:'curings_candate_t',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.curings_candate_t" /></th>
					<!-- 硫化合模时间 -->
					<th data-options="field:'curing_closemoulddate_t',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.curing_closemoulddate_t" /></th>
					<!-- 硫化开模时间 -->
					<th data-options="field:'curing_openmoulddate_t',editor:{type:'textbox'}", ><spring:message code="workorderresult.column.curing_openmoulddate_t" /></th>
					<!-- 固化标识 1:已固化 0或者null :未固化 -->
                    <th data-options="field:'solidif_yflag_sato',editor:{type:'textbox'}"><spring:message code="workorderresult.column.solidif_yflag_sATO" /></th>
                    <!-- 生产版本 -->
                    <th data-options="field:'productionver_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.productionver_s" /></th>
                    <!-- 生产报工流水号 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.spare1_s" /></th>
					
					<!-- 硫化首模标识 -->
					<th data-options="field:'first_potflag_sato',editor:{type:'textbox'}"><spring:message code="workorderresult.column.first_potflag_s" /></th>
					<!-- 是否实验胎 1：是 0：否 -->
                    <th data-options="field:'spare6_s',formatter:istestFormatter,editor:{type:'textbox'}"><spring:message code="workorderresulttosap.column.spare6_s" /></th>
                    <!-- 是否补硫化 1：是 0：否 -->
                    <th data-options="field:'patch_curingflag_sato',editor:{type:'textbox'}"><spring:message code="workorderresult.column.patch_curingflag_s" /></th>
                    <!-- 是否条码替换 -->
                    <th data-options="field:'spare2_sato',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.spare2_s" /></th>
                    <!--是否规格更正 -->
                    <th data-options="field:'spare3_s',formatter:textFomatter,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.spare3_s" /></th>
                    <!-- 是否后充气报警 -->
                    <th data-options="field:'ispostinflation_s',formatter:textFomatter,editor:{type:'textbox'}"><spring:message code="workorderresult.column.ispostinflation_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'memo_s',editor:{type:'textbox'}"><spring:message code="c_mm_workorderresult.column.memo_s" /></th>
                    <!-- 胎胚角度 -->
                    <th data-options="field:'embryos_point_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.embryos_point_s" /></th>
                    <!-- 胶囊条码 -->
					<th data-options="field:'capsule_id_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.capsule_id_s" /></th>
					<!-- 模具条码 -->
					<th data-options="field:'mold_code_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.mold_code_s" /></th>
					<!-- DOT号 -->
					<th data-options="field:'dot_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.dot_s" /></th>
					<!-- 月计划号 -->
					<th data-options="field:'spare4_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.spare4_s" /></th>
					<!-- 工单号 -->
					<th data-options="field:'plan_no_s',sortable:true,editor:{type:'textbox'}"><spring:message code="workorderresult.column.plan_no_s" /></th>
					<!-- 硫化班次 -->
					<th data-options="field:'class_id_s',sortable:true,width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			panelHeight:200,
                    			method:'get',
                                url:'dict/code/302',
                    			required:true}}"><spring:message code="workorderresult.column.class_id_s" /></th>
					<!-- 硫化班组 -->
					<th data-options="field:'shift_id_s',sortable:true,width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			panelHeight:200,
                    			method:'get',
                                url:'dict/code/301',
                    			required:true}}"><spring:message code="workorderresult.column.shift_id_s" /></th>
                     </tr>
            </thead>
        </table>
    </div>
    
    <div id="lh_qx" class="easyui-window" title="查看硫化曲线"  maximized="true"  style="width:1200px;height:700px" closed="true">
		  <div id='canvasDiv'  ></div>
    </div>
    
     <div id="yl_qx" class="easyui-window" title="查看定型压力"  maximized="true"  style="width:1200px;height:700px" closed="true">
		  <div id='dxylDiv'  ></div>
    </div>
     
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WorkOrderResult_search_form" />
		<jsp:param name="datagridId" value="workorderresult_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.WorkOrderResultExportHandler" />
		<jsp:param name="serviceName" value="WorkOrderResultServiceImpl" />
	</jsp:include>
</body>
</html>
