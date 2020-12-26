<!-- 

    作者      :王超
    时间      :2020-03-03 16:23:29 
    页面名称:半部件机台物料维护
    文件关联:
        EquipmentMaterial.java
        EquipmentMaterialController.java
        EquipmentMaterialServiceImpl.java
        EquipmentMaterialServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="equipmentmaterial.js.jsp"%>
<script type="text/javascript" src="dict/105,177,302,253.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="EquipmentMaterial_dg_toolbar">
            <form id="EquipmentMaterial_search_form" class="form" >
                <!-- 机台名称 -->
                <spring:message code="equipmentmaterial.column.equipmentname_s" />:<input name="filter[equipmentcode_s]" id="equipmentcode_s" style="width:170px" type="text" class="easyui-combobox"
					data-options="valueField:'description',
				            			textField:'description',
                                        required:false, 
                                        url:'halfpart/basedata/productlinemanager/getProductline',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}"
				>&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="equipmentmaterial.setprimarymaterial"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="setprimarymaterial()"><spring:message code="equipmentmaterial.setprimarymaterial_s" /></a></auth:button>
            <auth:button code="equipmentmaterial.setsecondmaterial"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="setsecondmaterial()"><spring:message code="equipmentmaterial.setsecondmaterial_s" /></a></auth:button>
            <auth:button code="equipmentmaterial.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="equipmentmaterial.add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="equipmentmaterial.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="equipmentmaterial.remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　		<auth:button code="equipmentmaterial.excel"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="equipmentmaterial.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a></auth:button>
            <auth:button code="equipmentmaterial.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button> 
        </div>
        <table id="equipmentmaterial_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#EquipmentMaterial_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 机台名称 -->
                    <th data-options="field:'description',width:160,formatter:toEquipName,editor:{type:'combobox',options:{
                    					valueField:'description',
				            			textField:'description',
                                        required:true, 
                                        url:'halfpart/basedata/productlinemanager/getProductline',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}}}"><spring:message code="equipmentmaterial.column.equipmentname_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'dictname_s',width:150,formatter:getNameByGroupCode,editor:{type:'combobox',options:{
                    					valueField:'materialgroup_s',
				            			textField:'materialgroup_s',
                                        required:true, 
                                        url:'halfpart/basedata/equipmentMaterial/searchMaterialGroup',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}}}"><spring:message code="equipmentmaterial.column.materialgroup_s" /></th>
                    <!-- 是否是主物料 0：主物料 1：副物料 -->
                    <th data-options="field:'isprimary_s',formatter:isprimary_material,width:120,editor:{type:'combobox',options:{
                    				 required:true,
								     editable:false,
								     data:[
								     {'value':'0','text':'是'},
								     {'value':'1','text':'否'}],
								     valueField:'value',
								     textField:'text'}}"><spring:message code="equipmentmaterial.column.isprimarymaterial_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',formatter:toUserName,width:100,editor:close"><spring:message code="equipmentmaterial.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:160,editor:close"><spring:message code="equipmentmaterial.column.created_time_t" /></th>
                	<!-- 修改人 -->
                    <th data-options="field:'changed_by_s',formatter:toUserName,width:100,editor:close"><spring:message code="equipmentmaterial.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:160,editor:close"><spring:message code="equipmentmaterial.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <!-- 批量设置主物料 -->
    <div id="setprimarymaterial_dg" class="easyui-dialog" title="批量设置主物料" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
        <div id="setprimarymaterial_dg_toolbar">
            <form id="materialcode_search_form" class="form" method="post">
                <!-- 机台名称 -->
                <spring:message code="equipmentmaterial.column.equipmentname_s" />:<input name="filter[equipmentcode_s]" id="equipmentcodes1" style="width:170px" type="text" class="easyui-combobox"
                    data-options="valueField:'description',
				            			textField:'description',
                                        required:false, 
                                        url:'halfpart/basedata/productlinemanager/getProductline',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
									    onChange:onEquipSelect,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}"
				>&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="setprimarymaterial_save()"><spring:message code="button.save" /></a>
            </form> 
        </div>
        <table id="material_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#setprimarymaterial_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"><spring:message code="equipmentmaterial.column.select" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',width:300,editor:{type:'textbox'}"><spring:message code="equipmentmaterial.column.materialgroup_s" /></th>
               		<!-- 是否主物料 -->
                    <th data-options="field:'isprimary_s',formatter:isp,width:300"><spring:message code="equipmentmaterial.column.isprimarymaterial_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <!-- 批量设置副物料 -->
    <div id="setsecondmaterial_dg" class="easyui-dialog" title="批量设置副物料" style="width:900px;height:400px;"
            data-options="
                closed:true
            ">
        <div id="setsecondmaterial_dg_toolbar">
            <form id="materialcode_search_form1" class="form" method="post">
                <!-- 机台名称 -->
                <spring:message code="equipmentmaterial.column.equipmentname_s" />:<input name="filter[equipmentcode_s]" id="equipmentcodes2" style="width:170px" type="text" class="easyui-combobox"
                    data-options="valueField:'description',
				            			textField:'description',
                                        required:false, 
                                        url:'halfpart/basedata/equipmentMaterial/searchEquipmentCode',
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
									    onChange:onEquipSelect1,
										filter: function(q, row){  
								        var opts = $(this).combobox('options');  
								        return row[opts.textField].indexOf(q) >= 0;
								    	}"
				>&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="setsecondmaterial_save()"><spring:message code="button.save" /></a>
            </form> 
        </div>
        <table id="material_dg1" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#setsecondmaterial_dg_toolbar',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"><spring:message code="equipmentmaterial.column.select" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',width:300,editor:{type:'textbox'}"><spring:message code="equipmentmaterial.column.materialgroup_s" /></th>
                	<!-- 是否主物料 -->
                    <th data-options="field:'isprimary_s',formatter:iss,width:300"><spring:message code="equipmentmaterial.column.isprimarymaterial_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
    
    <!--导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="EquipmentMaterial_search_form" />
		<jsp:param name="datagridId" value="equipmentmaterial_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.EquipmentMaterialExportHandler" />
		<jsp:param name="serviceName" value="EquipmentMaterialServiceImpl" />
	</jsp:include>
</body>
</html>
