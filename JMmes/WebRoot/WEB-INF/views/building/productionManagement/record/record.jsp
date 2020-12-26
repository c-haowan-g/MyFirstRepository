<!-- 

    作者      :司乔靖
    时间      :2019-02-18 09:15:19 
    页面名称:成型返修品记录
    文件关联:
        Record.java
        RecordController.java
        RecordServiceImpl.java
        RecordServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="record.js.jsp"%>
<script type="text/javascript" src="dict/253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Record_dg_toolbar">
            <form id="Record_search_form" class="form" >
                <!-- 轮胎条码 -->
                <spring:message code="record.column.tyre_barcode_s" />:
                <input name="filter[tyre_barcode_s]" id="tyre_barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <spring:message code="record.column.machine_code_s" />:
                <input name="filter[machine_code_s]" id="machine_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                
				<spring:message code="record.column.material_code_s" />:
                <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                

                <spring:message code="record.column.changed_time_t" />:&emsp;
                <input name="filter[begintime]" editable="true" id="begin_created_time"
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
				到 <input name="filter[endtime]" editable="true" id="end_created_time" 
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
                
                
             
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
        </div>
        <table id="record_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Record_dg_toolbar',
                url: 'building/productionManagement/record/datagrid',
                striped:true,
                method: 'get',
                emptyMsg:'<span><spring:message code='tip.noData'/></span>'
                
                ">
            <thead>
                <tr>
                    <!-- 轮胎条码 -->
                    <th data-options="field:'tyre_barcode_s',editor:{type:'textbox'}"><spring:message code="record.column.tyre_barcode_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="record.column.changed_time_t" /></th>
                    <!-- 物料条码 -->
                    <th data-options="field:'material_code_s',editor:{type:'textbox'}"><spring:message code="record.column.mterial_code_s" /></th>
                    <!-- 物料描述 -->
                    <th data-options="field:'material_desc_s',editor:{type:'textbox'}"><spring:message code="record.column.mterial_desc_s" /></th>
                    <!--成型机台 -->
                    <th data-options="field:'machine_code_s',editor:{type:'textbox'}"><spring:message code="record.column.machine_code_s" /></th>
                    <!-- 创建人 -->			 
                    <th data-options="field:'username',editor:{type:'textbox'}"><spring:message code="record.column.created_by_s" /></th>
                   	<!-- 病项 -->
                    <th data-options="field:'disease_items_s',editor:{type:'textbox'}"><spring:message code="record.column.disease_items_s" /></th>
                   	<!-- 返修工号 -->
                    <th data-options="field:'workername',editor:{type:'textbox'}"><spring:message code="record.column.worker_id_s" /></th>
               		<!-- 修补结果 -->
                    <th data-options="field:'tyre_status_code_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="record.column.patch_results_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
