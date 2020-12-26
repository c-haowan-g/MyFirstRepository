<!-- 

    作者      :刘朋
    时间      :2019-02-26 11:45:20 
    页面名称:成型产量数据sap上报数据
    文件关联:
        WorkOrderResult.java
        WorkOrderResultController.java
        WorkOrderResultServiceImpl.java
        WorkOrderResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="updatemoldingsap.js.jsp"%>
<script type="text/javascript" src="dict/193.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="UpdateMoldingSap_dg_toolbar">
            <form id="UpdateMoldingSap_search_form" class="form" >
                <spring:message code="dailyreportoffinishedproductqualityinspection.column.buildingtime_t" />
                :&nbsp;<input name="filter[start_time]" type="text"  id="start_time" class="easyui-datetimebox"  style="width:150px;" data-options="label:''">
                &emsp;<spring:message code="tip.to" />&emsp;
                <input name="filter[end_time]"  id="end_time" class="easyui-datetimebox"  style="width:150px;">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="CX_BAN_GANG_BBGL_SAP_UPDATESOLIDCHOOSE"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-maintype'" onclick="updatesolid()"><spring:message code="button.updatesolid" /></a></auth:button>
            </form> 
        </div>
        <table id="UpdateMoldingSap_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#UpdateMoldingSap_dg_toolbar',
                pageSize: 100,
                pageList: [100,200,300,400],
                striped:true,
                method: 'get',
                emptyMsg:'暂无数据' 
                ">
            <thead>
                <tr>
                 	<th data-options="field:'atr_key',checkbox:true">ID</th>
                 	<!-- 班次-->
                    <th data-options="field:'buildingshift_s',width:100,formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="moldingproductsap.column.building_shift_s" /></th>
                    <!-- 生产版本-->
                    <th data-options="field:'productionver_s',width:100,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.productionver_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',width:300,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 规格描述 -->
                    <th data-options="field:'material_name_s',width:400,editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                    <!-- 合计数量-->
                    <th data-options="field:'total',width:100,editor:{type:'textbox'}"><spring:message code="Total.number.of" /></th>
                    
            </thead>
        </table>
    </div>
</body>
</html>
