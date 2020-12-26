<!-- 

    作者      :李昂
    时间      :2020-08-18 08:21:36 
    页面名称:原材料库存状态看板
    文件关联:
        RawMaterialInventoryState.java
        RawMaterialInventoryStateController.java
        RawMaterialInventoryStateServiceImpl.java
        RawMaterialInventoryStateServiceImpl.xml
        
 -->
<!-- 原材料库存状态 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="rawMaterialInventoryState.js.jsp"%>
<script type="text/javascript" src="dict/005.js"></script>
<style type="text/css">

table {
           /*列宽由表格宽度和列宽度设定*/
           table-layout: fixed;
       }
</style>
<script type="text/javascript">
</script>
<body class="easyui-layout" fit="true">
<div id="name" style="width:100%" align="center">
	<h1 style="color:blue"><spring:message code="原材料库存状态看板" /></h2>
</div>
<div id="message"></div>
	<div data-options="region:'center',split:true,border:false" style="width:100%">
	    	<table class="easyui-datagrid" style="width:80%" id="dg"
			data-options="
		          fit:true,
		          fitColumns:true,
		          rownumbers:false,
		          singleSelect:true,
		          method:'get',
		          url:'material/digitalSignage/RawMaterialInventoryState/datagrid',
		           emptyMsg:'<span><spring:message code='tip.noData'/></span>',
		          striped:true,
		          toolbar:'#message,#name'
		          ">
			<thead>
				<tr>
	            	<!--库房-->
					<th data-options="field:'store_type_s',formatter:codeFormatter,editor:{type:'textbox'}">库房</th>
					<!--库位-->
					<th data-options="field:'store_code_s',width:60,editor:{type:'textbox'}">库位</th>
					<!--物料名称-->
					<th data-options="field:'material_name_s',width:60,editor:{type:'textbox'}">物料名称</th>
					<!--生产日期-->
					<th data-options="field:'product_time_t',editor:{type:'textbox'}">生产日期</th>
					<!--保质期-->
					<th data-options="field:'expiry_date_t',editor:{type:'textbox'}">保质期</th>
					<!--数量-->
					<th data-options="field:'num_in_i',editor:{type:'textbox'}">数量</th>
					<!--重量-->
					<th data-options="field:'qty_left_f',editor:{type:'textbox'}">重量</th>
					  <!-- 下发标识：0-未下发、1-已下发、2-下发失败 -->
					<!--状态-->
					<th data-options="field:'send_state_s',formatter:isQualified,editor:{type:'textbox'}">状态</th>
					<!--供应商-->
					<th data-options="field:'supplier_name_s',width:60,editor:{type:'textbox'}">供应商</th>
					<!--条码-->
					<th data-options="field:'supplier_lot_no_s',editor:{type:'textbox'}">条码</th>
					<!--进厂批次-->
					<th data-options="field:'lot_no_s',editor:{type:'textbox'}">进厂批次</th>
				</tr>
			</thead>
		</table>
	</div>
<
</body>
</html>
