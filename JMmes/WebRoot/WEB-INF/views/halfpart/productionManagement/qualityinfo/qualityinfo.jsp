<!-- 

    作者      :葛迎祥
    时间      :2020-06-28 16:55:16 
    页面名称:AT_A_QM_QUALITYINFO
    文件关联:
        Qualityinfo.java
        QualityinfoController.java
        QualityinfoServiceImpl.java
        QualityinfoServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="qualityinfo.js.jsp"%>
<script type="text/javascript" src="dict/113.js"></script>

<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="Qualityinfo_dg_toolbar">
            <form id="Qualityinfo_search_form" class="form" >
                <!-- 半部件类型 -->
                <spring:message code="qualityinfo.column.halfpart_type_s" /> : 
                <input name="filter[halfpart_type_s]" id="halfpart_type_s" type="text" class="easyui-combobox" 
                       data-options="valueField:'DICTNAME_S',
			            			 textField:'DICTNAME_S',
                                     required:false, 
                                     editable:true,
                                     url:'sap/materials/getMaterialGroupList',
									 method: 'get',
									 prompt:'全部',
								     limitToList:'false',
								     panelHeight:150,
								     labelWidth:'auto'" >
                <!-- 病象描述 -->
                <spring:message code="qualityinfo.column.sickelephants_desc_s" /> : 
                <input name="filter[sickelephants_desc_s]" id="sickelephants_desc_s" type="text" class="easyui-textbox" >
                <!-- 处理措施 -->
                <spring:message code="qualityinfo.column.treatmentmeaure_s" /> : 
                <input name="filter[treatmentmeaure_s]" id="treatmentmeaure_s" type="text" class="easyui-textbox" >
                <!-- 等级 -->
                <spring:message code="qualityinfo.column.grade_s" /> : 
                <input name="filter[grade_s]" 
	                id="grade_s" type="text" 
	                class="easyui-combobox" 
	                data-options="textField: 'text',
								 valueField: 'value',
								 data: [{
									 text: '全部',
									 value: ''
								 },{
									 text: '合格',
									 value: '1'
								 },{
									 text: '不合格',
									 value: '0'
								 }]" >
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="qualityinfo_add"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="add()"><spring:message code="button.add" /></a></auth:button>
            <auth:button code="qualityinfo_edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()"><spring:message code="button.edit" /></a></auth:button>
            <auth:button code="qualityinfo_remove"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-remove'" onclick="remove()"><spring:message code="button.delete" /></a></auth:button>
            　
            <auth:button code="qualityinfo_save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()"><spring:message code="button.save" /></a></auth:button>
            <auth:button code="qualityinfo_cancel"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()"><spring:message code="button.cancel" /></a>  </auth:button>
            　
            <auth:button code="qualityinfo_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel'" onclick="$_export()"><spring:message code="button.export" /></a></auth:button>
            <auth:button code="qualityinfo_showOrHide"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-hide'" onclick="showOrHide()"><spring:message code="button.searchColumn" /></a></auth:button>
        </div>
        <table id="qualityinfo_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#Qualityinfo_dg_toolbar',
                url: 'halfpart/productionManagement/qualityinfo/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'atr_key',checkbox:true">ID</th>
                    <!-- 半部件类型 -->
                    <th data-options="field:'halfpart_type_s',width:150,editor:{type:'combobox',options:{
														                    				  required:true,
																						      editable:true,
																						      valueField:'DICTNAME_S',
																	            			  textField:'DICTNAME_S',
														                                      url:'sap/materials/getMaterialGroupList',
																							  method:'get',
																							  panelHeight:150,
																				     	  	  labelWidth:'auto'}}"><spring:message code="qualityinfo.column.halfpart_type_s" /></th>
                    <!-- 病象编号 -->
                    <th data-options="field:'sickelephants_no_s',editor:{type:'textbox',options:{required:true,disabled:true}},width:100"><spring:message code="qualityinfo.column.sickelephants_no_s" /></th>
                    <!-- 病象描述 -->
                    <th data-options="field:'sickelephants_desc_s',editor:{type:'textbox',options:{required:true}},width:100"><spring:message code="qualityinfo.column.sickelephants_desc_s" /></th>
                    <!-- 处理措施 -->
                    <th data-options="field:'treatmentmeaure_s',editor:{type:'textbox',options:{required:true}},width:100"><spring:message code="qualityinfo.column.treatmentmeaure_s" /></th>
                    <!-- 等级 -->
                    <th data-options="field:'grade_s',editor:{type:'combobox',options:{
		                    				  required:true,
										      editable:false,
										      textField: 'text',
											  valueField: 'value',
											  data: [{
												  text: '合格',
												  value: '1'
											  },{
												  text: '不合格',
												  value: '0'
											  }],
								     	  	  labelWidth:'auto'}},width:100,formatter:gradeFormatter"><spring:message code="qualityinfo.column.grade_s" /></th>
                    <!-- 备注 -->
                    <th data-options="field:'bz_s',editor:{type:'textbox'},width:100"><spring:message code="qualityinfo.column.bz_s" /></th>
                    <!-- 创建人 -->
                    <th data-options="field:'created_by_s',editor:{type:'textbox',options:{disabled:true}},width:100"><spring:message code="qualityinfo.column.created_by_s" /></th>
                    <!-- 创建时间 -->
                    <th data-options="field:'created_time_t',editor:{type:'textbox',options:{disabled:true}},width:150"><spring:message code="qualityinfo.column.created_time_t" /></th>
                    <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox',options:{disabled:true}},width:100"><spring:message code="qualityinfo.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox',options:{disabled:true}},width:150"><spring:message code="qualityinfo.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="Qualityinfo_search_form" />
		<jsp:param name="datagridId" value="qualityinfo_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.QualityinfoExportHandler" />
		<jsp:param name="serviceName" value="QualityinfoServiceImpl" />
    </jsp:include>
</body>
</html>
