<!-- 

    作者      :栾和源
    时间      :2020-01-15 11:22:25
    页面名称:成型胎胚重量合格率（机台）
    文件关联:
        WeightInfo.java
        WeightInfoController.java
        WeightInfoServiceImpl.java
        WeightInfoServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="weightinfo.js.jsp"%>
<script type="text/javascript" src="dict/105,177,302,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="WeightInfo_dg_toolbar">
            <form id="WeightInfo_search_form" class="form" >
                
                <!-- 机台条码 -->
                <spring:message code="workorderresult.column.equip_code_s" />:<input name="filter[equip_code_s]" id="equip_code_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                <!-- 物料编码 -->
                <spring:message code="workorderresult.column.material_code_s" />:<input name="filter[material_code_s]" id="material_code_s" style="width:120px" type="text" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;
                
				<spring:message code="workorderresult.column.building_date_t" />:<input name="filter[begintime]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:160px" data-options="label:''">&nbsp;&nbsp;&nbsp;
            </form> 
            <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="workorderresult.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="workorderresult.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button> 
        </div>
        <table id="weightinfo_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#WeightInfo_dg_toolbar',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    
                    <!-- 机台条码 -->
                    <th data-options="field:'equip_code_s',width:120,editor:{type:'textbox'}"><spring:message code="workorderresult.column.equip_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',formatter:material_name_Formatter,width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 物料名称 -->
                    <th data-options="field:'material_name_s',width:140,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                    <!-- 标准重量 -->
                    <th data-options="field:'standard_weight_s',formatter:max_min_Formatter,width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.standard_weight_s" /></th>
                    <!-- 上限重量 -->
                    <th data-options="field:'max_weight_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.max_weight_s" /></th>
                    <!-- 下限重量 -->
                    <th data-options="field:'min_weight_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.min_weight_s" /></th>

                   <!-- 总数 -->
                    <th data-options="field:'total_number_count',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.total_number_count" /></th>
					
					<!-- 重量合格数量 -->
                    <th data-options="field:'weight_ok_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.quality_weight_ok_count" /></th>
                    
                    <!-- 重量超轻数量 -->
                    <th data-options="field:'weight_sml_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.quality_weight_sml_count" /></th>
                    
                    <!-- 重量超重数量 -->
                    <th data-options="field:'weight_big_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.quality_weight_big_count" /></th>
                    
                    <!-- 合格率 -->
                    <th data-options="field:'weight_rate_s',width:80,editor:{type:'textbox'}"><spring:message code="workorderresult.column.percent_of_pass" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
        <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="WeightInfo_search_form" />
		<jsp:param name="datagridId" value="weightinfo_dg" />
		
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.WeightInfoExportHandler" />
		 
		
		<jsp:param name="serviceName" value="WeightInfoServiceImpl" />
	</jsp:include>  
</body>
</html>
