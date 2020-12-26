<!-- 

    作者      :刘朋
    时间      :2019-06-23
    页面名称:单元实时状态查询
    文件关联:
        unitstatus.java
        unitstatusController.java
        unitstatusServiceImpl.java
        unitstatusServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="unitStatus.js.jsp"%>
<script type="text/javascript" src="dict/252,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="unitstatus_dg_toolbar">
            <form id="unitstatus_search_form" class="form" >
		      <!-- 月计划号 -->
		      <spring:message code="peo.column.planno_month_s" />:<input name="filter[order_number]" id="baseunit" type="text" class="easyui-textbox" data-options="label:''" >
		      <!-- 工单号-->
		      <spring:message code="workordertest.column.order_item" />:<input name="filter[order_item]" id="brand" type="text" class="easyui-textbox" data-options="label:''" >
		      <!-- 轮胎条码 -->
		      <spring:message code="buildwastereport.column.tyre_barcode_s" />:<input name="filter[serial_number]" id="zwbm" type="text" class="easyui-textbox" data-options="label:''" ></br>
		      <!-- 工序 -->
		      <spring:message code="unitstatus.column.op_name" />:<input name="filter[op_name]" id="zwbm" type="text" class="easyui-combotree" data-options="labelWidth:'auto',
				  panelWidth:'170',
				  panelHeight:'300',
				  required:false,
				  url:'dict/code/252',
				  method:'get',
				  label:''" >
		      <!-- 开始时间 -->
		      <spring:message code="workorder.column.start_time_t" />:<input name="filter[start_time]" id="start_time"  editable="true" class="easyui-datetimebox" data-options="label:''" >
		      <!--   结束时间 -->
		      <spring:message code="workorder.column.end_time_t" />:<input name="filter[end_time]" id="end_time" editable="true" class="easyui-datetimebox" data-options="label:''" >
		      <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
		     <auth:button code="unitstatus.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
     		</form> 
    <%--  <table border="1">
	     <tr>
	     	<td>
	                               工艺操作<input id="step" type="text" class="easyui-textbox" data-options="label:''" >
	                               生产说明 <input  id="reason" type="text" class="easyui-textbox" data-options="label:''" >
	                              生产操作1开始，0结束 <input  id="flag" type="text" class="easyui-textbox" data-options="label:''" >
				</br>
	                              工单号<input  id="orderitem" type="text" class="easyui-textbox" data-options="label:''" >
	                              扫描条码<input  id="scan" type="text" class="easyui-textbox" data-options="label:''" >                
				<auth:button code="XXX">
					<a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="scan()">扫描</a>
				</auth:button>
	     	</td>
	     </tr>
     </table> --%>
     

		</div>
        <table id="unitstatus_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#unitstatus_dg_toolbar',
                striped:true,
                method: 'get' ,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                ">
            <thead>
                <tr>
                	<!--key-->
                     <th data-options="field:'atr_key',checkbox:true"></th>
                	<!--日计划号-->
                    <th data-options="field:'order_number',width:100,editor:{type:'textbox'}"><spring:message code="peo.column.planno_month_s" /></th>
					<!-- 工单号 -->
                    <th data-options="field:'order_item',width:160,editor:{type:'textbox'}"><spring:message code="workordertest.column.order_item" /></th>
                     <!-- 轮胎条码 -->
                    <th data-options="field:'uda_0',width:80,editor:{type:'textbox'}"><spring:message code="buildwastereport.column.tyre_barcode_s" /></th>
					<!-- 外胎品号-->
                    <th data-options="field:'part_number',width:80,editor:{type:'textbox'}"><spring:message code="workordertest.column.part_number" /></th>
					<!-- 规格描述-->
                    <th data-options="field:'description',width:160,editor:{type:'textbox'}"><spring:message code="sapreturnresult.column.material_name_s" /></th>
<!--                     <th data-options="field:'serial_number',width:80,editor:{type:'textbox'}">产品编号</th>
                     <!-- 总质量等级 -->
                    <th data-options="field:'quality_grade_s',width:80,formatter:function(v,r,i){return dictFormat(v);},editor:{type:'textbox'}"><spring:message code="curingmaintype.column.quality_grade_s" /></th>
					<!-- 工艺操作-->
                    <th data-options="field:'op_name',width:80,formatter:function(v,r,i){return dictFormat(v);},editor:{type:'textbox'}"><spring:message code="unitstatus.column.op_name" /></th>
	                 <!-- 当前工艺状态 -->
                    <th data-options="field:'status',width:80,formatter:showStatus,editor:{type:'textbox'}"><spring:message code="unitstatus.column.status" /></th>
                     <!-- 当前质量等级 -->
                    <th data-options="field:'atpresentgradecode_s',formatter:function(v,r,i){return dictFormat(v);},width:80,editor:{type:'textbox'}"><spring:message code="curingmaintype.column.atpresentgradecode_s" /></th>
                     <!-- 病象 -->
                    <th data-options="field:'reas_cn_s',width:80,formatter:reasFormatter,editor:{type:'textbox'}"><spring:message code="tyrereasalermmaintain.column.creation_name" /></th>
                     <!-- 检测次数 -->
                    <th data-options="field:'checknumber_i',formatter:checknumberFormatter,width:80,editor:{type:'textbox'}"><spring:message code="maintyre.column.uniformitycount_i" /></th>
                     <!-- 工艺路线 -->
                    <th data-options="field:'route_name',width:100,editor:{type:'textbox'}"><spring:message code="unitstatus.column.route_name" /></th>
                     <!-- 当前工艺步骤-->
<%--                     <th data-options="field:'route_step_name',width:80,editor:{type:'textbox'}"><spring:message code="unitstatus.column.route_name" /></th>--%>               
               		<!-- 机台-->
                    <th data-options="field:'machinecode_s',width:80,"><spring:message code="curingmaintype.column.machinecode_s" /></th>
               		<!-- 操作工-->
                    <th data-options="field:'username',width:80,"><spring:message code="wmsintore.column.worker_id_s" /></th>
                     <!-- 上一个节点名称-->
                    <th data-options="field:'previous_node_name',width:80,editor:{type:'textbox'}"><spring:message code="unitstatus.column.previous_node_name" /></th>
                     <!-- 上一步状态-->
                    <th data-options="field:'previous_status',formatter:showStatus,width:80,editor:{type:'textbox'}"><spring:message code="unitstatus.column.previous_status" /></th>
                     <!-- 上一个节点类型-->
<!--                     <th data-options="field:'previous_node_type',width:80,editor:{type:'textbox'}">上一个节点类型</th>
 -->                     <!-- 下一个节点名称-->
                    <th data-options="field:'queue_name',width:80,editor:{type:'textbox'}"><spring:message code="unitstatus.column.queue_name" /></th>
                      <!-- 过站历史-->
                    <th data-options="field:'arc_history',editor:{type:'textbox'}"><spring:message code="unitstatus.column.arc_history" /></th>
                     <!-- 产线-->
<!--                     <th data-options="field:'p_line_name',width:120,editor:{type:'textbox'}">产线</th>
 -->                     <!-- 开始时间-->
<!--                     <th data-options="field:'start_time',width:120,editor:{type:'textbox'}">开始时间</th>
 -->                     <!-- 操作时间-->
                    <th data-options="field:'last_modified_time',width:130,editor:{type:'textbox'}"><spring:message code="dfd.column.operatetime" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="unitstatus_search_form" />
		<jsp:param name="datagridId" value="unitstatus_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.curing.excel.UnitStatusExportHandler" />
		<jsp:param name="serviceName" value="UnitStatusServiceImpl" />
	</jsp:include>
</body>
</html>
