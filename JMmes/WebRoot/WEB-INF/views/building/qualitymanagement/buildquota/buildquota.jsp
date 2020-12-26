<!-- 

    作者      :周清玉
    时间      :2019-06-05 09:40:52 
    页面名称:成型定额表
    文件关联:
        BuildQuota.java
        BuildQuotaController.java
        BuildQuotaServiceImpl.java
        BuildQuotaServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="buildquota.js.jsp"%>
<script type="text/javascript" src="dict/358,214.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="BuildQuota_dg_toolbar">
            <form id="BuildQuota_search_form" class="form" >
                <!-- 机台类型 -->
                <spring:message code="buildquota.column.equip_type_s" />:
                <input name="filter[equip_type_s]" id="equip_type_s" like="true" style="width:120px;" type="text" class="easyui-combotree" data-options="label:'',
						                  labelWidth:'auto',
										  panelHeight:100,
										  required:false,
										  url:'dict/code/358',
										  method:'get'">
                <!-- 胎胚编码 -->
                <spring:message code="buildquota.column.materialcode_s" />:
                <input name="filter[materialcode_s]" id="materialcode_s" style="width:110px;" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 胎胚描述 -->
                <spring:message code="buildquota.column.materialdesc_s" />:
                <input name="filter[materialdesc_s]" id="materialdesc_s" style="width:130px;"  like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 规格-->
                <spring:message code="b_mm_quota.column.materialspec_s" />:
                <input name="filter[materialspec_s]" id="materialspec_s" style="width:130px;" like="true" type="text" class="easyui-textbox" data-options="label:''" >
                <!-- 胎体成型方式 -->
                <spring:message code="buildquota.column.tyretype_s" />:
                <input name="filter[tyretype_s]" id="tyretype_s" style="width:80px;"  type="text" like="true" class="easyui-textbox" data-options="label:''" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="XXX"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="XXX"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="XXX"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
           <%--  <auth:button code="XXX"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-add'" onclick="export()"><spring:message code="button.export" /></a></auth:button>
        --%> </div>
        <table id="buildquota_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#BuildQuota_dg_toolbar',
                url: '',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true"></th>
                    <!-- 机台类型 -->
                   <%--  <th data-options="field:'equip_type_s',width:100,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildquota.column.equip_type_s" /></th>
                    --%>
                  <th data-options="field:'equip_type_s',width:100,sortable:true,formatter:codeFormatter,editor:{type:'combotree',options:{
                    			method:'get',
                                url:'dict/code/358',
                                labelwidth:'auto',
                    			required:true
                    			}}"><spring:message code="buildquota.column.equip_type_s" /></th>
                    
                    			
					<!-- 胎胚编码 -->
                    <th data-options="width:100,field:'materialcode_s',editor:{
					       type:'combobox',
					       options:{
					       delay:300,
					       required:true,
					       url:'Part/halbMaterialList',
					       panelHeight:150,
					       editable:true,
					       valueField:'PART_NUMBER',
					       textField:'PART_NUMBER',
					       selectOnNavigation:false,
					       limitToList:true,
					       onSelect:onMaterialSelect}}"><spring:message code="cxproductiondayplan.column.specification_s" /></th>
					<!-- 胎胚物料编码 -->
					<th data-options="required:true,width:100,field:'materialdesc_s',editor:{type:'textbox',options:{required:true,disabled:true}}"><spring:message code="cxproductiondayplan.column.material_code_s" /></th>
                    <!-- 规格 -->
                    <th data-options="required:true,width:100,field:'materialspec_s',editor:{type:'textbox',options:{required:true,disabled:true}}"><spring:message code="b_mm_quota.column.materialspec_s" /></th>
                    <!-- 定额数量 -->
                    <th data-options="field:'quotacount_s',width:100,editor:{type:'textbox',options:{required:true}}"><spring:message code="buildquota.column.quotacount_s" /></th>
                    <!-- 胎体成型方式 -->
                    <th data-options="field:'tyretype_s',width:100,editor:{type:'textbox',options:{required:true,readonly:true,editable:true}}"><spring:message code="buildquota.column.tyretype_s" /></th>
                </tr>
            </thead>
        </table>
    </div>
</body>
</html>
