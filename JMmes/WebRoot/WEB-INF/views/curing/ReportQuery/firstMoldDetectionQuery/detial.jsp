<!-- 

    作者      :时永良
    时间      :2018-08-07 17:18:05 
    页面名称:首模检测查询
    文件关联:
        Detial.java
        FirstMoldDetectionController.java
        FirstMoldDetectionServiceImpl.java
        FirstMoldDetectionServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="detial.js.jsp"%>
<script type="text/javascript" src="dict/302.js"></script>
<body class="easyui-layout" fit="true">
	<div data-options="region:'center',split:true,border:false">
		<div id="EntDetial_dg_toolbar">
			<form id="Detial_search_form" class="form">
				<!-- 质检时间 -->
				<spring:message code="detial.column.opertime_t" />
				: <input name="filter[start_opertime_t]" id="start_opertime_t" class="easyui-datetimebox" data-options="label:''">
				<!-- 质检时间 -->
				到<input name="filter[end_opertime_t]" id="end_opertime_t" class="easyui-datetimebox">
				<!-- 轮胎条码 -->
				<spring:message code="detial.column.barcode_s" />:
				<input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''"> 
				<!-- 品号 -->
				<spring:message code="entdetial.column.speccode_s" />
				: <input name="filter[itemid_s]" id="itemid_s" type="text" class="easyui-textbox" data-options="label:''"> 
				
				  <spring:message code="detial.column.equip_code_s" />:
		                <!-- 机台编码 -->
		              <input name="filter[equip_code_s]" id="equip_code_s" like="true" style="width:120px;" class="easyui-combobox" data-options="label:'',
										  panelHeight:200,
										  required:false,
										  editable:true,
										  limitToList:false,
										  url:'curing/report/productionSubsidiaryQuery/searchByEquipCode',
										  valueField: 'EQUIP_CODE_S',
                              			  textField: 'EQUIP_CODE_S',
										  method:'get'">
				
				<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'"onclick="doSearch()"><spring:message code="button.search" /></a>
				<auth:button code="ZJ_CPGL_SMJC_EXPORT">
					<a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a>
				</auth:button>
			</form>

		</div>

		<table id="detial_dg" class="easyui-datagrid" style="width:100%"
			data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#EntDetial_dg_toolbar',
                url: '',
                method:'get',
		        emptyMsg:'暂无数据',
		        striped:true,
                ">
			<thead>
				<tr>
					<th data-options="field:'atr_key',checkbox:true">ID</th>
					<!-- 轮胎条码：MainTyre 表 BARCODE -->
					<th data-options="field:'barcode_s',width:100,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.barcode_s" /></th>
					<!-- 品号 -->
					<th data-options="field:'itemid_s',width:100,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.itemid_s" /></th>
					<!-- 规格描述-->
					<th data-options="field:'material_name_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.material_name_s" /></th>
					<!-- 检查状态 -->
					<th data-options="field:'status_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.status_s" /></th>
					<!-- 病象描述 -->
					<th data-options="field:'reas_cn_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.reas_cn_s" /></th>
					<!-- 硫化机台 -->
					<th data-options="field:'equip_code_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.equip_code_s" /></th>
					<!-- 硫化时间 -->
					<th data-options="field:'curings_candate_t',width:150,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.curings_candate_s" /></th>
					<!-- 硫化工 +名字-->
					<th data-options="field:'curing_worker_s',width:120,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.curing_worker_s" /></th>
					<!-- 质检员工号+名字 -->
					<th data-options="field:'operby_s',width:120,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.operby_s" /></th>
					<!-- 质检时间 -->
					<th data-options="field:'opertime_t',width:150,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.opertime_t" /></th>
					<%--  <!-- 班组代码 -->
					<th data-options="field:'groupcd_s',editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.groupcd_s" /></th> --%>
					 <!-- 班次代码 -->
					<th data-options="field:'shiftcd_s',width:100,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/302',
                                editable:'true',
                                panelWidth:'300',
                    			}}"><spring:message code="detial.column.shiftcd_s" /></th>
					<%-- <!-- 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 -->
                    <th data-options="field:'agenc_no_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.agenc_no_s" /></th>
                    <!-- 成型换规首条确认标记： 1：换工装（换大规格）待检；2：普通换欧盟规格待检；0：质检已确认 -->
                    <th data-options="field:'aqhmflag_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.aqhmflag_s" /></th>
                    <!-- 轮胎类型区分：0：正常；1：技术用胎；2：测温；3：扒废；4：质单； 5：实验胎；6：重建胎 -->
                    <th data-options="field:'attribute_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.attribute_s" /></th>
                    <!-- 载具ID -->
                    <th data-options="field:'carriercode_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.carriercode_s" /></th>
                    <!-- 首中末件的标识：1首件2中件3末件 -->
                    <th data-options="field:'checkflag_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.checkflag_s" /></th>
                    <!-- 曲线胎标记： 0：正常；1：曲线胎；2：SDS -->
                    <th data-options="field:'curveflag_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.curveflag_s" /></th>
                    <!-- 动平衡机条码：Ent 表 ENTBARCODE -->
                    <th data-options="field:'dbmbar_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.dbmbar_s" /></th>
                    <!-- 是否复检：0未复检、1已复检过 -->
                    <th data-options="field:'isrecheck_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.isrecheck_s" /></th>
                    <!-- 物料类ID -->
                    <th data-options="field:'itemclassid_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.itemclassid_s" /></th>
                    
                    <!-- 均匀机条码：Ent 表 ENTBARCODE -->
                    <th data-options="field:'jyxmbar_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.jyxmbar_s" /></th>
                    <!-- 是否新品 -->
                    <th data-options="field:'newitem_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.newitem_s" /></th>
                    <!-- 当前工序 -->
                    <th data-options="field:'proess_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.proess_s" /></th>
                    <!-- 病象代码：QM_Reas 表 ID -->
                    <th data-options="field:'reascd_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.reascd_s" /></th>
                    <!-- 自检标识（默认0合格，1不合格) -->
                    <th data-options="field:'selfflag_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.selfflag_s" /></th>
                    <!-- 轮胎状态编码：0-待检、1-合格、2-不合格 -->
                    <th data-options="field:'statecd_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.statecd_s" /></th>
                    <!-- 库区ID -->
                    <th data-options="field:'stockareacode_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.stockareacode_s" /></th>
                    <!-- 工厂(1.全钢 2.半钢) -->
                    <th data-options="field:'s_factory_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.s_factory_s" /></th>
                    <!-- 工装器具ID -->
                    <th data-options="field:'utensilcode_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.utensilcode_s" /></th>
                    <!-- X光机条码：Ent 表 ENTBARCODE -->
                    <th data-options="field:'xraymbar_s',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="detial.column.xraymbar_s" /></th>
                    --%>
				</tr>
			</thead>
		</table>
	</div>

	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="EntDetial_search_form" />
		<jsp:param name="datagridId" value="detial_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.FirstMoldDetectionHandler" />
		<jsp:param name="serviceName" value="FirstMoldDetectionServiceImpl" />
	</jsp:include>
</body>
</html>
