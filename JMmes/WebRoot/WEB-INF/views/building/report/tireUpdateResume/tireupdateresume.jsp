<!-- 

    作者      :李昂
    时间      :2020-07-23 08:45:22 
    页面名称:胎胚重量修改履历表
    文件关联:
        TireUpdateResume.java
        TireUpdateResumeController.java
        TireUpdateResumeServiceImpl.java
        TireUpdateResumeServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="tireupdateresume.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="TireUpdateResume_dg_toolbar">
            <form id="TireUpdateResume_search_form" class="form" >
            	
             	<!-- 轮胎条码-->
             	<spring:message code="tireupdateresume.column.tyre_barcode_s" />
                :&emsp;<input name="filter[tyre_barcode_s]" id="tyre_barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                &emsp;<spring:message code="tireupdateresume.column.material_code_s" />
                :&emsp;<input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                 
                 <!--创建时间 -->
                 &emsp;<spring:message code="tireupdateresume.column.created_time_t" />
                 :&emsp;<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
				type="text" class="easyui-datetimebox" style="width:165px"data-options="label:''">
				
				到 <input name="filter[end_created_time]" editable="true" id="end_created_time"
				class="easyui-datetimebox" style="width:165px">
				
               	&emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_BAN_GANG_BBGL_4_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
       		<auth:button code="LH_SCGL_PBCX_SEARCH"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-hide'" onclick="queryBar()"><spring:message code="button.searchColumn" /></a>  </auth:button>
        </div>
        <table id="tireupdateresume_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#TireUpdateResume_dg_toolbar',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                url: 'building/reportquery/tireupdateresume/datagridUDA',
                striped:true,
                method: 'get' 
                ">
            <thead>
            
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyre_barcode_s',align:'center',width:70,editor:{type:'textbox'}"><spring:message code="tireupdateresume.column.tyre_barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'material_code_s',align:'center',width:70,editor:{type:'textbox'}"><spring:message code="tireupdateresume.column.material_code_s" /></th>
                    <!-- 物料规格 -->
                    <th data-options="field:'material_spec_s',align:'center',width:70,editor:{type:'textbox'}"><spring:message code="tireupdateresume.column.material_spec_s" /></th>
                   	<!-- 原胎胚重量 -->
                    <th data-options="field:'building_weight_s',align:'center',width:70,editor:{type:'textbox'}"><spring:message code="tireupdateresume.column.building_weight_s" /></th>
                    <!-- 修改后的轮胎重量 -->
                    <th data-options="field:'change_weight_s',align:'center',width:80,editor:{type:'textbox'}"><spring:message code="tireupdateresume.column.change_weight_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'creation_by_created',align:'center',width:80,editor:{type:'textbox'}"><spring:message code="tireupdateresume.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',align:'center',width:80,editor:{type:'textbox'}"><spring:message code="tireupdateresume.column.created_time_t" /></th>
                    
                   
                    
                </tr>
            </thead>
        </table>
        
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="TireUpdateResume_search_form" />
		<jsp:param name="datagridId" value="tireupdateresume_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.TireUpdateResumeExportHandler" />
		<jsp:param name="serviceName" value="TireUpdateResumeServiceImpl" />
	</jsp:include>
</body>
</html>
