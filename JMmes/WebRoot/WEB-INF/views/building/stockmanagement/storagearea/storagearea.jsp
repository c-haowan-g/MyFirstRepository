<!-- 

    作者      :李德晓
    时间      :2020-11-25 09:19:46 
    页面名称:成型线边库台账
    文件关联:
        Storagearea.java
        StorageareaController.java
        StorageareaServiceImpl.java
        StorageareaServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="dict/105,106,112,227,308,362,253.js"></script>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="storagearea.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Storagearea_dg_toolbar">
            <form id="Storagearea_search_form" class="form" >
                <!-- 条码号  -->
                <spring:message code="storagearearecord.column.barcode_s" />:
                <input name="filter[barcode_s]" id="barcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 当前库存位置 推荐库位  -->
                <spring:message code="storagearea.column.location_s" /> :
                <input name="filter[location_s]" id="location_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料编码 -->
                <spring:message code="storagearea.column.materielcode_s" /> :
                <input name="filter[materielcode_s]" id="materielcode_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 物料名称  -->
                <spring:message code="storagearea.column.materielname_s" /> :
                <input name="filter[materielname_s]" id="materielname_s" type="text" class="easyui-textbox" data-options="label:''" ><br>
                <!-- 物料组 基础数据308  -->
                <spring:message code="storagearearecord.column.m_group_s" /> :
                <input name="filter[m_group_s]" id="m_group_s" type="text" class="easyui-combotree" data-options="label:'', required:false,
	                editable:true,
          			panelHeight:200,
          			url:'dict/code/308',
          			method:'get'" >
                <!-- 质量状态 基础数据106  -->
                <spring:message code="storagearearecord.column.quality_status_s" /> : 
                <input name="filter[quality_status_s]" id="quality_status_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 载具条码  -->
                <spring:message code="storagearea.column.vehicles_code_s" /> :
                <input name="filter[vehicles_code_s]" id="vehicles_code_s" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 操作方式 数据字典362  -->
                <spring:message code="storagearearecord.column.operattype_s" /> :
                <input name="filter[operattype_s]" id="operattype_s" type="text" class="easyui-combotree" data-options="label:'', required:false,
	                editable:true,
          			panelHeight:200,
          			url:'dict/code/362',
          			method:'get'" ><br>
          		<!-- 机台条码 -->
          		<spring:message code="cxproductiondayplan.column.equip_code_s" />
                :&emsp;<input name="filter[equip_code_s]" id="equip_code_s" type="text" class="easyui-combobox" data-options="label:'',
                                  width:'155px',
                                 required:false, 
                                 url:'building/basedata/productline/getProductlineByProcess?process='+'252005',
	                             method: 'get',
	                             editable:true,
	                             panelHeight:300,
	                             valueField:'p_line_name',
	                             textField:'p_line_name'" >
                <!-- 入库时间 -->
                 <spring:message code="stockingrecordmain.column.storeentrytime_t" />
                :<input name="filter[start_time]" type="text" editable="true" id="start_time" class="easyui-datetimebox" style="width:170px" data-options="label:''">
				 
				 到:
				 
                 <input name="filter[end_time]" editable="true" id="end_time" 
							type="text" class="easyui-datetimebox" style="width:170px"
							data-options="label:''">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
                <auth:button code="CX_BAN_GANG_KCGL_storagearea_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            </form> 
            <%-- <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button> --%>
        </div>
        <table id="storagearea_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Storagearea_dg_toolbar',
                url: 'building/stockmanagement/storagearea/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materielcode_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.materielcode_s" /></th>
                    <!-- 物料名称  -->
                    <th data-options="field:'materielname_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.materielname_s" /></th>
                     <!-- 规格  -->
                    <th data-options="field:'specification_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.specification_s" /></th>
                    <!-- 条码号  -->
                    <th data-options="field:'barcode_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.barcode_s" /></th>
                    <!-- 载具条码  -->
                    <th data-options="field:'vehicles_code_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.vehicles_code_s" /></th>
                    <!-- 机台条码  -->
                    <th data-options="field:'equip_code_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.equip_code_s" /></th>
                   
                    <!-- 当前剩余 数量/长度/ 重量  -->
                    <th data-options="field:'current_num_f',editor:{type:'textbox'}"><spring:message code="capsulestockq.column.num_surplus_i" /></th>
                    <!-- 延期时间，按小时计算  -->
                    <th data-options="field:'delaytime_t',editor:{type:'textbox'}"><spring:message code="delayhandlerecord.column.delay_time_t" /></th>
                    <!-- 配送人      -->
                    <th data-options="field:'deliverier_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="storagearea.column.deliverier_s" /></th>
                    <!-- 配送时间  -->
                    <th data-options="field:'deliverytime_t',editor:{type:'textbox'}"><spring:message code="storagearea.column.deliverytime_t" /></th>
                    
                    <!-- 产出初始数量/长度 /重量(半部件产出)  -->
                    <th data-options="field:'ini_num_f',editor:{type:'textbox'}"><spring:message code="inv11.column.num_in_i" /></th>
                    <!-- 是否用完 0 否1 是  -->
                    <%-- <th data-options="field:'isrunout_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.isrunout_s" /></th> --%>
                    <!-- 当前库存位置 推荐库位  -->
                    <th data-options="field:'location_s',editor:{type:'textbox'}"><spring:message code="storagearearecord.column.location_s" /></th>
                    <!-- 物料大类 113  -->
                    <th data-options="field:'materialgroup_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storageareahis.column.materialgroup_s" /></th>
                    
                    <!-- 物料组 基础数据308  -->
                    <th data-options="field:'m_group_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storagearearecord.column.m_group_s" /></th>
                    <!-- 物料类型 基础数据 304  -->
                    <th data-options="field:'m_type_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storagearearecord.column.m_type_s" /></th>
                    <!-- 计量单位  -->
                    <th data-options="field:'m_units_s',editor:{type:'textbox'}"><spring:message code="storagearearecord.column.m_units_s" /></th>
                    <!-- 操作方式 数据字典362 -->
                    <th data-options="field:'operattype_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storagearearecord.column.operattype_s" /></th>
                    <!-- 产出时间  -->
                    <th data-options="field:'outputtime_t',editor:{type:'textbox'}"><spring:message code="storagearea.column.outputtime_t" /></th>
                    <!-- 过期时间  -->
                    <th data-options="field:'outtime_t',editor:{type:'textbox'}"><spring:message code="storagearea.column.outtime_t" /></th>
                    <!-- 质量状态 基础数据106  -->
                    <th data-options="field:'quality_status_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storagearearecord.column.quality_status_s" /></th>
                    <!-- 记录标志，A可用，D删除 -->
                   <%--  <th data-options="field:'record_flag_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.record_flag_s" /></th> --%>
                   
                    <!-- 库存类型 基础数据 227  -->
                    <th data-options="field:'stocktype_s',formatter:codeFormatter,editor:{type:'textbox'}"><spring:message code="storageareahis.column.stocktype_s" /></th>
                     <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="storagearea.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="storagearea.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',formatter:operatorFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'USERCODE',
				            			textField:'USERNAME',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}"><spring:message code="storagearea.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox'}"><spring:message code="storagearea.column.created_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
     <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Storagearea_search_form" />
		<jsp:param name="datagridId" value="storagearea_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.building.excel.StorageareaExportHandler" />
		<jsp:param name="serviceName" value="StorageareaServiceImpl" />
	</jsp:include>  
</body>
</html>
