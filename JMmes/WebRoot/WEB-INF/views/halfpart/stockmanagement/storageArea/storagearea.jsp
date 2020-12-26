<!-- 

    作者      :栾和源
    时间      :2020-03-10 13:07:41 
    页面名称:线边库表
    文件关联:
        StorageArea.java
        StorageAreaController.java
        StorageAreaServiceImpl.java
        StorageAreaServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="storagearea.js.jsp"%>
<script type="text/javascript" src="dict/106,227,308.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="StorageArea_dg_toolbar">
            <form id="StorageArea_search_form" class="form" >
                <!-- 物料编码 -->
                
                <spring:message code="storagearea.column.materielcode_s" />&nbsp;:&nbsp;
                <input name="filter[materielcode_s]" id="materielcode_s" style="width:130px" type="text" class="easyui-combobox" 
                	data-options="
                			textField:'MATERIALCODE_S',
							valueField:'MATERIALCODE_S',
                            required:false, 
                            url:'sap/materials/getMaterialList',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150,
				          	filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}    
									" >&nbsp;&nbsp;&nbsp;&nbsp;
                <!-- 物料名称  -->
                <spring:message code="storagearea.column.materielname_s" />&nbsp;:&nbsp;
                <input name="filter[materielname_s]" id="materielname_s" style="width:130px" type="text" class="easyui-combobox" 
                	data-options="
                			textField:'MATERIALDESC_S',
							valueField:'MATERIALDESC_S',
                            required:false, 
                            url:'sap/materials/getMaterialList',
							method: 'get',
							editable:'true',
							limitToList:false,
							panelHeight:150,
				          	filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
								    	}    
                		" >&nbsp;&nbsp;&nbsp;&nbsp;
                <!-- 物料组 基础数据308  -->
                <spring:message code="storagearea.column.m_group" />&nbsp;:&nbsp;
                <input name="filter[m_group_s]" id="m_group_s" style="width:130px" type="text"  class="easyui-combobox" 
                		data-options="label:'',
                                            labelWidth:'auto',
                                            panelHeight:200,
                                            editable:true,
                                            required:false,
                                            data:materialGroupList,
                                            valueField:'DICTCODE_S',
                              			    textField:'DICTNAME_S',
                                            method:'get'" >&nbsp;&nbsp;&nbsp;&nbsp;
                <!-- 质量状态 基础数据106  -->
                <spring:message code="storagearea.column.quality_status" />&nbsp;:&nbsp;
                <input name="filter[quality_status_s]" id="quality_status_s" style="width:130px" type="text" class="easyui-combotree" 
                		data-options="label:'',
                					  panelHeight:200,
						              labelWidth:'auto',
									  panelWidth:'15%',
									  required:false,
									  url:'dict/code/106',
									  method:'get'" >
               	</br></br>
                <!-- 条码号  -->
                <spring:message code="storagearea.column.barcode_s" />&nbsp;:&nbsp;
                <input name="filter[barcode_s]" id="barcode_s" type="text" style="width:130px" class="easyui-textbox" data-options="label:''" >&nbsp;&nbsp;&nbsp;&nbsp;
                <!-- 载具条码  -->
                <spring:message code="storagearea.column.vehicles_code_s" />&nbsp;:&nbsp;
                <input name="filter[vehicles_code_s]" id="vehicles_code_s" style="width:130px" type="text" class="easyui-textbox" onchange="setData()" data-options="label:''" >&nbsp;&nbsp;&nbsp;&nbsp;
               	<!-- 产出时间  -->
                &emsp;<spring:message code="storagearea.column.outputtime_t" />
               	&nbsp;<input name="filter[begin_created_time]" editable="true" id="begin_created_time" type="text" class="easyui-datetimebox" style="width:130px" data-options="label:''">
				&nbsp;到&nbsp; <input name="filter[end_created_time]" editable="true" id="end_created_time" type="text" class="easyui-datetimebox" style="width:130px" data-options="label:''">&nbsp;&nbsp;&nbsp; 
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            &nbsp;&nbsp;&nbsp;&emsp;
            <auth:button code="storagearea.export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="equipmentcapacity_hide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="storagearea_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#StorageArea_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 条码号  -->
                    <th data-options="field:'barcode_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.barcode_s" /></th>
                    <!-- 物料编码 -->
                    <th data-options="field:'materielcode_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.materielcode_s" /></th>
                    <!-- 物料名称  -->
                    <th data-options="field:'materielname_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.materielname_s" /></th>
                    <!-- 载具条码  -->
                    <th data-options="field:'vehicles_code_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.vehicles_code_s" /></th>
                    <!-- 产出量  -->
                    <th data-options="field:'ini_num_f',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.ini_num" /></th>
                    <!-- 当前剩余量  -->
                    <th data-options="field:'current_num_f',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.current_num" /></th>
                    <!-- 当前库存位置 推荐库位  -->
                    <th data-options="field:'location_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.location" /></th>
                    <!-- 库存类型 基础数据 227  -->
                    <th data-options="field:'stocktype_s',editor:{type:'textbox'}"><spring:message code="storagearea.column.stocktype" /></th>
                    <!-- 质量状态 基础数据106  -->
                    <th data-options="field:'quality_status_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.quality_status" /></th>
                    <!-- 产出时间  -->
                    <th data-options="field:'outputtime_t',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.outputtime_t" /></th>
                    <!-- 过期时间  -->
                    <th data-options="field:'outtime_t',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.outtime_t" /></th>
                     <!-- 延期时间，按小时计算  -->
                    <th data-options="field:'delaytime_t',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.delaytime" /></th>
                    <!-- 是否用完 0 否1 是  -->
                    <th data-options="field:'isrunout_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.isrunout" /></th>
                    <!-- 计量单位 基础数据305  -->
                    <th data-options="field:'m_units_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.m_units" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',align:'center',width:100,editor:{type:'textbox'}"><spring:message code="storagearea.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="StorageArea_search_form" />
		<jsp:param name="datagridId" value="storagearea_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.StorageAreaExportHandler" />
		<jsp:param name="serviceName" value="StorageAreaServiceImpl" />
	</jsp:include>  
    
</body>
</html>
