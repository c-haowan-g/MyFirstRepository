<!-- 

    作者      :时永良
    时间      :2020-02-21 16:09:51 
    页面名称:X光检测数据维护表
    文件关联:
        XrayMaintain.java
        XrayMaintainController.java
        XrayMaintainServiceImpl.java
        XrayMaintainServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="xraymaintain.js.jsp"%>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="XrayMaintain_dg_toolbar">
            <form id="XrayMaintain_search_form" class="form" >
                <!-- 规格品号 -->
                <spring:message code="xraymaintain.column.material_code_s" />: <input name="filter[material_code_s]" id="material_code_s" type="text" class="easyui-textbox" data-options="" >
                <!-- 规格描述 -->
                &nbsp;&nbsp;<spring:message code="xraymaintain.column.material_desc_s" />: <input name="filter[material_desc_s]" id="material_desc_s" type="text" class="easyui-textbox" data-options="" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="CX_XRAYMAINTAIN_ADD"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="CX_XRAYMAINTAIN_EDIT"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="CX_XRAYMAINTAIN_REMOVE"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            <auth:button code="CX_XRAYMAINTAIN_SAVE"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="CX_XRAYMAINTAIN_CANCEL"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a></auth:button>
            <auth:button code="CX_XRAYMAINTAIN_EXPORT"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
        </div>
        <table id="xraymaintain_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#XrayMaintain_dg_toolbar',
                url: 'finalcheck/baseData/xrayMaintain/datagridUDA',
                striped:true,
                method: 'get',
                emptyMsg: '<span><spring:message code='tip.noData'/></span>' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 规格品号 -->
                    <th data-options="field:'material_code_s',width:'15%',editor:{
                     type:'combobox',
					       options:{
					       delay:300,panelWidth:120,
					       required:true,
					       panelHeight:150,
					       editable:true,
					       data:materialCodeList,
					       valueField:'PART_NUMBER',
					       textField:'PART_NUMBER',
					       selectOnNavigation:false,
					       limitToList:true,
					       onSelect:onMaterialSelect}
                    }"><spring:message code="xraymaintain.column.material_code_s" /></th>
                    <!-- 规格描述 -->
                    <th data-options="field:'material_desc_s',width:'25%',editor:{type:'textbox',
					    options:{
					    required:true,
					     editable:false
					    }}"><spring:message code="xraymaintain.column.material_desc_s" /></th>
                    <!-- 防擦半径 -->
                    <th data-options="field:'radius_f',width:'10%',editor:{type:'textbox', options:{
					    required:true
					    }}"><spring:message code="xraymaintain.column.radius_f" /></th>
                    <!-- 轮胎高度 -->
                    <th data-options="field:'tyreheight_f',width:'10%',editor:{type:'textbox', options:{
					    required:true
					    }}"><spring:message code="xraymaintain.column.tyreheight_f" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created',width:'5%'"><spring:message code="xraymaintain.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',width:'15%'"><spring:message code="xraymaintain.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed',width:'5%'"><spring:message code="xraymaintain.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',width:'15%'"><spring:message code="xraymaintain.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
  <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="XrayMaintain_search_form" />
		<jsp:param name="datagridId" value="xraymaintain_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.finalcheck.excel.XrayMaintainExportHandler" />
		<jsp:param name="serviceName" value="XrayMaintainServiceImpl" />
  </jsp:include> 
</body>
</html>
