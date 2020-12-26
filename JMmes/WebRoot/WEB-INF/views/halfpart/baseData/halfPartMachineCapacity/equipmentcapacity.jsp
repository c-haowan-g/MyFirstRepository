<!-- 

    作者      :李德晓
    时间      :2020-03-05 15:34:59 
    页面名称:半部件机台产能维护
    文件关联:
        Equipmentcapacity.java
        EquipmentcapacityController.java
        EquipmentcapacityServiceImpl.java
        EquipmentcapacityServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="equipmentcapacity.js.jsp"%>
<<script type="text/javascript" src="dict/-308.js"></script>
<script type="text/javascript" src="dict/104,-118,328.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Equipmentcapacity_dg_toolbar">
            <form id="Equipmentcapacity_search_form" class="form" >
                <!-- 机台名称 -->
                <spring:message code="machinecontrol.column.equip_name_s" />:
                <input name="filter[equipmentcode_s]" id="equipmentcode_s" style="width:180px" type="text" class="easyui-combobox"
                	data-options="label:'',
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        required:false,
                        data:productLineList,
                        valueField:'P_LINE_NAME',
          			    textField:'DESCRIPTION',
                        method:'get'"
                	
                 >&nbsp;&nbsp;&nbsp;
               <!-- 物料组 -->
                <spring:message code="equipmentcapacity.column.materialgroup_s" />:
               <input name="filter[materialgroup_s]" id="materialgroup_s"  style="width:180px" type="text" class="easyui-combobox"
                	data-options="label:'',
                        labelWidth:'auto',
                        panelHeight:200,
                        editable:true,
                        required:false,
                        data:materialGroupList,
                        valueField:'DICTCODE_S',
          			    textField:'DICTNAME_S',
                        method:'get'"
                	
                 >&nbsp;&nbsp;&nbsp;
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="equipmentcapacity_add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="equipmentcapacity_edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="equipmentcapacity_remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="equipmentcapacity_save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="equipmentcapacity_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="equipmentcapacity_no"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            <auth:button code="equipmentcapacity_hide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="equipmentcapacity_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Equipmentcapacity_dg_toolbar',
                url: 'halfpart/baseData/halfPartMachineCapacity/datagrid',
                striped:true,
                method: 'get',
                "> 
               
                
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                <!-- 机台名称 -->
                    <th id="equipmentcode_filed" data-options="field:'equipmentcode_s',formatter:equipmentcodeFormatter,sortable:true,width:190,editor:{type:'combobox',options:{
                    required:true,
                    	editable: true,
                    	textField:'DESCRIPTION',
                    	valueField:'P_LINE_NAME',
                    	data:productLineList,
                    	limitToList:true,
                    	labelPosition: 'top',
                    	panelHeight:150,
                    	editable:true
                    	}}
                    "><spring:message code="machinecontrol.column.equip_name_s" /></th>
                    <!-- 物料组 -->
                    <th data-options="field:'materialgroup_s',formatter:materialGroupFormatter,sortable:true,width:190,editor:{type:'combobox',options:{
                    required:true,
                    	editable: true,
                    	data:materialGroupList,
                    	textField: 'DICTNAME_S',
                    	valueField: 'DICTCODE_S',
                    	limitToList:true,
                    	labelPosition:'top',
                    	panelHeight:150,
                    	editable:true
                    	}}
                    "><spring:message code="equipmentcapacity.column.materialgroup_s" /></th>
                    <!-- 产能 -->
                    <th data-options="field:'materialcapacity_f',width:80,editor:{type:'textbox',options:{required:true}}"><spring:message code="equipmentcapacity.column.materialcapacity_f" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',width:80,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="equipmentcapacity.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',sortable:true,width:160,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="equipmentcapacity.column.changed_time_t" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',sortable:true,width:80,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="equipmentcapacity.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',sortable:true,width:160,editor:{type:'textbox',options:{disabled:true}}"><spring:message code="equipmentcapacity.column.created_time_t" /></th>
                    
                </tr>
            </thead>
            
        </table>
    </div>
     <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Equipmentcapacity_search_form" />
		<jsp:param name="datagridId" value="equipmentcapacity_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.EquipmentcapacityExportHandler" />
		<jsp:param name="serviceName" value="EquipmentcapacityServiceImpl" />
	</jsp:include>
</body>
</html>
