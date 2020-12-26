<!-- 

    作者      :时永良
    时间      :2018-09-10 11:45:20 
    页面名称:硫化冲产固化，sap上报数据
    文件关联:
        SapReturnResult.java
        SapReturnResultController.java
        SapReturnResultServiceImpl.java
        SapReturnResultServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="sapreturnresulttosap.js.jsp"%>
<script type="text/javascript" src="dict/253,302.js"></script>
<script type="text/javascript" src="resources/libs/ichart.1.1.min.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="SapReturnResult_dg_toolbar">
            <form id="SapReturnResult_search_form" class="form" >
                <spring:message code="workorderresult.column.curing_openmoulddate_t" />
                <input name="filter[start_time]" type="text"    id="start_time" class="easyui-datetimebox"  style="width:160px;" data-options="label:''">
                &emsp;<spring:message code="tip.to" />&emsp;&emsp;
                <input name="filter[end_time]"    id="end_time" class="easyui-datetimebox"  style="width:160px;">
                <spring:message code="messapproduction.column.material_code_s" />
				<input name="filter[material_code_s]" id="material_code_s" like="true" class="easyui-textbox" style="width:150px;">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <br>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-supplier'" onclick="curing()"><spring:message code="button.curing" /></a>
                <a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-supplier'" onclick="productionDetail()"><spring:message code="button.detail" /></a>
            </form>
        </div>
        <table id="sapreturnresult_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#SapReturnResult_dg_toolbar',
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
                    <th data-options="field:'class_id_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.class_id_s" /></th>
                    <!-- 生产版本-->
                    <th data-options="field:'productionver_s',editor:{type:'textbox'}"><spring:message code="workorderresultprint.column.productionver_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_code_s" /></th>
                    <!-- 规格描述 -->
                    <th data-options="field:'material_name_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.material_name_s" /></th>
                    <!-- 是否为试验胎 -->
                    <th data-options="field:'spare6_s',formatter:testTyreFormatter,editor:{type:'textbox'}"><spring:message code="workorderresulttosap.column.spare6_s" /></th>
                    <!-- 数量-->
                    <th data-options="field:'total',editor:{type:'textbox'}"><spring:message code="Total.number.count" /></th>
                    
            </thead>
        </table>
    </div>
    
    <!-- 明细窗口 -->
    <div id="workorderresult_detail_dg" class="easyui-dialog" title="明细查询窗口" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
             <table class="easyui-datagrid" style="width:100%" id="detail_dg"
	            data-options="
	                 fit:true,
	                 fitColumns:false,
					 singleSelect:false,
					 autoRowHeight:true,
					 rownumbers:true,
					 loadMsg:'加载中。。。',
					 height:'auto',
	                  method:'get',
	                  emptyMsg:'暂无数据',
	                  striped:true
	                  ">
	            <thead>
	                <tr>
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
	                   <%--  <!-- 是否补硫化 1：是 0：否 -->
                        <th data-options="field:'patch_curingflag_s',editor:{type:'textbox'}"><spring:message code="workorderresult.column.patch_curingflag_s" /></th> --%>
	                </tr>
	            </thead>
	        </table>
    </div>
</body>
</html>
