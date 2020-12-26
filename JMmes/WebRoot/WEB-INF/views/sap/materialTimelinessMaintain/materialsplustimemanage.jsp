<!-- 

    作者      :时永良
    时间      :2018-11-15 16:51:18 
    页面名称:物料信息扩展表-物料时效性维护
    文件关联:
        MaterialsPlus.java
        MaterialsPlusController.java
        MaterialsPlusServiceImpl.java
        MaterialsPlusServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../inc/meta.jsp"%>
<%@ include file="materialsplustimemanage.js.jsp"%>
<script type="text/javascript" src="dict/-308.js"></script>

<body class="easyui-layout" fit="true"> 
   <!--  <div data-options="region:'center',split:true,border:false" > -->
    <div class="easyui-tabs" fit="true" border="false" style="width:700px;height:250px">
       <div title="<spring:message code='materialgroup.maintain'/>" style="padding:10px">
     		<div style="width:100%;height:100%">
		        <div id="MaterialsPlus_dg_toolbar">
		            <form id="MaterialsPlus_search_form" class="form" >
		               <!-- 物料组 -->
		                <spring:message code="materialslog.column.matgrp_s" />:
		                <input name="filter[matgrp_s]" id="matgrp_s" like="true" type="text" class="easyui-textbox" data-options="label:'',width:130" >
		                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
		            </form> 
		            <auth:button code="MaterialsPlusTime.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
		            <auth:button code="MaterialsPlusTime.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
		            <auth:button code="MaterialsPlusTime.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
		            <auth:button code="MaterialsPlusTime.showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
		        </div>
		        <table id="materialsplus_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MaterialsPlus_dg_toolbar',
                url: 'sap/materialTimelinessMaintain/searchManageMaterialOutdate',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                  <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 物料组-->
                    <th data-options="field:'matgrp_s',formatter:codeFormatter,width:150"><spring:message code="materialslog.column.materialgroup_s" /></th>
                    <!-- 最小存放时间(h) -->
                    <th data-options="field:'smalltime_f',width:80,editor:{type:'numberbox',options:{required:true,min:0,precision:0}}"><spring:message code="materialplus.column.smalltime_f" /></th>
                    <!-- 最长存放时间(h) -->
                    <th data-options="field:'overtime_f',width:80,editor:{type:'numberbox',options:{required:true,min:0,precision:0}}"><spring:message code="materialplus.column.overtime_f" /></th>
                    <!-- 操作人 -->
                    <th data-options="field:'changed_by_name',width:120"><spring:message code="materialsplus.column.changed_by_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="materialsplus.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    		</div>
	    </div>
    	<div title="<spring:message code='materialsing.maintain'/>" style="padding:10px">
    		<div style="width:100%;height:100%">
    			<div id="MaterialsPlus_dg_toolbar1">
		            <form id="MaterialsPlus_search_form1" class="form" >
		            	<!-- 物料编号80位 -->
		                <spring:message code="materialsplus.column.materialcode_s" />:
		                <input name="filter[materialcode_s]" id="materialcode_s" like="true" type="text" class="easyui-textbox" data-options="label:'',width:130" >
		            	<!-- 物料名称 -->
		                <spring:message code="materialsplus.column.materialdesc_s" />:
		                <input name="filter[materialdesc_s]" id="materialdesc_s" like="true" type="text" class="easyui-textbox" data-options="label:'',width:260" >
		                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="singlefilter()"><spring:message code="button.search" /></a>
		            </form> 
		            <auth:button code="MaterialsPlusTime.add"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
		            <auth:button code="MaterialsPlusTime.edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="editsingle()"><spring:message code="button.edit" /></a></auth:button>
		            <auth:button code="MaterialsPlusTime.delete"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-remove'" onclick="removesingle()"><spring:message code="button.delete" /></a></auth:button>
		            <auth:button code="MaterialsPlusTime.save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="savesingle()"><spring:message code="button.save" /></a></auth:button>
		            <auth:button code="MaterialsPlusTime.cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancelsingle()"><spring:message code="button.cancel" /></a>  </auth:button>
		         </div>
		 <table id="materialsplus_dg1" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:true,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#MaterialsPlus_dg_toolbar1',
                url: 'sap/materialTimelinessMaintain/searchManageMaterialOutdate1',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                  <th data-options="field:'atr_key',checkbox:true">ID</th>
                  <!-- 物料编号 -->
                    <th data-options="width:100,field:'amaterialcode_s',editor:{
					       type:'combobox',
					       options:{
					       delay:300,
					       required:true,
					       url:'sap/materialTimelinessMaintain/sapMaterialList',
					       panelHeight:150,
					       editable:true,
					       valueField:'MATERIALCODE_S',
					       textField:'MATERIALCODE_S',
					       selectOnNavigation:false,
					       limitToList:true,
					       onSelect:onMaterialSelect}}"><spring:message code="materialsplus.column.materialcode_s" /></th>
					
                    <!-- 物料名称 -->
                    <th data-options="field:'amaterialdesc_s',width:120,editor:{type:'textbox',options:{required:true,disabled:true}}"><spring:message code="messapproduction.column.material_name_s" /></th>
                    <!-- 最小存放时间(h) -->
                    <th data-options="field:'smalltime_f',width:80,editor:{type:'numberbox',options:{required:true,min:0,precision:0}}"><spring:message code="materialplus.column.smalltime_f" /></th>
                    <!-- 最长存放时间(h) -->
                    <th data-options="field:'overtime_f',width:80,editor:{type:'numberbox',options:{required:true,min:0,precision:0}}"><spring:message code="materialplus.column.overtime_f" /></th>
                    <!-- 最长存放时间(h) -->
                    <th data-options="field:'spare1_s',width:80,editor:{type:'numberbox',options:{min:0,max:100,precision:0}}"><spring:message code="materialplus.column.spare1_s" /></th>
                    <!-- 操作人 -->
                    <th data-options="field:'changed_by_name',width:100"><spring:message code="materialsplus.column.changed_by_s" /></th>
                    <!-- 操作时间 -->
                    <th data-options="field:'changed_time_t'"><spring:message code="materialsplus.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
	    	</div>
	    </div>
    </div>
</body>
</html>
