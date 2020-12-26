<!-- 

    作者      :李昂
    时间      :2020-11-25 08:03:01 
    页面名称:成型线边库历史表
    文件关联:
        StorageAreaHis.java
        StorageAreaHisController.java
        StorageAreaHisServiceImpl.java
        StorageAreaHisServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="storageareahis.js.jsp"%>
<script type="text/javascript" src="dict/362,308,227,106,113.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="StorageAreaHis_dg_toolbar">
            <form id="StorageAreaHis_search_form" class="form" >
                 <!--创建时间 -->
                 &emsp;<spring:message code="tireupdateresume.column.created_time_t" />
                 :&emsp;<input name="filter[begin_created_time]" editable="true" id="begin_created_time"
				type="text" class="easyui-datetimebox" style="width:165px"data-options="label:''">
				
				&emsp;到&emsp; <input name="filter[end_created_time]" editable="true" id="end_created_time"
				class="easyui-datetimebox" style="width:165px">
                
                
                <!-- 条码号   -->
                &emsp;<spring:message code="storageareahis.column.barcode_s" />
                :&emsp;<input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                
                <!-- 物料编码 -->
                &emsp;<spring:message code="storageareahis.column.materielcode_s" />
                :&emsp;<input name="filter[materielcode_s]" id="materielcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                </br>
               	<!-- 物料组 基础数据308  -->
               	&emsp;<spring:message code="storageareahis.column.m_group_s" />
                :&emsp;<input name="filter[m_group_s]" id="m_group_s" type="text" class="easyui-combobox" data-options="valueField:'code',
	            			  textField:'text',
                              required:false, 
                              url:'dict/code/308',
                              panelHeight:150" >
                
                
                <!-- 载具条码  -->
                
                &emsp;<spring:message code="storageareahis.column.vehicles_code_s" />
                :&emsp;<input name="filter[vehicles_code_s]" id="vehicles_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                
                <!-- 操作方式 数据字典362 -->
                &emsp;<spring:message code="storageareahis.column.operattype_s" />
                :&emsp;<input name="filter[operattype_s]" id="operattype_s" type="text" class="easyui-combobox" data-options="valueField:'code',
	            			  textField:'text',
                              required:false, 
                              url:'dict/code/362',
                              panelHeight:150" >
                <!-- 机台条码 -->
          		<spring:message code="cxproductiondayplan.column.equip_code_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                                  width:'130px',
                                 required:false, 
                                 url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name'" >
                &emsp;&emsp;<a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            <auth:button code="CX_BAN_GANG_BBGL_SSHIS_EXP"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            
        </div>
        <table id="storageareahis_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#StorageAreaHis_dg_toolbar',
                url: 'building/report/storageareahis/datagrid',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    
                    <!-- 条码号   -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.barcode_s" /></th>
                    <!-- 机台条码  -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.equip_code_s" /></th>
                    <!-- 载具条码  -->
                    <th data-options="field:'vehicles_code_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.vehicles_code_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materielcode_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.materielcode_s" /></th>
                    <!-- 物料名称  -->
                    <th data-options="field:'materielname_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.materielname_s" /></th>
                    
                    <!-- 配送人  -->
                    <th data-options="field:'deliveryname',editor:{type:'textbox'}"><spring:message code="storageareahis.column.deliverier_s" /></th>
                    <!-- 配送时间  -->
                    <th data-options="field:'deliverytime_t',editor:{type:'textbox'}"><spring:message code="storageareahis.column.deliverytime_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'username',editor:{type:'textbox'}"><spring:message code="storageareahis.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="storageareahis.column.created_time_t" /></th>
                    <!-- 是否用完 0 否1 是  -->
                    <th data-options="field:'isrunout_s',formatter:isUsed,editor:{type:'textbox'}"><spring:message code="storageareahis.column.isrunout_s" /></th>
                    <!-- 当前库存位置 推荐库位  -->
                    <th data-options="field:'location_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.location_s" /></th>
                    <!-- 物料大类 113  -->
                    <th data-options="field:'materialgroup_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storageareahis.column.materialgroup_s" /></th>
                    
                    <!-- 物料组 基础数据308  -->
                    <th data-options="field:'m_group_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storageareahis.column.m_group_s" /></th>
                    <!-- 物料类型 基础数据 304  -->
                    <th data-options="field:'m_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storageareahis.column.m_type_s" /></th>
                    <!-- 计量单位 基础数据305  -->
                    <th data-options="field:'m_units_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.m_units_s" /></th>
                    <!-- 操作方式 数据字典362 -->
                    <th data-options="field:'operattype_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storageareahis.column.operattype_s" /></th>
                    <!-- 产出时间  -->
                    <th data-options="field:'outputtime_t',editor:{type:'textbox'}"><spring:message code="storageareahis.column.outputtime_t" /></th>
                    
                    <!-- 质量状态 基础数据106  -->
                    <th data-options="field:'quality_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storageareahis.column.quality_status_s" /></th>
                    
                    
                    <!-- 规格   -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.specification_s" /></th>
                    <!-- 库存类型 基础数据 227  -->
                    <th data-options="field:'stocktype_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storageareahis.column.stocktype_s" /></th>
                    
                    
                    <!-- 产出初始数量/长度 /重量(半部件产出)  -->
                    <th data-options="field:'ini_num_f',editor:{type:'textbox'}"><spring:message code="storageareahis.column.ini_num_f" /></th>
                    <!-- 备用字段1 -->
                    <th data-options="field:'spare1_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare1_s" /></th>
                    <!-- 备用字段2 -->
                    <th data-options="field:'spare2_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare2_s" /></th>
                    <!-- 备用字段3 -->
                    <th data-options="field:'spare3_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare3_s" /></th>
                    <!-- 备用字段4 -->
                    <th data-options="field:'spare4_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare4_s" /></th>
                    <!-- 备用字段5 -->
                    <th data-options="field:'spare5_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare5_s" /></th>
                    <!-- 备用字段6 -->
                    <th data-options="field:'spare6_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare6_s" /></th>
                    <!-- 备用字段7 -->
                    <th data-options="field:'spare7_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare7_s" /></th>
                    <!-- 备用字段8 -->
                    <th data-options="field:'spare8_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare8_s" /></th>
                    <!-- 备用字段9 -->
                    <th data-options="field:'spare9_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare9_s" /></th>
                    <!-- 备用字段10 -->
                    <th data-options="field:'spare10_s',editor:{type:'textbox'}"><spring:message code="storageareahis.column.spare10_s" /></th>
                    
                </tr>
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key"/>
		<jsp:param name="formId" value="StorageAreaHis_search_form" />
		<jsp:param name="datagridId" value="storageareahis_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.StorageAreaHisExportHandler" />
		<jsp:param name="serviceName" value="StorageAreaHisServiceImpl" />
	</jsp:include>
</body>
</html>
