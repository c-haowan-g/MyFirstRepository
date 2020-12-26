<!-- 

    作者      :李德晓
    时间      :2020-03-16 15:31:45 
    页面名称:PLM半部件配方下发基础参数表
    文件关联:
        PlmHalfpartRecipePara.java
        PlmHalfpartRecipeParaController.java
        PlmHalfpartRecipeParaServiceImpl.java
        PlmHalfpartRecipeParaServiceImpl.xml
 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../../inc/meta.jsp"%>
<%@ include file="plmhalfpartrecipepara.js.jsp"%>
<<script type="text/javascript" src="dict/-308,301.js"></script>
<body class="easyui-layout" fit="true"> 
    <div data-options="region:'center',split:true,border:false" >
        <div id="PLMHalfpartRecipePara_dg_toolbar">
            <form id="PLMHalfpartRecipePara_search_form" class="form">
            设备类型名称
                :&emsp;<input name="filter[equipmenttypecode_s]" id=equipmenttypecode_s type="text" class="easyui-combobox" style="width:150px;"
                              data-options="label:'',
                                            url:'halfpart/baseData/plmHalfpartRecipePara/searchEquipmenttypecode_s',
                                            labelWidth:'auto',
                                            editable:true,
                                            panelHeight:200,
                                            data:equipTypeList,
                                            valueField:'ERPCODE_S',
                              			    textField:'DICTNAME_S',
                                            method:'get'">
      逻辑地址
        :&emsp;<input name="filter[logicaladdress_s]" id=logicaladdress_s type="text" class="easyui-textbox" style="width:150px;"
                              data-options="label:''">
                <a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-search'" onclick="filter()"><spring:message code="button.search" /></a>
            </form> 
            <auth:button code="PlmHalfpartRecipeParameter_save"><a class="easyui-linkbutton btn-blue" data-options="iconCls:'icon-save'" onclick="save()">保存</a></auth:button>
            <auth:button code="PlmHalfpartRecipeParameter_edit"><a class="easyui-linkbutton btn-red" data-options="iconCls:'icon-edit'" onclick="edit()">编辑</a></auth:button>
            <auth:button code="PlmHalfpartRecipeParameter_start"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-add'" onclick="start()">启用</a></auth:button>
            <auth:button code="PlmHalfpartRecipeParameter_stop"><a class="easyui-linkbutton btn-green" data-options="iconCls:'icon-remove'" onclick="stop()">停用</a></auth:button>
            　                 <auth:button code="PlmHalfpartRecipeParameter_startaddress"><a class="easyui-linkbutton btn-black" data-options="iconCls:'icon-add'" onclick="startaddress()">上下限开启</a></auth:button>
            <auth:button code="PlmHalfpartRecipeParameter_stopaddress"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-remove'" onclick="stopaddress()">上下限关闭</a></auth:button>
            <auth:button code="PlmHalfpartRecipeParameter_export"><a class="easyui-linkbutton btn-deep-blue" data-options="iconCls:'icon-excel-export'" onclick="$_export()">导出</a></auth:button>
            <auth:button code="PlmHalfpartRecipeParameter_no"><a class="easyui-linkbutton btn-yellow" data-options="iconCls:'icon-no'" onclick="cancel()">取消</a></auth:button>
        </div>
        <table id="plmhalfpartrecipepara_dg" class="easyui-datagrid" style="width:100%"
            data-options="  
                fit:true,
                fitColumns:false,
                data:equipTypeList,
                pagination:true,
                rownumbers: true,
                singleSelect: false,
                toolbar: '#PLMHalfpartRecipePara_dg_toolbar',
                url: 'halfpart/baseData/plmHalfpartRecipePara/datagrid',
                striped:true,
                method: 'get' 
                ">
            <thead>
                <tr>
                    <th data-options="field:'',checkbox:true">ID</th>
                    <!-- 参数类型：1-半部件 -->
                    <th data-options="field:'basetype_s',formatter:basetypesFormatter,sortable:true,editor:{type:'textbox',options:{
                    					valueField:'ERPCODE_S',
				            			textField:'DICTNAME_S',
                                        required:true, 
										data:basetypesList,
										method: 'get',
									    editable:'true',
									    limitToList:false,
									    panelHeight:200,
										}}">参数类型</th>
                    <!-- 参数CODE -->
                    <th data-options="field:'parmcode_s',editor:{}"><spring:message code="plmhalfpartrecipeparameter.column.parmcode_s" /></th>
                    <!-- 参数中文名称 -->
                    <th data-options="field:'parmname_s',editor:{}"><spring:message code="plmhalfpartrecipeparameter.column.parmname_s" /></th>
                     <!-- 单位 -->
                    <th data-options="field:'unit_s',width:80,editor:{type:'textbox'}"><spring:message code="plmhalfpartrecipeparameter.column.unit_s" /></th>
                    <!-- 参数对象类型代码 -->
                    <th data-options="field:'parmtypecode_s',editor:{type:'textbox'}"><spring:message code="plmhalfpartrecipeparameter.column.parmtypecode_s" /></th>
                    <!-- 参数类型名称： 101-工艺控制参数 102-施工显示参数 172-施工显示参数 173-显示控制参数 301-工艺控制参数 302-施工显示参数 304-施工控制参数 -->
                    <th data-options="field:'parmtypename_s',editor:{type:'textbox'}"><spring:message code="for.column.parmtypename_s" /></th>
                     <!-- 记录标志，A可用，D删除 -->
                    <th data-options="field:'record_flag_s',width:80,editor:{},styler:cellStyler,formatter:recordflagText">记录标志</th>
                    <!-- 逻辑地址 -->
                    <th data-options="field:'logicaladdress_s',editor:{type:'textbox'}"><spring:message code="plmhalfpartrecipeparameter.column.logicaladdress_s" /></th>
                    <!-- 逻辑地址备注 -->
                    <th data-options="field:'remark_s',editor:{type:'textbox'}"><spring:message code="plmhalfpartrecipeparameter.column.remark_s" /></th>
                     <!-- 上下限是否启用：A-是、D-否 -->
                    <th data-options="field:'is_max_min_s',styler:cellStyler,formatter:recordflagText">上下限是否启用</th>
                    <!-- 上限值逻辑地址 -->
                    <th data-options="field:'logicaladdress_max_s',editor:{type:'textbox'}">上限值逻辑地址</th>
                    <!-- 上限值逻辑地址描述 -->
                    <th data-options="field:'logicaladdress_max_name_s',editor:{type:'textbox'}">上限值逻辑地址描述</th>
                    <!-- 下限值逻辑地址 -->
                    <th data-options="field:'logicaladdress_min_s',editor:{type:'textbox'}">下限值逻辑地址</th>
                    <!-- 下限值逻辑地址描述 -->
                    <th data-options="field:'logicaladdress_min_name_s',editor:{type:'textbox'}">下限值逻辑地址描述</th>
                    <!-- 参数值 -->
                    <th data-options="field:'value_s',editor:{type:'textbox'}"><spring:message code="plmhalfpartrecipeparameter.column.value_s" /></th>
                     <!-- 修改人 -->
                    <th data-options="field:'changed_by_s',editor:{type:'textbox'}"><spring:message code="plmhalfpartrecipeparameter.column.changed_by_s" /></th>
                    <!-- 修改时间 -->
                    <th data-options="field:'changed_time_t',editor:{type:'textbox'}"><spring:message code="plmhalfpartrecipeparameter.column.changed_time_t" /></th>
                </tr>
            </thead>
        </table>
    </div>
    <!-- 	导出-->    
	<jsp:include page="../../../../inc/export.jsp">
		<jsp:param name="idField" value="atr_key" />
		<jsp:param name="formId" value="PLMHalfpartRecipePara_search_form" />
		<jsp:param name="datagridId" value="plmhalfpartrecipepara_dg" />
		<jsp:param name="handlerClass" value="com.bluebirdme.mes.linglong.halfpart.excel.PlmHalfpartRecipeParaExportHandler" />
		<jsp:param name="serviceName" value="PlmHalfpartRecipeParaServiceImpl.java" />
	</jsp:include>
</body>
</html>
