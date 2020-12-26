<!-- 

    作者      :司乔靖
    时间      :2018-11-28 09:19:33 
    页面名称:PLM动平衡参数表
    文件关联:
        DynamicBalance.java
        DynamicBalanceController.java
        DynamicBalanceServiceImpl.java
        DynamicBalanceServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="dynamicbalance.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="DynamicBalance_dg_toolbar">
            <form id="DynamicBalance_search_form" class="form" >
                <!-- 类别：TBROE、TBRRE -->
                <label>类别:</label>
                <select  name="filter[category_s]" id="category_s" class="easyui-combobox" name="state" style="width:200px;">
                	<option value="TBROE" selected>TBROE-配套</option>
					<option value="TBRRE">TBRRE-零售</option>
				</select>
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            	 <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            </div>
        <table id="dynamicbalance_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#DynamicBalance_dg_toolbar',
                url: 'finalcheck/standardmagement/dynamicbalance/datagrid',
                striped:true,
                 emptyMsg:'<span><spring:message code='tip.noData'/></span>',
                method: 'get' 
                ">
            <thead>
            	<tr>
            	    <!--<th data-options="field:'atr_key',checkbox:true" rowspan="2"></th>-->
            	    <!-- 类别：TBROE、TBRRE -->
                    <th data-options="field:'category_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.category_s" /></th>
            		<th colspan="3">规格及品种</th>
            		<!-- 花纹 -->
                    <th data-options="field:'pattern_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.pattern_s" /></th>
                    <!-- SAP号 -->
                    <th data-options="field:'sapcode_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.sapcode_s" /></th>
                    <th colspan="2">实验</th>
                    <!-- 等级 -->
                    <th data-options="field:'grade_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.grade_s" /></th>
                    <th colspan="2">动平衡</th>
                    <!-- 静平衡 -->
                    <th data-options="field:'staticbalance_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.staticbalance_s" /></th>
                    <!-- 凹凸度 -->
                    <th data-options="field:'camber_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.camber_s" /></th>
                    <!-- 径向跳动 -->
                    <th data-options="field:'runout_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.runout_s" /></th>
                    <!-- 侧向跳动 -->
                    <th data-options="field:'lateralbeating_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.lateralbeating_s" /></th>
                    <th colspan="4">均匀性</th>
                    <!-- 外直径-->
                    <th data-options="field:'externaldiameter_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.externaldiameter_s" /></th>
                    <!-- 胎圈直径（内径） -->
                    <th data-options="field:'beaddiameter_s',width:100,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.beaddiameter_s" /></th>
                    <!-- 轮胎断面宽度（充气后最宽的部分） -->
                    <th data-options="field:'sectionwidth_s',width:120,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.sectionwidth_s" /></th>
                    <!-- 最大外径 -->
                    <th data-options="field:'maxoutsidediameter_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.maxoutsidediameter_s" /></th>
                    <!-- 最小外径 -->
                    <th data-options="field:'minimumoutsidediameter_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.minimumoutsidediameter_s" /></th>
                    <!-- 胎压公差 -->
                    <th data-options="field:'tirepressuretolerance_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.tirepressuretolerance_s" /></th>
                    <!-- 打标特殊要求 -->
                    <th data-options="field:'specialrequire_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.specialrequire_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'comment_s',width:80,editor:{type:'textbox'}" rowspan="2"><spring:message code="dynamicbalance.column.comment_s" /></th>  
            	</tr>
                <tr>
                	<!-- 规格 -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.specification_s" /></th>
                    <!-- 层级 -->
                    <th data-options="field:'hierarchy_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.hierarchy_s" /></th>
                    <!-- 描述 -->
                    <th data-options="field:'description_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.description_s" /></th>
                    <!-- 气压 -->
                    <th data-options="field:'pressure_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.pressure_s" /></th>
                    <!-- 负荷 -->
                    <th data-options="field:'load_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.load_s" /></th>
                    <!-- Up/Low -->
                    <th data-options="field:'uplow_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.uplow_s" /></th>
                    <!-- Total -->
                    <th data-options="field:'total_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.total_s" /></th>
                    <!-- RFV -->
                    <th data-options="field:'rfv_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.rfv_s" /></th>
                    <!-- RIH -->
                    <th data-options="field:'rih_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.rih_s" /></th>
                    <!-- LFV -->
                    <th data-options="field:'lfv_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.lfv_s" /></th>
                    <!-- CON -->
                    <th data-options="field:'con_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.con_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',width:80,editor:{type:'textbox'}"><spring:message code="dynamicbalance.column.record_flag_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
      <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="DynamicBalance_search_form" />
		<jsp:param name="datagridId" value="dynamicbalance_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.DynamicBalanceExportHandler" />
		<jsp:param name="serviceName" value="DynamicBalanceServiceImpl" />
	</jsp:include>
</body>
</html>
